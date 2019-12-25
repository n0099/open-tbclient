package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private e cRq;
    private BdTypeListView efM;
    private a gxU;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.cRq = eVar;
        this.efM = bdTypeListView;
        uR();
    }

    private void uR() {
        this.gxU = new a((TbPageContext) this.cRq, d.gyq);
        this.aoz.add(this.gxU);
        this.efM.addAdapters(this.aoz);
    }

    public void setData(List<m> list) {
        if (this.efM != null) {
            this.efM.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0497a interfaceC0497a) {
        this.gxU.setClickListener(interfaceC0497a);
    }
}
