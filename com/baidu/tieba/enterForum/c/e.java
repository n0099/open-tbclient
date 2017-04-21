package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private View bAI;
    private final com.baidu.tieba.enterForum.home.f bGQ;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> bHW;
    private r bHX;
    private ag bHY;
    private com.baidu.tieba.enterForum.model.e bHZ;
    private ViewEventCenter bHa;
    private boolean bIa;
    private List<com.baidu.tieba.tbadkCore.u> bIb;
    private boolean bIc;
    private CommonTipView bId;
    private TextView bIe;
    private BdListView bks;
    private View blT;
    private com.baidu.tbadk.core.view.ae mPullView;
    private int bHN = 0;
    private boolean bIf = false;

    public e(com.baidu.tieba.enterForum.home.f fVar, View view, ViewEventCenter viewEventCenter) {
        this.bIc = false;
        this.bGQ = fVar;
        this.bHa = viewEventCenter;
        this.bHY = new ag(viewEventCenter);
        this.bHZ = new com.baidu.tieba.enterForum.model.e(fVar.getPageContext(), viewEventCenter);
        ad(view);
        Xz();
        this.bks.setAdapter((ListAdapter) this.bHW);
        this.bIc = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void ad(View view) {
        this.bks = (BdListView) view.findViewById(w.h.listview);
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.bGQ.getPageContext());
        this.mPullView.setTag(this.bGQ.getUniqueId());
        this.mPullView.a(new f(this));
        this.bks.setPullRefresh(this.mPullView);
        this.bHX = new r(this.bGQ.getFragmentActivity());
        this.bHX.setEventCenter(this.bHa);
        this.blT = this.bHX.findViewById(w.h.divider_line);
        this.bks.addHeaderView(this.bHX);
        this.bIe = (TextView) BdListViewHelper.a(this.bGQ.getPageContext().getPageActivity(), this.bks, BdListViewHelper.HeadType.DEFAULT);
        this.bAI = new View(this.bGQ.getActivity());
        this.bAI.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.bGQ.getActivity(), w.f.ds150)));
    }

    public int Xs() {
        return this.bHN;
    }

    public int Xy() {
        return this.bHZ.Xs();
    }

    private void Xz() {
        this.bHW = new g(this, this.bGQ.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{w.j.home_like_item_with_portrait, w.j.home_like_item_extra_with_text, w.j.home_like_two_column_item}, this.bHa);
        this.bHW.bU(false);
    }

    public void b(com.baidu.tieba.tbadkCore.u uVar) {
        this.bHZ.b(uVar);
    }

    public void ah(List<com.baidu.tieba.tbadkCore.u> list) {
        this.bHZ.ag(list);
    }

    public List<com.baidu.tieba.tbadkCore.u> XA() {
        return this.bHZ.getDataList();
    }

    public void XB() {
        this.bHZ.Xt();
    }

    public boolean Xb() {
        return this.bIa;
    }

    public BdListView XC() {
        return this.bks;
    }

    public TextView XD() {
        return this.bIe;
    }

    public void XE() {
        this.bHN = this.bHZ.Xs();
        al(this.bHZ.getDataList());
    }

    public void hz(int i) {
        this.bIa = true;
        if (this.bHZ.Xq() == null) {
            this.bHZ.Xr();
        }
        j Xq = this.bHZ.Xq();
        Xq.n(this.bGQ.getPageContext());
        if (Xq.getParent() == null && this.bGQ.WR() != null && this.bGQ.WQ() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bGQ.WR().getId());
            this.bGQ.WQ().addView(Xq);
        }
        this.bHZ.a(this.bHN, this.bIb);
        com.baidu.adp.lib.g.h.fS().post(new h(this, i));
    }

    public void XF() {
        this.bIa = false;
        this.bks.setVisibility(0);
        if (this.bHZ.Xq() != null && this.bGQ.WQ() != null) {
            this.bGQ.WQ().removeView(this.bHZ.Xq());
        }
    }

    public void XG() {
        this.bks.setVisibility(8);
        if (this.bHZ.Xq() != null) {
            this.bHZ.Xq().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hA(int i) {
        int i2;
        if (this.bHZ.Xq() != null && this.bks != null && this.bks.getChildCount() > 0) {
            int firstVisiblePosition = this.bks.getFirstVisiblePosition();
            if (this.bHN == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.bks.getChildAt(0);
            this.bHZ.Xq().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bks.startPullRefresh();
    }

    public void XH() {
        this.bks.completePullRefreshPostDelayed(2000L);
    }

    public void dv(boolean z) {
        this.bHX.a(this.bGQ.getPageContext(), z);
    }

    public void f(com.baidu.tieba.enterForum.b.b bVar) {
        this.bHX.a(this.bGQ.getPageContext(), bVar);
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bHX.b(list, tbPageContext);
    }

    public void ae(View view) {
        if (this.bHX != null && view != null) {
            this.bHX.ae(view);
        }
    }

    public View getBannerView() {
        if (this.bHX == null) {
            return null;
        }
        return this.bHX.getBannerView();
    }

    public void ai(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list == null || list.isEmpty()) {
            XM();
            return;
        }
        this.bHY.a(this.bGQ.getFragmentActivity(), list, this.bGQ.getPageContext());
        if (!TbadkCoreApplication.isLogin()) {
            if (this.bks.getFooterViewsCount() < 1) {
                XI();
            }
        } else if (this.bks.getFooterViewsCount() < 2) {
            XI();
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bks.removeFooterView(this.bAI);
            this.bks.addFooterView(this.bAI);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bks.removeFooterView(this.bAI);
        }
    }

    private void XI() {
        this.bks.addFooterView(this.bHY.XZ(), null, false);
        com.baidu.tbadk.m.a.a(this.bGQ.getPageContext(), this.bHY.XZ());
    }

    public List<com.baidu.tieba.tbadkCore.u> XJ() {
        return this.bIb;
    }

    public List<com.baidu.tieba.tbadkCore.u> XK() {
        return this.bHZ.getDataList();
    }

    public void hB(int i) {
        this.bHN = i;
    }

    private List<Object> aj(List<com.baidu.tieba.tbadkCore.u> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.bIc) {
                arrayList.add(new com.baidu.tieba.tbadkCore.u(1));
            }
        }
        return arrayList;
    }

    private com.baidu.tieba.tbadkCore.u b(int i, List<com.baidu.tieba.tbadkCore.u> list) {
        com.baidu.tieba.tbadkCore.u uVar = new com.baidu.tieba.tbadkCore.u();
        if (list != null) {
            int size = list.size();
            if (i < size) {
                com.baidu.tieba.tbadkCore.u uVar2 = list.get(i);
                uVar2.setType(0);
                return uVar2;
            } else if (i == size && this.bIc) {
                uVar.setType(1);
                return uVar;
            } else {
                uVar.setType(2);
                return uVar;
            }
        }
        return uVar;
    }

    private List<Object> ak(List<com.baidu.tieba.tbadkCore.u> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.bIc) {
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
        this.bHW.notifyDataSetChanged();
    }

    public void al(List<com.baidu.tieba.tbadkCore.u> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.bHW.w(new ArrayList());
            return;
        }
        this.bIb = list;
        if (this.bHN == 2) {
            this.blT.setVisibility(8);
            this.bHW.w(ak(list));
            return;
        }
        this.blT.setVisibility(0);
        this.bHW.w(aj(list));
    }

    public void XL() {
        if (this.bHY != null) {
            this.bHY.p(this.bGQ.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.bks.setSelection(this.bks.getCount() - 1);
            }
        }
    }

    public void XM() {
        if (this.bHY != null && this.bHY.XZ() != null) {
            this.bks.removeFooterView(this.bHY.XZ());
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bks.removeFooterView(this.bAI);
            this.bks.addFooterView(this.bAI);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bks.removeFooterView(this.bAI);
        }
        if (this.bHW != null && !this.bHW.isEmpty()) {
            this.bHW.b(this.bGQ.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        if (this.bHY.XZ() != null) {
            this.bHY.XZ().n(this.bGQ.getPageContext());
        }
        if (this.bHX != null) {
            this.bHX.n(this.bGQ.getPageContext());
        }
        if (this.bHZ.Xq() != null && this.bHZ.Xq().getVisibility() == 0) {
            this.bHZ.n(this.bGQ.getPageContext());
        }
    }

    public void a(ab.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.bHX != null) {
            this.bHX.setSearchHint(str);
        }
    }

    public void XN() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("enter_forum_login_tip", true)) {
            if (this.bId == null) {
                this.bId = new CommonTipView(this.bGQ.getActivity());
            }
            this.bId.setText(w.l.enter_forum_login_tip);
            this.bId.b(this.bGQ.WQ(), TbadkCoreApplication.m9getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.bId != null) {
            this.bId.onDestroy();
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        this.bHX.setAttentionTitleVisibililty(z);
    }
}
