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
import com.baidu.card.d;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class k extends com.baidu.tieba.frs.k<bz, ThreadCardViewHolder<bz>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String air;
    private boolean akY;
    private int hSs;
    private com.baidu.tieba.card.aa<bz> hiC;
    private NEGFeedBackView.a hjg;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jgX;
    private com.baidu.adp.lib.d.b<TbImageView> jgY;
    private HashSet<String> jkH;
    private int jkI;
    private com.baidu.tieba.frs.b.b jkJ;
    private boolean jla;
    private boolean jlb;
    private boolean jlj;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jlj = false;
        this.akY = true;
        this.jla = false;
        this.jkJ = new com.baidu.tieba.frs.b.b();
        this.hiC = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if (k.this.jag != null) {
                        k.this.jag.a(view, (View) bzVar, (Object) k.this.getType());
                    }
                    if ("c13010".equals(k.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").an("obj_type", 1).w("fid", bzVar.getFid()).dW("tid", bzVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 2, k.this.mPageId, k.this.jkJ, k.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (k.this.hiC.ajy instanceof Boolean) {
                            if (((Boolean) k.this.hiC.ajy).booleanValue()) {
                                com.baidu.tieba.frs.b.a.a(bzVar, 1, k.this.mPageId, k.this.jkJ, k.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.b.a.a(bzVar, 3, k.this.mPageId, k.this.jkJ, k.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 15, k.this.mPageId, k.this.jkJ, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 5, k.this.mPageId, k.this.jkJ, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 14, k.this.mPageId, k.this.jkJ, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 12, k.this.mPageId, k.this.jkJ, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 13, k.this.mPageId, k.this.jkJ, k.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(bzVar, 1, k.this.mPageId, k.this.jkJ, k.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cIR().a(k.this.jkJ, bzVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(k.this.jkJ, bzVar.bkW());
                    } else if (view instanceof TbImageView) {
                        if (k.this.hiC.ajy instanceof Boolean) {
                            if (((Boolean) k.this.hiC.ajy).booleanValue()) {
                                com.baidu.tieba.frs.b.c.cIR().a(k.this.jkJ, bzVar, 1);
                            } else {
                                com.baidu.tieba.frs.b.c.cIR().a(k.this.jkJ, bzVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.b.c.cIR().a(k.this.jkJ, bzVar, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.b.c.cIR().a(k.this.jkJ, bzVar, 1);
                    } else {
                        int i = 6;
                        if (bzVar.bpd() != null && bzVar.bpd().dLo() != null && bzVar.bpd().dLo().bHf() != null && bzVar.bpd().dLo().bHf().size() > 0) {
                            i = bzVar.bpd().nnu ? 9 : 8;
                        }
                        com.baidu.tieba.frs.b.c.cIR().a(k.this.jkJ, bzVar, i);
                    }
                }
            }
        };
        this.hjg = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.k.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                TiebaStatic.log(new aq("c11973").dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new aq("c11974").dW("obj_locate", sb.toString()).dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW(IntentConfig.NID, atVar.blV()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("source", atVar.source).dW("weight", atVar.weight).dW("ab_tag", atVar.abTag).dW("extra", atVar.extra).an(IntentConfig.CARD_TYPE, atVar.cardType).an("obj_floor", atVar.eMg));
                }
            }
        };
        this.jgX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.adapter.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cDT */
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
        this.jgY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bur */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(k.this.mPageContext.getPageActivity());
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
    /* renamed from: bd */
    public ThreadCardViewHolder<bz> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bq(4280);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.k.5
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
        wVar.setConstrainLayoutPool(this.jgX);
        wVar.setConstrainImagePool(this.jgY);
        wVar.setFromCDN(this.akY);
        if (this.hSs == 502) {
            wVar.setNeedFrsTabName(false);
        } else {
            wVar.setNeedFrsTabName(true);
        }
        aVar.c(wVar);
        if (this.jlb) {
            aVar.a((com.baidu.card.h) new com.baidu.card.s(this.mPageContext.getPageActivity()));
        }
        com.baidu.card.at atVar = new com.baidu.card.at(this.mPageContext.getPageActivity());
        atVar.setPageContext(this.mPageContext);
        atVar.setFromForPb(3);
        aVar.a((com.baidu.card.h) atVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.bu(cFe());
        aVar.a((com.baidu.card.h) lVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ai(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) nVar);
        nVar.setFromCDN(this.akY);
        nVar.setForm("frs");
        if (!aO(1) || !aO(2)) {
            wVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.adapter.k.6
                @Override // com.baidu.adp.widget.a.b
                public void i(int i, int i2, int i3) {
                    k.this.h(i, i2, i3);
                    if (k.this.aO(1) && k.this.aO(2)) {
                        wVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.eJO = this.jlj ? 10 : 2;
        dVar2.eJU = 2;
        amVar.setAgreeStatisticData(dVar2);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(3);
        amVar.bq(48);
        if (this.jla) {
            amVar.br(4);
        }
        aVar.b(amVar);
        aVar.tl().bx(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak tk = aVar.tk();
        tk.setSourceForPb(3);
        ThreadCardViewHolder<bz> threadCardViewHolder = new ThreadCardViewHolder<>(tk);
        threadCardViewHolder.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.k.7
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof bz) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = (bz) nVar2;
                    bzVar.objType = 1;
                    if (k.this.hiC != null) {
                        k.this.hiC.a(threadCardViewHolder2.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), 3, false);
                    threadCardViewHolder2.tm().b(new a.C0089a(1));
                }
            }
        });
        threadCardViewHolder.tn();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bz bzVar, ThreadCardViewHolder<bz> threadCardViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) bzVar, (bz) threadCardViewHolder);
        if (bzVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.tm().setPage(this.air);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tm().tg(), this.jaa);
        if (this.jaa != null && this.jaa.getForum() != null && !StringUtils.isNull(this.jaa.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jaa.getForum().getTopic_special_icon_right())) {
            bzVar.dJ(this.jaa.getForum().getTopic_special_icon(), this.jaa.getForum().getTopic_special_icon_right());
        }
        boolean z = (bzVar.bnx() == null || bzVar.bnx().getUserId() == null || !bzVar.bnx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bzVar.boP() && bzVar.getFeedBackReasonMap() != null && !z) {
            threadCardViewHolder.aK(true).a(this.hjg);
        }
        threadCardViewHolder.tp();
        threadCardViewHolder.b((ThreadCardViewHolder<bz>) bzVar);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tm().a(this.hiC);
        if (this.jkJ != null) {
            bzVar.eMg = (i + 1) - (this.jaa != null ? this.jaa.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.b.c.cIR().a(this.jkJ, bzVar);
        aq(bzVar);
        bzVar.boL();
        com.baidu.tieba.frs.b.a.a(bzVar, this.mPageId, this.jkJ, getTbPageTag());
        bzVar.boL();
        return threadCardViewHolder.getView();
    }

    private void aq(bz bzVar) {
        if (this.jkH == null) {
            this.jkH = new HashSet<>();
        }
        com.baidu.tieba.frs.b.c.cIR().a(bzVar, this.jkH);
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
        this.hSs = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.card.z
    public void pt(boolean z) {
        this.jlj = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jkJ;
    }

    public void qT(boolean z) {
        this.jla = z;
    }

    public void qU(boolean z) {
        this.jlb = z;
    }

    public void zd(int i) {
        this.jkI = i;
    }

    public int cFe() {
        return this.jkI;
    }
}
