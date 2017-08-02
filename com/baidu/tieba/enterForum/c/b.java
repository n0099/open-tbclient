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
    private View bLF;
    private ViewEventCenter bWE;
    private final com.baidu.tieba.enterForum.home.a bXg;
    private com.baidu.tieba.enterForum.a.a bYA;
    private f bYB;
    private com.baidu.tieba.enterForum.model.c bYC;
    private com.baidu.tieba.enterForum.multiConcern.a bYD;
    private boolean bYF;
    private List<g> bYG;
    private List<j> bYH;
    private CommonTipView bYI;
    private TextView bYJ;
    private boolean bYK;
    private BdListView btT;
    private com.baidu.tbadk.core.view.j mNoDataView;
    private l mPullView;
    private boolean bYE = false;
    private com.baidu.adp.lib.guide.c bOe = null;
    private Handler mHandler = new Handler();
    private Runnable bYL = new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.3
        @Override // java.lang.Runnable
        public void run() {
            b.this.acg();
        }
    };

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.bYK = false;
        this.bXg = aVar;
        this.bWE = viewEventCenter;
        this.bYC = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.bYD = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oK(), viewEventCenter);
        ah(view);
        this.bYA = new com.baidu.tieba.enterForum.a.a(this.bXg.getPageContext(), this.bWE);
        this.btT.setAdapter((ListAdapter) this.bYA);
        this.bYK = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_click_to_rank_forums_tip", false);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ah(View view) {
        this.btT = (BdListView) view.findViewById(d.h.listview);
        this.btT.setVerticalScrollBarEnabled(false);
        this.mPullView = new l(this.bXg.getPageContext());
        this.mPullView.setTag(this.bXg.getUniqueId());
        this.btT.setPullRefresh(this.mPullView);
        this.bYB = new f(this.bXg.getFragmentActivity());
        this.bYB.setEventCenter(this.bWE);
        this.btT.addHeaderView(this.bYB);
        this.bYJ = (TextView) BdListViewHelper.a(this.bXg.getPageContext().getPageActivity(), this.btT, BdListViewHelper.HeadType.DEFAULT);
        this.bLF = new View(this.bXg.getActivity());
        this.bLF.setLayoutParams(new AbsListView.LayoutParams(-1, k.g(this.bXg.getActivity(), d.f.ds0)));
    }

    public void ai(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bXg.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.net_refresh_emotion, k.g(this.bXg.getPageContext().getContext(), d.f.ds300), k.g(this.bXg.getPageContext().getContext(), d.f.ds480), k.g(this.bXg.getPageContext().getContext(), d.f.ds360)), NoDataViewFactory.d.ad(this.bXg.getString(d.l.neterror), this.bXg.getString(d.l.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bXg.getString(d.l.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.bYB.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.bXg.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.btT.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.btT.setVisibility(0);
    }

    public boolean isEmpty() {
        return u.v(this.bYG) && u.v(this.bYH);
    }

    public void b(g gVar) {
        this.bYC.b(gVar);
    }

    public void em(boolean z) {
        this.bYE = z;
    }

    public boolean abD() {
        return this.bYF;
    }

    public BdListView abY() {
        return this.btT;
    }

    public void abZ() {
        i(this.bYC.getDataList(), this.bYH);
    }

    public void ig(final int i) {
        this.bYF = true;
        if (this.bYC.abR() == null) {
            this.bYC.abS();
            this.bYC.abR().setVisibility(8);
        }
        d abR = this.bYC.abR();
        abR.n(this.bXg.getPageContext());
        if (abR.getParent() == null && this.bXg.abv() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bXg.abq().getId());
            this.bXg.abq().addView(abR);
            this.bXg.abu();
        }
        this.bYC.as(this.bYG);
        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.ih(i);
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.bYC.abR() != null) {
                            b.this.bYC.abR().setVisibility(0);
                            b.this.btT.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void aca() {
        this.bYF = false;
        this.btT.setVisibility(0);
        if (this.bYC.abR() != null && this.bXg.abq() != null) {
            this.bXg.abq().removeView(this.bYC.abR());
            this.bYC.abR().setVisibility(8);
        }
        this.bXg.abu();
    }

    public void acb() {
        this.bYF = true;
        this.btT.setVisibility(8);
        if (this.bYC.abR() != null) {
            this.bYC.abR().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ih(int i) {
        if (this.bYC.abR() != null && this.btT != null && this.btT.getChildCount() > 0) {
            int firstVisiblePosition = (this.btT.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.btT.getChildAt(0);
            this.bYC.abR().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.btT.startPullRefresh();
    }

    public void acc() {
        this.btT.completePullRefreshPostDelayed(2000L);
    }

    public List<g> acd() {
        return this.bYG;
    }

    public List<g> ace() {
        List<g> dataList = this.bYC.getDataList();
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
        this.bYA.notifyDataSetChanged();
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
        this.bYG = list;
        this.bYH = list2;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.b.c> a2 = a(list, false, 0, 0);
        if (u.u(a2) == 1 && (a2.get(0) instanceof com.baidu.tieba.enterForum.b.a)) {
            com.baidu.tieba.enterForum.b.a aVar = (com.baidu.tieba.enterForum.b.a) a2.get(0);
            if (aVar.abc().getType() == 1 && aVar.abd().getType() == 2) {
                z = false;
                if (!u.v(a2)) {
                    arrayList.add(new com.baidu.tieba.enterForum.b.d(this.bXg.getPageContext().getResources().getString(d.l.my_attention_bar), z));
                    arrayList.addAll(a2);
                }
                a = a(list2, false, 3, 3);
                if (!u.v(a)) {
                    com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.bXg.getPageContext().getResources().getString(d.l.group_fourm_recommend_title), false);
                    dVar.bWT = d.f.ds40;
                    arrayList.add(dVar);
                    arrayList.addAll(a);
                }
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setType(2);
                arrayList.add(cVar);
                hideNoDataView();
                this.bYA.setData(arrayList);
                if (!this.bYF) {
                    this.btT.setVisibility(8);
                    return;
                }
                aca();
                this.bYB.setVisibility(0);
                if (!this.bYK && u.u(list) >= 2 && this.bYD != null && !this.bYD.isShowing()) {
                    this.mHandler.postDelayed(this.bYL, 500L);
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
        this.bYA.setData(arrayList);
        if (!this.bYF) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.btT.removeFooterView(this.bLF);
            this.btT.addFooterView(this.bLF);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.btT.removeFooterView(this.bLF);
        }
        if (this.mPullView != null) {
            this.mPullView.dn(i);
        }
        if (this.bYB != null) {
            this.bYB.n(this.bXg.getPageContext());
        }
        if (this.bYC.abR() != null && this.bYC.abR().getVisibility() == 0) {
            this.bYC.n(this.bXg.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bXg.getPageContext(), i);
        }
        if (this.bYD.abX() != null) {
            this.bYD.onChangeSkinType();
        }
    }

    public void a(k.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.bYB != null) {
            this.bYB.setSearchHint(str);
        }
    }

    public void acf() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.bYI == null) {
                this.bYI = new CommonTipView(this.bXg.getActivity());
            }
            this.bYI.setText(d.l.enter_forum_login_tip);
            this.bYI.b(this.bXg.abq(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.bYI != null) {
            this.bYI.onDestroy();
        }
        this.mHandler.removeCallbacks(this.bYL);
        if (this.bYD != null) {
            this.bYD.onDestroy();
        }
    }

    public void abE() {
        if (this.bOe != null) {
            this.bOe.dismiss();
        }
    }

    public void acg() {
        if (!this.bYK && this.bXg.isPrimary() && !this.bYE) {
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.o(this.bYB).ad(178).z(false);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.c.b.4
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    return layoutInflater.inflate(d.j.drag_to_sort_forum_tip_layout, (ViewGroup) null, false);
                }

                @Override // com.baidu.adp.lib.guide.b
                public int eX() {
                    return 4;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int eY() {
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
            this.bOe = dVar.eZ();
            this.bOe.j(this.bXg.getPageContext().getPageActivity());
            this.bYK = true;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_click_to_rank_forums_tip", true);
        }
    }

    public void av(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.bYD.isShowing() && !u.v(list)) {
            this.bYD.au(list);
        }
    }

    public boolean ach() {
        return this.bYK;
    }
}
