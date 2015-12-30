package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.collect.MyCollectFrsActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class ew {
    private BdTypeListView aVi;
    private cy beG;
    private dx beM;
    private cv beY;
    private MyCollectFrsActivity bjg;
    private List<com.baidu.adp.widget.ListView.a> aVK = new LinkedList();
    private boolean bck = false;
    private Set bjh = new HashSet();

    public ew(MyCollectFrsActivity myCollectFrsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.bjg = myCollectFrsActivity;
        this.aVi = bdTypeListView;
        a(bdTypeListView);
        cl(z);
    }

    public Set OA() {
        return this.bjh;
    }

    public void cl(boolean z) {
        if (this.bck != z) {
            this.bck = z;
            if (this.beG != null) {
                this.beG.cl(z);
            }
        }
    }

    private void a(BdTypeListView bdTypeListView) {
        this.beG = new cy(this.bjg, com.baidu.tbadk.core.data.z.WC);
        this.beM = new dx(this.bjg, com.baidu.tbadk.core.data.w.Wx);
        this.beY = new cv(this.bjg, cw.bho);
        this.aVK.add(this.beG);
        this.aVK.add(this.beM);
        this.aVK.add(this.beY);
        bdTypeListView.g(this.aVK);
        this.bjh.add(com.baidu.tbadk.core.data.z.WC);
        this.bjh.add(com.baidu.tbadk.core.data.w.Wx);
        this.bjh.add(cw.bho);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    aVar.a(vVar);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    aVar.a(wVar);
                }
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
            if (aVar instanceof bp) {
                ((bp) aVar).release();
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVi.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVi.getAdapter()).notifyDataSetChanged();
        }
    }

    public int Nz() {
        if (this.beG != null) {
            return this.beG.Nz();
        }
        return 0;
    }

    public int MQ() {
        if (this.beG != null) {
            return this.beG.MQ();
        }
        return 0;
    }

    public int NB() {
        if (this.beG != null) {
            return this.beG.NB();
        }
        return 0;
    }

    public void b(bf bfVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).a(bfVar);
                }
            }
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, com.baidu.tieba.tbadkCore.p pVar) {
        a(pVar);
        this.aVi.setData(arrayList);
    }

    public void a(com.baidu.tieba.tbadkCore.p pVar) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).a(pVar);
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        if (this.aVK != null && this.aVK.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aVK) {
                if (aVar instanceof bp) {
                    ((bp) aVar).setFromCDN(z);
                }
            }
        }
    }
}
