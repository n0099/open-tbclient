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
    private g gGP;
    private boolean gIP;
    private com.baidu.tieba.ala.alasquare.subtablist.view.a gIQ;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.gIS);
        this.gIP = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public AlaSubListGameDoubleViewHolder e(ViewGroup viewGroup) {
        this.gIQ = new com.baidu.tieba.ala.alasquare.subtablist.view.a(this.mPageContext, this.gIP);
        return new AlaSubListGameDoubleViewHolder(this.gIQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        a(aVar);
        alaSubListGameDoubleViewHolder.gIQ.a(aVar);
        alaSubListGameDoubleViewHolder.gIQ.d(this.gGP);
        return alaSubListGameDoubleViewHolder.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.gBm != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bSe().e(com.baidu.tieba.ala.alasquare.b.a.bSe().a(this.isSmallFollow, "c12117", aVar.gBm.tabId, aVar.gBm.entryName, aVar.gBm.bln()));
                }
                if (aVar.gBn != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bSe().e(com.baidu.tieba.ala.alasquare.b.a.bSe().a(this.isSmallFollow, "c12117", aVar.gBn.tabId, aVar.gBn.entryName, aVar.gBn.bln()));
                }
            } else if (this.from == 2) {
                if (aVar.gBm != null && aVar.gBm.bln() != null && aVar.gBm.bln().boj() != null) {
                    cb bln = aVar.gBm.bln();
                    TiebaStatic.log(new ar("c12115").v("obj_id", bln.boj().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bln.boj().appId).dR("locate_type", aVar.gBm.entryName));
                }
                if (aVar.gBn != null && aVar.gBn.bln() != null && aVar.gBn.bln().boj() != null) {
                    cb bln2 = aVar.gBn.bln();
                    TiebaStatic.log(new ar("c12115").v("obj_id", bln2.boj().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bln2.boj().appId).dR("locate_type", aVar.gBn.entryName));
                }
            }
        }
    }

    public void b(g gVar) {
        this.gGP = gVar;
    }

    public void tG(int i) {
        this.isSmallFollow = i;
    }

    public void mL(boolean z) {
        this.gIP = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
