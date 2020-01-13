package com.baidu.tieba.ala.endliveroom;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
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
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.l;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    private static final LinearInterpolator ewk = new LinearInterpolator();
    private String aeS;
    private l aiW;
    private TbImageView ewA;
    private TextView ewB;
    private TextView ewC;
    private ProgressBar ewD;
    private TextView ewE;
    private LinearLayout ewF;
    private TextView ewG;
    private TextView ewH;
    private View ewI;
    private boolean ewJ;
    private boolean ewK;
    private ArrayList<AlaLiveInfoData> ewM;
    private ValueAnimator ewN;
    private a ewl;
    private HeadImageView ewm;
    private TextView ewn;
    private ImageView ewo;
    private LottieAnimationView ewp;
    private LottieAnimationView ewq;
    private Animation ewr;
    private LinearLayout ews;
    private LinearLayout ewt;
    private RelativeLayout ewu;
    private RelativeLayout ewv;
    private TbImageView eww;
    private TextView ewx;
    private TextView ewy;
    private ProgressBar ewz;
    private String liveId;
    private ImageView mCloseBtn;
    private Activity mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private String otherParams;
    private String roomId;
    private int ewL = 0;
    private Set<Long> ewO = new HashSet();

    /* loaded from: classes2.dex */
    public interface a {
        void b(AlaLiveInfoData alaLiveInfoData);

        void bco();

        void ik(boolean z);
    }

    public b(TbPageContext tbPageContext, l lVar, boolean z, String str, boolean z2, a aVar, String str2) {
        this.ewJ = false;
        this.mPortrait = "";
        this.ewK = false;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aiW = lVar;
        this.mLiveInfo = lVar.mLiveInfo;
        this.ewl = aVar;
        this.ewJ = z;
        this.mPortrait = str;
        this.ewK = z2;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aeS = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aeS == null || TextUtils.equals(this.aeS, "null")) {
            this.aeS = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) null);
        this.mView.setId(a.g.ala_liveroom_audience_end_view);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ewl != null) {
                    b.this.ewl.bco();
                }
            }
        });
        this.ewo = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.ewp = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.ewp.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ewp.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.ewq = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.ewq.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ewq.setAnimation("anim_endview_head_flower_loop.json");
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ewo.setVisibility(4);
        } else {
            this.ewr = AnimationUtils.loadAnimation(this.mContext, a.C0086a.anim_endview_holo_rotate);
            this.ewo.startAnimation(this.ewr);
        }
        this.ewm = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.ewm.setIsRound(true);
        this.ewm.setDrawBorder(true);
        this.ewm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ewm.setAutoChangeStyle(false);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.ewm.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.ewm.startLoad(this.mPortrait, 12, false, false);
        }
        this.ewn = (TextView) this.mView.findViewById(a.g.user_name);
        this.ewn.setText(this.aiW.Wf.userName);
        this.ewH = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.ewF = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.ewE = (TextView) this.mView.findViewById(a.g.follow_label);
        this.ewF.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        this.ewF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aiW == null || b.this.aiW.mLiveInfo == null || b.this.aiW.mLiveInfo.mLiveCloseData == null) {
                    if (b.this.ewl != null) {
                        if (b.this.ewJ) {
                            b.this.bcs();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.aeS, b.this.otherParams);
                        b.this.ewl.ik(b.this.ewJ);
                    }
                } else if (!TextUtils.isEmpty(b.this.aiW.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(b.this.mContext, b.this.aiW.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.ewG = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aiW != null && this.aiW.mLiveInfo != null && this.aiW.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aiW.mLiveInfo.mLiveCloseData.title)) {
            this.ewG.setText(this.aiW.mLiveInfo.mLiveCloseData.title);
        } else if (this.ewK) {
            this.ewG.setText(a.i.live_closed);
        } else {
            this.ewG.setText(a.i.live_over_name);
        }
        this.ewp.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.endliveroom.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ewq.setVisibility(0);
                b.this.ewp.setVisibility(8);
                b.this.ewq.playAnimation();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ewp.setVisibility(0);
        this.ewp.playAnimation();
        bcp();
        il(this.ewJ);
    }

    public void il(boolean z) {
        this.ewJ = z;
        if (this.aiW != null && this.aiW.mLiveInfo != null && this.aiW.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aiW.mLiveInfo.mLiveCloseData.tips) && !TextUtils.isEmpty(this.aiW.mLiveInfo.mLiveCloseData.actionText)) {
            this.ewH.setText(this.aiW.mLiveInfo.mLiveCloseData.tips);
            this.ewE.setText(this.aiW.mLiveInfo.mLiveCloseData.actionText);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.ewF.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                this.ewF.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ewF.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
            } else {
                this.ewF.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            }
            oR(8);
        } else if (this.ewJ) {
            this.ewH.setText(a.i.endtext_followed);
            this.ewE.setText(a.i.sdk_followed);
            this.ewE.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ewF.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
            } else {
                this.ewF.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
            }
        } else {
            this.ewH.setText(a.i.endtext_follow);
            this.ewE.setText(a.i.follow);
            this.ewE.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.ewF.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                this.ewF.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ewF.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
            } else {
                this.ewF.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            }
        }
    }

    private void bcp() {
        this.ews = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.ewt = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.ewI = this.mView.findViewById(a.g.change_layout);
        this.eww = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.ewx = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.ewy = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.ewA = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.ewB = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.ewC = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.ewu = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.ewv = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.ewz = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.ewD = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void oR(int i) {
        this.ews.setVisibility(i);
        this.ewt.setVisibility(i);
    }

    public void S(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            oR(8);
        } else if (this.aiW != null) {
            if (this.aiW.mLiveInfo == null || this.aiW.mLiveInfo.mLiveCloseData == null) {
                oR(0);
                boolean z = arrayList.size() > 2;
                this.ewM = arrayList;
                this.ewL = 0;
                a(this.ewL, arrayList.get(this.ewL), this.ewL + 1, arrayList.get(this.ewL + 1), z);
                this.ewL++;
                if (this.ewN == null) {
                    this.ewN = ValueAnimator.ofInt(100, 0);
                    this.ewN.setDuration(5000L);
                    this.ewN.setInterpolator(ewk);
                    this.ewN.setRepeatCount(-1);
                    this.ewN.setRepeatMode(1);
                    this.ewN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.b.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            b.this.ewz.setProgress(intValue);
                            b.this.ewD.setProgress(intValue);
                        }
                    });
                    this.ewN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.endliveroom.b.5
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            b.this.bcq();
                        }
                    });
                }
                if (z) {
                    this.ewN.start();
                    this.ewI.setVisibility(0);
                    this.ewI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.aeS, b.this.otherParams);
                            b.this.ewN.cancel();
                            b.this.bcq();
                            b.this.ewN.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcq() {
        int i = this.ewL + 1;
        this.ewL = i;
        if (i >= this.ewM.size()) {
            this.ewL = 0;
            i = 0;
        }
        int i2 = this.ewL + 1;
        this.ewL = i2;
        if (i2 >= this.ewM.size()) {
            this.ewL = 0;
            i2 = 0;
        }
        this.ewL = i2;
        a(i, this.ewM.get(i), i2, this.ewM.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.ewO.contains(Long.valueOf(this.ewM.get(i).live_id))) {
            this.ewO.add(Long.valueOf(this.ewM.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aeS, this.ewM.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.ewO.contains(Long.valueOf(this.ewM.get(i2).live_id))) {
            this.ewO.add(Long.valueOf(this.ewM.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aeS, this.ewM.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.ewu, this.eww, this.ewx, this.ewy, this.ewz, alaLiveInfoData, z, i);
        a(this.ewv, this.ewA, this.ewB, this.ewC, this.ewD, alaLiveInfoData2, z, i2);
    }

    public void a(View view, TbImageView tbImageView, TextView textView, TextView textView2, ProgressBar progressBar, final AlaLiveInfoData alaLiveInfoData, boolean z, final int i) {
        if (alaLiveInfoData != null) {
            String str = alaLiveInfoData.cover;
            tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TextUtils.isEmpty(str)) {
                tbImageView.startLoad(str, 10, false);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.aeS, ((AlaLiveInfoData) b.this.ewM.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", b.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(b.this.mContext, a.i.sdk_no_network_guide);
                    } else if (b.this.ewl != null) {
                        b.this.ewl.b(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.mContext.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public View getRootView() {
        return this.mView;
    }

    public ViewGroup bcr() {
        return this.ews;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcs() {
        if (this.mContext != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mContext);
            bdAlertDialog.setMessage(this.mContext.getResources().getString(a.i.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.i.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.i.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.aeS, b.this.otherParams);
                    b.this.ewl.ik(b.this.ewJ);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
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
        if (this.ewr != null) {
            this.ewr.cancel();
        }
        if (this.ewp != null) {
            this.ewp.cancelAnimation();
        }
        if (this.ewq != null) {
            this.ewq.cancelAnimation();
        }
        if (this.ewN != null) {
            this.ewN.cancel();
        }
    }
}
