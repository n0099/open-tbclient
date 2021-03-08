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
import com.baidu.live.data.ab;
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
    private static final LinearInterpolator gVl = new LinearInterpolator();
    private ab aED;
    private String aYp;
    private ValueAnimator animator;
    private ProgressBar gVA;
    private TbImageView gVB;
    private TextView gVC;
    private TextView gVD;
    private ProgressBar gVE;
    private TextView gVF;
    private LinearLayout gVG;
    private TextView gVH;
    private TextView gVI;
    private View gVJ;
    private boolean gVK;
    private boolean gVL;
    private int gVM;
    private ArrayList<AlaLiveInfoData> gVN;
    private Set<Long> gVO;
    private HttpMessageListener gVP;
    private a gVm;
    private HeadImageView gVn;
    private TextView gVo;
    private ImageView gVp;
    private LottieAnimationView gVq;
    private LottieAnimationView gVr;
    private Animation gVs;
    private LinearLayout gVt;
    private LinearLayout gVu;
    private RelativeLayout gVv;
    private RelativeLayout gVw;
    private TbImageView gVx;
    private TextView gVy;
    private TextView gVz;
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
        void MP();

        void f(AlaLiveInfoData alaLiveInfoData);

        void nb(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gVK = false;
        this.mPortrait = "";
        this.gVL = false;
        this.gVM = 0;
        this.gVO = new HashSet();
        this.gVP = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).gVN;
                }
                AlaLiveAudienceEndView.this.X(arrayList);
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
                if (AlaLiveAudienceEndView.this.gVm != null) {
                    AlaLiveAudienceEndView.this.gVm.MP();
                }
            }
        });
        this.gVp = (ImageView) this.mView.findViewById(a.f.headHalo_imageView);
        this.gVq = (LottieAnimationView) this.mView.findViewById(a.f.flowerAppear_lottieAnimationView);
        this.gVq.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gVq.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.gVr = (LottieAnimationView) this.mView.findViewById(a.f.flowerDrop_lottieAnimationView);
        this.gVr.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gVr.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.gVn = (HeadImageView) this.mView.findViewById(a.f.avatar_img);
        this.gVn.setIsRound(true);
        this.gVn.setDrawBorder(true);
        this.gVn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gVn.setAutoChangeStyle(false);
        this.gVo = (TextView) this.mView.findViewById(a.f.user_name);
        this.gVI = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.gVG = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gVF = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aED == null || AlaLiveAudienceEndView.this.aED.mLiveInfo == null || AlaLiveAudienceEndView.this.aED.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.gVm != null) {
                        if (AlaLiveAudienceEndView.this.gVK) {
                            AlaLiveAudienceEndView.this.bUV();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYp, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gVm.nb(AlaLiveAudienceEndView.this.gVK);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aED.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.aED.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.gVH = (TextView) this.mView.findViewById(a.f.live_over_name);
        if (this.aED != null && this.aED.mLiveInfo != null && this.aED.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aED.mLiveInfo.mLiveCloseData.title)) {
                this.gVH.setText(a.h.live_over_name);
            } else {
                this.gVH.setText(this.aED.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gVL) {
            this.gVH.setText(a.h.live_closed);
        } else {
            this.gVH.setText(a.h.live_over_name);
        }
        this.gVq.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.gVr.setVisibility(0);
                AlaLiveAudienceEndView.this.gVq.setVisibility(8);
                AlaLiveAudienceEndView.this.gVr.playAnimation();
            }
        });
        bUS();
        MessageManager.getInstance().registerListener(this.gVP);
    }

    public void setCallback(a aVar) {
        this.gVm = aVar;
    }

    public void setData(TbPageContext tbPageContext, ab abVar, boolean z, boolean z2, String str, String str2) {
        this.aED = abVar;
        this.gVL = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aED = abVar;
        this.mLiveInfo = abVar.mLiveInfo;
        this.gVK = z2;
        this.mPortrait = str;
        this.gVL = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aYp = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aYp == null || TextUtils.equals(this.aYp, "null")) {
            this.aYp = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gVp.setVisibility(4);
        } else {
            this.gVs = AnimationUtils.loadAnimation(this.mContext, a.C0201a.anim_endview_holo_rotate);
            this.gVp.startAnimation(this.gVs);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.gVn.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.gVn.startLoad(this.mPortrait, 12, false, false);
        }
        this.gVo.setText(this.aED.aJD.userName);
        this.gVG.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aED != null && this.aED.mLiveInfo != null && this.aED.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aED.mLiveInfo.mLiveCloseData.title)) {
            this.gVH.setText(this.aED.mLiveInfo.mLiveCloseData.title);
        } else if (this.gVL) {
            this.gVH.setText(a.h.live_closed);
        } else {
            this.gVH.setText(a.h.live_over_name);
        }
        this.gVq.setVisibility(0);
        this.gVq.playAnimation();
        nc(this.gVK);
    }

    public void nc(boolean z) {
        this.gVK = z;
        if (this.aED != null && this.aED.mLiveInfo != null && this.aED.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aED.mLiveInfo.mLiveCloseData.tips)) {
                this.gVI.setText("");
            } else {
                this.gVI.setText(this.aED.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aED.mLiveInfo.mLiveCloseData.actionText)) {
                this.gVG.setVisibility(8);
                this.gVF.setText("");
            } else {
                this.gVG.setVisibility(0);
                this.gVF.setText(this.aED.mLiveInfo.mLiveCloseData.actionText);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gVG.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gVK) {
            this.gVI.setText(a.h.endtext_followed);
            this.gVF.setText(a.h.sdk_followed);
            this.gVF.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha60));
            this.gVG.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_c);
            return;
        }
        this.gVI.setText(a.h.endtext_follow);
        this.gVF.setText(a.h.follow);
        this.gVF.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
    }

    private void bUS() {
        this.gVt = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gVu = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gVJ = this.mView.findViewById(a.f.change_layout);
        this.gVx = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gVy = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gVz = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.gVB = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gVC = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gVD = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.gVv = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gVw = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gVA = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gVE = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gVt.setVisibility(i);
        this.gVu.setVisibility(i);
    }

    public void bUT() {
        d dVar = new d();
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aED == null || (this.aED.mLiveInfo != null && this.aED.mLiveInfo.mLiveCloseData != null)) {
            setRecommendViewVisible(8);
        } else {
            setRecommendViewVisible(0);
            boolean z = arrayList.size() > 2;
            this.gVN = arrayList;
            this.gVM = 0;
            a(this.gVM, arrayList.get(this.gVM), this.gVM + 1, arrayList.get(this.gVM + 1), z);
            this.gVM++;
            if (this.animator == null) {
                this.animator = ValueAnimator.ofInt(100, 0);
                this.animator.setDuration(5000L);
                this.animator.setInterpolator(gVl);
                this.animator.setRepeatCount(-1);
                this.animator.setRepeatMode(1);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.gVA.setProgress(intValue);
                        AlaLiveAudienceEndView.this.gVE.setProgress(intValue);
                    }
                });
                this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bUU();
                    }
                });
            }
            if (z) {
                this.animator.start();
                this.gVJ.setVisibility(0);
                this.gVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYp, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.animator.cancel();
                        AlaLiveAudienceEndView.this.bUU();
                        AlaLiveAudienceEndView.this.animator.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUU() {
        int i = this.gVM + 1;
        this.gVM = i;
        if (i >= this.gVN.size()) {
            this.gVM = 0;
            i = 0;
        }
        int i2 = this.gVM + 1;
        this.gVM = i2;
        if (i2 >= this.gVN.size()) {
            this.gVM = 0;
            i2 = 0;
        }
        this.gVM = i2;
        a(i, this.gVN.get(i), i2, this.gVN.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.gVO.contains(Long.valueOf(this.gVN.get(i).live_id))) {
            this.gVO.add(Long.valueOf(this.gVN.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aYp, this.gVN.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.gVO.contains(Long.valueOf(this.gVN.get(i2).live_id))) {
            this.gVO.add(Long.valueOf(this.gVN.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aYp, this.gVN.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.gVv, this.gVx, this.gVy, this.gVz, this.gVA, alaLiveInfoData, z, i);
        a(this.gVw, this.gVB, this.gVC, this.gVD, this.gVE, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYp, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.gVN.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.mContext, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.gVm != null) {
                        AlaLiveAudienceEndView.this.gVm.f(alaLiveInfoData);
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
        return this.gVt;
    }

    public HeadImageView getPortraitImg() {
        return this.gVn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUV() {
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
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYp, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.gVm.nb(AlaLiveAudienceEndView.this.gVK);
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
        MessageManager.getInstance().unRegisterListener(this.gVP);
        if (this.gVs != null) {
            this.gVs.cancel();
        }
        if (this.gVq != null) {
            this.gVq.cancelAnimation();
        }
        if (this.gVr != null) {
            this.gVr.cancelAnimation();
        }
        if (this.animator != null) {
            this.animator.cancel();
            this.animator.removeAllUpdateListeners();
            this.animator.removeAllListeners();
        }
    }
}
