package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
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
import com.baidu.tieba.frs.ap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class aa extends com.baidu.tieba.frs.h<bi, com.baidu.card.a<bj>> implements com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private boolean agt;
    private com.baidu.tieba.card.z<bj> fsd;
    private int hgF;
    private com.baidu.tieba.frs.d.b hgG;
    private Set<String> hhM;

    public aa(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hgF = 3;
        this.hgG = new com.baidu.tieba.frs.d.b();
        this.agt = false;
        this.fsd = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, aa.this.mPageId, aa.this.hgG, aa.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, aa.this.mPageId, aa.this.hgG, aa.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 3, aa.this.mPageId, aa.this.hgG, aa.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, aa.this.mPageId, aa.this.hgG, aa.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, aa.this.mPageId, aa.this.hgG, aa.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, aa.this.mPageId, aa.this.hgG, aa.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, aa.this.mPageId, aa.this.hgG, aa.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, aa.this.mPageId, aa.this.hgG, aa.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bUu().a(aa.this.hgG, bjVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bjVar.aLm() == 2 && bjVar.aKk() != null) {
                            String aKb = bjVar.aKk().aKb();
                            if (StringUtils.isNull(aKb)) {
                                aKb = bjVar.aKk().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bjVar.getFid()), bjVar.aKJ(), bjVar.aKk().getThreadId(), "tieba.baidu.com/p/" + bjVar.aKk().getThreadId(), aKb);
                            String taskId = bjVar.aKk().getTaskId();
                            an anVar = new an("c13329");
                            anVar.t("fid", bjVar.getFid());
                            anVar.cI("obj_id", taskId);
                            TiebaStatic.log(anVar);
                        }
                        com.baidu.tieba.frs.d.c.bUu().a(aa.this.hgG, bjVar, 1);
                    }
                }
            }
        };
        this.hhM = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aW(696);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFromCDN(this.agt);
        aVar.c(oVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.agt);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        com.baidu.card.ag agVar = new com.baidu.card.ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmT = 2;
        dVar.dmZ = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.bl(this.hgF);
        agVar.aW(16);
        aVar.b(agVar);
        com.baidu.card.ad rC = aVar.rC();
        com.baidu.card.a aVar2 = new com.baidu.card.a(rC);
        aVar2.setPageId(this.mPageId);
        rC.a(this.fsd);
        rC.bc(this.hgF);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.frs.entelechy.a.aa.2
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).dqA;
                    bjVar.objType = 1;
                    if (aa.this.fsd != null) {
                        aa.this.fsd.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), aa.this.hgF, false);
                    afVar.rD().b(new a.C0074a(1));
                }
            }
        });
        aVar2.rE();
        return aVar2;
    }

    private com.baidu.tieba.play.y aj(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bjVar.aLK() ? "3" : "2";
        yVar.eQf = this.hgG.htW;
        yVar.ahL = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.kin = bjVar.dsU;
        yVar.kio = bjVar.mRecomWeight;
        yVar.kir = bjVar.mRecomAbTag;
        if (bjVar.aKV() != null) {
            yVar.kis = bjVar.aKV().video_md5;
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
        if (this.hgG != null) {
            int i2 = 0;
            if (this.gXO != null) {
                i2 = this.gXO.getTopThreadSize();
            }
            biVar.dqA.doZ = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bUu().a(this.hgG, biVar.dqA);
        com.baidu.tieba.frs.d.a.a(biVar.dqA, this.mPageId, this.hgG, getTbPageTag());
        bh aKk = biVar.dqA.aKk();
        if (aKk != null) {
            String taskId = aKk.getTaskId();
            String aKb = aKk.aKb();
            if (StringUtils.isNull(aKb)) {
                aKb = aKk.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof ap) {
                ap apVar = (ap) this.mPageContext.getOrignalPage();
                if (this.hhM.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", apVar.getForumId(), apVar.getForumName(), aKk.getThreadId(), "tieba.baidu.com/p/" + biVar.dqA.getTid(), aKb);
                }
            }
            an anVar = new an("c13324");
            anVar.t("fid", biVar.dqA.getFid());
            anVar.cI("tid", biVar.dqA.getTid());
            anVar.cI("obj_id", taskId);
            anVar.af("thread_type", biVar.dqA.getThreadType());
            TiebaStatic.log(anVar);
        }
        if (biVar != null) {
            biVar.dqA.aLN();
            if (biVar.dqA.aKV() != null ? true : true) {
                aVar.setVideoStatsData(aj(biVar.dqA));
            }
            if (biVar.dqA != null && biVar.dqA.aLQ()) {
                aVar.rD().rx().aW(32);
            }
            aVar.b((com.baidu.card.a<bj>) biVar.dqA);
            aVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.rD().a(this.fsd);
            com.baidu.tieba.frs.g.a(aVar.rD().rx(), this.gXO);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.hhM.clear();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.hgF = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.agt = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hgG;
    }
}
