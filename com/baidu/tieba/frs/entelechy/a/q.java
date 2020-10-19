package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class q extends com.baidu.tieba.frs.k<bv, d<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String forumName;
    private com.baidu.tieba.card.aa<bw> gAq;
    private com.baidu.tieba.frs.d.b iyS;
    private TbPageContext<?> mPageContext;
    public static int izy = 5;
    public static int izz = 10;
    public static int izA = 15;

    /* JADX INFO: Access modifiers changed from: private */
    public void n(bw bwVar, String str) {
        if (bwVar != null) {
            int bjv = bwVar.bjv();
            aq aqVar = new aq(str);
            aqVar.dK("obj_locate", yP(bjv));
            aqVar.dK("tid", bwVar.getTid());
            aqVar.aj("obj_type", 2);
            TiebaStatic.log(aqVar);
        }
    }

    private String yP(int i) {
        if (i == izy) {
            return "3";
        }
        if (i == izz) {
            return "10";
        }
        if (i != izA) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iyS = new com.baidu.tieba.frs.d.b();
        this.gAq = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        q.this.n(bwVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        q.this.n(bwVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        q.this.n(bwVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_PORTRAIT);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(q.this.iyS, bwVar.bfH());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, q.this.mPageId, q.this.iyS, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, q.this.mPageId, q.this.iyS, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, q.this.mPageId, q.this.iyS, q.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, q.this.mPageId, q.this.iyS, q.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bm */
    public d c(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.o(this.mPageId);
        bVar.setForumName(this.forumName);
        return new d(bVar);
    }

    private com.baidu.tieba.play.o ai(bw bwVar) {
        com.baidu.tieba.play.o oVar = null;
        if (bwVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = yP(bwVar.bjv());
            oVar.fkA = this.iyS.iNk;
            oVar.alS = bwVar.getTid();
            oVar.lRy = bwVar.mRecomAbTag;
            if (bwVar.biz() != null) {
                oVar.lRz = bwVar.biz().video_md5;
            }
            bwVar.bjt();
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, d dVar) {
        if (dVar == null || dVar.cjq() == null) {
            return null;
        }
        dVar.cjq().setVideoStatsData(ai(bvVar.eji));
        dVar.cjq().a(bvVar.eji);
        dVar.cjq().c(this.gAq);
        com.baidu.tieba.frs.d.a.a(bvVar.eji, this.mPageId, this.iyS, getTbPageTag());
        return dVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void ux(int i) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iyS;
    }
}
