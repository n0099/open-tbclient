package com.baidu.tieba.ala.alasquare.live_tab.my_concern.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boS = new LinkedList();
    private b gDX;
    private c gDY;
    private g gDZ;
    private f gEa;
    private d gEb;
    private e gEc;
    private TbPageContext mTbPageContext;

    public a(final TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.gDX = new b(tbPageContext);
        this.gDY = new c(tbPageContext);
        this.gDZ = new g(tbPageContext);
        this.gEa = new f(tbPageContext);
        this.gEb = new d(tbPageContext);
        this.gEc = new e(tbPageContext);
        this.gDY.a(new i() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.1
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i
            public void a(com.baidu.tieba.ala.alasquare.a.e eVar) {
                if (eVar != null && eVar.blp() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), eVar.blp());
                }
            }
        });
        this.gEa.a(new i() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a.2
            @Override // com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.i
            public void a(com.baidu.tieba.ala.alasquare.a.e eVar) {
                if (eVar != null && eVar.blp() != null) {
                    com.baidu.tieba.ala.alasquare.live_tab.c.a(tbPageContext.getPageActivity(), eVar.blp());
                }
            }
        });
        this.boS.add(this.gDX);
        this.boS.add(this.gDY);
        this.boS.add(this.gDZ);
        this.boS.add(this.gEa);
        this.boS.add(this.gEb);
        this.boS.add(this.gEc);
    }

    public List<com.baidu.adp.widget.ListView.a> bRQ() {
        return this.boS;
    }
}
