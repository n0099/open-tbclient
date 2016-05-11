package com.baidu.tieba.enterForum.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.t;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private View aTb;
    private final com.baidu.tieba.enterForum.home.e aXi;
    private ViewEventCenter aXs;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> aYA;
    private r aYB;
    private ag aYC;
    private com.baidu.tieba.enterForum.c.g aYD;
    private ViewGroup aYE;
    private boolean aYF;
    private List<com.baidu.tieba.tbadkCore.w> aYG;
    private boolean aYH;
    private CommonTipView aYI;
    private TextView aYJ;
    private View aYK;
    private BdListView aYz;
    private com.baidu.tbadk.core.view.w mPullView;
    private int aYl = 0;
    private boolean aYL = false;

    public e(com.baidu.tieba.enterForum.home.e eVar, View view, ViewEventCenter viewEventCenter) {
        this.aYH = false;
        this.aXi = eVar;
        this.aXs = viewEventCenter;
        this.aYC = new ag(viewEventCenter);
        this.aYD = new com.baidu.tieba.enterForum.c.g(eVar.getPageContext(), viewEventCenter);
        X(view);
        Nf();
        this.aYz.setAdapter((ListAdapter) this.aYA);
        this.aYH = TbadkCoreApplication.m11getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
    }

    private void X(View view) {
        this.aYE = (ViewGroup) view.findViewById(t.g.mybar_root_layout);
        this.aYz = (BdListView) view.findViewById(t.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.w(this.aXi.getPageContext());
        this.mPullView.setTag(this.aXi.getUniqueId());
        this.aYz.setPullRefresh(this.mPullView);
        this.aYB = new r(this.aXi.getFragmentActivity());
        this.aYB.setEventCenter(this.aXs);
        this.aTb = this.aYB.findViewById(t.g.divider_line);
        this.aYz.addHeaderView(this.aYB);
        this.aYJ = (TextView) BdListViewHelper.a(this.aXi.getPageContext().getPageActivity(), this.aYz, BdListViewHelper.HeadType.HASTAB);
        this.aYK = new View(this.aXi.getActivity());
        this.aYK.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.aXi.getActivity(), t.e.ds150)));
    }

    public int MY() {
        return this.aYl;
    }

    public int Ne() {
        return this.aYD.MY();
    }

    private void Nf() {
        this.aYA = new f(this, this.aXi.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{t.h.home_like_item_with_portrait, t.h.home_like_item_extra_with_text, t.h.home_like_two_column_item}, this.aXs);
        this.aYA.bM(false);
    }

    public void b(com.baidu.tieba.tbadkCore.w wVar) {
        this.aYD.b(wVar);
    }

    public void T(List<com.baidu.tieba.tbadkCore.w> list) {
        this.aYD.S(list);
    }

    public List<com.baidu.tieba.tbadkCore.w> Ng() {
        return this.aYD.DR();
    }

    public void Nh() {
        this.aYD.MZ();
    }

    public boolean MF() {
        return this.aYF;
    }

    public BdListView Ni() {
        return this.aYz;
    }

    public TextView Nj() {
        return this.aYJ;
    }

    public void Nk() {
        this.aYl = this.aYD.MY();
        X(this.aYD.DR());
    }

    public void fS(int i) {
        this.aYF = true;
        if (this.aYD.MW() == null) {
            this.aYD.MX();
        }
        i MW = this.aYD.MW();
        MW.g(this.aXi.getPageContext());
        if (MW.getParent() == null && this.aXi.Ms() != null && this.aXi.Mr() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.aXi.Ms().getId());
            this.aXi.Mr().addView(MW);
        }
        this.aYD.a(this.aYl, this.aYG);
        com.baidu.adp.lib.h.h.dL().post(new g(this, i));
    }

    public void MD() {
        this.aYF = false;
        this.aYz.setVisibility(0);
        if (this.aYD.MW() != null && this.aXi.Mr() != null) {
            this.aXi.Mr().removeView(this.aYD.MW());
        }
    }

    public void Nl() {
        this.aYz.setVisibility(0);
        if (this.aYD.MW() != null) {
            this.aYD.MW().setVisibility(8);
        }
    }

    public void Nm() {
        this.aYz.setVisibility(8);
        if (this.aYD.MW() != null) {
            this.aYD.MW().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(int i) {
        int i2;
        if (this.aYD.MW() != null && this.aYz != null && this.aYz.getChildCount() > 0) {
            int firstVisiblePosition = this.aYz.getFirstVisiblePosition();
            if (this.aYl == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.aYz.getChildAt(0);
            this.aYD.MW().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void jy() {
        this.aYz.jy();
    }

    public void Nn() {
        this.aYz.k(2000L);
    }

    public void cw(boolean z) {
        this.aYB.a(this.aXi.getPageContext(), z);
    }

    public void Y(View view) {
        if (this.aYB != null && view != null) {
            this.aYB.Y(view);
        }
    }

    public View getBannerView() {
        if (this.aYB == null) {
            return null;
        }
        return this.aYB.getBannerView();
    }

    public void Z(View view) {
        if (this.aYB != null && view != null) {
            this.aYB.Z(view);
        }
    }

    public View getTogetherHiBannerView() {
        if (this.aYB == null) {
            return null;
        }
        return this.aYB.getTogetherHiBannerView();
    }

    public void U(List<com.baidu.tieba.enterForum.b.f> list) {
        if (list == null || list.isEmpty()) {
            Ns();
            return;
        }
        this.aYC.a(this.aXi.getFragmentActivity(), list, this.aXi.getPageContext());
        if (!TbadkCoreApplication.isLogin()) {
            if (this.aYz.getFooterViewsCount() < 1) {
                No();
            }
        } else if (this.aYz.getFooterViewsCount() < 2) {
            No();
        }
        if (TbadkCoreApplication.m11getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.aYz.removeFooterView(this.aYK);
            this.aYz.addFooterView(this.aYK);
        }
        if (TbadkCoreApplication.m11getInst().getSkinType() == 2) {
            this.aYz.removeFooterView(this.aYK);
        }
    }

    private void No() {
        this.aYz.addFooterView(this.aYC.NH(), null, false);
        com.baidu.tbadk.i.a.a(this.aXi.getPageContext(), this.aYC.NH());
    }

    public List<com.baidu.tieba.tbadkCore.w> Np() {
        return this.aYG;
    }

    public List<com.baidu.tieba.tbadkCore.w> Nq() {
        return this.aYD.DR();
    }

    public void fU(int i) {
        this.aYl = i;
    }

    private List<Object> V(List<com.baidu.tieba.tbadkCore.w> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.aYH) {
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
            } else if (i == size && this.aYH) {
                wVar.setType(1);
                return wVar;
            } else {
                wVar.setType(2);
                return wVar;
            }
        }
        return wVar;
    }

    private List<Object> W(List<com.baidu.tieba.tbadkCore.w> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.aYH) {
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
        this.aYA.notifyDataSetChanged();
    }

    public void X(List<com.baidu.tieba.tbadkCore.w> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aYA.z((List<Object>) new ArrayList());
            return;
        }
        this.aYG = list;
        if (this.aYl == 2) {
            this.aTb.setVisibility(8);
            this.aYA.z(W(list));
            return;
        }
        this.aTb.setVisibility(0);
        this.aYA.z(V(list));
    }

    public void Nr() {
        if (this.aYC != null) {
            this.aYC.i(this.aXi.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.aYz.setSelection(this.aYz.getCount() - 1);
            }
        }
    }

    public void Ns() {
        if (this.aYC != null && this.aYC.NH() != null) {
            this.aYz.removeFooterView(this.aYC.NH());
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m11getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.aYz.removeFooterView(this.aYK);
            this.aYz.addFooterView(this.aYK);
        }
        if (TbadkCoreApplication.m11getInst().getSkinType() == 2) {
            this.aYz.removeFooterView(this.aYK);
        }
        if (this.aYA != null && !this.aYA.isEmpty()) {
            this.aYA.a(this.aXi.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.cS(i);
        }
        if (this.aYC.NH() != null) {
            this.aYC.NH().g(this.aXi.getPageContext());
        }
        if (this.aYB != null) {
            this.aYB.g(this.aXi.getPageContext());
        }
        if (this.aYD.MW() != null && this.aYD.MW().getVisibility() == 0) {
            this.aYD.g(this.aXi.getPageContext());
        }
    }

    public void a(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void Nt() {
        this.aYH = true;
        X(this.aYG);
        this.aYC.NI();
    }

    public void setSearchHint(String str) {
        if (this.aYB != null) {
            this.aYB.setSearchHint(str);
        }
    }

    public void Nu() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("enter_forum_login_tip", true)) {
            if (this.aYI == null) {
                this.aYI = new CommonTipView(this.aXi.getActivity());
            }
            this.aYI.setText(t.j.enter_forum_login_tip);
            this.aYI.b(this.aXi.Mr(), TbadkCoreApplication.m11getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.aYI != null) {
            this.aYI.onDestroy();
        }
    }
}
