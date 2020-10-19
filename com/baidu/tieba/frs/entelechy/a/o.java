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
/* loaded from: classes22.dex */
public class o extends com.baidu.tieba.frs.k<bv, am<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aht;
    private boolean akj;
    private com.baidu.tieba.card.aa<bw> gAn;
    private int iyR;
    private String mFrom;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.akj = true;
        this.iyR = 3;
        this.gAn = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (o.this.ioA != null) {
                        o.this.ioA.a(view, (View) bwVar, (Object) o.this.getType());
                    }
                    if ("c13010".equals(o.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").aj("obj_type", 1).u("fid", bwVar.getFid()).dK("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, o.this.mPageId, com.baidu.tieba.frs.d.d.iyS, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, o.this.mPageId, com.baidu.tieba.frs.d.d.iyS, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, o.this.mPageId, com.baidu.tieba.frs.d.d.iyS, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, o.this.mPageId, com.baidu.tieba.frs.d.d.iyS, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, o.this.mPageId, com.baidu.tieba.frs.d.d.iyS, o.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (o.this.gAn.aiI instanceof Boolean) {
                            if (((Boolean) o.this.gAn.aiI).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bwVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.iyS, o.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bwVar, 3, o.this.mPageId, com.baidu.tieba.frs.d.d.iyS, o.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, o.this.mPageId, com.baidu.tieba.frs.d.d.iyS, o.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.iyS, o.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bwVar.bgN()) {
                        o.this.aq(bwVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(com.baidu.tieba.frs.d.d.iyS, bwVar.bfH());
                    } else if (view instanceof TbImageView) {
                        if (o.this.gAn.aiI instanceof Boolean) {
                            if (((Boolean) o.this.gAn.aiI).booleanValue()) {
                                com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bwVar.bjK() != null && bwVar.bjK().dEr() != null && bwVar.bjK().dEr().bBq() != null && bwVar.bjK().dEr().bBq().size() > 0) {
                            i = bwVar.bjK().mEN ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.czh().a(com.baidu.tieba.frs.d.d.iyS, bwVar, 1);
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
    /* renamed from: aT */
    public am<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.i) nVar);
        nVar.setFromCDN(this.akj);
        nVar.setForm("frs");
        com.baidu.card.ak a2 = aVar.a(false, viewGroup, this.hUo);
        a2.setSourceForPb(3);
        am<bw> amVar = new am<>(a2);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.o.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    if ((com.baidu.tieba.frs.b.crE().cry() || com.baidu.tieba.frs.a.crx().cry()) && !nVar.tK()) {
                        bw bwVar = ((bv) qVar).eji;
                        if (bwVar != null) {
                            if (!bwVar.bjS() && com.baidu.tieba.frs.b.crE().cry()) {
                                if (com.baidu.tieba.frs.b.crE().aj(bwVar)) {
                                    bwVar.iu(true);
                                }
                            } else if (!bwVar.bjT() && com.baidu.tieba.frs.a.crx().cry()) {
                                if (com.baidu.tieba.frs.a.crx().aj(bwVar)) {
                                    bwVar.iv(true);
                                }
                            } else {
                                com.baidu.tieba.frs.b.crE().ak(bwVar);
                                bwVar.iu(false);
                                com.baidu.tieba.frs.a.crx().ak(bwVar);
                                bwVar.iv(false);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, bwVar));
                            return;
                        }
                        return;
                    }
                    am amVar2 = (am) view.getTag();
                    bw bwVar2 = ((bv) qVar).eji;
                    bwVar2.objType = 1;
                    if (o.this.gAn != null) {
                        o.this.gAn.a(amVar2.getView(), bwVar2);
                    }
                    ay.a((AbsThreadDataSupport) bwVar2, view.getContext(), o.this.iyR, false);
                    amVar2.tW().b(new a.C0097a(1));
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
        amVar.tW().setPage(this.aht);
        amVar.tW().setPosition(i);
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.iou);
        if (this.iou != null && this.iou.getForum() != null && !StringUtils.isNull(this.iou.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iou.getForum().getTopic_special_icon_right())) {
            bvVar.eji.dz(this.iou.getForum().getTopic_special_icon(), this.iou.getForum().getTopic_special_icon_right());
        }
        amVar.b((am<bw>) bvVar.eji);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gAn);
        bvVar.eji.bjt();
        return amVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akj = z;
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void ux(int i) {
        this.iyR = i;
    }

    @Override // com.baidu.tieba.card.z
    public void nZ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return iyS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dK("tid", bwVar.getId()).aj("obj_locate", csq() ? 2 : 1).u("obj_id", bwVar.biB() == null ? -1L : bwVar.biB().live_id).aj("obj_type", 1));
    }
}
