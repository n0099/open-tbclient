package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class p extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bh>> implements com.baidu.adp.widget.ListView.s, com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String GC;
    private ab<bh> dTc;
    private int fDY;
    private String mFrom;

    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fDY = 3;
        this.dTc = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (p.this.fuX != null) {
                        p.this.fuX.a(view, (View) bhVar, (Object) p.this.getType());
                    }
                    if ("c13010".equals(p.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").O("obj_type", 1).p("fid", bhVar.getFid()).bS("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bhVar.ajA()) {
                        p.this.ae(bhVar);
                    }
                    if ((view instanceof ThreadSmartAppLayout) || view.getId() == R.id.iv_thread_smart_app_head || view.getId() == R.id.tv_thread_smart_app_title || view.getId() == R.id.tv_thread_smart_app_abstract) {
                        com.baidu.tieba.card.n.uz(bhVar.getTid());
                        if (bhVar.ajs() != null) {
                            TiebaStatic.log(new an("c13274").p("uid", TbadkCoreApplication.getCurrentAccountId()).p("fid", bhVar.getFid()).bS("obj_source", "frs_card").p("obj_id", bhVar.ajs().swan_app_id.longValue()).bS("obj_name", bhVar.ajs().name).bS("tid", bhVar.getTid()).O("obj_param1", bhVar.ajs().is_game.intValue()));
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.frs.d.c.bpJ().a(com.baidu.tieba.frs.d.d.fDZ, bhVar, 1);
                    com.baidu.tieba.frs.d.a.a(bhVar, 1, p.this.mPageId, com.baidu.tieba.frs.d.d.fDZ);
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
        aVar.a((com.baidu.card.f) new com.baidu.card.v(this.mPageContext.getPageActivity()));
        com.baidu.card.x a = aVar.a(false, viewGroup, this.fdE);
        a.aF(3);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        a((com.baidu.adp.widget.ListView.s) this);
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
        zVar.a(bgVar.cbq);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.dTc);
        bgVar.cbq.ajK();
        return zVar.getView();
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
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmX() {
        return fDZ;
    }

    @Override // com.baidu.adp.widget.ListView.s
    public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
            com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
            bh bhVar = ((bg) mVar).cbq;
            bhVar.objType = 1;
            if (this.dTc != null) {
                this.dTc.a(zVar.getView(), bhVar);
            }
            au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), this.fDY, false);
            zVar.lV().b(new a.C0044a(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bh bhVar) {
        TiebaStatic.log(new an("c12126").bS("tid", bhVar.getId()).O("obj_locate", bjE() ? 2 : 1).p("obj_id", bhVar.aiZ() == null ? -1L : bhVar.aiZ().live_id).O("obj_type", 1));
    }
}
