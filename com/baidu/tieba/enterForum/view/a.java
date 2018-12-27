package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdListView cCh;
    private View def;
    private ViewEventCenter dqs;
    private final EnterForumFragment dsD;
    private com.baidu.tieba.enterForum.a.a dsE;
    private ForumHeaderView dsF;
    private com.baidu.tieba.enterForum.model.c dsG;
    private com.baidu.tieba.enterForum.multiConcern.a dsH;
    private boolean dsI;
    private List<f> dsJ;
    private CommonTipView dsK;
    private k mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.dsD = enterForumFragment;
        this.dqs = viewEventCenter;
        this.dsG = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.dsH = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        aL(view);
        this.dsE = new com.baidu.tieba.enterForum.a.a(this.dsD.getPageContext(), this.dqs, recentlyVisitedForumModel);
        this.cCh.setAdapter((ListAdapter) this.dsE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aL(View view) {
        this.cCh = (BdListView) view.findViewById(e.g.listview);
        this.cCh.setVerticalScrollBarEnabled(false);
        this.mPullView = new k(this.dsD.getPageContext());
        this.mPullView.setTag(this.dsD.getUniqueId());
        this.cCh.setPullRefresh(this.mPullView);
        this.dsF = new ForumHeaderView(this.dsD.getFragmentActivity());
        this.dsF.setEventCenter(this.dqs);
        this.cCh.addHeaderView(this.dsF);
        BdListViewHelper.a(this.dsD.getPageContext().getPageActivity(), this.cCh, BdListViewHelper.HeadType.DEFAULT);
        this.def = new View(this.dsD.getActivity());
        this.def.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(this.dsD.getActivity(), e.C0210e.ds0)));
    }

    public View awa() {
        this.dsF.lE(l.h(this.dsD.getPageContext().getPageActivity(), e.C0210e.ds20));
        return BdListViewHelper.a(this.dsD.getPageContext().getPageActivity(), this.cCh, BdListViewHelper.HeadType.TIP);
    }

    public void aK(View view) {
        this.dsF.lE(l.h(this.dsD.getPageContext().getPageActivity(), e.C0210e.ds10));
        this.cCh.removeHeaderView(view);
    }

    public void aM(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.dsD.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.hideNoDataView();
                    if (a.this.dsF != null) {
                        a.this.dsF.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.ge(this.dsD.getPageContext().getContext().getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.refreshView.io(this.dsD.getString(e.j.neterror));
        this.mRootView = view;
        this.refreshView.attachView(view, true);
        this.refreshView.NM();
        this.cCh.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cCh.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.I(this.dsJ);
    }

    public void b(f fVar) {
        this.dsG.b(fVar);
    }

    public boolean awf() {
        return this.dsI;
    }

    public BdListView awy() {
        return this.cCh;
    }

    public void awz() {
        bn(this.dsG.getDataList());
    }

    public void lC(final int i) {
        this.dsI = true;
        if (this.dsG.awt() == null) {
            this.dsG.createView();
            this.dsG.awt().setVisibility(8);
        }
        ForumEditView awt = this.dsG.awt();
        awt.onChangeSkinType(this.dsD.getPageContext());
        if (awt.getParent() == null && this.dsD.avX() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.dsD.avR().getId());
            this.dsD.avR().addView(awt);
            this.dsD.avW();
        }
        this.dsG.bk(this.dsJ);
        com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.lD(i);
                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.dsG.awt() != null) {
                            a.this.dsG.awt().setVisibility(0);
                            a.this.cCh.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean avB() {
        if (this.dsE != null) {
            return this.dsE.avB();
        }
        return false;
    }

    public void awA() {
        this.dsI = false;
        this.cCh.setVisibility(0);
        if (this.dsG.awt() != null && this.dsD.avR() != null) {
            this.dsD.avR().removeView(this.dsG.awt());
            this.dsG.awt().setVisibility(8);
        }
        this.dsD.avW();
    }

    public void awB() {
        this.dsI = true;
        this.cCh.setVisibility(8);
        if (this.dsG.awt() != null) {
            this.dsG.awt().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD(int i) {
        if (this.dsG.awt() != null && this.cCh != null && this.cCh.getChildCount() > 0) {
            int firstVisiblePosition = (this.cCh.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cCh.getChildAt(0);
            this.dsG.awt().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cCh.startPullRefresh();
    }

    public void pg() {
        this.cCh.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public List<f> awC() {
        return this.dsJ;
    }

    public List<f> awD() {
        List<f> dataList = this.dsG.getDataList();
        f fVar = (f) v.d(dataList, 0);
        if (fVar != null && fVar.getType() == 1) {
            v.e(dataList, 0);
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
        this.dsE.notifyDataSetChanged();
    }

    public void bn(List<f> list) {
        this.dsJ = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!v.I(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.dsD.getPageContext().getResources().getString(e.j.my_attention_bar)));
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
        this.dsE.setData(arrayList);
        if (this.dsI) {
            this.cCh.setVisibility(8);
            return;
        }
        awA();
        this.dsF.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cCh.removeFooterView(this.def);
            this.cCh.addFooterView(this.def);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cCh.removeFooterView(this.def);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dsF != null) {
            this.dsF.onChangeSkinType(this.dsD.getPageContext());
        }
        if (this.dsG.awt() != null && this.dsG.awt().getVisibility() == 0) {
            this.dsG.onChangeSkinType(this.dsD.getPageContext());
        }
        if (this.dsH.awx() != null) {
            this.dsH.onChangeSkinType();
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.dsF != null) {
            this.dsF.setSearchHint(str);
        }
    }

    public void awE() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.dsK == null) {
                this.dsK = new CommonTipView(this.dsD.getActivity());
            }
            this.dsK.setText(e.j.enter_forum_login_tip);
            this.dsK.show(this.dsD.avR(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.dsK != null) {
            this.dsK.onDestroy();
        }
        if (this.dsH != null) {
            this.dsH.onDestroy();
        }
    }

    public void bo(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.dsH.isShowing() && !v.I(list)) {
            this.dsH.bm(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dsE != null) {
            this.dsE.setPageUniqueId(bdUniqueId);
        }
    }
}
