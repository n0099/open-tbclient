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
public class z extends com.baidu.tieba.frs.h<bi, com.baidu.card.a<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String aey;
    private com.baidu.tieba.card.z<bj> fsd;
    private int hgF;
    private com.baidu.tieba.frs.d.b hgG;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hgF = 3;
        this.hgG = new com.baidu.tieba.frs.d.b();
        this.fsd = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (z.this.gXU != null) {
                        z.this.gXU.a(view, (View) bjVar, (Object) bj.dqV);
                    }
                    if ("c13010".equals(z.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").af("obj_type", 2).t("fid", bjVar.getFid()).cI("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bjVar.aJr()) {
                        com.baidu.tieba.frs.d.c.bUu().a(z.this.hgG, bjVar, 1);
                        z.this.ar(bjVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bUu().a(z.this.hgG, bjVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(z.this.hgG, bjVar.aIx());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bUu().a(z.this.hgG, bjVar, 4);
                        z.this.ar(bjVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        z.this.ar(bjVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, z.this.mPageId, z.this.hgG, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, z.this.mPageId, z.this.hgG, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, z.this.mPageId, z.this.hgG, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, z.this.mPageId, z.this.hgG, z.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, z.this.mPageId, z.this.hgG, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, z.this.mPageId, z.this.hgG, z.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, z.this.mPageId, z.this.hgG, z.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bUu().b(z.this.hgG, bjVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bUu().b(z.this.hgG, bjVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bUu().b(z.this.hgG, bjVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bUu().b(z.this.hgG, bjVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bUu().b(z.this.hgG, bjVar, 3);
                    }
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
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity(), true);
        gVar.setFrom("frs");
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.z.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect aQ = au.aQ(gVar.getVideoContainer());
                    if (!(aVar2 instanceof bj)) {
                        au.a(aVar2, z.this.mContext, z.this.hgF, false, aQ);
                        return;
                    }
                    aVar2.objType = 5;
                    au.a(aVar2, z.this.mContext, z.this.hgF, false, aQ);
                }
            }
        });
        if (this.hgF == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        aVar.c(gVar);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.gEc);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.fsd);
        a.bc(this.hgF);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.frs.entelechy.a.z.3
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).dqA;
                    bjVar.objType = 1;
                    if (z.this.fsd != null) {
                        z.this.fsd.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), z.this.hgF, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar.rD().b(new a.C0074a(1));
                }
            }
        });
        aVar2.aH(false);
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
        if (aVar.rD() instanceof com.baidu.tieba.a.e) {
            aVar.rD().setPage(this.aey);
        }
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) aVar);
        com.baidu.tieba.frs.g.a(aVar.rD().rx(), this.gXO);
        aVar.setVideoStatsData(aj(biVar.dqA));
        aVar.rD().setPosition(i);
        if (this.gXO != null && this.gXO.getForum() != null && !StringUtils.isNull(this.gXO.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.gXO.getForum().getTopic_special_icon_right())) {
            biVar.dqA.cz(this.gXO.getForum().getTopic_special_icon(), this.gXO.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bj>) biVar.dqA);
        aVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rD().a(this.fsd);
        if (this.hgG != null) {
            int i2 = 0;
            if (this.gXO != null) {
                i2 = this.gXO.getTopThreadSize();
            }
            biVar.dqA.doZ = (biVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bUu().a(this.hgG, biVar.dqA);
        com.baidu.tieba.frs.d.c.bUu().ax(biVar.dqA);
        com.baidu.tieba.frs.d.c.bUu().a(biVar.dqA, bOk());
        com.baidu.tieba.frs.d.a.a(biVar.dqA, this.mPageId, this.hgG, getTbPageTag());
        biVar.dqA.aLN();
        return aVar.getView();
    }

    private com.baidu.tieba.play.y aj(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bjVar.aLK() ? "3" : "2";
        if (this.hgG.htX == 501) {
            yVar.mLocate = "frs_tab";
        }
        yVar.eQf = this.hgG.htW;
        yVar.ahL = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.kin = bjVar.dsU;
        yVar.kio = bjVar.mRecomWeight;
        yVar.kir = bjVar.mRecomAbTag;
        if (bjVar.aKV() != null) {
            yVar.kis = bjVar.aKV().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.hgF = i;
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(bj bjVar) {
        TiebaStatic.log(new an("c12126").cI("tid", bjVar.getId()).af("obj_locate", bOk() ? 2 : 1).t("obj_id", bjVar.aKX() == null ? -1L : bjVar.aKX().live_id).af("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.y
    public void lz(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hgG;
    }
}
