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
    private boolean aKl;
    private ad<bb> cbh;
    private String cbk;
    private VoiceManager dLz;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dQa;
    private com.baidu.adp.lib.e.b<TbImageView> dQb;
    private boolean dTD;
    private int dTE;
    private com.baidu.tieba.frs.e.b dTF;
    private com.baidu.tieba.frs.entelechy.view.e dTR;
    private HashSet<String> dTS;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void Y(bb bbVar) {
        if (this.dTS == null) {
            this.dTS = new HashSet<>();
        }
        if (bbVar.getTid() != null && !this.dTS.contains(bbVar.getTid())) {
            this.dTS.add(bbVar.getTid());
            TiebaStatic.log(new am("c11662").y("obj_param1", 1).aB("post_id", bbVar.getTid()));
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aKl = false;
        this.dTD = false;
        this.dTE = 3;
        this.dTF = new com.baidu.tieba.frs.e.b();
        this.cbh = new ad<bb>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bb bbVar) {
                if (view != null && bbVar != null) {
                    if (i.this.dLj != null) {
                        i.this.dLj.a(view, bbVar, i.this.getType());
                    }
                    if ("c13010".equals(i.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").y("obj_type", 1).i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aB("tid", bbVar.getTid()));
                    }
                    if (view.getId() == e.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.c.aHW().a(i.this.dTF, bbVar, 2);
                        com.baidu.tieba.frs.e.a.a(bbVar, 2, i.this.mPageId, i.this.dTF);
                    } else if (view.getId() == e.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(i.this.dTF, bbVar.As());
                    } else if (view instanceof TbImageView) {
                        if (i.this.cbh.bwB instanceof Boolean) {
                            if (((Boolean) i.this.cbh.bwB).booleanValue()) {
                                com.baidu.tieba.frs.e.c.aHW().a(i.this.dTF, bbVar, 1);
                                com.baidu.tieba.frs.e.a.a(bbVar, 1, i.this.mPageId, i.this.dTF);
                                return;
                            }
                            com.baidu.tieba.frs.e.c.aHW().a(i.this.dTF, bbVar, 3);
                            com.baidu.tieba.frs.e.a.a(bbVar, 3, i.this.mPageId, i.this.dTF);
                        }
                    } else if (view.getId() == e.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.c.aHW().a(i.this.dTF, bbVar, 5);
                    } else if (view.getId() == e.g.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bbVar.Bk() != null && bbVar.Bk().bEU() != null && bbVar.Bk().bEU().Sx() != null && bbVar.Bk().bEU().Sx().size() > 0) {
                            i = bbVar.Bk().hqi ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.c.aHW().a(i.this.dTF, bbVar, i);
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, i.this.mPageId, i.this.dTF);
                    } else if (view.getId() == e.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.e.a.a(bbVar, 5, i.this.mPageId, i.this.dTF);
                    } else {
                        com.baidu.tieba.frs.e.c.aHW().a(i.this.dTF, bbVar, 1);
                        com.baidu.tieba.frs.e.a.a(bbVar, 1, i.this.mPageId, i.this.dTF);
                    }
                }
            }
        };
        this.dQa = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.i.2
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
        this.dQb = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.i.3
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
        eVar.setConstrainLayoutPool(this.dQa);
        eVar.setConstrainImagePool(this.dQb);
        eVar.j(this.mPageId);
        eVar.setVoiceManager(this.dLz);
        eVar.setSingleImageRatio(0.75d);
        if (eVar.acN() != null) {
            eVar.acN().setInFrsAllThread(this.aKl);
        }
        eVar.iK(this.dTE);
        if (this.dTE != 15 && this.dTD && eVar.cbw != null) {
            eVar.cbw.setFrom(4);
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
        this.dTR = eVar;
        return new com.baidu.tieba.card.a.a<>(this.dTR);
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
            aVar.arr().setPage(this.cbk);
        }
        com.baidu.tieba.frs.g.a(aVar.arr().acN(), this.dLc);
        com.baidu.tieba.frs.g.a(aVar.arr().acO(), this.dLc);
        if (this.dLc != null && this.dLc.bhx() != null && !StringUtils.isNull(this.dLc.bhx().getTopic_special_icon()) && !StringUtils.isNull(this.dLc.bhx().getTopic_special_icon_right())) {
            aVar.arr().am(this.dLc.bhx().getTopic_special_icon(), this.dLc.bhx().getTopic_special_icon_right());
        }
        aVar.arr().a(bbVar);
        aVar.arr().setForumName(this.mForumName);
        aVar.arr().b(this.cbh);
        if (this.dTF != null) {
            int i2 = 0;
            if (this.dLc != null) {
                i2 = this.dLc.aHA();
            }
            bbVar.awj = (i + 1) - i2;
        }
        com.baidu.tieba.frs.e.c.aHW().a(this.dTF, bbVar);
        com.baidu.tieba.frs.e.a.a(bbVar, this.mPageId, this.dTF);
        if (bbVar != null) {
            bbVar.AQ();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        if (this.dTR != null) {
            this.dTR.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.ab
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.ab
    public void iK(int i) {
        this.dTE = i;
        if (this.dTR != null) {
            this.dTR.iK(i);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dLz = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbk = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.aKl = z;
    }

    @Override // com.baidu.tieba.card.ac
    public void fA(boolean z) {
        this.dTD = z;
    }

    @Override // com.baidu.tieba.frs.e.d
    public com.baidu.tieba.frs.e.b aFf() {
        return this.dTF;
    }
}
