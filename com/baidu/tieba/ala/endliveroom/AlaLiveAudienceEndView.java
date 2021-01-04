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
/* loaded from: classes11.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator gVk = new LinearInterpolator();
    private x aGe;
    private String aYx;
    private ValueAnimator animator;
    private TbImageView gVA;
    private TextView gVB;
    private TextView gVC;
    private ProgressBar gVD;
    private TextView gVE;
    private LinearLayout gVF;
    private TextView gVG;
    private TextView gVH;
    private View gVI;
    private boolean gVJ;
    private boolean gVK;
    private int gVL;
    private ArrayList<AlaLiveInfoData> gVM;
    private Set<Long> gVN;
    private HttpMessageListener gVO;
    private a gVl;
    private HeadImageView gVm;
    private TextView gVn;
    private ImageView gVo;
    private LottieAnimationView gVp;
    private LottieAnimationView gVq;
    private Animation gVr;
    private LinearLayout gVs;
    private LinearLayout gVt;
    private RelativeLayout gVu;
    private RelativeLayout gVv;
    private TbImageView gVw;
    private TextView gVx;
    private TextView gVy;
    private ProgressBar gVz;
    private String liveId;
    private ImageView mCloseBtn;
    private Activity mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private String otherParams;
    private String roomId;

    /* loaded from: classes11.dex */
    public interface a {
        void Pj();

        void f(AlaLiveInfoData alaLiveInfoData);

        void na(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gVJ = false;
        this.mPortrait = "";
        this.gVK = false;
        this.gVL = 0;
        this.gVN = new HashSet();
        this.gVO = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).gVM;
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
                if (AlaLiveAudienceEndView.this.gVl != null) {
                    AlaLiveAudienceEndView.this.gVl.Pj();
                }
            }
        });
        this.gVo = (ImageView) this.mView.findViewById(a.f.headHalo_imageView);
        this.gVp = (LottieAnimationView) this.mView.findViewById(a.f.flowerAppear_lottieAnimationView);
        this.gVp.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gVp.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.gVq = (LottieAnimationView) this.mView.findViewById(a.f.flowerDrop_lottieAnimationView);
        this.gVq.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gVq.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.gVm = (HeadImageView) this.mView.findViewById(a.f.avatar_img);
        this.gVm.setIsRound(true);
        this.gVm.setDrawBorder(true);
        this.gVm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gVm.setAutoChangeStyle(false);
        this.gVn = (TextView) this.mView.findViewById(a.f.user_name);
        this.gVH = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.gVF = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gVE = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gVF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aGe == null || AlaLiveAudienceEndView.this.aGe.mLiveInfo == null || AlaLiveAudienceEndView.this.aGe.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.gVl != null) {
                        if (AlaLiveAudienceEndView.this.gVJ) {
                            AlaLiveAudienceEndView.this.bXU();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYx, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gVl.na(AlaLiveAudienceEndView.this.gVJ);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aGe.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.aGe.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.gVG = (TextView) this.mView.findViewById(a.f.live_over_name);
        if (this.aGe != null && this.aGe.mLiveInfo != null && this.aGe.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aGe.mLiveInfo.mLiveCloseData.title)) {
                this.gVG.setText(a.h.live_over_name);
            } else {
                this.gVG.setText(this.aGe.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gVK) {
            this.gVG.setText(a.h.live_closed);
        } else {
            this.gVG.setText(a.h.live_over_name);
        }
        this.gVp.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.gVq.setVisibility(0);
                AlaLiveAudienceEndView.this.gVp.setVisibility(8);
                AlaLiveAudienceEndView.this.gVq.playAnimation();
            }
        });
        bXR();
        MessageManager.getInstance().registerListener(this.gVO);
    }

    public void setCallback(a aVar) {
        this.gVl = aVar;
    }

    public void setData(TbPageContext tbPageContext, x xVar, boolean z, boolean z2, String str, String str2) {
        this.aGe = xVar;
        this.gVK = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aGe = xVar;
        this.mLiveInfo = xVar.mLiveInfo;
        this.gVJ = z2;
        this.mPortrait = str;
        this.gVK = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aYx = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aYx == null || TextUtils.equals(this.aYx, "null")) {
            this.aYx = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gVo.setVisibility(4);
        } else {
            this.gVr = AnimationUtils.loadAnimation(this.mContext, a.C0203a.anim_endview_holo_rotate);
            this.gVo.startAnimation(this.gVr);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.gVm.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.gVm.startLoad(this.mPortrait, 12, false, false);
        }
        this.gVn.setText(this.aGe.aKu.userName);
        this.gVF.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aGe != null && this.aGe.mLiveInfo != null && this.aGe.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aGe.mLiveInfo.mLiveCloseData.title)) {
            this.gVG.setText(this.aGe.mLiveInfo.mLiveCloseData.title);
        } else if (this.gVK) {
            this.gVG.setText(a.h.live_closed);
        } else {
            this.gVG.setText(a.h.live_over_name);
        }
        this.gVp.setVisibility(0);
        this.gVp.playAnimation();
        nb(this.gVJ);
    }

    public void nb(boolean z) {
        this.gVJ = z;
        if (this.aGe != null && this.aGe.mLiveInfo != null && this.aGe.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aGe.mLiveInfo.mLiveCloseData.tips)) {
                this.gVH.setText("");
            } else {
                this.gVH.setText(this.aGe.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aGe.mLiveInfo.mLiveCloseData.actionText)) {
                this.gVF.setVisibility(8);
                this.gVE.setText("");
            } else {
                this.gVF.setVisibility(0);
                this.gVE.setText(this.aGe.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gVF.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    this.gVF.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gVF.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_24_selector_bd);
                } else {
                    this.gVF.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gVF.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gVJ) {
            this.gVH.setText(a.h.endtext_followed);
            this.gVE.setText(a.h.sdk_followed);
            this.gVE.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gVF.setBackgroundResource(a.e.sdk_round_btn_gray_border_bg_radius_24_bd);
                return;
            } else {
                this.gVF.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_c);
                return;
            }
        }
        this.gVH.setText(a.h.endtext_follow);
        this.gVE.setText(a.h.follow);
        this.gVE.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gVF.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            this.gVF.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gVF.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_24_selector_bd);
        } else {
            this.gVF.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
        }
    }

    private void bXR() {
        this.gVs = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gVt = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gVI = this.mView.findViewById(a.f.change_layout);
        this.gVw = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gVx = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gVy = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.gVA = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gVB = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gVC = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.gVu = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gVv = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gVz = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gVD = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gVs.setVisibility(i);
        this.gVt.setVisibility(i);
    }

    public void bXS() {
        d dVar = new d();
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aGe == null || (this.aGe.mLiveInfo != null && this.aGe.mLiveInfo.mLiveCloseData != null)) {
            setRecommendViewVisible(8);
        } else {
            setRecommendViewVisible(0);
            boolean z = arrayList.size() > 2;
            this.gVM = arrayList;
            this.gVL = 0;
            a(this.gVL, arrayList.get(this.gVL), this.gVL + 1, arrayList.get(this.gVL + 1), z);
            this.gVL++;
            if (this.animator == null) {
                this.animator = ValueAnimator.ofInt(100, 0);
                this.animator.setDuration(5000L);
                this.animator.setInterpolator(gVk);
                this.animator.setRepeatCount(-1);
                this.animator.setRepeatMode(1);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.gVz.setProgress(intValue);
                        AlaLiveAudienceEndView.this.gVD.setProgress(intValue);
                    }
                });
                this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bXT();
                    }
                });
            }
            if (z) {
                this.animator.start();
                this.gVI.setVisibility(0);
                this.gVI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYx, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.animator.cancel();
                        AlaLiveAudienceEndView.this.bXT();
                        AlaLiveAudienceEndView.this.animator.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXT() {
        int i = this.gVL + 1;
        this.gVL = i;
        if (i >= this.gVM.size()) {
            this.gVL = 0;
            i = 0;
        }
        int i2 = this.gVL + 1;
        this.gVL = i2;
        if (i2 >= this.gVM.size()) {
            this.gVL = 0;
            i2 = 0;
        }
        this.gVL = i2;
        a(i, this.gVM.get(i), i2, this.gVM.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.gVN.contains(Long.valueOf(this.gVM.get(i).live_id))) {
            this.gVN.add(Long.valueOf(this.gVM.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aYx, this.gVM.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.gVN.contains(Long.valueOf(this.gVM.get(i2).live_id))) {
            this.gVN.add(Long.valueOf(this.gVM.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aYx, this.gVM.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.gVu, this.gVw, this.gVx, this.gVy, this.gVz, alaLiveInfoData, z, i);
        a(this.gVv, this.gVA, this.gVB, this.gVC, this.gVD, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYx, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.gVM.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.mContext, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.gVl != null) {
                        AlaLiveAudienceEndView.this.gVl.f(alaLiveInfoData);
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
        return this.gVs;
    }

    public HeadImageView getPortraitImg() {
        return this.gVm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXU() {
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
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYx, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.gVl.na(AlaLiveAudienceEndView.this.gVJ);
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
        MessageManager.getInstance().unRegisterListener(this.gVO);
        if (this.gVr != null) {
            this.gVr.cancel();
        }
        if (this.gVp != null) {
            this.gVp.cancelAnimation();
        }
        if (this.gVq != null) {
            this.gVq.cancelAnimation();
        }
        if (this.animator != null) {
            this.animator.cancel();
            this.animator.removeAllUpdateListeners();
            this.animator.removeAllListeners();
        }
    }
}
