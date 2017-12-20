package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.e;
import com.baidu.tieba.play.y;
/* loaded from: classes.dex */
public class i extends e<bd, a<com.baidu.tieba.frs.entelechy.view.d>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.e.c {
    public static int cNL = 5;
    public static int cNM = 10;
    public static int cNN = 15;
    private v<bd> buW;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bd bdVar, String str) {
        if (bdVar != null) {
            int sx = bdVar.sx();
            ak akVar = new ak(str);
            akVar.ac("obj_locate", kg(sx));
            akVar.ac("tid", bdVar.getTid());
            akVar.r("obj_type", 2);
            TiebaStatic.log(akVar);
        }
    }

    private String kg(int i) {
        if (i == cNL) {
            return "3";
        }
        if (i == cNM) {
            return "10";
        }
        if (i != cNN) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.buW = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        i.this.b(bdVar, "c11718");
                    } else if (view.getId() == d.g.layout_root) {
                        i.this.b(bdVar, "c10242");
                    } else if (view.getId() == d.g.image_user || view.getId() == d.g.pendant_image_user) {
                        i.this.b(bdVar, "c10241");
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.cYY, bdVar.rU());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.d dVar = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        dVar.k(this.mPageId);
        dVar.setForumName(this.forumName);
        return new a(dVar);
    }

    private y I(bd bdVar) {
        y yVar = null;
        if (bdVar != null) {
            yVar = new y();
            yVar.mLocate = kg(bdVar.sx());
            yVar.aAs = cYY.cYQ;
            yVar.aMU = bdVar.getTid();
            yVar.fRl = bdVar.aaf;
            if (bdVar.rN() != null) {
                yVar.fRm = bdVar.rN().video_md5;
            }
            bdVar.su();
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.acB() == null) {
            return null;
        }
        aVar.acB().setVideoStatsData(I(bdVar));
        aVar.acB().a(bdVar);
        aVar.acB().b(this.buW);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.forumName = str;
    }
}
