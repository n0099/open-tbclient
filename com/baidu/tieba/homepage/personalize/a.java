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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes9.dex */
public class a {
    private TbPageContext duG;
    private ScrollFragmentTabHost hMP;
    private PersonalizePageView hMQ;
    private ConcernUnreadTipView hMR;
    private BdUniqueId hMS;
    private Runnable hMT = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hMQ != null) {
                if (a.this.hMR != null) {
                    a.this.hMQ.removeView(a.this.hMR);
                    TiebaStatic.log(new an("c12632").af("obj_locate", 3));
                }
                a.this.hMQ.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gHl = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener hMU = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.nQ(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.duG = tbPageContext;
            tbPageContext.registerListener(this.gHl);
            tbPageContext.registerListener(this.hMU);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bE(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.bZV()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hMP = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.hMQ = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.hMQ != null) {
            this.hMR = new ConcernUnreadTipView(this.duG.getContext());
            this.hMR.setBdUniqueId(this.hMS);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.hMR.setLayoutParams(layoutParams);
            this.hMR.setData(eVar);
            this.hMR.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hMR != null && a.this.hMR.fOY != null) {
                        if (view.getId() != a.this.hMR.fOY.getId()) {
                            if (a.this.hMP != null) {
                                a.this.hMP.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.nQ(false);
                        TiebaStatic.log(new an("c12632").af("obj_locate", 1));
                    }
                }
            });
            this.hMQ.setIsUnreadTipShow(true);
            this.hMQ.addView(this.hMR);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").af("obj_param1", eVar.hQi).af(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.lb().postDelayed(this.hMT, 5000L);
        }
    }

    public void nQ(boolean z) {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hMT);
        if (this.hMQ != null) {
            if (this.hMR != null) {
                this.hMQ.removeView(this.hMR);
                if (z && this.hMQ.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.aNV().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new an("c12632").af("obj_locate", 2));
                }
            }
            this.hMQ.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.hMQ = null;
        this.hMP = null;
        if (this.hMT != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hMT);
        }
        MessageManager.getInstance().unRegisterListener(this.gHl);
        MessageManager.getInstance().unRegisterListener(this.hMU);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.hMS = bdUniqueId;
    }
}
