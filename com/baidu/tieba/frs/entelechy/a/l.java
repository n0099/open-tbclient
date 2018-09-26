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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.x;
import com.baidu.tieba.e;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f, ab, com.baidu.tieba.frs.e.c {
    private boolean aAK;
    private ad<bc> bNn;
    private String bNq;
    private int dAA;
    private com.baidu.tieba.frs.e.a dAB;
    private HashSet<String> dAO;
    private x dAU;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void Y(bb bbVar) {
        if (this.dAO == null) {
            this.dAO = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dAO.contains(bbVar.getTid())) {
            this.dAO.add(bbVar.getTid());
            TiebaStatic.log(new am("c11662").w("obj_param1", 1).al("post_id", bbVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aAK = false;
        this.dAA = 3;
        this.dAB = new com.baidu.tieba.frs.e.a();
        this.bNn = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null && bcVar.threadData != null) {
                    bb bbVar = bcVar.threadData;
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").w("obj_type", 3).g(ImageViewerConfig.FORUM_ID, bbVar.getFid()).al("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aCj().a(l.this.dAB, bbVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aCj().a(l.this.dAB, bbVar, 1);
                    }
                    if (view.getId() == e.g.thread_user_pendant_header || view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        am amVar = new am("c12940");
                        amVar.al("obj_type", "1");
                        amVar.al("tid", bcVar.threadData.getTid());
                        TiebaStatic.log(amVar);
                    } else if (view.getId() == e.g.original_thread_view) {
                        am amVar2 = new am("c12940");
                        amVar2.al("obj_type", "3");
                        amVar2.al("tid", bcVar.threadData.getTid());
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
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dAU = new x(this.mPageContext);
        this.dAU.j(this.mPageId);
        this.dAU.eM(false);
        if (this.dAU.bND != null) {
            this.dAU.bND.amD = this.dAA;
            this.dAU.bND.setInFrsAllThread(this.aAK);
        }
        if (this.dAU.cGe != null) {
            this.dAU.cGe.cGR = 3;
        }
        if (this.dAU.bOr != null) {
            this.dAU.bOr.setHideBarName(true);
        }
        this.dAU.currentPageType = this.dAA;
        return new com.baidu.tieba.card.a.a<>(this.dAU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (bbVar != null && bbVar.vS()) {
            Y(bbVar);
        }
        if (aVar == null || aVar.aln() == null) {
            return null;
        }
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        bc bcVar = new bc(bbVar);
        bcVar.stType = "frs_page";
        bcVar.amB = 2;
        bcVar.amC = 1;
        bcVar.amD = 3;
        bcVar.amE = 2;
        com.baidu.tieba.frs.g.a(aVar.aln().Xq(), this.drN);
        com.baidu.tieba.frs.g.a(aVar.aln().Xr(), this.drN);
        if (this.drN != null && this.drN.bbH() != null && !StringUtils.isNull(this.drN.bbH().getTopic_special_icon()) && !StringUtils.isNull(this.drN.bbH().getTopic_special_icon_right())) {
            aVar.aln().V(this.drN.bbH().getTopic_special_icon(), this.drN.bbH().getTopic_special_icon_right());
        }
        aVar.aln().a(bcVar);
        aVar.aln().b(this.bNn);
        com.baidu.tieba.frs.e.b.aCj().a(this.dAB, bbVar);
        if (bbVar != null) {
            bbVar.xj();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hK(int i) {
        this.dAA = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aAK = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a azt() {
        return this.dAB;
    }
}
