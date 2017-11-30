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
    private TbPageContext acd;
    private Runnable dpA = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.dpx != null) {
                if (a.this.dpy != null) {
                    a.this.dpx.removeView(a.this.dpy);
                    TiebaStatic.log(new ak("c12632").r("obj_locate", 3));
                }
                a.this.dpx.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a dpB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener dpC = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.fX(true);
        }
    };
    private ScrollFragmentTabHost dpw;
    private d dpx;
    private com.baidu.tieba.homepage.personalize.view.a dpy;
    private int dpz;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.acd = tbPageContext;
            tbPageContext.registerListener(this.dpB);
            tbPageContext.registerListener(this.dpC);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aF(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
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
        if (eVar != null && eVar.aum()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.dpw = scrollFragmentTabHost;
    }

    public void a(d dVar) {
        this.dpx = dVar;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.dpx != null) {
            this.dpy = new com.baidu.tieba.homepage.personalize.view.a(this.acd.getContext());
            this.dpy.setBdUniqueId(this.acd.getUniqueId());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.dpz;
            this.dpy.setLayoutParams(layoutParams);
            this.dpy.setData(eVar);
            this.dpy.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() != a.this.dpy.drL.getId()) {
                        a.this.dpw.setCurrentTab(0);
                        return;
                    }
                    a.this.fX(false);
                    TiebaStatic.log(new ak("c12632").r("obj_locate", 1));
                }
            });
            this.dpx.setIsUnreadTipShow(true);
            this.dpx.addView(this.dpy);
            if (eVar != null) {
                TiebaStatic.log(new ak("c12631").r("obj_param1", eVar.drn).r("obj_param2", eVar.drr));
            }
            com.baidu.adp.lib.g.e.fP().postDelayed(this.dpA, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void fX(boolean z) {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dpA);
        if (this.dpx != null) {
            if (this.dpy != null) {
                this.dpx.removeView(this.dpy);
                if (z && this.dpx.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new ak("c12632").r("obj_locate", 2));
                }
            }
            this.dpx.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.dpz = i;
    }

    public void onDestroy() {
        this.dpx = null;
        this.dpw = null;
        if (this.dpA != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.dpA);
        }
    }
}
