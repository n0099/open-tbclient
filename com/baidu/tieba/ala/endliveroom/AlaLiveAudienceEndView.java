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
    private static final LinearInterpolator eBe = new LinearInterpolator();
    private String ahj;
    private m alp;
    private TextView eBA;
    private TextView eBB;
    private View eBC;
    private boolean eBD;
    private boolean eBE;
    private int eBF;
    private ArrayList<AlaLiveInfoData> eBG;
    private ValueAnimator eBH;
    private Set<Long> eBI;
    private a eBf;
    private HeadImageView eBg;
    private TextView eBh;
    private ImageView eBi;
    private LottieAnimationView eBj;
    private LottieAnimationView eBk;
    private Animation eBl;
    private LinearLayout eBm;
    private LinearLayout eBn;
    private RelativeLayout eBo;
    private RelativeLayout eBp;
    private TbImageView eBq;
    private TextView eBr;
    private TextView eBs;
    private ProgressBar eBt;
    private TbImageView eBu;
    private TextView eBv;
    private TextView eBw;
    private ProgressBar eBx;
    private TextView eBy;
    private LinearLayout eBz;
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

        void it(boolean z);

        void yK();
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.eBD = false;
        this.mPortrait = "";
        this.eBE = false;
        this.eBF = 0;
        this.eBI = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.eBf != null) {
                    AlaLiveAudienceEndView.this.eBf.yK();
                }
            }
        });
        this.eBi = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.eBj = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.eBj.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eBj.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.eBk = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.eBk.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eBk.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.eBg = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.eBg.setIsRound(true);
        this.eBg.setDrawBorder(true);
        this.eBg.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eBg.setAutoChangeStyle(false);
        this.eBh = (TextView) this.mView.findViewById(a.g.user_name);
        this.eBB = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.eBz = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.eBy = (TextView) this.mView.findViewById(a.g.follow_label);
        this.eBz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.alp == null || AlaLiveAudienceEndView.this.alp.mLiveInfo == null || AlaLiveAudienceEndView.this.alp.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.eBf != null) {
                        if (AlaLiveAudienceEndView.this.eBD) {
                            AlaLiveAudienceEndView.this.beN();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.ahj, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.eBf.it(AlaLiveAudienceEndView.this.eBD);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.alp.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.alp.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.eBA = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.alp != null && this.alp.mLiveInfo != null && this.alp.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.alp.mLiveInfo.mLiveCloseData.title)) {
                this.eBA.setText(a.i.live_over_name);
            } else {
                this.eBA.setText(this.alp.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.eBE) {
            this.eBA.setText(a.i.live_closed);
        } else {
            this.eBA.setText(a.i.live_over_name);
        }
        this.eBj.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.eBk.setVisibility(0);
                AlaLiveAudienceEndView.this.eBj.setVisibility(8);
                AlaLiveAudienceEndView.this.eBk.playAnimation();
            }
        });
        beL();
    }

    public void setCallback(a aVar) {
        this.eBf = aVar;
    }

    public void setData(TbPageContext tbPageContext, m mVar, boolean z, boolean z2, String str, String str2) {
        this.alp = mVar;
        this.eBE = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.alp = mVar;
        this.mLiveInfo = mVar.mLiveInfo;
        this.eBD = z2;
        this.mPortrait = str;
        this.eBE = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.ahj = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.ahj == null || TextUtils.equals(this.ahj, "null")) {
            this.ahj = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eBi.setVisibility(4);
        } else {
            this.eBl = AnimationUtils.loadAnimation(this.mContext, a.C0102a.anim_endview_holo_rotate);
            this.eBi.startAnimation(this.eBl);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.eBg.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.eBg.startLoad(this.mPortrait, 12, false, false);
        }
        this.eBh.setText(this.alp.Ya.userName);
        this.eBz.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.alp != null && this.alp.mLiveInfo != null && this.alp.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.alp.mLiveInfo.mLiveCloseData.title)) {
            this.eBA.setText(this.alp.mLiveInfo.mLiveCloseData.title);
        } else if (this.eBE) {
            this.eBA.setText(a.i.live_closed);
        } else {
            this.eBA.setText(a.i.live_over_name);
        }
        this.eBj.setVisibility(0);
        this.eBj.playAnimation();
        iu(this.eBD);
    }

    public void iu(boolean z) {
        this.eBD = z;
        if (this.alp != null && this.alp.mLiveInfo != null && this.alp.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.alp.mLiveInfo.mLiveCloseData.tips)) {
                this.eBB.setText("");
            } else {
                this.eBB.setText(this.alp.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.alp.mLiveInfo.mLiveCloseData.actionText)) {
                this.eBz.setVisibility(8);
                this.eBy.setText("");
            } else {
                this.eBz.setVisibility(0);
                this.eBy.setText(this.alp.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.eBz.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.eBz.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.eBz.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.eBz.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.eBz.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.eBD) {
            this.eBB.setText(a.i.endtext_followed);
            this.eBy.setText(a.i.sdk_followed);
            this.eBy.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.eBz.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.eBz.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.eBB.setText(a.i.endtext_follow);
        this.eBy.setText(a.i.follow);
        this.eBy.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.eBz.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.eBz.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eBz.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.eBz.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void beL() {
        this.eBm = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.eBn = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.eBC = this.mView.findViewById(a.g.change_layout);
        this.eBq = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.eBr = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.eBs = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.eBu = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.eBv = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.eBw = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.eBo = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.eBp = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.eBt = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.eBx = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.eBm.setVisibility(i);
        this.eBn.setVisibility(i);
    }

    public void U(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.alp != null) {
            if (this.alp.mLiveInfo == null || this.alp.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.eBG = arrayList;
                this.eBF = 0;
                a(this.eBF, arrayList.get(this.eBF), this.eBF + 1, arrayList.get(this.eBF + 1), z);
                this.eBF++;
                if (this.eBH == null) {
                    this.eBH = ValueAnimator.ofInt(100, 0);
                    this.eBH.setDuration(5000L);
                    this.eBH.setInterpolator(eBe);
                    this.eBH.setRepeatCount(-1);
                    this.eBH.setRepeatMode(1);
                    this.eBH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.eBt.setProgress(intValue);
                            AlaLiveAudienceEndView.this.eBx.setProgress(intValue);
                        }
                    });
                    this.eBH.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.beM();
                        }
                    });
                }
                if (z) {
                    this.eBH.start();
                    this.eBC.setVisibility(0);
                    this.eBC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.ahj, AlaLiveAudienceEndView.this.otherParams);
                            AlaLiveAudienceEndView.this.eBH.cancel();
                            AlaLiveAudienceEndView.this.beM();
                            AlaLiveAudienceEndView.this.eBH.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beM() {
        int i = this.eBF + 1;
        this.eBF = i;
        if (i >= this.eBG.size()) {
            this.eBF = 0;
            i = 0;
        }
        int i2 = this.eBF + 1;
        this.eBF = i2;
        if (i2 >= this.eBG.size()) {
            this.eBF = 0;
            i2 = 0;
        }
        this.eBF = i2;
        a(i, this.eBG.get(i), i2, this.eBG.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.eBI.contains(Long.valueOf(this.eBG.get(i).live_id))) {
            this.eBI.add(Long.valueOf(this.eBG.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.ahj, this.eBG.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.eBI.contains(Long.valueOf(this.eBG.get(i2).live_id))) {
            this.eBI.add(Long.valueOf(this.eBG.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.ahj, this.eBG.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.eBo, this.eBq, this.eBr, this.eBs, this.eBt, alaLiveInfoData, z, i);
        a(this.eBp, this.eBu, this.eBv, this.eBw, this.eBx, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.ahj, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.eBG.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.mContext, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.eBf != null) {
                        AlaLiveAudienceEndView.this.eBf.c(alaLiveInfoData);
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
        return this.eBm;
    }

    public HeadImageView getPortraitImg() {
        return this.eBg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beN() {
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
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.ahj, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.eBf.it(AlaLiveAudienceEndView.this.eBD);
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
        if (this.eBl != null) {
            this.eBl.cancel();
        }
        if (this.eBj != null) {
            this.eBj.cancelAnimation();
        }
        if (this.eBk != null) {
            this.eBk.cancelAnimation();
        }
        if (this.eBH != null) {
            this.eBH.cancel();
        }
    }
}
