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
    private static final LinearInterpolator gAy = new LinearInterpolator();
    private w aDh;
    private String aTN;
    private Activity bMo;
    private HeadImageView gAA;
    private TextView gAB;
    private ImageView gAC;
    private LottieAnimationView gAD;
    private LottieAnimationView gAE;
    private Animation gAF;
    private LinearLayout gAG;
    private LinearLayout gAH;
    private RelativeLayout gAI;
    private RelativeLayout gAJ;
    private TbImageView gAK;
    private TextView gAL;
    private TextView gAM;
    private ProgressBar gAN;
    private TbImageView gAO;
    private TextView gAP;
    private TextView gAQ;
    private ProgressBar gAR;
    private TextView gAS;
    private LinearLayout gAT;
    private TextView gAU;
    private TextView gAV;
    private View gAW;
    private boolean gAX;
    private boolean gAY;
    private int gAZ;
    private a gAz;
    private ArrayList<AlaLiveInfoData> gBa;
    private ValueAnimator gBb;
    private Set<Long> gBc;
    private HttpMessageListener gBd;
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
        void Nd();

        void f(AlaLiveInfoData alaLiveInfoData);

        void mf(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gAX = false;
        this.mPortrait = "";
        this.gAY = false;
        this.gAZ = 0;
        this.gBc = new HashSet();
        this.gBd = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).gBa;
                }
                AlaLiveAudienceEndView.this.ac(arrayList);
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
                if (AlaLiveAudienceEndView.this.gAz != null) {
                    AlaLiveAudienceEndView.this.gAz.Nd();
                }
            }
        });
        this.gAC = (ImageView) this.mView.findViewById(a.f.headHalo_imageView);
        this.gAD = (LottieAnimationView) this.mView.findViewById(a.f.flowerAppear_lottieAnimationView);
        this.gAD.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gAD.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.gAE = (LottieAnimationView) this.mView.findViewById(a.f.flowerDrop_lottieAnimationView);
        this.gAE.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gAE.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.gAA = (HeadImageView) this.mView.findViewById(a.f.avatar_img);
        this.gAA.setIsRound(true);
        this.gAA.setDrawBorder(true);
        this.gAA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gAA.setAutoChangeStyle(false);
        this.gAB = (TextView) this.mView.findViewById(a.f.user_name);
        this.gAV = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.gAT = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gAS = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gAT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aDh == null || AlaLiveAudienceEndView.this.aDh.mLiveInfo == null || AlaLiveAudienceEndView.this.aDh.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.gAz != null) {
                        if (AlaLiveAudienceEndView.this.gAX) {
                            AlaLiveAudienceEndView.this.bRE();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTN, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gAz.mf(AlaLiveAudienceEndView.this.gAX);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aDh.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.bMo, AlaLiveAudienceEndView.this.aDh.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.gAU = (TextView) this.mView.findViewById(a.f.live_over_name);
        if (this.aDh != null && this.aDh.mLiveInfo != null && this.aDh.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDh.mLiveInfo.mLiveCloseData.title)) {
                this.gAU.setText(a.h.live_over_name);
            } else {
                this.gAU.setText(this.aDh.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gAY) {
            this.gAU.setText(a.h.live_closed);
        } else {
            this.gAU.setText(a.h.live_over_name);
        }
        this.gAD.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.gAE.setVisibility(0);
                AlaLiveAudienceEndView.this.gAD.setVisibility(8);
                AlaLiveAudienceEndView.this.gAE.playAnimation();
            }
        });
        bRB();
        MessageManager.getInstance().registerListener(this.gBd);
    }

    public void setCallback(a aVar) {
        this.gAz = aVar;
    }

    public void setData(TbPageContext tbPageContext, w wVar, boolean z, boolean z2, String str, String str2) {
        this.aDh = wVar;
        this.gAY = z;
        this.mTbPageContext = tbPageContext;
        this.bMo = tbPageContext.getPageActivity();
        this.aDh = wVar;
        this.mLiveInfo = wVar.mLiveInfo;
        this.gAX = z2;
        this.mPortrait = str;
        this.gAY = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aTN = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aTN == null || TextUtils.equals(this.aTN, "null")) {
            this.aTN = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gAC.setVisibility(4);
        } else {
            this.gAF = AnimationUtils.loadAnimation(this.bMo, a.C0195a.anim_endview_holo_rotate);
            this.gAC.startAnimation(this.gAF);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.gAA.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.gAA.startLoad(this.mPortrait, 12, false, false);
        }
        this.gAB.setText(this.aDh.aHk.userName);
        this.gAT.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aDh != null && this.aDh.mLiveInfo != null && this.aDh.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aDh.mLiveInfo.mLiveCloseData.title)) {
            this.gAU.setText(this.aDh.mLiveInfo.mLiveCloseData.title);
        } else if (this.gAY) {
            this.gAU.setText(a.h.live_closed);
        } else {
            this.gAU.setText(a.h.live_over_name);
        }
        this.gAD.setVisibility(0);
        this.gAD.playAnimation();
        mg(this.gAX);
    }

    public void mg(boolean z) {
        this.gAX = z;
        if (this.aDh != null && this.aDh.mLiveInfo != null && this.aDh.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDh.mLiveInfo.mLiveCloseData.tips)) {
                this.gAV.setText("");
            } else {
                this.gAV.setText(this.aDh.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aDh.mLiveInfo.mLiveCloseData.actionText)) {
                this.gAT.setVisibility(8);
                this.gAS.setText("");
            } else {
                this.gAT.setVisibility(0);
                this.gAS.setText(this.aDh.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gAT.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    this.gAT.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gAT.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_24_selector_bd);
                } else {
                    this.gAT.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gAT.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gAX) {
            this.gAV.setText(a.h.endtext_followed);
            this.gAS.setText(a.h.sdk_followed);
            this.gAS.setTextColor(this.bMo.getResources().getColor(a.c.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gAT.setBackgroundResource(a.e.sdk_round_btn_gray_border_bg_radius_24_bd);
                return;
            } else {
                this.gAT.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_c);
                return;
            }
        }
        this.gAV.setText(a.h.endtext_follow);
        this.gAS.setText(a.h.follow);
        this.gAS.setTextColor(this.bMo.getResources().getColor(a.c.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gAT.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            this.gAT.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gAT.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_24_selector_bd);
        } else {
            this.gAT.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
        }
    }

    private void bRB() {
        this.gAG = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gAH = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gAW = this.mView.findViewById(a.f.change_layout);
        this.gAK = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gAL = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gAM = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.gAO = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gAP = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gAQ = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.gAI = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gAJ = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gAN = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gAR = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gAG.setVisibility(i);
        this.gAH.setVisibility(i);
    }

    public void bRC() {
        d dVar = new d();
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aDh == null || (this.aDh.mLiveInfo != null && this.aDh.mLiveInfo.mLiveCloseData != null)) {
            setRecommendViewVisible(8);
        } else {
            setRecommendViewVisible(0);
            boolean z = arrayList.size() > 2;
            this.gBa = arrayList;
            this.gAZ = 0;
            a(this.gAZ, arrayList.get(this.gAZ), this.gAZ + 1, arrayList.get(this.gAZ + 1), z);
            this.gAZ++;
            if (this.gBb == null) {
                this.gBb = ValueAnimator.ofInt(100, 0);
                this.gBb.setDuration(5000L);
                this.gBb.setInterpolator(gAy);
                this.gBb.setRepeatCount(-1);
                this.gBb.setRepeatMode(1);
                this.gBb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.gAN.setProgress(intValue);
                        AlaLiveAudienceEndView.this.gAR.setProgress(intValue);
                    }
                });
                this.gBb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bRD();
                    }
                });
            }
            if (z) {
                this.gBb.start();
                this.gAW.setVisibility(0);
                this.gAW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTN, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gBb.cancel();
                        AlaLiveAudienceEndView.this.bRD();
                        AlaLiveAudienceEndView.this.gBb.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRD() {
        int i = this.gAZ + 1;
        this.gAZ = i;
        if (i >= this.gBa.size()) {
            this.gAZ = 0;
            i = 0;
        }
        int i2 = this.gAZ + 1;
        this.gAZ = i2;
        if (i2 >= this.gBa.size()) {
            this.gAZ = 0;
            i2 = 0;
        }
        this.gAZ = i2;
        a(i, this.gBa.get(i), i2, this.gBa.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.gBc.contains(Long.valueOf(this.gBa.get(i).live_id))) {
            this.gBc.add(Long.valueOf(this.gBa.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aTN, this.gBa.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.gBc.contains(Long.valueOf(this.gBa.get(i2).live_id))) {
            this.gBc.add(Long.valueOf(this.gBa.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aTN, this.gBa.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.gAI, this.gAK, this.gAL, this.gAM, this.gAN, alaLiveInfoData, z, i);
        a(this.gAJ, this.gAO, this.gAP, this.gAQ, this.gAR, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTN, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.gBa.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.bMo, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.gAz != null) {
                        AlaLiveAudienceEndView.this.gAz.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.bMo.getString(a.h.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.gAG;
    }

    public HeadImageView getPortraitImg() {
        return this.gAA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRE() {
        if (this.bMo != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.bMo);
            bdAlertDialog.setMessage(this.bMo.getResources().getString(a.h.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.h.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.10
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.h.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTN, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.gAz.mf(AlaLiveAudienceEndView.this.gAX);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.bMo.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.bMo.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
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
        MessageManager.getInstance().unRegisterListener(this.gBd);
        if (this.gAF != null) {
            this.gAF.cancel();
        }
        if (this.gAD != null) {
            this.gAD.cancelAnimation();
        }
        if (this.gAE != null) {
            this.gAE.cancelAnimation();
        }
        if (this.gBb != null) {
            this.gBb.cancel();
            this.gBb.removeAllUpdateListeners();
            this.gBb.removeAllListeners();
        }
    }
}
