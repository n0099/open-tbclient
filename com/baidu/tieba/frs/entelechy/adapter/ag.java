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
    private boolean amh;
    private com.baidu.tieba.card.ab<cb> hoQ;
    private int jsm;
    private com.baidu.tieba.frs.b.b jsn;
    private Set<String> jtD;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jsm = 3;
        this.jsn = new com.baidu.tieba.frs.b.b();
        this.amh = false;
        this.hoQ = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 2, ag.this.mPageId, ag.this.jsn, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 5, ag.this.mPageId, ag.this.jsn, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 3, ag.this.mPageId, ag.this.jsn, ag.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 15, ag.this.mPageId, ag.this.jsn, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 14, ag.this.mPageId, ag.this.jsn, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 12, ag.this.mPageId, ag.this.jsn, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 13, ag.this.mPageId, ag.this.jsn, ag.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(cbVar, 1, ag.this.mPageId, ag.this.jsn, ag.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cKr().a(ag.this.jsn, cbVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (cbVar.boC() == 2 && cbVar.bny() != null) {
                            String bno = cbVar.bny().bno();
                            if (StringUtils.isNull(bno)) {
                                bno = cbVar.bny().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", String.valueOf(cbVar.getFid()), cbVar.bnW(), cbVar.bny().getThreadId(), "tieba.baidu.com/p/" + cbVar.bny().getThreadId(), bno);
                            String taskId = cbVar.bny().getTaskId();
                            ar arVar = new ar("c13329");
                            arVar.v("fid", cbVar.getFid());
                            arVar.dR("obj_id", taskId);
                            TiebaStatic.log(arVar);
                        }
                        com.baidu.tieba.frs.b.c.cKr().a(ag.this.jsn, cbVar, 1);
                    }
                }
            }
        };
        this.jtD = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.br(696);
        dVar.setPageUniqueId(this.mPageId);
        aVar.a(dVar);
        com.baidu.card.r rVar = new com.baidu.card.r(this.mPageContext.getPageActivity());
        rVar.setFromCDN(this.amh);
        aVar.c(rVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.amh);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = 2;
        eVar.eNH = 2;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(this.jsm);
        amVar.br(16);
        aVar.b(amVar);
        com.baidu.card.ak th = aVar.th();
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(th);
        autoVideoCardViewHolder.setPageId(this.mPageId);
        th.a(this.hoQ);
        th.setSourceForPb(this.jsm);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.ag.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof cb) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = (cb) nVar2;
                    cbVar.objType = 1;
                    if (ag.this.hoQ != null) {
                        ag.this.hoQ.a(threadCardViewHolder.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), ag.this.jsm, false);
                    threadCardViewHolder.tj().b(new a.C0095a(1));
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
        oVar.mLocate = cbVar.bpc() ? "3" : "2";
        oVar.fOD = this.jsn.jJj;
        oVar.anU = cbVar.getTid();
        oVar.mSource = cbVar.mRecomSource;
        oVar.mKz = cbVar.eUj;
        oVar.mKA = cbVar.mRecomWeight;
        oVar.mKD = cbVar.mRecomAbTag;
        if (cbVar.boj() != null) {
            oVar.mKE = cbVar.boj().video_md5;
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
        if (this.jsn != null) {
            int i2 = 0;
            if (this.jhD != null) {
                i2 = this.jhD.getTopThreadSize();
            }
            cbVar.ePT = (i + 1) - i2;
        }
        com.baidu.tieba.frs.b.c.cKr().a(this.jsn, cbVar);
        com.baidu.tieba.frs.b.a.a(cbVar, this.mPageId, this.jsn, getTbPageTag());
        bz bny = cbVar.bny();
        if (bny != null) {
            String taskId = bny.getTaskId();
            String bno = bny.bno();
            if (StringUtils.isNull(bno)) {
                bno = bny.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof as) {
                as asVar = (as) this.mPageContext.getOrignalPage();
                if (this.jtD.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.c("frs", "VIEW_TRUE", asVar.getForumId(), asVar.getForumName(), bny.getThreadId(), "tieba.baidu.com/p/" + cbVar.getTid(), bno);
                }
            }
            ar arVar = new ar("c13324");
            arVar.v("fid", cbVar.getFid());
            arVar.dR("tid", cbVar.getTid());
            arVar.dR("obj_id", taskId);
            arVar.aq("thread_type", cbVar.getThreadType());
            TiebaStatic.log(arVar);
        }
        if (cbVar != null) {
            cbVar.bpf();
            if (cbVar.boj() != null ? true : true) {
                autoVideoCardViewHolder.setVideoStatsData(al(cbVar));
            }
            autoVideoCardViewHolder.tj().td().br(32);
            autoVideoCardViewHolder.b((AutoVideoCardViewHolder<cb>) cbVar);
            autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.tj().a(this.hoQ);
            com.baidu.tieba.frs.j.a(autoVideoCardViewHolder.tj().td(), this.jhD);
        }
        return autoVideoCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        super.release();
        this.jtD.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uZ(int i) {
        this.jsm = i;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jsn;
    }
}
