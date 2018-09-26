package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.frs.h<bb, a<Object>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean aAK;
    private String bNq;
    private ad<bb> bNr;
    private int dAA;
    private com.baidu.tieba.frs.e.a dAB;
    private boolean dAz;
    public boolean dyU;
    private String forumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aAK = false;
        this.dAz = false;
        this.dAA = 3;
        this.dAB = new com.baidu.tieba.frs.e.a();
        this.bNr = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (d.this.drU != null) {
                        d.this.drU.a(view, bbVar, bb.akf);
                    }
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").w("obj_type", 2).g(ImageViewerConfig.FORUM_ID, bbVar.getFid()).al("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aCj().a(d.this.dAB, bbVar, 4);
                    } else if (view.getId() == e.g.layout_root) {
                        com.baidu.tieba.frs.e.b.aCj().a(d.this.dAB, bbVar, 1);
                    } else if (view.getId() == e.g.image_user) {
                        com.baidu.tieba.frs.e.b.aCj().a(d.this.dAB, bbVar, 2);
                    } else if (view.getId() == e.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(d.this.dAB, bbVar.wL());
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
        if (aVar.bND != null) {
            aVar.bND.setInFrsAllThread(this.aAK);
        }
        aVar.hK(this.dAA);
        if (this.dAA != 15 && this.dAz && aVar.bNC != null) {
            aVar.bNC.setFrom(4);
        }
        return new a(aVar);
    }

    private y X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bbVar.xf() ? "3" : "2";
        if (this.dAB.dLK == 501) {
            yVar.mLocate = "frs_tab";
        }
        yVar.cHI = this.dAB.dLJ;
        yVar.aZG = bbVar.getTid();
        yVar.goX = bbVar.mRecomAbTag;
        if (bbVar.wE() != null) {
            yVar.goY = bbVar.wE().video_md5;
        }
        bbVar.xj();
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.aln() == null) {
            return null;
        }
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        com.baidu.tieba.frs.g.a(aVar.aln().Xq(), this.drN);
        aVar.aln().setVideoStatsData(X(bbVar));
        aVar.aln().a(bbVar);
        aVar.aln().b(this.bNr);
        if (this.drN != null) {
            aVar.aln().dBD = this.drN.gTQ;
        } else {
            aVar.aln().dBD = this.dyU;
        }
        if (this.dAB != null) {
            aVar.aln().dBE = this.dAB.dLK;
        }
        com.baidu.tieba.frs.e.b.aCj().a(this.dAB, bbVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hK(int i) {
        this.dAA = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aAK = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void eR(boolean z) {
        this.dAz = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a azt() {
        return this.dAB;
    }
}
