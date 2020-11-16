package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class r extends com.baidu.tieba.frs.k<bw, am<bx>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahw;
    private boolean akn;
    private NEGFeedBackView.a gSL;
    private com.baidu.tieba.card.ab<bx> gSh;
    private int iRX;
    private com.baidu.tieba.frs.d.b iRY;
    private TbPageContext<?> mPageContext;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.akn = true;
        this.iRX = 3;
        this.iRY = new com.baidu.tieba.frs.d.b();
        this.gSh = new com.baidu.tieba.card.ab<bx>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bx bxVar) {
                if (view != null && bxVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 2, r.this.mPageId, r.this.iRY, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 5, r.this.mPageId, r.this.iRY, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 14, r.this.mPageId, r.this.iRY, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 12, r.this.mPageId, r.this.iRY, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 13, r.this.mPageId, r.this.iRY, r.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (r.this.gSh.aiO instanceof Boolean) {
                            if (((Boolean) r.this.gSh.aiO).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bxVar, 1, r.this.mPageId, r.this.iRY, r.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bxVar, 3, r.this.mPageId, r.this.iRY, r.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 15, r.this.mPageId, r.this.iRY, r.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bxVar, 1, r.this.mPageId, r.this.iRY, r.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cEu().a(r.this.iRY, bxVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.cEu().a(r.this.iRY, bxVar, 7);
                    } else {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ak("obj_type", 3));
                    }
                }
            }
        };
        this.gSL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.2
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
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.mPageId);
        eVar.bo(4272);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.3
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
        aVar.c(new com.baidu.card.t(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akn);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.exI = 2;
        dVar.exO = 2;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(this.iRX);
        anVar.setFromForPb(this.iRX);
        anVar.bo(48);
        aVar.b(anVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup);
        a2.setSourceForPb(this.iRX);
        am<bx> amVar = new am<>(a2);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.r.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bx bxVar = ((bw) qVar).evQ;
                    bxVar.objType = 1;
                    if (r.this.gSh != null) {
                        r.this.gSh.a(amVar2.getView(), bxVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), r.this.iRX, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        amVar.tX();
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, am<bx> amVar) {
        if (bwVar == null || amVar == null || amVar.tW() == null) {
            return null;
        }
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) amVar);
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.ahw);
        }
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.iHB);
        boolean z = (bwVar.evQ.blC() == null || bwVar.evQ.blC().getUserId() == null || !bwVar.evQ.blC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bwVar.evQ.bmT() && bwVar.evQ.getFeedBackReasonMap() != null && !z) {
            com.baidu.card.ab aN = amVar.aN(true);
            aN.a(this.gSL);
            aN.H(bwVar.evQ.bjf());
        }
        amVar.tY();
        amVar.b((am<bx>) bwVar.evQ);
        amVar.b(this.gSh);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.iRY != null) {
            bwVar.evQ.eAb = (bwVar.position + 1) - (this.iHB != null ? this.iHB.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cEu().a(this.iRY, bwVar.evQ);
        com.baidu.tieba.frs.d.a.a(bwVar.evQ, this.mPageId, this.iRY, getTbPageTag());
        if (bwVar != null) {
            bwVar.evQ.bmQ();
        }
        return amVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
        this.iRX = i;
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRY;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akn = z;
    }
}
