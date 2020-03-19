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
    private String LC;
    private com.baidu.tieba.card.z<bj> eNJ;
    private int gxk;
    private com.baidu.tieba.frs.d.b gxl;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gxk = 3;
        this.gxl = new com.baidu.tieba.frs.d.b();
        this.eNJ = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (z.this.goP != null) {
                        z.this.goP.a(view, (View) bjVar, (Object) bj.cRN);
                    }
                    if ("c13010".equals(z.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").X("obj_type", 2).s("fid", bjVar.getFid()).cx("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bjVar.aBe()) {
                        com.baidu.tieba.frs.d.c.bJX().a(z.this.gxl, bjVar, 1);
                        z.this.ap(bjVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJX().a(z.this.gxl, bjVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(z.this.gxl, bjVar.aAk());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bJX().a(z.this.gxl, bjVar, 4);
                        z.this.ap(bjVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        z.this.ap(bjVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, z.this.mPageId, z.this.gxl, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, z.this.mPageId, z.this.gxl, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, z.this.mPageId, z.this.gxl, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, z.this.mPageId, z.this.gxl, z.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, z.this.mPageId, z.this.gxl, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, z.this.mPageId, z.this.gxl, z.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, z.this.mPageId, z.this.gxl, z.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bJX().b(z.this.gxl, bjVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJX().b(z.this.gxl, bjVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bJX().b(z.this.gxl, bjVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bJX().b(z.this.gxl, bjVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bJX().b(z.this.gxl, bjVar, 3);
                    }
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
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity(), true);
        gVar.setFrom("frs");
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.z.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect aP = au.aP(gVar.getVideoContainer());
                    if (!(aVar2 instanceof bj)) {
                        au.a(aVar2, z.this.mContext, z.this.gxk, false, aP);
                        return;
                    }
                    aVar2.objType = 5;
                    au.a(aVar2, z.this.mContext, z.this.gxk, false, aP);
                }
            }
        });
        if (this.gxk == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        aVar.c(gVar);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.fXy);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.eNJ);
        a.aQ(this.gxk);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.z.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cRt;
                    bjVar.objType = 1;
                    if (z.this.eNJ != null) {
                        z.this.eNJ.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), z.this.gxk, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
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
        com.baidu.tieba.frs.g.a(aVar.nk().ne(), this.goJ);
        aVar.setVideoStatsData(aq(biVar.cRt));
        aVar.nk().setPosition(i);
        if (this.goJ != null && this.goJ.getForum() != null && !StringUtils.isNull(this.goJ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.goJ.getForum().getTopic_special_icon_right())) {
            biVar.cRt.co(this.goJ.getForum().getTopic_special_icon(), this.goJ.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bj>) biVar.cRt);
        aVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.nk().a(this.eNJ);
        if (this.gxl != null) {
            int i2 = 0;
            if (this.goJ != null) {
                i2 = this.goJ.getTopThreadSize();
            }
            biVar.cRt.cPT = (biVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bJX().a(this.gxl, biVar.cRt);
        com.baidu.tieba.frs.d.c.bJX().aw(biVar.cRt);
        com.baidu.tieba.frs.d.c.bJX().a(biVar.cRt, bDL());
        com.baidu.tieba.frs.d.a.a(biVar.cRt, this.mPageId, this.gxl, getTbPageTag());
        biVar.cRt.aDA();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bj bjVar) {
        TiebaStatic.log(new an("c12126").cx("tid", bjVar.getId()).X("obj_locate", bDL() ? 2 : 1).s("obj_id", bjVar.aCK() == null ? -1L : bjVar.aCK().live_id).X("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.y
    public void kw(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bHn() {
        return this.gxl;
    }
}
