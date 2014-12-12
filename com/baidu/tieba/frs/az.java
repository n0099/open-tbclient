package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class az {
    private FrsActivity aDc;
    private BdTypeListView aDd;
    private cp aDe;
    private cf aDf;
    private View.OnClickListener aDg;
    private View.OnClickListener aDh;
    private cg aDi;
    private cy aDj;
    private be aDk;
    private bg aDl;
    private bl aDm;
    private cn aDn;
    private cr aDo;
    private final HashMap<Integer, com.baidu.tbadk.core.data.w> aDq;
    private List<com.baidu.adp.widget.ListView.a> aDp = new ArrayList();
    private boolean aAZ = false;
    private boolean aDr = false;
    private boolean TP = false;

    public az(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        a(frsActivity, bdTypeListView);
        this.aDd = bdTypeListView;
        this.aDq = new HashMap<>();
        bA(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.aDc = frsActivity;
        this.aDi = new cg(frsActivity, com.baidu.tbadk.core.data.w.EA);
        this.aDj = new cy(frsActivity, com.baidu.tbadk.core.data.w.Ez);
        this.aDk = new be(frsActivity, com.baidu.tbadk.core.data.c.Di);
        this.aDl = new bg(frsActivity, com.baidu.tbadk.core.data.c.Dj);
        this.aDm = new bl(frsActivity, com.baidu.tbadk.core.data.l.DU);
        this.aDn = new cn(frsActivity, com.baidu.tieba.tbadkCore.ag.bTc);
        this.aDo = new cr(frsActivity, com.baidu.tbadk.core.data.s.Em);
        this.aDp.add(this.aDi);
        this.aDp.add(this.aDj);
        this.aDp.add(this.aDk);
        this.aDp.add(this.aDl);
        this.aDp.add(this.aDm);
        this.aDp.add(this.aDn);
        this.aDp.add(this.aDo);
        bdTypeListView.h(this.aDp);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.am> arrayList, com.baidu.tieba.tbadkCore.e eVar, boolean z, boolean z2) {
        setForumModel(eVar);
        this.TP = z2;
        bK(this.TP);
        this.aDr = z;
        bJ(this.aDr);
        A(arrayList);
        B(arrayList);
        this.aDd.setData(arrayList);
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.am> arrayList, com.baidu.tieba.tbadkCore.e eVar) {
        a(arrayList, eVar, this.aDr, this.TP);
    }

    private ArrayList<Integer> A(ArrayList<com.baidu.adp.widget.ListView.am> arrayList) {
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
                if (this.aDq != null && !this.aDq.containsValue(amVar)) {
                    this.aDq.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.w) amVar);
                }
            }
            i = i2 + 1;
        }
    }

    public void bA(boolean z) {
        if (this.aAZ != z) {
            this.aAZ = z;
            if (this.aDi != null) {
                this.aDi.bA(z);
            }
        }
    }

    public void bH(boolean z) {
        if (this.aDf != null) {
            this.aDf.bH(z);
        }
    }

    public boolean FR() {
        if (this.aDf != null) {
            return this.aDf.FR();
        }
        return false;
    }

    public void bI(boolean z) {
        if (this.aDe != null) {
            this.aDe.bI(z);
        }
    }

    public boolean FS() {
        if (this.aDe != null) {
            return this.aDe.FS();
        }
        return false;
    }

    public HashMap<Integer, com.baidu.tbadk.core.data.w> FT() {
        return this.aDq;
    }

    public void am(String str, String str2) {
        if (this.aDo != null) {
            this.aDo.am(str, str2);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        if (this.aDk != null) {
            this.aDk.h(onClickListener);
        }
    }

    public void i(View.OnClickListener onClickListener) {
        if (this.aDk != null) {
            this.aDk.i(onClickListener);
        }
        if (this.aDl != null) {
            this.aDl.i(onClickListener);
        }
    }

    public void FU() {
        if (this.aDd != null && this.aDd.getData() != null && this.aDd.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.am amVar : this.aDd.getData()) {
                if ((amVar instanceof com.baidu.tbadk.core.data.w) && ((com.baidu.tbadk.core.data.w) amVar).getIs_top() != 0) {
                    ((com.baidu.tbadk.core.data.w) amVar).parser_title();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aDd.getAdapter() instanceof com.baidu.adp.widget.ListView.k) {
            ((com.baidu.adp.widget.ListView.k) this.aDd.getAdapter()).notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aDe != null) {
            this.aDe.onChangeSkinType(i);
        }
        if (this.aDf != null) {
            this.aDf.onChangeSkinType(i);
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aDd.getAdapter() instanceof com.baidu.adp.widget.ListView.k) {
            ((com.baidu.adp.widget.ListView.k) this.aDd.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aDp != null && this.aDp.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aDp) {
                if (aVar instanceof bi) {
                    ((bi) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void setForumModel(com.baidu.tieba.tbadkCore.e eVar) {
        if (this.aDp != null && this.aDp.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aDp) {
                if (aVar instanceof bi) {
                    ((bi) aVar).e(eVar);
                }
            }
        }
    }

    public void a(ba baVar) {
        if (this.aDp != null && this.aDp.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aDp) {
                if (aVar instanceof bi) {
                    ((bi) aVar).a(baVar);
                }
            }
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.aDg = onClickListener;
        if (this.aDe != null) {
            this.aDe.j(onClickListener);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.aDh = onClickListener;
        if (this.aDf != null) {
            this.aDf.m(onClickListener);
        }
    }

    public int FV() {
        if (this.aDi != null) {
            return this.aDi.FV();
        }
        return 0;
    }

    public int Fe() {
        if (this.aDi != null) {
            return this.aDi.Fe();
        }
        return 0;
    }

    public int Ff() {
        if (this.aDi != null) {
            return this.aDi.Ff();
        }
        return 0;
    }

    public int Fg() {
        if (this.aDi != null) {
            return this.aDi.Fg();
        }
        return 0;
    }

    public int FW() {
        if (this.aDn != null) {
            return this.aDn.FW();
        }
        return 0;
    }

    public int FX() {
        if (this.aDn != null) {
            return this.aDn.FX();
        }
        return 0;
    }

    private void bJ(boolean z) {
        if (z) {
            if (this.aDe == null) {
                this.aDe = new cp(this.aDc);
                this.aDe.j(this.aDg);
            }
            if (this.aDd != null) {
                this.aDd.setPrePage(this.aDe);
            }
        } else if (this.aDe != null && this.aDd != null) {
            this.aDd.setPrePage(null);
        }
    }

    private void bK(boolean z) {
        if (z) {
            if (this.aDf == null) {
                this.aDf = new cf(this.aDc);
                this.aDf.m(this.aDh);
            }
            if (this.aDd != null) {
                this.aDd.setNextPage(this.aDf);
            }
        } else if (this.aDf != null && this.aDd != null) {
            this.aDd.setNextPage(null);
        }
    }

    public void a(com.baidu.adp.widget.ListView.an anVar) {
        if (this.aDp != null && this.aDp.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aDp) {
                if (aVar instanceof bi) {
                    ((bi) aVar).a(anVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ao aoVar) {
        if (this.aDp != null && this.aDp.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aDp) {
                if (aVar instanceof bi) {
                    ((bi) aVar).a(aoVar);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.am ay(int i) {
        if (this.aDd != null) {
            return this.aDd.ay(i);
        }
        return null;
    }

    private void B(ArrayList<com.baidu.adp.widget.ListView.am> arrayList) {
        int i;
        if (this.aDp != null && this.aDp.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.am> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().jr().getId() != com.baidu.tbadk.core.data.w.Ez.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            if (this.aDr) {
                i++;
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aDp) {
                if (aVar instanceof bi) {
                    ((bi) aVar).eG(i);
                }
            }
        }
    }
}
