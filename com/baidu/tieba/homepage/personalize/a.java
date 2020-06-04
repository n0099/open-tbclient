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
/* loaded from: classes9.dex */
public class a {
    private TbPageContext dIF;
    private ScrollFragmentTabHost icj;
    private PersonalizePageView ick;
    private ConcernUnreadTipView icl;
    private BdUniqueId icm;
    private Runnable icn = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ick != null) {
                if (a.this.icl != null) {
                    a.this.ick.removeView(a.this.icl);
                    TiebaStatic.log(new an("c12632").ag("obj_locate", 3));
                }
                a.this.ick.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gWl = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener ico = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.om(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.dIF = tbPageContext;
            tbPageContext.registerListener(this.gWl);
            tbPageContext.registerListener(this.ico);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bF(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.cgy()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.icj = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.ick = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.ick != null) {
            this.icl = new ConcernUnreadTipView(this.dIF.getContext());
            this.icl.setBdUniqueId(this.icm);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.icl.setLayoutParams(layoutParams);
            this.icl.setData(eVar);
            this.icl.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.icl != null && a.this.icl.gdY != null) {
                        if (view.getId() != a.this.icl.gdY.getId()) {
                            if (a.this.icj != null) {
                                a.this.icj.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.om(false);
                        TiebaStatic.log(new an("c12632").ag("obj_locate", 1));
                    }
                }
            });
            this.ick.setIsUnreadTipShow(true);
            this.ick.addView(this.icl);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").ag("obj_param1", eVar.ifG).ag(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.ld().postDelayed(this.icn, 5000L);
        }
    }

    public void om(boolean z) {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.icn);
        if (this.ick != null) {
            if (this.icl != null) {
                this.ick.removeView(this.icl);
                if (z && this.ick.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new an("c12632").ag("obj_locate", 2));
                }
            }
            this.ick.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.ick = null;
        this.icj = null;
        if (this.icn != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.icn);
        }
        MessageManager.getInstance().unRegisterListener(this.gWl);
        MessageManager.getInstance().unRegisterListener(this.ico);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.icm = bdUniqueId;
    }
}
