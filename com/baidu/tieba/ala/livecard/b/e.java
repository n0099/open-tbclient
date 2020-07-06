package com.baidu.tieba.ala.livecard.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.y;
import com.baidu.tieba.pb.ThreadSkinView;
import tbclient.AppPosInfo;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<bu> implements com.baidu.tieba.a.e, y {
    private CardUserInfoLayout aeg;
    private String afG;
    private final View.OnClickListener ahM;
    public TbImageView eKV;
    private TextView eLb;
    private RelativeLayout fRG;
    private View fRJ;
    private com.baidu.tieba.ala.livecard.vc.a fSB;
    public ThreadSkinView fSF;
    private TbImageView fSG;
    public RelativeLayout fSH;
    private TBLottieAnimationView fSI;
    private TextView fSJ;
    private LinearLayout fSK;
    private View fSL;
    private boolean fSM;
    private boolean fSN;
    protected ThreadSourceShareAndPraiseLayout fSu;
    public LinearLayout fdX;
    private View mDivider;
    private String mForumName;
    private int mLastScreenWidth;
    private View mMaskView;
    private TextView mTextTitle;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.fSM = false;
        this.mLastScreenWidth = 0;
        this.ahM = new View.OnClickListener() { // from class: com.baidu.tieba.ala.livecard.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.bOd() != null) {
                    e.this.bOd().a(view, e.this.aea);
                }
            }
        };
        setTag(bdUniqueId);
        this.dPv = tbPageContext;
        View view = getView();
        this.fRG = (RelativeLayout) view.findViewById(R.id.layout_root);
        this.fdX = (LinearLayout) view.findViewById(R.id.video_card_content_layout);
        this.fRG.setOnClickListener(this);
        this.fSG = (TbImageView) view.findViewById(R.id.video_card_stage_view);
        this.fSG.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.fSG.setDefaultBgResource(R.color.transparent);
        this.aeg = (CardUserInfoLayout) view.findViewById(R.id.card_ala_video_user_info_layout);
        this.aeg.setUserAfterClickListener(this.ahM);
        this.mTextTitle = (TextView) view.findViewById(R.id.text_title);
        this.fSH = (RelativeLayout) view.findViewById(R.id.frame_video);
        this.eKV = (TbImageView) view.findViewById(R.id.image_video);
        this.eKV.setDrawCorner(true);
        this.eKV.setPlaceHolder(3);
        this.eKV.setDefaultResource(0);
        this.eKV.setDefaultErrorResource(0);
        this.eKV.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        TbImageView tbImageView = this.eKV;
        TbImageView tbImageView2 = this.eKV;
        tbImageView.setConrers(15);
        this.eKV.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eKV.setBorderColor(an.getColor(R.color.cp_border_a));
        this.eKV.setBorderSurroundContent(true);
        this.eKV.setDrawBorder(true);
        this.fSK = (LinearLayout) view.findViewById(R.id.ala_live_lottie_bg);
        this.fSI = (TBLottieAnimationView) view.findViewById(R.id.ala_live_lottie);
        this.fSI.loop(true);
        an.a(this.fSI, (int) R.raw.ala_live2);
        this.fSI.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.ala.livecard.b.e.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                e.this.fSI.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                e.this.fSI.cancelAnimation();
            }
        });
        this.eLb = (TextView) view.findViewById(R.id.play_count);
        this.fSJ = (TextView) view.findViewById(R.id.ala_live_recom_reason);
        this.fSL = view.findViewById(R.id.play_count_line);
        this.fRI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.text_bottom);
        b(this.fRI);
        this.fRI.setSelectVisible(false);
        this.fRI.setIsBarViewVisible(false);
        this.fRI.setCommentNumEnable(true);
        this.fRI.setLiveShareEnable(false);
        this.fRI.setFrom(2);
        this.fRI.getCommentContainer().setOnClickListener(this);
        this.fRI.hideDisagree();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 2;
        cVar.dHw = 2;
        this.fRI.setAgreeStatisticData(cVar);
        this.gOF = (ThreadCommentAndPraiseInfoLayout) view.findViewById(R.id.card_bottom_op_weight_layout);
        b(this.gOF);
        this.gOF.setFrom(2);
        this.gOF.setShareReportFrom(1);
        this.fSu = (ThreadSourceShareAndPraiseLayout) view.findViewById(R.id.text_bottom_2);
        this.fSu.eeP.setOnClickListener(this);
        this.fSu.eeP.getCommentContainer().setOnClickListener(this);
        this.fSu.setFrom(2);
        this.fSu.setShareReportFrom(1);
        this.fSu.setSourceFromForPb(3);
        this.fSu.setStType("frs_page");
        this.fSu.setHideBarName(true);
        this.fRJ = view.findViewById(R.id.divider_below_reply_number_layout);
        this.fSF = (ThreadSkinView) view.findViewById(R.id.frs_thread_skin);
        this.mDivider = view.findViewById(R.id.divider_line);
        this.mMaskView = view.findViewById(R.id.thread_multi_del_mask_view);
        this.mMaskView.setClickable(true);
        this.fSB = new com.baidu.tieba.ala.livecard.vc.a(tbPageContext, this.aeg.getSuffixContainer());
        this.fSB.setUniqueId(getTag());
    }

    @Override // com.baidu.tieba.card.b
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            d(tbPageContext, i);
            an.setBackgroundResource(this.fRG, R.drawable.addresslist_item_bg);
            an.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
            an.setBackgroundResource(this.fSH, R.drawable.bg_ala_shape);
            int dimens = l.getDimens(getContext(), R.dimen.tbds10);
            an.a(this.fSK, (int) R.color.cp_other_d, GradientDrawable.Orientation.LEFT_RIGHT, new float[]{dimens, dimens, 0.0f, 0.0f, dimens, dimens, 0.0f, 0.0f});
            an.setBackgroundColor(this.fSL, R.color.cp_cont_a);
            an.setViewTextColor(this.eLb, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fSJ, (int) R.color.cp_cont_a);
            this.aeg.onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.eKV.setPlaceHolder(3);
            this.fRI.onChangeSkinType();
            this.mSkinType = i;
            if (this.fSu != null && this.fSu.getVisibility() == 0) {
                this.fSu.onChangeSkinType();
            }
        }
        if (this.aea != 0 && m.DP(((bu) this.aea).getId())) {
            an.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_d);
        } else {
            an.setViewTextColor(this.mTextTitle, (int) R.color.cp_cont_b);
        }
        an.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.fSB.onChangeSkinType();
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ala_video_layout_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(bu buVar) {
        this.aea = buVar;
        refreshView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.tieba.frs.b.bXd().bWX() && !com.baidu.tieba.frs.a.bWW().bWX()) {
            if (view == this.fRG || view == this.fRI.getCommentContainer() || view == this.fdX || view == this.fSu.eeP.getCommentContainer() || view == this.gOF.getCommentContainer()) {
                if (this.aea != 0) {
                    m.DO(((bu) this.aea).getId());
                }
                if (bOd() != null) {
                    bOd().a(this.fRG, this.aea);
                }
                b(getContext(), (bu) this.aea);
                if (this.aea != 0) {
                    if (view == this.fRI.getCommentContainer() || view == this.fSu.eeP.getCommentContainer()) {
                        ao aoVar = new ao("c12942");
                        aoVar.ag("obj_locate", 2);
                        aoVar.ag("obj_type", 5);
                        aoVar.dk("tid", ((bu) this.aea).getTid());
                        aoVar.dk("nid", ((bu) this.aea).getNid());
                        TiebaStatic.log(aoVar);
                    }
                }
            } else if (view.getId() == R.id.video_container) {
                if (bOd() != null) {
                    bOd().a(view, this.aea);
                }
                b(getContext(), (bu) this.aea);
            }
        }
    }

    private void refreshView() {
        SparseArray<String> sparseArray;
        if (this.aea == 0 || ((bu) this.aea).aSp() == null) {
            this.fRG.setVisibility(8);
            return;
        }
        this.fRG.setVisibility(0);
        int equipmentWidth = l.getEquipmentWidth(this.dPv.getPageActivity());
        if (equipmentWidth != this.mLastScreenWidth) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fSH.getLayoutParams();
            layoutParams.width = equipmentWidth - l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds88);
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.fSH.setLayoutParams(layoutParams);
            this.mLastScreenWidth = equipmentWidth;
        }
        if (((bu) this.aea).aSJ() != null && ((bu) this.aea).aSJ().user_info != null && ((bu) this.aea).aSJ().user_info.is_official == 2) {
            this.fSN = true;
            SparseArray<String> sparseArray2 = ((bu) this.aea).aSJ().dislikeInfo;
            this.fSG.setVisibility(0);
            int[] screenDimensions = l.getScreenDimensions(getContext());
            ViewGroup.LayoutParams layoutParams2 = this.fSG.getLayoutParams();
            layoutParams2.width = screenDimensions[0];
            layoutParams2.height = (screenDimensions[0] * 156) / 1080;
            this.fSG.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(((bu) this.aea).aSJ().liveStagePicUrl)) {
                this.fSG.startLoad(((bu) this.aea).aSJ().liveStagePicUrl, 10, false);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aeg.getLayoutParams();
            marginLayoutParams.topMargin = this.dPv.getResources().getDimensionPixelSize(R.dimen.tbds24);
            this.aeg.setLayoutParams(marginLayoutParams);
            sparseArray = sparseArray2;
        } else {
            this.fSN = false;
            this.fSG.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.aeg.getLayoutParams();
            marginLayoutParams2.topMargin = this.dPv.getResources().getDimensionPixelSize(R.dimen.tbds44);
            this.aeg.setLayoutParams(marginLayoutParams2);
            sparseArray = null;
        }
        if (this.fSN && sparseArray != null && sparseArray.size() > 0) {
            this.fSB.l((bu) this.aea, "ala_frs_demo_hell_live_feed_back_type");
        } else if (this.fSB.bzh() != null) {
            this.fSB.bzh().setVisibility(8);
        }
        ((bu) this.aea).v(false, true);
        this.aeg.setData((bu) this.aea);
        SpannableStringBuilder aSZ = ((bu) this.aea).aSZ();
        if (aSZ != null && !StringUtils.isNull(aSZ.toString())) {
            this.mTextTitle.setText(((bu) this.aea).aSZ());
            this.mTextTitle.setVisibility(0);
        } else {
            this.mTextTitle.setVisibility(8);
        }
        if (((bu) this.aea).aSJ().audience_count > 0) {
            this.fSL.setVisibility(0);
            this.eLb.setVisibility(0);
            this.eLb.setText(String.format(this.dPv.getResources().getString(R.string.ala_audience_count_prefix), ar.numFormatOverWan(((bu) this.aea).aSJ().audience_count)));
        } else {
            this.fSL.setVisibility(8);
            this.eLb.setVisibility(8);
        }
        this.fSJ.setVisibility(8);
        if (((bu) this.aea).aSJ().openRecomReason == 1) {
            String str = ((bu) this.aea).aSJ().recomReason;
            if (!StringUtils.isNull(str)) {
                this.fSJ.setVisibility(0);
                this.fSJ.setText(str);
            } else {
                String aSE = ((bu) this.aea).aSE();
                String aSF = ((bu) this.aea).aSF();
                if (UtilHelper.isDecimal(aSE) && UtilHelper.isDecimal(aSF) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    AppPosInfo cZK = com.baidu.tieba.recapp.d.a.cZG().cZK();
                    String str2 = cZK.latitude;
                    String str3 = cZK.longitude;
                    if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && l.GetDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(aSE), Double.parseDouble(aSF)) <= 50.0d) {
                        this.fSJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                        this.fSJ.setVisibility(0);
                    }
                }
            }
        }
        qZ(pz(1));
        Y((bu) this.aea);
        this.mMaskView.setVisibility((com.baidu.tieba.frs.b.bXd().bWX() || com.baidu.tieba.frs.a.bWW().bWX()) ? 0 : 8);
        onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
        bzl();
        this.fSI.playAnimation();
        aN(this.fRG);
    }

    public void bzl() {
        if (k.aPA().isShowImages() && this.aea != 0 && ((bu) this.aea).aPS() != null && ((bu) this.aea).aPS().aSJ() != null) {
            this.eKV.setPlaceHolder(3);
            this.eKV.startLoad(((bu) this.aea).aPS().aSJ().cover, 10, false);
            this.fSH.setVisibility(0);
            return;
        }
        this.fSH.setVisibility(8);
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.fRI != null) {
            if (this.aeg != null) {
                this.aeg.setPageUniqueId(bdUniqueId);
            }
            setTag(bdUniqueId);
            q(bdUniqueId);
        }
    }

    public void ku(boolean z) {
        this.fSM = z;
    }

    private void Y(bu buVar) {
        if (buVar != null) {
            TiebaStatic.log(new ao("c12125").dk("tid", buVar.getId()).ag("obj_locate", this.fSM ? 2 : 1).s("obj_id", buVar.aSJ().live_id).ag("obj_type", 2));
            if (buVar.aSJ() != null && buVar.aSJ().user_info != null && buVar.aSJ().user_info.is_official == 2) {
                TiebaStatic.log(new ao("c12800").dk("tid", buVar.getId()));
            }
        }
    }

    private void m(bu buVar, String str) {
        TiebaStatic.log(new ao("c12126").dk("tid", buVar.getId()).ag("obj_locate", this.fSM ? 2 : 1).s("obj_id", buVar.aSJ().live_id).ag("obj_type", 2));
        if (buVar.aSJ() != null && buVar.aSJ().user_info != null && buVar.aSJ().user_info.is_official == 2) {
            TiebaStatic.log(new ao("c12801").dk("tid", buVar.getId()));
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (str.equals("frs_live_play")) {
            if (buVar.aSt().equals(this.mForumName)) {
                TiebaStatic.log(new ao("c11843").dk("uid", currentAccount).s("fid", buVar.getFid()));
            } else {
                TiebaStatic.log(new ao("c11845").dk("uid", currentAccount).s("fid", buVar.getFid()));
            }
        }
    }

    public void b(Context context, bu buVar) {
        String str;
        if (context != null && buVar != null && buVar.aSJ() != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            String str2 = this.fSN ? "frs_live_stage_live" : "frs_play";
            if (buVar.aSb() != null) {
                str2 = buVar.aSb();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + buVar.getFid();
            } else {
                str = frsCurTabType == 13 ? AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + buVar.getFid() : str2;
            }
            m(buVar, str);
            AlaInfoData aSJ = buVar.aSJ();
            boolean z = false;
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && buVar.aSp() != null) {
                z = TextUtils.equals(buVar.aSp().getUserId(), TbadkCoreApplication.getCurrentAccount());
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(aSJ);
            if (aSJ.user_info != null) {
                alaLiveInfoCoreData.userName = aSJ.user_info.user_name;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, str, "", z, this.mForumName)));
        }
    }

    public void qZ(int i) {
        if (this.aea != 0) {
            if (i == 1) {
                this.fRI.setVisibility(8);
                this.fSu.setData((bu) this.aea);
                return;
            }
            this.fRJ.setVisibility(this.fRI.setData((bu) this.aea) ? 8 : 0);
            this.fSu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afG = str;
    }

    public int pz(int i) {
        return com.baidu.tieba.a.d.boB().as(this.afG, i);
    }
}
