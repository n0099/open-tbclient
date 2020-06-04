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
    private static final LinearInterpolator fts = new LinearInterpolator();
    private String aEX;
    private q aJj;
    private Activity clq;
    private Animation ftA;
    private LinearLayout ftB;
    private LinearLayout ftC;
    private RelativeLayout ftD;
    private RelativeLayout ftE;
    private TbImageView ftF;
    private TextView ftG;
    private TextView ftH;
    private ProgressBar ftI;
    private TbImageView ftJ;
    private TextView ftK;
    private TextView ftL;
    private ProgressBar ftM;
    private TextView ftN;
    private LinearLayout ftO;
    private TextView ftP;
    private TextView ftQ;
    private View ftR;
    private boolean ftS;
    private boolean ftT;
    private int ftU;
    private ArrayList<AlaLiveInfoData> ftV;
    private ValueAnimator ftW;
    private Set<Long> ftX;
    private a ftt;
    private HeadImageView ftu;
    private TextView ftw;
    private ImageView ftx;
    private LottieAnimationView fty;
    private LottieAnimationView ftz;
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
        void Fb();

        void e(AlaLiveInfoData alaLiveInfoData);

        void jN(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.ftS = false;
        this.mPortrait = "";
        this.ftT = false;
        this.ftU = 0;
        this.ftX = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.ftt != null) {
                    AlaLiveAudienceEndView.this.ftt.Fb();
                }
            }
        });
        this.ftx = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.fty = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.fty.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fty.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.ftz = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.ftz.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ftz.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.ftu = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.ftu.setIsRound(true);
        this.ftu.setDrawBorder(true);
        this.ftu.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ftu.setAutoChangeStyle(false);
        this.ftw = (TextView) this.mView.findViewById(a.g.user_name);
        this.ftQ = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.ftO = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.ftN = (TextView) this.mView.findViewById(a.g.follow_label);
        this.ftO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aJj == null || AlaLiveAudienceEndView.this.aJj.mLiveInfo == null || AlaLiveAudienceEndView.this.aJj.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.ftt != null) {
                        if (AlaLiveAudienceEndView.this.ftS) {
                            AlaLiveAudienceEndView.this.btV();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aEX, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.ftt.jN(AlaLiveAudienceEndView.this.ftS);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aJj.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.clq, AlaLiveAudienceEndView.this.aJj.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.ftP = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aJj != null && this.aJj.mLiveInfo != null && this.aJj.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aJj.mLiveInfo.mLiveCloseData.title)) {
                this.ftP.setText(a.i.live_over_name);
            } else {
                this.ftP.setText(this.aJj.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.ftT) {
            this.ftP.setText(a.i.live_closed);
        } else {
            this.ftP.setText(a.i.live_over_name);
        }
        this.fty.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.ftz.setVisibility(0);
                AlaLiveAudienceEndView.this.fty.setVisibility(8);
                AlaLiveAudienceEndView.this.ftz.playAnimation();
            }
        });
        btT();
    }

    public void setCallback(a aVar) {
        this.ftt = aVar;
    }

    public void setData(TbPageContext tbPageContext, q qVar, boolean z, boolean z2, String str, String str2) {
        this.aJj = qVar;
        this.ftT = z;
        this.mTbPageContext = tbPageContext;
        this.clq = tbPageContext.getPageActivity();
        this.aJj = qVar;
        this.mLiveInfo = qVar.mLiveInfo;
        this.ftS = z2;
        this.mPortrait = str;
        this.ftT = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aEX = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aEX == null || TextUtils.equals(this.aEX, "null")) {
            this.aEX = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ftx.setVisibility(4);
        } else {
            this.ftA = AnimationUtils.loadAnimation(this.clq, a.C0182a.anim_endview_holo_rotate);
            this.ftx.startAnimation(this.ftA);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.ftu.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.ftu.startLoad(this.mPortrait, 12, false, false);
        }
        this.ftw.setText(this.aJj.avj.userName);
        this.ftO.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aJj != null && this.aJj.mLiveInfo != null && this.aJj.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aJj.mLiveInfo.mLiveCloseData.title)) {
            this.ftP.setText(this.aJj.mLiveInfo.mLiveCloseData.title);
        } else if (this.ftT) {
            this.ftP.setText(a.i.live_closed);
        } else {
            this.ftP.setText(a.i.live_over_name);
        }
        this.fty.setVisibility(0);
        this.fty.playAnimation();
        jO(this.ftS);
    }

    public void jO(boolean z) {
        this.ftS = z;
        if (this.aJj != null && this.aJj.mLiveInfo != null && this.aJj.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aJj.mLiveInfo.mLiveCloseData.tips)) {
                this.ftQ.setText("");
            } else {
                this.ftQ.setText(this.aJj.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aJj.mLiveInfo.mLiveCloseData.actionText)) {
                this.ftO.setVisibility(8);
                this.ftN.setText("");
            } else {
                this.ftO.setVisibility(0);
                this.ftN.setText(this.aJj.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.ftO.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.ftO.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.ftO.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.ftO.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.ftO.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.ftS) {
            this.ftQ.setText(a.i.endtext_followed);
            this.ftN.setText(a.i.sdk_followed);
            this.ftN.setTextColor(this.clq.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ftO.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.ftO.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.ftQ.setText(a.i.endtext_follow);
        this.ftN.setText(a.i.follow);
        this.ftN.setTextColor(this.clq.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ftO.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.ftO.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ftO.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.ftO.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void btT() {
        this.ftB = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.ftC = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.ftR = this.mView.findViewById(a.g.change_layout);
        this.ftF = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.ftG = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.ftH = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.ftJ = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.ftK = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.ftL = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.ftD = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.ftE = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.ftI = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.ftM = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.ftB.setVisibility(i);
        this.ftC.setVisibility(i);
    }

    public void V(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aJj != null) {
            if (this.aJj.mLiveInfo == null || this.aJj.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.ftV = arrayList;
                this.ftU = 0;
                a(this.ftU, arrayList.get(this.ftU), this.ftU + 1, arrayList.get(this.ftU + 1), z);
                this.ftU++;
                if (this.ftW == null) {
                    this.ftW = ValueAnimator.ofInt(100, 0);
                    this.ftW.setDuration(5000L);
                    this.ftW.setInterpolator(fts);
                    this.ftW.setRepeatCount(-1);
                    this.ftW.setRepeatMode(1);
                    this.ftW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.ftI.setProgress(intValue);
                            AlaLiveAudienceEndView.this.ftM.setProgress(intValue);
                        }
                    });
                    this.ftW.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.btU();
                        }
                    });
                }
                if (z) {
                    this.ftW.start();
                    this.ftR.setVisibility(0);
                    this.ftR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aEX, AlaLiveAudienceEndView.this.otherParams);
                            AlaLiveAudienceEndView.this.ftW.cancel();
                            AlaLiveAudienceEndView.this.btU();
                            AlaLiveAudienceEndView.this.ftW.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btU() {
        int i = this.ftU + 1;
        this.ftU = i;
        if (i >= this.ftV.size()) {
            this.ftU = 0;
            i = 0;
        }
        int i2 = this.ftU + 1;
        this.ftU = i2;
        if (i2 >= this.ftV.size()) {
            this.ftU = 0;
            i2 = 0;
        }
        this.ftU = i2;
        a(i, this.ftV.get(i), i2, this.ftV.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.ftX.contains(Long.valueOf(this.ftV.get(i).live_id))) {
            this.ftX.add(Long.valueOf(this.ftV.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aEX, this.ftV.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.ftX.contains(Long.valueOf(this.ftV.get(i2).live_id))) {
            this.ftX.add(Long.valueOf(this.ftV.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aEX, this.ftV.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.ftD, this.ftF, this.ftG, this.ftH, this.ftI, alaLiveInfoData, z, i);
        a(this.ftE, this.ftJ, this.ftK, this.ftL, this.ftM, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aEX, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.ftV.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.clq, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.ftt != null) {
                        AlaLiveAudienceEndView.this.ftt.e(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.clq.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.ftB;
    }

    public HeadImageView getPortraitImg() {
        return this.ftu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btV() {
        if (this.clq != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.clq);
            bdAlertDialog.setMessage(this.clq.getResources().getString(a.i.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.i.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.i.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aEX, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.ftt.jN(AlaLiveAudienceEndView.this.ftS);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.clq.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.clq.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
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
        if (this.ftA != null) {
            this.ftA.cancel();
        }
        if (this.fty != null) {
            this.fty.cancelAnimation();
        }
        if (this.ftz != null) {
            this.ftz.cancelAnimation();
        }
        if (this.ftW != null) {
            this.ftW.cancel();
        }
    }
}
