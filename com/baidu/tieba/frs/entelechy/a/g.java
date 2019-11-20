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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String Gc;
    private boolean Hx;
    private boolean cqi;
    private ab<bh> dSl;
    private int fDh;
    private String mFrom;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.cqi = false;
        this.Hx = true;
        this.fDh = 3;
        this.dSl = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (g.this.fug != null) {
                        g.this.fug.a(view, (View) bhVar, (Object) g.this.getType());
                    }
                    if ("c13010".equals(g.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").O("obj_type", 1).p("fid", bhVar.getFid()).bS("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bhVar.ajy()) {
                        g.this.ae(bhVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpH().a(com.baidu.tieba.frs.d.d.fDi, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, g.this.mPageId, com.baidu.tieba.frs.d.d.fDi);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fDi, bhVar.agH());
                    } else if (view instanceof TbImageView) {
                        if (g.this.dSl.Hc instanceof Boolean) {
                            if (((Boolean) g.this.dSl.Hc).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bpH().a(com.baidu.tieba.frs.d.d.fDi, bhVar, 1);
                                com.baidu.tieba.frs.d.a.a(bhVar, 1, g.this.mPageId, com.baidu.tieba.frs.d.d.fDi);
                                return;
                            }
                            com.baidu.tieba.frs.d.c.bpH().a(com.baidu.tieba.frs.d.d.fDi, bhVar, 3);
                            com.baidu.tieba.frs.d.a.a(bhVar, 3, g.this.mPageId, com.baidu.tieba.frs.d.d.fDi);
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bpH().a(com.baidu.tieba.frs.d.d.fDi, bhVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bhVar.akb() != null && bhVar.akb().cop() != null && bhVar.akb().cop().azf() != null && bhVar.akb().cop().azf().size() > 0) {
                            i = bhVar.akb().jie ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bpH().a(com.baidu.tieba.frs.d.d.fDi, bhVar, i);
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, g.this.mPageId, com.baidu.tieba.frs.d.d.fDi);
                    } else {
                        com.baidu.tieba.frs.d.c.bpH().a(com.baidu.tieba.frs.d.d.fDi, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, g.this.mPageId, com.baidu.tieba.frs.d.d.fDi);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.z<bh> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.r rVar = new com.baidu.card.r(this.mPageContext.getPageActivity());
        rVar.setFrom("frs");
        rVar.setFromCDN(this.Hx);
        aVar.b(rVar);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.fcN);
        a.aF(3);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        zVar.Y(false);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.g.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).caz;
                    bhVar.objType = 1;
                    if (g.this.dSl != null) {
                        g.this.dSl.a(zVar2.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), g.this.fDh, false);
                    zVar2.lV().b(new a.C0044a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.z<bh> zVar) {
        super.a(i, view, viewGroup, (ViewGroup) bgVar, (bg) zVar);
        if (bgVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        zVar.lV().setPage(this.Gc);
        zVar.lV().setPosition(i);
        com.baidu.tieba.frs.g.a(zVar.lV().lP(), this.fua);
        if (this.fua != null && this.fua.getForum() != null && !StringUtils.isNull(this.fua.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fua.getForum().getTopic_special_icon_right())) {
            bgVar.caz.bI(this.fua.getForum().getTopic_special_icon(), this.fua.getForum().getTopic_special_icon_right());
        }
        zVar.a(bgVar.caz);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.dSl);
        bgVar.caz.ajI();
        return zVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Hx = z;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void mW(int i) {
        this.fDh = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmV() {
        return fDi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bh bhVar) {
        TiebaStatic.log(new an("c12126").bS("tid", bhVar.getId()).O("obj_locate", bjC() ? 2 : 1).p("obj_id", bhVar.aiX() == null ? -1L : bhVar.aiX().live_id).O("obj_type", 1));
    }
}
