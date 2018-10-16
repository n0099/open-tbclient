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
import com.baidu.tieba.play.z;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.frs.h<bb, a<Object>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean aFr;
    private String bVS;
    private ad<bb> bVT;
    public boolean dGU;
    private int dIA;
    private com.baidu.tieba.frs.e.a dIB;
    private boolean dIz;
    private String forumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aFr = false;
        this.dIz = false;
        this.dIA = 3;
        this.dIB = new com.baidu.tieba.frs.e.a();
        this.bVT = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (d.this.dzW != null) {
                        d.this.dzW.a(view, bbVar, bb.apa);
                    }
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 2).h(ImageViewerConfig.FORUM_ID, bbVar.getFid()).ax("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aFC().a(d.this.dIB, bbVar, 4);
                    } else if (view.getId() == e.g.layout_root) {
                        com.baidu.tieba.frs.e.b.aFC().a(d.this.dIB, bbVar, 1);
                    } else if (view.getId() == e.g.image_user) {
                        com.baidu.tieba.frs.e.b.aFC().a(d.this.dIB, bbVar, 2);
                    } else if (view.getId() == e.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(d.this.dIB, bbVar.yU());
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
        if (aVar.bWf != null) {
            aVar.bWf.setInFrsAllThread(this.aFr);
        }
        aVar.ii(this.dIA);
        if (this.dIA != 15 && this.dIz && aVar.bWe != null) {
            aVar.bWe.setFrom(4);
        }
        return new a(aVar);
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.zo() ? "3" : "2";
        if (this.dIB.dTF == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.cQb = this.dIB.dTE;
        zVar.beh = bbVar.getTid();
        zVar.gwy = bbVar.mRecomAbTag;
        if (bbVar.yN() != null) {
            zVar.gwz = bbVar.yN().video_md5;
        }
        bbVar.zs();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.aoP() == null) {
            return null;
        }
        if (aVar.aoP() instanceof com.baidu.tieba.a.e) {
            aVar.aoP().setPage(this.bVS);
        }
        com.baidu.tieba.frs.g.a(aVar.aoP().aaX(), this.dzP);
        aVar.aoP().setVideoStatsData(X(bbVar));
        aVar.aoP().a(bbVar);
        aVar.aoP().b(this.bVT);
        if (this.dzP != null) {
            aVar.aoP().dJD = this.dzP.hbl;
        } else {
            aVar.aoP().dJD = this.dGU;
        }
        if (this.dIB != null) {
            aVar.aoP().dJE = this.dIB.dTF;
        }
        com.baidu.tieba.frs.e.b.aFC().a(this.dIB, bbVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void ii(int i) {
        this.dIA = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aFr = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fj(boolean z) {
        this.dIz = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aCM() {
        return this.dIB;
    }
}
