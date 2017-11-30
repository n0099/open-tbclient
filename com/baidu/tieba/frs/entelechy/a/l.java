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
import java.util.HashSet;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.widget.ListView.a<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.e.c {
    private v<bd> buS;
    private VoiceManager cGZ;
    private com.baidu.tieba.frs.entelechy.view.l cNJ;
    private HashSet<String> cNK;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cNv;
    private com.baidu.adp.lib.e.b<TbImageView> cNw;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void H(bd bdVar) {
        if (this.cNK == null) {
            this.cNK = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.cNK.contains(bdVar.getTid())) {
            this.cNK.add(bdVar.getTid());
            TiebaStatic.log(new ak("c11662").r("obj_param1", 1).ac("post_id", bdVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.buS = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.cYM, bdVar.rW());
                    } else if (view instanceof TbImageView) {
                        if (l.this.buS.aXB instanceof Boolean) {
                            if (((Boolean) l.this.buS.aXB).booleanValue()) {
                                com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 3);
                            }
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 5);
                    } else if (view.getId() == d.g.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bdVar.sO() != null && bdVar.sO().bwr() != null && bdVar.sO().bwr().Jq() != null && bdVar.sO().bwr().Jq().size() > 0) {
                            i = bdVar.sO().gzM ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, i);
                    } else {
                        com.baidu.tieba.frs.e.b.aqn().a(com.baidu.tieba.frs.e.c.cYM, bdVar, 1);
                    }
                }
            }
        };
        this.cNv = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: anD */
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
        this.cNw = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: wN */
            public TbImageView fI() {
                TbImageView tbImageView = new TbImageView(l.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0082d.common_color_10043));
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
        this.cNJ = new com.baidu.tieba.frs.entelechy.view.l(this.mPageContext, this.mPageId);
        this.cNJ.setConstrainLayoutPool(this.cNv);
        this.cNJ.setConstrainImagePool(this.cNw);
        this.cNJ.k(this.mPageId);
        this.cNJ.setVoiceManager(this.cGZ);
        this.cNJ.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.cNJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> aVar) {
        if (bdVar != null && bdVar.rc()) {
            H(bdVar);
        }
        if (aVar == null || aVar.acs() == null) {
            return null;
        }
        aVar.acs().a(bdVar);
        aVar.acs().setForumName(this.mForumName);
        aVar.acs().b(this.buS);
        com.baidu.tieba.frs.e.b.aqn().a(cYM, bdVar);
        if (bdVar != null) {
            bdVar.sw();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cNJ != null) {
            this.cNJ.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cGZ = voiceManager;
    }
}
