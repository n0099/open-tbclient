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
    private boolean aJH;
    private String caw;
    private ad<bb> cax;
    public boolean dOO;
    private boolean dQg;
    private int dQh;
    private com.baidu.tieba.frs.e.a dQi;
    private String forumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aJH = false;
        this.dQg = false;
        this.dQh = 3;
        this.dQi = new com.baidu.tieba.frs.e.a();
        this.cax = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (d.this.dHM != null) {
                        d.this.dHM.a(view, bbVar, bb.ato);
                    }
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 2).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aA("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aGK().a(d.this.dQi, bbVar, 4);
                    } else if (view.getId() == e.g.layout_root) {
                        com.baidu.tieba.frs.e.b.aGK().a(d.this.dQi, bbVar, 1);
                    } else if (view.getId() == e.g.image_user) {
                        com.baidu.tieba.frs.e.b.aGK().a(d.this.dQi, bbVar, 2);
                    } else if (view.getId() == e.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(d.this.dQi, bbVar.Af());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        if (aVar.caJ != null) {
            aVar.caJ.setInFrsAllThread(this.aJH);
        }
        aVar.iJ(this.dQh);
        if (this.dQh != 15 && this.dQg && aVar.caI != null) {
            aVar.caI.setFrom(4);
        }
        return new a(aVar);
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.Az() ? "3" : "2";
        if (this.dQi.ebp == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.cXO = this.dQi.ebo;
        zVar.biw = bbVar.getTid();
        zVar.gEQ = bbVar.mRecomAbTag;
        if (bbVar.zY() != null) {
            zVar.gER = bbVar.zY().video_md5;
        }
        bbVar.AD();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.aqe() == null) {
            return null;
        }
        if (aVar.aqe() instanceof com.baidu.tieba.a.e) {
            aVar.aqe().setPage(this.caw);
        }
        com.baidu.tieba.frs.g.a(aVar.aqe().aco(), this.dHF);
        aVar.aqe().setVideoStatsData(X(bbVar));
        aVar.aqe().a(bbVar);
        aVar.aqe().b(this.cax);
        if (this.dHF != null) {
            aVar.aqe().dRk = this.dHF.hjC;
        } else {
            aVar.aqe().dRk = this.dOO;
        }
        if (this.dQi != null) {
            aVar.aqe().dRl = this.dQi.ebp;
        }
        com.baidu.tieba.frs.e.b.aGK().a(this.dQi, bbVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iJ(int i) {
        this.dQh = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aJH = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fv(boolean z) {
        this.dQg = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aDT() {
        return this.dQi;
    }
}
