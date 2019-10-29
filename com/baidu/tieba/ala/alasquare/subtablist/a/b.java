package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.alasquare.subtablist.c.e;
import com.baidu.tieba.ala.alasquare.subtablist.c.f;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, f> {
    private h dBR;
    private boolean dDE;
    private e dDG;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.dDI);
        this.dDE = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public f b(ViewGroup viewGroup) {
        this.dDG = new e(this.mPageContext, this.dDE);
        return new f(this.dDG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.dDG.a(bVar);
        fVar.dDG.d(this.dBR);
        return fVar.getView();
    }

    public void b(h hVar) {
        this.dBR = hVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.dxr != null) {
                    com.baidu.tieba.ala.alasquare.c.a.aJO().c(com.baidu.tieba.ala.alasquare.c.a.aJO().a(this.isSmallFollow, "c12117", bVar.dxr.tabId, bVar.dxr.entryName, bVar.dxr.agI()));
                }
                if (bVar.dxs != null) {
                    com.baidu.tieba.ala.alasquare.c.a.aJO().c(com.baidu.tieba.ala.alasquare.c.a.aJO().a(this.isSmallFollow, "c12117", bVar.dxs.tabId, bVar.dxs.entryName, bVar.dxs.agI()));
                }
            } else if (this.from == 2) {
                if (bVar.dxr != null && bVar.dxr.agI() != null && bVar.dxr.agI().aiZ() != null) {
                    bh agI = bVar.dxr.agI();
                    TiebaStatic.log(new an("c12115").p("obj_id", agI.aiZ().live_id).bS(TiebaInitialize.Params.OBJ_PARAM3, agI.aiZ().appId).bS("locate_type", bVar.dxr.entryName));
                }
                if (bVar.dxs != null && bVar.dxs.agI() != null && bVar.dxs.agI().aiZ() != null) {
                    bh agI2 = bVar.dxs.agI();
                    TiebaStatic.log(new an("c12115").p("obj_id", agI2.aiZ().live_id).bS(TiebaInitialize.Params.OBJ_PARAM3, agI2.aiZ().appId).bS("locate_type", bVar.dxs.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void mc(int i) {
        this.isSmallFollow = i;
    }

    public void gJ(boolean z) {
        this.dDE = z;
    }
}
