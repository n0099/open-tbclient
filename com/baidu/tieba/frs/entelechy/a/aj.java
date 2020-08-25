package com.baidu.tieba.frs.entelechy.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.am;
import com.baidu.card.b;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class aj extends com.baidu.tieba.frs.k<bw, com.baidu.card.a<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String agH;
    private boolean ajr;
    private com.baidu.tieba.card.aa<bw> giM;
    private NEGFeedBackView.a gjn;
    public boolean ibL;
    private int icK;
    private com.baidu.tieba.frs.d.b icL;
    private boolean idh;
    private boolean idi;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public aj(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ajr = false;
        this.idh = false;
        this.icK = 3;
        this.icL = new com.baidu.tieba.frs.d.b();
        this.giM = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (aj.this.hSt != null) {
                        aj.this.hSt.a(view, (View) bwVar, (Object) bw.ebo);
                    }
                    if ("c13010".equals(aj.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 2).u("fid", bwVar.getFid()).dD("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, aj.this.mPageId, aj.this.icL, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, aj.this.mPageId, aj.this.icL, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, aj.this.mPageId, aj.this.icL, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, aj.this.mPageId, aj.this.icL, aj.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, aj.this.mPageId, aj.this.icL, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, aj.this.mPageId, aj.this.icL, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, aj.this.mPageId, aj.this.icL, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, aj.this.mPageId, aj.this.icL, aj.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, aj.this.mPageId, aj.this.icL, aj.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.csu().a(aj.this.icL, bwVar, 1);
                        aj.this.ap(bwVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.csu().a(aj.this.icL, bwVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(aj.this.icL, bwVar.bcf());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.csu().a(aj.this.icL, bwVar, 4);
                        aj.this.ap(bwVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        aj.this.ap(bwVar);
                    }
                }
            }
        };
        this.gjn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.aj.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                TiebaStatic.log(new aq("c11973").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, ar arVar) {
                if (arrayList != null && arVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new aq("c11974").dD("obj_locate", sb.toString()).dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("nid", arVar.getNid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("source", arVar.source).dD("weight", arVar.weight).dD("ab_tag", arVar.abTag).dD("extra", arVar.extra).ai(IntentConfig.CARD_TYPE, arVar.cardType).ai("obj_floor", arVar.dZb));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bk(4272);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.setFrom("frs");
        gVar.setStageType("2003");
        if (this.icK == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.aj.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aY = ay.aY(gVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, aj.this.mContext, aj.this.icK, false, aY);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, aj.this.mContext, aj.this.icK, false, aY);
                }
            }
        });
        aVar.c(gVar);
        if (this.idi) {
            com.baidu.card.r rVar = new com.baidu.card.r(this.mPageContext.getPageActivity());
            rVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
            aVar.a((com.baidu.card.h) rVar);
        }
        com.baidu.card.af afVar = new com.baidu.card.af(this.mPageContext.getPageActivity());
        afVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) afVar);
        com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext.getPageActivity());
        zVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) zVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) kVar);
        com.baidu.card.m mVar = new com.baidu.card.m(this.mPageContext.getPageActivity());
        mVar.setFromCDN(this.ajr);
        mVar.setForm("frs");
        aVar.a((com.baidu.card.h) mVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 2;
        cVar.dWL = 2;
        cVar.dWQ = 2;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(this.icK);
        amVar.bk(16);
        if (this.idh) {
            amVar.bl(4);
        }
        aVar.b(amVar);
        aVar.tP().br(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.aj tQ = aVar.tQ();
        com.baidu.card.a aVar2 = new com.baidu.card.a(tQ);
        aVar2.setPageId(this.mPageId);
        tQ.a(this.giM);
        tQ.setSourceForPb(this.icK);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.aj.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof com.baidu.card.al)) {
                    com.baidu.card.al alVar = (com.baidu.card.al) view.getTag();
                    bw bwVar = (bw) qVar;
                    bwVar.objType = 1;
                    if (aj.this.giM != null) {
                        aj.this.giM.a(alVar.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), aj.this.icK, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    alVar.tR().b(new a.C0095a(1));
                }
            }
        });
        aVar2.tS();
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, bw bwVar, com.baidu.card.a aVar) {
        if (aVar == null) {
            return null;
        }
        if (bwVar == null) {
            return aVar.getView();
        }
        if (aVar.tR().tL() instanceof am) {
            ((am) aVar.tR().tL()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.aj.5
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                    }
                }
            });
        }
        if (aVar.tR() instanceof com.baidu.tieba.a.e) {
            aVar.tR().setPage(this.agH);
        }
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) aVar);
        com.baidu.tieba.frs.j.a(aVar.tR().tL(), this.hSn);
        aVar.setVideoStatsData(ah(bwVar));
        if (this.hSn != null && this.hSn.getForum() != null && !StringUtils.isNull(this.hSn.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hSn.getForum().getTopic_special_icon_right())) {
            bwVar.du(this.hSn.getForum().getTopic_special_icon(), this.hSn.getForum().getTopic_special_icon_right());
        }
        boolean z = (bwVar.beE() == null || bwVar.beE().getUserId() == null || !bwVar.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bwVar.bfT() && bwVar.getFeedBackReasonMap() != null && !z) {
            aVar.aL(true).a(this.gjn);
        }
        if (!bwVar.isBjh()) {
            aVar.tT();
        }
        aVar.b((com.baidu.card.a) bwVar);
        aVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tR().a((com.baidu.tieba.card.aa<T>) this.giM);
        if (this.icL != null) {
            bwVar.dZb = (i + 1) - (this.hSn != null ? this.hSn.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.csu().a(this.icL, bwVar);
        com.baidu.tieba.frs.d.c.csu().av(bwVar);
        com.baidu.tieba.frs.d.c.csu().a(bwVar, clF());
        com.baidu.tieba.frs.d.a.a(bwVar, this.mPageId, this.icL, getTbPageTag());
        bwVar.bfQ();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ah(bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bwVar.bfN() ? "3" : "2";
        if (this.icL.iqW == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.eVt = this.icL.iqV;
        oVar.akY = bwVar.getTid();
        oVar.mSource = bwVar.mRecomSource;
        oVar.ltc = bwVar.edk;
        oVar.ltd = bwVar.mRecomWeight;
        oVar.ltg = bwVar.mRecomAbTag;
        if (bwVar.beW() != null) {
            oVar.lth = bwVar.beW().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.icK = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dD("tid", bwVar.getId()).ai("obj_locate", clF() ? 2 : 1).u("obj_id", bwVar.beY() == null ? -1L : bwVar.beY().live_id).ai("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.z
    public void nm(boolean z) {
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.icL;
    }

    public void oL(boolean z) {
        this.idh = z;
    }

    public void oM(boolean z) {
        this.idi = z;
    }
}
