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
import com.baidu.tbadk.core.data.bf;
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
public class t extends com.baidu.tieba.frs.h<bf, com.baidu.card.a<bg>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private boolean XI;
    private ab<bg> dAV;
    private Set<String> fxS;
    private int fxk;
    private com.baidu.tieba.frs.d.b fxl;

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fxk = 3;
        this.fxl = new com.baidu.tieba.frs.d.b();
        this.XI = false;
        this.dAV = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpE().a(t.this.fxl, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, t.this.mPageId, t.this.fxl);
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
                        com.baidu.tieba.frs.d.c.bpE().a(t.this.fxl, bgVar, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, t.this.mPageId, t.this.fxl);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, t.this.mPageId, t.this.fxl);
                    }
                }
            }
        };
        this.fxS = new HashSet();
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
        kVar.setFromCDN(this.XI);
        aVar.b(kVar);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.XI);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bEz = 2;
        dVar2.bEE = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bw(this.fxk);
        aaVar.bm(16);
        aVar.a(aaVar);
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.x qr = aVar.qr();
        com.baidu.card.a aVar2 = new com.baidu.card.a(qr);
        aVar2.setPageId(this.mPageId);
        qr.a(this.dAV);
        qr.bq(this.fxk);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.t.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (t.this.dAV != null) {
                        t.this.dAV.a(zVar.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), t.this.fxk, false);
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
        zVar.eAC = this.fxl.fJH;
        zVar.bVM = bgVar.getTid();
        zVar.mSource = bgVar.mRecomSource;
        zVar.iri = bgVar.bKu;
        zVar.irj = bgVar.mRecomWeight;
        zVar.irl = bgVar.mRecomAbTag;
        if (bgVar.adM() != null) {
            zVar.irm = bgVar.adM().video_md5;
        }
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bf bfVar, com.baidu.card.a<bg> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.fxl != null) {
            int i2 = 0;
            if (this.fot != null) {
                i2 = this.fot.getTopThreadSize();
            }
            bfVar.threadData.bLn = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bpE().a(this.fxl, bfVar.threadData);
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, this.fxl);
        be adb = bfVar.threadData.adb();
        if (adb != null) {
            String taskId = adb.getTaskId();
            String acS = adb.acS();
            if (StringUtils.isNull(acS)) {
                acS = adb.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aj) {
                aj ajVar = (aj) this.mPageContext.getOrignalPage();
                if (this.fxS.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", ajVar.getForumId(), ajVar.getForumName(), adb.getThreadId(), "tieba.baidu.com/p/" + bfVar.threadData.getTid(), acS);
                }
            }
            am amVar = new am("c13324");
            amVar.l("fid", bfVar.threadData.getFid());
            amVar.bT("tid", bfVar.threadData.getTid());
            amVar.bT(VideoPlayActivityConfig.OBJ_ID, taskId);
            amVar.P("thread_type", bfVar.threadData.getThreadType());
            TiebaStatic.log(amVar);
        }
        if (bfVar != null) {
            bfVar.threadData.aez();
            if (bfVar.threadData.adM() != null ? true : true) {
                aVar.setVideoStatsData(af(bfVar.threadData));
            }
            aVar.a(bfVar.threadData);
            aVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.qs().a(this.dAV);
            com.baidu.tieba.frs.g.a(aVar.qs().qm(), this.fot);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.fxS.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void nt(int i) {
        this.fxk = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.XI = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmT() {
        return this.fxl;
    }
}
