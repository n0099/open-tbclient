package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.card.a.a;
import com.baidu.card.ad;
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
public class j extends com.baidu.tieba.frs.h<bj, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String aey;
    private boolean agt;
    private int fWX;
    private NEGFeedBackView.a fsE;
    private com.baidu.tieba.card.z<bj> fsa;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hdn;
    private com.baidu.adp.lib.d.b<TbImageView> hdo;
    private HashSet<String> hgE;
    private com.baidu.tieba.frs.d.b hgG;
    private boolean hhb;
    private boolean hhc;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hhb = false;
        this.agt = true;
        this.hhc = false;
        this.hgG = new com.baidu.tieba.frs.d.b();
        this.fsa = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (j.this.gXU != null) {
                        j.this.gXU.a(view, (View) bjVar, (Object) j.this.getType());
                    }
                    if ("c13010".equals(j.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").af("obj_type", 1).t("fid", bjVar.getFid()).cI("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, j.this.mPageId, j.this.hgG, j.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (j.this.fsa.afG instanceof Boolean) {
                            if (((Boolean) j.this.fsa.afG).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bjVar, 1, j.this.mPageId, j.this.hgG, j.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bjVar, 3, j.this.mPageId, j.this.hgG, j.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, j.this.mPageId, j.this.hgG, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, j.this.mPageId, j.this.hgG, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, j.this.mPageId, j.this.hgG, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, j.this.mPageId, j.this.hgG, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, j.this.mPageId, j.this.hgG, j.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, j.this.mPageId, j.this.hgG, j.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bUu().a(j.this.hgG, bjVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(j.this.hgG, bjVar.aIx());
                    } else if (view instanceof TbImageView) {
                        if (j.this.fsa.afG instanceof Boolean) {
                            if (((Boolean) j.this.fsa.afG).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bUu().a(j.this.hgG, bjVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.bUu().a(j.this.hgG, bjVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bUu().a(j.this.hgG, bjVar, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.bUu().a(j.this.hgG, bjVar, 1);
                    } else {
                        int i = 6;
                        if (bjVar.aMe() != null && bjVar.aMe().cWt() != null && bjVar.aMe().cWt().bch() != null && bjVar.aMe().cWt().bch().size() > 0) {
                            i = bjVar.aMe().kSW ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bUu().a(j.this.hgG, bjVar, i);
                    }
                }
            }
        };
        this.fsE = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.j.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(new an("c11973").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11974").cI("obj_locate", sb.toString()).cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("source", alVar.source).cI(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cI(TiebaInitialize.Params.AB_TAG, alVar.doY).cI("extra", alVar.extra).af("card_type", alVar.cardType).af("obj_floor", alVar.doZ));
                }
            }
        };
        this.hdn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bQQ */
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
        this.hdo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aQH */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(j.this.mPageContext.getPageActivity());
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
    /* renamed from: aA */
    public com.baidu.card.af<bj> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aW(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.j.5
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
        sVar.setConstrainLayoutPool(this.hdn);
        sVar.setConstrainImagePool(this.hdo);
        sVar.setFromCDN(this.agt);
        if (this.fWX == 502) {
            sVar.setNeedFrsTabName(false);
        } else {
            sVar.setNeedFrsTabName(true);
        }
        aVar.c(sVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ab(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) kVar);
        kVar.setFromCDN(this.agt);
        kVar.setForm("frs");
        if (!at(1) || !at(2)) {
            sVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.j.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    j.this.h(i, i2, i3);
                    if (j.this.at(1) && j.this.at(2)) {
                        sVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        com.baidu.card.ag agVar = new com.baidu.card.ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmT = this.hhb ? 10 : 2;
        dVar.dmZ = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.bl(3);
        agVar.aW(16);
        if (this.hhc) {
            agVar.aX(4);
        }
        aVar.b(agVar);
        aVar.rB().bd(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ad rC = aVar.rC();
        rC.bc(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(rC);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.frs.entelechy.a.j.7
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bj) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = (bj) mVar;
                    bjVar.objType = 1;
                    if (j.this.fsa != null) {
                        j.this.fsa.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 3, false);
                    afVar2.rD().b(new a.C0074a(1));
                }
            }
        });
        afVar.rE();
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
        afVar.rD().setPage(this.aey);
        com.baidu.tieba.frs.g.a(afVar.rD().rx(), this.gXO);
        if (this.gXO != null && this.gXO.getForum() != null && !StringUtils.isNull(this.gXO.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.gXO.getForum().getTopic_special_icon_right())) {
            bjVar.cz(this.gXO.getForum().getTopic_special_icon(), this.gXO.getForum().getTopic_special_icon_right());
        }
        boolean z = (bjVar.aKE() == null || bjVar.aKE().getUserId() == null || !bjVar.aKE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bjVar.aLQ() && bjVar.getFeedBackReasonMap() != null && !z) {
            afVar.aF(true).a(this.fsE);
        }
        afVar.rF();
        afVar.b((com.baidu.card.af<bj>) bjVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.fsa);
        if (this.hgG != null) {
            bjVar.doZ = (i + 1) - (this.gXO != null ? this.gXO.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bUu().a(this.hgG, bjVar);
        ap(bjVar);
        bjVar.aLN();
        com.baidu.tieba.frs.d.a.a(bjVar, this.mPageId, this.hgG, getTbPageTag());
        bjVar.aLN();
        return afVar.getView();
    }

    private void ap(bj bjVar) {
        if (this.hgE == null) {
            this.hgE = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bUu().a(bjVar, this.hgE);
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.agt = z;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.fWX = i;
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
        this.aey = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.card.y
    public void lz(boolean z) {
        this.hhb = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hgG;
    }

    public void mW(boolean z) {
        this.hhc = z;
    }
}
