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
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private e cVC;
    private BdTypeListView eka;
    private a gDe;

    public b(e eVar, BdTypeListView bdTypeListView) {
        this.cVC = eVar;
        this.eka = bdTypeListView;
        wM();
    }

    private void wM() {
        this.gDe = new a((TbPageContext) this.cVC, d.gDA);
        this.asE.add(this.gDe);
        this.eka.addAdapters(this.asE);
    }

    public void setData(List<m> list) {
        if (this.eka != null) {
            this.eka.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0508a interfaceC0508a) {
        this.gDe.setClickListener(interfaceC0508a);
    }
}
