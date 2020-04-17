package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.e;
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
public class y extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String aey;
    private com.baidu.tieba.card.z<bj> fsa;
    private int hgF;
    private String mFrom;

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hgF = 3;
        this.fsa = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (y.this.gXU != null) {
                        y.this.gXU.a(view, (View) bjVar, (Object) y.this.getType());
                    }
                    if ("c13010".equals(y.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").af("obj_type", 1).t("fid", bjVar.getFid()).cI("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, y.this.mPageId, com.baidu.tieba.frs.d.d.hgG, y.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (y.this.fsa.afG instanceof Boolean) {
                            if (((Boolean) y.this.fsa.afG).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bjVar, 1, y.this.mPageId, com.baidu.tieba.frs.d.d.hgG, y.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bjVar, 3, y.this.mPageId, com.baidu.tieba.frs.d.d.hgG, y.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, y.this.mPageId, com.baidu.tieba.frs.d.d.hgG, y.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, y.this.mPageId, com.baidu.tieba.frs.d.d.hgG, y.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bjVar.aJr()) {
                        y.this.ar(bjVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bUu().a(com.baidu.tieba.frs.d.d.hgG, bjVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.hgG, bjVar.aIx());
                    } else if (view instanceof TbImageView) {
                        if (y.this.fsa.afG instanceof Boolean) {
                            if (((Boolean) y.this.fsa.afG).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bUu().a(com.baidu.tieba.frs.d.d.hgG, bjVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.bUu().a(com.baidu.tieba.frs.d.d.hgG, bjVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bUu().a(com.baidu.tieba.frs.d.d.hgG, bjVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bjVar.aMe() != null && bjVar.aMe().cWt() != null && bjVar.aMe().cWt().bch() != null && bjVar.aMe().cWt().bch().size() > 0) {
                            i = bjVar.aMe().kSW ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bUu().a(com.baidu.tieba.frs.d.d.hgG, bjVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.bUu().a(com.baidu.tieba.frs.d.d.hgG, bjVar, 1);
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
    /* renamed from: aA */
    public com.baidu.card.af<bj> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), true);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aW(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.y.2
            @Override // com.baidu.card.e.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.gEc);
        a.bc(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        afVar.aH(false);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.frs.entelechy.a.y.3
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).dqA;
                    bjVar.objType = 1;
                    if (y.this.fsa != null) {
                        y.this.fsa.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), y.this.hgF, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar2.rD().b(new a.C0074a(1));
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
        afVar.rD().setPage(this.aey);
        afVar.rD().setPosition(i);
        com.baidu.tieba.frs.g.a(afVar.rD().rx(), this.gXO);
        if (this.gXO != null && this.gXO.getForum() != null && !StringUtils.isNull(this.gXO.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.gXO.getForum().getTopic_special_icon_right())) {
            biVar.dqA.cz(this.gXO.getForum().getTopic_special_icon(), this.gXO.getForum().getTopic_special_icon_right());
        }
        if (!biVar.dqA.isBjh()) {
            afVar.rF();
        }
        afVar.b((com.baidu.card.af<bj>) biVar.dqA);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.fsa);
        biVar.dqA.aLN();
        if (hgG != null) {
            int i2 = 0;
            if (this.gXO != null) {
                i2 = this.gXO.getTopThreadSize();
            }
            biVar.dqA.doZ = (biVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bUu().a(hgG, biVar.dqA);
        biVar.dqA.aLN();
        com.baidu.tieba.frs.d.a.a(biVar.dqA, this.mPageId, hgG, getTbPageTag());
        if (biVar != null) {
            biVar.dqA.aLN();
        }
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.hgF = i;
    }

    @Override // com.baidu.tieba.card.y
    public void lz(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hgG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(bj bjVar) {
        TiebaStatic.log(new an("c12126").cI("tid", bjVar.getId()).af("obj_locate", bOk() ? 2 : 1).t("obj_id", bjVar.aKX() == null ? -1L : bjVar.aKX().live_id).af("obj_type", 1));
    }
}
