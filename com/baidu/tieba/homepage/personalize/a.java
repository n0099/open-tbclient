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
/* loaded from: classes16.dex */
public class a {
    private TbPageContext efr;
    private ScrollFragmentTabHost iMq;
    private PersonalizePageView iMr;
    private ConcernUnreadTipView iMs;
    private BdUniqueId iMt;
    private Runnable iMu = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.iMr != null) {
                if (a.this.iMs != null) {
                    a.this.iMr.removeView(a.this.iMs);
                    TiebaStatic.log(new aq("c12632").ai("obj_locate", 3));
                }
                a.this.iMr.setIsUnreadTipShow(false);
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
    private CustomMessageListener iMv = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.pJ(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.efr = tbPageContext;
            tbPageContext.registerListener(this.netMessageListener);
            tbPageContext.registerListener(this.iMv);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bH(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.cyu()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iMq = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.iMr = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.iMr != null) {
            this.iMs = new ConcernUnreadTipView(this.efr.getContext());
            this.iMs.setBdUniqueId(this.iMt);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.iMs.setLayoutParams(layoutParams);
            this.iMs.setData(eVar);
            this.iMs.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iMs != null && a.this.iMs.gIr != null) {
                        if (view.getId() != a.this.iMs.gIr.getId()) {
                            if (a.this.iMq != null) {
                                a.this.iMq.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.pJ(false);
                        TiebaStatic.log(new aq("c12632").ai("obj_locate", 1));
                    }
                }
            });
            this.iMr.setIsUnreadTipShow(true);
            this.iMr.addView(this.iMs);
            if (eVar != null) {
                TiebaStatic.log(new aq("c12631").ai("obj_param1", eVar.iPV).ai(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.mS().postDelayed(this.iMu, 5000L);
        }
    }

    public void pJ(boolean z) {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iMu);
        if (this.iMr != null) {
            if (this.iMs != null) {
                this.iMr.removeView(this.iMs);
                if (z && this.iMr.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new aq("c12632").ai("obj_locate", 2));
                }
            }
            this.iMr.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.iMr = null;
        this.iMq = null;
        if (this.iMu != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iMu);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.iMv);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.iMt = bdUniqueId;
    }
}
