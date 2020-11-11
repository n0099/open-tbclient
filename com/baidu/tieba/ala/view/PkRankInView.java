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
    PkRankView gzq;
    com.baidu.tieba.ala.d hNA;
    RelativeLayout hNH;
    ImageView hNI;
    ImageView hNJ;
    RelativeLayout hNK;
    HeadImageView hNL;
    TextView hNM;
    TextView hNN;
    FixedTextView hNO;
    ImageView hNP;
    ImageView hNQ;
    RelativeLayout hNR;
    HeadImageView hNS;
    TextView hNT;
    TextView hNU;
    FixedTextView hNV;
    ImageView hNW;
    ImageView hNX;
    ImageView hNY;
    TextView hNZ;
    TextView hOa;
    long hOb;
    long hOc;
    long hOd;
    Queue<com.baidu.tieba.ala.view.anim.a> hOe;
    Queue<com.baidu.tieba.ala.view.anim.a> hOf;
    public AnimatorListenerAdapter hOg;
    public AnimatorListenerAdapter hOh;
    k hOi;
    private View mView;
    int status;

    public PkRankInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hOe = new LinkedBlockingQueue();
        this.hOf = new LinkedBlockingQueue();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_in_layout, (ViewGroup) this, true);
        this.hNK = (RelativeLayout) this.mView.findViewById(a.f.in_top_layout);
        this.hNH = (RelativeLayout) this.mView.findViewById(a.f.background_view);
        this.hNI = (ImageView) this.mView.findViewById(a.f.top_bg);
        this.hNJ = (ImageView) this.mView.findViewById(a.f.bottom_bg);
        this.hNY = (ImageView) this.mView.findViewById(a.f.pk_img);
        this.hNL = (HeadImageView) this.mView.findViewById(a.f.top_head);
        this.hNM = (TextView) this.mView.findViewById(a.f.top_wins);
        this.hNN = (TextView) this.mView.findViewById(a.f.top_name);
        this.hNO = (FixedTextView) this.mView.findViewById(a.f.top_scores);
        this.hNP = (ImageView) this.mView.findViewById(a.f.top_plus);
        this.hNQ = (ImageView) this.mView.findViewById(a.f.top_scores_shade);
        this.hNL.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hNL.setIsRound(true);
        this.hNL.setAutoChangeStyle(false);
        this.hNL.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.hNL.setBorderColor(872415231);
        this.hNK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gzq.B(PkRankInView.this.gzq.hPo.H5URL, PkRankInView.this.gzq.hPo.myPkData.userID);
            }
        });
        this.hNR = (RelativeLayout) this.mView.findViewById(a.f.in_bottom_layout);
        this.hNS = (HeadImageView) this.mView.findViewById(a.f.bottom_head);
        this.hNT = (TextView) this.mView.findViewById(a.f.bottom_wins);
        this.hNU = (TextView) this.mView.findViewById(a.f.bottom_name);
        this.hNV = (FixedTextView) this.mView.findViewById(a.f.bottom_scores);
        this.hNW = (ImageView) this.mView.findViewById(a.f.bottom_plus);
        this.hNX = (ImageView) this.mView.findViewById(a.f.bottom_scores_shade);
        this.hNS.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hNS.setIsRound(true);
        this.hNS.setAutoChangeStyle(false);
        this.hNS.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.hNS.setBorderColor(872415231);
        this.hNR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gzq.B(PkRankInView.this.gzq.hPo.H5URL, PkRankInView.this.gzq.hPo.otherPkData.userID);
            }
        });
        this.hNZ = (TextView) this.mView.findViewById(a.f.end_view);
        this.hOa = (TextView) this.mView.findViewById(a.f.timer);
        cma();
    }

    private void cma() {
        this.hOg = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hNY.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hOe.poll();
                if (PkRankInView.this.hOe.peek() != null) {
                    PkRankInView.this.hOe.peek().startAnim();
                }
            }
        };
        this.hOh = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.hNY.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.hOf.poll();
                if (PkRankInView.this.hOf.peek() != null) {
                    PkRankInView.this.hOf.peek().startAnim();
                }
            }
        };
    }

    public void a(PkInfoData pkInfoData, int i) {
        this.gzq.cmD();
        this.hNZ.setVisibility(8);
        if (pkInfoData.pkStatusInfoData.pkStatus == 1) {
            fl(pkInfoData.pkStatusInfoData.stageEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        this.status = i;
        if (this.gzq.wN(i)) {
            switch (i) {
                case 10:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    d(pkInfoData);
                    return;
                case 30:
                    bSv();
                    return;
                default:
                    return;
            }
        }
    }

    private void d(PkInfoData pkInfoData) {
        this.hNS.startLoad(pkInfoData.otherPkData.bdPortrait, 12, false, false);
        if (pkInfoData.otherPkData.winningStreak > 1) {
            this.hNT.setVisibility(0);
            this.hNT.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.otherPkData.winningStreak)));
        } else {
            this.hNT.setVisibility(8);
        }
        this.hNU.setText(pkInfoData.otherPkData.userNickName);
        this.hNL.startLoad(pkInfoData.myPkData.bdPortrait, 12, false, false);
        if (pkInfoData.myPkData.winningStreak > 1) {
            this.hNM.setVisibility(0);
            this.hNM.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.myPkData.winningStreak)));
        } else {
            this.hNM.setVisibility(8);
        }
        this.hNN.setText(pkInfoData.myPkData.userNickName);
        if (pkInfoData.pkStatusInfoData.anchorScore >= this.hOb && pkInfoData.pkStatusInfoData.rivalScore >= this.hOc) {
            this.hNO.setText(fm(pkInfoData.pkStatusInfoData.anchorScore) + "");
            this.hNV.setText(fm(pkInfoData.pkStatusInfoData.rivalScore) + "");
            x(pkInfoData.pkStatusInfoData.anchorScore, pkInfoData.pkStatusInfoData.rivalScore);
        }
    }

    private void fl(long j) {
        if (j <= 0) {
            this.hOa.setVisibility(8);
        } else if (this.hNA == null || !this.hNA.isRunning()) {
            this.hOa.setVisibility(0);
            this.hNA = new com.baidu.tieba.ala.d(j * 1000, 1000L);
            this.hNA.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankInView.5
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j2) {
                    PkRankInView.this.hOd = Math.round(j2 / 1000.0d);
                    PkRankInView.this.hOa.setText(StringHelper.formatSecondsTime(PkRankInView.this.hOd));
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankInView.this.hNA.cancelTimer();
                    if (!PkRankInView.this.gzq.isHost) {
                        PkRankInView.this.bSv();
                    }
                    PkRankInView.this.cmb();
                }
            });
            this.hNA.startTimer();
        } else if (this.hOd - j >= 1) {
            this.hNA.cancelTimer();
            this.hNA = null;
            fl(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmb() {
        if (!this.gzq.getGetPkInfoModel().isLoop()) {
            this.gzq.getGetPkInfoModel().a(this.gzq.aKv.aIV.userId, this.gzq.hPo.pkStatusInfoData.pkID, this.gzq.aKv.mLiveInfo.room_id, this.gzq.aKv.mLiveInfo.live_id, this.gzq.isHost ? 1 : 0);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.6
            @Override // java.lang.Runnable
            public void run() {
                if (!PkRankInView.this.gzq.getGetPkInfoModel().isLoop()) {
                    PkRankInView.this.gzq.getGetPkInfoModel().a(PkRankInView.this.gzq.aKv.aIV.userId, PkRankInView.this.gzq.hPo.pkStatusInfoData.pkID, PkRankInView.this.gzq.aKv.mLiveInfo.room_id, PkRankInView.this.gzq.aKv.mLiveInfo.live_id, PkRankInView.this.gzq.isHost ? 1 : 0);
                }
            }
        }, this.gzq.hPo.resultInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSv() {
        this.hNZ.bringToFront();
        this.hNZ.setVisibility(0);
        this.hOa.setVisibility(8);
    }

    private void cmc() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hOg);
        pkRankPropAnim.setParentView(this.hNH);
        a(pkRankPropAnim);
    }

    private void cmd() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hOh);
        pkRankPropAnim.setParentView(this.hNH);
        b(pkRankPropAnim);
    }

    private void cme() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hOg);
        pkRankPropAnim.setParentView(this.hNH);
        a(pkRankPropAnim);
    }

    private void cmf() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.hOh);
        pkRankPropAnim.setParentView(this.hNH);
        b(pkRankPropAnim);
    }

    private void cmg() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, true);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hOg);
        alaFirstBloodAnim.setParentView(this.hNH);
        a(alaFirstBloodAnim);
    }

    private void cmh() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, false);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.hOh);
        alaFirstBloodAnim.setParentView(this.hNH);
        b(alaFirstBloodAnim);
    }

    private void co(View view) {
        ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(300L).start();
    }

    private void a(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hOe.peek() == null) {
            this.hOe.add(aVar);
            this.hOe.peek().startAnim();
            return;
        }
        this.hOe.add(aVar);
    }

    private void b(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.hOf.peek() == null) {
            this.hOf.add(aVar);
            this.hOf.peek().startAnim();
            return;
        }
        this.hOf.add(aVar);
    }

    public void e(JSONObject jSONObject, int i) {
        boolean z;
        if (this.gzq.wN(i)) {
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
                    cmg();
                    z = false;
                    break;
                case 12:
                    cme();
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
                    cmc();
                    z = true;
                    break;
                case 16:
                    long optLong = jSONObject.optLong("honor");
                    long optLong2 = jSONObject.optLong("rival_honor");
                    if (optLong >= this.hOb && optLong2 >= this.hOc) {
                        this.hNV.setText(fm(optLong2) + "");
                        this.hNO.setText(fm(optLong) + "");
                        x(optLong, optLong2);
                        z = false;
                        break;
                    } else {
                        return;
                    }
                case 21:
                    cmh();
                    z = false;
                    break;
                case 22:
                    cmf();
                    z = true;
                    break;
                case 24:
                    cmd();
                    z = true;
                    break;
                case 30:
                    bSv();
                    z = true;
                    break;
            }
            if (z && !this.gzq.getGetPkInfoModel().isLoop()) {
                this.gzq.getGetPkInfoModel().a(this.gzq.aKv.aIV.userId, jSONObject.optLong("pk_id"), this.gzq.aKv.mLiveInfo.room_id, this.gzq.aKv.mLiveInfo.live_id, this.gzq.isHost ? 1 : 0);
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gzq = pkRankView;
    }

    public void onDestroy() {
        if (this.gzq.getGetPkInfoModel() != null) {
            this.gzq.getGetPkInfoModel().ciT();
        }
        clY();
        if (this.hOi != null) {
            this.hOi.onDestroy();
        }
    }

    public void clY() {
        if (this.hNA != null) {
            this.hNA.cancelTimer();
            this.hNA = null;
        }
    }

    public k getPkRankPropController() {
        if (this.hOi == null) {
            this.hOi = new k(this);
        }
        return this.hOi;
    }

    public void cmi() {
        this.hNP.setAlpha(1.0f);
        this.hNP.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cmj() {
        co(this.hNP);
        this.hNP.setVisibility(8);
    }

    public void cmk() {
        this.hNQ.setAlpha(0.8f);
        this.hNQ.setVisibility(0);
        this.hNO.setVisibility(0);
    }

    public void cml() {
        this.hNQ.setAlpha(1.0f);
        this.hNQ.setVisibility(0);
        this.hNO.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oj(boolean z) {
        if (z) {
            this.hNO.setVisibility(8);
            return;
        }
        co(this.hNQ);
        this.hNQ.setVisibility(8);
        this.hNO.setVisibility(0);
    }

    public void cmm() {
        this.hNW.setAlpha(1.0f);
        this.hNW.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cmn() {
        co(this.hNW);
        this.hNW.setVisibility(8);
    }

    public void cmo() {
        this.hNX.setAlpha(1.0f);
        this.hNX.setVisibility(0);
        this.hNV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(boolean z) {
        if (z) {
            this.hNV.setVisibility(8);
            return;
        }
        co(this.hNX);
        this.hNX.setVisibility(8);
        this.hNV.setVisibility(0);
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
        if (j - this.hOb >= 100) {
            ObjectAnimator.ofFloat(this.hNO, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hNO, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        if (j2 - this.hOc >= 100) {
            ObjectAnimator.ofFloat(this.hNV, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.hNV, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        this.hOb = j;
        this.hOc = j2;
    }

    public void resetView() {
        this.hOb = 0L;
        this.hOc = 0L;
        this.hOi.handler.removeCallbacksAndMessages(null);
        this.hNX.setVisibility(8);
        this.hNQ.setVisibility(8);
        this.hNP.setVisibility(8);
        this.hNW.setVisibility(8);
        clY();
        this.hNS.setVisibility(0);
        this.hNU.setVisibility(0);
        this.hNV.setVisibility(0);
        this.hNV.setText("0");
        this.hNL.setVisibility(0);
        this.hNN.setVisibility(0);
        this.hNO.setVisibility(0);
        this.hNO.setText("0");
    }
}
