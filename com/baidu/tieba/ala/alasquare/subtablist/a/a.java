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
    private i erx;
    private boolean ety;
    private com.baidu.tieba.ala.alasquare.subtablist.c.a etz;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.etB);
        this.ety = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public com.baidu.tieba.ala.alasquare.subtablist.c.b b(ViewGroup viewGroup) {
        this.etz = new com.baidu.tieba.ala.alasquare.subtablist.c.a(this.mPageContext, this.ety);
        return new com.baidu.tieba.ala.alasquare.subtablist.c.b(this.etz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, com.baidu.tieba.ala.alasquare.subtablist.c.b bVar) {
        a(aVar);
        bVar.etz.a(aVar);
        bVar.etz.d(this.erx);
        return bVar.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.emi != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcY().d(com.baidu.tieba.ala.alasquare.c.a.bcY().a(this.isSmallFollow, "c12117", aVar.emi.tabId, aVar.emi.entryName, aVar.emi.aAg()));
                }
                if (aVar.emj != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcY().d(com.baidu.tieba.ala.alasquare.c.a.bcY().a(this.isSmallFollow, "c12117", aVar.emj.tabId, aVar.emj.entryName, aVar.emj.aAg()));
                }
            } else if (this.from == 2) {
                if (aVar.emi != null && aVar.emi.aAg() != null && aVar.emi.aAg().aCH() != null) {
                    bj aAg = aVar.emi.aAg();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAg.aCH().live_id).cy(TiebaInitialize.Params.OBJ_PARAM3, aAg.aCH().appId).cy("locate_type", aVar.emi.entryName));
                }
                if (aVar.emj != null && aVar.emj.aAg() != null && aVar.emj.aAg().aCH() != null) {
                    bj aAg2 = aVar.emj.aAg();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAg2.aCH().live_id).cy(TiebaInitialize.Params.OBJ_PARAM3, aAg2.aCH().appId).cy("locate_type", aVar.emj.entryName));
                }
            }
        }
    }

    public void b(i iVar) {
        this.erx = iVar;
    }

    public void oB(int i) {
        this.isSmallFollow = i;
    }

    /* renamed from: if  reason: not valid java name */
    public void m31if(boolean z) {
        this.ety = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
