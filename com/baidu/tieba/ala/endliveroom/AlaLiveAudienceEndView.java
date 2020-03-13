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
    private static final LinearInterpolator eAI = new LinearInterpolator();
    private String agZ;
    private m ale;
    private a eAJ;
    private HeadImageView eAK;
    private TextView eAL;
    private ImageView eAM;
    private LottieAnimationView eAN;
    private LottieAnimationView eAO;
    private Animation eAP;
    private LinearLayout eAQ;
    private LinearLayout eAR;
    private RelativeLayout eAS;
    private RelativeLayout eAT;
    private TbImageView eAU;
    private TextView eAV;
    private TextView eAW;
    private ProgressBar eAX;
    private TbImageView eAY;
    private TextView eAZ;
    private TextView eBa;
    private ProgressBar eBb;
    private TextView eBc;
    private LinearLayout eBd;
    private TextView eBe;
    private TextView eBf;
    private View eBg;
    private boolean eBh;
    private boolean eBi;
    private int eBj;
    private ArrayList<AlaLiveInfoData> eBk;
    private ValueAnimator eBl;
    private Set<Long> eBm;
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
        this.eBh = false;
        this.mPortrait = "";
        this.eBi = false;
        this.eBj = 0;
        this.eBm = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.eAJ != null) {
                    AlaLiveAudienceEndView.this.eAJ.yF();
                }
            }
        });
        this.eAM = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.eAN = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.eAN.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eAN.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.eAO = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.eAO.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eAO.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.eAK = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.eAK.setIsRound(true);
        this.eAK.setDrawBorder(true);
        this.eAK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eAK.setAutoChangeStyle(false);
        this.eAL = (TextView) this.mView.findViewById(a.g.user_name);
        this.eBf = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.eBd = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.eBc = (TextView) this.mView.findViewById(a.g.follow_label);
        this.eBd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.ale == null || AlaLiveAudienceEndView.this.ale.mLiveInfo == null || AlaLiveAudienceEndView.this.ale.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.eAJ != null) {
                        if (AlaLiveAudienceEndView.this.eBh) {
                            AlaLiveAudienceEndView.this.beI();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.agZ, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.eAJ.ir(AlaLiveAudienceEndView.this.eBh);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.ale.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.ale.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.eBe = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.ale != null && this.ale.mLiveInfo != null && this.ale.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.ale.mLiveInfo.mLiveCloseData.title)) {
                this.eBe.setText(a.i.live_over_name);
            } else {
                this.eBe.setText(this.ale.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.eBi) {
            this.eBe.setText(a.i.live_closed);
        } else {
            this.eBe.setText(a.i.live_over_name);
        }
        this.eAN.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.eAO.setVisibility(0);
                AlaLiveAudienceEndView.this.eAN.setVisibility(8);
                AlaLiveAudienceEndView.this.eAO.playAnimation();
            }
        });
        beG();
    }

    public void setCallback(a aVar) {
        this.eAJ = aVar;
    }

    public void setData(TbPageContext tbPageContext, m mVar, boolean z, boolean z2, String str, String str2) {
        this.ale = mVar;
        this.eBi = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ale = mVar;
        this.mLiveInfo = mVar.mLiveInfo;
        this.eBh = z2;
        this.mPortrait = str;
        this.eBi = z;
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
            this.eAM.setVisibility(4);
        } else {
            this.eAP = AnimationUtils.loadAnimation(this.mContext, a.C0102a.anim_endview_holo_rotate);
            this.eAM.startAnimation(this.eAP);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.eAK.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.eAK.startLoad(this.mPortrait, 12, false, false);
        }
        this.eAL.setText(this.ale.XQ.userName);
        this.eBd.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.ale != null && this.ale.mLiveInfo != null && this.ale.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.ale.mLiveInfo.mLiveCloseData.title)) {
            this.eBe.setText(this.ale.mLiveInfo.mLiveCloseData.title);
        } else if (this.eBi) {
            this.eBe.setText(a.i.live_closed);
        } else {
            this.eBe.setText(a.i.live_over_name);
        }
        this.eAN.setVisibility(0);
        this.eAN.playAnimation();
        is(this.eBh);
    }

    public void is(boolean z) {
        this.eBh = z;
        if (this.ale != null && this.ale.mLiveInfo != null && this.ale.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.ale.mLiveInfo.mLiveCloseData.tips)) {
                this.eBf.setText("");
            } else {
                this.eBf.setText(this.ale.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.ale.mLiveInfo.mLiveCloseData.actionText)) {
                this.eBd.setVisibility(8);
                this.eBc.setText("");
            } else {
                this.eBd.setVisibility(0);
                this.eBc.setText(this.ale.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.eBd.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.eBd.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.eBd.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.eBd.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.eBd.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.eBh) {
            this.eBf.setText(a.i.endtext_followed);
            this.eBc.setText(a.i.sdk_followed);
            this.eBc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.eBd.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.eBd.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.eBf.setText(a.i.endtext_follow);
        this.eBc.setText(a.i.follow);
        this.eBc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.eBd.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.eBd.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eBd.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.eBd.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void beG() {
        this.eAQ = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.eAR = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.eBg = this.mView.findViewById(a.g.change_layout);
        this.eAU = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.eAV = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.eAW = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.eAY = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.eAZ = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.eBa = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.eAS = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.eAT = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.eAX = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.eBb = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.eAQ.setVisibility(i);
        this.eAR.setVisibility(i);
    }

    public void U(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.ale != null) {
            if (this.ale.mLiveInfo == null || this.ale.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.eBk = arrayList;
                this.eBj = 0;
                a(this.eBj, arrayList.get(this.eBj), this.eBj + 1, arrayList.get(this.eBj + 1), z);
                this.eBj++;
                if (this.eBl == null) {
                    this.eBl = ValueAnimator.ofInt(100, 0);
                    this.eBl.setDuration(5000L);
                    this.eBl.setInterpolator(eAI);
                    this.eBl.setRepeatCount(-1);
                    this.eBl.setRepeatMode(1);
                    this.eBl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.eAX.setProgress(intValue);
                            AlaLiveAudienceEndView.this.eBb.setProgress(intValue);
                        }
                    });
                    this.eBl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.beH();
                        }
                    });
                }
                if (z) {
                    this.eBl.start();
                    this.eBg.setVisibility(0);
                    this.eBg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.agZ, AlaLiveAudienceEndView.this.otherParams);
                            AlaLiveAudienceEndView.this.eBl.cancel();
                            AlaLiveAudienceEndView.this.beH();
                            AlaLiveAudienceEndView.this.eBl.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beH() {
        int i = this.eBj + 1;
        this.eBj = i;
        if (i >= this.eBk.size()) {
            this.eBj = 0;
            i = 0;
        }
        int i2 = this.eBj + 1;
        this.eBj = i2;
        if (i2 >= this.eBk.size()) {
            this.eBj = 0;
            i2 = 0;
        }
        this.eBj = i2;
        a(i, this.eBk.get(i), i2, this.eBk.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.eBm.contains(Long.valueOf(this.eBk.get(i).live_id))) {
            this.eBm.add(Long.valueOf(this.eBk.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.agZ, this.eBk.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.eBm.contains(Long.valueOf(this.eBk.get(i2).live_id))) {
            this.eBm.add(Long.valueOf(this.eBk.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.agZ, this.eBk.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.eAS, this.eAU, this.eAV, this.eAW, this.eAX, alaLiveInfoData, z, i);
        a(this.eAT, this.eAY, this.eAZ, this.eBa, this.eBb, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.agZ, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.eBk.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.mContext, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.eAJ != null) {
                        AlaLiveAudienceEndView.this.eAJ.c(alaLiveInfoData);
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
        return this.eAQ;
    }

    public HeadImageView getPortraitImg() {
        return this.eAK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beI() {
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
                    AlaLiveAudienceEndView.this.eAJ.ir(AlaLiveAudienceEndView.this.eBh);
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
        if (this.eAP != null) {
            this.eAP.cancel();
        }
        if (this.eAN != null) {
            this.eAN.cancelAnimation();
        }
        if (this.eAO != null) {
            this.eAO.cancelAnimation();
        }
        if (this.eBl != null) {
            this.eBl.cancel();
        }
    }
}
