package com.baidu.tieba.frs.entelechy.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class aj extends com.baidu.tieba.frs.j<bv, com.baidu.card.a<bv>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String afx;
    private boolean aib;
    private com.baidu.tieba.card.aa<bv> fWN;
    private NEGFeedBackView.a fXo;
    public boolean hNG;
    private int hOF;
    private com.baidu.tieba.frs.d.b hOG;
    private boolean hPc;
    private boolean hPd;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public aj(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aib = false;
        this.hPc = false;
        this.hOF = 3;
        this.hOG = new com.baidu.tieba.frs.d.b();
        this.fWN = new com.baidu.tieba.card.aa<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    if (aj.this.hFd != null) {
                        aj.this.hFd.a(view, (View) bvVar, (Object) bv.dRS);
                    }
                    if ("c13010".equals(aj.this.mFrom)) {
                        TiebaStatic.log(new ap("c13010").ah("obj_type", 2).t("fid", bvVar.getFid()).dn("tid", bvVar.getTid()));
                    }
                    if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 4, aj.this.mPageId, aj.this.hOG, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 2, aj.this.mPageId, aj.this.hOG, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 4, aj.this.mPageId, aj.this.hOG, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 5, aj.this.mPageId, aj.this.hOG, aj.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 15, aj.this.mPageId, aj.this.hOG, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 14, aj.this.mPageId, aj.this.hOG, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 12, aj.this.mPageId, aj.this.hOG, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 13, aj.this.mPageId, aj.this.hOG, aj.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bvVar, 1, aj.this.mPageId, aj.this.hOG, aj.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.chQ().a(aj.this.hOG, bvVar, 1);
                        aj.this.ap(bvVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.chQ().a(aj.this.hOG, bvVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(aj.this.hOG, bvVar.aTO());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.chQ().a(aj.this.hOG, bvVar, 4);
                        aj.this.ap(bvVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        aj.this.ap(bvVar);
                    }
                }
            }
        };
        this.fXo = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.aj.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aq aqVar) {
                TiebaStatic.log(new ap("c11973").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
                if (arrayList != null && aqVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ap("c11974").dn("obj_locate", sb.toString()).dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("nid", aqVar.getNid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("source", aqVar.source).dn("weight", aqVar.weight).dn("ab_tag", aqVar.abTag).dn("extra", aqVar.extra).ah(IntentConfig.CARD_TYPE, aqVar.cardType).ah("obj_floor", aqVar.dPI));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bf(4272);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.setFrom("frs");
        if (this.hOF == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.aj.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aW = ax.aW(gVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bv)) {
                        ax.a(absThreadDataSupport, aj.this.mContext, aj.this.hOF, false, aW);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ax.a(absThreadDataSupport, aj.this.mContext, aj.this.hOF, false, aW);
                }
            }
        });
        aVar.c(gVar);
        if (this.hPd) {
            com.baidu.card.q qVar = new com.baidu.card.q(this.mPageContext.getPageActivity());
            qVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
            aVar.a((com.baidu.card.h) qVar);
        }
        as asVar = new as(this.mPageContext.getPageActivity());
        asVar.setPageContext(this.mPageContext);
        asVar.setFromForPb(3);
        asVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
        aVar.a((com.baidu.card.h) asVar);
        com.baidu.card.ae aeVar = new com.baidu.card.ae(this.mPageContext.getPageActivity());
        aeVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) aeVar);
        com.baidu.card.y yVar = new com.baidu.card.y(this.mPageContext.getPageActivity());
        yVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) yVar);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aib);
        lVar.setForm("frs");
        aVar.a((com.baidu.card.h) lVar);
        com.baidu.card.al alVar = new com.baidu.card.al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 2;
        cVar.dNC = 2;
        cVar.dNH = 2;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(2);
        alVar.setShareReportFrom(1);
        alVar.setFromForPb(this.hOF);
        alVar.bf(16);
        if (this.hPc) {
            alVar.bg(4);
        }
        aVar.b(alVar);
        aVar.se().bm(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ai sf = aVar.sf();
        com.baidu.card.a aVar2 = new com.baidu.card.a(sf);
        aVar2.setPageId(this.mPageId);
        sf.a(this.fWN);
        sf.setSourceForPb(this.hOF);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.aj.4
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar2 instanceof bv) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar = (com.baidu.card.ak) view.getTag();
                    bv bvVar = (bv) qVar2;
                    bvVar.objType = 1;
                    if (aj.this.fWN != null) {
                        aj.this.fWN.a(akVar.getView(), bvVar);
                    }
                    ax.a((AbsThreadDataSupport) bvVar, view.getContext(), aj.this.hOF, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    akVar.sg().b(new a.C0096a(1));
                }
            }
        });
        aVar2.sh();
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, bv bvVar, com.baidu.card.a aVar) {
        if (aVar == null) {
            return null;
        }
        if (bvVar == null) {
            return aVar.getView();
        }
        if (aVar.sg().sa() instanceof com.baidu.card.al) {
            ((com.baidu.card.al) aVar.sg().sa()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.aj.5
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                    }
                }
            });
        }
        if (aVar.sg() instanceof com.baidu.tieba.a.e) {
            aVar.sg().setPage(this.afx);
        }
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) aVar);
        com.baidu.tieba.frs.i.a(aVar.sg().sa(), this.hEX);
        aVar.setVideoStatsData(ah(bvVar));
        if (this.hEX != null && this.hEX.getForum() != null && !StringUtils.isNull(this.hEX.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hEX.getForum().getTopic_special_icon_right())) {
            bvVar.de(this.hEX.getForum().getTopic_special_icon(), this.hEX.getForum().getTopic_special_icon_right());
        }
        boolean z = (bvVar.aWl() == null || bvVar.aWl().getUserId() == null || !bvVar.aWl().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bvVar.aXA() && bvVar.getFeedBackReasonMap() != null && !z) {
            aVar.aK(true).a(this.fXo);
        }
        if (!bvVar.isBjh()) {
            aVar.si();
        }
        aVar.b((com.baidu.card.a) bvVar);
        aVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.sg().a((com.baidu.tieba.card.aa<T>) this.fWN);
        if (this.hOG != null) {
            bvVar.dPI = (i + 1) - (this.hEX != null ? this.hEX.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.chQ().a(this.hOG, bvVar);
        com.baidu.tieba.frs.d.c.chQ().av(bvVar);
        com.baidu.tieba.frs.d.c.chQ().a(bvVar, cbj());
        com.baidu.tieba.frs.d.a.a(bvVar, this.mPageId, this.hOG, getTbPageTag());
        bvVar.aXx();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ah(bv bvVar) {
        if (bvVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bvVar.aXu() ? "3" : "2";
        if (this.hOG.icP == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.eKO = this.hOG.icO;
        oVar.ajJ = bvVar.getTid();
        oVar.mSource = bvVar.mRecomSource;
        oVar.lcJ = bvVar.dTO;
        oVar.lcK = bvVar.mRecomWeight;
        oVar.lcN = bvVar.mRecomAbTag;
        if (bvVar.aWD() != null) {
            oVar.lcO = bvVar.aWD().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
        this.hOF = i;
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bv bvVar) {
        TiebaStatic.log(new ap("c12126").dn("tid", bvVar.getId()).ah("obj_locate", cbj() ? 2 : 1).t("obj_id", bvVar.aWF() == null ? -1L : bvVar.aWF().live_id).ah("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.z
    public void mJ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.j
    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hOG;
    }

    public void oh(boolean z) {
        this.hPc = z;
    }

    public void oi(boolean z) {
        this.hPd = z;
    }
}
