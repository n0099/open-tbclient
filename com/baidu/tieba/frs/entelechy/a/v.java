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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes22.dex */
public class v extends com.baidu.tieba.frs.k<bv, am<bv>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahu;
    private boolean akk;
    private com.baidu.tieba.card.ab<bv> gSA;
    private NEGFeedBackView.a gTe;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iNL;
    private com.baidu.adp.lib.d.b<TbImageView> iNM;
    private boolean iRG;
    private int iRh;
    private HashSet<String> iRj;
    private com.baidu.tieba.frs.d.b iRl;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.iRG = false;
        this.akk = true;
        this.iRl = new com.baidu.tieba.frs.d.b();
        this.gSA = new com.baidu.tieba.card.ab<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    if (v.this.iGT != null) {
                        v.this.iGT.a(view, (View) bvVar, (Object) v.this.getType());
                    }
                    if ("c13010".equals(v.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").al("obj_type", 1).w("fid", bvVar.exA.getFid()).dR("tid", bvVar.exA.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bvVar.exA, 2, v.this.mPageId, v.this.iRl, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar.exA, 5, v.this.mPageId, v.this.iRl, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar.exA, 14, v.this.mPageId, v.this.iRl, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bvVar.exA, 12, v.this.mPageId, v.this.iRl, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bvVar.exA, 13, v.this.mPageId, v.this.iRl, v.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (v.this.gSA.aiJ instanceof Boolean) {
                            if (((Boolean) v.this.gSA.aiJ).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bvVar.exA, 1, v.this.mPageId, v.this.iRl, v.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bvVar.exA, 3, v.this.mPageId, v.this.iRl, v.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bvVar.exA, 15, v.this.mPageId, v.this.iRl, v.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bvVar.exA, 1, v.this.mPageId, v.this.iRl, v.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cEP().a(v.this.iRl, bvVar.exA, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(v.this.iRl, bvVar.bka());
                    } else if (view instanceof TbImageView) {
                        if (v.this.gSA.aiJ instanceof Boolean) {
                            if (((Boolean) v.this.gSA.aiJ).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cEP().a(v.this.iRl, bvVar.exA, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cEP().a(v.this.iRl, bvVar.exA, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cEP().a(v.this.iRl, bvVar.exA, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.cEP().a(v.this.iRl, bvVar.exA, 1);
                    } else {
                        int i = 6;
                        if (bvVar.exA.bod() != null && bvVar.exA.bod().dKb() != null && bvVar.exA.bod().dKb().bFI() != null && bvVar.exA.bod().dKb().bFI().size() > 0) {
                            i = bvVar.exA.bod().mXx ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cEP().a(v.this.iRl, bvVar.exA, i);
                    }
                }
            }
        };
        this.gTe = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.v.2
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
        this.iNL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.v.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cAV */
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
        this.iNM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.v.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bsZ */
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
    /* renamed from: aV */
    public am<bv> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bo(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.v.5
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
        final com.baidu.card.w wVar = new com.baidu.card.w(this.mPageContext.getPageActivity());
        wVar.setFrom("frs");
        if (this.iRh == 502) {
            wVar.setNeedFrsTabName(false);
        } else {
            wVar.setNeedFrsTabName(true);
        }
        wVar.setConstrainLayoutPool(this.iNL);
        wVar.setConstrainImagePool(this.iNM);
        wVar.setFromCDN(this.akk);
        aVar.c(wVar);
        au auVar = new au(this.mPageContext.getPageActivity());
        auVar.setPageContext(this.mPageContext);
        auVar.setFromForPb(3);
        aVar.a((com.baidu.card.i) auVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.ai(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.i) nVar);
        nVar.setFromCDN(this.akk);
        nVar.setForm("frs");
        if (!aI(1) || !aI(2)) {
            wVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.v.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    v.this.h(i, i2, i3);
                    if (v.this.aI(1) && v.this.aI(2)) {
                        wVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ezt = this.iRG ? 10 : 2;
        cVar.ezz = 2;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(3);
        anVar.bo(16);
        aVar.b(anVar);
        aVar.tU().bv(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak tV = aVar.tV();
        tV.setSourceForPb(3);
        am<bv> amVar = new am<>(tV);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.v.7
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = ((bv) qVar).exA;
                    bwVar.objType = 1;
                    if (v.this.gSA != null) {
                        v.this.gSA.a(amVar2.getView(), (bv) qVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 3, false);
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
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, am<bv> amVar) {
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) amVar);
        if (bvVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tW().setPage(this.ahu);
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
        amVar.b((am<bv>) bvVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gSA);
        if (this.iRl != null) {
            bvVar.exA.eBK = (bvVar.position + 1) - (this.iGN != null ? this.iGN.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cEP().a(this.iRl, bvVar.exA);
        ao(bvVar.exA);
        bvVar.exA.bnM();
        com.baidu.tieba.frs.d.a.a(bvVar.exA, this.mPageId, this.iRl, getTbPageTag());
        if (bvVar != null) {
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

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void vd(int i) {
        this.iRh = i;
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }

    @Override // com.baidu.tieba.card.aa
    public void oA(boolean z) {
        this.iRG = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRl;
    }
}
