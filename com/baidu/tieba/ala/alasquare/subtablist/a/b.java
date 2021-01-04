package com.baidu.tieba.ala.alasquare.subtablist.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListLiveDoubleViewHolder;
import com.baidu.tieba.ala.alasquare.subtablist.view.d;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
/* loaded from: classes10.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, AlaSubListLiveDoubleViewHolder> {
    private int from;
    private g gIx;
    private boolean gKx;
    private d gKz;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.gKB);
        this.gKx = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public AlaSubListLiveDoubleViewHolder e(ViewGroup viewGroup) {
        this.gKz = new d(this.mPageContext, this.gKx);
        return new AlaSubListLiveDoubleViewHolder(this.gKz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        b(bVar);
        alaSubListLiveDoubleViewHolder.gKz.a(bVar);
        alaSubListLiveDoubleViewHolder.gKz.d(this.gIx);
        return alaSubListLiveDoubleViewHolder.getView();
    }

    public void b(g gVar) {
        this.gIx = gVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.gCV != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bVl().e(com.baidu.tieba.ala.alasquare.b.a.bVl().a(this.isSmallFollow, "c12117", bVar.gCV.tabId, bVar.gCV.entryName, bVar.gCV.boO()));
                }
                if (bVar.gCW != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bVl().e(com.baidu.tieba.ala.alasquare.b.a.bVl().a(this.isSmallFollow, "c12117", bVar.gCW.tabId, bVar.gCW.entryName, bVar.gCW.boO()));
                }
            } else if (this.from == 2) {
                if (bVar.gCV != null && bVar.gCV.boO() != null && bVar.gCV.boO().brJ() != null) {
                    bz boO = bVar.gCV.boO();
                    TiebaStatic.log(new aq("c12115").w("obj_id", boO.brJ().live_id).dX(TiebaInitialize.Params.OBJ_PARAM3, boO.brJ().appId).dX("locate_type", bVar.gCV.entryName));
                }
                if (bVar.gCW != null && bVar.gCW.boO() != null && bVar.gCW.boO().brJ() != null) {
                    bz boO2 = bVar.gCW.boO();
                    TiebaStatic.log(new aq("c12115").w("obj_id", boO2.brJ().live_id).dX(TiebaInitialize.Params.OBJ_PARAM3, boO2.brJ().appId).dX("locate_type", bVar.gCW.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void vg(int i) {
        this.isSmallFollow = i;
    }

    public void mL(boolean z) {
        this.gKx = z;
    }
}
