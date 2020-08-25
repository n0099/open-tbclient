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
/* loaded from: classes16.dex */
public class a {
    private TbPageContext efn;
    private ScrollFragmentTabHost iMk;
    private PersonalizePageView iMl;
    private ConcernUnreadTipView iMm;
    private BdUniqueId iMn;
    private Runnable iMo = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.iMl != null) {
                if (a.this.iMm != null) {
                    a.this.iMl.removeView(a.this.iMm);
                    TiebaStatic.log(new aq("c12632").ai("obj_locate", 3));
                }
                a.this.iMl.setIsUnreadTipShow(false);
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
    private CustomMessageListener iMp = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.pH(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.efn = tbPageContext;
            tbPageContext.registerListener(this.netMessageListener);
            tbPageContext.registerListener(this.iMp);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bH(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.cyt()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iMk = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.iMl = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.iMl != null) {
            this.iMm = new ConcernUnreadTipView(this.efn.getContext());
            this.iMm.setBdUniqueId(this.iMn);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.iMm.setLayoutParams(layoutParams);
            this.iMm.setData(eVar);
            this.iMm.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iMm != null && a.this.iMm.gIn != null) {
                        if (view.getId() != a.this.iMm.gIn.getId()) {
                            if (a.this.iMk != null) {
                                a.this.iMk.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.pH(false);
                        TiebaStatic.log(new aq("c12632").ai("obj_locate", 1));
                    }
                }
            });
            this.iMl.setIsUnreadTipShow(true);
            this.iMl.addView(this.iMm);
            if (eVar != null) {
                TiebaStatic.log(new aq("c12631").ai("obj_param1", eVar.iPP).ai(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.mS().postDelayed(this.iMo, 5000L);
        }
    }

    public void pH(boolean z) {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iMo);
        if (this.iMl != null) {
            if (this.iMm != null) {
                this.iMl.removeView(this.iMm);
                if (z && this.iMl.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new aq("c12632").ai("obj_locate", 2));
                }
            }
            this.iMl.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.iMl = null;
        this.iMk = null;
        if (this.iMo != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.iMo);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.iMp);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.iMn = bdUniqueId;
    }
}
