package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.am;
import com.baidu.card.ao;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, al<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.l> aeT;
    private String agH;
    private boolean ajr;
    private com.baidu.adp.widget.ListView.v akI;
    public BdUniqueId ePv;
    private com.baidu.adp.lib.d.b<ImageView> fcm;
    private com.baidu.adp.lib.d.b<GifView> fcn;
    private TbPageContext<?> mPageContext;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajr = true;
        this.fcm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.homepage.concern.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: byu */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(m.this.mPageContext.getPageActivity());
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
        this.fcn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.homepage.concern.a.m.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cgy */
            public GifView makeObject() {
                GifView gifView = new GifView(m.this.mPageContext.getPageActivity());
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
        this.aeT = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (view != null && lVar != null && lVar.bce() != null && !StringUtils.isNull(lVar.bce().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 2);
                    } else if (id == R.id.thread_card_voice) {
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 6);
                    } else if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 1);
                    } else if (id == R.id.god_reply_voice_btn) {
                        aq aqVar = new aq("c13423");
                        aqVar.ai("obj_locate", 4);
                        if (lVar != null) {
                            aqVar.dD("tid", lVar.tid);
                            if (lVar.dUS != null && lVar.dUS.bgh() != null) {
                                aqVar.dD("pid", lVar.dUS.bgh().getId());
                            }
                        }
                        TiebaStatic.log(aqVar);
                    } else if (id == R.id.god_reply_content) {
                        aq aqVar2 = new aq("c13423");
                        aqVar2.ai("obj_locate", 2);
                        if (lVar != null) {
                            aqVar2.dD("tid", lVar.tid);
                            if (lVar.dUS != null && lVar.dUS.bgh() != null) {
                                aqVar2.dD("pid", lVar.dUS.bgh().getId());
                            }
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        aq aqVar3 = new aq("c13423");
                        aqVar3.ai("obj_locate", 1);
                        if (lVar != null) {
                            aqVar3.dD("tid", lVar.tid);
                            if (lVar.dUS != null && lVar.dUS.bgh() != null) {
                                aqVar3.dD("pid", lVar.dUS.bgh().getId());
                            }
                        }
                        TiebaStatic.log(aqVar3);
                    } else if (id == R.id.god_reply_agree_view) {
                        aq aqVar4 = new aq("c13423");
                        aqVar4.ai("obj_locate", 5);
                        if (lVar != null) {
                            aqVar4.dD("tid", lVar.tid);
                            if (lVar.dUS != null && lVar.dUS.bgh() != null) {
                                aqVar4.dD("pid", lVar.dUS.bgh().getId());
                            }
                        }
                        TiebaStatic.log(aqVar4);
                    } else if (view.getId() == R.id.forum_name_text) {
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 7);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            aq aqVar5 = new aq("c13423");
                            aqVar5.ai("obj_locate", 3);
                            if (lVar != null) {
                                aqVar5.dD("tid", lVar.tid);
                                if (lVar.dUS != null && lVar.dUS.bgh() != null) {
                                    aqVar5.dD("pid", lVar.dUS.bgh().getId());
                                }
                            }
                            TiebaStatic.log(aqVar5);
                            return;
                        }
                        com.baidu.tieba.homepage.concern.b.a(view, lVar, 6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ePv);
        eVar.bk(128);
        eVar.bl(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.concern.a.m.4
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
                    m.this.b(view, absThreadDataSupport);
                }
            }
        });
        aVar.a(eVar);
        ae aeVar = new ae(this.mPageContext);
        aeVar.b((Boolean) false);
        aeVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds15));
        aeVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        aVar.tP().br(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        aeVar.setOnCardSubClickListener(new aa<AbsThreadDataSupport>() { // from class: com.baidu.tieba.homepage.concern.a.m.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: c */
            public void a(View view, AbsThreadDataSupport absThreadDataSupport) {
                m.this.b(view, absThreadDataSupport);
            }
        });
        aVar.c(aeVar);
        final com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        nVar.setFromForPb(1);
        nVar.setObjectPool(this.fcm, this.fcn);
        nVar.setFromCDN(this.ajr);
        nVar.b((Boolean) true);
        nVar.bp(R.color.cp_bg_line_g);
        nVar.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds27), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32));
        nVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.a.m.6
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bce() != null && absThreadDataSupport.bce().edE != null) {
                    ay.a(absThreadDataSupport.bce().edE, m.this.mContext, 1);
                    com.baidu.tieba.homepage.concern.b.a(nVar.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) nVar);
        aVar.a((com.baidu.card.h) new ao(this.mPageContext.getPageActivity()));
        com.baidu.card.j jVar = new com.baidu.card.j(this.mPageContext.getPageActivity());
        jVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds24));
        aVar.a((com.baidu.card.h) jVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 9;
        cVar.dWQ = 9;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(9);
        amVar.setShareReportFrom(4);
        amVar.setFromForPb(1);
        amVar.bk(32);
        aVar.b(amVar);
        aVar.tP().setBackgroundResource(R.drawable.addresslist_item_bg);
        aj a = aVar.a(true, viewGroup, this.akI);
        a.setSourceForPb(1);
        al<com.baidu.tieba.card.data.l> alVar = new al<>(a);
        alVar.setPageId(this.ePv);
        a(new ab() { // from class: com.baidu.tieba.homepage.concern.a.m.7
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof al)) {
                    al alVar2 = (al) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (m.this.aeT != null) {
                        m.this.aeT.a(alVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 1, false);
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
        com.baidu.tieba.card.s.cbX().e(lVar.He("c12351"));
        alVar.tR().setPage(this.agH);
        alVar.a(true, Align.ALIGN_RIGHT_TOP);
        alVar.b((al<com.baidu.tieba.card.data.l>) lVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.aeT);
        return alVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, AbsThreadDataSupport absThreadDataSupport) {
        if (view != null && absThreadDataSupport != null && view.getId() != -1) {
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                com.baidu.tieba.homepage.concern.b.a(view, absThreadDataSupport, 1);
            } else if (id == R.id.thread_card_title || id == R.id.thread_card_abstract || id == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.b.a(view, absThreadDataSupport, 2);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.akI = vVar;
    }
}
