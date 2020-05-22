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
    private ScrollFragmentTabHost ibw;
    private PersonalizePageView ibx;
    private ConcernUnreadTipView iby;
    private BdUniqueId ibz;
    private Runnable ibA = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ibx != null) {
                if (a.this.iby != null) {
                    a.this.ibx.removeView(a.this.iby);
                    TiebaStatic.log(new an("c12632").ag("obj_locate", 3));
                }
                a.this.ibx.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gWa = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener ibB = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.om(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.dIF = tbPageContext;
            tbPageContext.registerListener(this.gWa);
            tbPageContext.registerListener(this.ibB);
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
        if (eVar != null && eVar.cgp()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ibw = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.ibx = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.ibx != null) {
            this.iby = new ConcernUnreadTipView(this.dIF.getContext());
            this.iby.setBdUniqueId(this.ibz);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.iby.setLayoutParams(layoutParams);
            this.iby.setData(eVar);
            this.iby.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iby != null && a.this.iby.gdN != null) {
                        if (view.getId() != a.this.iby.gdN.getId()) {
                            if (a.this.ibw != null) {
                                a.this.ibw.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.om(false);
                        TiebaStatic.log(new an("c12632").ag("obj_locate", 1));
                    }
                }
            });
            this.ibx.setIsUnreadTipShow(true);
            this.ibx.addView(this.iby);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").ag("obj_param1", eVar.ieT).ag(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.ld().postDelayed(this.ibA, 5000L);
        }
    }

    public void om(boolean z) {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.ibA);
        if (this.ibx != null) {
            if (this.iby != null) {
                this.ibx.removeView(this.iby);
                if (z && this.ibx.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new an("c12632").ag("obj_locate", 2));
                }
            }
            this.ibx.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.ibx = null;
        this.ibw = null;
        if (this.ibA != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.ibA);
        }
        MessageManager.getInstance().unRegisterListener(this.gWa);
        MessageManager.getInstance().unRegisterListener(this.ibB);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.ibz = bdUniqueId;
    }
}
