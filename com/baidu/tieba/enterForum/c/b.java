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
    private View bMP;
    private ViewEventCenter bXK;
    private final com.baidu.tieba.enterForum.home.a bYm;
    private com.baidu.tieba.enterForum.a.a bZG;
    private f bZH;
    private com.baidu.tieba.enterForum.model.c bZI;
    private com.baidu.tieba.enterForum.multiConcern.a bZJ;
    private boolean bZL;
    private List<g> bZM;
    private List<j> bZN;
    private CommonTipView bZO;
    private TextView bZP;
    private boolean bZQ;
    private BdListView bve;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private l mPullView;
    private boolean bZK = false;
    private com.baidu.adp.lib.guide.c bPo = null;
    private Handler mHandler = new Handler();
    private Runnable bZR = new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.3
        @Override // java.lang.Runnable
        public void run() {
            b.this.acl();
        }
    };

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.bZQ = false;
        this.bYm = aVar;
        this.bXK = viewEventCenter;
        this.bZI = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.bZJ = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oU(), viewEventCenter);
        ah(view);
        this.bZG = new com.baidu.tieba.enterForum.a.a(this.bYm.getPageContext(), this.bXK);
        this.bve.setAdapter((ListAdapter) this.bZG);
        this.bZQ = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_click_to_rank_forums_tip", false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ah(View view) {
        this.bve = (BdListView) view.findViewById(d.h.listview);
        this.bve.setVerticalScrollBarEnabled(false);
        this.mPullView = new l(this.bYm.getPageContext());
        this.mPullView.setTag(this.bYm.getUniqueId());
        this.bve.setPullRefresh(this.mPullView);
        this.bZH = new f(this.bYm.getFragmentActivity());
        this.bZH.setEventCenter(this.bXK);
        this.bve.addHeaderView(this.bZH);
        this.bZP = (TextView) BdListViewHelper.a(this.bYm.getPageContext().getPageActivity(), this.bve, BdListViewHelper.HeadType.DEFAULT);
        this.bMP = new View(this.bYm.getActivity());
        this.bMP.setLayoutParams(new AbsListView.LayoutParams(-1, k.g(this.bYm.getActivity(), d.f.ds0)));
    }

    public void ai(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bYm.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.net_refresh_emotion, k.g(this.bYm.getPageContext().getContext(), d.f.ds300), k.g(this.bYm.getPageContext().getContext(), d.f.ds480), k.g(this.bYm.getPageContext().getContext(), d.f.ds360)), NoDataViewFactory.d.ad(this.bYm.getString(d.l.neterror), this.bYm.getString(d.l.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bYm.getString(d.l.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.bZH.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.bYm.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bve.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bve.setVisibility(0);
    }

    public boolean isEmpty() {
        return u.v(this.bZM) && u.v(this.bZN);
    }

    public void b(g gVar) {
        this.bZI.b(gVar);
    }

    public void em(boolean z) {
        this.bZK = z;
    }

    public boolean abI() {
        return this.bZL;
    }

    public BdListView acd() {
        return this.bve;
    }

    public void ace() {
        i(this.bZI.getDataList(), this.bZN);
    }

    public void ig(final int i) {
        this.bZL = true;
        if (this.bZI.abW() == null) {
            this.bZI.abX();
            this.bZI.abW().setVisibility(8);
        }
        d abW = this.bZI.abW();
        abW.n(this.bYm.getPageContext());
        if (abW.getParent() == null && this.bYm.abA() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bYm.abv().getId());
            this.bYm.abv().addView(abW);
            this.bYm.abz();
        }
        this.bZI.as(this.bZM);
        com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.ih(i);
                com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.bZI.abW() != null) {
                            b.this.bZI.abW().setVisibility(0);
                            b.this.bve.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void acf() {
        this.bZL = false;
        this.bve.setVisibility(0);
        if (this.bZI.abW() != null && this.bYm.abv() != null) {
            this.bYm.abv().removeView(this.bZI.abW());
            this.bZI.abW().setVisibility(8);
        }
        this.bYm.abz();
    }

    public void acg() {
        this.bZL = true;
        this.bve.setVisibility(8);
        if (this.bZI.abW() != null) {
            this.bZI.abW().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih(int i) {
        if (this.bZI.abW() != null && this.bve != null && this.bve.getChildCount() > 0) {
            int firstVisiblePosition = (this.bve.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bve.getChildAt(0);
            this.bZI.abW().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bve.startPullRefresh();
    }

    public void ach() {
        this.bve.completePullRefreshPostDelayed(2000L);
    }

    public List<g> aci() {
        return this.bZM;
    }

    public List<g> acj() {
        List<g> dataList = this.bZI.getDataList();
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
        this.bZG.notifyDataSetChanged();
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
        this.bZM = list;
        this.bZN = list2;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.b.c> a2 = a(list, false, 0, 0);
        if (u.u(a2) == 1 && (a2.get(0) instanceof com.baidu.tieba.enterForum.b.a)) {
            com.baidu.tieba.enterForum.b.a aVar = (com.baidu.tieba.enterForum.b.a) a2.get(0);
            if (aVar.abh().getType() == 1 && aVar.abi().getType() == 2) {
                z = false;
                if (!u.v(a2)) {
                    arrayList.add(new com.baidu.tieba.enterForum.b.d(this.bYm.getPageContext().getResources().getString(d.l.my_attention_bar), z));
                    arrayList.addAll(a2);
                }
                a = a(list2, false, 3, 3);
                if (!u.v(a)) {
                    com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.bYm.getPageContext().getResources().getString(d.l.group_fourm_recommend_title), false);
                    dVar.bXZ = d.f.ds40;
                    arrayList.add(dVar);
                    arrayList.addAll(a);
                }
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setType(2);
                arrayList.add(cVar);
                hideNoDataView();
                this.bZG.setData(arrayList);
                if (!this.bZL) {
                    this.bve.setVisibility(8);
                    return;
                }
                acf();
                this.bZH.setVisibility(0);
                if (!this.bZQ && u.u(list) >= 2 && this.bZJ != null && !this.bZJ.isShowing()) {
                    this.mHandler.postDelayed(this.bZR, 500L);
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
        this.bZG.setData(arrayList);
        if (!this.bZL) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bve.removeFooterView(this.bMP);
            this.bve.addFooterView(this.bMP);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bve.removeFooterView(this.bMP);
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
        if (this.bZH != null) {
            this.bZH.n(this.bYm.getPageContext());
        }
        if (this.bZI.abW() != null && this.bZI.abW().getVisibility() == 0) {
            this.bZI.n(this.bYm.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bYm.getPageContext(), i);
        }
        if (this.bZJ.acc() != null) {
            this.bZJ.onChangeSkinType();
        }
    }

    public void a(k.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.bZH != null) {
            this.bZH.setSearchHint(str);
        }
    }

    public void ack() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.bZO == null) {
                this.bZO = new CommonTipView(this.bYm.getActivity());
            }
            this.bZO.setText(d.l.enter_forum_login_tip);
            this.bZO.b(this.bYm.abv(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.bZO != null) {
            this.bZO.onDestroy();
        }
        this.mHandler.removeCallbacks(this.bZR);
        if (this.bZJ != null) {
            this.bZJ.onDestroy();
        }
    }

    public void abJ() {
        if (this.bPo != null) {
            this.bPo.dismiss();
        }
    }

    public void acl() {
        if (!this.bZQ && this.bYm.isPrimary() && !this.bZK) {
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.o(this.bZH).ag(178).z(false);
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
            this.bPo = dVar.fk();
            this.bPo.j(this.bYm.getPageContext().getPageActivity());
            this.bZQ = true;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_click_to_rank_forums_tip", true);
        }
    }

    public void av(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.bZJ.isShowing() && !u.v(list)) {
            this.bZJ.au(list);
        }
    }

    public boolean acm() {
        return this.bZQ;
    }
}
