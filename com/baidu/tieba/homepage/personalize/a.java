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
/* loaded from: classes4.dex */
public class a {
    private BdUniqueId bDk;
    private ScrollFragmentTabHost gbf;
    private PersonalizePageView gbg;
    private ConcernUnreadTipView gbh;
    private Runnable gbi = new Runnable() { // from class: com.baidu.tieba.homepage.personalize.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gbg != null) {
                if (a.this.gbh != null) {
                    a.this.gbg.removeView(a.this.gbh);
                    TiebaStatic.log(new am("c12632").P("obj_locate", 3));
                }
                a.this.gbg.setIsUnreadTipShow(false);
            }
        }
    };
    private com.baidu.adp.framework.listener.a gbj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541) { // from class: com.baidu.tieba.homepage.personalize.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.a(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.a(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    };
    private CustomMessageListener gbk = new CustomMessageListener(2921064) { // from class: com.baidu.tieba.homepage.personalize.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.lb(true);
        }
    };
    private TbPageContext mContext;

    public a(TbPageContext tbPageContext) {
        if (tbPageContext != null) {
            this.mContext = tbPageContext;
            tbPageContext.registerListener(this.gbj);
            tbPageContext.registerListener(this.gbk);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, com.baidu.tieba.tbadkCore.a.a.bn(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309541);
            bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
            bVar.D(true);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (eVar != null && eVar.but()) {
            b(eVar);
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.gbf = scrollFragmentTabHost;
    }

    public void a(PersonalizePageView personalizePageView) {
        this.gbg = personalizePageView;
    }

    public void b(com.baidu.tieba.homepage.personalize.data.e eVar) {
        if (this.gbg != null) {
            this.gbh = new ConcernUnreadTipView(this.mContext.getContext());
            this.gbh.setBdUniqueId(this.bDk);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 49;
            this.gbh.setLayoutParams(layoutParams);
            this.gbh.setData(eVar);
            this.gbh.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gbh != null && a.this.gbh.geN != null) {
                        if (view.getId() != a.this.gbh.geN.getId()) {
                            if (a.this.gbf != null) {
                                a.this.gbf.setCurrentTab(0);
                                return;
                            }
                            return;
                        }
                        a.this.lb(false);
                        TiebaStatic.log(new am("c12632").P("obj_locate", 1));
                    }
                }
            });
            this.gbg.setIsUnreadTipShow(true);
            this.gbg.addView(this.gbh);
            if (eVar != null) {
                TiebaStatic.log(new am("c12631").P("obj_param1", eVar.gek).P("obj_param2", eVar.gep));
            }
            com.baidu.adp.lib.g.e.iB().postDelayed(this.gbi, 5000L);
        }
    }

    public void lb(boolean z) {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gbi);
        if (this.gbg != null) {
            if (this.gbh != null) {
                this.gbg.removeView(this.gbh);
                if (z && this.gbg.getIsUnreadTipShow()) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new am("c12632").P("obj_locate", 2));
                }
            }
            this.gbg.setIsUnreadTipShow(false);
        }
    }

    public void onDestroy() {
        this.gbg = null;
        this.gbf = null;
        if (this.gbi != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.gbi);
        }
        MessageManager.getInstance().unRegisterListener(this.gbj);
        MessageManager.getInstance().unRegisterListener(this.gbk);
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.bDk = bdUniqueId;
    }
}
