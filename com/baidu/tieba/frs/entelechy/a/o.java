package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class o extends com.baidu.tieba.frs.k<bw, am<bx>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahw;
    private boolean akn;
    private com.baidu.tieba.card.ab<bx> gSh;
    private int iRX;
    private String mFrom;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.akn = true;
        this.iRX = 3;
        this.gSh = new com.baidu.tieba.card.ab<bx>() { // from class: com.baidu.tieba.frs.entelechy.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bx bxVar) {
                if (view != null && bxVar != null) {
                    if (o.this.iHH != null) {
                        o.this.iHH.a(view, (View) bxVar, (Object) o.this.getType());
                    }
                    if ("c13010".equals(o.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ak("obj_type", 1).w("fid", bxVar.getFid()).dR("tid", bxVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 2, o.this.mPageId, com.baidu.tieba.frs.d.d.iRY, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 5, o.this.mPageId, com.baidu.tieba.frs.d.d.iRY, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 14, o.this.mPageId, com.baidu.tieba.frs.d.d.iRY, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 12, o.this.mPageId, com.baidu.tieba.frs.d.d.iRY, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 13, o.this.mPageId, com.baidu.tieba.frs.d.d.iRY, o.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (o.this.gSh.aiO instanceof Boolean) {
                            if (((Boolean) o.this.gSh.aiO).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bxVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.iRY, o.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bxVar, 3, o.this.mPageId, com.baidu.tieba.frs.d.d.iRY, o.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 15, o.this.mPageId, com.baidu.tieba.frs.d.d.iRY, o.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bxVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.iRY, o.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bxVar.bki()) {
                        o.this.as(bxVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(com.baidu.tieba.frs.d.d.iRY, bxVar.bje());
                    } else if (view instanceof TbImageView) {
                        if (o.this.gSh.aiO instanceof Boolean) {
                            if (((Boolean) o.this.gSh.aiO).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ak("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bxVar.bnh() != null && bxVar.bnh().dJS() != null && bxVar.bnh().dJS().bFb() != null && bxVar.bnh().dJS().bFb().size() > 0) {
                            i = bxVar.bnh().mYp ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, 1);
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
    public am<bx> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.i) nVar);
        nVar.setFromCDN(this.akn);
        nVar.setForm("frs");
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.inB);
        a2.setSourceForPb(3);
        am<bx> amVar = new am<>(a2);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.o.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    if ((com.baidu.tieba.frs.b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI()) && !nVar.tK()) {
                        bx bxVar = ((bw) qVar).evQ;
                        if (bxVar != null) {
                            if (!bxVar.bnp() && com.baidu.tieba.frs.b.cwO().cwI()) {
                                if (com.baidu.tieba.frs.b.cwO().al(bxVar)) {
                                    bxVar.iR(true);
                                }
                            } else if (!bxVar.bnq() && com.baidu.tieba.frs.a.cwH().cwI()) {
                                if (com.baidu.tieba.frs.a.cwH().al(bxVar)) {
                                    bxVar.iS(true);
                                }
                            } else {
                                com.baidu.tieba.frs.b.cwO().am(bxVar);
                                bxVar.iR(false);
                                com.baidu.tieba.frs.a.cwH().am(bxVar);
                                bxVar.iS(false);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, bxVar));
                            return;
                        }
                        return;
                    }
                    am amVar2 = (am) view.getTag();
                    bx bxVar2 = ((bw) qVar).evQ;
                    bxVar2.objType = 1;
                    if (o.this.gSh != null) {
                        o.this.gSh.a(amVar2.getView(), bxVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bxVar2, view.getContext(), o.this.iRX, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, am<bx> amVar) {
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) amVar);
        if (bwVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tW().setPage(this.ahw);
        amVar.tW().setPosition(i);
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.iHB);
        if (this.iHB != null && this.iHB.getForum() != null && !StringUtils.isNull(this.iHB.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iHB.getForum().getTopic_special_icon_right())) {
            bwVar.evQ.dE(this.iHB.getForum().getTopic_special_icon(), this.iHB.getForum().getTopic_special_icon_right());
        }
        amVar.b((am<bx>) bwVar.evQ);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gSh);
        bwVar.evQ.bmQ();
        return amVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
        this.iRX = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void oD(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return iRY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bx bxVar) {
        TiebaStatic.log(new ar("c12126").dR("tid", bxVar.getId()).ak("obj_locate", cxB() ? 2 : 1).w("obj_id", bxVar.blW() == null ? -1L : bxVar.blW().live_id).ak("obj_type", 1));
    }
}
