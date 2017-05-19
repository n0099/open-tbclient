package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.core.view.ah;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private View bAJ;
    private final com.baidu.tieba.enterForum.home.e bGC;
    private ViewEventCenter bGb;
    private com.baidu.tieba.enterForum.a.a bHE;
    private q bHF;
    private com.baidu.tieba.enterForum.model.d bHG;
    private boolean bHH;
    private List<com.baidu.tieba.enterForum.b.g> bHI;
    private List<com.baidu.tieba.enterForum.b.j> bHJ;
    private CommonTipView bHK;
    private TextView bHL;
    private boolean bHM;
    private BdListView bkP;
    private y mNoDataView;
    private ah mPullView;
    private com.baidu.adp.lib.guide.d bDm = null;
    private Handler mHandler = new Handler();
    private Runnable bHN = new d(this);
    private Runnable bHO = new e(this);

    public c(com.baidu.tieba.enterForum.home.e eVar, View view, ViewEventCenter viewEventCenter) {
        this.bHM = false;
        this.bGC = eVar;
        this.bGb = viewEventCenter;
        this.bHG = new com.baidu.tieba.enterForum.model.d(eVar.getPageContext(), viewEventCenter);
        ab(view);
        this.bHE = new com.baidu.tieba.enterForum.a.a(this.bGC.getPageContext(), this.bGb);
        this.bkP.setAdapter((ListAdapter) this.bHE);
        this.bHM = com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("show_long_click_to_rank_forums_tip", false);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void ab(View view) {
        this.bkP = (BdListView) view.findViewById(w.h.listview);
        this.bkP.setVerticalScrollBarEnabled(false);
        this.mPullView = new ah(this.bGC.getPageContext());
        this.mPullView.setTag(this.bGC.getUniqueId());
        this.bkP.setPullRefresh(this.mPullView);
        this.bHF = new q(this.bGC.getFragmentActivity());
        this.bHF.setEventCenter(this.bGb);
        this.bkP.addHeaderView(this.bHF);
        this.bHL = (TextView) BdListViewHelper.a(this.bGC.getPageContext().getPageActivity(), this.bkP, BdListViewHelper.HeadType.DEFAULT);
        this.bAJ = new View(this.bGC.getActivity());
        this.bAJ.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.bGC.getActivity(), w.f.ds0)));
    }

    public void ac(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bGC.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.net_refresh_emotion, com.baidu.adp.lib.util.k.g(this.bGC.getPageContext().getContext(), w.f.ds300), com.baidu.adp.lib.util.k.g(this.bGC.getPageContext().getContext(), w.f.ds480), com.baidu.adp.lib.util.k.g(this.bGC.getPageContext().getContext(), w.f.ds360)), NoDataViewFactory.d.ae(this.bGC.getString(w.l.neterror), this.bGC.getString(w.l.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bGC.getString(w.l.refresh_view_button_text), new f(this))));
        }
        this.mNoDataView.onChangeSkinType(this.bGC.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bkP.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bkP.setVisibility(0);
    }

    public boolean isEmpty() {
        return x.r(this.bHI) && x.r(this.bHJ);
    }

    public void b(com.baidu.tieba.enterForum.b.g gVar) {
        this.bHG.b(gVar);
    }

    public boolean Wr() {
        return this.bHH;
    }

    public BdListView WJ() {
        return this.bkP;
    }

    public void WK() {
        f(this.bHG.getDataList(), this.bHJ);
    }

    public void hr(int i) {
        this.bHH = true;
        if (this.bHG.WE() == null) {
            this.bHG.WF();
            this.bHG.WE().setVisibility(8);
        }
        m WE = this.bHG.WE();
        WE.o(this.bGC.getPageContext());
        if (WE.getParent() == null && this.bGC.Wj() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bGC.We().getId());
            this.bGC.We().addView(WE);
            this.bGC.Wi();
        }
        this.bHG.ag(this.bHI);
        com.baidu.adp.lib.g.h.fS().post(new g(this, i));
    }

    public void WL() {
        this.bHH = false;
        this.bkP.setVisibility(0);
        if (this.bHG.WE() != null && this.bGC.We() != null) {
            this.bGC.We().removeView(this.bHG.WE());
            this.bHG.WE().setVisibility(8);
        }
        this.bGC.Wi();
    }

    public void WM() {
        this.bHH = true;
        this.bkP.setVisibility(8);
        if (this.bHG.WE() != null) {
            this.bHG.WE().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs(int i) {
        if (this.bHG.WE() != null && this.bkP != null && this.bkP.getChildCount() > 0) {
            int firstVisiblePosition = (this.bkP.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bkP.getChildAt(0);
            this.bHG.WE().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bkP.startPullRefresh();
    }

    public void WN() {
        this.bkP.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.b.g> WO() {
        return this.bHI;
    }

    public List<com.baidu.tieba.enterForum.b.g> WP() {
        List<com.baidu.tieba.enterForum.b.g> dataList = this.bHG.getDataList();
        com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) x.c(dataList, 0);
        if (gVar != null && gVar.getType() == 1) {
            x.d(dataList, 0);
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
        this.bHE.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(List<com.baidu.tieba.enterForum.b.g> list, List<com.baidu.tieba.enterForum.b.j> list2) {
        boolean z;
        List<com.baidu.tieba.enterForum.b.c> a;
        this.bHI = list;
        this.bHJ = list2;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.b.c> a2 = a(list, false, 0, 0);
        if (x.q(a2) == 1 && (a2.get(0) instanceof com.baidu.tieba.enterForum.b.a)) {
            com.baidu.tieba.enterForum.b.a aVar = (com.baidu.tieba.enterForum.b.a) a2.get(0);
            if (aVar.VR().getType() == 1 && aVar.VS().getType() == 2) {
                z = false;
                if (!x.r(a2)) {
                    arrayList.add(new com.baidu.tieba.enterForum.b.d(this.bGC.getPageContext().getResources().getString(w.l.my_attention_bar), z));
                    arrayList.addAll(a2);
                }
                a = a(list2, false, 3, 3);
                if (!x.r(a)) {
                    com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.bGC.getPageContext().getResources().getString(w.l.group_fourm_recommend_title), false);
                    dVar.bGp = w.f.ds40;
                    arrayList.add(dVar);
                    arrayList.addAll(a);
                }
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setType(2);
                arrayList.add(cVar);
                hideNoDataView();
                this.bHE.setData(arrayList);
                if (!this.bHH) {
                    this.bkP.setVisibility(8);
                    return;
                }
                WL();
                this.bHF.setVisibility(0);
                if (!this.bHM && x.q(list) >= 2) {
                    this.mHandler.postDelayed(this.bHO, 500L);
                    return;
                }
                return;
            }
        }
        z = true;
        if (!x.r(a2)) {
        }
        a = a(list2, false, 3, 3);
        if (!x.r(a)) {
        }
        com.baidu.tieba.enterForum.b.c cVar2 = new com.baidu.tieba.enterForum.b.c();
        cVar2.setType(2);
        arrayList.add(cVar2);
        hideNoDataView();
        this.bHE.setData(arrayList);
        if (!this.bHH) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bkP.removeFooterView(this.bAJ);
            this.bkP.addFooterView(this.bAJ);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bkP.removeFooterView(this.bAJ);
        }
        if (this.mPullView != null) {
            this.mPullView.di(i);
        }
        if (this.bHF != null) {
            this.bHF.o(this.bGC.getPageContext());
        }
        if (this.bHG.WE() != null && this.bHG.WE().getVisibility() == 0) {
            this.bHG.o(this.bGC.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bGC.getPageContext(), i);
        }
    }

    public void a(ae.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.bHF != null) {
            this.bHF.setSearchHint(str);
        }
    }

    public void WQ() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("enter_forum_login_tip", true)) {
            if (this.bHK == null) {
                this.bHK = new CommonTipView(this.bGC.getActivity());
            }
            this.bHK.setText(w.l.enter_forum_login_tip);
            this.bHK.b(this.bGC.We(), TbadkCoreApplication.m9getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.bHK != null) {
            this.bHK.onDestroy();
        }
        this.mHandler.removeCallbacks(this.bHN);
        this.mHandler.removeCallbacks(this.bHO);
    }

    public void WR() {
        if (!this.bHM) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.o(this.bHF).ad(178).z(false);
            gVar.a(new i(this));
            this.bDm = gVar.fc();
            this.bDm.j(this.bGC.getPageContext().getPageActivity());
            this.bHM = true;
            com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("show_long_click_to_rank_forums_tip", true);
        }
    }
}
