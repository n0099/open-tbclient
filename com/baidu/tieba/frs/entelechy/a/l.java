package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f, ab, com.baidu.tieba.frs.e.c {
    private boolean axH;
    private String bHB;
    private ad<bc> bHy;
    private int dtX;
    private com.baidu.tieba.frs.e.a dtY;
    private HashSet<String> dul;
    private x duq;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void X(bb bbVar) {
        if (this.dul == null) {
            this.dul = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dul.contains(bbVar.getTid())) {
            this.dul.add(bbVar.getTid());
            TiebaStatic.log(new an("c11662").r("obj_param1", 1).af("post_id", bbVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.axH = false;
        this.dtX = 3;
        this.dtY = new com.baidu.tieba.frs.e.a();
        this.bHy = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null && bcVar.threadData != null) {
                    bb bbVar = bcVar.threadData;
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").r("obj_type", 3).f(ImageViewerConfig.FORUM_ID, bbVar.getFid()).af("tid", bbVar.getTid()));
                    }
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aAd().a(l.this.dtY, bbVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aAd().a(l.this.dtY, bbVar, 1);
                    }
                    if (view.getId() == d.g.thread_user_pendant_header || view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        an anVar = new an("c12940");
                        anVar.af("obj_type", "1");
                        anVar.af("tid", bcVar.threadData.getTid());
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == d.g.original_thread_view) {
                        an anVar2 = new an("c12940");
                        anVar2.af("obj_type", "3");
                        anVar2.af("tid", bcVar.threadData.getTid());
                        TiebaStatic.log(anVar2);
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
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.duq = new x(this.mPageContext);
        this.duq.j(this.mPageId);
        this.duq.ev(false);
        if (this.duq.bHO != null) {
            this.duq.bHO.ajY = this.dtX;
            this.duq.bHO.setInFrsAllThread(this.axH);
        }
        if (this.duq.cAp != null) {
            this.duq.cAp.cBc = 3;
        }
        if (this.duq.bIC != null) {
            this.duq.bIC.setHideBarName(true);
        }
        this.duq.currentPageType = this.dtX;
        return new com.baidu.tieba.card.a.a<>(this.duq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (bbVar != null && bbVar.uQ()) {
            X(bbVar);
        }
        if (aVar == null || aVar.ajz() == null) {
            return null;
        }
        if (aVar.ajz() instanceof com.baidu.tieba.a.e) {
            aVar.ajz().setPage(this.bHB);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        bc bcVar = new bc(bbVar);
        bcVar.stType = "frs_page";
        bcVar.ajW = 2;
        bcVar.ajX = 1;
        bcVar.ajY = 3;
        com.baidu.tieba.frs.g.a(aVar.ajz().VA(), this.dlS);
        com.baidu.tieba.frs.g.a(aVar.ajz().VB(), this.dlS);
        if (this.dlS != null && this.dlS.aZl() != null && !StringUtils.isNull(this.dlS.aZl().getTopic_special_icon()) && !StringUtils.isNull(this.dlS.aZl().getTopic_special_icon_right())) {
            aVar.ajz().O(this.dlS.aZl().getTopic_special_icon(), this.dlS.aZl().getTopic_special_icon_right());
        }
        aVar.ajz().a(bcVar);
        aVar.ajz().b(this.bHy);
        com.baidu.tieba.frs.e.b.aAd().a(this.dtY, bbVar);
        if (bbVar != null) {
            bbVar.wf();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hl(int i) {
        this.dtX = i;
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.axH = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axh() {
        return this.dtY;
    }
}
