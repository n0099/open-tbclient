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
    PkRankView gRJ;
    com.baidu.tieba.ala.f ikN;
    public RelativeLayout ikV;
    ImageView ikW;
    ImageView ikX;
    RelativeLayout ikY;
    HeadImageView ikZ;
    RelativeLayout ilA;
    TextView ilB;
    boolean ilC;
    boolean ilD;
    boolean ilE;
    PkInfoData ilF;
    PkTaskInfoData ilG;
    PkKillInfoData ilH;
    int ilI;
    int ilJ;
    long ilK;
    long ilL;
    long ilM;
    Queue<com.baidu.tieba.ala.view.anim.a> ilN;
    Queue<com.baidu.tieba.ala.view.anim.a> ilO;
    public AnimatorListenerAdapter ilP;
    public AnimatorListenerAdapter ilQ;
    k ilR;
    m ilS;
    private HashMap<String, String> ilT;
    TextView ila;
    TextView ilb;
    FixedTextView ilc;
    TextView ild;
    ImageView ile;
    RelativeLayout ilf;
    HeadImageView ilg;
    TextView ilh;
    TextView ili;
    FixedTextView ilj;
    TextView ilk;
    ImageView ill;
    ImageView ilm;
    TextView iln;
    TextView ilo;
    long ilp;
    long ilq;
    long ilr;
    RelativeLayout ils;
    RelativeLayout ilt;
    TextView ilu;
    TextView ilv;
    RelativeLayout ilw;
    TextView ilx;
    TextView ily;
    SeekBar ilz;
    private View mView;
    int status;

    public PkRankInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilC = false;
        this.ilD = false;
        this.ilE = false;
        this.ilN = new LinkedBlockingQueue();
        this.ilO = new LinkedBlockingQueue();
        this.ilT = new HashMap<>(32);
        this.context = context;
        initView();
    }

    private void initView() {
        this.ilS = new m();
        this.ilS.PU();
        cpQ();
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_in_layout, (ViewGroup) this, true);
        this.ikY = (RelativeLayout) this.mView.findViewById(a.f.in_top_layout);
        this.ikV = (RelativeLayout) this.mView.findViewById(a.f.background_view);
        this.ikW = (ImageView) this.mView.findViewById(a.f.top_bg);
        this.ikX = (ImageView) this.mView.findViewById(a.f.bottom_bg);
        this.ilm = (ImageView) this.mView.findViewById(a.f.pk_img);
        this.ikZ = (HeadImageView) this.mView.findViewById(a.f.top_head);
        this.ila = (TextView) this.mView.findViewById(a.f.top_wins);
        this.ilb = (TextView) this.mView.findViewById(a.f.top_name);
        this.ilc = (FixedTextView) this.mView.findViewById(a.f.top_scores);
        this.ild = (TextView) this.mView.findViewById(a.f.top_plus);
        this.ile = (ImageView) this.mView.findViewById(a.f.top_scores_shade);
        this.ikZ.setDefaultBgResource(a.e.sdk_default_avatar);
        this.ikZ.setIsRound(true);
        this.ikZ.setAutoChangeStyle(false);
        this.ikZ.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.ikZ.setBorderColor(872415231);
        this.ikY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gRJ.A(PkRankInView.this.gRJ.inj.H5URL, PkRankInView.this.gRJ.inj.myPkData.userID);
            }
        });
        this.ilf = (RelativeLayout) this.mView.findViewById(a.f.in_bottom_layout);
        this.ilg = (HeadImageView) this.mView.findViewById(a.f.bottom_head);
        this.ilh = (TextView) this.mView.findViewById(a.f.bottom_wins);
        this.ili = (TextView) this.mView.findViewById(a.f.bottom_name);
        this.ilj = (FixedTextView) this.mView.findViewById(a.f.bottom_scores);
        this.ilk = (TextView) this.mView.findViewById(a.f.bottom_plus);
        this.ill = (ImageView) this.mView.findViewById(a.f.bottom_scores_shade);
        this.ilg.setDefaultBgResource(a.e.sdk_default_avatar);
        this.ilg.setIsRound(true);
        this.ilg.setAutoChangeStyle(false);
        this.ilg.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.ilg.setBorderColor(872415231);
        this.ilf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gRJ.A(PkRankInView.this.gRJ.inj.H5URL, PkRankInView.this.gRJ.inj.otherPkData.userID);
            }
        });
        this.iln = (TextView) this.mView.findViewById(a.f.end_view);
        this.ilo = (TextView) this.mView.findViewById(a.f.timer);
        cpR();
        this.ils = (RelativeLayout) this.mView.findViewById(a.f.task_tip_anim_view);
        this.ilt = (RelativeLayout) this.mView.findViewById(a.f.task_tip_view);
        this.ilu = (TextView) this.mView.findViewById(a.f.task_tip_view_title);
        this.ilv = (TextView) this.mView.findViewById(a.f.task_tip_view_title_tip);
        this.ilw = (RelativeLayout) this.mView.findViewById(a.f.in_task_view);
        this.ilx = (TextView) this.mView.findViewById(a.f.in_task_view_title);
        this.ily = (TextView) this.mView.findViewById(a.f.in_task_view_title_tip);
        this.ilz = (SeekBar) this.mView.findViewById(a.f.in_task_view_bar);
        this.ilA = (RelativeLayout) this.mView.findViewById(a.f.task_result_view);
        this.ilB = (TextView) this.mView.findViewById(a.f.task_result_view_result);
        cqf();
        this.ilS.setParentView(this.ils);
    }

    public void cpQ() {
        this.ilH = null;
        this.ilG = null;
        this.ilK = 0L;
        this.ilL = 0L;
        this.ilM = 0L;
        this.ilD = false;
        this.ilC = false;
        this.ilJ = -10;
        this.ilI = 0;
        this.ilE = false;
    }

    private void cpR() {
        this.ilP = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (PkRankInView.this.cqg()) {
                    PkRankInView.this.ils.bringToFront();
                    PkRankInView.this.ilA.bringToFront();
                    PkRankInView.this.ilt.bringToFront();
                    PkRankInView.this.ilw.bringToFront();
                    return;
                }
                PkRankInView.this.ilm.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.ilN.poll();
                if (PkRankInView.this.ilN.peek() != null) {
                    PkRankInView.this.ilN.peek().startAnim();
                }
                PkRankInView.this.ilA.bringToFront();
                PkRankInView.this.ilt.bringToFront();
                PkRankInView.this.ilw.bringToFront();
            }
        };
        this.ilQ = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (PkRankInView.this.cqg()) {
                    PkRankInView.this.ils.bringToFront();
                    PkRankInView.this.ilA.bringToFront();
                    PkRankInView.this.ilt.bringToFront();
                    PkRankInView.this.ilw.bringToFront();
                    return;
                }
                PkRankInView.this.ilm.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.ilO.poll();
                if (PkRankInView.this.ilO.peek() != null) {
                    PkRankInView.this.ilO.peek().startAnim();
                }
                PkRankInView.this.ilA.bringToFront();
                PkRankInView.this.ilt.bringToFront();
                PkRankInView.this.ilw.bringToFront();
            }
        };
    }

    public void a(PkInfoData pkInfoData, int i) {
        this.gRJ.cqt();
        this.iln.setVisibility(8);
        if (pkInfoData.pkStatusInfoData.pkStatus == 1) {
            e(pkInfoData);
        }
        this.status = i;
        if (this.gRJ.wJ(i)) {
            this.ilF = pkInfoData;
            switch (i) {
                case 10:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    d(pkInfoData);
                    return;
                case 30:
                    bUS();
                    return;
                default:
                    return;
            }
        }
    }

    private void d(PkInfoData pkInfoData) {
        this.ilg.startLoad(pkInfoData.otherPkData.bdPortrait, 12, false, false);
        if (pkInfoData.otherPkData.winningStreak > 1) {
            this.ilh.setVisibility(0);
            this.ilh.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.otherPkData.winningStreak)));
        } else {
            this.ilh.setVisibility(8);
        }
        this.ili.setText(pkInfoData.otherPkData.userNickName);
        this.ikZ.startLoad(pkInfoData.myPkData.bdPortrait, 12, false, false);
        if (pkInfoData.myPkData.winningStreak > 1) {
            this.ila.setVisibility(0);
            this.ila.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.myPkData.winningStreak)));
        } else {
            this.ila.setVisibility(8);
        }
        this.ilb.setText(pkInfoData.myPkData.userNickName);
        if (pkInfoData.pkStatusInfoData.anchorScore >= this.ilp && pkInfoData.pkStatusInfoData.rivalScore >= this.ilq) {
            this.ilc.setText(fV(pkInfoData.pkStatusInfoData.anchorScore) + "");
            this.ilj.setText(fV(pkInfoData.pkStatusInfoData.rivalScore) + "");
            E(pkInfoData.pkStatusInfoData.anchorScore, pkInfoData.pkStatusInfoData.rivalScore);
        }
    }

    private void e(PkInfoData pkInfoData) {
        long j = pkInfoData.pkStatusInfoData.stageEndTime - pkInfoData.pkStatusInfoData.nowTime;
        if (j <= 0) {
            this.ilo.setVisibility(8);
        } else if (this.ikN == null || !this.ikN.isRunning()) {
            this.ilo.setVisibility(0);
            this.ikN = new com.baidu.tieba.ala.f(j * 1000, 1000L);
            this.ikN.a(new f.a() { // from class: com.baidu.tieba.ala.view.PkRankInView.5
                @Override // com.baidu.tieba.ala.f.a
                public void onTick(long j2) {
                    PkRankInView.this.ilr = Math.round(j2 / 1000.0d);
                    PkRankInView.this.ilo.setText(StringHelper.formatSecondsTime(PkRankInView.this.ilr));
                    PkRankInView.this.cqe();
                }

                @Override // com.baidu.tieba.ala.f.a
                public void onFinish() {
                    PkRankInView.this.ikN.cancelTimer();
                    if (!PkRankInView.this.gRJ.isHost) {
                        PkRankInView.this.bUS();
                    }
                    PkRankInView.this.cpS();
                }
            });
            this.ikN.startTimer();
        } else if (this.ilr - j >= 1) {
            this.ikN.cancelTimer();
            this.ikN = null;
            e(pkInfoData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpS() {
        this.gRJ.getGetPkInfoModel().a(this.gRJ.aJZ.aId.userId, this.gRJ.inj.pkStatusInfoData.pkID, this.gRJ.aJZ.mLiveInfo.room_id, this.gRJ.aJZ.mLiveInfo.live_id, this.gRJ.isHost ? 1 : 0);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.6
            @Override // java.lang.Runnable
            public void run() {
                PkRankInView.this.gRJ.getGetPkInfoModel().a(PkRankInView.this.gRJ.aJZ.aId.userId, PkRankInView.this.gRJ.inj.pkStatusInfoData.pkID, PkRankInView.this.gRJ.aJZ.mLiveInfo.room_id, PkRankInView.this.gRJ.aJZ.mLiveInfo.live_id, PkRankInView.this.gRJ.isHost ? 1 : 0);
            }
        }, this.gRJ.inj.resultInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUS() {
        this.iln.bringToFront();
        this.iln.setVisibility(0);
        this.ilo.setVisibility(8);
    }

    private void cpT() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.ilP);
        pkRankPropAnim.setParentView(this.ikV);
        a(pkRankPropAnim);
    }

    private void cpU() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.ilQ);
        pkRankPropAnim.setParentView(this.ikV);
        b(pkRankPropAnim);
    }

    private void cpV() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.ilP);
        pkRankPropAnim.setParentView(this.ikV);
        a(pkRankPropAnim);
    }

    private void cpW() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.ilQ);
        pkRankPropAnim.setParentView(this.ikV);
        b(pkRankPropAnim);
    }

    private void cpX() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, true);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.ilP);
        alaFirstBloodAnim.setParentView(this.ikV);
        a(alaFirstBloodAnim);
    }

    private void cpY() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, false);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.ilQ);
        alaFirstBloodAnim.setParentView(this.ikV);
        b(alaFirstBloodAnim);
    }

    private void cE(View view) {
        ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(300L).start();
    }

    private void a(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.ilN.peek() == null) {
            this.ilN.add(aVar);
            this.ilN.peek().startAnim();
            return;
        }
        this.ilN.add(aVar);
    }

    private void b(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.ilO.peek() == null) {
            this.ilO.add(aVar);
            this.ilO.peek().startAnim();
            return;
        }
        this.ilO.add(aVar);
    }

    public void e(JSONObject jSONObject, int i) {
        boolean z;
        if (this.gRJ.wJ(i)) {
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
                    cpX();
                    z = false;
                    break;
                case 12:
                    cpV();
                    if (this.gRJ.aJZ.isHost || jSONObject.optLong("user_id") == this.gRJ.aJZ.aIz.userId) {
                        cqa();
                        z = true;
                        break;
                    } else {
                        cqb();
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
                    cpT();
                    IB(jSONObject.optString("buff_multiple", "1"));
                    z = true;
                    break;
                case 16:
                    long optLong = jSONObject.optLong("honor");
                    long optLong2 = jSONObject.optLong("rival_honor");
                    if (optLong >= this.ilp && optLong2 >= this.ilq) {
                        this.ilj.setText(fV(optLong2) + "");
                        this.ilc.setText(fV(optLong) + "");
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
                    this.ilG = pkTaskInfoData;
                    a(pkTaskInfoData, this.ilF.pkStatusInfoData.nowTime, this.ilF.pkStatusInfoData.stageEndTime);
                    z = true;
                    break;
                case 18:
                    PkKillInfoData pkKillInfoData = new PkKillInfoData();
                    pkKillInfoData.parserJson(jSONObject);
                    this.ilH = pkKillInfoData;
                    a(pkKillInfoData, this.ilF.pkStatusInfoData.nowTime, this.ilF.pkStatusInfoData.stageEndTime);
                    z = true;
                    break;
                case 21:
                    cpY();
                    z = false;
                    break;
                case 22:
                    cpW();
                    cqd();
                    z = true;
                    break;
                case 24:
                    cpU();
                    IC(jSONObject.optString("buff_multiple", "1"));
                    z = true;
                    break;
                case 30:
                    bUS();
                    z = true;
                    break;
            }
            if (z) {
                this.gRJ.getGetPkInfoModel().a(this.gRJ.aJZ.aId.userId, jSONObject.optLong("pk_id"), this.gRJ.aJZ.mLiveInfo.room_id, this.gRJ.aJZ.mLiveInfo.live_id, this.gRJ.isHost ? 1 : 0);
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gRJ = pkRankView;
    }

    public void onDestroy() {
        if (this.gRJ.getGetPkInfoModel() != null) {
            this.gRJ.getGetPkInfoModel().cmf();
        }
        cpO();
        if (this.ilR != null) {
            this.ilR.onDestroy();
        }
        if (this.ilS != null) {
            this.ilS.release();
            this.ilS = null;
        }
        cpQ();
    }

    public void cpO() {
        if (this.ikN != null) {
            this.ikN.cancelTimer();
            this.ikN = null;
        }
    }

    public k getPkRankPropController() {
        if (this.ilR == null) {
            this.ilR = new k(this);
        }
        return this.ilR;
    }

    public void IB(String str) {
        this.ild.setAlpha(1.0f);
        this.ild.setText("加成x" + str);
        this.ild.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cpZ() {
        cE(this.ild);
        this.ild.setVisibility(8);
    }

    public void cqa() {
        this.ile.setAlpha(0.8f);
        this.ile.setVisibility(0);
        this.ilc.setVisibility(0);
    }

    public void cqb() {
        this.ile.setAlpha(1.0f);
        this.ile.setVisibility(0);
        this.ilc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pl(boolean z) {
        if (z) {
            this.ilc.setVisibility(8);
            return;
        }
        cE(this.ile);
        this.ile.setVisibility(8);
        this.ilc.setVisibility(0);
    }

    public void IC(String str) {
        this.ilk.setAlpha(1.0f);
        this.ilk.setText("加成x" + str);
        this.ilk.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cqc() {
        cE(this.ilk);
        this.ilk.setVisibility(8);
    }

    public void cqd() {
        this.ill.setAlpha(1.0f);
        this.ill.setVisibility(0);
        this.ilj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pm(boolean z) {
        if (z) {
            this.ilj.setVisibility(8);
            return;
        }
        cE(this.ill);
        this.ill.setVisibility(8);
        this.ilj.setVisibility(0);
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
        if (j - this.ilp >= 100) {
            ObjectAnimator.ofFloat(this.ilc, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.ilc, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        if (j2 - this.ilq >= 100) {
            ObjectAnimator.ofFloat(this.ilj, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.ilj, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        this.ilp = j;
        this.ilq = j2;
    }

    public void resetView() {
        this.ilp = 0L;
        this.ilq = 0L;
        this.ilR.handler.removeCallbacksAndMessages(null);
        this.ill.setVisibility(8);
        this.ile.setVisibility(8);
        this.ild.setVisibility(8);
        this.ilk.setVisibility(8);
        cpO();
        this.ilg.setVisibility(0);
        this.ili.setVisibility(0);
        this.ilj.setVisibility(0);
        this.ilj.setText("0");
        this.ikZ.setVisibility(0);
        this.ilb.setVisibility(0);
        this.ilc.setVisibility(0);
        this.ilc.setText("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqe() {
        if (this.ilG != null && this.ilG.status > this.ilF.taskInfoData.status) {
            a(this.ilG, this.ilF.pkStatusInfoData.nowTime, this.ilF.pkStatusInfoData.stageEndTime);
        } else {
            a(this.ilF.taskInfoData, this.ilF.pkStatusInfoData.nowTime, this.ilF.pkStatusInfoData.stageEndTime);
        }
        if (this.ilH != null && this.ilH.status > this.ilF.killInfoData.status) {
            a(this.ilH, this.ilF.pkStatusInfoData.nowTime, this.ilF.pkStatusInfoData.stageEndTime);
        } else {
            a(this.ilF.killInfoData, this.ilF.pkStatusInfoData.nowTime, this.ilF.pkStatusInfoData.stageEndTime);
        }
    }

    private void a(PkTaskInfoData pkTaskInfoData, long j, long j2) {
        if (pkTaskInfoData != null) {
            if (this.ilI != 2 || pkTaskInfoData.status != 1) {
                if (this.ilI != 3 || pkTaskInfoData.status != 1) {
                    if (this.ilI != 1 || pkTaskInfoData.status != 0) {
                        if (this.ilI != 0 || pkTaskInfoData.status != 3) {
                            if (this.ilI != 0 || pkTaskInfoData.status != 2) {
                                this.ilI = pkTaskInfoData.status;
                                switch (pkTaskInfoData.status) {
                                    case 0:
                                        this.ilC = false;
                                        long j3 = pkTaskInfoData.startTime;
                                        if (pkTaskInfoData.preStartTime > 0 && j >= pkTaskInfoData.preStartTime) {
                                            cqf();
                                            long j4 = this.ilr - (j2 - j3);
                                            if (j4 <= 0) {
                                                j4 = 0;
                                            }
                                            this.ilu.setText(j4 + "秒" + pkTaskInfoData.title);
                                            this.ilv.setText(pkTaskInfoData.tip);
                                            this.ilu.setTextColor(Color.parseColor("#FFFFFFFF"));
                                            this.ilv.setTextColor(Color.parseColor("#FFFFF465"));
                                            this.ilt.setVisibility(0);
                                            cG(this.ilt);
                                            if (!this.gRJ.isHost && j4 == 0) {
                                                this.gRJ.getGetPkInfoModel().a(this.gRJ.aJZ.aId.userId, this.ilF.pkStatusInfoData.pkID, this.gRJ.aJZ.mLiveInfo.room_id, this.gRJ.aJZ.mLiveInfo.live_id, this.gRJ.isHost ? 1 : 0);
                                            }
                                            eG("pk_competition_task", "show_countdown");
                                        }
                                        if (pkTaskInfoData.preStartTime > 0 && j < pkTaskInfoData.preStartTime) {
                                            cqf();
                                            this.ilm.setVisibility(0);
                                            cpQ();
                                            return;
                                        }
                                        return;
                                    case 1:
                                        cqf();
                                        this.ilC = false;
                                        this.ilK = this.ilK > ((long) pkTaskInfoData.countDown) ? this.ilK : pkTaskInfoData.countDown;
                                        long max = Math.max(pkTaskInfoData.startTime + this.ilK, pkTaskInfoData.endTime);
                                        this.ilw.setVisibility(0);
                                        cG(this.ilw);
                                        long j5 = this.ilr - (j2 - max);
                                        if (pkTaskInfoData.countDown < j5) {
                                            j5 = pkTaskInfoData.countDown;
                                        }
                                        if (j5 <= 0) {
                                            j5 = 0;
                                        }
                                        this.ilx.setText(j5 + "秒" + pkTaskInfoData.title);
                                        this.ily.setText(pkTaskInfoData.tip);
                                        this.ilz.setProgress((int) ((pkTaskInfoData.nowNum / Double.parseDouble(pkTaskInfoData.targetNum)) * 100.0d));
                                        if (!this.gRJ.isHost && j5 == 0) {
                                            this.gRJ.getGetPkInfoModel().a(this.gRJ.aJZ.aId.userId, this.ilF.pkStatusInfoData.pkID, this.gRJ.aJZ.mLiveInfo.room_id, this.gRJ.aJZ.mLiveInfo.live_id, this.gRJ.isHost ? 1 : 0);
                                        }
                                        eG("pk_competition_task", "task_start");
                                        return;
                                    case 2:
                                        if (cqg() && !this.ilC) {
                                            cqf();
                                            this.ilC = true;
                                            this.ilA.setVisibility(0);
                                            this.ilB.setText(pkTaskInfoData.title);
                                            this.ilB.setTextColor(Color.parseColor("#FFFFFFFF"));
                                            cG(this.ilA);
                                            this.ilA.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.7
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    PkRankInView.this.cqf();
                                                    PkRankInView.this.ilG = null;
                                                    PkRankInView.this.ilm.setVisibility(0);
                                                }
                                            }, IMConnection.RETRY_DELAY_TIMES);
                                            this.ilK = 0L;
                                            eG("pk_competition_task", "task_failed");
                                            return;
                                        }
                                        return;
                                    case 3:
                                        if (cqg() && !this.ilC) {
                                            cqf();
                                            this.ilC = true;
                                            this.ilA.setVisibility(0);
                                            this.ilB.setText(pkTaskInfoData.title + "\n" + pkTaskInfoData.tip);
                                            this.ilB.setTextColor(Color.parseColor("#FF89460D"));
                                            this.ils.setVisibility(0);
                                            cF(this.ilA);
                                            this.ilA.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.8
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    PkRankInView.this.cqf();
                                                    PkRankInView.this.ilG = null;
                                                    PkRankInView.this.ilm.setVisibility(0);
                                                }
                                            }, IMConnection.RETRY_DELAY_TIMES);
                                            this.ilK = 0L;
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
            if (this.ilJ != 3 || pkKillInfoData.status == 3) {
                if (this.ilJ != 4 || pkKillInfoData.status == 4) {
                    if (this.ilJ != -3 || pkKillInfoData.status == -3) {
                        if (this.ilJ != -2 || pkKillInfoData.status == -2) {
                            if (this.ilJ != 2 || pkKillInfoData.status != -1) {
                                this.ilJ = pkKillInfoData.status;
                                switch (pkKillInfoData.status) {
                                    case -3:
                                    case -2:
                                        if (cqg() && !this.ilD) {
                                            cqf();
                                            this.ilt.setVisibility(0);
                                            this.ilu.setText(pkKillInfoData.title);
                                            this.ilv.setText(pkKillInfoData.tip);
                                            this.ilu.setTextColor(Color.parseColor("#FFFFFFFF"));
                                            this.ilv.setTextColor(Color.parseColor("#FFFFF465"));
                                            cG(this.ilt);
                                            this.ilD = true;
                                            this.ilu.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.9
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    PkRankInView.this.cqf();
                                                    PkRankInView.this.ilm.setVisibility(0);
                                                }
                                            }, IMConnection.RETRY_DELAY_TIMES);
                                            this.ilM = 0L;
                                            this.ilL = 0L;
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
                                        cqf();
                                        this.ilt.setVisibility(0);
                                        this.ilu.setText(pkKillInfoData.title);
                                        this.ilv.setText(pkKillInfoData.tip);
                                        this.ilu.setTextColor(Color.parseColor("#FFFFFFFF"));
                                        this.ilv.setTextColor(Color.parseColor("#FFFFF465"));
                                        cG(this.ilt);
                                        eG("pk_competition_kill_mode", "in_activating");
                                        return;
                                    case 0:
                                    default:
                                        return;
                                    case 1:
                                        this.ilD = false;
                                        if (this.ilL < pkKillInfoData.countDown) {
                                            this.ilL = pkKillInfoData.countDown;
                                        }
                                        long j3 = pkKillInfoData.startTime + this.ilL;
                                        if (pkKillInfoData.startTime > 0 && j >= pkKillInfoData.startTime) {
                                            cqf();
                                            long j4 = this.ilr - (j2 - j3);
                                            if (pkKillInfoData.countDown < j4) {
                                                j4 = pkKillInfoData.countDown;
                                            }
                                            if (j4 <= 0) {
                                                j4 = 0;
                                            }
                                            this.ilu.setText(j4 + "秒" + pkKillInfoData.title);
                                            this.ilv.setText(pkKillInfoData.tip);
                                            this.ilu.setTextColor(Color.parseColor("#FFFFFFFF"));
                                            this.ilv.setTextColor(Color.parseColor("#FFFFF465"));
                                            this.ilt.setVisibility(0);
                                            cG(this.ilt);
                                            if (!this.gRJ.isHost && j4 == 0) {
                                                this.gRJ.getGetPkInfoModel().a(this.gRJ.aJZ.aId.userId, this.ilF.pkStatusInfoData.pkID, this.gRJ.aJZ.mLiveInfo.room_id, this.gRJ.aJZ.mLiveInfo.live_id, this.gRJ.isHost ? 1 : 0);
                                            }
                                            eG("pk_competition_kill_mode", "show_countdown");
                                            return;
                                        }
                                        return;
                                    case 2:
                                        cqf();
                                        this.ilD = false;
                                        if (this.ilM < pkKillInfoData.countDown) {
                                            this.ilM = pkKillInfoData.countDown;
                                        }
                                        long max = Math.max(pkKillInfoData.endTime, pkKillInfoData.startTime + this.ilM);
                                        this.ilt.setVisibility(0);
                                        cF(this.ilt);
                                        long j5 = this.ilr - (j2 - max);
                                        if (j5 <= 0) {
                                            j5 = 0;
                                        }
                                        this.ilu.setText(j5 + "秒" + pkKillInfoData.title);
                                        this.ilv.setText(pkKillInfoData.tip);
                                        this.ilu.setTextColor(Color.parseColor("#FF89460D"));
                                        this.ilv.setTextColor(Color.parseColor("#FF89460D"));
                                        eG("pk_competition_kill_mode", "activate_success");
                                        return;
                                    case 3:
                                    case 4:
                                        if (cqg() && !this.ilD) {
                                            cqf();
                                            this.ilm.setVisibility(0);
                                            this.gRJ.fW(-1L);
                                            this.ilD = true;
                                            this.ilH = null;
                                            this.ilM = 0L;
                                            this.ilL = 0L;
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
        this.ilm.setVisibility(8);
        if (this.ilS != null && this.ilS.coS()) {
            this.ils.setVisibility(0);
            view.setBackgroundResource(a.c.sdk_transparent);
            return;
        }
        view.setBackgroundResource(a.e.ala_pk_rank_task_bg_light);
    }

    private void cG(View view) {
        this.ilE = false;
        if (this.ilS != null) {
            this.ilS.reset();
            view.setVisibility(0);
            view.setBackgroundResource(a.e.ala_pk_rank_task_bg_black);
            this.ilm.setVisibility(8);
        }
    }

    public void cqf() {
        this.ilt.setVisibility(8);
        this.ilw.setVisibility(8);
        this.ilA.setVisibility(8);
        this.ils.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqg() {
        return this.ilA.getVisibility() == 0 || this.ilt.getVisibility() == 0 || this.ilw.getVisibility() == 0;
    }

    public void eG(String str, String str2) {
        if (this.gRJ.isHost) {
            if (this.ilT.containsKey(str + str2)) {
                if (this.ilF.pkStatusInfoData.pkID != Integer.parseInt(this.ilT.get(str + str2))) {
                    eH(str, str2);
                    this.ilT.put(str + str2, this.ilF.pkStatusInfoData.pkID + "");
                    return;
                }
                return;
            }
            eH(str, str2);
            this.ilT.put(str + str2, this.ilF.pkStatusInfoData.pkID + "");
        }
    }

    private void eH(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pkId", Long.valueOf(this.ilF.pkStatusInfoData.pkID));
            jSONObject.putOpt("lodId", Long.valueOf(this.ilF.logId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, str, "author_liveroom", str2).setContentExt(jSONObject));
    }
}
