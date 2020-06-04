package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class ab extends com.baidu.tieba.frs.h<bk, com.baidu.card.a<bk>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private boolean aha;
    private com.baidu.tieba.card.aa<bk> fGl;
    private int hvK;
    private com.baidu.tieba.frs.d.b hvL;
    private Set<String> hwR;

    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hvK = 3;
        this.hvL = new com.baidu.tieba.frs.d.b();
        this.aha = false;
        this.fGl = new com.baidu.tieba.card.aa<bk>() { // from class: com.baidu.tieba.frs.entelechy.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                if (view != null && bkVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 2, ab.this.mPageId, ab.this.hvL, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 5, ab.this.mPageId, ab.this.hvL, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 3, ab.this.mPageId, ab.this.hvL, ab.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 15, ab.this.mPageId, ab.this.hvL, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 14, ab.this.mPageId, ab.this.hvL, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 12, ab.this.mPageId, ab.this.hvL, ab.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 13, ab.this.mPageId, ab.this.hvL, ab.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bkVar, 1, ab.this.mPageId, ab.this.hvL, ab.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.caY().a(ab.this.hvL, bkVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bkVar.aRj() == 2 && bkVar.aQd() != null) {
                            String aPU = bkVar.aQd().aPU();
                            if (StringUtils.isNull(aPU)) {
                                aPU = bkVar.aQd().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(bkVar.getFid()), bkVar.aQC(), bkVar.aQd().getThreadId(), "tieba.baidu.com/p/" + bkVar.aQd().getThreadId(), aPU);
                            String taskId = bkVar.aQd().getTaskId();
                            an anVar = new an("c13329");
                            anVar.s("fid", bkVar.getFid());
                            anVar.dh("obj_id", taskId);
                            TiebaStatic.log(anVar);
                        }
                        com.baidu.tieba.frs.d.c.caY().a(ab.this.hvL, bkVar, 1);
                    }
                }
            }
        };
        this.hwR = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aX(696);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        com.baidu.card.p pVar = new com.baidu.card.p(this.mPageContext.getPageActivity());
        pVar.setFromCDN(this.aha);
        aVar.c(pVar);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aha);
        lVar.setForm("frs");
        aVar.a((com.baidu.card.h) lVar);
        com.baidu.card.ah ahVar = new com.baidu.card.ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 2;
        cVar.dBf = 2;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(2);
        ahVar.setShareReportFrom(1);
        ahVar.bm(this.hvK);
        ahVar.aX(16);
        aVar.b(ahVar);
        com.baidu.card.ae rL = aVar.rL();
        com.baidu.card.a aVar2 = new com.baidu.card.a(rL);
        aVar2.setPageId(this.mPageId);
        rL.a(this.fGl);
        rL.setSourceForPb(this.hvK);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.frs.entelechy.a.ab.2
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof bk) && (view.getTag() instanceof com.baidu.card.ag)) {
                    com.baidu.card.ag agVar = (com.baidu.card.ag) view.getTag();
                    bk bkVar = (bk) oVar;
                    bkVar.objType = 1;
                    if (ab.this.fGl != null) {
                        ab.this.fGl.a(agVar.getView(), bkVar);
                    }
                    au.a((AbsThreadDataSupport) bkVar, view.getContext(), ab.this.hvK, false);
                    agVar.rM().b(new a.C0097a(1));
                }
            }
        });
        aVar2.rN();
        return aVar2;
    }

    private com.baidu.tieba.play.y ak(bk bkVar) {
        if (bkVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bkVar.aRH() ? "3" : "2";
        yVar.evm = this.hvL.hJC;
        yVar.ais = bkVar.getTid();
        yVar.mSource = bkVar.mRecomSource;
        yVar.kBr = bkVar.dGS;
        yVar.kBs = bkVar.mRecomWeight;
        yVar.kBv = bkVar.mRecomAbTag;
        if (bkVar.aQQ() != null) {
            yVar.kBw = bkVar.aQQ().video_md5;
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, com.baidu.card.a<bk> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.hvL != null) {
            int i2 = 0;
            if (this.hmR != null) {
                i2 = this.hmR.getTopThreadSize();
            }
            bkVar.dDb = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.caY().a(this.hvL, bkVar);
        com.baidu.tieba.frs.d.a.a(bkVar, this.mPageId, this.hvL, getTbPageTag());
        bi aQd = bkVar.aQd();
        if (aQd != null) {
            String taskId = aQd.getTaskId();
            String aPU = aQd.aPU();
            if (StringUtils.isNull(aPU)) {
                aPU = aQd.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof ap) {
                ap apVar = (ap) this.mPageContext.getOrignalPage();
                if (this.hwR.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", apVar.getForumId(), apVar.getForumName(), aQd.getThreadId(), "tieba.baidu.com/p/" + bkVar.getTid(), aPU);
                }
            }
            an anVar = new an("c13324");
            anVar.s("fid", bkVar.getFid());
            anVar.dh("tid", bkVar.getTid());
            anVar.dh("obj_id", taskId);
            anVar.ag("thread_type", bkVar.getThreadType());
            TiebaStatic.log(anVar);
        }
        if (bkVar != null) {
            bkVar.aRK();
            if (bkVar.aQQ() != null ? true : true) {
                aVar.setVideoStatsData(ak(bkVar));
            }
            if (bkVar.aRN()) {
                aVar.rM().rG().aX(32);
            }
            aVar.b((com.baidu.card.a<bk>) bkVar);
            aVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.rM().a(this.fGl);
            com.baidu.tieba.frs.g.a(aVar.rM().rG(), this.hmR);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void release() {
        super.release();
        this.hwR.clear();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qy(int i) {
        this.hvK = i;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hvL;
    }
}
