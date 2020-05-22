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
    private i fic;
    private boolean fke;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a fkf;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.fkh);
        this.fke = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.fkf = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.fke);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.fkf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.fkf.a(aVar);
        bVar.fkf.d(this.fic);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.fcN != null) {
                    com.baidu.tieba.ala.alasquare.c.a.brq().e(com.baidu.tieba.ala.alasquare.c.a.brq().a(this.isSmallFollow, "c12117", aVar.fcN.tabId, aVar.fcN.entryName, aVar.fcN.aOi()));
                }
                if (aVar.fcO != null) {
                    com.baidu.tieba.ala.alasquare.c.a.brq().e(com.baidu.tieba.ala.alasquare.c.a.brq().a(this.isSmallFollow, "c12117", aVar.fcO.tabId, aVar.fcO.entryName, aVar.fcO.aOi()));
                }
            } else if (this.from == 2) {
                if (aVar.fcN != null && aVar.fcN.aOi() != null && aVar.fcN.aOi().aQS() != null) {
                    bk aOi = aVar.fcN.aOi();
                    TiebaStatic.log(new an("c12115").s("obj_id", aOi.aQS().live_id).dh(TiebaInitialize.Params.OBJ_PARAM3, aOi.aQS().appId).dh("locate_type", aVar.fcN.entryName));
                }
                if (aVar.fcO != null && aVar.fcO.aOi() != null && aVar.fcO.aOi().aQS() != null) {
                    bk aOi2 = aVar.fcO.aOi();
                    TiebaStatic.log(new an("c12115").s("obj_id", aOi2.aQS().live_id).dh(TiebaInitialize.Params.OBJ_PARAM3, aOi2.aQS().appId).dh("locate_type", aVar.fcO.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.fic = iVar;
    }

    public void px(int i) {
        this.isSmallFollow = i;
    }

    public void jA(boolean z) {
        this.fke = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
