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
    private String LC;
    private boolean NK;
    private com.baidu.tieba.card.z<bi> eNG;
    private NEGFeedBackView.a eOk;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> guc;
    private com.baidu.adp.lib.d.b<TbImageView> gud;
    private boolean gxG;
    private int gxh;
    private HashSet<String> gxj;
    private com.baidu.tieba.frs.d.b gxl;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.gxG = false;
        this.NK = true;
        this.gxl = new com.baidu.tieba.frs.d.b();
        this.eNG = new com.baidu.tieba.card.z<bi>() { // from class: com.baidu.tieba.frs.entelechy.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bi biVar) {
                if (view != null && biVar != null) {
                    if (u.this.goP != null) {
                        u.this.goP.a(view, (View) biVar, (Object) u.this.getType());
                    }
                    if ("c13010".equals(u.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").X("obj_type", 1).s("fid", biVar.cRt.getFid()).cx("tid", biVar.cRt.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(biVar.cRt, 2, u.this.mPageId, u.this.gxl, u.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(biVar.cRt, 5, u.this.mPageId, u.this.gxl, u.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(biVar.cRt, 14, u.this.mPageId, u.this.gxl, u.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(biVar.cRt, 12, u.this.mPageId, u.this.gxl, u.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(biVar.cRt, 13, u.this.mPageId, u.this.gxl, u.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (u.this.eNG.MV instanceof Boolean) {
                            if (((Boolean) u.this.eNG.MV).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(biVar.cRt, 1, u.this.mPageId, u.this.gxl, u.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(biVar.cRt, 3, u.this.mPageId, u.this.gxl, u.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(biVar.cRt, 15, u.this.mPageId, u.this.gxl, u.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(biVar.cRt, 1, u.this.mPageId, u.this.gxl, u.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJX().a(u.this.gxl, biVar.cRt, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(u.this.gxl, biVar.aAk());
                    } else if (view instanceof TbImageView) {
                        if (u.this.eNG.MV instanceof Boolean) {
                            if (((Boolean) u.this.eNG.MV).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bJX().a(u.this.gxl, biVar.cRt, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.bJX().a(u.this.gxl, biVar.cRt, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bJX().a(u.this.gxl, biVar.cRt, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.bJX().a(u.this.gxl, biVar.cRt, 1);
                    } else {
                        int i = 6;
                        if (biVar.cRt.aDQ() != null && biVar.cRt.aDQ().cLx() != null && biVar.cRt.aDQ().cLx().aTX() != null && biVar.cRt.aDQ().cLx().aTX().size() > 0) {
                            i = biVar.cRt.aDQ().kiQ ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bJX().a(u.this.gxl, biVar.cRt, i);
                    }
                }
            }
        };
        this.eOk = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.u.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(new an("c11973").cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11974").cx("obj_locate", sb.toString()).cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("source", alVar.source).cx(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cx(TiebaInitialize.Params.AB_TAG, alVar.cPS).cx("extra", alVar.extra).X("card_type", alVar.cardType).X("obj_floor", alVar.cPT));
                }
            }
        };
        this.guc = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.u.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bGo */
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
        this.gud = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.u.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aIl */
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
    /* renamed from: aN */
    public com.baidu.card.af<bi> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aK(4280);
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
        if (this.gxh == 502) {
            sVar.setNeedFrsTabName(false);
        } else {
            sVar.setNeedFrsTabName(true);
        }
        sVar.setConstrainLayoutPool(this.guc);
        sVar.setConstrainImagePool(this.gud);
        sVar.setFromCDN(this.NK);
        aVar.c(sVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ab(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) kVar);
        kVar.setFromCDN(this.NK);
        kVar.setForm("frs");
        if (!ah(1) || !ah(2)) {
            sVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.u.6
                @Override // com.baidu.adp.widget.a.b
                public void h(int i, int i2, int i3) {
                    u.this.g(i, i2, i3);
                    if (u.this.ah(1) && u.this.ah(2)) {
                        sVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        com.baidu.card.ag agVar = new com.baidu.card.ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = this.gxG ? 10 : 2;
        dVar.cNV = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.aZ(3);
        agVar.aK(16);
        aVar.b(agVar);
        aVar.ni().aR(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ad nj = aVar.nj();
        nj.aQ(3);
        com.baidu.card.af<bi> afVar = new com.baidu.card.af<>(nj);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.u.7
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cRt;
                    bjVar.objType = 1;
                    if (u.this.eNG != null) {
                        u.this.eNG.a(afVar2.getView(), (bi) mVar);
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
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.card.af<bi> afVar) {
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) afVar);
        if (biVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        afVar.nk().setPage(this.LC);
        com.baidu.tieba.frs.g.a(afVar.nk().ne(), this.goJ);
        if (this.goJ != null && this.goJ.getForum() != null && !StringUtils.isNull(this.goJ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.goJ.getForum().getTopic_special_icon_right())) {
            biVar.cRt.co(this.goJ.getForum().getTopic_special_icon(), this.goJ.getForum().getTopic_special_icon_right());
        }
        boolean z = (biVar.cRt.aCr() == null || biVar.cRt.aCr().getUserId() == null || !biVar.cRt.aCr().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (biVar.cRt.aDD() && biVar.cRt.getFeedBackReasonMap() != null && !z) {
            afVar.ag(true).a(this.eOk);
        }
        afVar.nm();
        if (biVar.cRt.aDD() && afVar.nk().ne() != null) {
            afVar.nk().ne().aK(32);
        }
        afVar.b((com.baidu.card.af<bi>) biVar);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.eNG);
        if (this.gxl != null) {
            biVar.cRt.cPT = (biVar.position + 1) - (this.goJ != null ? this.goJ.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bJX().a(this.gxl, biVar.cRt);
        an(biVar.cRt);
        biVar.cRt.aDA();
        com.baidu.tieba.frs.d.a.a(biVar.cRt, this.mPageId, this.gxl, getTbPageTag());
        if (biVar != null) {
            biVar.cRt.aDA();
        }
        return afVar.getView();
    }

    private void an(bj bjVar) {
        if (this.gxj == null) {
            this.gxj = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bJX().a(bjVar, this.gxj);
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.NK = z;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pB(int i) {
        this.gxh = i;
    }

    @Override // com.baidu.tieba.a.f
    public void wQ(String str) {
        this.LC = str;
    }

    @Override // com.baidu.tieba.card.y
    public void kw(boolean z) {
        this.gxG = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bHn() {
        return this.gxl;
    }
}
