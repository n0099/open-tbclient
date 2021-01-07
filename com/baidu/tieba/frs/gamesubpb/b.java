package com.baidu.tieba.frs.gamesubpb;

import com.baidu.adp.base.f;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private f eXW;
    private BdTypeListView gAY;
    private a jzP;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.eXW = fVar;
        this.gAY = bdTypeListView;
        MT();
    }

    private void MT() {
        this.jzP = new a((TbPageContext) this.eXW, d.jAl);
        this.boM.add(this.jzP);
        this.gAY.addAdapters(this.boM);
    }

    public void setData(List<n> list) {
        if (this.gAY != null) {
            this.gAY.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0747a interfaceC0747a) {
        this.jzP.setClickListener(interfaceC0747a);
    }
}
