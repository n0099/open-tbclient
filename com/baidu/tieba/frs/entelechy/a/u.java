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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.frs.aj;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class u extends com.baidu.tieba.frs.h<bg, com.baidu.card.a<bg>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private boolean XJ;
    private ab<bg> dAU;
    private Set<String> fxR;
    private int fxj;
    private com.baidu.tieba.frs.d.b fxk;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fxj = 3;
        this.fxk = new com.baidu.tieba.frs.d.b();
        this.XJ = false;
        this.dAU = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpz().a(u.this.fxk, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, u.this.mPageId, u.this.fxk);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bgVar.aed() == 2 && bgVar.adb() != null) {
                            String acS = bgVar.adb().acS();
                            if (StringUtils.isNull(acS)) {
                                acS = bgVar.adb().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bgVar.getFid()), bgVar.adA(), bgVar.adb().getThreadId(), "tieba.baidu.com/p/" + bgVar.adb().getThreadId(), acS);
                            String taskId = bgVar.adb().getTaskId();
                            am amVar = new am("c13329");
                            amVar.l("fid", bgVar.getFid());
                            amVar.bT(VideoPlayActivityConfig.OBJ_ID, taskId);
                            TiebaStatic.log(amVar);
                        }
                        com.baidu.tieba.frs.d.c.bpz().a(u.this.fxk, bgVar, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, u.this.mPageId, u.this.fxk);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, u.this.mPageId, u.this.fxk);
                    }
                }
            }
        };
        this.fxR = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.card.a onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bm(696);
        dVar.setPageUniqueId(this.mPageId);
        aVar.c(dVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.XJ);
        aVar.b(kVar);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.XJ);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bEy = 2;
        dVar2.bED = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bw(this.fxj);
        aaVar.bm(16);
        aVar.a(aaVar);
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.x qr = aVar.qr();
        com.baidu.card.a aVar2 = new com.baidu.card.a(qr);
        aVar2.setPageId(this.mPageId);
        qr.a(this.dAU);
        qr.bq(this.fxj);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.u.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bg bgVar = (bg) mVar;
                    bgVar.objType = 1;
                    if (u.this.dAU != null) {
                        u.this.dAU.a(zVar.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), u.this.fxj, false);
                    zVar.qs().b(new a.C0038a(1));
                }
            }
        });
        aVar2.qu();
        return aVar2;
    }

    private com.baidu.tieba.play.z af(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bgVar.aew() ? "3" : "2";
        zVar.eAB = this.fxk.fJE;
        zVar.bVL = bgVar.getTid();
        zVar.mSource = bgVar.mRecomSource;
        zVar.ire = bgVar.bKt;
        zVar.irf = bgVar.mRecomWeight;
        zVar.irh = bgVar.mRecomAbTag;
        if (bgVar.adM() != null) {
            zVar.iri = bgVar.adM().video_md5;
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
        if (this.fxk != null) {
            int i2 = 0;
            if (this.fos != null) {
                i2 = this.fos.getTopThreadSize();
            }
            bgVar.bLm = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bpz().a(this.fxk, bgVar);
        com.baidu.tieba.frs.d.a.a(bgVar, this.mPageId, this.fxk);
        be adb = bgVar.adb();
        if (adb != null) {
            String taskId = adb.getTaskId();
            String acS = adb.acS();
            if (StringUtils.isNull(acS)) {
                acS = adb.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aj) {
                aj ajVar = (aj) this.mPageContext.getOrignalPage();
                if (this.fxR.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", ajVar.getForumId(), ajVar.getForumName(), adb.getThreadId(), "tieba.baidu.com/p/" + bgVar.getTid(), acS);
                }
            }
            am amVar = new am("c13324");
            amVar.l("fid", bgVar.getFid());
            amVar.bT("tid", bgVar.getTid());
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, taskId);
            amVar.P("thread_type", bgVar.getThreadType());
            TiebaStatic.log(amVar);
        }
        if (bgVar != null) {
            bgVar.aez();
            if (bgVar.adM() != null ? true : true) {
                aVar.setVideoStatsData(af(bgVar));
            }
            aVar.a(bgVar);
            aVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.qs().a(this.dAU);
            com.baidu.tieba.frs.g.a(aVar.qs().qm(), this.fos);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.fxR.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void nt(int i) {
        this.fxj = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.XJ = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmQ() {
        return this.fxk;
    }
}
