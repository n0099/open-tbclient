package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ay {
    private FrsActivity aEd;
    private BdTypeListView aEe;
    private cq aEf;
    private ce aEg;
    private View.OnClickListener aEh;
    private View.OnClickListener aEi;
    private cf aEj;
    private cz aEk;
    private bd aEl;
    private bf aEm;
    private bk aEn;
    private co aEo;
    private cs aEp;
    private final HashMap<Integer, com.baidu.tbadk.core.data.x> aEr;
    private List<com.baidu.adp.widget.ListView.a> aEq = new ArrayList();
    private boolean aCa = false;
    private boolean aEs = false;
    private boolean Uu = false;

    public ay(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsActivity, bdTypeListView);
        this.aEe = bdTypeListView;
        this.aEr = new HashMap<>();
        bD(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aEd = frsActivity;
        this.aEj = new cf(frsActivity, com.baidu.tbadk.core.data.x.EE);
        this.aEk = new cz(frsActivity, com.baidu.tbadk.core.data.x.ED);
        this.aEl = new bd(frsActivity, com.baidu.tbadk.core.data.c.Dk);
        this.aEm = new bf(frsActivity, com.baidu.tbadk.core.data.c.Dl);
        this.aEn = new bk(frsActivity, com.baidu.tbadk.core.data.m.DY);
        this.aEo = new co(frsActivity, com.baidu.tieba.tbadkCore.ag.bUV);
        this.aEp = new cs(frsActivity, com.baidu.tbadk.core.data.t.Eq);
        this.aEq.add(this.aEj);
        this.aEq.add(this.aEk);
        this.aEq.add(this.aEl);
        this.aEq.add(this.aEm);
        this.aEq.add(this.aEn);
        this.aEq.add(this.aEo);
        this.aEq.add(this.aEp);
        bdTypeListView.h(this.aEq);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.am> arrayList, com.baidu.tieba.tbadkCore.e eVar, boolean z, boolean z2) {
        setForumModel(eVar);
        this.Uu = z2;
        bN(this.Uu);
        this.aEs = z;
        bM(this.aEs);
        B(arrayList);
        C(arrayList);
        this.aEe.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.am> arrayList, com.baidu.tieba.tbadkCore.e eVar) {
        a(arrayList, eVar, this.aEs, this.Uu);
    }

    private ArrayList<Integer> B(ArrayList<com.baidu.adp.widget.ListView.am> arrayList) {
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
            com.baidu.adp.widget.ListView.am amVar = arrayList.get(i2);
            if (amVar instanceof com.baidu.tbadk.core.data.c) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.aEr != null && !this.aEr.containsValue(amVar)) {
                    this.aEr.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.x) amVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bD(boolean z) {
        if (this.aCa != z) {
            this.aCa = z;
            if (this.aEj != null) {
                this.aEj.bD(z);
            }
        }
    }

    public void bK(boolean z) {
        if (this.aEg != null) {
            this.aEg.bK(z);
        }
    }

    public boolean Go() {
        if (this.aEg != null) {
            return this.aEg.Go();
        }
        return false;
    }

    public void bL(boolean z) {
        if (this.aEf != null) {
            this.aEf.bL(z);
        }
    }

    public boolean Gp() {
        if (this.aEf != null) {
            return this.aEf.Gp();
        }
        return false;
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.x> Gq() {
        return this.aEr;
    }

    public void ap(String str, String str2) {
        if (this.aEp != null) {
            this.aEp.ap(str, str2);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aEl != null) {
            this.aEl.i(onClickListener);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        if (this.aEl != null) {
            this.aEl.j(onClickListener);
        }
        if (this.aEm != null) {
            this.aEm.j(onClickListener);
        }
    }

    public void Gr() {
        if (this.aEe != null && this.aEe.getData() != null && this.aEe.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.am amVar : this.aEe.getData()) {
                if ((amVar instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) amVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.x) amVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aEe.getAdapter() instanceof com.baidu.adp.widget.ListView.k) {
            ((com.baidu.adp.widget.ListView.k) this.aEe.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aEf != null) {
            this.aEf.onChangeSkinType(i);
        }
        if (this.aEg != null) {
            this.aEg.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aEe.getAdapter() instanceof com.baidu.adp.widget.ListView.k) {
            ((com.baidu.adp.widget.ListView.k) this.aEe.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aEq != null && this.aEq.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aEq) {
                if (aVar instanceof bh) {
                    ((bh) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void setForumModel(com.baidu.tieba.tbadkCore.e eVar) {
        if (this.aEq != null && this.aEq.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aEq) {
                if (aVar instanceof bh) {
                    ((bh) aVar).e(eVar);
                }
            }
        }
    }

    public void a(az azVar) {
        if (this.aEq != null && this.aEq.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aEq) {
                if (aVar instanceof bh) {
                    ((bh) aVar).a(azVar);
                }
            }
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aEh = onClickListener;
        if (this.aEf != null) {
            this.aEf.k(onClickListener);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.aEi = onClickListener;
        if (this.aEg != null) {
            this.aEg.n(onClickListener);
        }
    }

    public int Gs() {
        if (this.aEj != null) {
            return this.aEj.Gs();
        }
        return 0;
    }

    public int FC() {
        if (this.aEj != null) {
            return this.aEj.FC();
        }
        return 0;
    }

    public int FD() {
        if (this.aEj != null) {
            return this.aEj.FD();
        }
        return 0;
    }

    public int FE() {
        if (this.aEj != null) {
            return this.aEj.FE();
        }
        return 0;
    }

    public int Gt() {
        if (this.aEo != null) {
            return this.aEo.Gt();
        }
        return 0;
    }

    public int Gu() {
        if (this.aEo != null) {
            return this.aEo.Gu();
        }
        return 0;
    }

    private void bM(boolean z) {
        if (z) {
            if (this.aEf == null) {
                this.aEf = new cq(this.aEd);
                this.aEf.k(this.aEh);
            }
            if (this.aEe != null) {
                this.aEe.setPrePage(this.aEf);
            }
        } else if (this.aEf != null && this.aEe != null) {
            this.aEe.setPrePage(null);
        }
    }

    private void bN(boolean z) {
        if (z) {
            if (this.aEg == null) {
                this.aEg = new ce(this.aEd);
                this.aEg.n(this.aEi);
            }
            if (this.aEe != null) {
                this.aEe.setNextPage(this.aEg);
            }
        } else if (this.aEg != null && this.aEe != null) {
            this.aEe.setNextPage(null);
        }
    }

    public void a(com.baidu.adp.widget.ListView.an anVar) {
        if (this.aEq != null && this.aEq.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aEq) {
                if (aVar instanceof bh) {
                    ((bh) aVar).a(anVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ao aoVar) {
        if (this.aEq != null && this.aEq.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aEq) {
                if (aVar instanceof bh) {
                    ((bh) aVar).a(aoVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.am aD(int i) {
        if (this.aEe != null) {
            return this.aEe.aD(i);
        }
        return null;
    }

    private void C(ArrayList<com.baidu.adp.widget.ListView.am> arrayList) {
        int i;
        if (this.aEq != null && this.aEq.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.am> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().js().getId() != com.baidu.tbadk.core.data.x.ED.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aEs) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aEq) {
                if (aVar instanceof bh) {
                    ((bh) aVar).eM(i);
                }
            }
        }
    }
}
