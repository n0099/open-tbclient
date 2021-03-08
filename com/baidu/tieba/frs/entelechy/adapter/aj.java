package com.baidu.tieba.frs.entelechy.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class aj extends com.baidu.tieba.frs.k<cb, AutoVideoCardViewHolder<cb>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String ajx;
    private boolean amh;
    private com.baidu.tieba.card.ab<cb> hoQ;
    private NEGFeedBackView.a hpr;
    public boolean jre;
    private boolean jsE;
    private boolean jsF;
    private int jsm;
    private com.baidu.tieba.frs.b.b jsn;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public aj(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.amh = false;
        this.jsE = false;
        this.jsm = 3;
        this.jsn = new com.baidu.tieba.frs.b.b();
        this.hoQ = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if (aj.this.jhJ != null) {
                        aj.this.jhJ.a(view, (View) cbVar, (Object) cb.eSl);
                    }
                    if ("c13010".equals(aj.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").aq("obj_type", 2).v("fid", cbVar.getFid()).dR("tid", cbVar.getTid()));
                    }
                    if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 4, aj.this.mPageId, aj.this.jsn, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 2, aj.this.mPageId, aj.this.jsn, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 4, aj.this.mPageId, aj.this.jsn, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 5, aj.this.mPageId, aj.this.jsn, aj.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 15, aj.this.mPageId, aj.this.jsn, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 14, aj.this.mPageId, aj.this.jsn, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 12, aj.this.mPageId, aj.this.jsn, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 13, aj.this.mPageId, aj.this.jsn, aj.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(cbVar, 1, aj.this.mPageId, aj.this.jsn, aj.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.b.c.cKr().a(aj.this.jsn, cbVar, 1);
                        aj.this.as(cbVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).aq("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cKr().a(aj.this.jsn, cbVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.d.k.a(aj.this.jsn, cbVar.blq());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.b.c.cKr().a(aj.this.jsn, cbVar, 4);
                        aj.this.as(cbVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        aj.this.as(cbVar);
                    }
                }
            }
        };
        this.hpr = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.aj.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(av avVar) {
                TiebaStatic.log(new ar("c11973").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
                if (arrayList != null && avVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + ",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ar("c11974").dR("obj_locate", sb.toString()).dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmq()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", avVar.source).dR("weight", avVar.weight).dR("ab_tag", avVar.abTag).dR("extra", avVar.extra).aq(IntentConfig.CARD_TYPE, avVar.cardType).aq("obj_floor", avVar.ePT));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.br(4272);
        dVar.setPageUniqueId(this.mPageId);
        aVar.a(dVar);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.setFrom("frs");
        gVar.setStageType("2003");
        if (this.jsm == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        gVar.a(new a.InterfaceC0094a() { // from class: com.baidu.tieba.frs.entelechy.adapter.aj.3
            @Override // com.baidu.card.a.InterfaceC0094a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bs = az.bs(gVar.getVideoContainer());
                    if (!(aVar2 instanceof cb)) {
                        az.a(aVar2, aj.this.mContext, aj.this.jsm, false, bs);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, aj.this.mContext, aj.this.jsm, false, bs);
                }
            }
        });
        aVar.c(gVar);
        if (this.jsF) {
            aVar.a((com.baidu.card.h) new com.baidu.card.s(this.mPageContext.getPageActivity()));
        }
        aVar.a((com.baidu.card.h) new com.baidu.card.ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.l(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.amh);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = 2;
        eVar.eNC = 2;
        eVar.eNH = 2;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(this.jsm);
        amVar.br(48);
        if (this.jsE) {
            amVar.bs(4);
        }
        aVar.b(amVar);
        aVar.ti().by(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak th = aVar.th();
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(th);
        autoVideoCardViewHolder.setPageId(this.mPageId);
        th.a(this.hoQ);
        th.setSourceForPb(this.jsm);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.aj.4
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof cb) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = (cb) nVar2;
                    cbVar.objType = 1;
                    if (aj.this.hoQ != null) {
                        aj.this.hoQ.a(threadCardViewHolder.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), aj.this.jsm, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder.tj().b(new a.C0095a(1));
                }
            }
        });
        autoVideoCardViewHolder.tk();
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, cb cbVar, AutoVideoCardViewHolder autoVideoCardViewHolder) {
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        if (cbVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder.tj().td() instanceof am) {
            ((am) autoVideoCardViewHolder.tj().td()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.aj.5
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup, view, i));
                    }
                }
            });
        }
        if (autoVideoCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            autoVideoCardViewHolder.tj().setPage(this.ajx);
        }
        super.a(i, view, viewGroup, (ViewGroup) cbVar, (cb) autoVideoCardViewHolder);
        com.baidu.tieba.frs.j.a(autoVideoCardViewHolder.tj().td(), this.jhD);
        autoVideoCardViewHolder.setVideoStatsData(al(cbVar));
        if (this.jhD != null && this.jhD.getForum() != null && !StringUtils.isNull(this.jhD.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jhD.getForum().getTopic_special_icon_right())) {
            cbVar.dD(this.jhD.getForum().getTopic_special_icon(), this.jhD.getForum().getTopic_special_icon_right());
        }
        boolean z = (cbVar.bnS() == null || cbVar.bnS().getUserId() == null || !cbVar.bnS().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (cbVar.bpj() && cbVar.getFeedBackReasonMap() != null && !z) {
            autoVideoCardViewHolder.aK(true).a(this.hpr);
        }
        if (!cbVar.isBjh()) {
            autoVideoCardViewHolder.tl();
        }
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder) cbVar);
        autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tj().a((com.baidu.tieba.card.ab<T>) this.hoQ);
        if (this.jsn != null) {
            cbVar.ePT = (i + 1) - (this.jhD != null ? this.jhD.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.b.c.cKr().a(this.jsn, cbVar);
        com.baidu.tieba.frs.b.c.cKr().az(cbVar);
        com.baidu.tieba.frs.b.c.cKr().a(cbVar, cCt());
        com.baidu.tieba.frs.b.a.a(cbVar, this.mPageId, this.jsn, getTbPageTag());
        cbVar.bpf();
        return autoVideoCardViewHolder.getView();
    }

    private com.baidu.tieba.play.o al(cb cbVar) {
        if (cbVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = cbVar.bpc() ? "3" : "2";
        if (this.jsn.jJk == 501) {
            oVar.mLocate = "frs_tab";
        }
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

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uZ(int i) {
        this.jsm = i;
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(cb cbVar) {
        TiebaStatic.log(new ar("c12126").dR("tid", cbVar.getId()).aq("obj_locate", cCt() ? 2 : 1).v("obj_id", cbVar.bol() == null ? -1L : cbVar.bol().live_id).aq("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void pD(boolean z) {
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jsn;
    }

    public void rd(boolean z) {
        this.jsE = z;
    }

    public void re(boolean z) {
        this.jsF = z;
    }
}
