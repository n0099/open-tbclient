package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private e efK;
    private BdTypeListView fCP;
    private a ikJ;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.efK = eVar;
        this.fCP = bdTypeListView;
        Jv();
    }

    private void Jv() {
        this.ikJ = new a((TbPageContext) this.efK, d.ilf);
        this.bbu.add(this.ikJ);
        this.fCP.addAdapters(this.bbu);
    }

    public void setData(List<q> list) {
        if (this.fCP != null) {
            this.fCP.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0685a interfaceC0685a) {
        this.ikJ.setClickListener(interfaceC0685a);
    }
}
