package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ag;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
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
/* loaded from: classes21.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.b, am<com.baidu.tieba.card.data.b>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.b> afK;
    private String ahw;
    private boolean akn;
    private com.baidu.adp.widget.ListView.v alH;
    private com.baidu.adp.lib.d.b<ImageView> fFn;
    private com.baidu.adp.lib.d.b<GifView> fFo;
    public BdUniqueId fsa;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View e(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, am<com.baidu.tieba.card.data.b> amVar) {
        return e2(i, view, viewGroup, bVar, (am) amVar);
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akn = true;
        this.fFn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bFZ */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(c.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.biL().isShowImages();
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
                    if (com.baidu.tbadk.core.k.biL().isShowImages()) {
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
        this.fFo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: csv */
            public GifView makeObject() {
                GifView gifView = new GifView(c.this.mPageContext.getPageActivity());
                boolean isShowImages = com.baidu.tbadk.core.k.biL().isShowImages();
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
                if (com.baidu.tbadk.core.k.biL().isShowImages()) {
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
                gifView.bAr();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
        }, 20, 0);
        this.afK = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                c.this.a(view, bVar);
            }
        };
        this.mPageContext = tbPageContext;
        cIA();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        int i;
        ar com2;
        if (view != null && bVar != null && bVar.bjd() != null && !StringUtils.isNull(bVar.bjd().getTid())) {
            int id = view.getId();
            if (bVar.eBx) {
                if (id == R.id.thread_card_root) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                } else if (id == R.id.user_avatar || id == R.id.user_name) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 1);
                }
            } else if (bVar.eBN) {
                com.baidu.tieba.card.t.cnT().lO(true);
                if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                    TiebaStatic.log(bVar.col());
                    com.baidu.tieba.a.d.bIl().a("page_concern", "clk_", bVar.col());
                    i = 9;
                } else {
                    if (bVar.bki()) {
                        com2 = bVar.con();
                    } else {
                        com2 = bVar.com();
                    }
                    TiebaStatic.log(com2);
                    com.baidu.tieba.a.d.bIl().a("page_concern", "clk_", com2);
                    i = 1;
                }
                com.baidu.tieba.homepage.personalize.c.a.a(bVar.evQ, this.fsa, bVar.cof(), i);
            } else if (bVar.eBC || bVar.ibM || bVar.eBB || bVar.eBy) {
                if (view.getId() == R.id.thread_card_root) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                } else if (view instanceof TbImageView) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 3);
                } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                }
            } else if (!bVar.eBJ) {
                if (bVar.eBL) {
                    am amVar = (am) view.getTag();
                    if (amVar != null) {
                        az.a((com.baidu.tbadk.core.data.a) bVar.bjd(), view.getContext(), 1, false);
                        amVar.tW().b(new a.C0096a(1));
                    }
                } else if (!bVar.eBM) {
                    if (bVar.ibO) {
                        if (view.getId() == R.id.thread_card_root) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                        } else if (id == R.id.forum_name_text) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 7);
                        }
                    } else if (bVar.eBE) {
                        if (view.getId() == R.id.thread_card_root) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                        } else if (id == R.id.god_reply_voice_btn) {
                            ar arVar = new ar("c13423");
                            arVar.ak("obj_locate", 4);
                            arVar.dR("tid", bVar.tid);
                            if (bVar.evQ != null && bVar.evQ.bnh() != null) {
                                arVar.dR("pid", bVar.evQ.bnh().getId());
                            }
                            TiebaStatic.log(arVar);
                        } else if (id == R.id.god_reply_content) {
                            ar arVar2 = new ar("c13423");
                            arVar2.ak("obj_locate", 2);
                            arVar2.dR("tid", bVar.tid);
                            if (bVar.evQ != null && bVar.evQ.bnh() != null) {
                                arVar2.dR("pid", bVar.evQ.bnh().getId());
                            }
                            TiebaStatic.log(arVar2);
                        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                            ar arVar3 = new ar("c13423");
                            arVar3.ak("obj_locate", 1);
                            arVar3.dR("tid", bVar.tid);
                            if (bVar.evQ != null && bVar.evQ.bnh() != null) {
                                arVar3.dR("pid", bVar.evQ.bnh().getId());
                            }
                            TiebaStatic.log(arVar3);
                        } else if (id == R.id.god_reply_agree_view) {
                            ar arVar4 = new ar("c13423");
                            arVar4.ak("obj_locate", 5);
                            arVar4.dR("tid", bVar.tid);
                            if (bVar.evQ != null && bVar.evQ.bnh() != null) {
                                arVar4.dR("pid", bVar.evQ.bnh().getId());
                            }
                            TiebaStatic.log(arVar4);
                        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                            ar arVar5 = new ar("c13423");
                            arVar5.ak("obj_locate", 3);
                            arVar5.dR("tid", bVar.tid);
                            if (bVar.evQ != null && bVar.evQ.bnh() != null) {
                                arVar5.dR("pid", bVar.evQ.bnh().getId());
                            }
                            TiebaStatic.log(arVar5);
                        }
                    } else if (bVar.eBD) {
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
    public BdUniqueId qJ() {
        return com.baidu.tieba.card.data.b.ibu;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qK() {
        return com.baidu.tieba.card.data.b.ibz;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qL() {
        return com.baidu.tieba.card.data.b.ibB;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qM() {
        return com.baidu.tieba.card.data.b.ibC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public am<com.baidu.tieba.card.data.b> b(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        if (bVar == null) {
            return null;
        }
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        if (bVar.eBx) {
            com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
            eVar.setPageUniqueId(this.fsa);
            eVar.bo(128);
            eVar.bp(1024);
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
        } else if (bVar.eBN) {
            aVar.a(new com.baidu.card.m(this.mPageContext.getPageActivity()));
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.TOP, viewGroup, this.alH);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.b> amVar = new am<>(a2);
        amVar.setPageId(this.fsa);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.c.5
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.adp.widget.ListView.i) && (view.getTag() instanceof am) && (((com.baidu.adp.widget.ListView.i) qVar).qT() instanceof com.baidu.tieba.card.data.b)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.i) qVar).qT();
                    bVar2.objType = 1;
                    if (c.this.afK != null) {
                        c.this.afK.a(amVar2.getView(), bVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, am<com.baidu.tieba.card.data.b> amVar) {
        if (bVar == null || amVar == null || amVar.getView() == null || bVar.evQ == null) {
            return null;
        }
        bVar.xH(bVar.position + 1);
        amVar.tW().setPosition(i);
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.ahw);
        }
        if (bVar.eBx) {
            amVar.a(true, Align.ALIGN_RIGHT_TOP);
        } else if (bVar.eBN) {
            com.baidu.tieba.card.t.cnT().e(bVar.coo());
            com.baidu.tieba.a.d.bIl().e(bVar.coo());
            com.baidu.tieba.homepage.personalize.c.a.a(bVar.evQ, this.fsa, bVar.cof());
        }
        amVar.b((am<com.baidu.tieba.card.data.b>) bVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afK);
        return amVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public am<com.baidu.tieba.card.data.b> c(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        if (bVar.eBC) {
            com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
            oVar.setObjectPool(this.fFn, this.fFo);
            oVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            oVar.setFromForPb(1);
            oVar.setFromCDN(this.akn);
            oVar.setCornerStyle(1);
            aVar.c(oVar);
        } else if (bVar.ibM) {
            com.baidu.card.y yVar = new com.baidu.card.y(this.mPageContext.getPageActivity());
            yVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            yVar.setFromCDN(this.akn);
            aVar.c(yVar);
        } else if (bVar.eBB) {
            com.baidu.card.v vVar = new com.baidu.card.v(this.mPageContext.getPageActivity());
            vVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            vVar.setFromCDN(this.akn);
            aVar.c(vVar);
        } else if (bVar.eBy) {
            com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext.getPageActivity());
            zVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            zVar.setFromCDN(this.akn);
            aVar.c(zVar);
        } else if (bVar.ibN) {
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.alH);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.b> amVar = new am<>(a2);
        amVar.setPageId(this.fsa);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.c.6
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.adp.widget.ListView.i) && (view.getTag() instanceof am) && (((com.baidu.adp.widget.ListView.i) qVar).qT() instanceof com.baidu.tieba.card.data.b)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.i) qVar).qT();
                    bVar2.objType = 1;
                    if (c.this.afK != null) {
                        c.this.afK.a(amVar2.getView(), bVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false);
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View c(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, am<com.baidu.tieba.card.data.b> amVar) {
        if (bVar == null || amVar == null || amVar.getView() == null || bVar.evQ == null) {
            return null;
        }
        bVar.xH(bVar.position + 1);
        com.baidu.tieba.card.t.cnT().e(bVar.IF("c12351"));
        amVar.tW().setPosition(i);
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.ahw);
        }
        if (bVar.ibM) {
            com.baidu.card.y yVar = (com.baidu.card.y) amVar.tW().tP();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.agK.akM.getLayoutParams();
            layoutParams.width = bVar.eBO;
            layoutParams.height = bVar.eBP;
            if (yVar.agK.akM.getVisibility() != 8) {
                yVar.agK.akM.setLayoutParams(layoutParams);
            }
        }
        amVar.b((am<com.baidu.tieba.card.data.b>) bVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afK);
        return amVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c  reason: avoid collision after fix types in other method */
    public am<com.baidu.tieba.card.data.b> d(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.s sVar = new com.baidu.card.s(this.mPageContext.getPageActivity());
        sVar.tL();
        aVar.a((com.baidu.card.i) sVar);
        aVar.a((com.baidu.card.i) new ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.tJ();
        aVar.a((com.baidu.card.i) kVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akn);
        nVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.i) nVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.alH);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.b> amVar = new am<>(a2);
        amVar.setPageId(this.fsa);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.c.7
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.adp.widget.ListView.i) && (view.getTag() instanceof am) && (((com.baidu.adp.widget.ListView.i) qVar).qT() instanceof com.baidu.tieba.card.data.b)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.i) qVar).qT();
                    bVar2.objType = 1;
                    if (c.this.afK != null) {
                        c.this.afK.a(amVar2.getView(), bVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View d(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, am<com.baidu.tieba.card.data.b> amVar) {
        if (bVar == null || amVar == null || amVar.getView() == null || bVar.evQ == null) {
            return null;
        }
        bVar.xH(bVar.position + 1);
        amVar.tW().setPosition(i);
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.ahw);
        }
        if (bVar.eBE) {
            com.baidu.tieba.card.t.cnT().e(new ar("c13424"));
        }
        amVar.b((am<com.baidu.tieba.card.data.b>) bVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afK);
        return amVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d  reason: avoid collision after fix types in other method */
    public am<com.baidu.tieba.card.data.b> e(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.exI = 9;
        dVar.exO = 9;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(4);
        anVar.setStType("personalize_page");
        anVar.setShareReportFrom(4);
        anVar.setFromForPb(1);
        anVar.bo(32);
        aVar.b(anVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.alH);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.b> amVar = new am<>(a2);
        amVar.setPageId(this.fsa);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.c.8
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.adp.widget.ListView.i) && (view.getTag() instanceof am) && (((com.baidu.adp.widget.ListView.i) qVar).qT() instanceof com.baidu.tieba.card.data.b)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.i) qVar).qT();
                    bVar2.objType = 1;
                    if (c.this.afK != null) {
                        c.this.afK.a(amVar2.getView(), bVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* renamed from: e  reason: avoid collision after fix types in other method */
    public View e2(final int i, final View view, final ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, am amVar) {
        if (bVar == null || amVar == null || amVar.getView() == null || bVar.evQ == null) {
            return null;
        }
        bVar.xH(bVar.position + 1);
        amVar.tW().setPosition(i);
        if (amVar.tW().tQ() instanceof an) {
            ((an) amVar.tW().tQ()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.concern.adapter.c.9
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                    }
                }
            });
        }
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.ahw);
        }
        amVar.a(false, Align.ALIGN_RIGHT_BOTTOM);
        amVar.b((am) bVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afK);
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    private void cIA() {
        com.baidu.tieba.card.data.k.ibX = "c10705";
        com.baidu.tieba.card.data.k.ibY = "c10730";
        com.baidu.tieba.card.data.k.ibZ = "c10731";
        com.baidu.tieba.card.data.k.ica = "c10704";
        com.baidu.tieba.card.data.k.icb = "c10755";
        com.baidu.tieba.card.data.k.icc = "c10710";
        com.baidu.tieba.card.data.k.icd = "c10736";
        com.baidu.tieba.card.data.k.ice = "c10737";
        com.baidu.tieba.card.data.k.icf = "c10711";
        com.baidu.tieba.card.data.k.icg = "c10758";
        com.baidu.tieba.card.data.k.ich = "c10757";
    }
}
