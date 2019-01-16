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
    private boolean aKl;
    private String cbk;
    private ad<bb> cbl;
    public boolean dSl;
    private boolean dTD;
    private int dTE;
    private com.baidu.tieba.frs.e.b dTF;
    private String forumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aKl = false;
        this.dTD = false;
        this.dTE = 3;
        this.dTF = new com.baidu.tieba.frs.e.b();
        this.cbl = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (d.this.dLj != null) {
                        d.this.dLj.a(view, bbVar, bb.atQ);
                    }
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").y("obj_type", 2).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aB("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.c.aHW().a(d.this.dTF, bbVar, 4);
                    } else if (view.getId() == e.g.layout_root) {
                        com.baidu.tieba.frs.e.c.aHW().a(d.this.dTF, bbVar, 1);
                    } else if (view.getId() == e.g.image_user) {
                        com.baidu.tieba.frs.e.c.aHW().a(d.this.dTF, bbVar, 2);
                    } else if (view.getId() == e.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(d.this.dTF, bbVar.As());
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, d.this.mPageId, d.this.dTF);
                    } else if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 4, d.this.mPageId, d.this.dTF);
                    } else if (view.getId() != e.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, d.this.mPageId, d.this.dTF);
                    } else {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, d.this.mPageId, d.this.dTF);
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
        if (aVar.cbx != null) {
            aVar.cbx.setInFrsAllThread(this.aKl);
        }
        aVar.iK(this.dTE);
        if (this.dTE != 15 && this.dTD && aVar.cbw != null) {
            aVar.cbw.setFrom(4);
        }
        return new a(aVar);
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.AM() ? "3" : "2";
        if (this.dTF.eeM == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.dbr = this.dTF.eeL;
        zVar.bjm = bbVar.getTid();
        zVar.gIL = bbVar.mRecomAbTag;
        if (bbVar.Al() != null) {
            zVar.gIM = bbVar.Al().video_md5;
        }
        bbVar.AQ();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.arr() == null) {
            return null;
        }
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbk);
        }
        com.baidu.tieba.frs.g.a(aVar.arr().acN(), this.dLc);
        aVar.arr().setVideoStatsData(X(bbVar));
        aVar.arr().a(bbVar);
        aVar.arr().b(this.cbl);
        if (this.dLc != null) {
            aVar.arr().dUH = this.dLc.hnS;
        } else {
            aVar.arr().dUH = this.dSl;
        }
        if (this.dTF != null) {
            aVar.arr().dUI = this.dTF.eeM;
            int i2 = 0;
            if (this.dLc != null) {
                i2 = this.dLc.aHA();
            }
            bbVar.awj = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHW().a(this.dTF, bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dTF);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.dTE = i;
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbk = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aKl = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fA(boolean z) {
        this.dTD = z;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aFf() {
        return this.dTF;
    }
}
