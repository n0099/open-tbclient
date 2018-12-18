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
/* loaded from: classes6.dex */
public class l extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f, ab, com.baidu.tieba.frs.e.c {
    private boolean aJH;
    private ad<bc> cat;
    private String caw;
    private x dQB;
    private int dQh;
    private com.baidu.tieba.frs.e.a dQi;
    private HashSet<String> dQv;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void Y(bb bbVar) {
        if (this.dQv == null) {
            this.dQv = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dQv.contains(bbVar.getTid())) {
            this.dQv.add(bbVar.getTid());
            TiebaStatic.log(new am("c11662").x("obj_param1", 1).aA("post_id", bbVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aJH = false;
        this.dQh = 3;
        this.dQi = new com.baidu.tieba.frs.e.a();
        this.cat = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null && bcVar.threadData != null) {
                    bb bbVar = bcVar.threadData;
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 3).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aA("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aGK().a(l.this.dQi, bbVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aGK().a(l.this.dQi, bbVar, 1);
                    }
                    if (view.getId() == e.g.thread_user_pendant_header || view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        am amVar = new am("c12940");
                        amVar.aA("obj_type", "1");
                        amVar.aA("tid", bcVar.threadData.getTid());
                        TiebaStatic.log(amVar);
                    } else if (view.getId() == e.g.original_thread_view) {
                        am amVar2 = new am("c12940");
                        amVar2.aA("obj_type", "3");
                        amVar2.aA("tid", bcVar.threadData.getTid());
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
        this.dQB = new x(this.mPageContext);
        this.dQB.j(this.mPageId);
        this.dQB.fq(false);
        if (this.dQB.caJ != null) {
            this.dQB.caJ.avL = this.dQh;
            this.dQB.caJ.setInFrsAllThread(this.aJH);
        }
        if (this.dQB.cWl != null) {
            this.dQB.cWl.cWY = 3;
        }
        if (this.dQB.cbw != null) {
            this.dQB.cbw.setHideBarName(true);
        }
        this.dQB.currentPageType = this.dQh;
        return new com.baidu.tieba.card.a.a<>(this.dQB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (bbVar != null && bbVar.zm()) {
            Y(bbVar);
        }
        if (aVar == null || aVar.aqe() == null) {
            return null;
        }
        if (aVar.aqe() instanceof com.baidu.tieba.a.e) {
            aVar.aqe().setPage(this.caw);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        bc bcVar = new bc(bbVar);
        bcVar.stType = "frs_page";
        bcVar.avJ = 2;
        bcVar.avK = 1;
        bcVar.avL = 3;
        bcVar.avM = 2;
        com.baidu.tieba.frs.g.a(aVar.aqe().aco(), this.dHF);
        com.baidu.tieba.frs.g.a(aVar.aqe().acp(), this.dHF);
        if (this.dHF != null && this.dHF.bgh() != null && !StringUtils.isNull(this.dHF.bgh().getTopic_special_icon()) && !StringUtils.isNull(this.dHF.bgh().getTopic_special_icon_right())) {
            aVar.aqe().al(this.dHF.bgh().getTopic_special_icon(), this.dHF.bgh().getTopic_special_icon_right());
        }
        aVar.aqe().a(bcVar);
        aVar.aqe().b(this.cat);
        com.baidu.tieba.frs.e.b.aGK().a(this.dQi, bbVar);
        if (bbVar != null) {
            bbVar.AD();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iJ(int i) {
        this.dQh = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aJH = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aDT() {
        return this.dQi;
    }
}
