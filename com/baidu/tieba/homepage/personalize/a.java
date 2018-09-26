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
/* loaded from: classes2.dex */
public class a {
    private BdUniqueId afv;
    private ScrollFragmentTabHost edZ;
    private PersonalizePageView eea;
    private ConcernUnreadTipView eeb;
    private int eec;
    private Runnable eed = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eea != null) {
                if (a.this.eeb != null) {
                    a.this.eea.removeView(a.this.eeb);
                    TiebaStatic.log(new am("c12632").w("obj_locate", 3));
                }
                a.this.eea.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eee = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener eef = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.hk(true);
        }
    };
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.eee);
            tbPageContext.registerListener(this.eef);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aP(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309541);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.x(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.aGQ()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.edZ = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.eea = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.eea != null) {
            this.eeb = new ConcernUnreadTipView(this.mContext.getContext());
            this.eeb.setBdUniqueId(this.afv);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.eec;
            this.eeb.setLayoutParams(layoutParams);
            this.eeb.setData(eVar);
            this.eeb.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eeb != null && a.this.eeb.ehf != null) {
                        if (view.getId() != a.this.eeb.ehf.getId()) {
                            if (a.this.edZ != null) {
                                a.this.edZ.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.hk(false);
                        TiebaStatic.log(new am("c12632").w("obj_locate", 1));
                    }
                }
            });
            this.eea.setIsUnreadTipShow(true);
            this.eea.addView(this.eeb);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").w("obj_param1", eVar.egE).w("obj_param2", eVar.egI));
            }
            com.baidu.adp.lib.g.e.jt().postDelayed(this.eed, 5000L);
        }
    }

    public void hk(boolean z) {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eed);
        if (this.eea != null) {
            if (this.eeb != null) {
                this.eea.removeView(this.eeb);
                if (z && this.eea.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").w("obj_locate", 2));
                }
            }
            this.eea.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.eec = i;
    }

    public void onDestroy() {
        this.eea = null;
        this.edZ = null;
        if (this.eed != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eed);
        }
        MessageManager.getInstance().unRegisterListener(this.eee);
        MessageManager.getInstance().unRegisterListener(this.eef);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.afv = bdUniqueId;
    }
}
