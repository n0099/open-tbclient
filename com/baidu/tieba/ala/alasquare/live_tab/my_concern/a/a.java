package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agQ = new LinkedList();
    private b dxI;
    private c dxJ;
    private g dxK;
    private f dxL;
    private d dxM;
    private e dxN;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.dxI = new b(tbPageContext);
        this.dxJ = new c(tbPageContext);
        this.dxK = new g(tbPageContext);
        this.dxL = new f(tbPageContext);
        this.dxM = new d(tbPageContext);
        this.dxN = new e(tbPageContext);
        this.dxJ.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.b bVar) {
                if (bVar != null && bVar.agI() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.b.b(tbPageContext.getPageActivity(), bVar.agI());
                }
            }
        });
        this.dxL.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.b bVar) {
                if (bVar != null && bVar.agI() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.b.b(tbPageContext.getPageActivity(), bVar.agI());
                }
            }
        });
        this.agQ.add(this.dxI);
        this.agQ.add(this.dxJ);
        this.agQ.add(this.dxK);
        this.agQ.add(this.dxL);
        this.agQ.add(this.dxM);
        this.agQ.add(this.dxN);
    }

    public List<com.baidu.adp.widget.ListView.a> aJs() {
        return this.agQ;
    }
}
