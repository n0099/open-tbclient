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
import com.baidu.tieba.ala.d;
import com.baidu.tieba.ala.data.PkInfoData;
import com.baidu.tieba.ala.view.anim.AlaFirstBloodAnim;
import com.baidu.tieba.ala.view.anim.PkRankPropAnim;
import java.text.DecimalFormat;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PkRankInView extends RelativeLayout {
    Context context;
    PkRankView gjB;
    TextView hvA;
    FixedTextView hvB;
    ImageView hvC;
    ImageView hvD;
    ImageView hvE;
    TextView hvF;
    TextView hvG;
    long hvH;
    long hvI;
    long hvJ;
    Queue<com.baidu.tieba.ala.view.anim.a> hvK;
    Queue<com.baidu.tieba.ala.view.anim.a> hvL;
    public AnimatorListenerAdapter hvM;
    public AnimatorListenerAdapter hvN;
    k hvO;
    com.baidu.tieba.ala.d hvg;
    RelativeLayout hvn;
    ImageView hvo;
    ImageView hvp;
    RelativeLayout hvq;
    HeadImageView hvr;
    TextView hvs;
    TextView hvt;
    FixedTextView hvu;
    ImageView hvv;
    ImageView hvw;
    RelativeLayout hvx;
    HeadImageView hvy;
    TextView hvz;
    private View mView;
    int status;

    public PkRankInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hvK = new LinkedBlockingQueue();
        this.hvL = new LinkedBlockingQueue();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_in_layout, (ViewGroup) this, true);
        this.hvq = (RelativeLayout) this.mView.findViewById(a.g.in_top_layout);
        this.hvn = (RelativeLayout) this.mView.findViewById(a.g.background_view);
        this.hvo = (ImageView) this.mView.findViewById(a.g.top_bg);
        this.hvp = (ImageView) this.mView.findViewById(a.g.bottom_bg);
        this.hvE = (ImageView) this.mView.findViewById(a.g.pk_img);
        this.hvr = (HeadImageView) this.mView.findViewById(a.g.top_head);
        this.hvs = (TextView) this.mView.findViewById(a.g.top_wins);
        this.hvt = (TextView) this.mView.findViewById(a.g.top_name);
        this.hvu = (FixedTextView) this.mView.findViewById(a.g.top_scores);
        this.hvv = (ImageView) this.mView.findViewById(a.g.top_plus);
        this.hvw = (ImageView) this.mView.findViewById(a.g.top_scores_shade);
        this.hvr.setDefaultBgResource(a.f.sdk_default_avatar);
        this.hvr.setIsRound(true);
        this.hvr.setAutoChangeStyle(false);
        this.hvr.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.hvr.setBorderColor(872415231);
        this.hvq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gjB.y(PkRankInView.this.gjB.hwU.H5URL, PkRankInView.this.gjB.hwU.myPkData.userID);
            }
        });
        this.hvx = (RelativeLayout) this.mView.findViewById(a.g.in_bottom_layout);
        this.hvy = (HeadImageView) this.mView.findViewById(a.g.bottom_head);
        this.hvz = (TextView) this.mView.findViewById(a.g.bottom_wins);
        this.hvA = (TextView) this.mView.findViewById(a.g.bottom_name);
        this.hvB = (FixedTextView) this.mView.findViewById(a.g.bottom_scores);
        this.hvC = (ImageView) this.mView.findViewById(a.g.bottom_plus);
        this.hvD = (ImageView) this.mView.findViewById(a.g.bottom_scores_shade);
        this.hvy.setDefaultBgResource(a.f.sdk_default_avatar);
        this.hvy.setIsRound(true);
        this.hvy.setAutoChangeStyle(false);
        this.hvy.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.hvy.setBorderColor(872415231);
        this.hvx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gjB.y(PkRankInView.this.gjB.hwU.H5URL, PkRankInView.this.gjB.hwU.otherPkData.userID);
            }
        });
        this.hvF = (TextView) this.mView.findViewById(a.g.end_view);
        this.hvG = (TextView) this.mView.findViewById(a.g.timer);
        cgr();
    }

    private void cgr() {
        this.hvM = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hvE.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hvK.poll();
                if (PkRankInView.this.hvK.peek() != null) {
                    PkRankInView.this.hvK.peek().startAnim();
                }
            }
        };
        this.hvN = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hvE.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hvL.poll();
                if (PkRankInView.this.hvL.peek() != null) {
                    PkRankInView.this.hvL.peek().startAnim();
                }
            }
        };
    }

    public void a(PkInfoData pkInfoData, int i) {
        this.gjB.cgU();
        this.hvF.setVisibility(8);
        if (pkInfoData.pkStatusInfoData.pkStatus == 1) {
            eO(pkInfoData.pkStatusInfoData.stageEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        this.status = i;
        if (this.gjB.wh(i)) {
            switch (i) {
                case 10:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    d(pkInfoData);
                    return;
                case 30:
                    bNq();
                    return;
                default:
                    return;
            }
        }
    }

    private void d(PkInfoData pkInfoData) {
        this.hvy.startLoad(pkInfoData.otherPkData.bdPortrait, 12, false, false);
        if (pkInfoData.otherPkData.winningStreak > 1) {
            this.hvz.setVisibility(0);
            this.hvz.setText(this.context.getString(a.i.sdk_pk_rank_wins, String.valueOf(pkInfoData.otherPkData.winningStreak)));
        } else {
            this.hvz.setVisibility(8);
        }
        this.hvA.setText(pkInfoData.otherPkData.userNickName);
        this.hvr.startLoad(pkInfoData.myPkData.bdPortrait, 12, false, false);
        if (pkInfoData.myPkData.winningStreak > 1) {
            this.hvs.setVisibility(0);
            this.hvs.setText(this.context.getString(a.i.sdk_pk_rank_wins, String.valueOf(pkInfoData.myPkData.winningStreak)));
        } else {
            this.hvs.setVisibility(8);
        }
        this.hvt.setText(pkInfoData.myPkData.userNickName);
        if (pkInfoData.pkStatusInfoData.anchorScore >= this.hvH && pkInfoData.pkStatusInfoData.rivalScore >= this.hvI) {
            this.hvu.setText(eP(pkInfoData.pkStatusInfoData.anchorScore) + "");
            this.hvB.setText(eP(pkInfoData.pkStatusInfoData.rivalScore) + "");
            w(pkInfoData.pkStatusInfoData.anchorScore, pkInfoData.pkStatusInfoData.rivalScore);
        }
    }

    private void eO(long j) {
        if (j <= 0) {
            this.hvG.setVisibility(8);
        } else if (this.hvg == null || !this.hvg.isRunning()) {
            this.hvG.setVisibility(0);
            this.hvg = new com.baidu.tieba.ala.d(j * 1000, 1000L);
            this.hvg.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankInView.5
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j2) {
                    PkRankInView.this.hvJ = Math.round(j2 / 1000.0d);
                    PkRankInView.this.hvG.setText(StringHelper.formatSecondsTime(PkRankInView.this.hvJ));
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankInView.this.hvg.cancelTimer();
                    if (!PkRankInView.this.gjB.isHost) {
                        PkRankInView.this.bNq();
                    }
                    PkRankInView.this.cgs();
                }
            });
            this.hvg.startTimer();
        } else if (this.hvJ - j >= 1) {
            this.hvg.cancelTimer();
            this.hvg = null;
            eO(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgs() {
        if (!this.gjB.getGetPkInfoModel().isLoop()) {
            this.gjB.getGetPkInfoModel().a(this.gjB.aIT.aHD.userId, this.gjB.hwU.pkStatusInfoData.pkID, this.gjB.aIT.mLiveInfo.room_id, this.gjB.aIT.mLiveInfo.live_id, this.gjB.isHost ? 1 : 0);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.6
            @Override // java.lang.Runnable
            public void run() {
                if (!PkRankInView.this.gjB.getGetPkInfoModel().isLoop()) {
                    PkRankInView.this.gjB.getGetPkInfoModel().a(PkRankInView.this.gjB.aIT.aHD.userId, PkRankInView.this.gjB.hwU.pkStatusInfoData.pkID, PkRankInView.this.gjB.aIT.mLiveInfo.room_id, PkRankInView.this.gjB.aIT.mLiveInfo.live_id, PkRankInView.this.gjB.isHost ? 1 : 0);
                }
            }
        }, this.gjB.hwU.resultInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNq() {
        this.hvF.bringToFront();
        this.hvF.setVisibility(0);
        this.hvG.setVisibility(8);
    }

    private void cgt() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hvM);
        pkRankPropAnim.setParentView(this.hvn);
        a(pkRankPropAnim);
    }

    private void cgu() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hvN);
        pkRankPropAnim.setParentView(this.hvn);
        b(pkRankPropAnim);
    }

    private void cgv() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hvM);
        pkRankPropAnim.setParentView(this.hvn);
        a(pkRankPropAnim);
    }

    private void cgw() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hvN);
        pkRankPropAnim.setParentView(this.hvn);
        b(pkRankPropAnim);
    }

    private void cgx() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, true);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hvM);
        alaFirstBloodAnim.setParentView(this.hvn);
        a(alaFirstBloodAnim);
    }

    private void cgy() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, false);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hvN);
        alaFirstBloodAnim.setParentView(this.hvn);
        b(alaFirstBloodAnim);
    }

    private void cf(View view) {
        ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(300L).start();
    }

    private void a(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hvK.peek() == null) {
            this.hvK.add(aVar);
            this.hvK.peek().startAnim();
            return;
        }
        this.hvK.add(aVar);
    }

    private void b(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hvL.peek() == null) {
            this.hvL.add(aVar);
            this.hvL.peek().startAnim();
            return;
        }
        this.hvL.add(aVar);
    }

    public void e(JSONObject jSONObject, int i) {
        boolean z;
        if (this.gjB.wh(i)) {
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
                    cgx();
                    z = false;
                    break;
                case 12:
                    cgv();
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
                    cgt();
                    z = true;
                    break;
                case 16:
                    long optLong = jSONObject.optLong("honor");
                    long optLong2 = jSONObject.optLong("rival_honor");
                    if (optLong >= this.hvH && optLong2 >= this.hvI) {
                        this.hvB.setText(eP(optLong2) + "");
                        this.hvu.setText(eP(optLong) + "");
                        w(optLong, optLong2);
                        z = false;
                        break;
                    } else {
                        return;
                    }
                case 21:
                    cgy();
                    z = false;
                    break;
                case 22:
                    cgw();
                    z = true;
                    break;
                case 24:
                    cgu();
                    z = true;
                    break;
                case 30:
                    bNq();
                    z = true;
                    break;
            }
            if (z && !this.gjB.getGetPkInfoModel().isLoop()) {
                this.gjB.getGetPkInfoModel().a(this.gjB.aIT.aHD.userId, jSONObject.optLong("pk_id"), this.gjB.aIT.mLiveInfo.room_id, this.gjB.aIT.mLiveInfo.live_id, this.gjB.isHost ? 1 : 0);
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gjB = pkRankView;
    }

    public void onDestroy() {
        if (this.gjB.getGetPkInfoModel() != null) {
            this.gjB.getGetPkInfoModel().cdp();
        }
        cgp();
        if (this.hvO != null) {
            this.hvO.onDestroy();
        }
    }

    public void cgp() {
        if (this.hvg != null) {
            this.hvg.cancelTimer();
            this.hvg = null;
        }
    }

    public k getPkRankPropController() {
        if (this.hvO == null) {
            this.hvO = new k(this);
        }
        return this.hvO;
    }

    public void cgz() {
        this.hvv.setAlpha(1.0f);
        this.hvv.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cgA() {
        cf(this.hvv);
        this.hvv.setVisibility(8);
    }

    public void cgB() {
        this.hvw.setAlpha(0.8f);
        this.hvw.setVisibility(0);
        this.hvu.setVisibility(0);
    }

    public void cgC() {
        this.hvw.setAlpha(1.0f);
        this.hvw.setVisibility(0);
        this.hvu.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nI(boolean z) {
        if (z) {
            this.hvu.setVisibility(8);
            return;
        }
        cf(this.hvw);
        this.hvw.setVisibility(8);
        this.hvu.setVisibility(0);
    }

    public void cgD() {
        this.hvC.setAlpha(1.0f);
        this.hvC.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cgE() {
        cf(this.hvC);
        this.hvC.setVisibility(8);
    }

    public void cgF() {
        this.hvD.setAlpha(1.0f);
        this.hvD.setVisibility(0);
        this.hvB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nJ(boolean z) {
        if (z) {
            this.hvB.setVisibility(8);
            return;
        }
        cf(this.hvD);
        this.hvD.setVisibility(8);
        this.hvB.setVisibility(0);
    }

    String eP(long j) {
        if (j <= 0) {
            return "0";
        }
        String str = j + "";
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        if (j > 9999999) {
            if (j > 100000000) {
                return this.context.getString(a.i.sdk_pk_rank_yi, decimalFormat.format(((float) j) / 1.0E8f));
            }
            return this.context.getString(a.i.sdk_pk_rank_wan, decimalFormat.format(((float) j) / 10000.0f));
        }
        return str;
    }

    void w(long j, long j2) {
        if (j - this.hvH >= 100) {
            ObjectAnimator.ofFloat(this.hvu, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hvu, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        if (j2 - this.hvI >= 100) {
            ObjectAnimator.ofFloat(this.hvB, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hvB, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        this.hvH = j;
        this.hvI = j2;
    }

    public void resetView() {
        this.hvH = 0L;
        this.hvI = 0L;
        this.hvO.handler.removeCallbacksAndMessages(null);
        this.hvD.setVisibility(8);
        this.hvw.setVisibility(8);
        this.hvv.setVisibility(8);
        this.hvC.setVisibility(8);
        cgp();
        this.hvy.setVisibility(0);
        this.hvA.setVisibility(0);
        this.hvB.setVisibility(0);
        this.hvB.setText("0");
        this.hvr.setVisibility(0);
        this.hvt.setVisibility(0);
        this.hvu.setVisibility(0);
        this.hvu.setText("0");
    }
}
