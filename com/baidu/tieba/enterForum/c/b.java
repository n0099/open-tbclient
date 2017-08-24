package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.core.view.l;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.enterForum.b.j;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private View bNz;
    private final com.baidu.tieba.enterForum.home.a bYZ;
    private ViewEventCenter bYx;
    private BdListView bvO;
    private List<j> caA;
    private CommonTipView caB;
    private TextView caC;
    private boolean caD;
    private com.baidu.tieba.enterForum.a.a cat;
    private f cau;
    private com.baidu.tieba.enterForum.model.c cav;
    private com.baidu.tieba.enterForum.multiConcern.a caw;
    private boolean cay;
    private List<g> caz;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private l mPullView;
    private boolean cax = false;
    private com.baidu.adp.lib.guide.c bPY = null;
    private Handler mHandler = new Handler();
    private Runnable caE = new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.3
        @Override // java.lang.Runnable
        public void run() {
            b.this.acC();
        }
    };

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.caD = false;
        this.bYZ = aVar;
        this.bYx = viewEventCenter;
        this.cav = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.caw = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oV(), viewEventCenter);
        ag(view);
        this.cat = new com.baidu.tieba.enterForum.a.a(this.bYZ.getPageContext(), this.bYx);
        this.bvO.setAdapter((ListAdapter) this.cat);
        this.caD = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_click_to_rank_forums_tip", false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ag(View view) {
        this.bvO = (BdListView) view.findViewById(d.h.listview);
        this.bvO.setVerticalScrollBarEnabled(false);
        this.mPullView = new l(this.bYZ.getPageContext());
        this.mPullView.setTag(this.bYZ.getUniqueId());
        this.bvO.setPullRefresh(this.mPullView);
        this.cau = new f(this.bYZ.getFragmentActivity());
        this.cau.setEventCenter(this.bYx);
        this.bvO.addHeaderView(this.cau);
        this.caC = (TextView) BdListViewHelper.a(this.bYZ.getPageContext().getPageActivity(), this.bvO, BdListViewHelper.HeadType.DEFAULT);
        this.bNz = new View(this.bYZ.getActivity());
        this.bNz.setLayoutParams(new AbsListView.LayoutParams(-1, k.g(this.bYZ.getActivity(), d.f.ds0)));
    }

    public void ah(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bYZ.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.net_refresh_emotion, k.g(this.bYZ.getPageContext().getContext(), d.f.ds300), k.g(this.bYZ.getPageContext().getContext(), d.f.ds480), k.g(this.bYZ.getPageContext().getContext(), d.f.ds360)), NoDataViewFactory.d.ad(this.bYZ.getString(d.l.neterror), this.bYZ.getString(d.l.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bYZ.getString(d.l.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.cau.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.bYZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bvO.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bvO.setVisibility(0);
    }

    public boolean isEmpty() {
        return u.v(this.caz) && u.v(this.caA);
    }

    public void b(g gVar) {
        this.cav.b(gVar);
    }

    public void en(boolean z) {
        this.cax = z;
    }

    public boolean abZ() {
        return this.cay;
    }

    public BdListView acu() {
        return this.bvO;
    }

    public void acv() {
        i(this.cav.getDataList(), this.caA);
    }

    public void ii(final int i) {
        this.cay = true;
        if (this.cav.acn() == null) {
            this.cav.aco();
            this.cav.acn().setVisibility(8);
        }
        d acn = this.cav.acn();
        acn.n(this.bYZ.getPageContext());
        if (acn.getParent() == null && this.bYZ.abS() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bYZ.abN().getId());
            this.bYZ.abN().addView(acn);
            this.bYZ.abR();
        }
        this.cav.as(this.caz);
        com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.ij(i);
                com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.cav.acn() != null) {
                            b.this.cav.acn().setVisibility(0);
                            b.this.bvO.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void acw() {
        this.cay = false;
        this.bvO.setVisibility(0);
        if (this.cav.acn() != null && this.bYZ.abN() != null) {
            this.bYZ.abN().removeView(this.cav.acn());
            this.cav.acn().setVisibility(8);
        }
        this.bYZ.abR();
    }

    public void acx() {
        this.cay = true;
        this.bvO.setVisibility(8);
        if (this.cav.acn() != null) {
            this.cav.acn().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(int i) {
        if (this.cav.acn() != null && this.bvO != null && this.bvO.getChildCount() > 0) {
            int firstVisiblePosition = (this.bvO.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bvO.getChildAt(0);
            this.cav.acn().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bvO.startPullRefresh();
    }

    public void acy() {
        this.bvO.completePullRefreshPostDelayed(2000L);
    }

    public List<g> acz() {
        return this.caz;
    }

    public List<g> acA() {
        List<g> dataList = this.cav.getDataList();
        g gVar = (g) u.c(dataList, 0);
        if (gVar != null && gVar.getType() == 1) {
            u.d(dataList, 0);
        }
        return dataList;
    }

    private List<com.baidu.tieba.enterForum.b.c> a(List list, boolean z, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int size = list.size();
        int i3 = 1;
        int i4 = 0;
        while (i4 < size && (i2 <= 0 || i3 < i2 * 2)) {
            com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
            com.baidu.tieba.enterForum.b.e eVar2 = new com.baidu.tieba.enterForum.b.e();
            if (i3 < size) {
                eVar = (com.baidu.tieba.enterForum.b.e) list.get(i4);
                eVar2 = (com.baidu.tieba.enterForum.b.e) list.get(i3);
                eVar.setType(i);
                eVar2.setType(i);
            } else if (i4 < size) {
                eVar = (com.baidu.tieba.enterForum.b.e) list.get(i4);
                eVar.setType(i);
                eVar2.setType(2);
            }
            arrayList.add(new com.baidu.tieba.enterForum.b.a(eVar, eVar2));
            int i5 = i4 + 2;
            i3 = i5 + 1;
            i4 = i5;
        }
        return arrayList;
    }

    public void notifyDataSetChanged() {
        this.cat.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(List<g> list, List<j> list2) {
        boolean z;
        List<com.baidu.tieba.enterForum.b.c> a;
        this.caz = list;
        this.caA = list2;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.b.c> a2 = a(list, false, 0, 0);
        if (u.u(a2) == 1 && (a2.get(0) instanceof com.baidu.tieba.enterForum.b.a)) {
            com.baidu.tieba.enterForum.b.a aVar = (com.baidu.tieba.enterForum.b.a) a2.get(0);
            if (aVar.abz().getType() == 1 && aVar.abA().getType() == 2) {
                z = false;
                if (!u.v(a2)) {
                    arrayList.add(new com.baidu.tieba.enterForum.b.d(this.bYZ.getPageContext().getResources().getString(d.l.my_attention_bar), z));
                    arrayList.addAll(a2);
                }
                a = a(list2, false, 3, 3);
                if (!u.v(a)) {
                    com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.bYZ.getPageContext().getResources().getString(d.l.group_fourm_recommend_title), false);
                    dVar.bYM = d.f.ds40;
                    arrayList.add(dVar);
                    arrayList.addAll(a);
                }
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setType(2);
                arrayList.add(cVar);
                hideNoDataView();
                this.cat.setData(arrayList);
                if (!this.cay) {
                    this.bvO.setVisibility(8);
                    return;
                }
                acw();
                this.cau.setVisibility(0);
                if (!this.caD && u.u(list) >= 2 && this.caw != null && !this.caw.isShowing()) {
                    this.mHandler.postDelayed(this.caE, 500L);
                    return;
                }
                return;
            }
        }
        z = true;
        if (!u.v(a2)) {
        }
        a = a(list2, false, 3, 3);
        if (!u.v(a)) {
        }
        com.baidu.tieba.enterForum.b.c cVar2 = new com.baidu.tieba.enterForum.b.c();
        cVar2.setType(2);
        arrayList.add(cVar2);
        hideNoDataView();
        this.cat.setData(arrayList);
        if (!this.cay) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bvO.removeFooterView(this.bNz);
            this.bvO.addFooterView(this.bNz);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bvO.removeFooterView(this.bNz);
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
        if (this.cau != null) {
            this.cau.n(this.bYZ.getPageContext());
        }
        if (this.cav.acn() != null && this.cav.acn().getVisibility() == 0) {
            this.cav.n(this.bYZ.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bYZ.getPageContext(), i);
        }
        if (this.caw.act() != null) {
            this.caw.onChangeSkinType();
        }
    }

    public void a(k.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cau != null) {
            this.cau.setSearchHint(str);
        }
    }

    public void acB() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.caB == null) {
                this.caB = new CommonTipView(this.bYZ.getActivity());
            }
            this.caB.setText(d.l.enter_forum_login_tip);
            this.caB.a(this.bYZ.abN(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.caB != null) {
            this.caB.onDestroy();
        }
        this.mHandler.removeCallbacks(this.caE);
        if (this.caw != null) {
            this.caw.onDestroy();
        }
    }

    public void aca() {
        if (this.bPY != null) {
            this.bPY.dismiss();
        }
    }

    public void acC() {
        if (!this.caD && this.bYZ.isPrimary() && !this.cax) {
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.o(this.cau).ag(178).z(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.c.b.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    return layoutInflater.inflate(d.j.drag_to_sort_forum_tip_layout, (ViewGroup) null, false);
                }

                @Override // com.baidu.adp.lib.guide.b
                public int fi() {
                    return 4;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int fj() {
                    return 32;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getXOffset() {
                    return 0;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getYOffset() {
                    return 0;
                }
            });
            this.bPY = dVar.fk();
            this.bPY.j(this.bYZ.getPageContext().getPageActivity());
            this.caD = true;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_click_to_rank_forums_tip", true);
        }
    }

    public void av(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.caw.isShowing() && !u.v(list)) {
            this.caw.au(list);
        }
    }

    public boolean acD() {
        return this.caD;
    }
}
