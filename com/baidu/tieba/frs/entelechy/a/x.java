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
/* loaded from: classes6.dex */
public class x extends com.baidu.tieba.frs.h<bi, com.baidu.card.a<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String La;
    private com.baidu.tieba.card.z<bj> eHX;
    private int grd;
    private com.baidu.tieba.frs.d.b gre;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.grd = 3;
        this.gre = new com.baidu.tieba.frs.d.b();
        this.eHX = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (x.this.giG != null) {
                        x.this.giG.a(view, (View) bjVar, (Object) bj.cNl);
                    }
                    if ("c13010".equals(x.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").Z("obj_type", 2).s("fid", bjVar.getFid()).cp("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bjVar.aAE()) {
                        com.baidu.tieba.frs.d.c.bHd().a(x.this.gre, bjVar, 1);
                        x.this.al(bjVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bHd().a(x.this.gre, bjVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(x.this.gre, bjVar.axy());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bHd().a(x.this.gre, bjVar, 4);
                        x.this.al(bjVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        x.this.al(bjVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, x.this.mPageId, x.this.gre, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, x.this.mPageId, x.this.gre, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, x.this.mPageId, x.this.gre, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, x.this.mPageId, x.this.gre, x.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, x.this.mPageId, x.this.gre, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, x.this.mPageId, x.this.gre, x.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, x.this.mPageId, x.this.gre, x.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bHd().b(x.this.gre, bjVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bHd().b(x.this.gre, bjVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bHd().b(x.this.gre, bjVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bHd().b(x.this.gre, bjVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bHd().b(x.this.gre, bjVar, 3);
                    }
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
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity(), true);
        gVar.setFrom("frs");
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.x.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect aL = au.aL(gVar.getVideoContainer());
                    if (!(aVar2 instanceof bj)) {
                        au.a(aVar2, x.this.mContext, x.this.grd, false, aL);
                        return;
                    }
                    aVar2.objType = 5;
                    au.a(aVar2, x.this.mContext, x.this.grd, false, aL);
                }
            }
        });
        aVar.c(gVar);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.fRq);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.eHX);
        a.aM(this.grd);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.x.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cMR;
                    bjVar.objType = 1;
                    if (x.this.eHX != null) {
                        x.this.eHX.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), x.this.grd, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar.mT().b(new a.C0050a(1));
                }
            }
        });
        aVar2.af(false);
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
        if (aVar.mT() instanceof com.baidu.tieba.a.e) {
            aVar.mT().setPage(this.La);
        }
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) aVar);
        com.baidu.tieba.frs.g.a(aVar.mT().mN(), this.giA);
        aVar.setVideoStatsData(am(biVar.cMR));
        aVar.mT().setPosition(i);
        if (this.giA != null && this.giA.getForum() != null && !StringUtils.isNull(this.giA.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.giA.getForum().getTopic_special_icon_right())) {
            biVar.cMR.cg(this.giA.getForum().getTopic_special_icon(), this.giA.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bj>) biVar.cMR);
        aVar.mT().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.mT().a(this.eHX);
        if (this.gre != null) {
            int i2 = 0;
            if (this.giA != null) {
                i2 = this.giA.getTopThreadSize();
            }
            biVar.cMR.cLr = (biVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bHd().a(this.gre, biVar.cMR);
        com.baidu.tieba.frs.d.c.bHd().aq(biVar.cMR);
        com.baidu.tieba.frs.d.c.bHd().a(biVar.cMR, bAV());
        com.baidu.tieba.frs.d.a.a(biVar.cMR, this.mPageId, this.gre, getTbPageTag());
        biVar.cMR.aAO();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void al(bj bjVar) {
        TiebaStatic.log(new an("c12126").cp("tid", bjVar.getId()).Z("obj_locate", bAV() ? 2 : 1).s("obj_id", bjVar.azX() == null ? -1L : bjVar.azX().live_id).Z("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.y
    public void ke(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bEr() {
        return this.gre;
    }
}
