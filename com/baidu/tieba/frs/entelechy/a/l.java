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
    private boolean aGh;
    private ad<bc> bWB;
    private String bWE;
    private int dJE;
    private com.baidu.tieba.frs.e.a dJF;
    private HashSet<String> dJS;
    private x dJY;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void Y(bb bbVar) {
        if (this.dJS == null) {
            this.dJS = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dJS.contains(bbVar.getTid())) {
            this.dJS.add(bbVar.getTid());
            TiebaStatic.log(new am("c11662").x("obj_param1", 1).ax("post_id", bbVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aGh = false;
        this.dJE = 3;
        this.dJF = new com.baidu.tieba.frs.e.a();
        this.bWB = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null && bcVar.threadData != null) {
                    bb bbVar = bcVar.threadData;
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 3).h(ImageViewerConfig.FORUM_ID, bbVar.getFid()).ax("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aEY().a(l.this.dJF, bbVar, 2);
                    } else {
                        com.baidu.tieba.frs.e.b.aEY().a(l.this.dJF, bbVar, 1);
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
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dJY = new x(this.mPageContext);
        this.dJY.j(this.mPageId);
        this.dJY.fp(false);
        if (this.dJY.bWR != null) {
            this.dJY.bWR.asl = this.dJE;
            this.dJY.bWR.setInFrsAllThread(this.aGh);
        }
        if (this.dJY.cPE != null) {
            this.dJY.cPE.cQr = 3;
        }
        if (this.dJY.bXE != null) {
            this.dJY.bXE.setHideBarName(true);
        }
        this.dJY.currentPageType = this.dJE;
        return new com.baidu.tieba.card.a.a<>(this.dJY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (bbVar != null && bbVar.yi()) {
            Y(bbVar);
        }
        if (aVar == null || aVar.aor() == null) {
            return null;
        }
        if (aVar.aor() instanceof com.baidu.tieba.a.e) {
            aVar.aor().setPage(this.bWE);
        }
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        bc bcVar = new bc(bbVar);
        bcVar.stType = "frs_page";
        bcVar.asj = 2;
        bcVar.ask = 1;
        bcVar.asl = 3;
        bcVar.asm = 2;
        com.baidu.tieba.frs.g.a(aVar.aor().abi(), this.dBg);
        com.baidu.tieba.frs.g.a(aVar.aor().abj(), this.dBg);
        if (this.dBg != null && this.dBg.ber() != null && !StringUtils.isNull(this.dBg.ber().getTopic_special_icon()) && !StringUtils.isNull(this.dBg.ber().getTopic_special_icon_right())) {
            aVar.aor().ai(this.dBg.ber().getTopic_special_icon(), this.dBg.ber().getTopic_special_icon_right());
        }
        aVar.aor().a(bcVar);
        aVar.aor().b(this.bWB);
        com.baidu.tieba.frs.e.b.aEY().a(this.dJF, bbVar);
        if (bbVar != null) {
            bbVar.zz();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iv(int i) {
        this.dJE = i;
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aGh = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aCh() {
        return this.dJF;
    }
}
