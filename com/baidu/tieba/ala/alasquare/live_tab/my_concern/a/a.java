package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bje = new LinkedList();
    private b gfr;
    private c gfs;
    private g gft;
    private f gfu;
    private d gfv;
    private e gfw;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gfr = new b(tbPageContext);
        this.gfs = new c(tbPageContext);
        this.gft = new g(tbPageContext);
        this.gfu = new f(tbPageContext);
        this.gfv = new d(tbPageContext);
        this.gfw = new e(tbPageContext);
        this.gfs.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bhz() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bhz());
                }
            }
        });
        this.gfu.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bhz() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bhz());
                }
            }
        });
        this.bje.add(this.gfr);
        this.bje.add(this.gfs);
        this.bje.add(this.gft);
        this.bje.add(this.gfu);
        this.bje.add(this.gfv);
        this.bje.add(this.gfw);
    }

    public List<com.baidu.adp.widget.ListView.a> bMJ() {
        return this.bje;
    }
}
