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
    private ScrollFragmentTabHost jQO;
    private PersonalizePageView jQP;
    private ConcernUnreadTipView jQQ;
    private BdUniqueId jQR;
    private Runnable jQS = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jQP != null) {
                if (a.this.jQQ != null) {
                    a.this.jQP.removeView(a.this.jQQ);
                    TiebaStatic.log(new ar("c12632").al("obj_locate", 3));
                }
                a.this.jQP.setIsUnreadTipShow(false);
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
    private CustomMessageListener jQT = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
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
            tbPageContext.registerListener(this.jQT);
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
        if (eVar != null && eVar.cQm()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jQO = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.jQP = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.jQP != null) {
            this.jQQ = new ConcernUnreadTipView(this.eNx.getContext());
            this.jQQ.setBdUniqueId(this.jQR);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.jQQ.setLayoutParams(layoutParams);
            this.jQQ.setData(eVar);
            this.jQQ.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jQQ != null && a.this.jQQ.jVn != null) {
                        if (view.getId() != a.this.jQQ.jVn.getId()) {
                            if (a.this.jQO != null) {
                                a.this.jQO.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.rC(false);
                        TiebaStatic.log(new ar("c12632").al("obj_locate", 1));
                    }
                }
            });
            this.jQP.setIsUnreadTipShow(true);
            this.jQP.addView(this.jQQ);
            if (eVar != null) {
                TiebaStatic.log(new ar("c12631").al("obj_param1", eVar.jUz).al(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jQS, 5000L);
        }
    }

    public void rC(boolean z) {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jQS);
        if (this.jQP != null) {
            if (this.jQQ != null) {
                this.jQP.removeView(this.jQQ);
                if (z && this.jQP.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new ar("c12632").al("obj_locate", 2));
                }
            }
            this.jQP.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.jQP = null;
        this.jQO = null;
        if (this.jQS != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jQS);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.jQT);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.jQR = bdUniqueId;
    }
}
