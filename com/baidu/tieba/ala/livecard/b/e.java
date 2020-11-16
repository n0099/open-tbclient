package com.baidu.tieba.ala.livecard.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.z;
import com.baidu.tieba.pb.ThreadSkinView;
import tbclient.AppPosInfo;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.a<bx> implements com.baidu.tieba.a.e, z {
    private CardUserInfoLayout afT;
    private String ahw;
    private final View.OnClickListener ajJ;
    public TbImageView fEY;
    private TextView fFe;
    public LinearLayout fXC;
    private RelativeLayout gSw;
    private View gSz;
    private LinearLayout gTA;
    private View gTB;
    private boolean gTC;
    private boolean gTD;
    protected ThreadSourceShareAndPraiseLayout gTk;
    private com.baidu.tieba.ala.livecard.vc.a gTr;
    public ThreadSkinView gTv;
    private TbImageView gTw;
    public RelativeLayout gTx;
    private TBLottieAnimationView gTy;
    private TextView gTz;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.gTC = false;
        this.mLastScreenWidth = 0;
        this.ajJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cnv() != null) {
                    e.this.cnv().a(view, e.this.afN);
                }
            }
        };
        setTag(bdUniqueId);
        this.eGu = tbPageContext;
        View view = getView();
        this.gSw = (RelativeLayout) view.findViewById(R.id.layout_root);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gSw.getLayoutParams();
        if (com.baidu.tbadk.a.d.bhw()) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        } else {
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            layoutParams.bottomMargin = 0;
        }
        this.fXC = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.gSw.setOnClickListener(this);
        this.gTw = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.gTw.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.gTw.setDefaultBgResource(R.color.transparent);
        this.afT = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.afT.setUserAfterClickListener(this.ajJ);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.gTx = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fEY = (TbImageView) view.findViewById(R.id.image_video);
        this.fEY.setDrawCorner(true);
        this.fEY.setPlaceHolder(3);
        this.fEY.setDefaultResource(0);
        this.fEY.setDefaultErrorResource(0);
        this.fEY.setRadiusById(R.string.J_X05);
        TbImageView tbImageView = this.fEY;
        TbImageView tbImageView2 = this.fEY;
        tbImageView.setConrers(15);
        this.fEY.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fEY.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.fEY.setBorderSurroundContent(true);
        this.fEY.setDrawBorder(true);
        this.gTA = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.gTy = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.gTy.loop(true);
        ap.a(this.gTy, R.raw.ala_live2);
        this.gTy.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.gTy.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.gTy.cancelAnimation();
            }
        });
        this.fFe = (TextView) view.findViewById(R.id.play_count);
        this.gTz = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.gTB = view.findViewById(R.id.play_count_line);
        this.gSy = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.gSy);
        this.gSy.setSelectVisible(false);
        this.gSy.setIsBarViewVisible(false);
        this.gSy.setCommentNumEnable(true);
        this.gSy.setLiveShareEnable(false);
        this.gSy.setFrom(2);
        this.gSy.getCommentContainer().setOnClickListener(this);
        this.gSy.hideDisagree();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.exI = 2;
        dVar.exO = 2;
        this.gSy.setAgreeStatisticData(dVar);
        this.hVY = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.hVY);
        this.hVY.setFrom(2);
        this.hVY.setShareReportFrom(1);
        this.gTk = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.gTk.eWE.setOnClickListener(this);
        this.gTk.eWE.getCommentContainer().setOnClickListener(this);
        this.gTk.setFrom(2);
        this.gTk.setShareReportFrom(1);
        this.gTk.setSourceFromForPb(3);
        this.gTk.setStType("frs_page");
        this.gTk.setHideBarName(true);
        this.gSz = view.findViewById(R.id.divider_below_reply_number_layout);
        this.gTv = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.gTr = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.afT.getSuffixContainer());
        this.gTr.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.gSw).pb(com.baidu.tbadk.a.d.bhw() ? R.string.J_X02 : R.string.J_X06).aN(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.gTx).pd(R.dimen.L_X01).pc(R.color.CAM_X0401).pb(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            ap.a(this.gTA, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            ap.setBackgroundColor(this.gTB, R.color.CAM_X0101);
            ap.setViewTextColor(this.fFe, R.color.CAM_X0101);
            ap.setViewTextColor(this.gTz, R.color.CAM_X0101);
            this.afT.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fEY.setPlaceHolder(3);
            this.gSy.onChangeSkinType();
            this.mSkinType = i;
            if (this.gTk != null && this.gTk.getVisibility() == 0) {
                this.gTk.onChangeSkinType();
            }
        }
        if (this.afN != 0 && n.IB(((bx) this.afN).getId())) {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
        } else {
            ap.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
        }
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.gTr.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bx bxVar) {
        this.afN = bxVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cwO().cwI() && !com.baidu.tieba.frs.a.cwH().cwI()) {
            if (view == this.gSw || view == this.gSy.getCommentContainer() || view == this.fXC || view == this.gTk.eWE.getCommentContainer() || view == this.hVY.getCommentContainer()) {
                if (this.afN != 0) {
                    n.IA(((bx) this.afN).getId());
                }
                if (cnv() != null) {
                    cnv().a(this.gSw, this.afN);
                }
                b(getContext(), (bx) this.afN);
                if (this.afN != 0) {
                    if (view == this.gSy.getCommentContainer() || view == this.gTk.eWE.getCommentContainer()) {
                        ar arVar = new ar("c12942");
                        arVar.ak("obj_locate", 2);
                        arVar.ak("obj_type", 5);
                        arVar.dR("tid", ((bx) this.afN).getTid());
                        arVar.dR("nid", ((bx) this.afN).getNid());
                        TiebaStatic.log(arVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (cnv() != null) {
                    cnv().a(view, this.afN);
                }
                b(getContext(), (bx) this.afN);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.afN == 0 || ((bx) this.afN).blC() == null) {
            this.gSw.setVisibility(8);
            return;
        }
        this.gSw.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.eGu.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gTx.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - (com.baidu.tbadk.a.d.bhw() ? UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2 : (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gTx.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bx) this.afN).blW() != null && ((bx) this.afN).blW().user_info != null && ((bx) this.afN).blW().user_info.is_official == 2) {
            this.gTD = true;
            SparseArray<String> sparseArray2 = ((bx) this.afN).blW().dislikeInfo;
            this.gTw.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.gTw.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.gTw.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bx) this.afN).blW().liveStagePicUrl)) {
                this.gTw.startLoad(((bx) this.afN).blW().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.afT.getLayoutParams();
            marginLayoutParams.topMargin = this.eGu.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.afT.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.gTD = false;
            this.gTw.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.afT.getLayoutParams();
            marginLayoutParams2.topMargin = this.eGu.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.afT.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.gTD && sparseArray != null && sparseArray.size() > 0) {
            this.gTr.l((bx) this.afN, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.gTr.bVp() != null) {
            this.gTr.bVp().setVisibility(8);
        }
        ((bx) this.afN).z(false, true);
        this.afT.setData((bx) this.afN);
        SpannableStringBuilder bmm = ((bx) this.afN).bmm();
        if (bmm != null && !StringUtils.isNull(bmm.toString())) {
            this.mTextTitle.setText(((bx) this.afN).bmm());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bx) this.afN).blW().audience_count > 0) {
            this.gTB.setVisibility(0);
            this.fFe.setVisibility(0);
            this.fFe.setText(String.format(this.eGu.getResources().getString(R.string.ala_audience_count_prefix), au.numFormatOverWan(((bx) this.afN).blW().audience_count)));
        } else {
            this.gTB.setVisibility(8);
            this.fFe.setVisibility(8);
        }
        this.gTz.setVisibility(8);
        if (((bx) this.afN).blW().openRecomReason == 1) {
            String str = ((bx) this.afN).blW().recomReason;
            if (!StringUtils.isNull(str)) {
                this.gTz.setVisibility(0);
                this.gTz.setText(str);
            } else {
                String blR = ((bx) this.afN).blR();
                String blS = ((bx) this.afN).blS();
                if (UtilHelper.isDecimal(blR) && UtilHelper.isDecimal(blS) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dAL = com.baidu.tieba.recapp.d.a.dAG().dAL();
                    String str2 = dAL.latitude;
                    String str3 = dAL.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(blR), Double.parseDouble(blS)) <= 50.0d) {
                        this.gTz.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.gTz.setVisibility(0);
                    }
                }
            }
        }
        vD(tH(1));
        Y((bx) this.afN);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI()) ? 0 : 8);
        onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
        bVt();
        this.gTy.playAnimation();
        aO(this.gSw);
    }

    public void bVt() {
        if (k.biL().isShowImages() && this.afN != 0 && ((bx) this.afN).bjd() != null && ((bx) this.afN).bjd().blW() != null) {
            this.fEY.setPlaceHolder(3);
            this.fEY.startLoad(((bx) this.afN).bjd().blW().cover, 10, false);
            this.gTx.setVisibility(0);
            return;
        }
        this.gTx.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.gSy != null) {
            if (this.afT != null) {
                this.afT.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void mG(boolean z) {
        this.gTC = z;
    }

    private void Y(bx bxVar) {
        if (bxVar != null) {
            TiebaStatic.log(new ar("c12125").dR("tid", bxVar.getId()).ak("obj_locate", this.gTC ? 2 : 1).w("obj_id", bxVar.blW().live_id).ak("obj_type", 2));
            if (bxVar.blW() != null && bxVar.blW().user_info != null && bxVar.blW().user_info.is_official == 2) {
                TiebaStatic.log(new ar("c12800").dR("tid", bxVar.getId()));
            }
        }
    }

    private void m(bx bxVar, String str) {
        TiebaStatic.log(new ar("c12126").dR("tid", bxVar.getId()).ak("obj_locate", this.gTC ? 2 : 1).w("obj_id", bxVar.blW().live_id).ak("obj_type", 2));
        if (bxVar.blW() != null && bxVar.blW().user_info != null && bxVar.blW().user_info.is_official == 2) {
            TiebaStatic.log(new ar("c12801").dR("tid", bxVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bxVar.blG().equals(this.mForumName)) {
                TiebaStatic.log(new ar("c11843").dR("uid", currentAccount).w("fid", bxVar.getFid()));
            } else {
                TiebaStatic.log(new ar("c11845").dR("uid", currentAccount).w("fid", bxVar.getFid()));
            }
        }
    }

    public void b(Context context, bx bxVar) {
        String str;
        if (context != null && bxVar != null && bxVar.blW() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, R.string.no_network_guide);
                return;
            }
            String str2 = this.gTD ? "frs_live_stage_live" : "frs_play";
            if (bxVar.blo() != null) {
                str2 = bxVar.blo();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + bxVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + bxVar.getFid() : str2;
            }
            m(bxVar, str);
            AlaInfoData blW = bxVar.blW();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bxVar.blC() != null) {
                z = TextUtils.equals(bxVar.blC().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(blW);
            if (blW.user_info != null) {
                alaLiveInfoCoreData.userName = blW.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void vD(int i) {
        if (this.afN != 0) {
            if (i == 1) {
                this.gSy.setVisibility(8);
                this.gTk.setData((bx) this.afN);
                return;
            }
            this.gSz.setVisibility(this.gSy.setData((bx) this.afN) ? 8 : 0);
            this.gTk.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahw = str;
    }

    public int tH(int i) {
        return com.baidu.tieba.a.d.bIl().aw(this.ahw, i);
    }
}
