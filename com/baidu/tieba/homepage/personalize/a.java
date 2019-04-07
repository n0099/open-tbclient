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
/* loaded from: classes4.dex */
public class a {
    private int aIV;
    private BdUniqueId bvY;
    private ScrollFragmentTabHost fJW;
    private PersonalizePageView fJX;
    private ConcernUnreadTipView fJY;
    private Runnable fJZ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fJX != null) {
                if (a.this.fJY != null) {
                    a.this.fJX.removeView(a.this.fJY);
                    TiebaStatic.log(new am("c12632").T("obj_locate", 3));
                }
                a.this.fJX.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fKa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener fKb = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.kl(true);
        }
    };
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.fKa);
            tbPageContext.registerListener(this.fKb);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.br(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
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
        if (eVar != null && eVar.bmR()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fJW = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.fJX = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.fJX != null) {
            this.fJY = new ConcernUnreadTipView(this.mContext.getContext());
            this.fJY.setBdUniqueId(this.bvY);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.aIV;
            this.fJY.setLayoutParams(layoutParams);
            this.fJY.setData(eVar);
            this.fJY.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fJY != null && a.this.fJY.fNE != null) {
                        if (view.getId() != a.this.fJY.fNE.getId()) {
                            if (a.this.fJW != null) {
                                a.this.fJW.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.kl(false);
                        TiebaStatic.log(new am("c12632").T("obj_locate", 1));
                    }
                }
            });
            this.fJX.setIsUnreadTipShow(true);
            this.fJX.addView(this.fJY);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").T("obj_param1", eVar.fNc).T("obj_param2", eVar.fNg));
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(this.fJZ, 5000L);
        }
    }

    public void kl(boolean z) {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fJZ);
        if (this.fJX != null) {
            if (this.fJY != null) {
                this.fJX.removeView(this.fJY);
                if (z && this.fJX.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").T("obj_locate", 2));
                }
            }
            this.fJX.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.aIV = i;
    }

    public void onDestroy() {
        this.fJX = null;
        this.fJW = null;
        if (this.fJZ != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fJZ);
        }
        MessageManager.getInstance().unRegisterListener(this.fKa);
        MessageManager.getInstance().unRegisterListener(this.fKb);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.bvY = bdUniqueId;
    }
}
