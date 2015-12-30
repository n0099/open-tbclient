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
public class ce {
    private BdTypeListView aVi;
    private dr beC;
    private cu beD;
    private cy beG;
    private en beI;
    private bj beJ;
    private bm beK;
    private bk beL;
    private dg beO;
    private ds beP;
    private ep beR;
    private dm beW;
    private eh beX;
    private cv beY;
    private final HashMap<Integer, com.baidu.tbadk.core.data.z> beZ;
    private FrsGoodActivity bgr;
    private dx bgt;
    private List<com.baidu.adp.widget.ListView.a> aVK = new LinkedList();
    private boolean bck = false;
    private boolean bfb = false;
    private boolean amU = false;

    public ce(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsGoodActivity, bdTypeListView);
        this.aVi = bdTypeListView;
        this.beZ = new HashMap<>();
        cl(z);
    }

    public void a(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView) {
        this.bgr = frsGoodActivity;
        this.beG = new cy(frsGoodActivity, com.baidu.tbadk.core.data.z.WC);
        this.beI = new en(frsGoodActivity, com.baidu.tbadk.core.data.z.WB);
        this.beJ = new bj(frsGoodActivity, com.baidu.tbadk.core.data.b.UF);
        this.beK = new bm(frsGoodActivity, com.baidu.tbadk.core.data.b.UG);
        this.beL = new bk(frsGoodActivity, com.baidu.tbadk.core.data.b.UH);
        this.beO = new dg(frsGoodActivity, com.baidu.tieba.tbadkCore.aa.dFI);
        this.beP = new ds(frsGoodActivity, com.baidu.tbadk.core.data.u.Wl);
        this.beR = new ep(frsGoodActivity, com.baidu.tbadk.core.data.z.WD);
        this.beY = new cv(frsGoodActivity, cw.bho);
        this.beX = new eh(frsGoodActivity, com.baidu.tbadk.core.data.z.WF);
        this.beW = new dm(frsGoodActivity, com.baidu.tbadk.core.data.z.WE);
        this.bgt = new dx(frsGoodActivity, com.baidu.tbadk.core.data.w.Wx);
        this.aVK.add(this.beG);
        this.aVK.add(this.beI);
        this.aVK.add(this.beJ);
        this.aVK.add(this.beK);
        this.aVK.add(this.beL);
        this.aVK.add(this.beO);
        this.aVK.add(this.beP);
        this.aVK.add(this.beR);
        this.aVK.add(this.beY);
        this.aVK.add(this.beX);
        this.aVK.add(this.beW);
        this.aVK.add(this.bgt);
        for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
            if (aVar instanceof bp) {
                ((bp) aVar).e(this.bgr);
            }
        }
        bdTypeListView.g(this.aVK);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
            if (aVar instanceof bp) {
                ((bp) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.p pVar, boolean z, boolean z2) {
        a(pVar);
        D(arrayList);
        E(arrayList);
        this.aVi.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.p pVar) {
        a(arrayList, pVar, this.bfb, this.amU);
    }

    private ArrayList<Integer> D(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
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
                if (this.beZ != null && !this.beZ.containsValue(uVar)) {
                    this.beZ.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.z) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void cl(boolean z) {
        if (this.bck != z) {
            this.bck = z;
            if (this.beG != null) {
                this.beG.cl(z);
            }
        }
    }

    public void cq(boolean z) {
        if (this.beD != null) {
            this.beD.cq(z);
        }
    }

    public void cr(boolean z) {
        if (this.beC != null) {
            this.beC.cr(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.z> Nx() {
        return this.beZ;
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.beJ != null) {
            this.beJ.h(onClickListener);
        }
        if (this.beK != null) {
            this.beK.h(onClickListener);
        }
        if (this.beL != null) {
            this.beL.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.beJ != null) {
            this.beJ.i(onClickListener);
        }
        if (this.beK != null) {
            this.beK.i(onClickListener);
        }
        if (this.beL != null) {
            this.beL.i(onClickListener);
        }
    }

    public void Ny() {
        if (this.aVi != null && this.aVi.getData() != null && this.aVi.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aVi.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.z) && ((com.baidu.tbadk.core.data.z) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.z) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVi.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVi.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.beC != null) {
            this.beC.onChangeSkinType(i);
        }
        if (this.beD != null) {
            this.beD.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aVi.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVi.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).a(pVar);
                }
            }
        }
    }

    public void a(bf bfVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).a(bfVar);
                }
            }
        }
    }

    public int Nz() {
        if (this.beG != null) {
            return this.beG.Nz();
        }
        return 0;
    }

    public int MQ() {
        if (this.beG != null) {
            return this.beG.MQ();
        }
        return 0;
    }

    public int NA() {
        if (this.beO != null) {
            return this.beO.NA();
        }
        return 0;
    }

    public int NB() {
        if (this.beG != null) {
            return this.beG.NB();
        }
        return 0;
    }

    public int NC() {
        if (this.beO != null) {
            return this.beO.NC();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u au(int i) {
        if (this.aVi != null) {
            return this.aVi.au(i);
        }
        return null;
    }

    private void E(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aVK != null && this.aVK.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.z.WB.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.bfb) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).fT(i);
                }
            }
        }
    }
}
