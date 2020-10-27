package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes22.dex */
public class a {
    private TbPageContext eCn;
    private ScrollFragmentTabHost jwr;
    private PersonalizePageView jws;
    private ConcernUnreadTipView jwt;
    private BdUniqueId jwu;
    private Runnable jwv = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jws != null) {
                if (a.this.jwt != null) {
                    a.this.jws.removeView(a.this.jwt);
                    TiebaStatic.log(new aq("c12632").aj("obj_locate", 3));
                }
                a.this.jws.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a netMessageListener = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener jww = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.qP(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.eCn = tbPageContext;
            tbPageContext.registerListener(this.netMessageListener);
            tbPageContext.registerListener(this.jww);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bJ(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_CONCERN_UNREAD_TIP);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.setNeedAck(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.cIR()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jwr = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.jws = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.jws != null) {
            this.jwt = new ConcernUnreadTipView(this.eCn.getContext());
            this.jwt.setBdUniqueId(this.jwu);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.jwt.setLayoutParams(layoutParams);
            this.jwt.setData(eVar);
            this.jwt.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jwt != null && a.this.jwt.jAO != null) {
                        if (view.getId() != a.this.jwt.jAO.getId()) {
                            if (a.this.jwr != null) {
                                a.this.jwr.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.qP(false);
                        TiebaStatic.log(new aq("c12632").aj("obj_locate", 1));
                    }
                }
            });
            this.jws.setIsUnreadTipShow(true);
            this.jws.addView(this.jwt);
            if (eVar != null) {
                TiebaStatic.log(new aq("c12631").aj("obj_param1", eVar.jAa).aj(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jwv, 5000L);
        }
    }

    public void qP(boolean z) {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jwv);
        if (this.jws != null) {
            if (this.jwt != null) {
                this.jws.removeView(this.jwt);
                if (z && this.jws.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new aq("c12632").aj("obj_locate", 2));
                }
            }
            this.jws.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.jws = null;
        this.jwr = null;
        if (this.jwv != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jwv);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.jww);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.jwu = bdUniqueId;
    }
}
