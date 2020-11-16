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
    PkRankView gyX;
    TextView hNA;
    TextView hNB;
    FixedTextView hNC;
    ImageView hND;
    ImageView hNE;
    ImageView hNF;
    TextView hNG;
    TextView hNH;
    long hNI;
    long hNJ;
    long hNK;
    Queue<com.baidu.tieba.ala.view.anim.a> hNL;
    Queue<com.baidu.tieba.ala.view.anim.a> hNM;
    public AnimatorListenerAdapter hNN;
    public AnimatorListenerAdapter hNO;
    k hNP;
    com.baidu.tieba.ala.d hNh;
    RelativeLayout hNo;
    ImageView hNp;
    ImageView hNq;
    RelativeLayout hNr;
    HeadImageView hNs;
    TextView hNt;
    TextView hNu;
    FixedTextView hNv;
    ImageView hNw;
    ImageView hNx;
    RelativeLayout hNy;
    HeadImageView hNz;
    private View mView;
    int status;

    public PkRankInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNL = new LinkedBlockingQueue();
        this.hNM = new LinkedBlockingQueue();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_in_layout, (ViewGroup) this, true);
        this.hNr = (RelativeLayout) this.mView.findViewById(a.f.in_top_layout);
        this.hNo = (RelativeLayout) this.mView.findViewById(a.f.background_view);
        this.hNp = (ImageView) this.mView.findViewById(a.f.top_bg);
        this.hNq = (ImageView) this.mView.findViewById(a.f.bottom_bg);
        this.hNF = (ImageView) this.mView.findViewById(a.f.pk_img);
        this.hNs = (HeadImageView) this.mView.findViewById(a.f.top_head);
        this.hNt = (TextView) this.mView.findViewById(a.f.top_wins);
        this.hNu = (TextView) this.mView.findViewById(a.f.top_name);
        this.hNv = (FixedTextView) this.mView.findViewById(a.f.top_scores);
        this.hNw = (ImageView) this.mView.findViewById(a.f.top_plus);
        this.hNx = (ImageView) this.mView.findViewById(a.f.top_scores_shade);
        this.hNs.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hNs.setIsRound(true);
        this.hNs.setAutoChangeStyle(false);
        this.hNs.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.hNs.setBorderColor(872415231);
        this.hNr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gyX.B(PkRankInView.this.gyX.hOV.H5URL, PkRankInView.this.gyX.hOV.myPkData.userID);
            }
        });
        this.hNy = (RelativeLayout) this.mView.findViewById(a.f.in_bottom_layout);
        this.hNz = (HeadImageView) this.mView.findViewById(a.f.bottom_head);
        this.hNA = (TextView) this.mView.findViewById(a.f.bottom_wins);
        this.hNB = (TextView) this.mView.findViewById(a.f.bottom_name);
        this.hNC = (FixedTextView) this.mView.findViewById(a.f.bottom_scores);
        this.hND = (ImageView) this.mView.findViewById(a.f.bottom_plus);
        this.hNE = (ImageView) this.mView.findViewById(a.f.bottom_scores_shade);
        this.hNz.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hNz.setIsRound(true);
        this.hNz.setAutoChangeStyle(false);
        this.hNz.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.hNz.setBorderColor(872415231);
        this.hNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gyX.B(PkRankInView.this.gyX.hOV.H5URL, PkRankInView.this.gyX.hOV.otherPkData.userID);
            }
        });
        this.hNG = (TextView) this.mView.findViewById(a.f.end_view);
        this.hNH = (TextView) this.mView.findViewById(a.f.timer);
        clt();
    }

    private void clt() {
        this.hNN = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hNF.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hNL.poll();
                if (PkRankInView.this.hNL.peek() != null) {
                    PkRankInView.this.hNL.peek().startAnim();
                }
            }
        };
        this.hNO = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hNF.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hNM.poll();
                if (PkRankInView.this.hNM.peek() != null) {
                    PkRankInView.this.hNM.peek().startAnim();
                }
            }
        };
    }

    public void a(PkInfoData pkInfoData, int i) {
        this.gyX.clW();
        this.hNG.setVisibility(8);
        if (pkInfoData.pkStatusInfoData.pkStatus == 1) {
            fl(pkInfoData.pkStatusInfoData.stageEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        this.status = i;
        if (this.gyX.xl(i)) {
            switch (i) {
                case 10:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    d(pkInfoData);
                    return;
                case 30:
                    bRO();
                    return;
                default:
                    return;
            }
        }
    }

    private void d(PkInfoData pkInfoData) {
        this.hNz.startLoad(pkInfoData.otherPkData.bdPortrait, 12, false, false);
        if (pkInfoData.otherPkData.winningStreak > 1) {
            this.hNA.setVisibility(0);
            this.hNA.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.otherPkData.winningStreak)));
        } else {
            this.hNA.setVisibility(8);
        }
        this.hNB.setText(pkInfoData.otherPkData.userNickName);
        this.hNs.startLoad(pkInfoData.myPkData.bdPortrait, 12, false, false);
        if (pkInfoData.myPkData.winningStreak > 1) {
            this.hNt.setVisibility(0);
            this.hNt.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.myPkData.winningStreak)));
        } else {
            this.hNt.setVisibility(8);
        }
        this.hNu.setText(pkInfoData.myPkData.userNickName);
        if (pkInfoData.pkStatusInfoData.anchorScore >= this.hNI && pkInfoData.pkStatusInfoData.rivalScore >= this.hNJ) {
            this.hNv.setText(fm(pkInfoData.pkStatusInfoData.anchorScore) + "");
            this.hNC.setText(fm(pkInfoData.pkStatusInfoData.rivalScore) + "");
            x(pkInfoData.pkStatusInfoData.anchorScore, pkInfoData.pkStatusInfoData.rivalScore);
        }
    }

    private void fl(long j) {
        if (j <= 0) {
            this.hNH.setVisibility(8);
        } else if (this.hNh == null || !this.hNh.isRunning()) {
            this.hNH.setVisibility(0);
            this.hNh = new com.baidu.tieba.ala.d(j * 1000, 1000L);
            this.hNh.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankInView.5
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j2) {
                    PkRankInView.this.hNK = Math.round(j2 / 1000.0d);
                    PkRankInView.this.hNH.setText(StringHelper.formatSecondsTime(PkRankInView.this.hNK));
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankInView.this.hNh.cancelTimer();
                    if (!PkRankInView.this.gyX.isHost) {
                        PkRankInView.this.bRO();
                    }
                    PkRankInView.this.clu();
                }
            });
            this.hNh.startTimer();
        } else if (this.hNK - j >= 1) {
            this.hNh.cancelTimer();
            this.hNh = null;
            fl(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clu() {
        if (!this.gyX.getGetPkInfoModel().isLoop()) {
            this.gyX.getGetPkInfoModel().a(this.gyX.aIK.aHk.userId, this.gyX.hOV.pkStatusInfoData.pkID, this.gyX.aIK.mLiveInfo.room_id, this.gyX.aIK.mLiveInfo.live_id, this.gyX.isHost ? 1 : 0);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.6
            @Override // java.lang.Runnable
            public void run() {
                if (!PkRankInView.this.gyX.getGetPkInfoModel().isLoop()) {
                    PkRankInView.this.gyX.getGetPkInfoModel().a(PkRankInView.this.gyX.aIK.aHk.userId, PkRankInView.this.gyX.hOV.pkStatusInfoData.pkID, PkRankInView.this.gyX.aIK.mLiveInfo.room_id, PkRankInView.this.gyX.aIK.mLiveInfo.live_id, PkRankInView.this.gyX.isHost ? 1 : 0);
                }
            }
        }, this.gyX.hOV.resultInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRO() {
        this.hNG.bringToFront();
        this.hNG.setVisibility(0);
        this.hNH.setVisibility(8);
    }

    private void clv() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hNN);
        pkRankPropAnim.setParentView(this.hNo);
        a(pkRankPropAnim);
    }

    private void clw() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hNO);
        pkRankPropAnim.setParentView(this.hNo);
        b(pkRankPropAnim);
    }

    private void clx() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hNN);
        pkRankPropAnim.setParentView(this.hNo);
        a(pkRankPropAnim);
    }

    private void cly() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hNO);
        pkRankPropAnim.setParentView(this.hNo);
        b(pkRankPropAnim);
    }

    private void clz() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, true);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hNN);
        alaFirstBloodAnim.setParentView(this.hNo);
        a(alaFirstBloodAnim);
    }

    private void clA() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, false);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hNO);
        alaFirstBloodAnim.setParentView(this.hNo);
        b(alaFirstBloodAnim);
    }

    private void cr(View view) {
        ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(300L).start();
    }

    private void a(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hNL.peek() == null) {
            this.hNL.add(aVar);
            this.hNL.peek().startAnim();
            return;
        }
        this.hNL.add(aVar);
    }

    private void b(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hNM.peek() == null) {
            this.hNM.add(aVar);
            this.hNM.peek().startAnim();
            return;
        }
        this.hNM.add(aVar);
    }

    public void e(JSONObject jSONObject, int i) {
        boolean z;
        if (this.gyX.xl(i)) {
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
                    clz();
                    z = false;
                    break;
                case 12:
                    clx();
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
                    clv();
                    z = true;
                    break;
                case 16:
                    long optLong = jSONObject.optLong("honor");
                    long optLong2 = jSONObject.optLong("rival_honor");
                    if (optLong >= this.hNI && optLong2 >= this.hNJ) {
                        this.hNC.setText(fm(optLong2) + "");
                        this.hNv.setText(fm(optLong) + "");
                        x(optLong, optLong2);
                        z = false;
                        break;
                    } else {
                        return;
                    }
                case 21:
                    clA();
                    z = false;
                    break;
                case 22:
                    cly();
                    z = true;
                    break;
                case 24:
                    clw();
                    z = true;
                    break;
                case 30:
                    bRO();
                    z = true;
                    break;
            }
            if (z && !this.gyX.getGetPkInfoModel().isLoop()) {
                this.gyX.getGetPkInfoModel().a(this.gyX.aIK.aHk.userId, jSONObject.optLong("pk_id"), this.gyX.aIK.mLiveInfo.room_id, this.gyX.aIK.mLiveInfo.live_id, this.gyX.isHost ? 1 : 0);
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gyX = pkRankView;
    }

    public void onDestroy() {
        if (this.gyX.getGetPkInfoModel() != null) {
            this.gyX.getGetPkInfoModel().cim();
        }
        clr();
        if (this.hNP != null) {
            this.hNP.onDestroy();
        }
    }

    public void clr() {
        if (this.hNh != null) {
            this.hNh.cancelTimer();
            this.hNh = null;
        }
    }

    public k getPkRankPropController() {
        if (this.hNP == null) {
            this.hNP = new k(this);
        }
        return this.hNP;
    }

    public void clB() {
        this.hNw.setAlpha(1.0f);
        this.hNw.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clC() {
        cr(this.hNw);
        this.hNw.setVisibility(8);
    }

    public void clD() {
        this.hNx.setAlpha(0.8f);
        this.hNx.setVisibility(0);
        this.hNv.setVisibility(0);
    }

    public void clE() {
        this.hNx.setAlpha(1.0f);
        this.hNx.setVisibility(0);
        this.hNv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(boolean z) {
        if (z) {
            this.hNv.setVisibility(8);
            return;
        }
        cr(this.hNx);
        this.hNx.setVisibility(8);
        this.hNv.setVisibility(0);
    }

    public void clF() {
        this.hND.setAlpha(1.0f);
        this.hND.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clG() {
        cr(this.hND);
        this.hND.setVisibility(8);
    }

    public void clH() {
        this.hNE.setAlpha(1.0f);
        this.hNE.setVisibility(0);
        this.hNC.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ol(boolean z) {
        if (z) {
            this.hNC.setVisibility(8);
            return;
        }
        cr(this.hNE);
        this.hNE.setVisibility(8);
        this.hNC.setVisibility(0);
    }

    String fm(long j) {
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
        if (j - this.hNI >= 100) {
            ObjectAnimator.ofFloat(this.hNv, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hNv, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        if (j2 - this.hNJ >= 100) {
            ObjectAnimator.ofFloat(this.hNC, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hNC, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        this.hNI = j;
        this.hNJ = j2;
    }

    public void resetView() {
        this.hNI = 0L;
        this.hNJ = 0L;
        this.hNP.handler.removeCallbacksAndMessages(null);
        this.hNE.setVisibility(8);
        this.hNx.setVisibility(8);
        this.hNw.setVisibility(8);
        this.hND.setVisibility(8);
        clr();
        this.hNz.setVisibility(0);
        this.hNB.setVisibility(0);
        this.hNC.setVisibility(0);
        this.hNC.setText("0");
        this.hNs.setVisibility(0);
        this.hNu.setVisibility(0);
        this.hNv.setVisibility(0);
        this.hNv.setText("0");
    }
}
