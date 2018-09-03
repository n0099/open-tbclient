package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.f;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.frs.h<bb, a<Object>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean axE;
    private String bHB;
    private ad<bb> bHC;
    private boolean dtT;
    private int dtU;
    private com.baidu.tieba.frs.e.a dtV;
    private String forumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.axE = false;
        this.dtT = false;
        this.dtU = 3;
        this.dtV = new com.baidu.tieba.frs.e.a();
        this.bHC = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (d.this.dlX != null) {
                        d.this.dlX.a(view, bbVar, bb.ahF);
                    }
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").r("obj_type", 2).f(ImageViewerConfig.FORUM_ID, bbVar.getFid()).ae("tid", bbVar.getTid()));
                    }
                    if (view.getId() == f.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aAa().a(d.this.dtV, bbVar, 4);
                    } else if (view.getId() == f.g.layout_root) {
                        com.baidu.tieba.frs.e.b.aAa().a(d.this.dtV, bbVar, 1);
                    } else if (view.getId() == f.g.image_user) {
                        com.baidu.tieba.frs.e.b.aAa().a(d.this.dtV, bbVar, 2);
                    } else if (view.getId() == f.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(d.this.dtV, bbVar.vH());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        if (aVar.bHO != null) {
            aVar.bHO.setInFrsAllThread(this.axE);
        }
        aVar.hk(this.dtU);
        if (this.dtU != 15 && this.dtT && aVar.bHN != null) {
            aVar.bHN.setFrom(4);
        }
        return new a(aVar);
    }

    private y W(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bbVar.wa() ? "3" : "2";
        yVar.cBR = this.dtV.dEC;
        yVar.aWq = bbVar.getTid();
        yVar.ghE = bbVar.mRecomAbTag;
        if (bbVar.vB() != null) {
            yVar.ghF = bbVar.vB().video_md5;
        }
        bbVar.we();
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.ajC() == null) {
            return null;
        }
        if (aVar.ajC() instanceof com.baidu.tieba.a.e) {
            aVar.ajC().setPage(this.bHB);
        }
        com.baidu.tieba.frs.g.a(aVar.ajC().VD(), this.dlQ);
        aVar.ajC().setVideoStatsData(W(bbVar));
        aVar.ajC().a(bbVar);
        aVar.ajC().b(this.bHC);
        if (this.dlQ != null) {
            aVar.ajC().duV = this.dlQ.gMo;
        }
        com.baidu.tieba.frs.e.b.aAa().a(this.dtV, bbVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hk(int i) {
        this.dtU = i;
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.axE = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void eA(boolean z) {
        this.dtT = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axg() {
        return this.dtV;
    }
}
