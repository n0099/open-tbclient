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
public class i extends com.baidu.adp.widget.ListView.a<bh, a<com.baidu.tieba.frs.entelechy.view.d>> implements v, com.baidu.tieba.frs.f.c {
    public static int cww = 5;
    public static int cwx = 10;
    public static int cwy = 15;
    private x<bh> bmv;
    private String forumName;
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bh bhVar, String str) {
        if (bhVar != null) {
            int sp = bhVar.sp();
            ak akVar = new ak(str);
            akVar.ac("obj_locate", jq(sp));
            akVar.ac("tid", bhVar.getTid());
            akVar.r("obj_type", 2);
            TiebaStatic.log(akVar);
        }
    }

    private String jq(int i) {
        if (i == cww) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (i == cwx) {
            return "10";
        }
        if (i != cwy) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId, bdUniqueId2);
        this.bmv = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.h.frame_video) {
                        i.this.b(bhVar, "c11718");
                    } else if (view.getId() == d.h.layout_root) {
                        i.this.b(bhVar, "c10242");
                    } else if (view.getId() == d.h.image_user || view.getId() == d.h.pendant_image_user) {
                        i.this.b(bhVar, "c10241");
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cFQ, bhVar.rM());
                    }
                }
            }
        };
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.d dVar = new com.baidu.tieba.frs.entelechy.view.d(this.mH, this.mPageId);
        dVar.k(this.mPageId);
        dVar.setForumName(this.forumName);
        return new a(dVar);
    }

    private com.baidu.tieba.play.x D(bh bhVar) {
        com.baidu.tieba.play.x xVar = null;
        if (bhVar != null) {
            xVar = new com.baidu.tieba.play.x();
            xVar.mLocate = jq(bhVar.sp());
            xVar.ayT = cFQ.cFI;
            xVar.cyL = bhVar.getTid();
            xVar.fxQ = bhVar.Zx;
            if (bhVar.rF() != null) {
                xVar.fxR = bhVar.rF().video_md5;
            }
            bhVar.sm();
        }
        return xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, a aVar) {
        if (aVar == null || aVar.Yn() == null) {
            return null;
        }
        aVar.Yn().setVideoStatsData(D(bhVar));
        aVar.Yn().a(bhVar);
        aVar.Yn().b(this.bmv);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.forumName = str;
    }
}
