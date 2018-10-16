package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class i extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean aFr;
    private ad<bb> bVP;
    private String bVS;
    private VoiceManager dAm;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dEO;
    private com.baidu.adp.lib.e.b<TbImageView> dEP;
    private int dIA;
    private com.baidu.tieba.frs.e.a dIB;
    private com.baidu.tieba.frs.entelechy.view.e dIN;
    private HashSet<String> dIO;
    private boolean dIz;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void Y(bb bbVar) {
        if (this.dIO == null) {
            this.dIO = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dIO.contains(bbVar.getTid())) {
            this.dIO.add(bbVar.getTid());
            TiebaStatic.log(new am("c11662").x("obj_param1", 1).ax("post_id", bbVar.getTid()));
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aFr = false;
        this.dIz = false;
        this.dIA = 3;
        this.dIB = new com.baidu.tieba.frs.e.a();
        this.bVP = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (i.this.dzW != null) {
                        i.this.dzW.a(view, bbVar, i.this.getType());
                    }
                    if ("c13010".equals(i.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 1).h(ImageViewerConfig.FORUM_ID, bbVar.getFid()).ax("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aFC().a(i.this.dIB, bbVar, 2);
                    } else if (view.getId() == e.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(i.this.dIB, bbVar.yU());
                    } else if (view instanceof TbImageView) {
                        if (i.this.bVP.brz instanceof Boolean) {
                            if (((Boolean) i.this.bVP.brz).booleanValue()) {
                                com.baidu.tieba.frs.e.b.aFC().a(i.this.dIB, bbVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.aFC().a(i.this.dIB, bbVar, 3);
                            }
                        }
                    } else if (view.getId() == e.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.aFC().a(i.this.dIB, bbVar, 5);
                    } else if (view.getId() != e.g.card_frs_god_reply_layout) {
                        com.baidu.tieba.frs.e.b.aFC().a(i.this.dIB, bbVar, 1);
                    } else {
                        int i = 6;
                        if (bbVar.zM() != null && bbVar.zM().bCd() != null && bbVar.zM().bCd().QK() != null && bbVar.zM().bCd().QK().size() > 0) {
                            i = bbVar.zM().hdA ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.aFC().a(i.this.dIB, bbVar, i);
                    }
                }
            }
        };
        this.dEO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aBF */
            public ConstrainImageLayout jB() {
                return new ConstrainImageLayout(i.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout v(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout w(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dEP = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ef */
            public TbImageView jB() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView v(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView w(TbImageView tbImageView) {
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
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.frs.entelechy.view.e eVar = new com.baidu.tieba.frs.entelechy.view.e(this.mPageContext, this.mPageId);
        eVar.setConstrainLayoutPool(this.dEO);
        eVar.setConstrainImagePool(this.dEP);
        eVar.j(this.mPageId);
        eVar.setVoiceManager(this.dAm);
        eVar.setSingleImageRatio(0.75d);
        if (eVar.aaX() != null) {
            eVar.aaX().setInFrsAllThread(this.aFr);
        }
        eVar.ii(this.dIA);
        if (this.dIA != 15 && this.dIz && eVar.bWe != null) {
            eVar.bWe.setFrom(4);
        }
        if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
            eVar.setPreloadSizeReadyCallback(new com.baidu.adp.widget.a.b() { // from class: com.baidu.tieba.frs.entelechy.a.i.4
                @Override // com.baidu.adp.widget.a.b
                public void k(int i, int i2, int i3) {
                    i.this.setPreloadSize(i, i2, i3);
                    if (i.this.isPreloadSizeReady(1) && i.this.isPreloadSizeReady(2)) {
                        eVar.setPreloadSizeReadyCallback(null);
                    }
                }
            });
        }
        this.dIN = eVar;
        return new com.baidu.tieba.card.a.a<>(this.dIN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> aVar) {
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (bbVar != null && bbVar.yb()) {
            Y(bbVar);
        }
        if (aVar == null || aVar.aoP() == null) {
            return null;
        }
        if (aVar.aoP() instanceof com.baidu.tieba.a.e) {
            aVar.aoP().setPage(this.bVS);
        }
        com.baidu.tieba.frs.g.a(aVar.aoP().aaX(), this.dzP);
        com.baidu.tieba.frs.g.a(aVar.aoP().aaY(), this.dzP);
        if (this.dzP != null && this.dzP.beT() != null && !StringUtils.isNull(this.dzP.beT().getTopic_special_icon()) && !StringUtils.isNull(this.dzP.beT().getTopic_special_icon_right())) {
            aVar.aoP().ai(this.dzP.beT().getTopic_special_icon(), this.dzP.beT().getTopic_special_icon_right());
        }
        aVar.aoP().a(bbVar);
        aVar.aoP().setForumName(this.mForumName);
        aVar.aoP().b(this.bVP);
        com.baidu.tieba.frs.e.b.aFC().a(this.dIB, bbVar);
        if (bbVar != null) {
            bbVar.zs();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        if (this.dIN != null) {
            this.dIN.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void ii(int i) {
        this.dIA = i;
        if (this.dIN != null) {
            this.dIN.ii(i);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dAm = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aFr = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fj(boolean z) {
        this.dIz = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aCM() {
        return this.dIB;
    }
}
