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
public class k extends com.baidu.tieba.frs.k<by, com.baidu.card.am<by>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aiw;
    private boolean alo;
    private int hKL;
    private NEGFeedBackView.a hbY;
    private com.baidu.tieba.card.ab<by> hbu;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> iZp;
    private com.baidu.adp.lib.d.b<TbImageView> iZq;
    private HashSet<String> jcQ;
    private int jcR;
    private com.baidu.tieba.frs.d.b jcS;
    private boolean jdp;
    private boolean jdq;
    private boolean jdr;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jdp = false;
        this.alo = true;
        this.jdq = false;
        this.jcS = new com.baidu.tieba.frs.d.b();
        this.hbu = new com.baidu.tieba.card.ab<by>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                if (view != null && byVar != null) {
                    if (k.this.iSz != null) {
                        k.this.iSz.a(view, (View) byVar, (Object) k.this.getType());
                    }
                    if ("c13010".equals(k.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").al("obj_type", 1).w("fid", byVar.getFid()).dY("tid", byVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(byVar, 2, k.this.mPageId, k.this.jcS, k.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (k.this.hbu.ajN instanceof Boolean) {
                            if (((Boolean) k.this.hbu.ajN).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(byVar, 1, k.this.mPageId, k.this.jcS, k.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(byVar, 3, k.this.mPageId, k.this.jcS, k.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(byVar, 15, k.this.mPageId, k.this.jcS, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 5, k.this.mPageId, k.this.jcS, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 14, k.this.mPageId, k.this.jcS, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 12, k.this.mPageId, k.this.jcS, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 13, k.this.mPageId, k.this.jcS, k.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(byVar, 1, k.this.mPageId, k.this.jcS, k.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cJH().a(k.this.jcS, byVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.k.a(k.this.jcS, byVar.bmo());
                    } else if (view instanceof TbImageView) {
                        if (k.this.hbu.ajN instanceof Boolean) {
                            if (((Boolean) k.this.hbu.ajN).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cJH().a(k.this.jcS, byVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cJH().a(k.this.jcS, byVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cJH().a(k.this.jcS, byVar, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.cJH().a(k.this.jcS, byVar, 1);
                    } else {
                        int i = 6;
                        if (byVar.bqu() != null && byVar.bqu().dPi() != null && byVar.bqu().dPi().bIC() != null && byVar.bqu().dPi().bIC().size() > 0) {
                            i = byVar.bqu().nmn ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cJH().a(k.this.jcS, byVar, i);
                    }
                }
            }
        };
        this.hbY = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.k.2
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
        this.iZp = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cEO */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(k.this.mPageContext.getPageActivity());
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
        this.iZq = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bvP */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(k.this.mPageContext.getPageActivity());
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
    public com.baidu.card.am<by> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bs(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.k.5
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
        wVar.setConstrainLayoutPool(this.iZp);
        wVar.setConstrainImagePool(this.iZq);
        wVar.setFromCDN(this.alo);
        if (this.hKL == 502) {
            wVar.setNeedFrsTabName(false);
        } else {
            wVar.setNeedFrsTabName(true);
        }
        aVar.c(wVar);
        if (this.jdr) {
            aVar.a((com.baidu.card.i) new com.baidu.card.s(this.mPageContext.getPageActivity()));
        }
        au auVar = new au(this.mPageContext.getPageActivity());
        auVar.setPageContext(this.mPageContext);
        auVar.setFromForPb(3);
        aVar.a((com.baidu.card.i) auVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.bw(cFV());
        aVar.a((com.baidu.card.i) lVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.ai(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.i) nVar);
        nVar.setFromCDN(this.alo);
        nVar.setForm("frs");
        if (!aN(1) || !aN(2)) {
            wVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.k.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    k.this.h(i, i2, i3);
                    if (k.this.aN(1) && k.this.aN(2)) {
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
        anVar.bs(48);
        if (this.jdq) {
            anVar.bt(4);
        }
        aVar.b(anVar);
        aVar.tY().bz(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak tX = aVar.tX();
        tX.setSourceForPb(3);
        com.baidu.card.am<by> amVar = new com.baidu.card.am<>(tX);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.k.7
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof by) && (view.getTag() instanceof com.baidu.card.am)) {
                    com.baidu.card.am amVar2 = (com.baidu.card.am) view.getTag();
                    by byVar = (by) qVar;
                    byVar.objType = 1;
                    if (k.this.hbu != null) {
                        k.this.hbu.a(amVar2.getView(), byVar);
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
    public View a(int i, View view, ViewGroup viewGroup, by byVar, com.baidu.card.am<by> amVar) {
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) amVar);
        if (byVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tZ().setPage(this.aiw);
        com.baidu.tieba.frs.j.a(amVar.tZ().tT(), this.iSt);
        if (this.iSt != null && this.iSt.getForum() != null && !StringUtils.isNull(this.iSt.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iSt.getForum().getTopic_special_icon_right())) {
            byVar.dL(this.iSt.getForum().getTopic_special_icon(), this.iSt.getForum().getTopic_special_icon_right());
        }
        boolean z = (byVar.boP() == null || byVar.boP().getUserId() == null || !byVar.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (byVar.bqg() && byVar.getFeedBackReasonMap() != null && !z) {
            amVar.aN(true).a(this.hbY);
        }
        amVar.ub();
        amVar.b((com.baidu.card.am<by>) byVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.hbu);
        if (this.jcS != null) {
            byVar.eHa = (i + 1) - (this.iSt != null ? this.iSt.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cJH().a(this.jcS, byVar);
        aq(byVar);
        byVar.bqd();
        com.baidu.tieba.frs.d.a.a(byVar, this.mPageId, this.jcS, getTbPageTag());
        byVar.bqd();
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
        this.hKL = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.card.aa
    public void oZ(boolean z) {
        this.jdp = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.jcS;
    }

    public void qz(boolean z) {
        this.jdq = z;
    }

    public void qA(boolean z) {
        this.jdr = z;
    }

    public void Ax(int i) {
        this.jcR = i;
    }

    public int cFV() {
        return this.jcR;
    }
}
