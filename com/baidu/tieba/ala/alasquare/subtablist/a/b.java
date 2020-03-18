package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.alasquare.subtablist.c.e;
import com.baidu.tieba.ala.alasquare.subtablist.c.f;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, f> {
    private i erT;
    private boolean etU;
    private e etW;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.etY);
        this.etU = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public f b(ViewGroup viewGroup) {
        this.etW = new e(this.mPageContext, this.etU);
        return new f(this.etW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.etW.a(bVar);
        fVar.etW.d(this.erT);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.erT = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.emz != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bdd().e(com.baidu.tieba.ala.alasquare.c.a.bdd().a(this.isSmallFollow, "c12117", bVar.emz.tabId, bVar.emz.entryName, bVar.emz.aAj()));
                }
                if (bVar.emA != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bdd().e(com.baidu.tieba.ala.alasquare.c.a.bdd().a(this.isSmallFollow, "c12117", bVar.emA.tabId, bVar.emA.entryName, bVar.emA.aAj()));
                }
            } else if (this.from == 2) {
                if (bVar.emz != null && bVar.emz.aAj() != null && bVar.emz.aAj().aCK() != null) {
                    bj aAj = bVar.emz.aAj();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAj.aCK().live_id).cx(TiebaInitialize.Params.OBJ_PARAM3, aAj.aCK().appId).cx("locate_type", bVar.emz.entryName));
                }
                if (bVar.emA != null && bVar.emA.aAj() != null && bVar.emA.aAj().aCK() != null) {
                    bj aAj2 = bVar.emA.aAj();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAj2.aCK().live_id).cx(TiebaInitialize.Params.OBJ_PARAM3, aAj2.aCK().appId).cx("locate_type", bVar.emA.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void oD(int i) {
        this.isSmallFollow = i;
    }

    public void ih(boolean z) {
        this.etU = z;
    }
}
