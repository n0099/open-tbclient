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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.liveroom.messages.ClosePageRecHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.messages.d;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator fYG = new LinearInterpolator();
    private u aAP;
    private String aPZ;
    private Activity byQ;
    private a fYH;
    private HeadImageView fYI;
    private TextView fYJ;
    private ImageView fYK;
    private LottieAnimationView fYL;
    private LottieAnimationView fYM;
    private Animation fYN;
    private LinearLayout fYO;
    private LinearLayout fYP;
    private RelativeLayout fYQ;
    private RelativeLayout fYR;
    private TbImageView fYS;
    private TextView fYT;
    private TextView fYU;
    private ProgressBar fYV;
    private TbImageView fYW;
    private TextView fYX;
    private TextView fYY;
    private ProgressBar fYZ;
    private TextView fZa;
    private LinearLayout fZb;
    private TextView fZc;
    private TextView fZd;
    private View fZe;
    private boolean fZf;
    private boolean fZg;
    private int fZh;
    private ArrayList<AlaLiveInfoData> fZi;
    private ValueAnimator fZj;
    private Set<Long> fZk;
    private HttpMessageListener fZl;
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
        void LO();

        void f(AlaLiveInfoData alaLiveInfoData);

        void lh(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.fZf = false;
        this.mPortrait = "";
        this.fZg = false;
        this.fZh = 0;
        this.fZk = new HashSet();
        this.fZl = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).fZi;
                }
                AlaLiveAudienceEndView.this.ac(arrayList);
            }
        };
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.fYH != null) {
                    AlaLiveAudienceEndView.this.fYH.LO();
                }
            }
        });
        this.fYK = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.fYL = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.fYL.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fYL.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.fYM = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.fYM.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fYM.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.fYI = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.fYI.setIsRound(true);
        this.fYI.setDrawBorder(true);
        this.fYI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fYI.setAutoChangeStyle(false);
        this.fYJ = (TextView) this.mView.findViewById(a.g.user_name);
        this.fZd = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.fZb = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.fZa = (TextView) this.mView.findViewById(a.g.follow_label);
        this.fZb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aAP == null || AlaLiveAudienceEndView.this.aAP.mLiveInfo == null || AlaLiveAudienceEndView.this.aAP.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.fYH != null) {
                        if (AlaLiveAudienceEndView.this.fZf) {
                            AlaLiveAudienceEndView.this.bKw();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aPZ, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.fYH.lh(AlaLiveAudienceEndView.this.fZf);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aAP.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.byQ, AlaLiveAudienceEndView.this.aAP.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.fZc = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aAP != null && this.aAP.mLiveInfo != null && this.aAP.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aAP.mLiveInfo.mLiveCloseData.title)) {
                this.fZc.setText(a.i.live_over_name);
            } else {
                this.fZc.setText(this.aAP.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.fZg) {
            this.fZc.setText(a.i.live_closed);
        } else {
            this.fZc.setText(a.i.live_over_name);
        }
        this.fYL.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.fYM.setVisibility(0);
                AlaLiveAudienceEndView.this.fYL.setVisibility(8);
                AlaLiveAudienceEndView.this.fYM.playAnimation();
            }
        });
        bKt();
        MessageManager.getInstance().registerListener(this.fZl);
    }

    public void setCallback(a aVar) {
        this.fYH = aVar;
    }

    public void setData(TbPageContext tbPageContext, u uVar, boolean z, boolean z2, String str, String str2) {
        this.aAP = uVar;
        this.fZg = z;
        this.mTbPageContext = tbPageContext;
        this.byQ = tbPageContext.getPageActivity();
        this.aAP = uVar;
        this.mLiveInfo = uVar.mLiveInfo;
        this.fZf = z2;
        this.mPortrait = str;
        this.fZg = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aPZ = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aPZ == null || TextUtils.equals(this.aPZ, "null")) {
            this.aPZ = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fYK.setVisibility(4);
        } else {
            this.fYN = AnimationUtils.loadAnimation(this.byQ, a.C0186a.anim_endview_holo_rotate);
            this.fYK.startAnimation(this.fYN);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.fYI.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.fYI.startLoad(this.mPortrait, 12, false, false);
        }
        this.fYJ.setText(this.aAP.aEz.userName);
        this.fZb.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aAP != null && this.aAP.mLiveInfo != null && this.aAP.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aAP.mLiveInfo.mLiveCloseData.title)) {
            this.fZc.setText(this.aAP.mLiveInfo.mLiveCloseData.title);
        } else if (this.fZg) {
            this.fZc.setText(a.i.live_closed);
        } else {
            this.fZc.setText(a.i.live_over_name);
        }
        this.fYL.setVisibility(0);
        this.fYL.playAnimation();
        li(this.fZf);
    }

    public void li(boolean z) {
        this.fZf = z;
        if (this.aAP != null && this.aAP.mLiveInfo != null && this.aAP.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aAP.mLiveInfo.mLiveCloseData.tips)) {
                this.fZd.setText("");
            } else {
                this.fZd.setText(this.aAP.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aAP.mLiveInfo.mLiveCloseData.actionText)) {
                this.fZb.setVisibility(8);
                this.fZa.setText("");
            } else {
                this.fZb.setVisibility(0);
                this.fZa.setText(this.aAP.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fZb.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.fZb.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.fZb.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.fZb.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.fZb.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.fZf) {
            this.fZd.setText(a.i.endtext_followed);
            this.fZa.setText(a.i.sdk_followed);
            this.fZa.setTextColor(this.byQ.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fZb.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.fZb.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.fZd.setText(a.i.endtext_follow);
        this.fZa.setText(a.i.follow);
        this.fZa.setTextColor(this.byQ.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fZb.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.fZb.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fZb.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fZb.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void bKt() {
        this.fYO = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.fYP = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.fZe = this.mView.findViewById(a.g.change_layout);
        this.fYS = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.fYT = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.fYU = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.fYW = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.fYX = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.fYY = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.fYQ = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.fYR = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.fYV = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.fYZ = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.fYO.setVisibility(i);
        this.fYP.setVisibility(i);
    }

    public void bKu() {
        d dVar = new d();
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aAP == null || (this.aAP.mLiveInfo != null && this.aAP.mLiveInfo.mLiveCloseData != null)) {
            setRecommendViewVisible(8);
        } else {
            setRecommendViewVisible(0);
            boolean z = arrayList.size() > 2;
            this.fZi = arrayList;
            this.fZh = 0;
            a(this.fZh, arrayList.get(this.fZh), this.fZh + 1, arrayList.get(this.fZh + 1), z);
            this.fZh++;
            if (this.fZj == null) {
                this.fZj = ValueAnimator.ofInt(100, 0);
                this.fZj.setDuration(5000L);
                this.fZj.setInterpolator(fYG);
                this.fZj.setRepeatCount(-1);
                this.fZj.setRepeatMode(1);
                this.fZj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.fYV.setProgress(intValue);
                        AlaLiveAudienceEndView.this.fYZ.setProgress(intValue);
                    }
                });
                this.fZj.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bKv();
                    }
                });
            }
            if (z) {
                this.fZj.start();
                this.fZe.setVisibility(0);
                this.fZe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aPZ, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.fZj.cancel();
                        AlaLiveAudienceEndView.this.bKv();
                        AlaLiveAudienceEndView.this.fZj.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKv() {
        int i = this.fZh + 1;
        this.fZh = i;
        if (i >= this.fZi.size()) {
            this.fZh = 0;
            i = 0;
        }
        int i2 = this.fZh + 1;
        this.fZh = i2;
        if (i2 >= this.fZi.size()) {
            this.fZh = 0;
            i2 = 0;
        }
        this.fZh = i2;
        a(i, this.fZi.get(i), i2, this.fZi.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.fZk.contains(Long.valueOf(this.fZi.get(i).live_id))) {
            this.fZk.add(Long.valueOf(this.fZi.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aPZ, this.fZi.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.fZk.contains(Long.valueOf(this.fZi.get(i2).live_id))) {
            this.fZk.add(Long.valueOf(this.fZi.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aPZ, this.fZi.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.fYQ, this.fYS, this.fYT, this.fYU, this.fYV, alaLiveInfoData, z, i);
        a(this.fYR, this.fYW, this.fYX, this.fYY, this.fYZ, alaLiveInfoData2, z, i2);
    }

    public void a(View view, TbImageView tbImageView, TextView textView, TextView textView2, ProgressBar progressBar, final AlaLiveInfoData alaLiveInfoData, boolean z, final int i) {
        if (alaLiveInfoData != null) {
            String str = alaLiveInfoData.cover;
            tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TextUtils.isEmpty(str)) {
                tbImageView.startLoad(str, 10, false);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aPZ, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.fZi.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.byQ, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.fYH != null) {
                        AlaLiveAudienceEndView.this.fYH.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.byQ.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.fYO;
    }

    public HeadImageView getPortraitImg() {
        return this.fYI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKw() {
        if (this.byQ != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.byQ);
            bdAlertDialog.setMessage(this.byQ.getResources().getString(a.i.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.i.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.10
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.i.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aPZ, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.fYH.lh(AlaLiveAudienceEndView.this.fZf);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.byQ.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.byQ.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
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
        MessageManager.getInstance().unRegisterListener(this.fZl);
        if (this.fYN != null) {
            this.fYN.cancel();
        }
        if (this.fYL != null) {
            this.fYL.cancelAnimation();
        }
        if (this.fYM != null) {
            this.fYM.cancelAnimation();
        }
        if (this.fZj != null) {
            this.fZj.cancel();
        }
    }
}
