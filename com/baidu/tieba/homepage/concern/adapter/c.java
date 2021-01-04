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
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ag;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.b, ThreadCardViewHolder<com.baidu.tieba.card.data.b>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.b> ahf;
    private String aji;
    private boolean alQ;
    private com.baidu.adp.widget.ListView.s anl;
    public BdUniqueId fJu;
    private com.baidu.adp.lib.d.b<ImageView> fWD;
    private com.baidu.adp.lib.d.b<GifView> fWE;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View e(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder) {
        return e2(i, view, viewGroup, bVar, (ThreadCardViewHolder) threadCardViewHolder);
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alQ = true;
        this.fWD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bLR */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(c.this.mPageContext.getPageActivity());
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
        this.fWE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: czE */
            public GifView makeObject() {
                GifView gifView = new GifView(c.this.mPageContext.getPageActivity());
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
        this.ahf = new aa<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                c.this.a(view, bVar);
            }
        };
        this.mPageContext = tbPageContext;
        cQW();
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.anl = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        int i;
        aq cvt;
        if (view != null && bVar != null && bVar.boO() != null && !StringUtils.isNull(bVar.boO().getTid())) {
            int id = view.getId();
            if (bVar.eSq) {
                if (id == R.id.thread_card_root) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                } else if (id == R.id.user_avatar || id == R.id.user_name) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 1);
                }
            } else if (bVar.eSH) {
                com.baidu.tieba.card.s.cva().mG(true);
                if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                    TiebaStatic.log(bVar.cvs());
                    com.baidu.tieba.a.d.bOm().a("page_concern", "clk_", bVar.cvs());
                    i = 9;
                } else {
                    if (bVar.bpV()) {
                        cvt = bVar.cvu();
                    } else {
                        cvt = bVar.cvt();
                    }
                    TiebaStatic.log(cvt);
                    com.baidu.tieba.a.d.bOm().a("page_concern", "clk_", cvt);
                    i = 1;
                }
                com.baidu.tieba.homepage.personalize.a.a.a(bVar.eMv, this.fJu, bVar.cvm(), i);
            } else if (bVar.eSv || bVar.izg || bVar.eSu || bVar.eSr) {
                if (view.getId() == R.id.thread_card_root) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                } else if (view instanceof TbImageView) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 3);
                } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                }
            } else if (!bVar.eSD) {
                if (bVar.eSF) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    if (threadCardViewHolder != null) {
                        ay.a((com.baidu.tbadk.core.data.a) bVar.boO(), view.getContext(), 1, false);
                        threadCardViewHolder.ty().b(new a.C0090a(1));
                    }
                } else if (!bVar.eSG) {
                    if (bVar.izi) {
                        if (view.getId() == R.id.thread_card_root) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                        } else if (id == R.id.forum_name_text) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 7);
                        }
                    } else if (bVar.eSx) {
                        if (view.getId() == R.id.thread_card_root) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                        } else if (id == R.id.god_reply_voice_btn) {
                            aq aqVar = new aq("c13423");
                            aqVar.an("obj_locate", 4);
                            aqVar.dX("tid", bVar.tid);
                            if (bVar.eMv != null && bVar.eMv.bsW() != null) {
                                aqVar.dX("pid", bVar.eMv.bsW().getId());
                            }
                            TiebaStatic.log(aqVar);
                        } else if (id == R.id.god_reply_content) {
                            aq aqVar2 = new aq("c13423");
                            aqVar2.an("obj_locate", 2);
                            aqVar2.dX("tid", bVar.tid);
                            if (bVar.eMv != null && bVar.eMv.bsW() != null) {
                                aqVar2.dX("pid", bVar.eMv.bsW().getId());
                            }
                            TiebaStatic.log(aqVar2);
                        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                            aq aqVar3 = new aq("c13423");
                            aqVar3.an("obj_locate", 1);
                            aqVar3.dX("tid", bVar.tid);
                            if (bVar.eMv != null && bVar.eMv.bsW() != null) {
                                aqVar3.dX("pid", bVar.eMv.bsW().getId());
                            }
                            TiebaStatic.log(aqVar3);
                        } else if (id == R.id.god_reply_agree_view) {
                            aq aqVar4 = new aq("c13423");
                            aqVar4.an("obj_locate", 5);
                            aqVar4.dX("tid", bVar.tid);
                            if (bVar.eMv != null && bVar.eMv.bsW() != null) {
                                aqVar4.dX("pid", bVar.eMv.bsW().getId());
                            }
                            TiebaStatic.log(aqVar4);
                        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                            aq aqVar5 = new aq("c13423");
                            aqVar5.an("obj_locate", 3);
                            aqVar5.dX("tid", bVar.tid);
                            if (bVar.eMv != null && bVar.eMv.bsW() != null) {
                                aqVar5.dX("pid", bVar.eMv.bsW().getId());
                            }
                            TiebaStatic.log(aqVar5);
                        }
                    } else if (bVar.eSw && (view.getId() == R.id.thread_card_root || view.getId() == R.id.thread_info_commont_container)) {
                        com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                    }
                }
            }
            if (id == R.id.thread_info_commont_container || id == R.id.thread_info_commont_img || id == R.id.thread_info_commont_num) {
                com.baidu.tieba.homepage.concern.c.a(view, bVar, 8);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qn() {
        return com.baidu.tieba.card.data.b.iyN;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qo() {
        return com.baidu.tieba.card.data.b.iyS;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qp() {
        return com.baidu.tieba.card.data.b.iyV;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qq() {
        return com.baidu.tieba.card.data.b.iyW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.b> b(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        if (bVar == null) {
            return null;
        }
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        if (bVar.eSq) {
            com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
            dVar.setPageUniqueId(this.fJu);
            dVar.bs(128);
            dVar.bt(1024);
            dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.concern.adapter.c.4
                @Override // com.baidu.card.d.a
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
            aVar.a(dVar);
        } else if (bVar.eSH) {
            aVar.a(new com.baidu.card.m(this.mPageContext.getPageActivity()));
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.TOP, viewGroup, this.anl);
        a2.setSourceForPb(1);
        ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fJu);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.c.5
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.adp.widget.ListView.g) && (view.getTag() instanceof ThreadCardViewHolder) && (((com.baidu.adp.widget.ListView.g) nVar).qx() instanceof com.baidu.tieba.card.data.b)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.g) nVar).qx();
                    bVar2.objType = 1;
                    if (c.this.ahf != null) {
                        c.this.ahf.a(threadCardViewHolder2.getView(), bVar2);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder) {
        if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || bVar.eMv == null) {
            return null;
        }
        bVar.yA(bVar.position + 1);
        threadCardViewHolder.ty().setPosition(i);
        if (threadCardViewHolder.ty() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.ty().setPage(this.aji);
        }
        if (bVar.eSq) {
            threadCardViewHolder.a(true, Align.ALIGN_RIGHT_TOP);
        } else if (bVar.eSH) {
            com.baidu.tieba.card.s.cva().e(bVar.cvv());
            com.baidu.tieba.a.d.bOm().e(bVar.cvv());
            com.baidu.tieba.homepage.personalize.a.a.a(bVar.eMv, this.fJu, bVar.cvm());
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.b>) bVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        return threadCardViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.b> c(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        if (bVar.eSv) {
            com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
            oVar.setObjectPool(this.fWD, this.fWE);
            oVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            oVar.setFromForPb(1);
            oVar.setFromCDN(this.alQ);
            oVar.setCornerStyle(1);
            aVar.c(oVar);
        } else if (bVar.izg) {
            com.baidu.card.y yVar = new com.baidu.card.y(this.mPageContext.getPageActivity());
            yVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            yVar.setFromCDN(this.alQ);
            aVar.c(yVar);
        } else if (bVar.eSu) {
            com.baidu.card.v vVar = new com.baidu.card.v(this.mPageContext.getPageActivity());
            vVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            vVar.setFromCDN(this.alQ);
            aVar.c(vVar);
        } else if (bVar.eSr) {
            com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext.getPageActivity());
            zVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            zVar.setFromCDN(this.alQ);
            aVar.c(zVar);
        } else if (bVar.izh) {
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anl);
        a2.setSourceForPb(1);
        ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fJu);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.c.6
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.adp.widget.ListView.g) && (view.getTag() instanceof ThreadCardViewHolder) && (((com.baidu.adp.widget.ListView.g) nVar).qx() instanceof com.baidu.tieba.card.data.b)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.g) nVar).qx();
                    bVar2.objType = 1;
                    if (c.this.ahf != null) {
                        c.this.ahf.a(threadCardViewHolder2.getView(), bVar2);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false);
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View c(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder) {
        if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || bVar.eMv == null) {
            return null;
        }
        bVar.yA(bVar.position + 1);
        com.baidu.tieba.card.s.cva().e(bVar.Jt("c12351"));
        threadCardViewHolder.ty().setPosition(i);
        if (threadCardViewHolder.ty() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.ty().setPage(this.aji);
        }
        if (bVar.izg) {
            com.baidu.card.y yVar = (com.baidu.card.y) threadCardViewHolder.ty().tr();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.aiw.amp.getLayoutParams();
            layoutParams.width = bVar.eSI;
            layoutParams.height = bVar.eSJ;
            if (yVar.aiw.amp.getVisibility() != 8) {
                yVar.aiw.amp.setLayoutParams(layoutParams);
            }
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.b>) bVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        return threadCardViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c  reason: avoid collision after fix types in other method */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.b> d(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.s sVar = new com.baidu.card.s(this.mPageContext.getPageActivity());
        sVar.tm();
        aVar.a((com.baidu.card.h) sVar);
        aVar.a((com.baidu.card.h) new ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.tk();
        aVar.a((com.baidu.card.h) kVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alQ);
        nVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.h) nVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.anl);
        a2.setSourceForPb(1);
        ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fJu);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.c.7
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.b bVar2;
                if ((nVar2 instanceof com.baidu.adp.widget.ListView.g) && (((com.baidu.adp.widget.ListView.g) nVar2).qx() instanceof com.baidu.tieba.card.data.b) && nVar2 != null && ((com.baidu.adp.widget.ListView.g) nVar2).qx() != null && (bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.g) nVar2).qx()) != null && bVar2.eMv != null && bVar2.eSD && bVar2.eMv.btx() != null) {
                    if (bVar2.eMv.getType() == bz.eTC) {
                        BdToast.b(c.this.mPageContext.getContext(), c.this.mPageContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bud();
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", String.valueOf(bVar2.eMv.btx().item_id));
                    hashMap.put("source", 2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                } else if ((nVar2 instanceof com.baidu.adp.widget.ListView.g) && (view.getTag() instanceof ThreadCardViewHolder) && (((com.baidu.adp.widget.ListView.g) nVar2).qx() instanceof com.baidu.tieba.card.data.b)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.b bVar3 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.g) nVar2).qx();
                    bVar3.objType = 1;
                    if (c.this.ahf != null) {
                        c.this.ahf.a(threadCardViewHolder2.getView(), bVar3);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bVar3, view.getContext(), 1, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View d(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder) {
        if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || bVar.eMv == null) {
            return null;
        }
        bVar.yA(bVar.position + 1);
        threadCardViewHolder.ty().setPosition(i);
        if (threadCardViewHolder.ty() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.ty().setPage(this.aji);
        }
        if (bVar.eSx) {
            com.baidu.tieba.card.s.cva().e(new aq("c13424"));
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.b>) bVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        return threadCardViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d  reason: avoid collision after fix types in other method */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.b> e(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eOz = 9;
        dVar.eOF = 9;
        amVar.setAgreeStatisticData(dVar);
        amVar.setFrom(4);
        amVar.setStType("personalize_page");
        amVar.setShareReportFrom(4);
        amVar.setFromForPb(1);
        amVar.bs(32);
        aVar.b(amVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.anl);
        a2.setSourceForPb(1);
        ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fJu);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.c.8
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.adp.widget.ListView.g) && (view.getTag() instanceof ThreadCardViewHolder) && (((com.baidu.adp.widget.ListView.g) nVar).qx() instanceof com.baidu.tieba.card.data.b)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.g) nVar).qx();
                    bVar2.objType = 1;
                    if (c.this.ahf != null) {
                        c.this.ahf.a(threadCardViewHolder2.getView(), bVar2);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* renamed from: e  reason: avoid collision after fix types in other method */
    public View e2(final int i, final View view, final ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, ThreadCardViewHolder threadCardViewHolder) {
        if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || bVar.eMv == null) {
            return null;
        }
        bVar.yA(bVar.position + 1);
        threadCardViewHolder.ty().setPosition(i);
        if (threadCardViewHolder.ty().ts() instanceof am) {
            ((am) threadCardViewHolder.ty().ts()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.concern.adapter.c.9
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup, view, i));
                    }
                }
            });
        }
        if (threadCardViewHolder.ty() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.ty().setPage(this.aji);
        }
        threadCardViewHolder.a(false, Align.ALIGN_RIGHT_BOTTOM);
        threadCardViewHolder.b((ThreadCardViewHolder) bVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fm(String str) {
        this.aji = str;
    }

    private void cQW() {
        com.baidu.tieba.card.data.k.izr = "c10705";
        com.baidu.tieba.card.data.k.izs = "c10730";
        com.baidu.tieba.card.data.k.izt = "c10731";
        com.baidu.tieba.card.data.k.izu = "c10704";
        com.baidu.tieba.card.data.k.izv = "c10755";
        com.baidu.tieba.card.data.k.izw = "c10710";
        com.baidu.tieba.card.data.k.izx = "c10736";
        com.baidu.tieba.card.data.k.izy = "c10737";
        com.baidu.tieba.card.data.k.izz = "c10711";
        com.baidu.tieba.card.data.k.izA = "c10758";
        com.baidu.tieba.card.data.k.izB = "c10757";
    }
}
