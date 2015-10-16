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
    private dp aVA;
    private cc aVB;
    private final HashMap<Integer, com.baidu.tbadk.core.data.w> aVD;
    private BdTypeListView aVg;
    private db aVh;
    private cb aVi;
    private cf aVl;
    private du aVm;
    private bh aVn;
    private bk aVo;
    private bi aVp;
    private cn aVs;
    private dc aVt;
    private dw aVv;
    private cw aVz;
    private FrsGoodActivity aWp;
    private dh aWq;
    private List<com.baidu.adp.widget.ListView.a> aVC = new LinkedList();
    private boolean aSP = false;
    private boolean aVF = false;
    private boolean ajY = false;

    public bq(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsGoodActivity, bdTypeListView);
        this.aVg = bdTypeListView;
        this.aVD = new HashMap<>();
        bV(z);
    }

    public void a(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView) {
        this.aWp = frsGoodActivity;
        this.aVl = new cf(frsGoodActivity, com.baidu.tbadk.core.data.w.Vu);
        this.aVm = new du(frsGoodActivity, com.baidu.tbadk.core.data.w.Vt);
        this.aVn = new bh(frsGoodActivity, com.baidu.tbadk.core.data.b.TO);
        this.aVo = new bk(frsGoodActivity, com.baidu.tbadk.core.data.b.TP);
        this.aVp = new bi(frsGoodActivity, com.baidu.tbadk.core.data.b.TQ);
        this.aVs = new cn(frsGoodActivity, com.baidu.tieba.tbadkCore.z.cYd);
        this.aVt = new dc(frsGoodActivity, com.baidu.tbadk.core.data.r.Ve);
        this.aVv = new dw(frsGoodActivity, com.baidu.tbadk.core.data.w.Vv);
        this.aVB = new cc(frsGoodActivity, cd.aXh);
        this.aVA = new dp(frsGoodActivity, com.baidu.tbadk.core.data.w.Vx);
        this.aVz = new cw(frsGoodActivity, com.baidu.tbadk.core.data.w.Vw);
        this.aWq = new dh(frsGoodActivity, com.baidu.tbadk.core.data.t.Vq);
        this.aVC.add(this.aVl);
        this.aVC.add(this.aVm);
        this.aVC.add(this.aVn);
        this.aVC.add(this.aVo);
        this.aVC.add(this.aVp);
        this.aVC.add(this.aVs);
        this.aVC.add(this.aVt);
        this.aVC.add(this.aVv);
        this.aVC.add(this.aVB);
        this.aVC.add(this.aVA);
        this.aVC.add(this.aVz);
        this.aVC.add(this.aWq);
        for (com.baidu.adp.widget.ListView.a aVar : this.aVC) {
            if (aVar instanceof bn) {
                ((bn) aVar).d(this.aWp);
            }
        }
        bdTypeListView.h(this.aVC);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aVC) {
            if (aVar instanceof bn) {
                ((bn) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar, boolean z, boolean z2) {
        a(oVar);
        C(arrayList);
        D(arrayList);
        this.aVg.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(arrayList, oVar, this.aVF, this.ajY);
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
                if (this.aVD != null && !this.aVD.containsValue(uVar)) {
                    this.aVD.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.w) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bV(boolean z) {
        if (this.aSP != z) {
            this.aSP = z;
            if (this.aVl != null) {
                this.aVl.bV(z);
            }
        }
    }

    public void ca(boolean z) {
        if (this.aVi != null) {
            this.aVi.ca(z);
        }
    }

    public void cb(boolean z) {
        if (this.aVh != null) {
            this.aVh.cb(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.w> Lu() {
        return this.aVD;
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.aVn != null) {
            this.aVn.h(onClickListener);
        }
        if (this.aVo != null) {
            this.aVo.h(onClickListener);
        }
        if (this.aVp != null) {
            this.aVp.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aVn != null) {
            this.aVn.i(onClickListener);
        }
        if (this.aVo != null) {
            this.aVo.i(onClickListener);
        }
        if (this.aVp != null) {
            this.aVp.i(onClickListener);
        }
    }

    public void Lv() {
        if (this.aVg != null && this.aVg.getData() != null && this.aVg.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aVg.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.w) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVg.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVg.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aVh != null) {
            this.aVh.onChangeSkinType(i);
        }
        if (this.aVi != null) {
            this.aVi.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aVg.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVg.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aVC != null && this.aVC.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVC) {
                if (aVar instanceof bn) {
                    ((bn) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.aVC != null && this.aVC.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVC) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(oVar);
                }
            }
        }
    }

    public void a(bd bdVar) {
        if (this.aVC != null && this.aVC.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVC) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(bdVar);
                }
            }
        }
    }

    public int Lw() {
        if (this.aVl != null) {
            return this.aVl.Lw();
        }
        return 0;
    }

    public int KM() {
        if (this.aVl != null) {
            return this.aVl.KM();
        }
        return 0;
    }

    public int Lx() {
        if (this.aVs != null) {
            return this.aVs.Lx();
        }
        return 0;
    }

    public int Ly() {
        if (this.aVl != null) {
            return this.aVl.Ly();
        }
        return 0;
    }

    public int Lz() {
        if (this.aVs != null) {
            return this.aVs.Lz();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aVC != null && this.aVC.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVC) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aVC != null && this.aVC.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVC) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aA(int i) {
        if (this.aVg != null) {
            return this.aVg.aA(i);
        }
        return null;
    }

    private void D(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aVC != null && this.aVC.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.w.Vt.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aVF) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aVC) {
                if (aVar instanceof bn) {
                    ((bn) aVar).fu(i);
                }
            }
        }
    }
}
