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
/* loaded from: classes4.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator fJY = new LinearInterpolator();
    private String aIO;
    private q avf;
    private Activity bdG;
    private a fJZ;
    private ArrayList<AlaLiveInfoData> fKA;
    private ValueAnimator fKB;
    private Set<Long> fKC;
    private HeadImageView fKa;
    private TextView fKb;
    private ImageView fKc;
    private LottieAnimationView fKd;
    private LottieAnimationView fKe;
    private Animation fKf;
    private LinearLayout fKg;
    private LinearLayout fKh;
    private RelativeLayout fKi;
    private RelativeLayout fKj;
    private TbImageView fKk;
    private TextView fKl;
    private TextView fKm;
    private ProgressBar fKn;
    private TbImageView fKo;
    private TextView fKp;
    private TextView fKq;
    private ProgressBar fKr;
    private TextView fKs;
    private LinearLayout fKt;
    private TextView fKu;
    private TextView fKv;
    private View fKw;
    private boolean fKx;
    private boolean fKy;
    private int fKz;
    private String liveId;
    private ImageView mCloseBtn;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private String otherParams;
    private String roomId;

    /* loaded from: classes4.dex */
    public interface a {
        void FE();

        void f(AlaLiveInfoData alaLiveInfoData);

        void kF(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.fKx = false;
        this.mPortrait = "";
        this.fKy = false;
        this.fKz = 0;
        this.fKC = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.fJZ != null) {
                    AlaLiveAudienceEndView.this.fJZ.FE();
                }
            }
        });
        this.fKc = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.fKd = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.fKd.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fKd.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.fKe = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.fKe.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fKe.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.fKa = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.fKa.setIsRound(true);
        this.fKa.setDrawBorder(true);
        this.fKa.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fKa.setAutoChangeStyle(false);
        this.fKb = (TextView) this.mView.findViewById(a.g.user_name);
        this.fKv = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.fKt = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.fKs = (TextView) this.mView.findViewById(a.g.follow_label);
        this.fKt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.avf == null || AlaLiveAudienceEndView.this.avf.mLiveInfo == null || AlaLiveAudienceEndView.this.avf.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.fJZ != null) {
                        if (AlaLiveAudienceEndView.this.fKx) {
                            AlaLiveAudienceEndView.this.bAh();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aIO, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.fJZ.kF(AlaLiveAudienceEndView.this.fKx);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.avf.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.bdG, AlaLiveAudienceEndView.this.avf.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.fKu = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.avf != null && this.avf.mLiveInfo != null && this.avf.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.avf.mLiveInfo.mLiveCloseData.title)) {
                this.fKu.setText(a.i.live_over_name);
            } else {
                this.fKu.setText(this.avf.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.fKy) {
            this.fKu.setText(a.i.live_closed);
        } else {
            this.fKu.setText(a.i.live_over_name);
        }
        this.fKd.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.fKe.setVisibility(0);
                AlaLiveAudienceEndView.this.fKd.setVisibility(8);
                AlaLiveAudienceEndView.this.fKe.playAnimation();
            }
        });
        bAf();
    }

    public void setCallback(a aVar) {
        this.fJZ = aVar;
    }

    public void setData(TbPageContext tbPageContext, q qVar, boolean z, boolean z2, String str, String str2) {
        this.avf = qVar;
        this.fKy = z;
        this.mTbPageContext = tbPageContext;
        this.bdG = tbPageContext.getPageActivity();
        this.avf = qVar;
        this.mLiveInfo = qVar.mLiveInfo;
        this.fKx = z2;
        this.mPortrait = str;
        this.fKy = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aIO = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aIO == null || TextUtils.equals(this.aIO, "null")) {
            this.aIO = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fKc.setVisibility(4);
        } else {
            this.fKf = AnimationUtils.loadAnimation(this.bdG, a.C0178a.anim_endview_holo_rotate);
            this.fKc.startAnimation(this.fKf);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.fKa.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.fKa.startLoad(this.mPortrait, 12, false, false);
        }
        this.fKb.setText(this.avf.ayC.userName);
        this.fKt.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.avf != null && this.avf.mLiveInfo != null && this.avf.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.avf.mLiveInfo.mLiveCloseData.title)) {
            this.fKu.setText(this.avf.mLiveInfo.mLiveCloseData.title);
        } else if (this.fKy) {
            this.fKu.setText(a.i.live_closed);
        } else {
            this.fKu.setText(a.i.live_over_name);
        }
        this.fKd.setVisibility(0);
        this.fKd.playAnimation();
        kG(this.fKx);
    }

    public void kG(boolean z) {
        this.fKx = z;
        if (this.avf != null && this.avf.mLiveInfo != null && this.avf.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.avf.mLiveInfo.mLiveCloseData.tips)) {
                this.fKv.setText("");
            } else {
                this.fKv.setText(this.avf.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.avf.mLiveInfo.mLiveCloseData.actionText)) {
                this.fKt.setVisibility(8);
                this.fKs.setText("");
            } else {
                this.fKt.setVisibility(0);
                this.fKs.setText(this.avf.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fKt.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.fKt.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.fKt.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.fKt.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.fKt.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.fKx) {
            this.fKv.setText(a.i.endtext_followed);
            this.fKs.setText(a.i.sdk_followed);
            this.fKs.setTextColor(this.bdG.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fKt.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.fKt.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.fKv.setText(a.i.endtext_follow);
        this.fKs.setText(a.i.follow);
        this.fKs.setTextColor(this.bdG.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fKt.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.fKt.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fKt.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fKt.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void bAf() {
        this.fKg = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.fKh = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.fKw = this.mView.findViewById(a.g.change_layout);
        this.fKk = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.fKl = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.fKm = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.fKo = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.fKp = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.fKq = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.fKi = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.fKj = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.fKn = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.fKr = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.fKg.setVisibility(i);
        this.fKh.setVisibility(i);
    }

    public void W(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.avf != null) {
            if (this.avf.mLiveInfo == null || this.avf.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.fKA = arrayList;
                this.fKz = 0;
                a(this.fKz, arrayList.get(this.fKz), this.fKz + 1, arrayList.get(this.fKz + 1), z);
                this.fKz++;
                if (this.fKB == null) {
                    this.fKB = ValueAnimator.ofInt(100, 0);
                    this.fKB.setDuration(5000L);
                    this.fKB.setInterpolator(fJY);
                    this.fKB.setRepeatCount(-1);
                    this.fKB.setRepeatMode(1);
                    this.fKB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.fKn.setProgress(intValue);
                            AlaLiveAudienceEndView.this.fKr.setProgress(intValue);
                        }
                    });
                    this.fKB.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.bAg();
                        }
                    });
                }
                if (z) {
                    this.fKB.start();
                    this.fKw.setVisibility(0);
                    this.fKw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aIO, AlaLiveAudienceEndView.this.otherParams);
                            AlaLiveAudienceEndView.this.fKB.cancel();
                            AlaLiveAudienceEndView.this.bAg();
                            AlaLiveAudienceEndView.this.fKB.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAg() {
        int i = this.fKz + 1;
        this.fKz = i;
        if (i >= this.fKA.size()) {
            this.fKz = 0;
            i = 0;
        }
        int i2 = this.fKz + 1;
        this.fKz = i2;
        if (i2 >= this.fKA.size()) {
            this.fKz = 0;
            i2 = 0;
        }
        this.fKz = i2;
        a(i, this.fKA.get(i), i2, this.fKA.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.fKC.contains(Long.valueOf(this.fKA.get(i).live_id))) {
            this.fKC.add(Long.valueOf(this.fKA.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aIO, this.fKA.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.fKC.contains(Long.valueOf(this.fKA.get(i2).live_id))) {
            this.fKC.add(Long.valueOf(this.fKA.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aIO, this.fKA.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.fKi, this.fKk, this.fKl, this.fKm, this.fKn, alaLiveInfoData, z, i);
        a(this.fKj, this.fKo, this.fKp, this.fKq, this.fKr, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aIO, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.fKA.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.bdG, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.fJZ != null) {
                        AlaLiveAudienceEndView.this.fJZ.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.bdG.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.fKg;
    }

    public HeadImageView getPortraitImg() {
        return this.fKa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAh() {
        if (this.bdG != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.bdG);
            bdAlertDialog.setMessage(this.bdG.getResources().getString(a.i.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.i.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.i.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aIO, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.fJZ.kF(AlaLiveAudienceEndView.this.fKx);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.bdG.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.bdG.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
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
        if (this.fKf != null) {
            this.fKf.cancel();
        }
        if (this.fKd != null) {
            this.fKd.cancelAnimation();
        }
        if (this.fKe != null) {
            this.fKe.cancelAnimation();
        }
        if (this.fKB != null) {
            this.fKB.cancel();
        }
    }
}
