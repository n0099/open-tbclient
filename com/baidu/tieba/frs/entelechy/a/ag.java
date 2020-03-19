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
public class ag extends com.baidu.tieba.frs.h<bj, com.baidu.card.a<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String LC;
    private boolean NK;
    private com.baidu.tieba.card.z<bj> eNJ;
    private NEGFeedBackView.a eOk;
    public boolean gwz;
    private boolean gxH;
    private int gxk;
    private com.baidu.tieba.frs.d.b gxl;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.NK = false;
        this.gxH = false;
        this.gxk = 3;
        this.gxl = new com.baidu.tieba.frs.d.b();
        this.eNJ = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (ag.this.goP != null) {
                        ag.this.goP.a(view, (View) bjVar, (Object) bj.cRN);
                    }
                    if ("c13010".equals(ag.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").X("obj_type", 2).s("fid", bjVar.getFid()).cx("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, ag.this.mPageId, ag.this.gxl, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, ag.this.mPageId, ag.this.gxl, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, ag.this.mPageId, ag.this.gxl, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, ag.this.mPageId, ag.this.gxl, ag.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, ag.this.mPageId, ag.this.gxl, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, ag.this.mPageId, ag.this.gxl, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, ag.this.mPageId, ag.this.gxl, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, ag.this.mPageId, ag.this.gxl, ag.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, ag.this.mPageId, ag.this.gxl, ag.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.bJX().a(ag.this.gxl, bjVar, 1);
                        ag.this.ap(bjVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJX().a(ag.this.gxl, bjVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(ag.this.gxl, bjVar.aAk());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bJX().a(ag.this.gxl, bjVar, 4);
                        ag.this.ap(bjVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ag.this.ap(bjVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bJX().b(ag.this.gxl, bjVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJX().b(ag.this.gxl, bjVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bJX().b(ag.this.gxl, bjVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bJX().b(ag.this.gxl, bjVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bJX().b(ag.this.gxl, bjVar, 3);
                    }
                }
            }
        };
        this.eOk = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.ag.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(new an("c11973").cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11974").cx("obj_locate", sb.toString()).cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("source", alVar.source).cx(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cx(TiebaInitialize.Params.AB_TAG, alVar.cPS).cx("extra", alVar.extra).X("card_type", alVar.cardType).X("obj_floor", alVar.cPT));
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
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aK(4272);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.setFrom("frs");
        if (this.gxk == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ag.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect aP = au.aP(gVar.getVideoContainer());
                    if (!(aVar2 instanceof bj)) {
                        au.a(aVar2, ag.this.mContext, ag.this.gxk, false, aP);
                        return;
                    }
                    aVar2.objType = 5;
                    au.a(aVar2, ag.this.mContext, ag.this.gxk, false, aP);
                }
            }
        });
        aVar.c(gVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.NK);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        com.baidu.card.ag agVar = new com.baidu.card.ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = 2;
        dVar.cNQ = 2;
        dVar.cNV = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.aZ(this.gxk);
        agVar.aK(16);
        if (this.gxH) {
            agVar.aL(4);
        }
        aVar.b(agVar);
        aVar.ni().aR(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ad nj = aVar.nj();
        com.baidu.card.a aVar2 = new com.baidu.card.a(nj);
        aVar2.setPageId(this.mPageId);
        nj.a(this.eNJ);
        nj.aQ(this.gxk);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.ag.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bj) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = (bj) mVar;
                    bjVar.objType = 1;
                    if (ag.this.eNJ != null) {
                        ag.this.eNJ.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), ag.this.gxk, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
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
        if (aVar.nk().ne() instanceof com.baidu.card.ag) {
            ((com.baidu.card.ag) aVar.nk().ne()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.ag.5
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
        com.baidu.tieba.frs.g.a(aVar.nk().ne(), this.goJ);
        aVar.setVideoStatsData(aq(bjVar));
        if (this.goJ != null && this.goJ.getForum() != null && !StringUtils.isNull(this.goJ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.goJ.getForum().getTopic_special_icon_right())) {
            bjVar.co(this.goJ.getForum().getTopic_special_icon(), this.goJ.getForum().getTopic_special_icon_right());
        }
        boolean z = (bjVar.aCr() == null || bjVar.aCr().getUserId() == null || !bjVar.aCr().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bjVar.aDD() && bjVar.getFeedBackReasonMap() != null && !z) {
            aVar.ag(true).a(this.eOk);
        }
        if (!bjVar.isBjh()) {
            aVar.nm();
        }
        aVar.b((com.baidu.card.a) bjVar);
        aVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.nk().a((com.baidu.tieba.card.z<T>) this.eNJ);
        if (this.gxl != null) {
            bjVar.cPT = (i + 1) - (this.goJ != null ? this.goJ.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bJX().a(this.gxl, bjVar);
        com.baidu.tieba.frs.d.c.bJX().aw(bjVar);
        com.baidu.tieba.frs.d.c.bJX().a(bjVar, bDL());
        com.baidu.tieba.frs.d.a.a(bjVar, this.mPageId, this.gxl, getTbPageTag());
        bjVar.aDA();
        return aVar.getView();
    }

    private com.baidu.tieba.play.y aq(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bjVar.aDx() ? "3" : "2";
        if (this.gxl.gKG == 501) {
            yVar.mLocate = "frs_tab";
        }
        yVar.emF = this.gxl.gKF;
        yVar.Pk = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.jyr = bjVar.cTK;
        yVar.jys = bjVar.mRecomWeight;
        yVar.mAbTag = bjVar.mRecomAbTag;
        if (bjVar.aCI() != null) {
            yVar.jyv = bjVar.aCI().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pB(int i) {
        this.gxk = i;
    }

    @Override // com.baidu.tieba.a.f
    public void wQ(String str) {
        this.LC = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bj bjVar) {
        TiebaStatic.log(new an("c12126").cx("tid", bjVar.getId()).X("obj_locate", bDL() ? 2 : 1).s("obj_id", bjVar.aCK() == null ? -1L : bjVar.aCK().live_id).X("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.y
    public void kw(boolean z) {
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.NK = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bHn() {
        return this.gxl;
    }

    public void lS(boolean z) {
        this.gxH = z;
    }
}
