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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class j extends com.baidu.tieba.frs.h<bf, a<com.baidu.tieba.frs.entelechy.view.b>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    public static int fgX = 5;
    public static int fgY = 10;
    public static int fgZ = 15;
    private ab<bg> dqo;
    private int fgP;
    private com.baidu.tieba.frs.d.b fgQ;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bg bgVar, String str) {
        if (bgVar != null) {
            int ZV = bgVar.ZV();
            am amVar = new am(str);
            amVar.bJ("obj_locate", qw(ZV));
            amVar.bJ("tid", bgVar.getTid());
            amVar.T("obj_type", 2);
            TiebaStatic.log(amVar);
        }
    }

    private String qw(int i) {
        if (i == fgX) {
            return "3";
        }
        if (i == fgY) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != fgZ) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fgP = 3;
        this.fgQ = new com.baidu.tieba.frs.d.b();
        this.dqo = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        j.this.e(bgVar, "c11718");
                    } else if (view.getId() == d.g.layout_root) {
                        j.this.e(bgVar, "c10242");
                    } else if (view.getId() == d.g.image_user || view.getId() == d.g.pendant_image_user) {
                        j.this.e(bgVar, "c10241");
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(j.this.fgQ, bgVar.WP());
                    }
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, j.this.mPageId, j.this.fgQ);
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, j.this.mPageId, j.this.fgQ);
                    } else if (view.getId() == d.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, j.this.mPageId, j.this.fgQ);
                    } else {
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, j.this.mPageId, j.this.fgQ);
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
            zVar.mLocate = qw(bgVar.ZV());
            zVar.ekM = this.fgQ.fsO;
            zVar.ctw = bgVar.getTid();
            zVar.hYA = bgVar.mRecomAbTag;
            if (bgVar.Zf() != null) {
                zVar.hYB = bgVar.Zf().video_md5;
            }
            bgVar.ZS();
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bf bfVar, a aVar) {
        if (aVar == null || aVar.aRg() == null) {
            return null;
        }
        aVar.aRg().setVideoStatsData(af(bfVar.threadData));
        aVar.aRg().a(bfVar.threadData);
        aVar.aRg().d(this.dqo);
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, this.fgQ);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mC(int i) {
        this.fgP = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bfx() {
        return this.fgQ;
    }
}
