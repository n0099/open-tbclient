package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.play.y;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.frs.entelechy.d.b> implements ab, com.baidu.tieba.frs.e.c {
    private ad<bb> bNr;
    private int dAA;
    private com.baidu.tieba.frs.e.a dAB;
    private Set<String> dAR;
    private boolean dAS;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dAS = false;
        this.dAA = 3;
        this.dAB = new com.baidu.tieba.frs.e.a();
        this.bNr = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.card_home_page_normal_thread_user_header || view.getId() == e.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.b.aCj().a(k.this.dAB, bbVar, 2);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_root || view.getId() == e.g.layout_root) {
                        if (bbVar.wO() == 2 && bbVar.vT() != null) {
                            String uL = bbVar.vT().uL();
                            if (StringUtils.isNull(uL)) {
                                uL = bbVar.vT().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bbVar.getFid()), bbVar.ws(), bbVar.vT().getThreadId(), "tieba.baidu.com/p/" + bbVar.vT().getThreadId(), uL);
                        }
                        com.baidu.tieba.frs.e.b.aCj().a(k.this.dAB, bbVar, 1);
                    }
                }
            }
        };
        this.dAR = new HashSet();
        this.dAS = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public com.baidu.tieba.frs.entelechy.d.b onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.g gVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        com.baidu.tieba.frs.entelechy.view.f azL = gVar.azL();
        if (azL != null) {
            azL.j(this.mPageId);
            azL.b(this.bNr);
        }
        com.baidu.tieba.frs.entelechy.view.h azM = gVar.azM();
        if (azM != null) {
            azM.j(this.mPageId);
        }
        return new com.baidu.tieba.frs.entelechy.d.b(gVar);
    }

    private y X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bbVar.xf() ? "3" : "2";
        yVar.cHI = this.dAB.dLJ;
        yVar.aZG = bbVar.getTid();
        yVar.mSource = bbVar.mRecomSource;
        yVar.goU = bbVar.alP;
        yVar.goV = bbVar.mRecomWeight;
        yVar.goX = bbVar.mRecomAbTag;
        if (bbVar.wE() != null) {
            yVar.goY = bbVar.wE().video_md5;
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.frs.entelechy.d.b bVar) {
        com.baidu.tieba.frs.entelechy.view.f azR;
        com.baidu.tieba.frs.entelechy.view.g azS = bVar.azS();
        if (azS == null || bVar == null) {
            return null;
        }
        com.baidu.tieba.frs.e.b.aCj().a(this.dAB, bbVar);
        ba vT = bbVar.vT();
        if (vT != null) {
            String taskId = vT.getTaskId();
            String uL = vT.uL();
            if (StringUtils.isNull(uL)) {
                uL = vT.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof am) {
                am amVar = (am) this.mPageContext.getOrignalPage();
                if (this.dAR.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", amVar.getForumId(), amVar.getForumName(), vT.getThreadId(), "tieba.baidu.com/p/" + bbVar.getTid(), uL);
                }
            }
        }
        if (bbVar != null) {
            bbVar.xj();
            int i2 = bbVar.wE() != null ? 2 : 1;
            azS.show(i2);
            if (i2 == 2) {
                a azT = bVar.azT();
                if (azT == null) {
                    return null;
                }
                if (azT.aln() instanceof com.baidu.tieba.frs.entelechy.view.h) {
                    com.baidu.tieba.frs.entelechy.view.h hVar = (com.baidu.tieba.frs.entelechy.view.h) azT.aln();
                    if (hVar == null) {
                        return null;
                    }
                    hVar.setVideoStatsData(X(bbVar));
                    hVar.a(bbVar);
                    hVar.b(this.bNr);
                    return azT.getView();
                }
            }
            if (i2 == 1) {
                com.baidu.tieba.frs.entelechy.d.a azU = bVar.azU();
                if (azU != null && (azR = azU.azR()) != null) {
                    azR.setFromCDN(this.mIsFromCDN);
                    azR.a(bbVar);
                    azR.gz(this.dAS);
                    return azU.getView();
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.dAR.clear();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.ab
    public void hK(int i) {
        this.dAA = i;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a azt() {
        return this.dAB;
    }
}
