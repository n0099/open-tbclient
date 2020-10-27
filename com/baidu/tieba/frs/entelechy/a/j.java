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
public class j extends com.baidu.tieba.frs.k<bw, am<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String ahu;
    private boolean akk;
    private NEGFeedBackView.a gMF;
    private com.baidu.tieba.card.ab<bw> gMb;
    private int hvC;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iHO;
    private com.baidu.adp.lib.d.b<TbImageView> iHP;
    private boolean iLJ;
    private boolean iLK;
    private boolean iLL;
    private HashSet<String> iLm;
    private int iLn;
    private com.baidu.tieba.frs.d.b iLo;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.iLJ = false;
        this.akk = true;
        this.iLK = false;
        this.iLo = new com.baidu.tieba.frs.d.b();
        this.gMb = new com.baidu.tieba.card.ab<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (j.this.iAW != null) {
                        j.this.iAW.a(view, (View) bwVar, (Object) j.this.getType());
                    }
                    if ("c13010".equals(j.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").aj("obj_type", 1).w("fid", bwVar.getFid()).dR("tid", bwVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, j.this.mPageId, j.this.iLo, j.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (j.this.gMb.aiJ instanceof Boolean) {
                            if (((Boolean) j.this.gMb.aiJ).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bwVar, 1, j.this.mPageId, j.this.iLo, j.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bwVar, 3, j.this.mPageId, j.this.iLo, j.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, j.this.mPageId, j.this.iLo, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, j.this.mPageId, j.this.iLo, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, j.this.mPageId, j.this.iLo, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, j.this.mPageId, j.this.iLo, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, j.this.mPageId, j.this.iLo, j.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, j.this.mPageId, j.this.iLo, j.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cCo().a(j.this.iLo, bwVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.j.a(j.this.iLo, bwVar.bhA());
                    } else if (view instanceof TbImageView) {
                        if (j.this.gMb.aiJ instanceof Boolean) {
                            if (((Boolean) j.this.gMb.aiJ).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cCo().a(j.this.iLo, bwVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cCo().a(j.this.iLo, bwVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cCo().a(j.this.iLo, bwVar, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.cCo().a(j.this.iLo, bwVar, 1);
                    } else {
                        int i = 6;
                        if (bwVar.blD() != null && bwVar.blD().dHz() != null && bwVar.blD().dHz().bDj() != null && bwVar.blD().dHz().bDj().size() > 0) {
                            i = bwVar.blD().mRu ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cCo().a(j.this.iLo, bwVar, i);
                    }
                }
            }
        };
        this.gMF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.j.2
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
                    TiebaStatic.log(new aq("c11974").dR("obj_locate", sb.toString()).dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("nid", arVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", arVar.source).dR("weight", arVar.weight).dR("ab_tag", arVar.abTag).dR("extra", arVar.extra).aj(IntentConfig.CARD_TYPE, arVar.cardType).aj("obj_floor", arVar.evR));
                }
            }
        };
        this.iHO = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cyu */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(j.this.mPageContext.getPageActivity());
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
        this.iHP = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bqz */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(j.this.mPageContext.getPageActivity());
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
    /* renamed from: aT */
    public am<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bo(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.j.5
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
        wVar.setConstrainLayoutPool(this.iHO);
        wVar.setConstrainImagePool(this.iHP);
        wVar.setFromCDN(this.akk);
        if (this.hvC == 502) {
            wVar.setNeedFrsTabName(false);
        } else {
            wVar.setNeedFrsTabName(true);
        }
        aVar.c(wVar);
        if (this.iLL) {
            com.baidu.card.s sVar = new com.baidu.card.s(this.mPageContext.getPageActivity());
            sVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
            aVar.a((com.baidu.card.i) sVar);
        }
        au auVar = new au(this.mPageContext.getPageActivity());
        auVar.setPageContext(this.mPageContext);
        auVar.setFromForPb(3);
        auVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
        aVar.a((com.baidu.card.i) auVar);
        com.baidu.card.ag agVar = new com.baidu.card.ag(this.mPageContext.getPageActivity());
        agVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.i) agVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        aaVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.i) aaVar);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.bs(czy());
        aVar.a((com.baidu.card.i) lVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.ai(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.i) nVar);
        nVar.setFromCDN(this.akk);
        nVar.setForm("frs");
        if (!aI(1) || !aI(2)) {
            wVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.j.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    j.this.h(i, i2, i3);
                    if (j.this.aI(1) && j.this.aI(2)) {
                        wVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.etA = this.iLJ ? 10 : 2;
        cVar.etG = 2;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(3);
        anVar.bo(16);
        if (this.iLK) {
            anVar.bp(4);
        }
        aVar.b(anVar);
        aVar.tU().bv(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak tV = aVar.tV();
        tV.setSourceForPb(3);
        am<bw> amVar = new am<>(tV);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.j.7
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = (bw) qVar;
                    bwVar.objType = 1;
                    if (j.this.gMb != null) {
                        j.this.gMb.a(amVar2.getView(), bwVar);
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
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, am<bw> amVar) {
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) amVar);
        if (bwVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tW().setPage(this.ahu);
        com.baidu.tieba.frs.j.a(amVar.tW().tQ(), this.iAQ);
        if (this.iAQ != null && this.iAQ.getForum() != null && !StringUtils.isNull(this.iAQ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iAQ.getForum().getTopic_special_icon_right())) {
            bwVar.dG(this.iAQ.getForum().getTopic_special_icon(), this.iAQ.getForum().getTopic_special_icon_right());
        }
        boolean z = (bwVar.bka() == null || bwVar.bka().getUserId() == null || !bwVar.bka().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bwVar.blp() && bwVar.getFeedBackReasonMap() != null && !z) {
            amVar.aL(true).a(this.gMF);
        }
        amVar.tY();
        amVar.b((am<bw>) bwVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.gMb);
        if (this.iLo != null) {
            bwVar.evR = (i + 1) - (this.iAQ != null ? this.iAQ.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cCo().a(this.iLo, bwVar);
        ao(bwVar);
        bwVar.blm();
        com.baidu.tieba.frs.d.a.a(bwVar, this.mPageId, this.iLo, getTbPageTag());
        bwVar.blm();
        return amVar.getView();
    }

    private void ao(bw bwVar) {
        if (this.iLm == null) {
            this.iLm = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.cCo().a(bwVar, this.iLm);
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uQ(int i) {
        this.hvC = i;
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.card.aa
    public void or(boolean z) {
        this.iLJ = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iLo;
    }

    public void pQ(boolean z) {
        this.iLK = z;
    }

    public void pR(boolean z) {
        this.iLL = z;
    }

    public void zh(int i) {
        this.iLn = i;
    }

    public int czy() {
        return this.iLn;
    }
}
