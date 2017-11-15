package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import java.util.HashSet;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.widget.ListView.a<bh, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l>> implements v, com.baidu.tieba.frs.e.c {
    private x<bh> bok;
    private com.baidu.tieba.frs.entelechy.view.l cEF;
    private HashSet<String> cEG;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cEr;
    private com.baidu.adp.lib.e.b<TbImageView> cEs;
    private VoiceManager cxT;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void E(bh bhVar) {
        if (this.cEG == null) {
            this.cEG = new HashSet<>();
        }
        if (bhVar.getTid() != null && !this.cEG.contains(bhVar.getTid())) {
            this.cEG.add(bhVar.getTid());
            TiebaStatic.log(new ak("c11662").r("obj_param1", 1).ac("post_id", bhVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bok = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cPx, bhVar.rS());
                    } else if (view instanceof TbImageView) {
                        if (l.this.bok.aUA instanceof Boolean) {
                            if (((Boolean) l.this.bok.aUA).booleanValue()) {
                                com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 3);
                            }
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 5);
                    } else if (view.getId() == d.g.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bhVar.sL() != null && bhVar.sL().aEx() != null && bhVar.sL().aEx().IT() != null && bhVar.sL().aEx().IT().size() > 0) {
                            i = bhVar.sL().gqT ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, i);
                    } else {
                        com.baidu.tieba.frs.e.b.aot().a(com.baidu.tieba.frs.e.c.cPx, bhVar, 1);
                    }
                }
            }
        };
        this.cEr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: alI */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(l.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public void n(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public com.baidu.tbadk.widget.layout.b o(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.cEs = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(l.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0080d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView o(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView p(TbImageView tbImageView) {
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
    /* renamed from: S */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.cEF = new com.baidu.tieba.frs.entelechy.view.l(this.mPageContext, this.mPageId);
        this.cEF.setConstrainLayoutPool(this.cEr);
        this.cEF.setConstrainImagePool(this.cEs);
        this.cEF.k(this.mPageId);
        this.cEF.setVoiceManager(this.cxT);
        this.cEF.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.cEF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> aVar) {
        if (bhVar != null && bhVar.qY()) {
            E(bhVar);
        }
        if (aVar == null || aVar.aaJ() == null) {
            return null;
        }
        aVar.aaJ().a(bhVar);
        aVar.aaJ().setForumName(this.mForumName);
        aVar.aaJ().b(this.bok);
        com.baidu.tieba.frs.e.b.aot().a(cPx, bhVar);
        if (bhVar != null) {
            bhVar.st();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cEF != null) {
            this.cEF.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cxT = voiceManager;
    }
}
