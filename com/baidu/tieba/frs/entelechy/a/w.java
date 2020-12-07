package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.an;
import com.baidu.card.au;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
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
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes22.dex */
public class w extends com.baidu.tieba.frs.k<bx, com.baidu.card.am<bx>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aiw;
    private boolean alo;
    private NEGFeedBackView.a hbY;
    private com.baidu.tieba.card.ab<bx> hbu;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iZp;
    private com.baidu.adp.lib.d.b<TbImageView> iZq;
    private int jcO;
    private HashSet<String> jcQ;
    private com.baidu.tieba.frs.d.b jcS;
    private boolean jdp;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jdp = false;
        this.alo = true;
        this.jcS = new com.baidu.tieba.frs.d.b();
        this.hbu = new com.baidu.tieba.card.ab<bx>() { // from class: com.baidu.tieba.frs.entelechy.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bx bxVar) {
                if (view != null && bxVar != null) {
                    if (w.this.iSz != null) {
                        w.this.iSz.a(view, (View) bxVar, (Object) w.this.getType());
                    }
                    if ("c13010".equals(w.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").al("obj_type", 1).w("fid", bxVar.eCR.getFid()).dY("tid", bxVar.eCR.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bxVar.eCR, 2, w.this.mPageId, w.this.jcS, w.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar.eCR, 5, w.this.mPageId, w.this.jcS, w.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bxVar.eCR, 14, w.this.mPageId, w.this.jcS, w.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bxVar.eCR, 12, w.this.mPageId, w.this.jcS, w.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bxVar.eCR, 13, w.this.mPageId, w.this.jcS, w.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (w.this.hbu.ajN instanceof Boolean) {
                            if (((Boolean) w.this.hbu.ajN).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bxVar.eCR, 1, w.this.mPageId, w.this.jcS, w.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bxVar.eCR, 3, w.this.mPageId, w.this.jcS, w.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bxVar.eCR, 15, w.this.mPageId, w.this.jcS, w.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bxVar.eCR, 1, w.this.mPageId, w.this.jcS, w.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cJH().a(w.this.jcS, bxVar.eCR, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.k.a(w.this.jcS, bxVar.bmo());
                    } else if (view instanceof TbImageView) {
                        if (w.this.hbu.ajN instanceof Boolean) {
                            if (((Boolean) w.this.hbu.ajN).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cJH().a(w.this.jcS, bxVar.eCR, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cJH().a(w.this.jcS, bxVar.eCR, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cJH().a(w.this.jcS, bxVar.eCR, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.cJH().a(w.this.jcS, bxVar.eCR, 1);
                    } else {
                        int i = 6;
                        if (bxVar.eCR.bqu() != null && bxVar.eCR.bqu().dPi() != null && bxVar.eCR.bqu().dPi().bIC() != null && bxVar.eCR.bqu().dPi().bIC().size() > 0) {
                            i = bxVar.eCR.bqu().nmn ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cJH().a(w.this.jcS, bxVar.eCR, i);
                    }
                }
            }
        };
        this.hbY = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.w.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                TiebaStatic.log(new ar("c11973").dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                if (arrayList != null && atVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + ",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ar("c11974").dY("obj_locate", sb.toString()).dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("nid", atVar.getNid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("source", atVar.source).dY("weight", atVar.weight).dY("ab_tag", atVar.abTag).dY("extra", atVar.extra).al(IntentConfig.CARD_TYPE, atVar.cardType).al("obj_floor", atVar.eHa));
                }
            }
        };
        this.iZp = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.w.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cEO */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(w.this.mPageContext.getPageActivity());
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
        this.iZq = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.w.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bvP */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(w.this.mPageContext.getPageActivity());
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
    public com.baidu.card.am<bx> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bs(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.w.5
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
        if (this.jcO == 502) {
            wVar.setNeedFrsTabName(false);
        } else {
            wVar.setNeedFrsTabName(true);
        }
        wVar.setConstrainLayoutPool(this.iZp);
        wVar.setConstrainImagePool(this.iZq);
        wVar.setFromCDN(this.alo);
        aVar.c(wVar);
        au auVar = new au(this.mPageContext.getPageActivity());
        auVar.setPageContext(this.mPageContext);
        auVar.setFromForPb(3);
        aVar.a((com.baidu.card.i) auVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.ai(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.i) nVar);
        nVar.setFromCDN(this.alo);
        nVar.setForm("frs");
        if (!aN(1) || !aN(2)) {
            wVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.w.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    w.this.h(i, i2, i3);
                    if (w.this.aN(1) && w.this.aN(2)) {
                        wVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = this.jdp ? 10 : 2;
        dVar.eEP = 2;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(3);
        anVar.bs(16);
        aVar.b(anVar);
        aVar.tY().bz(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak tX = aVar.tX();
        tX.setSourceForPb(3);
        com.baidu.card.am<bx> amVar = new com.baidu.card.am<>(tX);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.w.7
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bx) && (view.getTag() instanceof com.baidu.card.am)) {
                    com.baidu.card.am amVar2 = (com.baidu.card.am) view.getTag();
                    by byVar = ((bx) qVar).eCR;
                    byVar.objType = 1;
                    if (w.this.hbu != null) {
                        w.this.hbu.a(amVar2.getView(), (bx) qVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), 3, false);
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        amVar.ua();
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, com.baidu.card.am<bx> amVar) {
        super.a(i, view, viewGroup, (ViewGroup) bxVar, (bx) amVar);
        if (bxVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tZ().setPage(this.aiw);
        com.baidu.tieba.frs.j.a(amVar.tZ().tT(), this.iSt);
        if (this.iSt != null && this.iSt.getForum() != null && !StringUtils.isNull(this.iSt.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iSt.getForum().getTopic_special_icon_right())) {
            bxVar.eCR.dL(this.iSt.getForum().getTopic_special_icon(), this.iSt.getForum().getTopic_special_icon_right());
        }
        boolean z = (bxVar.eCR.boP() == null || bxVar.eCR.boP().getUserId() == null || !bxVar.eCR.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bxVar.eCR.bqg() && bxVar.eCR.getFeedBackReasonMap() != null && !z) {
            amVar.aN(true).a(this.hbY);
        }
        amVar.ub();
        if (amVar.tZ().tT() != null) {
            amVar.tZ().tT().bs(32);
        }
        amVar.b((com.baidu.card.am<bx>) bxVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.hbu);
        if (this.jcS != null) {
            bxVar.eCR.eHa = (bxVar.position + 1) - (this.iSt != null ? this.iSt.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cJH().a(this.jcS, bxVar.eCR);
        aq(bxVar.eCR);
        bxVar.eCR.bqd();
        com.baidu.tieba.frs.d.a.a(bxVar.eCR, this.mPageId, this.jcS, getTbPageTag());
        if (bxVar != null) {
            bxVar.eCR.bqd();
        }
        return amVar.getView();
    }

    private void aq(by byVar) {
        if (this.jcQ == null) {
            this.jcQ = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.cJH().a(byVar, this.jcQ);
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
        this.jcO = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    @Override // com.baidu.tieba.card.aa
    public void oZ(boolean z) {
        this.jdp = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.jcS;
    }
}
