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
/* loaded from: classes9.dex */
public class u extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bi>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String aeB;
    private boolean agw;
    private NEGFeedBackView.a fsJ;
    private com.baidu.tieba.card.z<bi> fsf;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hdt;
    private com.baidu.adp.lib.d.b<TbImageView> hdu;
    private int hgI;
    private HashSet<String> hgK;
    private com.baidu.tieba.frs.d.b hgM;
    private boolean hhh;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hhh = false;
        this.agw = true;
        this.hgM = new com.baidu.tieba.frs.d.b();
        this.fsf = new com.baidu.tieba.card.z<bi>() { // from class: com.baidu.tieba.frs.entelechy.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bi biVar) {
                if (view != null && biVar != null) {
                    if (u.this.gYa != null) {
                        u.this.gYa.a(view, (View) biVar, (Object) u.this.getType());
                    }
                    if ("c13010".equals(u.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").af("obj_type", 1).t("fid", biVar.dqE.getFid()).cI("tid", biVar.dqE.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(biVar.dqE, 2, u.this.mPageId, u.this.hgM, u.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(biVar.dqE, 5, u.this.mPageId, u.this.hgM, u.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(biVar.dqE, 14, u.this.mPageId, u.this.hgM, u.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(biVar.dqE, 12, u.this.mPageId, u.this.hgM, u.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(biVar.dqE, 13, u.this.mPageId, u.this.hgM, u.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (u.this.fsf.afJ instanceof Boolean) {
                            if (((Boolean) u.this.fsf.afJ).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(biVar.dqE, 1, u.this.mPageId, u.this.hgM, u.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(biVar.dqE, 3, u.this.mPageId, u.this.hgM, u.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(biVar.dqE, 15, u.this.mPageId, u.this.hgM, u.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(biVar.dqE, 1, u.this.mPageId, u.this.hgM, u.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bUs().a(u.this.hgM, biVar.dqE, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(u.this.hgM, biVar.aIv());
                    } else if (view instanceof TbImageView) {
                        if (u.this.fsf.afJ instanceof Boolean) {
                            if (((Boolean) u.this.fsf.afJ).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bUs().a(u.this.hgM, biVar.dqE, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.bUs().a(u.this.hgM, biVar.dqE, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bUs().a(u.this.hgM, biVar.dqE, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.bUs().a(u.this.hgM, biVar.dqE, 1);
                    } else {
                        int i = 6;
                        if (biVar.dqE.aMc() != null && biVar.dqE.aMc().cWq() != null && biVar.dqE.aMc().cWq().bcf() != null && biVar.dqE.aMc().cWq().bcf().size() > 0) {
                            i = biVar.dqE.aMc().kTa ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bUs().a(u.this.hgM, biVar.dqE, i);
                    }
                }
            }
        };
        this.fsJ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.u.2
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
                    TiebaStatic.log(new an("c11974").cI("obj_locate", sb.toString()).cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("source", alVar.source).cI(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cI(TiebaInitialize.Params.AB_TAG, alVar.dpc).cI("extra", alVar.extra).af("card_type", alVar.cardType).af("obj_floor", alVar.dpd));
                }
            }
        };
        this.hdt = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.u.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bQO */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(u.this.mPageContext.getPageActivity());
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
        this.hdu = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.u.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aQE */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(u.this.mPageContext.getPageActivity());
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
    public com.baidu.card.af<bi> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aW(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.u.5
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
        if (this.hgI == 502) {
            sVar.setNeedFrsTabName(false);
        } else {
            sVar.setNeedFrsTabName(true);
        }
        sVar.setConstrainLayoutPool(this.hdt);
        sVar.setConstrainImagePool(this.hdu);
        sVar.setFromCDN(this.agw);
        aVar.c(sVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ab(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) kVar);
        kVar.setFromCDN(this.agw);
        kVar.setForm("frs");
        if (!at(1) || !at(2)) {
            sVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.u.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    u.this.h(i, i2, i3);
                    if (u.this.at(1) && u.this.at(2)) {
                        sVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        com.baidu.card.ag agVar = new com.baidu.card.ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmX = this.hhh ? 10 : 2;
        dVar.dnd = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.bl(3);
        agVar.aW(16);
        aVar.b(agVar);
        aVar.rB().bd(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ad rC = aVar.rC();
        rC.bc(3);
        com.baidu.card.af<bi> afVar = new com.baidu.card.af<>(rC);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.frs.entelechy.a.u.7
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).dqE;
                    bjVar.objType = 1;
                    if (u.this.fsf != null) {
                        u.this.fsf.a(afVar2.getView(), (bi) mVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 3, false);
                    afVar2.rD().b(new a.C0095a(1));
                }
            }
        });
        afVar.rE();
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
        afVar.rD().setPage(this.aeB);
        com.baidu.tieba.frs.g.a(afVar.rD().rx(), this.gXU);
        if (this.gXU != null && this.gXU.getForum() != null && !StringUtils.isNull(this.gXU.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.gXU.getForum().getTopic_special_icon_right())) {
            biVar.dqE.cz(this.gXU.getForum().getTopic_special_icon(), this.gXU.getForum().getTopic_special_icon_right());
        }
        boolean z = (biVar.dqE.aKC() == null || biVar.dqE.aKC().getUserId() == null || !biVar.dqE.aKC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (biVar.dqE.aLO() && biVar.dqE.getFeedBackReasonMap() != null && !z) {
            afVar.aF(true).a(this.fsJ);
        }
        afVar.rF();
        if (biVar.dqE.aLO() && afVar.rD().rx() != null) {
            afVar.rD().rx().aW(32);
        }
        afVar.b((com.baidu.card.af<bi>) biVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.fsf);
        if (this.hgM != null) {
            biVar.dqE.dpd = (biVar.position + 1) - (this.gXU != null ? this.gXU.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bUs().a(this.hgM, biVar.dqE);
        ap(biVar.dqE);
        biVar.dqE.aLL();
        com.baidu.tieba.frs.d.a.a(biVar.dqE, this.mPageId, this.hgM, getTbPageTag());
        if (biVar != null) {
            biVar.dqE.aLL();
        }
        return afVar.getView();
    }

    private void ap(bj bjVar) {
        if (this.hgK == null) {
            this.hgK = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bUs().a(bjVar, this.hgK);
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.agw = z;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
        this.hgI = i;
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }

    @Override // com.baidu.tieba.card.y
    public void lz(boolean z) {
        this.hhh = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hgM;
    }
}
