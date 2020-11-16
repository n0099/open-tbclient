package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class m extends com.baidu.tieba.frs.k<bw, am<bx>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahw;
    private NEGFeedBackView.a gSL;
    private com.baidu.tieba.card.ab<bx> gSh;
    private int iRX;
    private boolean iSt;
    private String mFrom;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.iSt = false;
        this.iRX = 3;
        this.gSh = new com.baidu.tieba.card.ab<bx>() { // from class: com.baidu.tieba.frs.entelechy.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bx bxVar) {
                if (view != null && bxVar != null) {
                    if (m.this.iHH != null) {
                        m.this.iHH.a(view, (View) bxVar, (Object) m.this.getType());
                    }
                    if ("c13010".equals(m.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ak("obj_type", 1).w("fid", bxVar.getFid()).dR("tid", bxVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 2, m.this.mPageId, com.baidu.tieba.frs.d.d.iRY, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 5, m.this.mPageId, com.baidu.tieba.frs.d.d.iRY, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 14, m.this.mPageId, com.baidu.tieba.frs.d.d.iRY, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 12, m.this.mPageId, com.baidu.tieba.frs.d.d.iRY, m.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 13, m.this.mPageId, com.baidu.tieba.frs.d.d.iRY, m.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (m.this.gSh.aiO instanceof Boolean) {
                            if (((Boolean) m.this.gSh.aiO).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bxVar, 1, m.this.mPageId, com.baidu.tieba.frs.d.d.iRY, m.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bxVar, 3, m.this.mPageId, com.baidu.tieba.frs.d.d.iRY, m.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 15, m.this.mPageId, com.baidu.tieba.frs.d.d.iRY, m.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bxVar, 1, m.this.mPageId, com.baidu.tieba.frs.d.d.iRY, m.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bxVar.bki()) {
                        m.this.as(bxVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cEu().a(com.baidu.tieba.frs.d.d.iRY, bxVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(com.baidu.tieba.frs.d.d.iRY, bxVar.bje());
                    } else if (view instanceof TbImageView) {
                        if (m.this.gSh.aiO instanceof Boolean) {
                            if (((Boolean) m.this.gSh.aiO).booleanValue()) {
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
        this.gSL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.m.4
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(as asVar) {
                TiebaStatic.log(new ar("c11973").dR("fid", asVar.getFid()).dR("tid", asVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(as asVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, as asVar) {
                if (arrayList != null && asVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ar("c11974").dR("obj_locate", sb.toString()).dR("fid", asVar.getFid()).dR("tid", asVar.getTid()).dR("nid", asVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", asVar.source).dR("weight", asVar.weight).dR("ab_tag", asVar.abTag).dR("extra", asVar.extra).ak(IntentConfig.CARD_TYPE, asVar.cardType).ak("obj_floor", asVar.eAb));
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
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.exI = this.iSt ? 10 : 2;
        dVar.exO = 2;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(2);
        anVar.setStType("frs_page");
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(3);
        anVar.bo(48);
        aVar.b(anVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.inB);
        a2.setSourceForPb(3);
        am<bx> amVar = new am<>(a2);
        amVar.setPageId(this.mPageId);
        amVar.aO(true);
        amVar.b(4, aVar.tV());
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.m.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bx bxVar = ((bw) qVar).evQ;
                    bxVar.objType = 1;
                    if (m.this.gSh != null) {
                        m.this.gSh.a(amVar2.getView(), bxVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), m.this.iRX, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, bw bwVar, am amVar) {
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
        amVar.a(false, Align.ALIGN_RIGHT_BOTTOM, this.gSL);
        if (amVar.tW().tQ() instanceof an) {
            ((an) amVar.tW().tQ()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.m.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                    }
                }
            });
        }
        amVar.b((am) bwVar.evQ);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gSh);
        bwVar.evQ.bmQ();
        return amVar.getView();
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
        this.iSt = z;
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
