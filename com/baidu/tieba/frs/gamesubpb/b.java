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
    private final List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private e cVE;
    private BdTypeListView eko;
    private a gDs;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.cVE = eVar;
        this.eko = bdTypeListView;
        wM();
    }

    private void wM() {
        this.gDs = new a((TbPageContext) this.cVE, d.gDO);
        this.asF.add(this.gDs);
        this.eko.addAdapters(this.asF);
    }

    public void setData(List<m> list) {
        if (this.eko != null) {
            this.eko.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0508a interfaceC0508a) {
        this.gDs.setClickListener(interfaceC0508a);
    }
}
