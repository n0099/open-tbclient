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
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class k extends com.baidu.tieba.frs.g<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l>> implements t, u, com.baidu.tieba.frs.e.c {
    private v<bd> clK;
    private int clN;
    private VoiceManager dEn;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dKG;
    private com.baidu.adp.lib.e.b<TbImageView> dKH;
    private com.baidu.tieba.frs.entelechy.view.l dKR;
    private HashSet<String> dKS;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void Q(bd bdVar) {
        if (this.dKS == null) {
            this.dKS = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.dKS.contains(bdVar.getTid())) {
            this.dKS.add(bdVar.getTid());
            TiebaStatic.log(new ak("c11662").s("obj_param1", 1).ab("post_id", bdVar.getTid()));
        }
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.clN = 0;
        this.clK = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.azS().a(com.baidu.tieba.frs.e.c.dUj, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.dUj, bdVar.zM());
                    } else if (view instanceof TbImageView) {
                        if (k.this.clK.bNF instanceof Boolean) {
                            if (((Boolean) k.this.clK.bNF).booleanValue()) {
                                com.baidu.tieba.frs.e.b.azS().a(com.baidu.tieba.frs.e.c.dUj, bdVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.azS().a(com.baidu.tieba.frs.e.c.dUj, bdVar, 3);
                            }
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.azS().a(com.baidu.tieba.frs.e.c.dUj, bdVar, 5);
                    } else if (view.getId() == d.g.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bdVar.AA() != null && bdVar.AA().bxb() != null && bdVar.AA().bxb().Ri() != null && bdVar.AA().bxb().Ri().size() > 0) {
                            i = bdVar.AA().hbE ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.azS().a(com.baidu.tieba.frs.e.c.dUj, bdVar, i);
                    } else {
                        com.baidu.tieba.frs.e.b.azS().a(com.baidu.tieba.frs.e.c.dUj, bdVar, 1);
                    }
                }
            }
        };
        this.dKG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axx */
            public com.baidu.tbadk.widget.layout.b nl() {
                return new com.baidu.tbadk.widget.layout.b(k.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void as(com.baidu.tbadk.widget.layout.b bVar) {
                bVar.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public com.baidu.tbadk.widget.layout.b at(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public com.baidu.tbadk.widget.layout.b au(com.baidu.tbadk.widget.layout.b bVar) {
                return bVar;
            }
        }, 6, 0);
        this.dKH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ey */
            public TbImageView nl() {
                TbImageView tbImageView = new TbImageView(k.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0141d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView at(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView au(TbImageView tbImageView) {
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
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.dKR = new com.baidu.tieba.frs.entelechy.view.l(this.mPageContext, this.mPageId);
        this.dKR.setConstrainLayoutPool(this.dKG);
        this.dKR.setConstrainImagePool(this.dKH);
        this.dKR.j(this.mPageId);
        this.dKR.setVoiceManager(this.dEn);
        this.dKR.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.dKR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> aVar) {
        if (bdVar != null && bdVar.yU()) {
            Q(bdVar);
        }
        if (aVar == null || aVar.alY() == null) {
            return null;
        }
        if (bdVar != null) {
            bdVar.aQp = this.clN;
        }
        com.baidu.tieba.frs.f.a(aVar.alY().alu(), this.dDS);
        com.baidu.tieba.frs.f.a(aVar.alY().alv(), this.dDS);
        aVar.alY().a(bdVar);
        aVar.alY().setForumName(this.mForumName);
        aVar.alY().b(this.clK);
        com.baidu.tieba.frs.e.b.azS().a(dUj, bdVar);
        if (bdVar != null) {
            bdVar.Ai();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.g
    public void setFromCDN(boolean z) {
        if (this.dKR != null) {
            this.dKR.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dEn = voiceManager;
    }

    @Override // com.baidu.tieba.card.u
    public void setCardShowType(int i) {
        this.clN = i;
    }
}
