package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.as;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes16.dex */
public class v extends com.baidu.tieba.frs.j<bu, com.baidu.card.ak<bu>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String afx;
    private boolean aib;
    private com.baidu.tieba.card.aa<bu> fWK;
    private NEGFeedBackView.a fXo;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hLg;
    private com.baidu.adp.lib.d.b<TbImageView> hLh;
    private int hOC;
    private HashSet<String> hOE;
    private com.baidu.tieba.frs.d.b hOG;
    private boolean hPb;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hPb = false;
        this.aib = true;
        this.hOG = new com.baidu.tieba.frs.d.b();
        this.fWK = new com.baidu.tieba.card.aa<bu>() { // from class: com.baidu.tieba.frs.entelechy.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bu buVar) {
                if (view != null && buVar != null) {
                    if (v.this.hFd != null) {
                        v.this.hFd.a(view, (View) buVar, (Object) v.this.getType());
                    }
                    if ("c13010".equals(v.this.mFrom)) {
                        TiebaStatic.log(new ap("c13010").ah("obj_type", 1).t("fid", buVar.dLK.getFid()).dn("tid", buVar.dLK.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(buVar.dLK, 2, v.this.mPageId, v.this.hOG, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(buVar.dLK, 5, v.this.mPageId, v.this.hOG, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(buVar.dLK, 14, v.this.mPageId, v.this.hOG, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(buVar.dLK, 12, v.this.mPageId, v.this.hOG, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(buVar.dLK, 13, v.this.mPageId, v.this.hOG, v.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (v.this.fWK.agK instanceof Boolean) {
                            if (((Boolean) v.this.fWK.agK).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(buVar.dLK, 1, v.this.mPageId, v.this.hOG, v.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(buVar.dLK, 3, v.this.mPageId, v.this.hOG, v.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(buVar.dLK, 15, v.this.mPageId, v.this.hOG, v.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(buVar.dLK, 1, v.this.mPageId, v.this.hOG, v.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.chQ().a(v.this.hOG, buVar.dLK, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(v.this.hOG, buVar.aTO());
                    } else if (view instanceof TbImageView) {
                        if (v.this.fWK.agK instanceof Boolean) {
                            if (((Boolean) v.this.fWK.agK).booleanValue()) {
                                com.baidu.tieba.frs.d.c.chQ().a(v.this.hOG, buVar.dLK, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.chQ().a(v.this.hOG, buVar.dLK, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.chQ().a(v.this.hOG, buVar.dLK, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.chQ().a(v.this.hOG, buVar.dLK, 1);
                    } else {
                        int i = 6;
                        if (buVar.dLK.aXO() != null && buVar.dLK.aXO().dlk() != null && buVar.dLK.aXO().dlk().boJ() != null && buVar.dLK.aXO().dlk().boJ().size() > 0) {
                            i = buVar.dLK.aXO().lNJ ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.chQ().a(v.this.hOG, buVar.dLK, i);
                    }
                }
            }
        };
        this.fXo = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.v.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aq aqVar) {
                TiebaStatic.log(new ap("c11973").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
                if (arrayList != null && aqVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ap("c11974").dn("obj_locate", sb.toString()).dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("nid", aqVar.getNid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("source", aqVar.source).dn("weight", aqVar.weight).dn("ab_tag", aqVar.abTag).dn("extra", aqVar.extra).ah(IntentConfig.CARD_TYPE, aqVar.cardType).ah("obj_floor", aqVar.dPI));
                }
            }
        };
        this.hLg = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.v.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cdX */
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
        this.hLh = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.v.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bcD */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(v.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ao.getColor(R.color.common_color_10043));
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
    public com.baidu.card.ak<bu> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bf(4280);
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
        final com.baidu.card.u uVar = new com.baidu.card.u(this.mPageContext.getPageActivity());
        uVar.setFrom("frs");
        if (this.hOC == 502) {
            uVar.setNeedFrsTabName(false);
        } else {
            uVar.setNeedFrsTabName(true);
        }
        uVar.setConstrainLayoutPool(this.hLg);
        uVar.setConstrainImagePool(this.hLh);
        uVar.setFromCDN(this.aib);
        aVar.c(uVar);
        as asVar = new as(this.mPageContext.getPageActivity());
        asVar.setPageContext(this.mPageContext);
        asVar.setFromForPb(3);
        aVar.a((com.baidu.card.h) asVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ag(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) lVar);
        lVar.setFromCDN(this.aib);
        lVar.setForm("frs");
        if (!aC(1) || !aC(2)) {
            uVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.v.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    v.this.h(i, i2, i3);
                    if (v.this.aC(1) && v.this.aC(2)) {
                        uVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        com.baidu.card.al alVar = new com.baidu.card.al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = this.hPb ? 10 : 2;
        cVar.dNH = 2;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(2);
        alVar.setShareReportFrom(1);
        alVar.setFromForPb(3);
        alVar.bf(16);
        aVar.b(alVar);
        aVar.se().bm(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ai sf = aVar.sf();
        sf.setSourceForPb(3);
        com.baidu.card.ak<bu> akVar = new com.baidu.card.ak<>(sf);
        akVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.v.7
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bu) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar2 = (com.baidu.card.ak) view.getTag();
                    bv bvVar = ((bu) qVar).dLK;
                    bvVar.objType = 1;
                    if (v.this.fWK != null) {
                        v.this.fWK.a(akVar2.getView(), (bu) qVar);
                    }
                    ax.a((AbsThreadDataSupport) bvVar, view.getContext(), 3, false);
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        akVar.sh();
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, com.baidu.card.ak<bu> akVar) {
        super.a(i, view, viewGroup, (ViewGroup) buVar, (bu) akVar);
        if (buVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        akVar.sg().setPage(this.afx);
        com.baidu.tieba.frs.i.a(akVar.sg().sa(), this.hEX);
        if (this.hEX != null && this.hEX.getForum() != null && !StringUtils.isNull(this.hEX.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hEX.getForum().getTopic_special_icon_right())) {
            buVar.dLK.de(this.hEX.getForum().getTopic_special_icon(), this.hEX.getForum().getTopic_special_icon_right());
        }
        boolean z = (buVar.dLK.aWl() == null || buVar.dLK.aWl().getUserId() == null || !buVar.dLK.aWl().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (buVar.dLK.aXA() && buVar.dLK.getFeedBackReasonMap() != null && !z) {
            akVar.aK(true).a(this.fXo);
        }
        akVar.si();
        if (buVar.dLK.aXA() && akVar.sg().sa() != null) {
            akVar.sg().sa().bf(32);
        }
        akVar.b((com.baidu.card.ak<bu>) buVar);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.sg().a(this.fWK);
        if (this.hOG != null) {
            buVar.dLK.dPI = (buVar.position + 1) - (this.hEX != null ? this.hEX.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.chQ().a(this.hOG, buVar.dLK);
        an(buVar.dLK);
        buVar.dLK.aXx();
        com.baidu.tieba.frs.d.a.a(buVar.dLK, this.mPageId, this.hOG, getTbPageTag());
        if (buVar != null) {
            buVar.dLK.aXx();
        }
        return akVar.getView();
    }

    private void an(bv bvVar) {
        if (this.hOE == null) {
            this.hOE = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.chQ().a(bvVar, this.hOE);
    }

    @Override // com.baidu.tieba.frs.j
    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
        this.hOC = i;
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mJ(boolean z) {
        this.hPb = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hOG;
    }
}
