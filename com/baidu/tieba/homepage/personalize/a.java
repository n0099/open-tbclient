package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes6.dex */
public class a {
    private BdUniqueId aoH;
    private ScrollFragmentTabHost eui;
    private PersonalizePageView euj;
    private ConcernUnreadTipView euk;
    private Runnable eul = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.euj != null) {
                if (a.this.euk != null) {
                    a.this.euj.removeView(a.this.euk);
                    TiebaStatic.log(new am("c12632").x("obj_locate", 3));
                }
                a.this.euj.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eum = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener eun = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.hO(true);
        }
    };
    private TbPageContext mContext;
    private int mHeaderHeight;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.eum);
            tbPageContext.registerListener(this.eun);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.aU(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309541);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.L(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.aLx()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.eui = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.euj = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.euj != null) {
            this.euk = new ConcernUnreadTipView(this.mContext.getContext());
            this.euk.setBdUniqueId(this.aoH);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            layoutParams.topMargin = this.mHeaderHeight;
            this.euk.setLayoutParams(layoutParams);
            this.euk.setData(eVar);
            this.euk.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.euk != null && a.this.euk.exm != null) {
                        if (view.getId() != a.this.euk.exm.getId()) {
                            if (a.this.eui != null) {
                                a.this.eui.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.hO(false);
                        TiebaStatic.log(new am("c12632").x("obj_locate", 1));
                    }
                }
            });
            this.euj.setIsUnreadTipShow(true);
            this.euj.addView(this.euk);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").x("obj_param1", eVar.ewM).x("obj_param2", eVar.ewQ));
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(this.eul, 5000L);
        }
    }

    public void hO(boolean z) {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eul);
        if (this.euj != null) {
            if (this.euk != null) {
                this.euj.removeView(this.euk);
                if (z && this.euj.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").x("obj_locate", 2));
                }
            }
            this.euj.setIsUnreadTipShow(false);
        }
    }

    public void setHeaderViewHeight(int i) {
        this.mHeaderHeight = i;
    }

    public void onDestroy() {
        this.euj = null;
        this.eui = null;
        if (this.eul != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eul);
        }
        MessageManager.getInstance().unRegisterListener(this.eum);
        MessageManager.getInstance().unRegisterListener(this.eun);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.aoH = bdUniqueId;
    }
}
