package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aMj = new LinkedList();
    private b eQZ;
    private c eRa;
    private g eRb;
    private f eRc;
    private d eRd;
    private e eRe;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.eQZ = new b(tbPageContext);
        this.eRa = new c(tbPageContext);
        this.eRb = new g(tbPageContext);
        this.eRc = new f(tbPageContext);
        this.eRd = new d(tbPageContext);
        this.eRe = new e(tbPageContext);
        this.eRa.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aIu() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aIu());
                }
            }
        });
        this.eRc.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aIu() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aIu());
                }
            }
        });
        this.aMj.add(this.eQZ);
        this.aMj.add(this.eRa);
        this.aMj.add(this.eRb);
        this.aMj.add(this.eRc);
        this.aMj.add(this.eRd);
        this.aMj.add(this.eRe);
    }

    public List<com.baidu.adp.widget.ListView.a> bly() {
        return this.aMj;
    }
}
