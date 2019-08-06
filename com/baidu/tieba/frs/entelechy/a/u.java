package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.frs.aj;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class u extends com.baidu.tieba.frs.h<bh, com.baidu.card.a<bh>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private boolean Yd;
    private ab<bh> dEy;
    private int fCU;
    private com.baidu.tieba.frs.d.b fCV;
    private Set<String> fDC;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fCU = 3;
        this.fCV = new com.baidu.tieba.frs.d.b();
        this.Yd = false;
        this.dEy = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brS().a(u.this.fCV, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, u.this.mPageId, u.this.fCV);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bhVar.afg() == 2 && bhVar.aee() != null) {
                            String adV = bhVar.aee().adV();
                            if (StringUtils.isNull(adV)) {
                                adV = bhVar.aee().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bhVar.getFid()), bhVar.aeD(), bhVar.aee().getThreadId(), "tieba.baidu.com/p/" + bhVar.aee().getThreadId(), adV);
                            String taskId = bhVar.aee().getTaskId();
                            an anVar = new an("c13329");
                            anVar.l("fid", bhVar.getFid());
                            anVar.bT(VideoPlayActivityConfig.OBJ_ID, taskId);
                            TiebaStatic.log(anVar);
                        }
                        com.baidu.tieba.frs.d.c.brS().a(u.this.fCV, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, u.this.mPageId, u.this.fCV);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, u.this.mPageId, u.this.fCV);
                    }
                }
            }
        };
        this.fDC = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public com.baidu.card.a onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bm(696);
        dVar.setPageUniqueId(this.mPageId);
        aVar.c(dVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.Yd);
        aVar.b(kVar);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Yd);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bFA = 2;
        dVar2.bFF = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bw(this.fCU);
        aaVar.bm(16);
        aVar.a(aaVar);
        aVar.qN().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.x qO = aVar.qO();
        com.baidu.card.a aVar2 = new com.baidu.card.a(qO);
        aVar2.setPageId(this.mPageId);
        qO.a(this.dEy);
        qO.bq(this.fCU);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.u.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bh) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bh bhVar = (bh) mVar;
                    bhVar.objType = 1;
                    if (u.this.dEy != null) {
                        u.this.dEy.a(zVar.getView(), bhVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), u.this.fCU, false);
                    zVar.qP().b(new a.C0038a(1));
                }
            }
        });
        aVar2.qR();
        return aVar2;
    }

    private com.baidu.tieba.play.z ag(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bhVar.afz() ? "3" : "2";
        zVar.eFF = this.fCV.fPt;
        zVar.bWU = bhVar.getTid();
        zVar.mSource = bhVar.mRecomSource;
        zVar.iyB = bhVar.bLz;
        zVar.iyC = bhVar.mRecomWeight;
        zVar.iyE = bhVar.mRecomAbTag;
        if (bhVar.aeP() != null) {
            zVar.iyF = bhVar.aeP().video_md5;
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.card.a<bh> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.fCV != null) {
            int i2 = 0;
            if (this.ftR != null) {
                i2 = this.ftR.getTopThreadSize();
            }
            bhVar.bMs = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.brS().a(this.fCV, bhVar);
        com.baidu.tieba.frs.d.a.a(bhVar, this.mPageId, this.fCV);
        bf aee = bhVar.aee();
        if (aee != null) {
            String taskId = aee.getTaskId();
            String adV = aee.adV();
            if (StringUtils.isNull(adV)) {
                adV = aee.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aj) {
                aj ajVar = (aj) this.mPageContext.getOrignalPage();
                if (this.fDC.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", ajVar.getForumId(), ajVar.getForumName(), aee.getThreadId(), "tieba.baidu.com/p/" + bhVar.getTid(), adV);
                }
            }
            an anVar = new an("c13324");
            anVar.l("fid", bhVar.getFid());
            anVar.bT("tid", bhVar.getTid());
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, taskId);
            anVar.P("thread_type", bhVar.getThreadType());
            TiebaStatic.log(anVar);
        }
        if (bhVar != null) {
            bhVar.afC();
            if (bhVar.aeP() != null ? true : true) {
                aVar.setVideoStatsData(ag(bhVar));
            }
            aVar.a(bhVar);
            aVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.qP().a(this.dEy);
            com.baidu.tieba.frs.g.a(aVar.qP().qJ(), this.ftR);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.fDC.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void nD(int i) {
        this.fCU = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bph() {
        return this.fCV;
    }
}
