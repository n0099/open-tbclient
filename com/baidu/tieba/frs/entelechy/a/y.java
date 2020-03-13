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
import com.baidu.tbadk.core.data.bi;
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
public class y extends com.baidu.tieba.frs.h<bi, com.baidu.card.a<bj>> implements com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private boolean NJ;
    private com.baidu.tieba.card.z<bj> eNp;
    private int gwB;
    private com.baidu.tieba.frs.d.b gwC;
    private Set<String> gxG;

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gwB = 3;
        this.gwC = new com.baidu.tieba.frs.d.b();
        this.NJ = false;
        this.eNp = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, y.this.mPageId, y.this.gwC, y.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, y.this.mPageId, y.this.gwC, y.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 3, y.this.mPageId, y.this.gwC, y.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, y.this.mPageId, y.this.gwC, y.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, y.this.mPageId, y.this.gwC, y.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, y.this.mPageId, y.this.gwC, y.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, y.this.mPageId, y.this.gwC, y.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, y.this.mPageId, y.this.gwC, y.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJK().a(y.this.gwC, bjVar, 2);
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
                        com.baidu.tieba.frs.d.c.bJK().a(y.this.gwC, bjVar, 1);
                    }
                }
            }
        };
        this.gxG = new HashSet();
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
        dVar.cNC = 2;
        dVar.cNI = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.aZ(this.gwB);
        agVar.aK(16);
        aVar.b(agVar);
        com.baidu.card.ad nj = aVar.nj();
        com.baidu.card.a aVar2 = new com.baidu.card.a(nj);
        aVar2.setPageId(this.mPageId);
        nj.a(this.eNp);
        nj.aQ(this.gwB);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.y.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cRg;
                    bjVar.objType = 1;
                    if (y.this.eNp != null) {
                        y.this.eNp.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), y.this.gwB, false);
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
        yVar.emo = this.gwC.gJA;
        yVar.Pj = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.jwS = bjVar.cTx;
        yVar.jwT = bjVar.mRecomWeight;
        yVar.mAbTag = bjVar.mRecomAbTag;
        if (bjVar.aCF() != null) {
            yVar.jwW = bjVar.aCF().video_md5;
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.card.a<bj> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.gwC != null) {
            int i2 = 0;
            if (this.gnZ != null) {
                i2 = this.gnZ.getTopThreadSize();
            }
            biVar.cRg.cPG = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bJK().a(this.gwC, biVar.cRg);
        com.baidu.tieba.frs.d.a.a(biVar.cRg, this.mPageId, this.gwC, getTbPageTag());
        bh aBU = biVar.cRg.aBU();
        if (aBU != null) {
            String taskId = aBU.getTaskId();
            String aBL = aBU.aBL();
            if (StringUtils.isNull(aBL)) {
                aBL = aBU.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof ak) {
                ak akVar = (ak) this.mPageContext.getOrignalPage();
                if (this.gxG.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", akVar.getForumId(), akVar.getForumName(), aBU.getThreadId(), "tieba.baidu.com/p/" + biVar.cRg.getTid(), aBL);
                }
            }
            an anVar = new an("c13324");
            anVar.s("fid", biVar.cRg.getFid());
            anVar.cy("tid", biVar.cRg.getTid());
            anVar.cy("obj_id", taskId);
            anVar.X("thread_type", biVar.cRg.getThreadType());
            TiebaStatic.log(anVar);
        }
        if (biVar != null) {
            biVar.cRg.aDw();
            if (biVar.cRg.aCF() != null ? true : true) {
                aVar.setVideoStatsData(ap(biVar.cRg));
            }
            if (biVar.cRg != null && biVar.cRg.aDz()) {
                aVar.nk().ne().aK(32);
            }
            aVar.b((com.baidu.card.a<bj>) biVar.cRg);
            aVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.nk().a(this.eNp);
            com.baidu.tieba.frs.g.a(aVar.nk().ne(), this.gnZ);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.gxG.clear();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
        this.gwB = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bGY() {
        return this.gwC;
    }
}
