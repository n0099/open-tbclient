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
    private x<bh> bmG;
    private VoiceManager cqs;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cwD;
    private com.baidu.adp.lib.e.b<TbImageView> cwE;
    private com.baidu.tieba.frs.entelechy.view.l cwQ;
    private HashSet<String> cwR;
    private String mForumName;
    private TbPageContext<?> mG;

    private void E(bh bhVar) {
        if (this.cwR == null) {
            this.cwR = new HashSet<>();
        }
        if (bhVar.getTid() != null && !this.cwR.contains(bhVar.getTid())) {
            this.cwR.add(bhVar.getTid());
            TiebaStatic.log(new ak("c11662").r("obj_param1", 1).ad("post_id", bhVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bmG = new x<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (view.getId() == d.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.f.b.aly().a(com.baidu.tieba.frs.f.c.cGc, bhVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cGc, bhVar.rT());
                    } else if (view instanceof TbImageView) {
                        if (l.this.bmG.aUA instanceof Boolean) {
                            if (((Boolean) l.this.bmG.aUA).booleanValue()) {
                                com.baidu.tieba.frs.f.b.aly().a(com.baidu.tieba.frs.f.c.cGc, bhVar, 1);
                            } else {
                                com.baidu.tieba.frs.f.b.aly().a(com.baidu.tieba.frs.f.c.cGc, bhVar, 3);
                            }
                        }
                    } else if (view.getId() == d.h.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.f.b.aly().a(com.baidu.tieba.frs.f.c.cGc, bhVar, 5);
                    } else if (view.getId() == d.h.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bhVar.sL() != null && bhVar.sL().aCd() != null && bhVar.sL().aCd().ID() != null && bhVar.sL().aCd().ID().size() > 0) {
                            i = bhVar.sL().ghu ? 9 : 8;
                        }
                        com.baidu.tieba.frs.f.b.aly().a(com.baidu.tieba.frs.f.c.cGc, bhVar, i);
                    } else {
                        com.baidu.tieba.frs.f.b.aly().a(com.baidu.tieba.frs.f.c.cGc, bhVar, 1);
                    }
                }
            }
        };
        this.cwD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ajm */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(l.this.mG.getPageActivity());
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
        this.cwE = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(l.this.mG.getPageActivity());
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
        this.mG = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.cwQ = new com.baidu.tieba.frs.entelechy.view.l(this.mG, this.mPageId);
        this.cwQ.setConstrainLayoutPool(this.cwD);
        this.cwQ.setConstrainImagePool(this.cwE);
        this.cwQ.k(this.mPageId);
        this.cwQ.setVoiceManager(this.cqs);
        this.cwQ.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.cwQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> aVar) {
        if (bhVar != null && bhVar.rb()) {
            E(bhVar);
        }
        if (aVar == null || aVar.Yr() == null) {
            return null;
        }
        aVar.Yr().a(bhVar);
        aVar.Yr().setForumName(this.mForumName);
        aVar.Yr().b(this.bmG);
        com.baidu.tieba.frs.f.b.aly().a(cGc, bhVar);
        if (bhVar != null) {
            bhVar.st();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cwQ != null) {
            this.cwQ.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cqs = voiceManager;
    }
}
