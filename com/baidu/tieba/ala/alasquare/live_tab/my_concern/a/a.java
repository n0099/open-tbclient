package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> apl = new LinkedList();
    private b eiH;
    private c eiI;
    private g eiJ;
    private f eiK;
    private d eiL;
    private e eiM;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.eiH = new b(tbPageContext);
        this.eiI = new c(tbPageContext);
        this.eiJ = new g(tbPageContext);
        this.eiK = new f(tbPageContext);
        this.eiL = new d(tbPageContext);
        this.eiM = new e(tbPageContext);
        this.eiI.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.axQ() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.b(tbPageContext.getPageActivity(), cVar.axQ());
                }
            }
        });
        this.eiK.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.axQ() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.b(tbPageContext.getPageActivity(), cVar.axQ());
                }
            }
        });
        this.apl.add(this.eiH);
        this.apl.add(this.eiI);
        this.apl.add(this.eiJ);
        this.apl.add(this.eiK);
        this.apl.add(this.eiL);
        this.apl.add(this.eiM);
    }

    public List<com.baidu.adp.widget.ListView.a> ban() {
        return this.apl;
    }
}
