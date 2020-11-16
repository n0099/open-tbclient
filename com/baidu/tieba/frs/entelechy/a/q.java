package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class q extends com.baidu.tieba.frs.k<bw, d<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    public static int iSE = 5;
    public static int iSF = 10;
    public static int iSG = 15;
    private String forumName;
    private com.baidu.tieba.card.ab<bx> gSk;
    private com.baidu.tieba.frs.d.b iRY;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void n(bx bxVar, String str) {
        if (bxVar != null) {
            int bmS = bxVar.bmS();
            ar arVar = new ar(str);
            arVar.dR("obj_locate", zT(bmS));
            arVar.dR("tid", bxVar.getTid());
            arVar.ak("obj_type", 2);
            TiebaStatic.log(arVar);
        }
    }

    private String zT(int i) {
        if (i == iSE) {
            return "3";
        }
        if (i == iSF) {
            return "10";
        }
        if (i != iSG) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iRY = new com.baidu.tieba.frs.d.b();
        this.gSk = new com.baidu.tieba.card.ab<bx>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bx bxVar) {
                if (view != null && bxVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        q.this.n(bxVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        q.this.n(bxVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        q.this.n(bxVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_PORTRAIT);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(q.this.iRY, bxVar.bje());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 2, q.this.mPageId, q.this.iRY, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 4, q.this.mPageId, q.this.iRY, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 5, q.this.mPageId, q.this.iRY, q.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bxVar, 1, q.this.mPageId, q.this.iRY, q.this.getTbPageTag());
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
    public d c(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.o(this.mPageId);
        bVar.setForumName(this.forumName);
        return new d(bVar);
    }

    private com.baidu.tieba.play.o ak(bx bxVar) {
        com.baidu.tieba.play.o oVar = null;
        if (bxVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = zT(bxVar.bmS());
            oVar.fyg = this.iRY.jgo;
            oVar.alZ = bxVar.getTid();
            oVar.mko = bxVar.mRecomAbTag;
            if (bxVar.blU() != null) {
                oVar.mkp = bxVar.blU().video_md5;
            }
            bxVar.bmQ();
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, d dVar) {
        if (dVar == null || dVar.coz() == null) {
            return null;
        }
        dVar.coz().setVideoStatsData(ak(bwVar.evQ));
        dVar.coz().a(bwVar.evQ);
        dVar.coz().c(this.gSk);
        com.baidu.tieba.frs.d.a.a(bwVar.evQ, this.mPageId, this.iRY, getTbPageTag());
        return dVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRY;
    }
}
