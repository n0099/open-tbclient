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
    private i fZK;
    private int from;
    private boolean gbL;
    private e gbN;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.gbP);
        this.gbL = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public f c(ViewGroup viewGroup) {
        this.gbN = new e(this.mPageContext, this.gbL);
        return new f(this.gbN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.gbN.a(bVar);
        fVar.gbN.d(this.fZK);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.fZK = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.fUl != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bKA().e(com.baidu.tieba.ala.alasquare.c.a.bKA().a(this.isSmallFollow, "c12117", bVar.fUl.tabId, bVar.fUl.entryName, bVar.fUl.bfG()));
                }
                if (bVar.fUm != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bKA().e(com.baidu.tieba.ala.alasquare.c.a.bKA().a(this.isSmallFollow, "c12117", bVar.fUm.tabId, bVar.fUm.entryName, bVar.fUm.bfG()));
                }
            } else if (this.from == 2) {
                if (bVar.fUl != null && bVar.fUl.bfG() != null && bVar.fUl.bfG().biB() != null) {
                    bw bfG = bVar.fUl.bfG();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bfG.biB().live_id).dK(TiebaInitialize.Params.OBJ_PARAM3, bfG.biB().appId).dK("locate_type", bVar.fUl.entryName));
                }
                if (bVar.fUm != null && bVar.fUm.bfG() != null && bVar.fUm.bfG().biB() != null) {
                    bw bfG2 = bVar.fUm.bfG();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bfG2.biB().live_id).dK(TiebaInitialize.Params.OBJ_PARAM3, bfG2.biB().appId).dK("locate_type", bVar.fUm.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void tp(int i) {
        this.isSmallFollow = i;
    }

    public void lr(boolean z) {
        this.gbL = z;
    }
}
