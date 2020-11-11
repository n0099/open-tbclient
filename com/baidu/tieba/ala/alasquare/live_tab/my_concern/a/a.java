package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bky = new LinkedList();
    private b glg;
    private c glh;
    private g gli;
    private f glj;
    private d glk;
    private e gll;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.glg = new b(tbPageContext);
        this.glh = new c(tbPageContext);
        this.gli = new g(tbPageContext);
        this.glj = new f(tbPageContext);
        this.glk = new d(tbPageContext);
        this.gll = new e(tbPageContext);
        this.glh.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bjZ() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bjZ());
                }
            }
        });
        this.glj.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bjZ() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bjZ());
                }
            }
        });
        this.bky.add(this.glg);
        this.bky.add(this.glh);
        this.bky.add(this.gli);
        this.bky.add(this.glj);
        this.bky.add(this.glk);
        this.bky.add(this.gll);
    }

    public List<com.baidu.adp.widget.ListView.a> bPj() {
        return this.bky;
    }
}
