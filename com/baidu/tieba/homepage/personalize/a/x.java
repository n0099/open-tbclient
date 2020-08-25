package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.am;
import com.baidu.card.ao;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class x extends com.baidu.tieba.homepage.a<com.baidu.tieba.card.data.l, al<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> aeT;
    private String agH;
    private boolean ajr;
    private com.baidu.adp.widget.ListView.v akI;
    public BdUniqueId ePv;
    private com.baidu.adp.lib.d.b<ImageView> fcm;
    private com.baidu.adp.lib.d.b<GifView> fcn;
    private NEGFeedBackView.a flJ;
    private com.baidu.tieba.homepage.personalize.model.e iOg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajr = true;
        this.flJ = null;
        this.fcm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.homepage.personalize.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: byu */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(x.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.bbM().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
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
        }, 8, 0);
        this.fcn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.homepage.personalize.a.x.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cgy */
            public GifView makeObject() {
                GifView gifView = new GifView(x.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.bbM().isShowImages();
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
                if (com.baidu.tbadk.core.k.bbM().isShowImages()) {
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
                gifView.bsU();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
        }, 20, 0);
        this.aeT = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.x.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.cbX().kK(true);
                com.baidu.tieba.a.d.bAA().dA("page_recommend", "show_");
                if (view != null && x.this.iOg != null && lVar != null && lVar.bce() != null && !StringUtils.isNull(lVar.bce().getTid())) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eP(com.baidu.adp.lib.f.b.toLong(lVar.bce().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.eO(com.baidu.adp.lib.f.b.toLong(lVar.bce().getTid(), 0L));
                        x.this.iOg.a(com.baidu.adp.lib.f.b.toLong(lVar.bce().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.ccj(), lVar.cck(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.bce().getBaijiahaoData());
                    }
                    x.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cyk();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.akI = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        int i = 2;
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(lVar.ccw());
            com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", lVar.ccw());
            i = 1;
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(lVar.ccy());
            com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", lVar.ccy());
        } else if (id == R.id.user_name) {
            TiebaStatic.log(lVar.ccy());
            com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", lVar.ccy());
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(lVar.ccx());
            com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", lVar.ccx());
            i = 9;
        } else if (id == R.id.god_reply_content) {
            aq aqVar = new aq("c10760");
            aqVar.ai("obj_locate", 2);
            TiebaStatic.log(aqVar);
            i = 5;
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            aq aqVar2 = new aq("c10760");
            aqVar2.ai("obj_locate", 1);
            TiebaStatic.log(aqVar2);
            i = 5;
        } else if (!(view instanceof TbImageView)) {
            i = 0;
        } else {
            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                aq aqVar3 = new aq("c10760");
                aqVar3.ai("obj_locate", 3);
                TiebaStatic.log(aqVar3);
            }
            TiebaStatic.log(lVar.ccz());
            com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", lVar.ccz());
            i = 3;
        }
        if (i != 0) {
            com.baidu.tieba.homepage.personalize.c.a.a(lVar.dUS, this.ePv, lVar.ccj(), i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ePv);
        eVar.bl(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.x.4
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.ae aeVar = new com.baidu.card.ae(this.mPageContext);
        aeVar.b((Boolean) false);
        aeVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds15));
        aeVar.setFrom("index");
        aVar.c(aeVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFrom("index");
        nVar.setFromForPb(2);
        nVar.setObjectPool(this.fcm, this.fcn);
        nVar.setFromCDN(this.ajr);
        nVar.b((Boolean) true);
        nVar.bp(R.color.cp_bg_line_c);
        nVar.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds27), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        nVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.x.5
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && absThreadDataSupport.bce().edE != null) {
                    ay.a(absThreadDataSupport.bce().edE, x.this.mContext, 2);
                }
            }
        });
        aVar.a((com.baidu.card.h) nVar);
        ao aoVar = new ao(this.mPageContext.getPageActivity());
        aoVar.setTopMargin(-com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds16));
        aVar.a((com.baidu.card.h) aoVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.j(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 1;
        cVar.dWQ = 1;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(1);
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(2);
        aVar.b(amVar);
        aVar.tP().setBackgroundResource(R.drawable.addresslist_item_bg);
        aj a = aVar.a(true, viewGroup, this.akI);
        a.setSourceForPb(2);
        al alVar = new al(a);
        alVar.setPageId(this.ePv);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.x.6
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof al)) {
                    al alVar2 = (al) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (x.this.aeT != null) {
                        x.this.aeT.a(alVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false);
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, al<com.baidu.tieba.card.data.l> alVar) {
        if (lVar == null || alVar == null || alVar.getView() == null || lVar.dUS == null) {
            return null;
        }
        lVar.vy(lVar.position + 1);
        alVar.tR().setPosition(i);
        alVar.tR().setPage(this.agH);
        alVar.aL(true).a(this.flJ);
        alVar.a(lVar.bcp(), this.iFO);
        alVar.b((al<com.baidu.tieba.card.data.l>) lVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.aeT);
        com.baidu.tieba.card.s.cbX().e(lVar.ccv());
        com.baidu.tieba.a.d.bAA().e(lVar.ccv());
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dUS, this.ePv, lVar.ccj());
        return alVar.getView();
    }

    private void cyk() {
        com.baidu.tieba.card.data.l.hmJ = "c10705";
        com.baidu.tieba.card.data.l.hmK = "c10730";
        com.baidu.tieba.card.data.l.hmL = "c10731";
        com.baidu.tieba.card.data.l.hmM = "c10704";
        com.baidu.tieba.card.data.l.hmN = "c10755";
        com.baidu.tieba.card.data.l.hmO = "c10710";
        com.baidu.tieba.card.data.l.hmP = "c10736";
        com.baidu.tieba.card.data.l.hmQ = "c10737";
        com.baidu.tieba.card.data.l.hmR = "c10711";
        com.baidu.tieba.card.data.l.hmS = "c10758";
        com.baidu.tieba.card.data.l.hmT = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.flJ = aVar;
    }
}
