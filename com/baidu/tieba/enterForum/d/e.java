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
    private View aKa;
    private BdListView aKp;
    private ViewEventCenter aLM;
    private final com.baidu.tieba.enterForum.home.d aMI;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> aMJ;
    private r aMK;
    private ah aML;
    private com.baidu.tieba.enterForum.c.g aMM;
    private ViewGroup aMN;
    private boolean aMO;
    private List<com.baidu.tieba.tbadkCore.v> aMP;
    private NoNetworkView aMQ;
    private boolean aMR;
    private int aMz = 0;
    private com.baidu.tbadk.core.view.r mPullView;

    public e(com.baidu.tieba.enterForum.home.d dVar, ViewEventCenter viewEventCenter) {
        this.aMR = false;
        this.aMI = dVar;
        this.aLM = viewEventCenter;
        this.aML = new ah(viewEventCenter);
        this.aMM = new com.baidu.tieba.enterForum.c.g(dVar.getPageContext(), viewEventCenter);
        x(this.aMI.getView());
        IK();
        this.aKp.setAdapter((ListAdapter) this.aMJ);
        this.aMR = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
    }

    private void x(View view) {
        this.aMQ = (NoNetworkView) view.findViewById(i.f.view_no_network);
        this.aMN = (ViewGroup) view.findViewById(i.f.container);
        this.aKp = (BdListView) view.findViewById(i.f.listview);
        this.mPullView = new com.baidu.tbadk.core.view.r(this.aMI.getPageContext());
        this.mPullView.setTag(this.aMI.getUniqueId());
        this.aKp.setPullRefresh(this.mPullView);
        this.aMK = new r(this.aMI.getFragmentActivity());
        this.aMK.setEventCenter(this.aLM);
        this.aKa = this.aMK.findViewById(i.f.divider_line);
        this.aKp.addHeaderView(this.aMK);
    }

    public int IF() {
        return this.aMz;
    }

    public int IJ() {
        return this.aMM.IF();
    }

    private void IK() {
        this.aMJ = new f(this, this.aMI.getPageContext(), new Class[]{z.class, w.class, o.class}, new int[]{i.g.home_like_item_with_portrait, i.g.home_like_item_extra_with_text, i.g.home_like_two_column_item}, this.aLM);
        this.aMJ.bo(false);
    }

    public void b(com.baidu.tieba.tbadkCore.v vVar) {
        this.aMM.b(vVar);
    }

    public void O(List<com.baidu.tieba.tbadkCore.v> list) {
        this.aMM.N(list);
    }

    public List<com.baidu.tieba.tbadkCore.v> IL() {
        return this.aMM.Dj();
    }

    public void IM() {
        this.aMM.IG();
    }

    public boolean IN() {
        return this.aMO;
    }

    public void IO() {
        this.aMz = this.aMM.IF();
        S(this.aMM.Dj());
    }

    public void fa(int i) {
        this.aMO = true;
        if (this.aMM.ID() == null) {
            this.aMM.IE();
        }
        i ID = this.aMM.ID();
        ID.e(this.aMI.getPageContext());
        if (ID.getParent() == null) {
            this.aMN.addView(ID, new FrameLayout.LayoutParams(-1, -1));
        }
        this.aMM.a(this.aMz, this.aMP);
        com.baidu.adp.lib.g.h.hg().post(new g(this, i));
    }

    public void IP() {
        this.aMO = false;
        this.aKp.setVisibility(0);
        if (this.aMM.ID() != null) {
            this.aMN.removeView(this.aMM.ID());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(int i) {
        int i2;
        if (this.aMM.ID() != null && this.aKp != null && this.aKp.getChildCount() > 0) {
            int firstVisiblePosition = this.aKp.getFirstVisiblePosition();
            if (this.aMz == 2) {
                i2 = (firstVisiblePosition * 2) - 1;
            } else {
                i2 = firstVisiblePosition - 1;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            View childAt = this.aKp.getChildAt(0);
            this.aMM.ID().setSelectionFromTop(i2, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void nw() {
        this.aKp.nw();
    }

    public void IQ() {
        this.aKp.completePullRefresh();
    }

    public void bP(boolean z) {
        this.aMK.a(this.aMI.getPageContext(), z);
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.u uVar) {
        this.aMK.b(tbPageContext, uVar);
    }

    public void P(List<com.baidu.tieba.enterForum.b.f> list) {
        if (list == null || list.isEmpty()) {
            IU();
            return;
        }
        this.aML.a(this.aMI.getFragmentActivity(), list, this.aMI.getPageContext());
        if (this.aKp.getFooterViewsCount() < 1) {
            this.aKp.addFooterView(this.aML.Je(), null, false);
            com.baidu.tbadk.h.a.a(this.aMI.getPageContext(), this.aML.Je());
        }
    }

    public List<com.baidu.tieba.tbadkCore.v> IR() {
        return this.aMP;
    }

    public List<com.baidu.tieba.tbadkCore.v> IS() {
        return this.aMM.Dj();
    }

    public void fc(int i) {
        this.aMz = i;
    }

    private List<Object> Q(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.aMR) {
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
            } else if (i == size && this.aMR) {
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
        if (this.aMR) {
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
        this.aMJ.notifyDataSetChanged();
    }

    public void S(List<com.baidu.tieba.tbadkCore.v> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aMJ.r(new ArrayList());
            return;
        }
        this.aMP = list;
        if (this.aMz == 2) {
            this.aKa.setVisibility(8);
            this.aMJ.r(R(list));
            return;
        }
        this.aKa.setVisibility(0);
        this.aMJ.r(Q(list));
    }

    public void IT() {
        if (this.aML != null) {
            this.aML.g(this.aMI.getPageContext());
        }
    }

    public void IU() {
        if (this.aML != null && this.aML.Je() != null) {
            this.aKp.removeFooterView(this.aML.Je());
        }
    }

    public void onResume() {
        if (this.aMQ != null && this.aMQ.getVisibility() == 0 && com.baidu.adp.lib.util.i.iM()) {
            this.aMQ.aw(false);
        }
    }

    public void onStop() {
    }

    public void IV() {
        if (this.aMQ != null) {
            this.aMQ.aw(true);
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.aMQ.a(aVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.aMI.getPageContext(), this.aMI.getView());
        this.aMJ.a(this.aMI.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        if (this.aMQ != null) {
            this.aMQ.onChangeSkinType(this.aMI.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.mPullView != null) {
            this.mPullView.cN(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.aML.Je() != null) {
            this.aML.Je().e(this.aMI.getPageContext());
        }
        if (this.aMK != null) {
            this.aMK.e(this.aMI.getPageContext());
        }
        if (this.aMM.ID() != null && this.aMM.ID().getVisibility() == 0) {
            this.aMM.e(this.aMI.getPageContext());
        }
    }

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void IW() {
        this.aMR = true;
        S(this.aMP);
    }

    public void setSearchHint(String str) {
        if (this.aMK != null) {
            this.aMK.setSearchHint(str);
        }
    }
}
