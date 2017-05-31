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
    private View bGC;
    private ViewEventCenter bLQ;
    private final com.baidu.tieba.enterForum.home.e bMr;
    private boolean bNA;
    private com.baidu.tieba.enterForum.a.a bNs;
    private q bNt;
    private com.baidu.tieba.enterForum.model.d bNu;
    private boolean bNv;
    private List<com.baidu.tieba.enterForum.b.g> bNw;
    private List<com.baidu.tieba.enterForum.b.j> bNx;
    private CommonTipView bNy;
    private TextView bNz;
    private BdListView blW;
    private y mNoDataView;
    private ah mPullView;
    private com.baidu.adp.lib.guide.d bJc = null;
    private Handler mHandler = new Handler();
    private Runnable bNB = new d(this);
    private Runnable bNC = new e(this);

    public c(com.baidu.tieba.enterForum.home.e eVar, View view, ViewEventCenter viewEventCenter) {
        this.bNA = false;
        this.bMr = eVar;
        this.bLQ = viewEventCenter;
        this.bNu = new com.baidu.tieba.enterForum.model.d(eVar.getPageContext(), viewEventCenter);
        ab(view);
        this.bNs = new com.baidu.tieba.enterForum.a.a(this.bMr.getPageContext(), this.bLQ);
        this.blW.setAdapter((ListAdapter) this.bNs);
        this.bNA = com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("show_long_click_to_rank_forums_tip", false);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void ab(View view) {
        this.blW = (BdListView) view.findViewById(w.h.listview);
        this.blW.setVerticalScrollBarEnabled(false);
        this.mPullView = new ah(this.bMr.getPageContext());
        this.mPullView.setTag(this.bMr.getUniqueId());
        this.blW.setPullRefresh(this.mPullView);
        this.bNt = new q(this.bMr.getFragmentActivity());
        this.bNt.setEventCenter(this.bLQ);
        this.blW.addHeaderView(this.bNt);
        this.bNz = (TextView) BdListViewHelper.a(this.bMr.getPageContext().getPageActivity(), this.blW, BdListViewHelper.HeadType.DEFAULT);
        this.bGC = new View(this.bMr.getActivity());
        this.bGC.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.bMr.getActivity(), w.f.ds0)));
    }

    public void ac(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bMr.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.net_refresh_emotion, com.baidu.adp.lib.util.k.g(this.bMr.getPageContext().getContext(), w.f.ds300), com.baidu.adp.lib.util.k.g(this.bMr.getPageContext().getContext(), w.f.ds480), com.baidu.adp.lib.util.k.g(this.bMr.getPageContext().getContext(), w.f.ds360)), NoDataViewFactory.d.ad(this.bMr.getString(w.l.neterror), this.bMr.getString(w.l.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bMr.getString(w.l.refresh_view_button_text), new f(this))));
        }
        this.mNoDataView.onChangeSkinType(this.bMr.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.blW.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.blW.setVisibility(0);
    }

    public boolean isEmpty() {
        return x.r(this.bNw) && x.r(this.bNx);
    }

    public void b(com.baidu.tieba.enterForum.b.g gVar) {
        this.bNu.b(gVar);
    }

    public boolean Xu() {
        return this.bNv;
    }

    public BdListView XM() {
        return this.blW;
    }

    public void XN() {
        h(this.bNu.getDataList(), this.bNx);
    }

    public void hP(int i) {
        this.bNv = true;
        if (this.bNu.XH() == null) {
            this.bNu.XI();
            this.bNu.XH().setVisibility(8);
        }
        m XH = this.bNu.XH();
        XH.n(this.bMr.getPageContext());
        if (XH.getParent() == null && this.bMr.Xm() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bMr.Xh().getId());
            this.bMr.Xh().addView(XH);
            this.bMr.Xl();
        }
        this.bNu.ag(this.bNw);
        com.baidu.adp.lib.g.h.fS().post(new g(this, i));
    }

    public void XO() {
        this.bNv = false;
        this.blW.setVisibility(0);
        if (this.bNu.XH() != null && this.bMr.Xh() != null) {
            this.bMr.Xh().removeView(this.bNu.XH());
            this.bNu.XH().setVisibility(8);
        }
        this.bMr.Xl();
    }

    public void XP() {
        this.bNv = true;
        this.blW.setVisibility(8);
        if (this.bNu.XH() != null) {
            this.bNu.XH().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hQ(int i) {
        if (this.bNu.XH() != null && this.blW != null && this.blW.getChildCount() > 0) {
            int firstVisiblePosition = (this.blW.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.blW.getChildAt(0);
            this.bNu.XH().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.blW.startPullRefresh();
    }

    public void XQ() {
        this.blW.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.b.g> XR() {
        return this.bNw;
    }

    public List<com.baidu.tieba.enterForum.b.g> XS() {
        List<com.baidu.tieba.enterForum.b.g> dataList = this.bNu.getDataList();
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
        this.bNs.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(List<com.baidu.tieba.enterForum.b.g> list, List<com.baidu.tieba.enterForum.b.j> list2) {
        boolean z;
        List<com.baidu.tieba.enterForum.b.c> a;
        this.bNw = list;
        this.bNx = list2;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.b.c> a2 = a(list, false, 0, 0);
        if (x.q(a2) == 1 && (a2.get(0) instanceof com.baidu.tieba.enterForum.b.a)) {
            com.baidu.tieba.enterForum.b.a aVar = (com.baidu.tieba.enterForum.b.a) a2.get(0);
            if (aVar.WU().getType() == 1 && aVar.WV().getType() == 2) {
                z = false;
                if (!x.r(a2)) {
                    arrayList.add(new com.baidu.tieba.enterForum.b.d(this.bMr.getPageContext().getResources().getString(w.l.my_attention_bar), z));
                    arrayList.addAll(a2);
                }
                a = a(list2, false, 3, 3);
                if (!x.r(a)) {
                    com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d(this.bMr.getPageContext().getResources().getString(w.l.group_fourm_recommend_title), false);
                    dVar.bMe = w.f.ds40;
                    arrayList.add(dVar);
                    arrayList.addAll(a);
                }
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setType(2);
                arrayList.add(cVar);
                hideNoDataView();
                this.bNs.setData(arrayList);
                if (!this.bNv) {
                    this.blW.setVisibility(8);
                    return;
                }
                XO();
                this.bNt.setVisibility(0);
                if (!this.bNA && x.q(list) >= 2) {
                    this.mHandler.postDelayed(this.bNC, 500L);
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
        this.bNs.setData(arrayList);
        if (!this.bNv) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.blW.removeFooterView(this.bGC);
            this.blW.addFooterView(this.bGC);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.blW.removeFooterView(this.bGC);
        }
        if (this.mPullView != null) {
            this.mPullView.dj(i);
        }
        if (this.bNt != null) {
            this.bNt.n(this.bMr.getPageContext());
        }
        if (this.bNu.XH() != null && this.bNu.XH().getVisibility() == 0) {
            this.bNu.n(this.bMr.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bMr.getPageContext(), i);
        }
    }

    public void a(ae.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.bNt != null) {
            this.bNt.setSearchHint(str);
        }
    }

    public void XT() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.bNy == null) {
                this.bNy = new CommonTipView(this.bMr.getActivity());
            }
            this.bNy.setText(w.l.enter_forum_login_tip);
            this.bNy.b(this.bMr.Xh(), TbadkCoreApplication.m9getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.bNy != null) {
            this.bNy.onDestroy();
        }
        this.mHandler.removeCallbacks(this.bNB);
        this.mHandler.removeCallbacks(this.bNC);
    }

    public void XU() {
        if (!this.bNA && this.bMr.isPrimary()) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.o(this.bNt).ad(178).z(false);
            gVar.a(new i(this));
            this.bJc = gVar.fc();
            this.bJc.j(this.bMr.getPageContext().getPageActivity());
            this.bNA = true;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_long_click_to_rank_forums_tip", true);
        }
    }
}
