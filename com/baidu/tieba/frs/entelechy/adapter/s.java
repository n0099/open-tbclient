package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class s extends com.baidu.tieba.frs.k<by, FrsCardVideoViewHolder<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.b.d {
    public static int jlt = 5;
    public static int jlu = 10;
    public static int jlv = 15;
    private String forumName;
    private com.baidu.tieba.card.aa<bz> hiF;
    private com.baidu.tieba.frs.b.b jkJ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void n(bz bzVar, String str) {
        if (bzVar != null) {
            int boO = bzVar.boO();
            aq aqVar = new aq(str);
            aqVar.dW("obj_locate", ze(boO));
            aqVar.dW("tid", bzVar.getTid());
            aqVar.an("obj_type", 2);
            TiebaStatic.log(aqVar);
        }
    }

    private String ze(int i) {
        if (i == jlt) {
            return "3";
        }
        if (i == jlu) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != jlv) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jkJ = new com.baidu.tieba.frs.b.b();
        this.hiF = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        s.this.n(bzVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        s.this.n(bzVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        s.this.n(bzVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_PORTRAIT);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(s.this.jkJ, bzVar.bkW());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 2, s.this.mPageId, s.this.jkJ, s.this.getTbPageTag());
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 4, s.this.mPageId, s.this.jkJ, s.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 5, s.this.mPageId, s.this.jkJ, s.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(bzVar, 1, s.this.mPageId, s.this.jkJ, s.this.getTbPageTag());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bw */
    public FrsCardVideoViewHolder e(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.o(this.mPageId);
        bVar.setForumName(this.forumName);
        return new FrsCardVideoViewHolder(bVar);
    }

    private com.baidu.tieba.play.o ak(bz bzVar) {
        com.baidu.tieba.play.o oVar = null;
        if (bzVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = ze(bzVar.boO());
            oVar.fKR = this.jkJ.jBI;
            oVar.amM = bzVar.getTid();
            oVar.mzb = bzVar.mRecomAbTag;
            if (bzVar.bnO() != null) {
                oVar.mzc = bzVar.bnO().video_md5;
            }
            bzVar.boL();
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.crP() == null) {
            return null;
        }
        frsCardVideoViewHolder.crP().setVideoStatsData(ak(byVar.eHK));
        frsCardVideoViewHolder.crP().a(byVar.eHK);
        frsCardVideoViewHolder.crP().c(this.hiF);
        com.baidu.tieba.frs.b.a.a(byVar.eHK, this.mPageId, this.jkJ, getTbPageTag());
        return frsCardVideoViewHolder.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jkJ;
    }
}
