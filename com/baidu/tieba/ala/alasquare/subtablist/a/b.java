package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.alasquare.subtablist.c.e;
import com.baidu.tieba.ala.alasquare.subtablist.c.f;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, f> {
    private i eVp;
    private boolean eXp;
    private e eXr;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.eXt);
        this.eXp = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public f b(ViewGroup viewGroup) {
        this.eXr = new e(this.mPageContext, this.eXp);
        return new f(this.eXr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.eXr.a(bVar);
        fVar.eXr.d(this.eVp);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.eVp = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.ePZ != null) {
                    com.baidu.tieba.ala.alasquare.c.a.blU().e(com.baidu.tieba.ala.alasquare.c.a.blU().a(this.isSmallFollow, "c12117", bVar.ePZ.tabId, bVar.ePZ.entryName, bVar.ePZ.aIw()));
                }
                if (bVar.eQa != null) {
                    com.baidu.tieba.ala.alasquare.c.a.blU().e(com.baidu.tieba.ala.alasquare.c.a.blU().a(this.isSmallFollow, "c12117", bVar.eQa.tabId, bVar.eQa.entryName, bVar.eQa.aIw()));
                }
            } else if (this.from == 2) {
                if (bVar.ePZ != null && bVar.ePZ.aIw() != null && bVar.ePZ.aIw().aKX() != null) {
                    bj aIw = bVar.ePZ.aIw();
                    TiebaStatic.log(new an("c12115").t("obj_id", aIw.aKX().live_id).cI(TiebaInitialize.Params.OBJ_PARAM3, aIw.aKX().appId).cI("locate_type", bVar.ePZ.entryName));
                }
                if (bVar.eQa != null && bVar.eQa.aIw() != null && bVar.eQa.aIw().aKX() != null) {
                    bj aIw2 = bVar.eQa.aIw();
                    TiebaStatic.log(new an("c12115").t("obj_id", aIw2.aKX().live_id).cI(TiebaInitialize.Params.OBJ_PARAM3, aIw2.aKX().appId).cI("locate_type", bVar.eQa.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void oW(int i) {
        this.isSmallFollow = i;
    }

    public void jh(boolean z) {
        this.eXp = z;
    }
}
