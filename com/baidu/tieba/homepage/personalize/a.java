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
    private BdUniqueId aJJ;
    private TbPageContext aRG;
    private ScrollFragmentTabHost eir;
    private d eis;
    private com.baidu.tieba.homepage.personalize.view.a eit;
    private int eiu;
    private Runnable eiv = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.eis != null) {
                if (a.this.eit != null) {
                    a.this.eis.removeView(a.this.eit);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 3));
                }
                a.this.eis.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eiw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener eix = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.gN(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.aRG = tbPageContext;
            tbPageContext.registerListener(this.eiw);
            tbPageContext.registerListener(this.eix);
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
        if (eVar != null && eVar.aDc()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eir = scrollFragmentTabHost;
    }

    public void a(d dVar) {
        this.eis = dVar;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.eis != null) {
            this.eit = new com.baidu.tieba.homepage.personalize.view.a(this.aRG.getContext());
            this.eit.setBdUniqueId(this.aJJ);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.eiu;
            this.eit.setLayoutParams(layoutParams);
            this.eit.setData(eVar);
            this.eit.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view.getId() != a.this.eit.ekM.getId()) {
                        a.this.eir.setCurrentTab(0);
                        return;
                    }
                    a.this.gN(false);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 1));
                }
            });
            this.eis.setIsUnreadTipShow(true);
            this.eis.addView(this.eit);
            if (eVar != null) {
                TiebaStatic.log(new ak("c12631").s("obj_param1", eVar.ekm).s("obj_param2", eVar.ekq));
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(this.eiv, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void gN(boolean z) {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eiv);
        if (this.eis != null) {
            if (this.eit != null) {
                this.eis.removeView(this.eit);
                if (z && this.eis.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new ak("c12632").s("obj_locate", 2));
                }
            }
            this.eis.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.eiu = i;
    }

    public void onDestroy() {
        this.eis = null;
        this.eir = null;
        if (this.eiv != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.eiv);
        }
        MessageManager.getInstance().unRegisterListener(this.eiw);
        MessageManager.getInstance().unRegisterListener(this.eix);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aJJ = bdUniqueId;
    }
}
