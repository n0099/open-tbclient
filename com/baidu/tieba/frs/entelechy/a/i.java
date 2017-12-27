package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.play.aa;
/* loaded from: classes2.dex */
public class i extends com.baidu.tieba.frs.g<be, a<com.baidu.tieba.frs.entelechy.view.d>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    public static int dCQ = 5;
    public static int dCR = 10;
    public static int dCS = 15;
    private v<be> cis;
    private String forumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void e(be beVar, String str) {
        if (beVar != null) {
            int zZ = beVar.zZ();
            ak akVar = new ak(str);
            akVar.ab("obj_locate", nh(zZ));
            akVar.ab("tid", beVar.getTid());
            akVar.s("obj_type", 2);
            TiebaStatic.log(akVar);
        }
    }

    private String nh(int i) {
        if (i == dCQ) {
            return "3";
        }
        if (i == dCR) {
            return "10";
        }
        if (i != dCS) {
            return "";
        }
        return "11";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cis = new v<be>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                if (view != null && beVar != null) {
                    if (view.getId() == d.g.frame_video) {
                        i.this.e(beVar, "c11718");
                    } else if (view.getId() == d.g.layout_root) {
                        i.this.e(beVar, "c10242");
                    } else if (view.getId() == d.g.image_user || view.getId() == d.g.pendant_image_user) {
                        i.this.e(beVar, "c10241");
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.e.g.a(com.baidu.tieba.frs.d.c.dMh, beVar.zw());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.d dVar = new com.baidu.tieba.frs.entelechy.view.d(this.mPageContext, this.mPageId);
        dVar.j(this.mPageId);
        dVar.setForumName(this.forumName);
        return new a(dVar);
    }

    private aa M(be beVar) {
        aa aaVar = null;
        if (beVar != null) {
            aaVar = new aa();
            aaVar.mLocate = nh(beVar.zZ());
            aaVar.cSk = dMh.dLX;
            aaVar.bAK = beVar.getTid();
            aaVar.gER = beVar.mRecomAbTag;
            if (beVar.zp() != null) {
                aaVar.gES = beVar.zp().video_md5;
            }
            beVar.zW();
        }
        return aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, be beVar, a aVar) {
        if (aVar == null || aVar.akh() == null) {
            return null;
        }
        aVar.akh().setVideoStatsData(M(beVar));
        aVar.akh().a(beVar);
        aVar.akh().b(this.cis);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.forumName = str;
    }
}
