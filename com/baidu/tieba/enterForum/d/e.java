package com.baidu.tieba.enterForum.d;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.aj;
import com.baidu.tbadk.core.view.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private BdListView aDB;
    private View aDm;
    private ViewEventCenter aET;
    private int aFG = 0;
    private final com.baidu.tieba.enterForum.home.a aFP;
    private com.baidu.tbadk.mvc.j.b<Object, com.baidu.tbadk.mvc.e.c, com.baidu.tbadk.mvc.j.a<Object, com.baidu.tbadk.mvc.e.c>> aFQ;
    private q aFR;
    private ag aFS;
    private com.baidu.tieba.enterForum.c.i aFT;
    private ViewGroup aFU;
    private boolean aFV;
    private List<com.baidu.tieba.tbadkCore.ae> aFW;
    private NoNetworkView aFX;
    private int aFY;
    private al mPullView;

    public e(com.baidu.tieba.enterForum.home.a aVar, ViewEventCenter viewEventCenter) {
        this.aFP = aVar;
        this.aET = viewEventCenter;
        this.aFS = new ag(viewEventCenter);
        this.aFT = new com.baidu.tieba.enterForum.c.i(aVar.getPageContext(), viewEventCenter);
        v(this.aFP.getView());
        Iq();
        this.aDB.setAdapter((ListAdapter) this.aFQ);
    }

    private void v(View view) {
        this.aFX = (NoNetworkView) view.findViewById(com.baidu.tieba.q.view_no_network);
        this.aFU = (ViewGroup) view.findViewById(com.baidu.tieba.q.container);
        this.aDB = (BdListView) view.findViewById(com.baidu.tieba.q.listview);
        this.mPullView = new al(this.aFP.getPageContext());
        this.mPullView.setTag(this.aFP.getUniqueId());
        this.aDB.setPullRefresh(this.mPullView);
        this.aFR = new q(this.aFP.getFragmentActivity());
        this.aFR.setEventCenter(this.aET);
        this.aDm = this.aFR.findViewById(com.baidu.tieba.q.divider_line);
        this.aDB.addHeaderView(this.aFR);
    }

    public int Il() {
        return this.aFG;
    }

    public int Ip() {
        return this.aFT.Il();
    }

    private void Iq() {
        this.aFQ = new f(this, this.aFP.getPageContext(), new Class[]{y.class, v.class, n.class}, new int[]{com.baidu.tieba.r.home_like_item_with_portrait, com.baidu.tieba.r.home_like_item_extra_with_text, com.baidu.tieba.r.home_like_two_column_item}, this.aET);
        this.aFQ.bi(false);
    }

    public void b(com.baidu.tieba.tbadkCore.ae aeVar) {
        this.aFT.b(aeVar);
    }

    public void N(List<com.baidu.tieba.tbadkCore.ae> list) {
        this.aFT.M(list);
    }

    public List<com.baidu.tieba.tbadkCore.ae> Ir() {
        return this.aFT.CM();
    }

    public int Is() {
        return this.aDB.getFirstVisiblePosition() - this.aDB.getHeaderViewsCount();
    }

    public void It() {
        this.aFT.Im();
    }

    public boolean Iu() {
        return this.aFV;
    }

    public void Iv() {
        this.aFG = this.aFT.Il();
        R(this.aFT.CM());
    }

    public void eI(int i) {
        this.aFV = true;
        if (this.aFT.Ij() == null) {
            this.aFT.Ik();
        }
        i Ij = this.aFT.Ij();
        Ij.d(this.aFP.getPageContext());
        if (Ij.getParent() == null) {
            this.aFU.addView(Ij, new FrameLayout.LayoutParams(-1, -1));
        }
        this.aFT.a(this.aFG, this.aFW);
        com.baidu.adp.lib.g.i.hs().post(new g(this, i));
    }

    public void Iw() {
        this.aFV = false;
        this.aDB.setVisibility(0);
        if (this.aFT.Ij() != null) {
            this.aFU.removeView(this.aFT.Ij());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(int i) {
        int i2;
        int i3;
        int i4;
        if (this.aFT.Ij() != null) {
            if (this.aFY == 0) {
                this.aFY = (this.aDB.getHeight() - com.baidu.adp.lib.util.n.d(TbadkCoreApplication.m411getInst(), com.baidu.tieba.o.ds100)) / com.baidu.adp.lib.util.n.d(TbadkCoreApplication.m411getInst(), com.baidu.tieba.o.ds110);
            }
            if (this.aFG == 2) {
                int Is = Is() * 2;
                i2 = ((this.aFY * 2) + Is) - 1;
                i3 = Is;
                i4 = i * 2;
            } else {
                int Is2 = Is();
                i2 = (this.aFY + Is2) - 1;
                i3 = Is2;
                i4 = i;
            }
            if (i4 < i3) {
                i3 = i4;
            }
            if (i4 > i2) {
                if (this.aFG == 2) {
                    i3 += (i4 - i2) * 2;
                } else {
                    i3 += i4 - i2;
                }
            }
            this.aFT.Ij().setSelection(i3);
        }
    }

    public void no() {
        this.aDB.no();
    }

    public void Ix() {
        this.aDB.completePullRefresh();
    }

    public void bL(boolean z) {
        this.aFR.a(this.aFP.getPageContext(), z);
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.u uVar) {
        this.aFR.b(tbPageContext, uVar);
    }

    public void O(List<com.baidu.tieba.enterForum.b.e> list) {
        if (list == null || list.isEmpty()) {
            IB();
            return;
        }
        this.aFS.a(this.aFP.getFragmentActivity(), list, this.aFP.getPageContext());
        if (this.aDB.getFooterViewsCount() < 1) {
            this.aDB.addFooterView(this.aFS.IK(), null, false);
            com.baidu.tbadk.f.a.a(this.aFP.getPageContext(), this.aFS.IK());
        }
    }

    public List<com.baidu.tieba.tbadkCore.ae> Iy() {
        return this.aFW;
    }

    public List<com.baidu.tieba.tbadkCore.ae> Iz() {
        return this.aFT.CM();
    }

    public void eK(int i) {
        this.aFG = i;
    }

    private List<Object> P(List<com.baidu.tieba.tbadkCore.ae> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
            arrayList.add(new com.baidu.tieba.tbadkCore.ae(1));
        }
        return arrayList;
    }

    private com.baidu.tieba.tbadkCore.ae b(int i, List<com.baidu.tieba.tbadkCore.ae> list) {
        com.baidu.tieba.tbadkCore.ae aeVar = new com.baidu.tieba.tbadkCore.ae();
        if (list != null) {
            int size = list.size();
            if (i < size) {
                com.baidu.tieba.tbadkCore.ae aeVar2 = list.get(i);
                aeVar2.setType(0);
                return aeVar2;
            } else if (i == size) {
                aeVar.setType(1);
                return aeVar;
            } else {
                aeVar.setType(2);
                return aeVar;
            }
        }
        return aeVar;
    }

    private List<Object> Q(List<com.baidu.tieba.tbadkCore.ae> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            int i = 0;
            int i2 = 1;
            while (i < size + 1) {
                arrayList.add(new com.baidu.tieba.enterForum.b.a(b(i, list), b(i2, list)));
                i += 2;
                i2 = i + 1;
            }
        }
        return arrayList;
    }

    public void notifyDataSetChanged() {
        this.aFQ.notifyDataSetChanged();
    }

    public void R(List<com.baidu.tieba.tbadkCore.ae> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aFQ.s(new ArrayList());
            return;
        }
        this.aFW = list;
        if (this.aFG == 2) {
            this.aDm.setVisibility(8);
            this.aFQ.s(Q(list));
            return;
        }
        this.aDm.setVisibility(0);
        this.aFQ.s(P(list));
    }

    public void IA() {
        if (this.aFS != null) {
            this.aFS.f(this.aFP.getPageContext());
        }
    }

    public void IB() {
        if (this.aFS != null && this.aFS.IK() != null) {
            this.aDB.removeFooterView(this.aFS.IK());
        }
    }

    public void onResume() {
        NetworkInfo activeNetworkInfo;
        if (this.aFX != null && this.aFX.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.aFP.getFragmentActivity().getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.aFX.at(false);
        }
    }

    public void onStop() {
    }

    public void IC() {
        if (this.aFX != null) {
            this.aFX.at(true);
        }
    }

    public void c(com.baidu.tbadk.core.view.ad adVar) {
        this.aFX.a(adVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.f.a.a(this.aFP.getPageContext(), this.aFP.getView());
        this.aFQ.a(this.aFP.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        if (this.aFX != null) {
            this.aFX.onChangeSkinType(this.aFP.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.mPullView != null) {
            this.mPullView.cy(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.aFS.IK() != null) {
            this.aFS.IK().d(this.aFP.getPageContext());
        }
        if (this.aFR != null) {
            this.aFR.d(this.aFP.getPageContext());
        }
        if (this.aFT.Ij() != null && this.aFT.Ij().getVisibility() == 0) {
            this.aFT.d(this.aFP.getPageContext());
        }
    }

    public void a(aj ajVar) {
        this.mPullView.a(ajVar);
    }
}
