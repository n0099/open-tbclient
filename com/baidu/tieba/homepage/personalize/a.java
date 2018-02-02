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
/* loaded from: classes2.dex */
public class a {
    private TbPageContext aQs;
    private ScrollFragmentTabHost eer;
    private d ees;
    private com.baidu.tieba.homepage.personalize.view.a eet;
    private int eeu;
    private Runnable eev = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ees != null) {
                if (a.this.eet != null) {
                    a.this.ees.removeView(a.this.eet);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 3));
                }
                a.this.ees.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eew = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener eex = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gD(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.aQs = tbPageContext;
            tbPageContext.registerListener(this.eew);
            tbPageContext.registerListener(this.eex);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aI(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309541);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.T(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.aBJ()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eer = scrollFragmentTabHost;
    }

    public void a(d dVar) {
        this.ees = dVar;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.ees != null) {
            this.eet = new com.baidu.tieba.homepage.personalize.view.a(this.aQs.getContext());
            this.eet.setBdUniqueId(this.aQs.getUniqueId());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.eeu;
            this.eet.setLayoutParams(layoutParams);
            this.eet.setData(eVar);
            this.eet.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() != a.this.eet.egM.getId()) {
                        a.this.eer.setCurrentTab(0);
                        return;
                    }
                    a.this.gD(false);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 1));
                }
            });
            this.ees.setIsUnreadTipShow(true);
            this.ees.addView(this.eet);
            if (eVar != null) {
                TiebaStatic.log(new ak("c12631").s("obj_param1", eVar.egm).s("obj_param2", eVar.egq));
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(this.eev, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gD(boolean z) {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eev);
        if (this.ees != null) {
            if (this.eet != null) {
                this.ees.removeView(this.eet);
                if (z && this.ees.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 2));
                }
            }
            this.ees.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.eeu = i;
    }

    public void onDestroy() {
        this.ees = null;
        this.eer = null;
        if (this.eev != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eev);
        }
    }
}
