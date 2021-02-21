package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.ao;
import com.baidu.card.at;
import com.baidu.card.d;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class l extends com.baidu.tieba.frs.k<cb, ThreadCardViewHolder<cb>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String aif;
    private boolean akO;
    private com.baidu.adp.lib.d.b<ImageView> fUl;
    private com.baidu.adp.lib.d.b<GifView> fUm;
    private boolean fkD;
    private NEGFeedBackView.a hnH;
    private com.baidu.tieba.card.ab<cb> hnd;
    private HashSet<String> jqC;
    private int jqD;
    private com.baidu.tieba.frs.b.b jqE;
    private boolean jqW;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fkD = false;
        this.akO = true;
        this.jqD = 3;
        this.jqE = new com.baidu.tieba.frs.b.b();
        this.hnd = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ap("obj_type", 3).v("fid", cbVar.getFid()).dR("tid", cbVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 2, l.this.mPageId, l.this.jqE, l.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 15, l.this.mPageId, l.this.jqE, l.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 5, l.this.mPageId, l.this.jqE, l.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 14, l.this.mPageId, l.this.jqE, l.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 12, l.this.mPageId, l.this.jqE, l.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 13, l.this.mPageId, l.this.jqE, l.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(cbVar, 1, l.this.mPageId, l.this.jqE, l.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cKl().a(l.this.jqE, cbVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.b.c.cKl().a(l.this.jqE, cbVar, 1);
                    } else {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        ar arVar = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        arVar.dR("obj_type", "1");
                        arVar.dR("tid", cbVar.getTid());
                        TiebaStatic.log(arVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        ar arVar2 = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        arVar2.dR("obj_type", "3");
                        arVar2.dR("tid", cbVar.getTid());
                        TiebaStatic.log(arVar2);
                    }
                }
            }
        };
        this.fUl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bIt */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(l.this.mPageContext.getPageActivity());
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
        }, 8, 0);
        this.fUm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.frs.entelechy.adapter.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cxg */
            public GifView makeObject() {
                GifView gifView = new GifView(l.this.mPageContext.getPageActivity());
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
        this.hnH = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.l.4
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(av avVar) {
                TiebaStatic.log(new ar("c11973").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
                if (arrayList != null && avVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + ",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ar("c11974").dR("obj_locate", sb.toString()).dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmo()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", avVar.source).dR("weight", avVar.weight).dR("ab_tag", avVar.abTag).dR("extra", avVar.extra).ap(IntentConfig.CARD_TYPE, avVar.cardType).ap("obj_floor", avVar.eOs));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<cb> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bq(4280);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.l.5
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
        com.baidu.card.af afVar = new com.baidu.card.af(this.mPageContext);
        afVar.c(false);
        afVar.setFrom("frs");
        if (this.jqD == 502) {
            afVar.setNeedFrsTabName(false);
        } else {
            afVar.setNeedFrsTabName(true);
        }
        aVar.ti().bx(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(afVar);
        com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFrom("frs");
        oVar.setFromForPb(3);
        if (this.jqD == 502) {
            oVar.setNeedFrsTabName(false);
        } else {
            oVar.setNeedFrsTabName(true);
        }
        oVar.setObjectPool(this.fUl, this.fUm);
        oVar.setFromCDN(this.akO);
        oVar.c(true);
        oVar.bv(R.color.CAM_X0204);
        oVar.e(com.baidu.tbadk.a.b.b.bjL(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), com.baidu.tbadk.a.b.b.bjL(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        oVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.frs.entelechy.adapter.l.6
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bln() != null && aVar2.bln().eTc != null) {
                    az.a(aVar2.bln().eTc, l.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.h) oVar);
        aVar.a((com.baidu.card.h) new ao(this.mPageContext.getPageActivity()));
        at atVar = new at(this.mPageContext.getPageActivity());
        atVar.setPageContext(this.mPageContext);
        atVar.setFromForPb(3);
        aVar.a((com.baidu.card.h) atVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akO);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = 2;
        eVar.eMg = 2;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(3);
        amVar.setFromForPb(2);
        amVar.bq(48);
        aVar.b(amVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.iLY);
        a2.setSourceForPb(2);
        ThreadCardViewHolder<cb> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.l.7
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof cb) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = (cb) nVar2;
                    cbVar.objType = 1;
                    if (l.this.hnd != null) {
                        l.this.hnd.a(threadCardViewHolder2.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), l.this.jqD, false);
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        threadCardViewHolder.tk();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, cb cbVar, ThreadCardViewHolder<cb> threadCardViewHolder) {
        if (cbVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        threadCardViewHolder.tj().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) cbVar, (cb) threadCardViewHolder);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tj().td(), this.jfU);
        if (this.jfU != null && this.jfU.getForum() != null && !StringUtils.isNull(this.jfU.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jfU.getForum().getTopic_special_icon_right())) {
            cbVar.dD(this.jfU.getForum().getTopic_special_icon(), this.jfU.getForum().getTopic_special_icon_right());
        }
        boolean z = (cbVar.bnQ() == null || cbVar.bnQ().getUserId() == null || !cbVar.bnQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (cbVar.bph() && cbVar.getFeedBackReasonMap() != null && !z) {
            threadCardViewHolder.aK(true).a(this.hnH);
        }
        threadCardViewHolder.tl();
        if (threadCardViewHolder.tj().td() != null) {
            threadCardViewHolder.tj().td().bq(32);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) cbVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.hnd);
        if (this.jqE != null) {
            cbVar.eOs = (cbVar.position + 1) - (this.jfU != null ? this.jfU.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.b.c.cKl().a(this.jqE, cbVar);
        ar(cbVar);
        cbVar.bpd();
        com.baidu.tieba.frs.b.a.a(cbVar, this.mPageId, this.jqE, getTbPageTag());
        if (cbVar != null) {
            cbVar.bpd();
        }
        return threadCardViewHolder.getView();
    }

    private void ar(cb cbVar) {
        if (this.jqC == null) {
            this.jqC = new HashSet<>();
        }
        com.baidu.tieba.frs.b.c.cKl().a(cbVar, this.jqC);
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
        this.jqD = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jqE;
    }

    public void re(boolean z) {
        this.jqW = z;
    }
}
