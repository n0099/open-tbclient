package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.ag;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ak;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class z extends com.baidu.tieba.frs.h<bj, com.baidu.card.a<bj>> implements com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private boolean NJ;
    private com.baidu.tieba.card.z<bj> eNc;
    private int gwp;
    private com.baidu.tieba.frs.d.b gwq;
    private Set<String> gxu;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gwp = 3;
        this.gwq = new com.baidu.tieba.frs.d.b();
        this.NJ = false;
        this.eNc = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, z.this.mPageId, z.this.gwq, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, z.this.mPageId, z.this.gwq, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 3, z.this.mPageId, z.this.gwq, z.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, z.this.mPageId, z.this.gwq, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, z.this.mPageId, z.this.gwq, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, z.this.mPageId, z.this.gwq, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, z.this.mPageId, z.this.gwq, z.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, z.this.mPageId, z.this.gwq, z.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJJ().a(z.this.gwq, bjVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bjVar.aCW() == 2 && bjVar.aBU() != null) {
                            String aBL = bjVar.aBU().aBL();
                            if (StringUtils.isNull(aBL)) {
                                aBL = bjVar.aBU().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bjVar.getFid()), bjVar.aCt(), bjVar.aBU().getThreadId(), "tieba.baidu.com/p/" + bjVar.aBU().getThreadId(), aBL);
                            String taskId = bjVar.aBU().getTaskId();
                            an anVar = new an("c13329");
                            anVar.s("fid", bjVar.getFid());
                            anVar.cy("obj_id", taskId);
                            TiebaStatic.log(anVar);
                        }
                        com.baidu.tieba.frs.d.c.bJJ().a(z.this.gwq, bjVar, 1);
                    }
                }
            }
        };
        this.gxu = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aK(696);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFromCDN(this.NJ);
        aVar.c(oVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.NJ);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNB = 2;
        dVar.cNH = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.aZ(this.gwp);
        agVar.aK(16);
        aVar.b(agVar);
        com.baidu.card.ad nj = aVar.nj();
        com.baidu.card.a aVar2 = new com.baidu.card.a(nj);
        aVar2.setPageId(this.mPageId);
        nj.a(this.eNc);
        nj.aQ(this.gwp);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.z.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bj) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = (bj) mVar;
                    bjVar.objType = 1;
                    if (z.this.eNc != null) {
                        z.this.eNc.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), z.this.gwp, false);
                    afVar.nk().b(new a.C0052a(1));
                }
            }
        });
        aVar2.nl();
        return aVar2;
    }

    private com.baidu.tieba.play.y ap(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bjVar.aDt() ? "3" : "2";
        yVar.emb = this.gwq.gJo;
        yVar.Pj = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.jwG = bjVar.cTw;
        yVar.jwH = bjVar.mRecomWeight;
        yVar.mAbTag = bjVar.mRecomAbTag;
        if (bjVar.aCF() != null) {
            yVar.jwK = bjVar.aCF().video_md5;
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.card.a<bj> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.gwq != null) {
            int i2 = 0;
            if (this.gnM != null) {
                i2 = this.gnM.getTopThreadSize();
            }
            bjVar.cPF = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bJJ().a(this.gwq, bjVar);
        com.baidu.tieba.frs.d.a.a(bjVar, this.mPageId, this.gwq, getTbPageTag());
        bh aBU = bjVar.aBU();
        if (aBU != null) {
            String taskId = aBU.getTaskId();
            String aBL = aBU.aBL();
            if (StringUtils.isNull(aBL)) {
                aBL = aBU.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof ak) {
                ak akVar = (ak) this.mPageContext.getOrignalPage();
                if (this.gxu.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", akVar.getForumId(), akVar.getForumName(), aBU.getThreadId(), "tieba.baidu.com/p/" + bjVar.getTid(), aBL);
                }
            }
            an anVar = new an("c13324");
            anVar.s("fid", bjVar.getFid());
            anVar.cy("tid", bjVar.getTid());
            anVar.cy("obj_id", taskId);
            anVar.X("thread_type", bjVar.getThreadType());
            TiebaStatic.log(anVar);
        }
        if (bjVar != null) {
            bjVar.aDw();
            if (bjVar.aCF() != null ? true : true) {
                aVar.setVideoStatsData(ap(bjVar));
            }
            if (bjVar.aDz()) {
                aVar.nk().ne().aK(32);
            }
            aVar.b((com.baidu.card.a<bj>) bjVar);
            aVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.nk().a(this.eNc);
            com.baidu.tieba.frs.g.a(aVar.nk().ne(), this.gnM);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.gxu.clear();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
        this.gwp = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bGX() {
        return this.gwq;
    }
}
