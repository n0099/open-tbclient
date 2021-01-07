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
    private String aji;
    private com.baidu.tieba.card.aa<bz> hnl;
    private int jpp;
    private com.baidu.tieba.frs.b.b jpq;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ad(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jpp = 3;
        this.jpq = new com.baidu.tieba.frs.b.b();
        this.hnl = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.ad.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if (ad.this.jeN != null) {
                        ad.this.jeN.a(view, (View) bzVar, (Object) bz.eTj);
                    }
                    if ("c13010".equals(ad.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").an("obj_type", 2).w("fid", bzVar.getFid()).dX("tid", bzVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bzVar.bpW()) {
                        com.baidu.tieba.frs.b.c.cMJ().a(ad.this.jpq, bzVar, 1);
                        ad.this.as(bzVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cMJ().a(ad.this.jpq, bzVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.d.k.a(ad.this.jpq, bzVar.boQ());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.b.c.cMJ().a(ad.this.jpq, bzVar, 4);
                        ad.this.as(bzVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ad.this.as(bzVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 4, ad.this.mPageId, ad.this.jpq, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 4, ad.this.mPageId, ad.this.jpq, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 2, ad.this.mPageId, ad.this.jpq, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 5, ad.this.mPageId, ad.this.jpq, ad.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 15, ad.this.mPageId, ad.this.jpq, ad.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 14, ad.this.mPageId, ad.this.jpq, ad.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(bzVar, 1, ad.this.mPageId, ad.this.jpq, ad.this.getTbPageTag());
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
        gVar.a(new a.InterfaceC0089a() { // from class: com.baidu.tieba.frs.entelechy.adapter.ad.2
            @Override // com.baidu.card.a.InterfaceC0089a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bw = ay.bw(gVar.getVideoContainer());
                    if (!(aVar2 instanceof bz)) {
                        ay.a(aVar2, ad.this.mContext, ad.this.jpp, false, bw);
                        return;
                    }
                    aVar2.objType = 5;
                    ay.a(aVar2, ad.this.mContext, ad.this.jpp, false, bw);
                }
            }
        });
        if (this.jpp == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        aVar.c(gVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.iKI);
        AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(a2);
        autoVideoCardViewHolder.setPageId(this.mPageId);
        a2.a(this.hnl);
        a2.setSourceForPb(this.jpp);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.ad.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar).eMv;
                    bzVar.objType = 1;
                    if (ad.this.hnl != null) {
                        ad.this.hnl.a(threadCardViewHolder.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), ad.this.jpp, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder.ty().b(new a.C0090a(1));
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
        if (autoVideoCardViewHolder.ty() instanceof com.baidu.tieba.a.e) {
            autoVideoCardViewHolder.ty().setPage(this.aji);
        }
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) autoVideoCardViewHolder);
        com.baidu.tieba.frs.j.a(autoVideoCardViewHolder.ty().ts(), this.jeH);
        autoVideoCardViewHolder.setVideoStatsData(ak(byVar.eMv));
        autoVideoCardViewHolder.ty().setPosition(i);
        if (this.jeH != null && this.jeH.getForum() != null && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon_right())) {
            byVar.eMv.dK(this.jeH.getForum().getTopic_special_icon(), this.jeH.getForum().getTopic_special_icon_right());
        }
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<bz>) byVar.eMv);
        autoVideoCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.ty().a(this.hnl);
        if (this.jpq != null) {
            int i2 = 0;
            if (this.jeH != null) {
                i2 = this.jeH.getTopThreadSize();
            }
            byVar.eMv.eQR = (byVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.b.c.cMJ().a(this.jpq, byVar.eMv);
        com.baidu.tieba.frs.b.c.cMJ().ay(byVar.eMv);
        com.baidu.tieba.frs.b.c.cMJ().a(byVar.eMv, cEN());
        com.baidu.tieba.frs.b.a.a(byVar.eMv, this.mPageId, this.jpq, getTbPageTag());
        byVar.eMv.bsF();
        return autoVideoCardViewHolder.getView();
    }

    private com.baidu.tieba.play.o ak(bz bzVar) {
        if (bzVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = bzVar.bsC() ? "3" : "2";
        if (this.jpq.jGp == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.fPy = this.jpq.jGo;
        oVar.anD = bzVar.getTid();
        oVar.mSource = bzVar.mRecomSource;
        oVar.mDG = bzVar.eVh;
        oVar.mDH = bzVar.mRecomWeight;
        oVar.mDK = bzVar.mRecomAbTag;
        if (bzVar.brI() != null) {
            oVar.mDL = bzVar.brI().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
        this.jpp = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Fl(String str) {
        this.aji = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bz bzVar) {
        TiebaStatic.log(new aq("c12126").dX("tid", bzVar.getId()).an("obj_locate", cEN() ? 2 : 1).w("obj_id", bzVar.brK() == null ? -1L : bzVar.brK().live_id).an("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.z
    public void px(boolean z) {
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jpq;
    }
}
