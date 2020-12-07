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
    PkRankView gHT;
    TextView hYA;
    TextView hYB;
    long hYC;
    long hYD;
    long hYE;
    Queue<com.baidu.tieba.ala.view.anim.a> hYF;
    Queue<com.baidu.tieba.ala.view.anim.a> hYG;
    public AnimatorListenerAdapter hYH;
    public AnimatorListenerAdapter hYI;
    k hYJ;
    com.baidu.tieba.ala.d hYb;
    RelativeLayout hYi;
    ImageView hYj;
    ImageView hYk;
    RelativeLayout hYl;
    HeadImageView hYm;
    TextView hYn;
    TextView hYo;
    FixedTextView hYp;
    ImageView hYq;
    ImageView hYr;
    RelativeLayout hYs;
    HeadImageView hYt;
    TextView hYu;
    TextView hYv;
    FixedTextView hYw;
    ImageView hYx;
    ImageView hYy;
    ImageView hYz;
    private View mView;
    int status;

    public PkRankInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYF = new LinkedBlockingQueue();
        this.hYG = new LinkedBlockingQueue();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_in_layout, (ViewGroup) this, true);
        this.hYl = (RelativeLayout) this.mView.findViewById(a.f.in_top_layout);
        this.hYi = (RelativeLayout) this.mView.findViewById(a.f.background_view);
        this.hYj = (ImageView) this.mView.findViewById(a.f.top_bg);
        this.hYk = (ImageView) this.mView.findViewById(a.f.bottom_bg);
        this.hYz = (ImageView) this.mView.findViewById(a.f.pk_img);
        this.hYm = (HeadImageView) this.mView.findViewById(a.f.top_head);
        this.hYn = (TextView) this.mView.findViewById(a.f.top_wins);
        this.hYo = (TextView) this.mView.findViewById(a.f.top_name);
        this.hYp = (FixedTextView) this.mView.findViewById(a.f.top_scores);
        this.hYq = (ImageView) this.mView.findViewById(a.f.top_plus);
        this.hYr = (ImageView) this.mView.findViewById(a.f.top_scores_shade);
        this.hYm.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hYm.setIsRound(true);
        this.hYm.setAutoChangeStyle(false);
        this.hYm.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.hYm.setBorderColor(872415231);
        this.hYl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gHT.B(PkRankInView.this.gHT.hZM.H5URL, PkRankInView.this.gHT.hZM.myPkData.userID);
            }
        });
        this.hYs = (RelativeLayout) this.mView.findViewById(a.f.in_bottom_layout);
        this.hYt = (HeadImageView) this.mView.findViewById(a.f.bottom_head);
        this.hYu = (TextView) this.mView.findViewById(a.f.bottom_wins);
        this.hYv = (TextView) this.mView.findViewById(a.f.bottom_name);
        this.hYw = (FixedTextView) this.mView.findViewById(a.f.bottom_scores);
        this.hYx = (ImageView) this.mView.findViewById(a.f.bottom_plus);
        this.hYy = (ImageView) this.mView.findViewById(a.f.bottom_scores_shade);
        this.hYt.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hYt.setIsRound(true);
        this.hYt.setAutoChangeStyle(false);
        this.hYt.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.hYt.setBorderColor(872415231);
        this.hYs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gHT.B(PkRankInView.this.gHT.hZM.H5URL, PkRankInView.this.gHT.hZM.otherPkData.userID);
            }
        });
        this.hYA = (TextView) this.mView.findViewById(a.f.end_view);
        this.hYB = (TextView) this.mView.findViewById(a.f.timer);
        cpI();
    }

    private void cpI() {
        this.hYH = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hYz.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hYF.poll();
                if (PkRankInView.this.hYF.peek() != null) {
                    PkRankInView.this.hYF.peek().startAnim();
                }
            }
        };
        this.hYI = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hYz.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hYG.poll();
                if (PkRankInView.this.hYG.peek() != null) {
                    PkRankInView.this.hYG.peek().startAnim();
                }
            }
        };
    }

    public void a(PkInfoData pkInfoData, int i) {
        this.gHT.cqj();
        this.hYA.setVisibility(8);
        if (pkInfoData.pkStatusInfoData.pkStatus == 1) {
            fP(pkInfoData.pkStatusInfoData.stageEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        this.status = i;
        if (this.gHT.xR(i)) {
            switch (i) {
                case 10:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    d(pkInfoData);
                    return;
                case 30:
                    bVy();
                    return;
                default:
                    return;
            }
        }
    }

    private void d(PkInfoData pkInfoData) {
        this.hYt.startLoad(pkInfoData.otherPkData.bdPortrait, 12, false, false);
        if (pkInfoData.otherPkData.winningStreak > 1) {
            this.hYu.setVisibility(0);
            this.hYu.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.otherPkData.winningStreak)));
        } else {
            this.hYu.setVisibility(8);
        }
        this.hYv.setText(pkInfoData.otherPkData.userNickName);
        this.hYm.startLoad(pkInfoData.myPkData.bdPortrait, 12, false, false);
        if (pkInfoData.myPkData.winningStreak > 1) {
            this.hYn.setVisibility(0);
            this.hYn.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.myPkData.winningStreak)));
        } else {
            this.hYn.setVisibility(8);
        }
        this.hYo.setText(pkInfoData.myPkData.userNickName);
        if (pkInfoData.pkStatusInfoData.anchorScore >= this.hYC && pkInfoData.pkStatusInfoData.rivalScore >= this.hYD) {
            this.hYp.setText(fQ(pkInfoData.pkStatusInfoData.anchorScore) + "");
            this.hYw.setText(fQ(pkInfoData.pkStatusInfoData.rivalScore) + "");
            x(pkInfoData.pkStatusInfoData.anchorScore, pkInfoData.pkStatusInfoData.rivalScore);
        }
    }

    private void fP(long j) {
        if (j <= 0) {
            this.hYB.setVisibility(8);
        } else if (this.hYb == null || !this.hYb.isRunning()) {
            this.hYB.setVisibility(0);
            this.hYb = new com.baidu.tieba.ala.d(j * 1000, 1000L);
            this.hYb.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankInView.5
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j2) {
                    PkRankInView.this.hYE = Math.round(j2 / 1000.0d);
                    PkRankInView.this.hYB.setText(StringHelper.formatSecondsTime(PkRankInView.this.hYE));
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankInView.this.hYb.cancelTimer();
                    if (!PkRankInView.this.gHT.isHost) {
                        PkRankInView.this.bVy();
                    }
                    PkRankInView.this.cpJ();
                }
            });
            this.hYb.startTimer();
        } else if (this.hYE - j >= 1) {
            this.hYb.cancelTimer();
            this.hYb = null;
            fP(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpJ() {
        if (!this.gHT.getGetPkInfoModel().isLoop()) {
            this.gHT.getGetPkInfoModel().a(this.gHT.aLD.aJV.userId, this.gHT.hZM.pkStatusInfoData.pkID, this.gHT.aLD.mLiveInfo.room_id, this.gHT.aLD.mLiveInfo.live_id, this.gHT.isHost ? 1 : 0);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.6
            @Override // java.lang.Runnable
            public void run() {
                if (!PkRankInView.this.gHT.getGetPkInfoModel().isLoop()) {
                    PkRankInView.this.gHT.getGetPkInfoModel().a(PkRankInView.this.gHT.aLD.aJV.userId, PkRankInView.this.gHT.hZM.pkStatusInfoData.pkID, PkRankInView.this.gHT.aLD.mLiveInfo.room_id, PkRankInView.this.gHT.aLD.mLiveInfo.live_id, PkRankInView.this.gHT.isHost ? 1 : 0);
                }
            }
        }, this.gHT.hZM.resultInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVy() {
        this.hYA.bringToFront();
        this.hYA.setVisibility(0);
        this.hYB.setVisibility(8);
    }

    private void cpK() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hYH);
        pkRankPropAnim.setParentView(this.hYi);
        a(pkRankPropAnim);
    }

    private void cpL() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hYI);
        pkRankPropAnim.setParentView(this.hYi);
        b(pkRankPropAnim);
    }

    private void cpM() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hYH);
        pkRankPropAnim.setParentView(this.hYi);
        a(pkRankPropAnim);
    }

    private void cpN() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hYI);
        pkRankPropAnim.setParentView(this.hYi);
        b(pkRankPropAnim);
    }

    private void cpO() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, true);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hYH);
        alaFirstBloodAnim.setParentView(this.hYi);
        a(alaFirstBloodAnim);
    }

    private void cpP() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, false);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hYI);
        alaFirstBloodAnim.setParentView(this.hYi);
        b(alaFirstBloodAnim);
    }

    private void cy(View view) {
        ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(300L).start();
    }

    private void a(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hYF.peek() == null) {
            this.hYF.add(aVar);
            this.hYF.peek().startAnim();
            return;
        }
        this.hYF.add(aVar);
    }

    private void b(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hYG.peek() == null) {
            this.hYG.add(aVar);
            this.hYG.peek().startAnim();
            return;
        }
        this.hYG.add(aVar);
    }

    public void e(JSONObject jSONObject, int i) {
        boolean z;
        if (this.gHT.xR(i)) {
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
                    cpO();
                    z = false;
                    break;
                case 12:
                    cpM();
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
                    cpK();
                    z = true;
                    break;
                case 16:
                    long optLong = jSONObject.optLong("honor");
                    long optLong2 = jSONObject.optLong("rival_honor");
                    if (optLong >= this.hYC && optLong2 >= this.hYD) {
                        this.hYw.setText(fQ(optLong2) + "");
                        this.hYp.setText(fQ(optLong) + "");
                        x(optLong, optLong2);
                        z = false;
                        break;
                    } else {
                        return;
                    }
                case 21:
                    cpP();
                    z = false;
                    break;
                case 22:
                    cpN();
                    z = true;
                    break;
                case 24:
                    cpL();
                    z = true;
                    break;
                case 30:
                    bVy();
                    z = true;
                    break;
            }
            if (z && !this.gHT.getGetPkInfoModel().isLoop()) {
                this.gHT.getGetPkInfoModel().a(this.gHT.aLD.aJV.userId, jSONObject.optLong("pk_id"), this.gHT.aLD.mLiveInfo.room_id, this.gHT.aLD.mLiveInfo.live_id, this.gHT.isHost ? 1 : 0);
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gHT = pkRankView;
    }

    public void onDestroy() {
        if (this.gHT.getGetPkInfoModel() != null) {
            this.gHT.getGetPkInfoModel().cmg();
        }
        cpG();
        if (this.hYJ != null) {
            this.hYJ.onDestroy();
        }
    }

    public void cpG() {
        if (this.hYb != null) {
            this.hYb.cancelTimer();
            this.hYb = null;
        }
    }

    public k getPkRankPropController() {
        if (this.hYJ == null) {
            this.hYJ = new k(this);
        }
        return this.hYJ;
    }

    public void cpQ() {
        this.hYq.setAlpha(1.0f);
        this.hYq.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cpR() {
        cy(this.hYq);
        this.hYq.setVisibility(8);
    }

    public void cpS() {
        this.hYr.setAlpha(0.8f);
        this.hYr.setVisibility(0);
        this.hYp.setVisibility(0);
    }

    public void cpT() {
        this.hYr.setAlpha(1.0f);
        this.hYr.setVisibility(0);
        this.hYp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oG(boolean z) {
        if (z) {
            this.hYp.setVisibility(8);
            return;
        }
        cy(this.hYr);
        this.hYr.setVisibility(8);
        this.hYp.setVisibility(0);
    }

    public void cpU() {
        this.hYx.setAlpha(1.0f);
        this.hYx.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cpV() {
        cy(this.hYx);
        this.hYx.setVisibility(8);
    }

    public void cpW() {
        this.hYy.setAlpha(1.0f);
        this.hYy.setVisibility(0);
        this.hYw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oH(boolean z) {
        if (z) {
            this.hYw.setVisibility(8);
            return;
        }
        cy(this.hYy);
        this.hYy.setVisibility(8);
        this.hYw.setVisibility(0);
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

    void x(long j, long j2) {
        if (j - this.hYC >= 100) {
            ObjectAnimator.ofFloat(this.hYp, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hYp, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        if (j2 - this.hYD >= 100) {
            ObjectAnimator.ofFloat(this.hYw, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hYw, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        this.hYC = j;
        this.hYD = j2;
    }

    public void resetView() {
        this.hYC = 0L;
        this.hYD = 0L;
        this.hYJ.handler.removeCallbacksAndMessages(null);
        this.hYy.setVisibility(8);
        this.hYr.setVisibility(8);
        this.hYq.setVisibility(8);
        this.hYx.setVisibility(8);
        cpG();
        this.hYt.setVisibility(0);
        this.hYv.setVisibility(0);
        this.hYw.setVisibility(0);
        this.hYw.setText("0");
        this.hYm.setVisibility(0);
        this.hYo.setVisibility(0);
        this.hYp.setVisibility(0);
        this.hYp.setText("0");
    }
}
