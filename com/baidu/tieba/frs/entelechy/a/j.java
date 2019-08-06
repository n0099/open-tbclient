package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class j extends com.baidu.tieba.frs.h<bg, a<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    public static int fDc = 5;
    public static int fDd = 10;
    public static int fDe = 15;
    private ab<bh> dEy;
    private int fCU;
    private com.baidu.tieba.frs.d.b fCV;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bh bhVar, String str) {
        if (bhVar != null) {
            int afF = bhVar.afF();
            an anVar = new an(str);
            anVar.bT("obj_locate", rY(afF));
            anVar.bT("tid", bhVar.getTid());
            anVar.P("obj_type", 2);
            TiebaStatic.log(anVar);
        }
    }

    private String rY(int i) {
        if (i == fDc) {
            return "3";
        }
        if (i == fDd) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != fDe) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fCU = 3;
        this.fCV = new com.baidu.tieba.frs.d.b();
        this.dEy = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        j.this.e(bhVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        j.this.e(bhVar, "c10242");
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        j.this.e(bhVar, "c10241");
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(j.this.fCV, bhVar.acz());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, j.this.mPageId, j.this.fCV);
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 4, j.this.mPageId, j.this.fCV);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, j.this.mPageId, j.this.fCV);
                    } else {
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, j.this.mPageId, j.this.fCV);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.l(this.mPageId);
        bVar.setForumName(this.forumName);
        return new a(bVar);
    }

    private com.baidu.tieba.play.z ag(bh bhVar) {
        com.baidu.tieba.play.z zVar = null;
        if (bhVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = rY(bhVar.afF());
            zVar.eFF = this.fCV.fPt;
            zVar.bWU = bhVar.getTid();
            zVar.iyE = bhVar.mRecomAbTag;
            if (bhVar.aeP() != null) {
                zVar.iyF = bhVar.aeP().video_md5;
            }
            bhVar.afC();
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, a aVar) {
        if (aVar == null || aVar.bat() == null) {
            return null;
        }
        aVar.bat().setVideoStatsData(ag(bgVar.threadData));
        aVar.bat().a(bgVar.threadData);
        aVar.bat().d(this.dEy);
        com.baidu.tieba.frs.d.a.a(bgVar.threadData, this.mPageId, this.fCV);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nD(int i) {
        this.fCU = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bph() {
        return this.fCV;
    }
}
