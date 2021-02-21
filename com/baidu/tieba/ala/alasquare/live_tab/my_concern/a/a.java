package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private b gCo;
    private c gCp;
    private g gCq;
    private f gCr;
    private d gCs;
    private e gCt;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gCo = new b(tbPageContext);
        this.gCp = new c(tbPageContext);
        this.gCq = new g(tbPageContext);
        this.gCr = new f(tbPageContext);
        this.gCs = new d(tbPageContext);
        this.gCt = new e(tbPageContext);
        this.gCp.a(new i() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i
            public void a(com.baidu.tieba.ala.alasquare.a.e eVar) {
                if (eVar != null && eVar.bln() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), eVar.bln());
                }
            }
        });
        this.gCr.a(new i() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i
            public void a(com.baidu.tieba.ala.alasquare.a.e eVar) {
                if (eVar != null && eVar.bln() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), eVar.bln());
                }
            }
        });
        this.bns.add(this.gCo);
        this.bns.add(this.gCp);
        this.bns.add(this.gCq);
        this.bns.add(this.gCr);
        this.bns.add(this.gCs);
        this.bns.add(this.gCt);
    }

    public List<com.baidu.adp.widget.ListView.a> bRK() {
        return this.bns;
    }
}
