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
    private BdListView bVg;
    private ViewEventCenter cGR;
    private final EnterForumFragment cJg;
    private com.baidu.tieba.enterForum.a.a cJh;
    private ForumHeaderView cJi;
    private com.baidu.tieba.enterForum.model.c cJj;
    private com.baidu.tieba.enterForum.multiConcern.a cJk;
    private boolean cJl;
    private List<f> cJm;
    private CommonTipView cJn;
    private View mFooterView;
    private com.baidu.tbadk.core.view.f mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view2, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.cJg = enterForumFragment;
        this.cGR = viewEventCenter;
        this.cJj = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.cJk = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().pV(), viewEventCenter);
        an(view2);
        this.cJh = new com.baidu.tieba.enterForum.a.a(this.cJg.getPageContext(), this.cGR, recentlyVisitedForumModel);
        this.bVg.setAdapter((ListAdapter) this.cJh);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void an(View view2) {
        this.bVg = (BdListView) view2.findViewById(d.g.listview);
        this.bVg.setVerticalScrollBarEnabled(false);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.cJg.getPageContext());
        this.mPullView.setTag(this.cJg.getUniqueId());
        this.bVg.setPullRefresh(this.mPullView);
        this.cJi = new ForumHeaderView(this.cJg.getFragmentActivity());
        this.cJi.setEventCenter(this.cGR);
        this.bVg.addHeaderView(this.cJi);
        BdListViewHelper.a(this.cJg.getPageContext().getPageActivity(), this.bVg, BdListViewHelper.HeadType.DEFAULT);
        this.mFooterView = new View(this.cJg.getActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, l.e(this.cJg.getActivity(), d.e.ds0)));
    }

    public View akN() {
        this.cJi.jB(l.e(this.cJg.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.cJg.getPageContext().getPageActivity(), this.bVg, BdListViewHelper.HeadType.TIP);
    }

    public void am(View view2) {
        this.cJi.jB(l.e(this.cJg.getPageContext().getPageActivity(), d.e.ds10));
        this.bVg.removeHeaderView(view2);
    }

    public void ao(View view2) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.cJg.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    a.this.hideNoDataView();
                    if (a.this.cJi != null) {
                        a.this.cJi.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.fa(this.cJg.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(this.cJg.getString(d.k.neterror));
        this.mRootView = view2;
        this.refreshView.d(view2, true);
        this.refreshView.Fu();
        this.bVg.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.P(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.bVg.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.w(this.cJm);
    }

    public void b(f fVar) {
        this.cJj.b(fVar);
    }

    public boolean akS() {
        return this.cJl;
    }

    public BdListView alo() {
        return this.bVg;
    }

    public void alp() {
        aP(this.cJj.getDataList());
    }

    public void jz(final int i) {
        this.cJl = true;
        if (this.cJj.alj() == null) {
            this.cJj.createView();
            this.cJj.alj().setVisibility(8);
        }
        ForumEditView alj = this.cJj.alj();
        alj.onChangeSkinType(this.cJg.getPageContext());
        if (alj.getParent() == null && this.cJg.akK() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cJg.akE().getId());
            this.cJg.akE().addView(alj);
            this.cJg.akJ();
        }
        this.cJj.aM(this.cJm);
        e.fw().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.jA(i);
                e.fw().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cJj.alj() != null) {
                            a.this.cJj.alj().setVisibility(0);
                            a.this.bVg.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean akq() {
        if (this.cJh != null) {
            return this.cJh.akq();
        }
        return false;
    }

    public void alq() {
        this.cJl = false;
        this.bVg.setVisibility(0);
        if (this.cJj.alj() != null && this.cJg.akE() != null) {
            this.cJg.akE().removeView(this.cJj.alj());
            this.cJj.alj().setVisibility(8);
        }
        this.cJg.akJ();
    }

    public void alr() {
        this.cJl = true;
        this.bVg.setVisibility(8);
        if (this.cJj.alj() != null) {
            this.cJj.alj().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jA(int i) {
        if (this.cJj.alj() != null && this.bVg != null && this.bVg.getChildCount() > 0) {
            int firstVisiblePosition = (this.bVg.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bVg.getChildAt(0);
            this.cJj.alj().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bVg.startPullRefresh();
    }

    public void lh() {
        this.bVg.completePullRefreshPostDelayed(2000L);
    }

    public List<f> als() {
        return this.cJm;
    }

    public List<f> alt() {
        List<f> dataList = this.cJj.getDataList();
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
        this.cJh.notifyDataSetChanged();
    }

    public void aP(List<f> list) {
        this.cJm = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!v.w(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.cJg.getPageContext().getResources().getString(d.k.my_attention_bar)));
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
        this.cJh.setData(arrayList);
        if (this.cJl) {
            this.bVg.setVisibility(8);
            return;
        }
        alq();
        this.cJi.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bVg.removeFooterView(this.mFooterView);
            this.bVg.addFooterView(this.mFooterView);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bVg.removeFooterView(this.mFooterView);
        }
        if (this.mPullView != null) {
            this.mPullView.dv(i);
        }
        if (this.cJi != null) {
            this.cJi.onChangeSkinType(this.cJg.getPageContext());
        }
        if (this.cJj.alj() != null && this.cJj.alj().getVisibility() == 0) {
            this.cJj.onChangeSkinType(this.cJg.getPageContext());
        }
        if (this.cJk.aln() != null) {
            this.cJk.onChangeSkinType();
        }
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cJi != null) {
            this.cJi.setSearchHint(str);
        }
    }

    public void alu() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cJn == null) {
                this.cJn = new CommonTipView(this.cJg.getActivity());
            }
            this.cJn.setText(d.k.enter_forum_login_tip);
            this.cJn.show(this.cJg.akE(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cJn != null) {
            this.cJn.onDestroy();
        }
        if (this.cJk != null) {
            this.cJk.onDestroy();
        }
        if (this.cJh != null) {
            this.cJh.onDestroy();
        }
    }

    public void aQ(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cJk.isShowing() && !v.w(list)) {
            this.cJk.aO(list);
        }
    }
}
