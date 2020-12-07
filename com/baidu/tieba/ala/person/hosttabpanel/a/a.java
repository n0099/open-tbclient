package com.baidu.tieba.ala.person.hosttabpanel.a;

import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<AbsDelegateAdapter> bnf = new ArrayList();
    private BdTypeListView bnh;
    private e hJA;
    private f hJB;
    private d hJC;
    private b hJy;
    private c hJz;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        this.mPageContext = tbPageContext;
        this.bnh = bdTypeListView;
        Nt();
    }

    private void Nt() {
        this.hJy = new b(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.a.hJF);
        this.hJz = new c(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.b.hJI);
        this.hJA = new e(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.d.hJK);
        this.hJB = new f(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.e.hJL);
        this.hJC = new d(this.mPageContext, com.baidu.tieba.ala.person.hosttabpanel.b.c.hJJ);
        this.bnf.add(this.hJy);
        this.bnf.add(this.hJz);
        this.bnf.add(this.hJA);
        this.bnf.add(this.hJB);
        this.bnf.add(this.hJC);
        this.bnh.addAdapters(this.bnf);
    }

    public void onDestroy() {
        if (this.hJy != null) {
            this.hJy.onDestroy();
        }
        if (this.hJz != null) {
            this.hJz.onDestroy();
        }
    }
}
