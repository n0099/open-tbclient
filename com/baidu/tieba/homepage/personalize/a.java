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
/* loaded from: classes4.dex */
public class a {
    private BdUniqueId bVH;
    private TbPageContext ceu;
    private ScrollFragmentTabHost giN;
    private PersonalizePageView giO;
    private ConcernUnreadTipView giP;
    private Runnable giQ = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.giO != null) {
                if (a.this.giP != null) {
                    a.this.giO.removeView(a.this.giP);
                    TiebaStatic.log(new an("c12632").O("obj_locate", 3));
                }
                a.this.giO.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a giR = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener giS = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.lg(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.ceu = tbPageContext;
            tbPageContext.registerListener(this.giR);
            tbPageContext.registerListener(this.giS);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bl(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.bvf()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.giN = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.giO = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.giO != null) {
            this.giP = new ConcernUnreadTipView(this.ceu.getContext());
            this.giP.setBdUniqueId(this.bVH);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.giP.setLayoutParams(layoutParams);
            this.giP.setData(eVar);
            this.giP.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.giP != null && a.this.giP.gmq != null) {
                        if (view.getId() != a.this.giP.gmq.getId()) {
                            if (a.this.giN != null) {
                                a.this.giN.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.lg(false);
                        TiebaStatic.log(new an("c12632").O("obj_locate", 1));
                    }
                }
            });
            this.giO.setIsUnreadTipShow(true);
            this.giO.addView(this.giP);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").O("obj_param1", eVar.glO).O(TiebaInitialize.Params.OBJ_PARAM2, eVar.glS));
            }
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.giQ, 5000L);
        }
    }

    public void lg(boolean z) {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.giQ);
        if (this.giO != null) {
            if (this.giP != null) {
                this.giO.removeView(this.giP);
                if (z && this.giO.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.alP().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new an("c12632").O("obj_locate", 2));
                }
            }
            this.giO.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.giO = null;
        this.giN = null;
        if (this.giQ != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.giQ);
        }
        MessageManager.getInstance().unRegisterListener(this.giR);
        MessageManager.getInstance().unRegisterListener(this.giS);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.bVH = bdUniqueId;
    }
}
