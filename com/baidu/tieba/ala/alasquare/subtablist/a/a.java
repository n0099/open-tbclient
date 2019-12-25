package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, com.baidu.tieba.ala.alasquare.subtablist.c.b> {
    private h elY;
    private boolean enL;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a enM;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.enO);
        this.enL = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: J */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.enM = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.enL);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.enM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.enM.a(aVar);
        bVar.enM.d(this.elY);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.ehC != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bal().c(com.baidu.tieba.ala.alasquare.c.a.bal().a(this.isSmallFollow, "c12117", aVar.ehC.tabId, aVar.ehC.entryName, aVar.ehC.axx()));
                }
                if (aVar.ehD != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bal().c(com.baidu.tieba.ala.alasquare.c.a.bal().a(this.isSmallFollow, "c12117", aVar.ehD.tabId, aVar.ehD.entryName, aVar.ehD.axx()));
                }
            } else if (this.from == 2) {
                if (aVar.ehC != null && aVar.ehC.axx() != null && aVar.ehC.axx().azX() != null) {
                    bj axx = aVar.ehC.axx();
                    TiebaStatic.log(new an("c12115").s("obj_id", axx.azX().live_id).cp(TiebaInitialize.Params.OBJ_PARAM3, axx.azX().appId).cp("locate_type", aVar.ehC.entryName));
                }
                if (aVar.ehD != null && aVar.ehD.axx() != null && aVar.ehD.axx().azX() != null) {
                    bj axx2 = aVar.ehD.axx();
                    TiebaStatic.log(new an("c12115").s("obj_id", axx2.azX().live_id).cp(TiebaInitialize.Params.OBJ_PARAM3, axx2.azX().appId).cp("locate_type", aVar.ehD.entryName));
                }
            }
        }
    }

    public void b(h hVar) {
        this.elY = hVar;
    }

    public void ok(int i) {
        this.isSmallFollow = i;
    }

    public void hO(boolean z) {
        this.enL = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
