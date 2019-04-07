package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aa;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aj;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class t extends com.baidu.tieba.frs.h<bg, com.baidu.card.a<bg>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private boolean ZQ;
    private ab<bg> dqo;
    private int fgP;
    private com.baidu.tieba.frs.d.b fgQ;
    private Set<String> fhv;

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fgP = 3;
        this.fgQ = new com.baidu.tieba.frs.d.b();
        this.ZQ = false;
        this.dqo = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        com.baidu.tieba.frs.d.c.bij().a(t.this.fgQ, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, t.this.mPageId, t.this.fgQ);
                    } else if (view.getId() == d.g.thread_card_root) {
                        if (bgVar.Zw() == 2 && bgVar.Yu() != null) {
                            String Yl = bgVar.Yu().Yl();
                            if (StringUtils.isNull(Yl)) {
                                Yl = bgVar.Yu().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.b("frs", "CLICK", String.valueOf(bgVar.getFid()), bgVar.YT(), bgVar.Yu().getThreadId(), "tieba.baidu.com/p/" + bgVar.Yu().getThreadId(), Yl);
                            String taskId = bgVar.Yu().getTaskId();
                            am amVar = new am("c13329");
                            amVar.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
                            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, taskId);
                            TiebaStatic.log(amVar);
                        }
                        com.baidu.tieba.frs.d.c.bij().a(t.this.fgQ, bgVar, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, t.this.mPageId, t.this.fgQ);
                    } else if (view.getId() == d.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, t.this.mPageId, t.this.fgQ);
                    }
                }
            }
        };
        this.fhv = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.card.a onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bt(696);
        dVar.setPageUniqueId(this.mPageId);
        aVar.c(dVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.ZQ);
        aVar.b(kVar);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.ZQ);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bxm = 2;
        dVar2.bxr = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bz(this.fgP);
        aaVar.bt(16);
        aVar.a(aaVar);
        aVar.rv().setBackgroundResource(d.f.addresslist_item_bg);
        com.baidu.card.x rw = aVar.rw();
        com.baidu.card.a aVar2 = new com.baidu.card.a(rw);
        aVar2.setPageId(this.mPageId);
        rw.a(this.dqo);
        rw.bx(this.fgP);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.t.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bg bgVar = (bg) mVar;
                    bgVar.objType = 1;
                    if (t.this.dqo != null) {
                        t.this.dqo.a(zVar.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), t.this.fgP, false);
                    zVar.rx().b(new a.C0039a(1));
                }
            }
        });
        aVar2.rz();
        return aVar2;
    }

    private com.baidu.tieba.play.z af(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bgVar.ZP() ? "3" : "2";
        zVar.ekM = this.fgQ.fsO;
        zVar.ctw = bgVar.getTid();
        zVar.mSource = bgVar.mRecomSource;
        zVar.hYx = bgVar.bDc;
        zVar.hYy = bgVar.mRecomWeight;
        zVar.hYA = bgVar.mRecomAbTag;
        if (bgVar.Zf() != null) {
            zVar.hYB = bgVar.Zf().video_md5;
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
        if (this.fgQ != null) {
            int i2 = 0;
            if (this.eYh != null) {
                i2 = this.eYh.getTopThreadSize();
            }
            bgVar.bDU = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bij().a(this.fgQ, bgVar);
        com.baidu.tieba.frs.d.a.a(bgVar, this.mPageId, this.fgQ);
        be Yu = bgVar.Yu();
        if (Yu != null) {
            String taskId = Yu.getTaskId();
            String Yl = Yu.Yl();
            if (StringUtils.isNull(Yl)) {
                Yl = Yu.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aj) {
                aj ajVar = (aj) this.mPageContext.getOrignalPage();
                if (this.fhv.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.b("frs", "VIEW_TRUE", ajVar.getForumId(), ajVar.getForumName(), Yu.getThreadId(), "tieba.baidu.com/p/" + bgVar.getTid(), Yl);
                }
            }
            am amVar = new am("c13324");
            amVar.k(ImageViewerConfig.FORUM_ID, bgVar.getFid());
            amVar.bJ("tid", bgVar.getTid());
            amVar.bJ(VideoPlayActivityConfig.OBJ_ID, taskId);
            amVar.T("thread_type", bgVar.getThreadType());
            TiebaStatic.log(amVar);
        }
        if (bgVar != null) {
            bgVar.ZS();
            if (bgVar.Zf() != null ? true : true) {
                aVar.setVideoStatsData(af(bgVar));
            }
            aVar.a(bgVar);
            aVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.rx().a(this.dqo);
            com.baidu.tieba.frs.g.a(aVar.rx().rr(), this.eYh);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.fhv.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void mC(int i) {
        this.fgP = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.ZQ = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bfx() {
        return this.fgQ;
    }
}
