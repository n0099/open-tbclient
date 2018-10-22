package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.frs.h<bb, a<com.baidu.tieba.frs.entelechy.view.b>> implements ab, com.baidu.tieba.frs.e.c {
    public static int dIF = 5;
    public static int dIG = 10;
    public static int dIH = 15;
    private ad<bb> bVT;
    private int dIA;
    private com.baidu.tieba.frs.e.a dIB;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bb bbVar, String str) {
        if (bbVar != null) {
            int zv = bbVar.zv();
            am amVar = new am(str);
            amVar.ax("obj_locate", lS(zv));
            amVar.ax("tid", bbVar.getTid());
            amVar.x("obj_type", 2);
            TiebaStatic.log(amVar);
        }
    }

    private String lS(int i) {
        if (i == dIF) {
            return "3";
        }
        if (i == dIG) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != dIH) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dIA = 3;
        this.dIB = new com.baidu.tieba.frs.e.a();
        this.bVT = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.frame_video) {
                        f.this.e(bbVar, "c11718");
                    } else if (view.getId() == e.g.layout_root) {
                        f.this.e(bbVar, "c10242");
                    } else if (view.getId() == e.g.image_user || view.getId() == e.g.pendant_image_user) {
                        f.this.e(bbVar, "c10241");
                    } else if (view.getId() == e.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(f.this.dIB, bbVar.yU());
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

    private z X(bb bbVar) {
        z zVar = null;
        if (bbVar != null) {
            zVar = new z();
            zVar.mLocate = lS(bbVar.zv());
            zVar.cQb = this.dIB.dTF;
            zVar.beh = bbVar.getTid();
            zVar.gwz = bbVar.mRecomAbTag;
            if (bbVar.yN() != null) {
                zVar.gwA = bbVar.yN().video_md5;
            }
            bbVar.zs();
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.aoQ() == null) {
            return null;
        }
        aVar.aoQ().setVideoStatsData(X(bbVar));
        aVar.aoQ().a(bbVar);
        aVar.aoQ().b(this.bVT);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void ii(int i) {
        this.dIA = i;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aCN() {
        return this.dIB;
    }
}
