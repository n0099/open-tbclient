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
    private i erj;
    private boolean etl;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a etm;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.eto);
        this.etl = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.etm = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.etl);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.etm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.etm.a(aVar);
        bVar.etm.d(this.erj);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.elV != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcX().d(com.baidu.tieba.ala.alasquare.c.a.bcX().a(this.isSmallFollow, "c12117", aVar.elV.tabId, aVar.elV.entryName, aVar.elV.aAg()));
                }
                if (aVar.elW != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcX().d(com.baidu.tieba.ala.alasquare.c.a.bcX().a(this.isSmallFollow, "c12117", aVar.elW.tabId, aVar.elW.entryName, aVar.elW.aAg()));
                }
            } else if (this.from == 2) {
                if (aVar.elV != null && aVar.elV.aAg() != null && aVar.elV.aAg().aCH() != null) {
                    bj aAg = aVar.elV.aAg();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAg.aCH().live_id).cy(TiebaInitialize.Params.OBJ_PARAM3, aAg.aCH().appId).cy("locate_type", aVar.elV.entryName));
                }
                if (aVar.elW != null && aVar.elW.aAg() != null && aVar.elW.aAg().aCH() != null) {
                    bj aAg2 = aVar.elW.aAg();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAg2.aCH().live_id).cy(TiebaInitialize.Params.OBJ_PARAM3, aAg2.aCH().appId).cy("locate_type", aVar.elW.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.erj = iVar;
    }

    public void oB(int i) {
        this.isSmallFollow = i;
    }

    /* renamed from: if  reason: not valid java name */
    public void m31if(boolean z) {
        this.etl = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
