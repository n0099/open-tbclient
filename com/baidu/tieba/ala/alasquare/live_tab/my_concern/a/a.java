package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asE = new LinkedList();
    private b emQ;
    private c emR;
    private g emS;
    private f emT;
    private d emU;
    private e emV;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.emQ = new b(tbPageContext);
        this.emR = new c(tbPageContext);
        this.emS = new g(tbPageContext);
        this.emT = new f(tbPageContext);
        this.emU = new d(tbPageContext);
        this.emV = new e(tbPageContext);
        this.emR.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aAg() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aAg());
                }
            }
        });
        this.emT.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aAg() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aAg());
                }
            }
        });
        this.asE.add(this.emQ);
        this.asE.add(this.emR);
        this.asE.add(this.emS);
        this.asE.add(this.emT);
        this.asE.add(this.emU);
        this.asE.add(this.emV);
    }

    public List<com.baidu.adp.widget.ListView.a> bcE() {
        return this.asE;
    }
}
