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
    private BdUniqueId aoH;
    private ScrollFragmentTabHost ewY;
    private PersonalizePageView ewZ;
    private ConcernUnreadTipView exa;
    private Runnable exb = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ewZ != null) {
                if (a.this.exa != null) {
                    a.this.ewZ.removeView(a.this.exa);
                    TiebaStatic.log(new am("c12632").x("obj_locate", 3));
                }
                a.this.ewZ.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a exc = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener exd = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
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
            tbPageContext.registerListener(this.exc);
            tbPageContext.registerListener(this.exd);
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
        if (eVar != null && eVar.aMl()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ewY = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.ewZ = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.ewZ != null) {
            this.exa = new ConcernUnreadTipView(this.mContext.getContext());
            this.exa.setBdUniqueId(this.aoH);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.mHeaderHeight;
            this.exa.setLayoutParams(layoutParams);
            this.exa.setData(eVar);
            this.exa.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.exa != null && a.this.exa.eAf != null) {
                        if (view.getId() != a.this.exa.eAf.getId()) {
                            if (a.this.ewY != null) {
                                a.this.ewY.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.hR(false);
                        TiebaStatic.log(new am("c12632").x("obj_locate", 1));
                    }
                }
            });
            this.ewZ.setIsUnreadTipShow(true);
            this.ewZ.addView(this.exa);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").x("obj_param1", eVar.ezF).x("obj_param2", eVar.ezJ));
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(this.exb, 5000L);
        }
    }

    public void hR(boolean z) {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.exb);
        if (this.ewZ != null) {
            if (this.exa != null) {
                this.ewZ.removeView(this.exa);
                if (z && this.ewZ.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").x("obj_locate", 2));
                }
            }
            this.ewZ.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderHeight = i;
    }

    public void onDestroy() {
        this.ewZ = null;
        this.ewY = null;
        if (this.exb != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.exb);
        }
        MessageManager.getInstance().unRegisterListener(this.exc);
        MessageManager.getInstance().unRegisterListener(this.exd);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aoH = bdUniqueId;
    }
}
