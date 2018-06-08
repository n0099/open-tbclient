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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
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
    private ab<bd> bEO;
    private String bER;
    private VoiceManager dhB;
    private com.baidu.adp.lib.e.b<ConstrainImageLayout> dod;
    private com.baidu.adp.lib.e.b<TbImageView> doe;
    private com.baidu.tieba.frs.entelechy.view.e doo;
    private HashSet<String> dop;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    private void R(bd bdVar) {
        if (this.dop == null) {
            this.dop = new HashSet<>();
        }
        if (bdVar.getTid() != null && !this.dop.contains(bdVar.getTid())) {
            this.dop.add(bdVar.getTid());
            TiebaStatic.log(new am("c11662").r("obj_param1", 1).ah("post_id", bdVar.getTid()));
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.bEO = new ab<bd>() { // from class: com.baidu.tieba.frs.entelechy.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bd bdVar) {
                if (view != null && bdVar != null) {
                    if (i.this.dhm != null) {
                        i.this.dhm.a(view, bdVar, i.this.getType());
                    }
                    if ("c13010".equals(i.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").r("obj_type", 1).f(ImageViewerConfig.FORUM_ID, bdVar.getFid()).ah("tid", bdVar.getTid()));
                    }
                    if (view.getId() == d.g.card_home_page_normal_thread_user_name || (view instanceof HeadImageView) || (view instanceof HeadPendantView)) {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 2);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.e.c.dyP, bdVar.vJ());
                    } else if (view instanceof TbImageView) {
                        if (i.this.bEO.bfL instanceof Boolean) {
                            if (((Boolean) i.this.bEO.bfL).booleanValue()) {
                                com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 1);
                            } else {
                                com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 3);
                            }
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_abstract_voice) {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 5);
                    } else if (view.getId() == d.g.card_frs_god_reply_layout) {
                        int i = 6;
                        if (bdVar.wy() != null && bdVar.wy().bxb() != null && bdVar.wy().bxb().Ng() != null && bdVar.wy().bxb().Ng().size() > 0) {
                            i = bdVar.wy().gJA ? 9 : 8;
                        }
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, i);
                    } else {
                        com.baidu.tieba.frs.e.b.ayQ().a(com.baidu.tieba.frs.e.c.dyP, bdVar, 1);
                    }
                }
            }
        };
        this.dod = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ConstrainImageLayout>() { // from class: com.baidu.tieba.frs.entelechy.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: avY */
            public ConstrainImageLayout mo9if() {
                return new ConstrainImageLayout(i.this.mPageContext.getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void q(ConstrainImageLayout constrainImageLayout) {
                constrainImageLayout.removeAllViews();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public ConstrainImageLayout r(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public ConstrainImageLayout s(ConstrainImageLayout constrainImageLayout) {
                return constrainImageLayout;
            }
        }, 6, 0);
        this.doe = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<TbImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: AI */
            public TbImageView mo9if() {
                TbImageView tbImageView = new TbImageView(i.this.mPageContext.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(al.getColor(d.C0141d.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1));
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(TbImageView tbImageView) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public TbImageView r(TbImageView tbImageView) {
                return tbImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public TbImageView s(TbImageView tbImageView) {
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
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.doo = new com.baidu.tieba.frs.entelechy.view.e(this.mPageContext, this.mPageId);
        this.doo.setConstrainLayoutPool(this.dod);
        this.doo.setConstrainImagePool(this.doe);
        this.doo.j(this.mPageId);
        this.doo.setVoiceManager(this.dhB);
        this.doo.setSingleImageRatio(0.75d);
        return new com.baidu.tieba.card.a.a<>(this.doo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bd bdVar, com.baidu.tieba.card.a.a<com.baidu.tieba.frs.entelechy.view.e> aVar) {
        super.onFillViewHolder(i, view, viewGroup, bdVar, aVar);
        if (bdVar != null && bdVar.uU()) {
            R(bdVar);
        }
        if (aVar == null || aVar.ajG() == null) {
            return null;
        }
        if (aVar.ajG() instanceof com.baidu.tieba.a.e) {
            aVar.ajG().setPage(this.bER);
        }
        com.baidu.tieba.frs.e.a(aVar.ajG().UW(), this.dhf);
        com.baidu.tieba.frs.e.a(aVar.ajG().UX(), this.dhf);
        if (this.dhf != null && this.dhf.bam() != null && !StringUtils.isNull(this.dhf.bam().getTopic_special_icon()) && !StringUtils.isNull(this.dhf.bam().getTopic_special_icon_right())) {
            aVar.ajG().P(this.dhf.bam().getTopic_special_icon(), this.dhf.bam().getTopic_special_icon_right());
        }
        aVar.ajG().a(bdVar);
        aVar.ajG().setForumName(this.mForumName);
        aVar.ajG().b(this.bEO);
        com.baidu.tieba.frs.e.b.ayQ().a(dyP, bdVar);
        if (bdVar != null) {
            bdVar.wg();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.f
    public void setFromCDN(boolean z) {
        if (this.doo != null) {
            this.doo.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.card.aa
    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dhB = voiceManager;
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }
}
