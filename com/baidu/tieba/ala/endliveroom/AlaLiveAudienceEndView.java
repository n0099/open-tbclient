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
    private static final LinearInterpolator fVt = new LinearInterpolator();
    private r aAj;
    private String aOb;
    private Activity cAc;
    private Animation fVA;
    private LinearLayout fVB;
    private LinearLayout fVC;
    private RelativeLayout fVD;
    private RelativeLayout fVE;
    private TbImageView fVF;
    private TextView fVG;
    private TextView fVH;
    private ProgressBar fVI;
    private TbImageView fVJ;
    private TextView fVK;
    private TextView fVL;
    private ProgressBar fVM;
    private TextView fVN;
    private LinearLayout fVO;
    private TextView fVP;
    private TextView fVQ;
    private View fVR;
    private boolean fVS;
    private boolean fVT;
    private int fVU;
    private ArrayList<AlaLiveInfoData> fVV;
    private ValueAnimator fVW;
    private Set<Long> fVX;
    private HttpMessageListener fVY;
    private a fVu;
    private HeadImageView fVv;
    private TextView fVw;
    private ImageView fVx;
    private LottieAnimationView fVy;
    private LottieAnimationView fVz;
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

        void lf(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.fVS = false;
        this.mPortrait = "";
        this.fVT = false;
        this.fVU = 0;
        this.fVX = new HashSet();
        this.fVY = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).fVV;
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
                if (AlaLiveAudienceEndView.this.fVu != null) {
                    AlaLiveAudienceEndView.this.fVu.Ll();
                }
            }
        });
        this.fVx = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.fVy = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.fVy.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVy.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.fVz = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.fVz.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVz.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.fVv = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.fVv.setIsRound(true);
        this.fVv.setDrawBorder(true);
        this.fVv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fVv.setAutoChangeStyle(false);
        this.fVw = (TextView) this.mView.findViewById(a.g.user_name);
        this.fVQ = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.fVO = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.fVN = (TextView) this.mView.findViewById(a.g.follow_label);
        this.fVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aAj == null || AlaLiveAudienceEndView.this.aAj.mLiveInfo == null || AlaLiveAudienceEndView.this.aAj.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.fVu != null) {
                        if (AlaLiveAudienceEndView.this.fVS) {
                            AlaLiveAudienceEndView.this.bJn();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aOb, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.fVu.lf(AlaLiveAudienceEndView.this.fVS);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aAj.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.cAc, AlaLiveAudienceEndView.this.aAj.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.fVP = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aAj != null && this.aAj.mLiveInfo != null && this.aAj.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aAj.mLiveInfo.mLiveCloseData.title)) {
                this.fVP.setText(a.i.live_over_name);
            } else {
                this.fVP.setText(this.aAj.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.fVT) {
            this.fVP.setText(a.i.live_closed);
        } else {
            this.fVP.setText(a.i.live_over_name);
        }
        this.fVy.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.fVz.setVisibility(0);
                AlaLiveAudienceEndView.this.fVy.setVisibility(8);
                AlaLiveAudienceEndView.this.fVz.playAnimation();
            }
        });
        bJk();
        MessageManager.getInstance().registerListener(this.fVY);
    }

    public void setCallback(a aVar) {
        this.fVu = aVar;
    }

    public void setData(TbPageContext tbPageContext, r rVar, boolean z, boolean z2, String str, String str2) {
        this.aAj = rVar;
        this.fVT = z;
        this.mTbPageContext = tbPageContext;
        this.cAc = tbPageContext.getPageActivity();
        this.aAj = rVar;
        this.mLiveInfo = rVar.mLiveInfo;
        this.fVS = z2;
        this.mPortrait = str;
        this.fVT = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aOb = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aOb == null || TextUtils.equals(this.aOb, "null")) {
            this.aOb = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVx.setVisibility(4);
        } else {
            this.fVA = AnimationUtils.loadAnimation(this.cAc, a.C0185a.anim_endview_holo_rotate);
            this.fVx.startAnimation(this.fVA);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.fVv.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.fVv.startLoad(this.mPortrait, 12, false, false);
        }
        this.fVw.setText(this.aAj.aDG.userName);
        this.fVO.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aAj != null && this.aAj.mLiveInfo != null && this.aAj.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aAj.mLiveInfo.mLiveCloseData.title)) {
            this.fVP.setText(this.aAj.mLiveInfo.mLiveCloseData.title);
        } else if (this.fVT) {
            this.fVP.setText(a.i.live_closed);
        } else {
            this.fVP.setText(a.i.live_over_name);
        }
        this.fVy.setVisibility(0);
        this.fVy.playAnimation();
        lg(this.fVS);
    }

    public void lg(boolean z) {
        this.fVS = z;
        if (this.aAj != null && this.aAj.mLiveInfo != null && this.aAj.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aAj.mLiveInfo.mLiveCloseData.tips)) {
                this.fVQ.setText("");
            } else {
                this.fVQ.setText(this.aAj.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aAj.mLiveInfo.mLiveCloseData.actionText)) {
                this.fVO.setVisibility(8);
                this.fVN.setText("");
            } else {
                this.fVO.setVisibility(0);
                this.fVN.setText(this.aAj.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fVO.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    this.fVO.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.fVO.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
                } else {
                    this.fVO.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.fVO.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.fVS) {
            this.fVQ.setText(a.i.endtext_followed);
            this.fVN.setText(a.i.sdk_followed);
            this.fVN.setTextColor(this.cAc.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fVO.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
                return;
            } else {
                this.fVO.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
                return;
            }
        }
        this.fVQ.setText(a.i.endtext_follow);
        this.fVN.setText(a.i.follow);
        this.fVN.setTextColor(this.cAc.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fVO.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            this.fVO.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fVO.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            this.fVO.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
        }
    }

    private void bJk() {
        this.fVB = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.fVC = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.fVR = this.mView.findViewById(a.g.change_layout);
        this.fVF = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.fVG = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.fVH = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.fVJ = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.fVK = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.fVL = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.fVD = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.fVE = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.fVI = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.fVM = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.fVB.setVisibility(i);
        this.fVC.setVisibility(i);
    }

    public void bJl() {
        d dVar = new d();
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aAj == null || (this.aAj.mLiveInfo != null && this.aAj.mLiveInfo.mLiveCloseData != null)) {
            setRecommendViewVisible(8);
        } else {
            setRecommendViewVisible(0);
            boolean z = arrayList.size() > 2;
            this.fVV = arrayList;
            this.fVU = 0;
            a(this.fVU, arrayList.get(this.fVU), this.fVU + 1, arrayList.get(this.fVU + 1), z);
            this.fVU++;
            if (this.fVW == null) {
                this.fVW = ValueAnimator.ofInt(100, 0);
                this.fVW.setDuration(5000L);
                this.fVW.setInterpolator(fVt);
                this.fVW.setRepeatCount(-1);
                this.fVW.setRepeatMode(1);
                this.fVW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.fVI.setProgress(intValue);
                        AlaLiveAudienceEndView.this.fVM.setProgress(intValue);
                    }
                });
                this.fVW.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bJm();
                    }
                });
            }
            if (z) {
                this.fVW.start();
                this.fVR.setVisibility(0);
                this.fVR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aOb, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.fVW.cancel();
                        AlaLiveAudienceEndView.this.bJm();
                        AlaLiveAudienceEndView.this.fVW.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJm() {
        int i = this.fVU + 1;
        this.fVU = i;
        if (i >= this.fVV.size()) {
            this.fVU = 0;
            i = 0;
        }
        int i2 = this.fVU + 1;
        this.fVU = i2;
        if (i2 >= this.fVV.size()) {
            this.fVU = 0;
            i2 = 0;
        }
        this.fVU = i2;
        a(i, this.fVV.get(i), i2, this.fVV.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.fVX.contains(Long.valueOf(this.fVV.get(i).live_id))) {
            this.fVX.add(Long.valueOf(this.fVV.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aOb, this.fVV.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.fVX.contains(Long.valueOf(this.fVV.get(i2).live_id))) {
            this.fVX.add(Long.valueOf(this.fVV.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aOb, this.fVV.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.fVD, this.fVF, this.fVG, this.fVH, this.fVI, alaLiveInfoData, z, i);
        a(this.fVE, this.fVJ, this.fVK, this.fVL, this.fVM, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aOb, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.fVV.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.cAc, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.fVu != null) {
                        AlaLiveAudienceEndView.this.fVu.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.cAc.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.fVB;
    }

    public HeadImageView getPortraitImg() {
        return this.fVv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJn() {
        if (this.cAc != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.cAc);
            bdAlertDialog.setMessage(this.cAc.getResources().getString(a.i.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.i.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.10
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.i.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aOb, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.fVu.lf(AlaLiveAudienceEndView.this.fVS);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.cAc.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.cAc.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
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
        MessageManager.getInstance().unRegisterListener(this.fVY);
        if (this.fVA != null) {
            this.fVA.cancel();
        }
        if (this.fVy != null) {
            this.fVy.cancelAnimation();
        }
        if (this.fVz != null) {
            this.fVz.cancelAnimation();
        }
        if (this.fVW != null) {
            this.fVW.cancel();
        }
    }
}
