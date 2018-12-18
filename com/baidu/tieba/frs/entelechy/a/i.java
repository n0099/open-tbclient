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
    private boolean aJH;
    private ad<bb> cat;
    private String caw;
    private VoiceManager dIc;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dMD;
    private com.baidu.adp.lib.e.b<TbImageView> dME;
    private boolean dQg;
    private int dQh;
    private com.baidu.tieba.frs.e.a dQi;
    private com.baidu.tieba.frs.entelechy.view.e dQu;
    private HashSet<String> dQv;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void Y(bb bbVar) {
        if (this.dQv == null) {
            this.dQv = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dQv.contains(bbVar.getTid())) {
            this.dQv.add(bbVar.getTid());
            TiebaStatic.log(new am("c11662").x("obj_param1", 1).aA("post_id", bbVar.getTid()));
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aJH = false;
        this.dQg = false;
        this.dQh = 3;
        this.dQi = new com.baidu.tieba.frs.e.a();
        this.cat = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (i.this.dHM != null) {
                        i.this.dHM.a(view, bbVar, i.this.getType());
                    }
                    if ("c13010".equals(i.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").x("obj_type", 1).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aA("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aGK().a(i.this.dQi, bbVar, 2);
                    } else if (view.getId() == e.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(i.this.dQi, bbVar.Af());
                    } else if (view instanceof TbImageView) {
                        if (i.this.cat.bvK instanceof Boolean) {
                            if (((Boolean) i.this.cat.bvK).booleanValue()) {
                                com.baidu.tieba.frs.e.b.aGK().a(i.this.dQi, bbVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.aGK().a(i.this.dQi, bbVar, 3);
                            }
                        }
                    } else if (view.getId() == e.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.aGK().a(i.this.dQi, bbVar, 5);
                    } else if (view.getId() != e.g.card_frs_god_reply_layout) {
                        com.baidu.tieba.frs.e.b.aGK().a(i.this.dQi, bbVar, 1);
                    } else {
                        int i = 6;
                        if (bbVar.AX() != null && bbVar.AX().bDt() != null && bbVar.AX().bDt().RZ() != null && bbVar.AX().bDt().RZ().size() > 0) {
                            i = bbVar.AX().hlS ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.aGK().a(i.this.dQi, bbVar, i);
                    }
                }
            }
        };
        this.dMD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aCN */
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
        this.dME = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ft */
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
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        final com.baidu.tieba.frs.entelechy.view.e eVar = new com.baidu.tieba.frs.entelechy.view.e(this.mPageContext, this.mPageId);
        eVar.setConstrainLayoutPool(this.dMD);
        eVar.setConstrainImagePool(this.dME);
        eVar.j(this.mPageId);
        eVar.setVoiceManager(this.dIc);
        eVar.setSingleImageRatio(0.75d);
        if (eVar.aco() != null) {
            eVar.aco().setInFrsAllThread(this.aJH);
        }
        eVar.iJ(this.dQh);
        if (this.dQh != 15 && this.dQg && eVar.caI != null) {
            eVar.caI.setFrom(4);
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
        this.dQu = eVar;
        return new com.baidu.tieba.card.a.a<>(this.dQu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> aVar) {
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (bbVar != null && bbVar.zm()) {
            Y(bbVar);
        }
        if (aVar == null || aVar.aqe() == null) {
            return null;
        }
        if (aVar.aqe() instanceof com.baidu.tieba.a.e) {
            aVar.aqe().setPage(this.caw);
        }
        com.baidu.tieba.frs.g.a(aVar.aqe().aco(), this.dHF);
        com.baidu.tieba.frs.g.a(aVar.aqe().acp(), this.dHF);
        if (this.dHF != null && this.dHF.bgh() != null && !StringUtils.isNull(this.dHF.bgh().getTopic_special_icon()) && !StringUtils.isNull(this.dHF.bgh().getTopic_special_icon_right())) {
            aVar.aqe().al(this.dHF.bgh().getTopic_special_icon(), this.dHF.bgh().getTopic_special_icon_right());
        }
        aVar.aqe().a(bbVar);
        aVar.aqe().setForumName(this.mForumName);
        aVar.aqe().b(this.cat);
        com.baidu.tieba.frs.e.b.aGK().a(this.dQi, bbVar);
        if (bbVar != null) {
            bbVar.AD();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        if (this.dQu != null) {
            this.dQu.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iJ(int i) {
        this.dQh = i;
        if (this.dQu != null) {
            this.dQu.iJ(i);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dIc = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aJH = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fv(boolean z) {
        this.dQg = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aDT() {
        return this.dQi;
    }
}
