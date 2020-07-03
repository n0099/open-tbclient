package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class q extends com.baidu.tieba.frs.j<bt, d<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    public static int hJk = 5;
    public static int hJl = 10;
    public static int hJm = 15;
    private com.baidu.tieba.card.aa<bu> fRu;
    private String forumName;
    private com.baidu.tieba.frs.d.b hIE;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void n(bu buVar, String str) {
        if (buVar != null) {
            int aTD = buVar.aTD();
            ao aoVar = new ao(str);
            aoVar.dk("obj_locate", uZ(aTD));
            aoVar.dk("tid", buVar.getTid());
            aoVar.ag("obj_type", 2);
            TiebaStatic.log(aoVar);
        }
    }

    private String uZ(int i) {
        if (i == hJk) {
            return "3";
        }
        if (i == hJl) {
            return "10";
        }
        if (i != hJm) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hIE = new com.baidu.tieba.frs.d.b();
        this.fRu = new com.baidu.tieba.card.aa<bu>() { // from class: com.baidu.tieba.frs.entelechy.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bu buVar) {
                if (view != null && buVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        q.this.n(buVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        q.this.n(buVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        q.this.n(buVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_PORTRAIT);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(q.this.hIE, buVar.aPT());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(buVar, 2, q.this.mPageId, q.this.hIE, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(buVar, 4, q.this.mPageId, q.this.hIE, q.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(buVar, 5, q.this.mPageId, q.this.hIE, q.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(buVar, 1, q.this.mPageId, q.this.hIE, q.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public d b(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.o(this.mPageId);
        bVar.setForumName(this.forumName);
        return new d(bVar);
    }

    private com.baidu.tieba.play.y ak(bu buVar) {
        com.baidu.tieba.play.y yVar = null;
        if (buVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = uZ(buVar.aTD());
            yVar.eEs = this.hIE.hWO;
            yVar.ajO = buVar.getTid();
            yVar.kVs = buVar.mRecomAbTag;
            if (buVar.aSH() != null) {
                yVar.kVt = buVar.aSH().video_md5;
            }
            buVar.aTB();
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, d dVar) {
        if (dVar == null || dVar.bPg() == null) {
            return null;
        }
        dVar.bPg().setVideoStatsData(ak(btVar.dLi));
        dVar.bPg().a(btVar.dLi);
        dVar.bPg().c(this.fRu);
        com.baidu.tieba.frs.d.a.a(btVar.dLi, this.mPageId, this.hIE, getTbPageTag());
        return dVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hIE;
    }
}
