package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, com.baidu.tieba.ala.alasquare.subtablist.c.b> {
    private i emV;
    private boolean eoZ;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a epa;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.epc);
        this.eoZ = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: N */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.epa = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.eoZ);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.epa);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.epa.a(aVar);
        bVar.epa.d(this.emV);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.ehP != null) {
                    com.baidu.tieba.ala.alasquare.c.a.baG().c(com.baidu.tieba.ala.alasquare.c.a.baG().a(this.isSmallFollow, "c12117", aVar.ehP.tabId, aVar.ehP.entryName, aVar.ehP.axQ()));
                }
                if (aVar.ehQ != null) {
                    com.baidu.tieba.ala.alasquare.c.a.baG().c(com.baidu.tieba.ala.alasquare.c.a.baG().a(this.isSmallFollow, "c12117", aVar.ehQ.tabId, aVar.ehQ.entryName, aVar.ehQ.axQ()));
                }
            } else if (this.from == 2) {
                if (aVar.ehP != null && aVar.ehP.axQ() != null && aVar.ehP.axQ().aAq() != null) {
                    bj axQ = aVar.ehP.axQ();
                    TiebaStatic.log(new an("c12115").s("obj_id", axQ.aAq().live_id).cp(TiebaInitialize.Params.OBJ_PARAM3, axQ.aAq().appId).cp("locate_type", aVar.ehP.entryName));
                }
                if (aVar.ehQ != null && aVar.ehQ.axQ() != null && aVar.ehQ.axQ().aAq() != null) {
                    bj axQ2 = aVar.ehQ.axQ();
                    TiebaStatic.log(new an("c12115").s("obj_id", axQ2.aAq().live_id).cp(TiebaInitialize.Params.OBJ_PARAM3, axQ2.aAq().appId).cp("locate_type", aVar.ehQ.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.emV = iVar;
    }

    public void ok(int i) {
        this.isSmallFollow = i;
    }

    public void hY(boolean z) {
        this.eoZ = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
