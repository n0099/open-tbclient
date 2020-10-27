package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<AbsDelegateAdapter> bje = new ArrayList();
    private BdTypeListView bjg;
    private b hup;
    private c huq;
    private e hur;
    private f hus;
    private d hut;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.bjg = bdTypeListView;
        Ly();
    }

    private void Ly() {
        this.hup = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.huw);
        this.huq = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.huz);
        this.hur = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.huB);
        this.hus = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.huC);
        this.hut = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.huA);
        this.bje.add(this.hup);
        this.bje.add(this.huq);
        this.bje.add(this.hur);
        this.bje.add(this.hus);
        this.bje.add(this.hut);
        this.bjg.addAdapters(this.bje);
    }

    public void onDestroy() {
        if (this.hup != null) {
            this.hup.onDestroy();
        }
        if (this.huq != null) {
            this.huq.onDestroy();
        }
    }
}
