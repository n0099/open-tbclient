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
    private BdListView cCS;
    private View deS;
    private ViewEventCenter dre;
    private final EnterForumFragment dtm;
    private com.baidu.tieba.enterForum.a.a dtn;
    private ForumHeaderView dto;
    private com.baidu.tieba.enterForum.model.c dtp;
    private com.baidu.tieba.enterForum.multiConcern.a dtq;
    private boolean dtr;
    private List<f> dts;
    private CommonTipView dtt;
    private k mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.dtm = enterForumFragment;
        this.dre = viewEventCenter;
        this.dtp = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.dtq = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        aL(view);
        this.dtn = new com.baidu.tieba.enterForum.a.a(this.dtm.getPageContext(), this.dre, recentlyVisitedForumModel);
        this.cCS.setAdapter((ListAdapter) this.dtn);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aL(View view) {
        this.cCS = (BdListView) view.findViewById(e.g.listview);
        this.cCS.setVerticalScrollBarEnabled(false);
        this.mPullView = new k(this.dtm.getPageContext());
        this.mPullView.setTag(this.dtm.getUniqueId());
        this.cCS.setPullRefresh(this.mPullView);
        this.dto = new ForumHeaderView(this.dtm.getFragmentActivity());
        this.dto.setEventCenter(this.dre);
        this.cCS.addHeaderView(this.dto);
        BdListViewHelper.a(this.dtm.getPageContext().getPageActivity(), this.cCS, BdListViewHelper.HeadType.DEFAULT);
        this.deS = new View(this.dtm.getActivity());
        this.deS.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(this.dtm.getActivity(), e.C0210e.ds0)));
    }

    public View awx() {
        this.dto.lF(l.h(this.dtm.getPageContext().getPageActivity(), e.C0210e.ds20));
        return BdListViewHelper.a(this.dtm.getPageContext().getPageActivity(), this.cCS, BdListViewHelper.HeadType.TIP);
    }

    public void aK(View view) {
        this.dto.lF(l.h(this.dtm.getPageContext().getPageActivity(), e.C0210e.ds10));
        this.cCS.removeHeaderView(view);
    }

    public void aM(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.dtm.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.hideNoDataView();
                    if (a.this.dto != null) {
                        a.this.dto.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.ge(this.dtm.getPageContext().getContext().getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.refreshView.iC(this.dtm.getString(e.j.neterror));
        this.mRootView = view;
        this.refreshView.attachView(view, true);
        this.refreshView.Od();
        this.cCS.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cCS.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.I(this.dts);
    }

    public void b(f fVar) {
        this.dtp.b(fVar);
    }

    public boolean awC() {
        return this.dtr;
    }

    public BdListView awV() {
        return this.cCS;
    }

    public void awW() {
        bo(this.dtp.getDataList());
    }

    public void lD(final int i) {
        this.dtr = true;
        if (this.dtp.awQ() == null) {
            this.dtp.createView();
            this.dtp.awQ().setVisibility(8);
        }
        ForumEditView awQ = this.dtp.awQ();
        awQ.onChangeSkinType(this.dtm.getPageContext());
        if (awQ.getParent() == null && this.dtm.awu() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.dtm.awo().getId());
            this.dtm.awo().addView(awQ);
            this.dtm.awt();
        }
        this.dtp.bl(this.dts);
        com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.lE(i);
                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.dtp.awQ() != null) {
                            a.this.dtp.awQ().setVisibility(0);
                            a.this.cCS.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean avZ() {
        if (this.dtn != null) {
            return this.dtn.avZ();
        }
        return false;
    }

    public void awX() {
        this.dtr = false;
        this.cCS.setVisibility(0);
        if (this.dtp.awQ() != null && this.dtm.awo() != null) {
            this.dtm.awo().removeView(this.dtp.awQ());
            this.dtp.awQ().setVisibility(8);
        }
        this.dtm.awt();
    }

    public void awY() {
        this.dtr = true;
        this.cCS.setVisibility(8);
        if (this.dtp.awQ() != null) {
            this.dtp.awQ().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(int i) {
        if (this.dtp.awQ() != null && this.cCS != null && this.cCS.getChildCount() > 0) {
            int firstVisiblePosition = (this.cCS.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cCS.getChildAt(0);
            this.dtp.awQ().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cCS.startPullRefresh();
    }

    public void pk() {
        this.cCS.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public List<f> awZ() {
        return this.dts;
    }

    public List<f> axa() {
        List<f> dataList = this.dtp.getDataList();
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
        this.dtn.notifyDataSetChanged();
    }

    public void bo(List<f> list) {
        this.dts = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!v.I(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.dtm.getPageContext().getResources().getString(e.j.my_attention_bar)));
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
        this.dtn.setData(arrayList);
        if (this.dtr) {
            this.cCS.setVisibility(8);
            return;
        }
        awX();
        this.dto.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cCS.removeFooterView(this.deS);
            this.cCS.addFooterView(this.deS);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cCS.removeFooterView(this.deS);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dto != null) {
            this.dto.onChangeSkinType(this.dtm.getPageContext());
        }
        if (this.dtp.awQ() != null && this.dtp.awQ().getVisibility() == 0) {
            this.dtp.onChangeSkinType(this.dtm.getPageContext());
        }
        if (this.dtq.awU() != null) {
            this.dtq.onChangeSkinType();
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.dto != null) {
            this.dto.setSearchHint(str);
        }
    }

    public void axb() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.dtt == null) {
                this.dtt = new CommonTipView(this.dtm.getActivity());
            }
            this.dtt.setText(e.j.enter_forum_login_tip);
            this.dtt.show(this.dtm.awo(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.dtt != null) {
            this.dtt.onDestroy();
        }
        if (this.dtq != null) {
            this.dtq.onDestroy();
        }
    }

    public void bp(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.dtq.isShowing() && !v.I(list)) {
            this.dtq.bn(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dtn != null) {
            this.dtn.setPageUniqueId(bdUniqueId);
        }
    }
}
