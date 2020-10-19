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
/* loaded from: classes22.dex */
public class a {
    private TbPageContext etO;
    private ScrollFragmentTabHost jjU;
    private PersonalizePageView jjV;
    private ConcernUnreadTipView jjW;
    private BdUniqueId jjX;
    private Runnable jjY = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jjV != null) {
                if (a.this.jjW != null) {
                    a.this.jjV.removeView(a.this.jjW);
                    TiebaStatic.log(new aq("c12632").aj("obj_locate", 3));
                }
                a.this.jjV.setIsUnreadTipShow(false);
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
    private CustomMessageListener jjZ = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.qx(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.etO = tbPageContext;
            tbPageContext.registerListener(this.netMessageListener);
            tbPageContext.registerListener(this.jjZ);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bI(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.cFK()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.jjU = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.jjV = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.jjV != null) {
            this.jjW = new ConcernUnreadTipView(this.etO.getContext());
            this.jjW.setBdUniqueId(this.jjX);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.jjW.setLayoutParams(layoutParams);
            this.jjW.setData(eVar);
            this.jjW.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jjW != null && a.this.jjW.joo != null) {
                        if (view.getId() != a.this.jjW.joo.getId()) {
                            if (a.this.jjU != null) {
                                a.this.jjU.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.qx(false);
                        TiebaStatic.log(new aq("c12632").aj("obj_locate", 1));
                    }
                }
            });
            this.jjV.setIsUnreadTipShow(true);
            this.jjV.addView(this.jjW);
            if (eVar != null) {
                TiebaStatic.log(new aq("c12631").aj("obj_param1", eVar.jnA).aj(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jjY, 5000L);
        }
    }

    public void qx(boolean z) {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jjY);
        if (this.jjV != null) {
            if (this.jjW != null) {
                this.jjV.removeView(this.jjW);
                if (z && this.jjV.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new aq("c12632").aj("obj_locate", 2));
                }
            }
            this.jjV.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.jjV = null;
        this.jjU = null;
        if (this.jjY != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jjY);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.jjZ);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.jjX = bdUniqueId;
    }
}
