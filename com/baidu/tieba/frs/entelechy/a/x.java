package com.baidu.tieba.frs.entelechy.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.b;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class x extends com.baidu.tieba.frs.h<bi, com.baidu.card.a<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String LC;
    private com.baidu.tieba.card.z<bj> eNb;
    private int gwn;
    private com.baidu.tieba.frs.d.b gwo;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gwn = 3;
        this.gwo = new com.baidu.tieba.frs.d.b();
        this.eNb = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (x.this.gnQ != null) {
                        x.this.gnQ.a(view, (View) bjVar, (Object) bj.cRy);
                    }
                    if ("c13010".equals(x.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").X("obj_type", 2).s("fid", bjVar.getFid()).cy("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bjVar.aAZ()) {
                        com.baidu.tieba.frs.d.c.bJH().a(x.this.gwo, bjVar, 1);
                        x.this.ao(bjVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJH().a(x.this.gwo, bjVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(x.this.gwo, bjVar.aAf());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bJH().a(x.this.gwo, bjVar, 4);
                        x.this.ao(bjVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        x.this.ao(bjVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, x.this.mPageId, x.this.gwo, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, x.this.mPageId, x.this.gwo, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, x.this.mPageId, x.this.gwo, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, x.this.mPageId, x.this.gwo, x.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, x.this.mPageId, x.this.gwo, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, x.this.mPageId, x.this.gwo, x.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, x.this.mPageId, x.this.gwo, x.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bJH().b(x.this.gwo, bjVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJH().b(x.this.gwo, bjVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bJH().b(x.this.gwo, bjVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bJH().b(x.this.gwo, bjVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bJH().b(x.this.gwo, bjVar, 3);
                    }
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
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity(), true);
        gVar.setFrom("frs");
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.x.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect aP = au.aP(gVar.getVideoContainer());
                    if (!(aVar2 instanceof bj)) {
                        au.a(aVar2, x.this.mContext, x.this.gwn, false, aP);
                        return;
                    }
                    aVar2.objType = 5;
                    au.a(aVar2, x.this.mContext, x.this.gwn, false, aP);
                }
            }
        });
        aVar.c(gVar);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.fWB);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.eNb);
        a.aQ(this.gwn);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.x.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cRe;
                    bjVar.objType = 1;
                    if (x.this.eNb != null) {
                        x.this.eNb.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), x.this.gwn, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar.nk().b(new a.C0052a(1));
                }
            }
        });
        aVar2.ai(false);
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.card.a<bj> aVar) {
        if (aVar == null) {
            return null;
        }
        if (biVar == null) {
            return aVar.getView();
        }
        if (aVar.nk() instanceof com.baidu.tieba.a.e) {
            aVar.nk().setPage(this.LC);
        }
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) aVar);
        com.baidu.tieba.frs.g.a(aVar.nk().ne(), this.gnK);
        aVar.setVideoStatsData(ap(biVar.cRe));
        aVar.nk().setPosition(i);
        if (this.gnK != null && this.gnK.getForum() != null && !StringUtils.isNull(this.gnK.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.gnK.getForum().getTopic_special_icon_right())) {
            biVar.cRe.cp(this.gnK.getForum().getTopic_special_icon(), this.gnK.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bj>) biVar.cRe);
        aVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.nk().a(this.eNb);
        if (this.gwo != null) {
            int i2 = 0;
            if (this.gnK != null) {
                i2 = this.gnK.getTopThreadSize();
            }
            biVar.cRe.cPE = (biVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bJH().a(this.gwo, biVar.cRe);
        com.baidu.tieba.frs.d.c.bJH().av(biVar.cRe);
        com.baidu.tieba.frs.d.c.bJH().a(biVar.cRe, bDA());
        com.baidu.tieba.frs.d.a.a(biVar.cRe, this.mPageId, this.gwo, getTbPageTag());
        biVar.cRe.aDu();
        return aVar.getView();
    }

    private com.baidu.tieba.play.y ap(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bjVar.aDr() ? "3" : "2";
        if (this.gwo.gJn == 501) {
            yVar.mLocate = "frs_tab";
        }
        yVar.ema = this.gwo.gJm;
        yVar.Pj = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.jwE = bjVar.cTv;
        yVar.jwF = bjVar.mRecomWeight;
        yVar.mAbTag = bjVar.mRecomAbTag;
        if (bjVar.aCD() != null) {
            yVar.jwI = bjVar.aCD().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
        this.gwn = i;
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(bj bjVar) {
        TiebaStatic.log(new an("c12126").cy("tid", bjVar.getId()).X("obj_locate", bDA() ? 2 : 1).s("obj_id", bjVar.aCF() == null ? -1L : bjVar.aCF().live_id).X("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.y
    public void kr(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bGV() {
        return this.gwo;
    }
}
