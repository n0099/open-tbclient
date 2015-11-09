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
    private cn aVA;
    private dc aVB;
    private dy aVD;
    private cw aVH;
    private dr aVI;
    private cc aVJ;
    private final HashMap<Integer, com.baidu.tbadk.core.data.w> aVL;
    private BdTypeListView aVo;
    private db aVp;
    private cb aVq;
    private cf aVt;
    private dw aVu;
    private bh aVv;
    private bk aVw;
    private bi aVx;
    private FrsGoodActivity aWx;
    private dh aWy;
    private List<com.baidu.adp.widget.ListView.a> aVK = new LinkedList();
    private boolean aSX = false;
    private boolean aVN = false;
    private boolean akd = false;

    public bq(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsGoodActivity, bdTypeListView);
        this.aVo = bdTypeListView;
        this.aVL = new HashMap<>();
        bX(z);
    }

    public void a(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView) {
        this.aWx = frsGoodActivity;
        this.aVt = new cf(frsGoodActivity, com.baidu.tbadk.core.data.w.Vx);
        this.aVu = new dw(frsGoodActivity, com.baidu.tbadk.core.data.w.Vw);
        this.aVv = new bh(frsGoodActivity, com.baidu.tbadk.core.data.b.TP);
        this.aVw = new bk(frsGoodActivity, com.baidu.tbadk.core.data.b.TQ);
        this.aVx = new bi(frsGoodActivity, com.baidu.tbadk.core.data.b.TR);
        this.aVA = new cn(frsGoodActivity, com.baidu.tieba.tbadkCore.z.cZA);
        this.aVB = new dc(frsGoodActivity, com.baidu.tbadk.core.data.r.Vg);
        this.aVD = new dy(frsGoodActivity, com.baidu.tbadk.core.data.w.Vy);
        this.aVJ = new cc(frsGoodActivity, cd.aXq);
        this.aVI = new dr(frsGoodActivity, com.baidu.tbadk.core.data.w.VA);
        this.aVH = new cw(frsGoodActivity, com.baidu.tbadk.core.data.w.Vz);
        this.aWy = new dh(frsGoodActivity, com.baidu.tbadk.core.data.t.Vs);
        this.aVK.add(this.aVt);
        this.aVK.add(this.aVu);
        this.aVK.add(this.aVv);
        this.aVK.add(this.aVw);
        this.aVK.add(this.aVx);
        this.aVK.add(this.aVA);
        this.aVK.add(this.aVB);
        this.aVK.add(this.aVD);
        this.aVK.add(this.aVJ);
        this.aVK.add(this.aVI);
        this.aVK.add(this.aVH);
        this.aVK.add(this.aWy);
        for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
            if (aVar instanceof bn) {
                ((bn) aVar).d(this.aWx);
            }
        }
        bdTypeListView.h(this.aVK);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
            if (aVar instanceof bn) {
                ((bn) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar, boolean z, boolean z2) {
        a(oVar);
        C(arrayList);
        D(arrayList);
        this.aVo.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(arrayList, oVar, this.aVN, this.akd);
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
                if (this.aVL != null && !this.aVL.containsValue(uVar)) {
                    this.aVL.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.w) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bX(boolean z) {
        if (this.aSX != z) {
            this.aSX = z;
            if (this.aVt != null) {
                this.aVt.bX(z);
            }
        }
    }

    public void cc(boolean z) {
        if (this.aVq != null) {
            this.aVq.cc(z);
        }
    }

    public void cd(boolean z) {
        if (this.aVp != null) {
            this.aVp.cd(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.w> LG() {
        return this.aVL;
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.aVv != null) {
            this.aVv.h(onClickListener);
        }
        if (this.aVw != null) {
            this.aVw.h(onClickListener);
        }
        if (this.aVx != null) {
            this.aVx.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aVv != null) {
            this.aVv.i(onClickListener);
        }
        if (this.aVw != null) {
            this.aVw.i(onClickListener);
        }
        if (this.aVx != null) {
            this.aVx.i(onClickListener);
        }
    }

    public void LH() {
        if (this.aVo != null && this.aVo.getData() != null && this.aVo.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aVo.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.w) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVo.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVo.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aVp != null) {
            this.aVp.onChangeSkinType(i);
        }
        if (this.aVq != null) {
            this.aVq.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aVo.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVo.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bn) {
                    ((bn) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(oVar);
                }
            }
        }
    }

    public void a(bd bdVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(bdVar);
                }
            }
        }
    }

    public int LI() {
        if (this.aVt != null) {
            return this.aVt.LI();
        }
        return 0;
    }

    public int KY() {
        if (this.aVt != null) {
            return this.aVt.KY();
        }
        return 0;
    }

    public int LJ() {
        if (this.aVA != null) {
            return this.aVA.LJ();
        }
        return 0;
    }

    public int LK() {
        if (this.aVt != null) {
            return this.aVt.LK();
        }
        return 0;
    }

    public int LL() {
        if (this.aVA != null) {
            return this.aVA.LL();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bn) {
                    ((bn) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aA(int i) {
        if (this.aVo != null) {
            return this.aVo.aA(i);
        }
        return null;
    }

    private void D(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aVK != null && this.aVK.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.w.Vw.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aVN) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bn) {
                    ((bn) aVar).fC(i);
                }
            }
        }
    }
}
