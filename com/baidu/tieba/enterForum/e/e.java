package com.baidu.tieba.enterForum.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
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
    private ViewEventCenter aOw;
    private final com.baidu.tieba.enterForum.home.e bGH;
    private BdListView bHT;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> bHU;
    private r bHV;
    private ag bHW;
    private com.baidu.tieba.enterForum.c.f bHX;
    private ViewGroup bHY;
    private boolean bHZ;
    private List<com.baidu.tieba.tbadkCore.w> bIa;
    private boolean bIb;
    private CommonTipView bIc;
    private TextView bId;
    private View bIe;
    private View bdn;
    private com.baidu.tbadk.core.view.w mPullView;
    private int bHF = 0;
    private boolean bIf = false;

    public e(com.baidu.tieba.enterForum.home.e eVar, View view, ViewEventCenter viewEventCenter) {
        this.bIb = false;
        this.bGH = eVar;
        this.aOw = viewEventCenter;
        this.bHW = new ag(viewEventCenter);
        this.bHX = new com.baidu.tieba.enterForum.c.f(eVar.getPageContext(), viewEventCenter);
        Z(view);
        Ya();
        this.bHT.setAdapter((ListAdapter) this.bHU);
        this.bIb = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void Z(View view) {
        this.bHY = (ViewGroup) view.findViewById(t.g.mybar_root_layout);
        this.bHT = (BdListView) view.findViewById(t.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.w(this.bGH.getPageContext());
        this.mPullView.setTag(this.bGH.getUniqueId());
        this.mPullView.a(new f(this));
        this.bHT.setPullRefresh(this.mPullView);
        this.bHV = new r(this.bGH.getFragmentActivity());
        this.bHV.setEventCenter(this.aOw);
        this.bdn = this.bHV.findViewById(t.g.divider_line);
        this.bHT.addHeaderView(this.bHV);
        this.bId = (TextView) BdListViewHelper.a(this.bGH.getPageContext().getPageActivity(), this.bHT, BdListViewHelper.HeadType.HASTAB);
        this.bIe = new View(this.bGH.getActivity());
        this.bIe.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.bGH.getActivity(), t.e.ds150)));
    }

    public int XU() {
        return this.bHF;
    }

    public int XZ() {
        return this.bHX.XU();
    }

    private void Ya() {
        this.bHU = new g(this, this.bGH.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{t.h.home_like_item_with_portrait, t.h.home_like_item_extra_with_text, t.h.home_like_two_column_item}, this.aOw);
        this.bHU.bQ(false);
    }

    public void b(com.baidu.tieba.tbadkCore.w wVar) {
        this.bHX.b(wVar);
    }

    public void am(List<com.baidu.tieba.tbadkCore.w> list) {
        this.bHX.al(list);
    }

    public List<com.baidu.tieba.tbadkCore.w> Yb() {
        return this.bHX.Fu();
    }

    public void Yc() {
        this.bHX.XV();
    }

    public boolean XC() {
        return this.bHZ;
    }

    public BdListView Yd() {
        return this.bHT;
    }

    public TextView Ye() {
        return this.bId;
    }

    public void Yf() {
        this.bHF = this.bHX.XU();
        aq(this.bHX.Fu());
    }

    public void ht(int i) {
        this.bHZ = true;
        if (this.bHX.XS() == null) {
            this.bHX.XT();
        }
        j XS = this.bHX.XS();
        XS.n(this.bGH.getPageContext());
        if (XS.getParent() == null && this.bGH.Xs() != null && this.bGH.Xr() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bGH.Xs().getId());
            this.bGH.Xr().addView(XS);
        }
        this.bHX.a(this.bHF, this.bIa);
        com.baidu.adp.lib.h.h.eG().post(new h(this, i));
    }

    public void Yg() {
        this.bHZ = false;
        this.bHT.setVisibility(0);
        if (this.bHX.XS() != null && this.bGH.Xr() != null) {
            this.bGH.Xr().removeView(this.bHX.XS());
        }
    }

    public void Yh() {
        this.bHT.setVisibility(8);
        if (this.bHX.XS() != null) {
            this.bHX.XS().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu(int i) {
        int i2;
        if (this.bHX.XS() != null && this.bHT != null && this.bHT.getChildCount() > 0) {
            int firstVisiblePosition = this.bHT.getFirstVisiblePosition();
            if (this.bHF == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.bHT.getChildAt(0);
            this.bHX.XS().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void kv() {
        this.bHT.kv();
    }

    public void Yi() {
        this.bHT.l(2000L);
    }

    /* renamed from: do  reason: not valid java name */
    public void m13do(boolean z) {
        this.bHV.b(this.bGH.getPageContext(), z);
    }

    public void g(com.baidu.tieba.enterForum.b.b bVar) {
        this.bHV.a(this.bGH.getPageContext(), bVar);
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bHV.b(list, tbPageContext);
    }

    public void aa(View view) {
        if (this.bHV != null && view != null) {
            this.bHV.aa(view);
        }
    }

    public View getBannerView() {
        if (this.bHV == null) {
            return null;
        }
        return this.bHV.getBannerView();
    }

    public void ab(View view) {
        if (this.bHV != null && view != null) {
            this.bHV.ab(view);
        }
    }

    public View getTogetherHiBannerView() {
        if (this.bHV == null) {
            return null;
        }
        return this.bHV.getTogetherHiBannerView();
    }

    public void an(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list == null || list.isEmpty()) {
            Yn();
            return;
        }
        this.bHW.a(this.bGH.getFragmentActivity(), list, this.bGH.getPageContext());
        if (!TbadkCoreApplication.isLogin()) {
            if (this.bHT.getFooterViewsCount() < 1) {
                Yj();
            }
        } else if (this.bHT.getFooterViewsCount() < 2) {
            Yj();
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bHT.removeFooterView(this.bIe);
            this.bHT.addFooterView(this.bIe);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bHT.removeFooterView(this.bIe);
        }
    }

    private void Yj() {
        this.bHT.addFooterView(this.bHW.YD(), null, false);
        com.baidu.tbadk.j.a.a(this.bGH.getPageContext(), this.bHW.YD());
    }

    public List<com.baidu.tieba.tbadkCore.w> Yk() {
        return this.bIa;
    }

    public List<com.baidu.tieba.tbadkCore.w> Yl() {
        return this.bHX.Fu();
    }

    public void hv(int i) {
        this.bHF = i;
    }

    private List<Object> ao(List<com.baidu.tieba.tbadkCore.w> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.bIb) {
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
            } else if (i == size && this.bIb) {
                wVar.setType(1);
                return wVar;
            } else {
                wVar.setType(2);
                return wVar;
            }
        }
        return wVar;
    }

    private List<Object> ap(List<com.baidu.tieba.tbadkCore.w> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.bIb) {
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
        this.bHU.notifyDataSetChanged();
    }

    public void aq(List<com.baidu.tieba.tbadkCore.w> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.bHU.A(new ArrayList());
            return;
        }
        this.bIa = list;
        if (this.bHF == 2) {
            this.bdn.setVisibility(8);
            this.bHU.A(ap(list));
            return;
        }
        this.bdn.setVisibility(0);
        this.bHU.A(ao(list));
    }

    public void Ym() {
        if (this.bHW != null) {
            this.bHW.p(this.bGH.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.bHT.setSelection(this.bHT.getCount() - 1);
            }
        }
    }

    public void Yn() {
        if (this.bHW != null && this.bHW.YD() != null) {
            this.bHT.removeFooterView(this.bHW.YD());
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bHT.removeFooterView(this.bIe);
            this.bHT.addFooterView(this.bIe);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bHT.removeFooterView(this.bIe);
        }
        if (this.bHU != null && !this.bHU.isEmpty()) {
            this.bHU.a(this.bGH.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
        }
        if (this.bHW.YD() != null) {
            this.bHW.YD().n(this.bGH.getPageContext());
        }
        if (this.bHV != null) {
            this.bHV.n(this.bGH.getPageContext());
        }
        if (this.bHX.XS() != null && this.bHX.XS().getVisibility() == 0) {
            this.bHX.n(this.bGH.getPageContext());
        }
    }

    public void a(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void Yo() {
        this.bIb = true;
        aq(this.bIa);
        this.bHW.YE();
    }

    public void setSearchHint(String str) {
        if (this.bHV != null) {
            this.bHV.setSearchHint(str);
        }
    }

    public void Yp() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("enter_forum_login_tip", true)) {
            if (this.bIc == null) {
                this.bIc = new CommonTipView(this.bGH.getActivity());
            }
            this.bIc.setText(t.j.enter_forum_login_tip);
            this.bIc.b(this.bGH.Xr(), TbadkCoreApplication.m9getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.bIc != null) {
            this.bIc.onDestroy();
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        this.bHV.setAttentionTitleVisibililty(z);
    }
}
