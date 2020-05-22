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
    private static final LinearInterpolator fth = new LinearInterpolator();
    private String aEX;
    private q aJj;
    private Activity clq;
    private TextView ftA;
    private ProgressBar ftB;
    private TextView ftC;
    private LinearLayout ftD;
    private TextView ftE;
    private TextView ftF;
    private View ftG;
    private boolean ftH;
    private boolean ftI;
    private int ftJ;
    private ArrayList<AlaLiveInfoData> ftK;
    private ValueAnimator ftL;
    private Set<Long> ftM;
    private a fti;
    private HeadImageView ftj;
    private TextView ftk;
    private ImageView ftl;
    private LottieAnimationView ftm;
    private LottieAnimationView ftn;
    private Animation fto;
    private LinearLayout ftp;
    private LinearLayout ftq;
    private RelativeLayout ftr;
    private RelativeLayout fts;
    private TbImageView ftt;
    private TextView ftu;
    private TextView ftw;
    private ProgressBar ftx;
    private TbImageView fty;
    private TextView ftz;
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
        this.ftH = false;
        this.mPortrait = "";
        this.ftI = false;
        this.ftJ = 0;
        this.ftM = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.fti != null) {
                    AlaLiveAudienceEndView.this.fti.Fb();
                }
            }
        });
        this.ftl = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.ftm = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.ftm.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ftm.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.ftn = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.ftn.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ftn.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.ftj = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.ftj.setIsRound(true);
        this.ftj.setDrawBorder(true);
        this.ftj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ftj.setAutoChangeStyle(false);
        this.ftk = (TextView) this.mView.findViewById(a.g.user_name);
        this.ftF = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.ftD = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.ftC = (TextView) this.mView.findViewById(a.g.follow_label);
        this.ftD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aJj == null || AlaLiveAudienceEndView.this.aJj.mLiveInfo == null || AlaLiveAudienceEndView.this.aJj.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.fti != null) {
                        if (AlaLiveAudienceEndView.this.ftH) {
                            AlaLiveAudienceEndView.this.btT();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aEX, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.fti.jN(AlaLiveAudienceEndView.this.ftH);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aJj.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.clq, AlaLiveAudienceEndView.this.aJj.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.ftE = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aJj != null && this.aJj.mLiveInfo != null && this.aJj.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aJj.mLiveInfo.mLiveCloseData.title)) {
                this.ftE.setText(a.i.live_over_name);
            } else {
                this.ftE.setText(this.aJj.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.ftI) {
            this.ftE.setText(a.i.live_closed);
        } else {
            this.ftE.setText(a.i.live_over_name);
        }
        this.ftm.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.ftn.setVisibility(0);
                AlaLiveAudienceEndView.this.ftm.setVisibility(8);
                AlaLiveAudienceEndView.this.ftn.playAnimation();
            }
        });
        btR();
    }

    public void setCallback(a aVar) {
        this.fti = aVar;
    }

    public void setData(TbPageContext tbPageContext, q qVar, boolean z, boolean z2, String str, String str2) {
        this.aJj = qVar;
        this.ftI = z;
        this.mTbPageContext = tbPageContext;
        this.clq = tbPageContext.getPageActivity();
        this.aJj = qVar;
        this.mLiveInfo = qVar.mLiveInfo;
        this.ftH = z2;
        this.mPortrait = str;
        this.ftI = z;
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
            this.ftl.setVisibility(4);
        } else {
            this.fto = AnimationUtils.loadAnimation(this.clq, a.C0182a.anim_endview_holo_rotate);
            this.ftl.startAnimation(this.fto);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.ftj.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.ftj.startLoad(this.mPortrait, 12, false, false);
        }
        this.ftk.setText(this.aJj.avj.userName);
        this.ftD.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aJj != null && this.aJj.mLiveInfo != null && this.aJj.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aJj.mLiveInfo.mLiveCloseData.title)) {
            this.ftE.setText(this.aJj.mLiveInfo.mLiveCloseData.title);
        } else if (this.ftI) {
            this.ftE.setText(a.i.live_closed);
        } else {
            this.ftE.setText(a.i.live_over_name);
        }
        this.ftm.setVisibility(0);
        this.ftm.playAnimation();
        jO(this.ftH);
    }

    public void jO(boolean z) {
        this.ftH = z;
        if (this.aJj != null && this.aJj.mLiveInfo != null && this.aJj.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aJj.mLiveInfo.mLiveCloseData.tips)) {
                this.ftF.setText("");
            } else {
                this.ftF.setText(this.aJj.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aJj.mLiveInfo.mLiveCloseData.actionText)) {
                this.ftD.setVisibility(8);
                this.ftC.setText("");
            } else {
                this.ftD.setVisibility(0);
                this.ftC.setText(this.aJj.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.ftD.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.ftD.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.ftD.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.ftD.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.ftD.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.ftH) {
            this.ftF.setText(a.i.endtext_followed);
            this.ftC.setText(a.i.sdk_followed);
            this.ftC.setTextColor(this.clq.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ftD.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.ftD.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.ftF.setText(a.i.endtext_follow);
        this.ftC.setText(a.i.follow);
        this.ftC.setTextColor(this.clq.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ftD.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.ftD.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ftD.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.ftD.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void btR() {
        this.ftp = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.ftq = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.ftG = this.mView.findViewById(a.g.change_layout);
        this.ftt = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.ftu = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.ftw = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.fty = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.ftz = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.ftA = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.ftr = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.fts = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.ftx = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.ftB = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.ftp.setVisibility(i);
        this.ftq.setVisibility(i);
    }

    public void V(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aJj != null) {
            if (this.aJj.mLiveInfo == null || this.aJj.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.ftK = arrayList;
                this.ftJ = 0;
                a(this.ftJ, arrayList.get(this.ftJ), this.ftJ + 1, arrayList.get(this.ftJ + 1), z);
                this.ftJ++;
                if (this.ftL == null) {
                    this.ftL = ValueAnimator.ofInt(100, 0);
                    this.ftL.setDuration(5000L);
                    this.ftL.setInterpolator(fth);
                    this.ftL.setRepeatCount(-1);
                    this.ftL.setRepeatMode(1);
                    this.ftL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.ftx.setProgress(intValue);
                            AlaLiveAudienceEndView.this.ftB.setProgress(intValue);
                        }
                    });
                    this.ftL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.btS();
                        }
                    });
                }
                if (z) {
                    this.ftL.start();
                    this.ftG.setVisibility(0);
                    this.ftG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aEX, AlaLiveAudienceEndView.this.otherParams);
                            AlaLiveAudienceEndView.this.ftL.cancel();
                            AlaLiveAudienceEndView.this.btS();
                            AlaLiveAudienceEndView.this.ftL.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btS() {
        int i = this.ftJ + 1;
        this.ftJ = i;
        if (i >= this.ftK.size()) {
            this.ftJ = 0;
            i = 0;
        }
        int i2 = this.ftJ + 1;
        this.ftJ = i2;
        if (i2 >= this.ftK.size()) {
            this.ftJ = 0;
            i2 = 0;
        }
        this.ftJ = i2;
        a(i, this.ftK.get(i), i2, this.ftK.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.ftM.contains(Long.valueOf(this.ftK.get(i).live_id))) {
            this.ftM.add(Long.valueOf(this.ftK.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aEX, this.ftK.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.ftM.contains(Long.valueOf(this.ftK.get(i2).live_id))) {
            this.ftM.add(Long.valueOf(this.ftK.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aEX, this.ftK.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.ftr, this.ftt, this.ftu, this.ftw, this.ftx, alaLiveInfoData, z, i);
        a(this.fts, this.fty, this.ftz, this.ftA, this.ftB, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aEX, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.ftK.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.clq, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.fti != null) {
                        AlaLiveAudienceEndView.this.fti.e(alaLiveInfoData);
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
        return this.ftp;
    }

    public HeadImageView getPortraitImg() {
        return this.ftj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btT() {
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
                    AlaLiveAudienceEndView.this.fti.jN(AlaLiveAudienceEndView.this.ftH);
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
        if (this.fto != null) {
            this.fto.cancel();
        }
        if (this.ftm != null) {
            this.ftm.cancelAnimation();
        }
        if (this.ftn != null) {
            this.ftn.cancelAnimation();
        }
        if (this.ftL != null) {
            this.ftL.cancel();
        }
    }
}
