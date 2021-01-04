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
                    com.baidu.tieba.ala.alasquare.b.a.bVl().e(com.baidu.tieba.ala.alasquare.b.a.bVl().a(this.isSmallFollow, "c12117", aVar.gCV.tabId, aVar.gCV.entryName, aVar.gCV.boO()));
                }
                if (aVar.gCW != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bVl().e(com.baidu.tieba.ala.alasquare.b.a.bVl().a(this.isSmallFollow, "c12117", aVar.gCW.tabId, aVar.gCW.entryName, aVar.gCW.boO()));
                }
            } else if (this.from == 2) {
                if (aVar.gCV != null && aVar.gCV.boO() != null && aVar.gCV.boO().brJ() != null) {
                    bz boO = aVar.gCV.boO();
                    TiebaStatic.log(new aq("c12115").w("obj_id", boO.brJ().live_id).dX(TiebaInitialize.Params.OBJ_PARAM3, boO.brJ().appId).dX("locate_type", aVar.gCV.entryName));
                }
                if (aVar.gCW != null && aVar.gCW.boO() != null && aVar.gCW.boO().brJ() != null) {
                    bz boO2 = aVar.gCW.boO();
                    TiebaStatic.log(new aq("c12115").w("obj_id", boO2.brJ().live_id).dX(TiebaInitialize.Params.OBJ_PARAM3, boO2.brJ().appId).dX("locate_type", aVar.gCW.entryName));
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
