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
    private BdListView bMe;
    private View cgT;
    private ViewEventCenter csw;
    private final com.baidu.tieba.enterForum.home.a cuo;
    private com.baidu.tieba.enterForum.a.a cup;
    private f cuq;
    private com.baidu.tieba.enterForum.model.c cur;
    private com.baidu.tieba.enterForum.multiConcern.a cus;
    private boolean cut;
    private List<com.baidu.tieba.enterForum.data.f> cuu;
    private CommonTipView cuv;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private h mPullView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.cuo = aVar;
        this.csw = viewEventCenter;
        this.cur = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.cus = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oX(), viewEventCenter);
        as(view);
        this.cup = new com.baidu.tieba.enterForum.a.a(this.cuo.getPageContext(), this.csw);
        this.bMe.setAdapter((ListAdapter) this.cup);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void as(View view) {
        this.bMe = (BdListView) view.findViewById(d.g.listview);
        this.bMe.setVerticalScrollBarEnabled(false);
        this.mPullView = new h(this.cuo.getPageContext());
        this.mPullView.setTag(this.cuo.getUniqueId());
        this.bMe.setPullRefresh(this.mPullView);
        this.cuq = new f(this.cuo.getFragmentActivity());
        this.cuq.setEventCenter(this.csw);
        this.bMe.addHeaderView(this.cuq);
        BdListViewHelper.a(this.cuo.getPageContext().getPageActivity(), this.bMe, BdListViewHelper.HeadType.DEFAULT);
        this.cgT = new View(this.cuo.getActivity());
        this.cgT.setLayoutParams(new AbsListView.LayoutParams(-1, l.f(this.cuo.getActivity(), d.e.ds0)));
    }

    public View agX() {
        this.cuq.jp(l.f(this.cuo.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.cuo.getPageContext().getPageActivity(), this.bMe, BdListViewHelper.HeadType.TIP);
    }

    public void ar(View view) {
        this.cuq.jp(l.f(this.cuo.getPageContext().getPageActivity(), d.e.ds10));
        this.bMe.removeHeaderView(view);
    }

    public void at(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cuo.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, l.f(this.cuo.getPageContext().getContext(), d.e.ds300), l.f(this.cuo.getPageContext().getContext(), d.e.ds480), l.f(this.cuo.getPageContext().getContext(), d.e.ds360)), NoDataViewFactory.d.af(this.cuo.getString(d.j.neterror), this.cuo.getString(d.j.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cuo.getString(d.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.cuq.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.cuo.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bMe.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bMe.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.w(this.cuu);
    }

    public void b(com.baidu.tieba.enterForum.data.f fVar) {
        this.cur.b(fVar);
    }

    public boolean ahc() {
        return this.cut;
    }

    public BdListView ahu() {
        return this.bMe;
    }

    public void ahv() {
        aJ(this.cur.getDataList());
    }

    public void jn(final int i) {
        this.cut = true;
        if (this.cur.ahp() == null) {
            this.cur.createView();
            this.cur.ahp().setVisibility(8);
        }
        d ahp = this.cur.ahp();
        ahp.onChangeSkinType(this.cuo.getPageContext());
        if (ahp.getParent() == null && this.cuo.agU() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cuo.agO().getId());
            this.cuo.agO().addView(ahp);
            this.cuo.agT();
        }
        this.cur.aG(this.cuu);
        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.jo(i);
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.cur.ahp() != null) {
                            b.this.cur.ahp().setVisibility(0);
                            b.this.bMe.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void ahw() {
        this.cut = false;
        this.bMe.setVisibility(0);
        if (this.cur.ahp() != null && this.cuo.agO() != null) {
            this.cuo.agO().removeView(this.cur.ahp());
            this.cur.ahp().setVisibility(8);
        }
        this.cuo.agT();
    }

    public void ahx() {
        this.cut = true;
        this.bMe.setVisibility(8);
        if (this.cur.ahp() != null) {
            this.cur.ahp().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jo(int i) {
        if (this.cur.ahp() != null && this.bMe != null && this.bMe.getChildCount() > 0) {
            int firstVisiblePosition = (this.bMe.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bMe.getChildAt(0);
            this.cur.ahp().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bMe.startPullRefresh();
    }

    public void ahy() {
        this.bMe.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.data.f> ahz() {
        return this.cuu;
    }

    public List<com.baidu.tieba.enterForum.data.f> ahA() {
        List<com.baidu.tieba.enterForum.data.f> dataList = this.cur.getDataList();
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
        this.cup.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aJ(List<com.baidu.tieba.enterForum.data.f> list) {
        boolean z;
        this.cuu = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (v.v(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.data.a)) {
            com.baidu.tieba.enterForum.data.a aVar = (com.baidu.tieba.enterForum.data.a) a.get(0);
            if (aVar.agD().getType() == 1 && aVar.agE().getType() == 2) {
                z = false;
                if (v.w(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.data.d(this.cuo.getPageContext().getResources().getString(d.j.my_attention_bar), z));
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
                this.cup.setData(arrayList);
                if (!this.cut) {
                    this.bMe.setVisibility(8);
                    return;
                }
                ahw();
                this.cuq.setVisibility(0);
                return;
            }
        }
        z = true;
        if (v.w(a)) {
        }
        com.baidu.tieba.enterForum.data.c cVar22 = new com.baidu.tieba.enterForum.data.c();
        cVar22.setType(2);
        arrayList.add(cVar22);
        hideNoDataView();
        this.cup.setData(arrayList);
        if (!this.cut) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bMe.removeFooterView(this.cgT);
            this.bMe.addFooterView(this.cgT);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bMe.removeFooterView(this.cgT);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.cuq != null) {
            this.cuq.onChangeSkinType(this.cuo.getPageContext());
        }
        if (this.cur.ahp() != null && this.cur.ahp().getVisibility() == 0) {
            this.cur.onChangeSkinType(this.cuo.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cuo.getPageContext(), i);
        }
        if (this.cus.aht() != null) {
            this.cus.onChangeSkinType();
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cuq != null) {
            this.cuq.setSearchHint(str);
        }
    }

    public void ahB() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cuv == null) {
                this.cuv = new CommonTipView(this.cuo.getActivity());
            }
            this.cuv.setText(d.j.enter_forum_login_tip);
            this.cuv.show(this.cuo.agO(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cuv != null) {
            this.cuv.onDestroy();
        }
        if (this.cus != null) {
            this.cus.onDestroy();
        }
    }

    public void aK(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cus.isShowing() && !v.w(list)) {
            this.cus.aI(list);
        }
    }
}
