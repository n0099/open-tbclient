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
public class ae extends com.baidu.tieba.frs.k<bw, com.baidu.card.a<bw>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private boolean akk;
    private com.baidu.tieba.card.ab<bw> gMe;
    private int iLn;
    private com.baidu.tieba.frs.d.b iLo;
    private Set<String> iMz;

    public ae(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.iLn = 3;
        this.iLo = new com.baidu.tieba.frs.d.b();
        this.akk = false;
        this.gMe = new com.baidu.tieba.card.ab<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, ae.this.mPageId, ae.this.iLo, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, ae.this.mPageId, ae.this.iLo, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 3, ae.this.mPageId, ae.this.iLo, ae.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, ae.this.mPageId, ae.this.iLo, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, ae.this.mPageId, ae.this.iLo, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, ae.this.mPageId, ae.this.iLo, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, ae.this.mPageId, ae.this.iLo, ae.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, ae.this.mPageId, ae.this.iLo, ae.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cCo().a(ae.this.iLo, bwVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bwVar.bkL() == 2 && bwVar.bjG() != null) {
                            String bjw = bwVar.bjG().bjw();
                            if (StringUtils.isNull(bjw)) {
                                bjw = bwVar.bjG().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", String.valueOf(bwVar.getFid()), bwVar.bke(), bwVar.bjG().getThreadId(), "tieba.baidu.com/p/" + bwVar.bjG().getThreadId(), bjw);
                            String taskId = bwVar.bjG().getTaskId();
                            aq aqVar = new aq("c13329");
                            aqVar.w("fid", bwVar.getFid());
                            aqVar.dR("obj_id", taskId);
                            TiebaStatic.log(aqVar);
                        }
                        com.baidu.tieba.frs.d.c.cCo().a(ae.this.iLo, bwVar, 1);
                    }
                }
            }
        };
        this.iMz = new HashSet();
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
        rVar.setFromCDN(this.akk);
        aVar.c(rVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akk);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.etA = 2;
        cVar.etG = 2;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(this.iLn);
        anVar.bo(16);
        aVar.b(anVar);
        com.baidu.card.ak tV = aVar.tV();
        com.baidu.card.a aVar2 = new com.baidu.card.a(tV);
        aVar2.setPageId(this.mPageId);
        tV.a(this.gMe);
        tV.setSourceForPb(this.iLn);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ae.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    bw bwVar = (bw) qVar;
                    bwVar.objType = 1;
                    if (ae.this.gMe != null) {
                        ae.this.gMe.a(amVar.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), ae.this.iLn, false);
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
        oVar.mLocate = bwVar.blj() ? "3" : "2";
        oVar.fsZ = this.iLo.iZG;
        oVar.alT = bwVar.getTid();
        oVar.mSource = bwVar.mRecomSource;
        oVar.mdS = bwVar.eAe;
        oVar.mdT = bwVar.mRecomWeight;
        oVar.mdW = bwVar.mRecomAbTag;
        if (bwVar.bks() != null) {
            oVar.mdX = bwVar.bks().video_md5;
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, com.baidu.card.a<bw> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.iLo != null) {
            int i2 = 0;
            if (this.iAQ != null) {
                i2 = this.iAQ.getTopThreadSize();
            }
            bwVar.evR = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.cCo().a(this.iLo, bwVar);
        com.baidu.tieba.frs.d.a.a(bwVar, this.mPageId, this.iLo, getTbPageTag());
        bu bjG = bwVar.bjG();
        if (bjG != null) {
            String taskId = bjG.getTaskId();
            String bjw = bjG.bjw();
            if (StringUtils.isNull(bjw)) {
                bjw = bjG.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aw) {
                aw awVar = (aw) this.mPageContext.getOrignalPage();
                if (this.iMz.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.c("frs", "VIEW_TRUE", awVar.getForumId(), awVar.getForumName(), bjG.getThreadId(), "tieba.baidu.com/p/" + bwVar.getTid(), bjw);
                }
            }
            aq aqVar = new aq("c13324");
            aqVar.w("fid", bwVar.getFid());
            aqVar.dR("tid", bwVar.getTid());
            aqVar.dR("obj_id", taskId);
            aqVar.aj("thread_type", bwVar.getThreadType());
            TiebaStatic.log(aqVar);
        }
        if (bwVar != null) {
            bwVar.blm();
            if (bwVar.bks() != null ? true : true) {
                aVar.setVideoStatsData(ai(bwVar));
            }
            if (bwVar.blp()) {
                aVar.tW().tQ().bo(32);
            }
            aVar.b((com.baidu.card.a<bw>) bwVar);
            aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.tW().a(this.gMe);
            com.baidu.tieba.frs.j.a(aVar.tW().tQ(), this.iAQ);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        super.release();
        this.iMz.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uQ(int i) {
        this.iLn = i;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iLo;
    }
}
