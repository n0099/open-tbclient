package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.e;
import java.util.HashSet;
/* loaded from: classes.dex */
public class l extends e<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.e.c {
    private v<bd> buT;
    private VoiceManager cHh;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cNG;
    private com.baidu.adp.lib.e.b<TbImageView> cNH;
    private com.baidu.tieba.frs.entelechy.view.l cNU;
    private HashSet<String> cNV;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void J(bd bdVar) {
        if (this.cNV == null) {
            this.cNV = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.cNV.contains(bdVar.getTid())) {
            this.cNV.add(bdVar.getTid());
            TiebaStatic.log(new ak("c11662").r("obj_param1", 1).ac("post_id", bdVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.buT = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aqv().a(com.baidu.tieba.frs.e.c.cYY, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.cYY, bdVar.rU());
                    } else if (view instanceof TbImageView) {
                        if (l.this.buT.aXD instanceof Boolean) {
                            if (((Boolean) l.this.buT.aXD).booleanValue()) {
                                com.baidu.tieba.frs.e.b.aqv().a(com.baidu.tieba.frs.e.c.cYY, bdVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.aqv().a(com.baidu.tieba.frs.e.c.cYY, bdVar, 3);
                            }
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.aqv().a(com.baidu.tieba.frs.e.c.cYY, bdVar, 5);
                    } else if (view.getId() == d.g.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bdVar.sM() != null && bdVar.sM().bwX() != null && bdVar.sM().bwX().Jr() != null && bdVar.sM().bwX().Jr().size() > 0) {
                            i = bdVar.sM().gCv ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.aqv().a(com.baidu.tieba.frs.e.c.cYY, bdVar, i);
                    } else {
                        com.baidu.tieba.frs.e.b.aqv().a(com.baidu.tieba.frs.e.c.cYY, bdVar, 1);
                    }
                }
            }
        };
        this.cNG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: anL */
            public com.baidu.tbadk.widget.layout.b fI() {
                return new com.baidu.tbadk.widget.layout.b(l.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b o(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b p(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.cNH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wM */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(l.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0096d.common_color_10043));
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
    /* renamed from: U */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.cNU = new com.baidu.tieba.frs.entelechy.view.l(this.mPageContext, this.mPageId);
        this.cNU.setConstrainLayoutPool(this.cNG);
        this.cNU.setConstrainImagePool(this.cNH);
        this.cNU.k(this.mPageId);
        this.cNU.setVoiceManager(this.cHh);
        this.cNU.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.cNU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.e, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> aVar) {
        if (bdVar != null && bdVar.ra()) {
            J(bdVar);
        }
        if (aVar == null || aVar.acB() == null) {
            return null;
        }
        com.baidu.tieba.frs.d.a(aVar.acB().abX(), this.cGO);
        aVar.acB().a(bdVar);
        aVar.acB().setForumName(this.mForumName);
        aVar.acB().b(this.buT);
        com.baidu.tieba.frs.e.b.aqv().a(cYY, bdVar);
        if (bdVar != null) {
            bdVar.su();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.e
    public void setFromCDN(boolean z) {
        if (this.cNU != null) {
            this.cNU.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cHh = voiceManager;
    }
}
