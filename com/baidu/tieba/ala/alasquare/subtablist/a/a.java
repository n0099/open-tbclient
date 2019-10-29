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
    private h dBR;
    private boolean dDE;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a dDF;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.dDH);
        this.dDE = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.dDF = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.dDE);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.dDF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.dDF.a(aVar);
        bVar.dDF.d(this.dBR);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.dxr != null) {
                    com.baidu.tieba.ala.alasquare.c.a.aJO().c(com.baidu.tieba.ala.alasquare.c.a.aJO().a(this.isSmallFollow, "c12117", aVar.dxr.tabId, aVar.dxr.entryName, aVar.dxr.agI()));
                }
                if (aVar.dxs != null) {
                    com.baidu.tieba.ala.alasquare.c.a.aJO().c(com.baidu.tieba.ala.alasquare.c.a.aJO().a(this.isSmallFollow, "c12117", aVar.dxs.tabId, aVar.dxs.entryName, aVar.dxs.agI()));
                }
            } else if (this.from == 2) {
                if (aVar.dxr != null && aVar.dxr.agI() != null && aVar.dxr.agI().aiZ() != null) {
                    bh agI = aVar.dxr.agI();
                    TiebaStatic.log(new an("c12115").p("obj_id", agI.aiZ().live_id).bS(TiebaInitialize.Params.OBJ_PARAM3, agI.aiZ().appId).bS("locate_type", aVar.dxr.entryName));
                }
                if (aVar.dxs != null && aVar.dxs.agI() != null && aVar.dxs.agI().aiZ() != null) {
                    bh agI2 = aVar.dxs.agI();
                    TiebaStatic.log(new an("c12115").p("obj_id", agI2.aiZ().live_id).bS(TiebaInitialize.Params.OBJ_PARAM3, agI2.aiZ().appId).bS("locate_type", aVar.dxs.entryName));
                }
            }
        }
    }

    public void b(h hVar) {
        this.dBR = hVar;
    }

    public void mc(int i) {
        this.isSmallFollow = i;
    }

    public void gJ(boolean z) {
        this.dDE = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
