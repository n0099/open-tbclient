package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.frs.aj;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class u extends com.baidu.tieba.frs.h<bh, com.baidu.card.a<bh>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private boolean Hx;
    private ab<bh> dSq;
    private Set<String> fDP;
    private int fDh;
    private com.baidu.tieba.frs.d.b fDi;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fDh = 3;
        this.fDi = new com.baidu.tieba.frs.d.b();
        this.Hx = false;
        this.dSq = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpH().a(u.this.fDi, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, u.this.mPageId, u.this.fDi);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bhVar.ajm() == 2 && bhVar.aik() != null) {
                            String aib = bhVar.aik().aib();
                            if (StringUtils.isNull(aib)) {
                                aib = bhVar.aik().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bhVar.getFid()), bhVar.aiJ(), bhVar.aik().getThreadId(), "tieba.baidu.com/p/" + bhVar.aik().getThreadId(), aib);
                            String taskId = bhVar.aik().getTaskId();
                            an anVar = new an("c13329");
                            anVar.p("fid", bhVar.getFid());
                            anVar.bS("obj_id", taskId);
                            TiebaStatic.log(anVar);
                        }
                        com.baidu.tieba.frs.d.c.bpH().a(u.this.fDi, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, u.this.mPageId, u.this.fDi);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, u.this.mPageId, u.this.fDi);
                    }
                }
            }
        };
        this.fDP = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.aB(696);
        dVar.setPageUniqueId(this.mPageId);
        aVar.c(dVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.Hx);
        aVar.b(kVar);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Hx);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bWZ = 2;
        dVar2.bXe = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.aL(this.fDh);
        aaVar.aB(16);
        aVar.a(aaVar);
        com.baidu.card.x lU = aVar.lU();
        com.baidu.card.a aVar2 = new com.baidu.card.a(lU);
        aVar2.setPageId(this.mPageId);
        lU.b(this.dSq);
        lU.aF(this.fDh);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.u.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bh) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bh bhVar = (bh) mVar;
                    bhVar.objType = 1;
                    if (u.this.dSq != null) {
                        u.this.dSq.a(zVar.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), u.this.fDh, false);
                    zVar.lV().b(new a.C0044a(1));
                }
            }
        });
        aVar2.lX();
        return aVar2;
    }

    private com.baidu.tieba.play.z af(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bhVar.ajF() ? "3" : "2";
        zVar.ePc = this.fDi.fPM;
        zVar.cma = bhVar.getTid();
        zVar.mSource = bhVar.mRecomSource;
        zVar.iyj = bhVar.ccP;
        zVar.iyk = bhVar.mRecomWeight;
        zVar.iym = bhVar.mRecomAbTag;
        if (bhVar.aiV() != null) {
            zVar.iyn = bhVar.aiV().video_md5;
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.card.a<bh> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.fDi != null) {
            int i2 = 0;
            if (this.fua != null) {
                i2 = this.fua.getTopThreadSize();
            }
            bhVar.cdI = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bpH().a(this.fDi, bhVar);
        com.baidu.tieba.frs.d.a.a(bhVar, this.mPageId, this.fDi);
        bf aik = bhVar.aik();
        if (aik != null) {
            String taskId = aik.getTaskId();
            String aib = aik.aib();
            if (StringUtils.isNull(aib)) {
                aib = aik.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aj) {
                aj ajVar = (aj) this.mPageContext.getOrignalPage();
                if (this.fDP.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", ajVar.getForumId(), ajVar.getForumName(), aik.getThreadId(), "tieba.baidu.com/p/" + bhVar.getTid(), aib);
                }
            }
            an anVar = new an("c13324");
            anVar.p("fid", bhVar.getFid());
            anVar.bS("tid", bhVar.getTid());
            anVar.bS("obj_id", taskId);
            anVar.O("thread_type", bhVar.getThreadType());
            TiebaStatic.log(anVar);
        }
        if (bhVar != null) {
            bhVar.ajI();
            if (bhVar.aiV() != null ? true : true) {
                aVar.setVideoStatsData(af(bhVar));
            }
            aVar.a(bhVar);
            aVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.lV().b(this.dSq);
            com.baidu.tieba.frs.g.a(aVar.lV().lP(), this.fua);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.fDP.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void mW(int i) {
        this.fDh = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Hx = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmV() {
        return this.fDi;
    }
}
