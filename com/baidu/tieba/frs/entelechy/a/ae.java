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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.au;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class ae extends com.baidu.tieba.frs.j<bu, com.baidu.card.a<bu>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private boolean aik;
    private com.baidu.tieba.card.aa<bu> fRu;
    private int hID;
    private com.baidu.tieba.frs.d.b hIE;
    private Set<String> hJP;

    public ae(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hID = 3;
        this.hIE = new com.baidu.tieba.frs.d.b();
        this.aik = false;
        this.fRu = new com.baidu.tieba.card.aa<bu>() { // from class: com.baidu.tieba.frs.entelechy.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bu buVar) {
                if (view != null && buVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(buVar, 2, ae.this.mPageId, ae.this.hIE, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(buVar, 5, ae.this.mPageId, ae.this.hIE, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(buVar, 3, ae.this.mPageId, ae.this.hIE, ae.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(buVar, 15, ae.this.mPageId, ae.this.hIE, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(buVar, 14, ae.this.mPageId, ae.this.hIE, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(buVar, 12, ae.this.mPageId, ae.this.hIE, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(buVar, 13, ae.this.mPageId, ae.this.hIE, ae.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(buVar, 1, ae.this.mPageId, ae.this.hIE, ae.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.ceq().a(ae.this.hIE, buVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (buVar.aTa() == 2 && buVar.aRV() != null) {
                            String aRL = buVar.aRV().aRL();
                            if (StringUtils.isNull(aRL)) {
                                aRL = buVar.aRV().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", String.valueOf(buVar.getFid()), buVar.aSt(), buVar.aRV().getThreadId(), "tieba.baidu.com/p/" + buVar.aRV().getThreadId(), aRL);
                            String taskId = buVar.aRV().getTaskId();
                            ao aoVar = new ao("c13329");
                            aoVar.s("fid", buVar.getFid());
                            aoVar.dk("obj_id", taskId);
                            TiebaStatic.log(aoVar);
                        }
                        com.baidu.tieba.frs.d.c.ceq().a(ae.this.hIE, buVar, 1);
                    }
                }
            }
        };
        this.hJP = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bd(696);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        com.baidu.card.p pVar = new com.baidu.card.p(this.mPageContext.getPageActivity());
        pVar.setFromCDN(this.aik);
        aVar.c(pVar);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aik);
        lVar.setForm("frs");
        aVar.a((com.baidu.card.h) lVar);
        com.baidu.card.al alVar = new com.baidu.card.al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 2;
        cVar.dHw = 2;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(2);
        alVar.setShareReportFrom(1);
        alVar.setFromForPb(this.hID);
        alVar.bd(16);
        aVar.b(alVar);
        com.baidu.card.ai sd = aVar.sd();
        com.baidu.card.a aVar2 = new com.baidu.card.a(sd);
        aVar2.setPageId(this.mPageId);
        sd.a(this.fRu);
        sd.setSourceForPb(this.hID);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.ae.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bu) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar = (com.baidu.card.ak) view.getTag();
                    bu buVar = (bu) qVar;
                    buVar.objType = 1;
                    if (ae.this.fRu != null) {
                        ae.this.fRu.a(akVar.getView(), buVar);
                    }
                    aw.a((AbsThreadDataSupport) buVar, view.getContext(), ae.this.hID, false);
                    akVar.se().b(new a.C0098a(1));
                }
            }
        });
        aVar2.sf();
        return aVar2;
    }

    private com.baidu.tieba.play.y ak(bu buVar) {
        if (buVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = buVar.aTy() ? "3" : "2";
        yVar.eEs = this.hIE.hWO;
        yVar.ajO = buVar.getTid();
        yVar.mSource = buVar.mRecomSource;
        yVar.kVo = buVar.dND;
        yVar.kVp = buVar.mRecomWeight;
        yVar.kVs = buVar.mRecomAbTag;
        if (buVar.aSH() != null) {
            yVar.kVt = buVar.aSH().video_md5;
        }
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, com.baidu.card.a<bu> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.hIE != null) {
            int i2 = 0;
            if (this.hzi != null) {
                i2 = this.hzi.getTopThreadSize();
            }
            buVar.dJw = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.ceq().a(this.hIE, buVar);
        com.baidu.tieba.frs.d.a.a(buVar, this.mPageId, this.hIE, getTbPageTag());
        bs aRV = buVar.aRV();
        if (aRV != null) {
            String taskId = aRV.getTaskId();
            String aRL = aRV.aRL();
            if (StringUtils.isNull(aRL)) {
                aRL = aRV.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof au) {
                au auVar = (au) this.mPageContext.getOrignalPage();
                if (this.hJP.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.a("frs", "VIEW_TRUE", auVar.getForumId(), auVar.getForumName(), aRV.getThreadId(), "tieba.baidu.com/p/" + buVar.getTid(), aRL);
                }
            }
            ao aoVar = new ao("c13324");
            aoVar.s("fid", buVar.getFid());
            aoVar.dk("tid", buVar.getTid());
            aoVar.dk("obj_id", taskId);
            aoVar.ag("thread_type", buVar.getThreadType());
            TiebaStatic.log(aoVar);
        }
        if (buVar != null) {
            buVar.aTB();
            if (buVar.aSH() != null ? true : true) {
                aVar.setVideoStatsData(ak(buVar));
            }
            if (buVar.aTE()) {
                aVar.se().rY().bd(32);
            }
            aVar.b((com.baidu.card.a<bu>) buVar);
            aVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.se().a(this.fRu);
            com.baidu.tieba.frs.i.a(aVar.se().rY(), this.hzi);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.j
    public void release() {
        super.release();
        this.hJP.clear();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
        this.hID = i;
    }

    @Override // com.baidu.tieba.frs.j
    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hIE;
    }
}
