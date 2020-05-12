package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class q extends com.baidu.tieba.frs.h<bi, d<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    public static int hhr = 5;
    public static int hhs = 10;
    public static int hht = 15;
    private String forumName;
    private com.baidu.tieba.card.z<bj> fsi;
    private com.baidu.tieba.frs.d.b hgM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void n(bj bjVar, String str) {
        if (bjVar != null) {
            int aLN = bjVar.aLN();
            an anVar = new an(str);
            anVar.cI("obj_locate", tN(aLN));
            anVar.cI("tid", bjVar.getTid());
            anVar.af("obj_type", 2);
            TiebaStatic.log(anVar);
        }
    }

    private String tN(int i) {
        if (i == hhr) {
            return "3";
        }
        if (i == hhs) {
            return "10";
        }
        if (i != hht) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hgM = new com.baidu.tieba.frs.d.b();
        this.fsi = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        q.this.n(bjVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        q.this.n(bjVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        q.this.n(bjVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_PORTRAIT);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(q.this.hgM, bjVar.aIv());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, q.this.mPageId, q.this.hgM, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, q.this.mPageId, q.this.hgM, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, q.this.mPageId, q.this.hgM, q.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, q.this.mPageId, q.this.hgM, q.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public d b(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.m(this.mPageId);
        bVar.setForumName(this.forumName);
        return new d(bVar);
    }

    private com.baidu.tieba.play.y aj(bj bjVar) {
        com.baidu.tieba.play.y yVar = null;
        if (bjVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = tN(bjVar.aLN());
            yVar.eQk = this.hgM.huc;
            yVar.ahO = bjVar.getTid();
            yVar.kiv = bjVar.mRecomAbTag;
            if (bjVar.aKT() != null) {
                yVar.kiw = bjVar.aKT().video_md5;
            }
            bjVar.aLL();
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, d dVar) {
        if (dVar == null || dVar.bFA() == null) {
            return null;
        }
        dVar.bFA().setVideoStatsData(aj(biVar.dqE));
        dVar.bFA().a(biVar.dqE);
        dVar.bFA().c(this.fsi);
        com.baidu.tieba.frs.d.a.a(biVar.dqE, this.mPageId, this.hgM, getTbPageTag());
        return dVar.getView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hgM;
    }
}
