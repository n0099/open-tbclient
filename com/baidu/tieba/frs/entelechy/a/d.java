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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bg>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String YA;
    private boolean ZQ;
    private boolean bSP;
    private NEGFeedBackView.a dqL;
    private ab<bg> dqj;
    private VoiceManager eYD;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> fdJ;
    private com.baidu.adp.lib.e.b<TbImageView> fdK;
    private HashSet<String> fgN;
    private boolean fgO;
    private int fgP;
    private com.baidu.tieba.frs.d.b fgQ;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.bSP = false;
        this.fgO = false;
        this.ZQ = true;
        this.fgP = 3;
        this.fgQ = new com.baidu.tieba.frs.d.b();
        this.dqj = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (d.this.eYn != null) {
                        d.this.eYn.a(view, (View) bgVar, (Object) d.this.getType());
                    }
                    if ("c13010".equals(d.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").T("obj_type", 1).k(ImageViewerConfig.FORUM_ID, bgVar.getFid()).bJ("tid", bgVar.getTid()));
                    }
                    if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        com.baidu.tieba.frs.d.c.bij().a(d.this.fgQ, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, d.this.mPageId, d.this.fgQ);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(d.this.fgQ, bgVar.WP());
                    } else if (view instanceof TbImageView) {
                        if (d.this.dqj.Zw instanceof Boolean) {
                            if (((Boolean) d.this.dqj.Zw).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bij().a(d.this.fgQ, bgVar, 1);
                                com.baidu.tieba.frs.d.a.a(bgVar, 1, d.this.mPageId, d.this.fgQ);
                                return;
                            }
                            com.baidu.tieba.frs.d.c.bij().a(d.this.fgQ, bgVar, 3);
                            com.baidu.tieba.frs.d.a.a(bgVar, 3, d.this.mPageId, d.this.fgQ);
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    } else if (view.getId() == d.g.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bij().a(d.this.fgQ, bgVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bgVar.aam() != null && bgVar.aam().cer() != null && bgVar.aam().cer().ast() != null && bgVar.aam().cer().ast().size() > 0) {
                            i = bgVar.aam().iGr ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bij().a(d.this.fgQ, bgVar, i);
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, d.this.mPageId, d.this.fgQ);
                    } else if (view.getId() == d.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, d.this.mPageId, d.this.fgQ);
                    } else {
                        com.baidu.tieba.frs.d.c.bij().a(d.this.fgQ, bgVar, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, d.this.mPageId, d.this.fgQ);
                    }
                }
            }
        };
        this.dqL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.d.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new am("c11973").bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11974").bJ("obj_locate", sb.toString()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.fdJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beG */
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
        this.fdK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aeY */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(d.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0277d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
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
    /* renamed from: aH */
    public com.baidu.card.z<bg> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bt(184);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.a.d.5
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == d.g.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == d.g.user_avatar) {
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
        oVar.setConstrainLayoutPool(this.fdJ);
        oVar.setConstrainImagePool(this.fdK);
        oVar.setFromCDN(this.ZQ);
        aVar.b(oVar);
        com.baidu.card.u uVar = new com.baidu.card.u(this.mPageContext.getPageActivity());
        uVar.setFromCDN(this.ZQ);
        aVar.a((com.baidu.card.f) uVar);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.f) hVar);
        hVar.setFromCDN(this.ZQ);
        hVar.setForm("frs");
        if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
            oVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.d.6
                @Override // com.baidu.adp.widget.a.b
                public void k(int i, int i2, int i3) {
                    d.this.setPreloadSize(i, i2, i3);
                    if (d.this.isPreloadSizeReady(1) && d.this.isPreloadSizeReady(2)) {
                        oVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bxm = this.fgO ? 10 : 2;
        dVar2.bxr = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bz(3);
        aaVar.bt(16);
        aVar.a(aaVar);
        aVar.rv().setBackgroundResource(d.f.addresslist_item_bg);
        com.baidu.card.x rw = aVar.rw();
        rw.bx(3);
        com.baidu.card.z<bg> zVar = new com.baidu.card.z<>(rw);
        zVar.setPageId(this.mPageId);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.d.7
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bg bgVar = (bg) mVar;
                    bgVar.objType = 1;
                    if (d.this.dqj != null) {
                        d.this.dqj.a(zVar2.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), 3, false);
                    zVar2.rx().b(new a.C0039a(1));
                }
            }
        });
        zVar.rz();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.z<bg> zVar) {
        super.onFillViewHolder(i, view, viewGroup, bgVar, zVar);
        if (bgVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        zVar.rx().setPage(this.YA);
        com.baidu.tieba.frs.g.a(zVar.rx().rr(), this.eYh);
        if (this.eYh != null && this.eYh.getForum() != null && !StringUtils.isNull(this.eYh.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.eYh.getForum().getTopic_special_icon_right())) {
            bgVar.bt(this.eYh.getForum().getTopic_special_icon(), this.eYh.getForum().getTopic_special_icon_right());
        }
        boolean z = (bgVar.YO() == null || bgVar.YO().getUserId() == null || !bgVar.YO().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.ZX() && bgVar.Xx() != null && !z) {
            zVar.ry().a(this.dqL);
        }
        zVar.rA();
        zVar.a(bgVar);
        zVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.rx().a(this.dqj);
        if (this.fgQ != null) {
            bgVar.bDU = (i + 1) - (this.eYh != null ? this.eYh.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bij().a(this.fgQ, bgVar);
        ad(bgVar);
        bgVar.ZS();
        com.baidu.tieba.frs.d.a.a(bgVar, this.mPageId, this.fgQ);
        if (bgVar != null) {
            bgVar.ZS();
        }
        return zVar.getView();
    }

    private void ad(bg bgVar) {
        if (this.fgN == null) {
            this.fgN = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bij().a(bgVar, this.fgN);
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.ZQ = z;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mC(int i) {
        this.fgP = i;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.eYD = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YA = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.card.aa
    public void hS(boolean z) {
        this.fgO = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bfx() {
        return this.fgQ;
    }
}
