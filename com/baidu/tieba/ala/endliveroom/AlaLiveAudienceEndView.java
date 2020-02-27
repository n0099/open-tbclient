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
import com.baidu.live.data.m;
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
    private static final LinearInterpolator eAu = new LinearInterpolator();
    private String agZ;
    private m ald;
    private LottieAnimationView eAA;
    private Animation eAB;
    private LinearLayout eAC;
    private LinearLayout eAD;
    private RelativeLayout eAE;
    private RelativeLayout eAF;
    private TbImageView eAG;
    private TextView eAH;
    private TextView eAI;
    private ProgressBar eAJ;
    private TbImageView eAK;
    private TextView eAL;
    private TextView eAM;
    private ProgressBar eAN;
    private TextView eAO;
    private LinearLayout eAP;
    private TextView eAQ;
    private TextView eAR;
    private View eAS;
    private boolean eAT;
    private boolean eAU;
    private int eAV;
    private ArrayList<AlaLiveInfoData> eAW;
    private ValueAnimator eAX;
    private Set<Long> eAY;
    private a eAv;
    private HeadImageView eAw;
    private TextView eAx;
    private ImageView eAy;
    private LottieAnimationView eAz;
    private String liveId;
    private ImageView mCloseBtn;
    private Activity mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private String otherParams;
    private String roomId;

    /* loaded from: classes3.dex */
    public interface a {
        void c(AlaLiveInfoData alaLiveInfoData);

        void ir(boolean z);

        void yF();
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.eAT = false;
        this.mPortrait = "";
        this.eAU = false;
        this.eAV = 0;
        this.eAY = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.eAv != null) {
                    AlaLiveAudienceEndView.this.eAv.yF();
                }
            }
        });
        this.eAy = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.eAz = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.eAz.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eAz.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.eAA = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.eAA.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eAA.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.eAw = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.eAw.setIsRound(true);
        this.eAw.setDrawBorder(true);
        this.eAw.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eAw.setAutoChangeStyle(false);
        this.eAx = (TextView) this.mView.findViewById(a.g.user_name);
        this.eAR = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.eAP = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.eAO = (TextView) this.mView.findViewById(a.g.follow_label);
        this.eAP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.ald == null || AlaLiveAudienceEndView.this.ald.mLiveInfo == null || AlaLiveAudienceEndView.this.ald.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.eAv != null) {
                        if (AlaLiveAudienceEndView.this.eAT) {
                            AlaLiveAudienceEndView.this.beF();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.agZ, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.eAv.ir(AlaLiveAudienceEndView.this.eAT);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.ald.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.ald.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.eAQ = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.ald != null && this.ald.mLiveInfo != null && this.ald.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.ald.mLiveInfo.mLiveCloseData.title)) {
                this.eAQ.setText(a.i.live_over_name);
            } else {
                this.eAQ.setText(this.ald.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.eAU) {
            this.eAQ.setText(a.i.live_closed);
        } else {
            this.eAQ.setText(a.i.live_over_name);
        }
        this.eAz.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.eAA.setVisibility(0);
                AlaLiveAudienceEndView.this.eAz.setVisibility(8);
                AlaLiveAudienceEndView.this.eAA.playAnimation();
            }
        });
        beD();
    }

    public void setCallback(a aVar) {
        this.eAv = aVar;
    }

    public void setData(TbPageContext tbPageContext, m mVar, boolean z, boolean z2, String str, String str2) {
        this.ald = mVar;
        this.eAU = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ald = mVar;
        this.mLiveInfo = mVar.mLiveInfo;
        this.eAT = z2;
        this.mPortrait = str;
        this.eAU = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.agZ = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.agZ == null || TextUtils.equals(this.agZ, "null")) {
            this.agZ = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eAy.setVisibility(4);
        } else {
            this.eAB = AnimationUtils.loadAnimation(this.mContext, a.C0102a.anim_endview_holo_rotate);
            this.eAy.startAnimation(this.eAB);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.eAw.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.eAw.startLoad(this.mPortrait, 12, false, false);
        }
        this.eAx.setText(this.ald.XQ.userName);
        this.eAP.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.ald != null && this.ald.mLiveInfo != null && this.ald.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.ald.mLiveInfo.mLiveCloseData.title)) {
            this.eAQ.setText(this.ald.mLiveInfo.mLiveCloseData.title);
        } else if (this.eAU) {
            this.eAQ.setText(a.i.live_closed);
        } else {
            this.eAQ.setText(a.i.live_over_name);
        }
        this.eAz.setVisibility(0);
        this.eAz.playAnimation();
        is(this.eAT);
    }

    public void is(boolean z) {
        this.eAT = z;
        if (this.ald != null && this.ald.mLiveInfo != null && this.ald.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.ald.mLiveInfo.mLiveCloseData.tips)) {
                this.eAR.setText("");
            } else {
                this.eAR.setText(this.ald.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.ald.mLiveInfo.mLiveCloseData.actionText)) {
                this.eAP.setVisibility(8);
                this.eAO.setText("");
            } else {
                this.eAP.setVisibility(0);
                this.eAO.setText(this.ald.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.eAP.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.eAP.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.eAP.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.eAP.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.eAP.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.eAT) {
            this.eAR.setText(a.i.endtext_followed);
            this.eAO.setText(a.i.sdk_followed);
            this.eAO.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.eAP.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.eAP.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.eAR.setText(a.i.endtext_follow);
        this.eAO.setText(a.i.follow);
        this.eAO.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.eAP.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.eAP.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eAP.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.eAP.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void beD() {
        this.eAC = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.eAD = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.eAS = this.mView.findViewById(a.g.change_layout);
        this.eAG = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.eAH = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.eAI = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.eAK = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.eAL = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.eAM = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.eAE = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.eAF = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.eAJ = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.eAN = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.eAC.setVisibility(i);
        this.eAD.setVisibility(i);
    }

    public void U(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.ald != null) {
            if (this.ald.mLiveInfo == null || this.ald.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.eAW = arrayList;
                this.eAV = 0;
                a(this.eAV, arrayList.get(this.eAV), this.eAV + 1, arrayList.get(this.eAV + 1), z);
                this.eAV++;
                if (this.eAX == null) {
                    this.eAX = ValueAnimator.ofInt(100, 0);
                    this.eAX.setDuration(5000L);
                    this.eAX.setInterpolator(eAu);
                    this.eAX.setRepeatCount(-1);
                    this.eAX.setRepeatMode(1);
                    this.eAX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.eAJ.setProgress(intValue);
                            AlaLiveAudienceEndView.this.eAN.setProgress(intValue);
                        }
                    });
                    this.eAX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.beE();
                        }
                    });
                }
                if (z) {
                    this.eAX.start();
                    this.eAS.setVisibility(0);
                    this.eAS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.agZ, AlaLiveAudienceEndView.this.otherParams);
                            AlaLiveAudienceEndView.this.eAX.cancel();
                            AlaLiveAudienceEndView.this.beE();
                            AlaLiveAudienceEndView.this.eAX.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beE() {
        int i = this.eAV + 1;
        this.eAV = i;
        if (i >= this.eAW.size()) {
            this.eAV = 0;
            i = 0;
        }
        int i2 = this.eAV + 1;
        this.eAV = i2;
        if (i2 >= this.eAW.size()) {
            this.eAV = 0;
            i2 = 0;
        }
        this.eAV = i2;
        a(i, this.eAW.get(i), i2, this.eAW.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.eAY.contains(Long.valueOf(this.eAW.get(i).live_id))) {
            this.eAY.add(Long.valueOf(this.eAW.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.agZ, this.eAW.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.eAY.contains(Long.valueOf(this.eAW.get(i2).live_id))) {
            this.eAY.add(Long.valueOf(this.eAW.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.agZ, this.eAW.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.eAE, this.eAG, this.eAH, this.eAI, this.eAJ, alaLiveInfoData, z, i);
        a(this.eAF, this.eAK, this.eAL, this.eAM, this.eAN, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.agZ, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.eAW.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.mContext, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.eAv != null) {
                        AlaLiveAudienceEndView.this.eAv.c(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.mContext.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.eAC;
    }

    public HeadImageView getPortraitImg() {
        return this.eAw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beF() {
        if (this.mContext != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mContext);
            bdAlertDialog.setMessage(this.mContext.getResources().getString(a.i.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.i.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.i.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.agZ, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.eAv.ir(AlaLiveAudienceEndView.this.eAT);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
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
        if (this.eAB != null) {
            this.eAB.cancel();
        }
        if (this.eAz != null) {
            this.eAz.cancelAnimation();
        }
        if (this.eAA != null) {
            this.eAA.cancelAnimation();
        }
        if (this.eAX != null) {
            this.eAX.cancel();
        }
    }
}
