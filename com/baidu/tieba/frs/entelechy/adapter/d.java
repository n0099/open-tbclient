package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.frs.k<by, ThreadCardViewHolder<bz>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.b.d {
    private com.baidu.tieba.card.aa<bz> ahf;
    private String aji;
    private boolean alQ;
    private com.baidu.adp.lib.d.b<ImageView> fWD;
    private com.baidu.adp.lib.d.b<GifView> fWE;
    private int jpm;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jpm = 3;
        this.alQ = true;
        this.fWD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bLR */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(d.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.bou().isShowImages();
                foreDrawableImageView.setDefaultBg(ao.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.bou().isShowImages()) {
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
        this.fWE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: czE */
            public GifView makeObject() {
                GifView gifView = new GifView(d.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.bou().isShowImages();
                gifView.setDefaultBg(ao.getDrawable(R.color.common_color_10220));
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
                if (com.baidu.tbadk.core.k.bou().isShowImages()) {
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
                gifView.bGn();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
        }, 20, 0);
        this.ahf = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    com.baidu.tieba.a.d.bOm().dR("page_frs", "show_");
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<bz> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFrom("frs");
        oVar.setFromForPb(2);
        oVar.setObjectPool(this.fWD, this.fWE);
        oVar.e(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), 0, 0);
        oVar.setFromCDN(this.alQ);
        oVar.setCornerStyle(1);
        if (this.jpm == 502) {
            oVar.setNeedFrsTabName(false);
        } else {
            oVar.setNeedFrsTabName(true);
        }
        aVar.c(oVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.iKI);
        a2.setSourceForPb(3);
        ThreadCardViewHolder<bz> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        threadCardViewHolder.aL(false);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.d.4
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar).eMv;
                    bzVar.objType = 1;
                    if (d.this.ahf != null) {
                        d.this.ahf.a(threadCardViewHolder2.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), d.this.jpm, false);
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, ThreadCardViewHolder<bz> threadCardViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) threadCardViewHolder);
        if (byVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || byVar.eMv == null) {
            return null;
        }
        threadCardViewHolder.ty().setPage(this.aji);
        threadCardViewHolder.ty().setPosition(i);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.ty().ts(), this.jeH);
        if (this.jeH != null && this.jeH.getForum() != null && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon_right())) {
            byVar.eMv.dK(this.jeH.getForum().getTopic_special_icon(), this.jeH.getForum().getTopic_special_icon_right());
        }
        threadCardViewHolder.b((ThreadCardViewHolder<bz>) byVar.eMv);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        byVar.eMv.bsE();
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    @Override // com.baidu.tieba.a.f
    public void Fm(String str) {
        this.aji = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
        this.jpm = i;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return jpq;
    }
}
