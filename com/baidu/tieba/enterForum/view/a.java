package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.k.g;
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
    private View cFr;
    private ViewEventCenter cRI;
    private final EnterForumFragment cUd;
    private com.baidu.tieba.enterForum.a.a cUe;
    private ForumHeaderView cUf;
    private com.baidu.tieba.enterForum.model.c cUg;
    private com.baidu.tieba.enterForum.multiConcern.a cUh;
    private boolean cUi;
    private List<f> cUj;
    private CommonTipView cUk;
    private BdListView chP;
    private h mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.cUd = enterForumFragment;
        this.cRI = viewEventCenter;
        this.cUg = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.cUh = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        as(view);
        this.cUe = new com.baidu.tieba.enterForum.a.a(this.cUd.getPageContext(), this.cRI, recentlyVisitedForumModel);
        this.chP.setAdapter((ListAdapter) this.cUe);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void as(View view) {
        this.chP = (BdListView) view.findViewById(d.g.listview);
        this.chP.setVerticalScrollBarEnabled(false);
        this.mPullView = new h(this.cUd.getPageContext());
        this.mPullView.setTag(this.cUd.getUniqueId());
        this.chP.setPullRefresh(this.mPullView);
        this.cUf = new ForumHeaderView(this.cUd.getFragmentActivity());
        this.cUf.setEventCenter(this.cRI);
        this.chP.addHeaderView(this.cUf);
        BdListViewHelper.a(this.cUd.getPageContext().getPageActivity(), this.chP, BdListViewHelper.HeadType.DEFAULT);
        this.cFr = new View(this.cUd.getActivity());
        this.cFr.setLayoutParams(new AbsListView.LayoutParams(-1, l.f(this.cUd.getActivity(), d.e.ds0)));
    }

    public View aoO() {
        this.cUf.jN(l.f(this.cUd.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.cUd.getPageContext().getPageActivity(), this.chP, BdListViewHelper.HeadType.TIP);
    }

    public void ar(View view) {
        this.cUf.jN(l.f(this.cUd.getPageContext().getPageActivity(), d.e.ds10));
        this.chP.removeHeaderView(view);
    }

    public void at(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.cUd.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.hideNoDataView();
                    if (a.this.cUf != null) {
                        a.this.cUf.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.fh(this.cUd.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.hk(this.cUd.getString(d.j.neterror));
        this.mRootView = view;
        this.refreshView.c(view, true);
        this.refreshView.Jk();
        this.chP.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.Q(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.chP.setVisibility(0);
    }

    public boolean isEmpty() {
        return w.z(this.cUj);
    }

    public void b(f fVar) {
        this.cUg.b(fVar);
    }

    public boolean aoT() {
        return this.cUi;
    }

    public BdListView app() {
        return this.chP;
    }

    public void apq() {
        aV(this.cUg.getDataList());
    }

    public void jL(final int i) {
        this.cUi = true;
        if (this.cUg.apk() == null) {
            this.cUg.createView();
            this.cUg.apk().setVisibility(8);
        }
        ForumEditView apk = this.cUg.apk();
        apk.onChangeSkinType(this.cUd.getPageContext());
        if (apk.getParent() == null && this.cUd.aoL() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cUd.aoF().getId());
            this.cUd.aoF().addView(apk);
            this.cUd.aoK();
        }
        this.cUg.aS(this.cUj);
        e.in().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.jM(i);
                e.in().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cUg.apk() != null) {
                            a.this.cUg.apk().setVisibility(0);
                            a.this.chP.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean aop() {
        if (this.cUe != null) {
            return this.cUe.aop();
        }
        return false;
    }

    public void apr() {
        this.cUi = false;
        this.chP.setVisibility(0);
        if (this.cUg.apk() != null && this.cUd.aoF() != null) {
            this.cUd.aoF().removeView(this.cUg.apk());
            this.cUg.apk().setVisibility(8);
        }
        this.cUd.aoK();
    }

    public void aps() {
        this.cUi = true;
        this.chP.setVisibility(8);
        if (this.cUg.apk() != null) {
            this.cUg.apk().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jM(int i) {
        if (this.cUg.apk() != null && this.chP != null && this.chP.getChildCount() > 0) {
            int firstVisiblePosition = (this.chP.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.chP.getChildAt(0);
            this.cUg.apk().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.chP.startPullRefresh();
    }

    public void nY() {
        this.chP.completePullRefreshPostDelayed(2000L);
    }

    public List<f> apt() {
        return this.cUj;
    }

    public List<f> apu() {
        List<f> dataList = this.cUg.getDataList();
        f fVar = (f) w.d(dataList, 0);
        if (fVar != null && fVar.getType() == 1) {
            w.e(dataList, 0);
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
        this.cUe.notifyDataSetChanged();
    }

    public void aV(List<f> list) {
        this.cUj = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!w.z(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.cUd.getPageContext().getResources().getString(d.j.my_attention_bar)));
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
        this.cUe.setData(arrayList);
        if (this.cUi) {
            this.chP.setVisibility(8);
            return;
        }
        apr();
        this.cUf.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.chP.removeFooterView(this.cFr);
            this.chP.addFooterView(this.cFr);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.chP.removeFooterView(this.cFr);
        }
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        if (this.cUf != null) {
            this.cUf.onChangeSkinType(this.cUd.getPageContext());
        }
        if (this.cUg.apk() != null && this.cUg.apk().getVisibility() == 0) {
            this.cUg.onChangeSkinType(this.cUd.getPageContext());
        }
        if (this.cUh.apo() != null) {
            this.cUh.onChangeSkinType();
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cUf != null) {
            this.cUf.setSearchHint(str);
        }
    }

    public void apv() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cUk == null) {
                this.cUk = new CommonTipView(this.cUd.getActivity());
            }
            this.cUk.setText(d.j.enter_forum_login_tip);
            this.cUk.show(this.cUd.aoF(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cUk != null) {
            this.cUk.onDestroy();
        }
        if (this.cUh != null) {
            this.cUh.onDestroy();
        }
        if (this.cUe != null) {
            this.cUe.onDestroy();
        }
    }

    public void aW(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cUh.isShowing() && !w.z(list)) {
            this.cUh.aU(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cUe != null) {
            this.cUe.setPageUniqueId(bdUniqueId);
        }
    }
}
