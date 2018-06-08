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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.frs.f<bd, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.frs.e.c {
    private ab<be> bEO;
    private String bER;
    private HashSet<String> dop;
    private x dou;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void R(bd bdVar) {
        if (this.dop == null) {
            this.dop = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.dop.contains(bdVar.getTid())) {
            this.dop.add(bdVar.getTid());
            TiebaStatic.log(new am("c11662").r("obj_param1", 1).ah("post_id", bdVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.bEO = new ab<be>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, be beVar) {
                if (view != null && beVar != null && beVar.threadData != null) {
                    bd bdVar = beVar.threadData;
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").r("obj_type", 3).f(ImageViewerConfig.FORUM_ID, bdVar.getFid()).ah("tid", bdVar.getTid()));
                    }
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 1);
                    }
                    if (view.getId() == d.g.thread_user_pendant_header || view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        am amVar = new am("c12940");
                        amVar.ah("obj_type", "1");
                        amVar.ah("tid", beVar.threadData.getTid());
                        TiebaStatic.log(amVar);
                    } else if (view.getId() == d.g.original_thread_view) {
                        am amVar2 = new am("c12940");
                        amVar2.ah("obj_type", "3");
                        amVar2.ah("tid", beVar.threadData.getTid());
                        TiebaStatic.log(amVar2);
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
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dou = new x(this.mPageContext);
        this.dou.j(this.mPageId);
        this.dou.currentPageType = 3;
        this.dou.ev(false);
        if (this.dou.bFe != null) {
            this.dou.bFe.aka = 3;
        }
        if (this.dou.czT != null) {
            this.dou.czT.cAF = 3;
        }
        if (this.dou.bFT != null) {
            this.dou.bFT.setHideBarName(true);
        }
        return new com.baidu.tieba.card.a.a<>(this.dou);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (bdVar != null && bdVar.uU()) {
            R(bdVar);
        }
        if (aVar == null || aVar.ajG() == null) {
            return null;
        }
        if (aVar.ajG() instanceof com.baidu.tieba.a.e) {
            aVar.ajG().setPage(this.bER);
        }
        super.onFillViewHolder(i, view, viewGroup, bdVar, aVar);
        be beVar = new be(bdVar);
        beVar.stType = "frs_page";
        beVar.ajY = 2;
        beVar.ajZ = 1;
        beVar.aka = 3;
        com.baidu.tieba.frs.e.a(aVar.ajG().UW(), this.dhf);
        com.baidu.tieba.frs.e.a(aVar.ajG().UX(), this.dhf);
        if (this.dhf != null && this.dhf.bam() != null && !StringUtils.isNull(this.dhf.bam().getTopic_special_icon()) && !StringUtils.isNull(this.dhf.bam().getTopic_special_icon_right())) {
            aVar.ajG().P(this.dhf.bam().getTopic_special_icon(), this.dhf.bam().getTopic_special_icon_right());
        }
        aVar.ajG().a(beVar);
        aVar.ajG().b(this.bEO);
        com.baidu.tieba.frs.e.b.ayQ().a(dyP, bdVar);
        if (bdVar != null) {
            bdVar.wg();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }
}
