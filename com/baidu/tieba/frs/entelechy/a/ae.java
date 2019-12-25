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
/* loaded from: classes6.dex */
public class ae extends com.baidu.tieba.frs.h<bj, com.baidu.card.a<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String La;
    private boolean Nf;
    private com.baidu.tieba.card.z<bj> eHX;
    private NEGFeedBackView.a eIv;
    public boolean gqu;
    private int grd;
    private com.baidu.tieba.frs.d.b gre;
    private boolean grz;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ae(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.Nf = false;
        this.grz = false;
        this.grd = 3;
        this.gre = new com.baidu.tieba.frs.d.b();
        this.eHX = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (ae.this.giG != null) {
                        ae.this.giG.a(view, (View) bjVar, (Object) bj.cNl);
                    }
                    if ("c13010".equals(ae.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").Z("obj_type", 2).s("fid", bjVar.getFid()).cp("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, ae.this.mPageId, ae.this.gre, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, ae.this.mPageId, ae.this.gre, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, ae.this.mPageId, ae.this.gre, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, ae.this.mPageId, ae.this.gre, ae.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, ae.this.mPageId, ae.this.gre, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, ae.this.mPageId, ae.this.gre, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, ae.this.mPageId, ae.this.gre, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, ae.this.mPageId, ae.this.gre, ae.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, ae.this.mPageId, ae.this.gre, ae.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.bHd().a(ae.this.gre, bjVar, 1);
                        ae.this.al(bjVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bHd().a(ae.this.gre, bjVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(ae.this.gre, bjVar.axy());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bHd().a(ae.this.gre, bjVar, 4);
                        ae.this.al(bjVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ae.this.al(bjVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bHd().b(ae.this.gre, bjVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bHd().b(ae.this.gre, bjVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bHd().b(ae.this.gre, bjVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bHd().b(ae.this.gre, bjVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bHd().b(ae.this.gre, bjVar, 3);
                    }
                }
            }
        };
        this.eIv = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.ae.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(new an("c11973").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11974").cp("obj_locate", sb.toString()).cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("source", alVar.source).cp(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cp(TiebaInitialize.Params.AB_TAG, alVar.cLq).cp("extra", alVar.extra).Z("card_type", alVar.cardType).Z("obj_floor", alVar.cLr));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aH(4272);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.setFrom("frs");
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ae.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect aL = au.aL(gVar.getVideoContainer());
                    if (!(aVar2 instanceof bj)) {
                        au.a(aVar2, ae.this.mContext, ae.this.grd, false, aL);
                        return;
                    }
                    aVar2.objType = 5;
                    au.a(aVar2, ae.this.mContext, ae.this.grd, false, aL);
                }
            }
        });
        aVar.c(gVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.Nf);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJm = 2;
        dVar.cJn = 2;
        dVar.cJs = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.aV(this.grd);
        agVar.aH(16);
        if (this.grz) {
            agVar.aI(4);
        }
        aVar.b(agVar);
        aVar.mR().aN(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ad mS = aVar.mS();
        com.baidu.card.a aVar2 = new com.baidu.card.a(mS);
        aVar2.setPageId(this.mPageId);
        mS.a(this.eHX);
        mS.aM(this.grd);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.ae.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bj) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = (bj) mVar;
                    bjVar.objType = 1;
                    if (ae.this.eHX != null) {
                        ae.this.eHX.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), ae.this.grd, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar.mT().b(new a.C0050a(1));
                }
            }
        });
        aVar2.mU();
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
        if (aVar.mT().mN() instanceof ag) {
            ((ag) aVar.mT().mN()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.ae.5
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup, view, i));
                    }
                }
            });
        }
        if (aVar.mT() instanceof com.baidu.tieba.a.e) {
            aVar.mT().setPage(this.La);
        }
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) aVar);
        com.baidu.tieba.frs.g.a(aVar.mT().mN(), this.giA);
        aVar.setVideoStatsData(am(bjVar));
        if (this.giA != null && this.giA.getForum() != null && !StringUtils.isNull(this.giA.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.giA.getForum().getTopic_special_icon_right())) {
            bjVar.cg(this.giA.getForum().getTopic_special_icon(), this.giA.getForum().getTopic_special_icon_right());
        }
        boolean z = (bjVar.azE() == null || bjVar.azE().getUserId() == null || !bjVar.azE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bjVar.aAR() && bjVar.getFeedBackReasonMap() != null && !z) {
            aVar.ad(true).a(this.eIv);
        }
        if (!bjVar.isBjh()) {
            aVar.mV();
        }
        aVar.b((com.baidu.card.a) bjVar);
        aVar.mT().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.mT().a((com.baidu.tieba.card.z<T>) this.eHX);
        if (this.gre != null) {
            bjVar.cLr = (i + 1) - (this.giA != null ? this.giA.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bHd().a(this.gre, bjVar);
        com.baidu.tieba.frs.d.c.bHd().aq(bjVar);
        com.baidu.tieba.frs.d.c.bHd().a(bjVar, bAV());
        com.baidu.tieba.frs.d.a.a(bjVar, this.mPageId, this.gre, getTbPageTag());
        bjVar.aAO();
        return aVar.getView();
    }

    private com.baidu.tieba.play.y am(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bjVar.aAL() ? "3" : "2";
        if (this.gre.gDZ == 501) {
            yVar.mLocate = "frs_tab";
        }
        yVar.fGQ = this.gre.gDY;
        yVar.OC = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.jsi = bjVar.cPj;
        yVar.jsj = bjVar.mRecomWeight;
        yVar.mAbTag = bjVar.mRecomAbTag;
        if (bjVar.azV() != null) {
            yVar.jsl = bjVar.azV().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pm(int i) {
        this.grd = i;
    }

    @Override // com.baidu.tieba.a.f
    public void wq(String str) {
        this.La = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(bj bjVar) {
        TiebaStatic.log(new an("c12126").cp("tid", bjVar.getId()).Z("obj_locate", bAV() ? 2 : 1).s("obj_id", bjVar.azX() == null ? -1L : bjVar.azX().live_id).Z("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.y
    public void ke(boolean z) {
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bEr() {
        return this.gre;
    }

    public void lz(boolean z) {
        this.grz = z;
    }
}
