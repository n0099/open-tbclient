package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, com.baidu.tieba.ala.alasquare.subtablist.c.b> {
    private i eVp;
    private boolean eXp;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a eXq;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.eXs);
        this.eXp = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.eXq = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.eXp);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.eXq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.eXq.a(aVar);
        bVar.eXq.d(this.eVp);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.ePZ != null) {
                    com.baidu.tieba.ala.alasquare.c.a.blU().e(com.baidu.tieba.ala.alasquare.c.a.blU().a(this.isSmallFollow, "c12117", aVar.ePZ.tabId, aVar.ePZ.entryName, aVar.ePZ.aIw()));
                }
                if (aVar.eQa != null) {
                    com.baidu.tieba.ala.alasquare.c.a.blU().e(com.baidu.tieba.ala.alasquare.c.a.blU().a(this.isSmallFollow, "c12117", aVar.eQa.tabId, aVar.eQa.entryName, aVar.eQa.aIw()));
                }
            } else if (this.from == 2) {
                if (aVar.ePZ != null && aVar.ePZ.aIw() != null && aVar.ePZ.aIw().aKX() != null) {
                    bj aIw = aVar.ePZ.aIw();
                    TiebaStatic.log(new an("c12115").t("obj_id", aIw.aKX().live_id).cI(TiebaInitialize.Params.OBJ_PARAM3, aIw.aKX().appId).cI("locate_type", aVar.ePZ.entryName));
                }
                if (aVar.eQa != null && aVar.eQa.aIw() != null && aVar.eQa.aIw().aKX() != null) {
                    bj aIw2 = aVar.eQa.aIw();
                    TiebaStatic.log(new an("c12115").t("obj_id", aIw2.aKX().live_id).cI(TiebaInitialize.Params.OBJ_PARAM3, aIw2.aKX().appId).cI("locate_type", aVar.eQa.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.eVp = iVar;
    }

    public void oW(int i) {
        this.isSmallFollow = i;
    }

    public void jh(boolean z) {
        this.eXp = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
