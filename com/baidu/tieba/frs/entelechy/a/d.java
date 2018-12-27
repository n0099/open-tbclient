package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.play.z;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.frs.h<bb, a<Object>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.d {
    private boolean aJJ;
    private ad<bb> caA;
    private String caz;
    public boolean dRC;
    private boolean dSX;
    private int dSY;
    private com.baidu.tieba.frs.e.b dSZ;
    private String forumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aJJ = false;
        this.dSX = false;
        this.dSY = 3;
        this.dSZ = new com.baidu.tieba.frs.e.b();
        this.caA = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (d.this.dKA != null) {
                        d.this.dKA.a(view, bbVar, bb.ato);
                    }
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 2).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aA("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.c.aHz().a(d.this.dSZ, bbVar, 4);
                    } else if (view.getId() == e.g.layout_root) {
                        com.baidu.tieba.frs.e.c.aHz().a(d.this.dSZ, bbVar, 1);
                    } else if (view.getId() == e.g.image_user) {
                        com.baidu.tieba.frs.e.c.aHz().a(d.this.dSZ, bbVar, 2);
                    } else if (view.getId() == e.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(d.this.dSZ, bbVar.Af());
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, d.this.mPageId, d.this.dSZ);
                    } else if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 4, d.this.mPageId, d.this.dSZ);
                    } else if (view.getId() != e.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, d.this.mPageId, d.this.dSZ);
                    } else {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, d.this.mPageId, d.this.dSZ);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.a aVar = new com.baidu.tieba.frs.entelechy.view.a(this.mPageContext, this.mPageId);
        aVar.j(this.mPageId);
        aVar.setForumName(this.forumName);
        if (aVar.caM != null) {
            aVar.caM.setInFrsAllThread(this.aJJ);
        }
        aVar.iK(this.dSY);
        if (this.dSY != 15 && this.dSX && aVar.caL != null) {
            aVar.caL.setFrom(4);
        }
        return new a(aVar);
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.Az() ? "3" : "2";
        if (this.dSZ.eeg == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.daG = this.dSZ.eef;
        zVar.biz = bbVar.getTid();
        zVar.gHH = bbVar.mRecomAbTag;
        if (bbVar.zY() != null) {
            zVar.gHI = bbVar.zY().video_md5;
        }
        bbVar.AD();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.aqT() == null) {
            return null;
        }
        if (aVar.aqT() instanceof com.baidu.tieba.a.e) {
            aVar.aqT().setPage(this.caz);
        }
        com.baidu.tieba.frs.g.a(aVar.aqT().acq(), this.dKt);
        aVar.aqT().setVideoStatsData(X(bbVar));
        aVar.aqT().a(bbVar);
        aVar.aqT().b(this.caA);
        if (this.dKt != null) {
            aVar.aqT().dUb = this.dKt.hmN;
        } else {
            aVar.aqT().dUb = this.dRC;
        }
        if (this.dSZ != null) {
            aVar.aqT().dUc = this.dSZ.eeg;
            int i2 = 0;
            if (this.dKt != null) {
                i2 = this.dKt.aHd();
            }
            bbVar.avH = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHz().a(this.dSZ, bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dSZ);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.dSY = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jL(String str) {
        this.caz = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aJJ = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fx(boolean z) {
        this.dSX = z;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aEI() {
        return this.dSZ;
    }
}
