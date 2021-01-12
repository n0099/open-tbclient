package com.baidu.tieba.frs.entelechy.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class ad extends com.baidu.tieba.frs.k<by, AutoVideoCardViewHolder<bz>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String air;
    private com.baidu.tieba.card.aa<bz> hiF;
    private int jkI;
    private com.baidu.tieba.frs.b.b jkJ;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ad(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jkI = 3;
        this.jkJ = new com.baidu.tieba.frs.b.b();
        this.hiF = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.ad.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if (ad.this.jag != null) {
                        ad.this.jag.a(view, (View) bzVar, (Object) bz.eOy);
                    }
                    if ("c13010".equals(ad.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").an("obj_type", 2).w("fid", bzVar.getFid()).dW("tid", bzVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bzVar.bmc()) {
                        com.baidu.tieba.frs.b.c.cIR().a(ad.this.jkJ, bzVar, 1);
                        ad.this.as(bzVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cIR().a(ad.this.jkJ, bzVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.d.k.a(ad.this.jkJ, bzVar.bkW());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.b.c.cIR().a(ad.this.jkJ, bzVar, 4);
                        ad.this.as(bzVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ad.this.as(bzVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 4, ad.this.mPageId, ad.this.jkJ, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 4, ad.this.mPageId, ad.this.jkJ, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 2, ad.this.mPageId, ad.this.jkJ, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 5, ad.this.mPageId, ad.this.jkJ, ad.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 15, ad.this.mPageId, ad.this.jkJ, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 14, ad.this.mPageId, ad.this.jkJ, ad.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(bzVar, 1, ad.this.mPageId, ad.this.jkJ, ad.this.getTbPageTag());
                    }
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
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity(), true);
        gVar.setFrom("frs");
        gVar.setStageType("2003");
        gVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.frs.entelechy.adapter.ad.2
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bw = ay.bw(gVar.getVideoContainer());
                    if (!(aVar2 instanceof bz)) {
                        ay.a(aVar2, ad.this.mContext, ad.this.jkI, false, bw);
                        return;
                    }
                    aVar2.objType = 5;
                    ay.a(aVar2, ad.this.mContext, ad.this.jkI, false, bw);
                }
            }
        });
        if (this.jkI == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        aVar.c(gVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.iGb);
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(a2);
        autoVideoCardViewHolder.setPageId(this.mPageId);
        a2.a(this.hiF);
        a2.setSourceForPb(this.jkI);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.ad.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar).eHK;
                    bzVar.objType = 1;
                    if (ad.this.hiF != null) {
                        ad.this.hiF.a(threadCardViewHolder.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), ad.this.jkI, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder.tm().b(new a.C0089a(1));
                }
            }
        });
        autoVideoCardViewHolder.aL(false);
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, AutoVideoCardViewHolder<bz> autoVideoCardViewHolder) {
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        if (byVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder.tm() instanceof com.baidu.tieba.a.e) {
            autoVideoCardViewHolder.tm().setPage(this.air);
        }
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) autoVideoCardViewHolder);
        com.baidu.tieba.frs.j.a(autoVideoCardViewHolder.tm().tg(), this.jaa);
        autoVideoCardViewHolder.setVideoStatsData(ak(byVar.eHK));
        autoVideoCardViewHolder.tm().setPosition(i);
        if (this.jaa != null && this.jaa.getForum() != null && !StringUtils.isNull(this.jaa.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jaa.getForum().getTopic_special_icon_right())) {
            byVar.eHK.dJ(this.jaa.getForum().getTopic_special_icon(), this.jaa.getForum().getTopic_special_icon_right());
        }
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<bz>) byVar.eHK);
        autoVideoCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tm().a(this.hiF);
        if (this.jkJ != null) {
            int i2 = 0;
            if (this.jaa != null) {
                i2 = this.jaa.getTopThreadSize();
            }
            byVar.eHK.eMg = (byVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.b.c.cIR().a(this.jkJ, byVar.eHK);
        com.baidu.tieba.frs.b.c.cIR().ay(byVar.eHK);
        com.baidu.tieba.frs.b.c.cIR().a(byVar.eHK, cAV());
        com.baidu.tieba.frs.b.a.a(byVar.eHK, this.mPageId, this.jkJ, getTbPageTag());
        byVar.eHK.boL();
        return autoVideoCardViewHolder.getView();
    }

    private com.baidu.tieba.play.o ak(bz bzVar) {
        if (bzVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bzVar.boI() ? "3" : "2";
        if (this.jkJ.jBJ == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.fKR = this.jkJ.jBI;
        oVar.amM = bzVar.getTid();
        oVar.mSource = bzVar.mRecomSource;
        oVar.myX = bzVar.eQw;
        oVar.myY = bzVar.mRecomWeight;
        oVar.mzb = bzVar.mRecomAbTag;
        if (bzVar.bnO() != null) {
            oVar.mzc = bzVar.bnO().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
        this.jkI = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bz bzVar) {
        TiebaStatic.log(new aq("c12126").dW("tid", bzVar.getId()).an("obj_locate", cAV() ? 2 : 1).w("obj_id", bzVar.bnQ() == null ? -1L : bzVar.bnQ().live_id).an("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.z
    public void pt(boolean z) {
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jkJ;
    }
}
