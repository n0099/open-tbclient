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
import com.baidu.tieba.play.aa;
/* loaded from: classes2.dex */
public class i extends com.baidu.tieba.frs.g<bd, a<com.baidu.tieba.frs.entelechy.view.d>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    public static int dHr = 5;
    public static int dHs = 10;
    public static int dHt = 15;
    private v<bd> ciz;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bd bdVar, String str) {
        if (bdVar != null) {
            int zR = bdVar.zR();
            ak akVar = new ak(str);
            akVar.ab("obj_locate", nk(zR));
            akVar.ab("tid", bdVar.getTid());
            akVar.s("obj_type", 2);
            TiebaStatic.log(akVar);
        }
    }

    private String nk(int i) {
        if (i == dHr) {
            return "3";
        }
        if (i == dHs) {
            return "10";
        }
        if (i != dHt) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ciz = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        i.this.e(bdVar, "c11718");
                    } else if (view.getId() == d.g.layout_root) {
                        i.this.e(bdVar, "c10242");
                    } else if (view.getId() == d.g.image_user || view.getId() == d.g.pendant_image_user) {
                        i.this.e(bdVar, "c10241");
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.e.g.a(com.baidu.tieba.frs.d.c.dQJ, bdVar.zr());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.d dVar = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        dVar.j(this.mPageId);
        dVar.setForumName(this.forumName);
        return new a(dVar);
    }

    private aa M(bd bdVar) {
        aa aaVar = null;
        if (bdVar != null) {
            aaVar = new aa();
            aaVar.mLocate = nk(bdVar.zR());
            aaVar.cWM = dQJ.dQz;
            aaVar.bAT = bdVar.getTid();
            aaVar.gtY = bdVar.mRecomAbTag;
            if (bdVar.zk() != null) {
                aaVar.gtZ = bdVar.zk().video_md5;
            }
            bdVar.zO();
        }
        return aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, a aVar) {
        if (aVar == null || aVar.alk() == null) {
            return null;
        }
        aVar.alk().setVideoStatsData(M(bdVar));
        aVar.alk().a(bdVar);
        aVar.alk().b(this.ciz);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.forumName = str;
    }
}
