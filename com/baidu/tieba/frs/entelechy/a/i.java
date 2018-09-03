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
import com.baidu.tieba.f;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class i extends com.baidu.tieba.frs.h<bb, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean axE;
    private String bHB;
    private ad<bb> bHy;
    private VoiceManager dmn;
    private com.baidu.adp.lib.e.b<TbImageView> dqA;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dqz;
    private boolean dtT;
    private int dtU;
    private com.baidu.tieba.frs.e.a dtV;
    private com.baidu.tieba.frs.entelechy.view.e duh;
    private HashSet<String> dui;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void X(bb bbVar) {
        if (this.dui == null) {
            this.dui = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dui.contains(bbVar.getTid())) {
            this.dui.add(bbVar.getTid());
            TiebaStatic.log(new an("c11662").r("obj_param1", 1).ae("post_id", bbVar.getTid()));
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.axE = false;
        this.dtT = false;
        this.dtU = 3;
        this.dtV = new com.baidu.tieba.frs.e.a();
        this.bHy = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (i.this.dlX != null) {
                        i.this.dlX.a(view, bbVar, i.this.getType());
                    }
                    if ("c13010".equals(i.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").r("obj_type", 1).f(ImageViewerConfig.FORUM_ID, bbVar.getFid()).ae("tid", bbVar.getTid()));
                    }
                    if (view.getId() == f.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aAa().a(i.this.dtV, bbVar, 2);
                    } else if (view.getId() == f.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(i.this.dtV, bbVar.vH());
                    } else if (view instanceof TbImageView) {
                        if (i.this.bHy.bhF instanceof Boolean) {
                            if (((Boolean) i.this.bHy.bhF).booleanValue()) {
                                com.baidu.tieba.frs.e.b.aAa().a(i.this.dtV, bbVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.aAa().a(i.this.dtV, bbVar, 3);
                            }
                        }
                    } else if (view.getId() == f.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.aAa().a(i.this.dtV, bbVar, 5);
                    } else if (view.getId() != f.g.card_frs_god_reply_layout) {
                        com.baidu.tieba.frs.e.b.aAa().a(i.this.dtV, bbVar, 1);
                    } else {
                        int i = 6;
                        if (bbVar.ww() != null && bbVar.ww().bwi() != null && bbVar.ww().bwi().Nw() != null && bbVar.ww().bwi().Nw().size() > 0) {
                            i = bbVar.ww().gOB ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.aAa().a(i.this.dtV, bbVar, i);
                    }
                }
            }
        };
        this.dqz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avZ */
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
        this.dqA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AO */
            public TbImageView ig() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(f.d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds1));
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
        this.duh = new com.baidu.tieba.frs.entelechy.view.e(this.mPageContext, this.mPageId);
        this.duh.setConstrainLayoutPool(this.dqz);
        this.duh.setConstrainImagePool(this.dqA);
        this.duh.j(this.mPageId);
        this.duh.setVoiceManager(this.dmn);
        this.duh.setSingleImageRatio(0.75d);
        if (this.duh.VD() != null) {
            this.duh.VD().setInFrsAllThread(this.axE);
        }
        this.duh.hk(this.dtU);
        if (this.dtU != 15 && this.dtT && this.duh.bHN != null) {
            this.duh.bHN.setFrom(4);
        }
        return new com.baidu.tieba.card.a.a<>(this.duh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bb bbVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> aVar) {
        super.onFillViewHolder(i, view, viewGroup, bbVar, aVar);
        if (bbVar != null && bbVar.uP()) {
            X(bbVar);
        }
        if (aVar == null || aVar.ajC() == null) {
            return null;
        }
        if (aVar.ajC() instanceof com.baidu.tieba.a.e) {
            aVar.ajC().setPage(this.bHB);
        }
        com.baidu.tieba.frs.g.a(aVar.ajC().VD(), this.dlQ);
        com.baidu.tieba.frs.g.a(aVar.ajC().VE(), this.dlQ);
        if (this.dlQ != null && this.dlQ.aZg() != null && !StringUtils.isNull(this.dlQ.aZg().getTopic_special_icon()) && !StringUtils.isNull(this.dlQ.aZg().getTopic_special_icon_right())) {
            aVar.ajC().O(this.dlQ.aZg().getTopic_special_icon(), this.dlQ.aZg().getTopic_special_icon_right());
        }
        aVar.ajC().a(bbVar);
        aVar.ajC().setForumName(this.mForumName);
        aVar.ajC().b(this.bHy);
        com.baidu.tieba.frs.e.b.aAa().a(this.dtV, bbVar);
        if (bbVar != null) {
            bbVar.we();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        if (this.duh != null) {
            this.duh.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hk(int i) {
        this.dtU = i;
        if (this.duh != null) {
            this.duh.hk(i);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dmn = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.axE = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void eA(boolean z) {
        this.dtT = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axg() {
        return this.dtV;
    }
}
