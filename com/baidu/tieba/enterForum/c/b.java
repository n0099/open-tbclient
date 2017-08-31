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
    private View bQs;
    private BdListView bwG;
    private final com.baidu.tieba.enterForum.home.a cbW;
    private ViewEventCenter cbt;
    private com.baidu.tieba.enterForum.a.a cdn;
    private f cdo;
    private com.baidu.tieba.enterForum.model.c cdp;
    private com.baidu.tieba.enterForum.multiConcern.a cdq;
    private boolean cdr = false;
    private boolean cds;
    private List<g> cdt;
    private CommonTipView cdu;
    private TextView cdv;
    private j mNoDataView;
    private l mPullView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.cbW = aVar;
        this.cbt = viewEventCenter;
        this.cdp = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.cdq = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oP(), viewEventCenter);
        ao(view);
        this.cdn = new com.baidu.tieba.enterForum.a.a(this.cbW.getPageContext(), this.cbt);
        this.bwG.setAdapter((ListAdapter) this.cdn);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void ao(View view) {
        this.bwG = (BdListView) view.findViewById(d.h.listview);
        this.bwG.setVerticalScrollBarEnabled(false);
        this.mPullView = new l(this.cbW.getPageContext());
        this.mPullView.setTag(this.cbW.getUniqueId());
        this.bwG.setPullRefresh(this.mPullView);
        this.cdo = new f(this.cbW.getFragmentActivity());
        this.cdo.setEventCenter(this.cbt);
        this.bwG.addHeaderView(this.cdo);
        this.cdv = (TextView) BdListViewHelper.a(this.cbW.getPageContext().getPageActivity(), this.bwG, BdListViewHelper.HeadType.DEFAULT);
        this.bQs = new View(this.cbW.getActivity());
        this.bQs.setLayoutParams(new AbsListView.LayoutParams(-1, k.g(this.cbW.getActivity(), d.f.ds0)));
    }

    public void ap(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cbW.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.net_refresh_emotion, k.g(this.cbW.getPageContext().getContext(), d.f.ds300), k.g(this.cbW.getPageContext().getContext(), d.f.ds480), k.g(this.cbW.getPageContext().getContext(), d.f.ds360)), NoDataViewFactory.d.ag(this.cbW.getString(d.l.neterror), this.cbW.getString(d.l.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cbW.getString(d.l.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.cdo.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.cbW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bwG.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bwG.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.v(this.cdt);
    }

    public void b(g gVar) {
        this.cdp.b(gVar);
    }

    public void eq(boolean z) {
        this.cdr = z;
    }

    public boolean ada() {
        return this.cds;
    }

    public BdListView adu() {
        return this.bwG;
    }

    public void adv() {
        aw(this.cdp.getDataList());
    }

    public void is(final int i) {
        this.cds = true;
        if (this.cdp.adn() == null) {
            this.cdp.ado();
            this.cdp.adn().setVisibility(8);
        }
        d adn = this.cdp.adn();
        adn.n(this.cbW.getPageContext());
        if (adn.getParent() == null && this.cbW.acT() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cbW.acO().getId());
            this.cbW.acO().addView(adn);
            this.cbW.acS();
        }
        this.cdp.at(this.cdt);
        com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.it(i);
                com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.cdp.adn() != null) {
                            b.this.cdp.adn().setVisibility(0);
                            b.this.bwG.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void adw() {
        this.cds = false;
        this.bwG.setVisibility(0);
        if (this.cdp.adn() != null && this.cbW.acO() != null) {
            this.cbW.acO().removeView(this.cdp.adn());
            this.cdp.adn().setVisibility(8);
        }
        this.cbW.acS();
    }

    public void adx() {
        this.cds = true;
        this.bwG.setVisibility(8);
        if (this.cdp.adn() != null) {
            this.cdp.adn().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void it(int i) {
        if (this.cdp.adn() != null && this.bwG != null && this.bwG.getChildCount() > 0) {
            int firstVisiblePosition = (this.bwG.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bwG.getChildAt(0);
            this.cdp.adn().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bwG.startPullRefresh();
    }

    public void ady() {
        this.bwG.completePullRefreshPostDelayed(2000L);
    }

    public List<g> adz() {
        return this.cdt;
    }

    public List<g> adA() {
        List<g> dataList = this.cdp.getDataList();
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
        this.cdn.notifyDataSetChanged();
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
        this.cdt = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.b.c> a = a(list, false, 0, 0);
        if (v.u(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.b.a)) {
            com.baidu.tieba.enterForum.b.a aVar = (com.baidu.tieba.enterForum.b.a) a.get(0);
            if (aVar.acC().getType() == 1 && aVar.acD().getType() == 2) {
                z = false;
                if (v.v(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.b.d(this.cbW.getPageContext().getResources().getString(d.l.my_attention_bar), z));
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
                this.cdn.setData(arrayList);
                if (!this.cds) {
                    this.bwG.setVisibility(8);
                    return;
                }
                adw();
                this.cdo.setVisibility(0);
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
        this.cdn.setData(arrayList);
        if (!this.cds) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bwG.removeFooterView(this.bQs);
            this.bwG.addFooterView(this.bQs);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bwG.removeFooterView(this.bQs);
        }
        if (this.mPullView != null) {
            this.mPullView.dq(i);
        }
        if (this.cdo != null) {
            this.cdo.n(this.cbW.getPageContext());
        }
        if (this.cdp.adn() != null && this.cdp.adn().getVisibility() == 0) {
            this.cdp.n(this.cbW.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cbW.getPageContext(), i);
        }
        if (this.cdq.adt() != null) {
            this.cdq.onChangeSkinType();
        }
    }

    public void a(k.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cdo != null) {
            this.cdo.setSearchHint(str);
        }
    }

    public void adB() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cdu == null) {
                this.cdu = new CommonTipView(this.cbW.getActivity());
            }
            this.cdu.setText(d.l.enter_forum_login_tip);
            this.cdu.a(this.cbW.acO(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cdu != null) {
            this.cdu.onDestroy();
        }
        if (this.cdq != null) {
            this.cdq.onDestroy();
        }
    }

    public void ax(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cdq.isShowing() && !v.v(list)) {
            this.cdq.av(list);
        }
    }
}
