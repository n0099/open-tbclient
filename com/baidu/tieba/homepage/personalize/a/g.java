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
/* loaded from: classes9.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> ada;
    private String aeB;
    private boolean agw;
    private com.baidu.adp.widget.ListView.r ahy;
    public BdUniqueId ebA;
    private com.baidu.adp.lib.d.b<ImageView> emM;
    private com.baidu.adp.lib.d.b<GifView> emN;
    private com.baidu.tieba.homepage.personalize.model.e hOH;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agw = true;
        this.emM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bcZ */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(g.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.i.aIc().isShowImages();
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
                    if (com.baidu.tbadk.core.i.aIc().isShowImages()) {
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
        this.emN = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.homepage.personalize.a.g.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bJu */
            public GifView makeObject() {
                GifView gifView = new GifView(g.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.i.aIc().isShowImages();
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
                if (com.baidu.tbadk.core.i.aIc().isShowImages()) {
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
                gifView.aYi();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
        }, 20, 0);
        this.ada = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.g.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.r.bEW().jd(true);
                com.baidu.tieba.a.d.bfN().cF("page_recommend", "show_");
                if (view != null && g.this.hOH != null && kVar != null && kVar.aIu() != null && !StringUtils.isNull(kVar.aIu().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.em(com.baidu.adp.lib.f.b.toLong(kVar.aIu().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.el(com.baidu.adp.lib.f.b.toLong(kVar.aIu().getTid(), 0L));
                        g.this.hOH.a(com.baidu.adp.lib.f.b.toLong(kVar.aIu().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.bFf(), kVar.bFg(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.aIu().getBaijiahaoData());
                    }
                    g.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        bZK();
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.ahy = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.bFr());
            com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFr());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.bFt());
            com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFt());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.bFt());
            com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFt());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.bFs());
            com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFs());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            an anVar = new an("c10760");
            anVar.af("obj_locate", 2);
            TiebaStatic.log(anVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar2 = new an("c10760");
            anVar2.af("obj_locate", 1);
            TiebaStatic.log(anVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                an anVar3 = new an("c10760");
                anVar3.af("obj_locate", 3);
                TiebaStatic.log(anVar3);
            }
            TiebaStatic.log(kVar.bFu());
            com.baidu.tieba.a.d.bfN().a("page_recommend", "clk_", kVar.bFu());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.dqE, this.ebA, kVar.bFf(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFrom("index");
        lVar.setObjectPool(this.emM, this.emN);
        lVar.e(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), 0, 0);
        lVar.setFromCDN(this.agw);
        lVar.setCornerStyle(1);
        aVar.c(lVar);
        com.baidu.card.ad a = aVar.a(false, viewGroup, this.ahy);
        a.bc(2);
        af afVar = new af(a);
        afVar.setPageId(this.ebA);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.homepage.personalize.a.g.4
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (g.this.ada != null) {
                        g.this.ada.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    afVar2.rD().b(new a.C0095a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.dqE == null) {
            return null;
        }
        kVar.rN(kVar.position + 1);
        afVar.rD().setPosition(i);
        afVar.rD().setPage(this.aeB);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.ada);
        com.baidu.tieba.card.r.bEW().e(kVar.bFq());
        com.baidu.tieba.a.d.bfN().e(kVar.bFq());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.dqE, this.ebA, kVar.bFf());
        return afVar.getView();
    }

    private void bZK() {
        com.baidu.tieba.card.data.k.gsm = "c10705";
        com.baidu.tieba.card.data.k.gsn = "c10730";
        com.baidu.tieba.card.data.k.gso = "c10731";
        com.baidu.tieba.card.data.k.gsp = "c10704";
        com.baidu.tieba.card.data.k.gsq = "c10755";
        com.baidu.tieba.card.data.k.gsr = "c10710";
        com.baidu.tieba.card.data.k.gss = "c10736";
        com.baidu.tieba.card.data.k.gst = "c10737";
        com.baidu.tieba.card.data.k.gsu = "c10711";
        com.baidu.tieba.card.data.k.gsv = "c10758";
        com.baidu.tieba.card.data.k.gsw = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }

    public void setFromCDN(boolean z) {
        this.agw = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hOH = eVar;
    }
}
