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
import com.baidu.tbadk.core.data.by;
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
public class x extends com.baidu.tieba.frs.k<by, ThreadCardViewHolder<by>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String aji;
    private boolean alQ;
    private NEGFeedBackView.a hnM;
    private com.baidu.tieba.card.aa<by> hni;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> jlE;
    private com.baidu.adp.lib.d.b<TbImageView> jlF;
    private boolean jpQ;
    private int jpm;
    private HashSet<String> jpo;
    private com.baidu.tieba.frs.b.b jpq;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jpQ = false;
        this.alQ = true;
        this.jpq = new com.baidu.tieba.frs.b.b();
        this.hni = new com.baidu.tieba.card.aa<by>() { // from class: com.baidu.tieba.frs.entelechy.adapter.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, by byVar) {
                if (view != null && byVar != null) {
                    if (x.this.jeN != null) {
                        x.this.jeN.a(view, (View) byVar, (Object) x.this.getType());
                    }
                    if ("c13010".equals(x.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").an("obj_type", 1).w("fid", byVar.eMv.getFid()).dX("tid", byVar.eMv.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(byVar.eMv, 2, x.this.mPageId, x.this.jpq, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(byVar.eMv, 5, x.this.mPageId, x.this.jpq, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(byVar.eMv, 14, x.this.mPageId, x.this.jpq, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(byVar.eMv, 12, x.this.mPageId, x.this.jpq, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(byVar.eMv, 13, x.this.mPageId, x.this.jpq, x.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (x.this.hni.akp instanceof Boolean) {
                            if (((Boolean) x.this.hni.akp).booleanValue()) {
                                com.baidu.tieba.frs.b.a.a(byVar.eMv, 1, x.this.mPageId, x.this.jpq, x.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.b.a.a(byVar.eMv, 3, x.this.mPageId, x.this.jpq, x.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(byVar.eMv, 15, x.this.mPageId, x.this.jpq, x.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(byVar.eMv, 1, x.this.mPageId, x.this.jpq, x.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cMI().a(x.this.jpq, byVar.eMv, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(x.this.jpq, byVar.boP());
                    } else if (view instanceof TbImageView) {
                        if (x.this.hni.akp instanceof Boolean) {
                            if (((Boolean) x.this.hni.akp).booleanValue()) {
                                com.baidu.tieba.frs.b.c.cMI().a(x.this.jpq, byVar.eMv, 1);
                            } else {
                                com.baidu.tieba.frs.b.c.cMI().a(x.this.jpq, byVar.eMv, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.b.c.cMI().a(x.this.jpq, byVar.eMv, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.b.c.cMI().a(x.this.jpq, byVar.eMv, 1);
                    } else {
                        int i = 6;
                        if (byVar.eMv.bsW() != null && byVar.eMv.bsW().dPf() != null && byVar.eMv.bsW().dPf().bKW() != null && byVar.eMv.bsW().dPf().bKW().size() > 0) {
                            i = byVar.eMv.bsW().nsb ? 9 : 8;
                        }
                        com.baidu.tieba.frs.b.c.cMI().a(x.this.jpq, byVar.eMv, i);
                    }
                }
            }
        };
        this.hnM = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.x.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                TiebaStatic.log(new aq("c11973").dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new aq("c11974").dX("obj_locate", sb.toString()).dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX(IntentConfig.NID, atVar.bpO()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("source", atVar.source).dX("weight", atVar.weight).dX("ab_tag", atVar.abTag).dX("extra", atVar.extra).an(IntentConfig.CARD_TYPE, atVar.cardType).an("obj_floor", atVar.eQR));
                }
            }
        };
        this.jlE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.adapter.x.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cHK */
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
        this.jlF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.x.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: byk */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(x.this.mPageContext.getPageActivity());
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
    public ThreadCardViewHolder<by> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bs(4280);
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
        if (this.jpm == 502) {
            wVar.setNeedFrsTabName(false);
        } else {
            wVar.setNeedFrsTabName(true);
        }
        wVar.setConstrainLayoutPool(this.jlE);
        wVar.setConstrainImagePool(this.jlF);
        wVar.setFromCDN(this.alQ);
        aVar.c(wVar);
        com.baidu.card.at atVar = new com.baidu.card.at(this.mPageContext.getPageActivity());
        atVar.setPageContext(this.mPageContext);
        atVar.setFromForPb(3);
        aVar.a((com.baidu.card.h) atVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ai(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) nVar);
        nVar.setFromCDN(this.alQ);
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
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.eOz = this.jpQ ? 10 : 2;
        dVar2.eOF = 2;
        amVar.setAgreeStatisticData(dVar2);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(3);
        amVar.bs(16);
        aVar.b(amVar);
        aVar.tx().bz(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak tw = aVar.tw();
        tw.setSourceForPb(3);
        ThreadCardViewHolder<by> threadCardViewHolder = new ThreadCardViewHolder<>(tw);
        threadCardViewHolder.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.x.7
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar2).eMv;
                    bzVar.objType = 1;
                    if (x.this.hni != null) {
                        x.this.hni.a(threadCardViewHolder2.getView(), (by) nVar2);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), 3, false);
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        threadCardViewHolder.tz();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, ThreadCardViewHolder<by> threadCardViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) threadCardViewHolder);
        if (byVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.ty().setPage(this.aji);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.ty().ts(), this.jeH);
        if (this.jeH != null && this.jeH.getForum() != null && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon_right())) {
            byVar.eMv.dK(this.jeH.getForum().getTopic_special_icon(), this.jeH.getForum().getTopic_special_icon_right());
        }
        boolean z = (byVar.eMv.brq() == null || byVar.eMv.brq().getUserId() == null || !byVar.eMv.brq().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (byVar.eMv.bsI() && byVar.eMv.getFeedBackReasonMap() != null && !z) {
            threadCardViewHolder.aK(true).a(this.hnM);
        }
        threadCardViewHolder.tA();
        if (threadCardViewHolder.ty().ts() != null) {
            threadCardViewHolder.ty().ts().bs(32);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<by>) byVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.hni);
        if (this.jpq != null) {
            byVar.eMv.eQR = (byVar.position + 1) - (this.jeH != null ? this.jeH.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.b.c.cMI().a(this.jpq, byVar.eMv);
        aq(byVar.eMv);
        byVar.eMv.bsE();
        com.baidu.tieba.frs.b.a.a(byVar.eMv, this.mPageId, this.jpq, getTbPageTag());
        if (byVar != null) {
            byVar.eMv.bsE();
        }
        return threadCardViewHolder.getView();
    }

    private void aq(bz bzVar) {
        if (this.jpo == null) {
            this.jpo = new HashSet<>();
        }
        com.baidu.tieba.frs.b.c.cMI().a(bzVar, this.jpo);
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
        this.jpm = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Fm(String str) {
        this.aji = str;
    }

    @Override // com.baidu.tieba.card.z
    public void px(boolean z) {
        this.jpQ = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jpq;
    }
}
