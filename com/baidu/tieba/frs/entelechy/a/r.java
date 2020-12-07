package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class r extends com.baidu.tieba.frs.k<bx, d<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    public static int jdA = 5;
    public static int jdB = 10;
    public static int jdC = 15;
    private String forumName;
    private com.baidu.tieba.card.ab<by> hbx;
    private com.baidu.tieba.frs.d.b jcS;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void n(by byVar, String str) {
        if (byVar != null) {
            int bqf = byVar.bqf();
            ar arVar = new ar(str);
            arVar.dY("obj_locate", Ay(bqf));
            arVar.dY("tid", byVar.getTid());
            arVar.al("obj_type", 2);
            TiebaStatic.log(arVar);
        }
    }

    private String Ay(int i) {
        if (i == jdA) {
            return "3";
        }
        if (i == jdB) {
            return "10";
        }
        if (i != jdC) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jcS = new com.baidu.tieba.frs.d.b();
        this.hbx = new com.baidu.tieba.card.ab<by>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                if (view != null && byVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        r.this.n(byVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        r.this.n(byVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        r.this.n(byVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_PORTRAIT);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.k.a(r.this.jcS, byVar.bmo());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(byVar, 2, r.this.mPageId, r.this.jcS, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(byVar, 4, r.this.mPageId, r.this.jcS, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 5, r.this.mPageId, r.this.jcS, r.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(byVar, 1, r.this.mPageId, r.this.jcS, r.this.getTbPageTag());
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

    private com.baidu.tieba.play.o ak(by byVar) {
        com.baidu.tieba.play.o oVar = null;
        if (byVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = Ay(byVar.bqf());
            oVar.fFV = this.jcS.jtR;
            oVar.amY = byVar.getTid();
            oVar.mys = byVar.mRecomAbTag;
            if (byVar.bph() != null) {
                oVar.myt = byVar.bph().video_md5;
            }
            byVar.bqd();
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, d dVar) {
        if (dVar == null || dVar.csM() == null) {
            return null;
        }
        dVar.csM().setVideoStatsData(ak(bxVar.eCR));
        dVar.csM().a(bxVar.eCR);
        dVar.csM().c(this.hbx);
        com.baidu.tieba.frs.d.a.a(bxVar.eCR, this.mPageId, this.jcS, getTbPageTag());
        return dVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.jcS;
    }
}
