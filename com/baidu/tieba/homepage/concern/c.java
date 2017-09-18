package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.core.view.l;
import com.baidu.tbadk.data.e;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.r;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.d;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private BdTypeListView aTw;
    private PbListView ben;
    private f bfY;
    private com.baidu.tieba.homepage.concern.a cZb;
    private a cZc;
    private d cZd;
    private boolean cZe;
    private boolean cZf;
    private d.a cZg;
    private View.OnClickListener cZh;
    private CustomMessageListener cZi;
    private CustomMessageListener cqN;
    private View crD;
    private l mPullView;
    private TbPageContext<?> pageContext;
    private g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void lL(String str);

        void onPullToRefresh();

        void x(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.aTw != null) {
            this.aTw.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cZb != null) {
            this.cZb.setPageUniqueId(bdUniqueId);
        }
        if (this.cZd != null) {
            this.cZd.n(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cqN != null) {
            this.cqN.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cqN);
        }
        if (this.cZi != null) {
            this.cZi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cZi);
        }
    }

    public c(Context context) {
        super(context);
        this.cZe = false;
        this.cZf = false;
        this.cZg = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void aqo() {
                if (c.this.cZc == null) {
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.v(false, false);
                    return;
                }
                boolean aql = c.this.aql();
                c.this.NH();
                if (aql) {
                    c.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.cZc.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void lK(String str) {
                if (c.this.cZc != null) {
                    c.this.cZc.lL(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.v(false, false);
                if (i == 1) {
                    if (c.this.cZd != null) {
                        c.this.fN(c.this.cZd.hasMore());
                    }
                    if (i.hi()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.aTw.setVisibility(8);
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void w(boolean z, boolean z2) {
                if (c.this.cZd != null) {
                    c.this.fN(c.this.cZd.hasMore());
                }
                c.this.aTw.setVisibility(0);
                c.this.v(z, z2);
                c.this.NH();
            }
        };
        this.cZh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Ng();
            }
        };
        this.cqN = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                    com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                    if (bVar.forumId == 0 && bVar.state == 3 && !v.v(c.this.cZd.getDataList()) && (c.this.cZd.getDataList().get(0) instanceof e) && !v.v(((e) c.this.cZd.getDataList().get(0)).Co())) {
                        List<com.baidu.adp.widget.ListView.f> Co = ((e) c.this.cZd.getDataList().get(0)).Co();
                        int size = Co.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                i = -1;
                                break;
                            } else if ((Co.get(i2) instanceof com.baidu.tbadk.data.f) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((com.baidu.tbadk.data.f) Co.get(i2)).user_id))) {
                                i = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        com.baidu.tbadk.data.f fVar = new com.baidu.tbadk.data.f();
                        fVar.user_id = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        fVar.user_name = TbadkCoreApplication.getCurrentAccountName();
                        fVar.portrait = TbadkCoreApplication.getCurrentPortrait();
                        fVar.mStatus = 3;
                        fVar.azL = String.valueOf(0);
                        fVar.azK = bVar;
                        if (i != -1) {
                            Co.set(i, fVar);
                        } else {
                            Co.add(1, fVar);
                        }
                        c.this.cZd.aqq();
                    }
                }
            }
        };
        this.cZi = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.cZe = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aTw = new BdTypeListView(context);
        this.aTw.setDividerHeight(0);
        this.aTw.setSelector(17170445);
        this.ben = new PbListView(context);
        this.ben.lb();
        this.ben.dp(d.e.cp_bg_line_c);
        this.ben.setTextColor(aj.getColor(d.e.cp_cont_d));
        this.ben.dq(TbadkCoreApplication.getInst().getSkinType());
        this.ben.setOnClickListener(this.cZh);
        this.aTw.setNextPage(this.ben);
        com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new l(this.pageContext);
        this.aTw.setPullRefresh(this.mPullView);
        this.mPullView.W(true);
        this.crD = BdListViewHelper.a(context, this.aTw, BdListViewHelper.HeadType.DEFAULT);
        this.cZb = new com.baidu.tieba.homepage.concern.a(context, this.aTw);
        this.cZd = new d(this.pageContext, this.aTw, this.cZb);
        addView(this.aTw);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void aqj() {
        this.cZd.a(this.cZg);
        this.mPullView.a(new k.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                c.this.cZd.update();
            }
        });
        this.aTw.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.Ng();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(boolean z) {
        if (this.ben != null) {
            if (z) {
                this.ben.wX();
                this.ben.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.ben.ds(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.cZc = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.ben != null) {
            this.ben.wW();
            this.ben.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cZd.a(z, dataRes, 0, null);
    }

    public void aqk() {
        if (this.cZd != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cZd.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(r rVar) {
        if (this.cZd != null) {
            this.cZd.setRecommendFrsNavigationAnimDispatcher(rVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bfY != null) {
            this.bfY.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.mPullView != null) {
            this.mPullView.dq(i);
        }
        if (this.ben != null) {
            this.ben.setTextColor(aj.getColor(d.e.cp_cont_d));
            this.ben.dq(i);
        }
        this.cZb.onChangeSkinType(i);
        aj.k(this, d.e.cp_bg_line_d);
    }

    public long getTagCode() {
        return 0L;
    }

    public void N(String str, int i) {
        if (this.ben != null) {
            this.ben.wW();
            this.ben.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cZd.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.cZd != null) {
                        c.this.cZd.update();
                    }
                }
            });
        }
        this.refreshView.eZ(getContext().getResources().getDimensionPixelSize(d.f.ds280));
        this.refreshView.gv(str);
        this.refreshView.c(view, z);
        this.refreshView.ER();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NH() {
        if (this.refreshView != null) {
            this.refreshView.N(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z, boolean z2) {
        if (this.bfY != null) {
            this.bfY.N(this);
            this.bfY = null;
            this.aTw.setNextPage(this.ben);
        }
        if (this.cZc != null) {
            this.cZc.x(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aql() {
        if (this.refreshView != null) {
            return this.refreshView.EI();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.bfY == null) {
            if (i < 0) {
                this.bfY = new f(getContext());
            } else {
                this.bfY = new f(getContext(), i);
            }
            this.bfY.onChangeSkinType();
        }
        this.bfY.c(this, z);
        this.aTw.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cZd != null) {
            this.cZd.setTabInForeBackgroundState(z);
        }
    }

    public void aqm() {
        setViewForeground(false);
        if (this.cZd != null) {
            this.cZd.eP(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.cZd != null) {
            this.cZd.fO(z);
        }
    }

    public void reload() {
        if (this.aTw != null) {
            if (this.cZe && this.aTw.getFirstVisiblePosition() != 0) {
                this.cZe = false;
                return;
            }
            this.aTw.setSelection(0);
            if (this.aTw.isRefreshDone()) {
                this.aTw.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.cZd.a((d.a) null);
        this.mPullView.a((k.b) null);
        this.mPullView.a((k.c) null);
        this.aTw.setOnSrollToBottomListener(null);
        this.mPullView.a((k.a) null);
        this.mPullView.release();
        this.aTw.setRecyclerListener(null);
    }

    public void aqn() {
        if (this.cZd != null) {
            this.cZd.eP(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ng() {
        if (this.ben != null && !this.ben.xa()) {
            this.ben.wV();
            this.ben.dr(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cZd.Ng();
    }
}
