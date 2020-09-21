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
/* loaded from: classes21.dex */
public class aj extends com.baidu.tieba.frs.k<bw, com.baidu.card.a<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahc;
    private boolean ajR;
    private com.baidu.tieba.card.aa<bw> glX;
    private NEGFeedBackView.a gmy;
    public boolean iiV;
    private int ijU;
    private com.baidu.tieba.frs.d.b ijV;
    private boolean ikr;
    private boolean iks;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public aj(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.ajR = false;
        this.ikr = false;
        this.ijU = 3;
        this.ijV = new com.baidu.tieba.frs.d.b();
        this.glX = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (aj.this.hZz != null) {
                        aj.this.hZz.a(view, (View) bwVar, (Object) bw.edC);
                    }
                    if ("c13010".equals(aj.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 2).u("fid", bwVar.getFid()).dF("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, aj.this.mPageId, aj.this.ijV, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, aj.this.mPageId, aj.this.ijV, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 4, aj.this.mPageId, aj.this.ijV, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, aj.this.mPageId, aj.this.ijV, aj.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, aj.this.mPageId, aj.this.ijV, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, aj.this.mPageId, aj.this.ijV, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, aj.this.mPageId, aj.this.ijV, aj.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, aj.this.mPageId, aj.this.ijV, aj.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, aj.this.mPageId, aj.this.ijV, aj.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.cvK().a(aj.this.ijV, bwVar, 1);
                        aj.this.aq(bwVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cvK().a(aj.this.ijV, bwVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.j.a(aj.this.ijV, bwVar.bcZ());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.cvK().a(aj.this.ijV, bwVar, 4);
                        aj.this.aq(bwVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        aj.this.aq(bwVar);
                    }
                }
            }
        };
        this.gmy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.aj.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                TiebaStatic.log(new aq("c11973").dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new aq("c11974").dF("obj_locate", sb.toString()).dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("nid", arVar.getNid()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("source", arVar.source).dF("weight", arVar.weight).dF("ab_tag", arVar.abTag).dF("extra", arVar.extra).ai(IntentConfig.CARD_TYPE, arVar.cardType).ai("obj_floor", arVar.ebp));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bo(4272);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        final com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFrom("frs");
        hVar.setStageType("2003");
        if (this.ijU == 502) {
            hVar.setNeedFrsTabName(false);
        } else {
            hVar.setNeedFrsTabName(true);
        }
        hVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.aj.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect ba = ay.ba(hVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, aj.this.mContext, aj.this.ijU, false, ba);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, aj.this.mContext, aj.this.ijU, false, ba);
                }
            }
        });
        aVar.c(hVar);
        if (this.iks) {
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
        nVar.setFromCDN(this.ajR);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 2;
        cVar.dYZ = 2;
        cVar.dZe = 2;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(this.ijU);
        anVar.bo(16);
        if (this.ikr) {
            anVar.bp(4);
        }
        aVar.b(anVar);
        aVar.tU().bv(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak tV = aVar.tV();
        com.baidu.card.a aVar2 = new com.baidu.card.a(tV);
        aVar2.setPageId(this.mPageId);
        tV.a(this.glX);
        tV.setSourceForPb(this.ijU);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.aj.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    bw bwVar = (bw) qVar;
                    bwVar.objType = 1;
                    if (aj.this.glX != null) {
                        aj.this.glX.a(amVar.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), aj.this.ijU, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar.tW().b(new a.C0096a(1));
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
            aVar.tW().setPage(this.ahc);
        }
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) aVar);
        com.baidu.tieba.frs.j.a(aVar.tW().tQ(), this.hZt);
        aVar.setVideoStatsData(ai(bwVar));
        if (this.hZt != null && this.hZt.getForum() != null && !StringUtils.isNull(this.hZt.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hZt.getForum().getTopic_special_icon_right())) {
            bwVar.du(this.hZt.getForum().getTopic_special_icon(), this.hZt.getForum().getTopic_special_icon_right());
        }
        boolean z = (bwVar.bfy() == null || bwVar.bfy().getUserId() == null || !bwVar.bfy().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bwVar.bgN() && bwVar.getFeedBackReasonMap() != null && !z) {
            aVar.aL(true).a(this.gmy);
        }
        if (!bwVar.isBjh()) {
            aVar.tY();
        }
        aVar.b((com.baidu.card.a) bwVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a((com.baidu.tieba.card.aa<T>) this.glX);
        if (this.ijV != null) {
            bwVar.ebp = (i + 1) - (this.hZt != null ? this.hZt.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cvK().a(this.ijV, bwVar);
        com.baidu.tieba.frs.d.c.cvK().aw(bwVar);
        com.baidu.tieba.frs.d.c.cvK().a(bwVar, coS());
        com.baidu.tieba.frs.d.a.a(bwVar, this.mPageId, this.ijV, getTbPageTag());
        bwVar.bgK();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ai(bw bwVar) {
        if (bwVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bwVar.bgH() ? "3" : "2";
        if (this.ijV.iys == 501) {
            oVar.mLocate = "frs_tab";
        }
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

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
        this.ijU = i;
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dF("tid", bwVar.getId()).ai("obj_locate", coS() ? 2 : 1).u("obj_id", bwVar.bfS() == null ? -1L : bwVar.bfS().live_id).ai("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.z
    public void nu(boolean z) {
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.ijV;
    }

    public void oT(boolean z) {
        this.ikr = z;
    }

    public void oU(boolean z) {
        this.iks = z;
    }
}
