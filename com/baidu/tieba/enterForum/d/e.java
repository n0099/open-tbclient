package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private ViewEventCenter aRS;
    private final com.baidu.tieba.enterForum.home.f bJK;
    private BdListView bKP;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> bKQ;
    private r bKR;
    private ag bKS;
    private com.baidu.tieba.enterForum.c.f bKT;
    private boolean bKU;
    private List<com.baidu.tieba.tbadkCore.w> bKV;
    private boolean bKW;
    private CommonTipView bKX;
    private TextView bKY;
    private View bKZ;
    private View bgH;
    private com.baidu.tbadk.core.view.ac mPullView;
    private int bKG = 0;
    private boolean bLa = false;

    public e(com.baidu.tieba.enterForum.home.f fVar, View view, ViewEventCenter viewEventCenter) {
        this.bKW = false;
        this.bJK = fVar;
        this.aRS = viewEventCenter;
        this.bKS = new ag(viewEventCenter);
        this.bKT = new com.baidu.tieba.enterForum.c.f(fVar.getPageContext(), viewEventCenter);
        aa(view);
        Zu();
        this.bKP.setAdapter((ListAdapter) this.bKQ);
        this.bKW = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void aa(View view) {
        this.bKP = (BdListView) view.findViewById(r.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.ac(this.bJK.getPageContext());
        this.mPullView.setTag(this.bJK.getUniqueId());
        this.mPullView.a(new f(this));
        this.bKP.setPullRefresh(this.mPullView);
        this.bKR = new r(this.bJK.getFragmentActivity());
        this.bKR.setEventCenter(this.aRS);
        this.bgH = this.bKR.findViewById(r.g.divider_line);
        this.bKP.addHeaderView(this.bKR);
        this.bKY = (TextView) BdListViewHelper.a(this.bJK.getPageContext().getPageActivity(), this.bKP, BdListViewHelper.HeadType.HASTAB);
        this.bKZ = new View(this.bJK.getActivity());
        this.bKZ.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.bJK.getActivity(), r.e.ds150)));
    }

    public int Zp() {
        return this.bKG;
    }

    public int Zt() {
        return this.bKT.Zp();
    }

    private void Zu() {
        this.bKQ = new g(this, this.bJK.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{r.h.home_like_item_with_portrait, r.h.home_like_item_extra_with_text, r.h.home_like_two_column_item}, this.aRS);
        this.bKQ.bT(false);
    }

    public void b(com.baidu.tieba.tbadkCore.w wVar) {
        this.bKT.b(wVar);
    }

    public void an(List<com.baidu.tieba.tbadkCore.w> list) {
        this.bKT.am(list);
    }

    public List<com.baidu.tieba.tbadkCore.w> Zv() {
        return this.bKT.Fy();
    }

    public void Zw() {
        this.bKT.Zq();
    }

    public boolean YY() {
        return this.bKU;
    }

    public BdListView Zx() {
        return this.bKP;
    }

    public TextView Zy() {
        return this.bKY;
    }

    public void Zz() {
        this.bKG = this.bKT.Zp();
        ar(this.bKT.Fy());
    }

    public void hy(int i) {
        this.bKU = true;
        if (this.bKT.Zn() == null) {
            this.bKT.Zo();
        }
        j Zn = this.bKT.Zn();
        Zn.r(this.bJK.getPageContext());
        if (Zn.getParent() == null && this.bJK.YO() != null && this.bJK.YN() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bJK.YO().getId());
            this.bJK.YN().addView(Zn);
        }
        this.bKT.a(this.bKG, this.bKV);
        com.baidu.adp.lib.h.h.eG().post(new h(this, i));
    }

    public void ZA() {
        this.bKU = false;
        this.bKP.setVisibility(0);
        if (this.bKT.Zn() != null && this.bJK.YN() != null) {
            this.bJK.YN().removeView(this.bKT.Zn());
        }
    }

    public void ZB() {
        this.bKP.setVisibility(8);
        if (this.bKT.Zn() != null) {
            this.bKT.Zn().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hz(int i) {
        int i2;
        if (this.bKT.Zn() != null && this.bKP != null && this.bKP.getChildCount() > 0) {
            int firstVisiblePosition = this.bKP.getFirstVisiblePosition();
            if (this.bKG == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.bKP.getChildAt(0);
            this.bKT.Zn().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void kv() {
        this.bKP.kv();
    }

    public void ZC() {
        this.bKP.l(2000L);
    }

    public void du(boolean z) {
        this.bKR.a(this.bJK.getPageContext(), z);
    }

    public void f(com.baidu.tieba.enterForum.b.b bVar) {
        this.bKR.a(this.bJK.getPageContext(), bVar);
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bKR.b(list, tbPageContext);
    }

    public void ab(View view) {
        if (this.bKR != null && view != null) {
            this.bKR.ab(view);
        }
    }

    public View getBannerView() {
        if (this.bKR == null) {
            return null;
        }
        return this.bKR.getBannerView();
    }

    public void ao(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list == null || list.isEmpty()) {
            ZH();
            return;
        }
        this.bKS.a(this.bJK.getFragmentActivity(), list, this.bJK.getPageContext());
        if (!TbadkCoreApplication.isLogin()) {
            if (this.bKP.getFooterViewsCount() < 1) {
                ZD();
            }
        } else if (this.bKP.getFooterViewsCount() < 2) {
            ZD();
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bKP.removeFooterView(this.bKZ);
            this.bKP.addFooterView(this.bKZ);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bKP.removeFooterView(this.bKZ);
        }
    }

    private void ZD() {
        this.bKP.addFooterView(this.bKS.ZU(), null, false);
        com.baidu.tbadk.i.a.a(this.bJK.getPageContext(), this.bKS.ZU());
    }

    public List<com.baidu.tieba.tbadkCore.w> ZE() {
        return this.bKV;
    }

    public List<com.baidu.tieba.tbadkCore.w> ZF() {
        return this.bKT.Fy();
    }

    public void hA(int i) {
        this.bKG = i;
    }

    private List<Object> ap(List<com.baidu.tieba.tbadkCore.w> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.bKW) {
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
            } else if (i == size && this.bKW) {
                wVar.setType(1);
                return wVar;
            } else {
                wVar.setType(2);
                return wVar;
            }
        }
        return wVar;
    }

    private List<Object> aq(List<com.baidu.tieba.tbadkCore.w> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.bKW) {
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
        this.bKQ.notifyDataSetChanged();
    }

    public void ar(List<com.baidu.tieba.tbadkCore.w> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.bKQ.A(new ArrayList());
            return;
        }
        this.bKV = list;
        if (this.bKG == 2) {
            this.bgH.setVisibility(8);
            this.bKQ.A(aq(list));
            return;
        }
        this.bgH.setVisibility(0);
        this.bKQ.A(ap(list));
    }

    public void ZG() {
        if (this.bKS != null) {
            this.bKS.t(this.bJK.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.bKP.setSelection(this.bKP.getCount() - 1);
            }
        }
    }

    public void ZH() {
        if (this.bKS != null && this.bKS.ZU() != null) {
            this.bKP.removeFooterView(this.bKS.ZU());
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bKP.removeFooterView(this.bKZ);
            this.bKP.addFooterView(this.bKZ);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bKP.removeFooterView(this.bKZ);
        }
        if (this.bKQ != null && !this.bKQ.isEmpty()) {
            this.bKQ.a(this.bJK.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.di(i);
        }
        if (this.bKS.ZU() != null) {
            this.bKS.ZU().r(this.bJK.getPageContext());
        }
        if (this.bKR != null) {
            this.bKR.r(this.bJK.getPageContext());
        }
        if (this.bKT.Zn() != null && this.bKT.Zn().getVisibility() == 0) {
            this.bKT.r(this.bJK.getPageContext());
        }
    }

    public void a(z.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.bKR != null) {
            this.bKR.setSearchHint(str);
        }
    }

    public void ZI() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.um().getBoolean("enter_forum_login_tip", true)) {
            if (this.bKX == null) {
                this.bKX = new CommonTipView(this.bJK.getActivity());
            }
            this.bKX.setText(r.j.enter_forum_login_tip);
            this.bKX.b(this.bJK.YN(), TbadkCoreApplication.m9getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.um().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.bKX != null) {
            this.bKX.onDestroy();
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        this.bKR.setAttentionTitleVisibililty(z);
    }
}
