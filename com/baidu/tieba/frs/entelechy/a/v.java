package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public class v extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private String aeB;
    private boolean agw;
    private com.baidu.tieba.card.z<bj> fsf;
    private int hgI;
    private String mFrom;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.agw = true;
        this.fsf = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (v.this.gYa != null) {
                        v.this.gYa.a(view, (View) bjVar, (Object) v.this.getType());
                    }
                    if ("c13010".equals(v.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").af("obj_type", 1).t("fid", bjVar.getFid()).cI("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, v.this.mPageId, com.baidu.tieba.frs.d.d.hgM, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, v.this.mPageId, com.baidu.tieba.frs.d.d.hgM, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, v.this.mPageId, com.baidu.tieba.frs.d.d.hgM, v.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (v.this.fsf.afJ instanceof Boolean) {
                            if (((Boolean) v.this.fsf.afJ).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bjVar, 1, v.this.mPageId, com.baidu.tieba.frs.d.d.hgM, v.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bjVar, 3, v.this.mPageId, com.baidu.tieba.frs.d.d.hgM, v.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, v.this.mPageId, com.baidu.tieba.frs.d.d.hgM, v.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, v.this.mPageId, com.baidu.tieba.frs.d.d.hgM, v.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bUs().a(com.baidu.tieba.frs.d.d.hgM, bjVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.hgM, bjVar.aIv());
                    } else if (view instanceof TbImageView) {
                        if (v.this.fsf.afJ instanceof Boolean) {
                            if (((Boolean) v.this.fsf.afJ).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bUs().a(com.baidu.tieba.frs.d.d.hgM, bjVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.bUs().a(com.baidu.tieba.frs.d.d.hgM, bjVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bUs().a(com.baidu.tieba.frs.d.d.hgM, bjVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bjVar.aMc() != null && bjVar.aMc().cWq() != null && bjVar.aMc().cWq().bcf() != null && bjVar.aMc().cWq().bcf().size() > 0) {
                            i = bjVar.aMc().kTa ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bUs().a(com.baidu.tieba.frs.d.d.hgM, bjVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.bUs().a(com.baidu.tieba.frs.d.d.hgM, bjVar, 1);
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
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.u uVar = new com.baidu.card.u(this.mPageContext.getPageActivity());
        uVar.setFrom("frs");
        uVar.setFromCDN(this.agw);
        if (this.hgI == 502) {
            uVar.setNeedFrsTabName(false);
        } else {
            uVar.setNeedFrsTabName(true);
        }
        aVar.c(uVar);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.gEi);
        a.bc(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        afVar.aH(false);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.frs.entelechy.a.v.2
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).dqE;
                    bjVar.objType = 1;
                    if (v.this.fsf != null) {
                        v.this.fsf.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 3, false);
                    afVar2.rD().b(new a.C0095a(1));
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
        afVar.rD().setPage(this.aeB);
        afVar.rD().setPosition(i);
        com.baidu.tieba.frs.g.a(afVar.rD().rx(), this.gXU);
        if (this.gXU != null && this.gXU.getForum() != null && !StringUtils.isNull(this.gXU.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.gXU.getForum().getTopic_special_icon_right())) {
            biVar.dqE.cz(this.gXU.getForum().getTopic_special_icon(), this.gXU.getForum().getTopic_special_icon_right());
        }
        afVar.b((com.baidu.card.af<bj>) biVar.dqE);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.fsf);
        biVar.dqE.aLL();
        com.baidu.card.u uVar = (com.baidu.card.u) afVar.rD().rw();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) uVar.adU.ahf.getLayoutParams();
        layoutParams.width = biVar.dqF;
        layoutParams.height = biVar.dqG;
        if (uVar.adU.ahf.getVisibility() != 8) {
            uVar.adU.ahf.setLayoutParams(layoutParams);
        }
        return afVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.agw = z;
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.hgI = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hgM;
    }
}
