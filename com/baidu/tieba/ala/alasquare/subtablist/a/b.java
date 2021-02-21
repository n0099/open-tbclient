package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListLiveDoubleViewHolder;
import com.baidu.tieba.ala.alasquare.subtablist.view.d;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
/* loaded from: classes10.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, AlaSubListLiveDoubleViewHolder> {
    private int from;
    private g gGP;
    private boolean gIP;
    private d gIR;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.gIT);
        this.gIP = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public AlaSubListLiveDoubleViewHolder e(ViewGroup viewGroup) {
        this.gIR = new d(this.mPageContext, this.gIP);
        return new AlaSubListLiveDoubleViewHolder(this.gIR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        b(bVar);
        alaSubListLiveDoubleViewHolder.gIR.a(bVar);
        alaSubListLiveDoubleViewHolder.gIR.d(this.gGP);
        return alaSubListLiveDoubleViewHolder.getView();
    }

    public void b(g gVar) {
        this.gGP = gVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.gBm != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bSe().e(com.baidu.tieba.ala.alasquare.b.a.bSe().a(this.isSmallFollow, "c12117", bVar.gBm.tabId, bVar.gBm.entryName, bVar.gBm.bln()));
                }
                if (bVar.gBn != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bSe().e(com.baidu.tieba.ala.alasquare.b.a.bSe().a(this.isSmallFollow, "c12117", bVar.gBn.tabId, bVar.gBn.entryName, bVar.gBn.bln()));
                }
            } else if (this.from == 2) {
                if (bVar.gBm != null && bVar.gBm.bln() != null && bVar.gBm.bln().boj() != null) {
                    cb bln = bVar.gBm.bln();
                    TiebaStatic.log(new ar("c12115").v("obj_id", bln.boj().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bln.boj().appId).dR("locate_type", bVar.gBm.entryName));
                }
                if (bVar.gBn != null && bVar.gBn.bln() != null && bVar.gBn.bln().boj() != null) {
                    cb bln2 = bVar.gBn.bln();
                    TiebaStatic.log(new ar("c12115").v("obj_id", bln2.boj().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bln2.boj().appId).dR("locate_type", bVar.gBn.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void tG(int i) {
        this.isSmallFollow = i;
    }

    public void mL(boolean z) {
        this.gIP = z;
    }
}
