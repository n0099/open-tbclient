package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class q extends com.baidu.tieba.frs.j<bu, d<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    public static int hPm = 5;
    public static int hPn = 10;
    public static int hPo = 15;
    private com.baidu.tieba.card.aa<bv> fWN;
    private String forumName;
    private com.baidu.tieba.frs.d.b hOG;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void n(bv bvVar, String str) {
        if (bvVar != null) {
            int aXz = bvVar.aXz();
            ap apVar = new ap(str);
            apVar.dn("obj_locate", vr(aXz));
            apVar.dn("tid", bvVar.getTid());
            apVar.ah("obj_type", 2);
            TiebaStatic.log(apVar);
        }
    }

    private String vr(int i) {
        if (i == hPm) {
            return "3";
        }
        if (i == hPn) {
            return "10";
        }
        if (i != hPo) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hOG = new com.baidu.tieba.frs.d.b();
        this.fWN = new com.baidu.tieba.card.aa<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        q.this.n(bvVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        q.this.n(bvVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        q.this.n(bvVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_PORTRAIT);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(q.this.hOG, bvVar.aTO());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 2, q.this.mPageId, q.this.hOG, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 4, q.this.mPageId, q.this.hOG, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 5, q.this.mPageId, q.this.hOG, q.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bvVar, 1, q.this.mPageId, q.this.hOG, q.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bk */
    public d b(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.p(this.mPageId);
        bVar.setForumName(this.forumName);
        return new d(bVar);
    }

    private com.baidu.tieba.play.o ah(bv bvVar) {
        com.baidu.tieba.play.o oVar = null;
        if (bvVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = vr(bvVar.aXz());
            oVar.eKO = this.hOG.icO;
            oVar.ajJ = bvVar.getTid();
            oVar.lcN = bvVar.mRecomAbTag;
            if (bvVar.aWD() != null) {
                oVar.lcO = bvVar.aWD().video_md5;
            }
            bvVar.aXx();
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, d dVar) {
        if (dVar == null || dVar.bSs() == null) {
            return null;
        }
        dVar.bSs().setVideoStatsData(ah(buVar.dLK));
        dVar.bSs().a(buVar.dLK);
        dVar.bSs().c(this.fWN);
        com.baidu.tieba.frs.d.a.a(buVar.dLK, this.mPageId, this.hOG, getTbPageTag());
        return dVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hOG;
    }
}
