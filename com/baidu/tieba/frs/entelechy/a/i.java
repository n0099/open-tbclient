package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class i extends com.baidu.tieba.frs.f<bd, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.frs.e.c {
    private ab<bd> bwL;
    private String bwO;
    private VoiceManager cYn;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> deO;
    private com.baidu.adp.lib.e.b<TbImageView> deP;
    private com.baidu.tieba.frs.entelechy.view.e deZ;
    private HashSet<String> dfa;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void R(bd bdVar) {
        if (this.dfa == null) {
            this.dfa = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.dfa.contains(bdVar.getTid())) {
            this.dfa.add(bdVar.getTid());
            TiebaStatic.log(new al("c11662").r("obj_param1", 1).ac("post_id", bdVar.getTid()));
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.bwL = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, bd bdVar) {
                if (view2 != null && bdVar != null) {
                    if ("c13010".equals(i.this.mFrom)) {
                        TiebaStatic.log(new al("c13010").r("obj_type", 1).f(ImageViewerConfig.FORUM_ID, bdVar.getFid()).ac("tid", bdVar.getTid()));
                    }
                    if (view2.getId() == d.g.card_home_page_normal_thread_user_name || (view2 instanceof HeadImageView) || (view2 instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, 2);
                    } else if (view2.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.g.a(com.baidu.tieba.frs.e.c.dpD, bdVar.sm());
                    } else if (view2 instanceof TbImageView) {
                        if (i.this.bwL.aXE instanceof Boolean) {
                            if (((Boolean) i.this.bwL.aXE).booleanValue()) {
                                com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, 3);
                            }
                        }
                    } else if (view2.getId() == d.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, 5);
                    } else if (view2.getId() == d.g.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bdVar.tb() != null && bdVar.tb().brZ() != null && bdVar.tb().brZ().JH() != null && bdVar.tb().brZ().JH().size() > 0) {
                            i = bdVar.tb().gyb ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, i);
                    } else {
                        com.baidu.tieba.frs.e.b.auG().a(com.baidu.tieba.frs.e.c.dpD, bdVar, 1);
                    }
                }
            }
        };
        this.deO = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: arT */
            public ConstrainImageLayout fo() {
                return new ConstrainImageLayout(i.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void n(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout o(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout p(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.deP = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: xh */
            public TbImageView fo() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
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
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.deZ = new com.baidu.tieba.frs.entelechy.view.e(this.mPageContext, this.mPageId);
        this.deZ.setConstrainLayoutPool(this.deO);
        this.deZ.setConstrainImagePool(this.deP);
        this.deZ.j(this.mPageId);
        this.deZ.setVoiceManager(this.cYn);
        this.deZ.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.deZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> aVar) {
        if (bdVar != null && bdVar.ry()) {
            R(bdVar);
        }
        if (aVar == null || aVar.afY() == null) {
            return null;
        }
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bwO);
        }
        com.baidu.tieba.frs.e.a(aVar.afY().afz(), this.cXS);
        com.baidu.tieba.frs.e.a(aVar.afY().afA(), this.cXS);
        if (this.cXS != null && this.cXS.aVq() != null && !StringUtils.isNull(this.cXS.aVq().getTopic_special_icon()) && !StringUtils.isNull(this.cXS.aVq().getTopic_special_icon_right())) {
            aVar.afY().M(this.cXS.aVq().getTopic_special_icon(), this.cXS.aVq().getTopic_special_icon_right());
        }
        aVar.afY().a(bdVar);
        aVar.afY().setForumName(this.mForumName);
        aVar.afY().b(this.bwL);
        com.baidu.tieba.frs.e.b.auG().a(dpD, bdVar);
        if (bdVar != null) {
            bdVar.sJ();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.f
    public void setFromCDN(boolean z) {
        if (this.deZ != null) {
            this.deZ.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cYn = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void hZ(String str) {
        this.bwO = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }
}
