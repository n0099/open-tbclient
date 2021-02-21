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
/* loaded from: classes11.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator gTC = new LinearInterpolator();
    private ab aDd;
    private String aWP;
    private ValueAnimator animator;
    private a gTD;
    private HeadImageView gTE;
    private TextView gTF;
    private ImageView gTG;
    private LottieAnimationView gTH;
    private LottieAnimationView gTI;
    private Animation gTJ;
    private LinearLayout gTK;
    private LinearLayout gTL;
    private RelativeLayout gTM;
    private RelativeLayout gTN;
    private TbImageView gTO;
    private TextView gTP;
    private TextView gTQ;
    private ProgressBar gTR;
    private TbImageView gTS;
    private TextView gTT;
    private TextView gTU;
    private ProgressBar gTV;
    private TextView gTW;
    private LinearLayout gTX;
    private TextView gTY;
    private TextView gTZ;
    private View gUa;
    private boolean gUb;
    private boolean gUc;
    private int gUd;
    private ArrayList<AlaLiveInfoData> gUe;
    private Set<Long> gUf;
    private HttpMessageListener gUg;
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
        void MM();

        void f(AlaLiveInfoData alaLiveInfoData);

        void nb(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gUb = false;
        this.mPortrait = "";
        this.gUc = false;
        this.gUd = 0;
        this.gUf = new HashSet();
        this.gUg = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).gUe;
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
                if (AlaLiveAudienceEndView.this.gTD != null) {
                    AlaLiveAudienceEndView.this.gTD.MM();
                }
            }
        });
        this.gTG = (ImageView) this.mView.findViewById(a.f.headHalo_imageView);
        this.gTH = (LottieAnimationView) this.mView.findViewById(a.f.flowerAppear_lottieAnimationView);
        this.gTH.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gTH.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.gTI = (LottieAnimationView) this.mView.findViewById(a.f.flowerDrop_lottieAnimationView);
        this.gTI.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gTI.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.gTE = (HeadImageView) this.mView.findViewById(a.f.avatar_img);
        this.gTE.setIsRound(true);
        this.gTE.setDrawBorder(true);
        this.gTE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gTE.setAutoChangeStyle(false);
        this.gTF = (TextView) this.mView.findViewById(a.f.user_name);
        this.gTZ = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.gTX = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gTW = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gTX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aDd == null || AlaLiveAudienceEndView.this.aDd.mLiveInfo == null || AlaLiveAudienceEndView.this.aDd.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.gTD != null) {
                        if (AlaLiveAudienceEndView.this.gUb) {
                            AlaLiveAudienceEndView.this.bUP();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWP, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gTD.nb(AlaLiveAudienceEndView.this.gUb);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aDd.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.aDd.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.gTY = (TextView) this.mView.findViewById(a.f.live_over_name);
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.title)) {
                this.gTY.setText(a.h.live_over_name);
            } else {
                this.gTY.setText(this.aDd.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gUc) {
            this.gTY.setText(a.h.live_closed);
        } else {
            this.gTY.setText(a.h.live_over_name);
        }
        this.gTH.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.gTI.setVisibility(0);
                AlaLiveAudienceEndView.this.gTH.setVisibility(8);
                AlaLiveAudienceEndView.this.gTI.playAnimation();
            }
        });
        bUM();
        MessageManager.getInstance().registerListener(this.gUg);
    }

    public void setCallback(a aVar) {
        this.gTD = aVar;
    }

    public void setData(TbPageContext tbPageContext, ab abVar, boolean z, boolean z2, String str, String str2) {
        this.aDd = abVar;
        this.gUc = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aDd = abVar;
        this.mLiveInfo = abVar.mLiveInfo;
        this.gUb = z2;
        this.mPortrait = str;
        this.gUc = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aWP = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aWP == null || TextUtils.equals(this.aWP, "null")) {
            this.aWP = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gTG.setVisibility(4);
        } else {
            this.gTJ = AnimationUtils.loadAnimation(this.mContext, a.C0195a.anim_endview_holo_rotate);
            this.gTG.startAnimation(this.gTJ);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.gTE.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.gTE.startLoad(this.mPortrait, 12, false, false);
        }
        this.gTF.setText(this.aDd.aId.userName);
        this.gTX.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.title)) {
            this.gTY.setText(this.aDd.mLiveInfo.mLiveCloseData.title);
        } else if (this.gUc) {
            this.gTY.setText(a.h.live_closed);
        } else {
            this.gTY.setText(a.h.live_over_name);
        }
        this.gTH.setVisibility(0);
        this.gTH.playAnimation();
        nc(this.gUb);
    }

    public void nc(boolean z) {
        this.gUb = z;
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.tips)) {
                this.gTZ.setText("");
            } else {
                this.gTZ.setText(this.aDd.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.actionText)) {
                this.gTX.setVisibility(8);
                this.gTW.setText("");
            } else {
                this.gTX.setVisibility(0);
                this.gTW.setText(this.aDd.mLiveInfo.mLiveCloseData.actionText);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gTX.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gUb) {
            this.gTZ.setText(a.h.endtext_followed);
            this.gTW.setText(a.h.sdk_followed);
            this.gTW.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha60));
            this.gTX.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_c);
            return;
        }
        this.gTZ.setText(a.h.endtext_follow);
        this.gTW.setText(a.h.follow);
        this.gTW.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
    }

    private void bUM() {
        this.gTK = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gTL = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gUa = this.mView.findViewById(a.f.change_layout);
        this.gTO = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gTP = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gTQ = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.gTS = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gTT = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gTU = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.gTM = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gTN = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gTR = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gTV = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gTK.setVisibility(i);
        this.gTL.setVisibility(i);
    }

    public void bUN() {
        d dVar = new d();
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aDd == null || (this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null)) {
            setRecommendViewVisible(8);
        } else {
            setRecommendViewVisible(0);
            boolean z = arrayList.size() > 2;
            this.gUe = arrayList;
            this.gUd = 0;
            a(this.gUd, arrayList.get(this.gUd), this.gUd + 1, arrayList.get(this.gUd + 1), z);
            this.gUd++;
            if (this.animator == null) {
                this.animator = ValueAnimator.ofInt(100, 0);
                this.animator.setDuration(5000L);
                this.animator.setInterpolator(gTC);
                this.animator.setRepeatCount(-1);
                this.animator.setRepeatMode(1);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.gTR.setProgress(intValue);
                        AlaLiveAudienceEndView.this.gTV.setProgress(intValue);
                    }
                });
                this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bUO();
                    }
                });
            }
            if (z) {
                this.animator.start();
                this.gUa.setVisibility(0);
                this.gUa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWP, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.animator.cancel();
                        AlaLiveAudienceEndView.this.bUO();
                        AlaLiveAudienceEndView.this.animator.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUO() {
        int i = this.gUd + 1;
        this.gUd = i;
        if (i >= this.gUe.size()) {
            this.gUd = 0;
            i = 0;
        }
        int i2 = this.gUd + 1;
        this.gUd = i2;
        if (i2 >= this.gUe.size()) {
            this.gUd = 0;
            i2 = 0;
        }
        this.gUd = i2;
        a(i, this.gUe.get(i), i2, this.gUe.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.gUf.contains(Long.valueOf(this.gUe.get(i).live_id))) {
            this.gUf.add(Long.valueOf(this.gUe.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aWP, this.gUe.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.gUf.contains(Long.valueOf(this.gUe.get(i2).live_id))) {
            this.gUf.add(Long.valueOf(this.gUe.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aWP, this.gUe.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.gTM, this.gTO, this.gTP, this.gTQ, this.gTR, alaLiveInfoData, z, i);
        a(this.gTN, this.gTS, this.gTT, this.gTU, this.gTV, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWP, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.gUe.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.mContext, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.gTD != null) {
                        AlaLiveAudienceEndView.this.gTD.f(alaLiveInfoData);
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
        return this.gTK;
    }

    public HeadImageView getPortraitImg() {
        return this.gTE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUP() {
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
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWP, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.gTD.nb(AlaLiveAudienceEndView.this.gUb);
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
        MessageManager.getInstance().unRegisterListener(this.gUg);
        if (this.gTJ != null) {
            this.gTJ.cancel();
        }
        if (this.gTH != null) {
            this.gTH.cancelAnimation();
        }
        if (this.gTI != null) {
            this.gTI.cancelAnimation();
        }
        if (this.animator != null) {
            this.animator.cancel();
            this.animator.removeAllUpdateListeners();
            this.animator.removeAllListeners();
        }
    }
}
