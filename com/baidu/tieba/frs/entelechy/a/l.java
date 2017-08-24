package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
import java.util.HashSet;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.widget.ListView.a<bl, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l>> implements v, com.baidu.tieba.frs.e.c {
    private x<bl> bkB;
    private VoiceManager cjK;
    private com.baidu.adp.lib.e.b<TbImageView> coA;
    private com.baidu.tieba.frs.entelechy.view.l coL;
    private HashSet<String> coM;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> coz;
    private String mForumName;
    private TbPageContext<?> oW;

    private void F(bl blVar) {
        if (this.coM == null) {
            this.coM = new HashSet<>();
        }
        if (blVar.getTid() != null && !this.coM.contains(blVar.getTid())) {
            this.coM.add(blVar.getTid());
            TiebaStatic.log(new aj("c11662").r("obj_param1", 1).aa("post_id", blVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bkB = new x<bl>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bl blVar) {
                if (view != null && blVar != null) {
                    if (view.getId() == d.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.ajz().a(com.baidu.tieba.frs.e.c.cxO, blVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cxO, blVar.se());
                    } else if (view instanceof TbImageView) {
                        if (l.this.bkB.aTU instanceof Boolean) {
                            if (((Boolean) l.this.bkB.aTU).booleanValue()) {
                                com.baidu.tieba.frs.e.b.ajz().a(com.baidu.tieba.frs.e.c.cxO, blVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.ajz().a(com.baidu.tieba.frs.e.c.cxO, blVar, 3);
                            }
                        }
                    } else if (view.getId() == d.h.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.ajz().a(com.baidu.tieba.frs.e.c.cxO, blVar, 5);
                    } else if (view.getId() == d.h.card_frs_god_reply_layout) {
                        com.baidu.tieba.frs.e.b.ajz().a(com.baidu.tieba.frs.e.c.cxO, blVar, 6);
                    } else {
                        com.baidu.tieba.frs.e.b.ajz().a(com.baidu.tieba.frs.e.c.cxO, blVar, 1);
                    }
                }
            }
        };
        this.coz = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: ahk */
            public com.baidu.tbadk.widget.layout.b fT() {
                return new com.baidu.tbadk.widget.layout.b(l.this.oW.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void o(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b q(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.coA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xm */
            public TbImageView fT() {
                TbImageView tbImageView = new TbImageView(l.this.oW.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ai.getColor(d.e.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void o(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView p(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
        }, 12, 0);
        this.oW = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.coL = new com.baidu.tieba.frs.entelechy.view.l(this.oW, this.mPageId);
        this.coL.setConstrainLayoutPool(this.coz);
        this.coL.setConstrainImagePool(this.coA);
        this.coL.j(this.mPageId);
        this.coL.setVoiceManager(this.cjK);
        this.coL.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.coL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> aVar) {
        if (blVar != null && blVar.rn()) {
            F(blVar);
        }
        if (aVar == null || aVar.Xv() == null) {
            return null;
        }
        aVar.Xv().a(blVar);
        aVar.Xv().setForumName(this.mForumName);
        aVar.Xv().b(this.bkB);
        com.baidu.tieba.frs.e.b.ajz().a(cxO, blVar);
        if (blVar != null) {
            blVar.sE();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.coL != null) {
            this.coL.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cjK = voiceManager;
    }
}
