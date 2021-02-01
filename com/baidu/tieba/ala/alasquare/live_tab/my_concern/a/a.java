package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private b gCa;
    private c gCb;
    private g gCc;
    private f gCd;
    private d gCe;
    private e gCf;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gCa = new b(tbPageContext);
        this.gCb = new c(tbPageContext);
        this.gCc = new g(tbPageContext);
        this.gCd = new f(tbPageContext);
        this.gCe = new d(tbPageContext);
        this.gCf = new e(tbPageContext);
        this.gCb.a(new i() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i
            public void a(com.baidu.tieba.ala.alasquare.a.e eVar) {
                if (eVar != null && eVar.bln() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), eVar.bln());
                }
            }
        });
        this.gCd.a(new i() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i
            public void a(com.baidu.tieba.ala.alasquare.a.e eVar) {
                if (eVar != null && eVar.bln() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), eVar.bln());
                }
            }
        });
        this.bns.add(this.gCa);
        this.bns.add(this.gCb);
        this.bns.add(this.gCc);
        this.bns.add(this.gCd);
        this.bns.add(this.gCe);
        this.bns.add(this.gCf);
    }

    public List<com.baidu.adp.widget.ListView.a> bRD() {
        return this.bns;
    }
}
