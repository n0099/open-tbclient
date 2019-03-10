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
    private int aIR;
    private BdUniqueId bvT;
    private ScrollFragmentTabHost fKj;
    private PersonalizePageView fKk;
    private ConcernUnreadTipView fKl;
    private Runnable fKm = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fKk != null) {
                if (a.this.fKl != null) {
                    a.this.fKk.removeView(a.this.fKl);
                    TiebaStatic.log(new am("c12632").T("obj_locate", 3));
                }
                a.this.fKk.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fKn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener fKo = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
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
            tbPageContext.registerListener(this.fKn);
            tbPageContext.registerListener(this.fKo);
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
        if (eVar != null && eVar.bmV()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.fKj = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.fKk = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.fKk != null) {
            this.fKl = new ConcernUnreadTipView(this.mContext.getContext());
            this.fKl.setBdUniqueId(this.bvT);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.aIR;
            this.fKl.setLayoutParams(layoutParams);
            this.fKl.setData(eVar);
            this.fKl.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fKl != null && a.this.fKl.fNR != null) {
                        if (view.getId() != a.this.fKl.fNR.getId()) {
                            if (a.this.fKj != null) {
                                a.this.fKj.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.kl(false);
                        TiebaStatic.log(new am("c12632").T("obj_locate", 1));
                    }
                }
            });
            this.fKk.setIsUnreadTipShow(true);
            this.fKk.addView(this.fKl);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").T("obj_param1", eVar.fNp).T("obj_param2", eVar.fNt));
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(this.fKm, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void kl(boolean z) {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fKm);
        if (this.fKk != null) {
            if (this.fKl != null) {
                this.fKk.removeView(this.fKl);
                if (z && this.fKk.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").T("obj_locate", 2));
                }
            }
            this.fKk.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.aIR = i;
    }

    public void onDestroy() {
        this.fKk = null;
        this.fKj = null;
        if (this.fKm != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.fKm);
        }
        MessageManager.getInstance().unRegisterListener(this.fKn);
        MessageManager.getInstance().unRegisterListener(this.fKo);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.bvT = bdUniqueId;
    }
}
