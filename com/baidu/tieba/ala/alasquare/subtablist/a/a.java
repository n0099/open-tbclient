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
    private i fKf;
    private boolean fMf;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a fMg;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.fMi);
        this.fMf = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.fMg = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.fMf);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.fMg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.fMg.a(aVar);
        bVar.fMg.d(this.fKf);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.fEP != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bGy().e(com.baidu.tieba.ala.alasquare.c.a.bGy().a(this.isSmallFollow, "c12117", aVar.fEP.tabId, aVar.fEP.entryName, aVar.fEP.bce()));
                }
                if (aVar.fEQ != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bGy().e(com.baidu.tieba.ala.alasquare.c.a.bGy().a(this.isSmallFollow, "c12117", aVar.fEQ.tabId, aVar.fEQ.entryName, aVar.fEQ.bce()));
                }
            } else if (this.from == 2) {
                if (aVar.fEP != null && aVar.fEP.bce() != null && aVar.fEP.bce().beY() != null) {
                    bw bce = aVar.fEP.bce();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bce.beY().live_id).dD(TiebaInitialize.Params.OBJ_PARAM3, bce.beY().appId).dD("locate_type", aVar.fEP.entryName));
                }
                if (aVar.fEQ != null && aVar.fEQ.bce() != null && aVar.fEQ.bce().beY() != null) {
                    bw bce2 = aVar.fEQ.bce();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bce2.beY().live_id).dD(TiebaInitialize.Params.OBJ_PARAM3, bce2.beY().appId).dD("locate_type", aVar.fEQ.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.fKf = iVar;
    }

    public void sz(int i) {
        this.isSmallFollow = i;
    }

    public void kR(boolean z) {
        this.fMf = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
