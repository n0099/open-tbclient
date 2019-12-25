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
import com.baidu.live.data.k;
import com.baidu.live.q.a;
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
    private static final LinearInterpolator euZ = new LinearInterpolator();
    private String aej;
    private k aio;
    private ArrayList<AlaLiveInfoData> evB;
    private ValueAnimator evC;
    private a eva;
    private HeadImageView evb;
    private TextView evc;
    private ImageView evd;
    private LottieAnimationView eve;
    private LottieAnimationView evf;
    private Animation evg;
    private LinearLayout evh;
    private LinearLayout evi;
    private RelativeLayout evj;
    private RelativeLayout evk;
    private TbImageView evl;
    private TextView evm;
    private TextView evn;
    private ProgressBar evo;
    private TbImageView evp;
    private TextView evq;
    private TextView evr;
    private ProgressBar evs;
    private TextView evt;
    private LinearLayout evu;
    private TextView evv;
    private TextView evw;
    private View evx;
    private boolean evy;
    private boolean evz;
    private String liveId;
    private ImageView mCloseBtn;
    private Activity mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private String otherParams;
    private String roomId;
    private int evA = 0;
    private Set<Long> evD = new HashSet();

    /* loaded from: classes2.dex */
    public interface a {
        void b(AlaLiveInfoData alaLiveInfoData);

        void bbT();

        void ia(boolean z);
    }

    public b(TbPageContext tbPageContext, k kVar, boolean z, String str, boolean z2, a aVar, String str2) {
        this.evy = false;
        this.mPortrait = "";
        this.evz = false;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aio = kVar;
        this.mLiveInfo = kVar.mLiveInfo;
        this.eva = aVar;
        this.evy = z;
        this.mPortrait = str;
        this.evz = z2;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aej = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aej == null || TextUtils.equals(this.aej, "null")) {
            this.aej = "";
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
                if (b.this.eva != null) {
                    b.this.eva.bbT();
                }
            }
        });
        this.evd = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.eve = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.eve.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.eve.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.evf = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.evf.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.evf.setAnimation("anim_endview_head_flower_loop.json");
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.evd.setVisibility(4);
        } else {
            this.evg = AnimationUtils.loadAnimation(this.mContext, a.C0086a.anim_endview_holo_rotate);
            this.evd.startAnimation(this.evg);
        }
        this.evb = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.evb.setIsRound(true);
        this.evb.setDrawBorder(true);
        this.evb.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.evb.setAutoChangeStyle(false);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.evb.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.evb.startLoad(this.mPortrait, 12, false, false);
        }
        this.evc = (TextView) this.mView.findViewById(a.g.user_name);
        this.evc.setText(this.aio.VP.userName);
        this.evw = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.evu = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.evt = (TextView) this.mView.findViewById(a.g.follow_label);
        this.evu.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        this.evu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.aio == null || b.this.aio.mLiveInfo == null || b.this.aio.mLiveInfo.mLiveCloseData == null) {
                    if (b.this.eva != null) {
                        if (b.this.evy) {
                            b.this.bbX();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.aej, b.this.otherParams);
                        b.this.eva.ia(b.this.evy);
                    }
                } else if (!TextUtils.isEmpty(b.this.aio.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(b.this.mContext, b.this.aio.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.evv = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aio != null && this.aio.mLiveInfo != null && this.aio.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aio.mLiveInfo.mLiveCloseData.title)) {
            this.evv.setText(this.aio.mLiveInfo.mLiveCloseData.title);
        } else if (this.evz) {
            this.evv.setText(a.i.live_closed);
        } else {
            this.evv.setText(a.i.live_over_name);
        }
        this.eve.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.endliveroom.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.evf.setVisibility(0);
                b.this.eve.setVisibility(8);
                b.this.evf.playAnimation();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eve.setVisibility(0);
        this.eve.playAnimation();
        bbU();
        ib(this.evy);
    }

    public void ib(boolean z) {
        this.evy = z;
        if (this.aio != null && this.aio.mLiveInfo != null && this.aio.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aio.mLiveInfo.mLiveCloseData.tips) && !TextUtils.isEmpty(this.aio.mLiveInfo.mLiveCloseData.actionText)) {
            this.evw.setText(this.aio.mLiveInfo.mLiveCloseData.tips);
            this.evt.setText(this.aio.mLiveInfo.mLiveCloseData.actionText);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.evu.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                this.evu.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.evu.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
            } else {
                this.evu.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            }
            oQ(8);
        } else if (this.evy) {
            this.evw.setText(a.i.endtext_followed);
            this.evt.setText(a.i.sdk_followed);
            this.evt.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.evu.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_12_bd);
            } else {
                this.evu.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_c);
            }
        } else {
            this.evw.setText(a.i.endtext_follow);
            this.evt.setText(a.i.follow);
            this.evt.setTextColor(this.mContext.getResources().getColor(a.d.sdk_white_alpha100));
            if (TbadkCoreApplication.getInst().isHaokan()) {
                this.evu.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_12_n);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                this.evu.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.evu.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
            } else {
                this.evu.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_n);
            }
        }
    }

    private void bbU() {
        this.evh = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.evi = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.evx = this.mView.findViewById(a.g.change_layout);
        this.evl = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.evm = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.evn = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.evp = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.evq = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.evr = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.evj = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.evk = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.evo = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.evs = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void oQ(int i) {
        this.evh.setVisibility(i);
        this.evi.setVisibility(i);
    }

    public void S(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            oQ(8);
        } else if (this.aio != null) {
            if (this.aio.mLiveInfo == null || this.aio.mLiveInfo.mLiveCloseData == null) {
                oQ(0);
                boolean z = arrayList.size() > 2;
                this.evB = arrayList;
                this.evA = 0;
                a(this.evA, arrayList.get(this.evA), this.evA + 1, arrayList.get(this.evA + 1), z);
                this.evA++;
                if (this.evC == null) {
                    this.evC = ValueAnimator.ofInt(100, 0);
                    this.evC.setDuration(5000L);
                    this.evC.setInterpolator(euZ);
                    this.evC.setRepeatCount(-1);
                    this.evC.setRepeatMode(1);
                    this.evC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.b.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            b.this.evo.setProgress(intValue);
                            b.this.evs.setProgress(intValue);
                        }
                    });
                    this.evC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.endliveroom.b.5
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
                            b.this.bbV();
                        }
                    });
                }
                if (z) {
                    this.evC.start();
                    this.evx.setVisibility(0);
                    this.evx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.b.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.aej, b.this.otherParams);
                            b.this.evC.cancel();
                            b.this.bbV();
                            b.this.evC.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbV() {
        int i = this.evA + 1;
        this.evA = i;
        if (i >= this.evB.size()) {
            this.evA = 0;
            i = 0;
        }
        int i2 = this.evA + 1;
        this.evA = i2;
        if (i2 >= this.evB.size()) {
            this.evA = 0;
            i2 = 0;
        }
        this.evA = i2;
        a(i, this.evB.get(i), i2, this.evB.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.evD.contains(Long.valueOf(this.evB.get(i).live_id))) {
            this.evD.add(Long.valueOf(this.evB.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aej, this.evB.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.evD.contains(Long.valueOf(this.evB.get(i2).live_id))) {
            this.evD.add(Long.valueOf(this.evB.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aej, this.evB.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.evj, this.evl, this.evm, this.evn, this.evo, alaLiveInfoData, z, i);
        a(this.evk, this.evp, this.evq, this.evr, this.evs, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.aej, ((AlaLiveInfoData) b.this.evB.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", b.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(b.this.mContext, a.i.sdk_no_network_guide);
                    } else if (b.this.eva != null) {
                        b.this.eva.b(alaLiveInfoData);
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

    public ViewGroup bbW() {
        return this.evh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbX() {
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
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(b.this.liveId, b.this.roomId, b.this.aej, b.this.otherParams);
                    b.this.eva.ia(b.this.evy);
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
        if (this.evg != null) {
            this.evg.cancel();
        }
        if (this.eve != null) {
            this.eve.cancelAnimation();
        }
        if (this.evf != null) {
            this.evf.cancelAnimation();
        }
        if (this.evC != null) {
            this.evC.cancel();
        }
    }
}
