package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private com.baidu.adp.base.e cRq;
    private BdTypeListView efM;
    private f ewd;
    private c ewe;
    private a ewf;
    private b ewg;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.cRq = eVar;
        this.efM = bdTypeListView;
        m24if(z);
    }

    /* renamed from: if  reason: not valid java name */
    private void m24if(boolean z) {
        if (z) {
            this.ewe = new c((TbPageContext) this.cRq, com.baidu.tieba.ala.gamelist.b.a.enP);
            this.aoz.add(this.ewe);
        } else {
            this.ewd = new f((TbPageContext) this.cRq, com.baidu.tieba.ala.gamelist.b.a.enP);
            this.aoz.add(this.ewd);
        }
        this.ewf = new a((TbPageContext) this.cRq, com.baidu.tieba.ala.frsgamelive.b.a.ewi);
        this.ewg = new b((TbPageContext) this.cRq, com.baidu.tieba.ala.frsgamelive.b.b.ewj);
        this.aoz.add(this.ewf);
        this.aoz.add(this.ewg);
        this.efM.addAdapters(this.aoz);
    }

    public void setDatas(List<m> list) {
        if (this.efM != null) {
            this.efM.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.ewd != null) {
            this.ewd.a(dVar);
        }
        if (this.ewe != null) {
            this.ewe.a(dVar);
        }
    }
}
