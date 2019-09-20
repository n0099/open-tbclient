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
import com.baidu.tbadk.core.data.bg;
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
public class t extends com.baidu.tieba.frs.h<bg, com.baidu.card.a<bh>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private boolean Yd;
    private ab<bh> dGj;
    private int fEH;
    private com.baidu.tieba.frs.d.b fEI;
    private Set<String> fFp;

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fEH = 3;
        this.fEI = new com.baidu.tieba.frs.d.b();
        this.Yd = false;
        this.dGj = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bsF().a(t.this.fEI, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, t.this.mPageId, t.this.fEI);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bhVar.afk() == 2 && bhVar.aei() != null) {
                            String adZ = bhVar.aei().adZ();
                            if (StringUtils.isNull(adZ)) {
                                adZ = bhVar.aei().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bhVar.getFid()), bhVar.aeH(), bhVar.aei().getThreadId(), "tieba.baidu.com/p/" + bhVar.aei().getThreadId(), adZ);
                            String taskId = bhVar.aei().getTaskId();
                            an anVar = new an("c13329");
                            anVar.n("fid", bhVar.getFid());
                            anVar.bT(VideoPlayActivityConfig.OBJ_ID, taskId);
                            TiebaStatic.log(anVar);
                        }
                        com.baidu.tieba.frs.d.c.bsF().a(t.this.fEI, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, t.this.mPageId, t.this.fEI);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, t.this.mPageId, t.this.fEI);
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 3, t.this.mPageId, t.this.fEI);
                    }
                }
            }
        };
        this.fFp = new HashSet();
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
        dVar2.bFY = 2;
        dVar2.bGd = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bw(this.fEH);
        aaVar.bm(16);
        aVar.a(aaVar);
        com.baidu.card.x qP = aVar.qP();
        com.baidu.card.a aVar2 = new com.baidu.card.a(qP);
        aVar2.setPageId(this.mPageId);
        qP.a(this.dGj);
        qP.bq(this.fEH);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.t.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).threadData;
                    bhVar.objType = 1;
                    if (t.this.dGj != null) {
                        t.this.dGj.a(zVar.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), t.this.fEH, false);
                    zVar.qQ().b(new a.C0038a(1));
                }
            }
        });
        aVar2.qS();
        return aVar2;
    }

    private com.baidu.tieba.play.z ah(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bhVar.afD() ? "3" : "2";
        zVar.eHo = this.fEI.fRk;
        zVar.bXN = bhVar.getTid();
        zVar.mSource = bhVar.mRecomSource;
        zVar.iAD = bhVar.bLX;
        zVar.iAE = bhVar.mRecomWeight;
        zVar.iAG = bhVar.mRecomAbTag;
        if (bhVar.aeT() != null) {
            zVar.iAH = bhVar.aeT().video_md5;
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.a<bh> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.fEI != null) {
            int i2 = 0;
            if (this.fvE != null) {
                i2 = this.fvE.getTopThreadSize();
            }
            bgVar.threadData.bMQ = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bsF().a(this.fEI, bgVar.threadData);
        com.baidu.tieba.frs.d.a.a(bgVar.threadData, this.mPageId, this.fEI);
        bf aei = bgVar.threadData.aei();
        if (aei != null) {
            String taskId = aei.getTaskId();
            String adZ = aei.adZ();
            if (StringUtils.isNull(adZ)) {
                adZ = aei.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aj) {
                aj ajVar = (aj) this.mPageContext.getOrignalPage();
                if (this.fFp.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", ajVar.getForumId(), ajVar.getForumName(), aei.getThreadId(), "tieba.baidu.com/p/" + bgVar.threadData.getTid(), adZ);
                }
            }
            an anVar = new an("c13324");
            anVar.n("fid", bgVar.threadData.getFid());
            anVar.bT("tid", bgVar.threadData.getTid());
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, taskId);
            anVar.P("thread_type", bgVar.threadData.getThreadType());
            TiebaStatic.log(anVar);
        }
        if (bgVar != null) {
            bgVar.threadData.afG();
            if (bgVar.threadData.aeT() != null ? true : true) {
                aVar.setVideoStatsData(ah(bgVar.threadData));
            }
            aVar.a(bgVar.threadData);
            aVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.qQ().a(this.dGj);
            com.baidu.tieba.frs.g.a(aVar.qQ().qK(), this.fvE);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.fFp.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void nH(int i) {
        this.fEH = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bpS() {
        return this.fEI;
    }
}
