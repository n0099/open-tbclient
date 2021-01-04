package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private com.baidu.adp.base.f eXW;
    private BdTypeListView gAY;
    private f gWX;
    private c gWY;
    private a gWZ;
    private b gXa;

    public g(com.baidu.adp.base.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.eXW = fVar;
        this.gAY = bdTypeListView;
        nh(z);
    }

    private void nh(boolean z) {
        if (z) {
            this.gWY = new c((TbPageContext) this.eXW, com.baidu.tieba.ala.gamelist.b.a.gKB);
            this.boM.add(this.gWY);
        } else {
            this.gWX = new f((TbPageContext) this.eXW, com.baidu.tieba.ala.gamelist.b.a.gKB);
            this.boM.add(this.gWX);
        }
        this.gWZ = new a((TbPageContext) this.eXW, com.baidu.tieba.ala.frsgamelive.b.a.gXc);
        this.gXa = new b((TbPageContext) this.eXW, com.baidu.tieba.ala.frsgamelive.b.b.gXd);
        this.boM.add(this.gWZ);
        this.boM.add(this.gXa);
        this.gAY.addAdapters(this.boM);
    }

    public void setDatas(List<n> list) {
        if (this.gAY != null) {
            this.gAY.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.g gVar) {
        if (this.gWX != null) {
            this.gWX.a(gVar);
        }
        if (this.gWY != null) {
            this.gWY.a(gVar);
        }
    }
}
