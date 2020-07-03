package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private com.baidu.adp.base.e dPR;
    private BdTypeMultiColumnListView fFH;
    private e fFI;
    private h fFJ;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.dPR = eVar;
        this.fFH = bdTypeMultiColumnListView;
        Dz();
    }

    private void Dz() {
        this.fFI = new e((TbPageContext) this.dPR, com.baidu.tieba.ala.frsgamelive.b.c.fFR);
        this.fFJ = new h((TbPageContext) this.dPR, com.baidu.tieba.ala.frsgamelive.b.c.fFS);
        this.aUP.add(this.fFI);
        this.aUP.add(this.fFJ);
        this.fFH.addAdapters(this.aUP);
    }

    public void setDatas(List<q> list) {
        if (this.fFH != null) {
            this.fFH.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.fFI != null) {
            this.fFI.a(dVar);
        }
        if (this.fFJ != null) {
            this.fFJ.a(dVar);
        }
    }
}
