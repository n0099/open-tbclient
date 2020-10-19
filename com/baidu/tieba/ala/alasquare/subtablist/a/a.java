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
    private i fZK;
    private int from;
    private boolean gbL;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a gbM;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.gbO);
        this.gbL = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b c(ViewGroup viewGroup) {
        this.gbM = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.gbL);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.gbM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.gbM.a(aVar);
        bVar.gbM.d(this.fZK);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.fUl != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bKA().e(com.baidu.tieba.ala.alasquare.c.a.bKA().a(this.isSmallFollow, "c12117", aVar.fUl.tabId, aVar.fUl.entryName, aVar.fUl.bfG()));
                }
                if (aVar.fUm != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bKA().e(com.baidu.tieba.ala.alasquare.c.a.bKA().a(this.isSmallFollow, "c12117", aVar.fUm.tabId, aVar.fUm.entryName, aVar.fUm.bfG()));
                }
            } else if (this.from == 2) {
                if (aVar.fUl != null && aVar.fUl.bfG() != null && aVar.fUl.bfG().biB() != null) {
                    bw bfG = aVar.fUl.bfG();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bfG.biB().live_id).dK(TiebaInitialize.Params.OBJ_PARAM3, bfG.biB().appId).dK("locate_type", aVar.fUl.entryName));
                }
                if (aVar.fUm != null && aVar.fUm.bfG() != null && aVar.fUm.bfG().biB() != null) {
                    bw bfG2 = aVar.fUm.bfG();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bfG2.biB().live_id).dK(TiebaInitialize.Params.OBJ_PARAM3, bfG2.biB().appId).dK("locate_type", aVar.fUm.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.fZK = iVar;
    }

    public void tp(int i) {
        this.isSmallFollow = i;
    }

    public void lr(boolean z) {
        this.gbL = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
