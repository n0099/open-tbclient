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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class o extends com.baidu.tieba.frs.k<bv, am<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahc;
    private boolean ajR;
    private com.baidu.tieba.card.aa<bw> glU;
    private int ijU;
    private String mFrom;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ajR = true;
        this.ijU = 3;
        this.glU = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (o.this.hZz != null) {
                        o.this.hZz.a(view, (View) bwVar, (Object) o.this.getType());
                    }
                    if ("c13010".equals(o.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 1).u("fid", bwVar.getFid()).dF("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, o.this.mPageId, com.baidu.tieba.frs.d.d.ijV, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, o.this.mPageId, com.baidu.tieba.frs.d.d.ijV, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, o.this.mPageId, com.baidu.tieba.frs.d.d.ijV, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, o.this.mPageId, com.baidu.tieba.frs.d.d.ijV, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, o.this.mPageId, com.baidu.tieba.frs.d.d.ijV, o.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (o.this.glU.aiq instanceof Boolean) {
                            if (((Boolean) o.this.glU.aiq).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bwVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.ijV, o.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bwVar, 3, o.this.mPageId, com.baidu.tieba.frs.d.d.ijV, o.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, o.this.mPageId, com.baidu.tieba.frs.d.d.ijV, o.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.ijV, o.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bwVar.bee()) {
                        o.this.aq(bwVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cvK().a(com.baidu.tieba.frs.d.d.ijV, bwVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(com.baidu.tieba.frs.d.d.ijV, bwVar.bcZ());
                    } else if (view instanceof TbImageView) {
                        if (o.this.glU.aiq instanceof Boolean) {
                            if (((Boolean) o.this.glU.aiq).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cvK().a(com.baidu.tieba.frs.d.d.ijV, bwVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cvK().a(com.baidu.tieba.frs.d.d.ijV, bwVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cvK().a(com.baidu.tieba.frs.d.d.ijV, bwVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bwVar.bhb() != null && bwVar.bhb().dAF() != null && bwVar.bhb().dAF().byG() != null && bwVar.bhb().dAF().byG().size() > 0) {
                            i = bwVar.bhb().mph ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cvK().a(com.baidu.tieba.frs.d.d.ijV, bwVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.cvK().a(com.baidu.tieba.frs.d.d.ijV, bwVar, 1);
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
    public am<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.i) nVar);
        nVar.setFromCDN(this.ajR);
        nVar.setForm("frs");
        com.baidu.card.ak a = aVar.a(false, viewGroup, this.hFt);
        a.setSourceForPb(3);
        am<bw> amVar = new am<>(a);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.o.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    if ((com.baidu.tieba.frs.b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa()) && !nVar.tK()) {
                        bw bwVar = ((bv) qVar).dXg;
                        if (bwVar != null) {
                            if (!bwVar.bhj() && com.baidu.tieba.frs.b.cog().coa()) {
                                if (com.baidu.tieba.frs.b.cog().aj(bwVar)) {
                                    bwVar.hY(true);
                                }
                            } else if (!bwVar.bhk() && com.baidu.tieba.frs.a.cnZ().coa()) {
                                if (com.baidu.tieba.frs.a.cnZ().aj(bwVar)) {
                                    bwVar.hZ(true);
                                }
                            } else {
                                com.baidu.tieba.frs.b.cog().ak(bwVar);
                                bwVar.hY(false);
                                com.baidu.tieba.frs.a.cnZ().ak(bwVar);
                                bwVar.hZ(false);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, bwVar));
                            return;
                        }
                        return;
                    }
                    am amVar2 = (am) view.getTag();
                    bw bwVar2 = ((bv) qVar).dXg;
                    bwVar2.objType = 1;
                    if (o.this.glU != null) {
                        o.this.glU.a(amVar2.getView(), bwVar2);
                    }
                    ay.a((AbsThreadDataSupport) bwVar2, view.getContext(), o.this.ijU, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, am<bw> amVar) {
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) amVar);
        if (bvVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tW().setPage(this.ahc);
        amVar.tW().setPosition(i);
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.hZt);
        if (this.hZt != null && this.hZt.getForum() != null && !StringUtils.isNull(this.hZt.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hZt.getForum().getTopic_special_icon_right())) {
            bvVar.dXg.du(this.hZt.getForum().getTopic_special_icon(), this.hZt.getForum().getTopic_special_icon_right());
        }
        amVar.b((am<bw>) bvVar.dXg);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.glU);
        bvVar.dXg.bgK();
        return amVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tS(int i) {
        this.ijU = i;
    }

    @Override // com.baidu.tieba.card.z
    public void nu(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return ijV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dF("tid", bwVar.getId()).ai("obj_locate", coS() ? 2 : 1).u("obj_id", bwVar.bfS() == null ? -1L : bwVar.bfS().live_id).ai("obj_type", 1));
    }
}
