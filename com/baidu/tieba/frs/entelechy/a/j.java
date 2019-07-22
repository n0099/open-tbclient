package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class j extends com.baidu.tieba.frs.h<bf, a<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    public static int fCo = 5;
    public static int fCp = 10;
    public static int fCq = 15;
    private ab<bg> dEr;
    private int fCg;
    private com.baidu.tieba.frs.d.b fCh;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bg bgVar, String str) {
        if (bgVar != null) {
            int afE = bgVar.afE();
            an anVar = new an(str);
            anVar.bT("obj_locate", rW(afE));
            anVar.bT("tid", bgVar.getTid());
            anVar.P("obj_type", 2);
            TiebaStatic.log(anVar);
        }
    }

    private String rW(int i) {
        if (i == fCo) {
            return "3";
        }
        if (i == fCp) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != fCq) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fCg = 3;
        this.fCh = new com.baidu.tieba.frs.d.b();
        this.dEr = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (view.getId() == R.id.frame_video) {
                        j.this.e(bgVar, "c11718");
                    } else if (view.getId() == R.id.layout_root) {
                        j.this.e(bgVar, "c10242");
                    } else if (view.getId() == R.id.image_user || view.getId() == R.id.pendant_image_user) {
                        j.this.e(bgVar, "c10241");
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(j.this.fCh, bgVar.acy());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, j.this.mPageId, j.this.fCh);
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, j.this.mPageId, j.this.fCh);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, j.this.mPageId, j.this.fCh);
                    } else {
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, j.this.mPageId, j.this.fCh);
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

    private com.baidu.tieba.play.z af(bg bgVar) {
        com.baidu.tieba.play.z zVar = null;
        if (bgVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = rW(bgVar.afE());
            zVar.eFy = this.fCh.fOF;
            zVar.bWO = bgVar.getTid();
            zVar.ixB = bgVar.mRecomAbTag;
            if (bgVar.aeO() != null) {
                zVar.ixC = bgVar.aeO().video_md5;
            }
            bgVar.afB();
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bf bfVar, a aVar) {
        if (aVar == null || aVar.bar() == null) {
            return null;
        }
        aVar.bar().setVideoStatsData(af(bfVar.threadData));
        aVar.bar().a(bfVar.threadData);
        aVar.bar().d(this.dEr);
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, this.fCh);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nC(int i) {
        this.fCg = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b boU() {
        return this.fCh;
    }
}
