package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.e;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private static boolean eWB = false;
    private com.baidu.adp.lib.guide.c eGR;
    private ViewEventCenter eQn;
    private com.baidu.tieba.enterForum.data.b eQs;
    private ForumHeaderView eVD;
    private EnterForumAdView eWA;
    private int eWC;
    private e eWD;
    private h.c eWF;
    private final EnterForumFragment eWv;
    private com.baidu.tieba.enterForum.a.a eWw;
    private com.baidu.tieba.enterForum.multiConcern.a eWx;
    private List<com.baidu.tieba.enterForum.data.f> eWy;
    private CommonTipView eWz;
    private BdListView eai;
    private View epY;
    private Context mContext;
    private i mPullView;
    private View mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private boolean isFirst = true;
    private boolean eWE = true;
    private h.c dpu = new h.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            com.baidu.tieba.q.c.clt().x(b.this.eWv.getUniqueId());
            if (b.this.eWF != null) {
                b.this.eWF.en(z);
            }
            if (z && !b.this.eQU && b.this.eQs != null && b.this.eQs.eQU) {
                if (b.this.eQs.eQW > 0) {
                    b.this.eai.smoothScrollToPosition(0, 0, 0);
                    b.this.beM();
                    return;
                }
                b.this.eai.smoothScrollToPosition(0, 0, 0);
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.4
        private int dno = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.eWD.onScrollStateChanged(absListView, i);
            if (this.dno != i) {
                this.dno = i;
                if (this.dno == 1) {
                    if ((b.this.eQs == null || !b.this.eQs.eQU) && b.this.eWv != null && b.this.eWv.bdF() != null) {
                        b.this.eWv.bdF().aHR();
                    }
                    b.this.beQ();
                    return;
                }
                b.this.beJ();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.eWv.isPrimary() && this.dno != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.eai.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.eai.getItemAtPosition(i4) == v.c(b.this.eWy, 0)) {
                            b.this.a(dVar, b.this.eai.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.eWD.onScroll(absListView, i, i2, i3);
        }
    };
    c.a eWg = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.5
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void bdW() {
            b.this.beJ();
        }
    };
    private int eWG = 0;
    private int eWH = 0;
    boolean eQU = false;
    boolean eWI = false;
    private Runnable eWJ = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.9
        @Override // java.lang.Runnable
        public void run() {
            b.this.beN();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void beJ() {
        if (beK()) {
            if (this.eWv != null && this.eWv.bdF() != null) {
                this.eWv.bdF().aHS();
            }
        } else if ((this.eQs == null || !this.eQs.eQU) && this.eWv != null && this.eWv.bdF() != null) {
            this.eWv.bdF().aHR();
        }
    }

    private boolean beK() {
        return this.eai == null || this.eai.getChildCount() == 0 || this.eai.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.eWv = enterForumFragment;
        this.eQn = viewEventCenter;
        this.eWx = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bK(view);
        this.eWw = new com.baidu.tieba.enterForum.a.a(this.eWv.getPageContext(), this.eQn, recentlyVisitedForumModel, enterForumModel, this);
        this.eai.setAdapter((ListAdapter) this.eWw);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bK(View view) {
        this.mContext = view.getContext();
        this.eWD = new e();
        this.eWD.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (b.this.eQU) {
                    b.this.beN();
                } else if (b.this.eQs != null && b.this.eQs.eQU) {
                    b.this.eWG = -i;
                    b.this.beL();
                }
            }
        });
        this.eai = (BdListView) view.findViewById(R.id.listview);
        qq(0);
        this.eai.setBackgroundColor(0);
        this.eai.setVerticalScrollBarEnabled(false);
        this.eai.setOnScrollListener(this.mOnScrollListener);
        this.eai.setFastScrollEnabled(false);
        this.eai.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.eWv != null && this.eWv.bdF() != null) {
            this.eWv.bdF().b(this.eWg);
            this.eWv.bdF().a(this.eWg);
            this.eWv.bdF().a(this);
        }
        this.mPullView = new i(this.eWv.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                if (!b.this.eQU && b.this.eQs != null && b.this.eQs.eQU) {
                    b.this.eWH = i3;
                    b.this.beL();
                }
            }
        });
        this.mPullView.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EnterForumAdView.a(b.this.eWv.getPageContext().getUniqueId(), b.this.eWv.getPageContext().getPageActivity());
            }
        });
        this.mPullView.setListPullRefreshListener(this.dpu);
        this.mPullView.ep(true);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.eWv.getUniqueId());
        }
        this.eai.setPullRefresh(this.mPullView);
        this.eVD = new ForumHeaderView(this.eWv.getFragmentActivity());
        this.eai.addHeaderView(this.eVD);
        this.epY = new View(this.eWv.getActivity());
        this.epY.setLayoutParams(new AbsListView.LayoutParams(-1, l.g(this.eWv.getActivity(), R.dimen.ds50)));
        this.epY.setBackgroundResource(R.color.cp_bg_line_d);
    }

    public void bL(View view) {
        this.eWA = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.eWA != null) {
            beL();
            this.eWA.setTag(this.eWv.getUniqueId());
            this.eWA.setAdData();
            this.eWA.setEventCenter(this.eQn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beL() {
        if (this.eWA != null) {
            ViewGroup.LayoutParams layoutParams = this.eWA.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.eQU ? 0 : (this.eWG + this.eWH) - dimensionPixelOffset, 0, 0);
                this.eWA.setLayoutParams(layoutParams2);
                this.eWA.setAdViewHeight(layoutParams2.height - dimensionPixelOffset);
            }
        }
    }

    public void beM() {
        this.eQU = true;
        beL();
        qq(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.nI());
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eWJ);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.eWJ, 3000L);
    }

    private void qq(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eai.getLayoutParams();
        marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + i + this.eai.getResources().getDimensionPixelOffset(R.dimen.tbds140);
        this.eai.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beN() {
        this.eQU = false;
        beL();
        qq(0);
        if (this.eWI) {
            this.eai.completePullRefreshPostDelayed(0L);
        }
        this.eWI = false;
    }

    public void bM(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(this.eWv.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.eVD != null) {
                        b.this.eVD.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.qx(this.eWv.getString(R.string.neterror));
        this.mRootView = view;
        int dimensionPixelSize = this.eWv.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize += UtilHelper.getStatusBarHeight();
        }
        this.refreshView.kF(dimensionPixelSize);
        this.refreshView.attachView(view, false);
        this.refreshView.asB();
        this.eai.setVisibility(8);
        if (this.eWv.bdF() != null) {
            this.eWv.bdF().bdT();
            this.eWv.bdF().bdU();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.eai.setVisibility(0);
        if (this.eWv.bdF() != null) {
            this.eWv.bdF().bdT();
            this.eWv.bdF().bdU();
        }
    }

    public boolean isEmpty() {
        return v.aa(this.eWy);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.eWy.remove(fVar);
        i(this.eWy, z);
        notifyDataSetChanged();
    }

    public com.baidu.tbadk.m.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView beO() {
        return this.eai;
    }

    public void startPullRefresh() {
        this.eai.startPullRefresh();
    }

    public void oy() {
        if (this.eQU) {
            this.eWI = true;
            return;
        }
        this.eWI = false;
        this.eai.completePullRefreshPostDelayed(0L);
    }

    public void notifyDataSetChanged() {
        this.eWw.notifyDataSetChanged();
    }

    public void i(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.eWA.setAdData();
        this.eWy = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
        dVar.setType(4);
        arrayList.add(dVar);
        arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), !v.aa(list)));
        arrayList.addAll(list);
        if (v.aa(list)) {
            com.baidu.tieba.enterForum.data.d dVar2 = new com.baidu.tieba.enterForum.data.d();
            dVar2.setType(3);
            arrayList.add(dVar2);
        }
        if (z) {
            com.baidu.tieba.enterForum.data.d dVar3 = new com.baidu.tieba.enterForum.data.d();
            dVar3.setType(5);
            arrayList.add(dVar3);
        }
        hideNoDataView();
        this.eWw.setData(arrayList);
        this.eVD.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.eai.removeFooterView(this.epY);
            this.eai.addFooterView(this.epY);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.eai.removeFooterView(this.epY);
        }
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.eVD != null) {
            this.eVD.onChangeSkinType();
        }
        if (this.eWx.ben() != null) {
            this.eWx.onChangeSkinType();
        }
        al.k(this.epY, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.eWF = cVar;
    }

    public void setSearchHint(String str) {
        if (this.eVD != null) {
            this.eVD.setSearchHint(str);
        }
    }

    public void beP() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("enter_forum_login_tip", true) && this.eWv != null && this.eWv.getActivity() != null && this.eWv.bdE() != null) {
            if (this.eWz == null) {
                this.eWz = new CommonTipView(this.eWv.getActivity());
            }
            this.eWz.setText(R.string.enter_forum_login_tip);
            this.eWz.show(this.eWv.bdE(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onPrimary() {
        if (this.eWv.isAdded() && this.eWv.isPrimary()) {
            this.eWA.setAdData();
            eWB = false;
            if (this.eWw != null) {
                this.eWw.onPrimary();
                if (this.eai != null) {
                    Object itemAtPosition = this.eai.getItemAtPosition(this.eai.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.eWw.bcX();
                    }
                }
            }
            if (this.isFirst) {
                startPullRefresh();
                this.isFirst = false;
                return;
            }
            return;
        }
        beQ();
    }

    public void onPause() {
        beQ();
    }

    public void onDestroy() {
        if (this.eWz != null) {
            this.eWz.onDestroy();
        }
        if (this.eWx != null) {
            this.eWx.onDestroy();
        }
        if (this.eWw != null) {
            this.eWw.onDestroy();
        }
        if (this.eWv != null && this.eWv.bdF() != null) {
            this.eWv.bdF().b(this.eWg);
        }
    }

    public void qb(int i) {
        this.eWw.qb(i);
    }

    public void bI(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.eWx.isShowing() && !v.aa(list)) {
            this.eWx.bE(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eWw != null) {
            this.eWw.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bcW() {
        if (this.eWw == null) {
            return false;
        }
        return this.eWw.bcW();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !eWB && this.eWv.getActivity() != null && this.eWv.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bdm() != 0 && !com.baidu.tbadk.core.sharedPref.b.agM().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.eWC = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.agM().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.eWC = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                eWB = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).X(0).U(true).V(false).T(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.11
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.eWC);
                        b.this.eWv.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hJ() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hK() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return 0;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return 0;
                    }
                });
                dVar2.b(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                    }
                });
                this.eGR = dVar2.hL();
                this.eGR.R(false);
                this.eGR.S(true);
                this.eGR.n(this.eWv.getActivity());
                if (this.eWC == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.eWC == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.eGR != null) {
                            b.this.eGR.dismiss();
                            b.this.eGR = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void beQ() {
        if (this.eGR != null) {
            this.eGR.dismiss();
            this.eGR = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eQs = bVar;
        if (this.eWw != null) {
            this.eWw.setAdState(bVar);
        }
        if (this.eVD != null) {
            this.eVD.setAdState(bVar);
        }
    }

    public void jl(boolean z) {
        if (this.eWE != z) {
            this.eWE = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eai.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.eai.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.eai.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.eai.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.eWA != null) {
            this.eWA.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.eWA != null) {
            this.eWA.setRecentlyIsShow(z);
        }
    }
}
