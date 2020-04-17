package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aMd = new LinkedList();
    private b eQU;
    private c eQV;
    private g eQW;
    private f eQX;
    private d eQY;
    private e eQZ;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.eQU = new b(tbPageContext);
        this.eQV = new c(tbPageContext);
        this.eQW = new g(tbPageContext);
        this.eQX = new f(tbPageContext);
        this.eQY = new d(tbPageContext);
        this.eQZ = new e(tbPageContext);
        this.eQV.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aIw() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aIw());
                }
            }
        });
        this.eQX.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aIw() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aIw());
                }
            }
        });
        this.aMd.add(this.eQU);
        this.aMd.add(this.eQV);
        this.aMd.add(this.eQW);
        this.aMd.add(this.eQX);
        this.aMd.add(this.eQY);
        this.aMd.add(this.eQZ);
    }

    public List<com.baidu.adp.widget.ListView.a> blA() {
        return this.aMd;
    }
}
