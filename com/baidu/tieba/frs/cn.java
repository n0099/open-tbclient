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
public class cn {
    private BdTypeListView bcd;
    private ed blI;
    private dg blJ;
    private dk blM;
    private fh blP;
    private bn blQ;
    private bs blR;
    private bp blS;
    private dr blV;
    private ee blW;
    private fj blY;
    private em bmd;
    private dx bmf;
    private fa bmg;
    private dh bmh;
    private final HashMap<Integer, com.baidu.tbadk.core.data.as> bmi;
    private FrsGoodActivity bnM;
    private ej bnN;
    private cq bnO;
    private List<com.baidu.adp.widget.ListView.a> bcG = new LinkedList();
    private boolean bjl = false;
    private boolean bml = false;
    private boolean aoe = false;

    public cn(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsGoodActivity, bdTypeListView);
        this.bcd = bdTypeListView;
        this.bmi = new HashMap<>();
        cw(z);
    }

    public void a(FrsGoodActivity frsGoodActivity, BdTypeListView bdTypeListView) {
        this.bnM = frsGoodActivity;
        this.blM = new dk(frsGoodActivity, com.baidu.tbadk.core.data.as.UW);
        this.blP = new fh(frsGoodActivity, com.baidu.tbadk.core.data.as.UV);
        this.blQ = new bn(frsGoodActivity, com.baidu.tbadk.core.data.c.RS);
        this.blR = new bs(frsGoodActivity, com.baidu.tbadk.core.data.c.RT);
        this.blS = new bp(frsGoodActivity, com.baidu.tbadk.core.data.c.RU);
        this.blV = new dr(frsGoodActivity, com.baidu.tieba.tbadkCore.z.eoi);
        this.blW = new ee(frsGoodActivity, com.baidu.tbadk.core.data.ai.Uj);
        this.blY = new fj(frsGoodActivity, com.baidu.tbadk.core.data.as.UX);
        this.bmh = new dh(frsGoodActivity, di.bpm);
        this.bmg = new fa(frsGoodActivity, com.baidu.tbadk.core.data.as.UZ);
        this.bmf = new dx(frsGoodActivity, com.baidu.tbadk.core.data.as.UY);
        this.bnN = new ej(frsGoodActivity, com.baidu.tbadk.core.data.am.UI);
        this.bmd = new em(frsGoodActivity, com.baidu.tbadk.core.data.as.VN);
        this.bnO = new cq(frsGoodActivity, com.baidu.tbadk.core.data.as.VR);
        this.bcG.add(this.blM);
        this.bcG.add(this.blP);
        this.bcG.add(this.blQ);
        this.bcG.add(this.blR);
        this.bcG.add(this.blS);
        this.bcG.add(this.blV);
        this.bcG.add(this.blW);
        this.bcG.add(this.blY);
        this.bcG.add(this.bmh);
        this.bcG.add(this.bmg);
        this.bcG.add(this.bmf);
        this.bcG.add(this.bnN);
        this.bcG.add(this.bmd);
        this.bcG.add(this.bnO);
        for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
            if (aVar instanceof bx) {
                ((bx) aVar).e(this.bnM);
            }
        }
        bdTypeListView.g(this.bcG);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
            if (aVar instanceof bx) {
                ((bx) aVar).release();
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar, boolean z, boolean z2) {
        a(oVar);
        C(arrayList);
        D(arrayList);
        this.bcd.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(arrayList, oVar, this.bml, this.aoe);
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
            if (uVar instanceof com.baidu.tbadk.core.data.c) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.bmi != null && !this.bmi.containsValue(uVar)) {
                    this.bmi.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.as) uVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void cw(boolean z) {
        if (this.bjl != z) {
            this.bjl = z;
            if (this.blM != null) {
                this.blM.cw(z);
            }
        }
    }

    public void cC(boolean z) {
        if (this.blJ != null) {
            this.blJ.cC(z);
        }
    }

    public void cD(boolean z) {
        if (this.blI != null) {
            this.blI.cD(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.as> Rm() {
        return this.bmi;
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.blQ != null) {
            this.blQ.l(onClickListener);
        }
        if (this.blR != null) {
            this.blR.l(onClickListener);
        }
        if (this.blS != null) {
            this.blS.l(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.blQ != null) {
            this.blQ.m(onClickListener);
        }
        if (this.blR != null) {
            this.blR.m(onClickListener);
        }
        if (this.blS != null) {
            this.blS.m(onClickListener);
        }
    }

    public void Rn() {
        if (this.bcd != null && this.bcd.getData() != null && this.bcd.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.u uVar : this.bcd.getData()) {
                if ((uVar instanceof com.baidu.tbadk.core.data.as) && ((com.baidu.tbadk.core.data.as) uVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.as) uVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bcd.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bcd.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.blI != null) {
            this.blI.onChangeSkinType(i);
        }
        if (this.blJ != null) {
            this.blJ.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.bcd.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bcd.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.bcG != null && this.bcG.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
                if (aVar instanceof bx) {
                    ((bx) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bcG != null && this.bcG.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
                if (aVar instanceof bx) {
                    ((bx) aVar).a(oVar);
                }
            }
        }
    }

    public void a(bj bjVar) {
        if (this.bcG != null && this.bcG.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
                if (aVar instanceof bx) {
                    ((bx) aVar).a(bjVar);
                }
            }
        }
    }

    public int Ro() {
        if (this.blM != null) {
            return this.blM.Ro();
        }
        return 0;
    }

    public int QA() {
        if (this.blM != null) {
            return this.blM.QA();
        }
        return 0;
    }

    public int Rp() {
        if (this.blV != null) {
            return this.blV.Rp();
        }
        return 0;
    }

    public int Rq() {
        if (this.blM != null) {
            return this.blM.Rq();
        }
        return 0;
    }

    public int Rr() {
        if (this.blV != null) {
            return this.blV.Rr();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.bcG != null && this.bcG.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
                if (aVar instanceof bx) {
                    ((bx) aVar).a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bcG != null && this.bcG.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
                if (aVar instanceof bx) {
                    ((bx) aVar).a(wVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.u aF(int i) {
        if (this.bcd != null) {
            return this.bcd.aF(i);
        }
        return null;
    }

    private void D(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        int i;
        if (this.bcG != null && this.bcG.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.u> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.as.UV.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.bml) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bcG) {
                if (aVar instanceof bx) {
                    ((bx) aVar).gH(i);
                }
            }
        }
    }
}
