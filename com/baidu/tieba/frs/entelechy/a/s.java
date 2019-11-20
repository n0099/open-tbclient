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
    private String Gc;
    private boolean cqi;
    private ab<bh> dSq;
    private boolean fDf;
    private int fDh;
    private com.baidu.tieba.frs.d.b fDi;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cqi = false;
        this.fDf = false;
        this.fDh = 3;
        this.fDi = new com.baidu.tieba.frs.d.b();
        this.dSq = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (s.this.fug != null) {
                        s.this.fug.a(view, (View) bhVar, (Object) bh.caR);
                    }
                    if ("c13010".equals(s.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").O("obj_type", 2).p("fid", bhVar.getFid()).bS("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bhVar.ajy()) {
                        com.baidu.tieba.frs.d.c.bpH().a(s.this.fDi, bhVar, 1);
                        s.this.ae(bhVar);
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 4, s.this.mPageId, s.this.fDi);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpH().a(s.this.fDi, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, s.this.mPageId, s.this.fDi);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(s.this.fDi, bhVar.agH());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bpH().a(s.this.fDi, bhVar, 4);
                        s.this.ae(bhVar);
                        com.baidu.tieba.frs.d.a.a(bhVar, 4, s.this.mPageId, s.this.fDi);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, s.this.mPageId, s.this.fDi);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        s.this.ae(bhVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bpH().b(s.this.fDi, bhVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpH().b(s.this.fDi, bhVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bpH().b(s.this.fDi, bhVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bpH().b(s.this.fDi, bhVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bpH().b(s.this.fDi, bhVar, 3);
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
        com.baidu.card.x a = aVar.a(false, viewGroup, this.fcN);
        com.baidu.card.a aVar2 = new com.baidu.card.a(a);
        aVar2.setPageId(this.mPageId);
        a.b(this.dSq);
        a.aF(this.fDh);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.s.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).caz;
                    bhVar.objType = 1;
                    if (s.this.dSq != null) {
                        s.this.dSq.a(zVar.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), s.this.fDh, false);
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
            aVar.lV().setPage(this.Gc);
        }
        super.a(i, view, viewGroup, (ViewGroup) bgVar, (bg) aVar);
        com.baidu.tieba.frs.g.a(aVar.lV().lP(), this.fua);
        aVar.setVideoStatsData(af(bgVar.caz));
        aVar.lV().setPosition(i);
        if (this.fua != null && this.fua.getForum() != null && !StringUtils.isNull(this.fua.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fua.getForum().getTopic_special_icon_right())) {
            bgVar.caz.bI(this.fua.getForum().getTopic_special_icon(), this.fua.getForum().getTopic_special_icon_right());
        }
        aVar.a(bgVar.caz);
        aVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.lV().b(this.dSq);
        if (this.fDi != null) {
            int i2 = 0;
            if (this.fua != null) {
                i2 = this.fua.getTopThreadSize();
            }
            bgVar.caz.cdI = (bgVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bpH().a(this.fDi, bgVar.caz);
        com.baidu.tieba.frs.d.c.bpH().ak(bgVar.caz);
        com.baidu.tieba.frs.d.c.bpH().a(bgVar.caz, bjC());
        com.baidu.tieba.frs.d.a.a(bgVar.caz, this.mPageId, this.fDi);
        bgVar.caz.ajI();
        return aVar.getView();
    }

    private com.baidu.tieba.play.z af(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bhVar.ajF() ? "3" : "2";
        if (this.fDi.fPN == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.ePc = this.fDi.fPM;
        zVar.cma = bhVar.getTid();
        zVar.mSource = bhVar.mRecomSource;
        zVar.iyj = bhVar.ccP;
        zVar.iyk = bhVar.mRecomWeight;
        zVar.iym = bhVar.mRecomAbTag;
        if (bhVar.aiV() != null) {
            zVar.iyn = bhVar.aiV().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mW(int i) {
        this.fDh = i;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bh bhVar) {
        TiebaStatic.log(new an("c12126").bS("tid", bhVar.getId()).O("obj_locate", bjC() ? 2 : 1).p("obj_id", bhVar.aiX() == null ? -1L : bhVar.aiX().live_id).O("obj_type", 1));
    }

    public void setInFrsAllThread(boolean z) {
        this.cqi = z;
    }

    @Override // com.baidu.tieba.card.aa
    public void iM(boolean z) {
        this.fDf = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmV() {
        return this.fDi;
    }
}
