package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.collect.MyCollectFrsActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class ev {
    private BdTypeListView aRs;
    private cv baH;
    private dx baN;
    private cs baZ;
    private MyCollectFrsActivity bfn;
    private List<com.baidu.adp.widget.ListView.a> aRI = new LinkedList();
    private boolean aYl = false;
    private Set bfo = new HashSet();

    public ev(MyCollectFrsActivity myCollectFrsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.bfn = myCollectFrsActivity;
        this.aRs = bdTypeListView;
        a(bdTypeListView);
        ck(z);
    }

    public Set Oh() {
        return this.bfo;
    }

    public void ck(boolean z) {
        if (this.aYl != z) {
            this.aYl = z;
            if (this.baH != null) {
                this.baH.ck(z);
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        this.baH = new cv(this.bfn, com.baidu.tbadk.core.data.z.Wc);
        this.baN = new dx(this.bfn, com.baidu.tbadk.core.data.w.VX);
        this.baZ = new cs(this.bfn, ct.bdo);
        this.aRI.add(this.baH);
        this.aRI.add(this.baN);
        this.aRI.add(this.baZ);
        bdTypeListView.g(this.aRI);
        this.bfo.add(com.baidu.tbadk.core.data.z.Wc);
        this.bfo.add(com.baidu.tbadk.core.data.w.VX);
        this.bfo.add(ct.bdo);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    aVar.a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    aVar.a(wVar);
                }
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
            if (aVar instanceof bm) {
                ((bm) aVar).release();
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aRs.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aRs.getAdapter()).notifyDataSetChanged();
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

    public int Ni() {
        if (this.baH != null) {
            return this.baH.Ni();
        }
        return 0;
    }

    public void b(bc bcVar) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).a(bcVar);
                }
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.p pVar) {
        a(pVar);
        this.aRs.setData(arrayList);
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

    public void setFromCDN(boolean z) {
        if (this.aRI != null && this.aRI.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof bm) {
                    ((bm) aVar).setFromCDN(z);
                }
            }
        }
    }
}
