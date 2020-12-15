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
    PkRankView gHV;
    ImageView hYA;
    ImageView hYB;
    TextView hYC;
    TextView hYD;
    long hYE;
    long hYF;
    long hYG;
    Queue<com.baidu.tieba.ala.view.anim.a> hYH;
    Queue<com.baidu.tieba.ala.view.anim.a> hYI;
    public AnimatorListenerAdapter hYJ;
    public AnimatorListenerAdapter hYK;
    k hYL;
    com.baidu.tieba.ala.d hYd;
    RelativeLayout hYk;
    ImageView hYl;
    ImageView hYm;
    RelativeLayout hYn;
    HeadImageView hYo;
    TextView hYp;
    TextView hYq;
    FixedTextView hYr;
    ImageView hYs;
    ImageView hYt;
    RelativeLayout hYu;
    HeadImageView hYv;
    TextView hYw;
    TextView hYx;
    FixedTextView hYy;
    ImageView hYz;
    private View mView;
    int status;

    public PkRankInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYH = new LinkedBlockingQueue();
        this.hYI = new LinkedBlockingQueue();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_in_layout, (ViewGroup) this, true);
        this.hYn = (RelativeLayout) this.mView.findViewById(a.f.in_top_layout);
        this.hYk = (RelativeLayout) this.mView.findViewById(a.f.background_view);
        this.hYl = (ImageView) this.mView.findViewById(a.f.top_bg);
        this.hYm = (ImageView) this.mView.findViewById(a.f.bottom_bg);
        this.hYB = (ImageView) this.mView.findViewById(a.f.pk_img);
        this.hYo = (HeadImageView) this.mView.findViewById(a.f.top_head);
        this.hYp = (TextView) this.mView.findViewById(a.f.top_wins);
        this.hYq = (TextView) this.mView.findViewById(a.f.top_name);
        this.hYr = (FixedTextView) this.mView.findViewById(a.f.top_scores);
        this.hYs = (ImageView) this.mView.findViewById(a.f.top_plus);
        this.hYt = (ImageView) this.mView.findViewById(a.f.top_scores_shade);
        this.hYo.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hYo.setIsRound(true);
        this.hYo.setAutoChangeStyle(false);
        this.hYo.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.hYo.setBorderColor(872415231);
        this.hYn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gHV.B(PkRankInView.this.gHV.hZO.H5URL, PkRankInView.this.gHV.hZO.myPkData.userID);
            }
        });
        this.hYu = (RelativeLayout) this.mView.findViewById(a.f.in_bottom_layout);
        this.hYv = (HeadImageView) this.mView.findViewById(a.f.bottom_head);
        this.hYw = (TextView) this.mView.findViewById(a.f.bottom_wins);
        this.hYx = (TextView) this.mView.findViewById(a.f.bottom_name);
        this.hYy = (FixedTextView) this.mView.findViewById(a.f.bottom_scores);
        this.hYz = (ImageView) this.mView.findViewById(a.f.bottom_plus);
        this.hYA = (ImageView) this.mView.findViewById(a.f.bottom_scores_shade);
        this.hYv.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hYv.setIsRound(true);
        this.hYv.setAutoChangeStyle(false);
        this.hYv.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.hYv.setBorderColor(872415231);
        this.hYu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gHV.B(PkRankInView.this.gHV.hZO.H5URL, PkRankInView.this.gHV.hZO.otherPkData.userID);
            }
        });
        this.hYC = (TextView) this.mView.findViewById(a.f.end_view);
        this.hYD = (TextView) this.mView.findViewById(a.f.timer);
        cpJ();
    }

    private void cpJ() {
        this.hYJ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hYB.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hYH.poll();
                if (PkRankInView.this.hYH.peek() != null) {
                    PkRankInView.this.hYH.peek().startAnim();
                }
            }
        };
        this.hYK = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hYB.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hYI.poll();
                if (PkRankInView.this.hYI.peek() != null) {
                    PkRankInView.this.hYI.peek().startAnim();
                }
            }
        };
    }

    public void a(PkInfoData pkInfoData, int i) {
        this.gHV.cqk();
        this.hYC.setVisibility(8);
        if (pkInfoData.pkStatusInfoData.pkStatus == 1) {
            fP(pkInfoData.pkStatusInfoData.stageEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        this.status = i;
        if (this.gHV.xR(i)) {
            switch (i) {
                case 10:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    d(pkInfoData);
                    return;
                case 30:
                    bVz();
                    return;
                default:
                    return;
            }
        }
    }

    private void d(PkInfoData pkInfoData) {
        this.hYv.startLoad(pkInfoData.otherPkData.bdPortrait, 12, false, false);
        if (pkInfoData.otherPkData.winningStreak > 1) {
            this.hYw.setVisibility(0);
            this.hYw.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.otherPkData.winningStreak)));
        } else {
            this.hYw.setVisibility(8);
        }
        this.hYx.setText(pkInfoData.otherPkData.userNickName);
        this.hYo.startLoad(pkInfoData.myPkData.bdPortrait, 12, false, false);
        if (pkInfoData.myPkData.winningStreak > 1) {
            this.hYp.setVisibility(0);
            this.hYp.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.myPkData.winningStreak)));
        } else {
            this.hYp.setVisibility(8);
        }
        this.hYq.setText(pkInfoData.myPkData.userNickName);
        if (pkInfoData.pkStatusInfoData.anchorScore >= this.hYE && pkInfoData.pkStatusInfoData.rivalScore >= this.hYF) {
            this.hYr.setText(fQ(pkInfoData.pkStatusInfoData.anchorScore) + "");
            this.hYy.setText(fQ(pkInfoData.pkStatusInfoData.rivalScore) + "");
            x(pkInfoData.pkStatusInfoData.anchorScore, pkInfoData.pkStatusInfoData.rivalScore);
        }
    }

    private void fP(long j) {
        if (j <= 0) {
            this.hYD.setVisibility(8);
        } else if (this.hYd == null || !this.hYd.isRunning()) {
            this.hYD.setVisibility(0);
            this.hYd = new com.baidu.tieba.ala.d(j * 1000, 1000L);
            this.hYd.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankInView.5
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j2) {
                    PkRankInView.this.hYG = Math.round(j2 / 1000.0d);
                    PkRankInView.this.hYD.setText(StringHelper.formatSecondsTime(PkRankInView.this.hYG));
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankInView.this.hYd.cancelTimer();
                    if (!PkRankInView.this.gHV.isHost) {
                        PkRankInView.this.bVz();
                    }
                    PkRankInView.this.cpK();
                }
            });
            this.hYd.startTimer();
        } else if (this.hYG - j >= 1) {
            this.hYd.cancelTimer();
            this.hYd = null;
            fP(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpK() {
        if (!this.gHV.getGetPkInfoModel().isLoop()) {
            this.gHV.getGetPkInfoModel().a(this.gHV.aLD.aJV.userId, this.gHV.hZO.pkStatusInfoData.pkID, this.gHV.aLD.mLiveInfo.room_id, this.gHV.aLD.mLiveInfo.live_id, this.gHV.isHost ? 1 : 0);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.6
            @Override // java.lang.Runnable
            public void run() {
                if (!PkRankInView.this.gHV.getGetPkInfoModel().isLoop()) {
                    PkRankInView.this.gHV.getGetPkInfoModel().a(PkRankInView.this.gHV.aLD.aJV.userId, PkRankInView.this.gHV.hZO.pkStatusInfoData.pkID, PkRankInView.this.gHV.aLD.mLiveInfo.room_id, PkRankInView.this.gHV.aLD.mLiveInfo.live_id, PkRankInView.this.gHV.isHost ? 1 : 0);
                }
            }
        }, this.gHV.hZO.resultInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVz() {
        this.hYC.bringToFront();
        this.hYC.setVisibility(0);
        this.hYD.setVisibility(8);
    }

    private void cpL() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hYJ);
        pkRankPropAnim.setParentView(this.hYk);
        a(pkRankPropAnim);
    }

    private void cpM() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hYK);
        pkRankPropAnim.setParentView(this.hYk);
        b(pkRankPropAnim);
    }

    private void cpN() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hYJ);
        pkRankPropAnim.setParentView(this.hYk);
        a(pkRankPropAnim);
    }

    private void cpO() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hYK);
        pkRankPropAnim.setParentView(this.hYk);
        b(pkRankPropAnim);
    }

    private void cpP() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, true);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hYJ);
        alaFirstBloodAnim.setParentView(this.hYk);
        a(alaFirstBloodAnim);
    }

    private void cpQ() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, false);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hYK);
        alaFirstBloodAnim.setParentView(this.hYk);
        b(alaFirstBloodAnim);
    }

    private void cy(View view) {
        ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(300L).start();
    }

    private void a(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hYH.peek() == null) {
            this.hYH.add(aVar);
            this.hYH.peek().startAnim();
            return;
        }
        this.hYH.add(aVar);
    }

    private void b(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hYI.peek() == null) {
            this.hYI.add(aVar);
            this.hYI.peek().startAnim();
            return;
        }
        this.hYI.add(aVar);
    }

    public void e(JSONObject jSONObject, int i) {
        boolean z;
        if (this.gHV.xR(i)) {
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
                    cpP();
                    z = false;
                    break;
                case 12:
                    cpN();
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
                    cpL();
                    z = true;
                    break;
                case 16:
                    long optLong = jSONObject.optLong("honor");
                    long optLong2 = jSONObject.optLong("rival_honor");
                    if (optLong >= this.hYE && optLong2 >= this.hYF) {
                        this.hYy.setText(fQ(optLong2) + "");
                        this.hYr.setText(fQ(optLong) + "");
                        x(optLong, optLong2);
                        z = false;
                        break;
                    } else {
                        return;
                    }
                case 21:
                    cpQ();
                    z = false;
                    break;
                case 22:
                    cpO();
                    z = true;
                    break;
                case 24:
                    cpM();
                    z = true;
                    break;
                case 30:
                    bVz();
                    z = true;
                    break;
            }
            if (z && !this.gHV.getGetPkInfoModel().isLoop()) {
                this.gHV.getGetPkInfoModel().a(this.gHV.aLD.aJV.userId, jSONObject.optLong("pk_id"), this.gHV.aLD.mLiveInfo.room_id, this.gHV.aLD.mLiveInfo.live_id, this.gHV.isHost ? 1 : 0);
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gHV = pkRankView;
    }

    public void onDestroy() {
        if (this.gHV.getGetPkInfoModel() != null) {
            this.gHV.getGetPkInfoModel().cmh();
        }
        cpH();
        if (this.hYL != null) {
            this.hYL.onDestroy();
        }
    }

    public void cpH() {
        if (this.hYd != null) {
            this.hYd.cancelTimer();
            this.hYd = null;
        }
    }

    public k getPkRankPropController() {
        if (this.hYL == null) {
            this.hYL = new k(this);
        }
        return this.hYL;
    }

    public void cpR() {
        this.hYs.setAlpha(1.0f);
        this.hYs.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cpS() {
        cy(this.hYs);
        this.hYs.setVisibility(8);
    }

    public void cpT() {
        this.hYt.setAlpha(0.8f);
        this.hYt.setVisibility(0);
        this.hYr.setVisibility(0);
    }

    public void cpU() {
        this.hYt.setAlpha(1.0f);
        this.hYt.setVisibility(0);
        this.hYr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oG(boolean z) {
        if (z) {
            this.hYr.setVisibility(8);
            return;
        }
        cy(this.hYt);
        this.hYt.setVisibility(8);
        this.hYr.setVisibility(0);
    }

    public void cpV() {
        this.hYz.setAlpha(1.0f);
        this.hYz.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cpW() {
        cy(this.hYz);
        this.hYz.setVisibility(8);
    }

    public void cpX() {
        this.hYA.setAlpha(1.0f);
        this.hYA.setVisibility(0);
        this.hYy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oH(boolean z) {
        if (z) {
            this.hYy.setVisibility(8);
            return;
        }
        cy(this.hYA);
        this.hYA.setVisibility(8);
        this.hYy.setVisibility(0);
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
        if (j - this.hYE >= 100) {
            ObjectAnimator.ofFloat(this.hYr, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hYr, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        if (j2 - this.hYF >= 100) {
            ObjectAnimator.ofFloat(this.hYy, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hYy, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        this.hYE = j;
        this.hYF = j2;
    }

    public void resetView() {
        this.hYE = 0L;
        this.hYF = 0L;
        this.hYL.handler.removeCallbacksAndMessages(null);
        this.hYA.setVisibility(8);
        this.hYt.setVisibility(8);
        this.hYs.setVisibility(8);
        this.hYz.setVisibility(8);
        cpH();
        this.hYv.setVisibility(0);
        this.hYx.setVisibility(0);
        this.hYy.setVisibility(0);
        this.hYy.setText("0");
        this.hYo.setVisibility(0);
        this.hYq.setVisibility(0);
        this.hYr.setVisibility(0);
        this.hYr.setText("0");
    }
}
