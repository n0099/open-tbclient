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
/* loaded from: classes21.dex */
public class ae extends com.baidu.tieba.frs.k<bw, com.baidu.card.a<bw>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private boolean ajR;
    private com.baidu.tieba.card.aa<bw> glX;
    private int ijU;
    private com.baidu.tieba.frs.d.b ijV;
    private Set<String> ilg;

    public ae(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ijU = 3;
        this.ijV = new com.baidu.tieba.frs.d.b();
        this.ajR = false;
        this.glX = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, ae.this.mPageId, ae.this.ijV, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, ae.this.mPageId, ae.this.ijV, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 3, ae.this.mPageId, ae.this.ijV, ae.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, ae.this.mPageId, ae.this.ijV, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, ae.this.mPageId, ae.this.ijV, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, ae.this.mPageId, ae.this.ijV, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, ae.this.mPageId, ae.this.ijV, ae.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, ae.this.mPageId, ae.this.ijV, ae.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cvK().a(ae.this.ijV, bwVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bwVar.bgj() == 2 && bwVar.bfe() != null) {
                            String beU = bwVar.bfe().beU();
                            if (StringUtils.isNull(beU)) {
                                beU = bwVar.bfe().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", String.valueOf(bwVar.getFid()), bwVar.bfC(), bwVar.bfe().getThreadId(), "tieba.baidu.com/p/" + bwVar.bfe().getThreadId(), beU);
                            String taskId = bwVar.bfe().getTaskId();
                            aq aqVar = new aq("c13329");
                            aqVar.u("fid", bwVar.getFid());
                            aqVar.dF("obj_id", taskId);
                            TiebaStatic.log(aqVar);
                        }
                        com.baidu.tieba.frs.d.c.cvK().a(ae.this.ijV, bwVar, 1);
                    }
                }
            }
        };
        this.ilg = new HashSet();
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
        rVar.setFromCDN(this.ajR);
        aVar.c(rVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.ajR);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 2;
        cVar.dZe = 2;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(this.ijU);
        anVar.bo(16);
        aVar.b(anVar);
        com.baidu.card.ak tV = aVar.tV();
        com.baidu.card.a aVar2 = new com.baidu.card.a(tV);
        aVar2.setPageId(this.mPageId);
        tV.a(this.glX);
        tV.setSourceForPb(this.ijU);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ae.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    bw bwVar = (bw) qVar;
                    bwVar.objType = 1;
                    if (ae.this.glX != null) {
                        ae.this.glX.a(amVar.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), ae.this.ijU, false);
                    amVar.tW().b(new a.C0096a(1));
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
        oVar.mLocate = bwVar.bgH() ? "3" : "2";
        oVar.eYo = this.ijV.iyr;
        oVar.alA = bwVar.getTid();
        oVar.mSource = bwVar.mRecomSource;
        oVar.lCf = bwVar.efy;
        oVar.lCg = bwVar.mRecomWeight;
        oVar.lCj = bwVar.mRecomAbTag;
        if (bwVar.bfQ() != null) {
            oVar.lCk = bwVar.bfQ().video_md5;
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
        if (this.ijV != null) {
            int i2 = 0;
            if (this.hZt != null) {
                i2 = this.hZt.getTopThreadSize();
            }
            bwVar.ebp = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.cvK().a(this.ijV, bwVar);
        com.baidu.tieba.frs.d.a.a(bwVar, this.mPageId, this.ijV, getTbPageTag());
        bu bfe = bwVar.bfe();
        if (bfe != null) {
            String taskId = bfe.getTaskId();
            String beU = bfe.beU();
            if (StringUtils.isNull(beU)) {
                beU = bfe.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof aw) {
                aw awVar = (aw) this.mPageContext.getOrignalPage();
                if (this.ilg.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.c("frs", "VIEW_TRUE", awVar.getForumId(), awVar.getForumName(), bfe.getThreadId(), "tieba.baidu.com/p/" + bwVar.getTid(), beU);
                }
            }
            aq aqVar = new aq("c13324");
            aqVar.u("fid", bwVar.getFid());
            aqVar.dF("tid", bwVar.getTid());
            aqVar.dF("obj_id", taskId);
            aqVar.ai("thread_type", bwVar.getThreadType());
            TiebaStatic.log(aqVar);
        }
        if (bwVar != null) {
            bwVar.bgK();
            if (bwVar.bfQ() != null ? true : true) {
                aVar.setVideoStatsData(ai(bwVar));
            }
            if (bwVar.bgN()) {
                aVar.tW().tQ().bo(32);
            }
            aVar.b((com.baidu.card.a<bw>) bwVar);
            aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.tW().a(this.glX);
            com.baidu.tieba.frs.j.a(aVar.tW().tQ(), this.hZt);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        super.release();
        this.ilg.clear();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
        this.ijU = i;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.ijV;
    }
}
