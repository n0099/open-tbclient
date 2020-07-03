package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ak<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.k> adX;
    private String afG;
    private boolean aik;
    private com.baidu.adp.widget.ListView.v ajy;
    private com.baidu.adp.lib.d.b<ImageView> eLl;
    private com.baidu.adp.lib.d.b<GifView> eLm;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aik = true;
        this.eLl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.homepage.concern.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: blL */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(d.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.aPA().isShowImages();
                foreDrawableImageView.setDefaultBg(an.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.aPA().isShowImages()) {
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
        this.eLm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.homepage.concern.a.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bST */
            public GifView makeObject() {
                GifView gifView = new GifView(d.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.aPA().isShowImages();
                gifView.setDefaultBg(an.getDrawable(R.color.common_color_10220));
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
                if (com.baidu.tbadk.core.k.aPA().isShowImages()) {
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
                gifView.bgx();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
        }, 20, 0);
        this.adX = new aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.aPS() != null && !StringUtils.isNull(kVar.aPS().getTid())) {
                    d.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajy = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
        } else if (view instanceof TbImageView) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, 3);
        } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.m mVar = new com.baidu.card.m(this.mPageContext.getPageActivity());
        mVar.setObjectPool(this.eLl, this.eLm);
        mVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        mVar.setFromForPb(1);
        mVar.setFromCDN(this.aik);
        mVar.setCornerStyle(1);
        aVar.c(mVar);
        ai a = aVar.a(false, viewGroup, this.ajy);
        a.setSourceForPb(1);
        ak akVar = new ak(a);
        akVar.setPageId(this.eyE);
        a(new z() { // from class: com.baidu.tieba.homepage.concern.a.d.4
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (d.this.adX != null) {
                        d.this.adX.a(akVar2.getView(), kVar);
                    }
                    aw.a((AbsThreadDataSupport) kVar, view.getContext(), 1, false);
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ak<com.baidu.tieba.card.data.k> akVar) {
        if (kVar == null || akVar == null || akVar.getView() == null || kVar.dLi == null) {
            return null;
        }
        kVar.sR(kVar.position + 1);
        com.baidu.tieba.card.s.bOA().e(kVar.DU("c12351"));
        akVar.se().setPosition(i);
        if (akVar.se() instanceof com.baidu.tieba.a.e) {
            akVar.se().setPage(this.afG);
        }
        akVar.b((ak<com.baidu.tieba.card.data.k>) kVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.adX);
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }
}
