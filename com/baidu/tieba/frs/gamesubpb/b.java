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
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private e dWk;
    private BdTypeListView frv;
    private a hWA;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.dWk = eVar;
        this.frv = bdTypeListView;
        DS();
    }

    private void DS() {
        this.hWA = new a((TbPageContext) this.dWk, d.hWW);
        this.aWf.add(this.hWA);
        this.frv.addAdapters(this.aWf);
    }

    public void setData(List<q> list) {
        if (this.frv != null) {
            this.frv.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0634a interfaceC0634a) {
        this.hWA.setClickListener(interfaceC0634a);
    }
}
