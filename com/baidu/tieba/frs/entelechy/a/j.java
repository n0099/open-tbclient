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
import com.baidu.tieba.frs.entelechy.view.b;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class j extends com.baidu.tieba.frs.h<bf, a<b>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    public static int fhm = 5;
    public static int fhn = 10;
    public static int fho = 15;
    private ab<bg> dqn;
    private int fhe;
    private com.baidu.tieba.frs.d.b fhf;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bg bgVar, String str) {
        if (bgVar != null) {
            int ZY = bgVar.ZY();
            am amVar = new am(str);
            amVar.bJ("obj_locate", qA(ZY));
            amVar.bJ("tid", bgVar.getTid());
            amVar.T("obj_type", 2);
            TiebaStatic.log(amVar);
        }
    }

    private String qA(int i) {
        if (i == fhm) {
            return "3";
        }
        if (i == fhn) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != fho) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fhe = 3;
        this.fhf = new com.baidu.tieba.frs.d.b();
        this.dqn = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
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
                        com.baidu.tieba.frs.f.h.a(j.this.fhf, bgVar.WS());
                    }
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, j.this.mPageId, j.this.fhf);
                    } else if (view.getId() == d.g.frame_video) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 4, j.this.mPageId, j.this.fhf);
                    } else if (view.getId() == d.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, j.this.mPageId, j.this.fhf);
                    } else {
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, j.this.mPageId, j.this.fhf);
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
        b bVar = new b(this.mPageContext, this.mPageId);
        bVar.k(this.mPageId);
        bVar.setForumName(this.forumName);
        return new a(bVar);
    }

    private com.baidu.tieba.play.z ag(bg bgVar) {
        com.baidu.tieba.play.z zVar = null;
        if (bgVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = qA(bgVar.ZY());
            zVar.ele = this.fhf.ftd;
            zVar.ctx = bgVar.getTid();
            zVar.hYU = bgVar.mRecomAbTag;
            if (bgVar.Zi() != null) {
                zVar.hYV = bgVar.Zi().video_md5;
            }
            bgVar.ZV();
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bf bfVar, a aVar) {
        if (aVar == null || aVar.aRj() == null) {
            return null;
        }
        aVar.aRj().setVideoStatsData(ag(bfVar.threadData));
        aVar.aRj().a(bfVar.threadData);
        aVar.aRj().d(this.dqn);
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, this.fhf);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mD(int i) {
        this.fhe = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bfA() {
        return this.fhf;
    }
}
