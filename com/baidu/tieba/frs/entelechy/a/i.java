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
/* loaded from: classes9.dex */
public class i extends com.baidu.tieba.frs.h<bj, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String LC;
    private boolean NJ;
    private com.baidu.tieba.card.z<bj> eMW;
    private NEGFeedBackView.a eNy;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> gtj;
    private com.baidu.adp.lib.d.b<TbImageView> gtk;
    private boolean gwI;
    private boolean gwJ;
    private HashSet<String> gwm;
    private com.baidu.tieba.frs.d.b gwo;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.gwI = false;
        this.NJ = true;
        this.gwJ = false;
        this.gwo = new com.baidu.tieba.frs.d.b();
        this.eMW = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (i.this.gnQ != null) {
                        i.this.gnQ.a(view, (View) bjVar, (Object) i.this.getType());
                    }
                    if ("c13010".equals(i.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").X("obj_type", 1).s("fid", bjVar.getFid()).cy("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, i.this.mPageId, i.this.gwo, i.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (i.this.eMW.MU instanceof Boolean) {
                            if (((Boolean) i.this.eMW.MU).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bjVar, 1, i.this.mPageId, i.this.gwo, i.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bjVar, 3, i.this.mPageId, i.this.gwo, i.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, i.this.mPageId, i.this.gwo, i.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, i.this.mPageId, i.this.gwo, i.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, i.this.mPageId, i.this.gwo, i.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, i.this.mPageId, i.this.gwo, i.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, i.this.mPageId, i.this.gwo, i.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, i.this.mPageId, i.this.gwo, i.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJH().a(i.this.gwo, bjVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(i.this.gwo, bjVar.aAf());
                    } else if (view instanceof TbImageView) {
                        if (i.this.eMW.MU instanceof Boolean) {
                            if (((Boolean) i.this.eMW.MU).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bJH().a(i.this.gwo, bjVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.bJH().a(i.this.gwo, bjVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bJH().a(i.this.gwo, bjVar, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.bJH().a(i.this.gwo, bjVar, 1);
                    } else {
                        int i = 6;
                        if (bjVar.aDK() != null && bjVar.aDK().cLa() != null && bjVar.aDK().cLa().aTQ() != null && bjVar.aDK().cLa().aTQ().size() > 0) {
                            i = bjVar.aDK().kgZ ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bJH().a(i.this.gwo, bjVar, i);
                    }
                }
            }
        };
        this.eNy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.i.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(new an("c11973").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11974").cy("obj_locate", sb.toString()).cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("source", alVar.source).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cy(TiebaInitialize.Params.AB_TAG, alVar.cPD).cy("extra", alVar.extra).X("card_type", alVar.cardType).X("obj_floor", alVar.cPE));
                }
            }
        };
        this.gtj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bGa */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(i.this.mPageContext.getPageActivity());
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
        this.gtk = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.i.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aIe */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
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
    /* renamed from: aM */
    public com.baidu.card.af<bj> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aK(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.i.5
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
        sVar.setConstrainLayoutPool(this.gtj);
        sVar.setConstrainImagePool(this.gtk);
        sVar.setFromCDN(this.NJ);
        aVar.c(sVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ab(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) kVar);
        kVar.setFromCDN(this.NJ);
        kVar.setForm("frs");
        if (!ah(1) || !ah(2)) {
            sVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.i.6
                @Override // com.baidu.adp.widget.a.b
                public void h(int i, int i2, int i3) {
                    i.this.g(i, i2, i3);
                    if (i.this.ah(1) && i.this.ah(2)) {
                        sVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNA = this.gwI ? 10 : 2;
        dVar.cNG = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.aZ(3);
        agVar.aK(16);
        if (this.gwJ) {
            agVar.aL(4);
        }
        aVar.b(agVar);
        aVar.ni().aR(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ad nj = aVar.nj();
        nj.aQ(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(nj);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.i.7
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bj) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = (bj) mVar;
                    bjVar.objType = 1;
                    if (i.this.eMW != null) {
                        i.this.eMW.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 3, false);
                    afVar2.nk().b(new a.C0052a(1));
                }
            }
        });
        afVar.nl();
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.card.af<bj> afVar) {
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) afVar);
        if (bjVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        afVar.nk().setPage(this.LC);
        com.baidu.tieba.frs.g.a(afVar.nk().ne(), this.gnK);
        if (this.gnK != null && this.gnK.getForum() != null && !StringUtils.isNull(this.gnK.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.gnK.getForum().getTopic_special_icon_right())) {
            bjVar.cp(this.gnK.getForum().getTopic_special_icon(), this.gnK.getForum().getTopic_special_icon_right());
        }
        boolean z = (bjVar.aCm() == null || bjVar.aCm().getUserId() == null || !bjVar.aCm().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bjVar.aDx() && bjVar.getFeedBackReasonMap() != null && !z) {
            afVar.ag(true).a(this.eNy);
        }
        afVar.nm();
        afVar.b((com.baidu.card.af<bj>) bjVar);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.eMW);
        if (this.gwo != null) {
            bjVar.cPE = (i + 1) - (this.gnK != null ? this.gnK.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bJH().a(this.gwo, bjVar);
        am(bjVar);
        bjVar.aDu();
        com.baidu.tieba.frs.d.a.a(bjVar, this.mPageId, this.gwo, getTbPageTag());
        bjVar.aDu();
        return afVar.getView();
    }

    private void am(bj bjVar) {
        if (this.gwm == null) {
            this.gwm = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bJH().a(bjVar, this.gwm);
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.card.y
    public void kr(boolean z) {
        this.gwI = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bGV() {
        return this.gwo;
    }

    public void lN(boolean z) {
        this.gwJ = z;
    }
}
