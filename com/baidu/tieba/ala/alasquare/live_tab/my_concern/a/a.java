package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
    private b fun;
    private c fuo;
    private g fup;
    private f fuq;
    private d fur;
    private e fus;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fun = new b(tbPageContext);
        this.fuo = new c(tbPageContext);
        this.fup = new g(tbPageContext);
        this.fuq = new f(tbPageContext);
        this.fur = new d(tbPageContext);
        this.fus = new e(tbPageContext);
        this.fuo.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aTN() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aTN());
                }
            }
        });
        this.fuq.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aTN() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aTN());
                }
            }
        });
        this.aWf.add(this.fun);
        this.aWf.add(this.fuo);
        this.aWf.add(this.fup);
        this.aWf.add(this.fuq);
        this.aWf.add(this.fur);
        this.aWf.add(this.fus);
    }

    public List<com.baidu.adp.widget.ListView.a> bxf() {
        return this.aWf;
    }
}
