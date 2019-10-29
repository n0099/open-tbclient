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
/* loaded from: classes4.dex */
public class a {
    private BdUniqueId bWy;
    private TbPageContext cfl;
    private ScrollFragmentTabHost gjE;
    private PersonalizePageView gjF;
    private ConcernUnreadTipView gjG;
    private Runnable gjH = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gjF != null) {
                if (a.this.gjG != null) {
                    a.this.gjF.removeView(a.this.gjG);
                    TiebaStatic.log(new an("c12632").O("obj_locate", 3));
                }
                a.this.gjF.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gjI = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener gjJ = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.lg(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.cfl = tbPageContext;
            tbPageContext.registerListener(this.gjI);
            tbPageContext.registerListener(this.gjJ);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bl(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.bvh()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gjE = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.gjF = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.gjF != null) {
            this.gjG = new ConcernUnreadTipView(this.cfl.getContext());
            this.gjG.setBdUniqueId(this.bWy);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.gjG.setLayoutParams(layoutParams);
            this.gjG.setData(eVar);
            this.gjG.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gjG != null && a.this.gjG.gnh != null) {
                        if (view.getId() != a.this.gjG.gnh.getId()) {
                            if (a.this.gjE != null) {
                                a.this.gjE.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.lg(false);
                        TiebaStatic.log(new an("c12632").O("obj_locate", 1));
                    }
                }
            });
            this.gjF.setIsUnreadTipShow(true);
            this.gjF.addView(this.gjG);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").O("obj_param1", eVar.gmF).O(TiebaInitialize.Params.OBJ_PARAM2, eVar.gmJ));
            }
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.gjH, 5000L);
        }
    }

    public void lg(boolean z) {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.gjH);
        if (this.gjF != null) {
            if (this.gjG != null) {
                this.gjF.removeView(this.gjG);
                if (z && this.gjF.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.alR().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new an("c12632").O("obj_locate", 2));
                }
            }
            this.gjF.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.gjF = null;
        this.gjE = null;
        if (this.gjH != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.gjH);
        }
        MessageManager.getInstance().unRegisterListener(this.gjI);
        MessageManager.getInstance().unRegisterListener(this.gjJ);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.bWy = bdUniqueId;
    }
}
