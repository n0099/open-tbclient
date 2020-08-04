package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.au;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes16.dex */
public class ae extends com.baidu.tieba.frs.j<bv, com.baidu.card.a<bv>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private boolean aib;
    private com.baidu.tieba.card.aa<bv> fWN;
    private int hOF;
    private com.baidu.tieba.frs.d.b hOG;
    private Set<String> hPR;

    public ae(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hOF = 3;
        this.hOG = new com.baidu.tieba.frs.d.b();
        this.aib = false;
        this.fWN = new com.baidu.tieba.card.aa<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 2, ae.this.mPageId, ae.this.hOG, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 5, ae.this.mPageId, ae.this.hOG, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 3, ae.this.mPageId, ae.this.hOG, ae.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 15, ae.this.mPageId, ae.this.hOG, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 14, ae.this.mPageId, ae.this.hOG, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 12, ae.this.mPageId, ae.this.hOG, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 13, ae.this.mPageId, ae.this.hOG, ae.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bvVar, 1, ae.this.mPageId, ae.this.hOG, ae.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.chQ().a(ae.this.hOG, bvVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bvVar.aWW() == 2 && bvVar.aVR() != null) {
                            String aVH = bvVar.aVR().aVH();
                            if (StringUtils.isNull(aVH)) {
                                aVH = bvVar.aVR().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bvVar.getFid()), bvVar.aWp(), bvVar.aVR().getThreadId(), "tieba.baidu.com/p/" + bvVar.aVR().getThreadId(), aVH);
                            String taskId = bvVar.aVR().getTaskId();
                            ap apVar = new ap("c13329");
                            apVar.t("fid", bvVar.getFid());
                            apVar.dn("obj_id", taskId);
                            TiebaStatic.log(apVar);
                        }
                        com.baidu.tieba.frs.d.c.chQ().a(ae.this.hOG, bvVar, 1);
                    }
                }
            }
        };
        this.hPR = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bf(696);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        com.baidu.card.p pVar = new com.baidu.card.p(this.mPageContext.getPageActivity());
        pVar.setFromCDN(this.aib);
        aVar.c(pVar);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aib);
        lVar.setForm("frs");
        aVar.a((com.baidu.card.h) lVar);
        com.baidu.card.al alVar = new com.baidu.card.al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 2;
        cVar.dNH = 2;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(2);
        alVar.setShareReportFrom(1);
        alVar.setFromForPb(this.hOF);
        alVar.bf(16);
        aVar.b(alVar);
        com.baidu.card.ai sf = aVar.sf();
        com.baidu.card.a aVar2 = new com.baidu.card.a(sf);
        aVar2.setPageId(this.mPageId);
        sf.a(this.fWN);
        sf.setSourceForPb(this.hOF);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.ae.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar = (com.baidu.card.ak) view.getTag();
                    bv bvVar = (bv) qVar;
                    bvVar.objType = 1;
                    if (ae.this.fWN != null) {
                        ae.this.fWN.a(akVar.getView(), bvVar);
                    }
                    ax.a((AbsThreadDataSupport) bvVar, view.getContext(), ae.this.hOF, false);
                    akVar.sg().b(new a.C0096a(1));
                }
            }
        });
        aVar2.sh();
        return aVar2;
    }

    private com.baidu.tieba.play.o ah(bv bvVar) {
        if (bvVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bvVar.aXu() ? "3" : "2";
        oVar.eKO = this.hOG.icO;
        oVar.ajJ = bvVar.getTid();
        oVar.mSource = bvVar.mRecomSource;
        oVar.lcJ = bvVar.dTO;
        oVar.lcK = bvVar.mRecomWeight;
        oVar.lcN = bvVar.mRecomAbTag;
        if (bvVar.aWD() != null) {
            oVar.lcO = bvVar.aWD().video_md5;
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.card.a<bv> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.hOG != null) {
            int i2 = 0;
            if (this.hEX != null) {
                i2 = this.hEX.getTopThreadSize();
            }
            bvVar.dPI = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.chQ().a(this.hOG, bvVar);
        com.baidu.tieba.frs.d.a.a(bvVar, this.mPageId, this.hOG, getTbPageTag());
        bt aVR = bvVar.aVR();
        if (aVR != null) {
            String taskId = aVR.getTaskId();
            String aVH = aVR.aVH();
            if (StringUtils.isNull(aVH)) {
                aVH = aVR.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof au) {
                au auVar = (au) this.mPageContext.getOrignalPage();
                if (this.hPR.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", auVar.getForumId(), auVar.getForumName(), aVR.getThreadId(), "tieba.baidu.com/p/" + bvVar.getTid(), aVH);
                }
            }
            ap apVar = new ap("c13324");
            apVar.t("fid", bvVar.getFid());
            apVar.dn("tid", bvVar.getTid());
            apVar.dn("obj_id", taskId);
            apVar.ah("thread_type", bvVar.getThreadType());
            TiebaStatic.log(apVar);
        }
        if (bvVar != null) {
            bvVar.aXx();
            if (bvVar.aWD() != null ? true : true) {
                aVar.setVideoStatsData(ah(bvVar));
            }
            if (bvVar.aXA()) {
                aVar.sg().sa().bf(32);
            }
            aVar.b((com.baidu.card.a<bv>) bvVar);
            aVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.sg().a(this.fWN);
            com.baidu.tieba.frs.i.a(aVar.sg().sa(), this.hEX);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.j
    public void release() {
        super.release();
        this.hPR.clear();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
        this.hOF = i;
    }

    @Override // com.baidu.tieba.frs.j
    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hOG;
    }
}
