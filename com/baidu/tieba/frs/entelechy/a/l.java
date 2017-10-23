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
public class l extends com.baidu.adp.widget.ListView.a<bh, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l>> implements v, com.baidu.tieba.frs.f.c {
    private x<bh> bms;
    private VoiceManager cqg;
    private com.baidu.tieba.frs.entelechy.view.l cwE;
    private HashSet<String> cwF;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cwr;
    private com.baidu.adp.lib.e.b<TbImageView> cws;
    private String mForumName;
    private TbPageContext<?> mH;

    private void E(bh bhVar) {
        if (this.cwF == null) {
            this.cwF = new HashSet<>();
        }
        if (bhVar.getTid() != null && !this.cwF.contains(bhVar.getTid())) {
            this.cwF.add(bhVar.getTid());
            TiebaStatic.log(new ak("c11662").r("obj_param1", 1).ac("post_id", bhVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bms = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cFQ, bhVar.rM());
                    } else if (view instanceof TbImageView) {
                        if (l.this.bms.aUn instanceof Boolean) {
                            if (((Boolean) l.this.bms.aUn).booleanValue()) {
                                com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 1);
                            } else {
                                com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 3);
                            }
                        }
                    } else if (view.getId() == d.h.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 5);
                    } else if (view.getId() == d.h.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bhVar.sE() != null && bhVar.sE().aBY() != null && bhVar.sE().aBY().Ix() != null && bhVar.sE().aBY().Ix().size() > 0) {
                            i = bhVar.sE().ghf ? 9 : 8;
                        }
                        com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, i);
                    } else {
                        com.baidu.tieba.frs.f.b.alt().a(com.baidu.tieba.frs.f.c.cFQ, bhVar, 1);
                    }
                }
            }
        };
        this.cwr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajh */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(l.this.mH.getPageActivity());
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
        this.cws = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wF */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(l.this.mH.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.e.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
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
        this.mH = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.cwE = new com.baidu.tieba.frs.entelechy.view.l(this.mH, this.mPageId);
        this.cwE.setConstrainLayoutPool(this.cwr);
        this.cwE.setConstrainImagePool(this.cws);
        this.cwE.k(this.mPageId);
        this.cwE.setVoiceManager(this.cqg);
        this.cwE.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.cwE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> aVar) {
        if (bhVar != null && bhVar.qU()) {
            E(bhVar);
        }
        if (aVar == null || aVar.Yn() == null) {
            return null;
        }
        aVar.Yn().a(bhVar);
        aVar.Yn().setForumName(this.mForumName);
        aVar.Yn().b(this.bms);
        com.baidu.tieba.frs.f.b.alt().a(cFQ, bhVar);
        if (bhVar != null) {
            bhVar.sm();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cwE != null) {
            this.cwE.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cqg = voiceManager;
    }
}
