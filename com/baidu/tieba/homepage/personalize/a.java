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
    private TbPageContext aQq;
    private ScrollFragmentTabHost ecL;
    private d ecM;
    private com.baidu.tieba.homepage.personalize.view.a ecN;
    private int ecO;
    private Runnable ecP = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ecM != null) {
                if (a.this.ecN != null) {
                    a.this.ecM.removeView(a.this.ecN);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 3));
                }
                a.this.ecM.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ecQ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener ecR = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gx(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.aQq = tbPageContext;
            tbPageContext.registerListener(this.ecQ);
            tbPageContext.registerListener(this.ecR);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aG(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
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
        if (eVar != null && eVar.aBz()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ecL = scrollFragmentTabHost;
    }

    public void a(d dVar) {
        this.ecM = dVar;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.ecM != null) {
            this.ecN = new com.baidu.tieba.homepage.personalize.view.a(this.aQq.getContext());
            this.ecN.setBdUniqueId(this.aQq.getUniqueId());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.ecO;
            this.ecN.setLayoutParams(layoutParams);
            this.ecN.setData(eVar);
            this.ecN.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() != a.this.ecN.efa.getId()) {
                        a.this.ecL.setCurrentTab(0);
                        return;
                    }
                    a.this.gx(false);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 1));
                }
            });
            this.ecM.setIsUnreadTipShow(true);
            this.ecM.addView(this.ecN);
            if (eVar != null) {
                TiebaStatic.log(new ak("c12631").s("obj_param1", eVar.eeC).s("obj_param2", eVar.eeG));
            }
            com.baidu.adp.lib.g.e.nr().postDelayed(this.ecP, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gx(boolean z) {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.ecP);
        if (this.ecM != null) {
            if (this.ecN != null) {
                this.ecM.removeView(this.ecN);
                if (z && this.ecM.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 2));
                }
            }
            this.ecM.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.ecO = i;
    }

    public void onDestroy() {
        this.ecM = null;
        this.ecL = null;
        if (this.ecP != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.ecP);
        }
    }
}
