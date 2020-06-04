package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
public class j extends com.baidu.tieba.frs.h<bk, com.baidu.card.ag<bk>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aeX;
    private boolean aha;
    private NEGFeedBackView.a fGM;
    private com.baidu.tieba.card.aa<bk> fGi;
    private int gmh;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hss;
    private com.baidu.adp.lib.d.b<TbImageView> hst;
    private HashSet<String> hvJ;
    private com.baidu.tieba.frs.d.b hvL;
    private boolean hwg;
    private boolean hwh;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hwg = false;
        this.aha = true;
        this.hwh = false;
        this.hvL = new com.baidu.tieba.frs.d.b();
        this.fGi = new com.baidu.tieba.card.aa<bk>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                if (view != null && bkVar != null) {
                    if (j.this.hmX != null) {
                        j.this.hmX.a(view, (View) bkVar, (Object) j.this.getType());
                    }
                    if ("c13010".equals(j.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").ag("obj_type", 1).s("fid", bkVar.getFid()).dh("tid", bkVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 2, j.this.mPageId, j.this.hvL, j.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (j.this.fGi.agg instanceof Boolean) {
                            if (((Boolean) j.this.fGi.agg).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bkVar, 1, j.this.mPageId, j.this.hvL, j.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bkVar, 3, j.this.mPageId, j.this.hvL, j.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 15, j.this.mPageId, j.this.hvL, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 5, j.this.mPageId, j.this.hvL, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 14, j.this.mPageId, j.this.hvL, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 12, j.this.mPageId, j.this.hvL, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 13, j.this.mPageId, j.this.hvL, j.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bkVar, 1, j.this.mPageId, j.this.hvL, j.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.caY().a(j.this.hvL, bkVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(j.this.hvL, bkVar.aOj());
                    } else if (view instanceof TbImageView) {
                        if (j.this.fGi.agg instanceof Boolean) {
                            if (((Boolean) j.this.fGi.agg).booleanValue()) {
                                com.baidu.tieba.frs.d.c.caY().a(j.this.hvL, bkVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.caY().a(j.this.hvL, bkVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.caY().a(j.this.hvL, bkVar, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.caY().a(j.this.hvL, bkVar, 1);
                    } else {
                        int i = 6;
                        if (bkVar.aSb() != null && bkVar.aSb().ddL() != null && bkVar.aSb().ddL().bis() != null && bkVar.aSb().ddL().bis().size() > 0) {
                            i = bkVar.aSb().lmA ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.caY().a(j.this.hvL, bkVar, i);
                    }
                }
            }
        };
        this.fGM = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.j.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ak akVar) {
                TiebaStatic.log(new an("c11973").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ak akVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
                if (arrayList != null && akVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11974").dh("obj_locate", sb.toString()).dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("nid", akVar.getNid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("source", akVar.source).dh("weight", akVar.weight).dh("ab_tag", akVar.abTag).dh("extra", akVar.extra).ag(IntentConfig.CARD_TYPE, akVar.cardType).ag("obj_floor", akVar.dDb));
                }
            }
        };
        this.hss = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bXn */
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
        this.hst = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aWN */
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
    /* renamed from: aM */
    public com.baidu.card.ag<bk> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aX(4280);
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
        final com.baidu.card.t tVar = new com.baidu.card.t(this.mPageContext.getPageActivity());
        tVar.setFrom("frs");
        tVar.setConstrainLayoutPool(this.hss);
        tVar.setConstrainImagePool(this.hst);
        tVar.setFromCDN(this.aha);
        if (this.gmh == 502) {
            tVar.setNeedFrsTabName(false);
        } else {
            tVar.setNeedFrsTabName(true);
        }
        aVar.c(tVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ac(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) lVar);
        lVar.setFromCDN(this.aha);
        lVar.setForm("frs");
        if (!au(1) || !au(2)) {
            tVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.j.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    j.this.h(i, i2, i3);
                    if (j.this.au(1) && j.this.au(2)) {
                        tVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        com.baidu.card.ah ahVar = new com.baidu.card.ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = this.hwg ? 10 : 2;
        cVar.dBf = 2;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(2);
        ahVar.setShareReportFrom(1);
        ahVar.bm(3);
        ahVar.aX(16);
        if (this.hwh) {
            ahVar.aY(4);
        }
        aVar.b(ahVar);
        aVar.rK().be(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ae rL = aVar.rL();
        rL.setSourceForPb(3);
        com.baidu.card.ag<bk> agVar = new com.baidu.card.ag<>(rL);
        agVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.frs.entelechy.a.j.7
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof bk) && (view.getTag() instanceof com.baidu.card.ag)) {
                    com.baidu.card.ag agVar2 = (com.baidu.card.ag) view.getTag();
                    bk bkVar = (bk) oVar;
                    bkVar.objType = 1;
                    if (j.this.fGi != null) {
                        j.this.fGi.a(agVar2.getView(), bkVar);
                    }
                    au.a((AbsThreadDataSupport) bkVar, view.getContext(), 3, false);
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        agVar.rN();
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, com.baidu.card.ag<bk> agVar) {
        super.a(i, view, viewGroup, (ViewGroup) bkVar, (bk) agVar);
        if (bkVar == null || agVar == null || agVar.getView() == null) {
            return null;
        }
        agVar.rM().setPage(this.aeX);
        com.baidu.tieba.frs.g.a(agVar.rM().rG(), this.hmR);
        if (this.hmR != null && this.hmR.getForum() != null && !StringUtils.isNull(this.hmR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hmR.getForum().getTopic_special_icon_right())) {
            bkVar.cY(this.hmR.getForum().getTopic_special_icon(), this.hmR.getForum().getTopic_special_icon_right());
        }
        boolean z = (bkVar.aQx() == null || bkVar.aQx().getUserId() == null || !bkVar.aQx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bkVar.aRN() && bkVar.getFeedBackReasonMap() != null && !z) {
            agVar.aH(true).a(this.fGM);
        }
        agVar.rO();
        agVar.b((com.baidu.card.ag<bk>) bkVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.fGi);
        if (this.hvL != null) {
            bkVar.dDb = (i + 1) - (this.hmR != null ? this.hmR.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.caY().a(this.hvL, bkVar);
        aq(bkVar);
        bkVar.aRK();
        com.baidu.tieba.frs.d.a.a(bkVar, this.mPageId, this.hvL, getTbPageTag());
        bkVar.aRK();
        return agVar.getView();
    }

    private void aq(bk bkVar) {
        if (this.hvJ == null) {
            this.hvJ = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.caY().a(bkVar, this.hvJ);
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qy(int i) {
        this.gmh = i;
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.card.z
    public void lV(boolean z) {
        this.hwg = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hvL;
    }

    public void nr(boolean z) {
        this.hwh = z;
    }
}
