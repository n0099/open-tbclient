package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class q extends com.baidu.tieba.frs.h<bj, d<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    public static int hwf = 5;
    public static int hwg = 10;
    public static int hwh = 15;
    private com.baidu.tieba.card.aa<bk> fGa;
    private String forumName;
    private com.baidu.tieba.frs.d.b hvA;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void n(bk bkVar, String str) {
        if (bkVar != null) {
            int aRM = bkVar.aRM();
            an anVar = new an(str);
            anVar.dh("obj_locate", us(aRM));
            anVar.dh("tid", bkVar.getTid());
            anVar.ag("obj_type", 2);
            TiebaStatic.log(anVar);
        }
    }

    private String us(int i) {
        if (i == hwf) {
            return "3";
        }
        if (i == hwg) {
            return "10";
        }
        if (i != hwh) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hvA = new com.baidu.tieba.frs.d.b();
        this.fGa = new com.baidu.tieba.card.aa<bk>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                if (view != null && bkVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        q.this.n(bkVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        q.this.n(bkVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        q.this.n(bkVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_PORTRAIT);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(q.this.hvA, bkVar.aOj());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 2, q.this.mPageId, q.this.hvA, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 4, q.this.mPageId, q.this.hvA, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 5, q.this.mPageId, q.this.hvA, q.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bkVar, 1, q.this.mPageId, q.this.hvA, q.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bf */
    public d b(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.o(this.mPageId);
        bVar.setForumName(this.forumName);
        return new d(bVar);
    }

    private com.baidu.tieba.play.y ak(bk bkVar) {
        com.baidu.tieba.play.y yVar = null;
        if (bkVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = us(bkVar.aRM());
            yVar.evm = this.hvA.hIP;
            yVar.ais = bkVar.getTid();
            yVar.kAp = bkVar.mRecomAbTag;
            if (bkVar.aQQ() != null) {
                yVar.kAq = bkVar.aQQ().video_md5;
            }
            bkVar.aRK();
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, d dVar) {
        if (dVar == null || dVar.bLU() == null) {
            return null;
        }
        dVar.bLU().setVideoStatsData(ak(bjVar.dEA));
        dVar.bLU().a(bjVar.dEA);
        dVar.bLU().c(this.fGa);
        com.baidu.tieba.frs.d.a.a(bjVar.dEA, this.mPageId, this.hvA, getTbPageTag());
        return dVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hvA;
    }
}
