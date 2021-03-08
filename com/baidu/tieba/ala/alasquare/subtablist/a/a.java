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
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.subtablist.b.a, AlaSubListGameDoubleViewHolder> {
    private int from;
    private g gIy;
    private boolean gKy;
    private com.baidu.tieba.ala.alasquare.subtablist.view.a gKz;
    private int isSmallFollow;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.subtablist.b.a.gKB);
        this.gKy = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public AlaSubListGameDoubleViewHolder e(ViewGroup viewGroup) {
        this.gKz = new com.baidu.tieba.ala.alasquare.subtablist.view.a(this.mPageContext, this.gKy);
        return new AlaSubListGameDoubleViewHolder(this.gKz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.subtablist.b.a aVar, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        a(aVar);
        alaSubListGameDoubleViewHolder.gKz.a(aVar);
        alaSubListGameDoubleViewHolder.gKz.d(this.gIy);
        return alaSubListGameDoubleViewHolder.getView();
    }

    private void a(com.baidu.tieba.ala.alasquare.subtablist.b.a aVar) {
        if (aVar != null) {
            if (this.from == 1) {
                if (aVar.gCV != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bSk().e(com.baidu.tieba.ala.alasquare.b.a.bSk().a(this.isSmallFollow, "c12117", aVar.gCV.tabId, aVar.gCV.entryName, aVar.gCV.blp()));
                }
                if (aVar.gCW != null) {
                    com.baidu.tieba.ala.alasquare.b.a.bSk().e(com.baidu.tieba.ala.alasquare.b.a.bSk().a(this.isSmallFollow, "c12117", aVar.gCW.tabId, aVar.gCW.entryName, aVar.gCW.blp()));
                }
            } else if (this.from == 2) {
                if (aVar.gCV != null && aVar.gCV.blp() != null && aVar.gCV.blp().bol() != null) {
                    cb blp = aVar.gCV.blp();
                    TiebaStatic.log(new ar("c12115").v("obj_id", blp.bol().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, blp.bol().appId).dR("locate_type", aVar.gCV.entryName));
                }
                if (aVar.gCW != null && aVar.gCW.blp() != null && aVar.gCW.blp().bol() != null) {
                    cb blp2 = aVar.gCW.blp();
                    TiebaStatic.log(new ar("c12115").v("obj_id", blp2.bol().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, blp2.bol().appId).dR("locate_type", aVar.gCW.entryName));
                }
            }
        }
    }

    public void b(g gVar) {
        this.gIy = gVar;
    }

    public void tI(int i) {
        this.isSmallFollow = i;
    }

    public void mL(boolean z) {
        this.gKy = z;
    }

    public void setFrom(int i) {
        this.from = i;
    }
}
