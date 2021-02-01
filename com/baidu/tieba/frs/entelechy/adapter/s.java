package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class s extends com.baidu.tieba.frs.k<ca, FrsCardVideoViewHolder<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    public static int jra = 5;
    public static int jrb = 10;
    public static int jrc = 15;
    private String forumName;
    private com.baidu.tieba.card.ab<cb> hmS;
    private com.baidu.tieba.frs.b.b jqq;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void n(cb cbVar, String str) {
        if (cbVar != null) {
            int bpg = cbVar.bpg();
            ar arVar = new ar(str);
            arVar.dR("obj_locate", zo(bpg));
            arVar.dR("tid", cbVar.getTid());
            arVar.ap("obj_type", 2);
            TiebaStatic.log(arVar);
        }
    }

    private String zo(int i) {
        if (i == jra) {
            return "3";
        }
        if (i == jrb) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != jrc) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jqq = new com.baidu.tieba.frs.b.b();
        this.hmS = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        s.this.n(cbVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        s.this.n(cbVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        s.this.n(cbVar, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_PORTRAIT);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(s.this.jqq, cbVar.blo());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 2, s.this.mPageId, s.this.jqq, s.this.getTbPageTag());
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 4, s.this.mPageId, s.this.jqq, s.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 5, s.this.mPageId, s.this.jqq, s.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(cbVar, 1, s.this.mPageId, s.this.jqq, s.this.getTbPageTag());
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

    private com.baidu.tieba.play.o al(cb cbVar) {
        com.baidu.tieba.play.o oVar = null;
        if (cbVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = zo(cbVar.bpg());
            oVar.fNd = this.jqq.jHm;
            oVar.amC = cbVar.getTid();
            oVar.mIi = cbVar.mRecomAbTag;
            if (cbVar.boh() != null) {
                oVar.mIj = cbVar.boh().video_md5;
            }
            cbVar.bpd();
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        if (frsCardVideoViewHolder == null || frsCardVideoViewHolder.ctb() == null) {
            return null;
        }
        frsCardVideoViewHolder.ctb().setVideoStatsData(al(caVar.eJQ));
        frsCardVideoViewHolder.ctb().a(caVar.eJQ);
        frsCardVideoViewHolder.ctb().c(this.hmS);
        com.baidu.tieba.frs.b.a.a(caVar.eJQ, this.mPageId, this.jqq, getTbPageTag());
        return frsCardVideoViewHolder.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jqq;
    }
}
