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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.play.y;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.frs.entelechy.d.b> implements ab, com.baidu.tieba.frs.e.c {
    private ad<bb> bHC;
    private int dtX;
    private com.baidu.tieba.frs.e.a dtY;
    private Set<String> dun;
    private boolean duo;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.duo = false;
        this.dtX = 3;
        this.dtY = new com.baidu.tieba.frs.e.a();
        this.bHC = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_header || view.getId() == d.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.b.aAd().a(k.this.dtY, bbVar, 2);
                    } else if (view.getId() == d.g.card_home_page_normal_thread_root || view.getId() == d.g.layout_root) {
                        if (bbVar.vL() == 2 && bbVar.uR() != null) {
                            String tJ = bbVar.uR().tJ();
                            if (StringUtils.isNull(tJ)) {
                                tJ = bbVar.uR().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bbVar.getFid()), bbVar.vq(), bbVar.uR().getThreadId(), "tieba.baidu.com/p/" + bbVar.uR().getThreadId(), tJ);
                        }
                        com.baidu.tieba.frs.e.b.aAd().a(k.this.dtY, bbVar, 1);
                    }
                }
            }
        };
        this.dun = new HashSet();
        this.duo = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public com.baidu.tieba.frs.entelechy.d.b onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.g gVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        com.baidu.tieba.frs.entelechy.view.f axy = gVar.axy();
        if (axy != null) {
            axy.j(this.mPageId);
            axy.b(this.bHC);
        }
        com.baidu.tieba.frs.entelechy.view.h axz = gVar.axz();
        if (axz != null) {
            axz.j(this.mPageId);
        }
        return new com.baidu.tieba.frs.entelechy.d.b(gVar);
    }

    private y W(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bbVar.wb() ? "3" : "2";
        yVar.cBU = this.dtY.dEF;
        yVar.aWq = bbVar.getTid();
        yVar.mSource = bbVar.mRecomSource;
        yVar.ghC = bbVar.ajn;
        yVar.ghD = bbVar.mRecomWeight;
        yVar.ghF = bbVar.mRecomAbTag;
        if (bbVar.vC() != null) {
            yVar.ghG = bbVar.vC().video_md5;
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.frs.entelechy.d.b bVar) {
        com.baidu.tieba.frs.entelechy.view.f axE;
        com.baidu.tieba.frs.entelechy.view.g axF = bVar.axF();
        if (axF == null || bVar == null) {
            return null;
        }
        com.baidu.tieba.frs.e.b.aAd().a(this.dtY, bbVar);
        ba uR = bbVar.uR();
        if (uR != null) {
            String taskId = uR.getTaskId();
            String tJ = uR.tJ();
            if (StringUtils.isNull(tJ)) {
                tJ = uR.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof am) {
                am amVar = (am) this.mPageContext.getOrignalPage();
                if (this.dun.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", amVar.getForumId(), amVar.getForumName(), uR.getThreadId(), "tieba.baidu.com/p/" + bbVar.getTid(), tJ);
                }
            }
        }
        if (bbVar != null) {
            bbVar.wf();
            int i2 = bbVar.vC() != null ? 2 : 1;
            axF.show(i2);
            if (i2 == 2) {
                a axG = bVar.axG();
                if (axG == null) {
                    return null;
                }
                if (axG.ajz() instanceof com.baidu.tieba.frs.entelechy.view.h) {
                    com.baidu.tieba.frs.entelechy.view.h hVar = (com.baidu.tieba.frs.entelechy.view.h) axG.ajz();
                    if (hVar == null) {
                        return null;
                    }
                    hVar.setVideoStatsData(W(bbVar));
                    hVar.a(bbVar);
                    hVar.b(this.bHC);
                    return axG.getView();
                }
            }
            if (i2 == 1) {
                com.baidu.tieba.frs.entelechy.d.a axH = bVar.axH();
                if (axH != null && (axE = axH.axE()) != null) {
                    axE.setFromCDN(this.mIsFromCDN);
                    axE.a(bbVar);
                    axE.gb(this.duo);
                    return axH.getView();
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.dun.clear();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.ab
    public void hl(int i) {
        this.dtX = i;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axh() {
        return this.dtY;
    }
}
