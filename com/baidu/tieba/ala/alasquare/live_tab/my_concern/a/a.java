package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aoz = new LinkedList();
    private b ehT;
    private c ehU;
    private g ehV;
    private f ehW;
    private d ehX;
    private e ehY;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.ehT = new b(tbPageContext);
        this.ehU = new c(tbPageContext);
        this.ehV = new g(tbPageContext);
        this.ehW = new f(tbPageContext);
        this.ehX = new d(tbPageContext);
        this.ehY = new e(tbPageContext);
        this.ehU.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.b bVar) {
                if (bVar != null && bVar.axx() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.b.b(tbPageContext.getPageActivity(), bVar.axx());
                }
            }
        });
        this.ehW.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.b bVar) {
                if (bVar != null && bVar.axx() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.b.b(tbPageContext.getPageActivity(), bVar.axx());
                }
            }
        });
        this.aoz.add(this.ehT);
        this.aoz.add(this.ehU);
        this.aoz.add(this.ehV);
        this.aoz.add(this.ehW);
        this.aoz.add(this.ehX);
        this.aoz.add(this.ehY);
    }

    public List<com.baidu.adp.widget.ListView.a> aZO() {
        return this.aoz;
    }
}
