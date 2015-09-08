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
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private View aKX;
    private BdListView aLm;
    private ViewEventCenter aMG;
    private final com.baidu.tieba.enterForum.home.d aNC;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> aND;
    private q aNE;
    private ag aNF;
    private com.baidu.tieba.enterForum.c.g aNG;
    private ViewGroup aNH;
    private boolean aNI;
    private List<com.baidu.tieba.tbadkCore.v> aNJ;
    private NoNetworkView aNK;
    private boolean aNL;
    private int aNM;
    private int aNt = 0;
    private com.baidu.tbadk.core.view.z mPullView;

    public e(com.baidu.tieba.enterForum.home.d dVar, ViewEventCenter viewEventCenter) {
        this.aNL = false;
        this.aNC = dVar;
        this.aMG = viewEventCenter;
        this.aNF = new ag(viewEventCenter);
        this.aNG = new com.baidu.tieba.enterForum.c.g(dVar.getPageContext(), viewEventCenter);
        x(this.aNC.getView());
        IS();
        this.aLm.setAdapter((ListAdapter) this.aND);
        this.aNL = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
    }

    private void x(View view) {
        this.aNK = (NoNetworkView) view.findViewById(i.f.view_no_network);
        this.aNH = (ViewGroup) view.findViewById(i.f.container);
        this.aLm = (BdListView) view.findViewById(i.f.listview);
        this.mPullView = new com.baidu.tbadk.core.view.z(this.aNC.getPageContext());
        this.mPullView.setTag(this.aNC.getUniqueId());
        this.aLm.setPullRefresh(this.mPullView);
        this.aNE = new q(this.aNC.getFragmentActivity());
        this.aNE.setEventCenter(this.aMG);
        this.aKX = this.aNE.findViewById(i.f.divider_line);
        this.aLm.addHeaderView(this.aNE);
    }

    public int IN() {
        return this.aNt;
    }

    public int IR() {
        return this.aNG.IN();
    }

    private void IS() {
        this.aND = new f(this, this.aNC.getPageContext(), new Class[]{y.class, v.class, n.class}, new int[]{i.g.home_like_item_with_portrait, i.g.home_like_item_extra_with_text, i.g.home_like_two_column_item}, this.aMG);
        this.aND.bq(false);
    }

    public void b(com.baidu.tieba.tbadkCore.v vVar) {
        this.aNG.b(vVar);
    }

    public void N(List<com.baidu.tieba.tbadkCore.v> list) {
        this.aNG.M(list);
    }

    public List<com.baidu.tieba.tbadkCore.v> IT() {
        return this.aNG.Dz();
    }

    public int IU() {
        return this.aLm.getFirstVisiblePosition() - this.aLm.getHeaderViewsCount();
    }

    public void IV() {
        this.aNG.IO();
    }

    public boolean IW() {
        return this.aNI;
    }

    public void IX() {
        this.aNt = this.aNG.IN();
        R(this.aNG.Dz());
    }

    public void eV(int i) {
        this.aNI = true;
        if (this.aNG.IL() == null) {
            this.aNG.IM();
        }
        i IL = this.aNG.IL();
        IL.e(this.aNC.getPageContext());
        if (IL.getParent() == null) {
            this.aNH.addView(IL, new FrameLayout.LayoutParams(-1, -1));
        }
        this.aNG.a(this.aNt, this.aNJ);
        com.baidu.adp.lib.g.h.hf().post(new g(this, i));
    }

    public void IY() {
        this.aNI = false;
        this.aLm.setVisibility(0);
        if (this.aNG.IL() != null) {
            this.aNH.removeView(this.aNG.IL());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(int i) {
        int i2;
        int i3;
        int i4;
        if (this.aNG.IL() != null) {
            if (this.aNM == 0) {
                this.aNM = (this.aLm.getHeight() - com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst(), i.d.ds100)) / com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst(), i.d.ds110);
            }
            if (this.aNt == 2) {
                int IU = IU() * 2;
                i2 = ((this.aNM * 2) + IU) - 1;
                i3 = IU;
                i4 = i * 2;
            } else {
                int IU2 = IU();
                i2 = (this.aNM + IU2) - 1;
                i3 = IU2;
                i4 = i;
            }
            if (i4 < i3) {
                i3 = i4;
            }
            if (i4 > i2) {
                if (this.aNt == 2) {
                    i3 += (i4 - i2) * 2;
                } else {
                    i3 += i4 - i2;
                }
            }
            this.aNG.IL().setSelection(i3);
        }
    }

    public void nv() {
        this.aLm.nv();
    }

    public void IZ() {
        this.aLm.completePullRefresh();
    }

    public void bS(boolean z) {
        this.aNE.a(this.aNC.getPageContext(), z);
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.u uVar) {
        this.aNE.b(tbPageContext, uVar);
    }

    public void O(List<com.baidu.tieba.enterForum.b.e> list) {
        if (list == null || list.isEmpty()) {
            Jd();
            return;
        }
        this.aNF.a(this.aNC.getFragmentActivity(), list, this.aNC.getPageContext());
        if (this.aLm.getFooterViewsCount() < 1) {
            this.aLm.addFooterView(this.aNF.Jn(), null, false);
            com.baidu.tbadk.h.a.a(this.aNC.getPageContext(), this.aNF.Jn());
        }
    }

    public List<com.baidu.tieba.tbadkCore.v> Ja() {
        return this.aNJ;
    }

    public List<com.baidu.tieba.tbadkCore.v> Jb() {
        return this.aNG.Dz();
    }

    public void eX(int i) {
        this.aNt = i;
    }

    private List<Object> P(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.aNL) {
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
            } else if (i == size && this.aNL) {
                vVar.setType(1);
                return vVar;
            } else {
                vVar.setType(2);
                return vVar;
            }
        }
        return vVar;
    }

    private List<Object> Q(List<com.baidu.tieba.tbadkCore.v> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.aNL) {
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
        this.aND.notifyDataSetChanged();
    }

    public void R(List<com.baidu.tieba.tbadkCore.v> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aND.s(new ArrayList());
            return;
        }
        this.aNJ = list;
        if (this.aNt == 2) {
            this.aKX.setVisibility(8);
            this.aND.s(Q(list));
            return;
        }
        this.aKX.setVisibility(0);
        this.aND.s(P(list));
    }

    public void Jc() {
        if (this.aNF != null) {
            this.aNF.g(this.aNC.getPageContext());
        }
    }

    public void Jd() {
        if (this.aNF != null && this.aNF.Jn() != null) {
            this.aLm.removeFooterView(this.aNF.Jn());
        }
    }

    public void onResume() {
        if (this.aNK != null && this.aNK.getVisibility() == 0 && com.baidu.adp.lib.util.i.iL()) {
            this.aNK.ax(false);
        }
    }

    public void onStop() {
    }

    public void Je() {
        if (this.aNK != null) {
            this.aNK.ax(true);
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.aNK.a(aVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.h.a.a(this.aNC.getPageContext(), this.aNC.getView());
        this.aND.a(this.aNC.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        if (this.aNK != null) {
            this.aNK.onChangeSkinType(this.aNC.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.mPullView != null) {
            this.mPullView.cM(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.aNF.Jn() != null) {
            this.aNF.Jn().e(this.aNC.getPageContext());
        }
        if (this.aNE != null) {
            this.aNE.e(this.aNC.getPageContext());
        }
        if (this.aNG.IL() != null && this.aNG.IL().getVisibility() == 0) {
            this.aNG.e(this.aNC.getPageContext());
        }
    }

    public void a(x.a aVar) {
        this.mPullView.a(aVar);
    }

    public void Jf() {
        this.aNL = true;
        R(this.aNJ);
    }
}
