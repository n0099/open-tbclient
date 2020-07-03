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
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator fED = new LinearInterpolator();
    private String aHt;
    private q aLQ;
    private Activity bdo;
    private a fEE;
    private HeadImageView fEF;
    private TextView fEG;
    private ImageView fEH;
    private LottieAnimationView fEI;
    private LottieAnimationView fEJ;
    private Animation fEK;
    private LinearLayout fEL;
    private LinearLayout fEM;
    private RelativeLayout fEN;
    private RelativeLayout fEO;
    private TbImageView fEP;
    private TextView fEQ;
    private TextView fER;
    private ProgressBar fES;
    private TbImageView fET;
    private TextView fEU;
    private TextView fEV;
    private ProgressBar fEW;
    private TextView fEX;
    private LinearLayout fEY;
    private TextView fEZ;
    private TextView fFa;
    private View fFb;
    private boolean fFc;
    private boolean fFd;
    private int fFe;
    private ArrayList<AlaLiveInfoData> fFf;
    private ValueAnimator fFg;
    private Set<Long> fFh;
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
        void FK();

        void f(AlaLiveInfoData alaLiveInfoData);

        void kb(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.fFc = false;
        this.mPortrait = "";
        this.fFd = false;
        this.fFe = 0;
        this.fFh = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.fEE != null) {
                    AlaLiveAudienceEndView.this.fEE.FK();
                }
            }
        });
        this.fEH = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.fEI = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.fEI.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fEI.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.fEJ = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.fEJ.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fEJ.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.fEF = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.fEF.setIsRound(true);
        this.fEF.setDrawBorder(true);
        this.fEF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fEF.setAutoChangeStyle(false);
        this.fEG = (TextView) this.mView.findViewById(a.g.user_name);
        this.fFa = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.fEY = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.fEX = (TextView) this.mView.findViewById(a.g.follow_label);
        this.fEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aLQ == null || AlaLiveAudienceEndView.this.aLQ.mLiveInfo == null || AlaLiveAudienceEndView.this.aLQ.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.fEE != null) {
                        if (AlaLiveAudienceEndView.this.fFc) {
                            AlaLiveAudienceEndView.this.bwQ();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aHt, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.fEE.kb(AlaLiveAudienceEndView.this.fFc);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aLQ.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.bdo, AlaLiveAudienceEndView.this.aLQ.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.fEZ = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aLQ != null && this.aLQ.mLiveInfo != null && this.aLQ.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aLQ.mLiveInfo.mLiveCloseData.title)) {
                this.fEZ.setText(a.i.live_over_name);
            } else {
                this.fEZ.setText(this.aLQ.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.fFd) {
            this.fEZ.setText(a.i.live_closed);
        } else {
            this.fEZ.setText(a.i.live_over_name);
        }
        this.fEI.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.fEJ.setVisibility(0);
                AlaLiveAudienceEndView.this.fEI.setVisibility(8);
                AlaLiveAudienceEndView.this.fEJ.playAnimation();
            }
        });
        bwO();
    }

    public void setCallback(a aVar) {
        this.fEE = aVar;
    }

    public void setData(TbPageContext tbPageContext, q qVar, boolean z, boolean z2, String str, String str2) {
        this.aLQ = qVar;
        this.fFd = z;
        this.mTbPageContext = tbPageContext;
        this.bdo = tbPageContext.getPageActivity();
        this.aLQ = qVar;
        this.mLiveInfo = qVar.mLiveInfo;
        this.fFc = z2;
        this.mPortrait = str;
        this.fFd = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aHt = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aHt == null || TextUtils.equals(this.aHt, "null")) {
            this.aHt = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fEH.setVisibility(4);
        } else {
            this.fEK = AnimationUtils.loadAnimation(this.bdo, a.C0176a.anim_endview_holo_rotate);
            this.fEH.startAnimation(this.fEK);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.fEF.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.fEF.startLoad(this.mPortrait, 12, false, false);
        }
        this.fEG.setText(this.aLQ.axp.userName);
        this.fEY.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aLQ != null && this.aLQ.mLiveInfo != null && this.aLQ.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aLQ.mLiveInfo.mLiveCloseData.title)) {
            this.fEZ.setText(this.aLQ.mLiveInfo.mLiveCloseData.title);
        } else if (this.fFd) {
            this.fEZ.setText(a.i.live_closed);
        } else {
            this.fEZ.setText(a.i.live_over_name);
        }
        this.fEI.setVisibility(0);
        this.fEI.playAnimation();
        kc(this.fFc);
    }

    public void kc(boolean z) {
        this.fFc = z;
        if (this.aLQ != null && this.aLQ.mLiveInfo != null && this.aLQ.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aLQ.mLiveInfo.mLiveCloseData.tips)) {
                this.fFa.setText("");
            } else {
                this.fFa.setText(this.aLQ.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aLQ.mLiveInfo.mLiveCloseData.actionText)) {
                this.fEY.setVisibility(8);
                this.fEX.setText("");
            } else {
                this.fEY.setVisibility(0);
                this.fEX.setText(this.aLQ.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fEY.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.fEY.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.fEY.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.fEY.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.fEY.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.fFc) {
            this.fFa.setText(a.i.endtext_followed);
            this.fEX.setText(a.i.sdk_followed);
            this.fEX.setTextColor(this.bdo.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fEY.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.fEY.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.fFa.setText(a.i.endtext_follow);
        this.fEX.setText(a.i.follow);
        this.fEX.setTextColor(this.bdo.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fEY.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.fEY.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fEY.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fEY.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void bwO() {
        this.fEL = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.fEM = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.fFb = this.mView.findViewById(a.g.change_layout);
        this.fEP = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.fEQ = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.fER = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.fET = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.fEU = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.fEV = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.fEN = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.fEO = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.fES = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.fEW = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.fEL.setVisibility(i);
        this.fEM.setVisibility(i);
    }

    public void V(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aLQ != null) {
            if (this.aLQ.mLiveInfo == null || this.aLQ.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.fFf = arrayList;
                this.fFe = 0;
                a(this.fFe, arrayList.get(this.fFe), this.fFe + 1, arrayList.get(this.fFe + 1), z);
                this.fFe++;
                if (this.fFg == null) {
                    this.fFg = ValueAnimator.ofInt(100, 0);
                    this.fFg.setDuration(5000L);
                    this.fFg.setInterpolator(fED);
                    this.fFg.setRepeatCount(-1);
                    this.fFg.setRepeatMode(1);
                    this.fFg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.fES.setProgress(intValue);
                            AlaLiveAudienceEndView.this.fEW.setProgress(intValue);
                        }
                    });
                    this.fFg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.bwP();
                        }
                    });
                }
                if (z) {
                    this.fFg.start();
                    this.fFb.setVisibility(0);
                    this.fFb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aHt, AlaLiveAudienceEndView.this.otherParams);
                            AlaLiveAudienceEndView.this.fFg.cancel();
                            AlaLiveAudienceEndView.this.bwP();
                            AlaLiveAudienceEndView.this.fFg.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwP() {
        int i = this.fFe + 1;
        this.fFe = i;
        if (i >= this.fFf.size()) {
            this.fFe = 0;
            i = 0;
        }
        int i2 = this.fFe + 1;
        this.fFe = i2;
        if (i2 >= this.fFf.size()) {
            this.fFe = 0;
            i2 = 0;
        }
        this.fFe = i2;
        a(i, this.fFf.get(i), i2, this.fFf.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.fFh.contains(Long.valueOf(this.fFf.get(i).live_id))) {
            this.fFh.add(Long.valueOf(this.fFf.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aHt, this.fFf.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.fFh.contains(Long.valueOf(this.fFf.get(i2).live_id))) {
            this.fFh.add(Long.valueOf(this.fFf.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aHt, this.fFf.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.fEN, this.fEP, this.fEQ, this.fER, this.fES, alaLiveInfoData, z, i);
        a(this.fEO, this.fET, this.fEU, this.fEV, this.fEW, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aHt, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.fFf.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.bdo, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.fEE != null) {
                        AlaLiveAudienceEndView.this.fEE.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.bdo.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.fEL;
    }

    public HeadImageView getPortraitImg() {
        return this.fEF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwQ() {
        if (this.bdo != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.bdo);
            bdAlertDialog.setMessage(this.bdo.getResources().getString(a.i.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.i.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.i.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aHt, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.fEE.kb(AlaLiveAudienceEndView.this.fFc);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.bdo.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.bdo.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
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
        if (this.fEK != null) {
            this.fEK.cancel();
        }
        if (this.fEI != null) {
            this.fEI.cancelAnimation();
        }
        if (this.fEJ != null) {
            this.fEJ.cancelAnimation();
        }
        if (this.fFg != null) {
            this.fFg.cancel();
        }
    }
}
