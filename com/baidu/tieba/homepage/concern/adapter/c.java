package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ag;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.b, am<com.baidu.tieba.card.data.b>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.b> agG;
    private String aiw;
    private boolean alo;
    private com.baidu.adp.widget.ListView.v amH;
    private com.baidu.adp.lib.d.b<ImageView> fMZ;
    private com.baidu.adp.lib.d.b<GifView> fNa;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View e(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, am<com.baidu.tieba.card.data.b> amVar) {
        return e2(i, view, viewGroup, bVar, (am) amVar);
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alo = true;
        this.fMZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bJz */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(c.this.mPageContext.getPageActivity());
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
        this.fNa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cwK */
            public GifView makeObject() {
                GifView gifView = new GifView(c.this.mPageContext.getPageActivity());
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
        this.agG = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                c.this.a(view, bVar);
            }
        };
        this.mPageContext = tbPageContext;
        cNP();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.amH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        int i;
        ar csz;
        if (view != null && bVar != null && bVar.bmn() != null && !StringUtils.isNull(bVar.bmn().getTid())) {
            int id = view.getId();
            if (bVar.eIy) {
                if (id == R.id.thread_card_root) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                } else if (id == R.id.user_avatar || id == R.id.user_name) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 1);
                }
            } else if (bVar.eIO) {
                com.baidu.tieba.card.t.csg().mj(true);
                if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                    TiebaStatic.log(bVar.csy());
                    com.baidu.tieba.a.d.bLT().a("page_concern", "clk_", bVar.csy());
                    i = 9;
                } else {
                    if (bVar.bnv()) {
                        csz = bVar.csA();
                    } else {
                        csz = bVar.csz();
                    }
                    TiebaStatic.log(csz);
                    com.baidu.tieba.a.d.bLT().a("page_concern", "clk_", csz);
                    i = 1;
                }
                com.baidu.tieba.homepage.personalize.c.a.a(bVar.eCR, this.fzO, bVar.css(), i);
            } else if (bVar.eID || bVar.imJ || bVar.eIC || bVar.eIz) {
                if (view.getId() == R.id.thread_card_root) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                } else if (view instanceof TbImageView) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 3);
                } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                }
            } else if (!bVar.eIK) {
                if (bVar.eIM) {
                    am amVar = (am) view.getTag();
                    if (amVar != null) {
                        az.a((com.baidu.tbadk.core.data.a) bVar.bmn(), view.getContext(), 1, false);
                        amVar.tZ().b(new a.C0097a(1));
                    }
                } else if (!bVar.eIN) {
                    if (bVar.imL) {
                        if (view.getId() == R.id.thread_card_root) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                        } else if (id == R.id.forum_name_text) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 7);
                        }
                    } else if (bVar.eIF) {
                        if (view.getId() == R.id.thread_card_root) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                        } else if (id == R.id.god_reply_voice_btn) {
                            ar arVar = new ar("c13423");
                            arVar.al("obj_locate", 4);
                            arVar.dY("tid", bVar.tid);
                            if (bVar.eCR != null && bVar.eCR.bqu() != null) {
                                arVar.dY("pid", bVar.eCR.bqu().getId());
                            }
                            TiebaStatic.log(arVar);
                        } else if (id == R.id.god_reply_content) {
                            ar arVar2 = new ar("c13423");
                            arVar2.al("obj_locate", 2);
                            arVar2.dY("tid", bVar.tid);
                            if (bVar.eCR != null && bVar.eCR.bqu() != null) {
                                arVar2.dY("pid", bVar.eCR.bqu().getId());
                            }
                            TiebaStatic.log(arVar2);
                        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                            ar arVar3 = new ar("c13423");
                            arVar3.al("obj_locate", 1);
                            arVar3.dY("tid", bVar.tid);
                            if (bVar.eCR != null && bVar.eCR.bqu() != null) {
                                arVar3.dY("pid", bVar.eCR.bqu().getId());
                            }
                            TiebaStatic.log(arVar3);
                        } else if (id == R.id.god_reply_agree_view) {
                            ar arVar4 = new ar("c13423");
                            arVar4.al("obj_locate", 5);
                            arVar4.dY("tid", bVar.tid);
                            if (bVar.eCR != null && bVar.eCR.bqu() != null) {
                                arVar4.dY("pid", bVar.eCR.bqu().getId());
                            }
                            TiebaStatic.log(arVar4);
                        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                            ar arVar5 = new ar("c13423");
                            arVar5.al("obj_locate", 3);
                            arVar5.dY("tid", bVar.tid);
                            if (bVar.eCR != null && bVar.eCR.bqu() != null) {
                                arVar5.dY("pid", bVar.eCR.bqu().getId());
                            }
                            TiebaStatic.log(arVar5);
                        }
                    } else if (bVar.eIE) {
                        if (view.getId() == R.id.thread_card_root || view.getId() == R.id.thread_info_commont_container) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, am<com.baidu.tieba.card.data.b> amVar) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qL() {
        return com.baidu.tieba.card.data.b.imr;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qM() {
        return com.baidu.tieba.card.data.b.imw;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qN() {
        return com.baidu.tieba.card.data.b.imy;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qO() {
        return com.baidu.tieba.card.data.b.imz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public am<com.baidu.tieba.card.data.b> b(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        if (bVar == null) {
            return null;
        }
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        if (bVar.eIy) {
            com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
            eVar.setPageUniqueId(this.fzO);
            eVar.bs(128);
            eVar.bt(1024);
            eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.concern.adapter.c.4
                @Override // com.baidu.card.e.a
                public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                    if (aVar2 != null) {
                        if (view.getId() == R.id.user_name) {
                            aVar2.objType = 3;
                        } else if (view.getId() == R.id.user_avatar) {
                            aVar2.objType = 4;
                        } else {
                            aVar2.objType = 1;
                        }
                    }
                }
            });
            aVar.a(eVar);
        } else if (bVar.eIO) {
            aVar.a(new com.baidu.card.m(this.mPageContext.getPageActivity()));
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.TOP, viewGroup, this.amH);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.b> amVar = new am<>(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.c.5
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.adp.widget.ListView.i) && (view.getTag() instanceof am) && (((com.baidu.adp.widget.ListView.i) qVar).qV() instanceof com.baidu.tieba.card.data.b)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.i) qVar).qV();
                    bVar2.objType = 1;
                    if (c.this.agG != null) {
                        c.this.agG.a(amVar2.getView(), bVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, am<com.baidu.tieba.card.data.b> amVar) {
        if (bVar == null || amVar == null || amVar.getView() == null || bVar.eCR == null) {
            return null;
        }
        bVar.ym(bVar.position + 1);
        amVar.tZ().setPosition(i);
        if (amVar.tZ() instanceof com.baidu.tieba.a.e) {
            amVar.tZ().setPage(this.aiw);
        }
        if (bVar.eIy) {
            amVar.a(true, Align.ALIGN_RIGHT_TOP);
        } else if (bVar.eIO) {
            com.baidu.tieba.card.t.csg().e(bVar.csB());
            com.baidu.tieba.a.d.bLT().e(bVar.csB());
            com.baidu.tieba.homepage.personalize.c.a.a(bVar.eCR, this.fzO, bVar.css());
        }
        amVar.b((am<com.baidu.tieba.card.data.b>) bVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        return amVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public am<com.baidu.tieba.card.data.b> c(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        if (bVar.eID) {
            com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
            oVar.setObjectPool(this.fMZ, this.fNa);
            oVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            oVar.setFromForPb(1);
            oVar.setFromCDN(this.alo);
            oVar.setCornerStyle(1);
            aVar.c(oVar);
        } else if (bVar.imJ) {
            com.baidu.card.y yVar = new com.baidu.card.y(this.mPageContext.getPageActivity());
            yVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            yVar.setFromCDN(this.alo);
            aVar.c(yVar);
        } else if (bVar.eIC) {
            com.baidu.card.v vVar = new com.baidu.card.v(this.mPageContext.getPageActivity());
            vVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            vVar.setFromCDN(this.alo);
            aVar.c(vVar);
        } else if (bVar.eIz) {
            com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext.getPageActivity());
            zVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            zVar.setFromCDN(this.alo);
            aVar.c(zVar);
        } else if (bVar.imK) {
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amH);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.b> amVar = new am<>(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.c.6
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.adp.widget.ListView.i) && (view.getTag() instanceof am) && (((com.baidu.adp.widget.ListView.i) qVar).qV() instanceof com.baidu.tieba.card.data.b)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.i) qVar).qV();
                    bVar2.objType = 1;
                    if (c.this.agG != null) {
                        c.this.agG.a(amVar2.getView(), bVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false);
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View c(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, am<com.baidu.tieba.card.data.b> amVar) {
        if (bVar == null || amVar == null || amVar.getView() == null || bVar.eCR == null) {
            return null;
        }
        bVar.ym(bVar.position + 1);
        com.baidu.tieba.card.t.csg().e(bVar.Jv("c12351"));
        amVar.tZ().setPosition(i);
        if (amVar.tZ() instanceof com.baidu.tieba.a.e) {
            amVar.tZ().setPage(this.aiw);
        }
        if (bVar.imJ) {
            com.baidu.card.y yVar = (com.baidu.card.y) amVar.tZ().tS();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.ahJ.alN.getLayoutParams();
            layoutParams.width = bVar.eIP;
            layoutParams.height = bVar.eIQ;
            if (yVar.ahJ.alN.getVisibility() != 8) {
                yVar.ahJ.alN.setLayoutParams(layoutParams);
            }
        }
        amVar.b((am<com.baidu.tieba.card.data.b>) bVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        return amVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c  reason: avoid collision after fix types in other method */
    public am<com.baidu.tieba.card.data.b> d(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.s sVar = new com.baidu.card.s(this.mPageContext.getPageActivity());
        sVar.tO();
        aVar.a((com.baidu.card.i) sVar);
        aVar.a((com.baidu.card.i) new ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.tM();
        aVar.a((com.baidu.card.i) kVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alo);
        nVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.i) nVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.amH);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.b> amVar = new am<>(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.c.7
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.b bVar2;
                if ((qVar instanceof com.baidu.adp.widget.ListView.i) && (((com.baidu.adp.widget.ListView.i) qVar).qV() instanceof com.baidu.tieba.card.data.b) && qVar != null && ((com.baidu.adp.widget.ListView.i) qVar).qV() != null && (bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.i) qVar).qV()) != null && bVar2.eCR != null && bVar2.eIK && bVar2.eCR.bqV() != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", String.valueOf(bVar2.eCR.bqV().item_id));
                    hashMap.put("source", 2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                } else if ((qVar instanceof com.baidu.adp.widget.ListView.i) && (view.getTag() instanceof am) && (((com.baidu.adp.widget.ListView.i) qVar).qV() instanceof com.baidu.tieba.card.data.b)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.b bVar3 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.i) qVar).qV();
                    bVar3.objType = 1;
                    if (c.this.agG != null) {
                        c.this.agG.a(amVar2.getView(), bVar3);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bVar3, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View d(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, am<com.baidu.tieba.card.data.b> amVar) {
        if (bVar == null || amVar == null || amVar.getView() == null || bVar.eCR == null) {
            return null;
        }
        bVar.ym(bVar.position + 1);
        amVar.tZ().setPosition(i);
        if (amVar.tZ() instanceof com.baidu.tieba.a.e) {
            amVar.tZ().setPage(this.aiw);
        }
        if (bVar.eIF) {
            com.baidu.tieba.card.t.csg().e(new ar("c13424"));
        }
        amVar.b((am<com.baidu.tieba.card.data.b>) bVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        return amVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d  reason: avoid collision after fix types in other method */
    public am<com.baidu.tieba.card.data.b> e(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 9;
        dVar.eEP = 9;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(4);
        anVar.setStType("personalize_page");
        anVar.setShareReportFrom(4);
        anVar.setFromForPb(1);
        anVar.bs(32);
        aVar.b(anVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.amH);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.b> amVar = new am<>(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.c.8
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.adp.widget.ListView.i) && (view.getTag() instanceof am) && (((com.baidu.adp.widget.ListView.i) qVar).qV() instanceof com.baidu.tieba.card.data.b)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.i) qVar).qV();
                    bVar2.objType = 1;
                    if (c.this.agG != null) {
                        c.this.agG.a(amVar2.getView(), bVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* renamed from: e  reason: avoid collision after fix types in other method */
    public View e2(final int i, final View view, final ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, am amVar) {
        if (bVar == null || amVar == null || amVar.getView() == null || bVar.eCR == null) {
            return null;
        }
        bVar.ym(bVar.position + 1);
        amVar.tZ().setPosition(i);
        if (amVar.tZ().tT() instanceof an) {
            ((an) amVar.tZ().tT()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.concern.adapter.c.9
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                    }
                }
            });
        }
        if (amVar.tZ() instanceof com.baidu.tieba.a.e) {
            amVar.tZ().setPage(this.aiw);
        }
        amVar.a(false, Align.ALIGN_RIGHT_BOTTOM);
        amVar.b((am) bVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    private void cNP() {
        com.baidu.tieba.card.data.k.imU = "c10705";
        com.baidu.tieba.card.data.k.imV = "c10730";
        com.baidu.tieba.card.data.k.imW = "c10731";
        com.baidu.tieba.card.data.k.imX = "c10704";
        com.baidu.tieba.card.data.k.imY = "c10755";
        com.baidu.tieba.card.data.k.imZ = "c10710";
        com.baidu.tieba.card.data.k.ina = "c10736";
        com.baidu.tieba.card.data.k.inb = "c10737";
        com.baidu.tieba.card.data.k.inc = "c10711";
        com.baidu.tieba.card.data.k.ind = "c10758";
        com.baidu.tieba.card.data.k.ine = "c10757";
    }
}
