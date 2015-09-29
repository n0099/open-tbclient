package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private View aJP;
    private BdListView aKe;
    private ViewEventCenter aLB;
    private ah aMA;
    private com.baidu.tieba.enterForum.c.g aMB;
    private ViewGroup aMC;
    private boolean aMD;
    private List<com.baidu.tieba.tbadkCore.v> aME;
    private NoNetworkView aMF;
    private boolean aMG;
    private int aMo = 0;
    private final com.baidu.tieba.enterForum.home.d aMx;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> aMy;
    private r aMz;
    private com.baidu.tbadk.core.view.r mPullView;

    public e(com.baidu.tieba.enterForum.home.d dVar, ViewEventCenter viewEventCenter) {
        this.aMG = false;
        this.aMx = dVar;
        this.aLB = viewEventCenter;
        this.aMA = new ah(viewEventCenter);
        this.aMB = new com.baidu.tieba.enterForum.c.g(dVar.getPageContext(), viewEventCenter);
        x(this.aMx.getView());
        IO();
        this.aKe.setAdapter((ListAdapter) this.aMy);
        this.aMG = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
    }

    private void x(View view) {
        this.aMF = (NoNetworkView) view.findViewById(i.f.view_no_network);
        this.aMC = (ViewGroup) view.findViewById(i.f.container);
        this.aKe = (BdListView) view.findViewById(i.f.listview);
        this.mPullView = new com.baidu.tbadk.core.view.r(this.aMx.getPageContext());
        this.mPullView.setTag(this.aMx.getUniqueId());
        this.aKe.setPullRefresh(this.mPullView);
        this.aMz = new r(this.aMx.getFragmentActivity());
        this.aMz.setEventCenter(this.aLB);
        this.aJP = this.aMz.findViewById(i.f.divider_line);
        this.aKe.addHeaderView(this.aMz);
    }

    public int IJ() {
        return this.aMo;
    }

    public int IN() {
        return this.aMB.IJ();
    }

    private void IO() {
        this.aMy = new f(this, this.aMx.getPageContext(), new Class[]{z.class, w.class, o.class}, new int[]{i.g.home_like_item_with_portrait, i.g.home_like_item_extra_with_text, i.g.home_like_two_column_item}, this.aLB);
        this.aMy.bo(false);
    }

    public void b(com.baidu.tieba.tbadkCore.v vVar) {
        this.aMB.b(vVar);
    }

    public void O(List<com.baidu.tieba.tbadkCore.v> list) {
        this.aMB.N(list);
    }

    public List<com.baidu.tieba.tbadkCore.v> IP() {
        return this.aMB.Dm();
    }

    public void IQ() {
        this.aMB.IK();
    }

    public boolean IR() {
        return this.aMD;
    }

    public void IS() {
        this.aMo = this.aMB.IJ();
        S(this.aMB.Dm());
    }

    public void fa(int i) {
        this.aMD = true;
        if (this.aMB.IH() == null) {
            this.aMB.II();
        }
        i IH = this.aMB.IH();
        IH.e(this.aMx.getPageContext());
        if (IH.getParent() == null) {
            this.aMC.addView(IH, new FrameLayout.LayoutParams(-1, -1));
        }
        this.aMB.a(this.aMo, this.aME);
        com.baidu.adp.lib.g.h.hg().post(new g(this, i));
    }

    public void IT() {
        this.aMD = false;
        this.aKe.setVisibility(0);
        if (this.aMB.IH() != null) {
            this.aMC.removeView(this.aMB.IH());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(int i) {
        int i2;
        if (this.aMB.IH() != null && this.aKe != null && this.aKe.getChildCount() > 0) {
            int firstVisiblePosition = this.aKe.getFirstVisiblePosition();
            if (this.aMo == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.aKe.getChildAt(0);
            this.aMB.IH().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void nw() {
        this.aKe.nw();
    }

    public void IU() {
        this.aKe.completePullRefresh();
    }

    public void bP(boolean z) {
        this.aMz.a(this.aMx.getPageContext(), z);
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.t tVar) {
        this.aMz.b(tbPageContext, tVar);
    }

    public void P(List<com.baidu.tieba.enterForum.b.f> list) {
        if (list == null || list.isEmpty()) {
            IY();
            return;
        }
        this.aMA.a(this.aMx.getFragmentActivity(), list, this.aMx.getPageContext());
        if (this.aKe.getFooterViewsCount() < 1) {
            this.aKe.addFooterView(this.aMA.Ji(), null, false);
            com.baidu.tbadk.h.a.a(this.aMx.getPageContext(), this.aMA.Ji());
        }
    }

    public List<com.baidu.tieba.tbadkCore.v> IV() {
        return this.aME;
    }

    public List<com.baidu.tieba.tbadkCore.v> IW() {
        return this.aMB.Dm();
    }

    public void fc(int i) {
        this.aMo = i;
    }

    private List<Object> Q(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.aMG) {
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
            } else if (i == size && this.aMG) {
                vVar.setType(1);
                return vVar;
            } else {
                vVar.setType(2);
                return vVar;
            }
        }
        return vVar;
    }

    private List<Object> R(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.aMG) {
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
        this.aMy.notifyDataSetChanged();
    }

    public void S(List<com.baidu.tieba.tbadkCore.v> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aMy.r(new ArrayList());
            return;
        }
        this.aME = list;
        if (this.aMo == 2) {
            this.aJP.setVisibility(8);
            this.aMy.r(R(list));
            return;
        }
        this.aJP.setVisibility(0);
        this.aMy.r(Q(list));
    }

    public void IX() {
        if (this.aMA != null) {
            this.aMA.g(this.aMx.getPageContext());
        }
    }

    public void IY() {
        if (this.aMA != null && this.aMA.Ji() != null) {
            this.aKe.removeFooterView(this.aMA.Ji());
        }
    }

    public void onResume() {
        if (this.aMF != null && this.aMF.getVisibility() == 0 && com.baidu.adp.lib.util.i.iM()) {
            this.aMF.aw(false);
        }
    }

    public void onStop() {
    }

    public void IZ() {
        if (this.aMF != null) {
            this.aMF.aw(true);
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.aMF.a(aVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.aMx.getPageContext(), this.aMx.getView());
        this.aMy.a(this.aMx.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        if (this.aMF != null) {
            this.aMF.onChangeSkinType(this.aMx.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.mPullView != null) {
            this.mPullView.cN(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.aMA.Ji() != null) {
            this.aMA.Ji().e(this.aMx.getPageContext());
        }
        if (this.aMz != null) {
            this.aMz.e(this.aMx.getPageContext());
        }
        if (this.aMB.IH() != null && this.aMB.IH().getVisibility() == 0) {
            this.aMB.e(this.aMx.getPageContext());
        }
    }

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void Ja() {
        this.aMG = true;
        S(this.aME);
    }

    public void setSearchHint(String str) {
        if (this.aMz != null) {
            this.aMz.setSearchHint(str);
        }
    }
}
