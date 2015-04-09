package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class am {
    private FrsActivity aKd;
    private BdTypeListView aKe;
    private bz aKf;
    private br aKg;
    private View.OnClickListener aKh;
    private View.OnClickListener aKi;
    private bs aKj;
    private cg aKk;
    private ar aKl;
    private as aKm;
    private ba aKn;
    private by aKo;
    private cb aKp;
    private com.baidu.tieba.frs.a.a aKq;
    private com.baidu.tieba.frs.a.c aKr;
    private com.baidu.tieba.frs.a.e aKs;
    private final HashMap<Integer, com.baidu.tbadk.core.data.w> aKu;
    private List<com.baidu.adp.widget.ListView.a> aKt = new ArrayList();
    private boolean aHZ = false;
    private boolean aKv = false;
    private boolean aeC = false;

    public am(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsActivity, bdTypeListView);
        this.aKe = bdTypeListView;
        this.aKu = new HashMap<>();
        bG(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aKd = frsActivity;
        this.aKj = new bs(frsActivity, com.baidu.tbadk.core.data.w.Qp);
        this.aKk = new cg(frsActivity, com.baidu.tbadk.core.data.w.Qo);
        this.aKl = new ar(frsActivity, com.baidu.tbadk.core.data.c.OR);
        this.aKm = new as(frsActivity, com.baidu.tbadk.core.data.c.OS);
        this.aKn = new ba(frsActivity, com.baidu.tbadk.core.data.m.PM);
        this.aKo = new by(frsActivity, com.baidu.tieba.tbadkCore.aj.clQ);
        this.aKp = new cb(frsActivity, com.baidu.tbadk.core.data.s.Qb);
        this.aKq = new com.baidu.tieba.frs.a.a(frsActivity, com.baidu.tbadk.core.data.c.OW);
        this.aKs = new com.baidu.tieba.frs.a.e(frsActivity, com.baidu.tbadk.core.data.c.OV);
        this.aKr = new com.baidu.tieba.frs.a.c(frsActivity, com.baidu.tbadk.core.data.c.OT);
        this.aKt.add(this.aKj);
        this.aKt.add(this.aKk);
        this.aKt.add(this.aKl);
        this.aKt.add(this.aKm);
        this.aKt.add(this.aKn);
        this.aKt.add(this.aKo);
        this.aKt.add(this.aKp);
        this.aKt.add(this.aKq);
        this.aKt.add(this.aKs);
        this.aKt.add(this.aKr);
        bdTypeListView.g(this.aKt);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, com.baidu.tieba.tbadkCore.w wVar, boolean z, boolean z2) {
        a(wVar);
        x(arrayList);
        y(arrayList);
        this.aKe.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, com.baidu.tieba.tbadkCore.w wVar) {
        a(arrayList, wVar, this.aKv, this.aeC);
    }

    private ArrayList<Integer> x(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
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
                if (this.aKu != null && !this.aKu.containsValue(aiVar)) {
                    this.aKu.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.w) aiVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bG(boolean z) {
        if (this.aHZ != z) {
            this.aHZ = z;
            if (this.aKj != null) {
                this.aKj.bG(z);
            }
        }
    }

    public void bM(boolean z) {
        if (this.aKg != null) {
            this.aKg.bM(z);
        }
    }

    public void bN(boolean z) {
        if (this.aKf != null) {
            this.aKf.bN(z);
        }
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.w> JN() {
        return this.aKu;
    }

    public void al(String str, String str2) {
        if (this.aKp != null) {
            this.aKp.al(str, str2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.aKl != null) {
            this.aKl.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aKl != null) {
            this.aKl.i(onClickListener);
        }
        if (this.aKm != null) {
            this.aKm.i(onClickListener);
        }
    }

    public void JO() {
        if (this.aKe != null && this.aKe.getData() != null && this.aKe.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.ai aiVar : this.aKe.getData()) {
                if ((aiVar instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) aiVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.w) aiVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aKe.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aKe.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aKf != null) {
            this.aKf.onChangeSkinType(i);
        }
        if (this.aKg != null) {
            this.aKg.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aKe.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aKe.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aKt != null && this.aKt.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aKt) {
                if (aVar instanceof av) {
                    ((av) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.w wVar) {
        if (this.aKt != null && this.aKt.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aKt) {
                if (aVar instanceof av) {
                    ((av) aVar).a(wVar);
                }
            }
        }
    }

    public void a(an anVar) {
        if (this.aKt != null && this.aKt.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aKt) {
                if (aVar instanceof av) {
                    ((av) aVar).a(anVar);
                }
            }
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.aKh = onClickListener;
        if (this.aKf != null) {
            this.aKf.j(onClickListener);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aKi = onClickListener;
        if (this.aKg != null) {
            this.aKg.m(onClickListener);
        }
    }

    public int JP() {
        if (this.aKj != null) {
            return this.aKj.JP();
        }
        return 0;
    }

    public int Jd() {
        if (this.aKj != null) {
            return this.aKj.Jd();
        }
        return 0;
    }

    public int JQ() {
        if (this.aKo != null) {
            return this.aKo.JQ();
        }
        return 0;
    }

    public int JR() {
        if (this.aKo != null) {
            return this.aKo.JR();
        }
        return 0;
    }

    public void a(com.baidu.adp.widget.ListView.aj ajVar) {
        if (this.aKt != null && this.aKt.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aKt) {
                if (aVar instanceof av) {
                    ((av) aVar).a(ajVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ak akVar) {
        if (this.aKt != null && this.aKt.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aKt) {
                if (aVar instanceof av) {
                    ((av) aVar).a(akVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.ai aA(int i) {
        if (this.aKe != null) {
            return this.aKe.aA(i);
        }
        return null;
    }

    private void y(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
        int i;
        if (this.aKt != null && this.aKt.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.ai> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.w.Qo.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aKv) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aKt) {
                if (aVar instanceof av) {
                    ((av) aVar).eH(i);
                }
            }
        }
    }
}
