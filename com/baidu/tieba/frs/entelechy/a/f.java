package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class f extends com.baidu.tieba.frs.f<bd, a<com.baidu.tieba.frs.entelechy.view.b>> implements aa, com.baidu.tieba.frs.e.c {
    public static int ddJ = 5;
    public static int ddK = 10;
    public static int ddL = 15;
    private ab<bd> bvY;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bd bdVar, String str) {
        if (bdVar != null) {
            int sN = bdVar.sN();
            al alVar = new al(str);
            alVar.ac("obj_locate", kw(sN));
            alVar.ac("tid", bdVar.getTid());
            alVar.r("obj_type", 2);
            TiebaStatic.log(alVar);
        }
    }

    private String kw(int i) {
        if (i == ddJ) {
            return "3";
        }
        if (i == ddK) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != ddL) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.bvY = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, bd bdVar) {
                if (view2 != null && bdVar != null) {
                    if (view2.getId() == d.g.frame_video) {
                        f.this.e(bdVar, "c11718");
                    } else if (view2.getId() == d.g.layout_root) {
                        f.this.e(bdVar, "c10242");
                    } else if (view2.getId() == d.g.image_user || view2.getId() == d.g.pendant_image_user) {
                        f.this.e(bdVar, "c10241");
                    } else if (view2.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.dov, bdVar.sn());
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

    private y Q(bd bdVar) {
        y yVar = null;
        if (bdVar != null) {
            yVar = new y();
            yVar.mLocate = kw(bdVar.sN());
            yVar.crG = dov.dol;
            yVar.aNu = bdVar.getTid();
            yVar.fQM = bdVar.mRecomAbTag;
            if (bdVar.sh() != null) {
                yVar.fQN = bdVar.sh().video_md5;
            }
            bdVar.sK();
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.afY() == null) {
            return null;
        }
        aVar.afY().setVideoStatsData(Q(bdVar));
        aVar.afY().a(bdVar);
        aVar.afY().b(this.bvY);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.forumName = str;
    }
}
