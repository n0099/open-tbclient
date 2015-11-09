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
    private View aIU;
    private BdListView aJj;
    private ViewEventCenter aLU;
    private int aMH = 0;
    private final com.baidu.tieba.enterForum.home.d aMQ;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> aMR;
    private r aMS;
    private ah aMT;
    private com.baidu.tieba.enterForum.c.g aMU;
    private ViewGroup aMV;
    private boolean aMW;
    private List<com.baidu.tieba.tbadkCore.v> aMX;
    private NoNetworkView aMY;
    private boolean aMZ;
    private com.baidu.tbadk.core.view.r mPullView;

    public e(com.baidu.tieba.enterForum.home.d dVar, ViewEventCenter viewEventCenter) {
        this.aMZ = false;
        this.aMQ = dVar;
        this.aLU = viewEventCenter;
        this.aMT = new ah(viewEventCenter);
        this.aMU = new com.baidu.tieba.enterForum.c.g(dVar.getPageContext(), viewEventCenter);
        y(this.aMQ.getView());
        Ja();
        this.aJj.setAdapter((ListAdapter) this.aMR);
        this.aMZ = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
    }

    private void y(View view) {
        this.aMY = (NoNetworkView) view.findViewById(i.f.view_no_network);
        this.aMV = (ViewGroup) view.findViewById(i.f.container);
        this.aJj = (BdListView) view.findViewById(i.f.listview);
        this.mPullView = new com.baidu.tbadk.core.view.r(this.aMQ.getPageContext());
        this.mPullView.setTag(this.aMQ.getUniqueId());
        this.aJj.setPullRefresh(this.mPullView);
        this.aMS = new r(this.aMQ.getFragmentActivity());
        this.aMS.setEventCenter(this.aLU);
        this.aIU = this.aMS.findViewById(i.f.divider_line);
        this.aJj.addHeaderView(this.aMS);
    }

    public int IV() {
        return this.aMH;
    }

    public int IZ() {
        return this.aMU.IV();
    }

    private void Ja() {
        this.aMR = new f(this, this.aMQ.getPageContext(), new Class[]{z.class, w.class, o.class}, new int[]{i.g.home_like_item_with_portrait, i.g.home_like_item_extra_with_text, i.g.home_like_two_column_item}, this.aLU);
        this.aMR.br(false);
    }

    public void b(com.baidu.tieba.tbadkCore.v vVar) {
        this.aMU.b(vVar);
    }

    public void Q(List<com.baidu.tieba.tbadkCore.v> list) {
        this.aMU.P(list);
    }

    public List<com.baidu.tieba.tbadkCore.v> Jb() {
        return this.aMU.Dc();
    }

    public void Jc() {
        this.aMU.IW();
    }

    public boolean Jd() {
        return this.aMW;
    }

    public void Je() {
        this.aMH = this.aMU.IV();
        U(this.aMU.Dc());
    }

    public void fi(int i) {
        this.aMW = true;
        if (this.aMU.IT() == null) {
            this.aMU.IU();
        }
        i IT = this.aMU.IT();
        IT.e(this.aMQ.getPageContext());
        if (IT.getParent() == null) {
            this.aMV.addView(IT, new FrameLayout.LayoutParams(-1, -1));
        }
        this.aMU.a(this.aMH, this.aMX);
        com.baidu.adp.lib.g.h.hh().post(new g(this, i));
    }

    public void Jf() {
        this.aMW = false;
        this.aJj.setVisibility(0);
        if (this.aMU.IT() != null) {
            this.aMV.removeView(this.aMU.IT());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj(int i) {
        int i2;
        if (this.aMU.IT() != null && this.aJj != null && this.aJj.getChildCount() > 0) {
            int firstVisiblePosition = this.aJj.getFirstVisiblePosition();
            if (this.aMH == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.aJj.getChildAt(0);
            this.aMU.IT().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void nx() {
        this.aJj.nx();
    }

    public void Jg() {
        this.aJj.completePullRefresh();
    }

    public void bR(boolean z) {
        this.aMS.a(this.aMQ.getPageContext(), z);
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.u uVar) {
        this.aMS.b(tbPageContext, uVar);
    }

    public void R(List<com.baidu.tieba.enterForum.b.f> list) {
        if (list == null || list.isEmpty()) {
            Jk();
            return;
        }
        this.aMT.a(this.aMQ.getFragmentActivity(), list, this.aMQ.getPageContext());
        if (this.aJj.getFooterViewsCount() < 1) {
            this.aJj.addFooterView(this.aMT.Ju(), null, false);
            com.baidu.tbadk.h.a.a(this.aMQ.getPageContext(), this.aMT.Ju());
        }
    }

    public List<com.baidu.tieba.tbadkCore.v> Jh() {
        return this.aMX;
    }

    public List<com.baidu.tieba.tbadkCore.v> Ji() {
        return this.aMU.Dc();
    }

    public void fk(int i) {
        this.aMH = i;
    }

    private List<Object> S(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.aMZ) {
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
            } else if (i == size && this.aMZ) {
                vVar.setType(1);
                return vVar;
            } else {
                vVar.setType(2);
                return vVar;
            }
        }
        return vVar;
    }

    private List<Object> T(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.aMZ) {
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
        this.aMR.notifyDataSetChanged();
    }

    public void U(List<com.baidu.tieba.tbadkCore.v> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aMR.s(new ArrayList());
            return;
        }
        this.aMX = list;
        if (this.aMH == 2) {
            this.aIU.setVisibility(8);
            this.aMR.s(T(list));
            return;
        }
        this.aIU.setVisibility(0);
        this.aMR.s(S(list));
    }

    public void Jj() {
        if (this.aMT != null) {
            this.aMT.g(this.aMQ.getPageContext());
        }
    }

    public void Jk() {
        if (this.aMT != null && this.aMT.Ju() != null) {
            this.aJj.removeFooterView(this.aMT.Ju());
        }
    }

    public void onResume() {
        if (this.aMY != null && this.aMY.getVisibility() == 0 && com.baidu.adp.lib.util.i.iN()) {
            this.aMY.aw(false);
        }
    }

    public void onStop() {
    }

    public void Jl() {
        if (this.aMY != null) {
            this.aMY.aw(true);
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.aMY.a(aVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.aMQ.getPageContext(), this.aMQ.getView());
        this.aMR.a(this.aMQ.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        if (this.aMY != null) {
            this.aMY.onChangeSkinType(this.aMQ.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.mPullView != null) {
            this.mPullView.cN(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.aMT.Ju() != null) {
            this.aMT.Ju().e(this.aMQ.getPageContext());
        }
        if (this.aMS != null) {
            this.aMS.e(this.aMQ.getPageContext());
        }
        if (this.aMU.IT() != null && this.aMU.IT().getVisibility() == 0) {
            this.aMU.e(this.aMQ.getPageContext());
        }
    }

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void Jm() {
        this.aMZ = true;
        U(this.aMX);
    }

    public void setSearchHint(String str) {
        if (this.aMS != null) {
            this.aMS.setSearchHint(str);
        }
    }
}
