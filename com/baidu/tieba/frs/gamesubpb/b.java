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
    private final List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private e cVR;
    private BdTypeListView ekE;
    private a gEq;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.cVR = eVar;
        this.ekE = bdTypeListView;
        wR();
    }

    private void wR() {
        this.gEq = new a((TbPageContext) this.cVR, d.gEM);
        this.asP.add(this.gEq);
        this.ekE.addAdapters(this.asP);
    }

    public void setData(List<m> list) {
        if (this.ekE != null) {
            this.ekE.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0508a interfaceC0508a) {
        this.gEq.setClickListener(interfaceC0508a);
    }
}
