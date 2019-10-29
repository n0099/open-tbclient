package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
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
public class n extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bg>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String GC;
    private boolean HY;
    private boolean cqZ;
    private NEGFeedBackView.a dTF;
    private ab<bg> dTc;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fAu;
    private com.baidu.adp.lib.e.b<TbImageView> fAv;
    private HashSet<String> fDV;
    private boolean fDW;
    private int fDY;
    private com.baidu.tieba.frs.d.b fDZ;
    private VoiceManager fvn;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.cqZ = false;
        this.fDW = false;
        this.HY = true;
        this.fDY = 3;
        this.fDZ = new com.baidu.tieba.frs.d.b();
        this.dTc = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (n.this.fuX != null) {
                        n.this.fuX.a(view, (View) bgVar, (Object) n.this.getType());
                    }
                    if ("c13010".equals(n.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").O("obj_type", 1).p("fid", bgVar.cbq.getFid()).bS("tid", bgVar.cbq.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpJ().a(n.this.fDZ, bgVar.cbq, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar.cbq, 2, n.this.mPageId, n.this.fDZ);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(n.this.fDZ, bgVar.agJ());
                    } else if (view instanceof TbImageView) {
                        if (n.this.dTc.HC instanceof Boolean) {
                            if (((Boolean) n.this.dTc.HC).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bpJ().a(n.this.fDZ, bgVar.cbq, 1);
                                com.baidu.tieba.frs.d.a.a(bgVar.cbq, 1, n.this.mPageId, n.this.fDZ);
                                return;
                            }
                            com.baidu.tieba.frs.d.c.bpJ().a(n.this.fDZ, bgVar.cbq, 3);
                            com.baidu.tieba.frs.d.a.a(bgVar.cbq, 3, n.this.mPageId, n.this.fDZ);
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bpJ().a(n.this.fDZ, bgVar.cbq, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bgVar.cbq.akd() != null && bgVar.cbq.akd().cor() != null && bgVar.cbq.akd().cor().azh() != null && bgVar.cbq.akd().cor().azh().size() > 0) {
                            i = bgVar.cbq.akd().jiV ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bpJ().a(n.this.fDZ, bgVar.cbq, i);
                        com.baidu.tieba.frs.d.a.a(bgVar.cbq, 5, n.this.mPageId, n.this.fDZ);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar.cbq, 5, n.this.mPageId, n.this.fDZ);
                    } else {
                        com.baidu.tieba.frs.d.c.bpJ().a(n.this.fDZ, bgVar.cbq, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar.cbq, 1, n.this.mPageId, n.this.fDZ);
                    }
                }
            }
        };
        this.dTF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.n.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new an("c11973").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11974").bS("obj_locate", sb.toString()).bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.fAu = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.n.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bmb */
            public ConstrainImageLayout makeObject() {
                return new ConstrainImageLayout(n.this.mPageContext.getPageActivity());
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
        this.fAv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.n.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aoe */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(n.this.mPageContext.getPageActivity());
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
    /* renamed from: aN */
    public com.baidu.card.z<bg> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.aB(4280);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.a.n.5
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
        oVar.setConstrainLayoutPool(this.fAu);
        oVar.setConstrainImagePool(this.fAv);
        oVar.setFromCDN(this.HY);
        aVar.b(oVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.v(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.f) hVar);
        hVar.setFromCDN(this.HY);
        hVar.setForm("frs");
        if (!ab(1) || !ab(2)) {
            oVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.n.6
                @Override // com.baidu.adp.widget.a.b
                public void h(int i, int i2, int i3) {
                    n.this.g(i, i2, i3);
                    if (n.this.ab(1) && n.this.ab(2)) {
                        oVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bXQ = this.fDW ? 10 : 2;
        dVar2.bXV = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.aL(3);
        aaVar.aB(16);
        aVar.a(aaVar);
        com.baidu.card.x lU = aVar.lU();
        lU.aF(3);
        com.baidu.card.z<bg> zVar = new com.baidu.card.z<>(lU);
        zVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.n.7
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).cbq;
                    bhVar.objType = 1;
                    if (n.this.dTc != null) {
                        n.this.dTc.a(zVar2.getView(), (bg) mVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), 3, false);
                    zVar2.lV().b(new a.C0044a(1));
                }
            }
        });
        zVar.lX();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.z<bg> zVar) {
        super.a(i, view, viewGroup, (ViewGroup) bgVar, (bg) zVar);
        if (bgVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        zVar.lV().setPage(this.GC);
        com.baidu.tieba.frs.g.a(zVar.lV().lP(), this.fuR);
        if (this.fuR != null && this.fuR.getForum() != null && !StringUtils.isNull(this.fuR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fuR.getForum().getTopic_special_icon_right())) {
            bgVar.cbq.bI(this.fuR.getForum().getTopic_special_icon(), this.fuR.getForum().getTopic_special_icon_right());
        }
        boolean z = (bgVar.cbq.aiG() == null || bgVar.cbq.aiG().getUserId() == null || !bgVar.cbq.aiG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.cbq.ajO() && bgVar.cbq.getFeedBackReasonMap() != null && !z) {
            zVar.lW().a(this.dTF);
        }
        zVar.lY();
        zVar.a(bgVar);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.dTc);
        if (this.fDZ != null) {
            bgVar.cbq.cez = (bgVar.position + 1) - (this.fuR != null ? this.fuR.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bpJ().a(this.fDZ, bgVar.cbq);
        ad(bgVar.cbq);
        bgVar.cbq.ajK();
        com.baidu.tieba.frs.d.a.a(bgVar.cbq, this.mPageId, this.fDZ);
        if (bgVar != null) {
            bgVar.cbq.ajK();
        }
        return zVar.getView();
    }

    private void ad(bh bhVar) {
        if (this.fDV == null) {
            this.fDV = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bpJ().a(bhVar, this.fDV);
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.HY = z;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mX(int i) {
        this.fDY = i;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.fvn = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.cqZ = z;
    }

    @Override // com.baidu.tieba.card.aa
    public void iM(boolean z) {
        this.fDW = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmX() {
        return this.fDZ;
    }
}
