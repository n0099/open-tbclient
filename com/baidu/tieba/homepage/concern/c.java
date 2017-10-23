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
    private BdTypeListView aUi;
    private PbListView bfN;
    private f bhx;
    private com.baidu.tieba.homepage.concern.a cVk;
    private a cVl;
    private d cVm;
    private g cVn;
    private boolean cVo;
    private d.a cVp;
    private View.OnClickListener cVq;
    private CustomMessageListener cVr;
    private CustomMessageListener cqY;
    private View crN;
    private h mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void lo(String str);

        void onPullToRefresh();

        void y(boolean z, boolean z2);
    }

    public void completePullRefresh() {
        if (this.aUi != null) {
            this.aUi.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cVk != null) {
            this.cVk.setPageUniqueId(bdUniqueId);
        }
        if (this.cVm != null) {
            this.cVm.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.cqY != null) {
            this.cqY.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cqY);
        }
        if (this.cVr != null) {
            this.cVr.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cVr);
        }
    }

    public c(Context context) {
        super(context);
        this.cVo = false;
        this.mSkinType = 3;
        this.cVp = new d.a() { // from class: com.baidu.tieba.homepage.concern.c.1
            @Override // com.baidu.tieba.homepage.concern.d.a
            public void aoN() {
                if (c.this.cVl == null) {
                    if (c.this.cVn != null) {
                        c.this.cVn.setVisibility(8);
                    }
                    c.this.showNetRefreshView(c.this, TbadkCoreApplication.getInst().getString(d.l.neterror), true);
                    c.this.w(false, false);
                    return;
                }
                boolean aoJ = c.this.aoJ();
                c.this.NW();
                if (aoJ) {
                    c.this.h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
                }
                c.this.cVl.onPullToRefresh();
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void ln(String str) {
                if (c.this.cVl != null) {
                    c.this.cVl.lo(str);
                }
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void onError(int i, String str) {
                c.this.w(false, false);
                if (i == 1) {
                    if (c.this.cVm != null) {
                        c.this.fy(c.this.cVm.hasMore());
                    }
                    if (j.hh()) {
                        c.this.pageContext.showToast(str);
                        return;
                    }
                    return;
                }
                c.this.aUi.setVisibility(8);
                if (c.this.cVn != null) {
                    c.this.cVn.setVisibility(8);
                }
                c.this.showNetRefreshView(c.this, str, true);
            }

            @Override // com.baidu.tieba.homepage.concern.d.a
            public void x(boolean z, boolean z2) {
                if (c.this.cVm != null) {
                    c.this.fy(c.this.cVm.hasMore());
                }
                c.this.aUi.setVisibility(0);
                c.this.w(z, z2);
                c.this.NW();
            }
        };
        this.cVq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Ns();
            }
        };
        this.cqY = new CustomMessageListener(CmdConfigCustom.CMD_STORY_READ_CACHE) { // from class: com.baidu.tieba.homepage.concern.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.story.process.b)) {
                    com.baidu.tieba.story.process.b bVar = (com.baidu.tieba.story.process.b) customResponsedMessage.getData();
                    if (bVar.forumId == 0 && bVar.state == 3 && !v.u(c.this.cVm.getDataList()) && (c.this.cVm.getDataList().get(0) instanceof com.baidu.tbadk.data.d) && !v.u(((com.baidu.tbadk.data.d) c.this.cVm.getDataList().get(0)).BL())) {
                        List<com.baidu.adp.widget.ListView.f> BL = ((com.baidu.tbadk.data.d) c.this.cVm.getDataList().get(0)).BL();
                        int size = BL.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                i = -1;
                                break;
                            } else if ((BL.get(i2) instanceof e) && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(((e) BL.get(i2)).user_id))) {
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
                        eVar.ayT = String.valueOf(0);
                        eVar.ayS = bVar;
                        if (i != -1) {
                            BL.set(i, eVar);
                        } else {
                            BL.add(1, eVar);
                        }
                        c.this.cVm.aoP();
                    }
                }
            }
        };
        this.cVr = new CustomMessageListener(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW) { // from class: com.baidu.tieba.homepage.concern.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.cVo = true;
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.aUi = new BdTypeListView(context);
        this.aUi.setDividerHeight(0);
        this.aUi.setSelector(17170445);
        this.bfN = new PbListView(context);
        this.bfN.getView();
        this.bfN.dx(d.e.cp_bg_line_d);
        this.bfN.setHeight(l.f(context, d.f.ds140));
        this.bfN.wj();
        this.bfN.setTextColor(aj.getColor(d.e.cp_cont_d));
        this.bfN.dw(d.e.cp_cont_e);
        this.bfN.setOnClickListener(this.cVq);
        this.aUi.setNextPage(this.bfN);
        com.baidu.adp.base.e<?> Y = i.Y(context);
        if (Y instanceof TbPageContext) {
            this.pageContext = (TbPageContext) Y;
        }
        this.mPullView = new h(this.pageContext);
        this.aUi.setPullRefresh(this.mPullView);
        this.mPullView.X(true);
        if (TbadkCoreApplication.isLogin()) {
            this.crN = BdListViewHelper.a(context, this.aUi, BdListViewHelper.HeadType.DEFAULT);
        }
        this.cVk = new com.baidu.tieba.homepage.concern.a(context, this.aUi);
        this.cVm = new d(this.pageContext, this.aUi, this.cVk);
        addView(this.aUi);
        this.aUi.setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setHeaderViewHeight(int i) {
        if (this.crN != null && this.crN.getLayoutParams() != null) {
            this.crN.getLayoutParams().height = i;
            this.crN.setLayoutParams(this.crN.getLayoutParams());
        }
    }

    public void aoH() {
        this.cVm.a(this.cVp);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.homepage.concern.c.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                if (TbadkCoreApplication.isLogin()) {
                    c.this.cVm.update();
                }
            }
        });
        this.aUi.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.concern.c.3
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                c.this.Ns();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy(boolean z) {
        if (this.bfN != null) {
            if (z) {
                this.bfN.wp();
                this.bfN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                return;
            }
            this.bfN.dB(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public void setCallback(a aVar) {
        this.cVl = aVar;
    }

    public void a(DataRes dataRes, boolean z) {
        if (this.bfN != null) {
            this.bfN.wn();
            this.bfN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cVm.a(z, dataRes, 0, null);
    }

    public void aoI() {
        if (!TbadkCoreApplication.isLogin()) {
            aoK();
        } else if (this.cVm != null) {
            h(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds520));
            this.cVm.update();
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(q qVar) {
        if (this.cVm != null) {
            this.cVm.setRecommendFrsNavigationAnimDispatcher(qVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.cVn != null) {
                this.cVn.onChangeSkinType(i);
            }
            if (this.bhx != null) {
                this.bhx.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dy(i);
            }
            if (this.bfN != null) {
                this.bfN.setTextColor(aj.getColor(d.e.cp_cont_d));
                this.bfN.dy(i);
            }
            this.cVk.onChangeSkinType(i);
            aj.k(this, d.e.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void N(String str, int i) {
        if (this.bfN != null) {
            this.bfN.wn();
            this.bfN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cVm.a(true, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.cVm != null && TbadkCoreApplication.isLogin()) {
                        c.this.cVm.update();
                    }
                }
            });
        }
        this.refreshView.fj(getContext().getResources().getDimensionPixelSize(d.f.ds280));
        this.refreshView.gq(str);
        this.refreshView.c(view, z);
        this.refreshView.Eq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NW() {
        if (this.refreshView != null) {
            this.refreshView.O(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, boolean z2) {
        if (this.bhx != null) {
            this.bhx.O(this);
            this.bhx = null;
            this.aUi.setNextPage(this.bfN);
        }
        if (this.cVl != null) {
            this.cVl.y(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoJ() {
        if (this.refreshView != null) {
            return this.refreshView.Eh();
        }
        return false;
    }

    private void aoK() {
        if (this.cVn == null) {
            this.cVn = new com.baidu.tieba.homepage.concern.view.g(getContext());
            this.cVn.onChangeSkinType(this.mSkinType);
        }
        if (this.cVn.getParent() == null) {
            this.aUi.setVisibility(8);
            this.cVn.setVisibility(0);
            addView(this.cVn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.bhx == null) {
            if (i < 0) {
                this.bhx = new f(getContext());
            } else {
                this.bhx = new f(getContext(), i);
            }
            this.bhx.onChangeSkinType();
        }
        this.bhx.c(this, z);
        this.aUi.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.cVm != null) {
            this.cVm.setTabInForeBackgroundState(z);
        }
    }

    public void aoL() {
        setViewForeground(false);
        if (this.cVm != null) {
            this.cVm.eE(false);
        }
    }

    public void setViewForeground(boolean z) {
        if (this.cVm != null) {
            this.cVm.fz(z);
        }
    }

    public void reload() {
        if (this.aUi != null) {
            if (this.cVo && this.aUi.getFirstVisiblePosition() != 0) {
                this.cVo = false;
                return;
            }
            this.aUi.setSelection(0);
            if (this.aUi.isRefreshDone()) {
                this.aUi.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        this.cVm.a((d.a) null);
        this.mPullView.a((g.b) null);
        this.mPullView.a((g.c) null);
        this.aUi.setOnSrollToBottomListener(null);
        this.mPullView.a((g.a) null);
        this.mPullView.release();
        this.aUi.setRecyclerListener(null);
    }

    public void aoM() {
        if (this.cVm != null) {
            this.cVm.eE(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ns() {
        if (this.bfN != null && !this.bfN.ws()) {
            this.bfN.wm();
            this.bfN.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.cVm.Ns();
    }
}
