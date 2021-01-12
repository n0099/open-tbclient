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
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, AlaSubListGameDoubleViewHolder> {
    private int from;
    private g gDR;
    private boolean gFR;
    private com.baidu.tieba.ala.alasquare.subtablist.view.a gFS;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.gFU);
        this.gFR = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public AlaSubListGameDoubleViewHolder e(ViewGroup viewGroup) {
        this.gFS = new com.baidu.tieba.ala.alasquare.subtablist.view.a(this.mPageContext, this.gFR);
        return new AlaSubListGameDoubleViewHolder(this.gFS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        a(aVar);
        alaSubListGameDoubleViewHolder.gFS.a(aVar);
        alaSubListGameDoubleViewHolder.gFS.d(this.gDR);
        return alaSubListGameDoubleViewHolder.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.gyo != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bRu().e(com.baidu.tieba.ala.alasquare.b.a.bRu().a(this.isSmallFollow, "c12117", aVar.gyo.tabId, aVar.gyo.entryName, aVar.gyo.bkV()));
                }
                if (aVar.gyp != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bRu().e(com.baidu.tieba.ala.alasquare.b.a.bRu().a(this.isSmallFollow, "c12117", aVar.gyp.tabId, aVar.gyp.entryName, aVar.gyp.bkV()));
                }
            } else if (this.from == 2) {
                if (aVar.gyo != null && aVar.gyo.bkV() != null && aVar.gyo.bkV().bnQ() != null) {
                    bz bkV = aVar.gyo.bkV();
                    TiebaStatic.log(new aq("c12115").w("obj_id", bkV.bnQ().live_id).dW(TiebaInitialize.Params.OBJ_PARAM3, bkV.bnQ().appId).dW("locate_type", aVar.gyo.entryName));
                }
                if (aVar.gyp != null && aVar.gyp.bkV() != null && aVar.gyp.bkV().bnQ() != null) {
                    bz bkV2 = aVar.gyp.bkV();
                    TiebaStatic.log(new aq("c12115").w("obj_id", bkV2.bnQ().live_id).dW(TiebaInitialize.Params.OBJ_PARAM3, bkV2.bnQ().appId).dW("locate_type", aVar.gyp.entryName));
                }
            }
        }
    }

    public void b(g gVar) {
        this.gDR = gVar;
    }

    public void tA(int i) {
        this.isSmallFollow = i;
    }

    public void mH(boolean z) {
        this.gFR = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
