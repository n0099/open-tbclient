package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.frs.h<bh, com.baidu.card.z<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WM;
    private boolean Yd;
    private boolean ccM;
    private NEGFeedBackView.a dGG;
    private ab<bh> dGe;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fBg;
    private com.baidu.adp.lib.e.b<TbImageView> fBh;
    private HashSet<String> fEE;
    private boolean fEF;
    private boolean fEG;
    private int fEH;
    private com.baidu.tieba.frs.d.b fEI;
    private VoiceManager fwa;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ccM = false;
        this.fEF = false;
        this.Yd = true;
        this.fEG = false;
        this.fEH = 3;
        this.fEI = new com.baidu.tieba.frs.d.b();
        this.dGe = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (d.this.fvK != null) {
                        d.this.fvK.a(view, (View) bhVar, (Object) d.this.getType());
                    }
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 1).n("fid", bhVar.getFid()).bT("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bsF().a(d.this.fEI, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, d.this.mPageId, d.this.fEI);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(d.this.fEI, bhVar.acD());
                    } else if (view instanceof TbImageView) {
                        if (d.this.dGe.XI instanceof Boolean) {
                            if (((Boolean) d.this.dGe.XI).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bsF().a(d.this.fEI, bhVar, 1);
                                com.baidu.tieba.frs.d.a.a(bhVar, 1, d.this.mPageId, d.this.fEI);
                                return;
                            }
                            com.baidu.tieba.frs.d.c.bsF().a(d.this.fEI, bhVar, 3);
                            com.baidu.tieba.frs.d.a.a(bhVar, 3, d.this.mPageId, d.this.fEI);
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bsF().a(d.this.fEI, bhVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bhVar.aga() != null && bhVar.aga().cqB() != null && bhVar.aga().cqB().ayZ() != null && bhVar.aga().cqB().ayZ().size() > 0) {
                            i = bhVar.aga().jjh ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bsF().a(d.this.fEI, bhVar, i);
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, d.this.mPageId, d.this.fEI);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, d.this.mPageId, d.this.fEI);
                    } else {
                        com.baidu.tieba.frs.d.c.bsF().a(d.this.fEI, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, d.this.mPageId, d.this.fEI);
                    }
                }
            }
        };
        this.dGG = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.d.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new an("c11973").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
                if (arrayList != null && ajVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11974").bT("obj_locate", sb.toString()).bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.fBg = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: boX */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(d.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void destroyObject(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout activateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout passivateObject(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.fBh = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alq */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(d.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView activateObject(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
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
    /* renamed from: aL */
    public com.baidu.card.z<bh> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bm(4280);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.a.d.5
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
        aVar.c(dVar);
        final com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFrom("frs");
        oVar.setConstrainLayoutPool(this.fBg);
        oVar.setConstrainImagePool(this.fBh);
        oVar.setFromCDN(this.Yd);
        aVar.b(oVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.v(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.f) hVar);
        hVar.setFromCDN(this.Yd);
        hVar.setForm("frs");
        if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
            oVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.d.6
                @Override // com.baidu.adp.widget.a.b
                public void j(int i, int i2, int i3) {
                    d.this.setPreloadSize(i, i2, i3);
                    if (d.this.isPreloadSizeReady(1) && d.this.isPreloadSizeReady(2)) {
                        oVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bFY = this.fEF ? 10 : 2;
        dVar2.bGd = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bw(3);
        aaVar.bm(16);
        if (this.fEG) {
            aaVar.bn(4);
        }
        aVar.a(aaVar);
        com.baidu.card.x qP = aVar.qP();
        qP.bq(3);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(qP);
        zVar.setPageId(this.mPageId);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.d.7
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bh) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bh bhVar = (bh) mVar;
                    bhVar.objType = 1;
                    if (d.this.dGe != null) {
                        d.this.dGe.a(zVar2.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), 3, false);
                    zVar2.qQ().b(new a.C0038a(1));
                }
            }
        });
        zVar.qS();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.card.z<bh> zVar) {
        super.onFillViewHolder(i, view, viewGroup, bhVar, zVar);
        if (bhVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        zVar.qQ().setPage(this.WM);
        com.baidu.tieba.frs.g.a(zVar.qQ().qK(), this.fvE);
        if (this.fvE != null && this.fvE.getForum() != null && !StringUtils.isNull(this.fvE.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fvE.getForum().getTopic_special_icon_right())) {
            bhVar.bC(this.fvE.getForum().getTopic_special_icon(), this.fvE.getForum().getTopic_special_icon_right());
        }
        boolean z = (bhVar.aeC() == null || bhVar.aeC().getUserId() == null || !bhVar.aeC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bhVar.afL() && bhVar.adl() != null && !z) {
            zVar.qR().a(this.dGG);
        }
        zVar.qT();
        zVar.a(bhVar);
        zVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qQ().a(this.dGe);
        if (this.fEI != null) {
            bhVar.bMQ = (i + 1) - (this.fvE != null ? this.fvE.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bsF().a(this.fEI, bhVar);
        af(bhVar);
        bhVar.afG();
        com.baidu.tieba.frs.d.a.a(bhVar, this.mPageId, this.fEI);
        if (bhVar != null) {
            bhVar.afG();
        }
        return zVar.getView();
    }

    private void af(bh bhVar) {
        if (this.fEE == null) {
            this.fEE = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bsF().a(bhVar, this.fEE);
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nH(int i) {
        this.fEH = i;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.fwa = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
        this.WM = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.card.aa
    public void iJ(boolean z) {
        this.fEF = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bpS() {
        return this.fEI;
    }

    public void kA(boolean z) {
        this.fEG = z;
    }
}
