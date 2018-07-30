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
    private BdUniqueId acT;
    private ScrollFragmentTabHost dWK;
    private PersonalizePageView dWL;
    private ConcernUnreadTipView dWM;
    private int dWN;
    private Runnable dWO = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dWL != null) {
                if (a.this.dWM != null) {
                    a.this.dWL.removeView(a.this.dWM);
                    TiebaStatic.log(new an("c12632").r("obj_locate", 3));
                }
                a.this.dWL.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dWP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener dWQ = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
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
            tbPageContext.registerListener(this.dWP);
            tbPageContext.registerListener(this.dWQ);
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
        if (eVar != null && eVar.aEE()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dWK = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.dWL = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.dWL != null) {
            this.dWM = new ConcernUnreadTipView(this.mContext.getContext());
            this.dWM.setBdUniqueId(this.acT);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.dWN;
            this.dWM.setLayoutParams(layoutParams);
            this.dWM.setData(eVar);
            this.dWM.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dWM != null && a.this.dWM.dZM != null) {
                        if (view.getId() != a.this.dWM.dZM.getId()) {
                            if (a.this.dWK != null) {
                                a.this.dWK.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.gM(false);
                        TiebaStatic.log(new an("c12632").r("obj_locate", 1));
                    }
                }
            });
            this.dWL.setIsUnreadTipShow(true);
            this.dWL.addView(this.dWM);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").r("obj_param1", eVar.dZl).r("obj_param2", eVar.dZp));
            }
            com.baidu.adp.lib.g.e.in().postDelayed(this.dWO, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gM(boolean z) {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.dWO);
        if (this.dWL != null) {
            if (this.dWM != null) {
                this.dWL.removeView(this.dWM);
                if (z && this.dWL.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new an("c12632").r("obj_locate", 2));
                }
            }
            this.dWL.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.dWN = i;
    }

    public void onDestroy() {
        this.dWL = null;
        this.dWK = null;
        if (this.dWO != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.dWO);
        }
        MessageManager.getInstance().unRegisterListener(this.dWP);
        MessageManager.getInstance().unRegisterListener(this.dWQ);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.acT = bdUniqueId;
    }
}
