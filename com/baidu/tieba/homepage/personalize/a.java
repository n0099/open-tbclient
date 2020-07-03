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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes9.dex */
public class a {
    private TbPageContext dPv;
    private ScrollFragmentTabHost irq;
    private PersonalizePageView irr;
    private ConcernUnreadTipView irs;
    private BdUniqueId irt;
    private Runnable iru = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.irr != null) {
                if (a.this.irs != null) {
                    a.this.irr.removeView(a.this.irs);
                    TiebaStatic.log(new ao("c12632").ag("obj_locate", 3));
                }
                a.this.irr.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hja = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener irv = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.ox(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.dPv = tbPageContext;
            tbPageContext.registerListener(this.hja);
            tbPageContext.registerListener(this.irv);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bE(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.cjY()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.irq = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.irr = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.irr != null) {
            this.irs = new ConcernUnreadTipView(this.dPv.getContext());
            this.irs.setBdUniqueId(this.irt);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.irs.setLayoutParams(layoutParams);
            this.irs.setData(eVar);
            this.irs.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.irs != null && a.this.irs.gqS != null) {
                        if (view.getId() != a.this.irs.gqS.getId()) {
                            if (a.this.irq != null) {
                                a.this.irq.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.ox(false);
                        TiebaStatic.log(new ao("c12632").ag("obj_locate", 1));
                    }
                }
            });
            this.irr.setIsUnreadTipShow(true);
            this.irr.addView(this.irs);
            if (eVar != null) {
                TiebaStatic.log(new ao("c12631").ag("obj_param1", eVar.iuR).ag(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.lt().postDelayed(this.iru, 5000L);
        }
    }

    public void ox(boolean z) {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iru);
        if (this.irr != null) {
            if (this.irs != null) {
                this.irr.removeView(this.irs);
                if (z && this.irr.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new ao("c12632").ag("obj_locate", 2));
                }
            }
            this.irr.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.irr = null;
        this.irq = null;
        if (this.iru != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iru);
        }
        MessageManager.getInstance().unRegisterListener(this.hja);
        MessageManager.getInstance().unRegisterListener(this.irv);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.irt = bdUniqueId;
    }
}
