package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
    private b fdH;
    private c fdI;
    private g fdJ;
    private f fdK;
    private d fdL;
    private e fdM;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fdH = new b(tbPageContext);
        this.fdI = new c(tbPageContext);
        this.fdJ = new g(tbPageContext);
        this.fdK = new f(tbPageContext);
        this.fdL = new d(tbPageContext);
        this.fdM = new e(tbPageContext);
        this.fdI.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aOi() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aOi());
                }
            }
        });
        this.fdK.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aOi() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aOi());
                }
            }
        });
        this.aSj.add(this.fdH);
        this.aSj.add(this.fdI);
        this.aSj.add(this.fdJ);
        this.aSj.add(this.fdK);
        this.aSj.add(this.fdL);
        this.aSj.add(this.fdM);
    }

    public List<com.baidu.adp.widget.ListView.a> bqW() {
        return this.aSj;
    }
}
