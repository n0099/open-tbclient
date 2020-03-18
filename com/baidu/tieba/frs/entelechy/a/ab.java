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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.al;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class ab extends com.baidu.tieba.frs.h<bj, com.baidu.card.a<bj>> implements com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private boolean NK;
    private com.baidu.tieba.card.z<bj> eNJ;
    private int gxk;
    private com.baidu.tieba.frs.d.b gxl;
    private Set<String> gyr;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gxk = 3;
        this.gxl = new com.baidu.tieba.frs.d.b();
        this.NK = false;
        this.eNJ = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, ab.this.mPageId, ab.this.gxl, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, ab.this.mPageId, ab.this.gxl, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 3, ab.this.mPageId, ab.this.gxl, ab.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, ab.this.mPageId, ab.this.gxl, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, ab.this.mPageId, ab.this.gxl, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, ab.this.mPageId, ab.this.gxl, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, ab.this.mPageId, ab.this.gxl, ab.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, ab.this.mPageId, ab.this.gxl, ab.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJX().a(ab.this.gxl, bjVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bjVar.aCZ() == 2 && bjVar.aBX() != null) {
                            String aBO = bjVar.aBX().aBO();
                            if (StringUtils.isNull(aBO)) {
                                aBO = bjVar.aBX().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bjVar.getFid()), bjVar.aCw(), bjVar.aBX().getThreadId(), "tieba.baidu.com/p/" + bjVar.aBX().getThreadId(), aBO);
                            String taskId = bjVar.aBX().getTaskId();
                            an anVar = new an("c13329");
                            anVar.s("fid", bjVar.getFid());
                            anVar.cx("obj_id", taskId);
                            TiebaStatic.log(anVar);
                        }
                        com.baidu.tieba.frs.d.c.bJX().a(ab.this.gxl, bjVar, 1);
                    }
                }
            }
        };
        this.gyr = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aK(696);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFromCDN(this.NK);
        aVar.c(oVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.NK);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        com.baidu.card.ag agVar = new com.baidu.card.ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = 2;
        dVar.cNV = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.aZ(this.gxk);
        agVar.aK(16);
        aVar.b(agVar);
        com.baidu.card.ad nj = aVar.nj();
        com.baidu.card.a aVar2 = new com.baidu.card.a(nj);
        aVar2.setPageId(this.mPageId);
        nj.a(this.eNJ);
        nj.aQ(this.gxk);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.ab.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bj) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = (bj) mVar;
                    bjVar.objType = 1;
                    if (ab.this.eNJ != null) {
                        ab.this.eNJ.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), ab.this.gxk, false);
                    afVar.nk().b(new a.C0052a(1));
                }
            }
        });
        aVar2.nl();
        return aVar2;
    }

    private com.baidu.tieba.play.y aq(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bjVar.aDx() ? "3" : "2";
        yVar.emF = this.gxl.gKF;
        yVar.Pk = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.jyr = bjVar.cTK;
        yVar.jys = bjVar.mRecomWeight;
        yVar.mAbTag = bjVar.mRecomAbTag;
        if (bjVar.aCI() != null) {
            yVar.jyv = bjVar.aCI().video_md5;
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
        if (this.gxl != null) {
            int i2 = 0;
            if (this.goJ != null) {
                i2 = this.goJ.getTopThreadSize();
            }
            bjVar.cPT = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bJX().a(this.gxl, bjVar);
        com.baidu.tieba.frs.d.a.a(bjVar, this.mPageId, this.gxl, getTbPageTag());
        bh aBX = bjVar.aBX();
        if (aBX != null) {
            String taskId = aBX.getTaskId();
            String aBO = aBX.aBO();
            if (StringUtils.isNull(aBO)) {
                aBO = aBX.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof al) {
                al alVar = (al) this.mPageContext.getOrignalPage();
                if (this.gyr.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", alVar.getForumId(), alVar.getForumName(), aBX.getThreadId(), "tieba.baidu.com/p/" + bjVar.getTid(), aBO);
                }
            }
            an anVar = new an("c13324");
            anVar.s("fid", bjVar.getFid());
            anVar.cx("tid", bjVar.getTid());
            anVar.cx("obj_id", taskId);
            anVar.X("thread_type", bjVar.getThreadType());
            TiebaStatic.log(anVar);
        }
        if (bjVar != null) {
            bjVar.aDA();
            if (bjVar.aCI() != null ? true : true) {
                aVar.setVideoStatsData(aq(bjVar));
            }
            if (bjVar.aDD()) {
                aVar.nk().ne().aK(32);
            }
            aVar.b((com.baidu.card.a<bj>) bjVar);
            aVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.nk().a(this.eNJ);
            com.baidu.tieba.frs.g.a(aVar.nk().ne(), this.goJ);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.gyr.clear();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pB(int i) {
        this.gxk = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.NK = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bHn() {
        return this.gxl;
    }
}
