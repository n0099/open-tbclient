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
    public static int gxQ = 5;
    public static int gxR = 10;
    public static int gxS = 15;
    private com.baidu.tieba.card.z<bj> eNJ;
    private String forumName;
    private com.baidu.tieba.frs.d.b gxl;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void g(bj bjVar, String str) {
        if (bjVar != null) {
            int aDC = bjVar.aDC();
            an anVar = new an(str);
            anVar.cx("obj_locate", tp(aDC));
            anVar.cx("tid", bjVar.getTid());
            anVar.X("obj_type", 2);
            TiebaStatic.log(anVar);
        }
    }

    private String tp(int i) {
        if (i == gxQ) {
            return "3";
        }
        if (i == gxR) {
            return "10";
        }
        if (i != gxS) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gxl = new com.baidu.tieba.frs.d.b();
        this.eNJ = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        q.this.g(bjVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        q.this.g(bjVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        q.this.g(bjVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_PORTRAIT);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(q.this.gxl, bjVar.aAk());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, q.this.mPageId, q.this.gxl, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, q.this.mPageId, q.this.gxl, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, q.this.mPageId, q.this.gxl, q.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, q.this.mPageId, q.this.gxl, q.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public d b(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.m(this.mPageId);
        bVar.setForumName(this.forumName);
        return new d(bVar);
    }

    private com.baidu.tieba.play.y aq(bj bjVar) {
        com.baidu.tieba.play.y yVar = null;
        if (bjVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = tp(bjVar.aDC());
            yVar.emF = this.gxl.gKF;
            yVar.Pk = bjVar.getTid();
            yVar.mAbTag = bjVar.mRecomAbTag;
            if (bjVar.aCI() != null) {
                yVar.jyv = bjVar.aCI().video_md5;
            }
            bjVar.aDA();
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, d dVar) {
        if (dVar == null || dVar.bvQ() == null) {
            return null;
        }
        dVar.bvQ().setVideoStatsData(aq(biVar.cRt));
        dVar.bvQ().a(biVar.cRt);
        dVar.bvQ().c(this.eNJ);
        com.baidu.tieba.frs.d.a.a(biVar.cRt, this.mPageId, this.gxl, getTbPageTag());
        return dVar.getView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pB(int i) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bHn() {
        return this.gxl;
    }
}
