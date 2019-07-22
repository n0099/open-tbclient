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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.frs.aj;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class u extends com.baidu.tieba.frs.h<bg, com.baidu.card.a<bg>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private boolean Yd;
    private ab<bg> dEr;
    private Set<String> fCO;
    private int fCg;
    private com.baidu.tieba.frs.d.b fCh;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fCg = 3;
        this.fCh = new com.baidu.tieba.frs.d.b();
        this.Yd = false;
        this.dEr = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brF().a(u.this.fCh, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, u.this.mPageId, u.this.fCh);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bgVar.aff() == 2 && bgVar.aed() != null) {
                            String adU = bgVar.aed().adU();
                            if (StringUtils.isNull(adU)) {
                                adU = bgVar.aed().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bgVar.getFid()), bgVar.aeC(), bgVar.aed().getThreadId(), "tieba.baidu.com/p/" + bgVar.aed().getThreadId(), adU);
                            String taskId = bgVar.aed().getTaskId();
                            an anVar = new an("c13329");
                            anVar.l("fid", bgVar.getFid());
                            anVar.bT(VideoPlayActivityConfig.OBJ_ID, taskId);
                            TiebaStatic.log(anVar);
                        }
                        com.baidu.tieba.frs.d.c.brF().a(u.this.fCh, bgVar, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, u.this.mPageId, u.this.fCh);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, u.this.mPageId, u.this.fCh);
                    }
                }
            }
        };
        this.fCO = new HashSet();
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
        dVar2.bFz = 2;
        dVar2.bFE = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bw(this.fCg);
        aaVar.bm(16);
        aVar.a(aaVar);
        aVar.qN().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.x qO = aVar.qO();
        com.baidu.card.a aVar2 = new com.baidu.card.a(qO);
        aVar2.setPageId(this.mPageId);
        qO.a(this.dEr);
        qO.bq(this.fCg);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.u.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bg bgVar = (bg) mVar;
                    bgVar.objType = 1;
                    if (u.this.dEr != null) {
                        u.this.dEr.a(zVar.getView(), bgVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), u.this.fCg, false);
                    zVar.qP().b(new a.C0038a(1));
                }
            }
        });
        aVar2.qR();
        return aVar2;
    }

    private com.baidu.tieba.play.z af(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bgVar.afy() ? "3" : "2";
        zVar.eFy = this.fCh.fOF;
        zVar.bWO = bgVar.getTid();
        zVar.mSource = bgVar.mRecomSource;
        zVar.ixy = bgVar.bLu;
        zVar.ixz = bgVar.mRecomWeight;
        zVar.ixB = bgVar.mRecomAbTag;
        if (bgVar.aeO() != null) {
            zVar.ixC = bgVar.aeO().video_md5;
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.a<bg> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.fCh != null) {
            int i2 = 0;
            if (this.fts != null) {
                i2 = this.fts.getTopThreadSize();
            }
            bgVar.bMn = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.brF().a(this.fCh, bgVar);
        com.baidu.tieba.frs.d.a.a(bgVar, this.mPageId, this.fCh);
        be aed = bgVar.aed();
        if (aed != null) {
            String taskId = aed.getTaskId();
            String adU = aed.adU();
            if (StringUtils.isNull(adU)) {
                adU = aed.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aj) {
                aj ajVar = (aj) this.mPageContext.getOrignalPage();
                if (this.fCO.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", ajVar.getForumId(), ajVar.getForumName(), aed.getThreadId(), "tieba.baidu.com/p/" + bgVar.getTid(), adU);
                }
            }
            an anVar = new an("c13324");
            anVar.l("fid", bgVar.getFid());
            anVar.bT("tid", bgVar.getTid());
            anVar.bT(VideoPlayActivityConfig.OBJ_ID, taskId);
            anVar.P("thread_type", bgVar.getThreadType());
            TiebaStatic.log(anVar);
        }
        if (bgVar != null) {
            bgVar.afB();
            if (bgVar.aeO() != null ? true : true) {
                aVar.setVideoStatsData(af(bgVar));
            }
            aVar.a(bgVar);
            aVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.qP().a(this.dEr);
            com.baidu.tieba.frs.g.a(aVar.qP().qJ(), this.fts);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.fCO.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void nC(int i) {
        this.fCg = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b boU() {
        return this.fCh;
    }
}
