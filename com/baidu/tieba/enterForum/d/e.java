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
    private ViewEventCenter aRj;
    private View bfW;
    private final com.baidu.tieba.enterForum.home.f bpO;
    private BdListView bqT;
    private com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> bqU;
    private r bqV;
    private ag bqW;
    private com.baidu.tieba.enterForum.c.f bqX;
    private boolean bqY;
    private List<com.baidu.tieba.tbadkCore.v> bqZ;
    private boolean bra;
    private CommonTipView brb;
    private TextView brc;
    private View brd;
    private com.baidu.tbadk.core.view.ac mPullView;
    private int bqK = 0;
    private boolean bre = false;

    public e(com.baidu.tieba.enterForum.home.f fVar, View view, ViewEventCenter viewEventCenter) {
        this.bra = false;
        this.bpO = fVar;
        this.aRj = viewEventCenter;
        this.bqW = new ag(viewEventCenter);
        this.bqX = new com.baidu.tieba.enterForum.c.f(fVar.getPageContext(), viewEventCenter);
        aa(view);
        TH();
        this.bqT.setAdapter((ListAdapter) this.bqU);
        this.bra = TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void aa(View view) {
        this.bqT = (BdListView) view.findViewById(r.g.listview);
        this.mPullView = new com.baidu.tbadk.core.view.ac(this.bpO.getPageContext());
        this.mPullView.setTag(this.bpO.getUniqueId());
        this.mPullView.a(new f(this));
        this.bqT.setPullRefresh(this.mPullView);
        this.bqV = new r(this.bpO.getFragmentActivity());
        this.bqV.setEventCenter(this.aRj);
        this.bfW = this.bqV.findViewById(r.g.divider_line);
        this.bqT.addHeaderView(this.bqV);
        this.brc = (TextView) BdListViewHelper.a(this.bpO.getPageContext().getPageActivity(), this.bqT, BdListViewHelper.HeadType.DEFAULT);
        this.brd = new View(this.bpO.getActivity());
        this.brd.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.bpO.getActivity(), r.e.ds150)));
    }

    public int TC() {
        return this.bqK;
    }

    public int TG() {
        return this.bqX.TC();
    }

    private void TH() {
        this.bqU = new g(this, this.bpO.getPageContext(), new Class[]{y.class, w.class, o.class}, new int[]{r.h.home_like_item_with_portrait, r.h.home_like_item_extra_with_text, r.h.home_like_two_column_item}, this.aRj);
        this.bqU.bS(false);
    }

    public void b(com.baidu.tieba.tbadkCore.v vVar) {
        this.bqX.b(vVar);
    }

    public void af(List<com.baidu.tieba.tbadkCore.v> list) {
        this.bqX.ae(list);
    }

    public List<com.baidu.tieba.tbadkCore.v> TI() {
        return this.bqX.getDataList();
    }

    public void TJ() {
        this.bqX.TD();
    }

    public boolean Tl() {
        return this.bqY;
    }

    public BdListView TK() {
        return this.bqT;
    }

    public TextView TL() {
        return this.brc;
    }

    public void TM() {
        this.bqK = this.bqX.TC();
        aj(this.bqX.getDataList());
    }

    public void gI(int i) {
        this.bqY = true;
        if (this.bqX.TA() == null) {
            this.bqX.TB();
        }
        j TA = this.bqX.TA();
        TA.s(this.bpO.getPageContext());
        if (TA.getParent() == null && this.bpO.SZ() != null && this.bpO.SY() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.bpO.SZ().getId());
            this.bpO.SY().addView(TA);
        }
        this.bqX.a(this.bqK, this.bqZ);
        com.baidu.adp.lib.h.h.eG().post(new h(this, i));
    }

    public void TN() {
        this.bqY = false;
        this.bqT.setVisibility(0);
        if (this.bqX.TA() != null && this.bpO.SY() != null) {
            this.bpO.SY().removeView(this.bqX.TA());
        }
    }

    public void TO() {
        this.bqT.setVisibility(8);
        if (this.bqX.TA() != null) {
            this.bqX.TA().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(int i) {
        int i2;
        if (this.bqX.TA() != null && this.bqT != null && this.bqT.getChildCount() > 0) {
            int firstVisiblePosition = this.bqT.getFirstVisiblePosition();
            if (this.bqK == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.bqT.getChildAt(0);
            this.bqX.TA().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void kv() {
        this.bqT.kv();
    }

    public void TP() {
        this.bqT.l(2000L);
    }

    public void dc(boolean z) {
        this.bqV.a(this.bpO.getPageContext(), z);
    }

    public void f(com.baidu.tieba.enterForum.b.b bVar) {
        this.bqV.a(this.bpO.getPageContext(), bVar);
    }

    public void b(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bqV.b(list, tbPageContext);
    }

    public void ab(View view) {
        if (this.bqV != null && view != null) {
            this.bqV.ab(view);
        }
    }

    public View getBannerView() {
        if (this.bqV == null) {
            return null;
        }
        return this.bqV.getBannerView();
    }

    public void ag(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list == null || list.isEmpty()) {
            TU();
            return;
        }
        this.bqW.a(this.bpO.getFragmentActivity(), list, this.bpO.getPageContext());
        if (!TbadkCoreApplication.isLogin()) {
            if (this.bqT.getFooterViewsCount() < 1) {
                TQ();
            }
        } else if (this.bqT.getFooterViewsCount() < 2) {
            TQ();
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bqT.removeFooterView(this.brd);
            this.bqT.addFooterView(this.brd);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bqT.removeFooterView(this.brd);
        }
    }

    private void TQ() {
        this.bqT.addFooterView(this.bqW.Uh(), null, false);
        com.baidu.tbadk.i.a.a(this.bpO.getPageContext(), this.bqW.Uh());
    }

    public List<com.baidu.tieba.tbadkCore.v> TR() {
        return this.bqZ;
    }

    public List<com.baidu.tieba.tbadkCore.v> TS() {
        return this.bqX.getDataList();
    }

    public void gK(int i) {
        this.bqK = i;
    }

    private List<Object> ah(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.bra) {
                arrayList.add(new com.baidu.tieba.tbadkCore.v(1));
            }
        }
        return arrayList;
    }

    private com.baidu.tieba.tbadkCore.v b(int i, List<com.baidu.tieba.tbadkCore.v> list) {
        com.baidu.tieba.tbadkCore.v vVar = new com.baidu.tieba.tbadkCore.v();
        if (list != null) {
            int size = list.size();
            if (i < size) {
                com.baidu.tieba.tbadkCore.v vVar2 = list.get(i);
                vVar2.setType(0);
                return vVar2;
            } else if (i == size && this.bra) {
                vVar.setType(1);
                return vVar;
            } else {
                vVar.setType(2);
                return vVar;
            }
        }
        return vVar;
    }

    private List<Object> ai(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.bra) {
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
        this.bqU.notifyDataSetChanged();
    }

    public void aj(List<com.baidu.tieba.tbadkCore.v> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.bqU.A(new ArrayList());
            return;
        }
        this.bqZ = list;
        if (this.bqK == 2) {
            this.bfW.setVisibility(8);
            this.bqU.A(ai(list));
            return;
        }
        this.bfW.setVisibility(0);
        this.bqU.A(ah(list));
    }

    public void TT() {
        if (this.bqW != null) {
            this.bqW.u(this.bpO.getPageContext());
            if (TbadkCoreApplication.isLogin()) {
                this.bqT.setSelection(this.bqT.getCount() - 1);
            }
        }
    }

    public void TU() {
        if (this.bqW != null && this.bqW.Uh() != null) {
            this.bqT.removeFooterView(this.bqW.Uh());
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.m9getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bqT.removeFooterView(this.brd);
            this.bqT.addFooterView(this.brd);
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            this.bqT.removeFooterView(this.brd);
        }
        if (this.bqU != null && !this.bqU.isEmpty()) {
            this.bqU.a(this.bpO.getPageContext(), i);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        if (this.bqW.Uh() != null) {
            this.bqW.Uh().s(this.bpO.getPageContext());
        }
        if (this.bqV != null) {
            this.bqV.s(this.bpO.getPageContext());
        }
        if (this.bqX.TA() != null && this.bqX.TA().getVisibility() == 0) {
            this.bqX.s(this.bpO.getPageContext());
        }
    }

    public void a(z.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.bqV != null) {
            this.bqV.setSearchHint(str);
        }
    }

    public void TV() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("enter_forum_login_tip", true)) {
            if (this.brb == null) {
                this.brb = new CommonTipView(this.bpO.getActivity());
            }
            this.brb.setText(r.j.enter_forum_login_tip);
            this.brb.b(this.bpO.SY(), TbadkCoreApplication.m9getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestory() {
        if (this.brb != null) {
            this.brb.onDestroy();
        }
    }

    public void setAttentionTitleVisibililty(boolean z) {
        this.bqV.setAttentionTitleVisibililty(z);
    }
}
