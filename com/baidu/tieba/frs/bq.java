package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.frsgood.FrsGoodActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class bq {
    private BdTypeListView aUV;
    private db aUW;
    private cb aUX;
    private cf aVa;
    private du aVb;
    private bh aVc;
    private bk aVd;
    private bi aVe;
    private cn aVh;
    private dc aVi;
    private dw aVk;
    private cw aVo;
    private dp aVp;
    private cc aVq;
    private final HashMap<Integer, com.baidu.tbadk.core.data.v> aVs;
    private FrsGoodActivity aWe;
    private dh aWf;
    private List<com.baidu.adp.widget.ListView.a> aVr = new LinkedList();
    private boolean aSE = false;
    private boolean aVu = false;
    private boolean ajX = false;

    public bq(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsGoodActivity, bdTypeListView);
        this.aUV = bdTypeListView;
        this.aVs = new HashMap<>();
        bV(z);
    }

    public void a(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView) {
        this.aWe = frsGoodActivity;
        this.aVa = new cf(frsGoodActivity, com.baidu.tbadk.core.data.v.Vs);
        this.aVb = new du(frsGoodActivity, com.baidu.tbadk.core.data.v.Vr);
        this.aVc = new bh(frsGoodActivity, com.baidu.tbadk.core.data.b.TM);
        this.aVd = new bk(frsGoodActivity, com.baidu.tbadk.core.data.b.TO);
        this.aVe = new bi(frsGoodActivity, com.baidu.tbadk.core.data.b.TP);
        this.aVh = new cn(frsGoodActivity, com.baidu.tieba.tbadkCore.z.cXD);
        this.aVi = new dc(frsGoodActivity, com.baidu.tbadk.core.data.q.Vc);
        this.aVk = new dw(frsGoodActivity, com.baidu.tbadk.core.data.v.Vt);
        this.aVq = new cc(frsGoodActivity, cd.aWW);
        this.aVp = new dp(frsGoodActivity, com.baidu.tbadk.core.data.v.Vv);
        this.aVo = new cw(frsGoodActivity, com.baidu.tbadk.core.data.v.Vu);
        this.aWf = new dh(frsGoodActivity, com.baidu.tbadk.core.data.s.Vo);
        this.aVr.add(this.aVa);
        this.aVr.add(this.aVb);
        this.aVr.add(this.aVc);
        this.aVr.add(this.aVd);
        this.aVr.add(this.aVe);
        this.aVr.add(this.aVh);
        this.aVr.add(this.aVi);
        this.aVr.add(this.aVk);
        this.aVr.add(this.aVq);
        this.aVr.add(this.aVp);
        this.aVr.add(this.aVo);
        this.aVr.add(this.aWf);
        for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
            if (aVar instanceof bn) {
                ((bn) aVar).d(this.aWe);
            }
        }
        bdTypeListView.h(this.aVr);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
            if (aVar instanceof bn) {
                ((bn) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar, boolean z, boolean z2) {
        a(oVar);
        C(arrayList);
        D(arrayList);
        this.aUV.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(arrayList, oVar, this.aVu, this.ajX);
    }

    private ArrayList<Integer> C(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return arrayList2;
            }
            com.baidu.adp.widget.ListView.u uVar = arrayList.get(i2);
            if (uVar instanceof com.baidu.tbadk.core.data.b) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.aVs != null && !this.aVs.containsValue(uVar)) {
                    this.aVs.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.v) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bV(boolean z) {
        if (this.aSE != z) {
            this.aSE = z;
            if (this.aVa != null) {
                this.aVa.bV(z);
            }
        }
    }

    public void ca(boolean z) {
        if (this.aUX != null) {
            this.aUX.ca(z);
        }
    }

    public void cb(boolean z) {
        if (this.aUW != null) {
            this.aUW.cb(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.v> Lu() {
        return this.aVs;
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.aVc != null) {
            this.aVc.h(onClickListener);
        }
        if (this.aVd != null) {
            this.aVd.h(onClickListener);
        }
        if (this.aVe != null) {
            this.aVe.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aVc != null) {
            this.aVc.i(onClickListener);
        }
        if (this.aVd != null) {
            this.aVd.i(onClickListener);
        }
        if (this.aVe != null) {
            this.aVe.i(onClickListener);
        }
    }

    public void Lv() {
        if (this.aUV != null && this.aUV.getData() != null && this.aUV.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aUV.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.v) && ((com.baidu.tbadk.core.data.v) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.v) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aUV.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aUV.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aUW != null) {
            this.aUW.onChangeSkinType(i);
        }
        if (this.aUX != null) {
            this.aUX.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aUV.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aUV.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aVr != null && this.aVr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
                if (aVar instanceof bn) {
                    ((bn) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.aVr != null && this.aVr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(oVar);
                }
            }
        }
    }

    public void a(bd bdVar) {
        if (this.aVr != null && this.aVr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(bdVar);
                }
            }
        }
    }

    public int Lw() {
        if (this.aVa != null) {
            return this.aVa.Lw();
        }
        return 0;
    }

    public int KM() {
        if (this.aVa != null) {
            return this.aVa.KM();
        }
        return 0;
    }

    public int Lx() {
        if (this.aVh != null) {
            return this.aVh.Lx();
        }
        return 0;
    }

    public int Ly() {
        if (this.aVa != null) {
            return this.aVa.Ly();
        }
        return 0;
    }

    public int Lz() {
        if (this.aVh != null) {
            return this.aVh.Lz();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aVr != null && this.aVr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aVr != null && this.aVr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aA(int i) {
        if (this.aUV != null) {
            return this.aUV.aA(i);
        }
        return null;
    }

    private void D(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aVr != null && this.aVr.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.v.Vr.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aVu) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aVr) {
                if (aVar instanceof bn) {
                    ((bn) aVar).fu(i);
                }
            }
        }
    }
}
