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
    private BdUniqueId aJK;
    private TbPageContext aRI;
    private ScrollFragmentTabHost eiH;
    private d eiI;
    private com.baidu.tieba.homepage.personalize.view.a eiJ;
    private int eiK;
    private Runnable eiL = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eiI != null) {
                if (a.this.eiJ != null) {
                    a.this.eiI.removeView(a.this.eiJ);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 3));
                }
                a.this.eiI.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eiM = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener eiN = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gS(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.aRI = tbPageContext;
            tbPageContext.registerListener(this.eiM);
            tbPageContext.registerListener(this.eiN);
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
        this.eiH = scrollFragmentTabHost;
    }

    public void a(d dVar) {
        this.eiI = dVar;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.eiI != null) {
            this.eiJ = new com.baidu.tieba.homepage.personalize.view.a(this.aRI.getContext());
            this.eiJ.setBdUniqueId(this.aJK);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.eiK;
            this.eiJ.setLayoutParams(layoutParams);
            this.eiJ.setData(eVar);
            this.eiJ.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() != a.this.eiJ.elc.getId()) {
                        a.this.eiH.setCurrentTab(0);
                        return;
                    }
                    a.this.gS(false);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 1));
                }
            });
            this.eiI.setIsUnreadTipShow(true);
            this.eiI.addView(this.eiJ);
            if (eVar != null) {
                TiebaStatic.log(new ak("c12631").s("obj_param1", eVar.ekC).s("obj_param2", eVar.ekG));
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(this.eiL, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gS(boolean z) {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eiL);
        if (this.eiI != null) {
            if (this.eiJ != null) {
                this.eiI.removeView(this.eiJ);
                if (z && this.eiI.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 2));
                }
            }
            this.eiI.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.eiK = i;
    }

    public void onDestroy() {
        this.eiI = null;
        this.eiH = null;
        if (this.eiL != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eiL);
        }
        MessageManager.getInstance().unRegisterListener(this.eiM);
        MessageManager.getInstance().unRegisterListener(this.eiN);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aJK = bdUniqueId;
    }
}
