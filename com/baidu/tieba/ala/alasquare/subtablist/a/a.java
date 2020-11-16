package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, com.baidu.tieba.ala.alasquare.subtablist.c.b> {
    private int from;
    private i gpj;
    private boolean grj;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a grk;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.grm);
        this.grj = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b c(ViewGroup viewGroup) {
        this.grk = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.grj);
        d.e(this.grk.getView(), true);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.grk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.grk.a(aVar);
        bVar.grk.d(this.gpj);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.gjL != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bOV().e(com.baidu.tieba.ala.alasquare.c.a.bOV().a(this.isSmallFollow, "c12117", aVar.gjL.tabId, aVar.gjL.entryName, aVar.gjL.bjd()));
                }
                if (aVar.gjM != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bOV().e(com.baidu.tieba.ala.alasquare.c.a.bOV().a(this.isSmallFollow, "c12117", aVar.gjM.tabId, aVar.gjM.entryName, aVar.gjM.bjd()));
                }
            } else if (this.from == 2) {
                if (aVar.gjL != null && aVar.gjL.bjd() != null && aVar.gjL.bjd().blW() != null) {
                    bx bjd = aVar.gjL.bjd();
                    TiebaStatic.log(new ar("c12115").w("obj_id", bjd.blW().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bjd.blW().appId).dR("locate_type", aVar.gjL.entryName));
                }
                if (aVar.gjM != null && aVar.gjM.bjd() != null && aVar.gjM.bjd().blW() != null) {
                    bx bjd2 = aVar.gjM.bjd();
                    TiebaStatic.log(new ar("c12115").w("obj_id", bjd2.blW().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bjd2.blW().appId).dR("locate_type", aVar.gjM.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.gpj = iVar;
    }

    public void uq(int i) {
        this.isSmallFollow = i;
    }

    public void lT(boolean z) {
        this.grj = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
