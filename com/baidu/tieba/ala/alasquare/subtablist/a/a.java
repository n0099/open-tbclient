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
    private i fNt;
    private boolean fPt;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a fPu;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.fPw);
        this.fPt = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b c(ViewGroup viewGroup) {
        this.fPu = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.fPt);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.fPu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.fPu.a(aVar);
        bVar.fPu.d(this.fNt);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.fIb != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bHO().e(com.baidu.tieba.ala.alasquare.c.a.bHO().a(this.isSmallFollow, "c12117", aVar.fIb.tabId, aVar.fIb.entryName, aVar.fIb.bcY()));
                }
                if (aVar.fIc != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bHO().e(com.baidu.tieba.ala.alasquare.c.a.bHO().a(this.isSmallFollow, "c12117", aVar.fIc.tabId, aVar.fIc.entryName, aVar.fIc.bcY()));
                }
            } else if (this.from == 2) {
                if (aVar.fIb != null && aVar.fIb.bcY() != null && aVar.fIb.bcY().bfS() != null) {
                    bw bcY = aVar.fIb.bcY();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bcY.bfS().live_id).dF(TiebaInitialize.Params.OBJ_PARAM3, bcY.bfS().appId).dF("locate_type", aVar.fIb.entryName));
                }
                if (aVar.fIc != null && aVar.fIc.bcY() != null && aVar.fIc.bcY().bfS() != null) {
                    bw bcY2 = aVar.fIc.bcY();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bcY2.bfS().live_id).dF(TiebaInitialize.Params.OBJ_PARAM3, bcY2.bfS().appId).dF("locate_type", aVar.fIc.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.fNt = iVar;
    }

    public void sR(int i) {
        this.isSmallFollow = i;
    }

    public void kT(boolean z) {
        this.fPt = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
