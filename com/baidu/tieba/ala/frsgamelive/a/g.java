package com.baidu.tieba.ala.frsgamelive.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    private final List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private com.baidu.adp.base.e cRA;
    private BdTypeListView efW;
    private f exo;
    private c exp;
    private a exq;
    private b exr;

    public g(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView, boolean z) {
        this.cRA = eVar;
        this.efW = bdTypeListView;
        ip(z);
    }

    private void ip(boolean z) {
        if (z) {
            this.exp = new c((TbPageContext) this.cRA, com.baidu.tieba.ala.gamelist.b.a.epd);
            this.apl.add(this.exp);
        } else {
            this.exo = new f((TbPageContext) this.cRA, com.baidu.tieba.ala.gamelist.b.a.epd);
            this.apl.add(this.exo);
        }
        this.exq = new a((TbPageContext) this.cRA, com.baidu.tieba.ala.frsgamelive.b.a.exu);
        this.exr = new b((TbPageContext) this.cRA, com.baidu.tieba.ala.frsgamelive.b.b.exv);
        this.apl.add(this.exq);
        this.apl.add(this.exr);
        this.efW.addAdapters(this.apl);
    }

    public void setDatas(List<m> list) {
        if (this.efW != null) {
            this.efW.setData(list);
        }
    }

    public void b(com.baidu.tieba.ala.d dVar) {
        if (this.exo != null) {
            this.exo.a(dVar);
        }
        if (this.exp != null) {
            this.exp.a(dVar);
        }
    }
}
