package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class m extends com.baidu.tieba.frs.h<bj, com.baidu.card.ag<bk>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aeX;
    private NEGFeedBackView.a fGM;
    private com.baidu.tieba.card.aa<bk> fGi;
    private int hvK;
    private boolean hwg;
    private String mFrom;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hwg = false;
        this.hvK = 3;
        this.fGi = new com.baidu.tieba.card.aa<bk>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                if (view != null && bkVar != null) {
                    if (m.this.hmX != null) {
                        m.this.hmX.a(view, (View) bkVar, (Object) m.this.getType());
                    }
                    if ("c13010".equals(m.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").ag("obj_type", 1).s("fid", bkVar.getFid()).dh("tid", bkVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 2, m.this.mPageId, com.baidu.tieba.frs.d.d.hvL, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 5, m.this.mPageId, com.baidu.tieba.frs.d.d.hvL, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 14, m.this.mPageId, com.baidu.tieba.frs.d.d.hvL, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 12, m.this.mPageId, com.baidu.tieba.frs.d.d.hvL, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 13, m.this.mPageId, com.baidu.tieba.frs.d.d.hvL, m.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (m.this.fGi.agg instanceof Boolean) {
                            if (((Boolean) m.this.fGi.agg).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bkVar, 1, m.this.mPageId, com.baidu.tieba.frs.d.d.hvL, m.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bkVar, 3, m.this.mPageId, com.baidu.tieba.frs.d.d.hvL, m.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 15, m.this.mPageId, com.baidu.tieba.frs.d.d.hvL, m.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bkVar, 1, m.this.mPageId, com.baidu.tieba.frs.d.d.hvL, m.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bkVar.aPk()) {
                        m.this.as(bkVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.caY().a(com.baidu.tieba.frs.d.d.hvL, bkVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.hvL, bkVar.aOj());
                    } else if (view instanceof TbImageView) {
                        if (m.this.fGi.agg instanceof Boolean) {
                            if (((Boolean) m.this.fGi.agg).booleanValue()) {
                                com.baidu.tieba.frs.d.c.caY().a(com.baidu.tieba.frs.d.d.hvL, bkVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.caY().a(com.baidu.tieba.frs.d.d.hvL, bkVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.caY().a(com.baidu.tieba.frs.d.d.hvL, bkVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bkVar.aSb() != null && bkVar.aSb().ddL() != null && bkVar.aSb().ddL().bis() != null && bkVar.aSb().ddL().bis().size() > 0) {
                            i = bkVar.aSb().lmA ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.caY().a(com.baidu.tieba.frs.d.d.hvL, bkVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.caY().a(com.baidu.tieba.frs.d.d.hvL, bkVar, 1);
                    }
                }
            }
        };
        this.fGM = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.m.4
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ak akVar) {
                TiebaStatic.log(new an("c11973").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ak akVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
                if (arrayList != null && akVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11974").dh("obj_locate", sb.toString()).dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("nid", akVar.getNid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("source", akVar.source).dh("weight", akVar.weight).dh("ab_tag", akVar.abTag).dh("extra", akVar.extra).ag(IntentConfig.CARD_TYPE, akVar.cardType).ag("obj_floor", akVar.dDb));
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
    public com.baidu.card.ag<bk> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.ah ahVar = new com.baidu.card.ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = this.hwg ? 10 : 2;
        cVar.dBf = 2;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(2);
        ahVar.setStType("frs_page");
        ahVar.setShareReportFrom(1);
        ahVar.bm(3);
        ahVar.aX(16);
        aVar.b(ahVar);
        com.baidu.card.ae a = aVar.a(true, viewGroup, this.gTb);
        a.setSourceForPb(3);
        com.baidu.card.ag<bk> agVar = new com.baidu.card.ag<>(a);
        agVar.setPageId(this.mPageId);
        agVar.aI(true);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.frs.entelechy.a.m.2
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof bj) && (view.getTag() instanceof com.baidu.card.ag)) {
                    com.baidu.card.ag agVar2 = (com.baidu.card.ag) view.getTag();
                    bk bkVar = ((bj) oVar).dEA;
                    bkVar.objType = 1;
                    if (m.this.fGi != null) {
                        m.this.fGi.a(agVar2.getView(), bkVar);
                    }
                    au.a((AbsThreadDataSupport) bkVar, view.getContext(), m.this.hvK, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.t) viewGroup2, view, i));
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, bj bjVar, com.baidu.card.ag agVar) {
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) agVar);
        if (bjVar == null || agVar == null || agVar.getView() == null) {
            return null;
        }
        agVar.rM().setPage(this.aeX);
        agVar.rM().setPosition(i);
        com.baidu.tieba.frs.g.a(agVar.rM().rG(), this.hmR);
        if (this.hmR != null && this.hmR.getForum() != null && !StringUtils.isNull(this.hmR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hmR.getForum().getTopic_special_icon_right())) {
            bjVar.dEA.cY(this.hmR.getForum().getTopic_special_icon(), this.hmR.getForum().getTopic_special_icon_right());
        }
        boolean z = (bjVar.dEA.aQx() == null || bjVar.dEA.aQx().getUserId() == null || !bjVar.dEA.aQx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bjVar.dEA.aRN() && bjVar.dEA.getFeedBackReasonMap() != null && !z) {
            agVar.a(bjVar.aOp() ? false : true, Align.ALIGN_RIGHT_BOTTOM, this.fGM);
        } else {
            agVar.a(false, Align.ALIGN_RIGHT_BOTTOM, this.fGM);
        }
        if (bjVar.dEA.aRN()) {
            agVar.rM().rG().aX(32);
        }
        if (agVar.rM().rG() instanceof com.baidu.card.ah) {
            ((com.baidu.card.ah) agVar.rM().rG()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.m.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.t) viewGroup, view, i));
                    }
                }
            });
        }
        agVar.b((com.baidu.card.ag) bjVar.dEA);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.fGi);
        bjVar.dEA.aRK();
        return agVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qy(int i) {
        this.hvK = i;
    }

    @Override // com.baidu.tieba.card.z
    public void lV(boolean z) {
        this.hwg = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hvL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bk bkVar) {
        TiebaStatic.log(new an("c12126").dh("tid", bkVar.getId()).ag("obj_locate", bUG() ? 2 : 1).s("obj_id", bkVar.aQS() == null ? -1L : bkVar.aQS().live_id).ag("obj_type", 1));
    }
}
