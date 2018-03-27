package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.play.aa;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.frs.g<bd, a<com.baidu.tieba.frs.entelechy.view.d>> implements t, com.baidu.tieba.frs.e.c {
    public static int dKJ = 5;
    public static int dKK = 10;
    public static int dKL = 15;
    private v<bd> clO;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bd bdVar, String str) {
        if (bdVar != null) {
            int Al = bdVar.Al();
            ak akVar = new ak(str);
            akVar.ab("obj_locate", ni(Al));
            akVar.ab("tid", bdVar.getTid());
            akVar.s("obj_type", 2);
            TiebaStatic.log(akVar);
        }
    }

    private String ni(int i) {
        if (i == dKJ) {
            return "3";
        }
        if (i == dKK) {
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
        if (i != dKL) {
            return "";
        }
        return Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.clO = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        h.this.e(bdVar, "c11718");
                    } else if (view.getId() == d.g.layout_root) {
                        h.this.e(bdVar, "c10242");
                    } else if (view.getId() == d.g.image_user || view.getId() == d.g.pendant_image_user) {
                        h.this.e(bdVar, "c10241");
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.dUj, bdVar.zM());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aw */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.d dVar = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        dVar.j(this.mPageId);
        dVar.setForumName(this.forumName);
        return new a(dVar);
    }

    private aa P(bd bdVar) {
        aa aaVar = null;
        if (bdVar != null) {
            aaVar = new aa();
            aaVar.mLocate = ni(bdVar.Al());
            aaVar.cZL = dUj.dTZ;
            aaVar.bCV = bdVar.getTid();
            aaVar.gwe = bdVar.mRecomAbTag;
            if (bdVar.zF() != null) {
                aaVar.gwf = bdVar.zF().video_md5;
            }
            bdVar.Ai();
        }
        return aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.alY() == null) {
            return null;
        }
        aVar.alY().setVideoStatsData(P(bdVar));
        aVar.alY().a(bdVar);
        aVar.alY().b(this.clO);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.forumName = str;
    }
}
