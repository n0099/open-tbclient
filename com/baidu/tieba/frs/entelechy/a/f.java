package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.frs.h<bb, a<com.baidu.tieba.frs.entelechy.view.b>> implements ab, com.baidu.tieba.frs.e.c {
    public static int duc = 5;
    public static int dud = 10;
    public static int due = 15;
    private ad<bb> bHC;
    private int dtX;
    private com.baidu.tieba.frs.e.a dtY;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bb bbVar, String str) {
        if (bbVar != null) {
            int wi = bbVar.wi();
            an anVar = new an(str);
            anVar.af("obj_locate", kS(wi));
            anVar.af("tid", bbVar.getTid());
            anVar.r("obj_type", 2);
            TiebaStatic.log(anVar);
        }
    }

    private String kS(int i) {
        if (i == duc) {
            return "3";
        }
        if (i == dud) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != due) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dtX = 3;
        this.dtY = new com.baidu.tieba.frs.e.a();
        this.bHC = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        f.this.e(bbVar, "c11718");
                    } else if (view.getId() == d.g.layout_root) {
                        f.this.e(bbVar, "c10242");
                    } else if (view.getId() == d.g.image_user || view.getId() == d.g.pendant_image_user) {
                        f.this.e(bbVar, "c10241");
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(f.this.dtY, bbVar.vI());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.j(this.mPageId);
        bVar.setForumName(this.forumName);
        return new a(bVar);
    }

    private y W(bb bbVar) {
        y yVar = null;
        if (bbVar != null) {
            yVar = new y();
            yVar.mLocate = kS(bbVar.wi());
            yVar.cBU = this.dtY.dEF;
            yVar.aWq = bbVar.getTid();
            yVar.ghF = bbVar.mRecomAbTag;
            if (bbVar.vC() != null) {
                yVar.ghG = bbVar.vC().video_md5;
            }
            bbVar.wf();
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.ajz() == null) {
            return null;
        }
        aVar.ajz().setVideoStatsData(W(bbVar));
        aVar.ajz().a(bbVar);
        aVar.ajz().b(this.bHC);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hl(int i) {
        this.dtX = i;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axh() {
        return this.dtY;
    }
}
