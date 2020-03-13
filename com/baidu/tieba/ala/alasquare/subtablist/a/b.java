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
    private i erx;
    private e etA;
    private boolean ety;
    private int from;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.etC);
        this.ety = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public f b(ViewGroup viewGroup) {
        this.etA = new e(this.mPageContext, this.ety);
        return new f(this.etA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, f fVar) {
        b(bVar);
        fVar.etA.a(bVar);
        fVar.etA.d(this.erx);
        return fVar.getView();
    }

    public void b(i iVar) {
        this.erx = iVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.emi != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcY().d(com.baidu.tieba.ala.alasquare.c.a.bcY().a(this.isSmallFollow, "c12117", bVar.emi.tabId, bVar.emi.entryName, bVar.emi.aAg()));
                }
                if (bVar.emj != null) {
                    com.baidu.tieba.ala.alasquare.c.a.bcY().d(com.baidu.tieba.ala.alasquare.c.a.bcY().a(this.isSmallFollow, "c12117", bVar.emj.tabId, bVar.emj.entryName, bVar.emj.aAg()));
                }
            } else if (this.from == 2) {
                if (bVar.emi != null && bVar.emi.aAg() != null && bVar.emi.aAg().aCH() != null) {
                    bj aAg = bVar.emi.aAg();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAg.aCH().live_id).cy(TiebaInitialize.Params.OBJ_PARAM3, aAg.aCH().appId).cy("locate_type", bVar.emi.entryName));
                }
                if (bVar.emj != null && bVar.emj.aAg() != null && bVar.emj.aAg().aCH() != null) {
                    bj aAg2 = bVar.emj.aAg();
                    TiebaStatic.log(new an("c12115").s("obj_id", aAg2.aCH().live_id).cy(TiebaInitialize.Params.OBJ_PARAM3, aAg2.aCH().appId).cy("locate_type", bVar.emj.entryName));
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
        this.ety = z;
    }
}
