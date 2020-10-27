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
    PkRankView gtC;
    com.baidu.tieba.ala.d hHD;
    RelativeLayout hHK;
    ImageView hHL;
    ImageView hHM;
    RelativeLayout hHN;
    HeadImageView hHO;
    TextView hHP;
    TextView hHQ;
    FixedTextView hHR;
    ImageView hHS;
    ImageView hHT;
    RelativeLayout hHU;
    HeadImageView hHV;
    TextView hHW;
    TextView hHX;
    FixedTextView hHY;
    ImageView hHZ;
    ImageView hIa;
    ImageView hIb;
    TextView hIc;
    TextView hId;
    long hIe;
    long hIf;
    long hIg;
    Queue<com.baidu.tieba.ala.view.anim.a> hIh;
    Queue<com.baidu.tieba.ala.view.anim.a> hIi;
    public AnimatorListenerAdapter hIj;
    public AnimatorListenerAdapter hIk;
    k hIl;
    private View mView;
    int status;

    public PkRankInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hIh = new LinkedBlockingQueue();
        this.hIi = new LinkedBlockingQueue();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_in_layout, (ViewGroup) this, true);
        this.hHN = (RelativeLayout) this.mView.findViewById(a.g.in_top_layout);
        this.hHK = (RelativeLayout) this.mView.findViewById(a.g.background_view);
        this.hHL = (ImageView) this.mView.findViewById(a.g.top_bg);
        this.hHM = (ImageView) this.mView.findViewById(a.g.bottom_bg);
        this.hIb = (ImageView) this.mView.findViewById(a.g.pk_img);
        this.hHO = (HeadImageView) this.mView.findViewById(a.g.top_head);
        this.hHP = (TextView) this.mView.findViewById(a.g.top_wins);
        this.hHQ = (TextView) this.mView.findViewById(a.g.top_name);
        this.hHR = (FixedTextView) this.mView.findViewById(a.g.top_scores);
        this.hHS = (ImageView) this.mView.findViewById(a.g.top_plus);
        this.hHT = (ImageView) this.mView.findViewById(a.g.top_scores_shade);
        this.hHO.setDefaultBgResource(a.f.sdk_default_avatar);
        this.hHO.setIsRound(true);
        this.hHO.setAutoChangeStyle(false);
        this.hHO.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.hHO.setBorderColor(872415231);
        this.hHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gtC.B(PkRankInView.this.gtC.hJr.H5URL, PkRankInView.this.gtC.hJr.myPkData.userID);
            }
        });
        this.hHU = (RelativeLayout) this.mView.findViewById(a.g.in_bottom_layout);
        this.hHV = (HeadImageView) this.mView.findViewById(a.g.bottom_head);
        this.hHW = (TextView) this.mView.findViewById(a.g.bottom_wins);
        this.hHX = (TextView) this.mView.findViewById(a.g.bottom_name);
        this.hHY = (FixedTextView) this.mView.findViewById(a.g.bottom_scores);
        this.hHZ = (ImageView) this.mView.findViewById(a.g.bottom_plus);
        this.hIa = (ImageView) this.mView.findViewById(a.g.bottom_scores_shade);
        this.hHV.setDefaultBgResource(a.f.sdk_default_avatar);
        this.hHV.setIsRound(true);
        this.hHV.setAutoChangeStyle(false);
        this.hHV.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.hHV.setBorderColor(872415231);
        this.hHU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gtC.B(PkRankInView.this.gtC.hJr.H5URL, PkRankInView.this.gtC.hJr.otherPkData.userID);
            }
        });
        this.hIc = (TextView) this.mView.findViewById(a.g.end_view);
        this.hId = (TextView) this.mView.findViewById(a.g.timer);
        cjy();
    }

    private void cjy() {
        this.hIj = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hIb.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hIh.poll();
                if (PkRankInView.this.hIh.peek() != null) {
                    PkRankInView.this.hIh.peek().startAnim();
                }
            }
        };
        this.hIk = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hIb.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hIi.poll();
                if (PkRankInView.this.hIi.peek() != null) {
                    PkRankInView.this.hIi.peek().startAnim();
                }
            }
        };
    }

    public void a(PkInfoData pkInfoData, int i) {
        this.gtC.ckb();
        this.hIc.setVisibility(8);
        if (pkInfoData.pkStatusInfoData.pkStatus == 1) {
            eP(pkInfoData.pkStatusInfoData.stageEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        this.status = i;
        if (this.gtC.wA(i)) {
            switch (i) {
                case 10:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    d(pkInfoData);
                    return;
                case 30:
                    bPV();
                    return;
                default:
                    return;
            }
        }
    }

    private void d(PkInfoData pkInfoData) {
        this.hHV.startLoad(pkInfoData.otherPkData.bdPortrait, 12, false, false);
        if (pkInfoData.otherPkData.winningStreak > 1) {
            this.hHW.setVisibility(0);
            this.hHW.setText(this.context.getString(a.i.sdk_pk_rank_wins, String.valueOf(pkInfoData.otherPkData.winningStreak)));
        } else {
            this.hHW.setVisibility(8);
        }
        this.hHX.setText(pkInfoData.otherPkData.userNickName);
        this.hHO.startLoad(pkInfoData.myPkData.bdPortrait, 12, false, false);
        if (pkInfoData.myPkData.winningStreak > 1) {
            this.hHP.setVisibility(0);
            this.hHP.setText(this.context.getString(a.i.sdk_pk_rank_wins, String.valueOf(pkInfoData.myPkData.winningStreak)));
        } else {
            this.hHP.setVisibility(8);
        }
        this.hHQ.setText(pkInfoData.myPkData.userNickName);
        if (pkInfoData.pkStatusInfoData.anchorScore >= this.hIe && pkInfoData.pkStatusInfoData.rivalScore >= this.hIf) {
            this.hHR.setText(eQ(pkInfoData.pkStatusInfoData.anchorScore) + "");
            this.hHY.setText(eQ(pkInfoData.pkStatusInfoData.rivalScore) + "");
            w(pkInfoData.pkStatusInfoData.anchorScore, pkInfoData.pkStatusInfoData.rivalScore);
        }
    }

    private void eP(long j) {
        if (j <= 0) {
            this.hId.setVisibility(8);
        } else if (this.hHD == null || !this.hHD.isRunning()) {
            this.hId.setVisibility(0);
            this.hHD = new com.baidu.tieba.ala.d(j * 1000, 1000L);
            this.hHD.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankInView.5
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j2) {
                    PkRankInView.this.hIg = Math.round(j2 / 1000.0d);
                    PkRankInView.this.hId.setText(StringHelper.formatSecondsTime(PkRankInView.this.hIg));
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankInView.this.hHD.cancelTimer();
                    if (!PkRankInView.this.gtC.isHost) {
                        PkRankInView.this.bPV();
                    }
                    PkRankInView.this.cjz();
                }
            });
            this.hHD.startTimer();
        } else if (this.hIg - j >= 1) {
            this.hHD.cancelTimer();
            this.hHD = null;
            eP(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjz() {
        if (!this.gtC.getGetPkInfoModel().isLoop()) {
            this.gtC.getGetPkInfoModel().a(this.gtC.aJv.aIe.userId, this.gtC.hJr.pkStatusInfoData.pkID, this.gtC.aJv.mLiveInfo.room_id, this.gtC.aJv.mLiveInfo.live_id, this.gtC.isHost ? 1 : 0);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.6
            @Override // java.lang.Runnable
            public void run() {
                if (!PkRankInView.this.gtC.getGetPkInfoModel().isLoop()) {
                    PkRankInView.this.gtC.getGetPkInfoModel().a(PkRankInView.this.gtC.aJv.aIe.userId, PkRankInView.this.gtC.hJr.pkStatusInfoData.pkID, PkRankInView.this.gtC.aJv.mLiveInfo.room_id, PkRankInView.this.gtC.aJv.mLiveInfo.live_id, PkRankInView.this.gtC.isHost ? 1 : 0);
                }
            }
        }, this.gtC.hJr.resultInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPV() {
        this.hIc.bringToFront();
        this.hIc.setVisibility(0);
        this.hId.setVisibility(8);
    }

    private void cjA() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hIj);
        pkRankPropAnim.setParentView(this.hHK);
        a(pkRankPropAnim);
    }

    private void cjB() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hIk);
        pkRankPropAnim.setParentView(this.hHK);
        b(pkRankPropAnim);
    }

    private void cjC() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hIj);
        pkRankPropAnim.setParentView(this.hHK);
        a(pkRankPropAnim);
    }

    private void cjD() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hIk);
        pkRankPropAnim.setParentView(this.hHK);
        b(pkRankPropAnim);
    }

    private void cjE() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, true);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hIj);
        alaFirstBloodAnim.setParentView(this.hHK);
        a(alaFirstBloodAnim);
    }

    private void cjF() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, false);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hIk);
        alaFirstBloodAnim.setParentView(this.hHK);
        b(alaFirstBloodAnim);
    }

    private void cj(View view) {
        ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(300L).start();
    }

    private void a(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hIh.peek() == null) {
            this.hIh.add(aVar);
            this.hIh.peek().startAnim();
            return;
        }
        this.hIh.add(aVar);
    }

    private void b(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hIi.peek() == null) {
            this.hIi.add(aVar);
            this.hIi.peek().startAnim();
            return;
        }
        this.hIi.add(aVar);
    }

    public void e(JSONObject jSONObject, int i) {
        boolean z;
        if (this.gtC.wA(i)) {
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
                    cjE();
                    z = false;
                    break;
                case 12:
                    cjC();
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
                    cjA();
                    z = true;
                    break;
                case 16:
                    long optLong = jSONObject.optLong("honor");
                    long optLong2 = jSONObject.optLong("rival_honor");
                    if (optLong >= this.hIe && optLong2 >= this.hIf) {
                        this.hHY.setText(eQ(optLong2) + "");
                        this.hHR.setText(eQ(optLong) + "");
                        w(optLong, optLong2);
                        z = false;
                        break;
                    } else {
                        return;
                    }
                case 21:
                    cjF();
                    z = false;
                    break;
                case 22:
                    cjD();
                    z = true;
                    break;
                case 24:
                    cjB();
                    z = true;
                    break;
                case 30:
                    bPV();
                    z = true;
                    break;
            }
            if (z && !this.gtC.getGetPkInfoModel().isLoop()) {
                this.gtC.getGetPkInfoModel().a(this.gtC.aJv.aIe.userId, jSONObject.optLong("pk_id"), this.gtC.aJv.mLiveInfo.room_id, this.gtC.aJv.mLiveInfo.live_id, this.gtC.isHost ? 1 : 0);
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gtC = pkRankView;
    }

    public void onDestroy() {
        if (this.gtC.getGetPkInfoModel() != null) {
            this.gtC.getGetPkInfoModel().cgr();
        }
        cjw();
        if (this.hIl != null) {
            this.hIl.onDestroy();
        }
    }

    public void cjw() {
        if (this.hHD != null) {
            this.hHD.cancelTimer();
            this.hHD = null;
        }
    }

    public k getPkRankPropController() {
        if (this.hIl == null) {
            this.hIl = new k(this);
        }
        return this.hIl;
    }

    public void cjG() {
        this.hHS.setAlpha(1.0f);
        this.hHS.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cjH() {
        cj(this.hHS);
        this.hHS.setVisibility(8);
    }

    public void cjI() {
        this.hHT.setAlpha(0.8f);
        this.hHT.setVisibility(0);
        this.hHR.setVisibility(0);
    }

    public void cjJ() {
        this.hHT.setAlpha(1.0f);
        this.hHT.setVisibility(0);
        this.hHR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oa(boolean z) {
        if (z) {
            this.hHR.setVisibility(8);
            return;
        }
        cj(this.hHT);
        this.hHT.setVisibility(8);
        this.hHR.setVisibility(0);
    }

    public void cjK() {
        this.hHZ.setAlpha(1.0f);
        this.hHZ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cjL() {
        cj(this.hHZ);
        this.hHZ.setVisibility(8);
    }

    public void cjM() {
        this.hIa.setAlpha(1.0f);
        this.hIa.setVisibility(0);
        this.hHY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ob(boolean z) {
        if (z) {
            this.hHY.setVisibility(8);
            return;
        }
        cj(this.hIa);
        this.hIa.setVisibility(8);
        this.hHY.setVisibility(0);
    }

    String eQ(long j) {
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
        if (j - this.hIe >= 100) {
            ObjectAnimator.ofFloat(this.hHR, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hHR, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        if (j2 - this.hIf >= 100) {
            ObjectAnimator.ofFloat(this.hHY, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hHY, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        this.hIe = j;
        this.hIf = j2;
    }

    public void resetView() {
        this.hIe = 0L;
        this.hIf = 0L;
        this.hIl.handler.removeCallbacksAndMessages(null);
        this.hIa.setVisibility(8);
        this.hHT.setVisibility(8);
        this.hHS.setVisibility(8);
        this.hHZ.setVisibility(8);
        cjw();
        this.hHV.setVisibility(0);
        this.hHX.setVisibility(0);
        this.hHY.setVisibility(0);
        this.hHY.setText("0");
        this.hHO.setVisibility(0);
        this.hHQ.setVisibility(0);
        this.hHR.setVisibility(0);
        this.hHR.setText("0");
    }
}
