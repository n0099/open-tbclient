package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, com.baidu.tieba.ala.alasquare.subtablist.c.b> {
    private boolean fAJ;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a fAK;
    private int from;
    private i fyJ;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.fAM);
        this.fAJ = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.fAK = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.fAJ);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.fAK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.fAK.a(aVar);
        bVar.fAK.d(this.fyJ);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.fts != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bxy().e(com.baidu.tieba.ala.alasquare.c.a.bxy().a(this.isSmallFollow, "c12117", aVar.fts.tabId, aVar.fts.entryName, aVar.fts.aTN()));
                }
                if (aVar.ftt != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bxy().e(com.baidu.tieba.ala.alasquare.c.a.bxy().a(this.isSmallFollow, "c12117", aVar.ftt.tabId, aVar.ftt.entryName, aVar.ftt.aTN()));
                }
            } else if (this.from == 2) {
                if (aVar.fts != null && aVar.fts.aTN() != null && aVar.fts.aTN().aWF() != null) {
                    bv aTN = aVar.fts.aTN();
                    TiebaStatic.log(new ap("c12115").t("obj_id", aTN.aWF().live_id).dn(TiebaInitialize.Params.OBJ_PARAM3, aTN.aWF().appId).dn("locate_type", aVar.fts.entryName));
                }
                if (aVar.ftt != null && aVar.ftt.aTN() != null && aVar.ftt.aTN().aWF() != null) {
                    bv aTN2 = aVar.ftt.aTN();
                    TiebaStatic.log(new ap("c12115").t("obj_id", aTN2.aWF().live_id).dn(TiebaInitialize.Params.OBJ_PARAM3, aTN2.aWF().appId).dn("locate_type", aVar.ftt.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.fyJ = iVar;
    }

    public void qn(int i) {
        this.isSmallFollow = i;
    }

    public void kr(boolean z) {
        this.fAJ = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
