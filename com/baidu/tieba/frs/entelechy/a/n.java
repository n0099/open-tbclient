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
import com.baidu.tbadk.core.data.bf;
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
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class n extends com.baidu.tieba.frs.h<bf, com.baidu.card.z<bf>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String Wt;
    private boolean XJ;
    private boolean caI;
    private ab<bf> dAQ;
    private NEGFeedBackView.a dBs;
    private VoiceManager foP;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> ftY;
    private com.baidu.adp.lib.e.b<TbImageView> ftZ;
    private HashSet<String> fxh;
    private boolean fxi;
    private int fxk;
    private com.baidu.tieba.frs.d.b fxl;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.caI = false;
        this.fxi = false;
        this.XJ = true;
        this.fxk = 3;
        this.fxl = new com.baidu.tieba.frs.d.b();
        this.dAQ = new ab<bf>() { // from class: com.baidu.tieba.frs.entelechy.a.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bf bfVar) {
                if (view != null && bfVar != null) {
                    if (n.this.foz != null) {
                        n.this.foz.a(view, (View) bfVar, (Object) n.this.getType());
                    }
                    if ("c13010".equals(n.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").P("obj_type", 1).l("fid", bfVar.threadData.getFid()).bT("tid", bfVar.threadData.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpC().a(n.this.fxl, bfVar.threadData, 2);
                        com.baidu.tieba.frs.d.a.a(bfVar.threadData, 2, n.this.mPageId, n.this.fxl);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(n.this.fxl, bfVar.abw());
                    } else if (view instanceof TbImageView) {
                        if (n.this.dAQ.Xp instanceof Boolean) {
                            if (((Boolean) n.this.dAQ.Xp).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bpC().a(n.this.fxl, bfVar.threadData, 1);
                                com.baidu.tieba.frs.d.a.a(bfVar.threadData, 1, n.this.mPageId, n.this.fxl);
                                return;
                            }
                            com.baidu.tieba.frs.d.c.bpC().a(n.this.fxl, bfVar.threadData, 3);
                            com.baidu.tieba.frs.d.a.a(bfVar.threadData, 3, n.this.mPageId, n.this.fxl);
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bpC().a(n.this.fxl, bfVar.threadData, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bfVar.threadData.aeT() != null && bfVar.threadData.aeT().cmy() != null && bfVar.threadData.aeT().cmy().axz() != null && bfVar.threadData.aeT().cmy().axz().size() > 0) {
                            i = bfVar.threadData.aeT().iZj ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bpC().a(n.this.fxl, bfVar.threadData, i);
                        com.baidu.tieba.frs.d.a.a(bfVar.threadData, 5, n.this.mPageId, n.this.fxl);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bfVar.threadData, 5, n.this.mPageId, n.this.fxl);
                    } else {
                        com.baidu.tieba.frs.d.c.bpC().a(n.this.fxl, bfVar.threadData, 1);
                        com.baidu.tieba.frs.d.a.a(bfVar.threadData, 1, n.this.mPageId, n.this.fxl);
                    }
                }
            }
        };
        this.dBs = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.n.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new am("c11973").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11974").bT("obj_locate", sb.toString()).bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.ftY = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.n.3
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
        this.ftZ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.n.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajX */
            public TbImageView makeObject() {
                TbImageView tbImageView = new TbImageView(n.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(R.color.common_color_10043));
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
    /* renamed from: aH */
    public com.baidu.card.z<bf> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bm(184);
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
        oVar.setConstrainLayoutPool(this.ftY);
        oVar.setConstrainImagePool(this.ftZ);
        oVar.setFromCDN(this.XJ);
        aVar.b(oVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.v(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.f) hVar);
        hVar.setFromCDN(this.XJ);
        hVar.setForm("frs");
        if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
            oVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.n.6
                @Override // com.baidu.adp.widget.a.b
                public void j(int i, int i2, int i3) {
                    n.this.setPreloadSize(i, i2, i3);
                    if (n.this.isPreloadSizeReady(1) && n.this.isPreloadSizeReady(2)) {
                        oVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bEy = this.fxi ? 10 : 2;
        dVar2.bED = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.bw(3);
        aaVar.bm(16);
        aVar.a(aaVar);
        aVar.qq().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.x qr = aVar.qr();
        qr.bq(3);
        com.baidu.card.z<bf> zVar = new com.baidu.card.z<>(qr);
        zVar.setPageId(this.mPageId);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.n.7
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (n.this.dAQ != null) {
                        n.this.dAQ.a(zVar2.getView(), (bf) mVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), 3, false);
                    zVar2.qs().b(new a.C0038a(1));
                }
            }
        });
        zVar.qu();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bf bfVar, com.baidu.card.z<bf> zVar) {
        super.onFillViewHolder(i, view, viewGroup, bfVar, zVar);
        if (bfVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        zVar.qs().setPage(this.Wt);
        com.baidu.tieba.frs.g.a(zVar.qs().qm(), this.fot);
        if (this.fot != null && this.fot.getForum() != null && !StringUtils.isNull(this.fot.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fot.getForum().getTopic_special_icon_right())) {
            bfVar.threadData.bC(this.fot.getForum().getTopic_special_icon(), this.fot.getForum().getTopic_special_icon_right());
        }
        boolean z = (bfVar.threadData.adv() == null || bfVar.threadData.adv().getUserId() == null || !bfVar.threadData.adv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bfVar.threadData.aeE() && bfVar.threadData.ace() != null && !z) {
            zVar.qt().a(this.dBs);
        }
        zVar.qv();
        zVar.a(bfVar);
        zVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qs().a(this.dAQ);
        if (this.fxl != null) {
            bfVar.threadData.bLm = (bfVar.position + 1) - (this.fot != null ? this.fot.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bpC().a(this.fxl, bfVar.threadData);
        ad(bfVar.threadData);
        bfVar.threadData.aez();
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, this.fxl);
        if (bfVar != null) {
            bfVar.threadData.aez();
        }
        return zVar.getView();
    }

    private void ad(bg bgVar) {
        if (this.fxh == null) {
            this.fxh = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bpC().a(bgVar, this.fxh);
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.XJ = z;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void nt(int i) {
        this.fxk = i;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.foP = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.caI = z;
    }

    @Override // com.baidu.tieba.card.aa
    public void ix(boolean z) {
        this.fxi = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmT() {
        return this.fxl;
    }
}
