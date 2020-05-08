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
    private i eVu;
    private boolean eXu;
    private e eXw;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.eXy);
        this.eXu = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public f b(ViewGroup viewGroup) {
        this.eXw = new e(this.mPageContext, this.eXu);
        return new f(this.eXw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.eXw.a(bVar);
        fVar.eXw.d(this.eVu);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.eVu = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.eQe != null) {
                    com.baidu.tieba.ala.alasquare.c.a.blS().e(com.baidu.tieba.ala.alasquare.c.a.blS().a(this.isSmallFollow, "c12117", bVar.eQe.tabId, bVar.eQe.entryName, bVar.eQe.aIu()));
                }
                if (bVar.eQf != null) {
                    com.baidu.tieba.ala.alasquare.c.a.blS().e(com.baidu.tieba.ala.alasquare.c.a.blS().a(this.isSmallFollow, "c12117", bVar.eQf.tabId, bVar.eQf.entryName, bVar.eQf.aIu()));
                }
            } else if (this.from == 2) {
                if (bVar.eQe != null && bVar.eQe.aIu() != null && bVar.eQe.aIu().aKV() != null) {
                    bj aIu = bVar.eQe.aIu();
                    TiebaStatic.log(new an("c12115").t("obj_id", aIu.aKV().live_id).cI(TiebaInitialize.Params.OBJ_PARAM3, aIu.aKV().appId).cI("locate_type", bVar.eQe.entryName));
                }
                if (bVar.eQf != null && bVar.eQf.aIu() != null && bVar.eQf.aIu().aKV() != null) {
                    bj aIu2 = bVar.eQf.aIu();
                    TiebaStatic.log(new an("c12115").t("obj_id", aIu2.aKV().live_id).cI(TiebaInitialize.Params.OBJ_PARAM3, aIu2.aKV().appId).cI("locate_type", bVar.eQf.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void oW(int i) {
        this.isSmallFollow = i;
    }

    public void jh(boolean z) {
        this.eXu = z;
    }
}
