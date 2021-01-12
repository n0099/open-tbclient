package com.baidu.tieba.ala.endliveroom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
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
import androidx.annotation.NonNull;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.x;
import com.baidu.live.lottie.LottieAnimationView;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator gQE = new LinearInterpolator();
    private x aBr;
    private String aTK;
    private ValueAnimator animator;
    private a gQF;
    private HeadImageView gQG;
    private TextView gQH;
    private ImageView gQI;
    private LottieAnimationView gQJ;
    private LottieAnimationView gQK;
    private Animation gQL;
    private LinearLayout gQM;
    private LinearLayout gQN;
    private RelativeLayout gQO;
    private RelativeLayout gQP;
    private TbImageView gQQ;
    private TextView gQR;
    private TextView gQS;
    private ProgressBar gQT;
    private TbImageView gQU;
    private TextView gQV;
    private TextView gQW;
    private ProgressBar gQX;
    private TextView gQY;
    private LinearLayout gQZ;
    private TextView gRa;
    private TextView gRb;
    private View gRc;
    private boolean gRd;
    private boolean gRe;
    private int gRf;
    private ArrayList<AlaLiveInfoData> gRg;
    private Set<Long> gRh;
    private HttpMessageListener gRi;
    private String liveId;
    private ImageView mCloseBtn;
    private Activity mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private String otherParams;
    private String roomId;

    /* loaded from: classes10.dex */
    public interface a {
        void Lo();

        void f(AlaLiveInfoData alaLiveInfoData);

        void mW(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gRd = false;
        this.mPortrait = "";
        this.gRe = false;
        this.gRf = 0;
        this.gRh = new HashSet();
        this.gRi = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).gRg;
                }
                AlaLiveAudienceEndView.this.Y(arrayList);
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
                if (AlaLiveAudienceEndView.this.gQF != null) {
                    AlaLiveAudienceEndView.this.gQF.Lo();
                }
            }
        });
        this.gQI = (ImageView) this.mView.findViewById(a.f.headHalo_imageView);
        this.gQJ = (LottieAnimationView) this.mView.findViewById(a.f.flowerAppear_lottieAnimationView);
        this.gQJ.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gQJ.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.gQK = (LottieAnimationView) this.mView.findViewById(a.f.flowerDrop_lottieAnimationView);
        this.gQK.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gQK.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.gQG = (HeadImageView) this.mView.findViewById(a.f.avatar_img);
        this.gQG.setIsRound(true);
        this.gQG.setDrawBorder(true);
        this.gQG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gQG.setAutoChangeStyle(false);
        this.gQH = (TextView) this.mView.findViewById(a.f.user_name);
        this.gRb = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.gQZ = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gQY = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gQZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aBr == null || AlaLiveAudienceEndView.this.aBr.mLiveInfo == null || AlaLiveAudienceEndView.this.aBr.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.gQF != null) {
                        if (AlaLiveAudienceEndView.this.gRd) {
                            AlaLiveAudienceEndView.this.bUd();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTK, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gQF.mW(AlaLiveAudienceEndView.this.gRd);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aBr.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.aBr.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.gRa = (TextView) this.mView.findViewById(a.f.live_over_name);
        if (this.aBr != null && this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aBr.mLiveInfo.mLiveCloseData.title)) {
                this.gRa.setText(a.h.live_over_name);
            } else {
                this.gRa.setText(this.aBr.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gRe) {
            this.gRa.setText(a.h.live_closed);
        } else {
            this.gRa.setText(a.h.live_over_name);
        }
        this.gQJ.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.gQK.setVisibility(0);
                AlaLiveAudienceEndView.this.gQJ.setVisibility(8);
                AlaLiveAudienceEndView.this.gQK.playAnimation();
            }
        });
        bUa();
        MessageManager.getInstance().registerListener(this.gRi);
    }

    public void setCallback(a aVar) {
        this.gQF = aVar;
    }

    public void setData(TbPageContext tbPageContext, x xVar, boolean z, boolean z2, String str, String str2) {
        this.aBr = xVar;
        this.gRe = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aBr = xVar;
        this.mLiveInfo = xVar.mLiveInfo;
        this.gRd = z2;
        this.mPortrait = str;
        this.gRe = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aTK = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aTK == null || TextUtils.equals(this.aTK, "null")) {
            this.aTK = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gQI.setVisibility(4);
        } else {
            this.gQL = AnimationUtils.loadAnimation(this.mContext, a.C0194a.anim_endview_holo_rotate);
            this.gQI.startAnimation(this.gQL);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.gQG.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.gQG.startLoad(this.mPortrait, 12, false, false);
        }
        this.gQH.setText(this.aBr.aFH.userName);
        this.gQZ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aBr != null && this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aBr.mLiveInfo.mLiveCloseData.title)) {
            this.gRa.setText(this.aBr.mLiveInfo.mLiveCloseData.title);
        } else if (this.gRe) {
            this.gRa.setText(a.h.live_closed);
        } else {
            this.gRa.setText(a.h.live_over_name);
        }
        this.gQJ.setVisibility(0);
        this.gQJ.playAnimation();
        mX(this.gRd);
    }

    public void mX(boolean z) {
        this.gRd = z;
        if (this.aBr != null && this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aBr.mLiveInfo.mLiveCloseData.tips)) {
                this.gRb.setText("");
            } else {
                this.gRb.setText(this.aBr.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aBr.mLiveInfo.mLiveCloseData.actionText)) {
                this.gQZ.setVisibility(8);
                this.gQY.setText("");
            } else {
                this.gQZ.setVisibility(0);
                this.gQY.setText(this.aBr.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gQZ.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    this.gQZ.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gQZ.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_24_selector_bd);
                } else {
                    this.gQZ.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gQZ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gRd) {
            this.gRb.setText(a.h.endtext_followed);
            this.gQY.setText(a.h.sdk_followed);
            this.gQY.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gQZ.setBackgroundResource(a.e.sdk_round_btn_gray_border_bg_radius_24_bd);
                return;
            } else {
                this.gQZ.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_c);
                return;
            }
        }
        this.gRb.setText(a.h.endtext_follow);
        this.gQY.setText(a.h.follow);
        this.gQY.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gQZ.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            this.gQZ.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gQZ.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_24_selector_bd);
        } else {
            this.gQZ.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
        }
    }

    private void bUa() {
        this.gQM = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gQN = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gRc = this.mView.findViewById(a.f.change_layout);
        this.gQQ = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gQR = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gQS = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.gQU = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gQV = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gQW = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.gQO = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gQP = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gQT = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gQX = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gQM.setVisibility(i);
        this.gQN.setVisibility(i);
    }

    public void bUb() {
        d dVar = new d();
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aBr == null || (this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.mLiveCloseData != null)) {
            setRecommendViewVisible(8);
        } else {
            setRecommendViewVisible(0);
            boolean z = arrayList.size() > 2;
            this.gRg = arrayList;
            this.gRf = 0;
            a(this.gRf, arrayList.get(this.gRf), this.gRf + 1, arrayList.get(this.gRf + 1), z);
            this.gRf++;
            if (this.animator == null) {
                this.animator = ValueAnimator.ofInt(100, 0);
                this.animator.setDuration(5000L);
                this.animator.setInterpolator(gQE);
                this.animator.setRepeatCount(-1);
                this.animator.setRepeatMode(1);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.gQT.setProgress(intValue);
                        AlaLiveAudienceEndView.this.gQX.setProgress(intValue);
                    }
                });
                this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bUc();
                    }
                });
            }
            if (z) {
                this.animator.start();
                this.gRc.setVisibility(0);
                this.gRc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTK, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.animator.cancel();
                        AlaLiveAudienceEndView.this.bUc();
                        AlaLiveAudienceEndView.this.animator.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUc() {
        int i = this.gRf + 1;
        this.gRf = i;
        if (i >= this.gRg.size()) {
            this.gRf = 0;
            i = 0;
        }
        int i2 = this.gRf + 1;
        this.gRf = i2;
        if (i2 >= this.gRg.size()) {
            this.gRf = 0;
            i2 = 0;
        }
        this.gRf = i2;
        a(i, this.gRg.get(i), i2, this.gRg.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.gRh.contains(Long.valueOf(this.gRg.get(i).live_id))) {
            this.gRh.add(Long.valueOf(this.gRg.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aTK, this.gRg.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.gRh.contains(Long.valueOf(this.gRg.get(i2).live_id))) {
            this.gRh.add(Long.valueOf(this.gRg.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aTK, this.gRg.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.gQO, this.gQQ, this.gQR, this.gQS, this.gQT, alaLiveInfoData, z, i);
        a(this.gQP, this.gQU, this.gQV, this.gQW, this.gQX, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTK, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.gRg.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.mContext, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.gQF != null) {
                        AlaLiveAudienceEndView.this.gQF.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.mContext.getString(a.h.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.gQM;
    }

    public HeadImageView getPortraitImg() {
        return this.gQG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUd() {
        if (this.mContext != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mContext);
            bdAlertDialog.setMessage(this.mContext.getResources().getString(a.h.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.h.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.10
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.h.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTK, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.gQF.mW(AlaLiveAudienceEndView.this.gRd);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
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
        MessageManager.getInstance().unRegisterListener(this.gRi);
        if (this.gQL != null) {
            this.gQL.cancel();
        }
        if (this.gQJ != null) {
            this.gQJ.cancelAnimation();
        }
        if (this.gQK != null) {
            this.gQK.cancelAnimation();
        }
        if (this.animator != null) {
            this.animator.cancel();
            this.animator.removeAllUpdateListeners();
            this.animator.removeAllListeners();
        }
    }
}
