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
    private boolean alQ;
    private com.baidu.tieba.card.aa<bz> hnl;
    private int jpp;
    private com.baidu.tieba.frs.b.b jpq;
    private Set<String> jqG;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jpp = 3;
        this.jpq = new com.baidu.tieba.frs.b.b();
        this.alQ = false;
        this.hnl = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 2, ag.this.mPageId, ag.this.jpq, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 5, ag.this.mPageId, ag.this.jpq, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 3, ag.this.mPageId, ag.this.jpq, ag.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 15, ag.this.mPageId, ag.this.jpq, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 14, ag.this.mPageId, ag.this.jpq, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 12, ag.this.mPageId, ag.this.jpq, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 13, ag.this.mPageId, ag.this.jpq, ag.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(bzVar, 1, ag.this.mPageId, ag.this.jpq, ag.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cMJ().a(ag.this.jpq, bzVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (bzVar.bsc() == 2 && bzVar.bqX() != null) {
                            String bqN = bzVar.bqX().bqN();
                            if (StringUtils.isNull(bqN)) {
                                bqN = bzVar.bqX().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", String.valueOf(bzVar.getFid()), bzVar.brv(), bzVar.bqX().getThreadId(), "tieba.baidu.com/p/" + bzVar.bqX().getThreadId(), bqN);
                            String taskId = bzVar.bqX().getTaskId();
                            aq aqVar = new aq("c13329");
                            aqVar.w("fid", bzVar.getFid());
                            aqVar.dX("obj_id", taskId);
                            TiebaStatic.log(aqVar);
                        }
                        com.baidu.tieba.frs.b.c.cMJ().a(ag.this.jpq, bzVar, 1);
                    }
                }
            }
        };
        this.jqG = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bs(696);
        dVar.setPageUniqueId(this.mPageId);
        aVar.a(dVar);
        com.baidu.card.r rVar = new com.baidu.card.r(this.mPageContext.getPageActivity());
        rVar.setFromCDN(this.alQ);
        aVar.c(rVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alQ);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.eOz = 2;
        dVar2.eOF = 2;
        amVar.setAgreeStatisticData(dVar2);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(this.jpp);
        amVar.bs(16);
        aVar.b(amVar);
        com.baidu.card.ak tw = aVar.tw();
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(tw);
        autoVideoCardViewHolder.setPageId(this.mPageId);
        tw.a(this.hnl);
        tw.setSourceForPb(this.jpp);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.ag.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof bz) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = (bz) nVar2;
                    bzVar.objType = 1;
                    if (ag.this.hnl != null) {
                        ag.this.hnl.a(threadCardViewHolder.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), ag.this.jpp, false);
                    threadCardViewHolder.ty().b(new a.C0090a(1));
                }
            }
        });
        autoVideoCardViewHolder.tz();
        return autoVideoCardViewHolder;
    }

    private com.baidu.tieba.play.o ak(bz bzVar) {
        if (bzVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bzVar.bsC() ? "3" : "2";
        oVar.fPy = this.jpq.jGo;
        oVar.anD = bzVar.getTid();
        oVar.mSource = bzVar.mRecomSource;
        oVar.mDG = bzVar.eVh;
        oVar.mDH = bzVar.mRecomWeight;
        oVar.mDK = bzVar.mRecomAbTag;
        if (bzVar.brI() != null) {
            oVar.mDL = bzVar.brI().video_md5;
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
        if (this.jpq != null) {
            int i2 = 0;
            if (this.jeH != null) {
                i2 = this.jeH.getTopThreadSize();
            }
            bzVar.eQR = (i + 1) - i2;
        }
        com.baidu.tieba.frs.b.c.cMJ().a(this.jpq, bzVar);
        com.baidu.tieba.frs.b.a.a(bzVar, this.mPageId, this.jpq, getTbPageTag());
        bx bqX = bzVar.bqX();
        if (bqX != null) {
            String taskId = bqX.getTaskId();
            String bqN = bqX.bqN();
            if (StringUtils.isNull(bqN)) {
                bqN = bqX.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof as) {
                as asVar = (as) this.mPageContext.getOrignalPage();
                if (this.jqG.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.c("frs", "VIEW_TRUE", asVar.getForumId(), asVar.getForumName(), bqX.getThreadId(), "tieba.baidu.com/p/" + bzVar.getTid(), bqN);
                }
            }
            aq aqVar = new aq("c13324");
            aqVar.w("fid", bzVar.getFid());
            aqVar.dX("tid", bzVar.getTid());
            aqVar.dX("obj_id", taskId);
            aqVar.an("thread_type", bzVar.getThreadType());
            TiebaStatic.log(aqVar);
        }
        if (bzVar != null) {
            bzVar.bsF();
            if (bzVar.brI() != null ? true : true) {
                autoVideoCardViewHolder.setVideoStatsData(ak(bzVar));
            }
            autoVideoCardViewHolder.ty().ts().bs(32);
            autoVideoCardViewHolder.b((AutoVideoCardViewHolder<bz>) bzVar);
            autoVideoCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.ty().a(this.hnl);
            com.baidu.tieba.frs.j.a(autoVideoCardViewHolder.ty().ts(), this.jeH);
        }
        return autoVideoCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        super.release();
        this.jqG.clear();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
        this.jpp = i;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jpq;
    }
}
