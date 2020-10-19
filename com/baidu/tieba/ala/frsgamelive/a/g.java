package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private com.baidu.adp.base.e eul;
    private BdTypeListView fSo;
    private f gmM;
    private c gmN;
    private a gmO;
    private b gmP;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.eul = eVar;
        this.fSo = bdTypeListView;
        lM(z);
    }

    private void lM(boolean z) {
        if (z) {
            this.gmN = new c((TbPageContext) this.eul, com.baidu.tieba.ala.gamelist.b.a.gbP);
            this.bhH.add(this.gmN);
        } else {
            this.gmM = new f((TbPageContext) this.eul, com.baidu.tieba.ala.gamelist.b.a.gbP);
            this.bhH.add(this.gmM);
        }
        this.gmO = new a((TbPageContext) this.eul, com.baidu.tieba.ala.frsgamelive.b.a.gmR);
        this.gmP = new b((TbPageContext) this.eul, com.baidu.tieba.ala.frsgamelive.b.b.gmS);
        this.bhH.add(this.gmO);
        this.bhH.add(this.gmP);
        this.fSo.addAdapters(this.bhH);
    }

    public void setDatas(List<q> list) {
        if (this.fSo != null) {
            this.fSo.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.f fVar) {
        if (this.gmM != null) {
            this.gmM.a(fVar);
        }
        if (this.gmN != null) {
            this.gmN.a(fVar);
        }
    }
}
