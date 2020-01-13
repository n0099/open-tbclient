package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadSmartAppLayout;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class u extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.adp.widget.ListView.s, com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String Lg;
    private com.baidu.tieba.card.z<bj> eJc;
    private int gum;
    private String mFrom;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.gum = 3;
        this.eJc = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (u.this.glP != null) {
                        u.this.glP.a(view, (View) bjVar, (Object) u.this.getType());
                    }
                    if ("c13010".equals(u.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").Z("obj_type", 1).s("fid", bjVar.getFid()).cp("tid", bjVar.getTid()));
                    }
                    com.baidu.tieba.frs.d.a.a(bjVar, 1, u.this.mPageId, com.baidu.tieba.frs.d.d.gun, u.this.getTbPageTag());
                    if (view.getId() == R.id.thread_card_root && bjVar.aAX()) {
                        u.this.am(bjVar);
                    }
                    if ((view instanceof ThreadSmartAppLayout) || view.getId() == R.id.iv_thread_smart_app_head || view.getId() == R.id.tv_thread_smart_app_title || view.getId() == R.id.tv_thread_smart_app_abstract) {
                        com.baidu.tieba.card.l.zC(bjVar.getTid());
                        if (bjVar.aAJ() != null) {
                            TiebaStatic.log(new an("c13274").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("fid", bjVar.getFid()).cp("obj_source", "frs_card").s("obj_id", bjVar.aAJ().swan_app_id.longValue()).cp("obj_name", bjVar.aAJ().name).cp("tid", bjVar.getTid()).Z("obj_param1", bjVar.aAJ().is_game.intValue()));
                            return;
                        }
                        return;
                    }
                    com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, 1);
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public com.baidu.card.af<bj> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        aVar.a((com.baidu.card.h) new com.baidu.card.ab(this.mPageContext.getPageActivity()));
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.fUA);
        a.aM(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        a((com.baidu.adp.widget.ListView.s) this);
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.card.af<bj> afVar) {
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) afVar);
        if (biVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        afVar.mU().setPage(this.Lg);
        afVar.mU().setPosition(i);
        afVar.b((com.baidu.card.af<bj>) biVar.cNb);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.eJc);
        biVar.cNb.aBh();
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void po(int i) {
        this.gum = i;
    }

    @Override // com.baidu.tieba.card.y
    public void kp(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bFt() {
        return gun;
    }

    @Override // com.baidu.adp.widget.ListView.s
    public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
        if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
            com.baidu.card.af afVar = (com.baidu.card.af) view.getTag();
            bj bjVar = ((bi) mVar).cNb;
            bjVar.objType = 1;
            if (this.eJc != null) {
                this.eJc.a(afVar.getView(), bjVar);
            }
            au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), this.gum, false);
            afVar.mU().b(new a.C0050a(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(bj bjVar) {
        TiebaStatic.log(new an("c12126").cp("tid", bjVar.getId()).Z("obj_locate", bBX() ? 2 : 1).s("obj_id", bjVar.aAq() == null ? -1L : bjVar.aAq().live_id).Z("obj_type", 1));
    }
}
