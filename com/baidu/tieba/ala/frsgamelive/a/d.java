package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private com.baidu.adp.base.e efO;
    private BdTypeMultiColumnListView fXe;
    private e fXf;
    private h fXg;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.efO = eVar;
        this.fXe = bdTypeMultiColumnListView;
        Jv();
    }

    private void Jv() {
        this.fXf = new e((TbPageContext) this.efO, com.baidu.tieba.ala.frsgamelive.b.c.fXo);
        this.fXg = new h((TbPageContext) this.efO, com.baidu.tieba.ala.frsgamelive.b.c.fXp);
        this.bbw.add(this.fXf);
        this.bbw.add(this.fXg);
        this.fXe.addAdapters(this.bbw);
    }

    public void setDatas(List<q> list) {
        if (this.fXe != null) {
            this.fXe.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.e eVar) {
        if (this.fXf != null) {
            this.fXf.a(eVar);
        }
        if (this.fXg != null) {
            this.fXg.a(eVar);
        }
    }
}
