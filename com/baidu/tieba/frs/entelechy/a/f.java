package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.frs.f<bd, a<com.baidu.tieba.frs.entelechy.view.b>> implements aa, com.baidu.tieba.frs.e.c {
    public static int dog = 5;
    public static int doh = 10;
    public static int doi = 15;
    private ab<bd> bES;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bd bdVar, String str) {
        if (bdVar != null) {
            int wj = bdVar.wj();
            am amVar = new am(str);
            amVar.ah("obj_locate", kA(wj));
            amVar.ah("tid", bdVar.getTid());
            amVar.r("obj_type", 2);
            TiebaStatic.log(amVar);
        }
    }

    private String kA(int i) {
        if (i == dog) {
            return "3";
        }
        if (i == doh) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != doi) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bES = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        f.this.e(bdVar, "c11718");
                    } else if (view.getId() == d.g.layout_root) {
                        f.this.e(bdVar, "c10242");
                    } else if (view.getId() == d.g.image_user || view.getId() == d.g.pendant_image_user) {
                        f.this.e(bdVar, "c10241");
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.dyP, bdVar.vJ());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.b bVar = new com.baidu.tieba.frs.entelechy.view.b(this.mPageContext, this.mPageId);
        bVar.j(this.mPageId);
        bVar.setForumName(this.forumName);
        return new a(bVar);
    }

    private y Q(bd bdVar) {
        y yVar = null;
        if (bdVar != null) {
            yVar = new y();
            yVar.mLocate = kA(bdVar.wj());
            yVar.cBu = dyP.dyF;
            yVar.aVt = bdVar.getTid();
            yVar.gde = bdVar.mRecomAbTag;
            if (bdVar.vD() != null) {
                yVar.gdf = bdVar.vD().video_md5;
            }
            bdVar.wg();
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.ajG() == null) {
            return null;
        }
        aVar.ajG().setVideoStatsData(Q(bdVar));
        aVar.ajG().a(bdVar);
        aVar.ajG().b(this.bES);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.forumName = str;
    }
}
