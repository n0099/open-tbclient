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
    private BdUniqueId bEH;
    private ScrollFragmentTabHost gkg;
    private PersonalizePageView gkh;
    private ConcernUnreadTipView gki;
    private Runnable gkj = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gkh != null) {
                if (a.this.gki != null) {
                    a.this.gkh.removeView(a.this.gki);
                    TiebaStatic.log(new an("c12632").P("obj_locate", 3));
                }
                a.this.gkh.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gkk = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener gkl = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.ls(true);
        }
    };
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.gkk);
            tbPageContext.registerListener(this.gkl);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.bq(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
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
        if (eVar != null && eVar.byd()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gkg = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.gkh = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.gkh != null) {
            this.gki = new ConcernUnreadTipView(this.mContext.getContext());
            this.gki.setBdUniqueId(this.bEH);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.gki.setLayoutParams(layoutParams);
            this.gki.setData(eVar);
            this.gki.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gki != null && a.this.gki.gnI != null) {
                        if (view.getId() != a.this.gki.gnI.getId()) {
                            if (a.this.gkg != null) {
                                a.this.gkg.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.ls(false);
                        TiebaStatic.log(new an("c12632").P("obj_locate", 1));
                    }
                }
            });
            this.gkh.setIsUnreadTipShow(true);
            this.gkh.addView(this.gki);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").P("obj_param1", eVar.gnh).P("obj_param2", eVar.gnl));
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(this.gkj, 5000L);
        }
    }

    public void ls(boolean z) {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gkj);
        if (this.gkh != null) {
            if (this.gki != null) {
                this.gkh.removeView(this.gki);
                if (z && this.gkh.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.ahU().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new an("c12632").P("obj_locate", 2));
                }
            }
            this.gkh.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.gkh = null;
        this.gkg = null;
        if (this.gkj != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.gkj);
        }
        MessageManager.getInstance().unRegisterListener(this.gkk);
        MessageManager.getInstance().unRegisterListener(this.gkl);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.bEH = bdUniqueId;
    }
}
