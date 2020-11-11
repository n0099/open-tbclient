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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.frs.k<bv, am<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahu;
    private boolean akk;
    private boolean eWH;
    private com.baidu.tieba.card.ab<bw> gSA;
    private NEGFeedBackView.a gTe;
    private HashSet<String> iRj;
    private int iRk;
    private com.baidu.tieba.frs.d.b iRl;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.eWH = false;
        this.akk = true;
        this.iRk = 3;
        this.iRl = new com.baidu.tieba.frs.d.b();
        this.gSA = new com.baidu.tieba.card.ab<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if ("c13010".equals(b.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").al("obj_type", 3).w("fid", bwVar.getFid()).dR("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, b.this.mPageId, b.this.iRl, b.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, b.this.mPageId, b.this.iRl, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, b.this.mPageId, b.this.iRl, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, b.this.mPageId, b.this.iRl, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, b.this.mPageId, b.this.iRl, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, b.this.mPageId, b.this.iRl, b.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, b.this.mPageId, b.this.iRl, b.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cEP().a(b.this.iRl, bwVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.cEP().a(b.this.iRl, bwVar, 1);
                    } else {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        aq aqVar = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        aqVar.dR("obj_type", "1");
                        aqVar.dR("tid", bwVar.getTid());
                        TiebaStatic.log(aqVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        aq aqVar2 = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        aqVar2.dR("obj_type", "3");
                        aqVar2.dR("tid", bwVar.getTid());
                        TiebaStatic.log(aqVar2);
                    }
                }
            }
        };
        this.gTe = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.b.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                TiebaStatic.log(new aq("c11973").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, ar arVar) {
                if (arrayList != null && arVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new aq("c11974").dR("obj_locate", sb.toString()).dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("nid", arVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", arVar.source).dR("weight", arVar.weight).dR("ab_tag", arVar.abTag).dR("extra", arVar.extra).al(IntentConfig.CARD_TYPE, arVar.cardType).al("obj_floor", arVar.eBK));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public am<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bo(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.b.3
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.af afVar = new com.baidu.card.af(this.mPageContext);
        afVar.b((Boolean) false);
        afVar.setFrom("frs");
        if (this.iRk == 502) {
            afVar.setNeedFrsTabName(false);
        } else {
            afVar.setNeedFrsTabName(true);
        }
        afVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20));
        aVar.tU().bv(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(afVar);
        com.baidu.card.af afVar2 = new com.baidu.card.af(this.mPageContext);
        afVar2.b((Boolean) true);
        afVar2.setFrom("frs");
        if (this.iRk == 502) {
            afVar2.setNeedFrsTabName(false);
        } else {
            afVar2.setNeedFrsTabName(true);
        }
        afVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39));
        afVar2.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.b.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null && absThreadDataSupport.bjZ().eGn != null) {
                    ay.a(absThreadDataSupport.bjZ().eGn, b.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.i) afVar2);
        ao aoVar = new ao(this.mPageContext.getPageActivity());
        aoVar.b((Boolean) true);
        aoVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.b.5
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null && absThreadDataSupport.bjZ().eGn != null) {
                    ay.a(absThreadDataSupport.bjZ().eGn, b.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.i) aoVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akk);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ezt = 2;
        cVar.ezz = 2;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(3);
        anVar.bo(16);
        aVar.b(anVar);
        aVar.tU().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.ak a2 = aVar.a(true, viewGroup, this.imM);
        a2.setSourceForPb(3);
        am<bw> amVar = new am<>(a2);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.b.6
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = ((bv) qVar).exA;
                    bwVar.objType = 1;
                    if (b.this.gSA != null) {
                        b.this.gSA.a(amVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), b.this.iRk, false);
                    amVar2.tW().b(new a.C0097a(1));
                }
            }
        });
        amVar.tX();
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, am<bw> amVar) {
        if (bvVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.ahu);
        }
        amVar.tW().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) amVar);
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.iGN);
        if (this.iGN != null && this.iGN.getForum() != null && !StringUtils.isNull(this.iGN.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iGN.getForum().getTopic_special_icon_right())) {
            bvVar.exA.dG(this.iGN.getForum().getTopic_special_icon(), this.iGN.getForum().getTopic_special_icon_right());
        }
        boolean z = (bvVar.exA.bmA() == null || bvVar.exA.bmA().getUserId() == null || !bvVar.exA.bmA().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bvVar.exA.bnP() && bvVar.exA.getFeedBackReasonMap() != null && !z) {
            amVar.aL(true).a(this.gTe);
        }
        amVar.tY();
        if (bvVar.exA.bnP() && amVar.tW().tQ() != null) {
            amVar.tW().tQ().bo(32);
        }
        amVar.b((am<bw>) bvVar.exA);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gSA);
        if (this.iRl != null) {
            bvVar.exA.eBK = (bvVar.position + 1) - (this.iGN != null ? this.iGN.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cEP().a(this.iRl, bvVar.exA);
        ao(bvVar.exA);
        bvVar.exA.bnM();
        com.baidu.tieba.frs.d.a.a(bvVar.exA, this.mPageId, this.iRl, getTbPageTag());
        if (bvVar.exA != null) {
            bvVar.exA.bnM();
        }
        return amVar.getView();
    }

    private void ao(bw bwVar) {
        if (this.iRj == null) {
            this.iRj = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.cEP().a(bwVar, this.iRj);
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vd(int i) {
        this.iRk = i;
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.eWH = z;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRl;
    }
}
