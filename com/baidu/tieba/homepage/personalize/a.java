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
    private BdUniqueId bEi;
    private Runnable ghA = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ghy != null) {
                if (a.this.ghz != null) {
                    a.this.ghy.removeView(a.this.ghz);
                    TiebaStatic.log(new an("c12632").P("obj_locate", 3));
                }
                a.this.ghy.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ghB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener ghC = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.lp(true);
        }
    };
    private ScrollFragmentTabHost ghx;
    private PersonalizePageView ghy;
    private ConcernUnreadTipView ghz;
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.ghB);
            tbPageContext.registerListener(this.ghC);
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
        if (eVar != null && eVar.bxb()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ghx = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.ghy = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.ghy != null) {
            this.ghz = new ConcernUnreadTipView(this.mContext.getContext());
            this.ghz.setBdUniqueId(this.bEi);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.ghz.setLayoutParams(layoutParams);
            this.ghz.setData(eVar);
            this.ghz.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.ghz != null && a.this.ghz.glb != null) {
                        if (view.getId() != a.this.ghz.glb.getId()) {
                            if (a.this.ghx != null) {
                                a.this.ghx.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.lp(false);
                        TiebaStatic.log(new an("c12632").P("obj_locate", 1));
                    }
                }
            });
            this.ghy.setIsUnreadTipShow(true);
            this.ghy.addView(this.ghz);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").P("obj_param1", eVar.gkz).P("obj_param2", eVar.gkD));
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(this.ghA, 5000L);
        }
    }

    public void lp(boolean z) {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ghA);
        if (this.ghy != null) {
            if (this.ghz != null) {
                this.ghy.removeView(this.ghz);
                if (z && this.ghy.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.ahO().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new an("c12632").P("obj_locate", 2));
                }
            }
            this.ghy.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.ghy = null;
        this.ghx = null;
        if (this.ghA != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ghA);
        }
        MessageManager.getInstance().unRegisterListener(this.ghB);
        MessageManager.getInstance().unRegisterListener(this.ghC);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.bEi = bdUniqueId;
    }
}
