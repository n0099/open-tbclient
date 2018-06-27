package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import com.baidu.tieba.play.y;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.frs.h<bc, a<Object>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean ayb;
    private String bGM;
    private ad<bc> bGN;
    private boolean drj;
    private int drk;
    private com.baidu.tieba.frs.e.a drl;
    private String forumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ayb = false;
        this.drj = false;
        this.drk = 3;
        this.drl = new com.baidu.tieba.frs.e.a();
        this.bGN = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null) {
                    if (d.this.djj != null) {
                        d.this.djj.a(view, bcVar, bc.aij);
                    }
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").r("obj_type", 2).f(ImageViewerConfig.FORUM_ID, bcVar.getFid()).ah("tid", bcVar.getTid()));
                    }
                    if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.e.b.azw().a(d.this.drl, bcVar, 4);
                    } else if (view.getId() == d.g.layout_root) {
                        com.baidu.tieba.frs.e.b.azw().a(d.this.drl, bcVar, 1);
                    } else if (view.getId() == d.g.image_user) {
                        com.baidu.tieba.frs.e.b.azw().a(d.this.drl, bcVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(d.this.drl, bcVar.vT());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        if (aVar.bGZ != null) {
            aVar.bGZ.setInFrsAllThread(this.ayb);
        }
        aVar.hf(this.drk);
        if (this.drk != 15 && this.drj && aVar.bGY != null) {
            aVar.bGY.setFrom(4);
        }
        return new a(aVar);
    }

    private y U(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bcVar.wm() ? "3" : "2";
        yVar.czo = this.drl.dBT;
        yVar.aWo = bcVar.getTid();
        yVar.ghf = bcVar.mRecomAbTag;
        if (bcVar.vN() != null) {
            yVar.ghg = bcVar.vN().video_md5;
        }
        bcVar.wq();
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bc bcVar, a aVar) {
        if (aVar == null || aVar.aja() == null) {
            return null;
        }
        if (aVar.aja() instanceof com.baidu.tieba.a.e) {
            aVar.aja().setPage(this.bGM);
        }
        com.baidu.tieba.frs.g.a(aVar.aja().Vr(), this.djc);
        aVar.aja().setVideoStatsData(U(bcVar));
        aVar.aja().a(bcVar);
        aVar.aja().b(this.bGN);
        com.baidu.tieba.frs.e.b.azw().a(this.drl, bcVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hf(int i) {
        this.drk = i;
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.ayb = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void ez(boolean z) {
        this.drj = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a awC() {
        return this.drl;
    }
}
