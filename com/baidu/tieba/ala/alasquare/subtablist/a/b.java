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
    private int from;
    private i gjP;
    private boolean glP;
    private e glR;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.glT);
        this.glP = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public f c(ViewGroup viewGroup) {
        this.glR = new e(this.mPageContext, this.glP);
        return new f(this.glR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.glR.a(bVar);
        fVar.glR.d(this.gjP);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.gjP = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.gep != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bNc().e(com.baidu.tieba.ala.alasquare.c.a.bNc().a(this.isSmallFollow, "c12117", bVar.gep.tabId, bVar.gep.entryName, bVar.gep.bhz()));
                }
                if (bVar.geq != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bNc().e(com.baidu.tieba.ala.alasquare.c.a.bNc().a(this.isSmallFollow, "c12117", bVar.geq.tabId, bVar.geq.entryName, bVar.geq.bhz()));
                }
            } else if (this.from == 2) {
                if (bVar.gep != null && bVar.gep.bhz() != null && bVar.gep.bhz().bku() != null) {
                    bw bhz = bVar.gep.bhz();
                    TiebaStatic.log(new aq("c12115").w("obj_id", bhz.bku().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bhz.bku().appId).dR("locate_type", bVar.gep.entryName));
                }
                if (bVar.geq != null && bVar.geq.bhz() != null && bVar.geq.bhz().bku() != null) {
                    bw bhz2 = bVar.geq.bhz();
                    TiebaStatic.log(new aq("c12115").w("obj_id", bhz2.bku().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bhz2.bku().appId).dR("locate_type", bVar.geq.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void tI(int i) {
        this.isSmallFollow = i;
    }

    public void lJ(boolean z) {
        this.glP = z;
    }
}
