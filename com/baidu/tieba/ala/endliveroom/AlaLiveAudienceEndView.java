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
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator fVp = new LinearInterpolator();
    private r aAh;
    private String aNZ;
    private Activity czY;
    private RelativeLayout fVA;
    private TbImageView fVB;
    private TextView fVC;
    private TextView fVD;
    private ProgressBar fVE;
    private TbImageView fVF;
    private TextView fVG;
    private TextView fVH;
    private ProgressBar fVI;
    private TextView fVJ;
    private LinearLayout fVK;
    private TextView fVL;
    private TextView fVM;
    private View fVN;
    private boolean fVO;
    private boolean fVP;
    private int fVQ;
    private ArrayList<AlaLiveInfoData> fVR;
    private ValueAnimator fVS;
    private Set<Long> fVT;
    private HttpMessageListener fVU;
    private a fVq;
    private HeadImageView fVr;
    private TextView fVs;
    private ImageView fVt;
    private LottieAnimationView fVu;
    private LottieAnimationView fVv;
    private Animation fVw;
    private LinearLayout fVx;
    private LinearLayout fVy;
    private RelativeLayout fVz;
    private String liveId;
    private ImageView mCloseBtn;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private String otherParams;
    private String roomId;

    /* loaded from: classes7.dex */
    public interface a {
        void Ll();

        void f(AlaLiveInfoData alaLiveInfoData);

        void ld(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.fVO = false;
        this.mPortrait = "";
        this.fVP = false;
        this.fVQ = 0;
        this.fVT = new HashSet();
        this.fVU = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).fVR;
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
                if (AlaLiveAudienceEndView.this.fVq != null) {
                    AlaLiveAudienceEndView.this.fVq.Ll();
                }
            }
        });
        this.fVt = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.fVu = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.fVu.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVu.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.fVv = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.fVv.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVv.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.fVr = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.fVr.setIsRound(true);
        this.fVr.setDrawBorder(true);
        this.fVr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fVr.setAutoChangeStyle(false);
        this.fVs = (TextView) this.mView.findViewById(a.g.user_name);
        this.fVM = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.fVK = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.fVJ = (TextView) this.mView.findViewById(a.g.follow_label);
        this.fVK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aAh == null || AlaLiveAudienceEndView.this.aAh.mLiveInfo == null || AlaLiveAudienceEndView.this.aAh.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.fVq != null) {
                        if (AlaLiveAudienceEndView.this.fVO) {
                            AlaLiveAudienceEndView.this.bJm();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aNZ, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.fVq.ld(AlaLiveAudienceEndView.this.fVO);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aAh.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.czY, AlaLiveAudienceEndView.this.aAh.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.fVL = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aAh != null && this.aAh.mLiveInfo != null && this.aAh.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aAh.mLiveInfo.mLiveCloseData.title)) {
                this.fVL.setText(a.i.live_over_name);
            } else {
                this.fVL.setText(this.aAh.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.fVP) {
            this.fVL.setText(a.i.live_closed);
        } else {
            this.fVL.setText(a.i.live_over_name);
        }
        this.fVu.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.fVv.setVisibility(0);
                AlaLiveAudienceEndView.this.fVu.setVisibility(8);
                AlaLiveAudienceEndView.this.fVv.playAnimation();
            }
        });
        bJj();
        MessageManager.getInstance().registerListener(this.fVU);
    }

    public void setCallback(a aVar) {
        this.fVq = aVar;
    }

    public void setData(TbPageContext tbPageContext, r rVar, boolean z, boolean z2, String str, String str2) {
        this.aAh = rVar;
        this.fVP = z;
        this.mTbPageContext = tbPageContext;
        this.czY = tbPageContext.getPageActivity();
        this.aAh = rVar;
        this.mLiveInfo = rVar.mLiveInfo;
        this.fVO = z2;
        this.mPortrait = str;
        this.fVP = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aNZ = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aNZ == null || TextUtils.equals(this.aNZ, "null")) {
            this.aNZ = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVt.setVisibility(4);
        } else {
            this.fVw = AnimationUtils.loadAnimation(this.czY, a.C0185a.anim_endview_holo_rotate);
            this.fVt.startAnimation(this.fVw);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.fVr.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.fVr.startLoad(this.mPortrait, 12, false, false);
        }
        this.fVs.setText(this.aAh.aDE.userName);
        this.fVK.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aAh != null && this.aAh.mLiveInfo != null && this.aAh.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aAh.mLiveInfo.mLiveCloseData.title)) {
            this.fVL.setText(this.aAh.mLiveInfo.mLiveCloseData.title);
        } else if (this.fVP) {
            this.fVL.setText(a.i.live_closed);
        } else {
            this.fVL.setText(a.i.live_over_name);
        }
        this.fVu.setVisibility(0);
        this.fVu.playAnimation();
        le(this.fVO);
    }

    public void le(boolean z) {
        this.fVO = z;
        if (this.aAh != null && this.aAh.mLiveInfo != null && this.aAh.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aAh.mLiveInfo.mLiveCloseData.tips)) {
                this.fVM.setText("");
            } else {
                this.fVM.setText(this.aAh.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aAh.mLiveInfo.mLiveCloseData.actionText)) {
                this.fVK.setVisibility(8);
                this.fVJ.setText("");
            } else {
                this.fVK.setVisibility(0);
                this.fVJ.setText(this.aAh.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fVK.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.fVK.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.fVK.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.fVK.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.fVK.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.fVO) {
            this.fVM.setText(a.i.endtext_followed);
            this.fVJ.setText(a.i.sdk_followed);
            this.fVJ.setTextColor(this.czY.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fVK.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.fVK.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.fVM.setText(a.i.endtext_follow);
        this.fVJ.setText(a.i.follow);
        this.fVJ.setTextColor(this.czY.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fVK.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.fVK.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVK.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fVK.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void bJj() {
        this.fVx = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.fVy = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.fVN = this.mView.findViewById(a.g.change_layout);
        this.fVB = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.fVC = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.fVD = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.fVF = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.fVG = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.fVH = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.fVz = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.fVA = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.fVE = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.fVI = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.fVx.setVisibility(i);
        this.fVy.setVisibility(i);
    }

    public void bJk() {
        d dVar = new d();
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aAh == null || (this.aAh.mLiveInfo != null && this.aAh.mLiveInfo.mLiveCloseData != null)) {
            setRecommendViewVisible(8);
        } else {
            setRecommendViewVisible(0);
            boolean z = arrayList.size() > 2;
            this.fVR = arrayList;
            this.fVQ = 0;
            a(this.fVQ, arrayList.get(this.fVQ), this.fVQ + 1, arrayList.get(this.fVQ + 1), z);
            this.fVQ++;
            if (this.fVS == null) {
                this.fVS = ValueAnimator.ofInt(100, 0);
                this.fVS.setDuration(5000L);
                this.fVS.setInterpolator(fVp);
                this.fVS.setRepeatCount(-1);
                this.fVS.setRepeatMode(1);
                this.fVS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.fVE.setProgress(intValue);
                        AlaLiveAudienceEndView.this.fVI.setProgress(intValue);
                    }
                });
                this.fVS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bJl();
                    }
                });
            }
            if (z) {
                this.fVS.start();
                this.fVN.setVisibility(0);
                this.fVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aNZ, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.fVS.cancel();
                        AlaLiveAudienceEndView.this.bJl();
                        AlaLiveAudienceEndView.this.fVS.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJl() {
        int i = this.fVQ + 1;
        this.fVQ = i;
        if (i >= this.fVR.size()) {
            this.fVQ = 0;
            i = 0;
        }
        int i2 = this.fVQ + 1;
        this.fVQ = i2;
        if (i2 >= this.fVR.size()) {
            this.fVQ = 0;
            i2 = 0;
        }
        this.fVQ = i2;
        a(i, this.fVR.get(i), i2, this.fVR.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.fVT.contains(Long.valueOf(this.fVR.get(i).live_id))) {
            this.fVT.add(Long.valueOf(this.fVR.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aNZ, this.fVR.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.fVT.contains(Long.valueOf(this.fVR.get(i2).live_id))) {
            this.fVT.add(Long.valueOf(this.fVR.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aNZ, this.fVR.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.fVz, this.fVB, this.fVC, this.fVD, this.fVE, alaLiveInfoData, z, i);
        a(this.fVA, this.fVF, this.fVG, this.fVH, this.fVI, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aNZ, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.fVR.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.czY, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.fVq != null) {
                        AlaLiveAudienceEndView.this.fVq.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.czY.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.fVx;
    }

    public HeadImageView getPortraitImg() {
        return this.fVr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJm() {
        if (this.czY != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.czY);
            bdAlertDialog.setMessage(this.czY.getResources().getString(a.i.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.i.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.10
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.i.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aNZ, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.fVq.ld(AlaLiveAudienceEndView.this.fVO);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.czY.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.czY.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
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
        MessageManager.getInstance().unRegisterListener(this.fVU);
        if (this.fVw != null) {
            this.fVw.cancel();
        }
        if (this.fVu != null) {
            this.fVu.cancelAnimation();
        }
        if (this.fVv != null) {
            this.fVv.cancelAnimation();
        }
        if (this.fVS != null) {
            this.fVS.cancel();
        }
    }
}
