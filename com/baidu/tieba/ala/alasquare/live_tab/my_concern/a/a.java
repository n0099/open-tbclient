package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agy = new LinkedList();
    private b dwR;
    private c dwS;
    private g dwT;
    private f dwU;
    private d dwV;
    private e dwW;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.dwR = new b(tbPageContext);
        this.dwS = new c(tbPageContext);
        this.dwT = new g(tbPageContext);
        this.dwU = new f(tbPageContext);
        this.dwV = new d(tbPageContext);
        this.dwW = new e(tbPageContext);
        this.dwS.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.b bVar) {
                if (bVar != null && bVar.agG() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.b.b(tbPageContext.getPageActivity(), bVar.agG());
                }
            }
        });
        this.dwU.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.b bVar) {
                if (bVar != null && bVar.agG() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.b.b(tbPageContext.getPageActivity(), bVar.agG());
                }
            }
        });
        this.agy.add(this.dwR);
        this.agy.add(this.dwS);
        this.agy.add(this.dwT);
        this.agy.add(this.dwU);
        this.agy.add(this.dwV);
        this.agy.add(this.dwW);
    }

    public List<com.baidu.adp.widget.ListView.a> aJq() {
        return this.agy;
    }
}
