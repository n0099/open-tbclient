package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private BdListView aRC;
    private View aRo;
    private final com.baidu.tieba.enterForum.home.e aUj;
    private ViewEventCenter aUs;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> aVZ;
    private int aVh = 0;
    private r aWa;
    private ag aWb;
    private com.baidu.tieba.enterForum.c.g aWc;
    private ViewGroup aWd;
    private boolean aWe;
    private List<com.baidu.tieba.tbadkCore.w> aWf;
    private boolean aWg;
    private com.baidu.tbadk.core.view.t mPullView;

    public e(com.baidu.tieba.enterForum.home.e eVar, View view, ViewEventCenter viewEventCenter) {
        this.aWg = false;
        this.aUj = eVar;
        this.aUs = viewEventCenter;
        this.aWb = new ag(viewEventCenter);
        this.aWc = new com.baidu.tieba.enterForum.c.g(eVar.getPageContext(), viewEventCenter);
        B(view);
        KP();
        this.aRC.setAdapter((ListAdapter) this.aVZ);
        this.aWg = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void B(View view) {
        this.aWd = (ViewGroup) view.findViewById(n.g.mybar_root_layout);
        this.aRC = (BdListView) view.findViewById(n.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.t(this.aUj.getPageContext());
        this.mPullView.setTag(this.aUj.getUniqueId());
        this.aRC.setPullRefresh(this.mPullView);
        this.aWa = new r(this.aUj.getFragmentActivity());
        this.aWa.setEventCenter(this.aUs);
        this.aRo = this.aWa.findViewById(n.g.divider_line);
        this.aRC.addHeaderView(this.aWa);
    }

    public int KG() {
        return this.aVh;
    }

    public int KO() {
        return this.aWc.KG();
    }

    private void KP() {
        this.aVZ = new f(this, this.aUj.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{n.h.home_like_item_with_portrait, n.h.home_like_item_extra_with_text, n.h.home_like_two_column_item}, this.aUs);
        this.aVZ.bz(false);
    }

    public void b(com.baidu.tieba.tbadkCore.w wVar) {
        this.aWc.b(wVar);
    }

    public void W(List<com.baidu.tieba.tbadkCore.w> list) {
        this.aWc.Q(list);
    }

    public List<com.baidu.tieba.tbadkCore.w> KQ() {
        return this.aWc.DS();
    }

    public void KR() {
        this.aWc.KH();
    }

    public boolean KS() {
        return this.aWe;
    }

    public void KT() {
        this.aVh = this.aWc.KG();
        aa(this.aWc.DS());
    }

    public void fx(int i) {
        this.aWe = true;
        if (this.aWc.KE() == null) {
            this.aWc.KF();
        }
        i KE = this.aWc.KE();
        KE.f(this.aUj.getPageContext());
        if (KE.getParent() == null) {
            this.aWd.addView(KE, new FrameLayout.LayoutParams(-1, -1));
        }
        this.aWc.a(this.aVh, this.aWf);
        com.baidu.adp.lib.h.h.hj().post(new g(this, i));
    }

    public void KU() {
        this.aWe = false;
        this.aRC.setVisibility(0);
        if (this.aWc.KE() != null) {
            this.aWd.removeView(this.aWc.KE());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy(int i) {
        int i2;
        if (this.aWc.KE() != null && this.aRC != null && this.aRC.getChildCount() > 0) {
            int firstVisiblePosition = this.aRC.getFirstVisiblePosition();
            if (this.aVh == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.aRC.getChildAt(0);
            this.aWc.KE().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void nb() {
        this.aRC.nb();
    }

    public void KK() {
        this.aRC.completePullRefresh();
    }

    public void cf(boolean z) {
        this.aWa.a(this.aUj.getPageContext(), z);
    }

    public void E(View view) {
        if (this.aWa != null && view != null) {
            this.aWa.E(view);
        }
    }

    public View getBannerView() {
        if (this.aWa == null) {
            return null;
        }
        return this.aWa.getBannerView();
    }

    public void X(List<com.baidu.tieba.enterForum.b.f> list) {
        if (list == null || list.isEmpty()) {
            KY();
            return;
        }
        this.aWb.a(this.aUj.getFragmentActivity(), list, this.aUj.getPageContext());
        if (this.aRC.getFooterViewsCount() < 1) {
            this.aRC.addFooterView(this.aWb.Lh(), null, false);
            com.baidu.tbadk.i.a.a(this.aUj.getPageContext(), this.aWb.Lh());
        }
    }

    public List<com.baidu.tieba.tbadkCore.w> KV() {
        return this.aWf;
    }

    public List<com.baidu.tieba.tbadkCore.w> KW() {
        return this.aWc.DS();
    }

    public void fz(int i) {
        this.aVh = i;
    }

    private List<Object> Y(List<com.baidu.tieba.tbadkCore.w> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.aWg) {
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
            } else if (i == size && this.aWg) {
                wVar.setType(1);
                return wVar;
            } else {
                wVar.setType(2);
                return wVar;
            }
        }
        return wVar;
    }

    private List<Object> Z(List<com.baidu.tieba.tbadkCore.w> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.aWg) {
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
        this.aVZ.notifyDataSetChanged();
    }

    public void aa(List<com.baidu.tieba.tbadkCore.w> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aVZ.s(new ArrayList());
            return;
        }
        this.aWf = list;
        if (this.aVh == 2) {
            this.aRo.setVisibility(8);
            this.aVZ.s(Z(list));
            return;
        }
        this.aRo.setVisibility(0);
        this.aVZ.s(Y(list));
    }

    public void KX() {
        if (this.aWb != null) {
            this.aWb.h(this.aUj.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.aRC.setSelection(this.aRC.getCount() - 1);
            }
        }
    }

    public void KY() {
        if (this.aWb != null && this.aWb.Lh() != null) {
            this.aRC.removeFooterView(this.aWb.Lh());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aVZ != null && !this.aVZ.isEmpty()) {
            this.aVZ.a(this.aUj.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.cP(i);
        }
        if (this.aWb.Lh() != null) {
            this.aWb.Lh().f(this.aUj.getPageContext());
        }
        if (this.aWa != null) {
            this.aWa.f(this.aUj.getPageContext());
        }
        if (this.aWc.KE() != null && this.aWc.KE().getVisibility() == 0) {
            this.aWc.f(this.aUj.getPageContext());
        }
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void KZ() {
        this.aWg = true;
        aa(this.aWf);
    }

    public void setSearchHint(String str) {
        if (this.aWa != null) {
            this.aWa.setSearchHint(str);
        }
    }
}
