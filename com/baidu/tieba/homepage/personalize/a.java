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
    private TbPageContext eWx;
    private ScrollFragmentTabHost kjT;
    private PersonalizePageView kjU;
    private ConcernUnreadTipView kjV;
    private BdUniqueId kjW;
    private Runnable kjX = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.kjU != null) {
                if (a.this.kjV != null) {
                    a.this.kjU.removeView(a.this.kjV);
                    TiebaStatic.log(new ar("c12632").aq("obj_locate", 3));
                }
                a.this.kjU.setIsUnreadTipShow(false);
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
    private CustomMessageListener kjY = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.sh(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.eWx = tbPageContext;
            tbPageContext.registerListener(this.netMessageListener);
            tbPageContext.registerListener(this.kjY);
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
        if (eVar != null && eVar.cRP()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.kjT = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.kjU = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.kjU != null) {
            this.kjV = new ConcernUnreadTipView(this.eWx.getContext());
            this.kjV.setBdUniqueId(this.kjW);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.kjV.setLayoutParams(layoutParams);
            this.kjV.setData(eVar);
            this.kjV.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.kjV != null && a.this.kjV.izx != null) {
                        if (view.getId() != a.this.kjV.izx.getId()) {
                            if (a.this.kjT != null) {
                                a.this.kjT.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.sh(false);
                        TiebaStatic.log(new ar("c12632").aq("obj_locate", 1));
                    }
                }
            });
            this.kjU.setIsUnreadTipShow(true);
            this.kjU.addView(this.kjV);
            if (eVar != null) {
                TiebaStatic.log(new ar("c12631").aq("obj_param1", eVar.knG).aq(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(this.kjX, 5000L);
        }
    }

    public void sh(boolean z) {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kjX);
        if (this.kjU != null) {
            if (this.kjV != null) {
                this.kjU.removeView(this.kjV);
                if (z && this.kjU.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new ar("c12632").aq("obj_locate", 2));
                }
            }
            this.kjU.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.kjU = null;
        this.kjT = null;
        if (this.kjX != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kjX);
        }
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
        MessageManager.getInstance().unRegisterListener(this.kjY);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.kjW = bdUniqueId;
    }
}
