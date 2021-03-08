package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private com.baidu.adp.base.f eXa;
    private BdTypeListView gAY;
    private f gWY;
    private c gWZ;
    private a gXa;
    private b gXb;

    public g(com.baidu.adp.base.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.eXa = fVar;
        this.gAY = bdTypeListView;
        ni(z);
    }

    private void ni(boolean z) {
        if (z) {
            this.gWZ = new c((TbPageContext) this.eXa, com.baidu.tieba.ala.gamelist.b.a.gKC);
            this.boS.add(this.gWZ);
        } else {
            this.gWY = new f((TbPageContext) this.eXa, com.baidu.tieba.ala.gamelist.b.a.gKC);
            this.boS.add(this.gWY);
        }
        this.gXa = new a((TbPageContext) this.eXa, com.baidu.tieba.ala.frsgamelive.b.a.gXd);
        this.gXb = new b((TbPageContext) this.eXa, com.baidu.tieba.ala.frsgamelive.b.b.gXe);
        this.boS.add(this.gXa);
        this.boS.add(this.gXb);
        this.gAY.addAdapters(this.boS);
    }

    public void setDatas(List<n> list) {
        if (this.gAY != null) {
            this.gAY.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.h hVar) {
        if (this.gWY != null) {
            this.gWY.a(hVar);
        }
        if (this.gWZ != null) {
            this.gWZ.a(hVar);
        }
    }
}
