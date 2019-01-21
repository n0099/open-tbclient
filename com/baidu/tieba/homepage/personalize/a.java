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
    private BdUniqueId apk;
    private ScrollFragmentTabHost exK;
    private PersonalizePageView exL;
    private ConcernUnreadTipView exM;
    private Runnable exN = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.exL != null) {
                if (a.this.exM != null) {
                    a.this.exL.removeView(a.this.exM);
                    TiebaStatic.log(new am("c12632").y("obj_locate", 3));
                }
                a.this.exL.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a exO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener exP = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
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
            tbPageContext.registerListener(this.exO);
            tbPageContext.registerListener(this.exP);
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
        this.exK = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.exL = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.exL != null) {
            this.exM = new ConcernUnreadTipView(this.mContext.getContext());
            this.exM.setBdUniqueId(this.apk);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.mHeaderHeight;
            this.exM.setLayoutParams(layoutParams);
            this.exM.setData(eVar);
            this.exM.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.exM != null && a.this.exM.eAR != null) {
                        if (view.getId() != a.this.exM.eAR.getId()) {
                            if (a.this.exK != null) {
                                a.this.exK.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.hR(false);
                        TiebaStatic.log(new am("c12632").y("obj_locate", 1));
                    }
                }
            });
            this.exL.setIsUnreadTipShow(true);
            this.exL.addView(this.exM);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").y("obj_param1", eVar.eAq).y("obj_param2", eVar.eAu));
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(this.exN, 5000L);
        }
    }

    public void hR(boolean z) {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.exN);
        if (this.exL != null) {
            if (this.exM != null) {
                this.exL.removeView(this.exM);
                if (z && this.exL.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").y("obj_locate", 2));
                }
            }
            this.exL.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderHeight = i;
    }

    public void onDestroy() {
        this.exL = null;
        this.exK = null;
        if (this.exN != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.exN);
        }
        MessageManager.getInstance().unRegisterListener(this.exO);
        MessageManager.getInstance().unRegisterListener(this.exP);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.apk = bdUniqueId;
    }
}
