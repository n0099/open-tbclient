package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.z;
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
    private View bHv;
    private final com.baidu.tieba.enterForum.home.e bSS;
    private ViewEventCenter bSq;
    private com.baidu.tieba.enterForum.a.a bUm;
    private p bUn;
    private com.baidu.tieba.enterForum.model.d bUo;
    private com.baidu.tieba.enterForum.multiConcern.b bUp;
    private boolean bUr;
    private List<com.baidu.tieba.enterForum.b.g> bUs;
    private List<com.baidu.tieba.enterForum.b.j> bUt;
    private CommonTipView bUu;
    private TextView bUv;
    private boolean bUw;
    private BdListView bpM;
    private y mNoDataView;
    private ah mPullView;
    private boolean bUq = false;
    private com.baidu.adp.lib.guide.d bJU = null;
    private Handler mHandler = new Handler();
    private Runnable bUx = new d(this);

    public c(com.baidu.tieba.enterForum.home.e eVar, View view, ViewEventCenter viewEventCenter) {
        this.bUw = false;
        this.bSS = eVar;
        this.bSq = viewEventCenter;
        this.bUo = new com.baidu.tieba.enterForum.model.d(eVar.getPageContext(), viewEventCenter);
        this.bUp = new com.baidu.tieba.enterForum.multiConcern.b(eVar.getPageContext(), eVar.getBaseFragmentActivity().oH(), viewEventCenter);
        ac(view);
        this.bUm = new com.baidu.tieba.enterForum.a.a(this.bSS.getPageContext(), this.bSq);
        this.bpM.setAdapter((ListAdapter) this.bUm);
        this.bUw = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_click_to_rank_forums_tip", false);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void ac(View view) {
        this.bpM = (BdListView) view.findViewById(w.h.listview);
        this.bpM.setVerticalScrollBarEnabled(false);
        this.mPullView = new ah(this.bSS.getPageContext());
        this.mPullView.setTag(this.bSS.getUniqueId());
        this.bpM.setPullRefresh(this.mPullView);
        this.bUn = new p(this.bSS.getFragmentActivity());
        this.bUn.setEventCenter(this.bSq);
        this.bpM.addHeaderView(this.bUn);
        this.bUv = (TextView) BdListViewHelper.a(this.bSS.getPageContext().getPageActivity(), this.bpM, BdListViewHelper.HeadType.DEFAULT);
        this.bHv = new View(this.bSS.getActivity());
        this.bHv.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.bSS.getActivity(), w.f.ds0)));
    }

    public void ad(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bSS.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.net_refresh_emotion, com.baidu.adp.lib.util.k.g(this.bSS.getPageContext().getContext(), w.f.ds300), com.baidu.adp.lib.util.k.g(this.bSS.getPageContext().getContext(), w.f.ds480), com.baidu.adp.lib.util.k.g(this.bSS.getPageContext().getContext(), w.f.ds360)), NoDataViewFactory.d.ad(this.bSS.getString(w.l.neterror), this.bSS.getString(w.l.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bSS.getString(w.l.refresh_view_button_text), new e(this))));
        }
        this.mNoDataView.onChangeSkinType(this.bSS.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bpM.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bpM.setVisibility(0);
    }

    public boolean isEmpty() {
        return z.t(this.bUs) && z.t(this.bUt);
    }

    public void b(com.baidu.tieba.enterForum.b.g gVar) {
        this.bUo.b(gVar);
    }

    public void ed(boolean z) {
        this.bUq = z;
    }

    public boolean aaR() {
        return this.bUr;
    }

    public BdListView abm() {
        return this.bpM;
    }

    public void abn() {
        i(this.bUo.getDataList(), this.bUt);
    }

    public void hZ(int i) {
        this.bUr = true;
        if (this.bUo.abf() == null) {
            this.bUo.abg();
            this.bUo.abf().setVisibility(8);
        }
        l abf = this.bUo.abf();
        abf.n(this.bSS.getPageContext());
        if (abf.getParent() == null && this.bSS.aaJ() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bSS.aaE().getId());
            this.bSS.aaE().addView(abf);
            this.bSS.aaI();
        }
        this.bUo.am(this.bUs);
        com.baidu.adp.lib.g.h.fR().post(new f(this, i));
    }

    public void abo() {
        this.bUr = false;
        this.bpM.setVisibility(0);
        if (this.bUo.abf() != null && this.bSS.aaE() != null) {
            this.bSS.aaE().removeView(this.bUo.abf());
            this.bUo.abf().setVisibility(8);
        }
        this.bSS.aaI();
    }

    public void abp() {
        this.bUr = true;
        this.bpM.setVisibility(8);
        if (this.bUo.abf() != null) {
            this.bUo.abf().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(int i) {
        if (this.bUo.abf() != null && this.bpM != null && this.bpM.getChildCount() > 0) {
            int firstVisiblePosition = (this.bpM.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bpM.getChildAt(0);
            this.bUo.abf().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bpM.startPullRefresh();
    }

    public void abq() {
        this.bpM.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.b.g> abr() {
        return this.bUs;
    }

    public List<com.baidu.tieba.enterForum.b.g> abs() {
        List<com.baidu.tieba.enterForum.b.g> dataList = this.bUo.getDataList();
        com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) z.c(dataList, 0);
        if (gVar != null && gVar.getType() == 1) {
            z.d(dataList, 0);
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
        this.bUm.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(List<com.baidu.tieba.enterForum.b.g> list, List<com.baidu.tieba.enterForum.b.j> list2) {
        boolean z;
        List<com.baidu.tieba.enterForum.b.c> a;
        this.bUs = list;
        this.bUt = list2;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.b.c> a2 = a(list, false, 0, 0);
        if (z.s(a2) == 1 && (a2.get(0) instanceof com.baidu.tieba.enterForum.b.a)) {
            com.baidu.tieba.enterForum.b.a aVar = (com.baidu.tieba.enterForum.b.a) a2.get(0);
            if (aVar.aaq().getType() == 1 && aVar.aar().getType() == 2) {
                z = false;
                if (!z.t(a2)) {
                    arrayList.add(new com.baidu.tieba.enterForum.b.d(this.bSS.getPageContext().getResources().getString(w.l.my_attention_bar), z));
                    arrayList.addAll(a2);
                }
                a = a(list2, false, 3, 3);
                if (!z.t(a)) {
                    com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.bSS.getPageContext().getResources().getString(w.l.group_fourm_recommend_title), false);
                    dVar.bSF = w.f.ds40;
                    arrayList.add(dVar);
                    arrayList.addAll(a);
                }
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setType(2);
                arrayList.add(cVar);
                hideNoDataView();
                this.bUm.setData(arrayList);
                if (!this.bUr) {
                    this.bpM.setVisibility(8);
                    return;
                }
                abo();
                this.bUn.setVisibility(0);
                if (!this.bUw && z.s(list) >= 2 && this.bUp != null && !this.bUp.isShowing()) {
                    this.mHandler.postDelayed(this.bUx, 500L);
                    return;
                }
                return;
            }
        }
        z = true;
        if (!z.t(a2)) {
        }
        a = a(list2, false, 3, 3);
        if (!z.t(a)) {
        }
        com.baidu.tieba.enterForum.b.c cVar2 = new com.baidu.tieba.enterForum.b.c();
        cVar2.setType(2);
        arrayList.add(cVar2);
        hideNoDataView();
        this.bUm.setData(arrayList);
        if (!this.bUr) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bpM.removeFooterView(this.bHv);
            this.bpM.addFooterView(this.bHv);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bpM.removeFooterView(this.bHv);
        }
        if (this.mPullView != null) {
            this.mPullView.dl(i);
        }
        if (this.bUn != null) {
            this.bUn.n(this.bSS.getPageContext());
        }
        if (this.bUo.abf() != null && this.bUo.abf().getVisibility() == 0) {
            this.bUo.n(this.bSS.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bSS.getPageContext(), i);
        }
        if (this.bUp.abl() != null) {
            this.bUp.onChangeSkinType();
        }
    }

    public void a(ae.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.bUn != null) {
            this.bUn.setSearchHint(str);
        }
    }

    public void abt() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.bUu == null) {
                this.bUu = new CommonTipView(this.bSS.getActivity());
            }
            this.bUu.setText(w.l.enter_forum_login_tip);
            this.bUu.b(this.bSS.aaE(), TbadkCoreApplication.m9getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.bUu != null) {
            this.bUu.onDestroy();
        }
        this.mHandler.removeCallbacks(this.bUx);
        if (this.bUp != null) {
            this.bUp.onDestroy();
        }
    }

    public void aaS() {
        if (this.bJU != null) {
            this.bJU.dismiss();
        }
    }

    public void abu() {
        if (!this.bUw && this.bSS.isPrimary() && !this.bUq) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.o(this.bUn).ad(178).z(false);
            gVar.a(new h(this));
            this.bJU = gVar.fb();
            this.bJU.j(this.bSS.getPageContext().getPageActivity());
            this.bUw = true;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_click_to_rank_forums_tip", true);
        }
    }

    public void ap(List<com.baidu.tieba.enterForum.multiConcern.g> list) {
        if (!this.bUp.isShowing() && !z.t(list)) {
            this.bUp.ao(list);
        }
    }

    public boolean abv() {
        return this.bUw;
    }
}
