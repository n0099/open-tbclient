package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bdV = new LinkedList();
    private b fIW;
    private c fIX;
    private g fIY;
    private f fIZ;
    private d fJa;
    private e fJb;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fIW = new b(tbPageContext);
        this.fIX = new c(tbPageContext);
        this.fIY = new g(tbPageContext);
        this.fIZ = new f(tbPageContext);
        this.fJa = new d(tbPageContext);
        this.fJb = new e(tbPageContext);
        this.fIX.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bcY() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bcY());
                }
            }
        });
        this.fIZ.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bcY() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bcY());
                }
            }
        });
        this.bdV.add(this.fIW);
        this.bdV.add(this.fIX);
        this.bdV.add(this.fIY);
        this.bdV.add(this.fIZ);
        this.bdV.add(this.fJa);
        this.bdV.add(this.fJb);
    }

    public List<com.baidu.adp.widget.ListView.a> bHv() {
        return this.bdV;
    }
}
