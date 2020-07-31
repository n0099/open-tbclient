package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class o extends com.baidu.tieba.frs.j<bu, com.baidu.card.ak<bv>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String afx;
    private boolean aib;
    private com.baidu.tieba.card.aa<bv> fWK;
    private int hOD;
    private String mFrom;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aib = true;
        this.hOD = 3;
        this.fWK = new com.baidu.tieba.card.aa<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    if (o.this.hFd != null) {
                        o.this.hFd.a(view, (View) bvVar, (Object) o.this.getType());
                    }
                    if ("c13010".equals(o.this.mFrom)) {
                        TiebaStatic.log(new ap("c13010").ah("obj_type", 1).t("fid", bvVar.getFid()).dn("tid", bvVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 2, o.this.mPageId, com.baidu.tieba.frs.d.d.hOE, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 5, o.this.mPageId, com.baidu.tieba.frs.d.d.hOE, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 14, o.this.mPageId, com.baidu.tieba.frs.d.d.hOE, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 12, o.this.mPageId, com.baidu.tieba.frs.d.d.hOE, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 13, o.this.mPageId, com.baidu.tieba.frs.d.d.hOE, o.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (o.this.fWK.agK instanceof Boolean) {
                            if (((Boolean) o.this.fWK.agK).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bvVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.hOE, o.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bvVar, 3, o.this.mPageId, com.baidu.tieba.frs.d.d.hOE, o.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 15, o.this.mPageId, com.baidu.tieba.frs.d.d.hOE, o.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bvVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.hOE, o.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bvVar.aUR()) {
                        o.this.ap(bvVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOE, bvVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.hOE, bvVar.aTO());
                    } else if (view instanceof TbImageView) {
                        if (o.this.fWK.agK instanceof Boolean) {
                            if (((Boolean) o.this.fWK.agK).booleanValue()) {
                                com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOE, bvVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOE, bvVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOE, bvVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bvVar.aXO() != null && bvVar.aXO().dlj() != null && bvVar.aXO().dlj().boJ() != null && bvVar.aXO().dlj().boJ().size() > 0) {
                            i = bvVar.aXO().lNH ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOE, bvVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOE, bvVar, 1);
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
    /* renamed from: aR */
    public com.baidu.card.ak<bv> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) lVar);
        lVar.setFromCDN(this.aib);
        lVar.setForm("frs");
        com.baidu.card.ai a = aVar.a(false, viewGroup, this.hlu);
        a.setSourceForPb(3);
        com.baidu.card.ak<bv> akVar = new com.baidu.card.ak<>(a);
        akVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.o.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bu) && (view.getTag() instanceof com.baidu.card.ak)) {
                    if ((com.baidu.tieba.frs.b.caw().caq() || com.baidu.tieba.frs.a.cap().caq()) && !lVar.rU()) {
                        bv bvVar = ((bu) qVar).dLK;
                        if (bvVar != null) {
                            if (!bvVar.aXW() && com.baidu.tieba.frs.b.caw().caq()) {
                                if (com.baidu.tieba.frs.b.caw().ai(bvVar)) {
                                    bvVar.hE(true);
                                }
                            } else if (!bvVar.aXX() && com.baidu.tieba.frs.a.cap().caq()) {
                                if (com.baidu.tieba.frs.a.cap().ai(bvVar)) {
                                    bvVar.hF(true);
                                }
                            } else {
                                com.baidu.tieba.frs.b.caw().aj(bvVar);
                                bvVar.hE(false);
                                com.baidu.tieba.frs.a.cap().aj(bvVar);
                                bvVar.hF(false);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, bvVar));
                            return;
                        }
                        return;
                    }
                    com.baidu.card.ak akVar2 = (com.baidu.card.ak) view.getTag();
                    bv bvVar2 = ((bu) qVar).dLK;
                    bvVar2.objType = 1;
                    if (o.this.fWK != null) {
                        o.this.fWK.a(akVar2.getView(), bvVar2);
                    }
                    ax.a((AbsThreadDataSupport) bvVar2, view.getContext(), o.this.hOD, false);
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, com.baidu.card.ak<bv> akVar) {
        super.a(i, view, viewGroup, (ViewGroup) buVar, (bu) akVar);
        if (buVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        akVar.sg().setPage(this.afx);
        akVar.sg().setPosition(i);
        com.baidu.tieba.frs.i.a(akVar.sg().sa(), this.hEX);
        if (this.hEX != null && this.hEX.getForum() != null && !StringUtils.isNull(this.hEX.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hEX.getForum().getTopic_special_icon_right())) {
            buVar.dLK.de(this.hEX.getForum().getTopic_special_icon(), this.hEX.getForum().getTopic_special_icon_right());
        }
        akVar.b((com.baidu.card.ak<bv>) buVar.dLK);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.fWK);
        buVar.dLK.aXx();
        return akVar.getView();
    }

    @Override // com.baidu.tieba.frs.j
    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
        this.hOD = i;
    }

    @Override // com.baidu.tieba.card.z
    public void mJ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hOE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bv bvVar) {
        TiebaStatic.log(new ap("c12126").dn("tid", bvVar.getId()).ah("obj_locate", cbj() ? 2 : 1).t("obj_id", bvVar.aWF() == null ? -1L : bvVar.aWF().live_id).ah("obj_type", 1));
    }
}
