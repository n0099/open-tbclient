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
/* loaded from: classes6.dex */
public class z extends com.baidu.tieba.frs.h<bj, com.baidu.card.a<bj>> implements com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private boolean Nf;
    private com.baidu.tieba.card.z<bj> eHX;
    private int grd;
    private com.baidu.tieba.frs.d.b gre;
    private Set<String> gsi;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.grd = 3;
        this.gre = new com.baidu.tieba.frs.d.b();
        this.Nf = false;
        this.eHX = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, z.this.mPageId, z.this.gre, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, z.this.mPageId, z.this.gre, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 3, z.this.mPageId, z.this.gre, z.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, z.this.mPageId, z.this.gre, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, z.this.mPageId, z.this.gre, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, z.this.mPageId, z.this.gre, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, z.this.mPageId, z.this.gre, z.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, z.this.mPageId, z.this.gre, z.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bHd().a(z.this.gre, bjVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bjVar.aAm() == 2 && bjVar.azj() != null) {
                            String aza = bjVar.azj().aza();
                            if (StringUtils.isNull(aza)) {
                                aza = bjVar.azj().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bjVar.getFid()), bjVar.azJ(), bjVar.azj().getThreadId(), "tieba.baidu.com/p/" + bjVar.azj().getThreadId(), aza);
                            String taskId = bjVar.azj().getTaskId();
                            an anVar = new an("c13329");
                            anVar.s("fid", bjVar.getFid());
                            anVar.cp("obj_id", taskId);
                            TiebaStatic.log(anVar);
                        }
                        com.baidu.tieba.frs.d.c.bHd().a(z.this.gre, bjVar, 1);
                    }
                }
            }
        };
        this.gsi = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aH(696);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFromCDN(this.Nf);
        aVar.c(oVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.Nf);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJm = 2;
        dVar.cJs = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.aV(this.grd);
        agVar.aH(16);
        aVar.b(agVar);
        com.baidu.card.ad mS = aVar.mS();
        com.baidu.card.a aVar2 = new com.baidu.card.a(mS);
        aVar2.setPageId(this.mPageId);
        mS.a(this.eHX);
        mS.aM(this.grd);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.z.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bj) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = (bj) mVar;
                    bjVar.objType = 1;
                    if (z.this.eHX != null) {
                        z.this.eHX.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), z.this.grd, false);
                    afVar.mT().b(new a.C0050a(1));
                }
            }
        });
        aVar2.mU();
        return aVar2;
    }

    private com.baidu.tieba.play.y am(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bjVar.aAL() ? "3" : "2";
        yVar.fGQ = this.gre.gDY;
        yVar.OC = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.jsi = bjVar.cPj;
        yVar.jsj = bjVar.mRecomWeight;
        yVar.mAbTag = bjVar.mRecomAbTag;
        if (bjVar.azV() != null) {
            yVar.jsl = bjVar.azV().video_md5;
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
        if (this.gre != null) {
            int i2 = 0;
            if (this.giA != null) {
                i2 = this.giA.getTopThreadSize();
            }
            bjVar.cLr = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bHd().a(this.gre, bjVar);
        com.baidu.tieba.frs.d.a.a(bjVar, this.mPageId, this.gre, getTbPageTag());
        bh azj = bjVar.azj();
        if (azj != null) {
            String taskId = azj.getTaskId();
            String aza = azj.aza();
            if (StringUtils.isNull(aza)) {
                aza = azj.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof ak) {
                ak akVar = (ak) this.mPageContext.getOrignalPage();
                if (this.gsi.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", akVar.getForumId(), akVar.getForumName(), azj.getThreadId(), "tieba.baidu.com/p/" + bjVar.getTid(), aza);
                }
            }
            an anVar = new an("c13324");
            anVar.s("fid", bjVar.getFid());
            anVar.cp("tid", bjVar.getTid());
            anVar.cp("obj_id", taskId);
            anVar.Z("thread_type", bjVar.getThreadType());
            TiebaStatic.log(anVar);
        }
        if (bjVar != null) {
            bjVar.aAO();
            if (bjVar.azV() != null ? true : true) {
                aVar.setVideoStatsData(am(bjVar));
            }
            if (bjVar.aAR()) {
                aVar.mT().mN().aH(32);
            }
            aVar.b((com.baidu.card.a<bj>) bjVar);
            aVar.mT().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.mT().a(this.eHX);
            com.baidu.tieba.frs.g.a(aVar.mT().mN(), this.giA);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.gsi.clear();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pm(int i) {
        this.grd = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bEr() {
        return this.gre;
    }
}
