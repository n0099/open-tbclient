package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbu = new LinkedList();
    private b fFG;
    private c fFH;
    private g fFI;
    private f fFJ;
    private d fFK;
    private e fFL;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fFG = new b(tbPageContext);
        this.fFH = new c(tbPageContext);
        this.fFI = new g(tbPageContext);
        this.fFJ = new f(tbPageContext);
        this.fFK = new d(tbPageContext);
        this.fFL = new e(tbPageContext);
        this.fFH.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bce() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bce());
                }
            }
        });
        this.fFJ.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bce() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bce());
                }
            }
        });
        this.bbu.add(this.fFG);
        this.bbu.add(this.fFH);
        this.bbu.add(this.fFI);
        this.bbu.add(this.fFJ);
        this.bbu.add(this.fFK);
        this.bbu.add(this.fFL);
    }

    public List<com.baidu.adp.widget.ListView.a> bGe() {
        return this.bbu;
    }
}
