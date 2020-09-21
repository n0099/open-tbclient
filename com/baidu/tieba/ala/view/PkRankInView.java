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
    PkRankView fXi;
    ImageView hgA;
    ImageView hgB;
    RelativeLayout hgC;
    HeadImageView hgD;
    TextView hgE;
    TextView hgF;
    FixedTextView hgG;
    ImageView hgH;
    ImageView hgI;
    ImageView hgJ;
    TextView hgK;
    TextView hgL;
    long hgM;
    long hgN;
    Queue<com.baidu.tieba.ala.view.anim.a> hgO;
    Queue<com.baidu.tieba.ala.view.anim.a> hgP;
    public AnimatorListenerAdapter hgQ;
    public AnimatorListenerAdapter hgR;
    k hgS;
    com.baidu.tieba.ala.d hgl;
    RelativeLayout hgs;
    ImageView hgt;
    ImageView hgu;
    RelativeLayout hgv;
    HeadImageView hgw;
    TextView hgx;
    TextView hgy;
    FixedTextView hgz;
    private View mView;
    int status;

    public PkRankInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hgO = new LinkedBlockingQueue();
        this.hgP = new LinkedBlockingQueue();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_in_layout, (ViewGroup) this, true);
        this.hgv = (RelativeLayout) this.mView.findViewById(a.g.in_top_layout);
        this.hgs = (RelativeLayout) this.mView.findViewById(a.g.background_view);
        this.hgt = (ImageView) this.mView.findViewById(a.g.top_bg);
        this.hgu = (ImageView) this.mView.findViewById(a.g.bottom_bg);
        this.hgJ = (ImageView) this.mView.findViewById(a.g.pk_img);
        this.hgw = (HeadImageView) this.mView.findViewById(a.g.top_head);
        this.hgx = (TextView) this.mView.findViewById(a.g.top_wins);
        this.hgy = (TextView) this.mView.findViewById(a.g.top_name);
        this.hgz = (FixedTextView) this.mView.findViewById(a.g.top_scores);
        this.hgA = (ImageView) this.mView.findViewById(a.g.top_plus);
        this.hgB = (ImageView) this.mView.findViewById(a.g.top_scores_shade);
        this.hgw.setDefaultBgResource(a.f.sdk_default_avatar);
        this.hgw.setIsRound(true);
        this.hgw.setAutoChangeStyle(false);
        this.hgw.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.hgw.setBorderColor(872415231);
        this.hgv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.fXi.y(PkRankInView.this.fXi.hhY.H5URL, PkRankInView.this.fXi.hhY.myPkData.userID);
            }
        });
        this.hgC = (RelativeLayout) this.mView.findViewById(a.g.in_bottom_layout);
        this.hgD = (HeadImageView) this.mView.findViewById(a.g.bottom_head);
        this.hgE = (TextView) this.mView.findViewById(a.g.bottom_wins);
        this.hgF = (TextView) this.mView.findViewById(a.g.bottom_name);
        this.hgG = (FixedTextView) this.mView.findViewById(a.g.bottom_scores);
        this.hgH = (ImageView) this.mView.findViewById(a.g.bottom_plus);
        this.hgI = (ImageView) this.mView.findViewById(a.g.bottom_scores_shade);
        this.hgD.setDefaultBgResource(a.f.sdk_default_avatar);
        this.hgD.setIsRound(true);
        this.hgD.setAutoChangeStyle(false);
        this.hgD.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.hgD.setBorderColor(872415231);
        this.hgC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.fXi.y(PkRankInView.this.fXi.hhY.H5URL, PkRankInView.this.fXi.hhY.otherPkData.userID);
            }
        });
        this.hgK = (TextView) this.mView.findViewById(a.g.end_view);
        this.hgL = (TextView) this.mView.findViewById(a.g.timer);
        ccV();
    }

    private void ccV() {
        this.hgQ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hgJ.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hgO.poll();
                if (PkRankInView.this.hgO.peek() != null) {
                    PkRankInView.this.hgO.peek().startAnim();
                }
            }
        };
        this.hgR = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hgJ.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hgP.poll();
                if (PkRankInView.this.hgP.peek() != null) {
                    PkRankInView.this.hgP.peek().startAnim();
                }
            }
        };
    }

    public void a(PkInfoData pkInfoData, int i) {
        this.fXi.cdy();
        this.hgK.setVisibility(8);
        if (pkInfoData.pkStatusInfoData.pkStatus == 1) {
            ex(pkInfoData.pkStatusInfoData.stageEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        this.status = i;
        if (this.fXi.vB(i)) {
            switch (i) {
                case 10:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    d(pkInfoData);
                    return;
                case 30:
                    bKG();
                    return;
                default:
                    return;
            }
        }
    }

    private void d(PkInfoData pkInfoData) {
        this.hgD.startLoad(pkInfoData.otherPkData.bdPortrait, 12, false, false);
        if (pkInfoData.otherPkData.winningStreak > 1) {
            this.hgE.setVisibility(0);
            this.hgE.setText(this.context.getString(a.i.sdk_pk_rank_wins, String.valueOf(pkInfoData.otherPkData.winningStreak)));
        } else {
            this.hgE.setVisibility(8);
        }
        this.hgF.setText(pkInfoData.otherPkData.userNickName);
        this.hgw.startLoad(pkInfoData.myPkData.bdPortrait, 12, false, false);
        if (pkInfoData.myPkData.winningStreak > 1) {
            this.hgx.setVisibility(0);
            this.hgx.setText(this.context.getString(a.i.sdk_pk_rank_wins, String.valueOf(pkInfoData.myPkData.winningStreak)));
        } else {
            this.hgx.setVisibility(8);
        }
        this.hgy.setText(pkInfoData.myPkData.userNickName);
        if (pkInfoData.pkStatusInfoData.anchorScore >= this.hgM && pkInfoData.pkStatusInfoData.rivalScore >= this.hgN) {
            this.hgz.setText(ey(pkInfoData.pkStatusInfoData.anchorScore) + "");
            this.hgG.setText(ey(pkInfoData.pkStatusInfoData.rivalScore) + "");
            w(pkInfoData.pkStatusInfoData.anchorScore, pkInfoData.pkStatusInfoData.rivalScore);
        }
    }

    private void ex(long j) {
        if ((this.hgl == null || !this.hgl.isRunning()) && j > 0) {
            this.hgL.setVisibility(0);
            this.hgl = new com.baidu.tieba.ala.d(j * 1000, 1000L);
            this.hgl.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankInView.5
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j2) {
                    PkRankInView.this.hgL.setText(StringHelper.formatSecondsTime(Math.round(j2 / 1000.0d)));
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankInView.this.hgl.cancelTimer();
                    PkRankInView.this.ccW();
                }
            });
            this.hgl.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccW() {
        if (!this.fXi.getGetPkInfoModel().isLoop()) {
            this.fXi.getGetPkInfoModel().a(this.fXi.aFP.aEz.userId, this.fXi.hhY.pkStatusInfoData.pkID, this.fXi.aFP.mLiveInfo.room_id, this.fXi.aFP.mLiveInfo.live_id, this.fXi.isHost ? 1 : 0);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.6
            @Override // java.lang.Runnable
            public void run() {
                if (!PkRankInView.this.fXi.getGetPkInfoModel().isLoop()) {
                    PkRankInView.this.fXi.getGetPkInfoModel().a(PkRankInView.this.fXi.aFP.aEz.userId, PkRankInView.this.fXi.hhY.pkStatusInfoData.pkID, PkRankInView.this.fXi.aFP.mLiveInfo.room_id, PkRankInView.this.fXi.aFP.mLiveInfo.live_id, PkRankInView.this.fXi.isHost ? 1 : 0);
                }
            }
        }, this.fXi.hhY.resultInterval);
    }

    private void bKG() {
        this.hgK.bringToFront();
        this.hgK.setVisibility(0);
        this.hgL.setVisibility(8);
    }

    private void ccX() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hgQ);
        pkRankPropAnim.setParentView(this.hgs);
        a(pkRankPropAnim);
    }

    private void ccY() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hgR);
        pkRankPropAnim.setParentView(this.hgs);
        b(pkRankPropAnim);
    }

    private void ccZ() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hgQ);
        pkRankPropAnim.setParentView(this.hgs);
        a(pkRankPropAnim);
    }

    private void cda() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hgR);
        pkRankPropAnim.setParentView(this.hgs);
        b(pkRankPropAnim);
    }

    private void cdb() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, true);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hgQ);
        alaFirstBloodAnim.setParentView(this.hgs);
        a(alaFirstBloodAnim);
    }

    private void cdc() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, false);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hgR);
        alaFirstBloodAnim.setParentView(this.hgs);
        b(alaFirstBloodAnim);
    }

    private void cb(View view) {
        ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(300L).start();
    }

    private void a(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hgO.peek() == null) {
            this.hgO.add(aVar);
            this.hgO.peek().startAnim();
            return;
        }
        this.hgO.add(aVar);
    }

    private void b(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hgP.peek() == null) {
            this.hgP.add(aVar);
            this.hgP.peek().startAnim();
            return;
        }
        this.hgP.add(aVar);
    }

    public void d(JSONObject jSONObject, int i) {
        boolean z;
        if (this.fXi.vB(i)) {
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
                    cdb();
                    z = false;
                    break;
                case 12:
                    ccZ();
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
                    ccX();
                    z = true;
                    break;
                case 16:
                    long optLong = jSONObject.optLong("honor");
                    long optLong2 = jSONObject.optLong("rival_honor");
                    if (optLong >= this.hgM && optLong2 >= this.hgN) {
                        this.hgG.setText(ey(optLong2) + "");
                        this.hgz.setText(ey(optLong) + "");
                        w(optLong, optLong2);
                        z = false;
                        break;
                    } else {
                        return;
                    }
                case 21:
                    cdc();
                    z = false;
                    break;
                case 22:
                    cda();
                    z = true;
                    break;
                case 24:
                    ccY();
                    z = true;
                    break;
                case 30:
                    bKG();
                    z = true;
                    break;
            }
            if (z && !this.fXi.getGetPkInfoModel().isLoop()) {
                this.fXi.getGetPkInfoModel().a(this.fXi.aFP.aEz.userId, jSONObject.optLong("pk_id"), this.fXi.aFP.mLiveInfo.room_id, this.fXi.aFP.mLiveInfo.live_id, this.fXi.isHost ? 1 : 0);
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.fXi = pkRankView;
    }

    public void onDestroy() {
        if (this.fXi.getGetPkInfoModel() != null) {
            this.fXi.getGetPkInfoModel().bZR();
        }
        ccT();
        if (this.hgS != null) {
            this.hgS.onDestroy();
        }
    }

    public void ccT() {
        if (this.hgl != null) {
            this.hgl.cancelTimer();
            this.hgl = null;
        }
    }

    public k getPkRankPropController() {
        if (this.hgS == null) {
            this.hgS = new k(this);
        }
        return this.hgS;
    }

    public void cdd() {
        this.hgA.setAlpha(1.0f);
        this.hgA.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cde() {
        cb(this.hgA);
        this.hgA.setVisibility(8);
    }

    public void cdf() {
        this.hgB.setAlpha(0.8f);
        this.hgB.setVisibility(0);
        this.hgz.setVisibility(0);
    }

    public void cdg() {
        this.hgB.setAlpha(1.0f);
        this.hgB.setVisibility(0);
        this.hgz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nd(boolean z) {
        if (z) {
            this.hgz.setVisibility(8);
            return;
        }
        cb(this.hgB);
        this.hgB.setVisibility(8);
        this.hgz.setVisibility(0);
    }

    public void cdh() {
        this.hgH.setAlpha(1.0f);
        this.hgH.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cdi() {
        cb(this.hgH);
        this.hgH.setVisibility(8);
    }

    public void cdj() {
        this.hgI.setAlpha(1.0f);
        this.hgI.setVisibility(0);
        this.hgG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ne(boolean z) {
        if (z) {
            this.hgG.setVisibility(8);
            return;
        }
        cb(this.hgI);
        this.hgI.setVisibility(8);
        this.hgG.setVisibility(0);
    }

    String ey(long j) {
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
        if (j - this.hgM >= 100) {
            ObjectAnimator.ofFloat(this.hgz, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hgz, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        if (j2 - this.hgN >= 100) {
            ObjectAnimator.ofFloat(this.hgG, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hgG, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        this.hgM = j;
        this.hgN = j2;
    }

    public void resetView() {
        this.hgM = 0L;
        this.hgN = 0L;
        this.hgS.handler.removeCallbacksAndMessages(null);
        this.hgI.setVisibility(8);
        this.hgB.setVisibility(8);
        this.hgA.setVisibility(8);
        this.hgH.setVisibility(8);
        ccT();
        this.hgD.setVisibility(0);
        this.hgF.setVisibility(0);
        this.hgG.setVisibility(0);
        this.hgG.setText("0");
        this.hgw.setVisibility(0);
        this.hgy.setVisibility(0);
        this.hgz.setVisibility(0);
        this.hgz.setText("0");
    }
}
