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
    private String aeB;
    private boolean agw;
    private NEGFeedBackView.a fsJ;
    private com.baidu.tieba.card.z<bj> fsi;
    public boolean hfQ;
    private int hgL;
    private com.baidu.tieba.frs.d.b hgM;
    private boolean hhi;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.agw = false;
        this.hhi = false;
        this.hgL = 3;
        this.hgM = new com.baidu.tieba.frs.d.b();
        this.fsi = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (ag.this.gYa != null) {
                        ag.this.gYa.a(view, (View) bjVar, (Object) bj.dqZ);
                    }
                    if ("c13010".equals(ag.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").af("obj_type", 2).t("fid", bjVar.getFid()).cI("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, ag.this.mPageId, ag.this.hgM, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, ag.this.mPageId, ag.this.hgM, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, ag.this.mPageId, ag.this.hgM, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, ag.this.mPageId, ag.this.hgM, ag.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, ag.this.mPageId, ag.this.hgM, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, ag.this.mPageId, ag.this.hgM, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, ag.this.mPageId, ag.this.hgM, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, ag.this.mPageId, ag.this.hgM, ag.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, ag.this.mPageId, ag.this.hgM, ag.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.bUs().a(ag.this.hgM, bjVar, 1);
                        ag.this.ar(bjVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bUs().a(ag.this.hgM, bjVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(ag.this.hgM, bjVar.aIv());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bUs().a(ag.this.hgM, bjVar, 4);
                        ag.this.ar(bjVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ag.this.ar(bjVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bUs().b(ag.this.hgM, bjVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bUs().b(ag.this.hgM, bjVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bUs().b(ag.this.hgM, bjVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bUs().b(ag.this.hgM, bjVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bUs().b(ag.this.hgM, bjVar, 3);
                    }
                }
            }
        };
        this.fsJ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.ag.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(new an("c11973").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11974").cI("obj_locate", sb.toString()).cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("source", alVar.source).cI(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cI(TiebaInitialize.Params.AB_TAG, alVar.dpc).cI("extra", alVar.extra).af("card_type", alVar.cardType).af("obj_floor", alVar.dpd));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aW(4272);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.setFrom("frs");
        if (this.hgL == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ag.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect aQ = au.aQ(gVar.getVideoContainer());
                    if (!(aVar2 instanceof bj)) {
                        au.a(aVar2, ag.this.mContext, ag.this.hgL, false, aQ);
                        return;
                    }
                    aVar2.objType = 5;
                    au.a(aVar2, ag.this.mContext, ag.this.hgL, false, aQ);
                }
            }
        });
        aVar.c(gVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.agw);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        com.baidu.card.ag agVar = new com.baidu.card.ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmX = 2;
        dVar.dmY = 2;
        dVar.dnd = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.bl(this.hgL);
        agVar.aW(16);
        if (this.hhi) {
            agVar.aX(4);
        }
        aVar.b(agVar);
        aVar.rB().bd(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ad rC = aVar.rC();
        com.baidu.card.a aVar2 = new com.baidu.card.a(rC);
        aVar2.setPageId(this.mPageId);
        rC.a(this.fsi);
        rC.bc(this.hgL);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.frs.entelechy.a.ag.4
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bj) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = (bj) mVar;
                    bjVar.objType = 1;
                    if (ag.this.fsi != null) {
                        ag.this.fsi.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), ag.this.hgL, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar.rD().b(new a.C0095a(1));
                }
            }
        });
        aVar2.rE();
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
        if (aVar.rD().rx() instanceof com.baidu.card.ag) {
            ((com.baidu.card.ag) aVar.rD().rx()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.ag.5
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup, view, i));
                    }
                }
            });
        }
        if (aVar.rD() instanceof com.baidu.tieba.a.e) {
            aVar.rD().setPage(this.aeB);
        }
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) aVar);
        com.baidu.tieba.frs.g.a(aVar.rD().rx(), this.gXU);
        aVar.setVideoStatsData(aj(bjVar));
        if (this.gXU != null && this.gXU.getForum() != null && !StringUtils.isNull(this.gXU.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.gXU.getForum().getTopic_special_icon_right())) {
            bjVar.cz(this.gXU.getForum().getTopic_special_icon(), this.gXU.getForum().getTopic_special_icon_right());
        }
        boolean z = (bjVar.aKC() == null || bjVar.aKC().getUserId() == null || !bjVar.aKC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bjVar.aLO() && bjVar.getFeedBackReasonMap() != null && !z) {
            aVar.aF(true).a(this.fsJ);
        }
        if (!bjVar.isBjh()) {
            aVar.rF();
        }
        aVar.b((com.baidu.card.a) bjVar);
        aVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rD().a((com.baidu.tieba.card.z<T>) this.fsi);
        if (this.hgM != null) {
            bjVar.dpd = (i + 1) - (this.gXU != null ? this.gXU.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bUs().a(this.hgM, bjVar);
        com.baidu.tieba.frs.d.c.bUs().ax(bjVar);
        com.baidu.tieba.frs.d.c.bUs().a(bjVar, bOi());
        com.baidu.tieba.frs.d.a.a(bjVar, this.mPageId, this.hgM, getTbPageTag());
        bjVar.aLL();
        return aVar.getView();
    }

    private com.baidu.tieba.play.y aj(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bjVar.aLI() ? "3" : "2";
        if (this.hgM.hud == 501) {
            yVar.mLocate = "frs_tab";
        }
        yVar.eQk = this.hgM.huc;
        yVar.ahO = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.kir = bjVar.dsY;
        yVar.kis = bjVar.mRecomWeight;
        yVar.kiv = bjVar.mRecomAbTag;
        if (bjVar.aKT() != null) {
            yVar.kiw = bjVar.aKT().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.hgL = i;
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(bj bjVar) {
        TiebaStatic.log(new an("c12126").cI("tid", bjVar.getId()).af("obj_locate", bOi() ? 2 : 1).t("obj_id", bjVar.aKV() == null ? -1L : bjVar.aKV().live_id).af("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.y
    public void lz(boolean z) {
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.agw = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hgM;
    }

    public void mW(boolean z) {
        this.hhi = z;
    }
}
