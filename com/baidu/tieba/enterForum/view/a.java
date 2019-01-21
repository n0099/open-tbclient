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
    private BdListView cCT;
    private View deT;
    private ViewEventCenter drf;
    private final EnterForumFragment dtn;
    private com.baidu.tieba.enterForum.a.a dto;
    private ForumHeaderView dtp;
    private com.baidu.tieba.enterForum.model.c dtq;
    private com.baidu.tieba.enterForum.multiConcern.a dtr;
    private boolean dts;
    private List<f> dtt;
    private CommonTipView dtu;
    private k mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.dtn = enterForumFragment;
        this.drf = viewEventCenter;
        this.dtq = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.dtr = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        aL(view);
        this.dto = new com.baidu.tieba.enterForum.a.a(this.dtn.getPageContext(), this.drf, recentlyVisitedForumModel);
        this.cCT.setAdapter((ListAdapter) this.dto);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aL(View view) {
        this.cCT = (BdListView) view.findViewById(e.g.listview);
        this.cCT.setVerticalScrollBarEnabled(false);
        this.mPullView = new k(this.dtn.getPageContext());
        this.mPullView.setTag(this.dtn.getUniqueId());
        this.cCT.setPullRefresh(this.mPullView);
        this.dtp = new ForumHeaderView(this.dtn.getFragmentActivity());
        this.dtp.setEventCenter(this.drf);
        this.cCT.addHeaderView(this.dtp);
        BdListViewHelper.a(this.dtn.getPageContext().getPageActivity(), this.cCT, BdListViewHelper.HeadType.DEFAULT);
        this.deT = new View(this.dtn.getActivity());
        this.deT.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(this.dtn.getActivity(), e.C0210e.ds0)));
    }

    public View awx() {
        this.dtp.lF(l.h(this.dtn.getPageContext().getPageActivity(), e.C0210e.ds20));
        return BdListViewHelper.a(this.dtn.getPageContext().getPageActivity(), this.cCT, BdListViewHelper.HeadType.TIP);
    }

    public void aK(View view) {
        this.dtp.lF(l.h(this.dtn.getPageContext().getPageActivity(), e.C0210e.ds10));
        this.cCT.removeHeaderView(view);
    }

    public void aM(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.dtn.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.hideNoDataView();
                    if (a.this.dtp != null) {
                        a.this.dtp.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.ge(this.dtn.getPageContext().getContext().getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.refreshView.iC(this.dtn.getString(e.j.neterror));
        this.mRootView = view;
        this.refreshView.attachView(view, true);
        this.refreshView.Od();
        this.cCT.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cCT.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.I(this.dtt);
    }

    public void b(f fVar) {
        this.dtq.b(fVar);
    }

    public boolean awC() {
        return this.dts;
    }

    public BdListView awV() {
        return this.cCT;
    }

    public void awW() {
        bo(this.dtq.getDataList());
    }

    public void lD(final int i) {
        this.dts = true;
        if (this.dtq.awQ() == null) {
            this.dtq.createView();
            this.dtq.awQ().setVisibility(8);
        }
        ForumEditView awQ = this.dtq.awQ();
        awQ.onChangeSkinType(this.dtn.getPageContext());
        if (awQ.getParent() == null && this.dtn.awu() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.dtn.awo().getId());
            this.dtn.awo().addView(awQ);
            this.dtn.awt();
        }
        this.dtq.bl(this.dtt);
        com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.lE(i);
                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.dtq.awQ() != null) {
                            a.this.dtq.awQ().setVisibility(0);
                            a.this.cCT.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean avZ() {
        if (this.dto != null) {
            return this.dto.avZ();
        }
        return false;
    }

    public void awX() {
        this.dts = false;
        this.cCT.setVisibility(0);
        if (this.dtq.awQ() != null && this.dtn.awo() != null) {
            this.dtn.awo().removeView(this.dtq.awQ());
            this.dtq.awQ().setVisibility(8);
        }
        this.dtn.awt();
    }

    public void awY() {
        this.dts = true;
        this.cCT.setVisibility(8);
        if (this.dtq.awQ() != null) {
            this.dtq.awQ().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(int i) {
        if (this.dtq.awQ() != null && this.cCT != null && this.cCT.getChildCount() > 0) {
            int firstVisiblePosition = (this.cCT.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cCT.getChildAt(0);
            this.dtq.awQ().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cCT.startPullRefresh();
    }

    public void pk() {
        this.cCT.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public List<f> awZ() {
        return this.dtt;
    }

    public List<f> axa() {
        List<f> dataList = this.dtq.getDataList();
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
        this.dto.notifyDataSetChanged();
    }

    public void bo(List<f> list) {
        this.dtt = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!v.I(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.dtn.getPageContext().getResources().getString(e.j.my_attention_bar)));
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
        this.dto.setData(arrayList);
        if (this.dts) {
            this.cCT.setVisibility(8);
            return;
        }
        awX();
        this.dtp.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cCT.removeFooterView(this.deT);
            this.cCT.addFooterView(this.deT);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cCT.removeFooterView(this.deT);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dtp != null) {
            this.dtp.onChangeSkinType(this.dtn.getPageContext());
        }
        if (this.dtq.awQ() != null && this.dtq.awQ().getVisibility() == 0) {
            this.dtq.onChangeSkinType(this.dtn.getPageContext());
        }
        if (this.dtr.awU() != null) {
            this.dtr.onChangeSkinType();
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.dtp != null) {
            this.dtp.setSearchHint(str);
        }
    }

    public void axb() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.dtu == null) {
                this.dtu = new CommonTipView(this.dtn.getActivity());
            }
            this.dtu.setText(e.j.enter_forum_login_tip);
            this.dtu.show(this.dtn.awo(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.dtu != null) {
            this.dtu.onDestroy();
        }
        if (this.dtr != null) {
            this.dtr.onDestroy();
        }
    }

    public void bp(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.dtr.isShowing() && !v.I(list)) {
            this.dtr.bn(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dto != null) {
            this.dto.setPageUniqueId(bdUniqueId);
        }
    }
}
