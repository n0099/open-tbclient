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
    private static final LinearInterpolator ffx = new LinearInterpolator();
    private n aDE;
    private String azz;
    private Activity caH;
    private TextView ffA;
    private ImageView ffB;
    private LottieAnimationView ffC;
    private LottieAnimationView ffD;
    private Animation ffE;
    private LinearLayout ffF;
    private LinearLayout ffG;
    private RelativeLayout ffH;
    private RelativeLayout ffI;
    private TbImageView ffJ;
    private TextView ffK;
    private TextView ffL;
    private ProgressBar ffM;
    private TbImageView ffN;
    private TextView ffO;
    private TextView ffP;
    private ProgressBar ffQ;
    private TextView ffR;
    private LinearLayout ffS;
    private TextView ffT;
    private TextView ffU;
    private View ffV;
    private boolean ffW;
    private boolean ffX;
    private int ffY;
    private ArrayList<AlaLiveInfoData> ffZ;
    private a ffy;
    private HeadImageView ffz;
    private ValueAnimator fga;
    private Set<Long> fgb;
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
        void DE();

        void e(AlaLiveInfoData alaLiveInfoData);

        void ju(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.ffW = false;
        this.mPortrait = "";
        this.ffX = false;
        this.ffY = 0;
        this.fgb = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.ffy != null) {
                    AlaLiveAudienceEndView.this.ffy.DE();
                }
            }
        });
        this.ffB = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.ffC = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.ffC.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ffC.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.ffD = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.ffD.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ffD.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.ffz = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.ffz.setIsRound(true);
        this.ffz.setDrawBorder(true);
        this.ffz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ffz.setAutoChangeStyle(false);
        this.ffA = (TextView) this.mView.findViewById(a.g.user_name);
        this.ffU = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.ffS = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.ffR = (TextView) this.mView.findViewById(a.g.follow_label);
        this.ffS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aDE == null || AlaLiveAudienceEndView.this.aDE.mLiveInfo == null || AlaLiveAudienceEndView.this.aDE.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.ffy != null) {
                        if (AlaLiveAudienceEndView.this.ffW) {
                            AlaLiveAudienceEndView.this.bod();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.azz, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.ffy.ju(AlaLiveAudienceEndView.this.ffW);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aDE.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.caH, AlaLiveAudienceEndView.this.aDE.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.ffT = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aDE != null && this.aDE.mLiveInfo != null && this.aDE.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDE.mLiveInfo.mLiveCloseData.title)) {
                this.ffT.setText(a.i.live_over_name);
            } else {
                this.ffT.setText(this.aDE.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.ffX) {
            this.ffT.setText(a.i.live_closed);
        } else {
            this.ffT.setText(a.i.live_over_name);
        }
        this.ffC.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.ffD.setVisibility(0);
                AlaLiveAudienceEndView.this.ffC.setVisibility(8);
                AlaLiveAudienceEndView.this.ffD.playAnimation();
            }
        });
        bob();
    }

    public void setCallback(a aVar) {
        this.ffy = aVar;
    }

    public void setData(TbPageContext tbPageContext, n nVar, boolean z, boolean z2, String str, String str2) {
        this.aDE = nVar;
        this.ffX = z;
        this.mTbPageContext = tbPageContext;
        this.caH = tbPageContext.getPageActivity();
        this.aDE = nVar;
        this.mLiveInfo = nVar.mLiveInfo;
        this.ffW = z2;
        this.mPortrait = str;
        this.ffX = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.azz = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.azz == null || TextUtils.equals(this.azz, "null")) {
            this.azz = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ffB.setVisibility(4);
        } else {
            this.ffE = AnimationUtils.loadAnimation(this.caH, a.C0128a.anim_endview_holo_rotate);
            this.ffB.startAnimation(this.ffE);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.ffz.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.ffz.startLoad(this.mPortrait, 12, false, false);
        }
        this.ffA.setText(this.aDE.aqe.userName);
        this.ffS.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aDE != null && this.aDE.mLiveInfo != null && this.aDE.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aDE.mLiveInfo.mLiveCloseData.title)) {
            this.ffT.setText(this.aDE.mLiveInfo.mLiveCloseData.title);
        } else if (this.ffX) {
            this.ffT.setText(a.i.live_closed);
        } else {
            this.ffT.setText(a.i.live_over_name);
        }
        this.ffC.setVisibility(0);
        this.ffC.playAnimation();
        jv(this.ffW);
    }

    public void jv(boolean z) {
        this.ffW = z;
        if (this.aDE != null && this.aDE.mLiveInfo != null && this.aDE.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDE.mLiveInfo.mLiveCloseData.tips)) {
                this.ffU.setText("");
            } else {
                this.ffU.setText(this.aDE.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aDE.mLiveInfo.mLiveCloseData.actionText)) {
                this.ffS.setVisibility(8);
                this.ffR.setText("");
            } else {
                this.ffS.setVisibility(0);
                this.ffR.setText(this.aDE.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.ffS.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.ffS.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.ffS.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.ffS.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.ffS.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.ffW) {
            this.ffU.setText(a.i.endtext_followed);
            this.ffR.setText(a.i.sdk_followed);
            this.ffR.setTextColor(this.caH.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ffS.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.ffS.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.ffU.setText(a.i.endtext_follow);
        this.ffR.setText(a.i.follow);
        this.ffR.setTextColor(this.caH.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ffS.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.ffS.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ffS.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.ffS.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void bob() {
        this.ffF = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.ffG = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.ffV = this.mView.findViewById(a.g.change_layout);
        this.ffJ = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.ffK = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.ffL = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.ffN = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.ffO = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.ffP = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.ffH = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.ffI = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.ffM = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.ffQ = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.ffF.setVisibility(i);
        this.ffG.setVisibility(i);
    }

    public void V(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aDE != null) {
            if (this.aDE.mLiveInfo == null || this.aDE.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.ffZ = arrayList;
                this.ffY = 0;
                a(this.ffY, arrayList.get(this.ffY), this.ffY + 1, arrayList.get(this.ffY + 1), z);
                this.ffY++;
                if (this.fga == null) {
                    this.fga = ValueAnimator.ofInt(100, 0);
                    this.fga.setDuration(5000L);
                    this.fga.setInterpolator(ffx);
                    this.fga.setRepeatCount(-1);
                    this.fga.setRepeatMode(1);
                    this.fga.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.ffM.setProgress(intValue);
                            AlaLiveAudienceEndView.this.ffQ.setProgress(intValue);
                        }
                    });
                    this.fga.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.boc();
                        }
                    });
                }
                if (z) {
                    this.fga.start();
                    this.ffV.setVisibility(0);
                    this.ffV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.azz, AlaLiveAudienceEndView.this.otherParams);
                            AlaLiveAudienceEndView.this.fga.cancel();
                            AlaLiveAudienceEndView.this.boc();
                            AlaLiveAudienceEndView.this.fga.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boc() {
        int i = this.ffY + 1;
        this.ffY = i;
        if (i >= this.ffZ.size()) {
            this.ffY = 0;
            i = 0;
        }
        int i2 = this.ffY + 1;
        this.ffY = i2;
        if (i2 >= this.ffZ.size()) {
            this.ffY = 0;
            i2 = 0;
        }
        this.ffY = i2;
        a(i, this.ffZ.get(i), i2, this.ffZ.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.fgb.contains(Long.valueOf(this.ffZ.get(i).live_id))) {
            this.fgb.add(Long.valueOf(this.ffZ.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.azz, this.ffZ.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.fgb.contains(Long.valueOf(this.ffZ.get(i2).live_id))) {
            this.fgb.add(Long.valueOf(this.ffZ.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.azz, this.ffZ.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.ffH, this.ffJ, this.ffK, this.ffL, this.ffM, alaLiveInfoData, z, i);
        a(this.ffI, this.ffN, this.ffO, this.ffP, this.ffQ, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.azz, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.ffZ.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.caH, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.ffy != null) {
                        AlaLiveAudienceEndView.this.ffy.e(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.caH.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.ffF;
    }

    public HeadImageView getPortraitImg() {
        return this.ffz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bod() {
        if (this.caH != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.caH);
            bdAlertDialog.setMessage(this.caH.getResources().getString(a.i.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.i.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.i.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.azz, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.ffy.ju(AlaLiveAudienceEndView.this.ffW);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.caH.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.caH.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
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
        if (this.ffE != null) {
            this.ffE.cancel();
        }
        if (this.ffC != null) {
            this.ffC.cancelAnimation();
        }
        if (this.ffD != null) {
            this.ffD.cancelAnimation();
        }
        if (this.fga != null) {
            this.fga.cancel();
        }
    }
}
