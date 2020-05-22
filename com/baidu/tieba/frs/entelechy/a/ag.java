package com.baidu.tieba.frs.entelechy.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.b;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
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
public class ag extends com.baidu.tieba.frs.h<bk, com.baidu.card.a<bk>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aeX;
    private boolean aha;
    private NEGFeedBackView.a fGB;
    private com.baidu.tieba.card.aa<bk> fGa;
    public boolean huE;
    private com.baidu.tieba.frs.d.b hvA;
    private boolean hvW;
    private int hvz;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ag(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.aha = false;
        this.hvW = false;
        this.hvz = 3;
        this.hvA = new com.baidu.tieba.frs.d.b();
        this.fGa = new com.baidu.tieba.card.aa<bk>() { // from class: com.baidu.tieba.frs.entelechy.a.ag.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                if (view != null && bkVar != null) {
                    if (ag.this.hmM != null) {
                        ag.this.hmM.a(view, (View) bkVar, (Object) bk.dEV);
                    }
                    if ("c13010".equals(ag.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").ag("obj_type", 2).s("fid", bkVar.getFid()).dh("tid", bkVar.getTid()));
                    }
                    if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 4, ag.this.mPageId, ag.this.hvA, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 2, ag.this.mPageId, ag.this.hvA, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 4, ag.this.mPageId, ag.this.hvA, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 5, ag.this.mPageId, ag.this.hvA, ag.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 15, ag.this.mPageId, ag.this.hvA, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 14, ag.this.mPageId, ag.this.hvA, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 12, ag.this.mPageId, ag.this.hvA, ag.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 13, ag.this.mPageId, ag.this.hvA, ag.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bkVar, 1, ag.this.mPageId, ag.this.hvA, ag.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.caQ().a(ag.this.hvA, bkVar, 1);
                        ag.this.as(bkVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.caQ().a(ag.this.hvA, bkVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(ag.this.hvA, bkVar.aOj());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.caQ().a(ag.this.hvA, bkVar, 4);
                        ag.this.as(bkVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ag.this.as(bkVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.caQ().b(ag.this.hvA, bkVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.caQ().b(ag.this.hvA, bkVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.caQ().b(ag.this.hvA, bkVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.caQ().b(ag.this.hvA, bkVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.caQ().b(ag.this.hvA, bkVar, 3);
                    }
                }
            }
        };
        this.fGB = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.ag.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ak akVar) {
                TiebaStatic.log(new an("c11973").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ak akVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
                if (arrayList != null && akVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11974").dh("obj_locate", sb.toString()).dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("nid", akVar.getNid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("source", akVar.source).dh("weight", akVar.weight).dh("ab_tag", akVar.abTag).dh("extra", akVar.extra).ag(IntentConfig.CARD_TYPE, akVar.cardType).ag("obj_floor", akVar.dDb));
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
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aX(4272);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.setFrom("frs");
        if (this.hvz == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ag.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aQ = au.aQ(gVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bk)) {
                        au.a(absThreadDataSupport, ag.this.mContext, ag.this.hvz, false, aQ);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    au.a(absThreadDataSupport, ag.this.mContext, ag.this.hvz, false, aQ);
                }
            }
        });
        aVar.c(gVar);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aha);
        lVar.setForm("frs");
        aVar.a((com.baidu.card.h) lVar);
        com.baidu.card.ah ahVar = new com.baidu.card.ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 2;
        cVar.dBa = 2;
        cVar.dBf = 2;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(2);
        ahVar.setShareReportFrom(1);
        ahVar.bm(this.hvz);
        ahVar.aX(16);
        if (this.hvW) {
            ahVar.aY(4);
        }
        aVar.b(ahVar);
        aVar.rK().be(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ae rL = aVar.rL();
        com.baidu.card.a aVar2 = new com.baidu.card.a(rL);
        aVar2.setPageId(this.mPageId);
        rL.a(this.fGa);
        rL.setSourceForPb(this.hvz);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.frs.entelechy.a.ag.4
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof bk) && (view.getTag() instanceof com.baidu.card.ag)) {
                    com.baidu.card.ag agVar = (com.baidu.card.ag) view.getTag();
                    bk bkVar = (bk) oVar;
                    bkVar.objType = 1;
                    if (ag.this.fGa != null) {
                        ag.this.fGa.a(agVar.getView(), bkVar);
                    }
                    au.a((AbsThreadDataSupport) bkVar, view.getContext(), ag.this.hvz, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.t) viewGroup2, view, i));
                    agVar.rM().b(new a.C0097a(1));
                }
            }
        });
        aVar2.rN();
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, bk bkVar, com.baidu.card.a aVar) {
        if (aVar == null) {
            return null;
        }
        if (bkVar == null) {
            return aVar.getView();
        }
        if (aVar.rM().rG() instanceof com.baidu.card.ah) {
            ((com.baidu.card.ah) aVar.rM().rG()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.ag.5
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.t) viewGroup, view, i));
                    }
                }
            });
        }
        if (aVar.rM() instanceof com.baidu.tieba.a.e) {
            aVar.rM().setPage(this.aeX);
        }
        super.a(i, view, viewGroup, (ViewGroup) bkVar, (bk) aVar);
        com.baidu.tieba.frs.g.a(aVar.rM().rG(), this.hmG);
        aVar.setVideoStatsData(ak(bkVar));
        if (this.hmG != null && this.hmG.getForum() != null && !StringUtils.isNull(this.hmG.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hmG.getForum().getTopic_special_icon_right())) {
            bkVar.cY(this.hmG.getForum().getTopic_special_icon(), this.hmG.getForum().getTopic_special_icon_right());
        }
        boolean z = (bkVar.aQx() == null || bkVar.aQx().getUserId() == null || !bkVar.aQx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bkVar.aRN() && bkVar.getFeedBackReasonMap() != null && !z) {
            aVar.aH(true).a(this.fGB);
        }
        if (!bkVar.isBjh()) {
            aVar.rO();
        }
        aVar.b((com.baidu.card.a) bkVar);
        aVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rM().a((com.baidu.tieba.card.aa<T>) this.fGa);
        if (this.hvA != null) {
            bkVar.dDb = (i + 1) - (this.hmG != null ? this.hmG.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.caQ().a(this.hvA, bkVar);
        com.baidu.tieba.frs.d.c.caQ().ay(bkVar);
        com.baidu.tieba.frs.d.c.caQ().a(bkVar, bUE());
        com.baidu.tieba.frs.d.a.a(bkVar, this.mPageId, this.hvA, getTbPageTag());
        bkVar.aRK();
        return aVar.getView();
    }

    private com.baidu.tieba.play.y ak(bk bkVar) {
        if (bkVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bkVar.aRH() ? "3" : "2";
        if (this.hvA.hIQ == 501) {
            yVar.mLocate = "frs_tab";
        }
        yVar.evm = this.hvA.hIP;
        yVar.ais = bkVar.getTid();
        yVar.mSource = bkVar.mRecomSource;
        yVar.kAl = bkVar.dGS;
        yVar.kAm = bkVar.mRecomWeight;
        yVar.kAp = bkVar.mRecomAbTag;
        if (bkVar.aQQ() != null) {
            yVar.kAq = bkVar.aQQ().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
        this.hvz = i;
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bk bkVar) {
        TiebaStatic.log(new an("c12126").dh("tid", bkVar.getId()).ag("obj_locate", bUE() ? 2 : 1).s("obj_id", bkVar.aQS() == null ? -1L : bkVar.aQS().live_id).ag("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.z
    public void lV(boolean z) {
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hvA;
    }

    public void nr(boolean z) {
        this.hvW = z;
    }
}
