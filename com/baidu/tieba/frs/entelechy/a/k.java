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
    private ad<bb> bVT;
    private int dIA;
    private com.baidu.tieba.frs.e.a dIB;
    private Set<String> dIR;
    private boolean dIS;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dIS = false;
        this.dIA = 3;
        this.dIB = new com.baidu.tieba.frs.e.a();
        this.bVT = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (view.getId() == e.g.card_home_page_normal_thread_user_header || view.getId() == e.g.card_home_page_normal_thread_user_pendant_header) {
                        com.baidu.tieba.frs.e.b.aFC().a(k.this.dIB, bbVar, 2);
                    } else if (view.getId() == e.g.card_home_page_normal_thread_root || view.getId() == e.g.layout_root) {
                        if (bbVar.yX() == 2 && bbVar.yc() != null) {
                            String wU = bbVar.yc().wU();
                            if (StringUtils.isNull(wU)) {
                                wU = bbVar.yc().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bbVar.getFid()), bbVar.yB(), bbVar.yc().getThreadId(), "tieba.baidu.com/p/" + bbVar.yc().getThreadId(), wU);
                        }
                        com.baidu.tieba.frs.e.b.aFC().a(k.this.dIB, bbVar, 1);
                    }
                }
            }
        };
        this.dIR = new HashSet();
        this.dIS = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public com.baidu.tieba.frs.entelechy.d.b onCreateViewHolder(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.g gVar = new com.baidu.tieba.frs.entelechy.view.g(this.mPageContext, this.mPageId);
        com.baidu.tieba.frs.entelechy.view.f aDf = gVar.aDf();
        if (aDf != null) {
            aDf.j(this.mPageId);
            aDf.b(this.bVT);
        }
        com.baidu.tieba.frs.entelechy.view.h aDg = gVar.aDg();
        if (aDg != null) {
            aDg.j(this.mPageId);
        }
        return new com.baidu.tieba.frs.entelechy.d.b(gVar);
    }

    private z X(bb bbVar) {
        if (bbVar == null) {
            return null;
        }
        z zVar = new z();
        zVar.mLocate = bbVar.zo() ? "3" : "2";
        zVar.cQb = this.dIB.dTF;
        zVar.beh = bbVar.getTid();
        zVar.mSource = bbVar.mRecomSource;
        zVar.gww = bbVar.aqK;
        zVar.gwx = bbVar.mRecomWeight;
        zVar.gwz = bbVar.mRecomAbTag;
        if (bbVar.yN() != null) {
            zVar.gwA = bbVar.yN().video_md5;
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.frs.entelechy.d.b bVar) {
        com.baidu.tieba.frs.entelechy.view.f aDl;
        com.baidu.tieba.frs.entelechy.view.g aDm = bVar.aDm();
        if (aDm == null || bVar == null) {
            return null;
        }
        com.baidu.tieba.frs.e.b.aFC().a(this.dIB, bbVar);
        ba yc = bbVar.yc();
        if (yc != null) {
            String taskId = yc.getTaskId();
            String wU = yc.wU();
            if (StringUtils.isNull(wU)) {
                wU = yc.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof am) {
                am amVar = (am) this.mPageContext.getOrignalPage();
                if (this.dIR.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", amVar.getForumId(), amVar.getForumName(), yc.getThreadId(), "tieba.baidu.com/p/" + bbVar.getTid(), wU);
                }
            }
        }
        if (bbVar != null) {
            bbVar.zs();
            int i2 = bbVar.yN() != null ? 2 : 1;
            aDm.show(i2);
            if (i2 == 2) {
                a aDn = bVar.aDn();
                if (aDn == null) {
                    return null;
                }
                if (aDn.aoQ() instanceof com.baidu.tieba.frs.entelechy.view.h) {
                    com.baidu.tieba.frs.entelechy.view.h hVar = (com.baidu.tieba.frs.entelechy.view.h) aDn.aoQ();
                    if (hVar == null) {
                        return null;
                    }
                    hVar.setVideoStatsData(X(bbVar));
                    hVar.a(bbVar);
                    hVar.b(this.bVT);
                    return aDn.getView();
                }
            }
            if (i2 == 1) {
                com.baidu.tieba.frs.entelechy.d.a aDo = bVar.aDo();
                if (aDo != null && (aDl = aDo.aDl()) != null) {
                    aDl.setFromCDN(this.mIsFromCDN);
                    aDl.a(bbVar);
                    aDl.gR(this.dIS);
                    return aDo.getView();
                }
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.dIR.clear();
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.ab
    public void ii(int i) {
        this.dIA = i;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aCN() {
        return this.dIB;
    }
}
