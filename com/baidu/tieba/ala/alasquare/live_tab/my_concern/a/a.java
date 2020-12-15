package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
    private b gsY;
    private c gsZ;
    private g gta;
    private f gtb;
    private d gtc;
    private e gtd;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gsY = new b(tbPageContext);
        this.gsZ = new c(tbPageContext);
        this.gta = new g(tbPageContext);
        this.gtb = new f(tbPageContext);
        this.gtc = new d(tbPageContext);
        this.gtd = new e(tbPageContext);
        this.gsZ.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bmn() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bmn());
                }
            }
        });
        this.gtb.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bmn() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bmn());
                }
            }
        });
        this.bnf.add(this.gsY);
        this.bnf.add(this.gsZ);
        this.bnf.add(this.gta);
        this.bnf.add(this.gtb);
        this.bnf.add(this.gtc);
        this.bnf.add(this.gtd);
    }

    public List<com.baidu.adp.widget.ListView.a> bSo() {
        return this.bnf;
    }
}
