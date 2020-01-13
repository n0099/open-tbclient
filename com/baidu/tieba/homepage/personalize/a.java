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
/* loaded from: classes7.dex */
public class a {
    private TbPageContext cRe;
    private ScrollFragmentTabHost gZD;
    private PersonalizePageView gZE;
    private ConcernUnreadTipView gZF;
    private BdUniqueId gZG;
    private Runnable gZH = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gZE != null) {
                if (a.this.gZF != null) {
                    a.this.gZE.removeView(a.this.gZF);
                    TiebaStatic.log(new an("c12632").Z("obj_locate", 3));
                }
                a.this.gZE.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gZI = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener gZJ = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.mE(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.cRe = tbPageContext;
            tbPageContext.registerListener(this.gZI);
            tbPageContext.registerListener(this.gZJ);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bv(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.bNB()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gZD = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.gZE = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.gZE != null) {
            this.gZF = new ConcernUnreadTipView(this.cRe.getContext());
            this.gZF.setBdUniqueId(this.gZG);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.gZF.setLayoutParams(layoutParams);
            this.gZF.setData(eVar);
            this.gZF.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gZF != null && a.this.gZF.fgN != null) {
                        if (view.getId() != a.this.gZF.fgN.getId()) {
                            if (a.this.gZD != null) {
                                a.this.gZD.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.mE(false);
                        TiebaStatic.log(new an("c12632").Z("obj_locate", 1));
                    }
                }
            });
            this.gZE.setIsUnreadTipShow(true);
            this.gZE.addView(this.gZF);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").Z("obj_param1", eVar.hcQ).Z(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(this.gZH, 5000L);
        }
    }

    public void mE(boolean z) {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gZH);
        if (this.gZE != null) {
            if (this.gZF != null) {
                this.gZE.removeView(this.gZF);
                if (z && this.gZE.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new an("c12632").Z("obj_locate", 2));
                }
            }
            this.gZE.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.gZE = null;
        this.gZD = null;
        if (this.gZH != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gZH);
        }
        MessageManager.getInstance().unRegisterListener(this.gZI);
        MessageManager.getInstance().unRegisterListener(this.gZJ);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.gZG = bdUniqueId;
    }
}
