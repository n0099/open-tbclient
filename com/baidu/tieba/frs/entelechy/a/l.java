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
    private v<bd> ciw;
    private VoiceManager dBh;
    private HashSet<String> dHA;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dHm;
    private com.baidu.adp.lib.e.b<TbImageView> dHn;
    private com.baidu.tieba.frs.entelechy.view.l dHz;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void N(bd bdVar) {
        if (this.dHA == null) {
            this.dHA = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.dHA.contains(bdVar.getTid())) {
            this.dHA.add(bdVar.getTid());
            TiebaStatic.log(new ak("c11662").s("obj_param1", 1).ab("post_id", bdVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ciw = new v<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.b.ayK().a(com.baidu.tieba.frs.d.c.dQJ, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.e.g.a(com.baidu.tieba.frs.d.c.dQJ, bdVar.zr());
                    } else if (view instanceof TbImageView) {
                        if (l.this.ciw.bLD instanceof Boolean) {
                            if (((Boolean) l.this.ciw.bLD).booleanValue()) {
                                com.baidu.tieba.frs.d.b.ayK().a(com.baidu.tieba.frs.d.c.dQJ, bdVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.b.ayK().a(com.baidu.tieba.frs.d.c.dQJ, bdVar, 3);
                            }
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.d.b.ayK().a(com.baidu.tieba.frs.d.c.dQJ, bdVar, 5);
                    } else if (view.getId() == d.g.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bdVar.Ag() != null && bdVar.Ag().bvK() != null && bdVar.Ag().bvK().QB() != null && bdVar.Ag().bvK().QB().size() > 0) {
                            i = bdVar.Ag().gYN ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.b.ayK().a(com.baidu.tieba.frs.d.c.dQJ, bdVar, i);
                    } else {
                        com.baidu.tieba.frs.d.b.ayK().a(com.baidu.tieba.frs.d.c.dQJ, bdVar, 1);
                    }
                }
            }
        };
        this.dHm = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aws */
            public com.baidu.tbadk.widget.layout.b nk() {
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
        this.dHn = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Eb */
            public TbImageView nk() {
                TbImageView tbImageView = new TbImageView(l.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(aj.getColor(d.C0107d.common_color_10043));
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
        this.dHz = new com.baidu.tieba.frs.entelechy.view.l(this.mPageContext, this.mPageId);
        this.dHz.setConstrainLayoutPool(this.dHm);
        this.dHz.setConstrainImagePool(this.dHn);
        this.dHz.j(this.mPageId);
        this.dHz.setVoiceManager(this.dBh);
        this.dHz.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.dHz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> aVar) {
        if (bdVar != null && bdVar.yz()) {
            N(bdVar);
        }
        if (aVar == null || aVar.alk() == null) {
            return null;
        }
        com.baidu.tieba.frs.f.a(aVar.alk().akG(), this.dAN);
        aVar.alk().a(bdVar);
        aVar.alk().setForumName(this.mForumName);
        aVar.alk().b(this.ciw);
        com.baidu.tieba.frs.d.b.ayK().a(dQJ, bdVar);
        if (bdVar != null) {
            bdVar.zO();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.g
    public void setFromCDN(boolean z) {
        if (this.dHz != null) {
            this.dHz.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dBh = voiceManager;
    }
}
