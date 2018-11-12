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
    private boolean aGh;
    private String bWE;
    private ad<bb> bWF;
    public boolean dIp;
    private boolean dJD;
    private int dJE;
    private com.baidu.tieba.frs.e.a dJF;
    private String forumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aGh = false;
        this.dJD = false;
        this.dJE = 3;
        this.dJF = new com.baidu.tieba.frs.e.a();
        this.bWF = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (d.this.dBn != null) {
                        d.this.dBn.a(view, bbVar, bb.apO);
                    }
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 2).h(ImageViewerConfig.FORUM_ID, bbVar.getFid()).ax("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.b.aEY().a(d.this.dJF, bbVar, 4);
                    } else if (view.getId() == e.g.layout_root) {
                        com.baidu.tieba.frs.e.b.aEY().a(d.this.dJF, bbVar, 1);
                    } else if (view.getId() == e.g.image_user) {
                        com.baidu.tieba.frs.e.b.aEY().a(d.this.dJF, bbVar, 2);
                    } else if (view.getId() == e.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(d.this.dJF, bbVar.zb());
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
        if (aVar.bWR != null) {
            aVar.bWR.setInFrsAllThread(this.aGh);
        }
        aVar.iv(this.dJE);
        if (this.dJE != 15 && this.dJD && aVar.bWQ != null) {
            aVar.bWQ.setFrom(4);
        }
        return new a(aVar);
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.zv() ? "3" : "2";
        if (this.dJF.dUM == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.cRh = this.dJF.dUL;
        zVar.beV = bbVar.getTid();
        zVar.gya = bbVar.mRecomAbTag;
        if (bbVar.yU() != null) {
            zVar.gyb = bbVar.yU().video_md5;
        }
        bbVar.zz();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.aor() == null) {
            return null;
        }
        if (aVar.aor() instanceof com.baidu.tieba.a.e) {
            aVar.aor().setPage(this.bWE);
        }
        com.baidu.tieba.frs.g.a(aVar.aor().abi(), this.dBg);
        aVar.aor().setVideoStatsData(X(bbVar));
        aVar.aor().a(bbVar);
        aVar.aor().b(this.bWF);
        if (this.dBg != null) {
            aVar.aor().dKH = this.dBg.hcJ;
        } else {
            aVar.aor().dKH = this.dIp;
        }
        if (this.dJF != null) {
            aVar.aor().dKI = this.dJF.dUM;
        }
        com.baidu.tieba.frs.e.b.aEY().a(this.dJF, bbVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iv(int i) {
        this.dJE = i;
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aGh = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fu(boolean z) {
        this.dJD = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aCh() {
        return this.dJF;
    }
}
