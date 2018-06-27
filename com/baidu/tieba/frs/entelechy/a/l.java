package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bd;
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
public class l extends com.baidu.tieba.frs.h<bc, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f, ab, com.baidu.tieba.frs.e.c {
    private boolean ayb;
    private ad<bd> bGJ;
    private String bGM;
    private x drD;
    private int drk;
    private com.baidu.tieba.frs.e.a drl;
    private HashSet<String> dry;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void V(bc bcVar) {
        if (this.dry == null) {
            this.dry = new HashSet<>();
        }
        if (bcVar.getTid() != null && !this.dry.contains(bcVar.getTid())) {
            this.dry.add(bcVar.getTid());
            TiebaStatic.log(new an("c11662").r("obj_param1", 1).ah("post_id", bcVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ayb = false;
        this.drk = 3;
        this.drl = new com.baidu.tieba.frs.e.a();
        this.bGJ = new ad<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null && bdVar.threadData != null) {
                    bc bcVar = bdVar.threadData;
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").r("obj_type", 3).f(ImageViewerConfig.FORUM_ID, bcVar.getFid()).ah("tid", bcVar.getTid()));
                    }
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.azw().a(l.this.drl, bcVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.azw().a(l.this.drl, bcVar, 1);
                    }
                    if (view.getId() == d.g.thread_user_pendant_header || view.getId() == d.g.card_home_page_normal_thread_user_name || view.getId() == d.g.card_home_page_normal_thread_user_header) {
                        an anVar = new an("c12940");
                        anVar.ah("obj_type", "1");
                        anVar.ah("tid", bdVar.threadData.getTid());
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == d.g.original_thread_view) {
                        an anVar2 = new an("c12940");
                        anVar2.ah("obj_type", "3");
                        anVar2.ah("tid", bdVar.threadData.getTid());
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
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.drD = new x(this.mPageContext);
        this.drD.j(this.mPageId);
        this.drD.eu(false);
        if (this.drD.bGZ != null) {
            this.drD.bGZ.akz = this.drk;
            this.drD.bGZ.setInFrsAllThread(this.ayb);
        }
        if (this.drD.cxM != null) {
            this.drD.cxM.cyz = 3;
        }
        if (this.drD.bHN != null) {
            this.drD.bHN.setHideBarName(true);
        }
        this.drD.currentPageType = this.drk;
        return new com.baidu.tieba.card.a.a<>(this.drD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bc bcVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (bcVar != null && bcVar.vc()) {
            V(bcVar);
        }
        if (aVar == null || aVar.aja() == null) {
            return null;
        }
        if (aVar.aja() instanceof com.baidu.tieba.a.e) {
            aVar.aja().setPage(this.bGM);
        }
        super.onFillViewHolder(i, view, viewGroup, bcVar, aVar);
        bd bdVar = new bd(bcVar);
        bdVar.stType = "frs_page";
        bdVar.akx = 2;
        bdVar.aky = 1;
        bdVar.akz = 3;
        com.baidu.tieba.frs.g.a(aVar.aja().Vr(), this.djc);
        com.baidu.tieba.frs.g.a(aVar.aja().Vs(), this.djc);
        if (this.djc != null && this.djc.baT() != null && !StringUtils.isNull(this.djc.baT().getTopic_special_icon()) && !StringUtils.isNull(this.djc.baT().getTopic_special_icon_right())) {
            aVar.aja().P(this.djc.baT().getTopic_special_icon(), this.djc.baT().getTopic_special_icon_right());
        }
        aVar.aja().a(bdVar);
        aVar.aja().b(this.bGJ);
        com.baidu.tieba.frs.e.b.azw().a(this.drl, bcVar);
        if (bcVar != null) {
            bcVar.wq();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hf(int i) {
        this.drk = i;
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.ayb = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a awC() {
        return this.drl;
    }
}
