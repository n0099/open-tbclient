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
    private i eri;
    private boolean etk;
    private e etm;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.eto);
        this.etk = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public f b(ViewGroup viewGroup) {
        this.etm = new e(this.mPageContext, this.etk);
        return new f(this.etm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.etm.a(bVar);
        fVar.etm.d(this.eri);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.eri = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.elU != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcV().d(com.baidu.tieba.ala.alasquare.c.a.bcV().a(this.isSmallFollow, "c12117", bVar.elU.tabId, bVar.elU.entryName, bVar.elU.aAe()));
                }
                if (bVar.elV != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcV().d(com.baidu.tieba.ala.alasquare.c.a.bcV().a(this.isSmallFollow, "c12117", bVar.elV.tabId, bVar.elV.entryName, bVar.elV.aAe()));
                }
            } else if (this.from == 2) {
                if (bVar.elU != null && bVar.elU.aAe() != null && bVar.elU.aAe().aCF() != null) {
                    bj aAe = bVar.elU.aAe();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAe.aCF().live_id).cy(TiebaInitialize.Params.OBJ_PARAM3, aAe.aCF().appId).cy("locate_type", bVar.elU.entryName));
                }
                if (bVar.elV != null && bVar.elV.aAe() != null && bVar.elV.aAe().aCF() != null) {
                    bj aAe2 = bVar.elV.aAe();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAe2.aCF().live_id).cy(TiebaInitialize.Params.OBJ_PARAM3, aAe2.aCF().appId).cy("locate_type", bVar.elV.entryName));
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
        this.etk = z;
    }
}
