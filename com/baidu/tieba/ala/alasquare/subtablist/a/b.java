package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.ala.alasquare.subtablist.c.e;
import com.baidu.tieba.ala.alasquare.subtablist.c.f;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, f> {
    private int from;
    private i ftC;
    private boolean fvC;
    private e fvE;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.fvG);
        this.fvC = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public f b(ViewGroup viewGroup) {
        this.fvE = new e(this.mPageContext, this.fvC);
        return new f(this.fvE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.fvE.a(bVar);
        fVar.fvE.d(this.ftC);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.ftC = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.foi != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bup().e(com.baidu.tieba.ala.alasquare.c.a.bup().a(this.isSmallFollow, "c12117", bVar.foi.tabId, bVar.foi.entryName, bVar.foi.aPS()));
                }
                if (bVar.foj != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bup().e(com.baidu.tieba.ala.alasquare.c.a.bup().a(this.isSmallFollow, "c12117", bVar.foj.tabId, bVar.foj.entryName, bVar.foj.aPS()));
                }
            } else if (this.from == 2) {
                if (bVar.foi != null && bVar.foi.aPS() != null && bVar.foi.aPS().aSJ() != null) {
                    bu aPS = bVar.foi.aPS();
                    TiebaStatic.log(new ao("c12115").s("obj_id", aPS.aSJ().live_id).dk(TiebaInitialize.Params.OBJ_PARAM3, aPS.aSJ().appId).dk("locate_type", bVar.foi.entryName));
                }
                if (bVar.foj != null && bVar.foj.aPS() != null && bVar.foj.aPS().aSJ() != null) {
                    bu aPS2 = bVar.foj.aPS();
                    TiebaStatic.log(new ao("c12115").s("obj_id", aPS2.aSJ().live_id).dk(TiebaInitialize.Params.OBJ_PARAM3, aPS2.aSJ().appId).dk("locate_type", bVar.foj.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void pY(int i) {
        this.isSmallFollow = i;
    }

    public void jN(boolean z) {
        this.fvC = z;
    }
}
