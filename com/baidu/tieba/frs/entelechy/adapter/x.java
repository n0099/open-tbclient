package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.at;
import com.baidu.card.d;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes2.dex */
public class x extends com.baidu.tieba.frs.k<ca, ThreadCardViewHolder<ca>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String aif;
    private boolean akO;
    private NEGFeedBackView.a hnH;
    private com.baidu.tieba.card.ab<ca> hnd;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jmT;
    private com.baidu.adp.lib.d.b<TbImageView> jmU;
    private int jqA;
    private HashSet<String> jqC;
    private com.baidu.tieba.frs.b.b jqE;
    private boolean jre;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jre = false;
        this.akO = true;
        this.jqE = new com.baidu.tieba.frs.b.b();
        this.hnd = new com.baidu.tieba.card.ab<ca>() { // from class: com.baidu.tieba.frs.entelechy.adapter.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, ca caVar) {
                if (view != null && caVar != null) {
                    if (x.this.jga != null) {
                        x.this.jga.a(view, (View) caVar, (Object) x.this.getType());
                    }
                    if ("c13010".equals(x.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ap("obj_type", 1).v("fid", caVar.eJQ.getFid()).dR("tid", caVar.eJQ.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(caVar.eJQ, 2, x.this.mPageId, x.this.jqE, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(caVar.eJQ, 5, x.this.mPageId, x.this.jqE, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(caVar.eJQ, 14, x.this.mPageId, x.this.jqE, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(caVar.eJQ, 12, x.this.mPageId, x.this.jqE, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(caVar.eJQ, 13, x.this.mPageId, x.this.jqE, x.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (x.this.hnd.ajn instanceof Boolean) {
                            if (((Boolean) x.this.hnd.ajn).booleanValue()) {
                                com.baidu.tieba.frs.b.a.a(caVar.eJQ, 1, x.this.mPageId, x.this.jqE, x.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.b.a.a(caVar.eJQ, 3, x.this.mPageId, x.this.jqE, x.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(caVar.eJQ, 15, x.this.mPageId, x.this.jqE, x.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(caVar.eJQ, 1, x.this.mPageId, x.this.jqE, x.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cKl().a(x.this.jqE, caVar.eJQ, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(x.this.jqE, caVar.blo());
                    } else if (view instanceof TbImageView) {
                        if (x.this.hnd.ajn instanceof Boolean) {
                            if (((Boolean) x.this.hnd.ajn).booleanValue()) {
                                com.baidu.tieba.frs.b.c.cKl().a(x.this.jqE, caVar.eJQ, 1);
                            } else {
                                com.baidu.tieba.frs.b.c.cKl().a(x.this.jqE, caVar.eJQ, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.b.c.cKl().a(x.this.jqE, caVar.eJQ, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.b.c.cKl().a(x.this.jqE, caVar.eJQ, 1);
                    } else {
                        int i = 6;
                        if (caVar.eJQ.bpv() != null && caVar.eJQ.bpv().dNH() != null && caVar.eJQ.bpv().dNH().bHz() != null && caVar.eJQ.bpv().dNH().bHz().size() > 0) {
                            i = caVar.eJQ.bpv().nxE ? 9 : 8;
                        }
                        com.baidu.tieba.frs.b.c.cKl().a(x.this.jqE, caVar.eJQ, i);
                    }
                }
            }
        };
        this.hnH = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.x.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(av avVar) {
                TiebaStatic.log(new ar("c11973").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
                if (arrayList != null && avVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + ",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ar("c11974").dR("obj_locate", sb.toString()).dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmo()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", avVar.source).dR("weight", avVar.weight).dR("ab_tag", avVar.abTag).dR("extra", avVar.extra).ap(IntentConfig.CARD_TYPE, avVar.cardType).ap("obj_floor", avVar.eOs));
                }
            }
        };
        this.jmT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.adapter.x.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFm */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(x.this.mPageContext.getPageActivity());
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
        this.jmU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.x.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buL */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(x.this.mPageContext.getPageActivity());
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
    /* renamed from: bd */
    public ThreadCardViewHolder<ca> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bq(4280);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.x.5
            @Override // com.baidu.card.d.a
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
        aVar.a(dVar);
        final com.baidu.card.w wVar = new com.baidu.card.w(this.mPageContext.getPageActivity());
        wVar.setFrom("frs");
        if (this.jqA == 502) {
            wVar.setNeedFrsTabName(false);
        } else {
            wVar.setNeedFrsTabName(true);
        }
        wVar.setConstrainLayoutPool(this.jmT);
        wVar.setConstrainImagePool(this.jmU);
        wVar.setFromCDN(this.akO);
        aVar.c(wVar);
        at atVar = new at(this.mPageContext.getPageActivity());
        atVar.setPageContext(this.mPageContext);
        atVar.setFromForPb(3);
        aVar.a((com.baidu.card.h) atVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ai(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) nVar);
        nVar.setFromCDN(this.akO);
        nVar.setForm("frs");
        if (!aO(1) || !aO(2)) {
            wVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.adapter.x.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    x.this.h(i, i2, i3);
                    if (x.this.aO(1) && x.this.aO(2)) {
                        wVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = this.jre ? 10 : 2;
        eVar.eMg = 2;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(3);
        amVar.bq(16);
        aVar.b(amVar);
        aVar.ti().bx(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak th = aVar.th();
        th.setSourceForPb(3);
        ThreadCardViewHolder<ca> threadCardViewHolder = new ThreadCardViewHolder<>(th);
        threadCardViewHolder.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.x.7
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = ((ca) nVar2).eJQ;
                    cbVar.objType = 1;
                    if (x.this.hnd != null) {
                        x.this.hnd.a(threadCardViewHolder2.getView(), (ca) nVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), 3, false);
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        threadCardViewHolder.tk();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, ThreadCardViewHolder<ca> threadCardViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) caVar, (ca) threadCardViewHolder);
        if (caVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.tj().setPage(this.aif);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tj().td(), this.jfU);
        if (this.jfU != null && this.jfU.getForum() != null && !StringUtils.isNull(this.jfU.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jfU.getForum().getTopic_special_icon_right())) {
            caVar.eJQ.dD(this.jfU.getForum().getTopic_special_icon(), this.jfU.getForum().getTopic_special_icon_right());
        }
        boolean z = (caVar.eJQ.bnQ() == null || caVar.eJQ.bnQ().getUserId() == null || !caVar.eJQ.bnQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (caVar.eJQ.bph() && caVar.eJQ.getFeedBackReasonMap() != null && !z) {
            threadCardViewHolder.aK(true).a(this.hnH);
        }
        threadCardViewHolder.tl();
        if (threadCardViewHolder.tj().td() != null) {
            threadCardViewHolder.tj().td().bq(32);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<ca>) caVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.hnd);
        if (this.jqE != null) {
            caVar.eJQ.eOs = (caVar.position + 1) - (this.jfU != null ? this.jfU.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.b.c.cKl().a(this.jqE, caVar.eJQ);
        ar(caVar.eJQ);
        caVar.eJQ.bpd();
        com.baidu.tieba.frs.b.a.a(caVar.eJQ, this.mPageId, this.jqE, getTbPageTag());
        if (caVar != null) {
            caVar.eJQ.bpd();
        }
        return threadCardViewHolder.getView();
    }

    private void ar(cb cbVar) {
        if (this.jqC == null) {
            this.jqC = new HashSet<>();
        }
        com.baidu.tieba.frs.b.c.cKl().a(cbVar, this.jqC);
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
        this.jqA = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    @Override // com.baidu.tieba.card.aa
    public void pD(boolean z) {
        this.jre = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jqE;
    }
}
