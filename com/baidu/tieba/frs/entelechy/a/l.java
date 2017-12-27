package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
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
public class l extends com.baidu.tieba.frs.g<be, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l>> implements com.baidu.tieba.card.u, com.baidu.tieba.frs.d.c {
    private v<be> cip;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> dCL;
    private com.baidu.adp.lib.e.b<TbImageView> dCM;
    private com.baidu.tieba.frs.entelechy.view.l dCY;
    private HashSet<String> dCZ;
    private VoiceManager dwG;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    private void N(be beVar) {
        if (this.dCZ == null) {
            this.dCZ = new HashSet<>();
        }
        if (beVar.getTid() != null && !this.dCZ.contains(beVar.getTid())) {
            this.dCZ.add(beVar.getTid());
            TiebaStatic.log(new ak("c11662").s("obj_param1", 1).ab("post_id", beVar.getTid()));
        }
    }

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.cip = new v<be>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                if (view != null && beVar != null) {
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.e.g.a(com.baidu.tieba.frs.d.c.dMh, beVar.zw());
                    } else if (view instanceof TbImageView) {
                        if (l.this.cip.bLv instanceof Boolean) {
                            if (((Boolean) l.this.cip.bLv).booleanValue()) {
                                com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 3);
                            }
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 5);
                    } else if (view.getId() == d.g.card_frs_god_reply_layout) {
                        int i = 6;
                        if (beVar.Ao() != null && beVar.Ao().bCo() != null && beVar.Ao().bCo().QN() != null && beVar.Ao().bCo().QN().size() > 0) {
                            i = beVar.Ao().hjn ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, i);
                    } else {
                        com.baidu.tieba.frs.d.b.axH().a(com.baidu.tieba.frs.d.c.dMh, beVar, 1);
                    }
                }
            }
        };
        this.dCL = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<com.baidu.tbadk.widget.layout.b>() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avp */
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
        this.dCM = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: Ek */
            public TbImageView nk() {
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
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.dCY = new com.baidu.tieba.frs.entelechy.view.l(this.mPageContext, this.mPageId);
        this.dCY.setConstrainLayoutPool(this.dCL);
        this.dCY.setConstrainImagePool(this.dCM);
        this.dCY.j(this.mPageId);
        this.dCY.setVoiceManager(this.dwG);
        this.dCY.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.dCY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, be beVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.l> aVar) {
        if (beVar != null && beVar.yC()) {
            N(beVar);
        }
        if (aVar == null || aVar.akh() == null) {
            return null;
        }
        com.baidu.tieba.frs.f.a(aVar.akh().ajD(), this.dwm);
        aVar.akh().a(beVar);
        aVar.akh().setForumName(this.mForumName);
        aVar.akh().b(this.cip);
        com.baidu.tieba.frs.d.b.axH().a(dMh, beVar);
        if (beVar != null) {
            beVar.zW();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.g
    public void setFromCDN(boolean z) {
        if (this.dCY != null) {
            this.dCY.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.u
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dwG = voiceManager;
    }
}
