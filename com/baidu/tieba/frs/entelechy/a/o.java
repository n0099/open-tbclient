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
public class o extends com.baidu.tieba.frs.h<bi, c<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    public static int gxf = 5;
    public static int gxg = 10;
    public static int gxh = 15;
    private com.baidu.tieba.card.z<bj> eNp;
    private String forumName;
    private com.baidu.tieba.frs.d.b gwC;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void g(bj bjVar, String str) {
        if (bjVar != null) {
            int aDy = bjVar.aDy();
            an anVar = new an(str);
            anVar.cy("obj_locate", tl(aDy));
            anVar.cy("tid", bjVar.getTid());
            anVar.X("obj_type", 2);
            TiebaStatic.log(anVar);
        }
    }

    private String tl(int i) {
        if (i == gxf) {
            return "3";
        }
        if (i == gxg) {
            return "10";
        }
        if (i != gxh) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gwC = new com.baidu.tieba.frs.d.b();
        this.eNp = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        o.this.g(bjVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        o.this.g(bjVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        o.this.g(bjVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_PORTRAIT);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(o.this.gwC, bjVar.aAh());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, o.this.mPageId, o.this.gwC, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, o.this.mPageId, o.this.gwC, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, o.this.mPageId, o.this.gwC, o.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, o.this.mPageId, o.this.gwC, o.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public c b(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.m(this.mPageId);
        bVar.setForumName(this.forumName);
        return new c(bVar);
    }

    private com.baidu.tieba.play.y ap(bj bjVar) {
        com.baidu.tieba.play.y yVar = null;
        if (bjVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = tl(bjVar.aDy());
            yVar.emo = this.gwC.gJA;
            yVar.Pj = bjVar.getTid();
            yVar.mAbTag = bjVar.mRecomAbTag;
            if (bjVar.aCF() != null) {
                yVar.jwW = bjVar.aCF().video_md5;
            }
            bjVar.aDw();
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, c cVar) {
        if (cVar == null || cVar.bvL() == null) {
            return null;
        }
        cVar.bvL().setVideoStatsData(ap(biVar.cRg));
        cVar.bvL().a(biVar.cRg);
        cVar.bvL().c(this.eNp);
        com.baidu.tieba.frs.d.a.a(biVar.cRg, this.mPageId, this.gwC, getTbPageTag());
        return cVar.getView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bGY() {
        return this.gwC;
    }
}
