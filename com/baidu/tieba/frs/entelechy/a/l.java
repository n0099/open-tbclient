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
    private boolean aKl;
    private ad<bc> cbh;
    private String cbk;
    private int dTE;
    private com.baidu.tieba.frs.e.b dTF;
    private HashSet<String> dTS;
    private x dTY;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void Y(bb bbVar) {
        if (this.dTS == null) {
            this.dTS = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dTS.contains(bbVar.getTid())) {
            this.dTS.add(bbVar.getTid());
            TiebaStatic.log(new am("c11662").y("obj_param1", 1).aB("post_id", bbVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aKl = false;
        this.dTE = 3;
        this.dTF = new com.baidu.tieba.frs.e.b();
        this.cbh = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null && bcVar.threadData != null) {
                    bb bbVar = bcVar.threadData;
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").y("obj_type", 3).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aB("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.c.aHW().a(l.this.dTF, bbVar, 2);
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, l.this.mPageId, l.this.dTF);
                    } else if (view.getId() != e.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.e.c.aHW().a(l.this.dTF, bbVar, 1);
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, l.this.mPageId, l.this.dTF);
                    } else {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, l.this.mPageId, l.this.dTF);
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
        this.dTY = new x(this.mPageContext);
        this.dTY.j(this.mPageId);
        this.dTY.fv(false);
        if (this.dTY.cbx != null) {
            this.dTY.cbx.awo = this.dTE;
            this.dTY.cbx.setInFrsAllThread(this.aKl);
        }
        if (this.dTY.cZM != null) {
            this.dTY.cZM.daB = 3;
        }
        if (this.dTY.cck != null) {
            this.dTY.cck.setHideBarName(true);
        }
        this.dTY.currentPageType = this.dTE;
        return new com.baidu.tieba.card.a.a<>(this.dTY);
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
            aVar.arr().setPage(this.cbk);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        bc bcVar = new bc(bbVar);
        bcVar.stType = "frs_page";
        bcVar.awm = 2;
        bcVar.awn = 1;
        bcVar.awo = 3;
        bcVar.awp = 2;
        com.baidu.tieba.frs.g.a(aVar.arr().acN(), this.dLc);
        com.baidu.tieba.frs.g.a(aVar.arr().acO(), this.dLc);
        if (this.dLc != null && this.dLc.bhx() != null && !StringUtils.isNull(this.dLc.bhx().getTopic_special_icon()) && !StringUtils.isNull(this.dLc.bhx().getTopic_special_icon_right())) {
            aVar.arr().am(this.dLc.bhx().getTopic_special_icon(), this.dLc.bhx().getTopic_special_icon_right());
        }
        aVar.arr().a(bcVar);
        aVar.arr().b(this.cbh);
        if (this.dTF != null) {
            int i2 = 0;
            if (this.dLc != null) {
                i2 = this.dLc.aHA();
            }
            bbVar.awj = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHW().a(this.dTF, bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dTF);
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
        this.dTE = i;
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbk = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aKl = z;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aFf() {
        return this.dTF;
    }
}
