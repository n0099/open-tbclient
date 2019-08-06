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
/* loaded from: classes4.dex */
public class a {
    private BdUniqueId bEj;
    private ScrollFragmentTabHost gio;
    private PersonalizePageView gip;
    private ConcernUnreadTipView giq;
    private Runnable gir = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gip != null) {
                if (a.this.giq != null) {
                    a.this.gip.removeView(a.this.giq);
                    TiebaStatic.log(new an("c12632").P("obj_locate", 3));
                }
                a.this.gip.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gis = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener git = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.lp(true);
        }
    };
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.gis);
            tbPageContext.registerListener(this.git);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.bo(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309541);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.D(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.bxp()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gio = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.gip = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.gip != null) {
            this.giq = new ConcernUnreadTipView(this.mContext.getContext());
            this.giq.setBdUniqueId(this.bEj);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.giq.setLayoutParams(layoutParams);
            this.giq.setData(eVar);
            this.giq.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.giq != null && a.this.giq.glR != null) {
                        if (view.getId() != a.this.giq.glR.getId()) {
                            if (a.this.gio != null) {
                                a.this.gio.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.lp(false);
                        TiebaStatic.log(new an("c12632").P("obj_locate", 1));
                    }
                }
            });
            this.gip.setIsUnreadTipShow(true);
            this.gip.addView(this.giq);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").P("obj_param1", eVar.glp).P("obj_param2", eVar.glt));
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(this.gir, 5000L);
        }
    }

    public void lp(boolean z) {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gir);
        if (this.gip != null) {
            if (this.giq != null) {
                this.gip.removeView(this.giq);
                if (z && this.gip.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new an("c12632").P("obj_locate", 2));
                }
            }
            this.gip.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.gip = null;
        this.gio = null;
        if (this.gir != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gir);
        }
        MessageManager.getInstance().unRegisterListener(this.gis);
        MessageManager.getInstance().unRegisterListener(this.git);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.bEj = bdUniqueId;
    }
}
