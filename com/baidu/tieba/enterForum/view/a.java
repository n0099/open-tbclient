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
    private BdListView cBh;
    private View dbn;
    private ViewEventCenter dnB;
    private final EnterForumFragment dpN;
    private com.baidu.tieba.enterForum.a.a dpO;
    private ForumHeaderView dpP;
    private com.baidu.tieba.enterForum.model.c dpQ;
    private com.baidu.tieba.enterForum.multiConcern.a dpR;
    private boolean dpS;
    private List<f> dpT;
    private CommonTipView dpU;
    private k mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.dpN = enterForumFragment;
        this.dnB = viewEventCenter;
        this.dpQ = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.dpR = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        aI(view);
        this.dpO = new com.baidu.tieba.enterForum.a.a(this.dpN.getPageContext(), this.dnB, recentlyVisitedForumModel);
        this.cBh.setAdapter((ListAdapter) this.dpO);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aI(View view) {
        this.cBh = (BdListView) view.findViewById(e.g.listview);
        this.cBh.setVerticalScrollBarEnabled(false);
        this.mPullView = new k(this.dpN.getPageContext());
        this.mPullView.setTag(this.dpN.getUniqueId());
        this.cBh.setPullRefresh(this.mPullView);
        this.dpP = new ForumHeaderView(this.dpN.getFragmentActivity());
        this.dpP.setEventCenter(this.dnB);
        this.cBh.addHeaderView(this.dpP);
        BdListViewHelper.a(this.dpN.getPageContext().getPageActivity(), this.cBh, BdListViewHelper.HeadType.DEFAULT);
        this.dbn = new View(this.dpN.getActivity());
        this.dbn.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(this.dpN.getActivity(), e.C0210e.ds0)));
    }

    public View avl() {
        this.dpP.lr(l.h(this.dpN.getPageContext().getPageActivity(), e.C0210e.ds20));
        return BdListViewHelper.a(this.dpN.getPageContext().getPageActivity(), this.cBh, BdListViewHelper.HeadType.TIP);
    }

    public void aH(View view) {
        this.dpP.lr(l.h(this.dpN.getPageContext().getPageActivity(), e.C0210e.ds10));
        this.cBh.removeHeaderView(view);
    }

    public void aJ(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.dpN.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.hideNoDataView();
                    if (a.this.dpP != null) {
                        a.this.dpP.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.gd(this.dpN.getPageContext().getContext().getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.refreshView.in(this.dpN.getString(e.j.neterror));
        this.mRootView = view;
        this.refreshView.attachView(view, true);
        this.refreshView.NL();
        this.cBh.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cBh.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.I(this.dpT);
    }

    public void b(f fVar) {
        this.dpQ.b(fVar);
    }

    public boolean avq() {
        return this.dpS;
    }

    public BdListView avJ() {
        return this.cBh;
    }

    public void avK() {
        bm(this.dpQ.getDataList());
    }

    public void lp(final int i) {
        this.dpS = true;
        if (this.dpQ.avE() == null) {
            this.dpQ.createView();
            this.dpQ.avE().setVisibility(8);
        }
        ForumEditView avE = this.dpQ.avE();
        avE.onChangeSkinType(this.dpN.getPageContext());
        if (avE.getParent() == null && this.dpN.avi() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.dpN.avc().getId());
            this.dpN.avc().addView(avE);
            this.dpN.avh();
        }
        this.dpQ.bj(this.dpT);
        com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.lq(i);
                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.dpQ.avE() != null) {
                            a.this.dpQ.avE().setVisibility(0);
                            a.this.cBh.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean auM() {
        if (this.dpO != null) {
            return this.dpO.auM();
        }
        return false;
    }

    public void avL() {
        this.dpS = false;
        this.cBh.setVisibility(0);
        if (this.dpQ.avE() != null && this.dpN.avc() != null) {
            this.dpN.avc().removeView(this.dpQ.avE());
            this.dpQ.avE().setVisibility(8);
        }
        this.dpN.avh();
    }

    public void avM() {
        this.dpS = true;
        this.cBh.setVisibility(8);
        if (this.dpQ.avE() != null) {
            this.dpQ.avE().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq(int i) {
        if (this.dpQ.avE() != null && this.cBh != null && this.cBh.getChildCount() > 0) {
            int firstVisiblePosition = (this.cBh.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cBh.getChildAt(0);
            this.dpQ.avE().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cBh.startPullRefresh();
    }

    public void pg() {
        this.cBh.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public List<f> avN() {
        return this.dpT;
    }

    public List<f> avO() {
        List<f> dataList = this.dpQ.getDataList();
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
        this.dpO.notifyDataSetChanged();
    }

    public void bm(List<f> list) {
        this.dpT = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!v.I(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.dpN.getPageContext().getResources().getString(e.j.my_attention_bar)));
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
        this.dpO.setData(arrayList);
        if (this.dpS) {
            this.cBh.setVisibility(8);
            return;
        }
        avL();
        this.dpP.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cBh.removeFooterView(this.dbn);
            this.cBh.addFooterView(this.dbn);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cBh.removeFooterView(this.dbn);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dpP != null) {
            this.dpP.onChangeSkinType(this.dpN.getPageContext());
        }
        if (this.dpQ.avE() != null && this.dpQ.avE().getVisibility() == 0) {
            this.dpQ.onChangeSkinType(this.dpN.getPageContext());
        }
        if (this.dpR.avI() != null) {
            this.dpR.onChangeSkinType();
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.dpP != null) {
            this.dpP.setSearchHint(str);
        }
    }

    public void avP() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.dpU == null) {
                this.dpU = new CommonTipView(this.dpN.getActivity());
            }
            this.dpU.setText(e.j.enter_forum_login_tip);
            this.dpU.show(this.dpN.avc(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.dpU != null) {
            this.dpU.onDestroy();
        }
        if (this.dpR != null) {
            this.dpR.onDestroy();
        }
    }

    public void bn(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.dpR.isShowing() && !v.I(list)) {
            this.dpR.bl(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dpO != null) {
            this.dpO.setPageUniqueId(bdUniqueId);
        }
    }
}
