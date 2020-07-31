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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes16.dex */
public class a {
    private TbPageContext dVN;
    private ScrollFragmentTabHost ixu;
    private PersonalizePageView ixv;
    private ConcernUnreadTipView ixw;
    private BdUniqueId ixx;
    private Runnable ixy = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ixv != null) {
                if (a.this.ixw != null) {
                    a.this.ixv.removeView(a.this.ixw);
                    TiebaStatic.log(new ap("c12632").ah("obj_locate", 3));
                }
                a.this.ixv.setIsUnreadTipShow(false);
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
    private CustomMessageListener ixz = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.pc(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.dVN = tbPageContext;
            tbPageContext.registerListener(this.netMessageListener);
            tbPageContext.registerListener(this.ixz);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bC(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.cnA()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.ixu = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.ixv = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.ixv != null) {
            this.ixw = new ConcernUnreadTipView(this.dVN.getContext());
            this.ixw.setBdUniqueId(this.ixx);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.ixw.setLayoutParams(layoutParams);
            this.ixw.setData(eVar);
            this.ixw.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.ixw != null && a.this.ixw.gwo != null) {
                        if (view.getId() != a.this.ixw.gwo.getId()) {
                            if (a.this.ixu != null) {
                                a.this.ixu.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.pc(false);
                        TiebaStatic.log(new ap("c12632").ah("obj_locate", 1));
                    }
                }
            });
            this.ixv.setIsUnreadTipShow(true);
            this.ixv.addView(this.ixw);
            if (eVar != null) {
                TiebaStatic.log(new ap("c12631").ah("obj_param1", eVar.iAV).ah(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.lt().postDelayed(this.ixy, 5000L);
        }
    }

    public void pc(boolean z) {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ixy);
        if (this.ixv != null) {
            if (this.ixw != null) {
                this.ixv.removeView(this.ixw);
                if (z && this.ixv.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new ap("c12632").ah("obj_locate", 2));
                }
            }
            this.ixv.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.ixv = null;
        this.ixu = null;
        if (this.ixy != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ixy);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.ixz);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.ixx = bdUniqueId;
    }
}
