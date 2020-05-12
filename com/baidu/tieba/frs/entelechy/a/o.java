package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
public class o extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String aeB;
    private boolean agw;
    private com.baidu.tieba.card.z<bj> fsf;
    private int hgL;
    private String mFrom;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.agw = true;
        this.hgL = 3;
        this.fsf = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (o.this.gYa != null) {
                        o.this.gYa.a(view, (View) bjVar, (Object) o.this.getType());
                    }
                    if ("c13010".equals(o.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").af("obj_type", 1).t("fid", bjVar.getFid()).cI("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, o.this.mPageId, com.baidu.tieba.frs.d.d.hgM, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, o.this.mPageId, com.baidu.tieba.frs.d.d.hgM, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, o.this.mPageId, com.baidu.tieba.frs.d.d.hgM, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, o.this.mPageId, com.baidu.tieba.frs.d.d.hgM, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, o.this.mPageId, com.baidu.tieba.frs.d.d.hgM, o.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (o.this.fsf.afJ instanceof Boolean) {
                            if (((Boolean) o.this.fsf.afJ).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bjVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.hgM, o.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bjVar, 3, o.this.mPageId, com.baidu.tieba.frs.d.d.hgM, o.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, o.this.mPageId, com.baidu.tieba.frs.d.d.hgM, o.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.hgM, o.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bjVar.aJp()) {
                        o.this.ar(bjVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bUt().a(com.baidu.tieba.frs.d.d.hgM, bjVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.hgM, bjVar.aIv());
                    } else if (view instanceof TbImageView) {
                        if (o.this.fsf.afJ instanceof Boolean) {
                            if (((Boolean) o.this.fsf.afJ).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bUt().a(com.baidu.tieba.frs.d.d.hgM, bjVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.bUt().a(com.baidu.tieba.frs.d.d.hgM, bjVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bUt().a(com.baidu.tieba.frs.d.d.hgM, bjVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bjVar.aMc() != null && bjVar.aMc().cWr() != null && bjVar.aMc().cWr().bcf() != null && bjVar.aMc().cWr().bcf().size() > 0) {
                            i = bjVar.aMc().kTa ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bUt().a(com.baidu.tieba.frs.d.d.hgM, bjVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.bUt().a(com.baidu.tieba.frs.d.d.hgM, bjVar, 1);
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
        final com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) kVar);
        kVar.setFromCDN(this.agw);
        kVar.setForm("frs");
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.gEi);
        a.bc(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.frs.entelechy.a.o.2
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    if (com.baidu.tieba.frs.a.bNC().bND() && !kVar.rt()) {
                        bj bjVar = ((bi) mVar).dqE;
                        if (bjVar != null) {
                            if (!bjVar.aMl()) {
                                if (com.baidu.tieba.frs.a.bNC().ak(bjVar)) {
                                    bjVar.gA(true);
                                }
                            } else {
                                com.baidu.tieba.frs.a.bNC().al(bjVar);
                                bjVar.gA(false);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, bjVar));
                            return;
                        }
                        return;
                    }
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar2 = ((bi) mVar).dqE;
                    bjVar2.objType = 1;
                    if (o.this.fsf != null) {
                        o.this.fsf.a(afVar2.getView(), bjVar2);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar2, view.getContext(), o.this.hgL, false);
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
        this.hgL = i;
    }

    @Override // com.baidu.tieba.card.y
    public void lz(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hgM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(bj bjVar) {
        TiebaStatic.log(new an("c12126").cI("tid", bjVar.getId()).af("obj_locate", bOj() ? 2 : 1).t("obj_id", bjVar.aKV() == null ? -1L : bjVar.aKV().live_id).af("obj_type", 1));
    }
}
