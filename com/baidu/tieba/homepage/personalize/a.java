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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes2.dex */
public class a {
    private TbPageContext eSJ;
    private ScrollFragmentTabHost jZv;
    private PersonalizePageView jZw;
    private ConcernUnreadTipView jZx;
    private BdUniqueId jZy;
    private Runnable jZz = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jZw != null) {
                if (a.this.jZx != null) {
                    a.this.jZw.removeView(a.this.jZx);
                    TiebaStatic.log(new aq("c12632").an("obj_locate", 3));
                }
                a.this.jZw.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a netMessageListener = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener jZA = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.rV(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.eSJ = tbPageContext;
            tbPageContext.registerListener(this.netMessageListener);
            tbPageContext.registerListener(this.jZA);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bU(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.cPC()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jZv = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.jZw = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.jZw != null) {
            this.jZx = new ConcernUnreadTipView(this.eSJ.getContext());
            this.jZx.setBdUniqueId(this.jZy);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.jZx.setLayoutParams(layoutParams);
            this.jZx.setData(eVar);
            this.jZx.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jZx != null && a.this.jZx.kdU != null) {
                        if (view.getId() != a.this.jZx.kdU.getId()) {
                            if (a.this.jZv != null) {
                                a.this.jZv.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.rV(false);
                        TiebaStatic.log(new aq("c12632").an("obj_locate", 1));
                    }
                }
            });
            this.jZw.setIsUnreadTipShow(true);
            this.jZw.addView(this.jZx);
            if (eVar != null) {
                TiebaStatic.log(new aq("c12631").an("obj_param1", eVar.kdg).an(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(this.jZz, 5000L);
        }
    }

    public void rV(boolean z) {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jZz);
        if (this.jZw != null) {
            if (this.jZx != null) {
                this.jZw.removeView(this.jZx);
                if (z && this.jZw.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new aq("c12632").an("obj_locate", 2));
                }
            }
            this.jZw.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.jZw = null;
        this.jZv = null;
        if (this.jZz != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jZz);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.jZA);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.jZy = bdUniqueId;
    }
}
