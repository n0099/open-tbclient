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
/* loaded from: classes7.dex */
public class l extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private String Lg;
    private boolean Nj;
    private com.baidu.tieba.card.z<bj> eJc;
    private int gum;
    private String mFrom;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.Nj = true;
        this.gum = 3;
        this.eJc = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (l.this.glP != null) {
                        l.this.glP.a(view, (View) bjVar, (Object) l.this.getType());
                    }
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").Z("obj_type", 1).s("fid", bjVar.getFid()).cp("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, l.this.mPageId, com.baidu.tieba.frs.d.d.gun, l.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, l.this.mPageId, com.baidu.tieba.frs.d.d.gun, l.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, l.this.mPageId, com.baidu.tieba.frs.d.d.gun, l.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (l.this.eJc.Ms instanceof Boolean) {
                            if (((Boolean) l.this.eJc.Ms).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bjVar, 1, l.this.mPageId, com.baidu.tieba.frs.d.d.gun, l.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bjVar, 3, l.this.mPageId, com.baidu.tieba.frs.d.d.gun, l.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, l.this.mPageId, com.baidu.tieba.frs.d.d.gun, l.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, l.this.mPageId, com.baidu.tieba.frs.d.d.gun, l.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bjVar.aAX()) {
                        l.this.am(bjVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.gun, bjVar.axR());
                    } else if (view instanceof TbImageView) {
                        if (l.this.eJc.Ms instanceof Boolean) {
                            if (((Boolean) l.this.eJc.Ms).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bjVar.aBx() != null && bjVar.aBx().cJz() != null && bjVar.aBx().cJz().aRz() != null && bjVar.aBx().cJz().aRz().size() > 0) {
                            i = bjVar.aBx().kfT ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, 1);
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
        vVar.setFromCDN(this.Nj);
        aVar.c(vVar);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.fUA);
        a.aM(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        afVar.af(false);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cNb;
                    bjVar.objType = 1;
                    if (l.this.eJc != null) {
                        l.this.eJc.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), l.this.gum, false);
                    afVar2.mU().b(new a.C0050a(1));
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
        afVar.mU().setPage(this.Lg);
        afVar.mU().setPosition(i);
        com.baidu.tieba.frs.g.a(afVar.mU().mO(), this.glJ);
        if (this.glJ != null && this.glJ.getForum() != null && !StringUtils.isNull(this.glJ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.glJ.getForum().getTopic_special_icon_right())) {
            biVar.cNb.cg(this.glJ.getForum().getTopic_special_icon(), this.glJ.getForum().getTopic_special_icon_right());
        }
        afVar.b((com.baidu.card.af<bj>) biVar.cNb);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.eJc);
        biVar.cNb.aBh();
        return afVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Nj = z;
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

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bFt() {
        return gun;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(bj bjVar) {
        TiebaStatic.log(new an("c12126").cp("tid", bjVar.getId()).Z("obj_locate", bBX() ? 2 : 1).s("obj_id", bjVar.aAq() == null ? -1L : bjVar.aAq().live_id).Z("obj_type", 1));
    }
}
