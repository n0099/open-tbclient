package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private e dPR;
    private BdTypeListView fml;
    private a hQB;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.dPR = eVar;
        this.fml = bdTypeListView;
        Dz();
    }

    private void Dz() {
        this.hQB = new a((TbPageContext) this.dPR, d.hQX);
        this.aUP.add(this.hQB);
        this.fml.addAdapters(this.aUP);
    }

    public void setData(List<q> list) {
        if (this.fml != null) {
            this.fml.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0624a interfaceC0624a) {
        this.hQB.setClickListener(interfaceC0624a);
    }
}
