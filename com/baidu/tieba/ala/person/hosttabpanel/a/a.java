package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private List<AbsDelegateAdapter> bjZ = new ArrayList();
    private BdTypeListView bkb;
    private b hRf;
    private c hRg;
    private e hRh;
    private f hRi;
    private d hRj;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.bkb = bdTypeListView;
        IY();
    }

    private void IY() {
        this.hRf = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.hRm);
        this.hRg = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.hRp);
        this.hRh = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.hRr);
        this.hRi = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.hRs);
        this.hRj = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.hRq);
        this.bjZ.add(this.hRf);
        this.bjZ.add(this.hRg);
        this.bjZ.add(this.hRh);
        this.bjZ.add(this.hRi);
        this.bjZ.add(this.hRj);
        this.bkb.addAdapters(this.bjZ);
    }

    public void onDestroy() {
        if (this.hRf != null) {
            this.hRf.onDestroy();
        }
        if (this.hRg != null) {
            this.hRg.onDestroy();
        }
    }
}
