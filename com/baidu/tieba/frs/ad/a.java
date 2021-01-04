package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private FrsADFragment jli;
    private BdTypeRecyclerView jlj;
    private d jlk;
    private r jll;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jli = frsADFragment;
        this.jlj = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.jlk = new d(this.jli.getPageContext(), c.jly, this.jli.getUniqueId());
        this.jll = new r(this.jli.getPageContext(), s.jiG);
        this.boM.add(this.jlk);
        this.boM.add(this.jll);
        cHC();
        this.jlj.addAdapters(this.boM);
    }

    public void setData(ArrayList<n> arrayList) {
        this.jlj.setData(arrayList);
    }

    private void cHC() {
        if (!x.isEmpty(this.boM) && this.jli != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.jli.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.jlj.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void a(w wVar) {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar != null && (aVar instanceof k)) {
                    aVar.a(wVar);
                }
            }
        }
    }
}
