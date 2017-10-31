package com.baidu.tieba.enterForum.b;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private BdListView bDR;
    private View bYj;
    private ViewEventCenter cjC;
    private final com.baidu.tieba.enterForum.home.a cjY;
    private com.baidu.tieba.enterForum.a.a clp;
    private f clq;
    private com.baidu.tieba.enterForum.model.c clr;
    private com.baidu.tieba.enterForum.multiConcern.a cls;
    private boolean clt;
    private List<com.baidu.tieba.enterForum.data.f> clu;
    private CommonTipView clv;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private h mPullView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.cjY = aVar;
        this.cjC = viewEventCenter;
        this.clr = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.cls = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oQ(), viewEventCenter);
        aq(view);
        this.clp = new com.baidu.tieba.enterForum.a.a(this.cjY.getPageContext(), this.cjC);
        this.bDR.setAdapter((ListAdapter) this.clp);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aq(View view) {
        this.bDR = (BdListView) view.findViewById(d.g.listview);
        this.bDR.setVerticalScrollBarEnabled(false);
        this.mPullView = new h(this.cjY.getPageContext());
        this.mPullView.setTag(this.cjY.getUniqueId());
        this.bDR.setPullRefresh(this.mPullView);
        this.clq = new f(this.cjY.getFragmentActivity());
        this.clq.setEventCenter(this.cjC);
        this.bDR.addHeaderView(this.clq);
        BdListViewHelper.a(this.cjY.getPageContext().getPageActivity(), this.bDR, BdListViewHelper.HeadType.DEFAULT);
        this.bYj = new View(this.cjY.getActivity());
        this.bYj.setLayoutParams(new AbsListView.LayoutParams(-1, l.f(this.cjY.getActivity(), d.e.ds0)));
    }

    public void ar(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cjY.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, l.f(this.cjY.getPageContext().getContext(), d.e.ds300), l.f(this.cjY.getPageContext().getContext(), d.e.ds480), l.f(this.cjY.getPageContext().getContext(), d.e.ds360)), NoDataViewFactory.d.af(this.cjY.getString(d.j.neterror), this.cjY.getString(d.j.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cjY.getString(d.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.clq.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.cjY.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bDR.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bDR.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.v(this.clu);
    }

    public void b(com.baidu.tieba.enterForum.data.f fVar) {
        this.clr.b(fVar);
    }

    public boolean afc() {
        return this.clt;
    }

    public BdListView afv() {
        return this.bDR;
    }

    public void afw() {
        ax(this.clr.getDataList());
    }

    public void iR(final int i) {
        this.clt = true;
        if (this.clr.afp() == null) {
            this.clr.createView();
            this.clr.afp().setVisibility(8);
        }
        d afp = this.clr.afp();
        afp.k(this.cjY.getPageContext());
        if (afp.getParent() == null && this.cjY.aeV() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cjY.aeQ().getId());
            this.cjY.aeQ().addView(afp);
            this.cjY.aeU();
        }
        this.clr.au(this.clu);
        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.iS(i);
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.clr.afp() != null) {
                            b.this.clr.afp().setVisibility(0);
                            b.this.bDR.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void afx() {
        this.clt = false;
        this.bDR.setVisibility(0);
        if (this.clr.afp() != null && this.cjY.aeQ() != null) {
            this.cjY.aeQ().removeView(this.clr.afp());
            this.clr.afp().setVisibility(8);
        }
        this.cjY.aeU();
    }

    public void afy() {
        this.clt = true;
        this.bDR.setVisibility(8);
        if (this.clr.afp() != null) {
            this.clr.afp().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS(int i) {
        if (this.clr.afp() != null && this.bDR != null && this.bDR.getChildCount() > 0) {
            int firstVisiblePosition = (this.bDR.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bDR.getChildAt(0);
            this.clr.afp().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bDR.startPullRefresh();
    }

    public void afz() {
        this.bDR.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.data.f> afA() {
        return this.clu;
    }

    public List<com.baidu.tieba.enterForum.data.f> afB() {
        List<com.baidu.tieba.enterForum.data.f> dataList = this.clr.getDataList();
        com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) v.c(dataList, 0);
        if (fVar != null && fVar.getType() == 1) {
            v.d(dataList, 0);
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
        this.clp.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ax(List<com.baidu.tieba.enterForum.data.f> list) {
        boolean z;
        this.clu = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (v.u(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.data.a)) {
            com.baidu.tieba.enterForum.data.a aVar = (com.baidu.tieba.enterForum.data.a) a.get(0);
            if (aVar.aeF().getType() == 1 && aVar.aeG().getType() == 2) {
                z = false;
                if (v.v(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.data.d(this.cjY.getPageContext().getResources().getString(d.j.my_attention_bar), z));
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
                this.clp.setData(arrayList);
                if (!this.clt) {
                    this.bDR.setVisibility(8);
                    return;
                }
                afx();
                this.clq.setVisibility(0);
                return;
            }
        }
        z = true;
        if (v.v(a)) {
        }
        com.baidu.tieba.enterForum.data.c cVar22 = new com.baidu.tieba.enterForum.data.c();
        cVar22.setType(2);
        arrayList.add(cVar22);
        hideNoDataView();
        this.clp.setData(arrayList);
        if (!this.clt) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bDR.removeFooterView(this.bYj);
            this.bDR.addFooterView(this.bYj);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bDR.removeFooterView(this.bYj);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.clq != null) {
            this.clq.k(this.cjY.getPageContext());
        }
        if (this.clr.afp() != null && this.clr.afp().getVisibility() == 0) {
            this.clr.k(this.cjY.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cjY.getPageContext(), i);
        }
        if (this.cls.afu() != null) {
            this.cls.onChangeSkinType();
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.clq != null) {
            this.clq.setSearchHint(str);
        }
    }

    public void afC() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.clv == null) {
                this.clv = new CommonTipView(this.cjY.getActivity());
            }
            this.clv.setText(d.j.enter_forum_login_tip);
            this.clv.show(this.cjY.aeQ(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.clv != null) {
            this.clv.onDestroy();
        }
        if (this.cls != null) {
            this.cls.onDestroy();
        }
    }

    public void ay(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cls.isShowing() && !v.v(list)) {
            this.cls.aw(list);
        }
    }
}
