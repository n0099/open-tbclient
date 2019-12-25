package com.baidu.tieba.ala.liveroom.challenge.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.y;
import com.baidu.live.data.z;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.g;
import com.baidu.live.utils.k;
/* loaded from: classes2.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener {
    private z ePd;
    private RelativeLayout eRK;
    private RelativeLayout eRL;
    private RelativeLayout eRM;
    private TbImageView eRN;
    private View eRO;
    private RelativeLayout eRP;
    private TbImageView eRQ;
    private View eRR;
    private RelativeLayout eRS;
    private LinearLayout eRT;
    private ImageView eRU;
    private TextView eRV;
    private FrameAnimationView eRW;
    private RelativeLayout eRX;
    private RelativeLayout eRY;
    private HeadImageView eRZ;
    private int eSA;
    private ValueAnimator eSB;
    private TextView eSa;
    private LinearLayout eSb;
    private ImageView eSc;
    private TextView eSd;
    private FrameAnimationView eSe;
    private LinearLayout eSf;
    private TextView eSg;
    private RelativeLayout eSh;
    private TextView eSi;
    private TextView eSj;
    private TextView eSk;
    private TextView eSl;
    private View eSm;
    private LinearLayout eSn;
    private TbImageView eSo;
    private LinearLayout eSp;
    private TbImageView eSq;
    private TextView eSr;
    private LinearLayout eSs;
    private TextView eSt;
    private TextView eSu;
    private ImageView eSv;
    private a eSw;
    private long eSx;
    private long eSy;
    private int eSz;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void b(z zVar);

        void biA();

        void biB();

        void c(z zVar);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.eSx = -1L;
        this.eSy = -1L;
        this.screenWidth = -1;
        this.eSz = 0;
        this.eSA = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.eSx = -1L;
        this.eSy = -1L;
        this.screenWidth = -1;
        this.eSz = 0;
        this.eSA = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.eSx = -1L;
        this.eSy = -1L;
        this.screenWidth = -1;
        this.eSz = 0;
        this.eSA = 0;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        initView(context);
        updateView();
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.eRK = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.eRM = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.eRN = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.eRP = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.eRQ = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.eRL = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.eRS = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.eRT = (LinearLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.eRU = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.eRV = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.eRW = (FrameAnimationView) this.rootView.findViewById(a.g.anchor_layout_anim_img);
        this.eRX = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.eRY = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.eRZ = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.eSa = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.eSb = (LinearLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.eSc = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.eSd = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.eSe = (FrameAnimationView) this.rootView.findViewById(a.g.rival_layout_anim_img);
        this.eSf = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.eSg = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.eSh = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.eSi = (TextView) this.rootView.findViewById(a.g.pk_anchor_label);
        this.eSk = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.eSl = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.eSj = (TextView) this.rootView.findViewById(a.g.pk_rival_label);
        this.eSn = (LinearLayout) this.rootView.findViewById(a.g.pk_adv_top_layout);
        this.eSo = (TbImageView) this.rootView.findViewById(a.g.top_adv_img);
        this.eSp = (LinearLayout) this.rootView.findViewById(a.g.pk_adv_bottom_layout);
        this.eSq = (TbImageView) this.rootView.findViewById(a.g.bottom_adv_img);
        this.eSr = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.eSs = (LinearLayout) this.rootView.findViewById(a.g.pk_all_in_layout);
        this.eSt = (TextView) this.rootView.findViewById(a.g.btn_pk_all_in);
        this.eSu = (TextView) this.rootView.findViewById(a.g.pk_all_in_countdown_txt);
        this.eSv = (ImageView) this.rootView.findViewById(a.g.pk_all_in_label);
        this.eSm = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.eRO = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.eRR = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.eRY.setVisibility(0);
        this.eRY.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.eRZ.setIsRound(true);
        this.eRZ.setAutoChangeStyle(false);
        this.eRZ.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.eRZ.setIsNight(false);
        this.eRX.setOnClickListener(this);
        this.eRY.setOnClickListener(this);
        this.eSr.setOnClickListener(this);
        this.eSt.setOnClickListener(this);
    }

    private void updateView() {
        this.eSA = g.aG(this.mContext);
        this.eSz = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds64);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aJ = g.aJ(this.mContext);
        int aI = g.aI(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eSA;
        layoutParams.height = aI;
        this.eRL.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(aJ, aI);
        layoutParams2.addRule(9);
        this.eRS.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(aJ, aI);
        layoutParams3.addRule(11);
        this.eRX.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(aJ, aI);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = this.eSA;
        this.eRP.setLayoutParams(layoutParams4);
        int i = aI - dimensionPixelSize;
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.eSv.getLayoutParams();
        layoutParams5.topMargin = i;
        layoutParams5.addRule(14);
        this.eSv.setLayoutParams(layoutParams5);
        this.eSv.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.eSs.getLayoutParams();
        int i2 = aI - dimensionPixelSize2;
        float[] physicalScreenSize = k.getPhysicalScreenSize(getContext());
        if (physicalScreenSize != null && physicalScreenSize.length == 2 && physicalScreenSize[1] != 0.0f && physicalScreenSize[0] / physicalScreenSize[1] > 0.59f) {
            i2 -= dimensionPixelSize2 + getContext().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        layoutParams6.topMargin = i2;
        layoutParams6.addRule(14);
        this.eSs.setLayoutParams(layoutParams6);
        setAllInBtnVisible(false);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.eSf.getLayoutParams();
        layoutParams7.topMargin = this.eSA;
        layoutParams7.addRule(14);
        this.eSf.setLayoutParams(layoutParams7);
        this.eSh.setAlpha(0.0f);
        this.eSu.setVisibility(4);
    }

    public View getAnchorAnimLiveLayout() {
        return this.eRM;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.eRO;
    }

    public View getRivalAnimLiveLayout() {
        return this.eRP;
    }

    public View getRivalAnimLiveForeBg() {
        return this.eRR;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.eRN;
    }

    public void setAnchorUserViewBg(z zVar) {
        this.eRN.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (zVar.ZA != null) {
            str = zVar.ZA.portrait;
        }
        this.eRN.startLoad(str, 12, false);
        this.eRN.setVisibility(0);
    }

    public void setRivalUserViewBg(z zVar) {
        this.eRQ.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (zVar.ZA != null) {
            str = zVar.ZA.portrait;
        }
        this.eRQ.startLoad(str, 12, false);
    }

    public FrameAnimationView getAnchorLiveAllInAnimImg() {
        return this.eRW;
    }

    public FrameAnimationView getRivalLiveAllInAnimImg() {
        return this.eSe;
    }

    public View getLeftTimeView() {
        return this.eSf;
    }

    public ViewGroup getLiveContainerView() {
        return this.eRL;
    }

    public View getScoreProgressLayout() {
        return this.eSh;
    }

    public View getTopAdvViewLayout() {
        return this.eSn;
    }

    public View getBottomAdvViewLayout() {
        return this.eSp;
    }

    public View getCloseBtnView() {
        return this.eSr;
    }

    public RelativeLayout getContainerView() {
        return this.eRK;
    }

    public void a(y yVar, z zVar, z zVar2, boolean z) {
        this.ePd = zVar2;
        int i = yVar.Zo;
        long j = yVar.Zt - yVar.Zu;
        u(i, j);
        v(yVar.Zv, yVar.Zw);
        if (z) {
            a(zVar2);
            biz();
        }
        if (i == 2) {
            if (this.eSs.getVisibility() == 0 && j <= 120) {
                setAllInBtnVisible(false);
                BdUtilHelper.showToast(this.mContext, a.i.ala_challenge_reward_than_two_min_limit);
            }
            setCloseBtnVisible(true);
            biy();
        } else if (i == 3) {
            setCloseBtnVisible(false);
            setAllInBtnVisible(false);
            bk(yVar.challengeResult, yVar.Zx);
        } else {
            setCloseBtnVisible(false);
            setAllInBtnVisible(false);
            bk(yVar.challengeResult, yVar.Zx);
        }
    }

    private void u(int i, long j) {
        String formatSecondsTime = StringHelper.formatSecondsTime(j);
        String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
        if (i == 2) {
            string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
        } else if (i == 3) {
            string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
        } else if (i == 4) {
            string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
        }
        this.eSg.setText(string);
    }

    public void setAllInBtnVisible(boolean z) {
        this.eSs.setVisibility(4);
    }

    public void setAllInLabelVisible(boolean z) {
    }

    public void setAllInCountDownTextVisible(boolean z) {
        this.eSu.setVisibility(z ? 0 : 4);
    }

    public void setAllInCountDownText(String str) {
        this.eSu.setText(str);
    }

    public void setLiveContainerVisible(boolean z) {
        this.eRL.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.eSr.setVisibility(z ? 0 : 4);
        } else {
            this.eSr.setVisibility(4);
        }
    }

    public void bix() {
        setCloseBtnVisible(false);
        setAllInBtnVisible(false);
        setLiveContainerVisible(false);
        setAllInLabelVisible(false);
        setAllInCountDownTextVisible(false);
    }

    public void bk(int i, int i2) {
        this.eRT.setVisibility(0);
        this.eSb.setVisibility(0);
        this.eRV.setVisibility(4);
        this.eSd.setVisibility(4);
        if (1 == i) {
            this.eRU.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.eRV.setVisibility(0);
                this.eRV.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eRV.setText("");
            }
            this.eSc.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.eRU.setImageResource(a.f.icon_live_vs_draw);
            this.eSc.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.eRU.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.eSd.setVisibility(0);
                this.eSd.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eSd.setText("");
            }
            this.eSc.setImageResource(a.f.icon_live_vs_win);
        } else {
            biy();
        }
    }

    public void biy() {
        this.eRT.setVisibility(4);
        this.eSb.setVisibility(4);
    }

    private void v(long j, long j2) {
        int i;
        if (this.eSx != j || this.eSy != j2) {
            this.eSx = j;
            this.eSy = j2;
            this.eSk.setText(String.valueOf(this.eSx));
            this.eSl.setText(String.valueOf(this.eSy));
            float f = (float) (this.eSx + this.eSy);
            int i2 = this.screenWidth / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.eSx) / f) * this.screenWidth);
                int i4 = ((LinearLayout.LayoutParams) this.eSm.getLayoutParams()).width;
                if (i3 < this.eSz) {
                    i = this.eSz;
                } else {
                    i = i3 > this.screenWidth - this.eSz ? this.screenWidth - this.eSz : i3;
                }
                if (this.eSB != null) {
                    this.eSB.cancel();
                }
                this.eSB = ValueAnimator.ofInt(i4, i);
                this.eSB.setDuration(100L);
                this.eSB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.eSm.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.eSm.setLayoutParams(layoutParams);
                    }
                });
                this.eSB.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eSm.getLayoutParams();
            layoutParams.width = i2;
            this.eSm.setLayoutParams(layoutParams);
        }
    }

    public void a(z zVar) {
        if (zVar == null || zVar.ZA == null) {
            this.eRY.setVisibility(4);
            return;
        }
        this.eRY.setTag(zVar);
        this.eRZ.startLoad(zVar.ZA.portrait, 12, false, false);
        String str = zVar.ZA.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 12) {
            str = TextHelper.subStringWithEmoji(str, 12) + StringHelper.STRING_MORE;
        }
        this.eSa.setText(str);
    }

    public View getRivalUserInfoView() {
        return this.eRY;
    }

    private void biz() {
        this.eSn.setVisibility(0);
        this.eSo.setAutoChangeStyle(false);
        this.eSo.setIsNight(false);
        this.eSo.setIsRound(false);
        this.eSo.setDefaultBgResource(a.f.icon_live_vs_ad);
        this.eSo.setDefaultErrorResource(a.f.icon_live_vs_ad);
        this.eSo.startLoad(com.baidu.live.r.a.wA().arE.XZ, 10, false);
    }

    public void releaseResource() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eSr) {
            if (this.eSw != null) {
                this.eSw.biA();
            }
        } else if (view == this.eSt) {
            if (com.baidu.live.r.a.wA().arE.XX && this.eSw != null) {
                TiebaInitialize.log(new StatisticItem("c13052"));
                this.eSw.biB();
            }
        } else if (view == this.eRY) {
            if (this.eSw != null) {
                this.eSw.b((z) this.eRY.getTag());
            }
        } else if (view == this.eRX && this.eSw != null) {
            this.eSw.c(this.ePd);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.eSw = aVar;
    }
}
