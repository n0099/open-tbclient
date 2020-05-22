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
    private i fic;
    private boolean fke;
    private e fkg;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.fki);
        this.fke = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public f b(ViewGroup viewGroup) {
        this.fkg = new e(this.mPageContext, this.fke);
        return new f(this.fkg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.fkg.a(bVar);
        fVar.fkg.d(this.fic);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.fic = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.fcN != null) {
                    com.baidu.tieba.ala.alasquare.c.a.brq().e(com.baidu.tieba.ala.alasquare.c.a.brq().a(this.isSmallFollow, "c12117", bVar.fcN.tabId, bVar.fcN.entryName, bVar.fcN.aOi()));
                }
                if (bVar.fcO != null) {
                    com.baidu.tieba.ala.alasquare.c.a.brq().e(com.baidu.tieba.ala.alasquare.c.a.brq().a(this.isSmallFollow, "c12117", bVar.fcO.tabId, bVar.fcO.entryName, bVar.fcO.aOi()));
                }
            } else if (this.from == 2) {
                if (bVar.fcN != null && bVar.fcN.aOi() != null && bVar.fcN.aOi().aQS() != null) {
                    bk aOi = bVar.fcN.aOi();
                    TiebaStatic.log(new an("c12115").s("obj_id", aOi.aQS().live_id).dh(TiebaInitialize.Params.OBJ_PARAM3, aOi.aQS().appId).dh("locate_type", bVar.fcN.entryName));
                }
                if (bVar.fcO != null && bVar.fcO.aOi() != null && bVar.fcO.aOi().aQS() != null) {
                    bk aOi2 = bVar.fcO.aOi();
                    TiebaStatic.log(new an("c12115").s("obj_id", aOi2.aQS().live_id).dh(TiebaInitialize.Params.OBJ_PARAM3, aOi2.aQS().appId).dh("locate_type", bVar.fcO.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void px(int i) {
        this.isSmallFollow = i;
    }

    public void jA(boolean z) {
        this.fke = z;
    }
}
