package com.baidu.tieba.frs.entelechy.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.ag;
import com.baidu.card.b;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class ae extends com.baidu.tieba.frs.h<bj, com.baidu.card.a<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String LC;
    private boolean NJ;
    private NEGFeedBackView.a eNM;
    private com.baidu.tieba.card.z<bj> eNp;
    public boolean gvS;
    private int gwB;
    private com.baidu.tieba.frs.d.b gwC;
    private boolean gwX;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ae(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.NJ = false;
        this.gwX = false;
        this.gwB = 3;
        this.gwC = new com.baidu.tieba.frs.d.b();
        this.eNp = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (ae.this.gof != null) {
                        ae.this.gof.a(view, (View) bjVar, (Object) bj.cRA);
                    }
                    if ("c13010".equals(ae.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").X("obj_type", 2).s("fid", bjVar.getFid()).cy("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, ae.this.mPageId, ae.this.gwC, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, ae.this.mPageId, ae.this.gwC, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, ae.this.mPageId, ae.this.gwC, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, ae.this.mPageId, ae.this.gwC, ae.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, ae.this.mPageId, ae.this.gwC, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, ae.this.mPageId, ae.this.gwC, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, ae.this.mPageId, ae.this.gwC, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, ae.this.mPageId, ae.this.gwC, ae.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, ae.this.mPageId, ae.this.gwC, ae.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.bJK().a(ae.this.gwC, bjVar, 1);
                        ae.this.ao(bjVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJK().a(ae.this.gwC, bjVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(ae.this.gwC, bjVar.aAh());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bJK().a(ae.this.gwC, bjVar, 4);
                        ae.this.ao(bjVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ae.this.ao(bjVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bJK().b(ae.this.gwC, bjVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJK().b(ae.this.gwC, bjVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bJK().b(ae.this.gwC, bjVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bJK().b(ae.this.gwC, bjVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bJK().b(ae.this.gwC, bjVar, 3);
                    }
                }
            }
        };
        this.eNM = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.ae.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(new an("c11973").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, al alVar) {
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11974").cy("obj_locate", sb.toString()).cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("source", alVar.source).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cy(TiebaInitialize.Params.AB_TAG, alVar.cPF).cy("extra", alVar.extra).X("card_type", alVar.cardType).X("obj_floor", alVar.cPG));
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
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aK(4272);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.setFrom("frs");
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ae.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect aP = au.aP(gVar.getVideoContainer());
                    if (!(aVar2 instanceof bj)) {
                        au.a(aVar2, ae.this.mContext, ae.this.gwB, false, aP);
                        return;
                    }
                    aVar2.objType = 5;
                    au.a(aVar2, ae.this.mContext, ae.this.gwB, false, aP);
                }
            }
        });
        aVar.c(gVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.NJ);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNC = 2;
        dVar.cND = 2;
        dVar.cNI = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.aZ(this.gwB);
        agVar.aK(16);
        if (this.gwX) {
            agVar.aL(4);
        }
        aVar.b(agVar);
        aVar.ni().aR(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ad nj = aVar.nj();
        com.baidu.card.a aVar2 = new com.baidu.card.a(nj);
        aVar2.setPageId(this.mPageId);
        nj.a(this.eNp);
        nj.aQ(this.gwB);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.ae.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bj) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = (bj) mVar;
                    bjVar.objType = 1;
                    if (ae.this.eNp != null) {
                        ae.this.eNp.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), ae.this.gwB, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar.nk().b(new a.C0052a(1));
                }
            }
        });
        aVar2.nl();
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, bj bjVar, com.baidu.card.a aVar) {
        if (aVar == null) {
            return null;
        }
        if (bjVar == null) {
            return aVar.getView();
        }
        if (aVar.nk().ne() instanceof ag) {
            ((ag) aVar.nk().ne()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.ae.5
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup, view, i));
                    }
                }
            });
        }
        if (aVar.nk() instanceof com.baidu.tieba.a.e) {
            aVar.nk().setPage(this.LC);
        }
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) aVar);
        com.baidu.tieba.frs.g.a(aVar.nk().ne(), this.gnZ);
        aVar.setVideoStatsData(ap(bjVar));
        if (this.gnZ != null && this.gnZ.getForum() != null && !StringUtils.isNull(this.gnZ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.gnZ.getForum().getTopic_special_icon_right())) {
            bjVar.cp(this.gnZ.getForum().getTopic_special_icon(), this.gnZ.getForum().getTopic_special_icon_right());
        }
        boolean z = (bjVar.aCo() == null || bjVar.aCo().getUserId() == null || !bjVar.aCo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bjVar.aDz() && bjVar.getFeedBackReasonMap() != null && !z) {
            aVar.ag(true).a(this.eNM);
        }
        if (!bjVar.isBjh()) {
            aVar.nm();
        }
        aVar.b((com.baidu.card.a) bjVar);
        aVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.nk().a((com.baidu.tieba.card.z<T>) this.eNp);
        if (this.gwC != null) {
            bjVar.cPG = (i + 1) - (this.gnZ != null ? this.gnZ.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bJK().a(this.gwC, bjVar);
        com.baidu.tieba.frs.d.c.bJK().av(bjVar);
        com.baidu.tieba.frs.d.c.bJK().a(bjVar, bDD());
        com.baidu.tieba.frs.d.a.a(bjVar, this.mPageId, this.gwC, getTbPageTag());
        bjVar.aDw();
        return aVar.getView();
    }

    private com.baidu.tieba.play.y ap(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bjVar.aDt() ? "3" : "2";
        if (this.gwC.gJB == 501) {
            yVar.mLocate = "frs_tab";
        }
        yVar.emo = this.gwC.gJA;
        yVar.Pj = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.jwS = bjVar.cTx;
        yVar.jwT = bjVar.mRecomWeight;
        yVar.mAbTag = bjVar.mRecomAbTag;
        if (bjVar.aCF() != null) {
            yVar.jwW = bjVar.aCF().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
        this.gwB = i;
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(bj bjVar) {
        TiebaStatic.log(new an("c12126").cy("tid", bjVar.getId()).X("obj_locate", bDD() ? 2 : 1).s("obj_id", bjVar.aCH() == null ? -1L : bjVar.aCH().live_id).X("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.y
    public void kr(boolean z) {
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bGY() {
        return this.gwC;
    }

    public void lN(boolean z) {
        this.gwX = z;
    }
}
