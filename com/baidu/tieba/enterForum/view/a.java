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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
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
    private ViewEventCenter cRe;
    private final EnterForumFragment cTs;
    private com.baidu.tieba.enterForum.a.a cTt;
    private ForumHeaderView cTu;
    private com.baidu.tieba.enterForum.model.c cTv;
    private com.baidu.tieba.enterForum.multiConcern.a cTw;
    private boolean cTx;
    private List<f> cTy;
    private CommonTipView cTz;
    private BdListView cdW;
    private View mFooterView;
    private g mPullView;
    private View mRootView;
    private com.baidu.tbadk.j.g refreshView;

    public a(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.cTs = enterForumFragment;
        this.cRe = viewEventCenter;
        this.cTv = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.cTw = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().tq(), viewEventCenter);
        an(view);
        this.cTt = new com.baidu.tieba.enterForum.a.a(this.cTs.getPageContext(), this.cRe, recentlyVisitedForumModel);
        this.cdW.setAdapter((ListAdapter) this.cTt);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void an(View view) {
        this.cdW = (BdListView) view.findViewById(d.g.listview);
        this.cdW.setVerticalScrollBarEnabled(false);
        this.mPullView = new g(this.cTs.getPageContext());
        this.mPullView.setTag(this.cTs.getUniqueId());
        this.cdW.setPullRefresh(this.mPullView);
        this.cTu = new ForumHeaderView(this.cTs.getFragmentActivity());
        this.cTu.setEventCenter(this.cRe);
        this.cdW.addHeaderView(this.cTu);
        BdListViewHelper.a(this.cTs.getPageContext().getPageActivity(), this.cdW, BdListViewHelper.HeadType.DEFAULT);
        this.mFooterView = new View(this.cTs.getActivity());
        this.mFooterView.setLayoutParams(new AbsListView.LayoutParams(-1, l.e(this.cTs.getActivity(), d.e.ds0)));
    }

    public View aoT() {
        this.cTu.jD(l.e(this.cTs.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.cTs.getPageContext().getPageActivity(), this.cdW, BdListViewHelper.HeadType.TIP);
    }

    public void am(View view) {
        this.cTu.jD(l.e(this.cTs.getPageContext().getPageActivity(), d.e.ds10));
        this.cdW.removeHeaderView(view);
    }

    public void ao(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(this.cTs.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.hideNoDataView();
                    if (a.this.cTu != null) {
                        a.this.cTu.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.ff(this.cTs.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(this.cTs.getString(d.k.neterror));
        this.mRootView = view;
        this.refreshView.d(view, true);
        this.refreshView.IX();
        this.cdW.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.P(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cdW.setVisibility(0);
    }

    public boolean isEmpty() {
        return w.z(this.cTy);
    }

    public void b(f fVar) {
        this.cTv.b(fVar);
    }

    public boolean aoY() {
        return this.cTx;
    }

    public BdListView apu() {
        return this.cdW;
    }

    public void apv() {
        aV(this.cTv.getDataList());
    }

    public void jB(final int i) {
        this.cTx = true;
        if (this.cTv.app() == null) {
            this.cTv.createView();
            this.cTv.app().setVisibility(8);
        }
        ForumEditView app = this.cTv.app();
        app.onChangeSkinType(this.cTs.getPageContext());
        if (app.getParent() == null && this.cTs.aoQ() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cTs.aoK().getId());
            this.cTs.aoK().addView(app);
            this.cTs.aoP();
        }
        this.cTv.aS(this.cTy);
        e.im().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.jC(i);
                e.im().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cTv.app() != null) {
                            a.this.cTv.app().setVisibility(0);
                            a.this.cdW.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean aow() {
        if (this.cTt != null) {
            return this.cTt.aow();
        }
        return false;
    }

    public void apw() {
        this.cTx = false;
        this.cdW.setVisibility(0);
        if (this.cTv.app() != null && this.cTs.aoK() != null) {
            this.cTs.aoK().removeView(this.cTv.app());
            this.cTv.app().setVisibility(8);
        }
        this.cTs.aoP();
    }

    public void apx() {
        this.cTx = true;
        this.cdW.setVisibility(8);
        if (this.cTv.app() != null) {
            this.cTv.app().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jC(int i) {
        if (this.cTv.app() != null && this.cdW != null && this.cdW.getChildCount() > 0) {
            int firstVisiblePosition = (this.cdW.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cdW.getChildAt(0);
            this.cTv.app().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cdW.startPullRefresh();
    }

    public void nW() {
        this.cdW.completePullRefreshPostDelayed(2000L);
    }

    public List<f> apy() {
        return this.cTy;
    }

    public List<f> apz() {
        List<f> dataList = this.cTv.getDataList();
        f fVar = (f) w.c(dataList, 0);
        if (fVar != null && fVar.getType() == 1) {
            w.d(dataList, 0);
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
        this.cTt.notifyDataSetChanged();
    }

    public void aV(List<f> list) {
        this.cTy = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!w.z(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.cTs.getPageContext().getResources().getString(d.k.my_attention_bar)));
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
        this.cTt.setData(arrayList);
        if (this.cTx) {
            this.cdW.setVisibility(8);
            return;
        }
        apw();
        this.cTu.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cdW.removeFooterView(this.mFooterView);
            this.cdW.addFooterView(this.mFooterView);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cdW.removeFooterView(this.mFooterView);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        if (this.cTu != null) {
            this.cTu.onChangeSkinType(this.cTs.getPageContext());
        }
        if (this.cTv.app() != null && this.cTv.app().getVisibility() == 0) {
            this.cTv.onChangeSkinType(this.cTs.getPageContext());
        }
        if (this.cTw.apt() != null) {
            this.cTw.onChangeSkinType();
        }
    }

    public void a(f.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cTu != null) {
            this.cTu.setSearchHint(str);
        }
    }

    public void apA() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cTz == null) {
                this.cTz = new CommonTipView(this.cTs.getActivity());
            }
            this.cTz.setText(d.k.enter_forum_login_tip);
            this.cTz.show(this.cTs.aoK(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cTz != null) {
            this.cTz.onDestroy();
        }
        if (this.cTw != null) {
            this.cTw.onDestroy();
        }
        if (this.cTt != null) {
            this.cTt.onDestroy();
        }
    }

    public void aW(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cTw.isShowing() && !w.z(list)) {
            this.cTw.aU(list);
        }
    }
}
