package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
    private b fdS;
    private c fdT;
    private g fdU;
    private f fdV;
    private d fdW;
    private e fdX;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fdS = new b(tbPageContext);
        this.fdT = new c(tbPageContext);
        this.fdU = new g(tbPageContext);
        this.fdV = new f(tbPageContext);
        this.fdW = new d(tbPageContext);
        this.fdX = new e(tbPageContext);
        this.fdT.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aOi() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aOi());
                }
            }
        });
        this.fdV.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aOi() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aOi());
                }
            }
        });
        this.aSj.add(this.fdS);
        this.aSj.add(this.fdT);
        this.aSj.add(this.fdU);
        this.aSj.add(this.fdV);
        this.aSj.add(this.fdW);
        this.aSj.add(this.fdX);
    }

    public List<com.baidu.adp.widget.ListView.a> bqY() {
        return this.aSj;
    }
}
