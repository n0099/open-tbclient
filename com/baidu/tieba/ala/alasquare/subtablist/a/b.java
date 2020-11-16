package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.ala.alasquare.subtablist.c.e;
import com.baidu.tieba.ala.alasquare.subtablist.c.f;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, f> {
    private int from;
    private i gpj;
    private boolean grj;
    private e grl;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.grn);
        this.grj = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public f c(ViewGroup viewGroup) {
        this.grl = new e(this.mPageContext, this.grj);
        d.e(this.grl.getView(), true);
        return new f(this.grl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.grl.a(bVar);
        fVar.grl.d(this.gpj);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.gpj = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.gjL != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bOV().e(com.baidu.tieba.ala.alasquare.c.a.bOV().a(this.isSmallFollow, "c12117", bVar.gjL.tabId, bVar.gjL.entryName, bVar.gjL.bjd()));
                }
                if (bVar.gjM != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bOV().e(com.baidu.tieba.ala.alasquare.c.a.bOV().a(this.isSmallFollow, "c12117", bVar.gjM.tabId, bVar.gjM.entryName, bVar.gjM.bjd()));
                }
            } else if (this.from == 2) {
                if (bVar.gjL != null && bVar.gjL.bjd() != null && bVar.gjL.bjd().blW() != null) {
                    bx bjd = bVar.gjL.bjd();
                    TiebaStatic.log(new ar("c12115").w("obj_id", bjd.blW().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bjd.blW().appId).dR("locate_type", bVar.gjL.entryName));
                }
                if (bVar.gjM != null && bVar.gjM.bjd() != null && bVar.gjM.bjd().blW() != null) {
                    bx bjd2 = bVar.gjM.bjd();
                    TiebaStatic.log(new ar("c12115").w("obj_id", bjd2.blW().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bjd2.blW().appId).dR("locate_type", bVar.gjM.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void uq(int i) {
        this.isSmallFollow = i;
    }

    public void lT(boolean z) {
        this.grj = z;
    }
}
