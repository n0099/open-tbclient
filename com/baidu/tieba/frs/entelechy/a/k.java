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
    private v<bd> clT;
    private int clW;
    private VoiceManager dEw;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dKN;
    private com.baidu.adp.lib.e.b<TbImageView> dKO;
    private com.baidu.tieba.frs.entelechy.view.l dKY;
    private HashSet<String> dKZ;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void Q(bd bdVar) {
        if (this.dKZ == null) {
            this.dKZ = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.dKZ.contains(bdVar.getTid())) {
            this.dKZ.add(bdVar.getTid());
            TiebaStatic.log(new ak("c11662").s("obj_param1", 1).ab("post_id", bdVar.getTid()));
        }
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.clW = 0;
        this.clT = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.azR().a(com.baidu.tieba.frs.e.c.dUq, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.dUq, bdVar.zM());
                    } else if (view instanceof TbImageView) {
                        if (k.this.clT.bNP instanceof Boolean) {
                            if (((Boolean) k.this.clT.bNP).booleanValue()) {
                                com.baidu.tieba.frs.e.b.azR().a(com.baidu.tieba.frs.e.c.dUq, bdVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.azR().a(com.baidu.tieba.frs.e.c.dUq, bdVar, 3);
                            }
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.azR().a(com.baidu.tieba.frs.e.c.dUq, bdVar, 5);
                    } else if (view.getId() == d.g.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bdVar.AA() != null && bdVar.AA().bwX() != null && bdVar.AA().bwX().Ri() != null && bdVar.AA().bwX().Ri().size() > 0) {
                            i = bdVar.AA().hbv ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.azR().a(com.baidu.tieba.frs.e.c.dUq, bdVar, i);
                    } else {
                        com.baidu.tieba.frs.e.b.azR().a(com.baidu.tieba.frs.e.c.dUq, bdVar, 1);
                    }
                }
            }
        };
        this.dKN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: axw */
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
        this.dKO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.k.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ey */
            public TbImageView nl() {
                TbImageView tbImageView = new TbImageView(k.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0140d.common_color_10043));
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
        this.dKY = new com.baidu.tieba.frs.entelechy.view.l(this.mPageContext, this.mPageId);
        this.dKY.setConstrainLayoutPool(this.dKN);
        this.dKY.setConstrainImagePool(this.dKO);
        this.dKY.j(this.mPageId);
        this.dKY.setVoiceManager(this.dEw);
        this.dKY.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.dKY);
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
            bdVar.aQz = this.clW;
        }
        com.baidu.tieba.frs.f.a(aVar.alY().alu(), this.dEb);
        com.baidu.tieba.frs.f.a(aVar.alY().alv(), this.dEb);
        aVar.alY().a(bdVar);
        aVar.alY().setForumName(this.mForumName);
        aVar.alY().b(this.clT);
        com.baidu.tieba.frs.e.b.azR().a(dUq, bdVar);
        if (bdVar != null) {
            bdVar.Ai();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.g
    public void setFromCDN(boolean z) {
        if (this.dKY != null) {
            this.dKY.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.t
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dEw = voiceManager;
    }

    @Override // com.baidu.tieba.card.u
    public void setCardShowType(int i) {
        this.clW = i;
    }
}
