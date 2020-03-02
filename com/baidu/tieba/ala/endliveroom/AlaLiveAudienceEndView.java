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
    private static final LinearInterpolator eAv = new LinearInterpolator();
    private String agZ;
    private m ald;
    private LottieAnimationView eAA;
    private LottieAnimationView eAB;
    private Animation eAC;
    private LinearLayout eAD;
    private LinearLayout eAE;
    private RelativeLayout eAF;
    private RelativeLayout eAG;
    private TbImageView eAH;
    private TextView eAI;
    private TextView eAJ;
    private ProgressBar eAK;
    private TbImageView eAL;
    private TextView eAM;
    private TextView eAN;
    private ProgressBar eAO;
    private TextView eAP;
    private LinearLayout eAQ;
    private TextView eAR;
    private TextView eAS;
    private View eAT;
    private boolean eAU;
    private boolean eAV;
    private int eAW;
    private ArrayList<AlaLiveInfoData> eAX;
    private ValueAnimator eAY;
    private Set<Long> eAZ;
    private a eAw;
    private HeadImageView eAx;
    private TextView eAy;
    private ImageView eAz;
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
        this.eAU = false;
        this.mPortrait = "";
        this.eAV = false;
        this.eAW = 0;
        this.eAZ = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.eAw != null) {
                    AlaLiveAudienceEndView.this.eAw.yF();
                }
            }
        });
        this.eAz = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.eAA = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.eAA.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eAA.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.eAB = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.eAB.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eAB.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.eAx = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.eAx.setIsRound(true);
        this.eAx.setDrawBorder(true);
        this.eAx.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eAx.setAutoChangeStyle(false);
        this.eAy = (TextView) this.mView.findViewById(a.g.user_name);
        this.eAS = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.eAQ = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.eAP = (TextView) this.mView.findViewById(a.g.follow_label);
        this.eAQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.ald == null || AlaLiveAudienceEndView.this.ald.mLiveInfo == null || AlaLiveAudienceEndView.this.ald.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.eAw != null) {
                        if (AlaLiveAudienceEndView.this.eAU) {
                            AlaLiveAudienceEndView.this.beH();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.agZ, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.eAw.ir(AlaLiveAudienceEndView.this.eAU);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.ald.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.ald.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.eAR = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.ald != null && this.ald.mLiveInfo != null && this.ald.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.ald.mLiveInfo.mLiveCloseData.title)) {
                this.eAR.setText(a.i.live_over_name);
            } else {
                this.eAR.setText(this.ald.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.eAV) {
            this.eAR.setText(a.i.live_closed);
        } else {
            this.eAR.setText(a.i.live_over_name);
        }
        this.eAA.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.eAB.setVisibility(0);
                AlaLiveAudienceEndView.this.eAA.setVisibility(8);
                AlaLiveAudienceEndView.this.eAB.playAnimation();
            }
        });
        beF();
    }

    public void setCallback(a aVar) {
        this.eAw = aVar;
    }

    public void setData(TbPageContext tbPageContext, m mVar, boolean z, boolean z2, String str, String str2) {
        this.ald = mVar;
        this.eAV = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ald = mVar;
        this.mLiveInfo = mVar.mLiveInfo;
        this.eAU = z2;
        this.mPortrait = str;
        this.eAV = z;
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
            this.eAz.setVisibility(4);
        } else {
            this.eAC = AnimationUtils.loadAnimation(this.mContext, a.C0102a.anim_endview_holo_rotate);
            this.eAz.startAnimation(this.eAC);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.eAx.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.eAx.startLoad(this.mPortrait, 12, false, false);
        }
        this.eAy.setText(this.ald.XQ.userName);
        this.eAQ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.ald != null && this.ald.mLiveInfo != null && this.ald.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.ald.mLiveInfo.mLiveCloseData.title)) {
            this.eAR.setText(this.ald.mLiveInfo.mLiveCloseData.title);
        } else if (this.eAV) {
            this.eAR.setText(a.i.live_closed);
        } else {
            this.eAR.setText(a.i.live_over_name);
        }
        this.eAA.setVisibility(0);
        this.eAA.playAnimation();
        is(this.eAU);
    }

    public void is(boolean z) {
        this.eAU = z;
        if (this.ald != null && this.ald.mLiveInfo != null && this.ald.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.ald.mLiveInfo.mLiveCloseData.tips)) {
                this.eAS.setText("");
            } else {
                this.eAS.setText(this.ald.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.ald.mLiveInfo.mLiveCloseData.actionText)) {
                this.eAQ.setVisibility(8);
                this.eAP.setText("");
            } else {
                this.eAQ.setVisibility(0);
                this.eAP.setText(this.ald.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.eAQ.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.eAQ.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.eAQ.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.eAQ.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.eAQ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.eAU) {
            this.eAS.setText(a.i.endtext_followed);
            this.eAP.setText(a.i.sdk_followed);
            this.eAP.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.eAQ.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.eAQ.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.eAS.setText(a.i.endtext_follow);
        this.eAP.setText(a.i.follow);
        this.eAP.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.eAQ.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.eAQ.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eAQ.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.eAQ.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void beF() {
        this.eAD = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.eAE = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.eAT = this.mView.findViewById(a.g.change_layout);
        this.eAH = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.eAI = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.eAJ = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.eAL = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.eAM = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.eAN = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.eAF = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.eAG = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.eAK = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.eAO = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.eAD.setVisibility(i);
        this.eAE.setVisibility(i);
    }

    public void U(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.ald != null) {
            if (this.ald.mLiveInfo == null || this.ald.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.eAX = arrayList;
                this.eAW = 0;
                a(this.eAW, arrayList.get(this.eAW), this.eAW + 1, arrayList.get(this.eAW + 1), z);
                this.eAW++;
                if (this.eAY == null) {
                    this.eAY = ValueAnimator.ofInt(100, 0);
                    this.eAY.setDuration(5000L);
                    this.eAY.setInterpolator(eAv);
                    this.eAY.setRepeatCount(-1);
                    this.eAY.setRepeatMode(1);
                    this.eAY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.eAK.setProgress(intValue);
                            AlaLiveAudienceEndView.this.eAO.setProgress(intValue);
                        }
                    });
                    this.eAY.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.beG();
                        }
                    });
                }
                if (z) {
                    this.eAY.start();
                    this.eAT.setVisibility(0);
                    this.eAT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.agZ, AlaLiveAudienceEndView.this.otherParams);
                            AlaLiveAudienceEndView.this.eAY.cancel();
                            AlaLiveAudienceEndView.this.beG();
                            AlaLiveAudienceEndView.this.eAY.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beG() {
        int i = this.eAW + 1;
        this.eAW = i;
        if (i >= this.eAX.size()) {
            this.eAW = 0;
            i = 0;
        }
        int i2 = this.eAW + 1;
        this.eAW = i2;
        if (i2 >= this.eAX.size()) {
            this.eAW = 0;
            i2 = 0;
        }
        this.eAW = i2;
        a(i, this.eAX.get(i), i2, this.eAX.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.eAZ.contains(Long.valueOf(this.eAX.get(i).live_id))) {
            this.eAZ.add(Long.valueOf(this.eAX.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.agZ, this.eAX.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.eAZ.contains(Long.valueOf(this.eAX.get(i2).live_id))) {
            this.eAZ.add(Long.valueOf(this.eAX.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.agZ, this.eAX.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.eAF, this.eAH, this.eAI, this.eAJ, this.eAK, alaLiveInfoData, z, i);
        a(this.eAG, this.eAL, this.eAM, this.eAN, this.eAO, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.agZ, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.eAX.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.mContext, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.eAw != null) {
                        AlaLiveAudienceEndView.this.eAw.c(alaLiveInfoData);
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
        return this.eAD;
    }

    public HeadImageView getPortraitImg() {
        return this.eAx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beH() {
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
                    AlaLiveAudienceEndView.this.eAw.ir(AlaLiveAudienceEndView.this.eAU);
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
        if (this.eAC != null) {
            this.eAC.cancel();
        }
        if (this.eAA != null) {
            this.eAA.cancelAnimation();
        }
        if (this.eAB != null) {
            this.eAB.cancelAnimation();
        }
        if (this.eAY != null) {
            this.eAY.cancel();
        }
    }
}
