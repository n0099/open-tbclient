package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bc;
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
public class i extends com.baidu.tieba.frs.h<bc, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e>> implements com.baidu.tieba.a.f, ab, ac, com.baidu.tieba.frs.e.c {
    private boolean ayb;
    private ad<bc> bGJ;
    private String bGM;
    private VoiceManager djz;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dnI;
    private com.baidu.adp.lib.e.b<TbImageView> dnJ;
    private boolean drj;
    private int drk;
    private com.baidu.tieba.frs.e.a drl;
    private com.baidu.tieba.frs.entelechy.view.e drx;
    private HashSet<String> dry;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void V(bc bcVar) {
        if (this.dry == null) {
            this.dry = new HashSet<>();
        }
        if (bcVar.getTid() != null && !this.dry.contains(bcVar.getTid())) {
            this.dry.add(bcVar.getTid());
            TiebaStatic.log(new an("c11662").r("obj_param1", 1).ah("post_id", bcVar.getTid()));
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ayb = false;
        this.drj = false;
        this.drk = 3;
        this.drl = new com.baidu.tieba.frs.e.a();
        this.bGJ = new ad<bc>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                if (view != null && bcVar != null) {
                    if (i.this.djj != null) {
                        i.this.djj.a(view, bcVar, i.this.getType());
                    }
                    if ("c13010".equals(i.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").r("obj_type", 1).f(ImageViewerConfig.FORUM_ID, bcVar.getFid()).ah("tid", bcVar.getTid()));
                    }
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.azw().a(i.this.drl, bcVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(i.this.drl, bcVar.vT());
                    } else if (view instanceof TbImageView) {
                        if (i.this.bGJ.bgZ instanceof Boolean) {
                            if (((Boolean) i.this.bGJ.bgZ).booleanValue()) {
                                com.baidu.tieba.frs.e.b.azw().a(i.this.drl, bcVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.azw().a(i.this.drl, bcVar, 3);
                            }
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.azw().a(i.this.drl, bcVar, 5);
                    } else if (view.getId() != d.g.card_frs_god_reply_layout) {
                        com.baidu.tieba.frs.e.b.azw().a(i.this.drl, bcVar, 1);
                    } else {
                        int i = 6;
                        if (bcVar.wI() != null && bcVar.wI().bxE() != null && bcVar.wI().bxE().Nz() != null && bcVar.wI().bxE().Nz().size() > 0) {
                            i = bcVar.wI().gNB ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.azw().a(i.this.drl, bcVar, i);
                    }
                }
            }
        };
        this.dnI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avv */
            public ConstrainImageLayout mo9if() {
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
        this.dnJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ba */
            public TbImageView mo9if() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(am.getColor(d.C0142d.common_color_10043));
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
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.drx = new com.baidu.tieba.frs.entelechy.view.e(this.mPageContext, this.mPageId);
        this.drx.setConstrainLayoutPool(this.dnI);
        this.drx.setConstrainImagePool(this.dnJ);
        this.drx.j(this.mPageId);
        this.drx.setVoiceManager(this.djz);
        this.drx.setSingleImageRatio(0.75d);
        if (this.drx.Vr() != null) {
            this.drx.Vr().setInFrsAllThread(this.ayb);
        }
        this.drx.hf(this.drk);
        if (this.drk != 15 && this.drj && this.drx.bGY != null) {
            this.drx.bGY.setFrom(4);
        }
        return new com.baidu.tieba.card.a.a<>(this.drx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bc bcVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> aVar) {
        super.onFillViewHolder(i, view, viewGroup, bcVar, aVar);
        if (bcVar != null && bcVar.vc()) {
            V(bcVar);
        }
        if (aVar == null || aVar.aja() == null) {
            return null;
        }
        if (aVar.aja() instanceof com.baidu.tieba.a.e) {
            aVar.aja().setPage(this.bGM);
        }
        com.baidu.tieba.frs.g.a(aVar.aja().Vr(), this.djc);
        com.baidu.tieba.frs.g.a(aVar.aja().Vs(), this.djc);
        if (this.djc != null && this.djc.baT() != null && !StringUtils.isNull(this.djc.baT().getTopic_special_icon()) && !StringUtils.isNull(this.djc.baT().getTopic_special_icon_right())) {
            aVar.aja().P(this.djc.baT().getTopic_special_icon(), this.djc.baT().getTopic_special_icon_right());
        }
        aVar.aja().a(bcVar);
        aVar.aja().setForumName(this.mForumName);
        aVar.aja().b(this.bGJ);
        com.baidu.tieba.frs.e.b.azw().a(this.drl, bcVar);
        if (bcVar != null) {
            bcVar.wq();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        if (this.drx != null) {
            this.drx.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void hf(int i) {
        this.drk = i;
        if (this.drx != null) {
            this.drx.hf(i);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.djz = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.ayb = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void ez(boolean z) {
        this.drj = z;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a awC() {
        return this.drl;
    }
}
