package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<AbsDelegateAdapter> asE = new ArrayList();
    private BdTypeListView asG;
    private b fqB;
    private c fqC;
    private e fqD;
    private f fqE;
    private d fqF;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.asG = bdTypeListView;
        wM();
    }

    private void wM() {
        this.fqB = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.fqI);
        this.fqC = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.fqL);
        this.fqD = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.fqN);
        this.fqE = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.fqO);
        this.fqF = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.fqM);
        this.asE.add(this.fqB);
        this.asE.add(this.fqC);
        this.asE.add(this.fqD);
        this.asE.add(this.fqE);
        this.asE.add(this.fqF);
        this.asG.addAdapters(this.asE);
    }

    public void onDestroy() {
        if (this.fqB != null) {
            this.fqB.onDestroy();
        }
        if (this.fqC != null) {
            this.fqC.onDestroy();
        }
    }
}
