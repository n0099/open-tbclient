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
    private boolean aJJ;
    private ad<bc> caw;
    private String caz;
    private int dSY;
    private com.baidu.tieba.frs.e.b dSZ;
    private HashSet<String> dTm;
    private x dTs;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void Y(bb bbVar) {
        if (this.dTm == null) {
            this.dTm = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dTm.contains(bbVar.getTid())) {
            this.dTm.add(bbVar.getTid());
            TiebaStatic.log(new am("c11662").x("obj_param1", 1).aA("post_id", bbVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aJJ = false;
        this.dSY = 3;
        this.dSZ = new com.baidu.tieba.frs.e.b();
        this.caw = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null && bcVar.threadData != null) {
                    bb bbVar = bcVar.threadData;
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 3).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aA("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.c.aHz().a(l.this.dSZ, bbVar, 2);
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, l.this.mPageId, l.this.dSZ);
                    } else if (view.getId() != e.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.e.c.aHz().a(l.this.dSZ, bbVar, 1);
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, l.this.mPageId, l.this.dSZ);
                    } else {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, l.this.mPageId, l.this.dSZ);
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
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dTs = new x(this.mPageContext);
        this.dTs.j(this.mPageId);
        this.dTs.fs(false);
        if (this.dTs.caM != null) {
            this.dTs.caM.avM = this.dSY;
            this.dTs.caM.setInFrsAllThread(this.aJJ);
        }
        if (this.dTs.cZb != null) {
            this.dTs.cZb.cZO = 3;
        }
        if (this.dTs.cbz != null) {
            this.dTs.cbz.setHideBarName(true);
        }
        this.dTs.currentPageType = this.dSY;
        return new com.baidu.tieba.card.a.a<>(this.dTs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (bbVar != null && bbVar.zm()) {
            Y(bbVar);
        }
        if (aVar == null || aVar.aqT() == null) {
            return null;
        }
        if (aVar.aqT() instanceof com.baidu.tieba.a.e) {
            aVar.aqT().setPage(this.caz);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        bc bcVar = new bc(bbVar);
        bcVar.stType = "frs_page";
        bcVar.avK = 2;
        bcVar.avL = 1;
        bcVar.avM = 3;
        bcVar.avN = 2;
        com.baidu.tieba.frs.g.a(aVar.aqT().acq(), this.dKt);
        com.baidu.tieba.frs.g.a(aVar.aqT().acr(), this.dKt);
        if (this.dKt != null && this.dKt.bgT() != null && !StringUtils.isNull(this.dKt.bgT().getTopic_special_icon()) && !StringUtils.isNull(this.dKt.bgT().getTopic_special_icon_right())) {
            aVar.aqT().al(this.dKt.bgT().getTopic_special_icon(), this.dKt.bgT().getTopic_special_icon_right());
        }
        aVar.aqT().a(bcVar);
        aVar.aqT().b(this.caw);
        if (this.dSZ != null) {
            int i2 = 0;
            if (this.dKt != null) {
                i2 = this.dKt.aHd();
            }
            bbVar.avH = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHz().a(this.dSZ, bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dSZ);
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
    public void iK(int i) {
        this.dSY = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jL(String str) {
        this.caz = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aJJ = z;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aEI() {
        return this.dSZ;
    }
}
