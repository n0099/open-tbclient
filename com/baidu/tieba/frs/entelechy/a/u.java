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
    private boolean HY;
    private ab<bh> dTh;
    private int fDY;
    private com.baidu.tieba.frs.d.b fDZ;
    private Set<String> fEG;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fDY = 3;
        this.fDZ = new com.baidu.tieba.frs.d.b();
        this.HY = false;
        this.dTh = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpJ().a(u.this.fDZ, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, u.this.mPageId, u.this.fDZ);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bhVar.ajo() == 2 && bhVar.aim() != null) {
                            String aid = bhVar.aim().aid();
                            if (StringUtils.isNull(aid)) {
                                aid = bhVar.aim().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bhVar.getFid()), bhVar.aiL(), bhVar.aim().getThreadId(), "tieba.baidu.com/p/" + bhVar.aim().getThreadId(), aid);
                            String taskId = bhVar.aim().getTaskId();
                            an anVar = new an("c13329");
                            anVar.p("fid", bhVar.getFid());
                            anVar.bS("obj_id", taskId);
                            TiebaStatic.log(anVar);
                        }
                        com.baidu.tieba.frs.d.c.bpJ().a(u.this.fDZ, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, u.this.mPageId, u.this.fDZ);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, u.this.mPageId, u.this.fDZ);
                    }
                }
            }
        };
        this.fEG = new HashSet();
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
        kVar.setFromCDN(this.HY);
        aVar.b(kVar);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.HY);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bXQ = 2;
        dVar2.bXV = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.aL(this.fDY);
        aaVar.aB(16);
        aVar.a(aaVar);
        com.baidu.card.x lU = aVar.lU();
        com.baidu.card.a aVar2 = new com.baidu.card.a(lU);
        aVar2.setPageId(this.mPageId);
        lU.b(this.dTh);
        lU.aF(this.fDY);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.u.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bh) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bh bhVar = (bh) mVar;
                    bhVar.objType = 1;
                    if (u.this.dTh != null) {
                        u.this.dTh.a(zVar.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), u.this.fDY, false);
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
        zVar.mLocate = bhVar.ajH() ? "3" : "2";
        zVar.ePT = this.fDZ.fQD;
        zVar.cmS = bhVar.getTid();
        zVar.mSource = bhVar.mRecomSource;
        zVar.iza = bhVar.cdG;
        zVar.izb = bhVar.mRecomWeight;
        zVar.izd = bhVar.mRecomAbTag;
        if (bhVar.aiX() != null) {
            zVar.ize = bhVar.aiX().video_md5;
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
        if (this.fDZ != null) {
            int i2 = 0;
            if (this.fuR != null) {
                i2 = this.fuR.getTopThreadSize();
            }
            bhVar.cez = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bpJ().a(this.fDZ, bhVar);
        com.baidu.tieba.frs.d.a.a(bhVar, this.mPageId, this.fDZ);
        bf aim = bhVar.aim();
        if (aim != null) {
            String taskId = aim.getTaskId();
            String aid = aim.aid();
            if (StringUtils.isNull(aid)) {
                aid = aim.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aj) {
                aj ajVar = (aj) this.mPageContext.getOrignalPage();
                if (this.fEG.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", ajVar.getForumId(), ajVar.getForumName(), aim.getThreadId(), "tieba.baidu.com/p/" + bhVar.getTid(), aid);
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
            bhVar.ajK();
            if (bhVar.aiX() != null ? true : true) {
                aVar.setVideoStatsData(af(bhVar));
            }
            aVar.a(bhVar);
            aVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.lV().b(this.dTh);
            com.baidu.tieba.frs.g.a(aVar.lV().lP(), this.fuR);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.fEG.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void mX(int i) {
        this.fDY = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.HY = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmX() {
        return this.fDZ;
    }
}
