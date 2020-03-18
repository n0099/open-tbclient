package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asP = new LinkedList();
    private d enA;
    private e enB;
    private b enw;
    private c enx;
    private g eny;
    private f enz;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.enw = new b(tbPageContext);
        this.enx = new c(tbPageContext);
        this.eny = new g(tbPageContext);
        this.enz = new f(tbPageContext);
        this.enA = new d(tbPageContext);
        this.enB = new e(tbPageContext);
        this.enx.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aAj() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aAj());
                }
            }
        });
        this.enz.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aAj() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aAj());
                }
            }
        });
        this.asP.add(this.enw);
        this.asP.add(this.enx);
        this.asP.add(this.eny);
        this.asP.add(this.enz);
        this.asP.add(this.enA);
        this.asP.add(this.enB);
    }

    public List<com.baidu.adp.widget.ListView.a> bcJ() {
        return this.asP;
    }
}
