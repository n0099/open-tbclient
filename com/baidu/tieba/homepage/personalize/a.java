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
    private int aIS;
    private BdUniqueId bvV;
    private ScrollFragmentTabHost fKi;
    private PersonalizePageView fKj;
    private ConcernUnreadTipView fKk;
    private Runnable fKl = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fKj != null) {
                if (a.this.fKk != null) {
                    a.this.fKj.removeView(a.this.fKk);
                    TiebaStatic.log(new am("c12632").T("obj_locate", 3));
                }
                a.this.fKj.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fKm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener fKn = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
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
            tbPageContext.registerListener(this.fKm);
            tbPageContext.registerListener(this.fKn);
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
        if (eVar != null && eVar.bmU()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fKi = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.fKj = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.fKj != null) {
            this.fKk = new ConcernUnreadTipView(this.mContext.getContext());
            this.fKk.setBdUniqueId(this.bvV);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.aIS;
            this.fKk.setLayoutParams(layoutParams);
            this.fKk.setData(eVar);
            this.fKk.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fKk != null && a.this.fKk.fNQ != null) {
                        if (view.getId() != a.this.fKk.fNQ.getId()) {
                            if (a.this.fKi != null) {
                                a.this.fKi.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.kl(false);
                        TiebaStatic.log(new am("c12632").T("obj_locate", 1));
                    }
                }
            });
            this.fKj.setIsUnreadTipShow(true);
            this.fKj.addView(this.fKk);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").T("obj_param1", eVar.fNo).T("obj_param2", eVar.fNs));
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(this.fKl, 5000L);
        }
    }

    public void kl(boolean z) {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fKl);
        if (this.fKj != null) {
            if (this.fKk != null) {
                this.fKj.removeView(this.fKk);
                if (z && this.fKj.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").T("obj_locate", 2));
                }
            }
            this.fKj.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.aIS = i;
    }

    public void onDestroy() {
        this.fKj = null;
        this.fKi = null;
        if (this.fKl != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fKl);
        }
        MessageManager.getInstance().unRegisterListener(this.fKm);
        MessageManager.getInstance().unRegisterListener(this.fKn);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.bvV = bdUniqueId;
    }
}
