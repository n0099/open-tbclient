package com.baidu.tieba.ala.liveroom.challenge.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.CountDownTimer;
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
import com.baidu.live.data.aa;
import com.baidu.live.data.ab;
import com.baidu.live.data.ac;
import com.baidu.live.data.ad;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaChallengeLiveView extends RelativeLayout implements View.OnClickListener {
    private ad eQB;
    private ad eQC;
    private LinearLayout eTA;
    private ChallengeJinzhuView eTB;
    private ChallengeJinzhuView eTC;
    private ChallengeJinzhuView eTD;
    private RelativeLayout eTE;
    private RelativeLayout eTF;
    private HeadImageView eTG;
    private TextView eTH;
    private LinearLayout eTI;
    private ChallengeJinzhuView eTJ;
    private ChallengeJinzhuView eTK;
    private ChallengeJinzhuView eTL;
    private LinearLayout eTM;
    private ImageView eTN;
    private TextView eTO;
    private LinearLayout eTP;
    private TextView eTQ;
    private RelativeLayout eTR;
    private TextView eTS;
    private TextView eTT;
    private TextView eTU;
    private TextView eTV;
    private View eTW;
    private View eTX;
    private TextView eTY;
    private a eTZ;
    private RelativeLayout eTn;
    private RelativeLayout eTo;
    private RelativeLayout eTp;
    private TbImageView eTq;
    private View eTr;
    private RelativeLayout eTs;
    private TbImageView eTt;
    private View eTu;
    private RelativeLayout eTv;
    private RelativeLayout eTw;
    private LinearLayout eTx;
    private ImageView eTy;
    private TextView eTz;
    private long eUa;
    private long eUb;
    private int eUc;
    private int eUd;
    private ac eUe;
    private ValueAnimator eUf;
    private List<aa> eUg;
    private List<aa> eUh;
    private CountDownTimer erY;
    private boolean isHost;
    private Context mContext;
    private Handler mHandler;
    private RelativeLayout rootView;
    private int screenWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void b(ad adVar);

        void bjp();

        void c(ad adVar);
    }

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.isHost = false;
        this.eUa = -1L;
        this.eUb = -1L;
        this.screenWidth = -1;
        this.eUc = 0;
        this.eUd = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isHost = false;
        this.eUa = -1L;
        this.eUb = -1L;
        this.screenWidth = -1;
        this.eUc = 0;
        this.eUd = 0;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isHost = false;
        this.eUa = -1L;
        this.eUb = -1L;
        this.screenWidth = -1;
        this.eUc = 0;
        this.eUd = 0;
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
        this.eTn = (RelativeLayout) this.rootView.findViewById(a.g.root_container);
        this.eTp = (RelativeLayout) this.rootView.findViewById(a.g.anchor_live_anim_layout);
        this.eTq = (TbImageView) this.rootView.findViewById(a.g.anchor_live_anim_bg);
        this.eTs = (RelativeLayout) this.rootView.findViewById(a.g.rival_live_anim_layout);
        this.eTt = (TbImageView) this.rootView.findViewById(a.g.rival_live_anim_bg);
        this.eTo = (RelativeLayout) this.rootView.findViewById(a.g.pk_live_container);
        this.eTw = (RelativeLayout) this.rootView.findViewById(a.g.pk_anchor_live_layout);
        this.eTx = (LinearLayout) this.rootView.findViewById(a.g.anchor_streak_win_layout);
        this.eTy = (ImageView) this.rootView.findViewById(a.g.anchor_user_pk_streak_img);
        this.eTz = (TextView) this.rootView.findViewById(a.g.anchor_user_pk_streak_time);
        this.eTv = (RelativeLayout) this.rootView.findViewById(a.g.jinzhu_container);
        this.eTA = (LinearLayout) this.rootView.findViewById(a.g.anchor_jinzhu_layout);
        this.eTB = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_1);
        this.eTC = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_2);
        this.eTD = (ChallengeJinzhuView) this.rootView.findViewById(a.g.anchor_jinzhu_3);
        this.eTE = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_live_layout);
        this.eTF = (RelativeLayout) this.rootView.findViewById(a.g.pk_rival_user_layout);
        this.eTG = (HeadImageView) this.rootView.findViewById(a.g.ala_live_rival_user_image);
        this.eTH = (TextView) this.rootView.findViewById(a.g.ala_live_rival_user_name);
        this.eTM = (LinearLayout) this.rootView.findViewById(a.g.rival_streak_win_layout);
        this.eTI = (LinearLayout) this.rootView.findViewById(a.g.rival_jinzhu_layout);
        this.eTJ = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_1);
        this.eTK = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_2);
        this.eTL = (ChallengeJinzhuView) this.rootView.findViewById(a.g.rival_jinzhu_3);
        this.eTN = (ImageView) this.rootView.findViewById(a.g.rival_user_pk_streak_img);
        this.eTO = (TextView) this.rootView.findViewById(a.g.rival_user_pk_streak_time);
        this.eTP = (LinearLayout) this.rootView.findViewById(a.g.pk_time_layout);
        this.eTQ = (TextView) this.rootView.findViewById(a.g.pk_time_label);
        this.eTR = (RelativeLayout) this.rootView.findViewById(a.g.pk_score_progress_layout);
        this.eTS = (TextView) this.rootView.findViewById(a.g.pk_anchor_label);
        this.eTU = (TextView) this.rootView.findViewById(a.g.pk_anchor_progress);
        this.eTV = (TextView) this.rootView.findViewById(a.g.pk_rival_progress);
        this.eTT = (TextView) this.rootView.findViewById(a.g.pk_rival_label);
        this.eTY = (TextView) this.rootView.findViewById(a.g.btn_close_challenge_view);
        this.eTW = this.rootView.findViewById(a.g.anchor_progress_bg);
        this.eTX = this.rootView.findViewById(a.g.rival_progress_bg);
        this.eTr = this.rootView.findViewById(a.g.anchor_live_anim_fore_bg);
        this.eTu = this.rootView.findViewById(a.g.rival_live_anim_fore_bg);
        this.eTF.setVisibility(0);
        this.eTF.setBackgroundResource(a.f.sdk_round_host_header_bg);
        this.eTG.setIsRound(true);
        this.eTG.setAutoChangeStyle(false);
        this.eTG.setDefaultBgResource(a.f.sdk_icon_default_avatar100_bg);
        this.eTG.setIsNight(false);
        this.eTE.setOnClickListener(this);
        this.eTF.setOnClickListener(this);
        this.eTY.setOnClickListener(this);
        this.eTA.setVisibility(8);
        this.eTI.setVisibility(8);
    }

    private void updateView() {
        this.eUd = g.aG(this.mContext);
        this.eUc = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds50);
        this.screenWidth = BdUtilHelper.getScreenDimensions(this.mContext)[0];
        int aJ = g.aJ(this.mContext);
        int aI = g.aI(this.mContext);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.eUd;
        layoutParams.height = aI;
        this.eTo.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(aJ, aI);
        layoutParams2.addRule(9);
        this.eTw.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(aJ, aI);
        layoutParams3.addRule(11);
        this.eTE.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(aJ, aI);
        layoutParams4.addRule(11);
        layoutParams4.topMargin = this.eUd;
        this.eTs.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.eTP.getLayoutParams();
        layoutParams5.topMargin = this.eUd;
        layoutParams5.addRule(14);
        this.eTP.setLayoutParams(layoutParams5);
        this.eTR.setAlpha(0.0f);
    }

    public View getAnchorAnimLiveLayout() {
        return this.eTp;
    }

    public View getAnchorAnimLiveForeBg() {
        return this.eTr;
    }

    public View getRivalAnimLiveLayout() {
        return this.eTs;
    }

    public View getRivalAnimLiveForeBg() {
        return this.eTu;
    }

    public TbImageView getAnchorAnimLiveBgView() {
        return this.eTq;
    }

    public void setAnchorUserViewBg(ad adVar) {
        this.eTq.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (adVar.ZC != null) {
            str = adVar.ZC.portrait;
        }
        this.eTq.startLoad(str, 12, false);
        this.eTq.setVisibility(0);
    }

    public void setRivalUserViewBg(ad adVar) {
        this.eTt.setScaleType(ImageView.ScaleType.FIT_XY);
        String str = "";
        if (adVar.ZC != null) {
            str = adVar.ZC.portrait;
        }
        this.eTt.startLoad(str, 12, false);
    }

    public View getLeftTimeView() {
        return this.eTP;
    }

    public ViewGroup getLiveContainerView() {
        return this.eTo;
    }

    public View getScoreProgressLayout() {
        return this.eTR;
    }

    public View getJinzhuLayout() {
        return this.eTv;
    }

    public View getCloseBtnView() {
        return this.eTY;
    }

    public RelativeLayout getContainerView() {
        return this.eTn;
    }

    public void a(ac acVar, ad adVar, ad adVar2, boolean z) {
        this.eQB = adVar;
        this.eQC = adVar2;
        int i = acVar.ZE;
        a(acVar.challengeId, i, acVar.ZI, acVar.ZH);
        v(acVar.ZJ, acVar.ZK);
        if (z) {
            a(adVar2);
        }
        if (i == 2) {
            setCloseBtnVisible(true);
            bjn();
        } else if (i == 3) {
            setCloseBtnVisible(false);
            bn(acVar.challengeResult, acVar.ZL);
        } else {
            bbD();
            setCloseBtnVisible(false);
            bn(acVar.challengeResult, acVar.ZL);
        }
        a(adVar.ZP);
        b(adVar2.ZP);
        this.eUe = acVar;
    }

    private void a(ab abVar) {
        ArrayList arrayList;
        if (abVar == null) {
            this.eTB.setVisibility(8);
            this.eTC.setVisibility(8);
            this.eTD.setVisibility(8);
            return;
        }
        this.eTA.setVisibility(0);
        if (ListUtils.isEmpty(abVar.ZD)) {
            abVar.ZD = this.eUg;
        }
        if (ListUtils.isEmpty(abVar.ZD)) {
            this.eTB.setVisibility(0);
            this.eTC.setVisibility(8);
            this.eTD.setVisibility(8);
            this.eTB.a(true, null, abVar.liveId);
            return;
        }
        this.eUg = abVar.ZD;
        this.eTB.setVisibility(8);
        this.eTC.setVisibility(8);
        this.eTD.setVisibility(8);
        if (abVar.ZD.size() > 3) {
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < 3; i++) {
                arrayList2.add(abVar.ZD.get(i));
            }
            arrayList = arrayList2;
        } else {
            arrayList = abVar.ZD;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            aa aaVar = arrayList.get(i2);
            if (aaVar != null) {
                if (aaVar.pU() || aaVar.isFirst()) {
                    this.eTB.setVisibility(0);
                    this.eTB.a(true, aaVar, abVar.liveId);
                } else if (aaVar.rank == 2) {
                    this.eTC.setVisibility(0);
                    this.eTC.a(true, aaVar, abVar.liveId);
                } else if (aaVar.rank == 3) {
                    this.eTD.setVisibility(0);
                    this.eTD.a(true, aaVar, abVar.liveId);
                }
            }
        }
    }

    private void b(ab abVar) {
        List<aa> list;
        if (abVar == null) {
            this.eTJ.setVisibility(8);
            this.eTK.setVisibility(8);
            this.eTL.setVisibility(8);
            return;
        }
        this.eTI.setVisibility(0);
        if (ListUtils.isEmpty(abVar.ZD)) {
            abVar.ZD = this.eUh;
        }
        if (ListUtils.isEmpty(abVar.ZD)) {
            this.eTJ.setVisibility(0);
            this.eTK.setVisibility(8);
            this.eTL.setVisibility(8);
            this.eTJ.a(false, null, abVar.liveId);
            return;
        }
        this.eUh = abVar.ZD;
        this.eTJ.setVisibility(8);
        this.eTK.setVisibility(8);
        this.eTL.setVisibility(8);
        if (abVar.ZD.size() > 3) {
            list = abVar.ZD.subList(0, 3);
        } else {
            list = abVar.ZD;
        }
        for (int i = 0; i < list.size(); i++) {
            aa aaVar = list.get(i);
            if (aaVar != null) {
                if (aaVar.pU() || aaVar.isFirst()) {
                    this.eTJ.setVisibility(0);
                    this.eTJ.a(false, aaVar, abVar.liveId);
                } else if (aaVar.rank == 2) {
                    this.eTK.setVisibility(0);
                    this.eTK.a(false, aaVar, abVar.liveId);
                } else if (aaVar.rank == 3) {
                    this.eTL.setVisibility(0);
                    this.eTL.a(false, aaVar, abVar.liveId);
                }
            }
        }
    }

    private void a(long j, int i, long j2, long j3) {
        if (j3 >= j2 && a(j, i, j3)) {
            bbD();
            if (this.eUe != null) {
                u(this.eUe.ZE, (j3 - j2) * 1000);
            }
            this.erY = new CountDownTimer((j3 - j2) * 1000, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.1
                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    if (AlaChallengeLiveView.this.eUe != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.eUe.ZE, j4);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (AlaChallengeLiveView.this.eUe != null) {
                        AlaChallengeLiveView.this.u(AlaChallengeLiveView.this.eUe.ZE, 0L);
                    }
                }
            };
            this.erY.start();
        }
    }

    private boolean a(long j, int i, long j2) {
        return (this.eUe != null && this.eUe.challengeId == j && this.eUe.ZE == i && this.eUe.ZH == j2) ? false : true;
    }

    private void bbD() {
        if (this.erY != null) {
            this.erY.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, long j) {
        if (this.eTQ != null) {
            String formatSecondsTime = StringHelper.formatSecondsTime(Math.round(j / 1000.0d));
            String string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            if (i == 2) {
                string = this.mContext.getString(a.i.ala_challenge_operate_challenge_time, formatSecondsTime);
            } else if (i == 3) {
                string = this.mContext.getString(a.i.ala_challenge_operate_publish_time, formatSecondsTime);
            } else if (i == 4) {
                string = this.mContext.getString(a.i.ala_challenge_operate_over_time);
            }
            this.eTQ.setText(string);
        }
    }

    public void setLiveContainerVisible(boolean z) {
        this.eTo.setVisibility(z ? 0 : 4);
    }

    public void setCloseBtnVisible(boolean z) {
        if (this.isHost) {
            this.eTY.setVisibility(z ? 0 : 4);
        } else {
            this.eTY.setVisibility(4);
        }
    }

    public void bjm() {
        setCloseBtnVisible(false);
        setLiveContainerVisible(false);
        if (this.eUg != null) {
            this.eUg.clear();
            this.eUg = null;
        }
        if (this.eUh != null) {
            this.eUh.clear();
            this.eUh = null;
        }
        this.eUe = null;
    }

    public void bn(int i, int i2) {
        this.eTx.setVisibility(0);
        this.eTM.setVisibility(0);
        this.eTz.setVisibility(4);
        this.eTO.setVisibility(4);
        if (1 == i) {
            this.eTy.setImageResource(a.f.icon_live_vs_win);
            if (i2 >= 2) {
                this.eTz.setVisibility(0);
                this.eTz.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eTz.setText("");
            }
            this.eTN.setImageResource(a.f.icon_live_vs_lose);
        } else if (3 == i) {
            this.eTy.setImageResource(a.f.icon_live_vs_draw);
            this.eTN.setImageResource(a.f.icon_live_vs_draw);
        } else if (2 == i) {
            this.eTy.setImageResource(a.f.icon_live_vs_lose);
            if (i2 >= 2) {
                this.eTO.setVisibility(0);
                this.eTO.setText(this.mContext.getResources().getString(a.i.ala_challenge_streak_win_label, Integer.valueOf(i2)));
            } else {
                this.eTO.setText("");
            }
            this.eTN.setImageResource(a.f.icon_live_vs_win);
        } else {
            bjn();
        }
    }

    public void bjn() {
        this.eTx.setVisibility(4);
        this.eTM.setVisibility(4);
    }

    public void bjo() {
        if (this.eUg != null) {
            this.eUg.clear();
            this.eUg = null;
        }
        if (this.eUh != null) {
            this.eUh.clear();
            this.eUh = null;
        }
    }

    private void v(long j, long j2) {
        int i;
        if (this.eUa != j || this.eUb != j2) {
            this.eUa = j;
            this.eUb = j2;
            this.eTU.setText(String.valueOf(this.eUa));
            this.eTV.setText(String.valueOf(this.eUb));
            float f = (float) (this.eUa + this.eUb);
            final int dimensionPixelSize = (this.screenWidth - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20) * 2)) - (this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds6) * 2);
            int i2 = dimensionPixelSize / 2;
            if (f != 0.0f) {
                int i3 = (int) ((((float) this.eUa) / f) * dimensionPixelSize);
                int i4 = ((LinearLayout.LayoutParams) this.eTW.getLayoutParams()).width;
                if (i3 < this.eUc) {
                    i = this.eUc;
                } else {
                    i = i3 > dimensionPixelSize - this.eUc ? dimensionPixelSize - this.eUc : i3;
                }
                if (this.eUf != null) {
                    this.eUf.cancel();
                }
                this.eUf = ValueAnimator.ofInt(i4, i);
                this.eUf.setDuration(100L);
                this.eUf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeLiveView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.eTW.getLayoutParams();
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        AlaChallengeLiveView.this.eTW.setLayoutParams(layoutParams);
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AlaChallengeLiveView.this.eTX.getLayoutParams();
                        layoutParams2.width = dimensionPixelSize - layoutParams.width;
                        AlaChallengeLiveView.this.eTX.setLayoutParams(layoutParams2);
                    }
                });
                this.eUf.start();
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eTW.getLayoutParams();
            layoutParams.width = i2;
            this.eTW.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eTX.getLayoutParams();
            layoutParams2.width = dimensionPixelSize - layoutParams.width;
            this.eTX.setLayoutParams(layoutParams2);
        }
    }

    public void a(ad adVar) {
        if (adVar == null || adVar.ZC == null) {
            this.eTF.setVisibility(4);
            return;
        }
        this.eTF.setTag(adVar);
        this.eTG.startLoad(adVar.ZC.portrait, 12, false, false);
        String str = adVar.ZC.userName;
        if (TextHelper.getTextLengthWithEmoji(str) > 12) {
            str = TextHelper.subStringWithEmoji(str, 12) + StringHelper.STRING_MORE;
        }
        this.eTH.setText(str);
    }

    public View getRivalUserInfoView() {
        return this.eTF;
    }

    public void releaseResource() {
        bbD();
        this.eUe = null;
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eTY) {
            if (this.eTZ != null) {
                this.eTZ.bjp();
            }
        } else if (view == this.eTF) {
            if (this.eTZ != null) {
                this.eTZ.b((ad) this.eTF.getTag());
            }
        } else if (view == this.eTE && this.eTZ != null) {
            this.eTZ.c(this.eQC);
        }
    }

    public void setViewClickCallBack(a aVar) {
        this.eTZ = aVar;
    }
}
