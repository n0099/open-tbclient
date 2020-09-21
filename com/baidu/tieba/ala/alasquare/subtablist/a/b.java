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
    private i fNt;
    private boolean fPt;
    private e fPv;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.fPx);
        this.fPt = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public f c(ViewGroup viewGroup) {
        this.fPv = new e(this.mPageContext, this.fPt);
        return new f(this.fPv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.fPv.a(bVar);
        fVar.fPv.d(this.fNt);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.fNt = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.fIb != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bHO().e(com.baidu.tieba.ala.alasquare.c.a.bHO().a(this.isSmallFollow, "c12117", bVar.fIb.tabId, bVar.fIb.entryName, bVar.fIb.bcY()));
                }
                if (bVar.fIc != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bHO().e(com.baidu.tieba.ala.alasquare.c.a.bHO().a(this.isSmallFollow, "c12117", bVar.fIc.tabId, bVar.fIc.entryName, bVar.fIc.bcY()));
                }
            } else if (this.from == 2) {
                if (bVar.fIb != null && bVar.fIb.bcY() != null && bVar.fIb.bcY().bfS() != null) {
                    bw bcY = bVar.fIb.bcY();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bcY.bfS().live_id).dF(TiebaInitialize.Params.OBJ_PARAM3, bcY.bfS().appId).dF("locate_type", bVar.fIb.entryName));
                }
                if (bVar.fIc != null && bVar.fIc.bcY() != null && bVar.fIc.bcY().bfS() != null) {
                    bw bcY2 = bVar.fIc.bcY();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bcY2.bfS().live_id).dF(TiebaInitialize.Params.OBJ_PARAM3, bcY2.bfS().appId).dF("locate_type", bVar.fIc.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void sR(int i) {
        this.isSmallFollow = i;
    }

    public void kT(boolean z) {
        this.fPt = z;
    }
}
