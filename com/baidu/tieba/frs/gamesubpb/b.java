package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.f;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private f eVB;
    private BdTypeListView gzp;
    private a jBd;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.eVB = fVar;
        this.gzp = bdTypeListView;
        Kw();
    }

    private void Kw() {
        this.jBd = new a((TbPageContext) this.eVB, d.jBz);
        this.bns.add(this.jBd);
        this.gzp.addAdapters(this.bns);
    }

    public void setData(List<n> list) {
        if (this.gzp != null) {
            this.gzp.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0731a interfaceC0731a) {
        this.jBd.setClickListener(interfaceC0731a);
    }
}
