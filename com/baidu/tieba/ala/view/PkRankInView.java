package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.data.PkInfoData;
import com.baidu.tieba.ala.data.PkKillInfoData;
import com.baidu.tieba.ala.data.PkTaskInfoData;
import com.baidu.tieba.ala.f;
import com.baidu.tieba.ala.h.m;
import com.baidu.tieba.ala.view.anim.AlaFirstBloodAnim;
import com.baidu.tieba.ala.view.anim.PkRankPropAnim;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PkRankInView extends RelativeLayout {
    Context context;
    PkRankView gRX;
    ImageView ilA;
    TextView ilB;
    TextView ilC;
    long ilD;
    long ilE;
    long ilF;
    RelativeLayout ilG;
    RelativeLayout ilH;
    TextView ilI;
    TextView ilJ;
    RelativeLayout ilK;
    TextView ilL;
    TextView ilM;
    SeekBar ilN;
    RelativeLayout ilO;
    TextView ilP;
    boolean ilQ;
    boolean ilR;
    boolean ilS;
    PkInfoData ilT;
    PkTaskInfoData ilU;
    PkKillInfoData ilV;
    int ilW;
    int ilX;
    long ilY;
    long ilZ;
    com.baidu.tieba.ala.f ilb;
    public RelativeLayout ilj;
    ImageView ilk;
    ImageView ill;
    RelativeLayout ilm;
    HeadImageView iln;
    TextView ilo;
    TextView ilp;
    FixedTextView ilq;
    TextView ilr;
    ImageView ils;
    RelativeLayout ilt;
    HeadImageView ilu;
    TextView ilv;
    TextView ilw;
    FixedTextView ilx;
    TextView ily;
    ImageView ilz;
    long ima;
    Queue<com.baidu.tieba.ala.view.anim.a> imb;
    Queue<com.baidu.tieba.ala.view.anim.a> imc;
    public AnimatorListenerAdapter imd;
    public AnimatorListenerAdapter ime;
    k imf;
    m imh;
    private HashMap<String, String> imi;
    private View mView;
    int status;

    public PkRankInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilQ = false;
        this.ilR = false;
        this.ilS = false;
        this.imb = new LinkedBlockingQueue();
        this.imc = new LinkedBlockingQueue();
        this.imi = new HashMap<>(32);
        this.context = context;
        initView();
    }

    private void initView() {
        this.imh = new m();
        this.imh.PU();
        cpX();
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_in_layout, (ViewGroup) this, true);
        this.ilm = (RelativeLayout) this.mView.findViewById(a.f.in_top_layout);
        this.ilj = (RelativeLayout) this.mView.findViewById(a.f.background_view);
        this.ilk = (ImageView) this.mView.findViewById(a.f.top_bg);
        this.ill = (ImageView) this.mView.findViewById(a.f.bottom_bg);
        this.ilA = (ImageView) this.mView.findViewById(a.f.pk_img);
        this.iln = (HeadImageView) this.mView.findViewById(a.f.top_head);
        this.ilo = (TextView) this.mView.findViewById(a.f.top_wins);
        this.ilp = (TextView) this.mView.findViewById(a.f.top_name);
        this.ilq = (FixedTextView) this.mView.findViewById(a.f.top_scores);
        this.ilr = (TextView) this.mView.findViewById(a.f.top_plus);
        this.ils = (ImageView) this.mView.findViewById(a.f.top_scores_shade);
        this.iln.setDefaultBgResource(a.e.sdk_default_avatar);
        this.iln.setIsRound(true);
        this.iln.setAutoChangeStyle(false);
        this.iln.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.iln.setBorderColor(872415231);
        this.ilm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gRX.A(PkRankInView.this.gRX.iny.H5URL, PkRankInView.this.gRX.iny.myPkData.userID);
            }
        });
        this.ilt = (RelativeLayout) this.mView.findViewById(a.f.in_bottom_layout);
        this.ilu = (HeadImageView) this.mView.findViewById(a.f.bottom_head);
        this.ilv = (TextView) this.mView.findViewById(a.f.bottom_wins);
        this.ilw = (TextView) this.mView.findViewById(a.f.bottom_name);
        this.ilx = (FixedTextView) this.mView.findViewById(a.f.bottom_scores);
        this.ily = (TextView) this.mView.findViewById(a.f.bottom_plus);
        this.ilz = (ImageView) this.mView.findViewById(a.f.bottom_scores_shade);
        this.ilu.setDefaultBgResource(a.e.sdk_default_avatar);
        this.ilu.setIsRound(true);
        this.ilu.setAutoChangeStyle(false);
        this.ilu.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.ilu.setBorderColor(872415231);
        this.ilt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gRX.A(PkRankInView.this.gRX.iny.H5URL, PkRankInView.this.gRX.iny.otherPkData.userID);
            }
        });
        this.ilB = (TextView) this.mView.findViewById(a.f.end_view);
        this.ilC = (TextView) this.mView.findViewById(a.f.timer);
        cpY();
        this.ilG = (RelativeLayout) this.mView.findViewById(a.f.task_tip_anim_view);
        this.ilH = (RelativeLayout) this.mView.findViewById(a.f.task_tip_view);
        this.ilI = (TextView) this.mView.findViewById(a.f.task_tip_view_title);
        this.ilJ = (TextView) this.mView.findViewById(a.f.task_tip_view_title_tip);
        this.ilK = (RelativeLayout) this.mView.findViewById(a.f.in_task_view);
        this.ilL = (TextView) this.mView.findViewById(a.f.in_task_view_title);
        this.ilM = (TextView) this.mView.findViewById(a.f.in_task_view_title_tip);
        this.ilN = (SeekBar) this.mView.findViewById(a.f.in_task_view_bar);
        this.ilO = (RelativeLayout) this.mView.findViewById(a.f.task_result_view);
        this.ilP = (TextView) this.mView.findViewById(a.f.task_result_view_result);
        cqm();
        this.imh.setParentView(this.ilG);
    }

    public void cpX() {
        this.ilV = null;
        this.ilU = null;
        this.ilY = 0L;
        this.ilZ = 0L;
        this.ima = 0L;
        this.ilR = false;
        this.ilQ = false;
        this.ilX = -10;
        this.ilW = 0;
        this.ilS = false;
    }

    private void cpY() {
        this.imd = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (PkRankInView.this.cqn()) {
                    PkRankInView.this.ilG.bringToFront();
                    PkRankInView.this.ilO.bringToFront();
                    PkRankInView.this.ilH.bringToFront();
                    PkRankInView.this.ilK.bringToFront();
                    return;
                }
                PkRankInView.this.ilA.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.imb.poll();
                if (PkRankInView.this.imb.peek() != null) {
                    PkRankInView.this.imb.peek().startAnim();
                }
                PkRankInView.this.ilO.bringToFront();
                PkRankInView.this.ilH.bringToFront();
                PkRankInView.this.ilK.bringToFront();
            }
        };
        this.ime = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (PkRankInView.this.cqn()) {
                    PkRankInView.this.ilG.bringToFront();
                    PkRankInView.this.ilO.bringToFront();
                    PkRankInView.this.ilH.bringToFront();
                    PkRankInView.this.ilK.bringToFront();
                    return;
                }
                PkRankInView.this.ilA.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.imc.poll();
                if (PkRankInView.this.imc.peek() != null) {
                    PkRankInView.this.imc.peek().startAnim();
                }
                PkRankInView.this.ilO.bringToFront();
                PkRankInView.this.ilH.bringToFront();
                PkRankInView.this.ilK.bringToFront();
            }
        };
    }

    public void a(PkInfoData pkInfoData, int i) {
        this.gRX.cqA();
        this.ilB.setVisibility(8);
        if (pkInfoData.pkStatusInfoData.pkStatus == 1) {
            e(pkInfoData);
        }
        this.status = i;
        if (this.gRX.wJ(i)) {
            this.ilT = pkInfoData;
            switch (i) {
                case 10:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    d(pkInfoData);
                    return;
                case 30:
                    bUZ();
                    return;
                default:
                    return;
            }
        }
    }

    private void d(PkInfoData pkInfoData) {
        this.ilu.startLoad(pkInfoData.otherPkData.bdPortrait, 12, false, false);
        if (pkInfoData.otherPkData.winningStreak > 1) {
            this.ilv.setVisibility(0);
            this.ilv.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.otherPkData.winningStreak)));
        } else {
            this.ilv.setVisibility(8);
        }
        this.ilw.setText(pkInfoData.otherPkData.userNickName);
        this.iln.startLoad(pkInfoData.myPkData.bdPortrait, 12, false, false);
        if (pkInfoData.myPkData.winningStreak > 1) {
            this.ilo.setVisibility(0);
            this.ilo.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.myPkData.winningStreak)));
        } else {
            this.ilo.setVisibility(8);
        }
        this.ilp.setText(pkInfoData.myPkData.userNickName);
        if (pkInfoData.pkStatusInfoData.anchorScore >= this.ilD && pkInfoData.pkStatusInfoData.rivalScore >= this.ilE) {
            this.ilq.setText(fV(pkInfoData.pkStatusInfoData.anchorScore) + "");
            this.ilx.setText(fV(pkInfoData.pkStatusInfoData.rivalScore) + "");
            E(pkInfoData.pkStatusInfoData.anchorScore, pkInfoData.pkStatusInfoData.rivalScore);
        }
    }

    private void e(PkInfoData pkInfoData) {
        long j = pkInfoData.pkStatusInfoData.stageEndTime - pkInfoData.pkStatusInfoData.nowTime;
        if (j <= 0) {
            this.ilC.setVisibility(8);
        } else if (this.ilb == null || !this.ilb.isRunning()) {
            this.ilC.setVisibility(0);
            this.ilb = new com.baidu.tieba.ala.f(j * 1000, 1000L);
            this.ilb.a(new f.a() { // from class: com.baidu.tieba.ala.view.PkRankInView.5
                @Override // com.baidu.tieba.ala.f.a
                public void onTick(long j2) {
                    PkRankInView.this.ilF = Math.round(j2 / 1000.0d);
                    PkRankInView.this.ilC.setText(StringHelper.formatSecondsTime(PkRankInView.this.ilF));
                    PkRankInView.this.cql();
                }

                @Override // com.baidu.tieba.ala.f.a
                public void onFinish() {
                    PkRankInView.this.ilb.cancelTimer();
                    if (!PkRankInView.this.gRX.isHost) {
                        PkRankInView.this.bUZ();
                    }
                    PkRankInView.this.cpZ();
                }
            });
            this.ilb.startTimer();
        } else if (this.ilF - j >= 1) {
            this.ilb.cancelTimer();
            this.ilb = null;
            e(pkInfoData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpZ() {
        this.gRX.getGetPkInfoModel().a(this.gRX.aJZ.aId.userId, this.gRX.iny.pkStatusInfoData.pkID, this.gRX.aJZ.mLiveInfo.room_id, this.gRX.aJZ.mLiveInfo.live_id, this.gRX.isHost ? 1 : 0);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.6
            @Override // java.lang.Runnable
            public void run() {
                PkRankInView.this.gRX.getGetPkInfoModel().a(PkRankInView.this.gRX.aJZ.aId.userId, PkRankInView.this.gRX.iny.pkStatusInfoData.pkID, PkRankInView.this.gRX.aJZ.mLiveInfo.room_id, PkRankInView.this.gRX.aJZ.mLiveInfo.live_id, PkRankInView.this.gRX.isHost ? 1 : 0);
            }
        }, this.gRX.iny.resultInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUZ() {
        this.ilB.bringToFront();
        this.ilB.setVisibility(0);
        this.ilC.setVisibility(8);
    }

    private void cqa() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.imd);
        pkRankPropAnim.setParentView(this.ilj);
        a(pkRankPropAnim);
    }

    private void cqb() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.ime);
        pkRankPropAnim.setParentView(this.ilj);
        b(pkRankPropAnim);
    }

    private void cqc() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.imd);
        pkRankPropAnim.setParentView(this.ilj);
        a(pkRankPropAnim);
    }

    private void cqd() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.ime);
        pkRankPropAnim.setParentView(this.ilj);
        b(pkRankPropAnim);
    }

    private void cqe() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, true);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.imd);
        alaFirstBloodAnim.setParentView(this.ilj);
        a(alaFirstBloodAnim);
    }

    private void cqf() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, false);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.ime);
        alaFirstBloodAnim.setParentView(this.ilj);
        b(alaFirstBloodAnim);
    }

    private void cE(View view) {
        ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(300L).start();
    }

    private void a(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.imb.peek() == null) {
            this.imb.add(aVar);
            this.imb.peek().startAnim();
            return;
        }
        this.imb.add(aVar);
    }

    private void b(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.imc.peek() == null) {
            this.imc.add(aVar);
            this.imc.peek().startAnim();
            return;
        }
        this.imc.add(aVar);
    }

    public void e(JSONObject jSONObject, int i) {
        boolean z;
        if (this.gRX.wJ(i)) {
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
                    cqe();
                    z = false;
                    break;
                case 12:
                    cqc();
                    if (this.gRX.aJZ.isHost || jSONObject.optLong("user_id") == this.gRX.aJZ.aIz.userId) {
                        cqh();
                        z = true;
                        break;
                    } else {
                        cqi();
                        z = true;
                        break;
                    }
                    break;
                case 13:
                case 15:
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
                    cqa();
                    IC(jSONObject.optString("buff_multiple", "1"));
                    z = true;
                    break;
                case 16:
                    long optLong = jSONObject.optLong("honor");
                    long optLong2 = jSONObject.optLong("rival_honor");
                    if (optLong >= this.ilD && optLong2 >= this.ilE) {
                        this.ilx.setText(fV(optLong2) + "");
                        this.ilq.setText(fV(optLong) + "");
                        E(optLong, optLong2);
                        z = false;
                        break;
                    } else {
                        return;
                    }
                    break;
                case 17:
                    PkTaskInfoData pkTaskInfoData = new PkTaskInfoData();
                    pkTaskInfoData.parserJson(jSONObject);
                    this.ilU = pkTaskInfoData;
                    a(pkTaskInfoData, this.ilT.pkStatusInfoData.nowTime, this.ilT.pkStatusInfoData.stageEndTime);
                    z = true;
                    break;
                case 18:
                    PkKillInfoData pkKillInfoData = new PkKillInfoData();
                    pkKillInfoData.parserJson(jSONObject);
                    this.ilV = pkKillInfoData;
                    a(pkKillInfoData, this.ilT.pkStatusInfoData.nowTime, this.ilT.pkStatusInfoData.stageEndTime);
                    z = true;
                    break;
                case 21:
                    cqf();
                    z = false;
                    break;
                case 22:
                    cqd();
                    cqk();
                    z = true;
                    break;
                case 24:
                    cqb();
                    ID(jSONObject.optString("buff_multiple", "1"));
                    z = true;
                    break;
                case 30:
                    bUZ();
                    z = true;
                    break;
            }
            if (z) {
                this.gRX.getGetPkInfoModel().a(this.gRX.aJZ.aId.userId, jSONObject.optLong("pk_id"), this.gRX.aJZ.mLiveInfo.room_id, this.gRX.aJZ.mLiveInfo.live_id, this.gRX.isHost ? 1 : 0);
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gRX = pkRankView;
    }

    public void onDestroy() {
        if (this.gRX.getGetPkInfoModel() != null) {
            this.gRX.getGetPkInfoModel().cmm();
        }
        cpV();
        if (this.imf != null) {
            this.imf.onDestroy();
        }
        if (this.imh != null) {
            this.imh.release();
            this.imh = null;
        }
        cpX();
    }

    public void cpV() {
        if (this.ilb != null) {
            this.ilb.cancelTimer();
            this.ilb = null;
        }
    }

    public k getPkRankPropController() {
        if (this.imf == null) {
            this.imf = new k(this);
        }
        return this.imf;
    }

    public void IC(String str) {
        this.ilr.setAlpha(1.0f);
        this.ilr.setText("加成x" + str);
        this.ilr.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cqg() {
        cE(this.ilr);
        this.ilr.setVisibility(8);
    }

    public void cqh() {
        this.ils.setAlpha(0.8f);
        this.ils.setVisibility(0);
        this.ilq.setVisibility(0);
    }

    public void cqi() {
        this.ils.setAlpha(1.0f);
        this.ils.setVisibility(0);
        this.ilq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pl(boolean z) {
        if (z) {
            this.ilq.setVisibility(8);
            return;
        }
        cE(this.ils);
        this.ils.setVisibility(8);
        this.ilq.setVisibility(0);
    }

    public void ID(String str) {
        this.ily.setAlpha(1.0f);
        this.ily.setText("加成x" + str);
        this.ily.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cqj() {
        cE(this.ily);
        this.ily.setVisibility(8);
    }

    public void cqk() {
        this.ilz.setAlpha(1.0f);
        this.ilz.setVisibility(0);
        this.ilx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pm(boolean z) {
        if (z) {
            this.ilx.setVisibility(8);
            return;
        }
        cE(this.ilz);
        this.ilz.setVisibility(8);
        this.ilx.setVisibility(0);
    }

    String fV(long j) {
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

    void E(long j, long j2) {
        if (j - this.ilD >= 100) {
            ObjectAnimator.ofFloat(this.ilq, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.ilq, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        if (j2 - this.ilE >= 100) {
            ObjectAnimator.ofFloat(this.ilx, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.ilx, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        this.ilD = j;
        this.ilE = j2;
    }

    public void resetView() {
        this.ilD = 0L;
        this.ilE = 0L;
        this.imf.handler.removeCallbacksAndMessages(null);
        this.ilz.setVisibility(8);
        this.ils.setVisibility(8);
        this.ilr.setVisibility(8);
        this.ily.setVisibility(8);
        cpV();
        this.ilu.setVisibility(0);
        this.ilw.setVisibility(0);
        this.ilx.setVisibility(0);
        this.ilx.setText("0");
        this.iln.setVisibility(0);
        this.ilp.setVisibility(0);
        this.ilq.setVisibility(0);
        this.ilq.setText("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cql() {
        if (this.ilU != null && this.ilU.status > this.ilT.taskInfoData.status) {
            a(this.ilU, this.ilT.pkStatusInfoData.nowTime, this.ilT.pkStatusInfoData.stageEndTime);
        } else {
            a(this.ilT.taskInfoData, this.ilT.pkStatusInfoData.nowTime, this.ilT.pkStatusInfoData.stageEndTime);
        }
        if (this.ilV != null && this.ilV.status > this.ilT.killInfoData.status) {
            a(this.ilV, this.ilT.pkStatusInfoData.nowTime, this.ilT.pkStatusInfoData.stageEndTime);
        } else {
            a(this.ilT.killInfoData, this.ilT.pkStatusInfoData.nowTime, this.ilT.pkStatusInfoData.stageEndTime);
        }
    }

    private void a(PkTaskInfoData pkTaskInfoData, long j, long j2) {
        if (pkTaskInfoData != null) {
            if (this.ilW != 2 || pkTaskInfoData.status != 1) {
                if (this.ilW != 3 || pkTaskInfoData.status != 1) {
                    if (this.ilW != 1 || pkTaskInfoData.status != 0) {
                        if (this.ilW != 0 || pkTaskInfoData.status != 3) {
                            if (this.ilW != 0 || pkTaskInfoData.status != 2) {
                                this.ilW = pkTaskInfoData.status;
                                switch (pkTaskInfoData.status) {
                                    case 0:
                                        this.ilQ = false;
                                        long j3 = pkTaskInfoData.startTime;
                                        if (pkTaskInfoData.preStartTime > 0 && j >= pkTaskInfoData.preStartTime) {
                                            cqm();
                                            long j4 = this.ilF - (j2 - j3);
                                            if (j4 <= 0) {
                                                j4 = 0;
                                            }
                                            this.ilI.setText(j4 + "秒" + pkTaskInfoData.title);
                                            this.ilJ.setText(pkTaskInfoData.tip);
                                            this.ilI.setTextColor(Color.parseColor("#FFFFFFFF"));
                                            this.ilJ.setTextColor(Color.parseColor("#FFFFF465"));
                                            this.ilH.setVisibility(0);
                                            cG(this.ilH);
                                            if (!this.gRX.isHost && j4 == 0) {
                                                this.gRX.getGetPkInfoModel().a(this.gRX.aJZ.aId.userId, this.ilT.pkStatusInfoData.pkID, this.gRX.aJZ.mLiveInfo.room_id, this.gRX.aJZ.mLiveInfo.live_id, this.gRX.isHost ? 1 : 0);
                                            }
                                            eG("pk_competition_task", "show_countdown");
                                        }
                                        if (pkTaskInfoData.preStartTime > 0 && j < pkTaskInfoData.preStartTime) {
                                            cqm();
                                            this.ilA.setVisibility(0);
                                            cpX();
                                            return;
                                        }
                                        return;
                                    case 1:
                                        cqm();
                                        this.ilQ = false;
                                        this.ilY = this.ilY > ((long) pkTaskInfoData.countDown) ? this.ilY : pkTaskInfoData.countDown;
                                        long max = Math.max(pkTaskInfoData.startTime + this.ilY, pkTaskInfoData.endTime);
                                        this.ilK.setVisibility(0);
                                        cG(this.ilK);
                                        long j5 = this.ilF - (j2 - max);
                                        if (pkTaskInfoData.countDown < j5) {
                                            j5 = pkTaskInfoData.countDown;
                                        }
                                        if (j5 <= 0) {
                                            j5 = 0;
                                        }
                                        this.ilL.setText(j5 + "秒" + pkTaskInfoData.title);
                                        this.ilM.setText(pkTaskInfoData.tip);
                                        this.ilN.setProgress((int) ((pkTaskInfoData.nowNum / Double.parseDouble(pkTaskInfoData.targetNum)) * 100.0d));
                                        if (!this.gRX.isHost && j5 == 0) {
                                            this.gRX.getGetPkInfoModel().a(this.gRX.aJZ.aId.userId, this.ilT.pkStatusInfoData.pkID, this.gRX.aJZ.mLiveInfo.room_id, this.gRX.aJZ.mLiveInfo.live_id, this.gRX.isHost ? 1 : 0);
                                        }
                                        eG("pk_competition_task", "task_start");
                                        return;
                                    case 2:
                                        if (cqn() && !this.ilQ) {
                                            cqm();
                                            this.ilQ = true;
                                            this.ilO.setVisibility(0);
                                            this.ilP.setText(pkTaskInfoData.title);
                                            this.ilP.setTextColor(Color.parseColor("#FFFFFFFF"));
                                            cG(this.ilO);
                                            this.ilO.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.7
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    PkRankInView.this.cqm();
                                                    PkRankInView.this.ilU = null;
                                                    PkRankInView.this.ilA.setVisibility(0);
                                                }
                                            }, IMConnection.RETRY_DELAY_TIMES);
                                            this.ilY = 0L;
                                            eG("pk_competition_task", "task_failed");
                                            return;
                                        }
                                        return;
                                    case 3:
                                        if (cqn() && !this.ilQ) {
                                            cqm();
                                            this.ilQ = true;
                                            this.ilO.setVisibility(0);
                                            this.ilP.setText(pkTaskInfoData.title + "\n" + pkTaskInfoData.tip);
                                            this.ilP.setTextColor(Color.parseColor("#FF89460D"));
                                            this.ilG.setVisibility(0);
                                            cF(this.ilO);
                                            this.ilO.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.8
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    PkRankInView.this.cqm();
                                                    PkRankInView.this.ilU = null;
                                                    PkRankInView.this.ilA.setVisibility(0);
                                                }
                                            }, IMConnection.RETRY_DELAY_TIMES);
                                            this.ilY = 0L;
                                            eG("pk_competition_task", "task_success");
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(PkKillInfoData pkKillInfoData, long j, long j2) {
        if (pkKillInfoData != null) {
            if (this.ilX != 3 || pkKillInfoData.status == 3) {
                if (this.ilX != 4 || pkKillInfoData.status == 4) {
                    if (this.ilX != -3 || pkKillInfoData.status == -3) {
                        if (this.ilX != -2 || pkKillInfoData.status == -2) {
                            if (this.ilX != 2 || pkKillInfoData.status != -1) {
                                this.ilX = pkKillInfoData.status;
                                switch (pkKillInfoData.status) {
                                    case -3:
                                    case -2:
                                        if (cqn() && !this.ilR) {
                                            cqm();
                                            this.ilH.setVisibility(0);
                                            this.ilI.setText(pkKillInfoData.title);
                                            this.ilJ.setText(pkKillInfoData.tip);
                                            this.ilI.setTextColor(Color.parseColor("#FFFFFFFF"));
                                            this.ilJ.setTextColor(Color.parseColor("#FFFFF465"));
                                            cG(this.ilH);
                                            this.ilR = true;
                                            this.ilI.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.9
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    PkRankInView.this.cqm();
                                                    PkRankInView.this.ilA.setVisibility(0);
                                                }
                                            }, IMConnection.RETRY_DELAY_TIMES);
                                            this.ima = 0L;
                                            this.ilZ = 0L;
                                            if (pkKillInfoData.status == -2) {
                                                eG("pk_competition_kill_mode", "activate_failed");
                                                return;
                                            } else {
                                                eG("pk_competition_kill_mode", "kill_failed");
                                                return;
                                            }
                                        }
                                        return;
                                    case -1:
                                        cqm();
                                        this.ilH.setVisibility(0);
                                        this.ilI.setText(pkKillInfoData.title);
                                        this.ilJ.setText(pkKillInfoData.tip);
                                        this.ilI.setTextColor(Color.parseColor("#FFFFFFFF"));
                                        this.ilJ.setTextColor(Color.parseColor("#FFFFF465"));
                                        cG(this.ilH);
                                        eG("pk_competition_kill_mode", "in_activating");
                                        return;
                                    case 0:
                                    default:
                                        return;
                                    case 1:
                                        this.ilR = false;
                                        if (this.ilZ < pkKillInfoData.countDown) {
                                            this.ilZ = pkKillInfoData.countDown;
                                        }
                                        long j3 = pkKillInfoData.startTime + this.ilZ;
                                        if (pkKillInfoData.startTime > 0 && j >= pkKillInfoData.startTime) {
                                            cqm();
                                            long j4 = this.ilF - (j2 - j3);
                                            if (pkKillInfoData.countDown < j4) {
                                                j4 = pkKillInfoData.countDown;
                                            }
                                            if (j4 <= 0) {
                                                j4 = 0;
                                            }
                                            this.ilI.setText(j4 + "秒" + pkKillInfoData.title);
                                            this.ilJ.setText(pkKillInfoData.tip);
                                            this.ilI.setTextColor(Color.parseColor("#FFFFFFFF"));
                                            this.ilJ.setTextColor(Color.parseColor("#FFFFF465"));
                                            this.ilH.setVisibility(0);
                                            cG(this.ilH);
                                            if (!this.gRX.isHost && j4 == 0) {
                                                this.gRX.getGetPkInfoModel().a(this.gRX.aJZ.aId.userId, this.ilT.pkStatusInfoData.pkID, this.gRX.aJZ.mLiveInfo.room_id, this.gRX.aJZ.mLiveInfo.live_id, this.gRX.isHost ? 1 : 0);
                                            }
                                            eG("pk_competition_kill_mode", "show_countdown");
                                            return;
                                        }
                                        return;
                                    case 2:
                                        cqm();
                                        this.ilR = false;
                                        if (this.ima < pkKillInfoData.countDown) {
                                            this.ima = pkKillInfoData.countDown;
                                        }
                                        long max = Math.max(pkKillInfoData.endTime, pkKillInfoData.startTime + this.ima);
                                        this.ilH.setVisibility(0);
                                        cF(this.ilH);
                                        long j5 = this.ilF - (j2 - max);
                                        if (j5 <= 0) {
                                            j5 = 0;
                                        }
                                        this.ilI.setText(j5 + "秒" + pkKillInfoData.title);
                                        this.ilJ.setText(pkKillInfoData.tip);
                                        this.ilI.setTextColor(Color.parseColor("#FF89460D"));
                                        this.ilJ.setTextColor(Color.parseColor("#FF89460D"));
                                        eG("pk_competition_kill_mode", "activate_success");
                                        return;
                                    case 3:
                                    case 4:
                                        if (cqn() && !this.ilR) {
                                            cqm();
                                            this.ilA.setVisibility(0);
                                            this.gRX.fW(-1L);
                                            this.ilR = true;
                                            this.ilV = null;
                                            this.ima = 0L;
                                            this.ilZ = 0L;
                                            if (pkKillInfoData.status == 3) {
                                                eG("pk_competition_kill_mode", "kill_success");
                                                return;
                                            } else {
                                                eG("pk_competition_kill_mode", "anti_kill_success");
                                                return;
                                            }
                                        }
                                        return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void cF(View view) {
        this.ilA.setVisibility(8);
        if (this.imh != null && this.imh.coZ()) {
            this.ilG.setVisibility(0);
            view.setBackgroundResource(a.c.sdk_transparent);
            return;
        }
        view.setBackgroundResource(a.e.ala_pk_rank_task_bg_light);
    }

    private void cG(View view) {
        this.ilS = false;
        if (this.imh != null) {
            this.imh.reset();
            view.setVisibility(0);
            view.setBackgroundResource(a.e.ala_pk_rank_task_bg_black);
            this.ilA.setVisibility(8);
        }
    }

    public void cqm() {
        this.ilH.setVisibility(8);
        this.ilK.setVisibility(8);
        this.ilO.setVisibility(8);
        this.ilG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqn() {
        return this.ilO.getVisibility() == 0 || this.ilH.getVisibility() == 0 || this.ilK.getVisibility() == 0;
    }

    public void eG(String str, String str2) {
        if (this.gRX.isHost) {
            if (this.imi.containsKey(str + str2)) {
                if (this.ilT.pkStatusInfoData.pkID != Integer.parseInt(this.imi.get(str + str2))) {
                    eH(str, str2);
                    this.imi.put(str + str2, this.ilT.pkStatusInfoData.pkID + "");
                    return;
                }
                return;
            }
            eH(str, str2);
            this.imi.put(str + str2, this.ilT.pkStatusInfoData.pkID + "");
        }
    }

    private void eH(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pkId", Long.valueOf(this.ilT.pkStatusInfoData.pkID));
            jSONObject.putOpt("lodId", Long.valueOf(this.ilT.logId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, str, "author_liveroom", str2).setContentExt(jSONObject));
    }
}
