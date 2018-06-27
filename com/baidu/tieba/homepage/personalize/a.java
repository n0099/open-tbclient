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
    private BdUniqueId adq;
    private ScrollFragmentTabHost dST;
    private PersonalizePageView dSU;
    private ConcernUnreadTipView dSV;
    private int dSW;
    private Runnable dSX = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dSU != null) {
                if (a.this.dSV != null) {
                    a.this.dSU.removeView(a.this.dSV);
                    TiebaStatic.log(new an("c12632").r("obj_locate", 3));
                }
                a.this.dSU.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dSY = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener dSZ = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gJ(true);
        }
    };
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.dSY);
            tbPageContext.registerListener(this.dSZ);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aO(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309541);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.p(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.aDE()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dST = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.dSU = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.dSU != null) {
            this.dSV = new ConcernUnreadTipView(this.mContext.getContext());
            this.dSV.setBdUniqueId(this.adq);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.dSW;
            this.dSV.setLayoutParams(layoutParams);
            this.dSV.setData(eVar);
            this.dSV.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dSV != null && a.this.dSV.dVU != null) {
                        if (view.getId() != a.this.dSV.dVU.getId()) {
                            if (a.this.dST != null) {
                                a.this.dST.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.gJ(false);
                        TiebaStatic.log(new an("c12632").r("obj_locate", 1));
                    }
                }
            });
            this.dSU.setIsUnreadTipShow(true);
            this.dSU.addView(this.dSV);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").r("obj_param1", eVar.dVt).r("obj_param2", eVar.dVx));
            }
            com.baidu.adp.lib.g.e.im().postDelayed(this.dSX, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gJ(boolean z) {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.dSX);
        if (this.dSU != null) {
            if (this.dSV != null) {
                this.dSU.removeView(this.dSV);
                if (z && this.dSU.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new an("c12632").r("obj_locate", 2));
                }
            }
            this.dSU.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.dSW = i;
    }

    public void onDestroy() {
        this.dSU = null;
        this.dST = null;
        if (this.dSX != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.dSX);
        }
        MessageManager.getInstance().unRegisterListener(this.dSY);
        MessageManager.getInstance().unRegisterListener(this.dSZ);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.adq = bdUniqueId;
    }
}
