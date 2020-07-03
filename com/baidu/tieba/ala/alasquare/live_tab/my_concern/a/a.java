package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aUP = new LinkedList();
    private b fpc;
    private c fpd;
    private g fpe;
    private f fpf;
    private d fpg;
    private e fph;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fpc = new b(tbPageContext);
        this.fpd = new c(tbPageContext);
        this.fpe = new g(tbPageContext);
        this.fpf = new f(tbPageContext);
        this.fpg = new d(tbPageContext);
        this.fph = new e(tbPageContext);
        this.fpd.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aPS() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aPS());
                }
            }
        });
        this.fpf.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aPS() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aPS());
                }
            }
        });
        this.aUP.add(this.fpc);
        this.aUP.add(this.fpd);
        this.aUP.add(this.fpe);
        this.aUP.add(this.fpf);
        this.aUP.add(this.fpg);
        this.aUP.add(this.fph);
    }

    public List<com.baidu.adp.widget.ListView.a> btV() {
        return this.aUP;
    }
}
