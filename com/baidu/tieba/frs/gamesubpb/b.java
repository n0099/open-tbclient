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
    private final List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private e eCK;
    private BdTypeListView gcr;
    private a iTg;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.eCK = eVar;
        this.gcr = bdTypeListView;
        Ly();
    }

    private void Ly() {
        this.iTg = new a((TbPageContext) this.eCK, d.iTC);
        this.bje.add(this.iTg);
        this.gcr.addAdapters(this.bje);
    }

    public void setData(List<q> list) {
        if (this.gcr != null) {
            this.gcr.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0716a interfaceC0716a) {
        this.iTg.setClickListener(interfaceC0716a);
    }
}
