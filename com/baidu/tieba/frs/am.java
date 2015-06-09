package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class am {
    private com.baidu.tieba.frs.a.e aMA;
    private final HashMap<Integer, com.baidu.tbadk.core.data.w> aMC;
    private FrsActivity aMl;
    private BdTypeListView aMm;
    private by aMn;
    private bp aMo;
    private View.OnClickListener aMp;
    private View.OnClickListener aMq;
    private bq aMr;
    private cf aMs;
    private ar aMt;
    private as aMu;
    private ba aMv;
    private bx aMw;
    private ca aMx;
    private com.baidu.tieba.frs.a.a aMy;
    private com.baidu.tieba.frs.a.c aMz;
    private List<com.baidu.adp.widget.ListView.a> aMB = new ArrayList();
    private boolean aKi = false;
    private boolean aMD = false;
    private boolean afG = false;

    public am(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsActivity, bdTypeListView);
        this.aMm = bdTypeListView;
        this.aMC = new HashMap<>();
        bP(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aMl = frsActivity;
        this.aMr = new bq(frsActivity, com.baidu.tbadk.core.data.w.QL);
        this.aMs = new cf(frsActivity, com.baidu.tbadk.core.data.w.QK);
        this.aMt = new ar(frsActivity, com.baidu.tbadk.core.data.c.Pm);
        this.aMu = new as(frsActivity, com.baidu.tbadk.core.data.c.Pn);
        this.aMv = new ba(frsActivity, com.baidu.tbadk.core.data.m.Qi);
        this.aMw = new bx(frsActivity, com.baidu.tieba.tbadkCore.aj.cpQ);
        this.aMx = new ca(frsActivity, com.baidu.tbadk.core.data.s.Qw);
        this.aMy = new com.baidu.tieba.frs.a.a(frsActivity, com.baidu.tbadk.core.data.c.Pq);
        this.aMA = new com.baidu.tieba.frs.a.e(frsActivity, com.baidu.tbadk.core.data.c.Pp);
        this.aMz = new com.baidu.tieba.frs.a.c(frsActivity, com.baidu.tbadk.core.data.c.Po);
        this.aMB.add(this.aMr);
        this.aMB.add(this.aMs);
        this.aMB.add(this.aMt);
        this.aMB.add(this.aMu);
        this.aMB.add(this.aMv);
        this.aMB.add(this.aMw);
        this.aMB.add(this.aMx);
        this.aMB.add(this.aMy);
        this.aMB.add(this.aMA);
        this.aMB.add(this.aMz);
        bdTypeListView.h(this.aMB);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, com.baidu.tieba.tbadkCore.w wVar, boolean z, boolean z2) {
        a(wVar);
        w(arrayList);
        x(arrayList);
        this.aMm.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, com.baidu.tieba.tbadkCore.w wVar) {
        a(arrayList, wVar, this.aMD, this.afG);
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
                if (this.aMC != null && !this.aMC.containsValue(aiVar)) {
                    this.aMC.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.w) aiVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bP(boolean z) {
        if (this.aKi != z) {
            this.aKi = z;
            if (this.aMr != null) {
                this.aMr.bP(z);
            }
        }
    }

    public void bV(boolean z) {
        if (this.aMo != null) {
            this.aMo.bV(z);
        }
    }

    public void bW(boolean z) {
        if (this.aMn != null) {
            this.aMn.bW(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.w> KS() {
        return this.aMC;
    }

    public void aq(String str, String str2) {
        if (this.aMx != null) {
            this.aMx.aq(str, str2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.aMt != null) {
            this.aMt.h(onClickListener);
        }
        if (this.aMu != null) {
            this.aMu.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aMt != null) {
            this.aMt.i(onClickListener);
        }
        if (this.aMu != null) {
            this.aMu.i(onClickListener);
        }
    }

    public void KT() {
        if (this.aMm != null && this.aMm.getData() != null && this.aMm.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.ai aiVar : this.aMm.getData()) {
                if ((aiVar instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) aiVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.w) aiVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aMm.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aMm.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aMn != null) {
            this.aMn.onChangeSkinType(i);
        }
        if (this.aMo != null) {
            this.aMo.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aMm.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aMm.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aMB != null && this.aMB.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMB) {
                if (aVar instanceof av) {
                    ((av) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.w wVar) {
        if (this.aMB != null && this.aMB.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMB) {
                if (aVar instanceof av) {
                    ((av) aVar).a(wVar);
                }
            }
        }
    }

    public void a(an anVar) {
        if (this.aMB != null && this.aMB.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMB) {
                if (aVar instanceof av) {
                    ((av) aVar).a(anVar);
                }
            }
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.aMp = onClickListener;
        if (this.aMn != null) {
            this.aMn.j(onClickListener);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aMq = onClickListener;
        if (this.aMo != null) {
            this.aMo.m(onClickListener);
        }
    }

    public int KU() {
        if (this.aMr != null) {
            return this.aMr.KU();
        }
        return 0;
    }

    public int Kh() {
        if (this.aMr != null) {
            return this.aMr.Kh();
        }
        return 0;
    }

    public int KV() {
        if (this.aMw != null) {
            return this.aMw.KV();
        }
        return 0;
    }

    public int KW() {
        if (this.aMr != null) {
            return this.aMr.KW();
        }
        return 0;
    }

    public int KX() {
        if (this.aMw != null) {
            return this.aMw.KX();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.aj ajVar) {
        if (this.aMB != null && this.aMB.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMB) {
                if (aVar instanceof av) {
                    ((av) aVar).a(ajVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ak akVar) {
        if (this.aMB != null && this.aMB.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMB) {
                if (aVar instanceof av) {
                    ((av) aVar).a(akVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.ai ay(int i) {
        if (this.aMm != null) {
            return this.aMm.ay(i);
        }
        return null;
    }

    private void x(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
        int i;
        if (this.aMB != null && this.aMB.size() != 0) {
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
            if (this.aMD) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aMB) {
                if (aVar instanceof av) {
                    ((av) aVar).eV(i);
                }
            }
        }
    }
}
