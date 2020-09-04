package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aw;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes16.dex */
public class ad extends com.baidu.tieba.frs.k<bv, com.baidu.card.a<bw>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private boolean ajt;
    private com.baidu.tieba.card.aa<bw> giQ;
    private int icQ;
    private com.baidu.tieba.frs.d.b icR;
    private Set<String> ieg;

    public ad(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.icQ = 3;
        this.icR = new com.baidu.tieba.frs.d.b();
        this.ajt = false;
        this.giQ = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.ad.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, ad.this.mPageId, ad.this.icR, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, ad.this.mPageId, ad.this.icR, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 3, ad.this.mPageId, ad.this.icR, ad.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, ad.this.mPageId, ad.this.icR, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, ad.this.mPageId, ad.this.icR, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, ad.this.mPageId, ad.this.icR, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, ad.this.mPageId, ad.this.icR, ad.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, ad.this.mPageId, ad.this.icR, ad.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.csv().a(ad.this.icR, bwVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bwVar.bfp() == 2 && bwVar.bek() != null) {
                            String bea = bwVar.bek().bea();
                            if (StringUtils.isNull(bea)) {
                                bea = bwVar.bek().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", String.valueOf(bwVar.getFid()), bwVar.beI(), bwVar.bek().getThreadId(), "tieba.baidu.com/p/" + bwVar.bek().getThreadId(), bea);
                            String taskId = bwVar.bek().getTaskId();
                            aq aqVar = new aq("c13329");
                            aqVar.u("fid", bwVar.getFid());
                            aqVar.dD("obj_id", taskId);
                            TiebaStatic.log(aqVar);
                        }
                        com.baidu.tieba.frs.d.c.csv().a(ad.this.icR, bwVar, 1);
                    }
                }
            }
        };
        this.ieg = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bk(696);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        com.baidu.card.q qVar = new com.baidu.card.q(this.mPageContext.getPageActivity());
        qVar.setFromCDN(this.ajt);
        aVar.c(qVar);
        com.baidu.card.m mVar = new com.baidu.card.m(this.mPageContext.getPageActivity());
        mVar.setFromCDN(this.ajt);
        mVar.setForm("frs");
        aVar.a((com.baidu.card.h) mVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWO = 2;
        cVar.dWU = 2;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(this.icQ);
        amVar.bk(16);
        aVar.b(amVar);
        com.baidu.card.aj tQ = aVar.tQ();
        com.baidu.card.a aVar2 = new com.baidu.card.a(tQ);
        aVar2.setPageId(this.mPageId);
        tQ.a(this.giQ);
        tQ.setSourceForPb(this.icQ);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ad.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar2 instanceof bv) && (view.getTag() instanceof com.baidu.card.al)) {
                    com.baidu.card.al alVar = (com.baidu.card.al) view.getTag();
                    bw bwVar = ((bv) qVar2).dUW;
                    bwVar.objType = 1;
                    if (ad.this.giQ != null) {
                        ad.this.giQ.a(alVar.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), ad.this.icQ, false);
                    alVar.tR().b(new a.C0095a(1));
                }
            }
        });
        aVar2.tS();
        return aVar2;
    }

    private com.baidu.tieba.play.o ah(bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bwVar.bfN() ? "3" : "2";
        oVar.eVx = this.icR.irb;
        oVar.ala = bwVar.getTid();
        oVar.mSource = bwVar.mRecomSource;
        oVar.ltn = bwVar.edo;
        oVar.lto = bwVar.mRecomWeight;
        oVar.lts = bwVar.mRecomAbTag;
        if (bwVar.beW() != null) {
            oVar.ltt = bwVar.beW().video_md5;
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.card.a<bw> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.icR != null) {
            int i2 = 0;
            if (this.hSt != null) {
                i2 = this.hSt.getTopThreadSize();
            }
            bvVar.dUW.dZf = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.csv().a(this.icR, bvVar.dUW);
        com.baidu.tieba.frs.d.a.a(bvVar.dUW, this.mPageId, this.icR, getTbPageTag());
        bu bek = bvVar.dUW.bek();
        if (bek != null) {
            String taskId = bek.getTaskId();
            String bea = bek.bea();
            if (StringUtils.isNull(bea)) {
                bea = bek.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aw) {
                aw awVar = (aw) this.mPageContext.getOrignalPage();
                if (this.ieg.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.c("frs", "VIEW_TRUE", awVar.getForumId(), awVar.getForumName(), bek.getThreadId(), "tieba.baidu.com/p/" + bvVar.dUW.getTid(), bea);
                }
            }
            aq aqVar = new aq("c13324");
            aqVar.u("fid", bvVar.dUW.getFid());
            aqVar.dD("tid", bvVar.dUW.getTid());
            aqVar.dD("obj_id", taskId);
            aqVar.ai("thread_type", bvVar.dUW.getThreadType());
            TiebaStatic.log(aqVar);
        }
        if (bvVar != null) {
            bvVar.dUW.bfQ();
            if (bvVar.dUW.beW() != null ? true : true) {
                aVar.setVideoStatsData(ah(bvVar.dUW));
            }
            if (bvVar.dUW != null && bvVar.dUW.bfT()) {
                aVar.tR().tL().bk(32);
            }
            aVar.b((com.baidu.card.a<bw>) bvVar.dUW);
            aVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.tR().a(this.giQ);
            com.baidu.tieba.frs.j.a(aVar.tR().tL(), this.hSt);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        super.release();
        this.ieg.clear();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.icQ = i;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.ajt = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.icR;
    }
}
