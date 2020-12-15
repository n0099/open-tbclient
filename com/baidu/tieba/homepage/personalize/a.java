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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes22.dex */
public class a {
    private TbPageContext eNx;
    private ScrollFragmentTabHost jQQ;
    private PersonalizePageView jQR;
    private ConcernUnreadTipView jQS;
    private BdUniqueId jQT;
    private Runnable jQU = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jQR != null) {
                if (a.this.jQS != null) {
                    a.this.jQR.removeView(a.this.jQS);
                    TiebaStatic.log(new ar("c12632").al("obj_locate", 3));
                }
                a.this.jQR.setIsUnreadTipShow(false);
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
    private CustomMessageListener jQV = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.rC(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.eNx = tbPageContext;
            tbPageContext.registerListener(this.netMessageListener);
            tbPageContext.registerListener(this.jQV);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bN(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.cQn()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jQQ = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.jQR = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.jQR != null) {
            this.jQS = new ConcernUnreadTipView(this.eNx.getContext());
            this.jQS.setBdUniqueId(this.jQT);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.jQS.setLayoutParams(layoutParams);
            this.jQS.setData(eVar);
            this.jQS.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jQS != null && a.this.jQS.jVp != null) {
                        if (view.getId() != a.this.jQS.jVp.getId()) {
                            if (a.this.jQQ != null) {
                                a.this.jQQ.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.rC(false);
                        TiebaStatic.log(new ar("c12632").al("obj_locate", 1));
                    }
                }
            });
            this.jQR.setIsUnreadTipShow(true);
            this.jQR.addView(this.jQS);
            if (eVar != null) {
                TiebaStatic.log(new ar("c12631").al("obj_param1", eVar.jUB).al(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jQU, 5000L);
        }
    }

    public void rC(boolean z) {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jQU);
        if (this.jQR != null) {
            if (this.jQS != null) {
                this.jQR.removeView(this.jQS);
                if (z && this.jQR.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new ar("c12632").al("obj_locate", 2));
                }
            }
            this.jQR.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.jQR = null;
        this.jQQ = null;
        if (this.jQU != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jQU);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.jQV);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.jQT = bdUniqueId;
    }
}
