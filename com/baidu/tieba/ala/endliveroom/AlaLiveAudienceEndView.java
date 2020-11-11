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
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator gAR = new LinearInterpolator();
    private w aES;
    private String aVy;
    private Activity bNY;
    private a gAS;
    private HeadImageView gAT;
    private TextView gAU;
    private ImageView gAV;
    private LottieAnimationView gAW;
    private LottieAnimationView gAX;
    private Animation gAY;
    private LinearLayout gAZ;
    private LinearLayout gBa;
    private RelativeLayout gBb;
    private RelativeLayout gBc;
    private TbImageView gBd;
    private TextView gBe;
    private TextView gBf;
    private ProgressBar gBg;
    private TbImageView gBh;
    private TextView gBi;
    private TextView gBj;
    private ProgressBar gBk;
    private TextView gBl;
    private LinearLayout gBm;
    private TextView gBn;
    private TextView gBo;
    private View gBp;
    private boolean gBq;
    private boolean gBr;
    private int gBs;
    private ArrayList<AlaLiveInfoData> gBt;
    private ValueAnimator gBu;
    private Set<Long> gBv;
    private HttpMessageListener gBw;
    private String liveId;
    private ImageView mCloseBtn;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private String otherParams;
    private String roomId;

    /* loaded from: classes4.dex */
    public interface a {
        void NM();

        void f(AlaLiveInfoData alaLiveInfoData);

        void me(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gBq = false;
        this.mPortrait = "";
        this.gBr = false;
        this.gBs = 0;
        this.gBv = new HashSet();
        this.gBw = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).gBt;
                }
                AlaLiveAudienceEndView.this.ac(arrayList);
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
                if (AlaLiveAudienceEndView.this.gAS != null) {
                    AlaLiveAudienceEndView.this.gAS.NM();
                }
            }
        });
        this.gAV = (ImageView) this.mView.findViewById(a.f.headHalo_imageView);
        this.gAW = (LottieAnimationView) this.mView.findViewById(a.f.flowerAppear_lottieAnimationView);
        this.gAW.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gAW.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.gAX = (LottieAnimationView) this.mView.findViewById(a.f.flowerDrop_lottieAnimationView);
        this.gAX.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gAX.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.gAT = (HeadImageView) this.mView.findViewById(a.f.avatar_img);
        this.gAT.setIsRound(true);
        this.gAT.setDrawBorder(true);
        this.gAT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gAT.setAutoChangeStyle(false);
        this.gAU = (TextView) this.mView.findViewById(a.f.user_name);
        this.gBo = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.gBm = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gBl = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gBm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aES == null || AlaLiveAudienceEndView.this.aES.mLiveInfo == null || AlaLiveAudienceEndView.this.aES.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.gAS != null) {
                        if (AlaLiveAudienceEndView.this.gBq) {
                            AlaLiveAudienceEndView.this.bSl();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aVy, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gAS.me(AlaLiveAudienceEndView.this.gBq);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aES.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.bNY, AlaLiveAudienceEndView.this.aES.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.gBn = (TextView) this.mView.findViewById(a.f.live_over_name);
        if (this.aES != null && this.aES.mLiveInfo != null && this.aES.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aES.mLiveInfo.mLiveCloseData.title)) {
                this.gBn.setText(a.h.live_over_name);
            } else {
                this.gBn.setText(this.aES.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gBr) {
            this.gBn.setText(a.h.live_closed);
        } else {
            this.gBn.setText(a.h.live_over_name);
        }
        this.gAW.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.gAX.setVisibility(0);
                AlaLiveAudienceEndView.this.gAW.setVisibility(8);
                AlaLiveAudienceEndView.this.gAX.playAnimation();
            }
        });
        bSi();
        MessageManager.getInstance().registerListener(this.gBw);
    }

    public void setCallback(a aVar) {
        this.gAS = aVar;
    }

    public void setData(TbPageContext tbPageContext, w wVar, boolean z, boolean z2, String str, String str2) {
        this.aES = wVar;
        this.gBr = z;
        this.mTbPageContext = tbPageContext;
        this.bNY = tbPageContext.getPageActivity();
        this.aES = wVar;
        this.mLiveInfo = wVar.mLiveInfo;
        this.gBq = z2;
        this.mPortrait = str;
        this.gBr = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aVy = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aVy == null || TextUtils.equals(this.aVy, "null")) {
            this.aVy = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gAV.setVisibility(4);
        } else {
            this.gAY = AnimationUtils.loadAnimation(this.bNY, a.C0197a.anim_endview_holo_rotate);
            this.gAV.startAnimation(this.gAY);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.gAT.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.gAT.startLoad(this.mPortrait, 12, false, false);
        }
        this.gAU.setText(this.aES.aIV.userName);
        this.gBm.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aES != null && this.aES.mLiveInfo != null && this.aES.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aES.mLiveInfo.mLiveCloseData.title)) {
            this.gBn.setText(this.aES.mLiveInfo.mLiveCloseData.title);
        } else if (this.gBr) {
            this.gBn.setText(a.h.live_closed);
        } else {
            this.gBn.setText(a.h.live_over_name);
        }
        this.gAW.setVisibility(0);
        this.gAW.playAnimation();
        mf(this.gBq);
    }

    public void mf(boolean z) {
        this.gBq = z;
        if (this.aES != null && this.aES.mLiveInfo != null && this.aES.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aES.mLiveInfo.mLiveCloseData.tips)) {
                this.gBo.setText("");
            } else {
                this.gBo.setText(this.aES.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aES.mLiveInfo.mLiveCloseData.actionText)) {
                this.gBm.setVisibility(8);
                this.gBl.setText("");
            } else {
                this.gBm.setVisibility(0);
                this.gBl.setText(this.aES.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gBm.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    this.gBm.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gBm.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_24_selector_bd);
                } else {
                    this.gBm.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gBm.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gBq) {
            this.gBo.setText(a.h.endtext_followed);
            this.gBl.setText(a.h.sdk_followed);
            this.gBl.setTextColor(this.bNY.getResources().getColor(a.c.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gBm.setBackgroundResource(a.e.sdk_round_btn_gray_border_bg_radius_24_bd);
                return;
            } else {
                this.gBm.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_c);
                return;
            }
        }
        this.gBo.setText(a.h.endtext_follow);
        this.gBl.setText(a.h.follow);
        this.gBl.setTextColor(this.bNY.getResources().getColor(a.c.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gBm.setBackgroundResource(a.e.sdk_round_btn_hk_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            this.gBm.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gBm.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_24_selector_bd);
        } else {
            this.gBm.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_24_n);
        }
    }

    private void bSi() {
        this.gAZ = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gBa = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gBp = this.mView.findViewById(a.f.change_layout);
        this.gBd = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gBe = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gBf = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.gBh = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gBi = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gBj = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.gBb = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gBc = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gBg = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gBk = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gAZ.setVisibility(i);
        this.gBa.setVisibility(i);
    }

    public void bSj() {
        d dVar = new d();
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aES == null || (this.aES.mLiveInfo != null && this.aES.mLiveInfo.mLiveCloseData != null)) {
            setRecommendViewVisible(8);
        } else {
            setRecommendViewVisible(0);
            boolean z = arrayList.size() > 2;
            this.gBt = arrayList;
            this.gBs = 0;
            a(this.gBs, arrayList.get(this.gBs), this.gBs + 1, arrayList.get(this.gBs + 1), z);
            this.gBs++;
            if (this.gBu == null) {
                this.gBu = ValueAnimator.ofInt(100, 0);
                this.gBu.setDuration(5000L);
                this.gBu.setInterpolator(gAR);
                this.gBu.setRepeatCount(-1);
                this.gBu.setRepeatMode(1);
                this.gBu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.gBg.setProgress(intValue);
                        AlaLiveAudienceEndView.this.gBk.setProgress(intValue);
                    }
                });
                this.gBu.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bSk();
                    }
                });
            }
            if (z) {
                this.gBu.start();
                this.gBp.setVisibility(0);
                this.gBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aVy, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gBu.cancel();
                        AlaLiveAudienceEndView.this.bSk();
                        AlaLiveAudienceEndView.this.gBu.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSk() {
        int i = this.gBs + 1;
        this.gBs = i;
        if (i >= this.gBt.size()) {
            this.gBs = 0;
            i = 0;
        }
        int i2 = this.gBs + 1;
        this.gBs = i2;
        if (i2 >= this.gBt.size()) {
            this.gBs = 0;
            i2 = 0;
        }
        this.gBs = i2;
        a(i, this.gBt.get(i), i2, this.gBt.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.gBv.contains(Long.valueOf(this.gBt.get(i).live_id))) {
            this.gBv.add(Long.valueOf(this.gBt.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aVy, this.gBt.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.gBv.contains(Long.valueOf(this.gBt.get(i2).live_id))) {
            this.gBv.add(Long.valueOf(this.gBt.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aVy, this.gBt.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.gBb, this.gBd, this.gBe, this.gBf, this.gBg, alaLiveInfoData, z, i);
        a(this.gBc, this.gBh, this.gBi, this.gBj, this.gBk, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aVy, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.gBt.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.bNY, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.gAS != null) {
                        AlaLiveAudienceEndView.this.gAS.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.bNY.getString(a.h.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.gAZ;
    }

    public HeadImageView getPortraitImg() {
        return this.gAT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSl() {
        if (this.bNY != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.bNY);
            bdAlertDialog.setMessage(this.bNY.getResources().getString(a.h.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.h.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.10
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.h.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aVy, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.gAS.me(AlaLiveAudienceEndView.this.gBq);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.bNY.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.bNY.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
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
        MessageManager.getInstance().unRegisterListener(this.gBw);
        if (this.gAY != null) {
            this.gAY.cancel();
        }
        if (this.gAW != null) {
            this.gAW.cancelAnimation();
        }
        if (this.gAX != null) {
            this.gAX.cancelAnimation();
        }
        if (this.gBu != null) {
            this.gBu.cancel();
            this.gBu.removeAllUpdateListeners();
            this.gBu.removeAllListeners();
        }
    }
}
