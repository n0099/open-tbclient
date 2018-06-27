package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.frs.h<bc, a<com.baidu.tieba.frs.entelechy.view.b>> implements ab, com.baidu.tieba.frs.e.c {
    public static int drp = 5;
    public static int drq = 10;
    public static int drr = 15;
    private ad<bc> bGN;
    private int drk;
    private com.baidu.tieba.frs.e.a drl;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bc bcVar, String str) {
        if (bcVar != null) {
            int wt = bcVar.wt();
            an anVar = new an(str);
            anVar.ah("obj_locate", kH(wt));
            anVar.ah("tid", bcVar.getTid());
            anVar.r("obj_type", 2);
            TiebaStatic.log(anVar);
        }
    }

    private String kH(int i) {
        if (i == drp) {
            return "3";
        }
        if (i == drq) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != drr) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.drk = 3;
        this.drl = new com.baidu.tieba.frs.e.a();
        this.bGN = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        f.this.e(bcVar, "c11718");
                    } else if (view.getId() == d.g.layout_root) {
                        f.this.e(bcVar, "c10242");
                    } else if (view.getId() == d.g.image_user || view.getId() == d.g.pendant_image_user) {
                        f.this.e(bcVar, "c10241");
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(f.this.drl, bcVar.vT());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.j(this.mPageId);
        bVar.setForumName(this.forumName);
        return new a(bVar);
    }

    private y U(bc bcVar) {
        y yVar = null;
        if (bcVar != null) {
            yVar = new y();
            yVar.mLocate = kH(bcVar.wt());
            yVar.czo = this.drl.dBT;
            yVar.aWo = bcVar.getTid();
            yVar.ghf = bcVar.mRecomAbTag;
            if (bcVar.vN() != null) {
                yVar.ghg = bcVar.vN().video_md5;
            }
            bcVar.wq();
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bc bcVar, a aVar) {
        if (aVar == null || aVar.aja() == null) {
            return null;
        }
        aVar.aja().setVideoStatsData(U(bcVar));
        aVar.aja().a(bcVar);
        aVar.aja().b(this.bGN);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hf(int i) {
        this.drk = i;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a awC() {
        return this.drl;
    }
}
