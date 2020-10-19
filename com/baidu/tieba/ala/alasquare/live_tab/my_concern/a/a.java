package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bhH = new LinkedList();
    private b fVn;
    private c fVo;
    private g fVp;
    private f fVq;
    private d fVr;
    private e fVs;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fVn = new b(tbPageContext);
        this.fVo = new c(tbPageContext);
        this.fVp = new g(tbPageContext);
        this.fVq = new f(tbPageContext);
        this.fVr = new d(tbPageContext);
        this.fVs = new e(tbPageContext);
        this.fVo.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bfG() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bfG());
                }
            }
        });
        this.fVq.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.bfG() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.bfG());
                }
            }
        });
        this.bhH.add(this.fVn);
        this.bhH.add(this.fVo);
        this.bhH.add(this.fVp);
        this.bhH.add(this.fVq);
        this.bhH.add(this.fVr);
        this.bhH.add(this.fVs);
    }

    public List<com.baidu.adp.widget.ListView.a> bKh() {
        return this.bhH;
    }
}
