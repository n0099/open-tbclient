package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.ao;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.frs.k<bx, am<bx>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahw;
    private boolean akn;
    private boolean eVP;
    private NEGFeedBackView.a gSL;
    private com.baidu.tieba.card.ab<bx> gSh;
    private HashSet<String> iRW;
    private int iRX;
    private com.baidu.tieba.frs.d.b iRY;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.eVP = false;
        this.akn = true;
        this.iRX = 3;
        this.iRY = new com.baidu.tieba.frs.d.b();
        this.gSh = new com.baidu.tieba.card.ab<bx>() { // from class: com.baidu.tieba.frs.entelechy.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bx bxVar) {
                if (view != null && bxVar != null) {
                    if ("c13010".equals(c.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ak("obj_type", 3).w("fid", bxVar.getFid()).dR("tid", bxVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 2, c.this.mPageId, c.this.iRY, c.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 15, c.this.mPageId, c.this.iRY, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 5, c.this.mPageId, c.this.iRY, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 14, c.this.mPageId, c.this.iRY, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 12, c.this.mPageId, c.this.iRY, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bxVar, 13, c.this.mPageId, c.this.iRY, c.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bxVar, 1, c.this.mPageId, c.this.iRY, c.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cEu().a(c.this.iRY, bxVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.cEu().a(c.this.iRY, bxVar, 1);
                    } else {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ak("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        ar arVar = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        arVar.dR("obj_type", "1");
                        arVar.dR("tid", bxVar.getTid());
                        TiebaStatic.log(arVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        ar arVar2 = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        arVar2.dR("obj_type", "3");
                        arVar2.dR("tid", bxVar.getTid());
                        TiebaStatic.log(arVar2);
                    }
                }
            }
        };
        this.gSL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.2
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
        eVar.bo(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.3
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
        com.baidu.card.af afVar = new com.baidu.card.af(this.mPageContext);
        afVar.b((Boolean) false);
        afVar.setFrom("frs");
        if (this.iRX == 502) {
            afVar.setNeedFrsTabName(false);
        } else {
            afVar.setNeedFrsTabName(true);
        }
        aVar.tV().bv(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(afVar);
        com.baidu.card.af afVar2 = new com.baidu.card.af(this.mPageContext);
        afVar2.b((Boolean) true);
        afVar2.setFrom("frs");
        if (this.iRX == 502) {
            afVar2.setNeedFrsTabName(false);
        } else {
            afVar2.setNeedFrsTabName(true);
        }
        afVar2.e(com.baidu.tbadk.a.b.a.bhB(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), com.baidu.tbadk.a.b.a.bhB(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        afVar2.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.4
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bjd() != null && aVar2.bjd().eEF != null) {
                    az.a(aVar2.bjd().eEF, c.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.i) afVar2);
        ao aoVar = new ao(this.mPageContext.getPageActivity());
        aoVar.b((Boolean) true);
        aoVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.5
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bjd() != null && aVar2.bjd().eEF != null) {
                    az.a(aVar2.bjd().eEF, c.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.i) aoVar);
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
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(3);
        anVar.bo(48);
        aVar.b(anVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.inB);
        a2.setSourceForPb(3);
        am<bx> amVar = new am<>(a2);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.c.6
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bx) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bx bxVar = (bx) qVar;
                    bxVar.objType = 1;
                    if (c.this.gSh != null) {
                        c.this.gSh.a(amVar2.getView(), bxVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), c.this.iRX, false);
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
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, am<bx> amVar) {
        if (bxVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.ahw);
        }
        amVar.tW().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) bxVar, (bx) amVar);
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.iHB);
        if (this.iHB != null && this.iHB.getForum() != null && !StringUtils.isNull(this.iHB.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iHB.getForum().getTopic_special_icon_right())) {
            bxVar.dE(this.iHB.getForum().getTopic_special_icon(), this.iHB.getForum().getTopic_special_icon_right());
        }
        boolean z = (bxVar.blC() == null || bxVar.blC().getUserId() == null || !bxVar.blC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bxVar.bmT() && bxVar.getFeedBackReasonMap() != null && !z) {
            amVar.aN(true).a(this.gSL);
        }
        amVar.tY();
        if (amVar.tW().tQ() != null) {
            amVar.tW().tQ().bo(32);
        }
        amVar.b((am<bx>) bxVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gSh);
        if (this.iRY != null) {
            bxVar.eAb = (bxVar.position + 1) - (this.iHB != null ? this.iHB.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cEu().a(this.iRY, bxVar);
        aq(bxVar);
        bxVar.bmQ();
        com.baidu.tieba.frs.d.a.a(bxVar, this.mPageId, this.iRY, getTbPageTag());
        if (bxVar != null) {
            bxVar.bmQ();
        }
        return amVar.getView();
    }

    private void aq(bx bxVar) {
        if (this.iRW == null) {
            this.iRW = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.cEu().a(bxVar, this.iRW);
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
        this.iRX = i;
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRY;
    }
}
