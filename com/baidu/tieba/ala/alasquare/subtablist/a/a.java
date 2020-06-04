package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, com.baidu.tieba.ala.alasquare.subtablist.c.b> {
    private i fio;
    private boolean fkp;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a fkq;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.fks);
        this.fkp = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.fkq = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.fkp);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.fkq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.fkq.a(aVar);
        bVar.fkq.d(this.fio);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.fcY != null) {
                    com.baidu.tieba.ala.alasquare.c.a.brs().e(com.baidu.tieba.ala.alasquare.c.a.brs().a(this.isSmallFollow, "c12117", aVar.fcY.tabId, aVar.fcY.entryName, aVar.fcY.aOi()));
                }
                if (aVar.fcZ != null) {
                    com.baidu.tieba.ala.alasquare.c.a.brs().e(com.baidu.tieba.ala.alasquare.c.a.brs().a(this.isSmallFollow, "c12117", aVar.fcZ.tabId, aVar.fcZ.entryName, aVar.fcZ.aOi()));
                }
            } else if (this.from == 2) {
                if (aVar.fcY != null && aVar.fcY.aOi() != null && aVar.fcY.aOi().aQS() != null) {
                    bk aOi = aVar.fcY.aOi();
                    TiebaStatic.log(new an("c12115").s("obj_id", aOi.aQS().live_id).dh(TiebaInitialize.Params.OBJ_PARAM3, aOi.aQS().appId).dh("locate_type", aVar.fcY.entryName));
                }
                if (aVar.fcZ != null && aVar.fcZ.aOi() != null && aVar.fcZ.aOi().aQS() != null) {
                    bk aOi2 = aVar.fcZ.aOi();
                    TiebaStatic.log(new an("c12115").s("obj_id", aOi2.aQS().live_id).dh(TiebaInitialize.Params.OBJ_PARAM3, aOi2.aQS().appId).dh("locate_type", aVar.fcZ.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.fio = iVar;
    }

    public void pz(int i) {
        this.isSmallFollow = i;
    }

    public void jA(boolean z) {
        this.fkp = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
