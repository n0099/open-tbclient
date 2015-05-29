package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class am {
    private final HashMap<Integer, com.baidu.tbadk.core.data.w> aMB;
    private FrsActivity aMk;
    private BdTypeListView aMl;
    private by aMm;
    private bp aMn;
    private View.OnClickListener aMo;
    private View.OnClickListener aMp;
    private bq aMq;
    private cf aMr;
    private ar aMs;
    private as aMt;
    private ba aMu;
    private bx aMv;
    private ca aMw;
    private com.baidu.tieba.frs.a.a aMx;
    private com.baidu.tieba.frs.a.c aMy;
    private com.baidu.tieba.frs.a.e aMz;
    private List<com.baidu.adp.widget.ListView.a> aMA = new ArrayList();
    private boolean aKh = false;
    private boolean aMC = false;
    private boolean afG = false;

    public am(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsActivity, bdTypeListView);
        this.aMl = bdTypeListView;
        this.aMB = new HashMap<>();
        bP(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aMk = frsActivity;
        this.aMq = new bq(frsActivity, com.baidu.tbadk.core.data.w.QL);
        this.aMr = new cf(frsActivity, com.baidu.tbadk.core.data.w.QK);
        this.aMs = new ar(frsActivity, com.baidu.tbadk.core.data.c.Pm);
        this.aMt = new as(frsActivity, com.baidu.tbadk.core.data.c.Pn);
        this.aMu = new ba(frsActivity, com.baidu.tbadk.core.data.m.Qi);
        this.aMv = new bx(frsActivity, com.baidu.tieba.tbadkCore.aj.cpP);
        this.aMw = new ca(frsActivity, com.baidu.tbadk.core.data.s.Qw);
        this.aMx = new com.baidu.tieba.frs.a.a(frsActivity, com.baidu.tbadk.core.data.c.Pq);
        this.aMz = new com.baidu.tieba.frs.a.e(frsActivity, com.baidu.tbadk.core.data.c.Pp);
        this.aMy = new com.baidu.tieba.frs.a.c(frsActivity, com.baidu.tbadk.core.data.c.Po);
        this.aMA.add(this.aMq);
        this.aMA.add(this.aMr);
        this.aMA.add(this.aMs);
        this.aMA.add(this.aMt);
        this.aMA.add(this.aMu);
        this.aMA.add(this.aMv);
        this.aMA.add(this.aMw);
        this.aMA.add(this.aMx);
        this.aMA.add(this.aMz);
        this.aMA.add(this.aMy);
        bdTypeListView.h(this.aMA);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, com.baidu.tieba.tbadkCore.w wVar, boolean z, boolean z2) {
        a(wVar);
        w(arrayList);
        x(arrayList);
        this.aMl.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, com.baidu.tieba.tbadkCore.w wVar) {
        a(arrayList, wVar, this.aMC, this.afG);
    }

    private ArrayList<Integer> w(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
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
            com.baidu.adp.widget.ListView.ai aiVar = arrayList.get(i2);
            if (aiVar instanceof com.baidu.tbadk.core.data.c) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.aMB != null && !this.aMB.containsValue(aiVar)) {
                    this.aMB.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.w) aiVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bP(boolean z) {
        if (this.aKh != z) {
            this.aKh = z;
            if (this.aMq != null) {
                this.aMq.bP(z);
            }
        }
    }

    public void bV(boolean z) {
        if (this.aMn != null) {
            this.aMn.bV(z);
        }
    }

    public void bW(boolean z) {
        if (this.aMm != null) {
            this.aMm.bW(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.w> KR() {
        return this.aMB;
    }

    public void aq(String str, String str2) {
        if (this.aMw != null) {
            this.aMw.aq(str, str2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.aMs != null) {
            this.aMs.h(onClickListener);
        }
        if (this.aMt != null) {
            this.aMt.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aMs != null) {
            this.aMs.i(onClickListener);
        }
        if (this.aMt != null) {
            this.aMt.i(onClickListener);
        }
    }

    public void KS() {
        if (this.aMl != null && this.aMl.getData() != null && this.aMl.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.ai aiVar : this.aMl.getData()) {
                if ((aiVar instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) aiVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.w) aiVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aMl.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aMl.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aMm != null) {
            this.aMm.onChangeSkinType(i);
        }
        if (this.aMn != null) {
            this.aMn.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aMl.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aMl.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aMA != null && this.aMA.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMA) {
                if (aVar instanceof av) {
                    ((av) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.w wVar) {
        if (this.aMA != null && this.aMA.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMA) {
                if (aVar instanceof av) {
                    ((av) aVar).a(wVar);
                }
            }
        }
    }

    public void a(an anVar) {
        if (this.aMA != null && this.aMA.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMA) {
                if (aVar instanceof av) {
                    ((av) aVar).a(anVar);
                }
            }
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.aMo = onClickListener;
        if (this.aMm != null) {
            this.aMm.j(onClickListener);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aMp = onClickListener;
        if (this.aMn != null) {
            this.aMn.m(onClickListener);
        }
    }

    public int KT() {
        if (this.aMq != null) {
            return this.aMq.KT();
        }
        return 0;
    }

    public int Kg() {
        if (this.aMq != null) {
            return this.aMq.Kg();
        }
        return 0;
    }

    public int KU() {
        if (this.aMv != null) {
            return this.aMv.KU();
        }
        return 0;
    }

    public int KV() {
        if (this.aMq != null) {
            return this.aMq.KV();
        }
        return 0;
    }

    public int KW() {
        if (this.aMv != null) {
            return this.aMv.KW();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.aj ajVar) {
        if (this.aMA != null && this.aMA.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMA) {
                if (aVar instanceof av) {
                    ((av) aVar).a(ajVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ak akVar) {
        if (this.aMA != null && this.aMA.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMA) {
                if (aVar instanceof av) {
                    ((av) aVar).a(akVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.ai ay(int i) {
        if (this.aMl != null) {
            return this.aMl.ay(i);
        }
        return null;
    }

    private void x(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
        int i;
        if (this.aMA != null && this.aMA.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.ai> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.w.QK.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aMC) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aMA) {
                if (aVar instanceof av) {
                    ((av) aVar).eV(i);
                }
            }
        }
    }
}
