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
/* loaded from: classes6.dex */
public class a {
    private BdUniqueId alf;
    private ScrollFragmentTabHost enn;
    private PersonalizePageView eno;
    private ConcernUnreadTipView enp;
    private Runnable enq = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eno != null) {
                if (a.this.enp != null) {
                    a.this.eno.removeView(a.this.enp);
                    TiebaStatic.log(new am("c12632").x("obj_locate", 3));
                }
                a.this.eno.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a enr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener ens = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.hM(true);
        }
    };
    private TbPageContext mContext;
    private int mHeaderHeight;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.enr);
            tbPageContext.registerListener(this.ens);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aT(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
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
        if (eVar != null && eVar.aJG()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.enn = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.eno = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.eno != null) {
            this.enp = new ConcernUnreadTipView(this.mContext.getContext());
            this.enp.setBdUniqueId(this.alf);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.mHeaderHeight;
            this.enp.setLayoutParams(layoutParams);
            this.enp.setData(eVar);
            this.enp.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.enp != null && a.this.enp.eqs != null) {
                        if (view.getId() != a.this.enp.eqs.getId()) {
                            if (a.this.enn != null) {
                                a.this.enn.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.hM(false);
                        TiebaStatic.log(new am("c12632").x("obj_locate", 1));
                    }
                }
            });
            this.eno.setIsUnreadTipShow(true);
            this.eno.addView(this.enp);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").x("obj_param1", eVar.epS).x("obj_param2", eVar.epW));
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(this.enq, 5000L);
        }
    }

    public void hM(boolean z) {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.enq);
        if (this.eno != null) {
            if (this.enp != null) {
                this.eno.removeView(this.enp);
                if (z && this.eno.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").x("obj_locate", 2));
                }
            }
            this.eno.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderHeight = i;
    }

    public void onDestroy() {
        this.eno = null;
        this.enn = null;
        if (this.enq != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.enq);
        }
        MessageManager.getInstance().unRegisterListener(this.enr);
        MessageManager.getInstance().unRegisterListener(this.ens);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.alf = bdUniqueId;
    }
}
