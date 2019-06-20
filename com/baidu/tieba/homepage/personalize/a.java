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
    private BdUniqueId bDl;
    private ScrollFragmentTabHost gbi;
    private PersonalizePageView gbj;
    private ConcernUnreadTipView gbk;
    private Runnable gbl = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gbj != null) {
                if (a.this.gbk != null) {
                    a.this.gbj.removeView(a.this.gbk);
                    TiebaStatic.log(new am("c12632").P("obj_locate", 3));
                }
                a.this.gbj.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gbm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener gbn = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.lc(true);
        }
    };
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.gbm);
            tbPageContext.registerListener(this.gbn);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.bn(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
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
        if (eVar != null && eVar.bux()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gbi = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.gbj = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.gbj != null) {
            this.gbk = new ConcernUnreadTipView(this.mContext.getContext());
            this.gbk.setBdUniqueId(this.bDl);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.gbk.setLayoutParams(layoutParams);
            this.gbk.setData(eVar);
            this.gbk.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gbk != null && a.this.gbk.geQ != null) {
                        if (view.getId() != a.this.gbk.geQ.getId()) {
                            if (a.this.gbi != null) {
                                a.this.gbi.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.lc(false);
                        TiebaStatic.log(new am("c12632").P("obj_locate", 1));
                    }
                }
            });
            this.gbj.setIsUnreadTipShow(true);
            this.gbj.addView(this.gbk);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").P("obj_param1", eVar.gen).P("obj_param2", eVar.ges));
            }
            com.baidu.adp.lib.g.e.iB().postDelayed(this.gbl, 5000L);
        }
    }

    public void lc(boolean z) {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gbl);
        if (this.gbj != null) {
            if (this.gbk != null) {
                this.gbj.removeView(this.gbk);
                if (z && this.gbj.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").P("obj_locate", 2));
                }
            }
            this.gbj.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.gbj = null;
        this.gbi = null;
        if (this.gbl != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gbl);
        }
        MessageManager.getInstance().unRegisterListener(this.gbm);
        MessageManager.getInstance().unRegisterListener(this.gbn);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.bDl = bdUniqueId;
    }
}
