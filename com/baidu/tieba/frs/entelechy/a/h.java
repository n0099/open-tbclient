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
public class h extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String GC;
    private boolean HY;
    private boolean cqZ;
    private ab<bh> dTc;
    private boolean fDW;
    private int fDY;
    private String mFrom;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fDW = false;
        this.cqZ = false;
        this.HY = true;
        this.fDY = 3;
        this.dTc = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (h.this.fuX != null) {
                        h.this.fuX.a(view, (View) bhVar, (Object) h.this.getType());
                    }
                    if ("c13010".equals(h.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").O("obj_type", 1).p("fid", bhVar.getFid()).bS("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bhVar.ajA()) {
                        h.this.ae(bhVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpJ().a(com.baidu.tieba.frs.d.d.fDZ, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, h.this.mPageId, com.baidu.tieba.frs.d.d.fDZ);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fDZ, bhVar.agJ());
                    } else if (view instanceof TbImageView) {
                        if (h.this.dTc.HC instanceof Boolean) {
                            if (((Boolean) h.this.dTc.HC).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bpJ().a(com.baidu.tieba.frs.d.d.fDZ, bhVar, 1);
                                com.baidu.tieba.frs.d.a.a(bhVar, 1, h.this.mPageId, com.baidu.tieba.frs.d.d.fDZ);
                                return;
                            }
                            com.baidu.tieba.frs.d.c.bpJ().a(com.baidu.tieba.frs.d.d.fDZ, bhVar, 3);
                            com.baidu.tieba.frs.d.a.a(bhVar, 3, h.this.mPageId, com.baidu.tieba.frs.d.d.fDZ);
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bpJ().a(com.baidu.tieba.frs.d.d.fDZ, bhVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bhVar.akd() != null && bhVar.akd().cor() != null && bhVar.akd().cor().azh() != null && bhVar.akd().cor().azh().size() > 0) {
                            i = bhVar.akd().jiV ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bpJ().a(com.baidu.tieba.frs.d.d.fDZ, bhVar, i);
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, h.this.mPageId, com.baidu.tieba.frs.d.d.fDZ);
                    } else {
                        com.baidu.tieba.frs.d.c.bpJ().a(com.baidu.tieba.frs.d.d.fDZ, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, h.this.mPageId, com.baidu.tieba.frs.d.d.fDZ);
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
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.f) hVar);
        hVar.setFromCDN(this.HY);
        hVar.setForm("frs");
        com.baidu.card.x a = aVar.a(false, viewGroup, this.fdE);
        a.aF(3);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.h.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).cbq;
                    bhVar.objType = 1;
                    if (h.this.dTc != null) {
                        h.this.dTc.a(zVar2.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), h.this.fDY, false);
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
        zVar.lV().setPage(this.GC);
        zVar.lV().setPosition(i);
        com.baidu.tieba.frs.g.a(zVar.lV().lP(), this.fuR);
        if (this.fuR != null && this.fuR.getForum() != null && !StringUtils.isNull(this.fuR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fuR.getForum().getTopic_special_icon_right())) {
            bgVar.cbq.bI(this.fuR.getForum().getTopic_special_icon(), this.fuR.getForum().getTopic_special_icon_right());
        }
        zVar.a(bgVar.cbq);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.dTc);
        bgVar.cbq.ajK();
        return zVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.HY = z;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void mX(int i) {
        this.fDY = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void iM(boolean z) {
        this.fDW = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmX() {
        return fDZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bh bhVar) {
        TiebaStatic.log(new an("c12126").bS("tid", bhVar.getId()).O("obj_locate", bjE() ? 2 : 1).p("obj_id", bhVar.aiZ() == null ? -1L : bhVar.aiZ().live_id).O("obj_type", 1));
    }
}
