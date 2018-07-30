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
import com.baidu.tieba.d;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.frs.h<bb, a<Object>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean axH;
    private String bHB;
    private ad<bb> bHC;
    private boolean dtW;
    private int dtX;
    private com.baidu.tieba.frs.e.a dtY;
    private String forumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.axH = false;
        this.dtW = false;
        this.dtX = 3;
        this.dtY = new com.baidu.tieba.frs.e.a();
        this.bHC = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (d.this.dlZ != null) {
                        d.this.dlZ.a(view, bbVar, bb.ahF);
                    }
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").r("obj_type", 2).f(ImageViewerConfig.FORUM_ID, bbVar.getFid()).af("tid", bbVar.getTid()));
                    }
                    if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aAd().a(d.this.dtY, bbVar, 4);
                    } else if (view.getId() == d.g.layout_root) {
                        com.baidu.tieba.frs.e.b.aAd().a(d.this.dtY, bbVar, 1);
                    } else if (view.getId() == d.g.image_user) {
                        com.baidu.tieba.frs.e.b.aAd().a(d.this.dtY, bbVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(d.this.dtY, bbVar.vI());
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
            aVar.bHO.setInFrsAllThread(this.axH);
        }
        aVar.hl(this.dtX);
        if (this.dtX != 15 && this.dtW && aVar.bHN != null) {
            aVar.bHN.setFrom(4);
        }
        return new a(aVar);
    }

    private y W(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bbVar.wb() ? "3" : "2";
        yVar.cBU = this.dtY.dEF;
        yVar.aWq = bbVar.getTid();
        yVar.ghF = bbVar.mRecomAbTag;
        if (bbVar.vC() != null) {
            yVar.ghG = bbVar.vC().video_md5;
        }
        bbVar.wf();
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.ajz() == null) {
            return null;
        }
        if (aVar.ajz() instanceof com.baidu.tieba.a.e) {
            aVar.ajz().setPage(this.bHB);
        }
        com.baidu.tieba.frs.g.a(aVar.ajz().VA(), this.dlS);
        aVar.ajz().setVideoStatsData(W(bbVar));
        aVar.ajz().a(bbVar);
        aVar.ajz().b(this.bHC);
        if (this.dlS != null) {
            aVar.ajz().duY = this.dlS.gMm;
        }
        com.baidu.tieba.frs.e.b.aAd().a(this.dtY, bbVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hl(int i) {
        this.dtX = i;
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.axH = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void eA(boolean z) {
        this.dtW = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axh() {
        return this.dtY;
    }
}
