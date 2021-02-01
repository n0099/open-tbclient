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
    private g gGB;
    private boolean gIB;
    private d gID;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.gIF);
        this.gIB = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public AlaSubListLiveDoubleViewHolder e(ViewGroup viewGroup) {
        this.gID = new d(this.mPageContext, this.gIB);
        return new AlaSubListLiveDoubleViewHolder(this.gID);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        b(bVar);
        alaSubListLiveDoubleViewHolder.gID.a(bVar);
        alaSubListLiveDoubleViewHolder.gID.d(this.gGB);
        return alaSubListLiveDoubleViewHolder.getView();
    }

    public void b(g gVar) {
        this.gGB = gVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.gAY != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bRX().e(com.baidu.tieba.ala.alasquare.b.a.bRX().a(this.isSmallFollow, "c12117", bVar.gAY.tabId, bVar.gAY.entryName, bVar.gAY.bln()));
                }
                if (bVar.gAZ != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bRX().e(com.baidu.tieba.ala.alasquare.b.a.bRX().a(this.isSmallFollow, "c12117", bVar.gAZ.tabId, bVar.gAZ.entryName, bVar.gAZ.bln()));
                }
            } else if (this.from == 2) {
                if (bVar.gAY != null && bVar.gAY.bln() != null && bVar.gAY.bln().boj() != null) {
                    cb bln = bVar.gAY.bln();
                    TiebaStatic.log(new ar("c12115").v("obj_id", bln.boj().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bln.boj().appId).dR("locate_type", bVar.gAY.entryName));
                }
                if (bVar.gAZ != null && bVar.gAZ.bln() != null && bVar.gAZ.bln().boj() != null) {
                    cb bln2 = bVar.gAZ.bln();
                    TiebaStatic.log(new ar("c12115").v("obj_id", bln2.boj().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, bln2.boj().appId).dR("locate_type", bVar.gAZ.entryName));
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
        this.gIB = z;
    }
}
