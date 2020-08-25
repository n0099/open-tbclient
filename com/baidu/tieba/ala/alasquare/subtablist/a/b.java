package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.ala.alasquare.subtablist.c.e;
import com.baidu.tieba.ala.alasquare.subtablist.c.f;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, f> {
    private i fKb;
    private boolean fMb;
    private e fMd;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.fMf);
        this.fMb = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public f b(ViewGroup viewGroup) {
        this.fMd = new e(this.mPageContext, this.fMb);
        return new f(this.fMd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.fMd.a(bVar);
        fVar.fMd.d(this.fKb);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.fKb = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.fEL != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bGx().e(com.baidu.tieba.ala.alasquare.c.a.bGx().a(this.isSmallFollow, "c12117", bVar.fEL.tabId, bVar.fEL.entryName, bVar.fEL.bce()));
                }
                if (bVar.fEM != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bGx().e(com.baidu.tieba.ala.alasquare.c.a.bGx().a(this.isSmallFollow, "c12117", bVar.fEM.tabId, bVar.fEM.entryName, bVar.fEM.bce()));
                }
            } else if (this.from == 2) {
                if (bVar.fEL != null && bVar.fEL.bce() != null && bVar.fEL.bce().beY() != null) {
                    bw bce = bVar.fEL.bce();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bce.beY().live_id).dD(TiebaInitialize.Params.OBJ_PARAM3, bce.beY().appId).dD("locate_type", bVar.fEL.entryName));
                }
                if (bVar.fEM != null && bVar.fEM.bce() != null && bVar.fEM.bce().beY() != null) {
                    bw bce2 = bVar.fEM.bce();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bce2.beY().live_id).dD(TiebaInitialize.Params.OBJ_PARAM3, bce2.beY().appId).dD("locate_type", bVar.fEM.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void sz(int i) {
        this.isSmallFollow = i;
    }

    public void kP(boolean z) {
        this.fMb = z;
    }
}
