package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asF = new LinkedList();
    private b ene;
    private c enf;
    private g eng;
    private f enh;
    private d eni;
    private e enj;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.ene = new b(tbPageContext);
        this.enf = new c(tbPageContext);
        this.eng = new g(tbPageContext);
        this.enh = new f(tbPageContext);
        this.eni = new d(tbPageContext);
        this.enj = new e(tbPageContext);
        this.enf.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aAg() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aAg());
                }
            }
        });
        this.enh.a(new o() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.o
            public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
                if (cVar != null && cVar.aAg() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), cVar.aAg());
                }
            }
        });
        this.asF.add(this.ene);
        this.asF.add(this.enf);
        this.asF.add(this.eng);
        this.asF.add(this.enh);
        this.asF.add(this.eni);
        this.asF.add(this.enj);
    }

    public List<com.baidu.adp.widget.ListView.a> bcF() {
        return this.asF;
    }
}
