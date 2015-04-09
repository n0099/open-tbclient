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
import com.baidu.tbadk.core.view.ag;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private BdListView aBF;
    private ViewEventCenter aCS;
    private int aDE = 0;
    private final com.baidu.tieba.enterForum.home.a aDN;
    private View aDO;
    private com.baidu.tbadk.mvc.j.b<Object, com.baidu.tbadk.mvc.e.c, com.baidu.tbadk.mvc.j.a<Object, com.baidu.tbadk.mvc.e.c>> aDP;
    private q aDQ;
    private af aDR;
    private com.baidu.tieba.enterForum.c.i aDS;
    private ViewGroup aDT;
    private boolean aDU;
    private List<com.baidu.tieba.tbadkCore.ae> aDV;
    private NoNetworkView aDW;
    private ag mPullView;

    public e(com.baidu.tieba.enterForum.home.a aVar, ViewEventCenter viewEventCenter) {
        this.aDN = aVar;
        this.aCS = viewEventCenter;
        this.aDR = new af(viewEventCenter);
        this.aDS = new com.baidu.tieba.enterForum.c.i(aVar.getPageContext(), viewEventCenter);
        s(this.aDN.getView());
        Hq();
        this.aBF.setAdapter((ListAdapter) this.aDP);
    }

    private void s(View view) {
        this.aDW = (NoNetworkView) view.findViewById(com.baidu.tieba.v.view_no_network);
        this.aDT = (ViewGroup) view.findViewById(com.baidu.tieba.v.container);
        this.aBF = (BdListView) view.findViewById(com.baidu.tieba.v.listview);
        this.mPullView = new ag(this.aDN.getPageContext());
        this.aBF.setPullRefresh(this.mPullView);
        this.aDQ = new q(this.aDN.getFragmentActivity());
        this.aDQ.setEventCenter(this.aCS);
        this.aDO = this.aDQ.findViewById(com.baidu.tieba.v.divider_line);
        this.aBF.addHeaderView(this.aDQ);
    }

    public int Hl() {
        return this.aDE;
    }

    public int Hp() {
        return this.aDS.Hl();
    }

    private void Hq() {
        this.aDP = new f(this, this.aDN.getPageContext(), new Class[]{y.class, v.class, n.class}, new int[]{com.baidu.tieba.w.home_like_item_with_portrait, com.baidu.tieba.w.home_like_item_extra_with_text, com.baidu.tieba.w.home_like_two_column_item}, this.aCS);
        this.aDP.bb(false);
    }

    public void b(com.baidu.tieba.tbadkCore.ae aeVar) {
        this.aDS.b(aeVar);
    }

    public void K(List<com.baidu.tieba.tbadkCore.ae> list) {
        this.aDS.J(list);
    }

    public List<com.baidu.tieba.tbadkCore.ae> Hr() {
        return this.aDS.Ca();
    }

    public int Hs() {
        return this.aBF.getFirstVisiblePosition() - this.aBF.getHeaderViewsCount();
    }

    public void Ht() {
        this.aDS.Hm();
    }

    public boolean Hu() {
        return this.aDU;
    }

    public void Hv() {
        this.aDE = this.aDS.Hl();
        O(this.aDS.Ca());
    }

    public void bB(boolean z) {
        this.aDU = z;
        if (z) {
            if (this.aDS.Hj() == null) {
                this.aDS.Hk();
            }
            i Hj = this.aDS.Hj();
            Hj.f(this.aDN.getPageContext());
            if (Hj.getParent() == null) {
                this.aDT.addView(Hj, new FrameLayout.LayoutParams(-1, -1));
            }
            this.aDS.a(this.aDE, this.aDV);
            com.baidu.adp.lib.g.i.hI().post(new g(this));
            return;
        }
        this.aBF.setVisibility(0);
        if (this.aDS.Hj() != null) {
            this.aDT.removeView(this.aDS.Hj());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hw() {
        int Hs;
        if (this.aDS.Hj() != null) {
            if (this.aDE == 2) {
                Hs = Hs() * 2;
            } else {
                Hs = Hs();
            }
            this.aDS.Hj().setSelection(Hs);
        }
    }

    public void mX() {
        this.aBF.mX();
    }

    public void Hx() {
        this.aBF.mW();
    }

    public void bC(boolean z) {
        this.aDQ.a(this.aDN.getPageContext(), z);
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.u uVar) {
        this.aDQ.b(tbPageContext, uVar);
    }

    public void L(List<com.baidu.tieba.enterForum.b.d> list) {
        if (list == null || list.isEmpty()) {
            HB();
            return;
        }
        this.aDR.b(this.aDN.getFragmentActivity(), list);
        if (this.aBF.getFooterViewsCount() < 1) {
            this.aBF.addFooterView(this.aDR.HK());
            com.baidu.tbadk.f.a.a(this.aDN.getPageContext(), this.aDR.HK());
        }
    }

    public List<com.baidu.tieba.tbadkCore.ae> Hy() {
        return this.aDV;
    }

    public List<com.baidu.tieba.tbadkCore.ae> Hz() {
        return this.aDS.Ca();
    }

    public void ew(int i) {
        this.aDE = i;
    }

    private List<Object> M(List<com.baidu.tieba.tbadkCore.ae> list) {
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

    private List<Object> N(List<com.baidu.tieba.tbadkCore.ae> list) {
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
        this.aDP.notifyDataSetChanged();
    }

    public void O(List<com.baidu.tieba.tbadkCore.ae> list) {
        this.aDV = list;
        if (this.aDE == 2) {
            this.aDO.setVisibility(8);
            this.aDP.r(N(list));
            return;
        }
        this.aDO.setVisibility(0);
        this.aDP.r(M(list));
    }

    public void HA() {
        if (this.aDR != null) {
            this.aDR.HI();
        }
    }

    public void HB() {
        if (this.aDR != null && this.aDR.HK() != null) {
            this.aBF.removeFooterView(this.aDR.HK());
        }
    }

    public void onResume() {
        NetworkInfo activeNetworkInfo;
        if (this.aDW != null && this.aDW.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.aDN.getFragmentActivity().getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.aDW.am(false);
        }
    }

    public void onStop() {
    }

    public void HC() {
        if (this.aDW != null) {
            this.aDW.am(true);
        }
    }

    public void c(com.baidu.tbadk.core.view.y yVar) {
        this.aDW.a(yVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.f.a.a(this.aDN.getPageContext(), this.aDN.getView());
        this.aDP.a(this.aDN.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        if (this.aDW != null) {
            this.aDW.onChangeSkinType(this.aDN.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.mPullView != null) {
            this.mPullView.ct(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.aDR.HK() != null) {
            this.aDR.HK().f(this.aDN.getPageContext());
        }
        if (this.aDQ != null) {
            this.aDQ.f(this.aDN.getPageContext());
        }
        if (this.aDS.Hj() != null && this.aDS.Hj().getVisibility() == 0) {
            this.aDS.f(this.aDN.getPageContext());
        }
    }

    public void a(com.baidu.tbadk.core.view.ae aeVar) {
        this.mPullView.a(aeVar);
    }
}
