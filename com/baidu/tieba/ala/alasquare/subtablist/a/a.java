package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, com.baidu.tieba.ala.alasquare.subtablist.c.b> {
    private int from;
    private i ftC;
    private boolean fvC;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a fvD;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.fvF);
        this.fvC = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: W */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.fvD = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.fvC);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.fvD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.fvD.a(aVar);
        bVar.fvD.d(this.ftC);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.foi != null) {
                    com.baidu.tieba.ala.alasquare.c.a.buo().e(com.baidu.tieba.ala.alasquare.c.a.buo().a(this.isSmallFollow, "c12117", aVar.foi.tabId, aVar.foi.entryName, aVar.foi.aPS()));
                }
                if (aVar.foj != null) {
                    com.baidu.tieba.ala.alasquare.c.a.buo().e(com.baidu.tieba.ala.alasquare.c.a.buo().a(this.isSmallFollow, "c12117", aVar.foj.tabId, aVar.foj.entryName, aVar.foj.aPS()));
                }
            } else if (this.from == 2) {
                if (aVar.foi != null && aVar.foi.aPS() != null && aVar.foi.aPS().aSJ() != null) {
                    bu aPS = aVar.foi.aPS();
                    TiebaStatic.log(new ao("c12115").s("obj_id", aPS.aSJ().live_id).dk(TiebaInitialize.Params.OBJ_PARAM3, aPS.aSJ().appId).dk("locate_type", aVar.foi.entryName));
                }
                if (aVar.foj != null && aVar.foj.aPS() != null && aVar.foj.aPS().aSJ() != null) {
                    bu aPS2 = aVar.foj.aPS();
                    TiebaStatic.log(new ao("c12115").s("obj_id", aPS2.aSJ().live_id).dk(TiebaInitialize.Params.OBJ_PARAM3, aPS2.aSJ().appId).dk("locate_type", aVar.foj.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.ftC = iVar;
    }

    public void pY(int i) {
        this.isSmallFollow = i;
    }

    public void jN(boolean z) {
        this.fvC = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
