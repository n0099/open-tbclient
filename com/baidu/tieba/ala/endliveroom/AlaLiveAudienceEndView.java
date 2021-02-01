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
    private static final LinearInterpolator gTo = new LinearInterpolator();
    private ab aDd;
    private String aWP;
    private ValueAnimator animator;
    private TbImageView gTA;
    private TextView gTB;
    private TextView gTC;
    private ProgressBar gTD;
    private TbImageView gTE;
    private TextView gTF;
    private TextView gTG;
    private ProgressBar gTH;
    private TextView gTI;
    private LinearLayout gTJ;
    private TextView gTK;
    private TextView gTL;
    private View gTM;
    private boolean gTN;
    private boolean gTO;
    private int gTP;
    private ArrayList<AlaLiveInfoData> gTQ;
    private Set<Long> gTR;
    private HttpMessageListener gTS;
    private a gTp;
    private HeadImageView gTq;
    private TextView gTr;
    private ImageView gTs;
    private LottieAnimationView gTt;
    private LottieAnimationView gTu;
    private Animation gTv;
    private LinearLayout gTw;
    private LinearLayout gTx;
    private RelativeLayout gTy;
    private RelativeLayout gTz;
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
        this.gTN = false;
        this.mPortrait = "";
        this.gTO = false;
        this.gTP = 0;
        this.gTR = new HashSet();
        this.gTS = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).gTQ;
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
                if (AlaLiveAudienceEndView.this.gTp != null) {
                    AlaLiveAudienceEndView.this.gTp.MM();
                }
            }
        });
        this.gTs = (ImageView) this.mView.findViewById(a.f.headHalo_imageView);
        this.gTt = (LottieAnimationView) this.mView.findViewById(a.f.flowerAppear_lottieAnimationView);
        this.gTt.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gTt.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.gTu = (LottieAnimationView) this.mView.findViewById(a.f.flowerDrop_lottieAnimationView);
        this.gTu.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gTu.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.gTq = (HeadImageView) this.mView.findViewById(a.f.avatar_img);
        this.gTq.setIsRound(true);
        this.gTq.setDrawBorder(true);
        this.gTq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gTq.setAutoChangeStyle(false);
        this.gTr = (TextView) this.mView.findViewById(a.f.user_name);
        this.gTL = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.gTJ = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gTI = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aDd == null || AlaLiveAudienceEndView.this.aDd.mLiveInfo == null || AlaLiveAudienceEndView.this.aDd.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.gTp != null) {
                        if (AlaLiveAudienceEndView.this.gTN) {
                            AlaLiveAudienceEndView.this.bUI();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWP, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gTp.nb(AlaLiveAudienceEndView.this.gTN);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aDd.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.aDd.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.gTK = (TextView) this.mView.findViewById(a.f.live_over_name);
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.title)) {
                this.gTK.setText(a.h.live_over_name);
            } else {
                this.gTK.setText(this.aDd.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gTO) {
            this.gTK.setText(a.h.live_closed);
        } else {
            this.gTK.setText(a.h.live_over_name);
        }
        this.gTt.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.gTu.setVisibility(0);
                AlaLiveAudienceEndView.this.gTt.setVisibility(8);
                AlaLiveAudienceEndView.this.gTu.playAnimation();
            }
        });
        bUF();
        MessageManager.getInstance().registerListener(this.gTS);
    }

    public void setCallback(a aVar) {
        this.gTp = aVar;
    }

    public void setData(TbPageContext tbPageContext, ab abVar, boolean z, boolean z2, String str, String str2) {
        this.aDd = abVar;
        this.gTO = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aDd = abVar;
        this.mLiveInfo = abVar.mLiveInfo;
        this.gTN = z2;
        this.mPortrait = str;
        this.gTO = z;
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
            this.gTs.setVisibility(4);
        } else {
            this.gTv = AnimationUtils.loadAnimation(this.mContext, a.C0195a.anim_endview_holo_rotate);
            this.gTs.startAnimation(this.gTv);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.gTq.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.gTq.startLoad(this.mPortrait, 12, false, false);
        }
        this.gTr.setText(this.aDd.aId.userName);
        this.gTJ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.title)) {
            this.gTK.setText(this.aDd.mLiveInfo.mLiveCloseData.title);
        } else if (this.gTO) {
            this.gTK.setText(a.h.live_closed);
        } else {
            this.gTK.setText(a.h.live_over_name);
        }
        this.gTt.setVisibility(0);
        this.gTt.playAnimation();
        nc(this.gTN);
    }

    public void nc(boolean z) {
        this.gTN = z;
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.tips)) {
                this.gTL.setText("");
            } else {
                this.gTL.setText(this.aDd.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.actionText)) {
                this.gTJ.setVisibility(8);
                this.gTI.setText("");
            } else {
                this.gTJ.setVisibility(0);
                this.gTI.setText(this.aDd.mLiveInfo.mLiveCloseData.actionText);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gTJ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gTN) {
            this.gTL.setText(a.h.endtext_followed);
            this.gTI.setText(a.h.sdk_followed);
            this.gTI.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha60));
            this.gTJ.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_c);
            return;
        }
        this.gTL.setText(a.h.endtext_follow);
        this.gTI.setText(a.h.follow);
        this.gTI.setTextColor(this.mContext.getResources().getColor(a.c.sdk_white_alpha100));
    }

    private void bUF() {
        this.gTw = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gTx = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gTM = this.mView.findViewById(a.f.change_layout);
        this.gTA = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gTB = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gTC = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.gTE = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gTF = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gTG = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.gTy = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gTz = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gTD = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gTH = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gTw.setVisibility(i);
        this.gTx.setVisibility(i);
    }

    public void bUG() {
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
            this.gTQ = arrayList;
            this.gTP = 0;
            a(this.gTP, arrayList.get(this.gTP), this.gTP + 1, arrayList.get(this.gTP + 1), z);
            this.gTP++;
            if (this.animator == null) {
                this.animator = ValueAnimator.ofInt(100, 0);
                this.animator.setDuration(5000L);
                this.animator.setInterpolator(gTo);
                this.animator.setRepeatCount(-1);
                this.animator.setRepeatMode(1);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.gTD.setProgress(intValue);
                        AlaLiveAudienceEndView.this.gTH.setProgress(intValue);
                    }
                });
                this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bUH();
                    }
                });
            }
            if (z) {
                this.animator.start();
                this.gTM.setVisibility(0);
                this.gTM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWP, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.animator.cancel();
                        AlaLiveAudienceEndView.this.bUH();
                        AlaLiveAudienceEndView.this.animator.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUH() {
        int i = this.gTP + 1;
        this.gTP = i;
        if (i >= this.gTQ.size()) {
            this.gTP = 0;
            i = 0;
        }
        int i2 = this.gTP + 1;
        this.gTP = i2;
        if (i2 >= this.gTQ.size()) {
            this.gTP = 0;
            i2 = 0;
        }
        this.gTP = i2;
        a(i, this.gTQ.get(i), i2, this.gTQ.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.gTR.contains(Long.valueOf(this.gTQ.get(i).live_id))) {
            this.gTR.add(Long.valueOf(this.gTQ.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aWP, this.gTQ.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.gTR.contains(Long.valueOf(this.gTQ.get(i2).live_id))) {
            this.gTR.add(Long.valueOf(this.gTQ.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aWP, this.gTQ.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.gTy, this.gTA, this.gTB, this.gTC, this.gTD, alaLiveInfoData, z, i);
        a(this.gTz, this.gTE, this.gTF, this.gTG, this.gTH, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWP, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.gTQ.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.mContext, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.gTp != null) {
                        AlaLiveAudienceEndView.this.gTp.f(alaLiveInfoData);
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
        return this.gTw;
    }

    public HeadImageView getPortraitImg() {
        return this.gTq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUI() {
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
                    AlaLiveAudienceEndView.this.gTp.nb(AlaLiveAudienceEndView.this.gTN);
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
        MessageManager.getInstance().unRegisterListener(this.gTS);
        if (this.gTv != null) {
            this.gTv.cancel();
        }
        if (this.gTt != null) {
            this.gTt.cancelAnimation();
        }
        if (this.gTu != null) {
            this.gTu.cancelAnimation();
        }
        if (this.animator != null) {
            this.animator.cancel();
            this.animator.removeAllUpdateListeners();
            this.animator.removeAllListeners();
        }
    }
}
