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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.as;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class ag extends com.baidu.tieba.frs.k<cb, AutoVideoCardViewHolder<cb>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private boolean akO;
    private com.baidu.tieba.card.ab<cb> hmS;
    private int jqp;
    private com.baidu.tieba.frs.b.b jqq;
    private Set<String> jrG;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jqp = 3;
        this.jqq = new com.baidu.tieba.frs.b.b();
        this.akO = false;
        this.hmS = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 2, ag.this.mPageId, ag.this.jqq, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 5, ag.this.mPageId, ag.this.jqq, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 3, ag.this.mPageId, ag.this.jqq, ag.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 15, ag.this.mPageId, ag.this.jqq, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 14, ag.this.mPageId, ag.this.jqq, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 12, ag.this.mPageId, ag.this.jqq, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 13, ag.this.mPageId, ag.this.jqq, ag.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(cbVar, 1, ag.this.mPageId, ag.this.jqq, ag.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cKe().a(ag.this.jqq, cbVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (cbVar.boA() == 2 && cbVar.bnw() != null) {
                            String bnm = cbVar.bnw().bnm();
                            if (StringUtils.isNull(bnm)) {
                                bnm = cbVar.bnw().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", String.valueOf(cbVar.getFid()), cbVar.bnU(), cbVar.bnw().getThreadId(), "tieba.baidu.com/p/" + cbVar.bnw().getThreadId(), bnm);
                            String taskId = cbVar.bnw().getTaskId();
                            ar arVar = new ar("c13329");
                            arVar.v("fid", cbVar.getFid());
                            arVar.dR("obj_id", taskId);
                            TiebaStatic.log(arVar);
                        }
                        com.baidu.tieba.frs.b.c.cKe().a(ag.this.jqq, cbVar, 1);
                    }
                }
            }
        };
        this.jrG = new HashSet();
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
        rVar.setFromCDN(this.akO);
        aVar.c(rVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akO);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = 2;
        eVar.eMg = 2;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(this.jqp);
        amVar.bq(16);
        aVar.b(amVar);
        com.baidu.card.ak th = aVar.th();
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(th);
        autoVideoCardViewHolder.setPageId(this.mPageId);
        th.a(this.hmS);
        th.setSourceForPb(this.jqp);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.ag.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof cb) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = (cb) nVar2;
                    cbVar.objType = 1;
                    if (ag.this.hmS != null) {
                        ag.this.hmS.a(threadCardViewHolder.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), ag.this.jqp, false);
                    threadCardViewHolder.tj().b(new a.C0089a(1));
                }
            }
        });
        autoVideoCardViewHolder.tk();
        return autoVideoCardViewHolder;
    }

    private com.baidu.tieba.play.o al(cb cbVar) {
        if (cbVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = cbVar.bpa() ? "3" : "2";
        oVar.fNd = this.jqq.jHm;
        oVar.amC = cbVar.getTid();
        oVar.mSource = cbVar.mRecomSource;
        oVar.mIe = cbVar.eSI;
        oVar.mIf = cbVar.mRecomWeight;
        oVar.mIi = cbVar.mRecomAbTag;
        if (cbVar.boh() != null) {
            oVar.mIj = cbVar.boh().video_md5;
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cb cbVar, AutoVideoCardViewHolder<cb> autoVideoCardViewHolder) {
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        if (this.jqq != null) {
            int i2 = 0;
            if (this.jfG != null) {
                i2 = this.jfG.getTopThreadSize();
            }
            cbVar.eOs = (i + 1) - i2;
        }
        com.baidu.tieba.frs.b.c.cKe().a(this.jqq, cbVar);
        com.baidu.tieba.frs.b.a.a(cbVar, this.mPageId, this.jqq, getTbPageTag());
        bz bnw = cbVar.bnw();
        if (bnw != null) {
            String taskId = bnw.getTaskId();
            String bnm = bnw.bnm();
            if (StringUtils.isNull(bnm)) {
                bnm = bnw.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof as) {
                as asVar = (as) this.mPageContext.getOrignalPage();
                if (this.jrG.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.c("frs", "VIEW_TRUE", asVar.getForumId(), asVar.getForumName(), bnw.getThreadId(), "tieba.baidu.com/p/" + cbVar.getTid(), bnm);
                }
            }
            ar arVar = new ar("c13324");
            arVar.v("fid", cbVar.getFid());
            arVar.dR("tid", cbVar.getTid());
            arVar.dR("obj_id", taskId);
            arVar.ap("thread_type", cbVar.getThreadType());
            TiebaStatic.log(arVar);
        }
        if (cbVar != null) {
            cbVar.bpd();
            if (cbVar.boh() != null ? true : true) {
                autoVideoCardViewHolder.setVideoStatsData(al(cbVar));
            }
            autoVideoCardViewHolder.tj().td().bq(32);
            autoVideoCardViewHolder.b((AutoVideoCardViewHolder<cb>) cbVar);
            autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.tj().a(this.hmS);
            com.baidu.tieba.frs.j.a(autoVideoCardViewHolder.tj().td(), this.jfG);
        }
        return autoVideoCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        super.release();
        this.jrG.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
        this.jqp = i;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jqq;
    }
}
