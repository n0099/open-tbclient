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
    private BdListView aDC;
    private View aDn;
    private ViewEventCenter aEU;
    private int aFH = 0;
    private final com.baidu.tieba.enterForum.home.a aFQ;
    private com.baidu.tbadk.mvc.j.b<Object, com.baidu.tbadk.mvc.e.c, com.baidu.tbadk.mvc.j.a<Object, com.baidu.tbadk.mvc.e.c>> aFR;
    private q aFS;
    private ag aFT;
    private com.baidu.tieba.enterForum.c.i aFU;
    private ViewGroup aFV;
    private boolean aFW;
    private List<com.baidu.tieba.tbadkCore.ae> aFX;
    private NoNetworkView aFY;
    private int aFZ;
    private al mPullView;

    public e(com.baidu.tieba.enterForum.home.a aVar, ViewEventCenter viewEventCenter) {
        this.aFQ = aVar;
        this.aEU = viewEventCenter;
        this.aFT = new ag(viewEventCenter);
        this.aFU = new com.baidu.tieba.enterForum.c.i(aVar.getPageContext(), viewEventCenter);
        v(this.aFQ.getView());
        Ir();
        this.aDC.setAdapter((ListAdapter) this.aFR);
    }

    private void v(View view) {
        this.aFY = (NoNetworkView) view.findViewById(com.baidu.tieba.q.view_no_network);
        this.aFV = (ViewGroup) view.findViewById(com.baidu.tieba.q.container);
        this.aDC = (BdListView) view.findViewById(com.baidu.tieba.q.listview);
        this.mPullView = new al(this.aFQ.getPageContext());
        this.mPullView.setTag(this.aFQ.getUniqueId());
        this.aDC.setPullRefresh(this.mPullView);
        this.aFS = new q(this.aFQ.getFragmentActivity());
        this.aFS.setEventCenter(this.aEU);
        this.aDn = this.aFS.findViewById(com.baidu.tieba.q.divider_line);
        this.aDC.addHeaderView(this.aFS);
    }

    public int Im() {
        return this.aFH;
    }

    public int Iq() {
        return this.aFU.Im();
    }

    private void Ir() {
        this.aFR = new f(this, this.aFQ.getPageContext(), new Class[]{y.class, v.class, n.class}, new int[]{com.baidu.tieba.r.home_like_item_with_portrait, com.baidu.tieba.r.home_like_item_extra_with_text, com.baidu.tieba.r.home_like_two_column_item}, this.aEU);
        this.aFR.bi(false);
    }

    public void b(com.baidu.tieba.tbadkCore.ae aeVar) {
        this.aFU.b(aeVar);
    }

    public void N(List<com.baidu.tieba.tbadkCore.ae> list) {
        this.aFU.M(list);
    }

    public List<com.baidu.tieba.tbadkCore.ae> Is() {
        return this.aFU.CN();
    }

    public int It() {
        return this.aDC.getFirstVisiblePosition() - this.aDC.getHeaderViewsCount();
    }

    public void Iu() {
        this.aFU.In();
    }

    public boolean Iv() {
        return this.aFW;
    }

    public void Iw() {
        this.aFH = this.aFU.Im();
        R(this.aFU.CN());
    }

    public void eI(int i) {
        this.aFW = true;
        if (this.aFU.Ik() == null) {
            this.aFU.Il();
        }
        i Ik = this.aFU.Ik();
        Ik.d(this.aFQ.getPageContext());
        if (Ik.getParent() == null) {
            this.aFV.addView(Ik, new FrameLayout.LayoutParams(-1, -1));
        }
        this.aFU.a(this.aFH, this.aFX);
        com.baidu.adp.lib.g.i.hs().post(new g(this, i));
    }

    public void Ix() {
        this.aFW = false;
        this.aDC.setVisibility(0);
        if (this.aFU.Ik() != null) {
            this.aFV.removeView(this.aFU.Ik());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(int i) {
        int i2;
        int i3;
        int i4;
        if (this.aFU.Ik() != null) {
            if (this.aFZ == 0) {
                this.aFZ = (this.aDC.getHeight() - com.baidu.adp.lib.util.n.d(TbadkCoreApplication.m411getInst(), com.baidu.tieba.o.ds100)) / com.baidu.adp.lib.util.n.d(TbadkCoreApplication.m411getInst(), com.baidu.tieba.o.ds110);
            }
            if (this.aFH == 2) {
                int It = It() * 2;
                i2 = ((this.aFZ * 2) + It) - 1;
                i3 = It;
                i4 = i * 2;
            } else {
                int It2 = It();
                i2 = (this.aFZ + It2) - 1;
                i3 = It2;
                i4 = i;
            }
            if (i4 < i3) {
                i3 = i4;
            }
            if (i4 > i2) {
                if (this.aFH == 2) {
                    i3 += (i4 - i2) * 2;
                } else {
                    i3 += i4 - i2;
                }
            }
            this.aFU.Ik().setSelection(i3);
        }
    }

    public void no() {
        this.aDC.no();
    }

    public void Iy() {
        this.aDC.completePullRefresh();
    }

    public void bL(boolean z) {
        this.aFS.a(this.aFQ.getPageContext(), z);
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.u uVar) {
        this.aFS.b(tbPageContext, uVar);
    }

    public void O(List<com.baidu.tieba.enterForum.b.e> list) {
        if (list == null || list.isEmpty()) {
            IC();
            return;
        }
        this.aFT.a(this.aFQ.getFragmentActivity(), list, this.aFQ.getPageContext());
        if (this.aDC.getFooterViewsCount() < 1) {
            this.aDC.addFooterView(this.aFT.IL(), null, false);
            com.baidu.tbadk.f.a.a(this.aFQ.getPageContext(), this.aFT.IL());
        }
    }

    public List<com.baidu.tieba.tbadkCore.ae> Iz() {
        return this.aFX;
    }

    public List<com.baidu.tieba.tbadkCore.ae> IA() {
        return this.aFU.CN();
    }

    public void eK(int i) {
        this.aFH = i;
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
        this.aFR.notifyDataSetChanged();
    }

    public void R(List<com.baidu.tieba.tbadkCore.ae> list) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aFR.s(new ArrayList());
            return;
        }
        this.aFX = list;
        if (this.aFH == 2) {
            this.aDn.setVisibility(8);
            this.aFR.s(Q(list));
            return;
        }
        this.aDn.setVisibility(0);
        this.aFR.s(P(list));
    }

    public void IB() {
        if (this.aFT != null) {
            this.aFT.f(this.aFQ.getPageContext());
        }
    }

    public void IC() {
        if (this.aFT != null && this.aFT.IL() != null) {
            this.aDC.removeFooterView(this.aFT.IL());
        }
    }

    public void onResume() {
        NetworkInfo activeNetworkInfo;
        if (this.aFY != null && this.aFY.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.aFQ.getFragmentActivity().getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.aFY.at(false);
        }
    }

    public void onStop() {
    }

    public void ID() {
        if (this.aFY != null) {
            this.aFY.at(true);
        }
    }

    public void c(com.baidu.tbadk.core.view.ad adVar) {
        this.aFY.a(adVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.f.a.a(this.aFQ.getPageContext(), this.aFQ.getView());
        this.aFR.a(this.aFQ.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        if (this.aFY != null) {
            this.aFY.onChangeSkinType(this.aFQ.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.mPullView != null) {
            this.mPullView.cy(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.aFT.IL() != null) {
            this.aFT.IL().d(this.aFQ.getPageContext());
        }
        if (this.aFS != null) {
            this.aFS.d(this.aFQ.getPageContext());
        }
        if (this.aFU.Ik() != null && this.aFU.Ik().getVisibility() == 0) {
            this.aFU.d(this.aFQ.getPageContext());
        }
    }

    public void a(aj ajVar) {
        this.mPullView.a(ajVar);
    }
}
