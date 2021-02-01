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
import com.baidu.card.aa;
import com.baidu.card.ag;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.d;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.BdToast;
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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.b, ThreadCardViewHolder<com.baidu.tieba.card.data.b>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.b> agg;
    private String aif;
    private boolean akO;
    private com.baidu.adp.widget.ListView.s amk;
    public BdUniqueId fGZ;
    private com.baidu.adp.lib.d.b<ImageView> fUl;
    private com.baidu.adp.lib.d.b<GifView> fUm;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View e(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder) {
        return e2(i, view, viewGroup, bVar, (ThreadCardViewHolder) threadCardViewHolder);
    }

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akO = true;
        this.fUl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bIt */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(c.this.mPageContext.getPageActivity());
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
        this.fUm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cwZ */
            public GifView makeObject() {
                GifView gifView = new GifView(c.this.mPageContext.getPageActivity());
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
        this.agg = new ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                c.this.a(view, bVar);
            }
        };
        this.mPageContext = tbPageContext;
        cPb();
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amk = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        int i;
        ar csO;
        if (view != null && bVar != null && bVar.bln() != null && !StringUtils.isNull(bVar.bln().getTid())) {
            int id = view.getId();
            if (bVar.ePR) {
                if (id == R.id.thread_card_root) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                } else if (id == R.id.user_avatar || id == R.id.user_name) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 1);
                }
            } else if (bVar.eQi) {
                com.baidu.tieba.card.t.csu().mG(true);
                if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                    TiebaStatic.log(bVar.csN());
                    com.baidu.tieba.a.d.bKP().a("page_concern", "clk_", bVar.csN());
                    i = 9;
                } else {
                    if (bVar.bmv()) {
                        csO = bVar.csP();
                    } else {
                        csO = bVar.csO();
                    }
                    TiebaStatic.log(csO);
                    com.baidu.tieba.a.d.bKP().a("page_concern", "clk_", csO);
                    i = 1;
                }
                com.baidu.tieba.homepage.personalize.a.a.a(bVar.eJQ, this.fGZ, bVar.csH(), i);
            } else if (bVar.ePW || bVar.iAj || bVar.ePV || bVar.ePS) {
                if (view.getId() == R.id.thread_card_root) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                } else if (view instanceof TbImageView) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 3);
                } else if (view.getId() == R.id.thread_card_title || view.getId() == R.id.thread_card_abstract) {
                    com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                }
            } else if (!bVar.eQe) {
                if (bVar.eQg) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    if (threadCardViewHolder != null) {
                        az.a((com.baidu.tbadk.core.data.a) bVar.bln(), view.getContext(), 1, false);
                        threadCardViewHolder.tj().b(new a.C0089a(1));
                    }
                } else if (!bVar.eQh) {
                    if (bVar.iAl) {
                        if (view.getId() == R.id.thread_card_root) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                        } else if (id == R.id.forum_name_text) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 7);
                        }
                    } else if (bVar.ePY) {
                        if (view.getId() == R.id.thread_card_root) {
                            com.baidu.tieba.homepage.concern.c.a(view, bVar, 2);
                        } else if (id == R.id.god_reply_voice_btn) {
                            ar arVar = new ar("c13423");
                            arVar.ap("obj_locate", 4);
                            arVar.dR("tid", bVar.tid);
                            if (bVar.eJQ != null && bVar.eJQ.bpv() != null) {
                                arVar.dR("pid", bVar.eJQ.bpv().getId());
                            }
                            TiebaStatic.log(arVar);
                        } else if (id == R.id.god_reply_content) {
                            ar arVar2 = new ar("c13423");
                            arVar2.ap("obj_locate", 2);
                            arVar2.dR("tid", bVar.tid);
                            if (bVar.eJQ != null && bVar.eJQ.bpv() != null) {
                                arVar2.dR("pid", bVar.eJQ.bpv().getId());
                            }
                            TiebaStatic.log(arVar2);
                        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                            ar arVar3 = new ar("c13423");
                            arVar3.ap("obj_locate", 1);
                            arVar3.dR("tid", bVar.tid);
                            if (bVar.eJQ != null && bVar.eJQ.bpv() != null) {
                                arVar3.dR("pid", bVar.eJQ.bpv().getId());
                            }
                            TiebaStatic.log(arVar3);
                        } else if (id == R.id.god_reply_agree_view) {
                            ar arVar4 = new ar("c13423");
                            arVar4.ap("obj_locate", 5);
                            arVar4.dR("tid", bVar.tid);
                            if (bVar.eJQ != null && bVar.eJQ.bpv() != null) {
                                arVar4.dR("pid", bVar.eJQ.bpv().getId());
                            }
                            TiebaStatic.log(arVar4);
                        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                            ar arVar5 = new ar("c13423");
                            arVar5.ap("obj_locate", 3);
                            arVar5.dR("tid", bVar.tid);
                            if (bVar.eJQ != null && bVar.eJQ.bpv() != null) {
                                arVar5.dR("pid", bVar.eJQ.bpv().getId());
                            }
                            TiebaStatic.log(arVar5);
                        }
                    } else if (bVar.ePX && (view.getId() == R.id.thread_card_root || view.getId() == R.id.thread_info_commont_container)) {
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
    public BdUniqueId ql() {
        return com.baidu.tieba.card.data.b.izQ;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qm() {
        return com.baidu.tieba.card.data.b.izV;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qn() {
        return com.baidu.tieba.card.data.b.izY;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qo() {
        return com.baidu.tieba.card.data.b.izZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.b> b(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        if (bVar == null) {
            return null;
        }
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        if (bVar.ePR) {
            com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
            dVar.setPageUniqueId(this.fGZ);
            dVar.bq(128);
            dVar.br(1024);
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
        } else if (bVar.eQi) {
            aVar.a(new com.baidu.card.m(this.mPageContext.getPageActivity()));
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.TOP, viewGroup, this.amk);
        a2.setSourceForPb(1);
        ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.c.5
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.adp.widget.ListView.g) && (view.getTag() instanceof ThreadCardViewHolder) && (((com.baidu.adp.widget.ListView.g) nVar).qv() instanceof com.baidu.tieba.card.data.b)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.g) nVar).qv();
                    bVar2.objType = 1;
                    if (c.this.agg != null) {
                        c.this.agg.a(threadCardViewHolder2.getView(), bVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder) {
        if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || bVar.eJQ == null) {
            return null;
        }
        bVar.xd(bVar.position + 1);
        threadCardViewHolder.tj().setPosition(i);
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        if (bVar.ePR) {
            threadCardViewHolder.a(true, Align.ALIGN_RIGHT_TOP);
        } else if (bVar.eQi) {
            com.baidu.tieba.card.t.csu().e(bVar.csQ());
            com.baidu.tieba.a.d.bKP().e(bVar.csQ());
            com.baidu.tieba.homepage.personalize.a.a.a(bVar.eJQ, this.fGZ, bVar.csH());
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.b>) bVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.agg);
        return threadCardViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.b> c(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        if (bVar.ePW) {
            com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
            oVar.setObjectPool(this.fUl, this.fUm);
            oVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            oVar.setFromForPb(1);
            oVar.setFromCDN(this.akO);
            oVar.setCornerStyle(1);
            aVar.c(oVar);
        } else if (bVar.iAj) {
            com.baidu.card.y yVar = new com.baidu.card.y(this.mPageContext.getPageActivity());
            yVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            yVar.setFromCDN(this.akO);
            aVar.c(yVar);
        } else if (bVar.ePV) {
            com.baidu.card.v vVar = new com.baidu.card.v(this.mPageContext.getPageActivity());
            vVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            vVar.setFromCDN(this.akO);
            aVar.c(vVar);
        } else if (bVar.ePS) {
            com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext.getPageActivity());
            zVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            zVar.setFromCDN(this.akO);
            aVar.c(zVar);
        } else if (bVar.iAk) {
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amk);
        a2.setSourceForPb(1);
        ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.c.6
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.adp.widget.ListView.g) && (view.getTag() instanceof ThreadCardViewHolder) && (((com.baidu.adp.widget.ListView.g) nVar).qv() instanceof com.baidu.tieba.card.data.b)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.g) nVar).qv();
                    bVar2.objType = 1;
                    if (c.this.agg != null) {
                        c.this.agg.a(threadCardViewHolder2.getView(), bVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false);
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View c(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder) {
        if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || bVar.eJQ == null) {
            return null;
        }
        bVar.xd(bVar.position + 1);
        com.baidu.tieba.card.t.csu().e(bVar.IS("c12351"));
        threadCardViewHolder.tj().setPosition(i);
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        if (bVar.iAj) {
            com.baidu.card.y yVar = (com.baidu.card.y) threadCardViewHolder.tj().tc();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.ahs.alo.getLayoutParams();
            layoutParams.width = bVar.eQj;
            layoutParams.height = bVar.eQk;
            if (yVar.ahs.alo.getVisibility() != 8) {
                yVar.ahs.alo.setLayoutParams(layoutParams);
            }
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.b>) bVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.agg);
        return threadCardViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c  reason: avoid collision after fix types in other method */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.b> d(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.s sVar = new com.baidu.card.s(this.mPageContext.getPageActivity());
        sVar.sY();
        aVar.a((com.baidu.card.h) sVar);
        aVar.a((com.baidu.card.h) new ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new aa(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.sW();
        aVar.a((com.baidu.card.h) kVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akO);
        nVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.h) nVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.amk);
        a2.setSourceForPb(1);
        ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.c.7
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.b bVar2;
                if ((nVar2 instanceof com.baidu.adp.widget.ListView.g) && (((com.baidu.adp.widget.ListView.g) nVar2).qv() instanceof com.baidu.tieba.card.data.b) && nVar2 != null && ((com.baidu.adp.widget.ListView.g) nVar2).qv() != null && (bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.g) nVar2).qv()) != null && bVar2.eJQ != null && bVar2.eQe && bVar2.eJQ.bpW() != null) {
                    if (bVar2.eJQ.getType() == cb.eRd) {
                        BdToast.b(c.this.mPageContext.getContext(), c.this.mPageContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqD();
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemID", String.valueOf(bVar2.eJQ.bpW().item_id));
                    hashMap.put("source", 2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                } else if ((nVar2 instanceof com.baidu.adp.widget.ListView.g) && (view.getTag() instanceof ThreadCardViewHolder) && (((com.baidu.adp.widget.ListView.g) nVar2).qv() instanceof com.baidu.tieba.card.data.b)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.b bVar3 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.g) nVar2).qv();
                    bVar3.objType = 1;
                    if (c.this.agg != null) {
                        c.this.agg.a(threadCardViewHolder2.getView(), bVar3);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bVar3, view.getContext(), 1, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View d(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder) {
        if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || bVar.eJQ == null) {
            return null;
        }
        bVar.xd(bVar.position + 1);
        threadCardViewHolder.tj().setPosition(i);
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        if (bVar.ePY) {
            com.baidu.tieba.card.t.csu().e(new ar("c13424"));
        }
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.b>) bVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.agg);
        return threadCardViewHolder.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d  reason: avoid collision after fix types in other method */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.b> e(ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = 9;
        eVar.eMg = 9;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(4);
        amVar.setStType("personalize_page");
        amVar.setShareReportFrom(4);
        amVar.setFromForPb(1);
        amVar.bq(32);
        aVar.b(amVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.amk);
        a2.setSourceForPb(1);
        ThreadCardViewHolder<com.baidu.tieba.card.data.b> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.c.8
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.adp.widget.ListView.g) && (view.getTag() instanceof ThreadCardViewHolder) && (((com.baidu.adp.widget.ListView.g) nVar).qv() instanceof com.baidu.tieba.card.data.b)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.b bVar2 = (com.baidu.tieba.card.data.b) ((com.baidu.adp.widget.ListView.g) nVar).qv();
                    bVar2.objType = 1;
                    if (c.this.agg != null) {
                        c.this.agg.a(threadCardViewHolder2.getView(), bVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bVar2, view.getContext(), 1, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* renamed from: e  reason: avoid collision after fix types in other method */
    public View e2(final int i, final View view, final ViewGroup viewGroup, com.baidu.tieba.card.data.b bVar, ThreadCardViewHolder threadCardViewHolder) {
        if (bVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || bVar.eJQ == null) {
            return null;
        }
        bVar.xd(bVar.position + 1);
        threadCardViewHolder.tj().setPosition(i);
        if (threadCardViewHolder.tj().td() instanceof am) {
            ((am) threadCardViewHolder.tj().td()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.concern.adapter.c.9
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup, view, i));
                    }
                }
            });
        }
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        threadCardViewHolder.a(false, Align.ALIGN_RIGHT_BOTTOM);
        threadCardViewHolder.b((ThreadCardViewHolder) bVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.agg);
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ey(String str) {
        this.aif = str;
    }

    private void cPb() {
        com.baidu.tieba.card.data.k.iAu = "c10705";
        com.baidu.tieba.card.data.k.iAv = "c10730";
        com.baidu.tieba.card.data.k.iAw = "c10731";
        com.baidu.tieba.card.data.k.iAx = "c10704";
        com.baidu.tieba.card.data.k.iAy = "c10755";
        com.baidu.tieba.card.data.k.iAz = "c10710";
        com.baidu.tieba.card.data.k.iAA = "c10736";
        com.baidu.tieba.card.data.k.iAB = "c10737";
        com.baidu.tieba.card.data.k.iAC = "c10711";
        com.baidu.tieba.card.data.k.iAD = "c10758";
        com.baidu.tieba.card.data.k.iAE = "c10757";
    }
}
