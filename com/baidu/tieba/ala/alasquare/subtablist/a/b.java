package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.ala.alasquare.subtablist.c.e;
import com.baidu.tieba.ala.alasquare.subtablist.c.f;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes4.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, f> {
    private boolean fAJ;
    private e fAL;
    private int from;
    private i fyJ;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.fAN);
        this.fAJ = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public f b(ViewGroup viewGroup) {
        this.fAL = new e(this.mPageContext, this.fAJ);
        return new f(this.fAL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.fAL.a(bVar);
        fVar.fAL.d(this.fyJ);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.fyJ = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.fts != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bxy().e(com.baidu.tieba.ala.alasquare.c.a.bxy().a(this.isSmallFollow, "c12117", bVar.fts.tabId, bVar.fts.entryName, bVar.fts.aTN()));
                }
                if (bVar.ftt != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bxy().e(com.baidu.tieba.ala.alasquare.c.a.bxy().a(this.isSmallFollow, "c12117", bVar.ftt.tabId, bVar.ftt.entryName, bVar.ftt.aTN()));
                }
            } else if (this.from == 2) {
                if (bVar.fts != null && bVar.fts.aTN() != null && bVar.fts.aTN().aWF() != null) {
                    bv aTN = bVar.fts.aTN();
                    TiebaStatic.log(new ap("c12115").t("obj_id", aTN.aWF().live_id).dn(TiebaInitialize.Params.OBJ_PARAM3, aTN.aWF().appId).dn("locate_type", bVar.fts.entryName));
                }
                if (bVar.ftt != null && bVar.ftt.aTN() != null && bVar.ftt.aTN().aWF() != null) {
                    bv aTN2 = bVar.ftt.aTN();
                    TiebaStatic.log(new ap("c12115").t("obj_id", aTN2.aWF().live_id).dn(TiebaInitialize.Params.OBJ_PARAM3, aTN2.aWF().appId).dn("locate_type", bVar.ftt.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void qn(int i) {
        this.isSmallFollow = i;
    }

    public void kr(boolean z) {
        this.fAJ = z;
    }
}
