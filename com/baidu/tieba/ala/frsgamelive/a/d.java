package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private final List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private com.baidu.adp.base.e cRA;
    private BdTypeMultiColumnListView exl;
    private e exm;
    private h exn;

    public d(com.baidu.adp.base.e eVar, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        this.cRA = eVar;
        this.exl = bdTypeMultiColumnListView;
        vi();
    }

    private void vi() {
        this.exm = new e((TbPageContext) this.cRA, com.baidu.tieba.ala.frsgamelive.b.c.exw);
        this.exn = new h((TbPageContext) this.cRA, com.baidu.tieba.ala.frsgamelive.b.c.exx);
        this.apl.add(this.exm);
        this.apl.add(this.exn);
        this.exl.addAdapters(this.apl);
    }

    public void setDatas(List<m> list) {
        if (this.exl != null) {
            this.exl.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.exm != null) {
            this.exm.a(dVar);
        }
        if (this.exn != null) {
            this.exn.a(dVar);
        }
    }
}
