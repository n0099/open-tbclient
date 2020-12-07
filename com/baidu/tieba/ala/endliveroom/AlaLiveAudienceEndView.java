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
    private static final LinearInterpolator gJv = new LinearInterpolator();
    private w aFN;
    private String aWR;
    private Activity beD;
    private LottieAnimationView gJA;
    private LottieAnimationView gJB;
    private Animation gJC;
    private LinearLayout gJD;
    private LinearLayout gJE;
    private RelativeLayout gJF;
    private RelativeLayout gJG;
    private TbImageView gJH;
    private TextView gJI;
    private TextView gJJ;
    private ProgressBar gJK;
    private TbImageView gJL;
    private TextView gJM;
    private TextView gJN;
    private ProgressBar gJO;
    private TextView gJP;
    private LinearLayout gJQ;
    private TextView gJR;
    private TextView gJS;
    private View gJT;
    private boolean gJU;
    private boolean gJV;
    private int gJW;
    private ArrayList<AlaLiveInfoData> gJX;
    private ValueAnimator gJY;
    private Set<Long> gJZ;
    private a gJw;
    private HeadImageView gJx;
    private TextView gJy;
    private ImageView gJz;
    private HttpMessageListener gKa;
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
        this.gJU = false;
        this.mPortrait = "";
        this.gJV = false;
        this.gJW = 0;
        this.gJZ = new HashSet();
        this.gKa = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).gJX;
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
                if (AlaLiveAudienceEndView.this.gJw != null) {
                    AlaLiveAudienceEndView.this.gJw.Pv();
                }
            }
        });
        this.gJz = (ImageView) this.mView.findViewById(a.f.headHalo_imageView);
        this.gJA = (LottieAnimationView) this.mView.findViewById(a.f.flowerAppear_lottieAnimationView);
        this.gJA.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gJA.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.gJB = (LottieAnimationView) this.mView.findViewById(a.f.flowerDrop_lottieAnimationView);
        this.gJB.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gJB.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.gJx = (HeadImageView) this.mView.findViewById(a.f.avatar_img);
        this.gJx.setIsRound(true);
        this.gJx.setDrawBorder(true);
        this.gJx.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gJx.setAutoChangeStyle(false);
        this.gJy = (TextView) this.mView.findViewById(a.f.user_name);
        this.gJS = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.gJQ = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gJP = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gJQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aFN == null || AlaLiveAudienceEndView.this.aFN.mLiveInfo == null || AlaLiveAudienceEndView.this.aFN.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.gJw != null) {
                        if (AlaLiveAudienceEndView.this.gJU) {
                            AlaLiveAudienceEndView.this.bVo();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWR, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gJw.mA(AlaLiveAudienceEndView.this.gJU);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aFN.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.beD, AlaLiveAudienceEndView.this.aFN.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.gJR = (TextView) this.mView.findViewById(a.f.live_over_name);
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.title)) {
                this.gJR.setText(a.h.live_over_name);
            } else {
                this.gJR.setText(this.aFN.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gJV) {
            this.gJR.setText(a.h.live_closed);
        } else {
            this.gJR.setText(a.h.live_over_name);
        }
        this.gJA.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.gJB.setVisibility(0);
                AlaLiveAudienceEndView.this.gJA.setVisibility(8);
                AlaLiveAudienceEndView.this.gJB.playAnimation();
            }
        });
        bVl();
        MessageManager.getInstance().registerListener(this.gKa);
    }

    public void setCallback(a aVar) {
        this.gJw = aVar;
    }

    public void setData(TbPageContext tbPageContext, w wVar, boolean z, boolean z2, String str, String str2) {
        this.aFN = wVar;
        this.gJV = z;
        this.mTbPageContext = tbPageContext;
        this.beD = tbPageContext.getPageActivity();
        this.aFN = wVar;
        this.mLiveInfo = wVar.mLiveInfo;
        this.gJU = z2;
        this.mPortrait = str;
        this.gJV = z;
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
            this.gJz.setVisibility(4);
        } else {
            this.gJC = AnimationUtils.loadAnimation(this.beD, a.C0205a.anim_endview_holo_rotate);
            this.gJz.startAnimation(this.gJC);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.gJx.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.gJx.startLoad(this.mPortrait, 12, false, false);
        }
        this.gJy.setText(this.aFN.aJV.userName);
        this.gJQ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.title)) {
            this.gJR.setText(this.aFN.mLiveInfo.mLiveCloseData.title);
        } else if (this.gJV) {
            this.gJR.setText(a.h.live_closed);
        } else {
            this.gJR.setText(a.h.live_over_name);
        }
        this.gJA.setVisibility(0);
        this.gJA.playAnimation();
        mB(this.gJU);
    }

    public void mB(boolean z) {
        this.gJU = z;
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.tips)) {
                this.gJS.setText("");
            } else {
                this.gJS.setText(this.aFN.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.actionText)) {
                this.gJQ.setVisibility(8);
                this.gJP.setText("");
            } else {
                this.gJQ.setVisibility(0);
                this.gJP.setText(this.aFN.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gJQ.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    this.gJQ.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gJQ.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_24_selector_bd);
                } else {
                    this.gJQ.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gJQ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gJU) {
            this.gJS.setText(a.h.endtext_followed);
            this.gJP.setText(a.h.sdk_followed);
            this.gJP.setTextColor(this.beD.getResources().getColor(a.c.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gJQ.setBackgroundResource(a.e.sdk_round_btn_gray_border_bg_radius_24_bd);
                return;
            } else {
                this.gJQ.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_c);
                return;
            }
        }
        this.gJS.setText(a.h.endtext_follow);
        this.gJP.setText(a.h.follow);
        this.gJP.setTextColor(this.beD.getResources().getColor(a.c.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gJQ.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            this.gJQ.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gJQ.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_24_selector_bd);
        } else {
            this.gJQ.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
        }
    }

    private void bVl() {
        this.gJD = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gJE = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gJT = this.mView.findViewById(a.f.change_layout);
        this.gJH = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gJI = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gJJ = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.gJL = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gJM = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gJN = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.gJF = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gJG = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gJK = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gJO = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gJD.setVisibility(i);
        this.gJE.setVisibility(i);
    }

    public void bVm() {
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
            this.gJX = arrayList;
            this.gJW = 0;
            a(this.gJW, arrayList.get(this.gJW), this.gJW + 1, arrayList.get(this.gJW + 1), z);
            this.gJW++;
            if (this.gJY == null) {
                this.gJY = ValueAnimator.ofInt(100, 0);
                this.gJY.setDuration(5000L);
                this.gJY.setInterpolator(gJv);
                this.gJY.setRepeatCount(-1);
                this.gJY.setRepeatMode(1);
                this.gJY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.gJK.setProgress(intValue);
                        AlaLiveAudienceEndView.this.gJO.setProgress(intValue);
                    }
                });
                this.gJY.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bVn();
                    }
                });
            }
            if (z) {
                this.gJY.start();
                this.gJT.setVisibility(0);
                this.gJT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWR, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gJY.cancel();
                        AlaLiveAudienceEndView.this.bVn();
                        AlaLiveAudienceEndView.this.gJY.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVn() {
        int i = this.gJW + 1;
        this.gJW = i;
        if (i >= this.gJX.size()) {
            this.gJW = 0;
            i = 0;
        }
        int i2 = this.gJW + 1;
        this.gJW = i2;
        if (i2 >= this.gJX.size()) {
            this.gJW = 0;
            i2 = 0;
        }
        this.gJW = i2;
        a(i, this.gJX.get(i), i2, this.gJX.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.gJZ.contains(Long.valueOf(this.gJX.get(i).live_id))) {
            this.gJZ.add(Long.valueOf(this.gJX.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aWR, this.gJX.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.gJZ.contains(Long.valueOf(this.gJX.get(i2).live_id))) {
            this.gJZ.add(Long.valueOf(this.gJX.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aWR, this.gJX.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.gJF, this.gJH, this.gJI, this.gJJ, this.gJK, alaLiveInfoData, z, i);
        a(this.gJG, this.gJL, this.gJM, this.gJN, this.gJO, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWR, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.gJX.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.beD, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.gJw != null) {
                        AlaLiveAudienceEndView.this.gJw.f(alaLiveInfoData);
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
        return this.gJD;
    }

    public HeadImageView getPortraitImg() {
        return this.gJx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVo() {
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
                    AlaLiveAudienceEndView.this.gJw.mA(AlaLiveAudienceEndView.this.gJU);
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
        MessageManager.getInstance().unRegisterListener(this.gKa);
        if (this.gJC != null) {
            this.gJC.cancel();
        }
        if (this.gJA != null) {
            this.gJA.cancelAnimation();
        }
        if (this.gJB != null) {
            this.gJB.cancelAnimation();
        }
        if (this.gJY != null) {
            this.gJY.cancel();
            this.gJY.removeAllUpdateListeners();
            this.gJY.removeAllListeners();
        }
    }
}
