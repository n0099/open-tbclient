package com.baidu.tieba.frs.entelechy.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
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
/* loaded from: classes22.dex */
public class aj extends com.baidu.tieba.frs.k<bw, com.baidu.card.a<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahu;
    private boolean akk;
    private NEGFeedBackView.a gMF;
    private com.baidu.tieba.card.ab<bw> gMe;
    public boolean iKo;
    private boolean iLK;
    private boolean iLL;
    private int iLn;
    private com.baidu.tieba.frs.d.b iLo;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public aj(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.akk = false;
        this.iLK = false;
        this.iLn = 3;
        this.iLo = new com.baidu.tieba.frs.d.b();
        this.gMe = new com.baidu.tieba.card.ab<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (aj.this.iAW != null) {
                        aj.this.iAW.a(view, (View) bwVar, (Object) bw.eyg);
                    }
                    if ("c13010".equals(aj.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").aj("obj_type", 2).w("fid", bwVar.getFid()).dR("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, aj.this.mPageId, aj.this.iLo, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, aj.this.mPageId, aj.this.iLo, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, aj.this.mPageId, aj.this.iLo, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, aj.this.mPageId, aj.this.iLo, aj.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, aj.this.mPageId, aj.this.iLo, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, aj.this.mPageId, aj.this.iLo, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, aj.this.mPageId, aj.this.iLo, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, aj.this.mPageId, aj.this.iLo, aj.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, aj.this.mPageId, aj.this.iLo, aj.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.cCo().a(aj.this.iLo, bwVar, 1);
                        aj.this.aq(bwVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cCo().a(aj.this.iLo, bwVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.j.a(aj.this.iLo, bwVar.bhA());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.cCo().a(aj.this.iLo, bwVar, 4);
                        aj.this.aq(bwVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        aj.this.aq(bwVar);
                    }
                }
            }
        };
        this.gMF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.aj.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                TiebaStatic.log(new aq("c11973").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new aq("c11974").dR("obj_locate", sb.toString()).dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("nid", arVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", arVar.source).dR("weight", arVar.weight).dR("ab_tag", arVar.abTag).dR("extra", arVar.extra).aj(IntentConfig.CARD_TYPE, arVar.cardType).aj("obj_floor", arVar.evR));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public com.baidu.card.a c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bo(4272);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        final com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFrom("frs");
        hVar.setStageType("2003");
        if (this.iLn == 502) {
            hVar.setNeedFrsTabName(false);
        } else {
            hVar.setNeedFrsTabName(true);
        }
        hVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.aj.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect bd = ay.bd(hVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, aj.this.mContext, aj.this.iLn, false, bd);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, aj.this.mContext, aj.this.iLn, false, bd);
                }
            }
        });
        aVar.c(hVar);
        if (this.iLL) {
            com.baidu.card.s sVar = new com.baidu.card.s(this.mPageContext.getPageActivity());
            sVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
            aVar.a((com.baidu.card.i) sVar);
        }
        com.baidu.card.ag agVar = new com.baidu.card.ag(this.mPageContext.getPageActivity());
        agVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.i) agVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        aaVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.i) aaVar);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.i) lVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akk);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.etA = 2;
        cVar.etB = 2;
        cVar.etG = 2;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(this.iLn);
        anVar.bo(16);
        if (this.iLK) {
            anVar.bp(4);
        }
        aVar.b(anVar);
        aVar.tU().bv(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak tV = aVar.tV();
        com.baidu.card.a aVar2 = new com.baidu.card.a(tV);
        aVar2.setPageId(this.mPageId);
        tV.a(this.gMe);
        tV.setSourceForPb(this.iLn);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.aj.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    bw bwVar = (bw) qVar;
                    bwVar.objType = 1;
                    if (aj.this.gMe != null) {
                        aj.this.gMe.a(amVar.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), aj.this.iLn, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar.tW().b(new a.C0097a(1));
                }
            }
        });
        aVar2.tX();
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
        if (aVar.tW().tQ() instanceof an) {
            ((an) aVar.tW().tQ()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.aj.5
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                    }
                }
            });
        }
        if (aVar.tW() instanceof com.baidu.tieba.a.e) {
            aVar.tW().setPage(this.ahu);
        }
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) aVar);
        com.baidu.tieba.frs.j.a(aVar.tW().tQ(), this.iAQ);
        aVar.setVideoStatsData(ai(bwVar));
        if (this.iAQ != null && this.iAQ.getForum() != null && !StringUtils.isNull(this.iAQ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iAQ.getForum().getTopic_special_icon_right())) {
            bwVar.dG(this.iAQ.getForum().getTopic_special_icon(), this.iAQ.getForum().getTopic_special_icon_right());
        }
        boolean z = (bwVar.bka() == null || bwVar.bka().getUserId() == null || !bwVar.bka().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bwVar.blp() && bwVar.getFeedBackReasonMap() != null && !z) {
            aVar.aL(true).a(this.gMF);
        }
        if (!bwVar.isBjh()) {
            aVar.tY();
        }
        aVar.b((com.baidu.card.a) bwVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a((com.baidu.tieba.card.ab<T>) this.gMe);
        if (this.iLo != null) {
            bwVar.evR = (i + 1) - (this.iAQ != null ? this.iAQ.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cCo().a(this.iLo, bwVar);
        com.baidu.tieba.frs.d.c.cCo().aw(bwVar);
        com.baidu.tieba.frs.d.c.cCo().a(bwVar, cvx());
        com.baidu.tieba.frs.d.a.a(bwVar, this.mPageId, this.iLo, getTbPageTag());
        bwVar.blm();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ai(bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bwVar.blj() ? "3" : "2";
        if (this.iLo.iZH == 501) {
            oVar.mLocate = "frs_tab";
        }
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

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uQ(int i) {
        this.iLn = i;
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dR("tid", bwVar.getId()).aj("obj_locate", cvx() ? 2 : 1).w("obj_id", bwVar.bku() == null ? -1L : bwVar.bku().live_id).aj("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void or(boolean z) {
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iLo;
    }

    public void pQ(boolean z) {
        this.iLK = z;
    }

    public void pR(boolean z) {
        this.iLL = z;
    }
}
