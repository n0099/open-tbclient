package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
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
public class l extends com.baidu.adp.widget.ListView.a<bj, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l>> implements v, com.baidu.tieba.frs.f.c {
    private x<bj> bkV;
    private VoiceManager cpV;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cvV;
    private com.baidu.adp.lib.e.b<TbImageView> cvW;
    private com.baidu.tieba.frs.entelechy.view.l cwi;
    private HashSet<String> cwj;
    private TbPageContext<?> mF;
    private String mForumName;

    private void J(bj bjVar) {
        if (this.cwj == null) {
            this.cwj = new HashSet<>();
        }
        if (bjVar.getTid() != null && !this.cwj.contains(bjVar.getTid())) {
            this.cwj.add(bjVar.getTid());
            TiebaStatic.log(new ak("c11662").r("obj_param1", 1).ad("post_id", bjVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bkV = new x<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == d.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.f.b.alu().a(com.baidu.tieba.frs.f.c.cFj, bjVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.g.h.a(com.baidu.tieba.frs.f.c.cFj, bjVar.rZ());
                    } else if (view instanceof TbImageView) {
                        if (l.this.bkV.aTB instanceof Boolean) {
                            if (((Boolean) l.this.bkV.aTB).booleanValue()) {
                                com.baidu.tieba.frs.f.b.alu().a(com.baidu.tieba.frs.f.c.cFj, bjVar, 1);
                            } else {
                                com.baidu.tieba.frs.f.b.alu().a(com.baidu.tieba.frs.f.c.cFj, bjVar, 3);
                            }
                        }
                    } else if (view.getId() == d.h.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.f.b.alu().a(com.baidu.tieba.frs.f.c.cFj, bjVar, 5);
                    } else if (view.getId() == d.h.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bjVar.sR() != null && bjVar.sR().aDr() != null && bjVar.sR().aDr().Iv() != null && bjVar.sR().aDr().Iv().size() > 0) {
                            i = bjVar.sR().gjK ? 9 : 8;
                        }
                        com.baidu.tieba.frs.f.b.alu().a(com.baidu.tieba.frs.f.c.cFj, bjVar, i);
                    } else {
                        com.baidu.tieba.frs.f.b.alu().a(com.baidu.tieba.frs.f.c.cFj, bjVar, 1);
                    }
                }
            }
        };
        this.cvV = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aji */
            public com.baidu.tbadk.widget.layout.b fJ() {
                return new com.baidu.tbadk.widget.layout.b(l.this.mF.getPageActivity());
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
        this.cvW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xo */
            public TbImageView fJ() {
                TbImageView tbImageView = new TbImageView(l.this.mF.getPageActivity());
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
        this.mF = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.cwi = new com.baidu.tieba.frs.entelechy.view.l(this.mF, this.mPageId);
        this.cwi.setConstrainLayoutPool(this.cvV);
        this.cwi.setConstrainImagePool(this.cvW);
        this.cwi.l(this.mPageId);
        this.cwi.setVoiceManager(this.cpV);
        this.cwi.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.cwi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> aVar) {
        if (bjVar != null && bjVar.rh()) {
            J(bjVar);
        }
        if (aVar == null || aVar.YJ() == null) {
            return null;
        }
        aVar.YJ().a(bjVar);
        aVar.YJ().setForumName(this.mForumName);
        aVar.YJ().b(this.bkV);
        com.baidu.tieba.frs.f.b.alu().a(cFj, bjVar);
        if (bjVar != null) {
            bjVar.sz();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.cwi != null) {
            this.cwi.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cpV = voiceManager;
    }
}
