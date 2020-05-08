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
    private i eVu;
    private boolean eXu;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a eXv;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.eXx);
        this.eXu = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.eXv = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.eXu);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.eXv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.eXv.a(aVar);
        bVar.eXv.d(this.eVu);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.eQe != null) {
                    com.baidu.tieba.ala.alasquare.c.a.blS().e(com.baidu.tieba.ala.alasquare.c.a.blS().a(this.isSmallFollow, "c12117", aVar.eQe.tabId, aVar.eQe.entryName, aVar.eQe.aIu()));
                }
                if (aVar.eQf != null) {
                    com.baidu.tieba.ala.alasquare.c.a.blS().e(com.baidu.tieba.ala.alasquare.c.a.blS().a(this.isSmallFollow, "c12117", aVar.eQf.tabId, aVar.eQf.entryName, aVar.eQf.aIu()));
                }
            } else if (this.from == 2) {
                if (aVar.eQe != null && aVar.eQe.aIu() != null && aVar.eQe.aIu().aKV() != null) {
                    bj aIu = aVar.eQe.aIu();
                    TiebaStatic.log(new an("c12115").t("obj_id", aIu.aKV().live_id).cI(TiebaInitialize.Params.OBJ_PARAM3, aIu.aKV().appId).cI("locate_type", aVar.eQe.entryName));
                }
                if (aVar.eQf != null && aVar.eQf.aIu() != null && aVar.eQf.aIu().aKV() != null) {
                    bj aIu2 = aVar.eQf.aIu();
                    TiebaStatic.log(new an("c12115").t("obj_id", aIu2.aKV().live_id).cI(TiebaInitialize.Params.OBJ_PARAM3, aIu2.aKV().appId).cI("locate_type", aVar.eQf.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.eVu = iVar;
    }

    public void oW(int i) {
        this.isSmallFollow = i;
    }

    public void jh(boolean z) {
        this.eXu = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
