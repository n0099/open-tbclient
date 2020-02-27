package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asE = new LinkedList();
    private b emP;
    private c emQ;
    private g emR;
    private f emS;
    private d emT;
    private e emU;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.emP = new b(tbPageContext);
        this.emQ = new c(tbPageContext);
        this.emR = new g(tbPageContext);
        this.emS = new f(tbPageContext);
        this.emT = new d(tbPageContext);
        this.emU = new e(tbPageContext);
        this.emQ.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aAe() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aAe());
                }
            }
        });
        this.emS.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aAe() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aAe());
                }
            }
        });
        this.asE.add(this.emP);
        this.asE.add(this.emQ);
        this.asE.add(this.emR);
        this.asE.add(this.emS);
        this.asE.add(this.emT);
        this.asE.add(this.emU);
    }

    public List<com.baidu.adp.widget.ListView.a> bcC() {
        return this.asE;
    }
}
