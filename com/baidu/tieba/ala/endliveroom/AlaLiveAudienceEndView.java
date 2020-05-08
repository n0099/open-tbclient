package com.baidu.tieba.ala.endliveroom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator ffC = new LinearInterpolator();
    private n aDK;
    private String azF;
    private Activity caN;
    private a ffD;
    private HeadImageView ffE;
    private TextView ffF;
    private ImageView ffG;
    private LottieAnimationView ffH;
    private LottieAnimationView ffI;
    private Animation ffJ;
    private LinearLayout ffK;
    private LinearLayout ffL;
    private RelativeLayout ffM;
    private RelativeLayout ffN;
    private TbImageView ffO;
    private TextView ffP;
    private TextView ffQ;
    private ProgressBar ffR;
    private TbImageView ffS;
    private TextView ffT;
    private TextView ffU;
    private ProgressBar ffV;
    private TextView ffW;
    private LinearLayout ffX;
    private TextView ffY;
    private TextView ffZ;
    private View fga;
    private boolean fgb;
    private boolean fgc;
    private int fgd;
    private ArrayList<AlaLiveInfoData> fge;
    private ValueAnimator fgf;
    private Set<Long> fgg;
    private String liveId;
    private ImageView mCloseBtn;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private String otherParams;
    private String roomId;

    /* loaded from: classes3.dex */
    public interface a {
        void DD();

        void e(AlaLiveInfoData alaLiveInfoData);

        void ju(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.fgb = false;
        this.mPortrait = "";
        this.fgc = false;
        this.fgd = 0;
        this.fgg = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.ffD != null) {
                    AlaLiveAudienceEndView.this.ffD.DD();
                }
            }
        });
        this.ffG = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.ffH = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.ffH.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ffH.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.ffI = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.ffI.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ffI.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.ffE = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.ffE.setIsRound(true);
        this.ffE.setDrawBorder(true);
        this.ffE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ffE.setAutoChangeStyle(false);
        this.ffF = (TextView) this.mView.findViewById(a.g.user_name);
        this.ffZ = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.ffX = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.ffW = (TextView) this.mView.findViewById(a.g.follow_label);
        this.ffX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aDK == null || AlaLiveAudienceEndView.this.aDK.mLiveInfo == null || AlaLiveAudienceEndView.this.aDK.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.ffD != null) {
                        if (AlaLiveAudienceEndView.this.fgb) {
                            AlaLiveAudienceEndView.this.bob();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.azF, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.ffD.ju(AlaLiveAudienceEndView.this.fgb);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aDK.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.caN, AlaLiveAudienceEndView.this.aDK.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.ffY = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aDK != null && this.aDK.mLiveInfo != null && this.aDK.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDK.mLiveInfo.mLiveCloseData.title)) {
                this.ffY.setText(a.i.live_over_name);
            } else {
                this.ffY.setText(this.aDK.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.fgc) {
            this.ffY.setText(a.i.live_closed);
        } else {
            this.ffY.setText(a.i.live_over_name);
        }
        this.ffH.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.ffI.setVisibility(0);
                AlaLiveAudienceEndView.this.ffH.setVisibility(8);
                AlaLiveAudienceEndView.this.ffI.playAnimation();
            }
        });
        bnZ();
    }

    public void setCallback(a aVar) {
        this.ffD = aVar;
    }

    public void setData(TbPageContext tbPageContext, n nVar, boolean z, boolean z2, String str, String str2) {
        this.aDK = nVar;
        this.fgc = z;
        this.mTbPageContext = tbPageContext;
        this.caN = tbPageContext.getPageActivity();
        this.aDK = nVar;
        this.mLiveInfo = nVar.mLiveInfo;
        this.fgb = z2;
        this.mPortrait = str;
        this.fgc = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.azF = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.azF == null || TextUtils.equals(this.azF, "null")) {
            this.azF = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ffG.setVisibility(4);
        } else {
            this.ffJ = AnimationUtils.loadAnimation(this.caN, a.C0149a.anim_endview_holo_rotate);
            this.ffG.startAnimation(this.ffJ);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.ffE.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.ffE.startLoad(this.mPortrait, 12, false, false);
        }
        this.ffF.setText(this.aDK.aqk.userName);
        this.ffX.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aDK != null && this.aDK.mLiveInfo != null && this.aDK.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aDK.mLiveInfo.mLiveCloseData.title)) {
            this.ffY.setText(this.aDK.mLiveInfo.mLiveCloseData.title);
        } else if (this.fgc) {
            this.ffY.setText(a.i.live_closed);
        } else {
            this.ffY.setText(a.i.live_over_name);
        }
        this.ffH.setVisibility(0);
        this.ffH.playAnimation();
        jv(this.fgb);
    }

    public void jv(boolean z) {
        this.fgb = z;
        if (this.aDK != null && this.aDK.mLiveInfo != null && this.aDK.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDK.mLiveInfo.mLiveCloseData.tips)) {
                this.ffZ.setText("");
            } else {
                this.ffZ.setText(this.aDK.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aDK.mLiveInfo.mLiveCloseData.actionText)) {
                this.ffX.setVisibility(8);
                this.ffW.setText("");
            } else {
                this.ffX.setVisibility(0);
                this.ffW.setText(this.aDK.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.ffX.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.ffX.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.ffX.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.ffX.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.ffX.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.fgb) {
            this.ffZ.setText(a.i.endtext_followed);
            this.ffW.setText(a.i.sdk_followed);
            this.ffW.setTextColor(this.caN.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ffX.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.ffX.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.ffZ.setText(a.i.endtext_follow);
        this.ffW.setText(a.i.follow);
        this.ffW.setTextColor(this.caN.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ffX.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.ffX.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ffX.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.ffX.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void bnZ() {
        this.ffK = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.ffL = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.fga = this.mView.findViewById(a.g.change_layout);
        this.ffO = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.ffP = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.ffQ = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.ffS = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.ffT = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.ffU = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.ffM = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.ffN = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.ffR = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.ffV = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.ffK.setVisibility(i);
        this.ffL.setVisibility(i);
    }

    public void V(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aDK != null) {
            if (this.aDK.mLiveInfo == null || this.aDK.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.fge = arrayList;
                this.fgd = 0;
                a(this.fgd, arrayList.get(this.fgd), this.fgd + 1, arrayList.get(this.fgd + 1), z);
                this.fgd++;
                if (this.fgf == null) {
                    this.fgf = ValueAnimator.ofInt(100, 0);
                    this.fgf.setDuration(5000L);
                    this.fgf.setInterpolator(ffC);
                    this.fgf.setRepeatCount(-1);
                    this.fgf.setRepeatMode(1);
                    this.fgf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.ffR.setProgress(intValue);
                            AlaLiveAudienceEndView.this.ffV.setProgress(intValue);
                        }
                    });
                    this.fgf.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.boa();
                        }
                    });
                }
                if (z) {
                    this.fgf.start();
                    this.fga.setVisibility(0);
                    this.fga.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.azF, AlaLiveAudienceEndView.this.otherParams);
                            AlaLiveAudienceEndView.this.fgf.cancel();
                            AlaLiveAudienceEndView.this.boa();
                            AlaLiveAudienceEndView.this.fgf.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boa() {
        int i = this.fgd + 1;
        this.fgd = i;
        if (i >= this.fge.size()) {
            this.fgd = 0;
            i = 0;
        }
        int i2 = this.fgd + 1;
        this.fgd = i2;
        if (i2 >= this.fge.size()) {
            this.fgd = 0;
            i2 = 0;
        }
        this.fgd = i2;
        a(i, this.fge.get(i), i2, this.fge.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.fgg.contains(Long.valueOf(this.fge.get(i).live_id))) {
            this.fgg.add(Long.valueOf(this.fge.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.azF, this.fge.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.fgg.contains(Long.valueOf(this.fge.get(i2).live_id))) {
            this.fgg.add(Long.valueOf(this.fge.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.azF, this.fge.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.ffM, this.ffO, this.ffP, this.ffQ, this.ffR, alaLiveInfoData, z, i);
        a(this.ffN, this.ffS, this.ffT, this.ffU, this.ffV, alaLiveInfoData2, z, i2);
    }

    public void a(View view, TbImageView tbImageView, TextView textView, TextView textView2, ProgressBar progressBar, final AlaLiveInfoData alaLiveInfoData, boolean z, final int i) {
        if (alaLiveInfoData != null) {
            String str = alaLiveInfoData.cover;
            tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TextUtils.isEmpty(str)) {
                tbImageView.startLoad(str, 10, false);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.azF, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.fge.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.caN, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.ffD != null) {
                        AlaLiveAudienceEndView.this.ffD.e(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.caN.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.ffK;
    }

    public HeadImageView getPortraitImg() {
        return this.ffE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bob() {
        if (this.caN != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.caN);
            bdAlertDialog.setMessage(this.caN.getResources().getString(a.i.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.i.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.i.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.azF, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.ffD.ju(AlaLiveAudienceEndView.this.fgb);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.caN.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.caN.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                bdAlertDialog.setPositiveButtonTextColor(1714631475);
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
            } else {
                bdAlertDialog.setPositiveButtonTextColor(-13421773);
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
            }
            bdAlertDialog.create(this.mTbPageContext).show();
        }
    }

    public void onDestory() {
        if (this.ffJ != null) {
            this.ffJ.cancel();
        }
        if (this.ffH != null) {
            this.ffH.cancelAnimation();
        }
        if (this.ffI != null) {
            this.ffI.cancelAnimation();
        }
        if (this.fgf != null) {
            this.fgf.cancel();
        }
    }
}
