package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aj;
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
/* loaded from: classes16.dex */
public class o extends com.baidu.tieba.frs.k<bv, com.baidu.card.al<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String agJ;
    private boolean ajt;
    private com.baidu.tieba.card.aa<bw> giN;
    private int icQ;
    private String mFrom;

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ajt = true;
        this.icQ = 3;
        this.giN = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (o.this.hSz != null) {
                        o.this.hSz.a(view, (View) bwVar, (Object) o.this.getType());
                    }
                    if ("c13010".equals(o.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").ai("obj_type", 1).u("fid", bwVar.getFid()).dD("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, o.this.mPageId, com.baidu.tieba.frs.d.d.icR, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, o.this.mPageId, com.baidu.tieba.frs.d.d.icR, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, o.this.mPageId, com.baidu.tieba.frs.d.d.icR, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, o.this.mPageId, com.baidu.tieba.frs.d.d.icR, o.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, o.this.mPageId, com.baidu.tieba.frs.d.d.icR, o.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (o.this.giN.ahV instanceof Boolean) {
                            if (((Boolean) o.this.giN.ahV).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bwVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.icR, o.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bwVar, 3, o.this.mPageId, com.baidu.tieba.frs.d.d.icR, o.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, o.this.mPageId, com.baidu.tieba.frs.d.d.icR, o.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, o.this.mPageId, com.baidu.tieba.frs.d.d.icR, o.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bwVar.bdk()) {
                        o.this.ap(bwVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.csv().a(com.baidu.tieba.frs.d.d.icR, bwVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.icR, bwVar.bcf());
                    } else if (view instanceof TbImageView) {
                        if (o.this.giN.ahV instanceof Boolean) {
                            if (((Boolean) o.this.giN.ahV).booleanValue()) {
                                com.baidu.tieba.frs.d.c.csv().a(com.baidu.tieba.frs.d.d.icR, bwVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.csv().a(com.baidu.tieba.frs.d.d.icR, bwVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.csv().a(com.baidu.tieba.frs.d.d.icR, bwVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bwVar.bgh() != null && bwVar.bgh().dwM() != null && bwVar.bgh().dwM().bxx() != null && bwVar.bgh().dwM().bxx().size() > 0) {
                            i = bwVar.bgh().mfI ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.csv().a(com.baidu.tieba.frs.d.d.icR, bwVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.csv().a(com.baidu.tieba.frs.d.d.icR, bwVar, 1);
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
    /* renamed from: aQ */
    public com.baidu.card.al<bw> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.m mVar = new com.baidu.card.m(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) mVar);
        mVar.setFromCDN(this.ajt);
        mVar.setForm("frs");
        com.baidu.card.aj a = aVar.a(false, viewGroup, this.hyr);
        a.setSourceForPb(3);
        com.baidu.card.al<bw> alVar = new com.baidu.card.al<>(a);
        alVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.o.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof com.baidu.card.al)) {
                    if ((com.baidu.tieba.frs.b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN()) && !mVar.tF()) {
                        bw bwVar = ((bv) qVar).dUW;
                        if (bwVar != null) {
                            if (!bwVar.bgp() && com.baidu.tieba.frs.b.ckT().ckN()) {
                                if (com.baidu.tieba.frs.b.ckT().ai(bwVar)) {
                                    bwVar.ib(true);
                                }
                            } else if (!bwVar.bgq() && com.baidu.tieba.frs.a.ckM().ckN()) {
                                if (com.baidu.tieba.frs.a.ckM().ai(bwVar)) {
                                    bwVar.ic(true);
                                }
                            } else {
                                com.baidu.tieba.frs.b.ckT().aj(bwVar);
                                bwVar.ib(false);
                                com.baidu.tieba.frs.a.ckM().aj(bwVar);
                                bwVar.ic(false);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, bwVar));
                            return;
                        }
                        return;
                    }
                    com.baidu.card.al alVar2 = (com.baidu.card.al) view.getTag();
                    bw bwVar2 = ((bv) qVar).dUW;
                    bwVar2.objType = 1;
                    if (o.this.giN != null) {
                        o.this.giN.a(alVar2.getView(), bwVar2);
                    }
                    ay.a((AbsThreadDataSupport) bwVar2, view.getContext(), o.this.icQ, false);
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.card.al<bw> alVar) {
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) alVar);
        if (bvVar == null || alVar == null || alVar.getView() == null) {
            return null;
        }
        alVar.tR().setPage(this.agJ);
        alVar.tR().setPosition(i);
        com.baidu.tieba.frs.j.a(alVar.tR().tL(), this.hSt);
        if (this.hSt != null && this.hSt.getForum() != null && !StringUtils.isNull(this.hSt.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hSt.getForum().getTopic_special_icon_right())) {
            bvVar.dUW.du(this.hSt.getForum().getTopic_special_icon(), this.hSt.getForum().getTopic_special_icon_right());
        }
        alVar.b((com.baidu.card.al<bw>) bvVar.dUW);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.giN);
        bvVar.dUW.bfQ();
        return alVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.ajt = z;
    }

    @Override // com.baidu.tieba.a.f
    public void Dk(String str) {
        this.agJ = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.icQ = i;
    }

    @Override // com.baidu.tieba.card.z
    public void no(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return icR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(bw bwVar) {
        TiebaStatic.log(new aq("c12126").dD("tid", bwVar.getId()).ai("obj_locate", clG() ? 2 : 1).u("obj_id", bwVar.beY() == null ? -1L : bwVar.beY().live_id).ai("obj_type", 1));
    }
}
