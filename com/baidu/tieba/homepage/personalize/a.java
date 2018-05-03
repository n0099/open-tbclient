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
    private BdUniqueId Vf;
    private TbPageContext adf;
    private ScrollFragmentTabHost dDk;
    private PersonalizePageView dDl;
    private ConcernUnreadTipView dDm;
    private int dDn;
    private Runnable dDo = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dDl != null) {
                if (a.this.dDm != null) {
                    a.this.dDl.removeView(a.this.dDm);
                    TiebaStatic.log(new al("c12632").r("obj_locate", 3));
                }
                a.this.dDl.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dDp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener dDq = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gs(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.adf = tbPageContext;
            tbPageContext.registerListener(this.dDp);
            tbPageContext.registerListener(this.dDq);
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
        if (eVar != null && eVar.ayb()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dDk = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.dDl = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.dDl != null) {
            this.dDm = new ConcernUnreadTipView(this.adf.getContext());
            this.dDm.setBdUniqueId(this.Vf);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.dDn;
            this.dDm.setLayoutParams(layoutParams);
            this.dDm.setData(eVar);
            this.dDm.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.dDm != null && a.this.dDm.dFE != null) {
                        if (view2.getId() != a.this.dDm.dFE.getId()) {
                            if (a.this.dDk != null) {
                                a.this.dDk.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.gs(false);
                        TiebaStatic.log(new al("c12632").r("obj_locate", 1));
                    }
                }
            });
            this.dDl.setIsUnreadTipShow(true);
            this.dDl.addView(this.dDm);
            if (eVar != null) {
                TiebaStatic.log(new al("c12631").r("obj_param1", eVar.dFe).r("obj_param2", eVar.dFi));
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(this.dDo, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gs(boolean z) {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.dDo);
        if (this.dDl != null) {
            if (this.dDm != null) {
                this.dDl.removeView(this.dDm);
                if (z && this.dDl.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new al("c12632").r("obj_locate", 2));
                }
            }
            this.dDl.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.dDn = i;
    }

    public void onDestroy() {
        this.dDl = null;
        this.dDk = null;
        if (this.dDo != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.dDo);
        }
        MessageManager.getInstance().unRegisterListener(this.dDp);
        MessageManager.getInstance().unRegisterListener(this.dDq);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.Vf = bdUniqueId;
    }
}
