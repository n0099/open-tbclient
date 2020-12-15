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
import com.baidu.live.data.w;
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
    private static final LinearInterpolator gJx = new LinearInterpolator();
    private w aFN;
    private String aWR;
    private Activity beD;
    private TextView gJA;
    private ImageView gJB;
    private LottieAnimationView gJC;
    private LottieAnimationView gJD;
    private Animation gJE;
    private LinearLayout gJF;
    private LinearLayout gJG;
    private RelativeLayout gJH;
    private RelativeLayout gJI;
    private TbImageView gJJ;
    private TextView gJK;
    private TextView gJL;
    private ProgressBar gJM;
    private TbImageView gJN;
    private TextView gJO;
    private TextView gJP;
    private ProgressBar gJQ;
    private TextView gJR;
    private LinearLayout gJS;
    private TextView gJT;
    private TextView gJU;
    private View gJV;
    private boolean gJW;
    private boolean gJX;
    private int gJY;
    private ArrayList<AlaLiveInfoData> gJZ;
    private a gJy;
    private HeadImageView gJz;
    private ValueAnimator gKa;
    private Set<Long> gKb;
    private HttpMessageListener gKc;
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
        void Pv();

        void f(AlaLiveInfoData alaLiveInfoData);

        void mA(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gJW = false;
        this.mPortrait = "";
        this.gJX = false;
        this.gJY = 0;
        this.gKb = new HashSet();
        this.gKc = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).gJZ;
                }
                AlaLiveAudienceEndView.this.ad(arrayList);
            }
        };
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.ala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.f.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.gJy != null) {
                    AlaLiveAudienceEndView.this.gJy.Pv();
                }
            }
        });
        this.gJB = (ImageView) this.mView.findViewById(a.f.headHalo_imageView);
        this.gJC = (LottieAnimationView) this.mView.findViewById(a.f.flowerAppear_lottieAnimationView);
        this.gJC.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gJC.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.gJD = (LottieAnimationView) this.mView.findViewById(a.f.flowerDrop_lottieAnimationView);
        this.gJD.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gJD.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.gJz = (HeadImageView) this.mView.findViewById(a.f.avatar_img);
        this.gJz.setIsRound(true);
        this.gJz.setDrawBorder(true);
        this.gJz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gJz.setAutoChangeStyle(false);
        this.gJA = (TextView) this.mView.findViewById(a.f.user_name);
        this.gJU = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.gJS = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gJR = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gJS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aFN == null || AlaLiveAudienceEndView.this.aFN.mLiveInfo == null || AlaLiveAudienceEndView.this.aFN.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.gJy != null) {
                        if (AlaLiveAudienceEndView.this.gJW) {
                            AlaLiveAudienceEndView.this.bVp();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWR, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gJy.mA(AlaLiveAudienceEndView.this.gJW);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aFN.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.beD, AlaLiveAudienceEndView.this.aFN.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.gJT = (TextView) this.mView.findViewById(a.f.live_over_name);
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.title)) {
                this.gJT.setText(a.h.live_over_name);
            } else {
                this.gJT.setText(this.aFN.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gJX) {
            this.gJT.setText(a.h.live_closed);
        } else {
            this.gJT.setText(a.h.live_over_name);
        }
        this.gJC.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.gJD.setVisibility(0);
                AlaLiveAudienceEndView.this.gJC.setVisibility(8);
                AlaLiveAudienceEndView.this.gJD.playAnimation();
            }
        });
        bVm();
        MessageManager.getInstance().registerListener(this.gKc);
    }

    public void setCallback(a aVar) {
        this.gJy = aVar;
    }

    public void setData(TbPageContext tbPageContext, w wVar, boolean z, boolean z2, String str, String str2) {
        this.aFN = wVar;
        this.gJX = z;
        this.mTbPageContext = tbPageContext;
        this.beD = tbPageContext.getPageActivity();
        this.aFN = wVar;
        this.mLiveInfo = wVar.mLiveInfo;
        this.gJW = z2;
        this.mPortrait = str;
        this.gJX = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aWR = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aWR == null || TextUtils.equals(this.aWR, "null")) {
            this.aWR = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gJB.setVisibility(4);
        } else {
            this.gJE = AnimationUtils.loadAnimation(this.beD, a.C0205a.anim_endview_holo_rotate);
            this.gJB.startAnimation(this.gJE);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.gJz.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.gJz.startLoad(this.mPortrait, 12, false, false);
        }
        this.gJA.setText(this.aFN.aJV.userName);
        this.gJS.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.title)) {
            this.gJT.setText(this.aFN.mLiveInfo.mLiveCloseData.title);
        } else if (this.gJX) {
            this.gJT.setText(a.h.live_closed);
        } else {
            this.gJT.setText(a.h.live_over_name);
        }
        this.gJC.setVisibility(0);
        this.gJC.playAnimation();
        mB(this.gJW);
    }

    public void mB(boolean z) {
        this.gJW = z;
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.tips)) {
                this.gJU.setText("");
            } else {
                this.gJU.setText(this.aFN.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.actionText)) {
                this.gJS.setVisibility(8);
                this.gJR.setText("");
            } else {
                this.gJS.setVisibility(0);
                this.gJR.setText(this.aFN.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gJS.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    this.gJS.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gJS.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_24_selector_bd);
                } else {
                    this.gJS.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gJS.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gJW) {
            this.gJU.setText(a.h.endtext_followed);
            this.gJR.setText(a.h.sdk_followed);
            this.gJR.setTextColor(this.beD.getResources().getColor(a.c.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gJS.setBackgroundResource(a.e.sdk_round_btn_gray_border_bg_radius_24_bd);
                return;
            } else {
                this.gJS.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_c);
                return;
            }
        }
        this.gJU.setText(a.h.endtext_follow);
        this.gJR.setText(a.h.follow);
        this.gJR.setTextColor(this.beD.getResources().getColor(a.c.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gJS.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            this.gJS.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gJS.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_24_selector_bd);
        } else {
            this.gJS.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
        }
    }

    private void bVm() {
        this.gJF = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gJG = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gJV = this.mView.findViewById(a.f.change_layout);
        this.gJJ = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gJK = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gJL = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.gJN = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gJO = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gJP = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.gJH = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gJI = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gJM = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gJQ = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gJF.setVisibility(i);
        this.gJG.setVisibility(i);
    }

    public void bVn() {
        d dVar = new d();
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aFN == null || (this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null)) {
            setRecommendViewVisible(8);
        } else {
            setRecommendViewVisible(0);
            boolean z = arrayList.size() > 2;
            this.gJZ = arrayList;
            this.gJY = 0;
            a(this.gJY, arrayList.get(this.gJY), this.gJY + 1, arrayList.get(this.gJY + 1), z);
            this.gJY++;
            if (this.gKa == null) {
                this.gKa = ValueAnimator.ofInt(100, 0);
                this.gKa.setDuration(5000L);
                this.gKa.setInterpolator(gJx);
                this.gKa.setRepeatCount(-1);
                this.gKa.setRepeatMode(1);
                this.gKa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.gJM.setProgress(intValue);
                        AlaLiveAudienceEndView.this.gJQ.setProgress(intValue);
                    }
                });
                this.gKa.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bVo();
                    }
                });
            }
            if (z) {
                this.gKa.start();
                this.gJV.setVisibility(0);
                this.gJV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWR, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gKa.cancel();
                        AlaLiveAudienceEndView.this.bVo();
                        AlaLiveAudienceEndView.this.gKa.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVo() {
        int i = this.gJY + 1;
        this.gJY = i;
        if (i >= this.gJZ.size()) {
            this.gJY = 0;
            i = 0;
        }
        int i2 = this.gJY + 1;
        this.gJY = i2;
        if (i2 >= this.gJZ.size()) {
            this.gJY = 0;
            i2 = 0;
        }
        this.gJY = i2;
        a(i, this.gJZ.get(i), i2, this.gJZ.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.gKb.contains(Long.valueOf(this.gJZ.get(i).live_id))) {
            this.gKb.add(Long.valueOf(this.gJZ.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aWR, this.gJZ.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.gKb.contains(Long.valueOf(this.gJZ.get(i2).live_id))) {
            this.gKb.add(Long.valueOf(this.gJZ.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aWR, this.gJZ.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.gJH, this.gJJ, this.gJK, this.gJL, this.gJM, alaLiveInfoData, z, i);
        a(this.gJI, this.gJN, this.gJO, this.gJP, this.gJQ, alaLiveInfoData2, z, i2);
    }

    public void a(View view, TbImageView tbImageView, TextView textView, TextView textView2, ProgressBar progressBar, final AlaLiveInfoData alaLiveInfoData, boolean z, final int i) {
        if (alaLiveInfoData != null) {
            String str = alaLiveInfoData.cover;
            tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TextUtils.isEmpty(str)) {
                tbImageView.startLoad(str, 10, false);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWR, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.gJZ.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.beD, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.gJy != null) {
                        AlaLiveAudienceEndView.this.gJy.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.beD.getString(a.h.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.gJF;
    }

    public HeadImageView getPortraitImg() {
        return this.gJz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVp() {
        if (this.beD != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.beD);
            bdAlertDialog.setMessage(this.beD.getResources().getString(a.h.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.h.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.10
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.h.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWR, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.gJy.mA(AlaLiveAudienceEndView.this.gJW);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.beD.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.beD.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
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
        MessageManager.getInstance().unRegisterListener(this.gKc);
        if (this.gJE != null) {
            this.gJE.cancel();
        }
        if (this.gJC != null) {
            this.gJC.cancelAnimation();
        }
        if (this.gJD != null) {
            this.gJD.cancelAnimation();
        }
        if (this.gKa != null) {
            this.gKa.cancel();
            this.gKa.removeAllUpdateListeners();
            this.gKa.removeAllListeners();
        }
    }
}
