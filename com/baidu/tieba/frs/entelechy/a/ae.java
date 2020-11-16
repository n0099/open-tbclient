package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aw;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes21.dex */
public class ae extends com.baidu.tieba.frs.k<bx, com.baidu.card.a<bx>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private boolean akn;
    private com.baidu.tieba.card.ab<bx> gSk;
    private int iRX;
    private com.baidu.tieba.frs.d.b iRY;
    private Set<String> iTj;

    public ae(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iRX = 3;
        this.iRY = new com.baidu.tieba.frs.d.b();
        this.akn = false;
        this.gSk = new com.baidu.tieba.card.ab<bx>() { // from class: com.baidu.tieba.frs.entelechy.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bx bxVar) {
                if (view != null && bxVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 2, ae.this.mPageId, ae.this.iRY, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 5, ae.this.mPageId, ae.this.iRY, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 3, ae.this.mPageId, ae.this.iRY, ae.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 15, ae.this.mPageId, ae.this.iRY, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 14, ae.this.mPageId, ae.this.iRY, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 12, ae.this.mPageId, ae.this.iRY, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 13, ae.this.mPageId, ae.this.iRY, ae.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bxVar, 1, ae.this.mPageId, ae.this.iRY, ae.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cEu().a(ae.this.iRY, bxVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bxVar.bmn() == 2 && bxVar.bli() != null) {
                            String bkY = bxVar.bli().bkY();
                            if (StringUtils.isNull(bkY)) {
                                bkY = bxVar.bli().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", String.valueOf(bxVar.getFid()), bxVar.blG(), bxVar.bli().getThreadId(), "tieba.baidu.com/p/" + bxVar.bli().getThreadId(), bkY);
                            String taskId = bxVar.bli().getTaskId();
                            ar arVar = new ar("c13329");
                            arVar.w("fid", bxVar.getFid());
                            arVar.dR("obj_id", taskId);
                            TiebaStatic.log(arVar);
                        }
                        com.baidu.tieba.frs.d.c.cEu().a(ae.this.iRY, bxVar, 1);
                    }
                }
            }
        };
        this.iTj = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bo(696);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        com.baidu.card.r rVar = new com.baidu.card.r(this.mPageContext.getPageActivity());
        rVar.setFromCDN(this.akn);
        aVar.c(rVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akn);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.exI = 2;
        dVar.exO = 2;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(this.iRX);
        anVar.bo(16);
        aVar.b(anVar);
        com.baidu.card.ak tU = aVar.tU();
        com.baidu.card.a aVar2 = new com.baidu.card.a(tU);
        aVar2.setPageId(this.mPageId);
        tU.a(this.gSk);
        tU.setSourceForPb(this.iRX);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ae.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bx) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    bx bxVar = (bx) qVar;
                    bxVar.objType = 1;
                    if (ae.this.gSk != null) {
                        ae.this.gSk.a(amVar.getView(), bxVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), ae.this.iRX, false);
                    amVar.tW().b(new a.C0096a(1));
                }
            }
        });
        aVar2.tX();
        return aVar2;
    }

    private com.baidu.tieba.play.o ak(bx bxVar) {
        if (bxVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bxVar.bmN() ? "3" : "2";
        oVar.fyg = this.iRY.jgo;
        oVar.alZ = bxVar.getTid();
        oVar.mSource = bxVar.mRecomSource;
        oVar.mkk = bxVar.eEl;
        oVar.mkl = bxVar.mRecomWeight;
        oVar.mko = bxVar.mRecomAbTag;
        if (bxVar.blU() != null) {
            oVar.mkp = bxVar.blU().video_md5;
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, com.baidu.card.a<bx> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.iRY != null) {
            int i2 = 0;
            if (this.iHB != null) {
                i2 = this.iHB.getTopThreadSize();
            }
            bxVar.eAb = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.cEu().a(this.iRY, bxVar);
        com.baidu.tieba.frs.d.a.a(bxVar, this.mPageId, this.iRY, getTbPageTag());
        bv bli = bxVar.bli();
        if (bli != null) {
            String taskId = bli.getTaskId();
            String bkY = bli.bkY();
            if (StringUtils.isNull(bkY)) {
                bkY = bli.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aw) {
                aw awVar = (aw) this.mPageContext.getOrignalPage();
                if (this.iTj.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.c("frs", "VIEW_TRUE", awVar.getForumId(), awVar.getForumName(), bli.getThreadId(), "tieba.baidu.com/p/" + bxVar.getTid(), bkY);
                }
            }
            ar arVar = new ar("c13324");
            arVar.w("fid", bxVar.getFid());
            arVar.dR("tid", bxVar.getTid());
            arVar.dR("obj_id", taskId);
            arVar.ak("thread_type", bxVar.getThreadType());
            TiebaStatic.log(arVar);
        }
        if (bxVar != null) {
            bxVar.bmQ();
            if (bxVar.blU() != null ? true : true) {
                aVar.setVideoStatsData(ak(bxVar));
            }
            aVar.tW().tQ().bo(32);
            aVar.b((com.baidu.card.a<bx>) bxVar);
            aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.tW().a(this.gSk);
            com.baidu.tieba.frs.j.a(aVar.tW().tQ(), this.iHB);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        super.release();
        this.iTj.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
        this.iRX = i;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRY;
    }
}
