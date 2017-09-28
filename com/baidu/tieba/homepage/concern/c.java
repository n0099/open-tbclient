package com.baidu.tieba.homepage.concern;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.data.e;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.q;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.concern.d;
import com.baidu.tieba.homepage.concern.view.g;
import java.util.List;
import tbclient.Userlike.DataRes;
/* loaded from: classes.dex */
public class c extends FrameLayout {
    private BdTypeListView aUv;
    private PbListView bgb;
    private f bhL;
    private boolean cVA;
    private d.a cVB;
    private View.OnClickListener cVC;
    private CustomMessageListener cVD;
    private com.baidu.tieba.homepage.concern.a cVw;
    private a cVx;
    private d cVy;
    private g cVz;
    private View crZ;
    private CustomMessageListener crl;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void lp(String str);

        void onPullToRefresh();

        void y(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.aUv != null) {
            this.aUv.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cVw != null) {
            this.cVw.setPageUniqueId(bdUniqueId);
        }
        if (this.cVy != null) {
            this.cVy.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.crl != null) {
            this.crl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.crl);
        }
        if (this.cVD != null) {
            this.cVD.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cVD);
        }
    }

    public c(Context context) {
        super(context);
        this.cVA = false;
        this.mSkinType = 3;
        this.cVB = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void aoS() {
                if (c.this.cVx == null) {
                    if (c.this.cVz != null) {
                        c.this.cVz.setVisibility(8);
                    }
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.w(false, false);
                    return;
                }
                boolean aoO = c.this.aoO();
                c.this.Oc();
                if (aoO) {
                    c.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.cVx.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void lo(String str) {
                if (c.this.cVx != null) {
                    c.this.cVx.lp(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.w(false, false);
                if (i == 1) {
                    if (c.this.cVy != null) {
                        c.this.fz(c.this.cVy.hasMore());
                    }
                    if (j.hh()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.aUv.setVisibility(8);
                if (c.this.cVz != null) {
                    c.this.cVz.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void x(boolean z, boolean z2) {
                if (c.this.cVy != null) {
                    c.this.fz(c.this.cVy.hasMore());
                }
                c.this.aUv.setVisibility(0);
                c.this.w(z, z2);
                c.this.Oc();
            }
        };
        this.cVC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Ny();
            }
        };
        this.crl = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                    com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                    if (bVar.forumId == 0 && bVar.state == 3 && !v.u(c.this.cVy.getDataList()) && (c.this.cVy.getDataList().get(0) instanceof com.baidu.tbadk.data.d) && !v.u(((com.baidu.tbadk.data.d) c.this.cVy.getDataList().get(0)).BR())) {
                        List<com.baidu.adp.widget.ListView.f> BR = ((com.baidu.tbadk.data.d) c.this.cVy.getDataList().get(0)).BR();
                        int size = BR.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                i = -1;
                                break;
                            } else if ((BR.get(i2) instanceof e) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((e) BR.get(i2)).user_id))) {
                                i = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        e eVar = new e();
                        eVar.user_id = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        eVar.user_name = TbadkCoreApplication.getCurrentAccountName();
                        eVar.portrait = TbadkCoreApplication.getCurrentPortrait();
                        eVar.mStatus = 3;
                        eVar.azf = String.valueOf(0);
                        eVar.aze = bVar;
                        if (i != -1) {
                            BR.set(i, eVar);
                        } else {
                            BR.add(1, eVar);
                        }
                        c.this.cVy.aoU();
                    }
                }
            }
        };
        this.cVD = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.cVA = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aUv = new BdTypeListView(context);
        this.aUv.setDividerHeight(0);
        this.aUv.setSelector(17170445);
        this.bgb = new PbListView(context);
        this.bgb.getView();
        this.bgb.dy(d.e.cp_bg_line_d);
        this.bgb.setHeight(l.f(context, d.f.ds140));
        this.bgb.wq();
        this.bgb.setTextColor(aj.getColor(d.e.cp_cont_d));
        this.bgb.dx(d.e.cp_cont_e);
        this.bgb.setOnClickListener(this.cVC);
        this.aUv.setNextPage(this.bgb);
        com.baidu.adp.base.e<?> Y = i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new h(this.pageContext);
        this.aUv.setPullRefresh(this.mPullView);
        this.mPullView.X(true);
        if (TbadkCoreApplication.isLogin()) {
            this.crZ = BdListViewHelper.a(context, this.aUv, BdListViewHelper.HeadType.DEFAULT);
        }
        this.cVw = new com.baidu.tieba.homepage.concern.a(context, this.aUv);
        this.cVy = new d(this.pageContext, this.aUv, this.cVw);
        addView(this.aUv);
        this.aUv.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.crZ != null && this.crZ.getLayoutParams() != null) {
            this.crZ.getLayoutParams().height = i;
            this.crZ.setLayoutParams(this.crZ.getLayoutParams());
        }
    }

    public void aoM() {
        this.cVy.a(this.cVB);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.cVy.update();
                }
            }
        });
        this.aUv.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.Ny();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz(boolean z) {
        if (this.bgb != null) {
            if (z) {
                this.bgb.ww();
                this.bgb.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bgb.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.cVx = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bgb != null) {
            this.bgb.wu();
            this.bgb.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cVy.a(z, dataRes, 0, null);
    }

    public void aoN() {
        if (!TbadkCoreApplication.isLogin()) {
            aoP();
        } else if (this.cVy != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cVy.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
        if (this.cVy != null) {
            this.cVy.setRecommendFrsNavigationAnimDispatcher(qVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cVz != null) {
                this.cVz.onChangeSkinType(i);
            }
            if (this.bhL != null) {
                this.bhL.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
            if (this.bgb != null) {
                this.bgb.setTextColor(aj.getColor(d.e.cp_cont_d));
                this.bgb.dz(i);
            }
            this.cVw.onChangeSkinType(i);
            aj.k(this, d.e.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void N(String str, int i) {
        if (this.bgb != null) {
            this.bgb.wu();
            this.bgb.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cVy.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.cVy != null && TbadkCoreApplication.isLogin()) {
                        c.this.cVy.update();
                    }
                }
            });
        }
        this.refreshView.fk(getContext().getResources().getDimensionPixelSize(d.f.ds280));
        this.refreshView.gr(str);
        this.refreshView.c(view, z);
        this.refreshView.Ew();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oc() {
        if (this.refreshView != null) {
            this.refreshView.O(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, boolean z2) {
        if (this.bhL != null) {
            this.bhL.O(this);
            this.bhL = null;
            this.aUv.setNextPage(this.bgb);
        }
        if (this.cVx != null) {
            this.cVx.y(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoO() {
        if (this.refreshView != null) {
            return this.refreshView.En();
        }
        return false;
    }

    private void aoP() {
        if (this.cVz == null) {
            this.cVz = new com.baidu.tieba.homepage.concern.view.g(getContext());
            this.cVz.onChangeSkinType(this.mSkinType);
        }
        if (this.cVz.getParent() == null) {
            this.aUv.setVisibility(8);
            this.cVz.setVisibility(0);
            addView(this.cVz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.bhL == null) {
            if (i < 0) {
                this.bhL = new f(getContext());
            } else {
                this.bhL = new f(getContext(), i);
            }
            this.bhL.onChangeSkinType();
        }
        this.bhL.c(this, z);
        this.aUv.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cVy != null) {
            this.cVy.setTabInForeBackgroundState(z);
        }
    }

    public void aoQ() {
        setViewForeground(false);
        if (this.cVy != null) {
            this.cVy.eF(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.cVy != null) {
            this.cVy.fA(z);
        }
    }

    public void reload() {
        if (this.aUv != null) {
            if (this.cVA && this.aUv.getFirstVisiblePosition() != 0) {
                this.cVA = false;
                return;
            }
            this.aUv.setSelection(0);
            if (this.aUv.isRefreshDone()) {
                this.aUv.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.cVy.a((d.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.aUv.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        this.aUv.setRecyclerListener(null);
    }

    public void aoR() {
        if (this.cVy != null) {
            this.cVy.eF(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ny() {
        if (this.bgb != null && !this.bgb.wz()) {
            this.bgb.wt();
            this.bgb.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cVy.Ny();
    }
}
