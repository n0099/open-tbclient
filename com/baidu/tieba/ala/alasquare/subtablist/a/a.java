package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListGameDoubleViewHolder;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, AlaSubListGameDoubleViewHolder> {
    private int from;
    private g gIx;
    private boolean gKx;
    private com.baidu.tieba.ala.alasquare.subtablist.view.a gKy;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.gKA);
        this.gKx = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public AlaSubListGameDoubleViewHolder e(ViewGroup viewGroup) {
        this.gKy = new com.baidu.tieba.ala.alasquare.subtablist.view.a(this.mPageContext, this.gKx);
        return new AlaSubListGameDoubleViewHolder(this.gKy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        a(aVar);
        alaSubListGameDoubleViewHolder.gKy.a(aVar);
        alaSubListGameDoubleViewHolder.gKy.d(this.gIx);
        return alaSubListGameDoubleViewHolder.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.gCV != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bVm().e(com.baidu.tieba.ala.alasquare.b.a.bVm().a(this.isSmallFollow, "c12117", aVar.gCV.tabId, aVar.gCV.entryName, aVar.gCV.boP()));
                }
                if (aVar.gCW != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bVm().e(com.baidu.tieba.ala.alasquare.b.a.bVm().a(this.isSmallFollow, "c12117", aVar.gCW.tabId, aVar.gCW.entryName, aVar.gCW.boP()));
                }
            } else if (this.from == 2) {
                if (aVar.gCV != null && aVar.gCV.boP() != null && aVar.gCV.boP().brK() != null) {
                    bz boP = aVar.gCV.boP();
                    TiebaStatic.log(new aq("c12115").w("obj_id", boP.brK().live_id).dX(TiebaInitialize.Params.OBJ_PARAM3, boP.brK().appId).dX("locate_type", aVar.gCV.entryName));
                }
                if (aVar.gCW != null && aVar.gCW.boP() != null && aVar.gCW.boP().brK() != null) {
                    bz boP2 = aVar.gCW.boP();
                    TiebaStatic.log(new aq("c12115").w("obj_id", boP2.brK().live_id).dX(TiebaInitialize.Params.OBJ_PARAM3, boP2.brK().appId).dX("locate_type", aVar.gCW.entryName));
                }
            }
        }
    }

    public void b(g gVar) {
        this.gIx = gVar;
    }

    public void vg(int i) {
        this.isSmallFollow = i;
    }

    public void mL(boolean z) {
        this.gKx = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
