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
/* loaded from: classes21.dex */
public class a {
    private TbPageContext ehG;
    private ScrollFragmentTabHost iUW;
    private PersonalizePageView iUX;
    private ConcernUnreadTipView iUY;
    private BdUniqueId iUZ;
    private Runnable iVa = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.iUX != null) {
                if (a.this.iUY != null) {
                    a.this.iUX.removeView(a.this.iUY);
                    TiebaStatic.log(new aq("c12632").ai("obj_locate", 3));
                }
                a.this.iUX.setIsUnreadTipShow(false);
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
    private CustomMessageListener iVb = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.pR(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.ehG = tbPageContext;
            tbPageContext.registerListener(this.netMessageListener);
            tbPageContext.registerListener(this.iVb);
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
        if (eVar != null && eVar.cCb()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.iUW = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.iUX = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.iUX != null) {
            this.iUY = new ConcernUnreadTipView(this.ehG.getContext());
            this.iUY.setBdUniqueId(this.iUZ);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.iUY.setLayoutParams(layoutParams);
            this.iUY.setData(eVar);
            this.iUY.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iUY != null && a.this.iUY.iZp != null) {
                        if (view.getId() != a.this.iUY.iZp.getId()) {
                            if (a.this.iUW != null) {
                                a.this.iUW.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.pR(false);
                        TiebaStatic.log(new aq("c12632").ai("obj_locate", 1));
                    }
                }
            });
            this.iUX.setIsUnreadTipShow(true);
            this.iUX.addView(this.iUY);
            if (eVar != null) {
                TiebaStatic.log(new aq("c12631").ai("obj_param1", eVar.iYB).ai(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.mX().postDelayed(this.iVa, 5000L);
        }
    }

    public void pR(boolean z) {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iVa);
        if (this.iUX != null) {
            if (this.iUY != null) {
                this.iUX.removeView(this.iUY);
                if (z && this.iUX.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new aq("c12632").ai("obj_locate", 2));
                }
            }
            this.iUX.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.iUX = null;
        this.iUW = null;
        if (this.iVa != null) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iVa);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.iVb);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.iUZ = bdUniqueId;
    }
}
