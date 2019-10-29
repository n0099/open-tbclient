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
    private w dZX;
    private RelativeLayout ecG;
    private RelativeLayout ecH;
    private RelativeLayout ecI;
    private RelativeLayout ecJ;
    private TbImageView ecK;
    private View ecL;
    private RelativeLayout ecM;
    private TbImageView ecN;
    private View ecO;
    private RelativeLayout ecP;
    private LinearLayout ecQ;
    private ImageView ecR;
    private TextView ecS;
    private FrameAnimationView ecT;
    private RelativeLayout ecU;
    private RelativeLayout ecV;
    private HeadImageView ecW;
    private TextView ecX;
    private LinearLayout ecY;
    private ImageView ecZ;
    private TextView eda;
    private FrameAnimationView edb;
    private LinearLayout edc;
    private TextView edd;
    private RelativeLayout ede;
    private TextView edf;
    private TextView edg;
    private TextView edh;
    private TextView edi;
    private View edj;
    private LinearLayout edk;
    private TbImageView edl;
    private LinearLayout edm;
    private TbImageView edn;
    private TextView edo;
    private LinearLayout edp;
    private TextView edq;
    private TextView edr;
    private ImageView eds;
    private a edt;
    private long edu;
    private long edv;
    private int edw;
    private int edx;
    private ValueAnimator edy;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private int screenWidth;

    /* loaded from: classes6.dex */
    public interface a {
        void aQY();

        void aQZ();

        void b(w wVar);

        void c(w wVar);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.edu = -1L;
        this.edv = -1L;
        this.screenWidth = -1;
        this.edw = 0;
        this.edx = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.edu = -1L;
        this.edv = -1L;
        this.screenWidth = -1;
        this.edw = 0;
        this.edx = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.edu = -1L;
        this.edv = -1L;
        this.screenWidth = -1;
        this.edw = 0;
        this.edx = 0;
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
        this.ecG = (RelativeLayout) View.inflate(context, a.h.ala_challenge_panel_optation_view, this);
        this.ecH = (RelativeLayout) this.ecG.findViewById(a.g.root_container);
        this.ecJ = (RelativeLayout) this.ecG.findViewById(a.g.anchor_live_anim_layout);
        this.ecK = (TbImageView) this.ecG.findViewById(a.g.anchor_live_anim_bg);
        this.ecM = (RelativeLayout) this.ecG.findViewById(a.g.rival_live_anim_layout);
        this.ecN = (TbImageView) this.ecG.findViewById(a.g.rival_live_anim_bg);
        this.ecI = (RelativeLayout) this.ecG.findViewById(a.g.pk_live_container);
        this.ecP = (RelativeLayout) this.ecG.findViewById(a.g.pk_anchor_live_layout);
        this.ecQ = (LinearLayout) this.ecG.findViewById(a.g.anchor_streak_win_layout);
        this.ecR = (ImageView) this.ecG.findViewById(a.g.anchor_user_pk_streak_img);
        this.ecS = (TextView) this.ecG.findViewById(a.g.anchor_user_pk_streak_time);
        this.ecT = (FrameAnimationView) this.ecG.findViewById(a.g.anchor_layout_anim_img);
        this.ecU = (RelativeLayout) this.ecG.findViewById(a.g.pk_rival_live_layout);
        this.ecV = (RelativeLayout) this.ecG.findViewById(a.g.pk_rival_user_layout);
        this.ecW = (HeadImageView) this.ecG.findViewById(a.g.ala_live_rival_user_image);
        this.ecX = (TextView) this.ecG.findViewById(a.g.ala_live_rival_user_name);
        this.ecY = (LinearLayout) this.ecG.findViewById(a.g.rival_streak_win_layout);
        this.ecZ = (ImageView) this.ecG.findViewById(a.g.rival_user_pk_streak_img);
        this.eda = (TextView) this.ecG.findViewById(a.g.rival_user_pk_streak_time);
        this.edb = (FrameAnimationView) this.ecG.findViewById(a.g.rival_layout_anim_img);
        this.edc = (LinearLayout) this.ecG.findViewById(a.g.pk_time_layout);
        this.edd = (TextView) this.ecG.findViewById(a.g.pk_time_label);
        this.ede = (RelativeLayout) this.ecG.findViewById(a.g.pk_score_progress_layout);
        this.edf = (TextView) this.ecG.findViewById(a.g.pk_anchor_label);
        this.edh = (TextView) this.ecG.findViewById(a.g.pk_anchor_progress);
        this.edi = (TextView) this.ecG.findViewById(a.g.pk_rival_progress);
        this.edg = (TextView) this.ecG.findViewById(a.g.pk_rival_label);
        this.edk = (LinearLayout) this.ecG.findViewById(a.g.pk_adv_top_layout);
        this.edl = (TbImageView) this.ecG.findViewById(a.g.top_adv_img);
        this.edm = (LinearLayout) this.ecG.findViewById(a.g.pk_adv_bottom_layout);
        this.edn = (TbImageView) this.ecG.findViewById(a.g.bottom_adv_img);
        this.edo = (TextView) this.ecG.findViewById(a.g.btn_close_challenge_view);
        this.edp = (LinearLayout) this.ecG.findViewById(a.g.pk_all_in_layout);
        this.edq = (TextView) this.ecG.findViewById(a.g.btn_pk_all_in);
        this.edr = (TextView) this.ecG.findViewById(a.g.pk_all_in_countdown_txt);
        this.eds = (ImageView) this.ecG.findViewById(a.g.pk_all_in_label);
        this.edj = this.ecG.findViewById(a.g.anchor_progress_bg);
        this.ecL = this.ecG.findViewById(a.g.anchor_live_anim_fore_bg);
        this.ecO = this.ecG.findViewById(a.g.rival_live_anim_fore_bg);
        this.ecV.setVisibility(0);
        this.ecV.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.ecW.setIsRound(true);
        this.ecW.setAutoChangeStyle(false);
        this.ecW.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.ecW.setIsNight(false);
        this.ecU.setOnClickListener(this);
        this.ecV.setOnClickListener(this);
        this.edo.setOnClickListener(this);
        this.edq.setOnClickListener(this);
    }

    private void updateView() {
        this.edx = f.au(this.mContext);
        this.edw = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds64);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds30);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int ax = f.ax(this.mContext);
        int aw = f.aw(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.edx;
        layoutParams.height = aw;
        this.ecI.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ax, aw);
        layoutParams2.addRule(9);
        this.ecP.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ax, aw);
        layoutParams3.addRule(11);
        this.ecU.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ax, aw);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = this.edx;
        this.ecM.setLayoutParams(layoutParams4);
        int i = aw - dimensionPixelSize;
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.eds.getLayoutParams();
        layoutParams5.topMargin = i;
        layoutParams5.addRule(14);
        this.eds.setLayoutParams(layoutParams5);
        this.eds.setVisibility(4);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.edp.getLayoutParams();
        int i2 = aw - dimensionPixelSize2;
        float[] physicalScreenSize = j.getPhysicalScreenSize(getContext());
        if (physicalScreenSize != null && physicalScreenSize.length == 2 && physicalScreenSize[1] != 0.0f && physicalScreenSize[0] / physicalScreenSize[1] > 0.59f) {
            i2 -= dimensionPixelSize2 + getContext().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        layoutParams6.topMargin = i2;
        layoutParams6.addRule(14);
        this.edp.setLayoutParams(layoutParams6);
        setAllInBtnVisible(false);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.edc.getLayoutParams();
        layoutParams7.topMargin = this.edx;
        layoutParams7.addRule(14);
        this.edc.setLayoutParams(layoutParams7);
        this.ede.setAlpha(0.0f);
        this.edr.setVisibility(4);
    }

    public View getAnchorAnimLiveLayout() {
        return this.ecJ;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.ecL;
    }

    public View getRivalAnimLiveLayout() {
        return this.ecM;
    }

    public View getRivalAnimLiveForeBg() {
        return this.ecO;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.ecK;
    }

    public void setAnchorUserViewBg(w wVar) {
        this.ecK.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (wVar.Tb != null) {
            str = wVar.Tb.portrait;
        }
        this.ecK.startLoad(str, 12, false);
        this.ecK.setVisibility(0);
    }

    public void setRivalUserViewBg(w wVar) {
        this.ecN.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (wVar.Tb != null) {
            str = wVar.Tb.portrait;
        }
        this.ecN.startLoad(str, 12, false);
    }

    public FrameAnimationView getAnchorLiveAllInAnimImg() {
        return this.ecT;
    }

    public FrameAnimationView getRivalLiveAllInAnimImg() {
        return this.edb;
    }

    public View getLeftTimeView() {
        return this.edc;
    }

    public ViewGroup getLiveContainerView() {
        return this.ecI;
    }

    public View getScoreProgressLayout() {
        return this.ede;
    }

    public View getTopAdvViewLayout() {
        return this.edk;
    }

    public View getBottomAdvViewLayout() {
        return this.edm;
    }

    public View getCloseBtnView() {
        return this.edo;
    }

    public RelativeLayout getContainerView() {
        return this.ecH;
    }

    public void a(v vVar, w wVar, w wVar2, boolean z) {
        this.dZX = wVar2;
        int i = vVar.SO;
        long j = vVar.SU - vVar.SV;
        q(i, j);
        q(vVar.SW, vVar.SX);
        if (z) {
            a(wVar2);
            aQX();
        }
        if (i == 2) {
            if (this.edp.getVisibility() == 0 && j <= 120) {
                setAllInBtnVisible(false);
                BdUtilHelper.showToast(this.mContext, a.i.ala_challenge_reward_than_two_min_limit);
            }
            setCloseBtnVisible(true);
            aQW();
        } else if (i == 3) {
            setCloseBtnVisible(false);
            setAllInBtnVisible(false);
            aW(vVar.challengeResult, vVar.SY);
        } else {
            setCloseBtnVisible(false);
            setAllInBtnVisible(false);
            aW(vVar.challengeResult, vVar.SY);
        }
    }

    private void q(int i, long j) {
        String formatSecondsTime = StringHelper.formatSecondsTime(j);
        String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
        if (i == 2) {
            string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
        } else if (i == 3) {
            string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
        } else if (i == 4) {
            string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
        }
        this.edd.setText(string);
    }

    public void setAllInBtnVisible(boolean z) {
        this.edp.setVisibility(4);
    }

    public void setAllInLabelVisible(boolean z) {
    }

    public void setAllInCountDownTextVisible(boolean z) {
        this.edr.setVisibility(z ? 0 : 4);
    }

    public void setAllInCountDownText(String str) {
        this.edr.setText(str);
    }

    public void setLiveContainerVisible(boolean z) {
        this.ecI.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.edo.setVisibility(z ? 0 : 4);
        } else {
            this.edo.setVisibility(4);
        }
    }

    public void aQV() {
        setCloseBtnVisible(false);
        setAllInBtnVisible(false);
        setLiveContainerVisible(false);
        setAllInLabelVisible(false);
        setAllInCountDownTextVisible(false);
    }

    public void aW(int i, int i2) {
        this.ecQ.setVisibility(0);
        this.ecY.setVisibility(0);
        this.ecS.setVisibility(4);
        this.eda.setVisibility(4);
        if (1 == i) {
            this.ecR.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.ecS.setVisibility(0);
                this.ecS.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.ecS.setText("");
            }
            this.ecZ.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.ecR.setImageResource(a.f.icon_live_vs_draw);
            this.ecZ.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.ecR.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.eda.setVisibility(0);
                this.eda.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eda.setText("");
            }
            this.ecZ.setImageResource(a.f.icon_live_vs_win);
        } else {
            aQW();
        }
    }

    public void aQW() {
        this.ecQ.setVisibility(4);
        this.ecY.setVisibility(4);
    }

    private void q(long j, long j2) {
        int i;
        if (this.edu != j || this.edv != j2) {
            this.edu = j;
            this.edv = j2;
            this.edh.setText(String.valueOf(this.edu));
            this.edi.setText(String.valueOf(this.edv));
            float f = (float) (this.edu + this.edv);
            int i2 = this.screenWidth / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.edu) / f) * this.screenWidth);
                int i4 = ((LinearLayout.LayoutParams) this.edj.getLayoutParams()).width;
                if (i3 < this.edw) {
                    i = this.edw;
                } else {
                    i = i3 > this.screenWidth - this.edw ? this.screenWidth - this.edw : i3;
                }
                if (this.edy != null) {
                    this.edy.cancel();
                }
                this.edy = ValueAnimator.ofInt(i4, i);
                this.edy.setDuration(100L);
                this.edy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.edj.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.edj.setLayoutParams(layoutParams);
                    }
                });
                this.edy.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.edj.getLayoutParams();
            layoutParams.width = i2;
            this.edj.setLayoutParams(layoutParams);
        }
    }

    public void a(w wVar) {
        if (wVar == null || wVar.Tb == null) {
            this.ecV.setVisibility(4);
            return;
        }
        this.ecV.setTag(wVar);
        this.ecW.startLoad(wVar.Tb.portrait, 12, false, false);
        String str = wVar.Tb.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 12) {
            str = TextHelper.subStringWithEmoji(str, 12) + StringHelper.STRING_MORE;
        }
        this.ecX.setText(str);
    }

    public View getRivalUserInfoView() {
        return this.ecV;
    }

    private void aQX() {
        this.edk.setVisibility(0);
        this.edl.setAutoChangeStyle(false);
        this.edl.setIsNight(false);
        this.edl.setIsRound(false);
        this.edl.setDefaultBgResource(a.f.icon_live_vs_ad);
        this.edl.setDefaultErrorResource(a.f.icon_live_vs_ad);
        this.edl.startLoad(com.baidu.live.l.a.uA().ajX.RL, 10, false);
    }

    public void releaseResource() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.edo) {
            if (this.edt != null) {
                this.edt.aQY();
            }
        } else if (view == this.edq) {
            if (com.baidu.live.l.a.uA().ajX.RJ && this.edt != null) {
                TiebaInitialize.log(new StatisticItem("c13052"));
                this.edt.aQZ();
            }
        } else if (view == this.ecV) {
            if (this.edt != null) {
                this.edt.b((w) this.ecV.getTag());
            }
        } else if (view == this.ecU && this.edt != null) {
            this.edt.c(this.dZX);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.edt = aVar;
    }
}
