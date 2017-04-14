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
    private ViewEventCenter bEJ;
    private final com.baidu.tieba.enterForum.home.f bEz;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> bFF;
    private r bFG;
    private ag bFH;
    private com.baidu.tieba.enterForum.model.e bFI;
    private boolean bFJ;
    private List<com.baidu.tieba.tbadkCore.u> bFK;
    private boolean bFL;
    private CommonTipView bFM;
    private TextView bFN;
    private BdListView bii;
    private View bjH;
    private View byr;
    private com.baidu.tbadk.core.view.ae mPullView;
    private int bFw = 0;
    private boolean bFO = false;

    public e(com.baidu.tieba.enterForum.home.f fVar, View view, ViewEventCenter viewEventCenter) {
        this.bFL = false;
        this.bEz = fVar;
        this.bEJ = viewEventCenter;
        this.bFH = new ag(viewEventCenter);
        this.bFI = new com.baidu.tieba.enterForum.model.e(fVar.getPageContext(), viewEventCenter);
        ad(view);
        Wy();
        this.bii.setAdapter((ListAdapter) this.bFF);
        this.bFL = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void ad(View view) {
        this.bii = (BdListView) view.findViewById(w.h.listview);
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.bEz.getPageContext());
        this.mPullView.setTag(this.bEz.getUniqueId());
        this.mPullView.a(new f(this));
        this.bii.setPullRefresh(this.mPullView);
        this.bFG = new r(this.bEz.getFragmentActivity());
        this.bFG.setEventCenter(this.bEJ);
        this.bjH = this.bFG.findViewById(w.h.divider_line);
        this.bii.addHeaderView(this.bFG);
        this.bFN = (TextView) BdListViewHelper.a(this.bEz.getPageContext().getPageActivity(), this.bii, BdListViewHelper.HeadType.DEFAULT);
        this.byr = new View(this.bEz.getActivity());
        this.byr.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.bEz.getActivity(), w.f.ds150)));
    }

    public int Wr() {
        return this.bFw;
    }

    public int Wx() {
        return this.bFI.Wr();
    }

    private void Wy() {
        this.bFF = new g(this, this.bEz.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{w.j.home_like_item_with_portrait, w.j.home_like_item_extra_with_text, w.j.home_like_two_column_item}, this.bEJ);
        this.bFF.bU(false);
    }

    public void b(com.baidu.tieba.tbadkCore.u uVar) {
        this.bFI.b(uVar);
    }

    public void ag(List<com.baidu.tieba.tbadkCore.u> list) {
        this.bFI.af(list);
    }

    public List<com.baidu.tieba.tbadkCore.u> Wz() {
        return this.bFI.getDataList();
    }

    public void WA() {
        this.bFI.Ws();
    }

    public boolean Wa() {
        return this.bFJ;
    }

    public BdListView WB() {
        return this.bii;
    }

    public TextView WC() {
        return this.bFN;
    }

    public void WD() {
        this.bFw = this.bFI.Wr();
        ak(this.bFI.getDataList());
    }

    public void ht(int i) {
        this.bFJ = true;
        if (this.bFI.Wp() == null) {
            this.bFI.Wq();
        }
        j Wp = this.bFI.Wp();
        Wp.n(this.bEz.getPageContext());
        if (Wp.getParent() == null && this.bEz.VQ() != null && this.bEz.VP() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bEz.VQ().getId());
            this.bEz.VP().addView(Wp);
        }
        this.bFI.a(this.bFw, this.bFK);
        com.baidu.adp.lib.g.h.fR().post(new h(this, i));
    }

    public void WE() {
        this.bFJ = false;
        this.bii.setVisibility(0);
        if (this.bFI.Wp() != null && this.bEz.VP() != null) {
            this.bEz.VP().removeView(this.bFI.Wp());
        }
    }

    public void WF() {
        this.bii.setVisibility(8);
        if (this.bFI.Wp() != null) {
            this.bFI.Wp().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu(int i) {
        int i2;
        if (this.bFI.Wp() != null && this.bii != null && this.bii.getChildCount() > 0) {
            int firstVisiblePosition = this.bii.getFirstVisiblePosition();
            if (this.bFw == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.bii.getChildAt(0);
            this.bFI.Wp().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bii.startPullRefresh();
    }

    public void WG() {
        this.bii.completePullRefreshPostDelayed(2000L);
    }

    public void dl(boolean z) {
        this.bFG.a(this.bEz.getPageContext(), z);
    }

    public void f(com.baidu.tieba.enterForum.b.b bVar) {
        this.bFG.a(this.bEz.getPageContext(), bVar);
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bFG.b(list, tbPageContext);
    }

    public void ae(View view) {
        if (this.bFG != null && view != null) {
            this.bFG.ae(view);
        }
    }

    public View getBannerView() {
        if (this.bFG == null) {
            return null;
        }
        return this.bFG.getBannerView();
    }

    public void ah(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list == null || list.isEmpty()) {
            WL();
            return;
        }
        this.bFH.a(this.bEz.getFragmentActivity(), list, this.bEz.getPageContext());
        if (!TbadkCoreApplication.isLogin()) {
            if (this.bii.getFooterViewsCount() < 1) {
                WH();
            }
        } else if (this.bii.getFooterViewsCount() < 2) {
            WH();
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bii.removeFooterView(this.byr);
            this.bii.addFooterView(this.byr);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bii.removeFooterView(this.byr);
        }
    }

    private void WH() {
        this.bii.addFooterView(this.bFH.WY(), null, false);
        com.baidu.tbadk.m.a.a(this.bEz.getPageContext(), this.bFH.WY());
    }

    public List<com.baidu.tieba.tbadkCore.u> WI() {
        return this.bFK;
    }

    public List<com.baidu.tieba.tbadkCore.u> WJ() {
        return this.bFI.getDataList();
    }

    public void hv(int i) {
        this.bFw = i;
    }

    private List<Object> ai(List<com.baidu.tieba.tbadkCore.u> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.bFL) {
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
            } else if (i == size && this.bFL) {
                uVar.setType(1);
                return uVar;
            } else {
                uVar.setType(2);
                return uVar;
            }
        }
        return uVar;
    }

    private List<Object> aj(List<com.baidu.tieba.tbadkCore.u> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.bFL) {
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
        this.bFF.notifyDataSetChanged();
    }

    public void ak(List<com.baidu.tieba.tbadkCore.u> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.bFF.w(new ArrayList());
            return;
        }
        this.bFK = list;
        if (this.bFw == 2) {
            this.bjH.setVisibility(8);
            this.bFF.w(aj(list));
            return;
        }
        this.bjH.setVisibility(0);
        this.bFF.w(ai(list));
    }

    public void WK() {
        if (this.bFH != null) {
            this.bFH.p(this.bEz.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.bii.setSelection(this.bii.getCount() - 1);
            }
        }
    }

    public void WL() {
        if (this.bFH != null && this.bFH.WY() != null) {
            this.bii.removeFooterView(this.bFH.WY());
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bii.removeFooterView(this.byr);
            this.bii.addFooterView(this.byr);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bii.removeFooterView(this.byr);
        }
        if (this.bFF != null && !this.bFF.isEmpty()) {
            this.bFF.b(this.bEz.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        if (this.bFH.WY() != null) {
            this.bFH.WY().n(this.bEz.getPageContext());
        }
        if (this.bFG != null) {
            this.bFG.n(this.bEz.getPageContext());
        }
        if (this.bFI.Wp() != null && this.bFI.Wp().getVisibility() == 0) {
            this.bFI.n(this.bEz.getPageContext());
        }
    }

    public void a(ab.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.bFG != null) {
            this.bFG.setSearchHint(str);
        }
    }

    public void WM() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("enter_forum_login_tip", true)) {
            if (this.bFM == null) {
                this.bFM = new CommonTipView(this.bEz.getActivity());
            }
            this.bFM.setText(w.l.enter_forum_login_tip);
            this.bFM.b(this.bEz.VP(), TbadkCoreApplication.m9getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.bFM != null) {
            this.bFM.onDestroy();
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        this.bFG.setAttentionTitleVisibililty(z);
    }
}
