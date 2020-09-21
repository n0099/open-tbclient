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
/* loaded from: classes21.dex */
public class q extends com.baidu.tieba.frs.k<bv, d<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    public static int ikB = 5;
    public static int ikC = 10;
    public static int ikD = 15;
    private String forumName;
    private com.baidu.tieba.card.aa<bw> glX;
    private com.baidu.tieba.frs.d.b ijV;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void n(bw bwVar, String str) {
        if (bwVar != null) {
            int bgM = bwVar.bgM();
            aq aqVar = new aq(str);
            aqVar.dF("obj_locate", yj(bgM));
            aqVar.dF("tid", bwVar.getTid());
            aqVar.ai("obj_type", 2);
            TiebaStatic.log(aqVar);
        }
    }

    private String yj(int i) {
        if (i == ikB) {
            return "3";
        }
        if (i == ikC) {
            return "10";
        }
        if (i != ikD) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ijV = new com.baidu.tieba.frs.d.b();
        this.glX = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
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
                        com.baidu.tieba.frs.f.j.a(q.this.ijV, bwVar.bcZ());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, q.this.mPageId, q.this.ijV, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, q.this.mPageId, q.this.ijV, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, q.this.mPageId, q.this.ijV, q.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, q.this.mPageId, q.this.ijV, q.this.getTbPageTag());
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

    private com.baidu.tieba.play.o ai(bw bwVar) {
        com.baidu.tieba.play.o oVar = null;
        if (bwVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = yj(bwVar.bgM());
            oVar.eYo = this.ijV.iyr;
            oVar.alA = bwVar.getTid();
            oVar.lCj = bwVar.mRecomAbTag;
            if (bwVar.bfQ() != null) {
                oVar.lCk = bwVar.bfQ().video_md5;
            }
            bwVar.bgK();
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, d dVar) {
        if (dVar == null || dVar.cfU() == null) {
            return null;
        }
        dVar.cfU().setVideoStatsData(ai(bvVar.dXg));
        dVar.cfU().a(bvVar.dXg);
        dVar.cfU().c(this.glX);
        com.baidu.tieba.frs.d.a.a(bvVar.dXg, this.mPageId, this.ijV, getTbPageTag());
        return dVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.ijV;
    }
}
