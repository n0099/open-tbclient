package com.baidu.tieba.ala.livecard.a;

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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
import com.baidu.tieba.pb.ThreadSkinView;
import tbclient.AppPosInfo;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.a<bz> implements com.baidu.tieba.a.e, y {
    private CardUserInfoLayout agx;
    private String air;
    private final View.OnClickListener akt;
    public TbImageView fRH;
    private TextView fRN;
    public LinearLayout gln;
    private RelativeLayout hiR;
    private View hiU;
    protected ThreadSourceShareAndPraiseLayout hjF;
    private com.baidu.tieba.ala.livecard.vc.a hjM;
    public ThreadSkinView hjQ;
    private TbImageView hjR;
    public RelativeLayout hjS;
    private TBLottieAnimationView hjT;
    private TextView hjU;
    private LinearLayout hjV;
    private View hjW;
    private boolean hjX;
    private boolean hjY;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.hjX = false;
        this.mLastScreenWidth = 0;
        this.akt = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.a.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.cqL() != null) {
                    e.this.cqL().a(view, e.this.agr);
                }
            }
        };
        setTag(bdUniqueId);
        this.eSJ = tbPageContext;
        View view = getView();
        this.hiR = (RelativeLayout) view.findViewById(R.id.layout_root);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hiR.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.gln = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.hiR.setOnClickListener(this);
        this.hjR = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.hjR.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.hjR.setDefaultBgResource(R.color.transparent);
        this.agx = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.agx.setUserAfterClickListener(this.akt);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.hjS = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.fRH = (TbImageView) view.findViewById(R.id.image_video);
        this.fRH.setDrawCorner(true);
        this.fRH.setPlaceHolder(3);
        this.fRH.setDefaultResource(0);
        this.fRH.setRadiusById(R.string.J_X05);
        TbImageView tbImageView = this.fRH;
        TbImageView tbImageView2 = this.fRH;
        tbImageView.setConrers(15);
        this.fRH.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fRH.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.fRH.setBorderSurroundContent(true);
        this.fRH.setDrawBorder(true);
        this.hjV = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.hjT = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.hjT.loop(true);
        ao.a(this.hjT, R.raw.ala_live2);
        this.hjT.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.a.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.hjT.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.hjT.cancelAnimation();
            }
        });
        this.fRN = (TextView) view.findViewById(R.id.play_count);
        this.hjU = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.hjW = view.findViewById(R.id.play_count_line);
        this.hiT = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.hiT);
        this.hiT.setSelectVisible(false);
        this.hiT.setIsBarViewVisible(false);
        this.hiT.setCommentNumEnable(true);
        this.hiT.setLiveShareEnable(false);
        this.hiT.setFrom(2);
        this.hiT.getCommentContainer().setOnClickListener(this);
        this.hiT.hideDisagree();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eJO = 2;
        dVar.eJU = 2;
        this.hiT.setAgreeStatisticData(dVar);
        this.ioL = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.ioL);
        this.ioL.setFrom(2);
        this.ioL.setShareReportFrom(1);
        this.hjF = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.hjF.fjb.setOnClickListener(this);
        this.hjF.fjb.getCommentContainer().setOnClickListener(this);
        this.hjF.setFrom(2);
        this.hjF.setShareReportFrom(1);
        this.hjF.setSourceFromForPb(3);
        this.hjF.setStType("frs_page");
        this.hjF.setHideBarName(true);
        this.hiU = view.findViewById(R.id.divider_below_reply_number_layout);
        this.hjQ = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.hjM = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.agx.getSuffixContainer());
        this.hjM.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            g(tbPageContext, i);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.hiR).od(R.string.J_X06).aM(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.hjS).og(R.dimen.L_X01).of(R.color.CAM_X0401).od(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
            int dimens = l.getDimens(getContext(), R.dimen.tbds31);
            ao.a(this.hjV, R.color.CAM_X0310, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, dimens, dimens, dimens, dimens, dimens, dimens});
            ao.setBackgroundColor(this.hjW, R.color.CAM_X0101);
            ao.setViewTextColor(this.fRN, R.color.CAM_X0101);
            ao.setViewTextColor(this.hjU, R.color.CAM_X0101);
            this.agx.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.fRH.setPlaceHolder(3);
            this.hiT.onChangeSkinType();
            this.mSkinType = i;
            if (this.hjF != null && this.hjF.getVisibility() == 0) {
                this.hjF.onChangeSkinType();
            }
        }
        if (this.agr != 0 && m.Id(((bz) this.agr).getId())) {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0109);
        } else {
            ao.setViewTextColor(this.mTextTitle, R.color.CAM_X0105);
        }
        ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.hjM.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bz bzVar) {
        this.agr = bzVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void uN(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.cAg().cAa() && !com.baidu.tieba.frs.a.czZ().cAa()) {
            if (view == this.hiR || view == this.hiT.getCommentContainer() || view == this.gln || view == this.hjF.fjb.getCommentContainer() || view == this.ioL.getCommentContainer()) {
                if (this.agr != 0) {
                    m.Ic(((bz) this.agr).getId());
                }
                if (cqL() != null) {
                    cqL().a(this.hiR, this.agr);
                }
                b(getContext(), (bz) this.agr);
                if (this.agr != 0) {
                    if (view == this.hiT.getCommentContainer() || view == this.hjF.fjb.getCommentContainer()) {
                        aq aqVar = new aq("c12942");
                        aqVar.an("obj_locate", 2);
                        aqVar.an("obj_type", 5);
                        aqVar.dW("tid", ((bz) this.agr).getTid());
                        aqVar.dW(IntentConfig.NID, ((bz) this.agr).blV());
                        com.baidu.tbadk.pageExtra.c bV = com.baidu.tbadk.pageExtra.d.bV(view);
                        if (bV != null) {
                            aqVar.dW("obj_cur_page", bV.getCurrentPageKey());
                        }
                        if (com.baidu.tbadk.pageExtra.d.bDu() != null) {
                            aqVar.dW("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDu());
                        }
                        TiebaStatic.log(aqVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (cqL() != null) {
                    cqL().a(view, this.agr);
                }
                b(getContext(), (bz) this.agr);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.agr == 0 || ((bz) this.agr).bnx() == null) {
            this.hiR.setVisibility(8);
            return;
        }
        this.hiR.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.eSJ.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hjS.getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.hjS.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bz) this.agr).bnQ() != null && ((bz) this.agr).bnQ().user_info != null && ((bz) this.agr).bnQ().user_info.is_official == 2) {
            this.hjY = true;
            SparseArray<String> sparseArray2 = ((bz) this.agr).bnQ().dislikeInfo;
            this.hjR.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.hjR.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.hjR.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bz) this.agr).bnQ().liveStagePicUrl)) {
                this.hjR.startLoad(((bz) this.agr).bnQ().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.agx.getLayoutParams();
            marginLayoutParams.topMargin = this.eSJ.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.agx.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.hjY = false;
            this.hjR.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.agx.getLayoutParams();
            marginLayoutParams2.topMargin = this.eSJ.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.agx.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.hjY && sparseArray != null && sparseArray.size() > 0) {
            this.hjM.l((bz) this.agr, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.hjM.bXQ() != null) {
            this.hjM.bXQ().setVisibility(8);
        }
        ((bz) this.agr).z(false, true);
        this.agx.setData((bz) this.agr);
        SpannableStringBuilder bog = ((bz) this.agr).bog();
        if (bog != null && !StringUtils.isNull(bog.toString())) {
            this.mTextTitle.setText(((bz) this.agr).bog());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bz) this.agr).bnQ().audience_count > 0) {
            this.hjW.setVisibility(0);
            this.fRN.setVisibility(0);
            this.fRN.setText(String.format(this.eSJ.getResources().getString(R.string.ala_audience_count_prefix), at.numFormatOverWan(((bz) this.agr).bnQ().audience_count)));
        } else {
            this.hjW.setVisibility(8);
            this.fRN.setVisibility(8);
        }
        this.hjU.setVisibility(8);
        if (((bz) this.agr).bnQ().openRecomReason == 1) {
            String str = ((bz) this.agr).bnQ().recomReason;
            if (!StringUtils.isNull(str)) {
                this.hjU.setVisibility(0);
                this.hjU.setText(str);
            } else {
                String latitude = ((bz) this.agr).getLatitude();
                String bnM = ((bz) this.agr).bnM();
                if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(bnM) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo dCb = com.baidu.tieba.recapp.c.a.dBW().dCb();
                    String str2 = dCb.latitude;
                    String str3 = dCb.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(bnM)) <= 50.0d) {
                        this.hjU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.hjU.setVisibility(0);
                    }
                }
            }
        }
        uP(sR(1));
        Y((bz) this.agr);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa()) ? 0 : 8);
        onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
        bXU();
        this.hjT.playAnimation();
        ba(this.hiR);
    }

    public void bXU() {
        if (k.bkB().isShowImages() && this.agr != 0 && ((bz) this.agr).bkV() != null && ((bz) this.agr).bkV().bnQ() != null) {
            this.fRH.setPlaceHolder(3);
            this.fRH.startLoad(((bz) this.agr).bkV().bnQ().cover, 10, false);
            this.hjS.setVisibility(0);
            return;
        }
        this.hjS.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.hiT != null) {
            if (this.agx != null) {
                this.agx.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void nw(boolean z) {
        this.hjX = z;
    }

    private void Y(bz bzVar) {
        if (bzVar != null) {
            TiebaStatic.log(new aq("c12125").dW("tid", bzVar.getId()).an("obj_locate", this.hjX ? 2 : 1).w("obj_id", bzVar.bnQ().live_id).an("obj_type", 2));
            if (bzVar.bnQ() != null && bzVar.bnQ().user_info != null && bzVar.bnQ().user_info.is_official == 2) {
                TiebaStatic.log(new aq("c12800").dW("tid", bzVar.getId()));
            }
        }
    }

    private void m(bz bzVar, String str) {
        TiebaStatic.log(new aq("c12126").dW("tid", bzVar.getId()).an("obj_locate", this.hjX ? 2 : 1).w("obj_id", bzVar.bnQ().live_id).an("obj_type", 2));
        if (bzVar.bnQ() != null && bzVar.bnQ().user_info != null && bzVar.bnQ().user_info.is_official == 2) {
            TiebaStatic.log(new aq("c12801").dW("tid", bzVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (bzVar.bnB().equals(this.mForumName)) {
                TiebaStatic.log(new aq("c11843").dW("uid", currentAccount).w("fid", bzVar.getFid()));
            } else {
                TiebaStatic.log(new aq("c11845").dW("uid", currentAccount).w("fid", bzVar.getFid()));
            }
        }
    }

    public void b(Context context, bz bzVar) {
        String str;
        if (context != null && bzVar != null && bzVar.bnQ() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, R.string.no_network_guide);
                return;
            }
            String str2 = this.hjY ? "frs_live_stage_live" : "frs_play";
            if (bzVar.bnj() != null) {
                str2 = bzVar.bnj();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + bzVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + bzVar.getFid() : str2;
            }
            m(bzVar, str);
            AlaInfoData bnQ = bzVar.bnQ();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && bzVar.bnx() != null) {
                z = TextUtils.equals(bzVar.bnx().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bnQ);
            if (bnQ.user_info != null) {
                alaLiveInfoCoreData.userName = bnQ.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void uP(int i) {
        if (this.agr != 0) {
            if (i == 1) {
                this.hiT.setVisibility(8);
                this.hjF.setData((bz) this.agr);
                return;
            }
            this.hiU.setVisibility(this.hiT.setData((bz) this.agr) ? 8 : 0);
            this.hjF.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.air = str;
    }

    public int sR(int i) {
        return com.baidu.tieba.a.d.bKv().az(this.air, i);
    }
}
