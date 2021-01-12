package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new LinkedList();
    private b gzq;
    private c gzr;
    private g gzs;
    private f gzt;
    private d gzu;
    private e gzv;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gzq = new b(tbPageContext);
        this.gzr = new c(tbPageContext);
        this.gzs = new g(tbPageContext);
        this.gzt = new f(tbPageContext);
        this.gzu = new d(tbPageContext);
        this.gzv = new e(tbPageContext);
        this.gzr.a(new i() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i
            public void a(com.baidu.tieba.ala.alasquare.a.e eVar) {
                if (eVar != null && eVar.bkV() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), eVar.bkV());
                }
            }
        });
        this.gzt.a(new i() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i
            public void a(com.baidu.tieba.ala.alasquare.a.e eVar) {
                if (eVar != null && eVar.bkV() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), eVar.bkV());
                }
            }
        });
        this.bjZ.add(this.gzq);
        this.bjZ.add(this.gzr);
        this.bjZ.add(this.gzs);
        this.bjZ.add(this.gzt);
        this.bjZ.add(this.gzu);
        this.bjZ.add(this.gzv);
    }

    public List<com.baidu.adp.widget.ListView.a> bQZ() {
        return this.bjZ;
    }
}
