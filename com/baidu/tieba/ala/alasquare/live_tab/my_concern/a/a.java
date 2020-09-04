package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbw = new LinkedList();
    private b fFK;
    private c fFL;
    private g fFM;
    private f fFN;
    private d fFO;
    private e fFP;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fFK = new b(tbPageContext);
        this.fFL = new c(tbPageContext);
        this.fFM = new g(tbPageContext);
        this.fFN = new f(tbPageContext);
        this.fFO = new d(tbPageContext);
        this.fFP = new e(tbPageContext);
        this.fFL.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bce() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bce());
                }
            }
        });
        this.fFN.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bce() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bce());
                }
            }
        });
        this.bbw.add(this.fFK);
        this.bbw.add(this.fFL);
        this.bbw.add(this.fFM);
        this.bbw.add(this.fFN);
        this.bbw.add(this.fFO);
        this.bbw.add(this.fFP);
    }

    public List<com.baidu.adp.widget.ListView.a> bGf() {
        return this.bbw;
    }
}
