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
    private BdListView aBx;
    private ViewEventCenter aCK;
    private final com.baidu.tieba.enterForum.home.a aDF;
    private View aDG;
    private com.baidu.tbadk.mvc.j.b<Object, com.baidu.tbadk.mvc.e.c, com.baidu.tbadk.mvc.j.a<Object, com.baidu.tbadk.mvc.e.c>> aDH;
    private q aDI;
    private af aDJ;
    private com.baidu.tieba.enterForum.c.i aDK;
    private ViewGroup aDL;
    private boolean aDM;
    private List<com.baidu.tieba.tbadkCore.ae> aDN;
    private NoNetworkView aDO;
    private int aDw = 0;
    private ag mPullView;

    public e(com.baidu.tieba.enterForum.home.a aVar, ViewEventCenter viewEventCenter) {
        this.aDF = aVar;
        this.aCK = viewEventCenter;
        this.aDJ = new af(viewEventCenter);
        this.aDK = new com.baidu.tieba.enterForum.c.i(aVar.getPageContext(), viewEventCenter);
        s(this.aDF.getView());
        Hk();
        this.aBx.setAdapter((ListAdapter) this.aDH);
    }

    private void s(View view) {
        this.aDO = (NoNetworkView) view.findViewById(com.baidu.tieba.v.view_no_network);
        this.aDL = (ViewGroup) view.findViewById(com.baidu.tieba.v.container);
        this.aBx = (BdListView) view.findViewById(com.baidu.tieba.v.listview);
        this.mPullView = new ag(this.aDF.getPageContext());
        this.aBx.setPullRefresh(this.mPullView);
        this.aDI = new q(this.aDF.getFragmentActivity());
        this.aDI.setEventCenter(this.aCK);
        this.aDG = this.aDI.findViewById(com.baidu.tieba.v.divider_line);
        this.aBx.addHeaderView(this.aDI);
    }

    public int Hf() {
        return this.aDw;
    }

    public int Hj() {
        return this.aDK.Hf();
    }

    private void Hk() {
        this.aDH = new f(this, this.aDF.getPageContext(), new Class[]{y.class, v.class, n.class}, new int[]{com.baidu.tieba.w.home_like_item_with_portrait, com.baidu.tieba.w.home_like_item_extra_with_text, com.baidu.tieba.w.home_like_two_column_item}, this.aCK);
        this.aDH.bb(false);
    }

    public void b(com.baidu.tieba.tbadkCore.ae aeVar) {
        this.aDK.b(aeVar);
    }

    public void K(List<com.baidu.tieba.tbadkCore.ae> list) {
        this.aDK.J(list);
    }

    public List<com.baidu.tieba.tbadkCore.ae> Hl() {
        return this.aDK.BU();
    }

    public int Hm() {
        return this.aBx.getFirstVisiblePosition() - this.aBx.getHeaderViewsCount();
    }

    public void Hn() {
        this.aDK.Hg();
    }

    public boolean Ho() {
        return this.aDM;
    }

    public void Hp() {
        this.aDw = this.aDK.Hf();
        O(this.aDK.BU());
    }

    public void bB(boolean z) {
        this.aDM = z;
        if (z) {
            if (this.aDK.Hd() == null) {
                this.aDK.He();
            }
            i Hd = this.aDK.Hd();
            Hd.f(this.aDF.getPageContext());
            if (Hd.getParent() == null) {
                this.aDL.addView(Hd, new FrameLayout.LayoutParams(-1, -1));
            }
            this.aDK.a(this.aDw, this.aDN);
            com.baidu.adp.lib.g.i.hI().post(new g(this));
            return;
        }
        this.aBx.setVisibility(0);
        if (this.aDK.Hd() != null) {
            this.aDL.removeView(this.aDK.Hd());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hq() {
        int Hm;
        if (this.aDK.Hd() != null) {
            if (this.aDw == 2) {
                Hm = Hm() * 2;
            } else {
                Hm = Hm();
            }
            this.aDK.Hd().setSelection(Hm);
        }
    }

    public void mX() {
        this.aBx.mX();
    }

    public void Hr() {
        this.aBx.mW();
    }

    public void bC(boolean z) {
        this.aDI.a(this.aDF.getPageContext(), z);
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.core.data.u uVar) {
        this.aDI.b(tbPageContext, uVar);
    }

    public void L(List<com.baidu.tieba.enterForum.b.d> list) {
        if (list == null || list.isEmpty()) {
            Hv();
            return;
        }
        this.aDJ.b(this.aDF.getFragmentActivity(), list);
        if (this.aBx.getFooterViewsCount() < 1) {
            this.aBx.addFooterView(this.aDJ.HE());
            com.baidu.tbadk.f.a.a(this.aDF.getPageContext(), this.aDJ.HE());
        }
    }

    public List<com.baidu.tieba.tbadkCore.ae> Hs() {
        return this.aDN;
    }

    public List<com.baidu.tieba.tbadkCore.ae> Ht() {
        return this.aDK.BU();
    }

    public void ew(int i) {
        this.aDw = i;
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
        this.aDH.notifyDataSetChanged();
    }

    public void O(List<com.baidu.tieba.tbadkCore.ae> list) {
        this.aDN = list;
        if (this.aDw == 2) {
            this.aDG.setVisibility(8);
            this.aDH.r(N(list));
            return;
        }
        this.aDG.setVisibility(0);
        this.aDH.r(M(list));
    }

    public void Hu() {
        if (this.aDJ != null) {
            this.aDJ.HC();
        }
    }

    public void Hv() {
        if (this.aDJ != null && this.aDJ.HE() != null) {
            this.aBx.removeFooterView(this.aDJ.HE());
        }
    }

    public void onResume() {
        NetworkInfo activeNetworkInfo;
        if (this.aDO != null && this.aDO.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.aDF.getFragmentActivity().getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.aDO.am(false);
        }
    }

    public void onStop() {
    }

    public void Hw() {
        if (this.aDO != null) {
            this.aDO.am(true);
        }
    }

    public void c(com.baidu.tbadk.core.view.y yVar) {
        this.aDO.a(yVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.f.a.a(this.aDF.getPageContext(), this.aDF.getView());
        this.aDH.a(this.aDF.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        if (this.aDO != null) {
            this.aDO.onChangeSkinType(this.aDF.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.mPullView != null) {
            this.mPullView.ct(TbadkCoreApplication.m411getInst().getSkinType());
        }
        if (this.aDJ.HE() != null) {
            this.aDJ.HE().f(this.aDF.getPageContext());
        }
        if (this.aDI != null) {
            this.aDI.f(this.aDF.getPageContext());
        }
        if (this.aDK.Hd() != null && this.aDK.Hd().getVisibility() == 0) {
            this.aDK.f(this.aDF.getPageContext());
        }
    }

    public void a(com.baidu.tbadk.core.view.ae aeVar) {
        this.mPullView.a(aeVar);
    }
}
