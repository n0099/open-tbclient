package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.t;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<ca, ThreadCardViewHolder<cb>> {
    private ab<cb> agg;
    private boolean akO;
    private s amk;
    public BdUniqueId fGZ;
    private com.baidu.adp.lib.d.b<ImageView> fUl;
    private com.baidu.adp.lib.d.b<GifView> fUm;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akO = true;
        this.fUl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.homepage.tabfeed.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bIt */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(e.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.bkT().isShowImages();
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
            /* renamed from: c */
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
            /* renamed from: d */
            public ImageView activateObject(ImageView imageView) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
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
            /* renamed from: e */
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
        this.fUm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.homepage.tabfeed.a.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cxg */
            public GifView makeObject() {
                GifView gifView = new GifView(e.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.bkT().isShowImages();
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
                if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
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
                gifView.bCN();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
        }, 20, 0);
        this.agg = new ab<cb>() { // from class: com.baidu.tieba.homepage.tabfeed.a.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                t.csB().mG(true);
                com.baidu.tieba.homepage.tabfeed.b.a(view, cbVar, e.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.fGZ = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(s sVar) {
        this.amk = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFrom("index");
        oVar.setFromForPb(2);
        oVar.setObjectPool(this.fUl, this.fUm);
        oVar.e(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), 0, 0);
        oVar.setFromCDN(this.akO);
        oVar.setCornerStyle(1);
        aVar.c(oVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amk);
        a2.setSourceForPb(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new w() { // from class: com.baidu.tieba.homepage.tabfeed.a.e.4
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = ((ca) nVar).eJQ;
                    cbVar.objType = 1;
                    if (e.this.agg != null) {
                        e.this.agg.a(threadCardViewHolder2.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), 2, false);
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, ThreadCardViewHolder<cb> threadCardViewHolder) {
        if (caVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || caVar.eJQ == null) {
            return null;
        }
        caVar.eJQ.eOs = getPositionByType(i) + 1;
        threadCardViewHolder.tj().setPosition(i);
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) caVar.eJQ);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.agg);
        com.baidu.tieba.homepage.tabfeed.b.a(caVar, this.mTabName);
        return threadCardViewHolder.getView();
    }
}
