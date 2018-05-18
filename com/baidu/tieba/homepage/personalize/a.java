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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes2.dex */
public class a {
    private BdUniqueId Vb;
    private ScrollFragmentTabHost dEq;
    private PersonalizePageView dEr;
    private ConcernUnreadTipView dEs;
    private int dEt;
    private Runnable dEu = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dEr != null) {
                if (a.this.dEs != null) {
                    a.this.dEr.removeView(a.this.dEs);
                    TiebaStatic.log(new al("c12632").r("obj_locate", 3));
                }
                a.this.dEr.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dEv = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener dEw = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gt(true);
        }
    };
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.dEv);
            tbPageContext.registerListener(this.dEw);
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
        if (eVar != null && eVar.axZ()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dEq = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.dEr = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.dEr != null) {
            this.dEs = new ConcernUnreadTipView(this.mContext.getContext());
            this.dEs.setBdUniqueId(this.Vb);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.dEt;
            this.dEs.setLayoutParams(layoutParams);
            this.dEs.setData(eVar);
            this.dEs.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.dEs != null && a.this.dEs.dGK != null) {
                        if (view2.getId() != a.this.dEs.dGK.getId()) {
                            if (a.this.dEq != null) {
                                a.this.dEq.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.gt(false);
                        TiebaStatic.log(new al("c12632").r("obj_locate", 1));
                    }
                }
            });
            this.dEr.setIsUnreadTipShow(true);
            this.dEr.addView(this.dEs);
            if (eVar != null) {
                TiebaStatic.log(new al("c12631").r("obj_param1", eVar.dGk).r("obj_param2", eVar.dGo));
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(this.dEu, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gt(boolean z) {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.dEu);
        if (this.dEr != null) {
            if (this.dEs != null) {
                this.dEr.removeView(this.dEs);
                if (z && this.dEr.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new al("c12632").r("obj_locate", 2));
                }
            }
            this.dEr.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.dEt = i;
    }

    public void onDestroy() {
        this.dEr = null;
        this.dEq = null;
        if (this.dEu != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.dEu);
        }
        MessageManager.getInstance().unRegisterListener(this.dEv);
        MessageManager.getInstance().unRegisterListener(this.dEw);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.Vb = bdUniqueId;
    }
}
