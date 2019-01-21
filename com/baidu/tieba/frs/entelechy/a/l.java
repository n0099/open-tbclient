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
public class l extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f, ab, com.baidu.tieba.frs.e.d {
    private boolean aKm;
    private ad<bc> cbi;
    private String cbl;
    private int dTF;
    private com.baidu.tieba.frs.e.b dTG;
    private HashSet<String> dTT;
    private x dTZ;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void Y(bb bbVar) {
        if (this.dTT == null) {
            this.dTT = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dTT.contains(bbVar.getTid())) {
            this.dTT.add(bbVar.getTid());
            TiebaStatic.log(new am("c11662").y("obj_param1", 1).aB("post_id", bbVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aKm = false;
        this.dTF = 3;
        this.dTG = new com.baidu.tieba.frs.e.b();
        this.cbi = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null && bcVar.threadData != null) {
                    bb bbVar = bcVar.threadData;
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").y("obj_type", 3).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aB("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.c.aHW().a(l.this.dTG, bbVar, 2);
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, l.this.mPageId, l.this.dTG);
                    } else if (view.getId() != e.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.e.c.aHW().a(l.this.dTG, bbVar, 1);
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, l.this.mPageId, l.this.dTG);
                    } else {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, l.this.mPageId, l.this.dTG);
                    }
                    if (view.getId() == e.g.thread_user_pendant_header || view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        am amVar = new am("c12940");
                        amVar.aB("obj_type", "1");
                        amVar.aB("tid", bcVar.threadData.getTid());
                        TiebaStatic.log(amVar);
                    } else if (view.getId() == e.g.original_thread_view) {
                        am amVar2 = new am("c12940");
                        amVar2.aB("obj_type", "3");
                        amVar2.aB("tid", bcVar.threadData.getTid());
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
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dTZ = new x(this.mPageContext);
        this.dTZ.j(this.mPageId);
        this.dTZ.fv(false);
        if (this.dTZ.cby != null) {
            this.dTZ.cby.awp = this.dTF;
            this.dTZ.cby.setInFrsAllThread(this.aKm);
        }
        if (this.dTZ.cZN != null) {
            this.dTZ.cZN.daC = 3;
        }
        if (this.dTZ.ccl != null) {
            this.dTZ.ccl.setHideBarName(true);
        }
        this.dTZ.currentPageType = this.dTF;
        return new com.baidu.tieba.card.a.a<>(this.dTZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (bbVar != null && bbVar.zz()) {
            Y(bbVar);
        }
        if (aVar == null || aVar.arr() == null) {
            return null;
        }
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbl);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        bc bcVar = new bc(bbVar);
        bcVar.stType = "frs_page";
        bcVar.awn = 2;
        bcVar.awo = 1;
        bcVar.awp = 3;
        bcVar.awq = 2;
        com.baidu.tieba.frs.g.a(aVar.arr().acN(), this.dLd);
        com.baidu.tieba.frs.g.a(aVar.arr().acO(), this.dLd);
        if (this.dLd != null && this.dLd.bhx() != null && !StringUtils.isNull(this.dLd.bhx().getTopic_special_icon()) && !StringUtils.isNull(this.dLd.bhx().getTopic_special_icon_right())) {
            aVar.arr().am(this.dLd.bhx().getTopic_special_icon(), this.dLd.bhx().getTopic_special_icon_right());
        }
        aVar.arr().a(bcVar);
        aVar.arr().b(this.cbi);
        if (this.dTG != null) {
            int i2 = 0;
            if (this.dLd != null) {
                i2 = this.dLd.aHA();
            }
            bbVar.awk = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHW().a(this.dTG, bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dTG);
        if (bbVar != null) {
            bbVar.AQ();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.dTF = i;
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbl = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aKm = z;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aFf() {
        return this.dTG;
    }
}
