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
public class k extends com.baidu.tieba.frs.k<cb, ThreadCardViewHolder<cb>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String ajx;
    private boolean amh;
    private int hYK;
    private com.baidu.tieba.card.ab<cb> hoN;
    private NEGFeedBackView.a hpr;
    private com.baidu.adp.lib.d.b<ConstrainImageLayout> joC;
    private com.baidu.adp.lib.d.b<TbImageView> joD;
    private boolean jsE;
    private boolean jsF;
    private boolean jsN;
    private HashSet<String> jsl;
    private int jsm;
    private com.baidu.tieba.frs.b.b jsn;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.jsN = false;
        this.amh = true;
        this.jsE = false;
        this.jsn = new com.baidu.tieba.frs.b.b();
        this.hoN = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if (k.this.jhJ != null) {
                        k.this.jhJ.a(view, (View) cbVar, (Object) k.this.getType());
                    }
                    if ("c13010".equals(k.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").aq("obj_type", 1).v("fid", cbVar.getFid()).dR("tid", cbVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 2, k.this.mPageId, k.this.jsn, k.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (k.this.hoN.akF instanceof Boolean) {
                            if (((Boolean) k.this.hoN.akF).booleanValue()) {
                                com.baidu.tieba.frs.b.a.a(cbVar, 1, k.this.mPageId, k.this.jsn, k.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.b.a.a(cbVar, 3, k.this.mPageId, k.this.jsn, k.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 15, k.this.mPageId, k.this.jsn, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 5, k.this.mPageId, k.this.jsn, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 14, k.this.mPageId, k.this.jsn, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 12, k.this.mPageId, k.this.jsn, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 13, k.this.mPageId, k.this.jsn, k.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(cbVar, 1, k.this.mPageId, k.this.jsn, k.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cKr().a(k.this.jsn, cbVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.d.k.a(k.this.jsn, cbVar.blq());
                    } else if (view instanceof TbImageView) {
                        if (k.this.hoN.akF instanceof Boolean) {
                            if (((Boolean) k.this.hoN.akF).booleanValue()) {
                                com.baidu.tieba.frs.b.c.cKr().a(k.this.jsn, cbVar, 1);
                            } else {
                                com.baidu.tieba.frs.b.c.cKr().a(k.this.jsn, cbVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).aq("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.b.c.cKr().a(k.this.jsn, cbVar, 5);
                    } else if (!(view instanceof ThreadGodReplyLayout)) {
                        com.baidu.tieba.frs.b.c.cKr().a(k.this.jsn, cbVar, 1);
                    } else {
                        int i = 6;
                        if (cbVar.bpx() != null && cbVar.bpx().dNQ() != null && cbVar.bpx().dNQ().bHD() != null && cbVar.bpx().dNQ().bHD().size() > 0) {
                            i = cbVar.bpx().nzJ ? 9 : 8;
                        }
                        com.baidu.tieba.frs.b.c.cKr().a(k.this.jsn, cbVar, i);
                    }
                }
            }
        };
        this.hpr = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.k.2
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
                    TiebaStatic.log(new ar("c11974").dR("obj_locate", sb.toString()).dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmq()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", avVar.source).dR("weight", avVar.weight).dR("ab_tag", avVar.abTag).dR("extra", avVar.extra).aq(IntentConfig.CARD_TYPE, avVar.cardType).aq("obj_floor", avVar.ePT));
                }
            }
        };
        this.joC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.adapter.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cFs */
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
        this.joD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: buO */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(k.this.mPageContext.getPageActivity());
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
    public ThreadCardViewHolder<cb> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.br(4280);
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
        wVar.setConstrainLayoutPool(this.joC);
        wVar.setConstrainImagePool(this.joD);
        wVar.setFromCDN(this.amh);
        if (this.hYK == 502) {
            wVar.setNeedFrsTabName(false);
        } else {
            wVar.setNeedFrsTabName(true);
        }
        aVar.c(wVar);
        if (this.jsF) {
            aVar.a((com.baidu.card.h) new com.baidu.card.s(this.mPageContext.getPageActivity()));
        }
        at atVar = new at(this.mPageContext.getPageActivity());
        atVar.setPageContext(this.mPageContext);
        atVar.setFromForPb(3);
        aVar.a((com.baidu.card.h) atVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.bv(cGE());
        aVar.a((com.baidu.card.h) lVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ai(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.h) nVar);
        nVar.setFromCDN(this.amh);
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
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = this.jsN ? 10 : 2;
        eVar.eNH = 2;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(3);
        amVar.br(48);
        if (this.jsE) {
            amVar.bs(4);
        }
        aVar.b(amVar);
        aVar.ti().by(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak th = aVar.th();
        th.setSourceForPb(3);
        ThreadCardViewHolder<cb> threadCardViewHolder = new ThreadCardViewHolder<>(th);
        threadCardViewHolder.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.k.7
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof cb) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = (cb) nVar2;
                    cbVar.objType = 1;
                    if (k.this.hoN != null) {
                        k.this.hoN.a(threadCardViewHolder2.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), 3, false);
                    threadCardViewHolder2.tj().b(new a.C0095a(1));
                }
            }
        });
        threadCardViewHolder.tk();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cb cbVar, ThreadCardViewHolder<cb> threadCardViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) cbVar, (cb) threadCardViewHolder);
        if (cbVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.tj().setPage(this.ajx);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tj().td(), this.jhD);
        if (this.jhD != null && this.jhD.getForum() != null && !StringUtils.isNull(this.jhD.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jhD.getForum().getTopic_special_icon_right())) {
            cbVar.dD(this.jhD.getForum().getTopic_special_icon(), this.jhD.getForum().getTopic_special_icon_right());
        }
        boolean z = (cbVar.bnS() == null || cbVar.bnS().getUserId() == null || !cbVar.bnS().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (cbVar.bpj() && cbVar.getFeedBackReasonMap() != null && !z) {
            threadCardViewHolder.aK(true).a(this.hpr);
        }
        threadCardViewHolder.tl();
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) cbVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.hoN);
        if (this.jsn != null) {
            cbVar.ePT = (i + 1) - (this.jhD != null ? this.jhD.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.b.c.cKr().a(this.jsn, cbVar);
        ar(cbVar);
        cbVar.bpf();
        com.baidu.tieba.frs.b.a.a(cbVar, this.mPageId, this.jsn, getTbPageTag());
        cbVar.bpf();
        return threadCardViewHolder.getView();
    }

    private void ar(cb cbVar) {
        if (this.jsl == null) {
            this.jsl = new HashSet<>();
        }
        com.baidu.tieba.frs.b.c.cKr().a(cbVar, this.jsl);
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uZ(int i) {
        this.hYK = i;
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.card.aa
    public void pD(boolean z) {
        this.jsN = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jsn;
    }

    public void rd(boolean z) {
        this.jsE = z;
    }

    public void re(boolean z) {
        this.jsF = z;
    }

    public void zo(int i) {
        this.jsm = i;
    }

    public int cGE() {
        return this.jsm;
    }
}
