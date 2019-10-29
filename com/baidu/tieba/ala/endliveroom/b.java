package com.baidu.tieba.ala.endliveroom;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import com.baidu.live.data.i;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class b {
    private static final LinearInterpolator dHE = new LinearInterpolator();
    private String WX;
    private i aaB;
    private Activity cft;
    private a dHF;
    private HeadImageView dHG;
    private TextView dHH;
    private ImageView dHI;
    private LottieAnimationView dHJ;
    private LottieAnimationView dHK;
    private Animation dHL;
    private LinearLayout dHM;
    private LinearLayout dHN;
    private RelativeLayout dHO;
    private RelativeLayout dHP;
    private TbImageView dHQ;
    private TextView dHR;
    private TextView dHS;
    private ProgressBar dHT;
    private TbImageView dHU;
    private TextView dHV;
    private TextView dHW;
    private ProgressBar dHX;
    private TextView dHY;
    private LinearLayout dHZ;
    private TextView dIa;
    private TextView dIb;
    private View dIc;
    private boolean dId;
    private boolean dIe;
    private ArrayList<AlaLiveInfoData> dIg;
    private ValueAnimator dIh;
    private String liveId;
    private ImageView mCloseBtn;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View mView;
    private String otherParams;
    private String roomId;
    private int dIf = 0;
    private Set<Long> dIi = new HashSet();

    /* loaded from: classes6.dex */
    public interface a {
        void aKJ();

        void b(AlaLiveInfoData alaLiveInfoData);

        void gT(boolean z);
    }

    public b(Activity activity, i iVar, boolean z, String str, boolean z2, a aVar, String str2) {
        this.dId = false;
        this.mPortrait = "";
        this.dIe = false;
        this.cft = activity;
        this.aaB = iVar;
        this.mLiveInfo = iVar.mLiveInfo;
        this.dHF = aVar;
        this.dId = z;
        this.mPortrait = str;
        this.dIe = z2;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.WX = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.WX == null || TextUtils.equals(this.WX, "null")) {
            this.WX = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.cft).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) null);
        this.mView.setId(a.g.ala_liveroom_audience_end_view);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dHF != null) {
                    b.this.dHF.aKJ();
                }
            }
        });
        this.dHI = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.dHJ = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.dHJ.loop(false);
        this.dHJ.setAnimation("anim_endview_head_flower_appear.json");
        this.dHK = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.dHK.loop(false);
        this.dHK.setAnimation("anim_endview_head_flower_loop.json");
        this.dHL = AnimationUtils.loadAnimation(this.cft, a.C0068a.anim_endview_holo_rotate);
        this.dHI.startAnimation(this.dHL);
        this.dHG = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.dHG.setIsRound(true);
        this.dHG.setDrawBorder(false);
        this.dHG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dHG.setAutoChangeStyle(false);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.dHG.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.dHG.startLoad(this.mPortrait, 12, false, false);
        }
        this.dHH = (TextView) this.mView.findViewById(a.g.user_name);
        this.dHH.setText(this.aaB.Ps.userName);
        this.dIb = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.dHZ = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.dHY = (TextView) this.mView.findViewById(a.g.follow_label);
        this.dHZ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        this.dHZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aaB == null || b.this.aaB.mLiveInfo == null || b.this.aaB.mLiveInfo.mLiveCloseData == null) {
                    if (b.this.dHF != null) {
                        if (b.this.dId) {
                            b.this.aKN();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.WX, b.this.otherParams);
                        b.this.dHF.gT(b.this.dId);
                    }
                } else if (!TextUtils.isEmpty(b.this.aaB.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(b.this.cft, b.this.aaB.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.dIa = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aaB != null && this.aaB.mLiveInfo != null && this.aaB.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aaB.mLiveInfo.mLiveCloseData.title)) {
            this.dIa.setText(this.aaB.mLiveInfo.mLiveCloseData.title);
        } else if (this.dIe) {
            this.dIa.setText(a.i.live_closed);
        } else {
            this.dIa.setText(a.i.live_over_name);
        }
        this.dHJ.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.endliveroom.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.dHK.setVisibility(0);
                b.this.dHJ.setVisibility(8);
                b.this.dHK.playAnimation();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.dHJ.setVisibility(0);
        this.dHJ.playAnimation();
        aKK();
        gU(this.dId);
    }

    public void gU(boolean z) {
        this.dId = z;
        if (this.aaB != null && this.aaB.mLiveInfo != null && this.aaB.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aaB.mLiveInfo.mLiveCloseData.tips) && !TextUtils.isEmpty(this.aaB.mLiveInfo.mLiveCloseData.actionText)) {
            this.dIb.setText(this.aaB.mLiveInfo.mLiveCloseData.tips);
            this.dHY.setText(this.aaB.mLiveInfo.mLiveCloseData.actionText);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.dHZ.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                this.dHZ.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            } else {
                this.dHZ.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            }
            mB(8);
        } else if (this.dId) {
            this.dIb.setText(a.i.endtext_followed);
            this.dHY.setText(a.i.sdk_followed);
            this.dHY.setTextColor(this.cft.getResources().getColor(a.d.sdk_white_alpha60));
            this.dHZ.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
        } else {
            this.dIb.setText(a.i.endtext_follow);
            this.dHY.setText(a.i.follow);
            this.dHY.setTextColor(this.cft.getResources().getColor(a.d.sdk_white_alpha100));
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.dHZ.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                this.dHZ.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            } else {
                this.dHZ.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            }
        }
    }

    private void aKK() {
        this.dHM = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.dHN = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.dIc = this.mView.findViewById(a.g.change_layout);
        this.dHQ = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.dHR = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.dHS = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.dHU = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.dHV = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.dHW = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.dHO = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.dHP = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.dHT = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.dHX = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void mB(int i) {
        this.dHM.setVisibility(i);
        this.dHN.setVisibility(i);
    }

    public void M(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            mB(8);
        } else if (this.aaB != null) {
            if (this.aaB.mLiveInfo == null || this.aaB.mLiveInfo.mLiveCloseData == null) {
                mB(0);
                boolean z = arrayList.size() > 2;
                this.dIg = arrayList;
                this.dIf = 0;
                a(this.dIf, arrayList.get(this.dIf), this.dIf + 1, arrayList.get(this.dIf + 1), z);
                this.dIf++;
                if (this.dIh == null) {
                    this.dIh = ValueAnimator.ofInt(100, 0);
                    this.dIh.setDuration(5000L);
                    this.dIh.setInterpolator(dHE);
                    this.dIh.setRepeatCount(-1);
                    this.dIh.setRepeatMode(1);
                    this.dIh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.b.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            b.this.dHT.setProgress(intValue);
                            b.this.dHX.setProgress(intValue);
                        }
                    });
                    this.dIh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.endliveroom.b.5
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
                            b.this.aKL();
                        }
                    });
                }
                if (z) {
                    this.dIh.start();
                    this.dIc.setVisibility(0);
                    this.dIc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.WX, b.this.otherParams);
                            b.this.dIh.cancel();
                            b.this.aKL();
                            b.this.dIh.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKL() {
        int i = this.dIf + 1;
        this.dIf = i;
        if (i >= this.dIg.size()) {
            this.dIf = 0;
            i = 0;
        }
        int i2 = this.dIf + 1;
        this.dIf = i2;
        if (i2 >= this.dIg.size()) {
            this.dIf = 0;
            i2 = 0;
        }
        this.dIf = i2;
        a(i, this.dIg.get(i), i2, this.dIg.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.dIi.contains(Long.valueOf(this.dIg.get(i).live_id))) {
            this.dIi.add(Long.valueOf(this.dIg.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.WX, this.dIg.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.dIi.contains(Long.valueOf(this.dIg.get(i2).live_id))) {
            this.dIi.add(Long.valueOf(this.dIg.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.WX, this.dIg.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.dHO, this.dHQ, this.dHR, this.dHS, this.dHT, alaLiveInfoData, z, i);
        a(this.dHP, this.dHU, this.dHV, this.dHW, this.dHX, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.WX, ((AlaLiveInfoData) b.this.dIg.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", b.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(b.this.cft, a.i.sdk_no_network_guide);
                    } else if (b.this.dHF != null) {
                        b.this.dHF.b(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.cft.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
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

    public ViewGroup aKM() {
        return this.dHM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKN() {
        View inflate;
        final Dialog dialog;
        if (this.cft != null) {
            LayoutInflater from = LayoutInflater.from(this.cft);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                inflate = from.inflate(a.h.dialog_follow_confirm_hk, (ViewGroup) null);
                dialog = new Dialog(this.cft, a.j.PlayLevelDialog);
            } else {
                inflate = from.inflate(a.h.dialog_follow_confirm_qm, (ViewGroup) null);
                dialog = new Dialog(this.cft, a.j.PopStyleActivity);
            }
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                dialog.getWindow().getAttributes().width = this.cft.getResources().getDimensionPixelSize(a.e.sdk_ds630);
                dialog.getWindow().getAttributes().height = this.cft.getResources().getDimensionPixelSize(a.e.sdk_ds300);
            } else {
                dialog.getWindow().getAttributes().width = getScreenWidth(this.cft);
                dialog.getWindow().getAttributes().height = this.cft.getResources().getDimensionPixelSize(a.e.sdk_ds324);
                dialog.getWindow().getAttributes().gravity = 80;
            }
            ((TextView) inflate.findViewById(a.g.cancel_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.g.config_textView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.WX, b.this.otherParams);
                    b.this.dHF.gT(b.this.dId);
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    }

    public int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public void onDestory() {
        if (this.dHL != null) {
            this.dHL.cancel();
        }
        if (this.dHJ != null) {
            this.dHJ.cancelAnimation();
        }
        if (this.dHK != null) {
            this.dHK.cancelAnimation();
        }
        if (this.dIh != null) {
            this.dIh.cancel();
        }
    }
}
