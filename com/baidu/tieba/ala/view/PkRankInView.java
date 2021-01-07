package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ala.data.PkInfoData;
import com.baidu.tieba.ala.e;
import com.baidu.tieba.ala.view.anim.AlaFirstBloodAnim;
import com.baidu.tieba.ala.view.anim.PkRankPropAnim;
import java.text.DecimalFormat;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PkRankInView extends RelativeLayout {
    Context context;
    PkRankView gTH;
    com.baidu.tieba.ala.e ikC;
    RelativeLayout ikJ;
    ImageView ikK;
    ImageView ikL;
    RelativeLayout ikM;
    HeadImageView ikN;
    TextView ikO;
    TextView ikP;
    FixedTextView ikQ;
    ImageView ikR;
    ImageView ikS;
    RelativeLayout ikT;
    HeadImageView ikU;
    TextView ikV;
    TextView ikW;
    FixedTextView ikX;
    ImageView ikY;
    ImageView ikZ;
    ImageView ila;
    TextView ilb;
    TextView ilc;
    long ild;
    long ile;
    long ilf;
    Queue<com.baidu.tieba.ala.view.anim.a> ilg;
    Queue<com.baidu.tieba.ala.view.anim.a> ilh;
    public AnimatorListenerAdapter ili;
    public AnimatorListenerAdapter ilj;
    k ilk;
    private View mView;
    int status;

    public PkRankInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilg = new LinkedBlockingQueue();
        this.ilh = new LinkedBlockingQueue();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_in_layout, (ViewGroup) this, true);
        this.ikM = (RelativeLayout) this.mView.findViewById(a.f.in_top_layout);
        this.ikJ = (RelativeLayout) this.mView.findViewById(a.f.background_view);
        this.ikK = (ImageView) this.mView.findViewById(a.f.top_bg);
        this.ikL = (ImageView) this.mView.findViewById(a.f.bottom_bg);
        this.ila = (ImageView) this.mView.findViewById(a.f.pk_img);
        this.ikN = (HeadImageView) this.mView.findViewById(a.f.top_head);
        this.ikO = (TextView) this.mView.findViewById(a.f.top_wins);
        this.ikP = (TextView) this.mView.findViewById(a.f.top_name);
        this.ikQ = (FixedTextView) this.mView.findViewById(a.f.top_scores);
        this.ikR = (ImageView) this.mView.findViewById(a.f.top_plus);
        this.ikS = (ImageView) this.mView.findViewById(a.f.top_scores_shade);
        this.ikN.setDefaultBgResource(a.e.sdk_default_avatar);
        this.ikN.setIsRound(true);
        this.ikN.setAutoChangeStyle(false);
        this.ikN.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.ikN.setBorderColor(872415231);
        this.ikM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gTH.B(PkRankInView.this.gTH.imo.H5URL, PkRankInView.this.gTH.imo.myPkData.userID);
            }
        });
        this.ikT = (RelativeLayout) this.mView.findViewById(a.f.in_bottom_layout);
        this.ikU = (HeadImageView) this.mView.findViewById(a.f.bottom_head);
        this.ikV = (TextView) this.mView.findViewById(a.f.bottom_wins);
        this.ikW = (TextView) this.mView.findViewById(a.f.bottom_name);
        this.ikX = (FixedTextView) this.mView.findViewById(a.f.bottom_scores);
        this.ikY = (ImageView) this.mView.findViewById(a.f.bottom_plus);
        this.ikZ = (ImageView) this.mView.findViewById(a.f.bottom_scores_shade);
        this.ikU.setDefaultBgResource(a.e.sdk_default_avatar);
        this.ikU.setIsRound(true);
        this.ikU.setAutoChangeStyle(false);
        this.ikU.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.ikU.setBorderColor(872415231);
        this.ikT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gTH.B(PkRankInView.this.gTH.imo.H5URL, PkRankInView.this.gTH.imo.otherPkData.userID);
            }
        });
        this.ilb = (TextView) this.mView.findViewById(a.f.end_view);
        this.ilc = (TextView) this.mView.findViewById(a.f.timer);
        csD();
    }

    private void csD() {
        this.ili = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.ila.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.ilg.poll();
                if (PkRankInView.this.ilg.peek() != null) {
                    PkRankInView.this.ilg.peek().startAnim();
                }
            }
        };
        this.ilj = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.ila.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.ilh.poll();
                if (PkRankInView.this.ilh.peek() != null) {
                    PkRankInView.this.ilh.peek().startAnim();
                }
            }
        };
    }

    public void a(PkInfoData pkInfoData, int i) {
        this.gTH.cte();
        this.ilb.setVisibility(8);
        if (pkInfoData.pkStatusInfoData.pkStatus == 1) {
            fP(pkInfoData.pkStatusInfoData.stageEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        this.status = i;
        if (this.gTH.ye(i)) {
            switch (i) {
                case 10:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    d(pkInfoData);
                    return;
                case 30:
                    bYf();
                    return;
                default:
                    return;
            }
        }
    }

    private void d(PkInfoData pkInfoData) {
        this.ikU.startLoad(pkInfoData.otherPkData.bdPortrait, 12, false, false);
        if (pkInfoData.otherPkData.winningStreak > 1) {
            this.ikV.setVisibility(0);
            this.ikV.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.otherPkData.winningStreak)));
        } else {
            this.ikV.setVisibility(8);
        }
        this.ikW.setText(pkInfoData.otherPkData.userNickName);
        this.ikN.startLoad(pkInfoData.myPkData.bdPortrait, 12, false, false);
        if (pkInfoData.myPkData.winningStreak > 1) {
            this.ikO.setVisibility(0);
            this.ikO.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.myPkData.winningStreak)));
        } else {
            this.ikO.setVisibility(8);
        }
        this.ikP.setText(pkInfoData.myPkData.userNickName);
        if (pkInfoData.pkStatusInfoData.anchorScore >= this.ild && pkInfoData.pkStatusInfoData.rivalScore >= this.ile) {
            this.ikQ.setText(fQ(pkInfoData.pkStatusInfoData.anchorScore) + "");
            this.ikX.setText(fQ(pkInfoData.pkStatusInfoData.rivalScore) + "");
            A(pkInfoData.pkStatusInfoData.anchorScore, pkInfoData.pkStatusInfoData.rivalScore);
        }
    }

    private void fP(long j) {
        if (j <= 0) {
            this.ilc.setVisibility(8);
        } else if (this.ikC == null || !this.ikC.isRunning()) {
            this.ilc.setVisibility(0);
            this.ikC = new com.baidu.tieba.ala.e(j * 1000, 1000L);
            this.ikC.a(new e.a() { // from class: com.baidu.tieba.ala.view.PkRankInView.5
                @Override // com.baidu.tieba.ala.e.a
                public void onTick(long j2) {
                    PkRankInView.this.ilf = Math.round(j2 / 1000.0d);
                    PkRankInView.this.ilc.setText(StringHelper.formatSecondsTime(PkRankInView.this.ilf));
                }

                @Override // com.baidu.tieba.ala.e.a
                public void onFinish() {
                    PkRankInView.this.ikC.cancelTimer();
                    if (!PkRankInView.this.gTH.isHost) {
                        PkRankInView.this.bYf();
                    }
                    PkRankInView.this.csE();
                }
            });
            this.ikC.startTimer();
        } else if (this.ilf - j >= 1) {
            this.ikC.cancelTimer();
            this.ikC = null;
            fP(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csE() {
        if (!this.gTH.getGetPkInfoModel().aLg()) {
            this.gTH.getGetPkInfoModel().a(this.gTH.aMh.aKu.userId, this.gTH.imo.pkStatusInfoData.pkID, this.gTH.aMh.mLiveInfo.room_id, this.gTH.aMh.mLiveInfo.live_id, this.gTH.isHost ? 1 : 0);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.6
            @Override // java.lang.Runnable
            public void run() {
                if (!PkRankInView.this.gTH.getGetPkInfoModel().aLg()) {
                    PkRankInView.this.gTH.getGetPkInfoModel().a(PkRankInView.this.gTH.aMh.aKu.userId, PkRankInView.this.gTH.imo.pkStatusInfoData.pkID, PkRankInView.this.gTH.aMh.mLiveInfo.room_id, PkRankInView.this.gTH.aMh.mLiveInfo.live_id, PkRankInView.this.gTH.isHost ? 1 : 0);
                }
            }
        }, this.gTH.imo.resultInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYf() {
        this.ilb.bringToFront();
        this.ilb.setVisibility(0);
        this.ilc.setVisibility(8);
    }

    private void csF() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.ili);
        pkRankPropAnim.setParentView(this.ikJ);
        a(pkRankPropAnim);
    }

    private void csG() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.ilj);
        pkRankPropAnim.setParentView(this.ikJ);
        b(pkRankPropAnim);
    }

    private void csH() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.ili);
        pkRankPropAnim.setParentView(this.ikJ);
        a(pkRankPropAnim);
    }

    private void csI() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.ilj);
        pkRankPropAnim.setParentView(this.ikJ);
        b(pkRankPropAnim);
    }

    private void csJ() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, true);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.ili);
        alaFirstBloodAnim.setParentView(this.ikJ);
        a(alaFirstBloodAnim);
    }

    private void csK() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, false);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.ilj);
        alaFirstBloodAnim.setParentView(this.ikJ);
        b(alaFirstBloodAnim);
    }

    private void cI(View view) {
        ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(300L).start();
    }

    private void a(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.ilg.peek() == null) {
            this.ilg.add(aVar);
            this.ilg.peek().startAnim();
            return;
        }
        this.ilg.add(aVar);
    }

    private void b(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.ilh.peek() == null) {
            this.ilh.add(aVar);
            this.ilh.peek().startAnim();
            return;
        }
        this.ilh.add(aVar);
    }

    public void e(JSONObject jSONObject, int i) {
        boolean z;
        if (this.gTH.ye(i)) {
            switch (i) {
                case 10:
                    PkInfoData pkInfoData = new PkInfoData();
                    JSONObject optJSONObject = jSONObject.optJSONObject("anchor");
                    pkInfoData.myPkData.userID = optJSONObject.optLong("user_id");
                    pkInfoData.myPkData.userNickName = optJSONObject.optString("nick_name");
                    pkInfoData.myPkData.bdPortrait = optJSONObject.optString("bd_portrait");
                    pkInfoData.myPkData.winningStreak = optJSONObject.optInt("win_streak");
                    pkInfoData.myPkData.divisionIcon = optJSONObject.optJSONObject("division").optString("icon_url");
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("rival_anchor");
                    pkInfoData.otherPkData.userNickName = optJSONObject2.optString("nick_name");
                    pkInfoData.otherPkData.bdPortrait = optJSONObject2.optString("bd_portrait");
                    pkInfoData.otherPkData.winningStreak = optJSONObject2.optInt("win_streak");
                    pkInfoData.otherPkData.divisionIcon = optJSONObject2.optJSONObject("division").optString("icon_url");
                    pkInfoData.pkStatusInfoData.pkID = jSONObject.optLong("pk_id");
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    z = true;
                    break;
                case 11:
                    csJ();
                    z = false;
                    break;
                case 12:
                    csH();
                    z = true;
                    break;
                case 13:
                case 15:
                case 17:
                case 18:
                case 19:
                case 20:
                case 23:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                default:
                    z = true;
                    break;
                case 14:
                    csF();
                    z = true;
                    break;
                case 16:
                    long optLong = jSONObject.optLong("honor");
                    long optLong2 = jSONObject.optLong("rival_honor");
                    if (optLong >= this.ild && optLong2 >= this.ile) {
                        this.ikX.setText(fQ(optLong2) + "");
                        this.ikQ.setText(fQ(optLong) + "");
                        A(optLong, optLong2);
                        z = false;
                        break;
                    } else {
                        return;
                    }
                case 21:
                    csK();
                    z = false;
                    break;
                case 22:
                    csI();
                    z = true;
                    break;
                case 24:
                    csG();
                    z = true;
                    break;
                case 30:
                    bYf();
                    z = true;
                    break;
            }
            if (z && !this.gTH.getGetPkInfoModel().aLg()) {
                this.gTH.getGetPkInfoModel().a(this.gTH.aMh.aKu.userId, jSONObject.optLong("pk_id"), this.gTH.aMh.mLiveInfo.room_id, this.gTH.aMh.mLiveInfo.live_id, this.gTH.isHost ? 1 : 0);
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gTH = pkRankView;
    }

    public void onDestroy() {
        if (this.gTH.getGetPkInfoModel() != null) {
            this.gTH.getGetPkInfoModel().coZ();
        }
        csB();
        if (this.ilk != null) {
            this.ilk.onDestroy();
        }
    }

    public void csB() {
        if (this.ikC != null) {
            this.ikC.cancelTimer();
            this.ikC = null;
        }
    }

    public k getPkRankPropController() {
        if (this.ilk == null) {
            this.ilk = new k(this);
        }
        return this.ilk;
    }

    public void csL() {
        this.ikR.setAlpha(1.0f);
        this.ikR.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void csM() {
        cI(this.ikR);
        this.ikR.setVisibility(8);
    }

    public void csN() {
        this.ikS.setAlpha(0.8f);
        this.ikS.setVisibility(0);
        this.ikQ.setVisibility(0);
    }

    public void csO() {
        this.ikS.setAlpha(1.0f);
        this.ikS.setVisibility(0);
        this.ikQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pf(boolean z) {
        if (z) {
            this.ikQ.setVisibility(8);
            return;
        }
        cI(this.ikS);
        this.ikS.setVisibility(8);
        this.ikQ.setVisibility(0);
    }

    public void csP() {
        this.ikY.setAlpha(1.0f);
        this.ikY.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void csQ() {
        cI(this.ikY);
        this.ikY.setVisibility(8);
    }

    public void csR() {
        this.ikZ.setAlpha(1.0f);
        this.ikZ.setVisibility(0);
        this.ikX.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pg(boolean z) {
        if (z) {
            this.ikX.setVisibility(8);
            return;
        }
        cI(this.ikZ);
        this.ikZ.setVisibility(8);
        this.ikX.setVisibility(0);
    }

    String fQ(long j) {
        if (j <= 0) {
            return "0";
        }
        String str = j + "";
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        if (j > 9999999) {
            if (j > 100000000) {
                return this.context.getString(a.h.sdk_pk_rank_yi, decimalFormat.format(((float) j) / 1.0E8f));
            }
            return this.context.getString(a.h.sdk_pk_rank_wan, decimalFormat.format(((float) j) / 10000.0f));
        }
        return str;
    }

    void A(long j, long j2) {
        if (j - this.ild >= 100) {
            ObjectAnimator.ofFloat(this.ikQ, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.ikQ, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        if (j2 - this.ile >= 100) {
            ObjectAnimator.ofFloat(this.ikX, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.ikX, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        this.ild = j;
        this.ile = j2;
    }

    public void resetView() {
        this.ild = 0L;
        this.ile = 0L;
        this.ilk.handler.removeCallbacksAndMessages(null);
        this.ikZ.setVisibility(8);
        this.ikS.setVisibility(8);
        this.ikR.setVisibility(8);
        this.ikY.setVisibility(8);
        csB();
        this.ikU.setVisibility(0);
        this.ikW.setVisibility(0);
        this.ikX.setVisibility(0);
        this.ikX.setText("0");
        this.ikN.setVisibility(0);
        this.ikP.setVisibility(0);
        this.ikQ.setVisibility(0);
        this.ikQ.setText("0");
    }
}
