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
import com.baidu.tieba.f;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.frs.h<bb, a<com.baidu.tieba.frs.entelechy.view.b>> implements ab, com.baidu.tieba.frs.e.c {
    public static int dtZ = 5;
    public static int dua = 10;
    public static int dub = 15;
    private ad<bb> bHC;
    private int dtU;
    private com.baidu.tieba.frs.e.a dtV;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bb bbVar, String str) {
        if (bbVar != null) {
            int wh = bbVar.wh();
            an anVar = new an(str);
            anVar.ae("obj_locate", kR(wh));
            anVar.ae("tid", bbVar.getTid());
            anVar.r("obj_type", 2);
            TiebaStatic.log(anVar);
        }
    }

    private String kR(int i) {
        if (i == dtZ) {
            return "3";
        }
        if (i == dua) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != dub) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dtU = 3;
        this.dtV = new com.baidu.tieba.frs.e.a();
        this.bHC = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == f.g.frame_video) {
                        f.this.e(bbVar, "c11718");
                    } else if (view.getId() == f.g.layout_root) {
                        f.this.e(bbVar, "c10242");
                    } else if (view.getId() == f.g.image_user || view.getId() == f.g.pendant_image_user) {
                        f.this.e(bbVar, "c10241");
                    } else if (view.getId() == f.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(f.this.dtV, bbVar.vH());
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
            yVar.mLocate = kR(bbVar.wh());
            yVar.cBR = this.dtV.dEC;
            yVar.aWq = bbVar.getTid();
            yVar.ghE = bbVar.mRecomAbTag;
            if (bbVar.vB() != null) {
                yVar.ghF = bbVar.vB().video_md5;
            }
            bbVar.we();
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.ajC() == null) {
            return null;
        }
        aVar.ajC().setVideoStatsData(W(bbVar));
        aVar.ajC().a(bbVar);
        aVar.ajC().b(this.bHC);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hk(int i) {
        this.dtU = i;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axg() {
        return this.dtV;
    }
}
