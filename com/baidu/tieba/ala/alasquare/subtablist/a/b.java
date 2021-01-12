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
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.b, AlaSubListLiveDoubleViewHolder> {
    private int from;
    private g gDR;
    private boolean gFR;
    private d gFT;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.b.gFV);
        this.gFR = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public AlaSubListLiveDoubleViewHolder e(ViewGroup viewGroup) {
        this.gFT = new d(this.mPageContext, this.gFR);
        return new AlaSubListLiveDoubleViewHolder(this.gFT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.b bVar, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        b(bVar);
        alaSubListLiveDoubleViewHolder.gFT.a(bVar);
        alaSubListLiveDoubleViewHolder.gFT.d(this.gDR);
        return alaSubListLiveDoubleViewHolder.getView();
    }

    public void b(g gVar) {
        this.gDR = gVar;
    }

    private void b(com.baidu.tieba.ala.alasquare.subtablist.b.b bVar) {
        if (bVar != null) {
            if (this.from == 1) {
                if (bVar.gyo != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bRu().e(com.baidu.tieba.ala.alasquare.b.a.bRu().a(this.isSmallFollow, "c12117", bVar.gyo.tabId, bVar.gyo.entryName, bVar.gyo.bkV()));
                }
                if (bVar.gyp != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bRu().e(com.baidu.tieba.ala.alasquare.b.a.bRu().a(this.isSmallFollow, "c12117", bVar.gyp.tabId, bVar.gyp.entryName, bVar.gyp.bkV()));
                }
            } else if (this.from == 2) {
                if (bVar.gyo != null && bVar.gyo.bkV() != null && bVar.gyo.bkV().bnQ() != null) {
                    bz bkV = bVar.gyo.bkV();
                    TiebaStatic.log(new aq("c12115").w("obj_id", bkV.bnQ().live_id).dW(TiebaInitialize.Params.OBJ_PARAM3, bkV.bnQ().appId).dW("locate_type", bVar.gyo.entryName));
                }
                if (bVar.gyp != null && bVar.gyp.bkV() != null && bVar.gyp.bkV().bnQ() != null) {
                    bz bkV2 = bVar.gyp.bkV();
                    TiebaStatic.log(new aq("c12115").w("obj_id", bkV2.bnQ().live_id).dW(TiebaInitialize.Params.OBJ_PARAM3, bkV2.bnQ().appId).dW("locate_type", bVar.gyp.entryName));
                }
            }
        }
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public void tA(int i) {
        this.isSmallFollow = i;
    }

    public void mH(boolean z) {
        this.gFR = z;
    }
}
