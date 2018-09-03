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
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.f;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private View cFo;
    private ViewEventCenter cRF;
    private final EnterForumFragment cTZ;
    private com.baidu.tieba.enterForum.a.a cUa;
    private ForumHeaderView cUb;
    private com.baidu.tieba.enterForum.model.c cUc;
    private com.baidu.tieba.enterForum.multiConcern.a cUd;
    private boolean cUe;
    private List<f> cUf;
    private CommonTipView cUg;
    private BdListView chM;
    private h mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.cTZ = enterForumFragment;
        this.cRF = viewEventCenter;
        this.cUc = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.cUd = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        as(view);
        this.cUa = new com.baidu.tieba.enterForum.a.a(this.cTZ.getPageContext(), this.cRF, recentlyVisitedForumModel);
        this.chM.setAdapter((ListAdapter) this.cUa);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void as(View view) {
        this.chM = (BdListView) view.findViewById(f.g.listview);
        this.chM.setVerticalScrollBarEnabled(false);
        this.mPullView = new h(this.cTZ.getPageContext());
        this.mPullView.setTag(this.cTZ.getUniqueId());
        this.chM.setPullRefresh(this.mPullView);
        this.cUb = new ForumHeaderView(this.cTZ.getFragmentActivity());
        this.cUb.setEventCenter(this.cRF);
        this.chM.addHeaderView(this.cUb);
        BdListViewHelper.a(this.cTZ.getPageContext().getPageActivity(), this.chM, BdListViewHelper.HeadType.DEFAULT);
        this.cFo = new View(this.cTZ.getActivity());
        this.cFo.setLayoutParams(new AbsListView.LayoutParams(-1, l.f(this.cTZ.getActivity(), f.e.ds0)));
    }

    public View aoO() {
        this.cUb.jM(l.f(this.cTZ.getPageContext().getPageActivity(), f.e.ds20));
        return BdListViewHelper.a(this.cTZ.getPageContext().getPageActivity(), this.chM, BdListViewHelper.HeadType.TIP);
    }

    public void ar(View view) {
        this.cUb.jM(l.f(this.cTZ.getPageContext().getPageActivity(), f.e.ds10));
        this.chM.removeHeaderView(view);
    }

    public void at(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.cTZ.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.hideNoDataView();
                    if (a.this.cUb != null) {
                        a.this.cUb.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.fg(this.cTZ.getPageContext().getContext().getResources().getDimensionPixelSize(f.e.ds280));
        this.refreshView.hk(this.cTZ.getString(f.j.neterror));
        this.mRootView = view;
        this.refreshView.c(view, true);
        this.refreshView.Jk();
        this.chM.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.Q(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.chM.setVisibility(0);
    }

    public boolean isEmpty() {
        return w.z(this.cUf);
    }

    public void b(com.baidu.tieba.enterForum.data.f fVar) {
        this.cUc.b(fVar);
    }

    public boolean aoT() {
        return this.cUe;
    }

    public BdListView app() {
        return this.chM;
    }

    public void apq() {
        aV(this.cUc.getDataList());
    }

    public void jK(final int i) {
        this.cUe = true;
        if (this.cUc.apk() == null) {
            this.cUc.createView();
            this.cUc.apk().setVisibility(8);
        }
        ForumEditView apk = this.cUc.apk();
        apk.onChangeSkinType(this.cTZ.getPageContext());
        if (apk.getParent() == null && this.cTZ.aoL() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cTZ.aoF().getId());
            this.cTZ.aoF().addView(apk);
            this.cTZ.aoK();
        }
        this.cUc.aS(this.cUf);
        e.in().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.jL(i);
                e.in().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cUc.apk() != null) {
                            a.this.cUc.apk().setVisibility(0);
                            a.this.chM.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean aop() {
        if (this.cUa != null) {
            return this.cUa.aop();
        }
        return false;
    }

    public void apr() {
        this.cUe = false;
        this.chM.setVisibility(0);
        if (this.cUc.apk() != null && this.cTZ.aoF() != null) {
            this.cTZ.aoF().removeView(this.cUc.apk());
            this.cUc.apk().setVisibility(8);
        }
        this.cTZ.aoK();
    }

    public void aps() {
        this.cUe = true;
        this.chM.setVisibility(8);
        if (this.cUc.apk() != null) {
            this.cUc.apk().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jL(int i) {
        if (this.cUc.apk() != null && this.chM != null && this.chM.getChildCount() > 0) {
            int firstVisiblePosition = (this.chM.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.chM.getChildAt(0);
            this.cUc.apk().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.chM.startPullRefresh();
    }

    public void nV() {
        this.chM.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.data.f> apt() {
        return this.cUf;
    }

    public List<com.baidu.tieba.enterForum.data.f> apu() {
        List<com.baidu.tieba.enterForum.data.f> dataList = this.cUc.getDataList();
        com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) w.d(dataList, 0);
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
        this.cUa.notifyDataSetChanged();
    }

    public void aV(List<com.baidu.tieba.enterForum.data.f> list) {
        this.cUf = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!w.z(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.cTZ.getPageContext().getResources().getString(f.j.my_attention_bar)));
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
        this.cUa.setData(arrayList);
        if (this.cUe) {
            this.chM.setVisibility(8);
            return;
        }
        apr();
        this.cUb.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.chM.removeFooterView(this.cFo);
            this.chM.addFooterView(this.cFo);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.chM.removeFooterView(this.cFo);
        }
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        if (this.cUb != null) {
            this.cUb.onChangeSkinType(this.cTZ.getPageContext());
        }
        if (this.cUc.apk() != null && this.cUc.apk().getVisibility() == 0) {
            this.cUc.onChangeSkinType(this.cTZ.getPageContext());
        }
        if (this.cUd.apo() != null) {
            this.cUd.onChangeSkinType();
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cUb != null) {
            this.cUb.setSearchHint(str);
        }
    }

    public void apv() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cUg == null) {
                this.cUg = new CommonTipView(this.cTZ.getActivity());
            }
            this.cUg.setText(f.j.enter_forum_login_tip);
            this.cUg.show(this.cTZ.aoF(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cUg != null) {
            this.cUg.onDestroy();
        }
        if (this.cUd != null) {
            this.cUd.onDestroy();
        }
        if (this.cUa != null) {
            this.cUa.onDestroy();
        }
    }

    public void aW(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cUd.isShowing() && !w.z(list)) {
            this.cUd.aU(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cUa != null) {
            this.cUa.setPageUniqueId(bdUniqueId);
        }
    }
}
