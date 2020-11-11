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
    private TbPageContext eIc;
    private ScrollFragmentTabHost jCo;
    private PersonalizePageView jCp;
    private ConcernUnreadTipView jCq;
    private BdUniqueId jCr;
    private Runnable jCs = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jCp != null) {
                if (a.this.jCq != null) {
                    a.this.jCp.removeView(a.this.jCq);
                    TiebaStatic.log(new aq("c12632").al("obj_locate", 3));
                }
                a.this.jCp.setIsUnreadTipShow(false);
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
    private CustomMessageListener jCt = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.qY(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.eIc = tbPageContext;
            tbPageContext.registerListener(this.netMessageListener);
            tbPageContext.registerListener(this.jCt);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bL(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.cLs()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jCo = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.jCp = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.jCp != null) {
            this.jCq = new ConcernUnreadTipView(this.eIc.getContext());
            this.jCq.setBdUniqueId(this.jCr);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.jCq.setLayoutParams(layoutParams);
            this.jCq.setData(eVar);
            this.jCq.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jCq != null && a.this.jCq.jGL != null) {
                        if (view.getId() != a.this.jCq.jGL.getId()) {
                            if (a.this.jCo != null) {
                                a.this.jCo.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.qY(false);
                        TiebaStatic.log(new aq("c12632").al("obj_locate", 1));
                    }
                }
            });
            this.jCp.setIsUnreadTipShow(true);
            this.jCp.addView(this.jCq);
            if (eVar != null) {
                TiebaStatic.log(new aq("c12631").al("obj_param1", eVar.jFX).al(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jCs, 5000L);
        }
    }

    public void qY(boolean z) {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jCs);
        if (this.jCp != null) {
            if (this.jCq != null) {
                this.jCp.removeView(this.jCq);
                if (z && this.jCp.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new aq("c12632").al("obj_locate", 2));
                }
            }
            this.jCp.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.jCp = null;
        this.jCo = null;
        if (this.jCs != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jCs);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.jCt);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.jCr = bdUniqueId;
    }
}
