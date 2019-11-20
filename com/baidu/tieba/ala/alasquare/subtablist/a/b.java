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
    private h dBa;
    private boolean dCN;
    private e dCP;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.dCR);
        this.dCN = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: L */
    public f b(ViewGroup viewGroup) {
        this.dCP = new e(this.mPageContext, this.dCN);
        return new f(this.dCP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.dCP.a(bVar);
        fVar.dCP.d(this.dBa);
        return fVar.getView();
    }

    public void b(h hVar) {
        this.dBa = hVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.dwA != null) {
                    com.baidu.tieba.ala.alasquare.c.a.aJM().c(com.baidu.tieba.ala.alasquare.c.a.aJM().a(this.isSmallFollow, "c12117", bVar.dwA.tabId, bVar.dwA.entryName, bVar.dwA.agG()));
                }
                if (bVar.dwB != null) {
                    com.baidu.tieba.ala.alasquare.c.a.aJM().c(com.baidu.tieba.ala.alasquare.c.a.aJM().a(this.isSmallFollow, "c12117", bVar.dwB.tabId, bVar.dwB.entryName, bVar.dwB.agG()));
                }
            } else if (this.from == 2) {
                if (bVar.dwA != null && bVar.dwA.agG() != null && bVar.dwA.agG().aiX() != null) {
                    bh agG = bVar.dwA.agG();
                    TiebaStatic.log(new an("c12115").p("obj_id", agG.aiX().live_id).bS(TiebaInitialize.Params.OBJ_PARAM3, agG.aiX().appId).bS("locate_type", bVar.dwA.entryName));
                }
                if (bVar.dwB != null && bVar.dwB.agG() != null && bVar.dwB.agG().aiX() != null) {
                    bh agG2 = bVar.dwB.agG();
                    TiebaStatic.log(new an("c12115").p("obj_id", agG2.aiX().live_id).bS(TiebaInitialize.Params.OBJ_PARAM3, agG2.aiX().appId).bS("locate_type", bVar.dwB.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void mb(int i) {
        this.isSmallFollow = i;
    }

    public void gJ(boolean z) {
        this.dCN = z;
    }
}
