package com.baidu.tieba.frs.entelechy.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.b;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class z extends com.baidu.tieba.frs.h<bj, com.baidu.card.a<bk>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aeX;
    private com.baidu.tieba.card.aa<bk> fGa;
    private com.baidu.tieba.frs.d.b hvA;
    private int hvz;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hvz = 3;
        this.hvA = new com.baidu.tieba.frs.d.b();
        this.fGa = new com.baidu.tieba.card.aa<bk>() { // from class: com.baidu.tieba.frs.entelechy.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                if (view != null && bkVar != null) {
                    if (z.this.hmM != null) {
                        z.this.hmM.a(view, (View) bkVar, (Object) bk.dEV);
                    }
                    if ("c13010".equals(z.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").ag("obj_type", 2).s("fid", bkVar.getFid()).dh("tid", bkVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bkVar.aPk()) {
                        com.baidu.tieba.frs.d.c.caQ().a(z.this.hvA, bkVar, 1);
                        z.this.as(bkVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.caQ().a(z.this.hvA, bkVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(z.this.hvA, bkVar.aOj());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.caQ().a(z.this.hvA, bkVar, 4);
                        z.this.as(bkVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        z.this.as(bkVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 4, z.this.mPageId, z.this.hvA, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 4, z.this.mPageId, z.this.hvA, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 2, z.this.mPageId, z.this.hvA, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 5, z.this.mPageId, z.this.hvA, z.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 15, z.this.mPageId, z.this.hvA, z.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 14, z.this.mPageId, z.this.hvA, z.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bkVar, 1, z.this.mPageId, z.this.hvA, z.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.caQ().b(z.this.hvA, bkVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.caQ().b(z.this.hvA, bkVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.caQ().b(z.this.hvA, bkVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.caQ().b(z.this.hvA, bkVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.caQ().b(z.this.hvA, bkVar, 3);
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
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity(), true);
        gVar.setFrom("frs");
        gVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.z.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aQ = au.aQ(gVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bk)) {
                        au.a(absThreadDataSupport, z.this.mContext, z.this.hvz, false, aQ);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    au.a(absThreadDataSupport, z.this.mContext, z.this.hvz, false, aQ);
                }
            }
        });
        if (this.hvz == 502) {
            gVar.setNeedFrsTabName(false);
        } else {
            gVar.setNeedFrsTabName(true);
        }
        aVar.c(gVar);
        com.baidu.card.ae a = aVar.a(false, viewGroup, this.gSQ);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.fGa);
        a.setSourceForPb(this.hvz);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.frs.entelechy.a.z.3
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof bj) && (view.getTag() instanceof com.baidu.card.ag)) {
                    com.baidu.card.ag agVar = (com.baidu.card.ag) view.getTag();
                    bk bkVar = ((bj) oVar).dEA;
                    bkVar.objType = 1;
                    if (z.this.fGa != null) {
                        z.this.fGa.a(agVar.getView(), bkVar);
                    }
                    au.a((AbsThreadDataSupport) bkVar, view.getContext(), z.this.hvz, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.t) viewGroup2, view, i));
                    agVar.rM().b(new a.C0097a(1));
                }
            }
        });
        aVar2.aI(false);
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.card.a<bk> aVar) {
        if (aVar == null) {
            return null;
        }
        if (bjVar == null) {
            return aVar.getView();
        }
        if (aVar.rM() instanceof com.baidu.tieba.a.e) {
            aVar.rM().setPage(this.aeX);
        }
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) aVar);
        com.baidu.tieba.frs.g.a(aVar.rM().rG(), this.hmG);
        aVar.setVideoStatsData(ak(bjVar.dEA));
        aVar.rM().setPosition(i);
        if (this.hmG != null && this.hmG.getForum() != null && !StringUtils.isNull(this.hmG.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hmG.getForum().getTopic_special_icon_right())) {
            bjVar.dEA.cY(this.hmG.getForum().getTopic_special_icon(), this.hmG.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bk>) bjVar.dEA);
        aVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rM().a(this.fGa);
        if (this.hvA != null) {
            int i2 = 0;
            if (this.hmG != null) {
                i2 = this.hmG.getTopThreadSize();
            }
            bjVar.dEA.dDb = (bjVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.caQ().a(this.hvA, bjVar.dEA);
        com.baidu.tieba.frs.d.c.caQ().ay(bjVar.dEA);
        com.baidu.tieba.frs.d.c.caQ().a(bjVar.dEA, bUE());
        com.baidu.tieba.frs.d.a.a(bjVar.dEA, this.mPageId, this.hvA, getTbPageTag());
        bjVar.dEA.aRK();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bk bkVar) {
        TiebaStatic.log(new an("c12126").dh("tid", bkVar.getId()).ag("obj_locate", bUE() ? 2 : 1).s("obj_id", bkVar.aQS() == null ? -1L : bkVar.aQS().live_id).ag("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.z
    public void lV(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hvA;
    }
}
