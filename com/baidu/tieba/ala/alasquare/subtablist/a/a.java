package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListGameDoubleViewHolder;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, AlaSubListGameDoubleViewHolder> {
    private int from;
    private g gGB;
    private boolean gIB;
    private com.baidu.tieba.ala.alasquare.subtablist.view.a gIC;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.gIE);
        this.gIB = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public AlaSubListGameDoubleViewHolder e(ViewGroup viewGroup) {
        this.gIC = new com.baidu.tieba.ala.alasquare.subtablist.view.a(this.mPageContext, this.gIB);
        return new AlaSubListGameDoubleViewHolder(this.gIC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        a(aVar);
        alaSubListGameDoubleViewHolder.gIC.a(aVar);
        alaSubListGameDoubleViewHolder.gIC.d(this.gGB);
        return alaSubListGameDoubleViewHolder.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.gAY != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bRX().e(com.baidu.tieba.ala.alasquare.b.a.bRX().a(this.isSmallFollow, "c12117", aVar.gAY.tabId, aVar.gAY.entryName, aVar.gAY.bln()));
                }
                if (aVar.gAZ != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bRX().e(com.baidu.tieba.ala.alasquare.b.a.bRX().a(this.isSmallFollow, "c12117", aVar.gAZ.tabId, aVar.gAZ.entryName, aVar.gAZ.bln()));
                }
            } else if (this.from == 2) {
                if (aVar.gAY != null && aVar.gAY.bln() != null && aVar.gAY.bln().boj() != null) {
                    cb bln = aVar.gAY.bln();
                    TiebaStatic.log(new ar("c12115").v("obj_id", bln.boj().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bln.boj().appId).dR("locate_type", aVar.gAY.entryName));
                }
                if (aVar.gAZ != null && aVar.gAZ.bln() != null && aVar.gAZ.bln().boj() != null) {
                    cb bln2 = aVar.gAZ.bln();
                    TiebaStatic.log(new ar("c12115").v("obj_id", bln2.boj().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bln2.boj().appId).dR("locate_type", aVar.gAZ.entryName));
                }
            }
        }
    }

    public void b(g gVar) {
        this.gGB = gVar;
    }

    public void tG(int i) {
        this.isSmallFollow = i;
    }

    public void mL(boolean z) {
        this.gIB = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
