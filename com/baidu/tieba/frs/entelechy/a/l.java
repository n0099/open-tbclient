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
import com.baidu.tieba.f;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f, ab, com.baidu.tieba.frs.e.c {
    private boolean axE;
    private String bHB;
    private ad<bc> bHy;
    private int dtU;
    private com.baidu.tieba.frs.e.a dtV;
    private HashSet<String> dui;
    private x dun;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void X(bb bbVar) {
        if (this.dui == null) {
            this.dui = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dui.contains(bbVar.getTid())) {
            this.dui.add(bbVar.getTid());
            TiebaStatic.log(new an("c11662").r("obj_param1", 1).ae("post_id", bbVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.axE = false;
        this.dtU = 3;
        this.dtV = new com.baidu.tieba.frs.e.a();
        this.bHy = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null && bcVar.threadData != null) {
                    bb bbVar = bcVar.threadData;
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").r("obj_type", 3).f(ImageViewerConfig.FORUM_ID, bbVar.getFid()).ae("tid", bbVar.getTid()));
                    }
                    if (view.getId() == f.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aAa().a(l.this.dtV, bbVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aAa().a(l.this.dtV, bbVar, 1);
                    }
                    if (view.getId() == f.g.thread_user_pendant_header || view.getId() == f.g.card_home_page_normal_thread_user_name || view.getId() == f.g.card_home_page_normal_thread_user_header) {
                        an anVar = new an("c12940");
                        anVar.ae("obj_type", "1");
                        anVar.ae("tid", bcVar.threadData.getTid());
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == f.g.original_thread_view) {
                        an anVar2 = new an("c12940");
                        anVar2.ae("obj_type", "3");
                        anVar2.ae("tid", bcVar.threadData.getTid());
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
        this.dun = new x(this.mPageContext);
        this.dun.j(this.mPageId);
        this.dun.ev(false);
        if (this.dun.bHO != null) {
            this.dun.bHO.ajY = this.dtU;
            this.dun.bHO.setInFrsAllThread(this.axE);
        }
        if (this.dun.cAm != null) {
            this.dun.cAm.cAZ = 3;
        }
        if (this.dun.bIC != null) {
            this.dun.bIC.setHideBarName(true);
        }
        this.dun.currentPageType = this.dtU;
        return new com.baidu.tieba.card.a.a<>(this.dun);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (bbVar != null && bbVar.uP()) {
            X(bbVar);
        }
        if (aVar == null || aVar.ajC() == null) {
            return null;
        }
        if (aVar.ajC() instanceof com.baidu.tieba.a.e) {
            aVar.ajC().setPage(this.bHB);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        bc bcVar = new bc(bbVar);
        bcVar.stType = "frs_page";
        bcVar.ajW = 2;
        bcVar.ajX = 1;
        bcVar.ajY = 3;
        com.baidu.tieba.frs.g.a(aVar.ajC().VD(), this.dlQ);
        com.baidu.tieba.frs.g.a(aVar.ajC().VE(), this.dlQ);
        if (this.dlQ != null && this.dlQ.aZg() != null && !StringUtils.isNull(this.dlQ.aZg().getTopic_special_icon()) && !StringUtils.isNull(this.dlQ.aZg().getTopic_special_icon_right())) {
            aVar.ajC().O(this.dlQ.aZg().getTopic_special_icon(), this.dlQ.aZg().getTopic_special_icon_right());
        }
        aVar.ajC().a(bcVar);
        aVar.ajC().b(this.bHy);
        com.baidu.tieba.frs.e.b.aAa().a(this.dtV, bbVar);
        if (bbVar != null) {
            bbVar.we();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hk(int i) {
        this.dtU = i;
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.axE = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axg() {
        return this.dtV;
    }
}
