package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> biN = new LinkedList();
    private b gkN;
    private c gkO;
    private g gkP;
    private f gkQ;
    private d gkR;
    private e gkS;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gkN = new b(tbPageContext);
        this.gkO = new c(tbPageContext);
        this.gkP = new g(tbPageContext);
        this.gkQ = new f(tbPageContext);
        this.gkR = new d(tbPageContext);
        this.gkS = new e(tbPageContext);
        this.gkO.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bjd() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bjd());
                }
            }
        });
        this.gkQ.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bjd() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bjd());
                }
            }
        });
        this.biN.add(this.gkN);
        this.biN.add(this.gkO);
        this.biN.add(this.gkP);
        this.biN.add(this.gkQ);
        this.biN.add(this.gkR);
        this.biN.add(this.gkS);
    }

    public List<com.baidu.adp.widget.ListView.a> bOC() {
        return this.biN;
    }
}
