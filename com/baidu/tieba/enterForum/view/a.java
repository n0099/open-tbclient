package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
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
    private ViewEventCenter cOZ;
    private final EnterForumFragment cRq;
    private com.baidu.tieba.enterForum.a.a cRr;
    private ForumHeaderView cRs;
    private com.baidu.tieba.enterForum.model.c cRt;
    private com.baidu.tieba.enterForum.multiConcern.a cRu;
    private boolean cRv;
    private List<f> cRw;
    private CommonTipView cRx;
    private BdListView cgg;
    private View mFooterView;
    private h mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.cRq = enterForumFragment;
        this.cOZ = viewEventCenter;
        this.cRt = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.cRu = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        ap(view);
        this.cRr = new com.baidu.tieba.enterForum.a.a(this.cRq.getPageContext(), this.cOZ, recentlyVisitedForumModel);
        this.cgg.setAdapter((ListAdapter) this.cRr);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ap(View view) {
        this.cgg = (BdListView) view.findViewById(d.g.listview);
        this.cgg.setVerticalScrollBarEnabled(false);
        this.mPullView = new h(this.cRq.getPageContext());
        this.mPullView.setTag(this.cRq.getUniqueId());
        this.cgg.setPullRefresh(this.mPullView);
        this.cRs = new ForumHeaderView(this.cRq.getFragmentActivity());
        this.cRs.setEventCenter(this.cOZ);
        this.cgg.addHeaderView(this.cRs);
        BdListViewHelper.a(this.cRq.getPageContext().getPageActivity(), this.cgg, BdListViewHelper.HeadType.DEFAULT);
        this.mFooterView = new View(this.cRq.getActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, l.e(this.cRq.getActivity(), d.e.ds0)));
    }

    public View aoo() {
        this.cRs.jB(l.e(this.cRq.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.cRq.getPageContext().getPageActivity(), this.cgg, BdListViewHelper.HeadType.TIP);
    }

    public void ao(View view) {
        this.cRs.jB(l.e(this.cRq.getPageContext().getPageActivity(), d.e.ds10));
        this.cgg.removeHeaderView(view);
    }

    public void aq(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.cRq.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.hideNoDataView();
                    if (a.this.cRs != null) {
                        a.this.cRs.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.fg(this.cRq.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(this.cRq.getString(d.k.neterror));
        this.mRootView = view;
        this.refreshView.d(view, true);
        this.refreshView.Jp();
        this.cgg.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.Q(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cgg.setVisibility(0);
    }

    public boolean isEmpty() {
        return w.A(this.cRw);
    }

    public void b(f fVar) {
        this.cRt.b(fVar);
    }

    public boolean aot() {
        return this.cRv;
    }

    public BdListView aoO() {
        return this.cgg;
    }

    public void aoP() {
        aW(this.cRt.getDataList());
    }

    public void jz(final int i) {
        this.cRv = true;
        if (this.cRt.aoJ() == null) {
            this.cRt.createView();
            this.cRt.aoJ().setVisibility(8);
        }
        ForumEditView aoJ = this.cRt.aoJ();
        aoJ.onChangeSkinType(this.cRq.getPageContext());
        if (aoJ.getParent() == null && this.cRq.aol() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cRq.aof().getId());
            this.cRq.aof().addView(aoJ);
            this.cRq.aok();
        }
        this.cRt.aT(this.cRw);
        e.im().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.jA(i);
                e.im().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cRt.aoJ() != null) {
                            a.this.cRt.aoJ().setVisibility(0);
                            a.this.cgg.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean anQ() {
        if (this.cRr != null) {
            return this.cRr.anQ();
        }
        return false;
    }

    public void aoQ() {
        this.cRv = false;
        this.cgg.setVisibility(0);
        if (this.cRt.aoJ() != null && this.cRq.aof() != null) {
            this.cRq.aof().removeView(this.cRt.aoJ());
            this.cRt.aoJ().setVisibility(8);
        }
        this.cRq.aok();
    }

    public void aoR() {
        this.cRv = true;
        this.cgg.setVisibility(8);
        if (this.cRt.aoJ() != null) {
            this.cRt.aoJ().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jA(int i) {
        if (this.cRt.aoJ() != null && this.cgg != null && this.cgg.getChildCount() > 0) {
            int firstVisiblePosition = (this.cgg.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cgg.getChildAt(0);
            this.cRt.aoJ().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cgg.startPullRefresh();
    }

    public void nW() {
        this.cgg.completePullRefreshPostDelayed(2000L);
    }

    public List<f> aoS() {
        return this.cRw;
    }

    public List<f> aoT() {
        List<f> dataList = this.cRt.getDataList();
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
        this.cRr.notifyDataSetChanged();
    }

    public void aW(List<f> list) {
        this.cRw = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!w.A(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.cRq.getPageContext().getResources().getString(d.k.my_attention_bar)));
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
        this.cRr.setData(arrayList);
        if (this.cRv) {
            this.cgg.setVisibility(8);
            return;
        }
        aoQ();
        this.cRs.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cgg.removeFooterView(this.mFooterView);
            this.cgg.addFooterView(this.mFooterView);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cgg.removeFooterView(this.mFooterView);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.cRs != null) {
            this.cRs.onChangeSkinType(this.cRq.getPageContext());
        }
        if (this.cRt.aoJ() != null && this.cRt.aoJ().getVisibility() == 0) {
            this.cRt.onChangeSkinType(this.cRq.getPageContext());
        }
        if (this.cRu.aoN() != null) {
            this.cRu.onChangeSkinType();
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cRs != null) {
            this.cRs.setSearchHint(str);
        }
    }

    public void aoU() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cRx == null) {
                this.cRx = new CommonTipView(this.cRq.getActivity());
            }
            this.cRx.setText(d.k.enter_forum_login_tip);
            this.cRx.show(this.cRq.aof(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cRx != null) {
            this.cRx.onDestroy();
        }
        if (this.cRu != null) {
            this.cRu.onDestroy();
        }
        if (this.cRr != null) {
            this.cRr.onDestroy();
        }
    }

    public void aX(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cRu.isShowing() && !w.A(list)) {
            this.cRu.aV(list);
        }
    }
}
