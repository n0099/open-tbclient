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
    private boolean aFr;
    private ad<bc> bVP;
    private String bVS;
    private int dIA;
    private com.baidu.tieba.frs.e.a dIB;
    private HashSet<String> dIO;
    private x dIU;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void Y(bb bbVar) {
        if (this.dIO == null) {
            this.dIO = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dIO.contains(bbVar.getTid())) {
            this.dIO.add(bbVar.getTid());
            TiebaStatic.log(new am("c11662").x("obj_param1", 1).ax("post_id", bbVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aFr = false;
        this.dIA = 3;
        this.dIB = new com.baidu.tieba.frs.e.a();
        this.bVP = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null && bcVar.threadData != null) {
                    bb bbVar = bcVar.threadData;
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 3).h(ImageViewerConfig.FORUM_ID, bbVar.getFid()).ax("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aFC().a(l.this.dIB, bbVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aFC().a(l.this.dIB, bbVar, 1);
                    }
                    if (view.getId() == e.g.thread_user_pendant_header || view.getId() == e.g.card_home_page_normal_thread_user_name || view.getId() == e.g.card_home_page_normal_thread_user_header) {
                        am amVar = new am("c12940");
                        amVar.ax("obj_type", "1");
                        amVar.ax("tid", bcVar.threadData.getTid());
                        TiebaStatic.log(amVar);
                    } else if (view.getId() == e.g.original_thread_view) {
                        am amVar2 = new am("c12940");
                        amVar2.ax("obj_type", "3");
                        amVar2.ax("tid", bcVar.threadData.getTid());
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
        this.dIU = new x(this.mPageContext);
        this.dIU.j(this.mPageId);
        this.dIU.fe(false);
        if (this.dIU.bWf != null) {
            this.dIU.bWf.ary = this.dIA;
            this.dIU.bWf.setInFrsAllThread(this.aFr);
        }
        if (this.dIU.cOy != null) {
            this.dIU.cOy.cPl = 3;
        }
        if (this.dIU.bWS != null) {
            this.dIU.bWS.setHideBarName(true);
        }
        this.dIU.currentPageType = this.dIA;
        return new com.baidu.tieba.card.a.a<>(this.dIU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (bbVar != null && bbVar.yb()) {
            Y(bbVar);
        }
        if (aVar == null || aVar.aoQ() == null) {
            return null;
        }
        if (aVar.aoQ() instanceof com.baidu.tieba.a.e) {
            aVar.aoQ().setPage(this.bVS);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        bc bcVar = new bc(bbVar);
        bcVar.stType = "frs_page";
        bcVar.arw = 2;
        bcVar.arx = 1;
        bcVar.ary = 3;
        bcVar.arz = 2;
        com.baidu.tieba.frs.g.a(aVar.aoQ().aaY(), this.dzP);
        com.baidu.tieba.frs.g.a(aVar.aoQ().aaZ(), this.dzP);
        if (this.dzP != null && this.dzP.beT() != null && !StringUtils.isNull(this.dzP.beT().getTopic_special_icon()) && !StringUtils.isNull(this.dzP.beT().getTopic_special_icon_right())) {
            aVar.aoQ().ai(this.dzP.beT().getTopic_special_icon(), this.dzP.beT().getTopic_special_icon_right());
        }
        aVar.aoQ().a(bcVar);
        aVar.aoQ().b(this.bVP);
        com.baidu.tieba.frs.e.b.aFC().a(this.dIB, bbVar);
        if (bbVar != null) {
            bbVar.zs();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void ii(int i) {
        this.dIA = i;
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aFr = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aCN() {
        return this.dIB;
    }
}
