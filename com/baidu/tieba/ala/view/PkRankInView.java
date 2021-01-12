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
/* loaded from: classes10.dex */
public class PkRankInView extends RelativeLayout {
    Context context;
    PkRankView gPb;
    com.baidu.tieba.ala.e ifV;
    Queue<com.baidu.tieba.ala.view.anim.a> igA;
    public AnimatorListenerAdapter igB;
    public AnimatorListenerAdapter igC;
    k igD;
    RelativeLayout igc;
    ImageView igd;
    ImageView ige;
    RelativeLayout igf;
    HeadImageView igg;
    TextView igh;
    TextView igi;
    FixedTextView igj;
    ImageView igk;
    ImageView igl;
    RelativeLayout igm;
    HeadImageView ign;
    TextView igo;
    TextView igp;
    FixedTextView igq;
    ImageView igr;
    ImageView igs;
    ImageView igt;
    TextView igu;
    TextView igv;
    long igw;
    long igx;
    long igy;
    Queue<com.baidu.tieba.ala.view.anim.a> igz;
    private View mView;
    int status;

    public PkRankInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.igz = new LinkedBlockingQueue();
        this.igA = new LinkedBlockingQueue();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_in_layout, (ViewGroup) this, true);
        this.igf = (RelativeLayout) this.mView.findViewById(a.f.in_top_layout);
        this.igc = (RelativeLayout) this.mView.findViewById(a.f.background_view);
        this.igd = (ImageView) this.mView.findViewById(a.f.top_bg);
        this.ige = (ImageView) this.mView.findViewById(a.f.bottom_bg);
        this.igt = (ImageView) this.mView.findViewById(a.f.pk_img);
        this.igg = (HeadImageView) this.mView.findViewById(a.f.top_head);
        this.igh = (TextView) this.mView.findViewById(a.f.top_wins);
        this.igi = (TextView) this.mView.findViewById(a.f.top_name);
        this.igj = (FixedTextView) this.mView.findViewById(a.f.top_scores);
        this.igk = (ImageView) this.mView.findViewById(a.f.top_plus);
        this.igl = (ImageView) this.mView.findViewById(a.f.top_scores_shade);
        this.igg.setDefaultBgResource(a.e.sdk_default_avatar);
        this.igg.setIsRound(true);
        this.igg.setAutoChangeStyle(false);
        this.igg.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.igg.setBorderColor(872415231);
        this.igf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gPb.B(PkRankInView.this.gPb.ihG.H5URL, PkRankInView.this.gPb.ihG.myPkData.userID);
            }
        });
        this.igm = (RelativeLayout) this.mView.findViewById(a.f.in_bottom_layout);
        this.ign = (HeadImageView) this.mView.findViewById(a.f.bottom_head);
        this.igo = (TextView) this.mView.findViewById(a.f.bottom_wins);
        this.igp = (TextView) this.mView.findViewById(a.f.bottom_name);
        this.igq = (FixedTextView) this.mView.findViewById(a.f.bottom_scores);
        this.igr = (ImageView) this.mView.findViewById(a.f.bottom_plus);
        this.igs = (ImageView) this.mView.findViewById(a.f.bottom_scores_shade);
        this.ign.setDefaultBgResource(a.e.sdk_default_avatar);
        this.ign.setIsRound(true);
        this.ign.setAutoChangeStyle(false);
        this.ign.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.ign.setBorderColor(872415231);
        this.igm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gPb.B(PkRankInView.this.gPb.ihG.H5URL, PkRankInView.this.gPb.ihG.otherPkData.userID);
            }
        });
        this.igu = (TextView) this.mView.findViewById(a.f.end_view);
        this.igv = (TextView) this.mView.findViewById(a.f.timer);
        coL();
    }

    private void coL() {
        this.igB = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.igt.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.igz.poll();
                if (PkRankInView.this.igz.peek() != null) {
                    PkRankInView.this.igz.peek().startAnim();
                }
            }
        };
        this.igC = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PkRankInView.this.igt.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.igA.poll();
                if (PkRankInView.this.igA.peek() != null) {
                    PkRankInView.this.igA.peek().startAnim();
                }
            }
        };
    }

    public void a(PkInfoData pkInfoData, int i) {
        this.gPb.cpm();
        this.igu.setVisibility(8);
        if (pkInfoData.pkStatusInfoData.pkStatus == 1) {
            fP(pkInfoData.pkStatusInfoData.stageEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        this.status = i;
        if (this.gPb.wy(i)) {
            switch (i) {
                case 10:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    d(pkInfoData);
                    return;
                case 30:
                    bUn();
                    return;
                default:
                    return;
            }
        }
    }

    private void d(PkInfoData pkInfoData) {
        this.ign.startLoad(pkInfoData.otherPkData.bdPortrait, 12, false, false);
        if (pkInfoData.otherPkData.winningStreak > 1) {
            this.igo.setVisibility(0);
            this.igo.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.otherPkData.winningStreak)));
        } else {
            this.igo.setVisibility(8);
        }
        this.igp.setText(pkInfoData.otherPkData.userNickName);
        this.igg.startLoad(pkInfoData.myPkData.bdPortrait, 12, false, false);
        if (pkInfoData.myPkData.winningStreak > 1) {
            this.igh.setVisibility(0);
            this.igh.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.myPkData.winningStreak)));
        } else {
            this.igh.setVisibility(8);
        }
        this.igi.setText(pkInfoData.myPkData.userNickName);
        if (pkInfoData.pkStatusInfoData.anchorScore >= this.igw && pkInfoData.pkStatusInfoData.rivalScore >= this.igx) {
            this.igj.setText(fQ(pkInfoData.pkStatusInfoData.anchorScore) + "");
            this.igq.setText(fQ(pkInfoData.pkStatusInfoData.rivalScore) + "");
            A(pkInfoData.pkStatusInfoData.anchorScore, pkInfoData.pkStatusInfoData.rivalScore);
        }
    }

    private void fP(long j) {
        if (j <= 0) {
            this.igv.setVisibility(8);
        } else if (this.ifV == null || !this.ifV.isRunning()) {
            this.igv.setVisibility(0);
            this.ifV = new com.baidu.tieba.ala.e(j * 1000, 1000L);
            this.ifV.a(new e.a() { // from class: com.baidu.tieba.ala.view.PkRankInView.5
                @Override // com.baidu.tieba.ala.e.a
                public void onTick(long j2) {
                    PkRankInView.this.igy = Math.round(j2 / 1000.0d);
                    PkRankInView.this.igv.setText(StringHelper.formatSecondsTime(PkRankInView.this.igy));
                }

                @Override // com.baidu.tieba.ala.e.a
                public void onFinish() {
                    PkRankInView.this.ifV.cancelTimer();
                    if (!PkRankInView.this.gPb.isHost) {
                        PkRankInView.this.bUn();
                    }
                    PkRankInView.this.coM();
                }
            });
            this.ifV.startTimer();
        } else if (this.igy - j >= 1) {
            this.ifV.cancelTimer();
            this.ifV = null;
            fP(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coM() {
        if (!this.gPb.getGetPkInfoModel().aHm()) {
            this.gPb.getGetPkInfoModel().a(this.gPb.aHu.aFH.userId, this.gPb.ihG.pkStatusInfoData.pkID, this.gPb.aHu.mLiveInfo.room_id, this.gPb.aHu.mLiveInfo.live_id, this.gPb.isHost ? 1 : 0);
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.6
            @Override // java.lang.Runnable
            public void run() {
                if (!PkRankInView.this.gPb.getGetPkInfoModel().aHm()) {
                    PkRankInView.this.gPb.getGetPkInfoModel().a(PkRankInView.this.gPb.aHu.aFH.userId, PkRankInView.this.gPb.ihG.pkStatusInfoData.pkID, PkRankInView.this.gPb.aHu.mLiveInfo.room_id, PkRankInView.this.gPb.aHu.mLiveInfo.live_id, PkRankInView.this.gPb.isHost ? 1 : 0);
                }
            }
        }, this.gPb.ihG.resultInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUn() {
        this.igu.bringToFront();
        this.igu.setVisibility(0);
        this.igv.setVisibility(8);
    }

    private void coN() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.igB);
        pkRankPropAnim.setParentView(this.igc);
        a(pkRankPropAnim);
    }

    private void coO() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.igC);
        pkRankPropAnim.setParentView(this.igc);
        b(pkRankPropAnim);
    }

    private void coP() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.igB);
        pkRankPropAnim.setParentView(this.igc);
        a(pkRankPropAnim);
    }

    private void coQ() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.igC);
        pkRankPropAnim.setParentView(this.igc);
        b(pkRankPropAnim);
    }

    private void coR() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, true);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.igB);
        alaFirstBloodAnim.setParentView(this.igc);
        a(alaFirstBloodAnim);
    }

    private void coS() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, false);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.igC);
        alaFirstBloodAnim.setParentView(this.igc);
        b(alaFirstBloodAnim);
    }

    private void cI(View view) {
        ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(300L).start();
    }

    private void a(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.igz.peek() == null) {
            this.igz.add(aVar);
            this.igz.peek().startAnim();
            return;
        }
        this.igz.add(aVar);
    }

    private void b(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.igA.peek() == null) {
            this.igA.add(aVar);
            this.igA.peek().startAnim();
            return;
        }
        this.igA.add(aVar);
    }

    public void e(JSONObject jSONObject, int i) {
        boolean z;
        if (this.gPb.wy(i)) {
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
                    coR();
                    z = false;
                    break;
                case 12:
                    coP();
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
                    coN();
                    z = true;
                    break;
                case 16:
                    long optLong = jSONObject.optLong("honor");
                    long optLong2 = jSONObject.optLong("rival_honor");
                    if (optLong >= this.igw && optLong2 >= this.igx) {
                        this.igq.setText(fQ(optLong2) + "");
                        this.igj.setText(fQ(optLong) + "");
                        A(optLong, optLong2);
                        z = false;
                        break;
                    } else {
                        return;
                    }
                case 21:
                    coS();
                    z = false;
                    break;
                case 22:
                    coQ();
                    z = true;
                    break;
                case 24:
                    coO();
                    z = true;
                    break;
                case 30:
                    bUn();
                    z = true;
                    break;
            }
            if (z && !this.gPb.getGetPkInfoModel().aHm()) {
                this.gPb.getGetPkInfoModel().a(this.gPb.aHu.aFH.userId, jSONObject.optLong("pk_id"), this.gPb.aHu.mLiveInfo.room_id, this.gPb.aHu.mLiveInfo.live_id, this.gPb.isHost ? 1 : 0);
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gPb = pkRankView;
    }

    public void onDestroy() {
        if (this.gPb.getGetPkInfoModel() != null) {
            this.gPb.getGetPkInfoModel().clh();
        }
        coJ();
        if (this.igD != null) {
            this.igD.onDestroy();
        }
    }

    public void coJ() {
        if (this.ifV != null) {
            this.ifV.cancelTimer();
            this.ifV = null;
        }
    }

    public k getPkRankPropController() {
        if (this.igD == null) {
            this.igD = new k(this);
        }
        return this.igD;
    }

    public void coT() {
        this.igk.setAlpha(1.0f);
        this.igk.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void coU() {
        cI(this.igk);
        this.igk.setVisibility(8);
    }

    public void coV() {
        this.igl.setAlpha(0.8f);
        this.igl.setVisibility(0);
        this.igj.setVisibility(0);
    }

    public void coW() {
        this.igl.setAlpha(1.0f);
        this.igl.setVisibility(0);
        this.igj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pb(boolean z) {
        if (z) {
            this.igj.setVisibility(8);
            return;
        }
        cI(this.igl);
        this.igl.setVisibility(8);
        this.igj.setVisibility(0);
    }

    public void coX() {
        this.igr.setAlpha(1.0f);
        this.igr.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void coY() {
        cI(this.igr);
        this.igr.setVisibility(8);
    }

    public void coZ() {
        this.igs.setAlpha(1.0f);
        this.igs.setVisibility(0);
        this.igq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pc(boolean z) {
        if (z) {
            this.igq.setVisibility(8);
            return;
        }
        cI(this.igs);
        this.igs.setVisibility(8);
        this.igq.setVisibility(0);
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
        if (j - this.igw >= 100) {
            ObjectAnimator.ofFloat(this.igj, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.igj, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        if (j2 - this.igx >= 100) {
            ObjectAnimator.ofFloat(this.igq, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.igq, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        this.igw = j;
        this.igx = j2;
    }

    public void resetView() {
        this.igw = 0L;
        this.igx = 0L;
        this.igD.handler.removeCallbacksAndMessages(null);
        this.igs.setVisibility(8);
        this.igl.setVisibility(8);
        this.igk.setVisibility(8);
        this.igr.setVisibility(8);
        coJ();
        this.ign.setVisibility(0);
        this.igp.setVisibility(0);
        this.igq.setVisibility(0);
        this.igq.setText("0");
        this.igg.setVisibility(0);
        this.igi.setVisibility(0);
        this.igj.setVisibility(0);
        this.igj.setText("0");
    }
}
