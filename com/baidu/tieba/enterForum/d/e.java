package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private BdListView aNK;
    private View aNv;
    private ViewEventCenter aQB;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> aRX;
    private r aRY;
    private ag aRZ;
    private int aRq = 0;
    private final com.baidu.tieba.enterForum.home.e aRr;
    private com.baidu.tieba.enterForum.c.g aSa;
    private ViewGroup aSb;
    private boolean aSc;
    private List<com.baidu.tieba.tbadkCore.w> aSd;
    private boolean aSe;
    private com.baidu.tbadk.core.view.s mPullView;

    public e(com.baidu.tieba.enterForum.home.e eVar, View view, ViewEventCenter viewEventCenter) {
        this.aSe = false;
        this.aRr = eVar;
        this.aQB = viewEventCenter;
        this.aRZ = new ag(viewEventCenter);
        this.aSa = new com.baidu.tieba.enterForum.c.g(eVar.getPageContext(), viewEventCenter);
        A(view);
        Kw();
        this.aNK.setAdapter((ListAdapter) this.aRX);
        this.aSe = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void A(View view) {
        this.aSb = (ViewGroup) view.findViewById(n.f.mybar_root_layout);
        this.aNK = (BdListView) view.findViewById(n.f.listview);
        this.mPullView = new com.baidu.tbadk.core.view.s(this.aRr.getPageContext());
        this.mPullView.setTag(this.aRr.getUniqueId());
        this.aNK.setPullRefresh(this.mPullView);
        this.aRY = new r(this.aRr.getFragmentActivity());
        this.aRY.setEventCenter(this.aQB);
        this.aNv = this.aRY.findViewById(n.f.divider_line);
        this.aNK.addHeaderView(this.aRY);
    }

    public int Kn() {
        return this.aRq;
    }

    public int Kv() {
        return this.aSa.Kn();
    }

    private void Kw() {
        this.aRX = new f(this, this.aRr.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{n.g.home_like_item_with_portrait, n.g.home_like_item_extra_with_text, n.g.home_like_two_column_item}, this.aQB);
        this.aRX.bz(false);
    }

    public void b(com.baidu.tieba.tbadkCore.w wVar) {
        this.aSa.b(wVar);
    }

    public void V(List<com.baidu.tieba.tbadkCore.w> list) {
        this.aSa.P(list);
    }

    public List<com.baidu.tieba.tbadkCore.w> Kx() {
        return this.aSa.Ed();
    }

    public void Ky() {
        this.aSa.Ko();
    }

    public boolean Kz() {
        return this.aSc;
    }

    public void KA() {
        this.aRq = this.aSa.Kn();
        Z(this.aSa.Ed());
    }

    public void fC(int i) {
        this.aSc = true;
        if (this.aSa.Kl() == null) {
            this.aSa.Km();
        }
        i Kl = this.aSa.Kl();
        Kl.f(this.aRr.getPageContext());
        if (Kl.getParent() == null) {
            this.aSb.addView(Kl, new FrameLayout.LayoutParams(-1, -1));
        }
        this.aSa.a(this.aRq, this.aSd);
        com.baidu.adp.lib.h.h.hj().post(new g(this, i));
    }

    public void KB() {
        this.aSc = false;
        this.aNK.setVisibility(0);
        if (this.aSa.Kl() != null) {
            this.aSb.removeView(this.aSa.Kl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(int i) {
        int i2;
        if (this.aSa.Kl() != null && this.aNK != null && this.aNK.getChildCount() > 0) {
            int firstVisiblePosition = this.aNK.getFirstVisiblePosition();
            if (this.aRq == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.aNK.getChildAt(0);
            this.aSa.Kl().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void nD() {
        this.aNK.nD();
    }

    public void Kr() {
        this.aNK.completePullRefresh();
    }

    public void ce(boolean z) {
        this.aRY.a(this.aRr.getPageContext(), z);
    }

    public void D(View view) {
        if (this.aRY != null && view != null) {
            this.aRY.D(view);
        }
    }

    public View getBannerView() {
        if (this.aRY == null) {
            return null;
        }
        return this.aRY.getBannerView();
    }

    public void W(List<com.baidu.tieba.enterForum.b.f> list) {
        if (list == null || list.isEmpty()) {
            KF();
            return;
        }
        this.aRZ.a(this.aRr.getFragmentActivity(), list, this.aRr.getPageContext());
        if (this.aNK.getFooterViewsCount() < 1) {
            this.aNK.addFooterView(this.aRZ.KO(), null, false);
            com.baidu.tbadk.i.a.a(this.aRr.getPageContext(), this.aRZ.KO());
        }
    }

    public List<com.baidu.tieba.tbadkCore.w> KC() {
        return this.aSd;
    }

    public List<com.baidu.tieba.tbadkCore.w> KD() {
        return this.aSa.Ed();
    }

    public void fE(int i) {
        this.aRq = i;
    }

    private List<Object> X(List<com.baidu.tieba.tbadkCore.w> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.aSe) {
                arrayList.add(new com.baidu.tieba.tbadkCore.w(1));
            }
        }
        return arrayList;
    }

    private com.baidu.tieba.tbadkCore.w b(int i, List<com.baidu.tieba.tbadkCore.w> list) {
        com.baidu.tieba.tbadkCore.w wVar = new com.baidu.tieba.tbadkCore.w();
        if (list != null) {
            int size = list.size();
            if (i < size) {
                com.baidu.tieba.tbadkCore.w wVar2 = list.get(i);
                wVar2.setType(0);
                return wVar2;
            } else if (i == size && this.aSe) {
                wVar.setType(1);
                return wVar;
            } else {
                wVar.setType(2);
                return wVar;
            }
        }
        return wVar;
    }

    private List<Object> Y(List<com.baidu.tieba.tbadkCore.w> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.aSe) {
            size++;
        }
        int i = 0;
        int i2 = 1;
        while (i < size) {
            arrayList.add(new com.baidu.tieba.enterForum.b.a(b(i, list), b(i2, list)));
            i += 2;
            i2 = i + 1;
        }
        return arrayList;
    }

    public void notifyDataSetChanged() {
        this.aRX.notifyDataSetChanged();
    }

    public void Z(List<com.baidu.tieba.tbadkCore.w> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aRX.r(new ArrayList());
            return;
        }
        this.aSd = list;
        if (this.aRq == 2) {
            this.aNv.setVisibility(8);
            this.aRX.r(Y(list));
            return;
        }
        this.aNv.setVisibility(0);
        this.aRX.r(X(list));
    }

    public void KE() {
        if (this.aRZ != null) {
            this.aRZ.h(this.aRr.getPageContext());
            this.aNK.setSelection(this.aNK.getCount() - 1);
        }
    }

    public void KF() {
        if (this.aRZ != null && this.aRZ.KO() != null) {
            this.aNK.removeFooterView(this.aRZ.KO());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aRX != null && !this.aRX.isEmpty()) {
            this.aRX.a(this.aRr.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.cV(i);
        }
        if (this.aRZ.KO() != null) {
            this.aRZ.KO().f(this.aRr.getPageContext());
        }
        if (this.aRY != null) {
            this.aRY.f(this.aRr.getPageContext());
        }
        if (this.aSa.Kl() != null && this.aSa.Kl().getVisibility() == 0) {
            this.aSa.f(this.aRr.getPageContext());
        }
    }

    public void a(q.a aVar) {
        this.mPullView.a(aVar);
    }

    public void KG() {
        this.aSe = true;
        Z(this.aSd);
    }

    public void setSearchHint(String str) {
        if (this.aRY != null) {
            this.aRY.setSearchHint(str);
        }
    }
}
