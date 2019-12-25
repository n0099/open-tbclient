package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.ag;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class s extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bi>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String La;
    private boolean Nf;
    private com.baidu.tieba.card.z<bi> eHS;
    private NEGFeedBackView.a eIv;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gnZ;
    private com.baidu.adp.lib.d.b<TbImageView> goa;
    private HashSet<String> grc;
    private com.baidu.tieba.frs.d.b gre;
    private boolean gry;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.gry = false;
        this.Nf = true;
        this.gre = new com.baidu.tieba.frs.d.b();
        this.eHS = new com.baidu.tieba.card.z<bi>() { // from class: com.baidu.tieba.frs.entelechy.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bi biVar) {
                if (view != null && biVar != null) {
                    if (s.this.giG != null) {
                        s.this.giG.a(view, (View) biVar, (Object) s.this.getType());
                    }
                    if ("c13010".equals(s.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").Z("obj_type", 1).s("fid", biVar.cMR.getFid()).cp("tid", biVar.cMR.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(biVar.cMR, 2, s.this.mPageId, s.this.gre, s.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(biVar.cMR, 5, s.this.mPageId, s.this.gre, s.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(biVar.cMR, 14, s.this.mPageId, s.this.gre, s.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(biVar.cMR, 12, s.this.mPageId, s.this.gre, s.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(biVar.cMR, 13, s.this.mPageId, s.this.gre, s.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (s.this.eHS.Mn instanceof Boolean) {
                            if (((Boolean) s.this.eHS.Mn).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(biVar.cMR, 1, s.this.mPageId, s.this.gre, s.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(biVar.cMR, 3, s.this.mPageId, s.this.gre, s.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(biVar.cMR, 15, s.this.mPageId, s.this.gre, s.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(biVar.cMR, 1, s.this.mPageId, s.this.gre, s.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bHd().a(s.this.gre, biVar.cMR, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(s.this.gre, biVar.axy());
                    } else if (view instanceof TbImageView) {
                        if (s.this.eHS.Mn instanceof Boolean) {
                            if (((Boolean) s.this.eHS.Mn).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bHd().a(s.this.gre, biVar.cMR, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.bHd().a(s.this.gre, biVar.cMR, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bHd().a(s.this.gre, biVar.cMR, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.bHd().a(s.this.gre, biVar.cMR, 1);
                    } else {
                        int i = 6;
                        if (biVar.cMR.aBe() != null && biVar.cMR.aBe().cIv() != null && biVar.cMR.aBe().cIv().aRf() != null && biVar.cMR.aBe().cIv().aRf().size() > 0) {
                            i = biVar.cMR.aBe().kcq ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bHd().a(s.this.gre, biVar.cMR, i);
                    }
                }
            }
        };
        this.eIv = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.s.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(new an("c11973").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, al alVar) {
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11974").cp("obj_locate", sb.toString()).cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("source", alVar.source).cp(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cp(TiebaInitialize.Params.AB_TAG, alVar.cLq).cp("extra", alVar.extra).Z("card_type", alVar.cardType).Z("obj_floor", alVar.cLr));
                }
            }
        };
        this.gnZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.s.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bDw */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(s.this.mPageContext.getPageActivity());
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
        this.goa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aFw */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(s.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10043));
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
    /* renamed from: aI */
    public com.baidu.card.af<bi> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aH(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.s.5
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
        final com.baidu.card.s sVar = new com.baidu.card.s(this.mPageContext.getPageActivity());
        sVar.setFrom("frs");
        sVar.setConstrainLayoutPool(this.gnZ);
        sVar.setConstrainImagePool(this.goa);
        sVar.setFromCDN(this.Nf);
        aVar.c(sVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ab(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) kVar);
        kVar.setFromCDN(this.Nf);
        kVar.setForm("frs");
        if (!ae(1) || !ae(2)) {
            sVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.s.6
                @Override // com.baidu.adp.widget.a.b
                public void h(int i, int i2, int i3) {
                    s.this.g(i, i2, i3);
                    if (s.this.ae(1) && s.this.ae(2)) {
                        sVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJm = this.gry ? 10 : 2;
        dVar.cJs = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.aV(3);
        agVar.aH(16);
        aVar.b(agVar);
        aVar.mR().aN(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ad mS = aVar.mS();
        mS.aM(3);
        com.baidu.card.af<bi> afVar = new com.baidu.card.af<>(mS);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.s.7
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cMR;
                    bjVar.objType = 1;
                    if (s.this.eHS != null) {
                        s.this.eHS.a(afVar2.getView(), (bi) mVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 3, false);
                    afVar2.mT().b(new a.C0050a(1));
                }
            }
        });
        afVar.mU();
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.card.af<bi> afVar) {
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) afVar);
        if (biVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        afVar.mT().setPage(this.La);
        com.baidu.tieba.frs.g.a(afVar.mT().mN(), this.giA);
        if (this.giA != null && this.giA.getForum() != null && !StringUtils.isNull(this.giA.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.giA.getForum().getTopic_special_icon_right())) {
            biVar.cMR.cg(this.giA.getForum().getTopic_special_icon(), this.giA.getForum().getTopic_special_icon_right());
        }
        boolean z = (biVar.cMR.azE() == null || biVar.cMR.azE().getUserId() == null || !biVar.cMR.azE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (biVar.cMR.aAR() && biVar.cMR.getFeedBackReasonMap() != null && !z) {
            afVar.ad(true).a(this.eIv);
        }
        afVar.mV();
        if (biVar.cMR.aAR() && afVar.mT().mN() != null) {
            afVar.mT().mN().aH(32);
        }
        afVar.b((com.baidu.card.af<bi>) biVar);
        afVar.mT().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mT().a(this.eHS);
        if (this.gre != null) {
            biVar.cMR.cLr = (biVar.position + 1) - (this.giA != null ? this.giA.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bHd().a(this.gre, biVar.cMR);
        ak(biVar.cMR);
        biVar.cMR.aAO();
        com.baidu.tieba.frs.d.a.a(biVar.cMR, this.mPageId, this.gre, getTbPageTag());
        if (biVar != null) {
            biVar.cMR.aAO();
        }
        return afVar.getView();
    }

    private void ak(bj bjVar) {
        if (this.grc == null) {
            this.grc = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bHd().a(bjVar, this.grc);
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pm(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void wq(String str) {
        this.La = str;
    }

    @Override // com.baidu.tieba.card.y
    public void ke(boolean z) {
        this.gry = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bEr() {
        return this.gre;
    }
}
