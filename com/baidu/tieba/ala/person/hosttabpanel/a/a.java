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
    private b fqC;
    private c fqD;
    private e fqE;
    private f fqF;
    private d fqG;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.asG = bdTypeListView;
        wM();
    }

    private void wM() {
        this.fqC = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.fqJ);
        this.fqD = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.fqM);
        this.fqE = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.fqO);
        this.fqF = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.fqP);
        this.fqG = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.fqN);
        this.asE.add(this.fqC);
        this.asE.add(this.fqD);
        this.asE.add(this.fqE);
        this.asE.add(this.fqF);
        this.asE.add(this.fqG);
        this.asG.addAdapters(this.asE);
    }

    public void onDestroy() {
        if (this.fqC != null) {
            this.fqC.onDestroy();
        }
        if (this.fqD != null) {
            this.fqD.onDestroy();
        }
    }
}
