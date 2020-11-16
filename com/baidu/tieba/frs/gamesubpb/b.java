package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private e eGT;
    private BdTypeListView ghN;
    private a iZP;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.eGT = eVar;
        this.ghN = bdTypeListView;
        Lp();
    }

    private void Lp() {
        this.iZP = new a((TbPageContext) this.eGT, d.jal);
        this.biN.add(this.iZP);
        this.ghN.addAdapters(this.biN);
    }

    public void setData(List<q> list) {
        if (this.ghN != null) {
            this.ghN.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0731a interfaceC0731a) {
        this.iZP.setClickListener(interfaceC0731a);
    }
}
