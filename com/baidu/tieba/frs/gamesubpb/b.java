package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private e cfJ;
    private BdTypeListView dvB;
    private a fKw;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.cfJ = eVar;
        this.dvB = bdTypeListView;
        sX();
    }

    private void sX() {
        this.fKw = new a((TbPageContext) this.cfJ, d.fKS);
        this.agQ.add(this.fKw);
        this.dvB.addAdapters(this.agQ);
    }

    public void setData(List<m> list) {
        if (this.dvB != null) {
            this.dvB.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0414a interfaceC0414a) {
        this.fKw.setClickListener(interfaceC0414a);
    }
}
