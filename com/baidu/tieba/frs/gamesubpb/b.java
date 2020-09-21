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
    private final List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private e eid;
    private BdTypeListView fGf;
    private a irR;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.eid = eVar;
        this.fGf = bdTypeListView;
        JZ();
    }

    private void JZ() {
        this.irR = new a((TbPageContext) this.eid, d.isn);
        this.bdV.add(this.irR);
        this.fGf.addAdapters(this.bdV);
    }

    public void setData(List<q> list) {
        if (this.fGf != null) {
            this.fGf.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0682a interfaceC0682a) {
        this.irR.setClickListener(interfaceC0682a);
    }
}
