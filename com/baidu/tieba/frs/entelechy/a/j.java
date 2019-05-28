package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class j extends com.baidu.tieba.frs.h<bf, a<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    public static int fxs = 5;
    public static int fxt = 10;
    public static int fxu = 15;
    private ab<bg> dAV;
    private String forumName;
    private int fxk;
    private com.baidu.tieba.frs.d.b fxl;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bg bgVar, String str) {
        if (bgVar != null) {
            int aeC = bgVar.aeC();
            am amVar = new am(str);
            amVar.bT("obj_locate", rE(aeC));
            amVar.bT("tid", bgVar.getTid());
            amVar.P("obj_type", 2);
            TiebaStatic.log(amVar);
        }
    }

    private String rE(int i) {
        if (i == fxs) {
            return "3";
        }
        if (i == fxt) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != fxu) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fxk = 3;
        this.fxl = new com.baidu.tieba.frs.d.b();
        this.dAV = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
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
                        com.baidu.tieba.frs.f.h.a(j.this.fxl, bgVar.abw());
                    }
                    if (view.getId() == R.id.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, j.this.mPageId, j.this.fxl);
                    } else if (view.getId() == R.id.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, j.this.mPageId, j.this.fxl);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, j.this.mPageId, j.this.fxl);
                    } else {
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, j.this.mPageId, j.this.fxl);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aJ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.k(this.mPageId);
        bVar.setForumName(this.forumName);
        return new a(bVar);
    }

    private com.baidu.tieba.play.z af(bg bgVar) {
        com.baidu.tieba.play.z zVar = null;
        if (bgVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = rE(bgVar.aeC());
            zVar.eAC = this.fxl.fJF;
            zVar.bVL = bgVar.getTid();
            zVar.irk = bgVar.mRecomAbTag;
            if (bgVar.adM() != null) {
                zVar.irl = bgVar.adM().video_md5;
            }
            bgVar.aez();
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bf bfVar, a aVar) {
        if (aVar == null || aVar.aYs() == null) {
            return null;
        }
        aVar.aYs().setVideoStatsData(af(bfVar.threadData));
        aVar.aYs().a(bfVar.threadData);
        aVar.aYs().d(this.dAV);
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, this.fxl);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nt(int i) {
        this.fxk = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmT() {
        return this.fxl;
    }
}
