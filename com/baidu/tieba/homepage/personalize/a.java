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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes6.dex */
public class a {
    private BdUniqueId aks;
    private ScrollFragmentTabHost elS;
    private PersonalizePageView elT;
    private ConcernUnreadTipView elU;
    private Runnable elV = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.elT != null) {
                if (a.this.elU != null) {
                    a.this.elT.removeView(a.this.elU);
                    TiebaStatic.log(new am("c12632").x("obj_locate", 3));
                }
                a.this.elT.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a elW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener elX = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.hC(true);
        }
    };
    private TbPageContext mContext;
    private int mHeaderHeight;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.elW);
            tbPageContext.registerListener(this.elX);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aT(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309541);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.x(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.aKi()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.elS = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.elT = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.elT != null) {
            this.elU = new ConcernUnreadTipView(this.mContext.getContext());
            this.elU.setBdUniqueId(this.aks);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.mHeaderHeight;
            this.elU.setLayoutParams(layoutParams);
            this.elU.setData(eVar);
            this.elU.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.elU != null && a.this.elU.eoY != null) {
                        if (view.getId() != a.this.elU.eoY.getId()) {
                            if (a.this.elS != null) {
                                a.this.elS.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.hC(false);
                        TiebaStatic.log(new am("c12632").x("obj_locate", 1));
                    }
                }
            });
            this.elT.setIsUnreadTipShow(true);
            this.elT.addView(this.elU);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").x("obj_param1", eVar.eoy).x("obj_param2", eVar.eoC));
            }
            com.baidu.adp.lib.g.e.jI().postDelayed(this.elV, 5000L);
        }
    }

    public void hC(boolean z) {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.elV);
        if (this.elT != null) {
            if (this.elU != null) {
                this.elT.removeView(this.elU);
                if (z && this.elT.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").x("obj_locate", 2));
                }
            }
            this.elT.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderHeight = i;
    }

    public void onDestroy() {
        this.elT = null;
        this.elS = null;
        if (this.elV != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.elV);
        }
        MessageManager.getInstance().unRegisterListener(this.elW);
        MessageManager.getInstance().unRegisterListener(this.elX);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aks = bdUniqueId;
    }
}
