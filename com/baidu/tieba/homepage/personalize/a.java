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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes21.dex */
public class a {
    private TbPageContext eGu;
    private ScrollFragmentTabHost jDm;
    private PersonalizePageView jDn;
    private ConcernUnreadTipView jDo;
    private BdUniqueId jDp;
    private Runnable jDq = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jDn != null) {
                if (a.this.jDo != null) {
                    a.this.jDn.removeView(a.this.jDo);
                    TiebaStatic.log(new ar("c12632").ak("obj_locate", 3));
                }
                a.this.jDn.setIsUnreadTipShow(false);
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
    private CustomMessageListener jDr = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.rb(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.eGu = tbPageContext;
            tbPageContext.registerListener(this.netMessageListener);
            tbPageContext.registerListener(this.jDr);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bK(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.cKY()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jDm = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.jDn = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.jDn != null) {
            this.jDo = new ConcernUnreadTipView(this.eGu.getContext());
            this.jDo.setBdUniqueId(this.jDp);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.jDo.setLayoutParams(layoutParams);
            this.jDo.setData(eVar);
            this.jDo.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jDo != null && a.this.jDo.jHK != null) {
                        if (view.getId() != a.this.jDo.jHK.getId()) {
                            if (a.this.jDm != null) {
                                a.this.jDm.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.rb(false);
                        TiebaStatic.log(new ar("c12632").ak("obj_locate", 1));
                    }
                }
            });
            this.jDn.setIsUnreadTipShow(true);
            this.jDn.addView(this.jDo);
            if (eVar != null) {
                TiebaStatic.log(new ar("c12631").ak("obj_param1", eVar.jGW).ak(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jDq, 5000L);
        }
    }

    public void rb(boolean z) {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jDq);
        if (this.jDn != null) {
            if (this.jDo != null) {
                this.jDn.removeView(this.jDo);
                if (z && this.jDn.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new ar("c12632").ak("obj_locate", 2));
                }
            }
            this.jDn.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.jDn = null;
        this.jDm = null;
        if (this.jDq != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jDq);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.jDr);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.jDp = bdUniqueId;
    }
}
