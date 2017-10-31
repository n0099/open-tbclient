package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<bh, a<com.baidu.tieba.frs.entelechy.view.d>> implements v, com.baidu.tieba.frs.e.c {
    public static int cEd = 5;
    public static int cEe = 10;
    public static int cEf = 15;
    private x<bh> boe;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bh bhVar, String str) {
        if (bhVar != null) {
            int sw = bhVar.sw();
            ak akVar = new ak(str);
            akVar.ac("obj_locate", jH(sw));
            akVar.ac("tid", bhVar.getTid());
            akVar.r("obj_type", 2);
            TiebaStatic.log(akVar);
        }
    }

    private String jH(int i) {
        if (i == cEd) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (i == cEe) {
            return "10";
        }
        if (i != cEf) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.boe = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        i.this.b(bhVar, "c11718");
                    } else if (view.getId() == d.g.layout_root) {
                        i.this.b(bhVar, "c10242");
                    } else if (view.getId() == d.g.image_user || view.getId() == d.g.pendant_image_user) {
                        i.this.b(bhVar, "c10241");
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cPd, bhVar.rS());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.d dVar = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        dVar.k(this.mPageId);
        dVar.setForumName(this.forumName);
        return new a(dVar);
    }

    private com.baidu.tieba.play.x D(bh bhVar) {
        com.baidu.tieba.play.x xVar = null;
        if (bhVar != null) {
            xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = jH(bhVar.sw());
            xVar.azE = cPd.cOV;
            xVar.aMi = bhVar.getTid();
            xVar.fGH = bhVar.ZS;
            if (bhVar.rL() != null) {
                xVar.fGI = bhVar.rL().video_md5;
            }
            bhVar.st();
        }
        return xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, a aVar) {
        if (aVar == null || aVar.aax() == null) {
            return null;
        }
        aVar.aax().setVideoStatsData(D(bhVar));
        aVar.aax().a(bhVar);
        aVar.aax().b(this.boe);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.forumName = str;
    }
}
