package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.frs.h<bb, a<com.baidu.tieba.frs.entelechy.view.b>> implements ab, com.baidu.tieba.frs.e.d {
    public static int dTK = 5;
    public static int dTL = 10;
    public static int dTM = 15;
    private ad<bb> cbm;
    private int dTF;
    private com.baidu.tieba.frs.e.b dTG;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bb bbVar, String str) {
        if (bbVar != null) {
            int AT = bbVar.AT();
            am amVar = new am(str);
            amVar.aB("obj_locate", mN(AT));
            amVar.aB("tid", bbVar.getTid());
            amVar.y("obj_type", 2);
            TiebaStatic.log(amVar);
        }
    }

    private String mN(int i) {
        if (i == dTK) {
            return "3";
        }
        if (i == dTL) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != dTM) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dTF = 3;
        this.dTG = new com.baidu.tieba.frs.e.b();
        this.cbm = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.f.1
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
                        com.baidu.tieba.frs.f.h.a(f.this.dTG, bbVar.As());
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, f.this.mPageId, f.this.dTG);
                    } else if (view.getId() == e.g.frame_video) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 4, f.this.mPageId, f.this.dTG);
                    } else if (view.getId() == e.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, f.this.mPageId, f.this.dTG);
                    } else {
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, f.this.mPageId, f.this.dTG);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
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
            zVar.mLocate = mN(bbVar.AT());
            zVar.dbs = this.dTG.eeM;
            zVar.bjn = bbVar.getTid();
            zVar.gIM = bbVar.mRecomAbTag;
            if (bbVar.Al() != null) {
                zVar.gIN = bbVar.Al().video_md5;
            }
            bbVar.AQ();
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, a aVar) {
        if (aVar == null || aVar.arr() == null) {
            return null;
        }
        aVar.arr().setVideoStatsData(X(bbVar));
        aVar.arr().a(bbVar);
        aVar.arr().b(this.cbm);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dTG);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.forumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.dTF = i;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aFf() {
        return this.dTG;
    }
}
