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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.ac;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class i extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean axH;
    private String bHB;
    private ad<bb> bHy;
    private VoiceManager dmp;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dqB;
    private com.baidu.adp.lib.e.b<TbImageView> dqC;
    private boolean dtW;
    private int dtX;
    private com.baidu.tieba.frs.e.a dtY;
    private com.baidu.tieba.frs.entelechy.view.e duk;
    private HashSet<String> dul;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void X(bb bbVar) {
        if (this.dul == null) {
            this.dul = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dul.contains(bbVar.getTid())) {
            this.dul.add(bbVar.getTid());
            TiebaStatic.log(new an("c11662").r("obj_param1", 1).af("post_id", bbVar.getTid()));
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.axH = false;
        this.dtW = false;
        this.dtX = 3;
        this.dtY = new com.baidu.tieba.frs.e.a();
        this.bHy = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (i.this.dlZ != null) {
                        i.this.dlZ.a(view, bbVar, i.this.getType());
                    }
                    if ("c13010".equals(i.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").r("obj_type", 1).f(ImageViewerConfig.FORUM_ID, bbVar.getFid()).af("tid", bbVar.getTid()));
                    }
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aAd().a(i.this.dtY, bbVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(i.this.dtY, bbVar.vI());
                    } else if (view instanceof TbImageView) {
                        if (i.this.bHy.bhE instanceof Boolean) {
                            if (((Boolean) i.this.bHy.bhE).booleanValue()) {
                                com.baidu.tieba.frs.e.b.aAd().a(i.this.dtY, bbVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.aAd().a(i.this.dtY, bbVar, 3);
                            }
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.aAd().a(i.this.dtY, bbVar, 5);
                    } else if (view.getId() != d.g.card_frs_god_reply_layout) {
                        com.baidu.tieba.frs.e.b.aAd().a(i.this.dtY, bbVar, 1);
                    } else {
                        int i = 6;
                        if (bbVar.wx() != null && bbVar.wx().bwh() != null && bbVar.wx().bwh().Nx() != null && bbVar.wx().bwh().Nx().size() > 0) {
                            i = bbVar.wx().gOz ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.aAd().a(i.this.dtY, bbVar, i);
                    }
                }
            }
        };
        this.dqB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awa */
            public ConstrainImageLayout ig() {
                return new ConstrainImageLayout(i.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void q(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout r(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.dqC = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AR */
            public TbImageView ig() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(d.C0140d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView r(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView s(TbImageView tbImageView) {
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
        this.duk = new com.baidu.tieba.frs.entelechy.view.e(this.mPageContext, this.mPageId);
        this.duk.setConstrainLayoutPool(this.dqB);
        this.duk.setConstrainImagePool(this.dqC);
        this.duk.j(this.mPageId);
        this.duk.setVoiceManager(this.dmp);
        this.duk.setSingleImageRatio(0.75d);
        if (this.duk.VA() != null) {
            this.duk.VA().setInFrsAllThread(this.axH);
        }
        this.duk.hl(this.dtX);
        if (this.dtX != 15 && this.dtW && this.duk.bHN != null) {
            this.duk.bHN.setFrom(4);
        }
        return new com.baidu.tieba.card.a.a<>(this.duk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> aVar) {
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (bbVar != null && bbVar.uQ()) {
            X(bbVar);
        }
        if (aVar == null || aVar.ajz() == null) {
            return null;
        }
        if (aVar.ajz() instanceof com.baidu.tieba.a.e) {
            aVar.ajz().setPage(this.bHB);
        }
        com.baidu.tieba.frs.g.a(aVar.ajz().VA(), this.dlS);
        com.baidu.tieba.frs.g.a(aVar.ajz().VB(), this.dlS);
        if (this.dlS != null && this.dlS.aZl() != null && !StringUtils.isNull(this.dlS.aZl().getTopic_special_icon()) && !StringUtils.isNull(this.dlS.aZl().getTopic_special_icon_right())) {
            aVar.ajz().O(this.dlS.aZl().getTopic_special_icon(), this.dlS.aZl().getTopic_special_icon_right());
        }
        aVar.ajz().a(bbVar);
        aVar.ajz().setForumName(this.mForumName);
        aVar.ajz().b(this.bHy);
        com.baidu.tieba.frs.e.b.aAd().a(this.dtY, bbVar);
        if (bbVar != null) {
            bbVar.wf();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        if (this.duk != null) {
            this.duk.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hl(int i) {
        this.dtX = i;
        if (this.duk != null) {
            this.duk.hl(i);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dmp = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.axH = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void eA(boolean z) {
        this.dtW = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axh() {
        return this.dtY;
    }
}
