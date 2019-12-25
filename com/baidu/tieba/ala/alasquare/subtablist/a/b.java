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
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, f> {
    private h elY;
    private boolean enL;
    private e enN;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.enP);
        this.enL = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: K */
    public f b(ViewGroup viewGroup) {
        this.enN = new e(this.mPageContext, this.enL);
        return new f(this.enN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.enN.a(bVar);
        fVar.enN.d(this.elY);
        return fVar.getView();
    }

    public void b(h hVar) {
        this.elY = hVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.ehC != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bal().c(com.baidu.tieba.ala.alasquare.c.a.bal().a(this.isSmallFollow, "c12117", bVar.ehC.tabId, bVar.ehC.entryName, bVar.ehC.axx()));
                }
                if (bVar.ehD != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bal().c(com.baidu.tieba.ala.alasquare.c.a.bal().a(this.isSmallFollow, "c12117", bVar.ehD.tabId, bVar.ehD.entryName, bVar.ehD.axx()));
                }
            } else if (this.from == 2) {
                if (bVar.ehC != null && bVar.ehC.axx() != null && bVar.ehC.axx().azX() != null) {
                    bj axx = bVar.ehC.axx();
                    TiebaStatic.log(new an("c12115").s("obj_id", axx.azX().live_id).cp(TiebaInitialize.Params.OBJ_PARAM3, axx.azX().appId).cp("locate_type", bVar.ehC.entryName));
                }
                if (bVar.ehD != null && bVar.ehD.axx() != null && bVar.ehD.axx().azX() != null) {
                    bj axx2 = bVar.ehD.axx();
                    TiebaStatic.log(new an("c12115").s("obj_id", axx2.azX().live_id).cp(TiebaInitialize.Params.OBJ_PARAM3, axx2.azX().appId).cp("locate_type", bVar.ehD.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void ok(int i) {
        this.isSmallFollow = i;
    }

    public void hO(boolean z) {
        this.enL = z;
    }
}
