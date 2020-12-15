package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agG;
    private String aiw;
    private boolean alo;
    private com.baidu.adp.widget.ListView.v amH;
    private com.baidu.adp.lib.d.b<ImageView> fMZ;
    private com.baidu.adp.lib.d.b<GifView> fNa;
    public BdUniqueId fzO;
    private com.baidu.tieba.homepage.personalize.model.e jSQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alo = true;
        this.fMZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bJz */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(h.this.mPageContext.getPageActivity());
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
        this.fNa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.homepage.personalize.a.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cwL */
            public GifView makeObject() {
                GifView gifView = new GifView(h.this.mPageContext.getPageActivity());
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
        this.agG = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                com.baidu.tieba.card.t.csh().mj(true);
                com.baidu.tieba.a.d.bLU().dS("page_recommend", "show_");
                if (view != null && h.this.jSQ != null && kVar != null && kVar.bmn() != null && !StringUtils.isNull(kVar.bmn().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gA(com.baidu.adp.lib.f.b.toLong(kVar.bmn().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gz(com.baidu.adp.lib.f.b.toLong(kVar.bmn().getTid(), 0L));
                        h.this.jSQ.a(com.baidu.adp.lib.f.b.toLong(kVar.bmn().getTid(), 0L), kVar.getWeight(), kVar.getSource(), kVar.cst(), kVar.csu(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", kVar.bmn().getBaijiahaoData());
                    }
                    h.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cNQ();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.amH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(kVar.csA());
            com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csA());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(kVar.csI());
            com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csI());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(kVar.csI());
            com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csI());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(kVar.csz());
            com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csz());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            ar arVar = new ar("c10760");
            arVar.al("obj_locate", 2);
            TiebaStatic.log(arVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            ar arVar2 = new ar("c10760");
            arVar2.al("obj_locate", 1);
            TiebaStatic.log(arVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                ar arVar3 = new ar("c10760");
                arVar3.al("obj_locate", 3);
                TiebaStatic.log(arVar3);
            }
            TiebaStatic.log(kVar.csJ());
            com.baidu.tieba.a.d.bLU().a("page_recommend", "clk_", kVar.csJ());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, this.fzO, kVar.cst(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFrom("index");
        oVar.setFromForPb(2);
        oVar.setObjectPool(this.fMZ, this.fNa);
        oVar.e(0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), 0, 0);
        oVar.setFromCDN(this.alo);
        oVar.setCornerStyle(1);
        aVar.c(oVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amH);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.h.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) qVar;
                    kVar.objType = 1;
                    if (h.this.agG != null) {
                        h.this.agG.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 2, false);
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, am<com.baidu.tieba.card.data.k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.eCR == null) {
            return null;
        }
        kVar.ym(kVar.position + 1);
        amVar.tZ().setPosition(i);
        amVar.tZ().setPage(this.aiw);
        amVar.b((am<com.baidu.tieba.card.data.k>) kVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        com.baidu.tieba.card.t.csh().e(kVar.csC());
        com.baidu.tieba.a.d.bLU().e(kVar.csC());
        com.baidu.tieba.homepage.personalize.c.a.a(kVar.eCR, this.fzO, kVar.cst());
        return amVar.getView();
    }

    private void cNQ() {
        com.baidu.tieba.card.data.k.imW = "c10705";
        com.baidu.tieba.card.data.k.imX = "c10730";
        com.baidu.tieba.card.data.k.imY = "c10731";
        com.baidu.tieba.card.data.k.imZ = "c10704";
        com.baidu.tieba.card.data.k.ina = "c10755";
        com.baidu.tieba.card.data.k.inb = "c10710";
        com.baidu.tieba.card.data.k.inc = "c10736";
        com.baidu.tieba.card.data.k.ind = "c10737";
        com.baidu.tieba.card.data.k.ine = "c10711";
        com.baidu.tieba.card.data.k.inf = "c10758";
        com.baidu.tieba.card.data.k.ing = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jSQ = eVar;
    }
}
