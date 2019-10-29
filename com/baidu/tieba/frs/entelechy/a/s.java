package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class s extends com.baidu.tieba.frs.h<bg, com.baidu.card.a<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String GC;
    private boolean cqZ;
    private ab<bh> dTh;
    private boolean fDW;
    private int fDY;
    private com.baidu.tieba.frs.d.b fDZ;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cqZ = false;
        this.fDW = false;
        this.fDY = 3;
        this.fDZ = new com.baidu.tieba.frs.d.b();
        this.dTh = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (s.this.fuX != null) {
                        s.this.fuX.a(view, (View) bhVar, (Object) bh.cbI);
                    }
                    if ("c13010".equals(s.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").O("obj_type", 2).p("fid", bhVar.getFid()).bS("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bhVar.ajA()) {
                        com.baidu.tieba.frs.d.c.bpJ().a(s.this.fDZ, bhVar, 1);
                        s.this.ae(bhVar);
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 4, s.this.mPageId, s.this.fDZ);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpJ().a(s.this.fDZ, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, s.this.mPageId, s.this.fDZ);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(s.this.fDZ, bhVar.agJ());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bpJ().a(s.this.fDZ, bhVar, 4);
                        s.this.ae(bhVar);
                        com.baidu.tieba.frs.d.a.a(bhVar, 4, s.this.mPageId, s.this.fDZ);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, s.this.mPageId, s.this.fDZ);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        s.this.ae(bhVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bpJ().b(s.this.fDZ, bhVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpJ().b(s.this.fDZ, bhVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bpJ().b(s.this.fDZ, bhVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bpJ().b(s.this.fDZ, bhVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bpJ().b(s.this.fDZ, bhVar, 3);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity(), true);
        eVar.setFrom("frs");
        aVar.b(eVar);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.fdE);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.b(this.dTh);
        a.aF(this.fDY);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.s.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).cbq;
                    bhVar.objType = 1;
                    if (s.this.dTh != null) {
                        s.this.dTh.a(zVar.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), s.this.fDY, false);
                    zVar.lV().b(new a.C0044a(1));
                }
            }
        });
        aVar2.Y(false);
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.a<bh> aVar) {
        if (aVar == null) {
            return null;
        }
        if (bgVar == null) {
            return aVar.getView();
        }
        if (aVar.lV() instanceof com.baidu.tieba.a.e) {
            aVar.lV().setPage(this.GC);
        }
        super.a(i, view, viewGroup, (ViewGroup) bgVar, (bg) aVar);
        com.baidu.tieba.frs.g.a(aVar.lV().lP(), this.fuR);
        aVar.setVideoStatsData(af(bgVar.cbq));
        aVar.lV().setPosition(i);
        if (this.fuR != null && this.fuR.getForum() != null && !StringUtils.isNull(this.fuR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fuR.getForum().getTopic_special_icon_right())) {
            bgVar.cbq.bI(this.fuR.getForum().getTopic_special_icon(), this.fuR.getForum().getTopic_special_icon_right());
        }
        aVar.a(bgVar.cbq);
        aVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.lV().b(this.dTh);
        if (this.fDZ != null) {
            int i2 = 0;
            if (this.fuR != null) {
                i2 = this.fuR.getTopThreadSize();
            }
            bgVar.cbq.cez = (bgVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bpJ().a(this.fDZ, bgVar.cbq);
        com.baidu.tieba.frs.d.c.bpJ().ak(bgVar.cbq);
        com.baidu.tieba.frs.d.c.bpJ().a(bgVar.cbq, bjE());
        com.baidu.tieba.frs.d.a.a(bgVar.cbq, this.mPageId, this.fDZ);
        bgVar.cbq.ajK();
        return aVar.getView();
    }

    private com.baidu.tieba.play.z af(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bhVar.ajH() ? "3" : "2";
        if (this.fDZ.fQE == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.ePT = this.fDZ.fQD;
        zVar.cmS = bhVar.getTid();
        zVar.mSource = bhVar.mRecomSource;
        zVar.iza = bhVar.cdG;
        zVar.izb = bhVar.mRecomWeight;
        zVar.izd = bhVar.mRecomAbTag;
        if (bhVar.aiX() != null) {
            zVar.ize = bhVar.aiX().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mX(int i) {
        this.fDY = i;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bh bhVar) {
        TiebaStatic.log(new an("c12126").bS("tid", bhVar.getId()).O("obj_locate", bjE() ? 2 : 1).p("obj_id", bhVar.aiZ() == null ? -1L : bhVar.aiZ().live_id).O("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.cqZ = z;
    }

    @Override // com.baidu.tieba.card.aa
    public void iM(boolean z) {
        this.fDW = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmX() {
        return this.fDZ;
    }
}
