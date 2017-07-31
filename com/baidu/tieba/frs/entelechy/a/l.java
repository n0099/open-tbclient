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
    private TbPageContext<?> alI;
    private x<bl> bkw;
    private VoiceManager ciW;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> cnQ;
    private com.baidu.adp.lib.e.b<TbImageView> cnR;
    private com.baidu.tieba.frs.entelechy.view.l coc;
    private HashSet<String> cod;
    private String mForumName;

    private void F(bl blVar) {
        if (this.cod == null) {
            this.cod = new HashSet<>();
        }
        if (blVar.getTid() != null && !this.cod.contains(blVar.getTid())) {
            this.cod.add(blVar.getTid());
            TiebaStatic.log(new aj("c11662").r("obj_param1", 1).aa("post_id", blVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bkw = new x<bl>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, bl blVar) {
                if (view != null && blVar != null) {
                    if (view.getId() == d.h.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.aiY().a(com.baidu.tieba.frs.e.c.cvL, blVar, 2);
                    } else if (view.getId() == d.h.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.cvL, blVar.sd());
                    } else if (view instanceof TbImageView) {
                        if (l.this.bkw.aTS instanceof Boolean) {
                            if (((Boolean) l.this.bkw.aTS).booleanValue()) {
                                com.baidu.tieba.frs.e.b.aiY().a(com.baidu.tieba.frs.e.c.cvL, blVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.aiY().a(com.baidu.tieba.frs.e.c.cvL, blVar, 3);
                            }
                        }
                    } else if (view.getId() == d.h.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.aiY().a(com.baidu.tieba.frs.e.c.cvL, blVar, 5);
                    } else if (view.getId() == d.h.card_frs_god_reply_layout) {
                        com.baidu.tieba.frs.e.b.aiY().a(com.baidu.tieba.frs.e.c.cvL, blVar, 6);
                    } else {
                        com.baidu.tieba.frs.e.b.aiY().a(com.baidu.tieba.frs.e.c.cvL, blVar, 1);
                    }
                }
            }
        };
        this.cnQ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: agV */
            public com.baidu.tbadk.widget.layout.b fT() {
                return new com.baidu.tbadk.widget.layout.b(l.this.alI.getPageActivity());
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
        this.cnR = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xm */
            public TbImageView fT() {
                TbImageView tbImageView = new TbImageView(l.this.alI.getPageActivity());
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
        this.alI = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.coc = new com.baidu.tieba.frs.entelechy.view.l(this.alI, this.mPageId);
        this.coc.setConstrainLayoutPool(this.cnQ);
        this.coc.setConstrainImagePool(this.cnR);
        this.coc.j(this.mPageId);
        this.coc.setVoiceManager(this.ciW);
        this.coc.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.coc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> aVar) {
        if (blVar != null && blVar.rm()) {
            F(blVar);
        }
        if (aVar == null || aVar.Xc() == null) {
            return null;
        }
        aVar.Xc().a(blVar);
        aVar.Xc().setForumName(this.mForumName);
        aVar.Xc().a(this.bkw);
        com.baidu.tieba.frs.e.b.aiY().a(cvL, blVar);
        if (blVar != null) {
            blVar.sD();
        }
        return aVar.getView();
    }

    public void setFromCDN(boolean z) {
        if (this.coc != null) {
            this.coc.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.ciW = voiceManager;
    }
}
