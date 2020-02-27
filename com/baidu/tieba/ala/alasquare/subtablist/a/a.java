package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, com.baidu.tieba.ala.alasquare.subtablist.c.b> {
    private i eri;
    private boolean etk;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a etl;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.etn);
        this.etk = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.etl = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.etk);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.etl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.etl.a(aVar);
        bVar.etl.d(this.eri);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.elU != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcV().d(com.baidu.tieba.ala.alasquare.c.a.bcV().a(this.isSmallFollow, "c12117", aVar.elU.tabId, aVar.elU.entryName, aVar.elU.aAe()));
                }
                if (aVar.elV != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcV().d(com.baidu.tieba.ala.alasquare.c.a.bcV().a(this.isSmallFollow, "c12117", aVar.elV.tabId, aVar.elV.entryName, aVar.elV.aAe()));
                }
            } else if (this.from == 2) {
                if (aVar.elU != null && aVar.elU.aAe() != null && aVar.elU.aAe().aCF() != null) {
                    bj aAe = aVar.elU.aAe();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAe.aCF().live_id).cy(TiebaInitialize.Params.OBJ_PARAM3, aAe.aCF().appId).cy("locate_type", aVar.elU.entryName));
                }
                if (aVar.elV != null && aVar.elV.aAe() != null && aVar.elV.aAe().aCF() != null) {
                    bj aAe2 = aVar.elV.aAe();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAe2.aCF().live_id).cy(TiebaInitialize.Params.OBJ_PARAM3, aAe2.aCF().appId).cy("locate_type", aVar.elV.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.eri = iVar;
    }

    public void oB(int i) {
        this.isSmallFollow = i;
    }

    /* renamed from: if  reason: not valid java name */
    public void m31if(boolean z) {
        this.etk = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
