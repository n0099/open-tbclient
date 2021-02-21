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
/* loaded from: classes2.dex */
public class a {
    private TbPageContext eUY;
    private ScrollFragmentTabHost khQ;
    private PersonalizePageView khR;
    private ConcernUnreadTipView khS;
    private BdUniqueId khT;
    private Runnable khU = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.khR != null) {
                if (a.this.khS != null) {
                    a.this.khR.removeView(a.this.khS);
                    TiebaStatic.log(new ar("c12632").ap("obj_locate", 3));
                }
                a.this.khR.setIsUnreadTipShow(false);
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
    private CustomMessageListener khV = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.sh(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.eUY = tbPageContext;
            tbPageContext.registerListener(this.netMessageListener);
            tbPageContext.registerListener(this.khV);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bV(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.cRI()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.khQ = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.khR = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.khR != null) {
            this.khS = new ConcernUnreadTipView(this.eUY.getContext());
            this.khS.setBdUniqueId(this.khT);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.khS.setLayoutParams(layoutParams);
            this.khS.setData(eVar);
            this.khS.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.khS != null && a.this.khS.ixO != null) {
                        if (view.getId() != a.this.khS.ixO.getId()) {
                            if (a.this.khQ != null) {
                                a.this.khQ.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.sh(false);
                        TiebaStatic.log(new ar("c12632").ap("obj_locate", 1));
                    }
                }
            });
            this.khR.setIsUnreadTipShow(true);
            this.khR.addView(this.khS);
            if (eVar != null) {
                TiebaStatic.log(new ar("c12631").ap("obj_param1", eVar.klE).ap(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(this.khU, 5000L);
        }
    }

    public void sh(boolean z) {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.khU);
        if (this.khR != null) {
            if (this.khS != null) {
                this.khR.removeView(this.khS);
                if (z && this.khR.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new ar("c12632").ap("obj_locate", 2));
                }
            }
            this.khR.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.khR = null;
        this.khQ = null;
        if (this.khU != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.khU);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.khV);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.khT = bdUniqueId;
    }
}
