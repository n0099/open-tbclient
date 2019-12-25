package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes6.dex */
public class a {
    private TbPageContext cQU;
    private ScrollFragmentTabHost gWf;
    private PersonalizePageView gWg;
    private ConcernUnreadTipView gWh;
    private BdUniqueId gWi;
    private Runnable gWj = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gWg != null) {
                if (a.this.gWh != null) {
                    a.this.gWg.removeView(a.this.gWh);
                    TiebaStatic.log(new an("c12632").Z("obj_locate", 3));
                }
                a.this.gWg.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gWk = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener gWl = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.mt(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.cQU = tbPageContext;
            tbPageContext.registerListener(this.gWk);
            tbPageContext.registerListener(this.gWl);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bu(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_CONCERN_UNREAD_TIP);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.setNeedAck(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.bMt()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gWf = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.gWg = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.gWg != null) {
            this.gWh = new ConcernUnreadTipView(this.cQU.getContext());
            this.gWh.setBdUniqueId(this.gWi);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.gWh.setLayoutParams(layoutParams);
            this.gWh.setData(eVar);
            this.gWh.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gWh != null && a.this.gWh.fdH != null) {
                        if (view.getId() != a.this.gWh.fdH.getId()) {
                            if (a.this.gWf != null) {
                                a.this.gWf.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.mt(false);
                        TiebaStatic.log(new an("c12632").Z("obj_locate", 1));
                    }
                }
            });
            this.gWg.setIsUnreadTipShow(true);
            this.gWg.addView(this.gWh);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").Z("obj_param1", eVar.gZs).Z(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.gy().postDelayed(this.gWj, 5000L);
        }
    }

    public void mt(boolean z) {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.gWj);
        if (this.gWg != null) {
            if (this.gWh != null) {
                this.gWg.removeView(this.gWh);
                if (z && this.gWg.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.aCY().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new an("c12632").Z("obj_locate", 2));
                }
            }
            this.gWg.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.gWg = null;
        this.gWf = null;
        if (this.gWj != null) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.gWj);
        }
        MessageManager.getInstance().unRegisterListener(this.gWk);
        MessageManager.getInstance().unRegisterListener(this.gWl);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.gWi = bdUniqueId;
    }
}
