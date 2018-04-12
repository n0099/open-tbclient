package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.frs.f<bd, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.frs.e.c {
    private ab<be> bvU;
    private String bvX;
    private HashSet<String> ddV;
    private x dea;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void R(bd bdVar) {
        if (this.ddV == null) {
            this.ddV = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.ddV.contains(bdVar.getTid())) {
            this.ddV.add(bdVar.getTid());
            TiebaStatic.log(new al("c11662").r("obj_param1", 1).ac("post_id", bdVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.bvU = new ab<be>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, be beVar) {
                if (view2 != null && beVar != null && beVar.threadData != null) {
                    bd bdVar = beVar.threadData;
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new al("c13010").r("obj_type", 3).f(ImageViewerConfig.FORUM_ID, bdVar.getFid()).ac("tid", bdVar.getTid()));
                    }
                    if (view2.getId() == d.g.card_home_page_normal_thread_user_name || (view2 instanceof HeadImageView) || (view2 instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.auH().a(com.baidu.tieba.frs.e.c.doy, bdVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.auH().a(com.baidu.tieba.frs.e.c.doy, bdVar, 1);
                    }
                    if (view2.getId() == d.g.thread_user_pendant_header || view2.getId() == d.g.card_home_page_normal_thread_user_name || view2.getId() == d.g.card_home_page_normal_thread_user_header) {
                        al alVar = new al("c12940");
                        alVar.ac("obj_type", "1");
                        alVar.ac("tid", beVar.threadData.getTid());
                        TiebaStatic.log(alVar);
                    } else if (view2.getId() == d.g.original_thread_view) {
                        al alVar2 = new al("c12940");
                        alVar2.ac("obj_type", "3");
                        alVar2.ac("tid", beVar.threadData.getTid());
                        TiebaStatic.log(alVar2);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dea = new x(this.mPageContext);
        this.dea.j(this.mPageId);
        this.dea.currentPageType = 3;
        this.dea.eq(false);
        if (this.dea.bwk != null) {
            this.dea.bwk.abV = 3;
        }
        if (this.dea.cqk != null) {
            this.dea.cqk.cqV = 3;
        }
        if (this.dea.bwZ != null) {
            this.dea.bwZ.setHideBarName(true);
        }
        return new com.baidu.tieba.card.a.a<>(this.dea);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (bdVar != null && bdVar.rz()) {
            R(bdVar);
        }
        if (aVar == null || aVar.afY() == null) {
            return null;
        }
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bvX);
        }
        be beVar = new be(bdVar);
        beVar.stType = "frs_page";
        beVar.abT = 2;
        beVar.abU = 1;
        beVar.abV = 3;
        com.baidu.tieba.frs.e.a(aVar.afY().afz(), this.cWO);
        com.baidu.tieba.frs.e.a(aVar.afY().afA(), this.cWO);
        if (this.cWO != null && this.cWO.aVq() != null && !StringUtils.isNull(this.cWO.aVq().getTopic_special_icon()) && !StringUtils.isNull(this.cWO.aVq().getTopic_special_icon_right())) {
            aVar.afY().M(this.cWO.aVq().getTopic_special_icon(), this.cWO.aVq().getTopic_special_icon_right());
        }
        aVar.afY().a(beVar);
        aVar.afY().b(this.bvU);
        com.baidu.tieba.frs.e.b.auH().a(doy, bdVar);
        if (bdVar != null) {
            bdVar.sK();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.a.f
    public void hY(String str) {
        this.bvX = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }
}
