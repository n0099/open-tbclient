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
    private TbPageContext aQp;
    private ScrollFragmentTabHost edW;
    private d edX;
    private com.baidu.tieba.homepage.personalize.view.a edY;
    private int edZ;
    private Runnable eea = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.edX != null) {
                if (a.this.edY != null) {
                    a.this.edX.removeView(a.this.edY);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 3));
                }
                a.this.edX.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eeb = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener eec = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gA(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.aQp = tbPageContext;
            tbPageContext.registerListener(this.eeb);
            tbPageContext.registerListener(this.eec);
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
        if (eVar != null && eVar.aBE()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.edW = scrollFragmentTabHost;
    }

    public void a(d dVar) {
        this.edX = dVar;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.edX != null) {
            this.edY = new com.baidu.tieba.homepage.personalize.view.a(this.aQp.getContext());
            this.edY.setBdUniqueId(this.aQp.getUniqueId());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.edZ;
            this.edY.setLayoutParams(layoutParams);
            this.edY.setData(eVar);
            this.edY.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() != a.this.edY.egr.getId()) {
                        a.this.edW.setCurrentTab(0);
                        return;
                    }
                    a.this.gA(false);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 1));
                }
            });
            this.edX.setIsUnreadTipShow(true);
            this.edX.addView(this.edY);
            if (eVar != null) {
                TiebaStatic.log(new ak("c12631").s("obj_param1", eVar.efR).s("obj_param2", eVar.efV));
            }
            com.baidu.adp.lib.g.e.nr().postDelayed(this.eea, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gA(boolean z) {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eea);
        if (this.edX != null) {
            if (this.edY != null) {
                this.edX.removeView(this.edY);
                if (z && this.edX.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 2));
                }
            }
            this.edX.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.edZ = i;
    }

    public void onDestroy() {
        this.edX = null;
        this.edW = null;
        if (this.eea != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.eea);
        }
    }
}
