package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.an;
import com.baidu.card.au;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class l extends com.baidu.tieba.frs.k<by, com.baidu.card.am<by>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aiw;
    private boolean alo;
    private com.baidu.adp.lib.d.b<ImageView> fMZ;
    private com.baidu.adp.lib.d.b<GifView> fNa;
    private boolean fdm;
    private com.baidu.tieba.card.ab<by> hbw;
    private NEGFeedBackView.a hca;
    private HashSet<String> jcS;
    private int jcT;
    private com.baidu.tieba.frs.d.b jcU;
    private boolean jdt;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fdm = false;
        this.alo = true;
        this.jcT = 3;
        this.jcU = new com.baidu.tieba.frs.d.b();
        this.hbw = new com.baidu.tieba.card.ab<by>() { // from class: com.baidu.tieba.frs.entelechy.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                if (view != null && byVar != null) {
                    if ("c13010".equals(l.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").al("obj_type", 3).w("fid", byVar.getFid()).dY("tid", byVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(byVar, 2, l.this.mPageId, l.this.jcU, l.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(byVar, 15, l.this.mPageId, l.this.jcU, l.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 5, l.this.mPageId, l.this.jcU, l.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 14, l.this.mPageId, l.this.jcU, l.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 12, l.this.mPageId, l.this.jcU, l.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 13, l.this.mPageId, l.this.jcU, l.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(byVar, 1, l.this.mPageId, l.this.jcU, l.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cJI().a(l.this.jcU, byVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.cJI().a(l.this.jcU, byVar, 1);
                    } else {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        ar arVar = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        arVar.dY("obj_type", "1");
                        arVar.dY("tid", byVar.getTid());
                        TiebaStatic.log(arVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        ar arVar2 = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        arVar2.dY("obj_type", "3");
                        arVar2.dY("tid", byVar.getTid());
                        TiebaStatic.log(arVar2);
                    }
                }
            }
        };
        this.fMZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bJz */
            public ImageView makeObject() {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(l.this.mPageContext.getPageActivity());
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
        }, 8, 0);
        this.fNa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.frs.entelechy.a.l.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cwL */
            public GifView makeObject() {
                GifView gifView = new GifView(l.this.mPageContext.getPageActivity());
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
        this.hca = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.l.4
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                TiebaStatic.log(new ar("c11973").dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                if (arrayList != null && atVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + ",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ar("c11974").dY("obj_locate", sb.toString()).dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("nid", atVar.getNid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("source", atVar.source).dY("weight", atVar.weight).dY("ab_tag", atVar.abTag).dY("extra", atVar.extra).al(IntentConfig.CARD_TYPE, atVar.cardType).al("obj_floor", atVar.eHa));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.am<by> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bs(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.l.5
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
        com.baidu.card.af afVar = new com.baidu.card.af(this.mPageContext);
        afVar.b((Boolean) false);
        afVar.setFrom("frs");
        if (this.jcT == 502) {
            afVar.setNeedFrsTabName(false);
        } else {
            afVar.setNeedFrsTabName(true);
        }
        aVar.tY().bz(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(afVar);
        com.baidu.card.o oVar = new com.baidu.card.o(this.mPageContext.getPageActivity());
        oVar.setFrom("frs");
        oVar.setFromForPb(3);
        if (this.jcT == 502) {
            oVar.setNeedFrsTabName(false);
        } else {
            oVar.setNeedFrsTabName(true);
        }
        oVar.setObjectPool(this.fMZ, this.fNa);
        oVar.setFromCDN(this.alo);
        oVar.b((Boolean) true);
        oVar.bx(R.color.CAM_X0204);
        oVar.e(com.baidu.tbadk.a.b.a.bkK(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), com.baidu.tbadk.a.b.a.bkK(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        oVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.l.6
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bmn() != null && aVar2.bmn().eLH != null) {
                    az.a(aVar2.bmn().eLH, l.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.i) oVar);
        aVar.a((com.baidu.card.i) new com.baidu.card.ap(this.mPageContext.getPageActivity()));
        au auVar = new au(this.mPageContext.getPageActivity());
        auVar.setPageContext(this.mPageContext);
        auVar.setFromForPb(3);
        aVar.a((com.baidu.card.i) auVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alo);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 2;
        dVar.eEP = 2;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(3);
        anVar.setFromForPb(2);
        anVar.bs(48);
        aVar.b(anVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.iyv);
        a2.setSourceForPb(2);
        com.baidu.card.am<by> amVar = new com.baidu.card.am<>(a2);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.l.7
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof by) && (view.getTag() instanceof com.baidu.card.am)) {
                    com.baidu.card.am amVar2 = (com.baidu.card.am) view.getTag();
                    by byVar = (by) qVar;
                    byVar.objType = 1;
                    if (l.this.hbw != null) {
                        l.this.hbw.a(amVar2.getView(), byVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), l.this.jcT, false);
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        amVar.ua();
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, com.baidu.card.am<by> amVar) {
        if (byVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        if (amVar.tZ() instanceof com.baidu.tieba.a.e) {
            amVar.tZ().setPage(this.aiw);
        }
        amVar.tZ().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) amVar);
        com.baidu.tieba.frs.j.a(amVar.tZ().tT(), this.iSv);
        if (this.iSv != null && this.iSv.getForum() != null && !StringUtils.isNull(this.iSv.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iSv.getForum().getTopic_special_icon_right())) {
            byVar.dL(this.iSv.getForum().getTopic_special_icon(), this.iSv.getForum().getTopic_special_icon_right());
        }
        boolean z = (byVar.boP() == null || byVar.boP().getUserId() == null || !byVar.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (byVar.bqg() && byVar.getFeedBackReasonMap() != null && !z) {
            amVar.aN(true).a(this.hca);
        }
        amVar.ub();
        if (amVar.tZ().tT() != null) {
            amVar.tZ().tT().bs(32);
        }
        amVar.b((com.baidu.card.am<by>) byVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.hbw);
        if (this.jcU != null) {
            byVar.eHa = (byVar.position + 1) - (this.iSv != null ? this.iSv.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cJI().a(this.jcU, byVar);
        aq(byVar);
        byVar.bqd();
        com.baidu.tieba.frs.d.a.a(byVar, this.mPageId, this.jcU, getTbPageTag());
        if (byVar != null) {
            byVar.bqd();
        }
        return amVar.getView();
    }

    private void aq(by byVar) {
        if (this.jcS == null) {
            this.jcS = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.cJI().a(byVar, this.jcS);
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
        this.jcT = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.jcU;
    }

    public void qA(boolean z) {
        this.jdt = z;
    }
}
