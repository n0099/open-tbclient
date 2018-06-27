package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.play.y;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.frs.h<bc, com.baidu.tieba.frs.entelechy.d.b> implements ab, com.baidu.tieba.frs.e.c {
    private ad<bc> bGN;
    private Set<String> drA;
    private boolean drB;
    private int drk;
    private com.baidu.tieba.frs.e.a drl;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.drB = false;
        this.drk = 3;
        this.drl = new com.baidu.tieba.frs.e.a();
        this.bGN = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_header || view.getId() == d.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.b.azw().a(k.this.drl, bcVar, 2);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_root || view.getId() == d.g.layout_root) {
                        if (bcVar.vW() == 2 && bcVar.vd() != null) {
                            String tX = bcVar.vd().tX();
                            if (StringUtils.isNull(tX)) {
                                tX = bcVar.vd().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bcVar.getFid()), bcVar.vB(), bcVar.vd().getThreadId(), "tieba.baidu.com/p/" + bcVar.vd().getThreadId(), tX);
                        }
                        com.baidu.tieba.frs.e.b.azw().a(k.this.drl, bcVar, 1);
                    }
                }
            }
        };
        this.drA = new HashSet();
        this.drB = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.frs.entelechy.d.b onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.g gVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        com.baidu.tieba.frs.entelechy.view.f awT = gVar.awT();
        if (awT != null) {
            awT.j(this.mPageId);
            awT.b(this.bGN);
        }
        com.baidu.tieba.frs.entelechy.view.h awU = gVar.awU();
        if (awU != null) {
            awU.j(this.mPageId);
        }
        return new com.baidu.tieba.frs.entelechy.d.b(gVar);
    }

    private y U(bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bcVar.wm() ? "3" : "2";
        yVar.czo = this.drl.dBT;
        yVar.aWo = bcVar.getTid();
        yVar.mSource = bcVar.mRecomSource;
        yVar.ghc = bcVar.ajQ;
        yVar.ghd = bcVar.mRecomWeight;
        yVar.ghf = bcVar.mRecomAbTag;
        if (bcVar.vN() != null) {
            yVar.ghg = bcVar.vN().video_md5;
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bc bcVar, com.baidu.tieba.frs.entelechy.d.b bVar) {
        com.baidu.tieba.frs.entelechy.view.f awZ;
        com.baidu.tieba.frs.entelechy.view.g axa = bVar.axa();
        if (axa == null || bVar == null) {
            return null;
        }
        com.baidu.tieba.frs.e.b.azw().a(this.drl, bcVar);
        bb vd = bcVar.vd();
        if (vd != null) {
            String taskId = vd.getTaskId();
            String tX = vd.tX();
            if (StringUtils.isNull(tX)) {
                tX = vd.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof am) {
                am amVar = (am) this.mPageContext.getOrignalPage();
                if (this.drA.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", amVar.getForumId(), amVar.getForumName(), vd.getThreadId(), "tieba.baidu.com/p/" + bcVar.getTid(), tX);
                }
            }
        }
        if (bcVar != null) {
            bcVar.wq();
            int i2 = bcVar.vN() != null ? 2 : 1;
            axa.show(i2);
            if (i2 == 2) {
                a axb = bVar.axb();
                if (axb == null) {
                    return null;
                }
                if (axb.aja() instanceof com.baidu.tieba.frs.entelechy.view.h) {
                    com.baidu.tieba.frs.entelechy.view.h hVar = (com.baidu.tieba.frs.entelechy.view.h) axb.aja();
                    if (hVar == null) {
                        return null;
                    }
                    hVar.setVideoStatsData(U(bcVar));
                    hVar.a(bcVar);
                    hVar.b(this.bGN);
                    return axb.getView();
                }
            }
            if (i2 == 1) {
                com.baidu.tieba.frs.entelechy.d.a axc = bVar.axc();
                if (axc != null && (awZ = axc.awZ()) != null) {
                    awZ.setFromCDN(this.mIsFromCDN);
                    awZ.a(bcVar);
                    awZ.fZ(this.drB);
                    return axc.getView();
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.drA.clear();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.ab
    public void hf(int i) {
        this.drk = i;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a awC() {
        return this.drl;
    }
}
