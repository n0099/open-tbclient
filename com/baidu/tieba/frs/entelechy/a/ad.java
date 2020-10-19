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
/* loaded from: classes22.dex */
public class ad extends com.baidu.tieba.frs.k<bv, com.baidu.card.a<bw>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private boolean akj;
    private com.baidu.tieba.card.aa<bw> gAq;
    private Set<String> iAd;
    private int iyR;
    private com.baidu.tieba.frs.d.b iyS;

    public ad(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iyR = 3;
        this.iyS = new com.baidu.tieba.frs.d.b();
        this.akj = false;
        this.gAq = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.ad.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, ad.this.mPageId, ad.this.iyS, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, ad.this.mPageId, ad.this.iyS, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 3, ad.this.mPageId, ad.this.iyS, ad.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, ad.this.mPageId, ad.this.iyS, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, ad.this.mPageId, ad.this.iyS, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, ad.this.mPageId, ad.this.iyS, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, ad.this.mPageId, ad.this.iyS, ad.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, ad.this.mPageId, ad.this.iyS, ad.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.czh().a(ad.this.iyS, bwVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bwVar.biS() == 2 && bwVar.bhN() != null) {
                            String bhD = bwVar.bhN().bhD();
                            if (StringUtils.isNull(bhD)) {
                                bhD = bwVar.bhN().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", String.valueOf(bwVar.getFid()), bwVar.bil(), bwVar.bhN().getThreadId(), "tieba.baidu.com/p/" + bwVar.bhN().getThreadId(), bhD);
                            String taskId = bwVar.bhN().getTaskId();
                            aq aqVar = new aq("c13329");
                            aqVar.u("fid", bwVar.getFid());
                            aqVar.dK("obj_id", taskId);
                            TiebaStatic.log(aqVar);
                        }
                        com.baidu.tieba.frs.d.c.czh().a(ad.this.iyS, bwVar, 1);
                    }
                }
            }
        };
        this.iAd = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public com.baidu.card.a c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bo(696);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        com.baidu.card.r rVar = new com.baidu.card.r(this.mPageContext.getPageActivity());
        rVar.setFromCDN(this.akj);
        aVar.c(rVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akj);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ela = 2;
        cVar.elg = 2;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(this.iyR);
        anVar.bo(16);
        aVar.b(anVar);
        com.baidu.card.ak tV = aVar.tV();
        com.baidu.card.a aVar2 = new com.baidu.card.a(tV);
        aVar2.setPageId(this.mPageId);
        tV.a(this.gAq);
        tV.setSourceForPb(this.iyR);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ad.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    bw bwVar = ((bv) qVar).eji;
                    bwVar.objType = 1;
                    if (ad.this.gAq != null) {
                        ad.this.gAq.a(amVar.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), ad.this.iyR, false);
                    amVar.tW().b(new a.C0097a(1));
                }
            }
        });
        aVar2.tX();
        return aVar2;
    }

    private com.baidu.tieba.play.o ai(bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bwVar.bjq() ? "3" : "2";
        oVar.fkA = this.iyS.iNk;
        oVar.alS = bwVar.getTid();
        oVar.mSource = bwVar.mRecomSource;
        oVar.lRu = bwVar.erE;
        oVar.lRv = bwVar.mRecomWeight;
        oVar.lRy = bwVar.mRecomAbTag;
        if (bwVar.biz() != null) {
            oVar.lRz = bwVar.biz().video_md5;
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
        if (this.iyS != null) {
            int i2 = 0;
            if (this.iou != null) {
                i2 = this.iou.getTopThreadSize();
            }
            bvVar.eji.ens = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.czh().a(this.iyS, bvVar.eji);
        com.baidu.tieba.frs.d.a.a(bvVar.eji, this.mPageId, this.iyS, getTbPageTag());
        bu bhN = bvVar.eji.bhN();
        if (bhN != null) {
            String taskId = bhN.getTaskId();
            String bhD = bhN.bhD();
            if (StringUtils.isNull(bhD)) {
                bhD = bhN.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aw) {
                aw awVar = (aw) this.mPageContext.getOrignalPage();
                if (this.iAd.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.c("frs", "VIEW_TRUE", awVar.getForumId(), awVar.getForumName(), bhN.getThreadId(), "tieba.baidu.com/p/" + bvVar.eji.getTid(), bhD);
                }
            }
            aq aqVar = new aq("c13324");
            aqVar.u("fid", bvVar.eji.getFid());
            aqVar.dK("tid", bvVar.eji.getTid());
            aqVar.dK("obj_id", taskId);
            aqVar.aj("thread_type", bvVar.eji.getThreadType());
            TiebaStatic.log(aqVar);
        }
        if (bvVar != null) {
            bvVar.eji.bjt();
            if (bvVar.eji.biz() != null ? true : true) {
                aVar.setVideoStatsData(ai(bvVar.eji));
            }
            if (bvVar.eji != null && bvVar.eji.bjw()) {
                aVar.tW().tQ().bo(32);
            }
            aVar.b((com.baidu.card.a<bw>) bvVar.eji);
            aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.tW().a(this.gAq);
            com.baidu.tieba.frs.j.a(aVar.tW().tQ(), this.iou);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        super.release();
        this.iAd.clear();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void ux(int i) {
        this.iyR = i;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akj = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iyS;
    }
}
