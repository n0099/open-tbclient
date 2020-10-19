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
import com.baidu.live.data.u;
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
    private static final LinearInterpolator gkY = new LinearInterpolator();
    private u aDU;
    private String aTk;
    private Activity bFt;
    private a gkZ;
    private ArrayList<AlaLiveInfoData> glA;
    private ValueAnimator glB;
    private Set<Long> glC;
    private HttpMessageListener glD;
    private HeadImageView gla;
    private TextView glb;
    private ImageView glc;
    private LottieAnimationView gld;
    private LottieAnimationView gle;
    private Animation glf;
    private LinearLayout glg;
    private LinearLayout glh;
    private RelativeLayout gli;
    private RelativeLayout glj;
    private TbImageView glk;
    private TextView gll;
    private TextView glm;
    private ProgressBar gln;
    private TbImageView glo;
    private TextView glp;
    private TextView glq;
    private ProgressBar glr;
    private TextView gls;
    private LinearLayout glt;
    private TextView glu;
    private TextView glv;
    private View glw;
    private boolean glx;
    private boolean gly;
    private int glz;
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
        void MS();

        void f(AlaLiveInfoData alaLiveInfoData);

        void lF(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.glx = false;
        this.mPortrait = "";
        this.gly = false;
        this.glz = 0;
        this.glC = new HashSet();
        this.glD = new HttpMessageListener(1021207) { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                ArrayList<AlaLiveInfoData> arrayList = null;
                if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ClosePageRecHttpResponseMessage)) {
                    arrayList = ((ClosePageRecHttpResponseMessage) httpResponsedMessage).glA;
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
                if (AlaLiveAudienceEndView.this.gkZ != null) {
                    AlaLiveAudienceEndView.this.gkZ.MS();
                }
            }
        });
        this.glc = (ImageView) this.mView.findViewById(a.g.headHalo_imageView);
        this.gld = (LottieAnimationView) this.mView.findViewById(a.g.flowerAppear_lottieAnimationView);
        this.gld.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gld.setAnimation("anim_endview_head_flower_appear.json");
        }
        this.gle = (LottieAnimationView) this.mView.findViewById(a.g.flowerDrop_lottieAnimationView);
        this.gle.loop(false);
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gle.setAnimation("anim_endview_head_flower_loop.json");
        }
        this.gla = (HeadImageView) this.mView.findViewById(a.g.avatar_img);
        this.gla.setIsRound(true);
        this.gla.setDrawBorder(true);
        this.gla.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gla.setAutoChangeStyle(false);
        this.glb = (TextView) this.mView.findViewById(a.g.user_name);
        this.glv = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.glt = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.gls = (TextView) this.mView.findViewById(a.g.follow_label);
        this.glt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aDU == null || AlaLiveAudienceEndView.this.aDU.mLiveInfo == null || AlaLiveAudienceEndView.this.aDU.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.gkZ != null) {
                        if (AlaLiveAudienceEndView.this.glx) {
                            AlaLiveAudienceEndView.this.bNg();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTk, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.gkZ.lF(AlaLiveAudienceEndView.this.glx);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aDU.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.bFt, AlaLiveAudienceEndView.this.aDU.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
        this.glu = (TextView) this.mView.findViewById(a.g.live_over_name);
        if (this.aDU != null && this.aDU.mLiveInfo != null && this.aDU.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDU.mLiveInfo.mLiveCloseData.title)) {
                this.glu.setText(a.i.live_over_name);
            } else {
                this.glu.setText(this.aDU.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gly) {
            this.glu.setText(a.i.live_closed);
        } else {
            this.glu.setText(a.i.live_over_name);
        }
        this.gld.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaLiveAudienceEndView.this.gle.setVisibility(0);
                AlaLiveAudienceEndView.this.gld.setVisibility(8);
                AlaLiveAudienceEndView.this.gle.playAnimation();
            }
        });
        bNd();
        MessageManager.getInstance().registerListener(this.glD);
    }

    public void setCallback(a aVar) {
        this.gkZ = aVar;
    }

    public void setData(TbPageContext tbPageContext, u uVar, boolean z, boolean z2, String str, String str2) {
        this.aDU = uVar;
        this.gly = z;
        this.mTbPageContext = tbPageContext;
        this.bFt = tbPageContext.getPageActivity();
        this.aDU = uVar;
        this.mLiveInfo = uVar.mLiveInfo;
        this.glx = z2;
        this.mPortrait = str;
        this.gly = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aTk = this.mLiveInfo.feed_id;
        this.otherParams = str2;
        if (this.aTk == null || TextUtils.equals(this.aTk, "null")) {
            this.aTk = "";
        }
        if (this.otherParams == null || TextUtils.equals(this.otherParams, "null")) {
            this.otherParams = "";
        }
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.glc.setVisibility(4);
        } else {
            this.glf = AnimationUtils.loadAnimation(this.bFt, a.C0194a.anim_endview_holo_rotate);
            this.glc.startAnimation(this.glf);
        }
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.gla.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.gla.startLoad(this.mPortrait, 12, false, false);
        }
        this.glb.setText(this.aDU.aHD.userName);
        this.glt.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aDU != null && this.aDU.mLiveInfo != null && this.aDU.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aDU.mLiveInfo.mLiveCloseData.title)) {
            this.glu.setText(this.aDU.mLiveInfo.mLiveCloseData.title);
        } else if (this.gly) {
            this.glu.setText(a.i.live_closed);
        } else {
            this.glu.setText(a.i.live_over_name);
        }
        this.gld.setVisibility(0);
        this.gld.playAnimation();
        lG(this.glx);
    }

    public void lG(boolean z) {
        this.glx = z;
        if (this.aDU != null && this.aDU.mLiveInfo != null && this.aDU.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDU.mLiveInfo.mLiveCloseData.tips)) {
                this.glv.setText("");
            } else {
                this.glv.setText(this.aDU.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aDU.mLiveInfo.mLiveCloseData.actionText)) {
                this.glt.setVisibility(8);
                this.gls.setText("");
            } else {
                this.glt.setVisibility(0);
                this.gls.setText(this.aDU.mLiveInfo.mLiveCloseData.actionText);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.glt.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    this.glt.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_24_n);
                } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    this.glt.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_24_selector_bd);
                } else {
                    this.glt.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_24_n);
                }
            }
            setRecommendViewVisible(8);
            return;
        }
        this.glt.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.glx) {
            this.glv.setText(a.i.endtext_followed);
            this.gls.setText(a.i.sdk_followed);
            this.gls.setTextColor(this.bFt.getResources().getColor(a.d.sdk_white_alpha60));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.glt.setBackgroundResource(a.f.sdk_round_btn_gray_border_bg_radius_24_bd);
                return;
            } else {
                this.glt.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_24_c);
                return;
            }
        }
        this.glv.setText(a.i.endtext_follow);
        this.gls.setText(a.i.follow);
        this.gls.setTextColor(this.bFt.getResources().getColor(a.d.sdk_white_alpha100));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.glt.setBackgroundResource(a.f.sdk_round_btn_hk_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            this.glt.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_24_n);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.glt.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_24_selector_bd);
        } else {
            this.glt.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_24_n);
        }
    }

    private void bNd() {
        this.glg = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.glh = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.glw = this.mView.findViewById(a.g.change_layout);
        this.glk = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.gll = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.glm = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.glo = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.glp = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.glq = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.gli = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.glj = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.gln = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.glr = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.glg.setVisibility(i);
        this.glh.setVisibility(i);
    }

    public void bNe() {
        d dVar = new d();
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aDU == null || (this.aDU.mLiveInfo != null && this.aDU.mLiveInfo.mLiveCloseData != null)) {
            setRecommendViewVisible(8);
        } else {
            setRecommendViewVisible(0);
            boolean z = arrayList.size() > 2;
            this.glA = arrayList;
            this.glz = 0;
            a(this.glz, arrayList.get(this.glz), this.glz + 1, arrayList.get(this.glz + 1), z);
            this.glz++;
            if (this.glB == null) {
                this.glB = ValueAnimator.ofInt(100, 0);
                this.glB.setDuration(5000L);
                this.glB.setInterpolator(gkY);
                this.glB.setRepeatCount(-1);
                this.glB.setRepeatMode(1);
                this.glB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.6
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaLiveAudienceEndView.this.gln.setProgress(intValue);
                        AlaLiveAudienceEndView.this.glr.setProgress(intValue);
                    }
                });
                this.glB.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        AlaLiveAudienceEndView.this.bNf();
                    }
                });
            }
            if (z) {
                this.glB.start();
                this.glw.setVisibility(0);
                this.glw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTk, AlaLiveAudienceEndView.this.otherParams);
                        AlaLiveAudienceEndView.this.glB.cancel();
                        AlaLiveAudienceEndView.this.bNf();
                        AlaLiveAudienceEndView.this.glB.start();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNf() {
        int i = this.glz + 1;
        this.glz = i;
        if (i >= this.glA.size()) {
            this.glz = 0;
            i = 0;
        }
        int i2 = this.glz + 1;
        this.glz = i2;
        if (i2 >= this.glA.size()) {
            this.glz = 0;
            i2 = 0;
        }
        this.glz = i2;
        a(i, this.glA.get(i), i2, this.glA.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        if (!this.glC.contains(Long.valueOf(this.glA.get(i).live_id))) {
            this.glC.add(Long.valueOf(this.glA.get(i).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aTk, this.glA.get(i).getNameShow(), (i + 1) + "", (i + 1) + "", this.otherParams);
        }
        if (!this.glC.contains(Long.valueOf(this.glA.get(i2).live_id))) {
            this.glC.add(Long.valueOf(this.glA.get(i2).live_id));
            LogManager.getLiveCloseLogger().doShowRecommendLiveCloseGuestLog(this.liveId, this.roomId, this.aTk, this.glA.get(i2).getNameShow(), (i2 + 1) + "", (i2 + 1) + "", this.otherParams);
        }
        a(this.gli, this.glk, this.gll, this.glm, this.gln, alaLiveInfoData, z, i);
        a(this.glj, this.glo, this.glp, this.glq, this.glr, alaLiveInfoData2, z, i2);
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
                    LogManager.getLiveCloseLogger().doReadRecommendLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTk, ((AlaLiveInfoData) AlaLiveAudienceEndView.this.glA.get(i)).getNameShow(), (i + 1) + "", (i + 1) + "", AlaLiveAudienceEndView.this.otherParams);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.bFt, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.gkZ != null) {
                        AlaLiveAudienceEndView.this.gkZ.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.getNameShow());
            textView2.setText(this.bFt.getString(a.i.ala_live_audience_count, new Object[]{StringHelper.numberUniformFormat(alaLiveInfoData.audience_count)}));
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.glg;
    }

    public HeadImageView getPortraitImg() {
        return this.gla;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNg() {
        if (this.bFt != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.bFt);
            bdAlertDialog.setMessage(this.bFt.getResources().getString(a.i.ala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setPositiveButton(a.i.ala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.10
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(a.i.ala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.endliveroom.AlaLiveAudienceEndView.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTk, AlaLiveAudienceEndView.this.otherParams);
                    AlaLiveAudienceEndView.this.gkZ.lF(AlaLiveAudienceEndView.this.glx);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.bFt.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.bFt.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
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
        MessageManager.getInstance().unRegisterListener(this.glD);
        if (this.glf != null) {
            this.glf.cancel();
        }
        if (this.gld != null) {
            this.gld.cancelAnimation();
        }
        if (this.gle != null) {
            this.gle.cancelAnimation();
        }
        if (this.glB != null) {
            this.glB.cancel();
            this.glB.removeAllUpdateListeners();
            this.glB.removeAllListeners();
        }
    }
}
