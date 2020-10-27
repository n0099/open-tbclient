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
    private static final LinearInterpolator gvd = new LinearInterpolator();
    private w aEc;
    private String aUg;
    private Activity bIs;
    private TextView gvA;
    private View gvB;
    private boolean gvC;
    private boolean gvD;
    private int gvE;
    private ArrayList<AlaLiveInfoData> gvF;
    private ValueAnimator gvG;
    private Set<Long> gvH;
    private HttpMessageListener gvI;
    private a gve;
    private HeadImageView gvf;
    private TextView gvg;
    private ImageView gvh;
    private LottieAnimationView gvi;
    private LottieAnimationView gvj;
    private Animation gvk;
    private LinearLayout gvl;
    private LinearLayout gvm;
    private RelativeLayout gvn;
    private RelativeLayout gvo;
    private TbImageView gvp;
    private TextView gvq;
    private TextView gvr;
    private ProgressBar gvs;
    private TbImageView gvt;
    private TextView gvu;
    private TextView gvv;
    private ProgressBar gvw;
    private TextView gvx;
    private LinearLayout gvy;
    private TextView gvz;
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
        void Nm();

        void f(AlaLiveInfoData alaLiveInfoData);

        void lV(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gvC = false;
        this.mPortrait = "";
        this.gvD = false;
        this.gvE = 0;
        this.gvH = new HashSet();
        this.gvI = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).gvF;
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
                if (AlaLiveAudienceEndView.this.gve != null) {
                    AlaLiveAudienceEndView.this.gve.Nm();
                }
            }
        });
        this.gvh = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.gvi = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.gvi.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gvi.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.gvj = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.gvj.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gvj.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.gvf = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.gvf.setIsRound(true);
        this.gvf.setDrawBorder(true);
        this.gvf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gvf.setAutoChangeStyle(false);
        this.gvg = (TextView) this.mView.findViewById(a.g.user_name);
        this.gvA = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.gvy = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.gvx = (TextView) this.mView.findViewById(a.g.follow_label);
        this.gvy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aEc == null || AlaLiveAudienceEndView.this.aEc.mLiveInfo == null || AlaLiveAudienceEndView.this.aEc.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.gve != null) {
                        if (AlaLiveAudienceEndView.this.gvC) {
                            AlaLiveAudienceEndView.this.bPL();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aUg, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gve.lV(AlaLiveAudienceEndView.this.gvC);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aEc.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.bIs, AlaLiveAudienceEndView.this.aEc.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.gvz = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aEc != null && this.aEc.mLiveInfo != null && this.aEc.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aEc.mLiveInfo.mLiveCloseData.title)) {
                this.gvz.setText(a.i.live_over_name);
            } else {
                this.gvz.setText(this.aEc.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gvD) {
            this.gvz.setText(a.i.live_closed);
        } else {
            this.gvz.setText(a.i.live_over_name);
        }
        this.gvi.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.gvj.setVisibility(0);
                AlaLiveAudienceEndView.this.gvi.setVisibility(8);
                AlaLiveAudienceEndView.this.gvj.playAnimation();
            }
        });
        bPI();
        MessageManager.getInstance().registerListener(this.gvI);
    }

    public void setCallback(a aVar) {
        this.gve = aVar;
    }

    public void setData(TbPageContext tbPageContext, w wVar, boolean z, boolean z2, String str, String str2) {
        this.aEc = wVar;
        this.gvD = z;
        this.mTbPageContext = tbPageContext;
        this.bIs = tbPageContext.getPageActivity();
        this.aEc = wVar;
        this.mLiveInfo = wVar.mLiveInfo;
        this.gvC = z2;
        this.mPortrait = str;
        this.gvD = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aUg = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aUg == null || TextUtils.equals(this.aUg, "null")) {
            this.aUg = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gvh.setVisibility(4);
        } else {
            this.gvk = AnimationUtils.loadAnimation(this.bIs, a.C0195a.anim_endview_holo_rotate);
            this.gvh.startAnimation(this.gvk);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.gvf.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.gvf.startLoad(this.mPortrait, 12, false, false);
        }
        this.gvg.setText(this.aEc.aIe.userName);
        this.gvy.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aEc != null && this.aEc.mLiveInfo != null && this.aEc.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aEc.mLiveInfo.mLiveCloseData.title)) {
            this.gvz.setText(this.aEc.mLiveInfo.mLiveCloseData.title);
        } else if (this.gvD) {
            this.gvz.setText(a.i.live_closed);
        } else {
            this.gvz.setText(a.i.live_over_name);
        }
        this.gvi.setVisibility(0);
        this.gvi.playAnimation();
        lW(this.gvC);
    }

    public void lW(boolean z) {
        this.gvC = z;
        if (this.aEc != null && this.aEc.mLiveInfo != null && this.aEc.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aEc.mLiveInfo.mLiveCloseData.tips)) {
                this.gvA.setText("");
            } else {
                this.gvA.setText(this.aEc.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aEc.mLiveInfo.mLiveCloseData.actionText)) {
                this.gvy.setVisibility(8);
                this.gvx.setText("");
            } else {
                this.gvy.setVisibility(0);
                this.gvx.setText(this.aEc.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gvy.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    this.gvy.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.gvy.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_24_selector_bd);
                } else {
                    this.gvy.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_24_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gvy.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gvC) {
            this.gvA.setText(a.i.endtext_followed);
            this.gvx.setText(a.i.sdk_followed);
            this.gvx.setTextColor(this.bIs.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gvy.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_24_bd);
                return;
            } else {
                this.gvy.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_24_c);
                return;
            }
        }
        this.gvA.setText(a.i.endtext_follow);
        this.gvx.setText(a.i.follow);
        this.gvx.setTextColor(this.bIs.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gvy.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            this.gvy.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gvy.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_24_selector_bd);
        } else {
            this.gvy.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_24_n);
        }
    }

    private void bPI() {
        this.gvl = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.gvm = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.gvB = this.mView.findViewById(a.g.change_layout);
        this.gvp = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.gvq = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.gvr = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.gvt = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.gvu = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.gvv = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.gvn = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.gvo = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.gvs = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.gvw = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gvl.setVisibility(i);
        this.gvm.setVisibility(i);
    }

    public void bPJ() {
        d dVar = new d();
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aEc == null || (this.aEc.mLiveInfo != null && this.aEc.mLiveInfo.mLiveCloseData != null)) {
            setRecommendViewVisible(8);
        } else {
            setRecommendViewVisible(0);
            boolean z = arrayList.size() > 2;
            this.gvF = arrayList;
            this.gvE = 0;
            a(this.gvE, arrayList.get(this.gvE), this.gvE + 1, arrayList.get(this.gvE + 1), z);
            this.gvE++;
            if (this.gvG == null) {
                this.gvG = ValueAnimator.ofInt(100, 0);
                this.gvG.setDuration(5000L);
                this.gvG.setInterpolator(gvd);
                this.gvG.setRepeatCount(-1);
                this.gvG.setRepeatMode(1);
                this.gvG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.gvs.setProgress(intValue);
                        AlaLiveAudienceEndView.this.gvw.setProgress(intValue);
                    }
                });
                this.gvG.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bPK();
                    }
                });
            }
            if (z) {
                this.gvG.start();
                this.gvB.setVisibility(0);
                this.gvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aUg, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gvG.cancel();
                        AlaLiveAudienceEndView.this.bPK();
                        AlaLiveAudienceEndView.this.gvG.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPK() {
        int i = this.gvE + 1;
        this.gvE = i;
        if (i >= this.gvF.size()) {
            this.gvE = 0;
            i = 0;
        }
        int i2 = this.gvE + 1;
        this.gvE = i2;
        if (i2 >= this.gvF.size()) {
            this.gvE = 0;
            i2 = 0;
        }
        this.gvE = i2;
        a(i, this.gvF.get(i), i2, this.gvF.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.gvH.contains(Long.valueOf(this.gvF.get(i).live_id))) {
            this.gvH.add(Long.valueOf(this.gvF.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aUg, this.gvF.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.gvH.contains(Long.valueOf(this.gvF.get(i2).live_id))) {
            this.gvH.add(Long.valueOf(this.gvF.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aUg, this.gvF.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.gvn, this.gvp, this.gvq, this.gvr, this.gvs, alaLiveInfoData, z, i);
        a(this.gvo, this.gvt, this.gvu, this.gvv, this.gvw, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aUg, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.gvF.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.bIs, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.gve != null) {
                        AlaLiveAudienceEndView.this.gve.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.bIs.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.gvl;
    }

    public HeadImageView getPortraitImg() {
        return this.gvf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPL() {
        if (this.bIs != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.bIs);
            bdAlertDialog.setMessage(this.bIs.getResources().getString(a.i.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.i.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.10
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.i.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aUg, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.gve.lV(AlaLiveAudienceEndView.this.gvC);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.bIs.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.bIs.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
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
        MessageManager.getInstance().unRegisterListener(this.gvI);
        if (this.gvk != null) {
            this.gvk.cancel();
        }
        if (this.gvi != null) {
            this.gvi.cancelAnimation();
        }
        if (this.gvj != null) {
            this.gvj.cancelAnimation();
        }
        if (this.gvG != null) {
            this.gvG.cancel();
            this.gvG.removeAllUpdateListeners();
            this.gvG.removeAllListeners();
        }
    }
}
