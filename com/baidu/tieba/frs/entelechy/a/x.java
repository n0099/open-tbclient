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
/* loaded from: classes7.dex */
public class x extends com.baidu.tieba.frs.h<bi, com.baidu.card.a<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String Lg;
    private com.baidu.tieba.card.z<bj> eJh;
    private int gum;
    private com.baidu.tieba.frs.d.b gun;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gum = 3;
        this.gun = new com.baidu.tieba.frs.d.b();
        this.eJh = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (x.this.glP != null) {
                        x.this.glP.a(view, (View) bjVar, (Object) bj.cNv);
                    }
                    if ("c13010".equals(x.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").Z("obj_type", 2).s("fid", bjVar.getFid()).cp("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bjVar.aAX()) {
                        com.baidu.tieba.frs.d.c.bIf().a(x.this.gun, bjVar, 1);
                        x.this.am(bjVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bIf().a(x.this.gun, bjVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(x.this.gun, bjVar.axR());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bIf().a(x.this.gun, bjVar, 4);
                        x.this.am(bjVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        x.this.am(bjVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, x.this.mPageId, x.this.gun, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 4, x.this.mPageId, x.this.gun, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, x.this.mPageId, x.this.gun, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, x.this.mPageId, x.this.gun, x.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, x.this.mPageId, x.this.gun, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, x.this.mPageId, x.this.gun, x.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, x.this.mPageId, x.this.gun, x.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bIf().b(x.this.gun, bjVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bIf().b(x.this.gun, bjVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bIf().b(x.this.gun, bjVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bIf().b(x.this.gun, bjVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bIf().b(x.this.gun, bjVar, 3);
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
                        au.a(aVar2, x.this.mContext, x.this.gum, false, aP);
                        return;
                    }
                    aVar2.objType = 5;
                    au.a(aVar2, x.this.mContext, x.this.gum, false, aP);
                }
            }
        });
        aVar.c(gVar);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.fUA);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.eJh);
        a.aM(this.gum);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.x.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cNb;
                    bjVar.objType = 1;
                    if (x.this.eJh != null) {
                        x.this.eJh.a(afVar.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), x.this.gum, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar.mU().b(new a.C0050a(1));
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
        if (aVar.mU() instanceof com.baidu.tieba.a.e) {
            aVar.mU().setPage(this.Lg);
        }
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) aVar);
        com.baidu.tieba.frs.g.a(aVar.mU().mO(), this.glJ);
        aVar.setVideoStatsData(an(biVar.cNb));
        aVar.mU().setPosition(i);
        if (this.glJ != null && this.glJ.getForum() != null && !StringUtils.isNull(this.glJ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.glJ.getForum().getTopic_special_icon_right())) {
            biVar.cNb.cg(this.glJ.getForum().getTopic_special_icon(), this.glJ.getForum().getTopic_special_icon_right());
        }
        aVar.b((com.baidu.card.a<bj>) biVar.cNb);
        aVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.mU().a(this.eJh);
        if (this.gun != null) {
            int i2 = 0;
            if (this.glJ != null) {
                i2 = this.glJ.getTopThreadSize();
            }
            biVar.cNb.cLB = (biVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bIf().a(this.gun, biVar.cNb);
        com.baidu.tieba.frs.d.c.bIf().ar(biVar.cNb);
        com.baidu.tieba.frs.d.c.bIf().a(biVar.cNb, bBX());
        com.baidu.tieba.frs.d.a.a(biVar.cNb, this.mPageId, this.gun, getTbPageTag());
        biVar.cNb.aBh();
        return aVar.getView();
    }

    private com.baidu.tieba.play.y an(bj bjVar) {
        if (bjVar == null) {
            return null;
        }
        com.baidu.tieba.play.y yVar = new com.baidu.tieba.play.y();
        yVar.mLocate = bjVar.aBe() ? "3" : "2";
        if (this.gun.gHo == 501) {
            yVar.mLocate = "frs_tab";
        }
        yVar.fKa = this.gun.gHn;
        yVar.OG = bjVar.getTid();
        yVar.mSource = bjVar.mRecomSource;
        yVar.jvO = bjVar.cPt;
        yVar.jvP = bjVar.mRecomWeight;
        yVar.mAbTag = bjVar.mRecomAbTag;
        if (bjVar.aAo() != null) {
            yVar.jvS = bjVar.aAo().video_md5;
        }
        return yVar;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void po(int i) {
        this.gum = i;
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(bj bjVar) {
        TiebaStatic.log(new an("c12126").cp("tid", bjVar.getId()).Z("obj_locate", bBX() ? 2 : 1).s("obj_id", bjVar.aAq() == null ? -1L : bjVar.aAq().live_id).Z("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.y
    public void kp(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bFt() {
        return this.gun;
    }
}
