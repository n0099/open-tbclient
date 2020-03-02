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
    private i erj;
    private boolean etl;
    private e etn;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.etp);
        this.etl = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public f b(ViewGroup viewGroup) {
        this.etn = new e(this.mPageContext, this.etl);
        return new f(this.etn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.etn.a(bVar);
        fVar.etn.d(this.erj);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.erj = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.elV != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcX().d(com.baidu.tieba.ala.alasquare.c.a.bcX().a(this.isSmallFollow, "c12117", bVar.elV.tabId, bVar.elV.entryName, bVar.elV.aAg()));
                }
                if (bVar.elW != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcX().d(com.baidu.tieba.ala.alasquare.c.a.bcX().a(this.isSmallFollow, "c12117", bVar.elW.tabId, bVar.elW.entryName, bVar.elW.aAg()));
                }
            } else if (this.from == 2) {
                if (bVar.elV != null && bVar.elV.aAg() != null && bVar.elV.aAg().aCH() != null) {
                    bj aAg = bVar.elV.aAg();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAg.aCH().live_id).cy(TiebaInitialize.Params.OBJ_PARAM3, aAg.aCH().appId).cy("locate_type", bVar.elV.entryName));
                }
                if (bVar.elW != null && bVar.elW.aAg() != null && bVar.elW.aAg().aCH() != null) {
                    bj aAg2 = bVar.elW.aAg();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAg2.aCH().live_id).cy(TiebaInitialize.Params.OBJ_PARAM3, aAg2.aCH().appId).cy("locate_type", bVar.elW.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void oB(int i) {
        this.isSmallFollow = i;
    }

    /* renamed from: if  reason: not valid java name */
    public void m32if(boolean z) {
        this.etl = z;
    }
}
