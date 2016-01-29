package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.collect.MyCollectFrsActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class fg {
    private BdTypeListView aXu;
    private df bhb;
    private ec bhi;
    private dc bhv;
    private MyCollectFrsActivity bmb;
    private List<com.baidu.adp.widget.ListView.a> aXX = new LinkedList();
    private boolean bez = false;
    private Set bmc = new HashSet();

    public fg(MyCollectFrsActivity myCollectFrsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.bmb = myCollectFrsActivity;
        this.aXu = bdTypeListView;
        a(bdTypeListView);
        ck(z);
    }

    public Set QC() {
        return this.bmc;
    }

    public void ck(boolean z) {
        if (this.bez != z) {
            this.bez = z;
            if (this.bhb != null) {
                this.bhb.ck(z);
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        this.bhb = new df(this.bmb, com.baidu.tbadk.core.data.ah.WG);
        this.bhi = new ec(this.bmb, com.baidu.tbadk.core.data.ab.Wt);
        this.bhv = new dc(this.bmb, dd.bkd);
        this.aXX.add(this.bhb);
        this.aXX.add(this.bhi);
        this.aXX.add(this.bhv);
        bdTypeListView.g(this.aXX);
        this.bmc.add(com.baidu.tbadk.core.data.ah.WG);
        this.bmc.add(com.baidu.tbadk.core.data.ab.Wt);
        this.bmc.add(dd.bkd);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    aVar.a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    aVar.a(wVar);
                }
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
            if (aVar instanceof bv) {
                ((bv) aVar).release();
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aXu.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aXu.getAdapter()).notifyDataSetChanged();
        }
    }

    public int Pz() {
        if (this.bhb != null) {
            return this.bhb.Pz();
        }
        return 0;
    }

    public int OL() {
        if (this.bhb != null) {
            return this.bhb.OL();
        }
        return 0;
    }

    public int PB() {
        if (this.bhb != null) {
            return this.bhb.PB();
        }
        return 0;
    }

    public void b(bh bhVar) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).a(bhVar);
                }
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(oVar);
        this.aXu.setData(arrayList);
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).a(oVar);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aXX != null && this.aXX.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aXX) {
                if (aVar instanceof bv) {
                    ((bv) aVar).setFromCDN(z);
                }
            }
        }
    }
}
