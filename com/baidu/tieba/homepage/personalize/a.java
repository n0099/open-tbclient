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
    private TbPageContext cVv;
    private ScrollFragmentTabHost hcZ;
    private PersonalizePageView hda;
    private ConcernUnreadTipView hdb;
    private BdUniqueId hdc;
    private Runnable hdd = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.hda != null) {
                if (a.this.hdb != null) {
                    a.this.hda.removeView(a.this.hdb);
                    TiebaStatic.log(new an("c12632").X("obj_locate", 3));
                }
                a.this.hda.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a hde = new com.baidu.adp.framework.listener.a(1003387, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener hdf = new CustomMessageListener(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.mM(true);
        }
    };

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.cVv = tbPageContext;
            tbPageContext.registerListener(this.hde);
            tbPageContext.registerListener(this.hdf);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003387, com.baidu.tieba.tbadkCore.a.a.bu(TbConfig.URL_CONCERN_UNREAD_TIP, CmdConfigSocket.CMD_CONCERN_UNREAD_TIP));
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
        if (eVar != null && eVar.bPu()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.hcZ = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.hda = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.hda != null) {
            this.hdb = new ConcernUnreadTipView(this.cVv.getContext());
            this.hdb.setBdUniqueId(this.hdc);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.hdb.setLayoutParams(layoutParams);
            this.hdb.setData(eVar);
            this.hdb.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hdb != null && a.this.hdb.fkG != null) {
                        if (view.getId() != a.this.hdb.fkG.getId()) {
                            if (a.this.hcZ != null) {
                                a.this.hcZ.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.mM(false);
                        TiebaStatic.log(new an("c12632").X("obj_locate", 1));
                    }
                }
            });
            this.hda.setIsUnreadTipShow(true);
            this.hda.addView(this.hdb);
            if (eVar != null) {
                TiebaStatic.log(new an("c12631").X("obj_param1", eVar.hgy).X(TiebaInitialize.Params.OBJ_PARAM2, eVar.mThreadCount));
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(this.hdd, 5000L);
        }
    }

    public void mM(boolean z) {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hdd);
        if (this.hda != null) {
            if (this.hdb != null) {
                this.hda.removeView(this.hdb);
                if (z && this.hda.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.aFH().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_UNREAD_TIP_NEXT_SHOW_TIME), 0L);
                    TiebaStatic.log(new an("c12632").X("obj_locate", 2));
                }
            }
            this.hda.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.hda = null;
        this.hcZ = null;
        if (this.hdd != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.hdd);
        }
        MessageManager.getInstance().unRegisterListener(this.hde);
        MessageManager.getInstance().unRegisterListener(this.hdf);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.hdc = bdUniqueId;
    }
}
