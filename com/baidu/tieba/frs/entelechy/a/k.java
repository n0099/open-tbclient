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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.play.y;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.frs.entelechy.d.b> implements ab, com.baidu.tieba.frs.e.c {
    private ad<bb> bHC;
    private int dtU;
    private com.baidu.tieba.frs.e.a dtV;
    private Set<String> duk;
    private boolean dul;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dul = false;
        this.dtU = 3;
        this.dtV = new com.baidu.tieba.frs.e.a();
        this.bHC = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == f.g.card_home_page_normal_thread_user_header || view.getId() == f.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.b.aAa().a(k.this.dtV, bbVar, 2);
                    } else if (view.getId() == f.g.card_home_page_normal_thread_root || view.getId() == f.g.layout_root) {
                        if (bbVar.vK() == 2 && bbVar.uQ() != null) {
                            String tI = bbVar.uQ().tI();
                            if (StringUtils.isNull(tI)) {
                                tI = bbVar.uQ().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bbVar.getFid()), bbVar.vp(), bbVar.uQ().getThreadId(), "tieba.baidu.com/p/" + bbVar.uQ().getThreadId(), tI);
                        }
                        com.baidu.tieba.frs.e.b.aAa().a(k.this.dtV, bbVar, 1);
                    }
                }
            }
        };
        this.duk = new HashSet();
        this.dul = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public com.baidu.tieba.frs.entelechy.d.b onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.g gVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        com.baidu.tieba.frs.entelechy.view.f axx = gVar.axx();
        if (axx != null) {
            axx.j(this.mPageId);
            axx.b(this.bHC);
        }
        com.baidu.tieba.frs.entelechy.view.h axy = gVar.axy();
        if (axy != null) {
            axy.j(this.mPageId);
        }
        return new com.baidu.tieba.frs.entelechy.d.b(gVar);
    }

    private y W(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        y yVar = new y();
        yVar.mLocate = bbVar.wa() ? "3" : "2";
        yVar.cBR = this.dtV.dEC;
        yVar.aWq = bbVar.getTid();
        yVar.mSource = bbVar.mRecomSource;
        yVar.ghB = bbVar.ajn;
        yVar.ghC = bbVar.mRecomWeight;
        yVar.ghE = bbVar.mRecomAbTag;
        if (bbVar.vB() != null) {
            yVar.ghF = bbVar.vB().video_md5;
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.frs.entelechy.d.b bVar) {
        com.baidu.tieba.frs.entelechy.view.f axC;
        com.baidu.tieba.frs.entelechy.view.g axD = bVar.axD();
        if (axD == null || bVar == null) {
            return null;
        }
        com.baidu.tieba.frs.e.b.aAa().a(this.dtV, bbVar);
        ba uQ = bbVar.uQ();
        if (uQ != null) {
            String taskId = uQ.getTaskId();
            String tI = uQ.tI();
            if (StringUtils.isNull(tI)) {
                tI = uQ.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof am) {
                am amVar = (am) this.mPageContext.getOrignalPage();
                if (this.duk.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", amVar.getForumId(), amVar.getForumName(), uQ.getThreadId(), "tieba.baidu.com/p/" + bbVar.getTid(), tI);
                }
            }
        }
        if (bbVar != null) {
            bbVar.we();
            int i2 = bbVar.vB() != null ? 2 : 1;
            axD.show(i2);
            if (i2 == 2) {
                a axE = bVar.axE();
                if (axE == null) {
                    return null;
                }
                if (axE.ajC() instanceof com.baidu.tieba.frs.entelechy.view.h) {
                    com.baidu.tieba.frs.entelechy.view.h hVar = (com.baidu.tieba.frs.entelechy.view.h) axE.ajC();
                    if (hVar == null) {
                        return null;
                    }
                    hVar.setVideoStatsData(W(bbVar));
                    hVar.a(bbVar);
                    hVar.b(this.bHC);
                    return axE.getView();
                }
            }
            if (i2 == 1) {
                com.baidu.tieba.frs.entelechy.d.a axF = bVar.axF();
                if (axF != null && (axC = axF.axC()) != null) {
                    axC.setFromCDN(this.mIsFromCDN);
                    axC.a(bbVar);
                    axC.gb(this.dul);
                    return axF.getView();
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.duk.clear();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.ab
    public void hk(int i) {
        this.dtU = i;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axg() {
        return this.dtV;
    }
}
