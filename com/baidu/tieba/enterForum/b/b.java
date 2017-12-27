package com.baidu.tieba.enterForum.b;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private BdListView cAT;
    private View cVP;
    private ViewEventCenter dhh;
    private final com.baidu.tieba.enterForum.home.a diX;
    private com.baidu.tieba.enterForum.a.a diY;
    private f diZ;
    private com.baidu.tieba.enterForum.model.c dja;
    private com.baidu.tieba.enterForum.multiConcern.a djb;
    private boolean djc;
    private List<com.baidu.tieba.enterForum.data.f> djd;
    private CommonTipView dje;
    private j mPullView;
    private View mRootView;
    private g refreshView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.diX = aVar;
        this.dhh = viewEventCenter;
        this.dja = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.djb = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().wy(), viewEventCenter);
        bH(view);
        this.diY = new com.baidu.tieba.enterForum.a.a(this.diX.getPageContext(), this.dhh);
        this.cAT.setAdapter((ListAdapter) this.diY);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bH(View view) {
        this.cAT = (BdListView) view.findViewById(d.g.listview);
        this.cAT.setVerticalScrollBarEnabled(false);
        this.mPullView = new j(this.diX.getPageContext());
        this.mPullView.setTag(this.diX.getUniqueId());
        this.cAT.setPullRefresh(this.mPullView);
        this.diZ = new f(this.diX.getFragmentActivity());
        this.diZ.setEventCenter(this.dhh);
        this.cAT.addHeaderView(this.diZ);
        BdListViewHelper.a(this.diX.getPageContext().getPageActivity(), this.cAT, BdListViewHelper.HeadType.DEFAULT);
        this.cVP = new View(this.diX.getActivity());
        this.cVP.setLayoutParams(new AbsListView.LayoutParams(-1, l.s(this.diX.getActivity(), d.e.ds0)));
    }

    public View aoF() {
        this.diZ.mp(l.s(this.diX.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.diX.getPageContext().getPageActivity(), this.cAT, BdListViewHelper.HeadType.TIP);
    }

    public void bG(View view) {
        this.diZ.mp(l.s(this.diX.getPageContext().getPageActivity(), d.e.ds10));
        this.cAT.removeHeaderView(view);
    }

    public void bI(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.diX.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.diZ != null) {
                        b.this.diZ.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.ih(this.diX.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gE(this.diX.getString(d.j.neterror));
        this.mRootView = view;
        this.refreshView.j(view, true);
        this.refreshView.Mv();
        this.cAT.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.bi(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cAT.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.G(this.djd);
    }

    public void b(com.baidu.tieba.enterForum.data.f fVar) {
        this.dja.b(fVar);
    }

    public boolean aoK() {
        return this.djc;
    }

    public BdListView apc() {
        return this.cAT;
    }

    public void apd() {
        aU(this.dja.getDataList());
    }

    public void mn(final int i) {
        this.djc = true;
        if (this.dja.aoX() == null) {
            this.dja.createView();
            this.dja.aoX().setVisibility(8);
        }
        d aoX = this.dja.aoX();
        aoX.onChangeSkinType(this.diX.getPageContext());
        if (aoX.getParent() == null && this.diX.aoC() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.diX.aow().getId());
            this.diX.aow().addView(aoX);
            this.diX.aoB();
        }
        this.dja.aR(this.djd);
        com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mo(i);
                com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.dja.aoX() != null) {
                            b.this.dja.aoX().setVisibility(0);
                            b.this.cAT.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void ape() {
        this.djc = false;
        this.cAT.setVisibility(0);
        if (this.dja.aoX() != null && this.diX.aow() != null) {
            this.diX.aow().removeView(this.dja.aoX());
            this.dja.aoX().setVisibility(8);
        }
        this.diX.aoB();
    }

    public void apf() {
        this.djc = true;
        this.cAT.setVisibility(8);
        if (this.dja.aoX() != null) {
            this.dja.aoX().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mo(int i) {
        if (this.dja.aoX() != null && this.cAT != null && this.cAT.getChildCount() > 0) {
            int firstVisiblePosition = (this.cAT.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cAT.getChildAt(0);
            this.dja.aoX().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cAT.startPullRefresh();
    }

    public void sV() {
        this.cAT.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.data.f> apg() {
        return this.djd;
    }

    public List<com.baidu.tieba.enterForum.data.f> aph() {
        List<com.baidu.tieba.enterForum.data.f> dataList = this.dja.getDataList();
        com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) v.f(dataList, 0);
        if (fVar != null && fVar.getType() == 1) {
            v.g(dataList, 0);
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
        this.diY.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aU(List<com.baidu.tieba.enterForum.data.f> list) {
        boolean z;
        this.djd = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (v.F(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.data.a)) {
            com.baidu.tieba.enterForum.data.a aVar = (com.baidu.tieba.enterForum.data.a) a.get(0);
            if (aVar.aol().getType() == 1 && aVar.aom().getType() == 2) {
                z = false;
                if (v.G(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.data.d(this.diX.getPageContext().getResources().getString(d.j.my_attention_bar), z));
                    arrayList.addAll(a);
                } else {
                    com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                    cVar.setType(3);
                    arrayList.add(cVar);
                }
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.setType(2);
                arrayList.add(cVar2);
                hideNoDataView();
                this.diY.setData(arrayList);
                if (!this.djc) {
                    this.cAT.setVisibility(8);
                    return;
                }
                ape();
                this.diZ.setVisibility(0);
                return;
            }
        }
        z = true;
        if (v.G(a)) {
        }
        com.baidu.tieba.enterForum.data.c cVar22 = new com.baidu.tieba.enterForum.data.c();
        cVar22.setType(2);
        arrayList.add(cVar22);
        hideNoDataView();
        this.diY.setData(arrayList);
        if (!this.djc) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cAT.removeFooterView(this.cVP);
            this.cAT.addFooterView(this.cVP);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cAT.removeFooterView(this.cVP);
        }
        if (this.mPullView != null) {
            this.mPullView.gy(i);
        }
        if (this.diZ != null) {
            this.diZ.onChangeSkinType(this.diX.getPageContext());
        }
        if (this.dja.aoX() != null && this.dja.aoX().getVisibility() == 0) {
            this.dja.onChangeSkinType(this.diX.getPageContext());
        }
        if (this.djb.apb() != null) {
            this.djb.onChangeSkinType();
        }
    }

    public void a(i.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.diZ != null) {
            this.diZ.setSearchHint(str);
        }
    }

    public void api() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.dje == null) {
                this.dje = new CommonTipView(this.diX.getActivity());
            }
            this.dje.setText(d.j.enter_forum_login_tip);
            this.dje.show(this.diX.aow(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.dje != null) {
            this.dje.onDestroy();
        }
        if (this.djb != null) {
            this.djb.onDestroy();
        }
    }

    public void aV(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.djb.isShowing() && !v.G(list)) {
            this.djb.aT(list);
        }
    }
}
