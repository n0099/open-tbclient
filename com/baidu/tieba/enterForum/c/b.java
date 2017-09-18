package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.core.view.l;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private View bRj;
    private BdListView bxv;
    private final com.baidu.tieba.enterForum.home.a ccO;
    private ViewEventCenter ccl;
    private com.baidu.tieba.enterForum.a.a cef;
    private f ceg;
    private com.baidu.tieba.enterForum.model.c ceh;
    private com.baidu.tieba.enterForum.multiConcern.a cei;
    private boolean cej = false;
    private boolean cek;
    private List<g> cel;
    private CommonTipView cem;
    private TextView cen;
    private j mNoDataView;
    private l mPullView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.ccO = aVar;
        this.ccl = viewEventCenter;
        this.ceh = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.cei = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oP(), viewEventCenter);
        ao(view);
        this.cef = new com.baidu.tieba.enterForum.a.a(this.ccO.getPageContext(), this.ccl);
        this.bxv.setAdapter((ListAdapter) this.cef);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ao(View view) {
        this.bxv = (BdListView) view.findViewById(d.h.listview);
        this.bxv.setVerticalScrollBarEnabled(false);
        this.mPullView = new l(this.ccO.getPageContext());
        this.mPullView.setTag(this.ccO.getUniqueId());
        this.bxv.setPullRefresh(this.mPullView);
        this.ceg = new f(this.ccO.getFragmentActivity());
        this.ceg.setEventCenter(this.ccl);
        this.bxv.addHeaderView(this.ceg);
        this.cen = (TextView) BdListViewHelper.a(this.ccO.getPageContext().getPageActivity(), this.bxv, BdListViewHelper.HeadType.DEFAULT);
        this.bRj = new View(this.ccO.getActivity());
        this.bRj.setLayoutParams(new AbsListView.LayoutParams(-1, k.f(this.ccO.getActivity(), d.f.ds0)));
    }

    public void ap(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ccO.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.net_refresh_emotion, k.f(this.ccO.getPageContext().getContext(), d.f.ds300), k.f(this.ccO.getPageContext().getContext(), d.f.ds480), k.f(this.ccO.getPageContext().getContext(), d.f.ds360)), NoDataViewFactory.d.ag(this.ccO.getString(d.l.neterror), this.ccO.getString(d.l.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ccO.getString(d.l.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.ceg.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.ccO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bxv.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bxv.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.v(this.cel);
    }

    public void b(g gVar) {
        this.ceh.b(gVar);
    }

    public void er(boolean z) {
        this.cej = z;
    }

    public boolean adl() {
        return this.cek;
    }

    public BdListView adF() {
        return this.bxv;
    }

    public void adG() {
        aw(this.ceh.getDataList());
    }

    public void iu(final int i) {
        this.cek = true;
        if (this.ceh.ady() == null) {
            this.ceh.adz();
            this.ceh.ady().setVisibility(8);
        }
        d ady = this.ceh.ady();
        ady.n(this.ccO.getPageContext());
        if (ady.getParent() == null && this.ccO.ade() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.ccO.acZ().getId());
            this.ccO.acZ().addView(ady);
            this.ccO.add();
        }
        this.ceh.at(this.cel);
        com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.iv(i);
                com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.ceh.ady() != null) {
                            b.this.ceh.ady().setVisibility(0);
                            b.this.bxv.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void adH() {
        this.cek = false;
        this.bxv.setVisibility(0);
        if (this.ceh.ady() != null && this.ccO.acZ() != null) {
            this.ccO.acZ().removeView(this.ceh.ady());
            this.ceh.ady().setVisibility(8);
        }
        this.ccO.add();
    }

    public void adI() {
        this.cek = true;
        this.bxv.setVisibility(8);
        if (this.ceh.ady() != null) {
            this.ceh.ady().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iv(int i) {
        if (this.ceh.ady() != null && this.bxv != null && this.bxv.getChildCount() > 0) {
            int firstVisiblePosition = (this.bxv.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bxv.getChildAt(0);
            this.ceh.ady().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bxv.startPullRefresh();
    }

    public void adJ() {
        this.bxv.completePullRefreshPostDelayed(2000L);
    }

    public List<g> adK() {
        return this.cel;
    }

    public List<g> adL() {
        List<g> dataList = this.ceh.getDataList();
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
        this.cef.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aw(List<g> list) {
        boolean z;
        this.cel = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.b.c> a = a(list, false, 0, 0);
        if (v.u(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.b.a)) {
            com.baidu.tieba.enterForum.b.a aVar = (com.baidu.tieba.enterForum.b.a) a.get(0);
            if (aVar.acN().getType() == 1 && aVar.acO().getType() == 2) {
                z = false;
                if (v.v(a)) {
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
                this.cef.setData(arrayList);
                if (!this.cek) {
                    this.bxv.setVisibility(8);
                    return;
                }
                adH();
                this.ceg.setVisibility(0);
                return;
            }
        }
        z = true;
        if (v.v(a)) {
        }
        com.baidu.tieba.enterForum.b.c cVar22 = new com.baidu.tieba.enterForum.b.c();
        cVar22.setType(2);
        arrayList.add(cVar22);
        hideNoDataView();
        this.cef.setData(arrayList);
        if (!this.cek) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bxv.removeFooterView(this.bRj);
            this.bxv.addFooterView(this.bRj);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bxv.removeFooterView(this.bRj);
        }
        if (this.mPullView != null) {
            this.mPullView.dq(i);
        }
        if (this.ceg != null) {
            this.ceg.n(this.ccO.getPageContext());
        }
        if (this.ceh.ady() != null && this.ceh.ady().getVisibility() == 0) {
            this.ceh.n(this.ccO.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ccO.getPageContext(), i);
        }
        if (this.cei.adE() != null) {
            this.cei.onChangeSkinType();
        }
    }

    public void a(k.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.ceg != null) {
            this.ceg.setSearchHint(str);
        }
    }

    public void adM() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cem == null) {
                this.cem = new CommonTipView(this.ccO.getActivity());
            }
            this.cem.setText(d.l.enter_forum_login_tip);
            this.cem.a(this.ccO.acZ(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cem != null) {
            this.cem.onDestroy();
        }
        if (this.cei != null) {
            this.cei.onDestroy();
        }
    }

    public void ax(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cei.isShowing() && !v.v(list)) {
            this.cei.av(list);
        }
    }
}
