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
    private View bNy;
    private final com.baidu.tieba.enterForum.home.a bYY;
    private ViewEventCenter bYw;
    private BdListView bvN;
    private CommonTipView caA;
    private TextView caB;
    private boolean caC;
    private com.baidu.tieba.enterForum.a.a cas;
    private f cat;
    private com.baidu.tieba.enterForum.model.c cau;
    private com.baidu.tieba.enterForum.multiConcern.a cav;
    private boolean cax;
    private List<g> cay;
    private List<j> caz;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private l mPullView;
    private boolean caw = false;
    private com.baidu.adp.lib.guide.c bPX = null;
    private Handler mHandler = new Handler();
    private Runnable caD = new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.3
        @Override // java.lang.Runnable
        public void run() {
            b.this.acG();
        }
    };

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.caC = false;
        this.bYY = aVar;
        this.bYw = viewEventCenter;
        this.cau = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.cav = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oU(), viewEventCenter);
        ah(view);
        this.cas = new com.baidu.tieba.enterForum.a.a(this.bYY.getPageContext(), this.bYw);
        this.bvN.setAdapter((ListAdapter) this.cas);
        this.caC = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_click_to_rank_forums_tip", false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ah(View view) {
        this.bvN = (BdListView) view.findViewById(d.h.listview);
        this.bvN.setVerticalScrollBarEnabled(false);
        this.mPullView = new l(this.bYY.getPageContext());
        this.mPullView.setTag(this.bYY.getUniqueId());
        this.bvN.setPullRefresh(this.mPullView);
        this.cat = new f(this.bYY.getFragmentActivity());
        this.cat.setEventCenter(this.bYw);
        this.bvN.addHeaderView(this.cat);
        this.caB = (TextView) BdListViewHelper.a(this.bYY.getPageContext().getPageActivity(), this.bvN, BdListViewHelper.HeadType.DEFAULT);
        this.bNy = new View(this.bYY.getActivity());
        this.bNy.setLayoutParams(new AbsListView.LayoutParams(-1, k.g(this.bYY.getActivity(), d.f.ds0)));
    }

    public void ai(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bYY.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.net_refresh_emotion, k.g(this.bYY.getPageContext().getContext(), d.f.ds300), k.g(this.bYY.getPageContext().getContext(), d.f.ds480), k.g(this.bYY.getPageContext().getContext(), d.f.ds360)), NoDataViewFactory.d.ad(this.bYY.getString(d.l.neterror), this.bYY.getString(d.l.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bYY.getString(d.l.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.cat.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.bYY.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bvN.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bvN.setVisibility(0);
    }

    public boolean isEmpty() {
        return u.v(this.cay) && u.v(this.caz);
    }

    public void b(g gVar) {
        this.cau.b(gVar);
    }

    public void en(boolean z) {
        this.caw = z;
    }

    public boolean acd() {
        return this.cax;
    }

    public BdListView acy() {
        return this.bvN;
    }

    public void acz() {
        i(this.cau.getDataList(), this.caz);
    }

    public void ii(final int i) {
        this.cax = true;
        if (this.cau.acr() == null) {
            this.cau.acs();
            this.cau.acr().setVisibility(8);
        }
        d acr = this.cau.acr();
        acr.n(this.bYY.getPageContext());
        if (acr.getParent() == null && this.bYY.abV() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bYY.abQ().getId());
            this.bYY.abQ().addView(acr);
            this.bYY.abU();
        }
        this.cau.as(this.cay);
        com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.ij(i);
                com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.cau.acr() != null) {
                            b.this.cau.acr().setVisibility(0);
                            b.this.bvN.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void acA() {
        this.cax = false;
        this.bvN.setVisibility(0);
        if (this.cau.acr() != null && this.bYY.abQ() != null) {
            this.bYY.abQ().removeView(this.cau.acr());
            this.cau.acr().setVisibility(8);
        }
        this.bYY.abU();
    }

    public void acB() {
        this.cax = true;
        this.bvN.setVisibility(8);
        if (this.cau.acr() != null) {
            this.cau.acr().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(int i) {
        if (this.cau.acr() != null && this.bvN != null && this.bvN.getChildCount() > 0) {
            int firstVisiblePosition = (this.bvN.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bvN.getChildAt(0);
            this.cau.acr().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bvN.startPullRefresh();
    }

    public void acC() {
        this.bvN.completePullRefreshPostDelayed(2000L);
    }

    public List<g> acD() {
        return this.cay;
    }

    public List<g> acE() {
        List<g> dataList = this.cau.getDataList();
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
        this.cas.notifyDataSetChanged();
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
        this.cay = list;
        this.caz = list2;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.b.c> a2 = a(list, false, 0, 0);
        if (u.u(a2) == 1 && (a2.get(0) instanceof com.baidu.tieba.enterForum.b.a)) {
            com.baidu.tieba.enterForum.b.a aVar = (com.baidu.tieba.enterForum.b.a) a2.get(0);
            if (aVar.abC().getType() == 1 && aVar.abD().getType() == 2) {
                z = false;
                if (!u.v(a2)) {
                    arrayList.add(new com.baidu.tieba.enterForum.b.d(this.bYY.getPageContext().getResources().getString(d.l.my_attention_bar), z));
                    arrayList.addAll(a2);
                }
                a = a(list2, false, 3, 3);
                if (!u.v(a)) {
                    com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.bYY.getPageContext().getResources().getString(d.l.group_fourm_recommend_title), false);
                    dVar.bYL = d.f.ds40;
                    arrayList.add(dVar);
                    arrayList.addAll(a);
                }
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setType(2);
                arrayList.add(cVar);
                hideNoDataView();
                this.cas.setData(arrayList);
                if (!this.cax) {
                    this.bvN.setVisibility(8);
                    return;
                }
                acA();
                this.cat.setVisibility(0);
                if (!this.caC && u.u(list) >= 2 && this.cav != null && !this.cav.isShowing()) {
                    this.mHandler.postDelayed(this.caD, 500L);
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
        this.cas.setData(arrayList);
        if (!this.cax) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bvN.removeFooterView(this.bNy);
            this.bvN.addFooterView(this.bNy);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bvN.removeFooterView(this.bNy);
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
        if (this.cat != null) {
            this.cat.n(this.bYY.getPageContext());
        }
        if (this.cau.acr() != null && this.cau.acr().getVisibility() == 0) {
            this.cau.n(this.bYY.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bYY.getPageContext(), i);
        }
        if (this.cav.acx() != null) {
            this.cav.onChangeSkinType();
        }
    }

    public void a(k.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cat != null) {
            this.cat.setSearchHint(str);
        }
    }

    public void acF() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.caA == null) {
                this.caA = new CommonTipView(this.bYY.getActivity());
            }
            this.caA.setText(d.l.enter_forum_login_tip);
            this.caA.b(this.bYY.abQ(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.caA != null) {
            this.caA.onDestroy();
        }
        this.mHandler.removeCallbacks(this.caD);
        if (this.cav != null) {
            this.cav.onDestroy();
        }
    }

    public void ace() {
        if (this.bPX != null) {
            this.bPX.dismiss();
        }
    }

    public void acG() {
        if (!this.caC && this.bYY.isPrimary() && !this.caw) {
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.o(this.cat).ag(178).z(false);
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
            this.bPX = dVar.fk();
            this.bPX.j(this.bYY.getPageContext().getPageActivity());
            this.caC = true;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_click_to_rank_forums_tip", true);
        }
    }

    public void av(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cav.isShowing() && !u.v(list)) {
            this.cav.au(list);
        }
    }

    public boolean acH() {
        return this.caC;
    }
}
