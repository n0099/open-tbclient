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
    private BdTypeListView gzb;
    private a jAP;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.eVB = fVar;
        this.gzb = bdTypeListView;
        Kw();
    }

    private void Kw() {
        this.jAP = new a((TbPageContext) this.eVB, d.jBl);
        this.bns.add(this.jAP);
        this.gzb.addAdapters(this.bns);
    }

    public void setData(List<n> list) {
        if (this.gzb != null) {
            this.gzb.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0730a interfaceC0730a) {
        this.jAP.setClickListener(interfaceC0730a);
    }
}
