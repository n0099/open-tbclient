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
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, AlaSubListLiveDoubleViewHolder> {
    private int from;
    private g gIy;
    private d gKA;
    private boolean gKy;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.gKC);
        this.gKy = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public AlaSubListLiveDoubleViewHolder e(ViewGroup viewGroup) {
        this.gKA = new d(this.mPageContext, this.gKy);
        return new AlaSubListLiveDoubleViewHolder(this.gKA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        b(bVar);
        alaSubListLiveDoubleViewHolder.gKA.a(bVar);
        alaSubListLiveDoubleViewHolder.gKA.d(this.gIy);
        return alaSubListLiveDoubleViewHolder.getView();
    }

    public void b(g gVar) {
        this.gIy = gVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.gCV != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bSk().e(com.baidu.tieba.ala.alasquare.b.a.bSk().a(this.isSmallFollow, "c12117", bVar.gCV.tabId, bVar.gCV.entryName, bVar.gCV.blp()));
                }
                if (bVar.gCW != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bSk().e(com.baidu.tieba.ala.alasquare.b.a.bSk().a(this.isSmallFollow, "c12117", bVar.gCW.tabId, bVar.gCW.entryName, bVar.gCW.blp()));
                }
            } else if (this.from == 2) {
                if (bVar.gCV != null && bVar.gCV.blp() != null && bVar.gCV.blp().bol() != null) {
                    cb blp = bVar.gCV.blp();
                    TiebaStatic.log(new ar("c12115").v("obj_id", blp.bol().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, blp.bol().appId).dR("locate_type", bVar.gCV.entryName));
                }
                if (bVar.gCW != null && bVar.gCW.blp() != null && bVar.gCW.blp().bol() != null) {
                    cb blp2 = bVar.gCW.blp();
                    TiebaStatic.log(new ar("c12115").v("obj_id", blp2.bol().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, blp2.bol().appId).dR("locate_type", bVar.gCW.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void tI(int i) {
        this.isSmallFollow = i;
    }

    public void mL(boolean z) {
        this.gKy = z;
    }
}
