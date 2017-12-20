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
    private TbPageContext abX;
    private ScrollFragmentTabHost dqB;
    private d dqC;
    private com.baidu.tieba.homepage.personalize.view.a dqD;
    private int dqE;
    private Runnable dqF = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dqC != null) {
                if (a.this.dqD != null) {
                    a.this.dqC.removeView(a.this.dqD);
                    TiebaStatic.log(new ak("c12632").r("obj_locate", 3));
                }
                a.this.dqC.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dqG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener dqH = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.fY(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.abX = tbPageContext;
            tbPageContext.registerListener(this.dqG);
            tbPageContext.registerListener(this.dqH);
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
        if (eVar != null && eVar.auu()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dqB = scrollFragmentTabHost;
    }

    public void a(d dVar) {
        this.dqC = dVar;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.dqC != null) {
            this.dqD = new com.baidu.tieba.homepage.personalize.view.a(this.abX.getContext());
            this.dqD.setBdUniqueId(this.abX.getUniqueId());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.dqE;
            this.dqD.setLayoutParams(layoutParams);
            this.dqD.setData(eVar);
            this.dqD.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() != a.this.dqD.dsQ.getId()) {
                        a.this.dqB.setCurrentTab(0);
                        return;
                    }
                    a.this.fY(false);
                    TiebaStatic.log(new ak("c12632").r("obj_locate", 1));
                }
            });
            this.dqC.setIsUnreadTipShow(true);
            this.dqC.addView(this.dqD);
            if (eVar != null) {
                TiebaStatic.log(new ak("c12631").r("obj_param1", eVar.dss).r("obj_param2", eVar.dsw));
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(this.dqF, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void fY(boolean z) {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dqF);
        if (this.dqC != null) {
            if (this.dqD != null) {
                this.dqC.removeView(this.dqD);
                if (z && this.dqC.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new ak("c12632").r("obj_locate", 2));
                }
            }
            this.dqC.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.dqE = i;
    }

    public void onDestroy() {
        this.dqC = null;
        this.dqB = null;
        if (this.dqF != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dqF);
        }
    }
}
