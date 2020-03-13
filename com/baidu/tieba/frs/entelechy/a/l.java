package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class l extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private String LC;
    private boolean NJ;
    private com.baidu.tieba.card.z<bj> eNk;
    private int gwB;
    private String mFrom;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.NJ = true;
        this.gwB = 3;
        this.eNk = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (l.this.gof != null) {
                        l.this.gof.a(view, (View) bjVar, (Object) l.this.getType());
                    }
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").X("obj_type", 1).s("fid", bjVar.getFid()).cy("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, l.this.mPageId, com.baidu.tieba.frs.d.d.gwC, l.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, l.this.mPageId, com.baidu.tieba.frs.d.d.gwC, l.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, l.this.mPageId, com.baidu.tieba.frs.d.d.gwC, l.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (l.this.eNk.MU instanceof Boolean) {
                            if (((Boolean) l.this.eNk.MU).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bjVar, 1, l.this.mPageId, com.baidu.tieba.frs.d.d.gwC, l.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bjVar, 3, l.this.mPageId, com.baidu.tieba.frs.d.d.gwC, l.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, l.this.mPageId, com.baidu.tieba.frs.d.d.gwC, l.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, l.this.mPageId, com.baidu.tieba.frs.d.d.gwC, l.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bjVar.aBb()) {
                        l.this.ao(bjVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJK().a(com.baidu.tieba.frs.d.d.gwC, bjVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.gwC, bjVar.aAh());
                    } else if (view instanceof TbImageView) {
                        if (l.this.eNk.MU instanceof Boolean) {
                            if (((Boolean) l.this.eNk.MU).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bJK().a(com.baidu.tieba.frs.d.d.gwC, bjVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.bJK().a(com.baidu.tieba.frs.d.d.gwC, bjVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bJK().a(com.baidu.tieba.frs.d.d.gwC, bjVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bjVar.aDM() != null && bjVar.aDM().cLd() != null && bjVar.aDM().cLd().aTT() != null && bjVar.aDM().cLd().aTT().size() > 0) {
                            i = bjVar.aDM().khn ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bJK().a(com.baidu.tieba.frs.d.d.gwC, bjVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.bJK().a(com.baidu.tieba.frs.d.d.gwC, bjVar, 1);
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
    /* renamed from: aM */
    public com.baidu.card.af<bj> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.v vVar = new com.baidu.card.v(this.mPageContext.getPageActivity());
        vVar.setFrom("frs");
        vVar.setFromCDN(this.NJ);
        aVar.c(vVar);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.fWQ);
        a.aQ(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        afVar.ai(false);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cRg;
                    bjVar.objType = 1;
                    if (l.this.eNk != null) {
                        l.this.eNk.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), l.this.gwB, false);
                    afVar2.nk().b(new a.C0052a(1));
                }
            }
        });
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
        afVar.nk().setPage(this.LC);
        afVar.nk().setPosition(i);
        com.baidu.tieba.frs.g.a(afVar.nk().ne(), this.gnZ);
        if (this.gnZ != null && this.gnZ.getForum() != null && !StringUtils.isNull(this.gnZ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.gnZ.getForum().getTopic_special_icon_right())) {
            biVar.cRg.cp(this.gnZ.getForum().getTopic_special_icon(), this.gnZ.getForum().getTopic_special_icon_right());
        }
        afVar.b((com.baidu.card.af<bj>) biVar.cRg);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.eNk);
        biVar.cRg.aDw();
        return afVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
        this.gwB = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bGY() {
        return gwC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(bj bjVar) {
        TiebaStatic.log(new an("c12126").cy("tid", bjVar.getId()).X("obj_locate", bDD() ? 2 : 1).s("obj_id", bjVar.aCH() == null ? -1L : bjVar.aCH().live_id).X("obj_type", 1));
    }
}
