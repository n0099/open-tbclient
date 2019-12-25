package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> Jy;
    private String La;
    private boolean Nf;
    private com.baidu.adp.widget.ListView.r Ol;
    private com.baidu.adp.lib.d.b<ImageView> dHY;
    private com.baidu.adp.lib.d.b<GifView> dHZ;
    public BdUniqueId dwY;
    private com.baidu.tieba.homepage.personalize.model.e gXL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Nf = true;
        this.dHY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: aRZ */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(e.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.i.axf().isShowImages();
                foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                if (isShowImages) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                    foreDrawableImageView.setAdjustViewBounds(true);
                    foreDrawableImageView.setInterceptOnClick(true);
                }
                return foreDrawableImageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(ImageView imageView) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    ((ForeDrawableImageView) imageView).stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public ImageView activateObject(ImageView imageView) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (com.baidu.tbadk.core.i.axf().isShowImages()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(R.drawable.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public ImageView passivateObject(ImageView imageView) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    ((ForeDrawableImageView) imageView).stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.reset();
                }
                return imageView;
            }
        }, 12, 0);
        this.dHZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.homepage.personalize.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bEt */
            public GifView makeObject() {
                GifView gifView = new GifView(e.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.i.axf().isShowImages();
                gifView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                if (isShowImages) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: g */
            public void destroyObject(GifView gifView) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.onDestroy();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: h */
            public GifView activateObject(GifView gifView) {
                gifView.setTag(null);
                if (com.baidu.tbadk.core.i.axf().isShowImages()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: i */
            public GifView passivateObject(GifView gifView) {
                gifView.release();
                gifView.onDestroy();
                gifView.setImageDrawable(null);
                gifView.aMX();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
        }, 20, 0);
        this.Jy = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.bsy().hK(true);
                com.baidu.tieba.a.d.aUV().cm("page_recommend", "show_");
                if (view != null && e.this.gXL != null && kVar != null && kVar.axx() != null && !StringUtils.isNull(kVar.axx().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dy(com.baidu.adp.lib.f.b.toLong(kVar.axx().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dx(com.baidu.adp.lib.f.b.toLong(kVar.axx().getTid(), 0L));
                        e.this.gXL.a(com.baidu.adp.lib.f.b.toLong(kVar.axx().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.bsI(), kVar.bsJ(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.axx().getBaijiahaoData());
                    }
                    e.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bMk();
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.Ol = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.bsU());
            com.baidu.tieba.a.d.aUV().a("page_recommend", "clk_", kVar.bsU());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bsW());
            com.baidu.tieba.a.d.aUV().a("page_recommend", "clk_", kVar.bsW());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bsW());
            com.baidu.tieba.a.d.aUV().a("page_recommend", "clk_", kVar.bsW());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.bsV());
            com.baidu.tieba.a.d.aUV().a("page_recommend", "clk_", kVar.bsV());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            an anVar = new an("c10760");
            anVar.Z("obj_locate", 2);
            TiebaStatic.log(anVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar2 = new an("c10760");
            anVar2.Z("obj_locate", 1);
            TiebaStatic.log(anVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                an anVar3 = new an("c10760");
                anVar3.Z("obj_locate", 3);
                TiebaStatic.log(anVar3);
            }
            TiebaStatic.log(kVar.bsX());
            com.baidu.tieba.a.d.aUV().a("page_recommend", "clk_", kVar.bsX());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.cMR, this.dwY, kVar.bsI(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFrom("index");
        lVar.setObjectPool(this.dHY, this.dHZ);
        lVar.e(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), 0, 0);
        lVar.setFromCDN(this.Nf);
        lVar.setCornerStyle(1);
        aVar.c(lVar);
        ad a = aVar.a(false, viewGroup, this.Ol);
        a.aM(2);
        af afVar = new af(a);
        afVar.setPageId(this.dwY);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.e.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (e.this.Jy != null) {
                        e.this.Jy.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    afVar2.mT().b(new a.C0050a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cMR == null) {
            return null;
        }
        kVar.rh(kVar.position + 1);
        afVar.mT().setPosition(i);
        afVar.mT().setPage(this.La);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.mT().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mT().a(this.Jy);
        com.baidu.tieba.card.r.bsy().c(kVar.bsT());
        com.baidu.tieba.a.d.aUV().c(kVar.bsT());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.cMR, this.dwY, kVar.bsI());
        return afVar.getView();
    }

    private void bMk() {
        com.baidu.tieba.card.data.k.fGW = "c10705";
        com.baidu.tieba.card.data.k.fGX = "c10730";
        com.baidu.tieba.card.data.k.fGY = "c10731";
        com.baidu.tieba.card.data.k.fGZ = "c10704";
        com.baidu.tieba.card.data.k.fHa = "c10755";
        com.baidu.tieba.card.data.k.fHb = "c10710";
        com.baidu.tieba.card.data.k.fHc = "c10736";
        com.baidu.tieba.card.data.k.fHd = "c10737";
        com.baidu.tieba.card.data.k.fHe = "c10711";
        com.baidu.tieba.card.data.k.fHf = "c10758";
        com.baidu.tieba.card.data.k.fHg = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void wq(String str) {
        this.La = str;
    }

    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.gXL = eVar;
    }
}
