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
public class cb {
    private BdTypeListView aRs;
    private dr baD;
    private cr baE;
    private cv baH;
    private en baJ;
    private bg baK;
    private bj baL;
    private bh baM;
    private dd baP;
    private ds baQ;
    private ep baS;
    private dm baX;
    private eh baY;
    private cs baZ;
    private final HashMap<Integer, com.baidu.tbadk.core.data.z> bba;
    private FrsGoodActivity bcs;
    private dx bct;
    private List<com.baidu.adp.widget.ListView.a> aRI = new LinkedList();
    private boolean aYl = false;
    private boolean bbc = false;
    private boolean alO = false;

    public cb(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsGoodActivity, bdTypeListView);
        this.aRs = bdTypeListView;
        this.bba = new HashMap<>();
        ck(z);
    }

    public void a(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView) {
        this.bcs = frsGoodActivity;
        this.baH = new cv(frsGoodActivity, com.baidu.tbadk.core.data.z.Wc);
        this.baJ = new en(frsGoodActivity, com.baidu.tbadk.core.data.z.Wb);
        this.baK = new bg(frsGoodActivity, com.baidu.tbadk.core.data.b.Uf);
        this.baL = new bj(frsGoodActivity, com.baidu.tbadk.core.data.b.Ug);
        this.baM = new bh(frsGoodActivity, com.baidu.tbadk.core.data.b.Uh);
        this.baP = new dd(frsGoodActivity, com.baidu.tieba.tbadkCore.aa.dyo);
        this.baQ = new ds(frsGoodActivity, com.baidu.tbadk.core.data.u.VL);
        this.baS = new ep(frsGoodActivity, com.baidu.tbadk.core.data.z.Wd);
        this.baZ = new cs(frsGoodActivity, ct.bdo);
        this.baY = new eh(frsGoodActivity, com.baidu.tbadk.core.data.z.Wf);
        this.baX = new dm(frsGoodActivity, com.baidu.tbadk.core.data.z.We);
        this.bct = new dx(frsGoodActivity, com.baidu.tbadk.core.data.w.VX);
        this.aRI.add(this.baH);
        this.aRI.add(this.baJ);
        this.aRI.add(this.baK);
        this.aRI.add(this.baL);
        this.aRI.add(this.baM);
        this.aRI.add(this.baP);
        this.aRI.add(this.baQ);
        this.aRI.add(this.baS);
        this.aRI.add(this.baZ);
        this.aRI.add(this.baY);
        this.aRI.add(this.baX);
        this.aRI.add(this.bct);
        for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
            if (aVar instanceof bm) {
                ((bm) aVar).c(this.bcs);
            }
        }
        bdTypeListView.g(this.aRI);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
            if (aVar instanceof bm) {
                ((bm) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.p pVar, boolean z, boolean z2) {
        a(pVar);
        F(arrayList);
        G(arrayList);
        this.aRs.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.p pVar) {
        a(arrayList, pVar, this.bbc, this.alO);
    }

    private ArrayList<Integer> F(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
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
                if (this.bba != null && !this.bba.containsValue(uVar)) {
                    this.bba.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.z) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void ck(boolean z) {
        if (this.aYl != z) {
            this.aYl = z;
            if (this.baH != null) {
                this.baH.ck(z);
            }
        }
    }

    public void cp(boolean z) {
        if (this.baE != null) {
            this.baE.cp(z);
        }
    }

    public void cq(boolean z) {
        if (this.baD != null) {
            this.baD.cq(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.z> Ne() {
        return this.bba;
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.baK != null) {
            this.baK.h(onClickListener);
        }
        if (this.baL != null) {
            this.baL.h(onClickListener);
        }
        if (this.baM != null) {
            this.baM.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.baK != null) {
            this.baK.i(onClickListener);
        }
        if (this.baL != null) {
            this.baL.i(onClickListener);
        }
        if (this.baM != null) {
            this.baM.i(onClickListener);
        }
    }

    public void Nf() {
        if (this.aRs != null && this.aRs.getData() != null && this.aRs.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.aRs.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.z) && ((com.baidu.tbadk.core.data.z) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.z) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aRs.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aRs.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.baD != null) {
            this.baD.onChangeSkinType(i);
        }
        if (this.baE != null) {
            this.baE.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aRs.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aRs.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(pVar);
                }
            }
        }
    }

    public void a(bc bcVar) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(bcVar);
                }
            }
        }
    }

    public int Ng() {
        if (this.baH != null) {
            return this.baH.Ng();
        }
        return 0;
    }

    public int Mx() {
        if (this.baH != null) {
            return this.baH.Mx();
        }
        return 0;
    }

    public int Nh() {
        if (this.baP != null) {
            return this.baP.Nh();
        }
        return 0;
    }

    public int Ni() {
        if (this.baH != null) {
            return this.baH.Ni();
        }
        return 0;
    }

    public int Nj() {
        if (this.baP != null) {
            return this.baP.Nj();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aB(int i) {
        if (this.aRs != null) {
            return this.aRs.aB(i);
        }
        return null;
    }

    private void G(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.aRI != null && this.aRI.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.z.Wb.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.bbc) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).fY(i);
                }
            }
        }
    }
}
