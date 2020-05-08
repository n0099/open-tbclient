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
    private TbPageContext duK;
    private ScrollFragmentTabHost hMV;
    private PersonalizePageView hMW;
    private ConcernUnreadTipView hMX;
    private BdUniqueId hMY;
    private Runnable hMZ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hMW != null) {
                if (a.this.hMX != null) {
                    a.this.hMW.removeView(a.this.hMX);
                    TiebaStatic.log(new an("c12632").af("obj_locate", 3));
                }
                a.this.hMW.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gHr = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener hNa = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.nQ(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.duK = tbPageContext;
            tbPageContext.registerListener(this.gHr);
            tbPageContext.registerListener(this.hNa);
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
        if (eVar != null && eVar.bZT()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hMV = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.hMW = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.hMW != null) {
            this.hMX = new ConcernUnreadTipView(this.duK.getContext());
            this.hMX.setBdUniqueId(this.hMY);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.hMX.setLayoutParams(layoutParams);
            this.hMX.setData(eVar);
            this.hMX.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hMX != null && a.this.hMX.fPd != null) {
                        if (view.getId() != a.this.hMX.fPd.getId()) {
                            if (a.this.hMV != null) {
                                a.this.hMV.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.nQ(false);
                        TiebaStatic.log(new an("c12632").af("obj_locate", 1));
                    }
                }
            });
            this.hMW.setIsUnreadTipShow(true);
            this.hMW.addView(this.hMX);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").af("obj_param1", eVar.hQo).af(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.lb().postDelayed(this.hMZ, 5000L);
        }
    }

    public void nQ(boolean z) {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hMZ);
        if (this.hMW != null) {
            if (this.hMX != null) {
                this.hMW.removeView(this.hMX);
                if (z && this.hMW.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.aNT().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new an("c12632").af("obj_locate", 2));
                }
            }
            this.hMW.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.hMW = null;
        this.hMV = null;
        if (this.hMZ != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hMZ);
        }
        MessageManager.getInstance().unRegisterListener(this.gHr);
        MessageManager.getInstance().unRegisterListener(this.hNa);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.hMY = bdUniqueId;
    }
}
