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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
/* loaded from: classes2.dex */
public class a {
    private BdUniqueId aJU;
    private TbPageContext aRR;
    private ScrollFragmentTabHost eiD;
    private d eiE;
    private com.baidu.tieba.homepage.personalize.view.a eiF;
    private int eiG;
    private Runnable eiH = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eiE != null) {
                if (a.this.eiF != null) {
                    a.this.eiE.removeView(a.this.eiF);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 3));
                }
                a.this.eiE.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eiI = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener eiJ = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gN(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.aRR = tbPageContext;
            tbPageContext.registerListener(this.eiI);
            tbPageContext.registerListener(this.eiJ);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aJ(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309541);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.V(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.aDd()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eiD = scrollFragmentTabHost;
    }

    public void a(d dVar) {
        this.eiE = dVar;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.eiE != null) {
            this.eiF = new com.baidu.tieba.homepage.personalize.view.a(this.aRR.getContext());
            this.eiF.setBdUniqueId(this.aJU);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.eiG;
            this.eiF.setLayoutParams(layoutParams);
            this.eiF.setData(eVar);
            this.eiF.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() != a.this.eiF.ekY.getId()) {
                        a.this.eiD.setCurrentTab(0);
                        return;
                    }
                    a.this.gN(false);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 1));
                }
            });
            this.eiE.setIsUnreadTipShow(true);
            this.eiE.addView(this.eiF);
            if (eVar != null) {
                TiebaStatic.log(new ak("c12631").s("obj_param1", eVar.eky).s("obj_param2", eVar.ekC));
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(this.eiH, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gN(boolean z) {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eiH);
        if (this.eiE != null) {
            if (this.eiF != null) {
                this.eiE.removeView(this.eiF);
                if (z && this.eiE.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 2));
                }
            }
            this.eiE.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.eiG = i;
    }

    public void onDestroy() {
        this.eiE = null;
        this.eiD = null;
        if (this.eiH != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eiH);
        }
        MessageManager.getInstance().unRegisterListener(this.eiI);
        MessageManager.getInstance().unRegisterListener(this.eiJ);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aJU = bdUniqueId;
    }
}
