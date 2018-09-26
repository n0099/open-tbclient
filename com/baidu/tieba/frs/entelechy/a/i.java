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
/* loaded from: classes2.dex */
public class i extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean aAK;
    private ad<bb> bNn;
    private String bNq;
    private int dAA;
    private com.baidu.tieba.frs.e.a dAB;
    private com.baidu.tieba.frs.entelechy.view.e dAN;
    private HashSet<String> dAO;
    private boolean dAz;
    private VoiceManager dsk;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dwN;
    private com.baidu.adp.lib.e.b<TbImageView> dwO;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void Y(bb bbVar) {
        if (this.dAO == null) {
            this.dAO = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dAO.contains(bbVar.getTid())) {
            this.dAO.add(bbVar.getTid());
            TiebaStatic.log(new am("c11662").w("obj_param1", 1).al("post_id", bbVar.getTid()));
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aAK = false;
        this.dAz = false;
        this.dAA = 3;
        this.dAB = new com.baidu.tieba.frs.e.a();
        this.bNn = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (i.this.drU != null) {
                        i.this.drU.a(view, bbVar, i.this.getType());
                    }
                    if ("c13010".equals(i.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").w("obj_type", 1).g(ImageViewerConfig.FORUM_ID, bbVar.getFid()).al("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aCj().a(i.this.dAB, bbVar, 2);
                    } else if (view.getId() == e.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(i.this.dAB, bbVar.wL());
                    } else if (view instanceof TbImageView) {
                        if (i.this.bNn.bnx instanceof Boolean) {
                            if (((Boolean) i.this.bNn.bnx).booleanValue()) {
                                com.baidu.tieba.frs.e.b.aCj().a(i.this.dAB, bbVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.aCj().a(i.this.dAB, bbVar, 3);
                            }
                        }
                    } else if (view.getId() == e.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.aCj().a(i.this.dAB, bbVar, 5);
                    } else if (view.getId() != e.g.card_frs_god_reply_layout) {
                        com.baidu.tieba.frs.e.b.aCj().a(i.this.dAB, bbVar, 1);
                    } else {
                        int i = 6;
                        if (bbVar.xD() != null && bbVar.xD().byO() != null && bbVar.xD().byO().OP() != null && bbVar.xD().byO().OP().size() > 0) {
                            i = bbVar.xD().gWf ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.aCj().a(i.this.dAB, bbVar, i);
                    }
                }
            }
        };
        this.dwN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ayk */
            public ConstrainImageLayout jm() {
                return new ConstrainImageLayout(i.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void r(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout t(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dwO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ca */
            public TbImageView jm() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(e.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void r(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView s(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView t(TbImageView tbImageView) {
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
        eVar.setConstrainLayoutPool(this.dwN);
        eVar.setConstrainImagePool(this.dwO);
        eVar.j(this.mPageId);
        eVar.setVoiceManager(this.dsk);
        eVar.setSingleImageRatio(0.75d);
        if (eVar.Xq() != null) {
            eVar.Xq().setInFrsAllThread(this.aAK);
        }
        eVar.hK(this.dAA);
        if (this.dAA != 15 && this.dAz && eVar.bNC != null) {
            eVar.bNC.setFrom(4);
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
        this.dAN = eVar;
        return new com.baidu.tieba.card.a.a<>(this.dAN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> aVar) {
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (bbVar != null && bbVar.vS()) {
            Y(bbVar);
        }
        if (aVar == null || aVar.aln() == null) {
            return null;
        }
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        com.baidu.tieba.frs.g.a(aVar.aln().Xq(), this.drN);
        com.baidu.tieba.frs.g.a(aVar.aln().Xr(), this.drN);
        if (this.drN != null && this.drN.bbH() != null && !StringUtils.isNull(this.drN.bbH().getTopic_special_icon()) && !StringUtils.isNull(this.drN.bbH().getTopic_special_icon_right())) {
            aVar.aln().V(this.drN.bbH().getTopic_special_icon(), this.drN.bbH().getTopic_special_icon_right());
        }
        aVar.aln().a(bbVar);
        aVar.aln().setForumName(this.mForumName);
        aVar.aln().b(this.bNn);
        com.baidu.tieba.frs.e.b.aCj().a(this.dAB, bbVar);
        if (bbVar != null) {
            bbVar.xj();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        if (this.dAN != null) {
            this.dAN.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hK(int i) {
        this.dAA = i;
        if (this.dAN != null) {
            this.dAN.hK(i);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dsk = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aAK = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void eR(boolean z) {
        this.dAz = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a azt() {
        return this.dAB;
    }
}
