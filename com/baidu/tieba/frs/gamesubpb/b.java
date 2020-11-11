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
    private final List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private e eIz;
    private BdTypeListView gih;
    private a iZd;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.eIz = eVar;
        this.gih = bdTypeListView;
        LY();
    }

    private void LY() {
        this.iZd = new a((TbPageContext) this.eIz, d.iZz);
        this.bky.add(this.iZd);
        this.gih.addAdapters(this.bky);
    }

    public void setData(List<q> list) {
        if (this.gih != null) {
            this.gih.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0730a interfaceC0730a) {
        this.iZd.setClickListener(interfaceC0730a);
    }
}
