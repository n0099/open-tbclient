package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes2.dex */
public class a {
    private BdUniqueId acU;
    private ScrollFragmentTabHost dWH;
    private PersonalizePageView dWI;
    private ConcernUnreadTipView dWJ;
    private int dWK;
    private Runnable dWL = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dWI != null) {
                if (a.this.dWJ != null) {
                    a.this.dWI.removeView(a.this.dWJ);
                    TiebaStatic.log(new an("c12632").r("obj_locate", 3));
                }
                a.this.dWI.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dWM = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener dWN = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gM(true);
        }
    };
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.dWM);
            tbPageContext.registerListener(this.dWN);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aK(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309541);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.n(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.aEB()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dWH = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.dWI = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.dWI != null) {
            this.dWJ = new ConcernUnreadTipView(this.mContext.getContext());
            this.dWJ.setBdUniqueId(this.acU);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.dWK;
            this.dWJ.setLayoutParams(layoutParams);
            this.dWJ.setData(eVar);
            this.dWJ.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dWJ != null && a.this.dWJ.dZJ != null) {
                        if (view.getId() != a.this.dWJ.dZJ.getId()) {
                            if (a.this.dWH != null) {
                                a.this.dWH.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.gM(false);
                        TiebaStatic.log(new an("c12632").r("obj_locate", 1));
                    }
                }
            });
            this.dWI.setIsUnreadTipShow(true);
            this.dWI.addView(this.dWJ);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").r("obj_param1", eVar.dZi).r("obj_param2", eVar.dZm));
            }
            com.baidu.adp.lib.g.e.in().postDelayed(this.dWL, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gM(boolean z) {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.dWL);
        if (this.dWI != null) {
            if (this.dWJ != null) {
                this.dWI.removeView(this.dWJ);
                if (z && this.dWI.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new an("c12632").r("obj_locate", 2));
                }
            }
            this.dWI.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.dWK = i;
    }

    public void onDestroy() {
        this.dWI = null;
        this.dWH = null;
        if (this.dWL != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.dWL);
        }
        MessageManager.getInstance().unRegisterListener(this.dWM);
        MessageManager.getInstance().unRegisterListener(this.dWN);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.acU = bdUniqueId;
    }
}
