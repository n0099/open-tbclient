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
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.frs.g<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v<bd> ciE;
    private VoiceManager dBC;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dHH;
    private com.baidu.adp.lib.e.b<TbImageView> dHI;
    private com.baidu.tieba.frs.entelechy.view.l dHU;
    private HashSet<String> dHV;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void N(bd bdVar) {
        if (this.dHV == null) {
            this.dHV = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.dHV.contains(bdVar.getTid())) {
            this.dHV.add(bdVar.getTid());
            TiebaStatic.log(new ak("c11662").s("obj_param1", 1).aa("post_id", bdVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ciE = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.e.g.a(com.baidu.tieba.frs.d.c.dRe, bdVar.zs());
                    } else if (view instanceof TbImageView) {
                        if (l.this.ciE.bLL instanceof Boolean) {
                            if (((Boolean) l.this.ciE.bLL).booleanValue()) {
                                com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 3);
                            }
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 5);
                    } else if (view.getId() == d.g.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bdVar.Ah() != null && bdVar.Ah().bvM() != null && bdVar.Ah().bvM().QD() != null && bdVar.Ah().bvM().QD().size() > 0) {
                            i = bdVar.Ah().gZh ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, i);
                    } else {
                        com.baidu.tieba.frs.d.b.ayP().a(com.baidu.tieba.frs.d.c.dRe, bdVar, 1);
                    }
                }
            }
        };
        this.dHH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: awx */
            public com.baidu.tbadk.widget.layout.b nl() {
                return new com.baidu.tbadk.widget.layout.b(l.this.mPageContext.getPageActivity());
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
        this.dHI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ed */
            public TbImageView nl() {
                TbImageView tbImageView = new TbImageView(l.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0108d.common_color_10043));
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
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.dHU = new com.baidu.tieba.frs.entelechy.view.l(this.mPageContext, this.mPageId);
        this.dHU.setConstrainLayoutPool(this.dHH);
        this.dHU.setConstrainImagePool(this.dHI);
        this.dHU.j(this.mPageId);
        this.dHU.setVoiceManager(this.dBC);
        this.dHU.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.dHU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> aVar) {
        if (bdVar != null && bdVar.yA()) {
            N(bdVar);
        }
        if (aVar == null || aVar.alp() == null) {
            return null;
        }
        com.baidu.tieba.frs.f.a(aVar.alp().akL(), this.dBi);
        aVar.alp().a(bdVar);
        aVar.alp().setForumName(this.mForumName);
        aVar.alp().b(this.ciE);
        com.baidu.tieba.frs.d.b.ayP().a(dRe, bdVar);
        if (bdVar != null) {
            bdVar.zP();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.g
    public void setFromCDN(boolean z) {
        if (this.dHU != null) {
            this.dHU.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dBC = voiceManager;
    }
}
