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
    private BdListView bVd;
    private ViewEventCenter cGO;
    private final EnterForumFragment cJd;
    private com.baidu.tieba.enterForum.a.a cJe;
    private ForumHeaderView cJf;
    private com.baidu.tieba.enterForum.model.c cJg;
    private com.baidu.tieba.enterForum.multiConcern.a cJh;
    private boolean cJi;
    private List<f> cJj;
    private CommonTipView cJk;
    private View mFooterView;
    private com.baidu.tbadk.core.view.f mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view2, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.cJd = enterForumFragment;
        this.cGO = viewEventCenter;
        this.cJg = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.cJh = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().pV(), viewEventCenter);
        an(view2);
        this.cJe = new com.baidu.tieba.enterForum.a.a(this.cJd.getPageContext(), this.cGO, recentlyVisitedForumModel);
        this.bVd.setAdapter((ListAdapter) this.cJe);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void an(View view2) {
        this.bVd = (BdListView) view2.findViewById(d.g.listview);
        this.bVd.setVerticalScrollBarEnabled(false);
        this.mPullView = new com.baidu.tbadk.core.view.f(this.cJd.getPageContext());
        this.mPullView.setTag(this.cJd.getUniqueId());
        this.bVd.setPullRefresh(this.mPullView);
        this.cJf = new ForumHeaderView(this.cJd.getFragmentActivity());
        this.cJf.setEventCenter(this.cGO);
        this.bVd.addHeaderView(this.cJf);
        BdListViewHelper.a(this.cJd.getPageContext().getPageActivity(), this.bVd, BdListViewHelper.HeadType.DEFAULT);
        this.mFooterView = new View(this.cJd.getActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, l.e(this.cJd.getActivity(), d.e.ds0)));
    }

    public View akN() {
        this.cJf.jB(l.e(this.cJd.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.cJd.getPageContext().getPageActivity(), this.bVd, BdListViewHelper.HeadType.TIP);
    }

    public void am(View view2) {
        this.cJf.jB(l.e(this.cJd.getPageContext().getPageActivity(), d.e.ds10));
        this.bVd.removeHeaderView(view2);
    }

    public void ao(View view2) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.cJd.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    a.this.hideNoDataView();
                    if (a.this.cJf != null) {
                        a.this.cJf.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.fa(this.cJd.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(this.cJd.getString(d.k.neterror));
        this.mRootView = view2;
        this.refreshView.d(view2, true);
        this.refreshView.Fu();
        this.bVd.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.P(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.bVd.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.w(this.cJj);
    }

    public void b(f fVar) {
        this.cJg.b(fVar);
    }

    public boolean akS() {
        return this.cJi;
    }

    public BdListView alo() {
        return this.bVd;
    }

    public void alp() {
        aP(this.cJg.getDataList());
    }

    public void jz(final int i) {
        this.cJi = true;
        if (this.cJg.alj() == null) {
            this.cJg.createView();
            this.cJg.alj().setVisibility(8);
        }
        ForumEditView alj = this.cJg.alj();
        alj.onChangeSkinType(this.cJd.getPageContext());
        if (alj.getParent() == null && this.cJd.akK() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cJd.akE().getId());
            this.cJd.akE().addView(alj);
            this.cJd.akJ();
        }
        this.cJg.aM(this.cJj);
        e.fw().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.jA(i);
                e.fw().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cJg.alj() != null) {
                            a.this.cJg.alj().setVisibility(0);
                            a.this.bVd.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean akq() {
        if (this.cJe != null) {
            return this.cJe.akq();
        }
        return false;
    }

    public void alq() {
        this.cJi = false;
        this.bVd.setVisibility(0);
        if (this.cJg.alj() != null && this.cJd.akE() != null) {
            this.cJd.akE().removeView(this.cJg.alj());
            this.cJg.alj().setVisibility(8);
        }
        this.cJd.akJ();
    }

    public void alr() {
        this.cJi = true;
        this.bVd.setVisibility(8);
        if (this.cJg.alj() != null) {
            this.cJg.alj().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jA(int i) {
        if (this.cJg.alj() != null && this.bVd != null && this.bVd.getChildCount() > 0) {
            int firstVisiblePosition = (this.bVd.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bVd.getChildAt(0);
            this.cJg.alj().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bVd.startPullRefresh();
    }

    public void lh() {
        this.bVd.completePullRefreshPostDelayed(2000L);
    }

    public List<f> als() {
        return this.cJj;
    }

    public List<f> alt() {
        List<f> dataList = this.cJg.getDataList();
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
        this.cJe.notifyDataSetChanged();
    }

    public void aP(List<f> list) {
        this.cJj = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!v.w(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.cJd.getPageContext().getResources().getString(d.k.my_attention_bar)));
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
        this.cJe.setData(arrayList);
        if (this.cJi) {
            this.bVd.setVisibility(8);
            return;
        }
        alq();
        this.cJf.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bVd.removeFooterView(this.mFooterView);
            this.bVd.addFooterView(this.mFooterView);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bVd.removeFooterView(this.mFooterView);
        }
        if (this.mPullView != null) {
            this.mPullView.dv(i);
        }
        if (this.cJf != null) {
            this.cJf.onChangeSkinType(this.cJd.getPageContext());
        }
        if (this.cJg.alj() != null && this.cJg.alj().getVisibility() == 0) {
            this.cJg.onChangeSkinType(this.cJd.getPageContext());
        }
        if (this.cJh.aln() != null) {
            this.cJh.onChangeSkinType();
        }
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cJf != null) {
            this.cJf.setSearchHint(str);
        }
    }

    public void alu() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cJk == null) {
                this.cJk = new CommonTipView(this.cJd.getActivity());
            }
            this.cJk.setText(d.k.enter_forum_login_tip);
            this.cJk.show(this.cJd.akE(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cJk != null) {
            this.cJk.onDestroy();
        }
        if (this.cJh != null) {
            this.cJh.onDestroy();
        }
        if (this.cJe != null) {
            this.cJe.onDestroy();
        }
    }

    public void aQ(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cJh.isShowing() && !v.w(list)) {
            this.cJh.aO(list);
        }
    }
}
