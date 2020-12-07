package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
    private b gsW;
    private c gsX;
    private g gsY;
    private f gsZ;
    private d gta;
    private e gtb;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gsW = new b(tbPageContext);
        this.gsX = new c(tbPageContext);
        this.gsY = new g(tbPageContext);
        this.gsZ = new f(tbPageContext);
        this.gta = new d(tbPageContext);
        this.gtb = new e(tbPageContext);
        this.gsX.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bmn() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bmn());
                }
            }
        });
        this.gsZ.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bmn() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bmn());
                }
            }
        });
        this.bnf.add(this.gsW);
        this.bnf.add(this.gsX);
        this.bnf.add(this.gsY);
        this.bnf.add(this.gsZ);
        this.bnf.add(this.gta);
        this.bnf.add(this.gtb);
    }

    public List<com.baidu.adp.widget.ListView.a> bSn() {
        return this.bnf;
    }
}
