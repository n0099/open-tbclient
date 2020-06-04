package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.alasquare.subtablist.c.e;
import com.baidu.tieba.ala.alasquare.subtablist.c.f;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, f> {
    private i fio;
    private boolean fkp;
    private e fkr;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.fkt);
        this.fkp = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public f b(ViewGroup viewGroup) {
        this.fkr = new e(this.mPageContext, this.fkp);
        return new f(this.fkr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.fkr.a(bVar);
        fVar.fkr.d(this.fio);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.fio = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.fcY != null) {
                    com.baidu.tieba.ala.alasquare.c.a.brs().e(com.baidu.tieba.ala.alasquare.c.a.brs().a(this.isSmallFollow, "c12117", bVar.fcY.tabId, bVar.fcY.entryName, bVar.fcY.aOi()));
                }
                if (bVar.fcZ != null) {
                    com.baidu.tieba.ala.alasquare.c.a.brs().e(com.baidu.tieba.ala.alasquare.c.a.brs().a(this.isSmallFollow, "c12117", bVar.fcZ.tabId, bVar.fcZ.entryName, bVar.fcZ.aOi()));
                }
            } else if (this.from == 2) {
                if (bVar.fcY != null && bVar.fcY.aOi() != null && bVar.fcY.aOi().aQS() != null) {
                    bk aOi = bVar.fcY.aOi();
                    TiebaStatic.log(new an("c12115").s("obj_id", aOi.aQS().live_id).dh(TiebaInitialize.Params.OBJ_PARAM3, aOi.aQS().appId).dh("locate_type", bVar.fcY.entryName));
                }
                if (bVar.fcZ != null && bVar.fcZ.aOi() != null && bVar.fcZ.aOi().aQS() != null) {
                    bk aOi2 = bVar.fcZ.aOi();
                    TiebaStatic.log(new an("c12115").s("obj_id", aOi2.aQS().live_id).dh(TiebaInitialize.Params.OBJ_PARAM3, aOi2.aQS().appId).dh("locate_type", bVar.fcZ.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void pz(int i) {
        this.isSmallFollow = i;
    }

    public void jA(boolean z) {
        this.fkp = z;
    }
}
