package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, com.baidu.tieba.ala.alasquare.subtablist.c.b> {
    private i fKb;
    private boolean fMb;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a fMc;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.fMe);
        this.fMb = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.fMc = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.fMb);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.fMc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.fMc.a(aVar);
        bVar.fMc.d(this.fKb);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.fEL != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bGx().e(com.baidu.tieba.ala.alasquare.c.a.bGx().a(this.isSmallFollow, "c12117", aVar.fEL.tabId, aVar.fEL.entryName, aVar.fEL.bce()));
                }
                if (aVar.fEM != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bGx().e(com.baidu.tieba.ala.alasquare.c.a.bGx().a(this.isSmallFollow, "c12117", aVar.fEM.tabId, aVar.fEM.entryName, aVar.fEM.bce()));
                }
            } else if (this.from == 2) {
                if (aVar.fEL != null && aVar.fEL.bce() != null && aVar.fEL.bce().beY() != null) {
                    bw bce = aVar.fEL.bce();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bce.beY().live_id).dD(TiebaInitialize.Params.OBJ_PARAM3, bce.beY().appId).dD("locate_type", aVar.fEL.entryName));
                }
                if (aVar.fEM != null && aVar.fEM.bce() != null && aVar.fEM.bce().beY() != null) {
                    bw bce2 = aVar.fEM.bce();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bce2.beY().live_id).dD(TiebaInitialize.Params.OBJ_PARAM3, bce2.beY().appId).dD("locate_type", aVar.fEM.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.fKb = iVar;
    }

    public void sz(int i) {
        this.isSmallFollow = i;
    }

    public void kP(boolean z) {
        this.fMb = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
