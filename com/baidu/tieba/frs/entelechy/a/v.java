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
import com.baidu.card.au;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes21.dex */
public class v extends com.baidu.tieba.frs.k<bw, am<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahw;
    private boolean akn;
    private NEGFeedBackView.a gSL;
    private com.baidu.tieba.card.ab<bw> gSh;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iOy;
    private com.baidu.adp.lib.d.b<TbImageView> iOz;
    private int iRU;
    private HashSet<String> iRW;
    private com.baidu.tieba.frs.d.b iRY;
    private boolean iSt;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.iSt = false;
        this.akn = true;
        this.iRY = new com.baidu.tieba.frs.d.b();
        this.gSh = new com.baidu.tieba.card.ab<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (v.this.iHH != null) {
                        v.this.iHH.a(view, (View) bwVar, (Object) v.this.getType());
                    }
                    if ("c13010".equals(v.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ak("obj_type", 1).w("fid", bwVar.evQ.getFid()).dR("tid", bwVar.evQ.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar.evQ, 2, v.this.mPageId, v.this.iRY, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar.evQ, 5, v.this.mPageId, v.this.iRY, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar.evQ, 14, v.this.mPageId, v.this.iRY, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar.evQ, 12, v.this.mPageId, v.this.iRY, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar.evQ, 13, v.this.mPageId, v.this.iRY, v.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (v.this.gSh.aiO instanceof Boolean) {
                            if (((Boolean) v.this.gSh.aiO).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bwVar.evQ, 1, v.this.mPageId, v.this.iRY, v.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bwVar.evQ, 3, v.this.mPageId, v.this.iRY, v.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar.evQ, 15, v.this.mPageId, v.this.iRY, v.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar.evQ, 1, v.this.mPageId, v.this.iRY, v.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cEu().a(v.this.iRY, bwVar.evQ, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(v.this.iRY, bwVar.bje());
                    } else if (view instanceof TbImageView) {
                        if (v.this.gSh.aiO instanceof Boolean) {
                            if (((Boolean) v.this.gSh.aiO).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cEu().a(v.this.iRY, bwVar.evQ, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cEu().a(v.this.iRY, bwVar.evQ, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ak("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cEu().a(v.this.iRY, bwVar.evQ, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.cEu().a(v.this.iRY, bwVar.evQ, 1);
                    } else {
                        int i = 6;
                        if (bwVar.evQ.bnh() != null && bwVar.evQ.bnh().dJS() != null && bwVar.evQ.bnh().dJS().bFb() != null && bwVar.evQ.bnh().dJS().bFb().size() > 0) {
                            i = bwVar.evQ.bnh().mYp ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cEu().a(v.this.iRY, bwVar.evQ, i);
                    }
                }
            }
        };
        this.gSL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.v.2
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
        this.iOy = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.v.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cAy */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(v.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.iOz = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.v.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bsp */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(v.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ap.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public TbImageView passivateObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bo(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.v.5
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
        final com.baidu.card.w wVar = new com.baidu.card.w(this.mPageContext.getPageActivity());
        wVar.setFrom("frs");
        if (this.iRU == 502) {
            wVar.setNeedFrsTabName(false);
        } else {
            wVar.setNeedFrsTabName(true);
        }
        wVar.setConstrainLayoutPool(this.iOy);
        wVar.setConstrainImagePool(this.iOz);
        wVar.setFromCDN(this.akn);
        aVar.c(wVar);
        au auVar = new au(this.mPageContext.getPageActivity());
        auVar.setPageContext(this.mPageContext);
        auVar.setFromForPb(3);
        aVar.a((com.baidu.card.i) auVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.ai(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.i) nVar);
        nVar.setFromCDN(this.akn);
        nVar.setForm("frs");
        if (!aJ(1) || !aJ(2)) {
            wVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.v.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    v.this.h(i, i2, i3);
                    if (v.this.aJ(1) && v.this.aJ(2)) {
                        wVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.exI = this.iSt ? 10 : 2;
        dVar.exO = 2;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(3);
        anVar.bo(16);
        aVar.b(anVar);
        aVar.tV().bv(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak tU = aVar.tU();
        tU.setSourceForPb(3);
        am<bw> amVar = new am<>(tU);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.v.7
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bx bxVar = ((bw) qVar).evQ;
                    bxVar.objType = 1;
                    if (v.this.gSh != null) {
                        v.this.gSh.a(amVar2.getView(), (bw) qVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), 3, false);
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
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, am<bw> amVar) {
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) amVar);
        if (bwVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tW().setPage(this.ahw);
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.iHB);
        if (this.iHB != null && this.iHB.getForum() != null && !StringUtils.isNull(this.iHB.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iHB.getForum().getTopic_special_icon_right())) {
            bwVar.evQ.dE(this.iHB.getForum().getTopic_special_icon(), this.iHB.getForum().getTopic_special_icon_right());
        }
        boolean z = (bwVar.evQ.blC() == null || bwVar.evQ.blC().getUserId() == null || !bwVar.evQ.blC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bwVar.evQ.bmT() && bwVar.evQ.getFeedBackReasonMap() != null && !z) {
            amVar.aN(true).a(this.gSL);
        }
        amVar.tY();
        if (amVar.tW().tQ() != null) {
            amVar.tW().tQ().bo(32);
        }
        amVar.b((am<bw>) bwVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gSh);
        if (this.iRY != null) {
            bwVar.evQ.eAb = (bwVar.position + 1) - (this.iHB != null ? this.iHB.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cEu().a(this.iRY, bwVar.evQ);
        aq(bwVar.evQ);
        bwVar.evQ.bmQ();
        com.baidu.tieba.frs.d.a.a(bwVar.evQ, this.mPageId, this.iRY, getTbPageTag());
        if (bwVar != null) {
            bwVar.evQ.bmQ();
        }
        return amVar.getView();
    }

    private void aq(bx bxVar) {
        if (this.iRW == null) {
            this.iRW = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.cEu().a(bxVar, this.iRW);
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
        this.iRU = i;
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    @Override // com.baidu.tieba.card.aa
    public void oD(boolean z) {
        this.iSt = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRY;
    }
}
