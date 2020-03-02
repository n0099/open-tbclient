package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private e cVD;
    private BdTypeListView ekb;
    private a gDg;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.cVD = eVar;
        this.ekb = bdTypeListView;
        wM();
    }

    private void wM() {
        this.gDg = new a((TbPageContext) this.cVD, d.gDC);
        this.asE.add(this.gDg);
        this.ekb.addAdapters(this.asE);
    }

    public void setData(List<m> list) {
        if (this.ekb != null) {
            this.ekb.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0508a interfaceC0508a) {
        this.gDg.setClickListener(interfaceC0508a);
    }
}
