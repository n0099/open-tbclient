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
import com.baidu.tieba.play.z;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class k extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.frs.entelechy.d.b> implements ab, com.baidu.tieba.frs.e.c {
    private ad<bb> bWF;
    private int dJE;
    private com.baidu.tieba.frs.e.a dJF;
    private Set<String> dJV;
    private boolean dJW;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dJW = false;
        this.dJE = 3;
        this.dJF = new com.baidu.tieba.frs.e.a();
        this.bWF = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.card_home_page_normal_thread_user_header || view.getId() == e.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.b.aEY().a(k.this.dJF, bbVar, 2);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_root || view.getId() == e.g.layout_root) {
                        if (bbVar.ze() == 2 && bbVar.yj() != null) {
                            String xc = bbVar.yj().xc();
                            if (StringUtils.isNull(xc)) {
                                xc = bbVar.yj().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bbVar.getFid()), bbVar.yI(), bbVar.yj().getThreadId(), "tieba.baidu.com/p/" + bbVar.yj().getThreadId(), xc);
                        }
                        com.baidu.tieba.frs.e.b.aEY().a(k.this.dJF, bbVar, 1);
                    }
                }
            }
        };
        this.dJV = new HashSet();
        this.dJW = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public com.baidu.tieba.frs.entelechy.d.b onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.g gVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        com.baidu.tieba.frs.entelechy.view.f aCz = gVar.aCz();
        if (aCz != null) {
            aCz.j(this.mPageId);
            aCz.b(this.bWF);
        }
        com.baidu.tieba.frs.entelechy.view.h aCA = gVar.aCA();
        if (aCA != null) {
            aCA.j(this.mPageId);
        }
        return new com.baidu.tieba.frs.entelechy.d.b(gVar);
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.zv() ? "3" : "2";
        zVar.cRh = this.dJF.dUL;
        zVar.beV = bbVar.getTid();
        zVar.mSource = bbVar.mRecomSource;
        zVar.gxX = bbVar.arx;
        zVar.gxY = bbVar.mRecomWeight;
        zVar.gya = bbVar.mRecomAbTag;
        if (bbVar.yU() != null) {
            zVar.gyb = bbVar.yU().video_md5;
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.frs.entelechy.d.b bVar) {
        com.baidu.tieba.frs.entelechy.view.f aCF;
        com.baidu.tieba.frs.entelechy.view.g aCG = bVar.aCG();
        if (aCG == null || bVar == null) {
            return null;
        }
        com.baidu.tieba.frs.e.b.aEY().a(this.dJF, bbVar);
        ba yj = bbVar.yj();
        if (yj != null) {
            String taskId = yj.getTaskId();
            String xc = yj.xc();
            if (StringUtils.isNull(xc)) {
                xc = yj.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof am) {
                am amVar = (am) this.mPageContext.getOrignalPage();
                if (this.dJV.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", amVar.getForumId(), amVar.getForumName(), yj.getThreadId(), "tieba.baidu.com/p/" + bbVar.getTid(), xc);
                }
            }
        }
        if (bbVar != null) {
            bbVar.zz();
            int i2 = bbVar.yU() != null ? 2 : 1;
            aCG.show(i2);
            if (i2 == 2) {
                a aCH = bVar.aCH();
                if (aCH == null) {
                    return null;
                }
                if (aCH.aor() instanceof com.baidu.tieba.frs.entelechy.view.h) {
                    com.baidu.tieba.frs.entelechy.view.h hVar = (com.baidu.tieba.frs.entelechy.view.h) aCH.aor();
                    if (hVar == null) {
                        return null;
                    }
                    hVar.setVideoStatsData(X(bbVar));
                    hVar.a(bbVar);
                    hVar.b(this.bWF);
                    return aCH.getView();
                }
            }
            if (i2 == 1) {
                com.baidu.tieba.frs.entelechy.d.a aCI = bVar.aCI();
                if (aCI != null && (aCF = aCI.aCF()) != null) {
                    aCF.setFromCDN(this.mIsFromCDN);
                    aCF.a(bbVar);
                    aCF.ha(this.dJW);
                    return aCI.getView();
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.dJV.clear();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.ab
    public void iv(int i) {
        this.dJE = i;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aCh() {
        return this.dJF;
    }
}
