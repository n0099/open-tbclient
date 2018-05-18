package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdListView bVT;
    private ViewEventCenter cHX;
    private final EnterForumFragment cKm;
    private com.baidu.tieba.enterForum.a.a cKn;
    private ForumHeaderView cKo;
    private com.baidu.tieba.enterForum.model.c cKp;
    private com.baidu.tieba.enterForum.multiConcern.a cKq;
    private boolean cKr;
    private List<f> cKs;
    private CommonTipView cKt;
    private View mFooterView;
    private com.baidu.tbadk.core.view.f mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view2, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.cKm = enterForumFragment;
        this.cHX = viewEventCenter;
        this.cKp = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.cKq = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().pU(), viewEventCenter);
        an(view2);
        this.cKn = new com.baidu.tieba.enterForum.a.a(this.cKm.getPageContext(), this.cHX, recentlyVisitedForumModel);
        this.bVT.setAdapter((ListAdapter) this.cKn);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void an(View view2) {
        this.bVT = (BdListView) view2.findViewById(d.g.listview);
        this.bVT.setVerticalScrollBarEnabled(false);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.cKm.getPageContext());
        this.mPullView.setTag(this.cKm.getUniqueId());
        this.bVT.setPullRefresh(this.mPullView);
        this.cKo = new ForumHeaderView(this.cKm.getFragmentActivity());
        this.cKo.setEventCenter(this.cHX);
        this.bVT.addHeaderView(this.cKo);
        BdListViewHelper.a(this.cKm.getPageContext().getPageActivity(), this.bVT, BdListViewHelper.HeadType.DEFAULT);
        this.mFooterView = new View(this.cKm.getActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, l.e(this.cKm.getActivity(), d.e.ds0)));
    }

    public View akN() {
        this.cKo.jA(l.e(this.cKm.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.cKm.getPageContext().getPageActivity(), this.bVT, BdListViewHelper.HeadType.TIP);
    }

    public void am(View view2) {
        this.cKo.jA(l.e(this.cKm.getPageContext().getPageActivity(), d.e.ds10));
        this.bVT.removeHeaderView(view2);
    }

    public void ao(View view2) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.cKm.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    a.this.hideNoDataView();
                    if (a.this.cKo != null) {
                        a.this.cKo.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.fb(this.cKm.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(this.cKm.getString(d.k.neterror));
        this.mRootView = view2;
        this.refreshView.d(view2, true);
        this.refreshView.Fs();
        this.bVT.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.P(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.bVT.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.w(this.cKs);
    }

    public void b(f fVar) {
        this.cKp.b(fVar);
    }

    public boolean akS() {
        return this.cKr;
    }

    public BdListView alo() {
        return this.bVT;
    }

    public void alp() {
        aS(this.cKp.getDataList());
    }

    public void jy(final int i) {
        this.cKr = true;
        if (this.cKp.alj() == null) {
            this.cKp.createView();
            this.cKp.alj().setVisibility(8);
        }
        ForumEditView alj = this.cKp.alj();
        alj.onChangeSkinType(this.cKm.getPageContext());
        if (alj.getParent() == null && this.cKm.akK() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cKm.akE().getId());
            this.cKm.akE().addView(alj);
            this.cKm.akJ();
        }
        this.cKp.aP(this.cKs);
        e.fw().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.jz(i);
                e.fw().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cKp.alj() != null) {
                            a.this.cKp.alj().setVisibility(0);
                            a.this.bVT.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean akq() {
        if (this.cKn != null) {
            return this.cKn.akq();
        }
        return false;
    }

    public void alq() {
        this.cKr = false;
        this.bVT.setVisibility(0);
        if (this.cKp.alj() != null && this.cKm.akE() != null) {
            this.cKm.akE().removeView(this.cKp.alj());
            this.cKp.alj().setVisibility(8);
        }
        this.cKm.akJ();
    }

    public void alr() {
        this.cKr = true;
        this.bVT.setVisibility(8);
        if (this.cKp.alj() != null) {
            this.cKp.alj().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jz(int i) {
        if (this.cKp.alj() != null && this.bVT != null && this.bVT.getChildCount() > 0) {
            int firstVisiblePosition = (this.bVT.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bVT.getChildAt(0);
            this.cKp.alj().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bVT.startPullRefresh();
    }

    public void lg() {
        this.bVT.completePullRefreshPostDelayed(2000L);
    }

    public List<f> als() {
        return this.cKs;
    }

    public List<f> alt() {
        List<f> dataList = this.cKp.getDataList();
        f fVar = (f) v.c(dataList, 0);
        if (fVar != null && fVar.getType() == 1) {
            v.d(dataList, 0);
        }
        return dataList;
    }

    private List<com.baidu.tieba.enterForum.data.c> a(List list, boolean z, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int size = list.size();
        int i3 = 1;
        int i4 = 0;
        while (i4 < size && (i2 <= 0 || i3 < i2 * 2)) {
            com.baidu.tieba.enterForum.data.e eVar = new com.baidu.tieba.enterForum.data.e();
            com.baidu.tieba.enterForum.data.e eVar2 = new com.baidu.tieba.enterForum.data.e();
            if (i3 < size) {
                eVar = (com.baidu.tieba.enterForum.data.e) list.get(i4);
                eVar2 = (com.baidu.tieba.enterForum.data.e) list.get(i3);
                eVar.setType(i);
                eVar2.setType(i);
            } else if (i4 < size) {
                eVar = (com.baidu.tieba.enterForum.data.e) list.get(i4);
                eVar.setType(i);
                eVar2.setType(2);
            }
            arrayList.add(new com.baidu.tieba.enterForum.data.a(eVar, eVar2));
            int i5 = i4 + 2;
            i3 = i5 + 1;
            i4 = i5;
        }
        return arrayList;
    }

    public void notifyDataSetChanged() {
        this.cKn.notifyDataSetChanged();
    }

    public void aS(List<f> list) {
        this.cKs = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!v.w(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.cKm.getPageContext().getResources().getString(d.k.my_attention_bar)));
            arrayList.addAll(a);
        } else {
            com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
            cVar2.setType(3);
            arrayList.add(cVar2);
        }
        com.baidu.tieba.enterForum.data.c cVar3 = new com.baidu.tieba.enterForum.data.c();
        cVar3.setType(2);
        arrayList.add(cVar3);
        hideNoDataView();
        this.cKn.setData(arrayList);
        if (this.cKr) {
            this.bVT.setVisibility(8);
            return;
        }
        alq();
        this.cKo.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bVT.removeFooterView(this.mFooterView);
            this.bVT.addFooterView(this.mFooterView);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bVT.removeFooterView(this.mFooterView);
        }
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.cKo != null) {
            this.cKo.onChangeSkinType(this.cKm.getPageContext());
        }
        if (this.cKp.alj() != null && this.cKp.alj().getVisibility() == 0) {
            this.cKp.onChangeSkinType(this.cKm.getPageContext());
        }
        if (this.cKq.aln() != null) {
            this.cKq.onChangeSkinType();
        }
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cKo != null) {
            this.cKo.setSearchHint(str);
        }
    }

    public void alu() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cKt == null) {
                this.cKt = new CommonTipView(this.cKm.getActivity());
            }
            this.cKt.setText(d.k.enter_forum_login_tip);
            this.cKt.show(this.cKm.akE(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cKt != null) {
            this.cKt.onDestroy();
        }
        if (this.cKq != null) {
            this.cKq.onDestroy();
        }
        if (this.cKn != null) {
            this.cKn.onDestroy();
        }
    }

    public void aT(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cKq.isShowing() && !v.w(list)) {
            this.cKq.aR(list);
        }
    }
}
