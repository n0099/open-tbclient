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
public class i extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.d {
    private boolean aKm;
    private ad<bb> cbi;
    private String cbl;
    private VoiceManager dLA;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dQb;
    private com.baidu.adp.lib.e.b<TbImageView> dQc;
    private boolean dTE;
    private int dTF;
    private com.baidu.tieba.frs.e.b dTG;
    private com.baidu.tieba.frs.entelechy.view.e dTS;
    private HashSet<String> dTT;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void Y(bb bbVar) {
        if (this.dTT == null) {
            this.dTT = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dTT.contains(bbVar.getTid())) {
            this.dTT.add(bbVar.getTid());
            TiebaStatic.log(new am("c11662").y("obj_param1", 1).aB("post_id", bbVar.getTid()));
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aKm = false;
        this.dTE = false;
        this.dTF = 3;
        this.dTG = new com.baidu.tieba.frs.e.b();
        this.cbi = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (i.this.dLk != null) {
                        i.this.dLk.a(view, bbVar, i.this.getType());
                    }
                    if ("c13010".equals(i.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").y("obj_type", 1).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aB("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.c.aHW().a(i.this.dTG, bbVar, 2);
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, i.this.mPageId, i.this.dTG);
                    } else if (view.getId() == e.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(i.this.dTG, bbVar.As());
                    } else if (view instanceof TbImageView) {
                        if (i.this.cbi.bwC instanceof Boolean) {
                            if (((Boolean) i.this.cbi.bwC).booleanValue()) {
                                com.baidu.tieba.frs.e.c.aHW().a(i.this.dTG, bbVar, 1);
                                com.baidu.tieba.frs.e.a.a(bbVar, 1, i.this.mPageId, i.this.dTG);
                                return;
                            }
                            com.baidu.tieba.frs.e.c.aHW().a(i.this.dTG, bbVar, 3);
                            com.baidu.tieba.frs.e.a.a(bbVar, 3, i.this.mPageId, i.this.dTG);
                        }
                    } else if (view.getId() == e.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.c.aHW().a(i.this.dTG, bbVar, 5);
                    } else if (view.getId() == e.g.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bbVar.Bk() != null && bbVar.Bk().bEU() != null && bbVar.Bk().bEU().Sx() != null && bbVar.Bk().bEU().Sx().size() > 0) {
                            i = bbVar.Bk().hqj ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.c.aHW().a(i.this.dTG, bbVar, i);
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, i.this.mPageId, i.this.dTG);
                    } else if (view.getId() == e.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, i.this.mPageId, i.this.dTG);
                    } else {
                        com.baidu.tieba.frs.e.c.aHW().a(i.this.dTG, bbVar, 1);
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, i.this.mPageId, i.this.dTG);
                    }
                }
            }
        };
        this.dQb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aDZ */
            public ConstrainImageLayout jz() {
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
        this.dQc = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: FH */
            public TbImageView jz() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1));
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
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.frs.entelechy.view.e eVar = new com.baidu.tieba.frs.entelechy.view.e(this.mPageContext, this.mPageId);
        eVar.setConstrainLayoutPool(this.dQb);
        eVar.setConstrainImagePool(this.dQc);
        eVar.j(this.mPageId);
        eVar.setVoiceManager(this.dLA);
        eVar.setSingleImageRatio(0.75d);
        if (eVar.acN() != null) {
            eVar.acN().setInFrsAllThread(this.aKm);
        }
        eVar.iK(this.dTF);
        if (this.dTF != 15 && this.dTE && eVar.cbx != null) {
            eVar.cbx.setFrom(4);
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
        this.dTS = eVar;
        return new com.baidu.tieba.card.a.a<>(this.dTS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> aVar) {
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (bbVar != null && bbVar.zz()) {
            Y(bbVar);
        }
        if (aVar == null || aVar.arr() == null) {
            return null;
        }
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbl);
        }
        com.baidu.tieba.frs.g.a(aVar.arr().acN(), this.dLd);
        com.baidu.tieba.frs.g.a(aVar.arr().acO(), this.dLd);
        if (this.dLd != null && this.dLd.bhx() != null && !StringUtils.isNull(this.dLd.bhx().getTopic_special_icon()) && !StringUtils.isNull(this.dLd.bhx().getTopic_special_icon_right())) {
            aVar.arr().am(this.dLd.bhx().getTopic_special_icon(), this.dLd.bhx().getTopic_special_icon_right());
        }
        aVar.arr().a(bbVar);
        aVar.arr().setForumName(this.mForumName);
        aVar.arr().b(this.cbi);
        if (this.dTG != null) {
            int i2 = 0;
            if (this.dLd != null) {
                i2 = this.dLd.aHA();
            }
            bbVar.awk = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHW().a(this.dTG, bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dTG);
        if (bbVar != null) {
            bbVar.AQ();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        if (this.dTS != null) {
            this.dTS.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.dTF = i;
        if (this.dTS != null) {
            this.dTS.iK(i);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dLA = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbl = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aKm = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fA(boolean z) {
        this.dTE = z;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aFf() {
        return this.dTG;
    }
}
