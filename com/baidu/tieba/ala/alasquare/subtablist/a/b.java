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
    private i fKf;
    private boolean fMf;
    private e fMh;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.fMj);
        this.fMf = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public f b(ViewGroup viewGroup) {
        this.fMh = new e(this.mPageContext, this.fMf);
        return new f(this.fMh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.fMh.a(bVar);
        fVar.fMh.d(this.fKf);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.fKf = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.fEP != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bGy().e(com.baidu.tieba.ala.alasquare.c.a.bGy().a(this.isSmallFollow, "c12117", bVar.fEP.tabId, bVar.fEP.entryName, bVar.fEP.bce()));
                }
                if (bVar.fEQ != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bGy().e(com.baidu.tieba.ala.alasquare.c.a.bGy().a(this.isSmallFollow, "c12117", bVar.fEQ.tabId, bVar.fEQ.entryName, bVar.fEQ.bce()));
                }
            } else if (this.from == 2) {
                if (bVar.fEP != null && bVar.fEP.bce() != null && bVar.fEP.bce().beY() != null) {
                    bw bce = bVar.fEP.bce();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bce.beY().live_id).dD(TiebaInitialize.Params.OBJ_PARAM3, bce.beY().appId).dD("locate_type", bVar.fEP.entryName));
                }
                if (bVar.fEQ != null && bVar.fEQ.bce() != null && bVar.fEQ.bce().beY() != null) {
                    bw bce2 = bVar.fEQ.bce();
                    TiebaStatic.log(new aq("c12115").u("obj_id", bce2.beY().live_id).dD(TiebaInitialize.Params.OBJ_PARAM3, bce2.beY().appId).dD("locate_type", bVar.fEQ.entryName));
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

    public void kR(boolean z) {
        this.fMf = z;
    }
}
