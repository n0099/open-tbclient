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
    private static final LinearInterpolator dGN = new LinearInterpolator();
    private String WE;
    private i aaj;
    private Activity ceC;
    private a dGO;
    private HeadImageView dGP;
    private TextView dGQ;
    private ImageView dGR;
    private LottieAnimationView dGS;
    private LottieAnimationView dGT;
    private Animation dGU;
    private LinearLayout dGV;
    private LinearLayout dGW;
    private RelativeLayout dGX;
    private RelativeLayout dGY;
    private TbImageView dGZ;
    private TextView dHa;
    private TextView dHb;
    private ProgressBar dHc;
    private TbImageView dHd;
    private TextView dHe;
    private TextView dHf;
    private ProgressBar dHg;
    private TextView dHh;
    private LinearLayout dHi;
    private TextView dHj;
    private TextView dHk;
    private View dHl;
    private boolean dHm;
    private boolean dHn;
    private ArrayList<AlaLiveInfoData> dHp;
    private ValueAnimator dHq;
    private String liveId;
    private ImageView mCloseBtn;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View mView;
    private String otherParams;
    private String roomId;
    private int dHo = 0;
    private Set<Long> dHr = new HashSet();

    /* loaded from: classes6.dex */
    public interface a {
        void aKH();

        void b(AlaLiveInfoData alaLiveInfoData);

        void gT(boolean z);
    }

    public b(Activity activity, i iVar, boolean z, String str, boolean z2, a aVar, String str2) {
        this.dHm = false;
        this.mPortrait = "";
        this.dHn = false;
        this.ceC = activity;
        this.aaj = iVar;
        this.mLiveInfo = iVar.mLiveInfo;
        this.dGO = aVar;
        this.dHm = z;
        this.mPortrait = str;
        this.dHn = z2;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.WE = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.WE == null || TextUtils.equals(this.WE, "null")) {
            this.WE = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(this.ceC).inflate(a.h.ala_live_audience_end_view_layout, (ViewGroup) null);
        this.mView.setId(a.g.ala_liveroom_audience_end_view);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dGO != null) {
                    b.this.dGO.aKH();
                }
            }
        });
        this.dGR = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.dGS = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.dGS.loop(false);
        this.dGS.setAnimation("anim_endview_head_flower_appear.json");
        this.dGT = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.dGT.loop(false);
        this.dGT.setAnimation("anim_endview_head_flower_loop.json");
        this.dGU = AnimationUtils.loadAnimation(this.ceC, a.C0068a.anim_endview_holo_rotate);
        this.dGR.startAnimation(this.dGU);
        this.dGP = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.dGP.setIsRound(true);
        this.dGP.setDrawBorder(false);
        this.dGP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dGP.setAutoChangeStyle(false);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.dGP.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.dGP.startLoad(this.mPortrait, 12, false, false);
        }
        this.dGQ = (TextView) this.mView.findViewById(a.g.user_name);
        this.dGQ.setText(this.aaj.OR.userName);
        this.dHk = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.dHi = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.dHh = (TextView) this.mView.findViewById(a.g.follow_label);
        this.dHi.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        this.dHi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aaj == null || b.this.aaj.mLiveInfo == null || b.this.aaj.mLiveInfo.mLiveCloseData == null) {
                    if (b.this.dGO != null) {
                        if (b.this.dHm) {
                            b.this.aKL();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.WE, b.this.otherParams);
                        b.this.dGO.gT(b.this.dHm);
                    }
                } else if (!TextUtils.isEmpty(b.this.aaj.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(b.this.ceC, b.this.aaj.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.dHj = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aaj != null && this.aaj.mLiveInfo != null && this.aaj.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aaj.mLiveInfo.mLiveCloseData.title)) {
            this.dHj.setText(this.aaj.mLiveInfo.mLiveCloseData.title);
        } else if (this.dHn) {
            this.dHj.setText(a.i.live_closed);
        } else {
            this.dHj.setText(a.i.live_over_name);
        }
        this.dGS.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.endliveroom.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.dGT.setVisibility(0);
                b.this.dGS.setVisibility(8);
                b.this.dGT.playAnimation();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.dGS.setVisibility(0);
        this.dGS.playAnimation();
        aKI();
        gU(this.dHm);
    }

    public void gU(boolean z) {
        this.dHm = z;
        if (this.aaj != null && this.aaj.mLiveInfo != null && this.aaj.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aaj.mLiveInfo.mLiveCloseData.tips) && !TextUtils.isEmpty(this.aaj.mLiveInfo.mLiveCloseData.actionText)) {
            this.dHk.setText(this.aaj.mLiveInfo.mLiveCloseData.tips);
            this.dHh.setText(this.aaj.mLiveInfo.mLiveCloseData.actionText);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.dHi.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                this.dHi.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            } else {
                this.dHi.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            }
            mA(8);
        } else if (this.dHm) {
            this.dHk.setText(a.i.endtext_followed);
            this.dHh.setText(a.i.sdk_followed);
            this.dHh.setTextColor(this.ceC.getResources().getColor(a.d.sdk_white_alpha60));
            this.dHi.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
        } else {
            this.dHk.setText(a.i.endtext_follow);
            this.dHh.setText(a.i.follow);
            this.dHh.setTextColor(this.ceC.getResources().getColor(a.d.sdk_white_alpha100));
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.dHi.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                this.dHi.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            } else {
                this.dHi.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            }
        }
    }

    private void aKI() {
        this.dGV = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.dGW = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.dHl = this.mView.findViewById(a.g.change_layout);
        this.dGZ = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.dHa = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.dHb = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.dHd = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.dHe = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.dHf = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.dGX = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.dGY = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.dHc = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.dHg = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void mA(int i) {
        this.dGV.setVisibility(i);
        this.dGW.setVisibility(i);
    }

    public void M(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            mA(8);
        } else if (this.aaj != null) {
            if (this.aaj.mLiveInfo == null || this.aaj.mLiveInfo.mLiveCloseData == null) {
                mA(0);
                boolean z = arrayList.size() > 2;
                this.dHp = arrayList;
                this.dHo = 0;
                a(this.dHo, arrayList.get(this.dHo), this.dHo + 1, arrayList.get(this.dHo + 1), z);
                this.dHo++;
                if (this.dHq == null) {
                    this.dHq = ValueAnimator.ofInt(100, 0);
                    this.dHq.setDuration(5000L);
                    this.dHq.setInterpolator(dGN);
                    this.dHq.setRepeatCount(-1);
                    this.dHq.setRepeatMode(1);
                    this.dHq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.b.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            b.this.dHc.setProgress(intValue);
                            b.this.dHg.setProgress(intValue);
                        }
                    });
                    this.dHq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.endliveroom.b.5
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
                            b.this.aKJ();
                        }
                    });
                }
                if (z) {
                    this.dHq.start();
                    this.dHl.setVisibility(0);
                    this.dHl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.WE, b.this.otherParams);
                            b.this.dHq.cancel();
                            b.this.aKJ();
                            b.this.dHq.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKJ() {
        int i = this.dHo + 1;
        this.dHo = i;
        if (i >= this.dHp.size()) {
            this.dHo = 0;
            i = 0;
        }
        int i2 = this.dHo + 1;
        this.dHo = i2;
        if (i2 >= this.dHp.size()) {
            this.dHo = 0;
            i2 = 0;
        }
        this.dHo = i2;
        a(i, this.dHp.get(i), i2, this.dHp.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.dHr.contains(Long.valueOf(this.dHp.get(i).live_id))) {
            this.dHr.add(Long.valueOf(this.dHp.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.WE, this.dHp.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.dHr.contains(Long.valueOf(this.dHp.get(i2).live_id))) {
            this.dHr.add(Long.valueOf(this.dHp.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.WE, this.dHp.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.dGX, this.dGZ, this.dHa, this.dHb, this.dHc, alaLiveInfoData, z, i);
        a(this.dGY, this.dHd, this.dHe, this.dHf, this.dHg, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.WE, ((AlaLiveInfoData) b.this.dHp.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", b.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(b.this.ceC, a.i.sdk_no_network_guide);
                    } else if (b.this.dGO != null) {
                        b.this.dGO.b(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.ceC.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
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

    public ViewGroup aKK() {
        return this.dGV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKL() {
        View inflate;
        final Dialog dialog;
        if (this.ceC != null) {
            LayoutInflater from = LayoutInflater.from(this.ceC);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                inflate = from.inflate(a.h.dialog_follow_confirm_hk, (ViewGroup) null);
                dialog = new Dialog(this.ceC, a.j.PlayLevelDialog);
            } else {
                inflate = from.inflate(a.h.dialog_follow_confirm_qm, (ViewGroup) null);
                dialog = new Dialog(this.ceC, a.j.PopStyleActivity);
            }
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                dialog.getWindow().getAttributes().width = this.ceC.getResources().getDimensionPixelSize(a.e.sdk_ds630);
                dialog.getWindow().getAttributes().height = this.ceC.getResources().getDimensionPixelSize(a.e.sdk_ds300);
            } else {
                dialog.getWindow().getAttributes().width = getScreenWidth(this.ceC);
                dialog.getWindow().getAttributes().height = this.ceC.getResources().getDimensionPixelSize(a.e.sdk_ds324);
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
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.WE, b.this.otherParams);
                    b.this.dGO.gT(b.this.dHm);
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
        if (this.dGU != null) {
            this.dGU.cancel();
        }
        if (this.dGS != null) {
            this.dGS.cancelAnimation();
        }
        if (this.dGT != null) {
            this.dGT.cancelAnimation();
        }
        if (this.dHq != null) {
            this.dHq.cancel();
        }
    }
}
