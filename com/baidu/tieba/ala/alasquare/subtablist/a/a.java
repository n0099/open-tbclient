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
    private int from;
    private i gjP;
    private boolean glP;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a glQ;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.glS);
        this.glP = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b c(ViewGroup viewGroup) {
        this.glQ = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.glP);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.glQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.glQ.a(aVar);
        bVar.glQ.d(this.gjP);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.gep != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bNc().e(com.baidu.tieba.ala.alasquare.c.a.bNc().a(this.isSmallFollow, "c12117", aVar.gep.tabId, aVar.gep.entryName, aVar.gep.bhz()));
                }
                if (aVar.geq != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bNc().e(com.baidu.tieba.ala.alasquare.c.a.bNc().a(this.isSmallFollow, "c12117", aVar.geq.tabId, aVar.geq.entryName, aVar.geq.bhz()));
                }
            } else if (this.from == 2) {
                if (aVar.gep != null && aVar.gep.bhz() != null && aVar.gep.bhz().bku() != null) {
                    bw bhz = aVar.gep.bhz();
                    TiebaStatic.log(new aq("c12115").w("obj_id", bhz.bku().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bhz.bku().appId).dR("locate_type", aVar.gep.entryName));
                }
                if (aVar.geq != null && aVar.geq.bhz() != null && aVar.geq.bhz().bku() != null) {
                    bw bhz2 = aVar.geq.bhz();
                    TiebaStatic.log(new aq("c12115").w("obj_id", bhz2.bku().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bhz2.bku().appId).dR("locate_type", aVar.geq.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.gjP = iVar;
    }

    public void tI(int i) {
        this.isSmallFollow = i;
    }

    public void lJ(boolean z) {
        this.glP = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
