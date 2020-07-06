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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class j extends com.baidu.tieba.frs.j<bu, com.baidu.card.ak<bu>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String afG;
    private boolean aik;
    private NEGFeedBackView.a fRV;
    private com.baidu.tieba.card.aa<bu> fRr;
    private int gyV;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> hFi;
    private com.baidu.adp.lib.d.b<TbImageView> hFj;
    private HashSet<String> hIC;
    private com.baidu.tieba.frs.d.b hIE;
    private boolean hIZ;
    private boolean hJa;
    private boolean hJb;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hIZ = false;
        this.aik = true;
        this.hJa = false;
        this.hIE = new com.baidu.tieba.frs.d.b();
        this.fRr = new com.baidu.tieba.card.aa<bu>() { // from class: com.baidu.tieba.frs.entelechy.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bu buVar) {
                if (view != null && buVar != null) {
                    if (j.this.hzo != null) {
                        j.this.hzo.a(view, (View) buVar, (Object) j.this.getType());
                    }
                    if ("c13010".equals(j.this.mFrom)) {
                        TiebaStatic.log(new ao("c13010").ag("obj_type", 1).s("fid", buVar.getFid()).dk("tid", buVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(buVar, 2, j.this.mPageId, j.this.hIE, j.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (j.this.fRr.agT instanceof Boolean) {
                            if (((Boolean) j.this.fRr.agT).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(buVar, 1, j.this.mPageId, j.this.hIE, j.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(buVar, 3, j.this.mPageId, j.this.hIE, j.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(buVar, 15, j.this.mPageId, j.this.hIE, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(buVar, 5, j.this.mPageId, j.this.hIE, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(buVar, 14, j.this.mPageId, j.this.hIE, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(buVar, 12, j.this.mPageId, j.this.hIE, j.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(buVar, 13, j.this.mPageId, j.this.hIE, j.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(buVar, 1, j.this.mPageId, j.this.hIE, j.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cer().a(j.this.hIE, buVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(j.this.hIE, buVar.aPT());
                    } else if (view instanceof TbImageView) {
                        if (j.this.fRr.agT instanceof Boolean) {
                            if (((Boolean) j.this.fRr.agT).booleanValue()) {
                                com.baidu.tieba.frs.d.c.cer().a(j.this.hIE, buVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.cer().a(j.this.hIE, buVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ao(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.cer().a(j.this.hIE, buVar, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.d.c.cer().a(j.this.hIE, buVar, 1);
                    } else {
                        int i = 6;
                        if (buVar.aTS() != null && buVar.aTS().dib() != null && buVar.aTS().dib().bkP() != null && buVar.aTS().dib().bkP().size() > 0) {
                            i = buVar.aTS().lGt ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.cer().a(j.this.hIE, buVar, i);
                    }
                }
            }
        };
        this.fRV = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.j.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ap apVar) {
                TiebaStatic.log(new ao("c11973").dk("fid", apVar.getFid()).dk("tid", apVar.getTid()).dk("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ap apVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ap apVar) {
                if (arrayList != null && apVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ao("c11974").dk("obj_locate", sb.toString()).dk("fid", apVar.getFid()).dk("tid", apVar.getTid()).dk("nid", apVar.getNid()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("source", apVar.source).dk("weight", apVar.weight).dk("ab_tag", apVar.abTag).dk("extra", apVar.extra).ag(IntentConfig.CARD_TYPE, apVar.cardType).ag("obj_floor", apVar.dJw));
                }
            }
        };
        this.hFi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.j.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: caz */
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
        this.hFj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.j.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aYG */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(j.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(an.getColor(R.color.common_color_10043));
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
    /* renamed from: aQ */
    public com.baidu.card.ak<bu> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bd(4280);
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
        final com.baidu.card.u uVar = new com.baidu.card.u(this.mPageContext.getPageActivity());
        uVar.setFrom("frs");
        uVar.setConstrainLayoutPool(this.hFi);
        uVar.setConstrainImagePool(this.hFj);
        uVar.setFromCDN(this.aik);
        if (this.gyV == 502) {
            uVar.setNeedFrsTabName(false);
        } else {
            uVar.setNeedFrsTabName(true);
        }
        aVar.c(uVar);
        if (this.hJb) {
            com.baidu.card.q qVar = new com.baidu.card.q(this.mPageContext.getPageActivity());
            qVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
            aVar.a((com.baidu.card.h) qVar);
        }
        as asVar = new as(this.mPageContext.getPageActivity());
        asVar.setPageContext(this.mPageContext);
        asVar.setFromForPb(3);
        asVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds26));
        aVar.a((com.baidu.card.h) asVar);
        com.baidu.card.ae aeVar = new com.baidu.card.ae(this.mPageContext.getPageActivity());
        aeVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) aeVar);
        com.baidu.card.y yVar = new com.baidu.card.y(this.mPageContext.getPageActivity());
        yVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) yVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ag(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) lVar);
        lVar.setFromCDN(this.aik);
        lVar.setForm("frs");
        if (!aA(1) || !aA(2)) {
            uVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.j.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    j.this.h(i, i2, i3);
                    if (j.this.aA(1) && j.this.aA(2)) {
                        uVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        com.baidu.card.al alVar = new com.baidu.card.al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = this.hIZ ? 10 : 2;
        cVar.dHw = 2;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(2);
        alVar.setShareReportFrom(1);
        alVar.setFromForPb(3);
        alVar.bd(16);
        if (this.hJa) {
            alVar.be(4);
        }
        aVar.b(alVar);
        aVar.sc().bk(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ai sd = aVar.sd();
        sd.setSourceForPb(3);
        com.baidu.card.ak<bu> akVar = new com.baidu.card.ak<>(sd);
        akVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.j.7
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar2 instanceof bu) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar2 = (com.baidu.card.ak) view.getTag();
                    bu buVar = (bu) qVar2;
                    buVar.objType = 1;
                    if (j.this.fRr != null) {
                        j.this.fRr.a(akVar2.getView(), buVar);
                    }
                    aw.a((AbsThreadDataSupport) buVar, view.getContext(), 3, false);
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        akVar.sf();
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
        akVar.se().setPage(this.afG);
        com.baidu.tieba.frs.i.a(akVar.se().rY(), this.hzi);
        if (this.hzi != null && this.hzi.getForum() != null && !StringUtils.isNull(this.hzi.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hzi.getForum().getTopic_special_icon_right())) {
            buVar.db(this.hzi.getForum().getTopic_special_icon(), this.hzi.getForum().getTopic_special_icon_right());
        }
        boolean z = (buVar.aSp() == null || buVar.aSp().getUserId() == null || !buVar.aSp().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (buVar.aTE() && buVar.getFeedBackReasonMap() != null && !z) {
            akVar.aI(true).a(this.fRV);
        }
        akVar.sg();
        akVar.b((com.baidu.card.ak<bu>) buVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.fRr);
        if (this.hIE != null) {
            buVar.dJw = (i + 1) - (this.hzi != null ? this.hzi.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cer().a(this.hIE, buVar);
        aq(buVar);
        buVar.aTB();
        com.baidu.tieba.frs.d.a.a(buVar, this.mPageId, this.hIE, getTbPageTag());
        buVar.aTB();
        return akVar.getView();
    }

    private void aq(bu buVar) {
        if (this.hIC == null) {
            this.hIC = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.cer().a(buVar, this.hIC);
    }

    @Override // com.baidu.tieba.frs.j
    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
        this.gyV = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.card.z
    public void me(boolean z) {
        this.hIZ = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hIE;
    }

    public void nC(boolean z) {
        this.hJa = z;
    }

    public void nD(boolean z) {
        this.hJb = z;
    }
}
