package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, com.baidu.tieba.ala.alasquare.subtablist.c.b> {
    private h dBa;
    private boolean dCN;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a dCO;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.dCQ);
        this.dCN = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.dCO = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.dCN);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.dCO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.dCO.a(aVar);
        bVar.dCO.d(this.dBa);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.dwA != null) {
                    com.baidu.tieba.ala.alasquare.c.a.aJM().c(com.baidu.tieba.ala.alasquare.c.a.aJM().a(this.isSmallFollow, "c12117", aVar.dwA.tabId, aVar.dwA.entryName, aVar.dwA.agG()));
                }
                if (aVar.dwB != null) {
                    com.baidu.tieba.ala.alasquare.c.a.aJM().c(com.baidu.tieba.ala.alasquare.c.a.aJM().a(this.isSmallFollow, "c12117", aVar.dwB.tabId, aVar.dwB.entryName, aVar.dwB.agG()));
                }
            } else if (this.from == 2) {
                if (aVar.dwA != null && aVar.dwA.agG() != null && aVar.dwA.agG().aiX() != null) {
                    bh agG = aVar.dwA.agG();
                    TiebaStatic.log(new an("c12115").p("obj_id", agG.aiX().live_id).bS(TiebaInitialize.Params.OBJ_PARAM3, agG.aiX().appId).bS("locate_type", aVar.dwA.entryName));
                }
                if (aVar.dwB != null && aVar.dwB.agG() != null && aVar.dwB.agG().aiX() != null) {
                    bh agG2 = aVar.dwB.agG();
                    TiebaStatic.log(new an("c12115").p("obj_id", agG2.aiX().live_id).bS(TiebaInitialize.Params.OBJ_PARAM3, agG2.aiX().appId).bS("locate_type", aVar.dwB.entryName));
                }
            }
        }
    }

    public void b(h hVar) {
        this.dBa = hVar;
    }

    public void mb(int i) {
        this.isSmallFollow = i;
    }

    public void gJ(boolean z) {
        this.dCN = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
