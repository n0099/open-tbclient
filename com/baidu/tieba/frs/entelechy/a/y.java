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
/* loaded from: classes7.dex */
public class y extends com.baidu.tieba.frs.h<bi, com.baidu.card.a<bj>> implements com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private boolean Nj;
    private com.baidu.tieba.card.z<bj> eJh;
    private int gum;
    private com.baidu.tieba.frs.d.b gun;
    private Set<String> gvr;

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gum = 3;
        this.gun = new com.baidu.tieba.frs.d.b();
        this.Nj = false;
        this.eJh = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, y.this.mPageId, y.this.gun, y.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, y.this.mPageId, y.this.gun, y.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 3, y.this.mPageId, y.this.gun, y.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, y.this.mPageId, y.this.gun, y.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, y.this.mPageId, y.this.gun, y.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, y.this.mPageId, y.this.gun, y.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, y.this.mPageId, y.this.gun, y.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, y.this.mPageId, y.this.gun, y.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bIf().a(y.this.gun, bjVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bjVar.aAF() == 2 && bjVar.azC() != null) {
                            String azt = bjVar.azC().azt();
                            if (StringUtils.isNull(azt)) {
                                azt = bjVar.azC().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bjVar.getFid()), bjVar.aAc(), bjVar.azC().getThreadId(), "tieba.baidu.com/p/" + bjVar.azC().getThreadId(), azt);
                            String taskId = bjVar.azC().getTaskId();
                            an anVar = new an("c13329");
                            anVar.s("fid", bjVar.getFid());
                            anVar.cp("obj_id", taskId);
                            TiebaStatic.log(anVar);
                        }
                        com.baidu.tieba.frs.d.c.bIf().a(y.this.gun, bjVar, 1);
                    }
                }
            }
        };
        this.gvr = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aH(696);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFromCDN(this.Nj);
        aVar.c(oVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.Nj);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 2;
        dVar.cJD = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.aV(this.gum);
        agVar.aH(16);
        aVar.b(agVar);
        com.baidu.card.ad mT = aVar.mT();
        com.baidu.card.a aVar2 = new com.baidu.card.a(mT);
        aVar2.setPageId(this.mPageId);
        mT.a(this.eJh);
        mT.aM(this.gum);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.y.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cNb;
                    bjVar.objType = 1;
                    if (y.this.eJh != null) {
                        y.this.eJh.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), y.this.gum, false);
                    afVar.mU().b(new a.C0050a(1));
                }
            }
        });
        aVar2.mV();
        return aVar2;
    }

    private com.baidu.tieba.play.y an(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bjVar.aBe() ? "3" : "2";
        yVar.fKa = this.gun.gHn;
        yVar.OG = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.jvJ = bjVar.cPt;
        yVar.jvK = bjVar.mRecomWeight;
        yVar.mAbTag = bjVar.mRecomAbTag;
        if (bjVar.aAo() != null) {
            yVar.jvN = bjVar.aAo().video_md5;
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
        if (this.gun != null) {
            int i2 = 0;
            if (this.glJ != null) {
                i2 = this.glJ.getTopThreadSize();
            }
            biVar.cNb.cLB = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bIf().a(this.gun, biVar.cNb);
        com.baidu.tieba.frs.d.a.a(biVar.cNb, this.mPageId, this.gun, getTbPageTag());
        bh azC = biVar.cNb.azC();
        if (azC != null) {
            String taskId = azC.getTaskId();
            String azt = azC.azt();
            if (StringUtils.isNull(azt)) {
                azt = azC.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof ak) {
                ak akVar = (ak) this.mPageContext.getOrignalPage();
                if (this.gvr.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", akVar.getForumId(), akVar.getForumName(), azC.getThreadId(), "tieba.baidu.com/p/" + biVar.cNb.getTid(), azt);
                }
            }
            an anVar = new an("c13324");
            anVar.s("fid", biVar.cNb.getFid());
            anVar.cp("tid", biVar.cNb.getTid());
            anVar.cp("obj_id", taskId);
            anVar.Z("thread_type", biVar.cNb.getThreadType());
            TiebaStatic.log(anVar);
        }
        if (biVar != null) {
            biVar.cNb.aBh();
            if (biVar.cNb.aAo() != null ? true : true) {
                aVar.setVideoStatsData(an(biVar.cNb));
            }
            if (biVar.cNb != null && biVar.cNb.aBk()) {
                aVar.mU().mO().aH(32);
            }
            aVar.b((com.baidu.card.a<bj>) biVar.cNb);
            aVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.mU().a(this.eJh);
            com.baidu.tieba.frs.g.a(aVar.mU().mO(), this.glJ);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.gvr.clear();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void po(int i) {
        this.gum = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Nj = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bFt() {
        return this.gun;
    }
}
