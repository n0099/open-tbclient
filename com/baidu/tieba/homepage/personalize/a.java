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
    private BdUniqueId apj;
    private ScrollFragmentTabHost exJ;
    private PersonalizePageView exK;
    private ConcernUnreadTipView exL;
    private Runnable exM = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.exK != null) {
                if (a.this.exL != null) {
                    a.this.exK.removeView(a.this.exL);
                    TiebaStatic.log(new am("c12632").y("obj_locate", 3));
                }
                a.this.exK.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a exN = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener exO = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.hR(true);
        }
    };
    private TbPageContext mContext;
    private int mHeaderHeight;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.exN);
            tbPageContext.registerListener(this.exO);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aV(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309541);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.L(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.aML()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.exJ = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.exK = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.exK != null) {
            this.exL = new ConcernUnreadTipView(this.mContext.getContext());
            this.exL.setBdUniqueId(this.apj);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.mHeaderHeight;
            this.exL.setLayoutParams(layoutParams);
            this.exL.setData(eVar);
            this.exL.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.exL != null && a.this.exL.eAQ != null) {
                        if (view.getId() != a.this.exL.eAQ.getId()) {
                            if (a.this.exJ != null) {
                                a.this.exJ.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.hR(false);
                        TiebaStatic.log(new am("c12632").y("obj_locate", 1));
                    }
                }
            });
            this.exK.setIsUnreadTipShow(true);
            this.exK.addView(this.exL);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").y("obj_param1", eVar.eAp).y("obj_param2", eVar.eAt));
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(this.exM, 5000L);
        }
    }

    public void hR(boolean z) {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.exM);
        if (this.exK != null) {
            if (this.exL != null) {
                this.exK.removeView(this.exL);
                if (z && this.exK.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").y("obj_locate", 2));
                }
            }
            this.exK.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderHeight = i;
    }

    public void onDestroy() {
        this.exK = null;
        this.exJ = null;
        if (this.exM != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.exM);
        }
        MessageManager.getInstance().unRegisterListener(this.exN);
        MessageManager.getInstance().unRegisterListener(this.exO);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.apj = bdUniqueId;
    }
}
