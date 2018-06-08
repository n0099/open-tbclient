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
    private BdUniqueId ada;
    private ScrollFragmentTabHost dPB;
    private PersonalizePageView dPC;
    private ConcernUnreadTipView dPD;
    private int dPE;
    private Runnable dPF = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dPC != null) {
                if (a.this.dPD != null) {
                    a.this.dPC.removeView(a.this.dPD);
                    TiebaStatic.log(new am("c12632").r("obj_locate", 3));
                }
                a.this.dPC.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dPG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener dPH = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gz(true);
        }
    };
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.dPG);
            tbPageContext.registerListener(this.dPH);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aN(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309541);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.p(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.aCU()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dPB = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.dPC = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.dPC != null) {
            this.dPD = new ConcernUnreadTipView(this.mContext.getContext());
            this.dPD.setBdUniqueId(this.ada);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.dPE;
            this.dPD.setLayoutParams(layoutParams);
            this.dPD.setData(eVar);
            this.dPD.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.dPD != null && a.this.dPD.dSa != null) {
                        if (view.getId() != a.this.dPD.dSa.getId()) {
                            if (a.this.dPB != null) {
                                a.this.dPB.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.gz(false);
                        TiebaStatic.log(new am("c12632").r("obj_locate", 1));
                    }
                }
            });
            this.dPC.setIsUnreadTipShow(true);
            this.dPC.addView(this.dPD);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").r("obj_param1", eVar.dRA).r("obj_param2", eVar.dRE));
            }
            com.baidu.adp.lib.g.e.im().postDelayed(this.dPF, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gz(boolean z) {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.dPF);
        if (this.dPC != null) {
            if (this.dPD != null) {
                this.dPC.removeView(this.dPD);
                if (z && this.dPC.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").r("obj_locate", 2));
                }
            }
            this.dPC.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.dPE = i;
    }

    public void onDestroy() {
        this.dPC = null;
        this.dPB = null;
        if (this.dPF != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.dPF);
        }
        MessageManager.getInstance().unRegisterListener(this.dPG);
        MessageManager.getInstance().unRegisterListener(this.dPH);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.ada = bdUniqueId;
    }
}
