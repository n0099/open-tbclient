package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ay {
    private FrsActivity aEa;
    private BdTypeListView aEb;
    private cq aEc;
    private ce aEd;
    private View.OnClickListener aEe;
    private View.OnClickListener aEf;
    private cf aEg;
    private cz aEh;
    private bd aEi;
    private bf aEj;
    private bk aEk;
    private co aEl;
    private cs aEm;
    private final HashMap<Integer, com.baidu.tbadk.core.data.x> aEo;
    private List<com.baidu.adp.widget.ListView.a> aEn = new ArrayList();
    private boolean aBX = false;
    private boolean aEp = false;
    private boolean Ur = false;

    public ay(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsActivity, bdTypeListView);
        this.aEb = bdTypeListView;
        this.aEo = new HashMap<>();
        bD(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aEa = frsActivity;
        this.aEg = new cf(frsActivity, com.baidu.tbadk.core.data.x.EB);
        this.aEh = new cz(frsActivity, com.baidu.tbadk.core.data.x.EA);
        this.aEi = new bd(frsActivity, com.baidu.tbadk.core.data.c.Dh);
        this.aEj = new bf(frsActivity, com.baidu.tbadk.core.data.c.Di);
        this.aEk = new bk(frsActivity, com.baidu.tbadk.core.data.m.DV);
        this.aEl = new co(frsActivity, com.baidu.tieba.tbadkCore.ag.bUU);
        this.aEm = new cs(frsActivity, com.baidu.tbadk.core.data.t.En);
        this.aEn.add(this.aEg);
        this.aEn.add(this.aEh);
        this.aEn.add(this.aEi);
        this.aEn.add(this.aEj);
        this.aEn.add(this.aEk);
        this.aEn.add(this.aEl);
        this.aEn.add(this.aEm);
        bdTypeListView.h(this.aEn);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.am> arrayList, com.baidu.tieba.tbadkCore.e eVar, boolean z, boolean z2) {
        setForumModel(eVar);
        this.Ur = z2;
        bN(this.Ur);
        this.aEp = z;
        bM(this.aEp);
        B(arrayList);
        C(arrayList);
        this.aEb.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.am> arrayList, com.baidu.tieba.tbadkCore.e eVar) {
        a(arrayList, eVar, this.aEp, this.Ur);
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
                if (this.aEo != null && !this.aEo.containsValue(amVar)) {
                    this.aEo.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.x) amVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bD(boolean z) {
        if (this.aBX != z) {
            this.aBX = z;
            if (this.aEg != null) {
                this.aEg.bD(z);
            }
        }
    }

    public void bK(boolean z) {
        if (this.aEd != null) {
            this.aEd.bK(z);
        }
    }

    public boolean Gi() {
        if (this.aEd != null) {
            return this.aEd.Gi();
        }
        return false;
    }

    public void bL(boolean z) {
        if (this.aEc != null) {
            this.aEc.bL(z);
        }
    }

    public boolean Gj() {
        if (this.aEc != null) {
            return this.aEc.Gj();
        }
        return false;
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.x> Gk() {
        return this.aEo;
    }

    public void ap(String str, String str2) {
        if (this.aEm != null) {
            this.aEm.ap(str, str2);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aEi != null) {
            this.aEi.i(onClickListener);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        if (this.aEi != null) {
            this.aEi.j(onClickListener);
        }
        if (this.aEj != null) {
            this.aEj.j(onClickListener);
        }
    }

    public void Gl() {
        if (this.aEb != null && this.aEb.getData() != null && this.aEb.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.am amVar : this.aEb.getData()) {
                if ((amVar instanceof com.baidu.tbadk.core.data.x) && ((com.baidu.tbadk.core.data.x) amVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.x) amVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aEb.getAdapter() instanceof com.baidu.adp.widget.ListView.k) {
            ((com.baidu.adp.widget.ListView.k) this.aEb.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aEc != null) {
            this.aEc.onChangeSkinType(i);
        }
        if (this.aEd != null) {
            this.aEd.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aEb.getAdapter() instanceof com.baidu.adp.widget.ListView.k) {
            ((com.baidu.adp.widget.ListView.k) this.aEb.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aEn != null && this.aEn.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aEn) {
                if (aVar instanceof bh) {
                    ((bh) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void setForumModel(com.baidu.tieba.tbadkCore.e eVar) {
        if (this.aEn != null && this.aEn.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aEn) {
                if (aVar instanceof bh) {
                    ((bh) aVar).e(eVar);
                }
            }
        }
    }

    public void a(az azVar) {
        if (this.aEn != null && this.aEn.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aEn) {
                if (aVar instanceof bh) {
                    ((bh) aVar).a(azVar);
                }
            }
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aEe = onClickListener;
        if (this.aEc != null) {
            this.aEc.k(onClickListener);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.aEf = onClickListener;
        if (this.aEd != null) {
            this.aEd.n(onClickListener);
        }
    }

    public int Gm() {
        if (this.aEg != null) {
            return this.aEg.Gm();
        }
        return 0;
    }

    public int Fw() {
        if (this.aEg != null) {
            return this.aEg.Fw();
        }
        return 0;
    }

    public int Fx() {
        if (this.aEg != null) {
            return this.aEg.Fx();
        }
        return 0;
    }

    public int Fy() {
        if (this.aEg != null) {
            return this.aEg.Fy();
        }
        return 0;
    }

    public int Gn() {
        if (this.aEl != null) {
            return this.aEl.Gn();
        }
        return 0;
    }

    public int Go() {
        if (this.aEl != null) {
            return this.aEl.Go();
        }
        return 0;
    }

    private void bM(boolean z) {
        if (z) {
            if (this.aEc == null) {
                this.aEc = new cq(this.aEa);
                this.aEc.k(this.aEe);
            }
            if (this.aEb != null) {
                this.aEb.setPrePage(this.aEc);
            }
        } else if (this.aEc != null && this.aEb != null) {
            this.aEb.setPrePage(null);
        }
    }

    private void bN(boolean z) {
        if (z) {
            if (this.aEd == null) {
                this.aEd = new ce(this.aEa);
                this.aEd.n(this.aEf);
            }
            if (this.aEb != null) {
                this.aEb.setNextPage(this.aEd);
            }
        } else if (this.aEd != null && this.aEb != null) {
            this.aEb.setNextPage(null);
        }
    }

    public void a(com.baidu.adp.widget.ListView.an anVar) {
        if (this.aEn != null && this.aEn.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aEn) {
                if (aVar instanceof bh) {
                    ((bh) aVar).a(anVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ao aoVar) {
        if (this.aEn != null && this.aEn.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aEn) {
                if (aVar instanceof bh) {
                    ((bh) aVar).a(aoVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.am aD(int i) {
        if (this.aEb != null) {
            return this.aEb.aD(i);
        }
        return null;
    }

    private void C(ArrayList<com.baidu.adp.widget.ListView.am> arrayList) {
        int i;
        if (this.aEn != null && this.aEn.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.am> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().jl().getId() != com.baidu.tbadk.core.data.x.EA.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aEp) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aEn) {
                if (aVar instanceof bh) {
                    ((bh) aVar).eM(i);
                }
            }
        }
    }
}
