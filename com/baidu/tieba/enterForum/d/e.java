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
    private View aKK;
    private BdListView aKZ;
    private ViewEventCenter aMt;
    private int aNg = 0;
    private final com.baidu.tieba.enterForum.home.d aNp;
    private com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> aNq;
    private q aNr;
    private ag aNs;
    private com.baidu.tieba.enterForum.c.g aNt;
    private ViewGroup aNu;
    private boolean aNv;
    private List<com.baidu.tieba.tbadkCore.u> aNw;
    private NoNetworkView aNx;
    private boolean aNy;
    private int aNz;
    private com.baidu.tbadk.core.view.z mPullView;

    public e(com.baidu.tieba.enterForum.home.d dVar, ViewEventCenter viewEventCenter) {
        this.aNy = false;
        this.aNp = dVar;
        this.aMt = viewEventCenter;
        this.aNs = new ag(viewEventCenter);
        this.aNt = new com.baidu.tieba.enterForum.c.g(dVar.getPageContext(), viewEventCenter);
        x(this.aNp.getView());
        Je();
        this.aKZ.setAdapter((ListAdapter) this.aNq);
        this.aNy = TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
    }

    private void x(View view) {
        this.aNx = (NoNetworkView) view.findViewById(i.f.view_no_network);
        this.aNu = (ViewGroup) view.findViewById(i.f.container);
        this.aKZ = (BdListView) view.findViewById(i.f.listview);
        this.mPullView = new com.baidu.tbadk.core.view.z(this.aNp.getPageContext());
        this.mPullView.setTag(this.aNp.getUniqueId());
        this.aKZ.setPullRefresh(this.mPullView);
        this.aNr = new q(this.aNp.getFragmentActivity());
        this.aNr.setEventCenter(this.aMt);
        this.aKK = this.aNr.findViewById(i.f.divider_line);
        this.aKZ.addHeaderView(this.aNr);
    }

    public int IZ() {
        return this.aNg;
    }

    public int Jd() {
        return this.aNt.IZ();
    }

    private void Je() {
        this.aNq = new f(this, this.aNp.getPageContext(), new Class[]{y.class, v.class, n.class}, new int[]{i.g.home_like_item_with_portrait, i.g.home_like_item_extra_with_text, i.g.home_like_two_column_item}, this.aMt);
        this.aNq.bj(false);
    }

    public void b(com.baidu.tieba.tbadkCore.u uVar) {
        this.aNt.b(uVar);
    }

    public void M(List<com.baidu.tieba.tbadkCore.u> list) {
        this.aNt.L(list);
    }

    public List<com.baidu.tieba.tbadkCore.u> Jf() {
        return this.aNt.Dp();
    }

    public int Jg() {
        return this.aKZ.getFirstVisiblePosition() - this.aKZ.getHeaderViewsCount();
    }

    public void Jh() {
        this.aNt.Ja();
    }

    public boolean Ji() {
        return this.aNv;
    }

    public void Jj() {
        this.aNg = this.aNt.IZ();
        Q(this.aNt.Dp());
    }

    public void eO(int i) {
        this.aNv = true;
        if (this.aNt.IX() == null) {
            this.aNt.IY();
        }
        i IX = this.aNt.IX();
        IX.e(this.aNp.getPageContext());
        if (IX.getParent() == null) {
            this.aNu.addView(IX, new FrameLayout.LayoutParams(-1, -1));
        }
        this.aNt.a(this.aNg, this.aNw);
        com.baidu.adp.lib.g.h.hi().post(new g(this, i));
    }

    public void Jk() {
        this.aNv = false;
        this.aKZ.setVisibility(0);
        if (this.aNt.IX() != null) {
            this.aNu.removeView(this.aNt.IX());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(int i) {
        int i2;
        int i3;
        int i4;
        if (this.aNt.IX() != null) {
            if (this.aNz == 0) {
                this.aNz = (this.aKZ.getHeight() - com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst(), i.d.ds100)) / com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst(), i.d.ds110);
            }
            if (this.aNg == 2) {
                int Jg = Jg() * 2;
                i2 = ((this.aNz * 2) + Jg) - 1;
                i3 = Jg;
                i4 = i * 2;
            } else {
                int Jg2 = Jg();
                i2 = (this.aNz + Jg2) - 1;
                i3 = Jg2;
                i4 = i;
            }
            if (i4 < i3) {
                i3 = i4;
            }
            if (i4 > i2) {
                if (this.aNg == 2) {
                    i3 += (i4 - i2) * 2;
                } else {
                    i3 += i4 - i2;
                }
            }
            this.aNt.IX().setSelection(i3);
        }
    }

    public void ny() {
        this.aKZ.ny();
    }

    public void Jl() {
        this.aKZ.completePullRefresh();
    }

    public void bN(boolean z) {
        this.aNr.a(this.aNp.getPageContext(), z);
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.s sVar) {
        this.aNr.b(tbPageContext, sVar);
    }

    public void N(List<com.baidu.tieba.enterForum.b.e> list) {
        if (list == null || list.isEmpty()) {
            Jp();
            return;
        }
        this.aNs.a(this.aNp.getFragmentActivity(), list, this.aNp.getPageContext());
        if (this.aKZ.getFooterViewsCount() < 1) {
            this.aKZ.addFooterView(this.aNs.Jz(), null, false);
            com.baidu.tbadk.f.a.a(this.aNp.getPageContext(), this.aNs.Jz());
        }
    }

    public List<com.baidu.tieba.tbadkCore.u> Jm() {
        return this.aNw;
    }

    public List<com.baidu.tieba.tbadkCore.u> Jn() {
        return this.aNt.Dp();
    }

    public void eQ(int i) {
        this.aNg = i;
    }

    private List<Object> O(List<com.baidu.tieba.tbadkCore.u> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            if (this.aNy) {
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
            } else if (i == size && this.aNy) {
                uVar.setType(1);
                return uVar;
            } else {
                uVar.setType(2);
                return uVar;
            }
        }
        return uVar;
    }

    private List<Object> P(List<com.baidu.tieba.tbadkCore.u> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        int size = list.size();
        if (this.aNy) {
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
        this.aNq.notifyDataSetChanged();
    }

    public void Q(List<com.baidu.tieba.tbadkCore.u> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aNq.r(new ArrayList());
            return;
        }
        this.aNw = list;
        if (this.aNg == 2) {
            this.aKK.setVisibility(8);
            this.aNq.r(P(list));
            return;
        }
        this.aKK.setVisibility(0);
        this.aNq.r(O(list));
    }

    public void Jo() {
        if (this.aNs != null) {
            this.aNs.g(this.aNp.getPageContext());
        }
    }

    public void Jp() {
        if (this.aNs != null && this.aNs.Jz() != null) {
            this.aKZ.removeFooterView(this.aNs.Jz());
        }
    }

    public void onResume() {
        if (this.aNx != null && this.aNx.getVisibility() == 0 && com.baidu.adp.lib.util.i.iO()) {
            this.aNx.ax(false);
        }
    }

    public void onStop() {
    }

    public void Jq() {
        if (this.aNx != null) {
            this.aNx.ax(true);
        }
    }

    public void c(NoNetworkView.a aVar) {
        this.aNx.a(aVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.f.a.a(this.aNp.getPageContext(), this.aNp.getView());
        this.aNq.a(this.aNp.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        if (this.aNx != null) {
            this.aNx.onChangeSkinType(this.aNp.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.mPullView != null) {
            this.mPullView.cG(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.aNs.Jz() != null) {
            this.aNs.Jz().e(this.aNp.getPageContext());
        }
        if (this.aNr != null) {
            this.aNr.e(this.aNp.getPageContext());
        }
        if (this.aNt.IX() != null && this.aNt.IX().getVisibility() == 0) {
            this.aNt.e(this.aNp.getPageContext());
        }
    }

    public void a(x.a aVar) {
        this.mPullView.a(aVar);
    }

    public void Jr() {
        this.aNy = true;
        Q(this.aNw);
    }
}
