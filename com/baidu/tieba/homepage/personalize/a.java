package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
/* loaded from: classes.dex */
public class a {
    private TbPageContext aca;
    private ScrollFragmentTabHost dqF;
    private d dqG;
    private com.baidu.tieba.homepage.personalize.view.a dqH;
    private int dqI;
    private Runnable dqJ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dqG != null) {
                if (a.this.dqH != null) {
                    a.this.dqG.removeView(a.this.dqH);
                    TiebaStatic.log(new ak("c12632").r("obj_locate", 3));
                }
                a.this.dqG.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dqK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener dqL = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.fY(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.aca = tbPageContext;
            tbPageContext.registerListener(this.dqK);
            tbPageContext.registerListener(this.dqL);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aG(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309541);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.m(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.auv()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dqF = scrollFragmentTabHost;
    }

    public void a(d dVar) {
        this.dqG = dVar;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.dqG != null) {
            this.dqH = new com.baidu.tieba.homepage.personalize.view.a(this.aca.getContext());
            this.dqH.setBdUniqueId(this.aca.getUniqueId());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.dqI;
            this.dqH.setLayoutParams(layoutParams);
            this.dqH.setData(eVar);
            this.dqH.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() != a.this.dqH.dsU.getId()) {
                        a.this.dqF.setCurrentTab(0);
                        return;
                    }
                    a.this.fY(false);
                    TiebaStatic.log(new ak("c12632").r("obj_locate", 1));
                }
            });
            this.dqG.setIsUnreadTipShow(true);
            this.dqG.addView(this.dqH);
            if (eVar != null) {
                TiebaStatic.log(new ak("c12631").r("obj_param1", eVar.dsw).r("obj_param2", eVar.dsA));
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(this.dqJ, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void fY(boolean z) {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dqJ);
        if (this.dqG != null) {
            if (this.dqH != null) {
                this.dqG.removeView(this.dqH);
                if (z && this.dqG.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new ak("c12632").r("obj_locate", 2));
                }
            }
            this.dqG.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.dqI = i;
    }

    public void onDestroy() {
        this.dqG = null;
        this.dqF = null;
        if (this.dqJ != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dqJ);
        }
    }
}
