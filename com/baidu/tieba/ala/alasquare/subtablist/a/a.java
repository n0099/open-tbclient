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
    private i erT;
    private boolean etU;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a etV;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.etX);
        this.etU = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.etV = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.etU);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.etV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.etV.a(aVar);
        bVar.etV.d(this.erT);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.emz != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bdd().e(com.baidu.tieba.ala.alasquare.c.a.bdd().a(this.isSmallFollow, "c12117", aVar.emz.tabId, aVar.emz.entryName, aVar.emz.aAj()));
                }
                if (aVar.emA != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bdd().e(com.baidu.tieba.ala.alasquare.c.a.bdd().a(this.isSmallFollow, "c12117", aVar.emA.tabId, aVar.emA.entryName, aVar.emA.aAj()));
                }
            } else if (this.from == 2) {
                if (aVar.emz != null && aVar.emz.aAj() != null && aVar.emz.aAj().aCK() != null) {
                    bj aAj = aVar.emz.aAj();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAj.aCK().live_id).cx(TiebaInitialize.Params.OBJ_PARAM3, aAj.aCK().appId).cx("locate_type", aVar.emz.entryName));
                }
                if (aVar.emA != null && aVar.emA.aAj() != null && aVar.emA.aAj().aCK() != null) {
                    bj aAj2 = aVar.emA.aAj();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAj2.aCK().live_id).cx(TiebaInitialize.Params.OBJ_PARAM3, aAj2.aCK().appId).cx("locate_type", aVar.emA.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.erT = iVar;
    }

    public void oD(int i) {
        this.isSmallFollow = i;
    }

    public void ih(boolean z) {
        this.etU = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
