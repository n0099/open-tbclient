package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private e eNZ;
    private BdTypeListView gpX;
    private a jnp;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.eNZ = eVar;
        this.gpX = bdTypeListView;
        Nt();
    }

    private void Nt() {
        this.jnp = new a((TbPageContext) this.eNZ, d.jnL);
        this.bnf.add(this.jnp);
        this.gpX.addAdapters(this.bnf);
    }

    public void setData(List<q> list) {
        if (this.gpX != null) {
            this.gpX.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0747a interfaceC0747a) {
        this.jnp.setClickListener(interfaceC0747a);
    }
}
