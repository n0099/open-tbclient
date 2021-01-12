package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.as;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class ag extends com.baidu.tieba.frs.k<bz, AutoVideoCardViewHolder<bz>> implements com.baidu.tieba.card.y, com.baidu.tieba.frs.b.d {
    private boolean akY;
    private com.baidu.tieba.card.aa<bz> hiF;
    private int jkI;
    private com.baidu.tieba.frs.b.b jkJ;
    private Set<String> jlZ;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jkI = 3;
        this.jkJ = new com.baidu.tieba.frs.b.b();
        this.akY = false;
        this.hiF = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 2, ag.this.mPageId, ag.this.jkJ, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 5, ag.this.mPageId, ag.this.jkJ, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 3, ag.this.mPageId, ag.this.jkJ, ag.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 15, ag.this.mPageId, ag.this.jkJ, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 14, ag.this.mPageId, ag.this.jkJ, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 12, ag.this.mPageId, ag.this.jkJ, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 13, ag.this.mPageId, ag.this.jkJ, ag.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(bzVar, 1, ag.this.mPageId, ag.this.jkJ, ag.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cIR().a(ag.this.jkJ, bzVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bzVar.boi() == 2 && bzVar.bnd() != null) {
                            String bmT = bzVar.bnd().bmT();
                            if (StringUtils.isNull(bmT)) {
                                bmT = bzVar.bnd().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", String.valueOf(bzVar.getFid()), bzVar.bnB(), bzVar.bnd().getThreadId(), "tieba.baidu.com/p/" + bzVar.bnd().getThreadId(), bmT);
                            String taskId = bzVar.bnd().getTaskId();
                            aq aqVar = new aq("c13329");
                            aqVar.w("fid", bzVar.getFid());
                            aqVar.dW("obj_id", taskId);
                            TiebaStatic.log(aqVar);
                        }
                        com.baidu.tieba.frs.b.c.cIR().a(ag.this.jkJ, bzVar, 1);
                    }
                }
            }
        };
        this.jlZ = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bq(696);
        dVar.setPageUniqueId(this.mPageId);
        aVar.a(dVar);
        com.baidu.card.r rVar = new com.baidu.card.r(this.mPageContext.getPageActivity());
        rVar.setFromCDN(this.akY);
        aVar.c(rVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akY);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.eJO = 2;
        dVar2.eJU = 2;
        amVar.setAgreeStatisticData(dVar2);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(this.jkI);
        amVar.bq(16);
        aVar.b(amVar);
        com.baidu.card.ak tk = aVar.tk();
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(tk);
        autoVideoCardViewHolder.setPageId(this.mPageId);
        tk.a(this.hiF);
        tk.setSourceForPb(this.jkI);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.ag.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof bz) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = (bz) nVar2;
                    bzVar.objType = 1;
                    if (ag.this.hiF != null) {
                        ag.this.hiF.a(threadCardViewHolder.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), ag.this.jkI, false);
                    threadCardViewHolder.tm().b(new a.C0089a(1));
                }
            }
        });
        autoVideoCardViewHolder.tn();
        return autoVideoCardViewHolder;
    }

    private com.baidu.tieba.play.o ak(bz bzVar) {
        if (bzVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bzVar.boI() ? "3" : "2";
        oVar.fKR = this.jkJ.jBI;
        oVar.amM = bzVar.getTid();
        oVar.mSource = bzVar.mRecomSource;
        oVar.myX = bzVar.eQw;
        oVar.myY = bzVar.mRecomWeight;
        oVar.mzb = bzVar.mRecomAbTag;
        if (bzVar.bnO() != null) {
            oVar.mzc = bzVar.bnO().video_md5;
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bz bzVar, AutoVideoCardViewHolder<bz> autoVideoCardViewHolder) {
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        if (this.jkJ != null) {
            int i2 = 0;
            if (this.jaa != null) {
                i2 = this.jaa.getTopThreadSize();
            }
            bzVar.eMg = (i + 1) - i2;
        }
        com.baidu.tieba.frs.b.c.cIR().a(this.jkJ, bzVar);
        com.baidu.tieba.frs.b.a.a(bzVar, this.mPageId, this.jkJ, getTbPageTag());
        bx bnd = bzVar.bnd();
        if (bnd != null) {
            String taskId = bnd.getTaskId();
            String bmT = bnd.bmT();
            if (StringUtils.isNull(bmT)) {
                bmT = bnd.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof as) {
                as asVar = (as) this.mPageContext.getOrignalPage();
                if (this.jlZ.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.c("frs", "VIEW_TRUE", asVar.getForumId(), asVar.getForumName(), bnd.getThreadId(), "tieba.baidu.com/p/" + bzVar.getTid(), bmT);
                }
            }
            aq aqVar = new aq("c13324");
            aqVar.w("fid", bzVar.getFid());
            aqVar.dW("tid", bzVar.getTid());
            aqVar.dW("obj_id", taskId);
            aqVar.an("thread_type", bzVar.getThreadType());
            TiebaStatic.log(aqVar);
        }
        if (bzVar != null) {
            bzVar.boL();
            if (bzVar.bnO() != null ? true : true) {
                autoVideoCardViewHolder.setVideoStatsData(ak(bzVar));
            }
            autoVideoCardViewHolder.tm().tg().bq(32);
            autoVideoCardViewHolder.b((AutoVideoCardViewHolder<bz>) bzVar);
            autoVideoCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.tm().a(this.hiF);
            com.baidu.tieba.frs.j.a(autoVideoCardViewHolder.tm().tg(), this.jaa);
        }
        return autoVideoCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        super.release();
        this.jlZ.clear();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
        this.jkI = i;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jkJ;
    }
}
