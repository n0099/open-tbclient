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
import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.f;
import com.baidu.live.utils.j;
/* loaded from: classes6.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener {
    private w dZg;
    private RelativeLayout ebP;
    private RelativeLayout ebQ;
    private RelativeLayout ebR;
    private RelativeLayout ebS;
    private TbImageView ebT;
    private View ebU;
    private RelativeLayout ebV;
    private TbImageView ebW;
    private View ebX;
    private RelativeLayout ebY;
    private LinearLayout ebZ;
    private TextView ecA;
    private ImageView ecB;
    private a ecC;
    private long ecD;
    private long ecE;
    private int ecF;
    private int ecG;
    private ValueAnimator ecH;
    private ImageView eca;
    private TextView ecb;
    private FrameAnimationView ecc;
    private RelativeLayout ecd;
    private RelativeLayout ece;
    private HeadImageView ecf;
    private TextView ecg;
    private LinearLayout ech;
    private ImageView eci;
    private TextView ecj;
    private FrameAnimationView eck;
    private LinearLayout ecl;
    private TextView ecm;
    private RelativeLayout ecn;
    private TextView eco;
    private TextView ecp;
    private TextView ecq;
    private TextView ecr;
    private View ecs;
    private LinearLayout ect;
    private TbImageView ecu;
    private LinearLayout ecv;
    private TbImageView ecw;
    private TextView ecx;
    private LinearLayout ecy;
    private TextView ecz;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private int screenWidth;

    /* loaded from: classes6.dex */
    public interface a {
        void aQW();

        void aQX();

        void b(w wVar);

        void c(w wVar);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.ecD = -1L;
        this.ecE = -1L;
        this.screenWidth = -1;
        this.ecF = 0;
        this.ecG = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.ecD = -1L;
        this.ecE = -1L;
        this.screenWidth = -1;
        this.ecF = 0;
        this.ecG = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.ecD = -1L;
        this.ecE = -1L;
        this.screenWidth = -1;
        this.ecF = 0;
        this.ecG = 0;
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
        this.ebP = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.ebQ = (RelativeLayout) this.ebP.findViewById(a.g.root_container);
        this.ebS = (RelativeLayout) this.ebP.findViewById(a.g.anchor_live_anim_layout);
        this.ebT = (TbImageView) this.ebP.findViewById(a.g.anchor_live_anim_bg);
        this.ebV = (RelativeLayout) this.ebP.findViewById(a.g.rival_live_anim_layout);
        this.ebW = (TbImageView) this.ebP.findViewById(a.g.rival_live_anim_bg);
        this.ebR = (RelativeLayout) this.ebP.findViewById(a.g.pk_live_container);
        this.ebY = (RelativeLayout) this.ebP.findViewById(a.g.pk_anchor_live_layout);
        this.ebZ = (LinearLayout) this.ebP.findViewById(a.g.anchor_streak_win_layout);
        this.eca = (ImageView) this.ebP.findViewById(a.g.anchor_user_pk_streak_img);
        this.ecb = (TextView) this.ebP.findViewById(a.g.anchor_user_pk_streak_time);
        this.ecc = (FrameAnimationView) this.ebP.findViewById(a.g.anchor_layout_anim_img);
        this.ecd = (RelativeLayout) this.ebP.findViewById(a.g.pk_rival_live_layout);
        this.ece = (RelativeLayout) this.ebP.findViewById(a.g.pk_rival_user_layout);
        this.ecf = (HeadImageView) this.ebP.findViewById(a.g.ala_live_rival_user_image);
        this.ecg = (TextView) this.ebP.findViewById(a.g.ala_live_rival_user_name);
        this.ech = (LinearLayout) this.ebP.findViewById(a.g.rival_streak_win_layout);
        this.eci = (ImageView) this.ebP.findViewById(a.g.rival_user_pk_streak_img);
        this.ecj = (TextView) this.ebP.findViewById(a.g.rival_user_pk_streak_time);
        this.eck = (FrameAnimationView) this.ebP.findViewById(a.g.rival_layout_anim_img);
        this.ecl = (LinearLayout) this.ebP.findViewById(a.g.pk_time_layout);
        this.ecm = (TextView) this.ebP.findViewById(a.g.pk_time_label);
        this.ecn = (RelativeLayout) this.ebP.findViewById(a.g.pk_score_progress_layout);
        this.eco = (TextView) this.ebP.findViewById(a.g.pk_anchor_label);
        this.ecq = (TextView) this.ebP.findViewById(a.g.pk_anchor_progress);
        this.ecr = (TextView) this.ebP.findViewById(a.g.pk_rival_progress);
        this.ecp = (TextView) this.ebP.findViewById(a.g.pk_rival_label);
        this.ect = (LinearLayout) this.ebP.findViewById(a.g.pk_adv_top_layout);
        this.ecu = (TbImageView) this.ebP.findViewById(a.g.top_adv_img);
        this.ecv = (LinearLayout) this.ebP.findViewById(a.g.pk_adv_bottom_layout);
        this.ecw = (TbImageView) this.ebP.findViewById(a.g.bottom_adv_img);
        this.ecx = (TextView) this.ebP.findViewById(a.g.btn_close_challenge_view);
        this.ecy = (LinearLayout) this.ebP.findViewById(a.g.pk_all_in_layout);
        this.ecz = (TextView) this.ebP.findViewById(a.g.btn_pk_all_in);
        this.ecA = (TextView) this.ebP.findViewById(a.g.pk_all_in_countdown_txt);
        this.ecB = (ImageView) this.ebP.findViewById(a.g.pk_all_in_label);
        this.ecs = this.ebP.findViewById(a.g.anchor_progress_bg);
        this.ebU = this.ebP.findViewById(a.g.anchor_live_anim_fore_bg);
        this.ebX = this.ebP.findViewById(a.g.rival_live_anim_fore_bg);
        this.ece.setVisibility(0);
        this.ece.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.ecf.setIsRound(true);
        this.ecf.setAutoChangeStyle(false);
        this.ecf.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.ecf.setIsNight(false);
        this.ecd.setOnClickListener(this);
        this.ece.setOnClickListener(this);
        this.ecx.setOnClickListener(this);
        this.ecz.setOnClickListener(this);
    }

    private void updateView() {
        this.ecG = f.au(this.mContext);
        this.ecF = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds64);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int ax = f.ax(this.mContext);
        int aw = f.aw(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.ecG;
        layoutParams.height = aw;
        this.ebR.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ax, aw);
        layoutParams2.addRule(9);
        this.ebY.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ax, aw);
        layoutParams3.addRule(11);
        this.ecd.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ax, aw);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = this.ecG;
        this.ebV.setLayoutParams(layoutParams4);
        int i = aw - dimensionPixelSize;
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.ecB.getLayoutParams();
        layoutParams5.topMargin = i;
        layoutParams5.addRule(14);
        this.ecB.setLayoutParams(layoutParams5);
        this.ecB.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.ecy.getLayoutParams();
        int i2 = aw - dimensionPixelSize2;
        float[] physicalScreenSize = j.getPhysicalScreenSize(getContext());
        if (physicalScreenSize != null && physicalScreenSize.length == 2 && physicalScreenSize[1] != 0.0f && physicalScreenSize[0] / physicalScreenSize[1] > 0.59f) {
            i2 -= dimensionPixelSize2 + getContext().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        layoutParams6.topMargin = i2;
        layoutParams6.addRule(14);
        this.ecy.setLayoutParams(layoutParams6);
        setAllInBtnVisible(false);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.ecl.getLayoutParams();
        layoutParams7.topMargin = this.ecG;
        layoutParams7.addRule(14);
        this.ecl.setLayoutParams(layoutParams7);
        this.ecn.setAlpha(0.0f);
        this.ecA.setVisibility(4);
    }

    public View getAnchorAnimLiveLayout() {
        return this.ebS;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.ebU;
    }

    public View getRivalAnimLiveLayout() {
        return this.ebV;
    }

    public View getRivalAnimLiveForeBg() {
        return this.ebX;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.ebT;
    }

    public void setAnchorUserViewBg(w wVar) {
        this.ebT.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (wVar.SF != null) {
            str = wVar.SF.portrait;
        }
        this.ebT.startLoad(str, 12, false);
        this.ebT.setVisibility(0);
    }

    public void setRivalUserViewBg(w wVar) {
        this.ebW.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (wVar.SF != null) {
            str = wVar.SF.portrait;
        }
        this.ebW.startLoad(str, 12, false);
    }

    public FrameAnimationView getAnchorLiveAllInAnimImg() {
        return this.ecc;
    }

    public FrameAnimationView getRivalLiveAllInAnimImg() {
        return this.eck;
    }

    public View getLeftTimeView() {
        return this.ecl;
    }

    public ViewGroup getLiveContainerView() {
        return this.ebR;
    }

    public View getScoreProgressLayout() {
        return this.ecn;
    }

    public View getTopAdvViewLayout() {
        return this.ect;
    }

    public View getBottomAdvViewLayout() {
        return this.ecv;
    }

    public View getCloseBtnView() {
        return this.ecx;
    }

    public RelativeLayout getContainerView() {
        return this.ebQ;
    }

    public void a(v vVar, w wVar, w wVar2, boolean z) {
        this.dZg = wVar2;
        int i = vVar.Ss;
        long j = vVar.Sx - vVar.Sy;
        o(i, j);
        q(vVar.Sz, vVar.SA);
        if (z) {
            a(wVar2);
            aQV();
        }
        if (i == 2) {
            if (this.ecy.getVisibility() == 0 && j <= 120) {
                setAllInBtnVisible(false);
                BdUtilHelper.showToast(this.mContext, a.i.ala_challenge_reward_than_two_min_limit);
            }
            setCloseBtnVisible(true);
            aQU();
        } else if (i == 3) {
            setCloseBtnVisible(false);
            setAllInBtnVisible(false);
            aU(vVar.challengeResult, vVar.SB);
        } else {
            setCloseBtnVisible(false);
            setAllInBtnVisible(false);
            aU(vVar.challengeResult, vVar.SB);
        }
    }

    private void o(int i, long j) {
        String formatSecondsTime = StringHelper.formatSecondsTime(j);
        String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
        if (i == 2) {
            string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
        } else if (i == 3) {
            string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
        } else if (i == 4) {
            string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
        }
        this.ecm.setText(string);
    }

    public void setAllInBtnVisible(boolean z) {
        this.ecy.setVisibility(4);
    }

    public void setAllInLabelVisible(boolean z) {
    }

    public void setAllInCountDownTextVisible(boolean z) {
        this.ecA.setVisibility(z ? 0 : 4);
    }

    public void setAllInCountDownText(String str) {
        this.ecA.setText(str);
    }

    public void setLiveContainerVisible(boolean z) {
        this.ebR.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.ecx.setVisibility(z ? 0 : 4);
        } else {
            this.ecx.setVisibility(4);
        }
    }

    public void aQT() {
        setCloseBtnVisible(false);
        setAllInBtnVisible(false);
        setLiveContainerVisible(false);
        setAllInLabelVisible(false);
        setAllInCountDownTextVisible(false);
    }

    public void aU(int i, int i2) {
        this.ebZ.setVisibility(0);
        this.ech.setVisibility(0);
        this.ecb.setVisibility(4);
        this.ecj.setVisibility(4);
        if (1 == i) {
            this.eca.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.ecb.setVisibility(0);
                this.ecb.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.ecb.setText("");
            }
            this.eci.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.eca.setImageResource(a.f.icon_live_vs_draw);
            this.eci.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.eca.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.ecj.setVisibility(0);
                this.ecj.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.ecj.setText("");
            }
            this.eci.setImageResource(a.f.icon_live_vs_win);
        } else {
            aQU();
        }
    }

    public void aQU() {
        this.ebZ.setVisibility(4);
        this.ech.setVisibility(4);
    }

    private void q(long j, long j2) {
        int i;
        if (this.ecD != j || this.ecE != j2) {
            this.ecD = j;
            this.ecE = j2;
            this.ecq.setText(String.valueOf(this.ecD));
            this.ecr.setText(String.valueOf(this.ecE));
            float f = (float) (this.ecD + this.ecE);
            int i2 = this.screenWidth / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.ecD) / f) * this.screenWidth);
                int i4 = ((LinearLayout.LayoutParams) this.ecs.getLayoutParams()).width;
                if (i3 < this.ecF) {
                    i = this.ecF;
                } else {
                    i = i3 > this.screenWidth - this.ecF ? this.screenWidth - this.ecF : i3;
                }
                if (this.ecH != null) {
                    this.ecH.cancel();
                }
                this.ecH = ValueAnimator.ofInt(i4, i);
                this.ecH.setDuration(100L);
                this.ecH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.ecs.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.ecs.setLayoutParams(layoutParams);
                    }
                });
                this.ecH.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ecs.getLayoutParams();
            layoutParams.width = i2;
            this.ecs.setLayoutParams(layoutParams);
        }
    }

    public void a(w wVar) {
        if (wVar == null || wVar.SF == null) {
            this.ece.setVisibility(4);
            return;
        }
        this.ece.setTag(wVar);
        this.ecf.startLoad(wVar.SF.portrait, 12, false, false);
        String str = wVar.SF.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 12) {
            str = TextHelper.subStringWithEmoji(str, 12) + StringHelper.STRING_MORE;
        }
        this.ecg.setText(str);
    }

    public View getRivalUserInfoView() {
        return this.ece;
    }

    private void aQV() {
        this.ect.setVisibility(0);
        this.ecu.setAutoChangeStyle(false);
        this.ecu.setIsNight(false);
        this.ecu.setIsRound(false);
        this.ecu.setDefaultBgResource(a.f.icon_live_vs_ad);
        this.ecu.setDefaultErrorResource(a.f.icon_live_vs_ad);
        this.ecu.startLoad(com.baidu.live.l.a.uB().ajF.Rl, 10, false);
    }

    public void releaseResource() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ecx) {
            if (this.ecC != null) {
                this.ecC.aQW();
            }
        } else if (view == this.ecz) {
            if (com.baidu.live.l.a.uB().ajF.Rj && this.ecC != null) {
                TiebaInitialize.log(new StatisticItem("c13052"));
                this.ecC.aQX();
            }
        } else if (view == this.ece) {
            if (this.ecC != null) {
                this.ecC.b((w) this.ece.getTag());
            }
        } else if (view == this.ecd && this.ecC != null) {
            this.ecC.c(this.dZg);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.ecC = aVar;
    }
}
