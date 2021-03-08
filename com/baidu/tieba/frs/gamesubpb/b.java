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
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private f eXa;
    private BdTypeListView gAY;
    private a jCM;

    public b(f fVar, BdTypeListView bdTypeListView) {
        this.eXa = fVar;
        this.gAY = bdTypeListView;
        Kz();
    }

    private void Kz() {
        this.jCM = new a((TbPageContext) this.eXa, d.jDi);
        this.boS.add(this.jCM);
        this.gAY.addAdapters(this.boS);
    }

    public void setData(List<n> list) {
        if (this.gAY != null) {
            this.gAY.setData(list);
        }
    }

    public void setClickListener(a.InterfaceC0737a interfaceC0737a) {
        this.jCM.setClickListener(interfaceC0737a);
    }
}
