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
    private TbPageContext cVi;
    private ScrollFragmentTabHost hbR;
    private PersonalizePageView hbS;
    private ConcernUnreadTipView hbT;
    private BdUniqueId hbU;
    private Runnable hbV = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hbS != null) {
                if (a.this.hbT != null) {
                    a.this.hbS.removeView(a.this.hbT);
                    TiebaStatic.log(new an("c12632").X("obj_locate", 3));
                }
                a.this.hbS.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hbW = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener hbX = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.mG(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.cVi = tbPageContext;
            tbPageContext.registerListener(this.hbW);
            tbPageContext.registerListener(this.hbX);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bu(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.bPg()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hbR = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.hbS = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.hbS != null) {
            this.hbT = new ConcernUnreadTipView(this.cVi.getContext());
            this.hbT.setBdUniqueId(this.hbU);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.hbT.setLayoutParams(layoutParams);
            this.hbT.setData(eVar);
            this.hbT.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hbT != null && a.this.hbT.fkh != null) {
                        if (view.getId() != a.this.hbT.fkh.getId()) {
                            if (a.this.hbR != null) {
                                a.this.hbR.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.mG(false);
                        TiebaStatic.log(new an("c12632").X("obj_locate", 1));
                    }
                }
            });
            this.hbS.setIsUnreadTipShow(true);
            this.hbS.addView(this.hbT);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").X("obj_param1", eVar.hfe).X(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hbV, 5000L);
        }
    }

    public void mG(boolean z) {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hbV);
        if (this.hbS != null) {
            if (this.hbT != null) {
                this.hbS.removeView(this.hbT);
                if (z && this.hbS.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new an("c12632").X("obj_locate", 2));
                }
            }
            this.hbS.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.hbS = null;
        this.hbR = null;
        if (this.hbV != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hbV);
        }
        MessageManager.getInstance().unRegisterListener(this.hbW);
        MessageManager.getInstance().unRegisterListener(this.hbX);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.hbU = bdUniqueId;
    }
}
