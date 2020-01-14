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
/* loaded from: classes7.dex */
public class w extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String Lg;
    private com.baidu.tieba.card.z<bj> eJc;
    private int gum;
    private String mFrom;

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.gum = 3;
        this.eJc = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (w.this.glP != null) {
                        w.this.glP.a(view, (View) bjVar, (Object) w.this.getType());
                    }
                    if ("c13010".equals(w.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").Z("obj_type", 1).s("fid", bjVar.getFid()).cp("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, w.this.mPageId, com.baidu.tieba.frs.d.d.gun, w.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (w.this.eJc.Ms instanceof Boolean) {
                            if (((Boolean) w.this.eJc.Ms).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bjVar, 1, w.this.mPageId, com.baidu.tieba.frs.d.d.gun, w.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bjVar, 3, w.this.mPageId, com.baidu.tieba.frs.d.d.gun, w.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, w.this.mPageId, com.baidu.tieba.frs.d.d.gun, w.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, w.this.mPageId, com.baidu.tieba.frs.d.d.gun, w.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bjVar.aAX()) {
                        w.this.am(bjVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.gun, bjVar.axR());
                    } else if (view instanceof TbImageView) {
                        if (w.this.eJc.Ms instanceof Boolean) {
                            if (((Boolean) w.this.eJc.Ms).booleanValue()) {
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
                        if (bjVar.aBx() != null && bjVar.aBx().cJB() != null && bjVar.aBx().cJB().aRz() != null && bjVar.aBx().cJB().aRz().size() > 0) {
                            i = bjVar.aBx().kfY ? 9 : 8;
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
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), true);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aH(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.w.2
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
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.fUA);
        a.aM(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        afVar.af(false);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.w.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cNb;
                    bjVar.objType = 1;
                    if (w.this.eJc != null) {
                        w.this.eJc.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), w.this.gum, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
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
        if (!biVar.cNb.isBjh()) {
            afVar.mW();
        }
        afVar.b((com.baidu.card.af<bj>) biVar.cNb);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.eJc);
        biVar.cNb.aBh();
        if (gun != null) {
            int i2 = 0;
            if (this.glJ != null) {
                i2 = this.glJ.getTopThreadSize();
            }
            biVar.cNb.cLB = (biVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.bIf().a(gun, biVar.cNb);
        biVar.cNb.aBh();
        com.baidu.tieba.frs.d.a.a(biVar.cNb, this.mPageId, gun, getTbPageTag());
        if (biVar != null) {
            biVar.cNb.aBh();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void am(bj bjVar) {
        TiebaStatic.log(new an("c12126").cp("tid", bjVar.getId()).Z("obj_locate", bBX() ? 2 : 1).s("obj_id", bjVar.aAq() == null ? -1L : bjVar.aAq().live_id).Z("obj_type", 1));
    }
}
