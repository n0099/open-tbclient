package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class b extends a<bx, am<by>> {
    private ab<by> agG;
    private com.baidu.adp.lib.d.b<ImageView> fMZ;
    private com.baidu.adp.lib.d.b<GifView> fNa;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext, by.eJd);
        this.fMZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bJz */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(b.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.blV().isShowImages();
                foreDrawableImageView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.blV().isShowImages()) {
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
        this.fNa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cwL */
            public GifView makeObject() {
                GifView gifView = new GifView(b.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.blV().isShowImages();
                gifView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
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
                if (com.baidu.tbadk.core.k.blV().isShowImages()) {
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
                gifView.bDT();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
        }, 20, 0);
        this.agG = new ab<by>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                b.this.f(view, byVar);
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        o oVar = new o(this.mPageContext.getPageActivity());
        oVar.setFrom("index");
        oVar.setFromForPb(2);
        oVar.setObjectPool(this.fMZ, this.fNa);
        oVar.e(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), 0, 0);
        oVar.setFromCDN(isFromCDN());
        oVar.setCornerStyle(1);
        aVar.c(oVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amH);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.b.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bx) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    by byVar = ((bx) qVar).eCR;
                    byVar.objType = 1;
                    if (b.this.agG != null) {
                        b.this.agG.a(amVar2.getView(), byVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), 0, false);
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.hotTopic.tab.a.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, am<by> amVar) {
        if (bxVar == null || amVar == null || amVar.getView() == null || bxVar.eCR == null) {
            return null;
        }
        bxVar.eCR.eHa = getPositionByType(i) + 1;
        amVar.tZ().setPosition(i);
        amVar.b((am<by>) bxVar.eCR);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        a(amVar.getView(), bxVar.eCR, i, i);
        return amVar.getView();
    }
}
