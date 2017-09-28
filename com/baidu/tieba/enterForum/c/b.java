package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private View bQQ;
    private BdListView bze;
    private final com.baidu.tieba.enterForum.home.a ccO;
    private ViewEventCenter ccl;
    private com.baidu.tieba.enterForum.a.a ceg;
    private f ceh;
    private com.baidu.tieba.enterForum.model.c cei;
    private com.baidu.tieba.enterForum.multiConcern.a cej;
    private boolean cek = false;
    private boolean cel;
    private List<g> cem;
    private CommonTipView cen;
    private TextView ceo;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private h mPullView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.ccO = aVar;
        this.ccl = viewEventCenter;
        this.cei = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.cej = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oQ(), viewEventCenter);
        an(view);
        this.ceg = new com.baidu.tieba.enterForum.a.a(this.ccO.getPageContext(), this.ccl);
        this.bze.setAdapter((ListAdapter) this.ceg);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void an(View view) {
        this.bze = (BdListView) view.findViewById(d.h.listview);
        this.bze.setVerticalScrollBarEnabled(false);
        this.mPullView = new h(this.ccO.getPageContext());
        this.mPullView.setTag(this.ccO.getUniqueId());
        this.bze.setPullRefresh(this.mPullView);
        this.ceh = new f(this.ccO.getFragmentActivity());
        this.ceh.setEventCenter(this.ccl);
        this.bze.addHeaderView(this.ceh);
        this.ceo = (TextView) BdListViewHelper.a(this.ccO.getPageContext().getPageActivity(), this.bze, BdListViewHelper.HeadType.DEFAULT);
        this.bQQ = new View(this.ccO.getActivity());
        this.bQQ.setLayoutParams(new AbsListView.LayoutParams(-1, l.f(this.ccO.getActivity(), d.f.ds0)));
    }

    public void ao(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ccO.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.net_refresh_emotion, l.f(this.ccO.getPageContext().getContext(), d.f.ds300), l.f(this.ccO.getPageContext().getContext(), d.f.ds480), l.f(this.ccO.getPageContext().getContext(), d.f.ds360)), NoDataViewFactory.d.ag(this.ccO.getString(d.l.neterror), this.ccO.getString(d.l.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ccO.getString(d.l.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.ceh.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.ccO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bze.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bze.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.u(this.cem);
    }

    public void b(g gVar) {
        this.cei.b(gVar);
    }

    public void ek(boolean z) {
        this.cek = z;
    }

    public boolean acY() {
        return this.cel;
    }

    public BdListView ads() {
        return this.bze;
    }

    public void adt() {
        av(this.cei.getDataList());
    }

    public void iC(final int i) {
        this.cel = true;
        if (this.cei.adl() == null) {
            this.cei.adm();
            this.cei.adl().setVisibility(8);
        }
        d adl = this.cei.adl();
        adl.k(this.ccO.getPageContext());
        if (adl.getParent() == null && this.ccO.acR() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.ccO.acM().getId());
            this.ccO.acM().addView(adl);
            this.ccO.acQ();
        }
        this.cei.as(this.cem);
        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.iD(i);
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.cei.adl() != null) {
                            b.this.cei.adl().setVisibility(0);
                            b.this.bze.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void adu() {
        this.cel = false;
        this.bze.setVisibility(0);
        if (this.cei.adl() != null && this.ccO.acM() != null) {
            this.ccO.acM().removeView(this.cei.adl());
            this.cei.adl().setVisibility(8);
        }
        this.ccO.acQ();
    }

    public void adv() {
        this.cel = true;
        this.bze.setVisibility(8);
        if (this.cei.adl() != null) {
            this.cei.adl().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iD(int i) {
        if (this.cei.adl() != null && this.bze != null && this.bze.getChildCount() > 0) {
            int firstVisiblePosition = (this.bze.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bze.getChildAt(0);
            this.cei.adl().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bze.startPullRefresh();
    }

    public void adw() {
        this.bze.completePullRefreshPostDelayed(2000L);
    }

    public List<g> adx() {
        return this.cem;
    }

    public List<g> ady() {
        List<g> dataList = this.cei.getDataList();
        g gVar = (g) v.c(dataList, 0);
        if (gVar != null && gVar.getType() == 1) {
            v.d(dataList, 0);
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
        this.ceg.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void av(List<g> list) {
        boolean z;
        this.cem = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.b.c> a = a(list, false, 0, 0);
        if (v.t(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.b.a)) {
            com.baidu.tieba.enterForum.b.a aVar = (com.baidu.tieba.enterForum.b.a) a.get(0);
            if (aVar.acA().getType() == 1 && aVar.acB().getType() == 2) {
                z = false;
                if (v.u(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.b.d(this.ccO.getPageContext().getResources().getString(d.l.my_attention_bar), z));
                    arrayList.addAll(a);
                } else {
                    com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                    cVar.setType(3);
                    arrayList.add(cVar);
                }
                com.baidu.tieba.enterForum.b.c cVar2 = new com.baidu.tieba.enterForum.b.c();
                cVar2.setType(2);
                arrayList.add(cVar2);
                hideNoDataView();
                this.ceg.setData(arrayList);
                if (!this.cel) {
                    this.bze.setVisibility(8);
                    return;
                }
                adu();
                this.ceh.setVisibility(0);
                return;
            }
        }
        z = true;
        if (v.u(a)) {
        }
        com.baidu.tieba.enterForum.b.c cVar22 = new com.baidu.tieba.enterForum.b.c();
        cVar22.setType(2);
        arrayList.add(cVar22);
        hideNoDataView();
        this.ceg.setData(arrayList);
        if (!this.cel) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bze.removeFooterView(this.bQQ);
            this.bze.addFooterView(this.bQQ);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bze.removeFooterView(this.bQQ);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.ceh != null) {
            this.ceh.k(this.ccO.getPageContext());
        }
        if (this.cei.adl() != null && this.cei.adl().getVisibility() == 0) {
            this.cei.k(this.ccO.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ccO.getPageContext(), i);
        }
        if (this.cej.adr() != null) {
            this.cej.onChangeSkinType();
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.ceh != null) {
            this.ceh.setSearchHint(str);
        }
    }

    public void adz() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cen == null) {
                this.cen = new CommonTipView(this.ccO.getActivity());
            }
            this.cen.setText(d.l.enter_forum_login_tip);
            this.cen.a(this.ccO.acM(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cen != null) {
            this.cen.onDestroy();
        }
        if (this.cej != null) {
            this.cej.onDestroy();
        }
    }

    public void aw(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cej.isShowing() && !v.u(list)) {
            this.cej.au(list);
        }
    }
}
