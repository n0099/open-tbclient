package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class bd {
    private cp aBA;
    private ct aBB;
    private final HashMap<Integer, com.baidu.tbadk.core.data.q> aBD;
    private FrsActivity aBp;
    private BdTypeListView aBq;
    private cr aBr;
    private ci aBs;
    private View.OnClickListener aBt;
    private View.OnClickListener aBu;
    private cj aBv;
    private da aBw;
    private bi aBx;
    private bk aBy;
    private bp aBz;
    private List<com.baidu.adp.widget.ListView.a> aBC = new ArrayList();
    private boolean ayP = false;
    private boolean aBE = false;
    private boolean NY = false;

    public bd(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsActivity, bdTypeListView);
        this.aBq = bdTypeListView;
        this.aBD = new HashMap<>();
        bL(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aBp = frsActivity;
        this.aBv = new cj(frsActivity, com.baidu.tbadk.core.data.q.Ao);
        this.aBw = new da(frsActivity, com.baidu.tbadk.core.data.q.An);
        this.aBx = new bi(frsActivity, com.baidu.tbadk.core.data.a.zd);
        this.aBy = new bk(frsActivity, com.baidu.tbadk.core.data.a.ze);
        this.aBz = new bp(frsActivity, com.baidu.tbadk.core.data.i.zN);
        this.aBA = new cp(frsActivity, com.baidu.tieba.data.af.alz);
        this.aBB = new ct(frsActivity, com.baidu.tbadk.core.data.o.Ab);
        this.aBC.add(this.aBv);
        this.aBC.add(this.aBw);
        this.aBC.add(this.aBx);
        this.aBC.add(this.aBy);
        this.aBC.add(this.aBz);
        this.aBC.add(this.aBA);
        this.aBC.add(this.aBB);
        bdTypeListView.e(this.aBC);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.al> arrayList, b bVar, boolean z, boolean z2) {
        setForumModel(bVar);
        this.NY = z2;
        bZ(this.NY);
        this.aBE = z;
        bY(this.aBE);
        r(arrayList);
        s(arrayList);
        this.aBq.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.al> arrayList, b bVar) {
        a(arrayList, bVar, this.aBE, this.NY);
    }

    private ArrayList<Integer> r(ArrayList<com.baidu.adp.widget.ListView.al> arrayList) {
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
            com.baidu.adp.widget.ListView.al alVar = arrayList.get(i2);
            if (alVar instanceof com.baidu.tbadk.core.data.a) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.aBD != null && !this.aBD.containsValue(alVar)) {
                    this.aBD.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.q) alVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bL(boolean z) {
        if (this.ayP != z) {
            this.ayP = z;
            if (this.aBv != null) {
                this.aBv.bL(z);
            }
        }
    }

    public void bW(boolean z) {
        if (this.aBs != null) {
            this.aBs.bW(z);
        }
    }

    public boolean FK() {
        if (this.aBs != null) {
            return this.aBs.FK();
        }
        return false;
    }

    public void bX(boolean z) {
        if (this.aBr != null) {
            this.aBr.bX(z);
        }
    }

    public boolean FL() {
        if (this.aBr != null) {
            return this.aBr.FL();
        }
        return false;
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.q> FM() {
        return this.aBD;
    }

    public void ae(String str, String str2) {
        if (this.aBB != null) {
            this.aBB.ae(str, str2);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aBx != null) {
            this.aBx.i(onClickListener);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        if (this.aBx != null) {
            this.aBx.j(onClickListener);
        }
        if (this.aBy != null) {
            this.aBy.j(onClickListener);
        }
    }

    public void FN() {
        if (this.aBq != null && this.aBq.getData() != null && this.aBq.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.al alVar : this.aBq.getData()) {
                if ((alVar instanceof com.baidu.tbadk.core.data.q) && ((com.baidu.tbadk.core.data.q) alVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.q) alVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aBq.getAdapter() instanceof com.baidu.adp.widget.ListView.j) {
            ((com.baidu.adp.widget.ListView.j) this.aBq.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aBr != null) {
            this.aBr.onChangeSkinType(i);
        }
        if (this.aBs != null) {
            this.aBs.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aBq.getAdapter() instanceof com.baidu.adp.widget.ListView.j) {
            ((com.baidu.adp.widget.ListView.j) this.aBq.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aBC != null && this.aBC.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aBC) {
                if (aVar instanceof bm) {
                    ((bm) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void setForumModel(b bVar) {
        if (this.aBC != null && this.aBC.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aBC) {
                if (aVar instanceof bm) {
                    ((bm) aVar).h(bVar);
                }
            }
        }
    }

    public void a(be beVar) {
        if (this.aBC != null && this.aBC.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aBC) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(beVar);
                }
            }
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aBt = onClickListener;
        if (this.aBr != null) {
            this.aBr.k(onClickListener);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.aBu = onClickListener;
        if (this.aBs != null) {
            this.aBs.n(onClickListener);
        }
    }

    public int EL() {
        if (this.aBv != null) {
            return this.aBv.EL();
        }
        return 0;
    }

    public int EM() {
        if (this.aBv != null) {
            return this.aBv.EM();
        }
        return 0;
    }

    public int EN() {
        if (this.aBv != null) {
            return this.aBv.EN();
        }
        return 0;
    }

    public int FO() {
        if (this.aBA != null) {
            return this.aBA.FO();
        }
        return 0;
    }

    public int FP() {
        if (this.aBA != null) {
            return this.aBA.FP();
        }
        return 0;
    }

    private void bY(boolean z) {
        if (z) {
            if (this.aBr == null) {
                this.aBr = new cr(this.aBp);
                this.aBr.k(this.aBt);
            }
            if (this.aBq != null) {
                this.aBq.setPrePage(this.aBr);
            }
        } else if (this.aBr != null && this.aBq != null) {
            this.aBq.setPrePage(null);
        }
    }

    private void bZ(boolean z) {
        if (z) {
            if (this.aBs == null) {
                this.aBs = new ci(this.aBp);
                this.aBs.n(this.aBu);
            }
            if (this.aBq != null) {
                this.aBq.setNextPage(this.aBs);
            }
        } else if (this.aBs != null && this.aBq != null) {
            this.aBq.setNextPage(null);
        }
    }

    public void a(com.baidu.adp.widget.ListView.am amVar) {
        if (this.aBC != null && this.aBC.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aBC) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(amVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.an anVar) {
        if (this.aBC != null && this.aBC.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aBC) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(anVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.al ai(int i) {
        if (this.aBq != null) {
            return this.aBq.ai(i);
        }
        return null;
    }

    private void s(ArrayList<com.baidu.adp.widget.ListView.al> arrayList) {
        int i;
        if (this.aBC != null && this.aBC.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.al> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().hu().getId() != com.baidu.tbadk.core.data.q.An.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aBE) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aBC) {
                if (aVar instanceof bm) {
                    ((bm) aVar).eI(i);
                }
            }
        }
    }
}
