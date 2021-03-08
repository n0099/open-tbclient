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
/* loaded from: classes10.dex */
public class PkRankInView extends RelativeLayout {
    Context context;
    PkRankView gTG;
    com.baidu.tieba.ala.f imL;
    public RelativeLayout imT;
    ImageView imU;
    ImageView imV;
    RelativeLayout imW;
    HeadImageView imX;
    TextView imY;
    TextView imZ;
    TextView inA;
    boolean inB;
    boolean inC;
    boolean inD;
    PkInfoData inE;
    PkTaskInfoData inF;
    PkKillInfoData inG;
    int inH;
    int inI;
    long inJ;
    long inK;
    long inL;
    Queue<com.baidu.tieba.ala.view.anim.a> inM;
    Queue<com.baidu.tieba.ala.view.anim.a> inN;
    public AnimatorListenerAdapter inO;
    public AnimatorListenerAdapter inP;
    k inQ;
    m inR;
    private HashMap<String, String> inS;
    FixedTextView ina;
    TextView inb;
    ImageView inc;
    RelativeLayout ind;
    HeadImageView ine;
    TextView inf;
    TextView ing;
    FixedTextView inh;
    TextView ini;
    ImageView inj;
    ImageView ink;
    TextView inl;
    TextView inm;
    long inn;
    long ino;
    long inp;
    RelativeLayout inq;
    RelativeLayout inr;

    /* renamed from: int  reason: not valid java name */
    TextView f4int;
    TextView inu;
    RelativeLayout inv;
    TextView inw;
    TextView inx;
    SeekBar iny;
    RelativeLayout inz;
    private View mView;
    int status;

    public PkRankInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inB = false;
        this.inC = false;
        this.inD = false;
        this.inM = new LinkedBlockingQueue();
        this.inN = new LinkedBlockingQueue();
        this.inS = new HashMap<>(32);
        this.context = context;
        initView();
    }

    private void initView() {
        this.inR = new m();
        this.inR.PX();
        cqd();
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_in_layout, (ViewGroup) this, true);
        this.imW = (RelativeLayout) this.mView.findViewById(a.f.in_top_layout);
        this.imT = (RelativeLayout) this.mView.findViewById(a.f.background_view);
        this.imU = (ImageView) this.mView.findViewById(a.f.top_bg);
        this.imV = (ImageView) this.mView.findViewById(a.f.bottom_bg);
        this.ink = (ImageView) this.mView.findViewById(a.f.pk_img);
        this.imX = (HeadImageView) this.mView.findViewById(a.f.top_head);
        this.imY = (TextView) this.mView.findViewById(a.f.top_wins);
        this.imZ = (TextView) this.mView.findViewById(a.f.top_name);
        this.ina = (FixedTextView) this.mView.findViewById(a.f.top_scores);
        this.inb = (TextView) this.mView.findViewById(a.f.top_plus);
        this.inc = (ImageView) this.mView.findViewById(a.f.top_scores_shade);
        this.imX.setDefaultBgResource(a.e.sdk_default_avatar);
        this.imX.setIsRound(true);
        this.imX.setAutoChangeStyle(false);
        this.imX.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.imX.setBorderColor(872415231);
        this.imW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gTG.A(PkRankInView.this.gTG.iph.H5URL, PkRankInView.this.gTG.iph.myPkData.userID);
            }
        });
        this.ind = (RelativeLayout) this.mView.findViewById(a.f.in_bottom_layout);
        this.ine = (HeadImageView) this.mView.findViewById(a.f.bottom_head);
        this.inf = (TextView) this.mView.findViewById(a.f.bottom_wins);
        this.ing = (TextView) this.mView.findViewById(a.f.bottom_name);
        this.inh = (FixedTextView) this.mView.findViewById(a.f.bottom_scores);
        this.ini = (TextView) this.mView.findViewById(a.f.bottom_plus);
        this.inj = (ImageView) this.mView.findViewById(a.f.bottom_scores_shade);
        this.ine.setDefaultBgResource(a.e.sdk_default_avatar);
        this.ine.setIsRound(true);
        this.ine.setAutoChangeStyle(false);
        this.ine.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.ine.setBorderColor(872415231);
        this.ind.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankInView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankInView.this.gTG.A(PkRankInView.this.gTG.iph.H5URL, PkRankInView.this.gTG.iph.otherPkData.userID);
            }
        });
        this.inl = (TextView) this.mView.findViewById(a.f.end_view);
        this.inm = (TextView) this.mView.findViewById(a.f.timer);
        cqe();
        this.inq = (RelativeLayout) this.mView.findViewById(a.f.task_tip_anim_view);
        this.inr = (RelativeLayout) this.mView.findViewById(a.f.task_tip_view);
        this.f4int = (TextView) this.mView.findViewById(a.f.task_tip_view_title);
        this.inu = (TextView) this.mView.findViewById(a.f.task_tip_view_title_tip);
        this.inv = (RelativeLayout) this.mView.findViewById(a.f.in_task_view);
        this.inw = (TextView) this.mView.findViewById(a.f.in_task_view_title);
        this.inx = (TextView) this.mView.findViewById(a.f.in_task_view_title_tip);
        this.iny = (SeekBar) this.mView.findViewById(a.f.in_task_view_bar);
        this.inz = (RelativeLayout) this.mView.findViewById(a.f.task_result_view);
        this.inA = (TextView) this.mView.findViewById(a.f.task_result_view_result);
        cqs();
        this.inR.setParentView(this.inq);
    }

    public void cqd() {
        this.inG = null;
        this.inF = null;
        this.inJ = 0L;
        this.inK = 0L;
        this.inL = 0L;
        this.inC = false;
        this.inB = false;
        this.inI = -10;
        this.inH = 0;
        this.inD = false;
    }

    private void cqe() {
        this.inO = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (PkRankInView.this.cqt()) {
                    PkRankInView.this.inq.bringToFront();
                    PkRankInView.this.inz.bringToFront();
                    PkRankInView.this.inr.bringToFront();
                    PkRankInView.this.inv.bringToFront();
                    return;
                }
                PkRankInView.this.ink.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.inM.poll();
                if (PkRankInView.this.inM.peek() != null) {
                    PkRankInView.this.inM.peek().startAnim();
                }
                PkRankInView.this.inz.bringToFront();
                PkRankInView.this.inr.bringToFront();
                PkRankInView.this.inv.bringToFront();
            }
        };
        this.inP = new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.PkRankInView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (PkRankInView.this.cqt()) {
                    PkRankInView.this.inq.bringToFront();
                    PkRankInView.this.inz.bringToFront();
                    PkRankInView.this.inr.bringToFront();
                    PkRankInView.this.inv.bringToFront();
                    return;
                }
                PkRankInView.this.ink.bringToFront();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PkRankInView.this.inN.poll();
                if (PkRankInView.this.inN.peek() != null) {
                    PkRankInView.this.inN.peek().startAnim();
                }
                PkRankInView.this.inz.bringToFront();
                PkRankInView.this.inr.bringToFront();
                PkRankInView.this.inv.bringToFront();
            }
        };
    }

    public void a(PkInfoData pkInfoData, int i) {
        this.gTG.cqG();
        this.inl.setVisibility(8);
        if (pkInfoData.pkStatusInfoData.pkStatus == 1) {
            e(pkInfoData);
        }
        this.status = i;
        if (this.gTG.wK(i)) {
            this.inE = pkInfoData;
            switch (i) {
                case 10:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913231, pkInfoData));
                    d(pkInfoData);
                    return;
                case 30:
                    bVf();
                    return;
                default:
                    return;
            }
        }
    }

    private void d(PkInfoData pkInfoData) {
        this.ine.startLoad(pkInfoData.otherPkData.bdPortrait, 12, false, false);
        if (pkInfoData.otherPkData.winningStreak > 1) {
            this.inf.setVisibility(0);
            this.inf.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.otherPkData.winningStreak)));
        } else {
            this.inf.setVisibility(8);
        }
        this.ing.setText(pkInfoData.otherPkData.userNickName);
        this.imX.startLoad(pkInfoData.myPkData.bdPortrait, 12, false, false);
        if (pkInfoData.myPkData.winningStreak > 1) {
            this.imY.setVisibility(0);
            this.imY.setText(this.context.getString(a.h.sdk_pk_rank_wins, String.valueOf(pkInfoData.myPkData.winningStreak)));
        } else {
            this.imY.setVisibility(8);
        }
        this.imZ.setText(pkInfoData.myPkData.userNickName);
        if (pkInfoData.pkStatusInfoData.anchorScore >= this.inn && pkInfoData.pkStatusInfoData.rivalScore >= this.ino) {
            this.ina.setText(fV(pkInfoData.pkStatusInfoData.anchorScore) + "");
            this.inh.setText(fV(pkInfoData.pkStatusInfoData.rivalScore) + "");
            E(pkInfoData.pkStatusInfoData.anchorScore, pkInfoData.pkStatusInfoData.rivalScore);
        }
    }

    private void e(PkInfoData pkInfoData) {
        long j = pkInfoData.pkStatusInfoData.stageEndTime - pkInfoData.pkStatusInfoData.nowTime;
        if (j <= 0) {
            this.inm.setVisibility(8);
        } else if (this.imL == null || !this.imL.isRunning()) {
            this.inm.setVisibility(0);
            this.imL = new com.baidu.tieba.ala.f(j * 1000, 1000L);
            this.imL.a(new f.a() { // from class: com.baidu.tieba.ala.view.PkRankInView.5
                @Override // com.baidu.tieba.ala.f.a
                public void onTick(long j2) {
                    PkRankInView.this.inp = Math.round(j2 / 1000.0d);
                    PkRankInView.this.inm.setText(StringHelper.formatSecondsTime(PkRankInView.this.inp));
                    PkRankInView.this.cqr();
                }

                @Override // com.baidu.tieba.ala.f.a
                public void onFinish() {
                    PkRankInView.this.imL.cancelTimer();
                    if (!PkRankInView.this.gTG.isHost) {
                        PkRankInView.this.bVf();
                    }
                    PkRankInView.this.cqf();
                }
            });
            this.imL.startTimer();
        } else if (this.inp - j >= 1) {
            this.imL.cancelTimer();
            this.imL = null;
            e(pkInfoData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqf() {
        this.gTG.getGetPkInfoModel().a(this.gTG.aLz.aJD.userId, this.gTG.iph.pkStatusInfoData.pkID, this.gTG.aLz.mLiveInfo.room_id, this.gTG.aLz.mLiveInfo.live_id, this.gTG.isHost ? 1 : 0);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.6
            @Override // java.lang.Runnable
            public void run() {
                PkRankInView.this.gTG.getGetPkInfoModel().a(PkRankInView.this.gTG.aLz.aJD.userId, PkRankInView.this.gTG.iph.pkStatusInfoData.pkID, PkRankInView.this.gTG.aLz.mLiveInfo.room_id, PkRankInView.this.gTG.aLz.mLiveInfo.live_id, PkRankInView.this.gTG.isHost ? 1 : 0);
            }
        }, this.gTG.iph.resultInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVf() {
        this.inl.bringToFront();
        this.inl.setVisibility(0);
        this.inm.setVisibility(8);
    }

    private void cqg() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.inO);
        pkRankPropAnim.setParentView(this.imT);
        a(pkRankPropAnim);
    }

    private void cqh() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 1);
        pkRankPropAnim.setAnimatorListenerAdapter(this.inP);
        pkRankPropAnim.setParentView(this.imT);
        b(pkRankPropAnim);
    }

    private void cqi() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, true, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.inO);
        pkRankPropAnim.setParentView(this.imT);
        a(pkRankPropAnim);
    }

    private void cqj() {
        PkRankPropAnim pkRankPropAnim = new PkRankPropAnim(this.context, false, 2);
        pkRankPropAnim.setAnimatorListenerAdapter(this.inP);
        pkRankPropAnim.setParentView(this.imT);
        b(pkRankPropAnim);
    }

    private void cqk() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, true);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.inO);
        alaFirstBloodAnim.setParentView(this.imT);
        a(alaFirstBloodAnim);
    }

    private void cql() {
        AlaFirstBloodAnim alaFirstBloodAnim = new AlaFirstBloodAnim(this.context, false);
        alaFirstBloodAnim.setAnimatorListenerAdapter(this.inP);
        alaFirstBloodAnim.setParentView(this.imT);
        b(alaFirstBloodAnim);
    }

    private void cE(View view) {
        ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(300L).start();
    }

    private void a(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.inM.peek() == null) {
            this.inM.add(aVar);
            this.inM.peek().startAnim();
            return;
        }
        this.inM.add(aVar);
    }

    private void b(com.baidu.tieba.ala.view.anim.a aVar) {
        if (this.inN.peek() == null) {
            this.inN.add(aVar);
            this.inN.peek().startAnim();
            return;
        }
        this.inN.add(aVar);
    }

    public void e(JSONObject jSONObject, int i) {
        boolean z;
        if (this.gTG.wK(i)) {
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
                    cqk();
                    z = false;
                    break;
                case 12:
                    cqi();
                    if (this.gTG.aLz.isHost || jSONObject.optLong("user_id") == this.gTG.aLz.aJZ.userId) {
                        cqn();
                        z = true;
                        break;
                    } else {
                        cqo();
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
                    cqg();
                    IL(jSONObject.optString("buff_multiple", "1"));
                    z = true;
                    break;
                case 16:
                    long optLong = jSONObject.optLong("honor");
                    long optLong2 = jSONObject.optLong("rival_honor");
                    if (optLong >= this.inn && optLong2 >= this.ino) {
                        this.inh.setText(fV(optLong2) + "");
                        this.ina.setText(fV(optLong) + "");
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
                    this.inF = pkTaskInfoData;
                    a(pkTaskInfoData, this.inE.pkStatusInfoData.nowTime, this.inE.pkStatusInfoData.stageEndTime);
                    z = true;
                    break;
                case 18:
                    PkKillInfoData pkKillInfoData = new PkKillInfoData();
                    pkKillInfoData.parserJson(jSONObject);
                    this.inG = pkKillInfoData;
                    a(pkKillInfoData, this.inE.pkStatusInfoData.nowTime, this.inE.pkStatusInfoData.stageEndTime);
                    z = true;
                    break;
                case 21:
                    cql();
                    z = false;
                    break;
                case 22:
                    cqj();
                    cqq();
                    z = true;
                    break;
                case 24:
                    cqh();
                    IM(jSONObject.optString("buff_multiple", "1"));
                    z = true;
                    break;
                case 30:
                    bVf();
                    z = true;
                    break;
            }
            if (z) {
                this.gTG.getGetPkInfoModel().a(this.gTG.aLz.aJD.userId, jSONObject.optLong("pk_id"), this.gTG.aLz.mLiveInfo.room_id, this.gTG.aLz.mLiveInfo.live_id, this.gTG.isHost ? 1 : 0);
            }
        }
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gTG = pkRankView;
    }

    public void onDestroy() {
        if (this.gTG.getGetPkInfoModel() != null) {
            this.gTG.getGetPkInfoModel().cms();
        }
        cqb();
        if (this.inQ != null) {
            this.inQ.onDestroy();
        }
        if (this.inR != null) {
            this.inR.release();
            this.inR = null;
        }
        cqd();
    }

    public void cqb() {
        if (this.imL != null) {
            this.imL.cancelTimer();
            this.imL = null;
        }
    }

    public k getPkRankPropController() {
        if (this.inQ == null) {
            this.inQ = new k(this);
        }
        return this.inQ;
    }

    public void IL(String str) {
        this.inb.setAlpha(1.0f);
        this.inb.setText("加成x" + str);
        this.inb.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cqm() {
        cE(this.inb);
        this.inb.setVisibility(8);
    }

    public void cqn() {
        this.inc.setAlpha(0.8f);
        this.inc.setVisibility(0);
        this.ina.setVisibility(0);
    }

    public void cqo() {
        this.inc.setAlpha(1.0f);
        this.inc.setVisibility(0);
        this.ina.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pl(boolean z) {
        if (z) {
            this.ina.setVisibility(8);
            return;
        }
        cE(this.inc);
        this.inc.setVisibility(8);
        this.ina.setVisibility(0);
    }

    public void IM(String str) {
        this.ini.setAlpha(1.0f);
        this.ini.setText("加成x" + str);
        this.ini.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cqp() {
        cE(this.ini);
        this.ini.setVisibility(8);
    }

    public void cqq() {
        this.inj.setAlpha(1.0f);
        this.inj.setVisibility(0);
        this.inh.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pm(boolean z) {
        if (z) {
            this.inh.setVisibility(8);
            return;
        }
        cE(this.inj);
        this.inj.setVisibility(8);
        this.inh.setVisibility(0);
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
        if (j - this.inn >= 100) {
            ObjectAnimator.ofFloat(this.ina, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.ina, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        if (j2 - this.ino >= 100) {
            ObjectAnimator.ofFloat(this.inh, "scaleX", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
            ObjectAnimator.ofFloat(this.inh, "scaleY", 1.0f, 1.5f, 1.0f).setDuration(400L).start();
        }
        this.inn = j;
        this.ino = j2;
    }

    public void resetView() {
        this.inn = 0L;
        this.ino = 0L;
        this.inQ.handler.removeCallbacksAndMessages(null);
        this.inj.setVisibility(8);
        this.inc.setVisibility(8);
        this.inb.setVisibility(8);
        this.ini.setVisibility(8);
        cqb();
        this.ine.setVisibility(0);
        this.ing.setVisibility(0);
        this.inh.setVisibility(0);
        this.inh.setText("0");
        this.imX.setVisibility(0);
        this.imZ.setVisibility(0);
        this.ina.setVisibility(0);
        this.ina.setText("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqr() {
        if (this.inF != null && this.inF.status > this.inE.taskInfoData.status) {
            a(this.inF, this.inE.pkStatusInfoData.nowTime, this.inE.pkStatusInfoData.stageEndTime);
        } else {
            a(this.inE.taskInfoData, this.inE.pkStatusInfoData.nowTime, this.inE.pkStatusInfoData.stageEndTime);
        }
        if (this.inG != null && this.inG.status > this.inE.killInfoData.status) {
            a(this.inG, this.inE.pkStatusInfoData.nowTime, this.inE.pkStatusInfoData.stageEndTime);
        } else {
            a(this.inE.killInfoData, this.inE.pkStatusInfoData.nowTime, this.inE.pkStatusInfoData.stageEndTime);
        }
    }

    private void a(PkTaskInfoData pkTaskInfoData, long j, long j2) {
        if (pkTaskInfoData != null) {
            if (this.inH != 2 || pkTaskInfoData.status != 1) {
                if (this.inH != 3 || pkTaskInfoData.status != 1) {
                    if (this.inH != 1 || pkTaskInfoData.status != 0) {
                        if (this.inH != 0 || pkTaskInfoData.status != 3) {
                            if (this.inH != 0 || pkTaskInfoData.status != 2) {
                                this.inH = pkTaskInfoData.status;
                                switch (pkTaskInfoData.status) {
                                    case 0:
                                        this.inB = false;
                                        long j3 = pkTaskInfoData.startTime;
                                        if (pkTaskInfoData.preStartTime > 0 && j >= pkTaskInfoData.preStartTime) {
                                            cqs();
                                            long j4 = this.inp - (j2 - j3);
                                            if (j4 <= 0) {
                                                j4 = 0;
                                            }
                                            this.f4int.setText(j4 + "秒" + pkTaskInfoData.title);
                                            this.inu.setText(pkTaskInfoData.tip);
                                            this.f4int.setTextColor(Color.parseColor("#FFFFFFFF"));
                                            this.inu.setTextColor(Color.parseColor("#FFFFF465"));
                                            this.inr.setVisibility(0);
                                            cG(this.inr);
                                            if (!this.gTG.isHost && j4 == 0) {
                                                this.gTG.getGetPkInfoModel().a(this.gTG.aLz.aJD.userId, this.inE.pkStatusInfoData.pkID, this.gTG.aLz.mLiveInfo.room_id, this.gTG.aLz.mLiveInfo.live_id, this.gTG.isHost ? 1 : 0);
                                            }
                                            eG("pk_competition_task", "show_countdown");
                                        }
                                        if (pkTaskInfoData.preStartTime > 0 && j < pkTaskInfoData.preStartTime) {
                                            cqs();
                                            this.ink.setVisibility(0);
                                            cqd();
                                            return;
                                        }
                                        return;
                                    case 1:
                                        cqs();
                                        this.inB = false;
                                        this.inJ = this.inJ > ((long) pkTaskInfoData.countDown) ? this.inJ : pkTaskInfoData.countDown;
                                        long max = Math.max(pkTaskInfoData.startTime + this.inJ, pkTaskInfoData.endTime);
                                        this.inv.setVisibility(0);
                                        cG(this.inv);
                                        long j5 = this.inp - (j2 - max);
                                        if (pkTaskInfoData.countDown < j5) {
                                            j5 = pkTaskInfoData.countDown;
                                        }
                                        if (j5 <= 0) {
                                            j5 = 0;
                                        }
                                        this.inw.setText(j5 + "秒" + pkTaskInfoData.title);
                                        this.inx.setText(pkTaskInfoData.tip);
                                        this.iny.setProgress((int) ((pkTaskInfoData.nowNum / Double.parseDouble(pkTaskInfoData.targetNum)) * 100.0d));
                                        if (!this.gTG.isHost && j5 == 0) {
                                            this.gTG.getGetPkInfoModel().a(this.gTG.aLz.aJD.userId, this.inE.pkStatusInfoData.pkID, this.gTG.aLz.mLiveInfo.room_id, this.gTG.aLz.mLiveInfo.live_id, this.gTG.isHost ? 1 : 0);
                                        }
                                        eG("pk_competition_task", "task_start");
                                        return;
                                    case 2:
                                        if (cqt() && !this.inB) {
                                            cqs();
                                            this.inB = true;
                                            this.inz.setVisibility(0);
                                            this.inA.setText(pkTaskInfoData.title);
                                            this.inA.setTextColor(Color.parseColor("#FFFFFFFF"));
                                            cG(this.inz);
                                            this.inz.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.7
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    PkRankInView.this.cqs();
                                                    PkRankInView.this.inF = null;
                                                    PkRankInView.this.ink.setVisibility(0);
                                                }
                                            }, IMConnection.RETRY_DELAY_TIMES);
                                            this.inJ = 0L;
                                            eG("pk_competition_task", "task_failed");
                                            return;
                                        }
                                        return;
                                    case 3:
                                        if (cqt() && !this.inB) {
                                            cqs();
                                            this.inB = true;
                                            this.inz.setVisibility(0);
                                            this.inA.setText(pkTaskInfoData.title + "\n" + pkTaskInfoData.tip);
                                            this.inA.setTextColor(Color.parseColor("#FF89460D"));
                                            this.inq.setVisibility(0);
                                            cF(this.inz);
                                            this.inz.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.8
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    PkRankInView.this.cqs();
                                                    PkRankInView.this.inF = null;
                                                    PkRankInView.this.ink.setVisibility(0);
                                                }
                                            }, IMConnection.RETRY_DELAY_TIMES);
                                            this.inJ = 0L;
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
            if (this.inI != 3 || pkKillInfoData.status == 3) {
                if (this.inI != 4 || pkKillInfoData.status == 4) {
                    if (this.inI != -3 || pkKillInfoData.status == -3) {
                        if (this.inI != -2 || pkKillInfoData.status == -2) {
                            if (this.inI != 2 || pkKillInfoData.status != -1) {
                                this.inI = pkKillInfoData.status;
                                switch (pkKillInfoData.status) {
                                    case -3:
                                    case -2:
                                        if (cqt() && !this.inC) {
                                            cqs();
                                            this.inr.setVisibility(0);
                                            this.f4int.setText(pkKillInfoData.title);
                                            this.inu.setText(pkKillInfoData.tip);
                                            this.f4int.setTextColor(Color.parseColor("#FFFFFFFF"));
                                            this.inu.setTextColor(Color.parseColor("#FFFFF465"));
                                            cG(this.inr);
                                            this.inC = true;
                                            this.f4int.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankInView.9
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    PkRankInView.this.cqs();
                                                    PkRankInView.this.ink.setVisibility(0);
                                                }
                                            }, IMConnection.RETRY_DELAY_TIMES);
                                            this.inL = 0L;
                                            this.inK = 0L;
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
                                        cqs();
                                        this.inr.setVisibility(0);
                                        this.f4int.setText(pkKillInfoData.title);
                                        this.inu.setText(pkKillInfoData.tip);
                                        this.f4int.setTextColor(Color.parseColor("#FFFFFFFF"));
                                        this.inu.setTextColor(Color.parseColor("#FFFFF465"));
                                        cG(this.inr);
                                        eG("pk_competition_kill_mode", "in_activating");
                                        return;
                                    case 0:
                                    default:
                                        return;
                                    case 1:
                                        this.inC = false;
                                        if (this.inK < pkKillInfoData.countDown) {
                                            this.inK = pkKillInfoData.countDown;
                                        }
                                        long j3 = pkKillInfoData.startTime + this.inK;
                                        if (pkKillInfoData.startTime > 0 && j >= pkKillInfoData.startTime) {
                                            cqs();
                                            long j4 = this.inp - (j2 - j3);
                                            if (pkKillInfoData.countDown < j4) {
                                                j4 = pkKillInfoData.countDown;
                                            }
                                            if (j4 <= 0) {
                                                j4 = 0;
                                            }
                                            this.f4int.setText(j4 + "秒" + pkKillInfoData.title);
                                            this.inu.setText(pkKillInfoData.tip);
                                            this.f4int.setTextColor(Color.parseColor("#FFFFFFFF"));
                                            this.inu.setTextColor(Color.parseColor("#FFFFF465"));
                                            this.inr.setVisibility(0);
                                            cG(this.inr);
                                            if (!this.gTG.isHost && j4 == 0) {
                                                this.gTG.getGetPkInfoModel().a(this.gTG.aLz.aJD.userId, this.inE.pkStatusInfoData.pkID, this.gTG.aLz.mLiveInfo.room_id, this.gTG.aLz.mLiveInfo.live_id, this.gTG.isHost ? 1 : 0);
                                            }
                                            eG("pk_competition_kill_mode", "show_countdown");
                                            return;
                                        }
                                        return;
                                    case 2:
                                        cqs();
                                        this.inC = false;
                                        if (this.inL < pkKillInfoData.countDown) {
                                            this.inL = pkKillInfoData.countDown;
                                        }
                                        long max = Math.max(pkKillInfoData.endTime, pkKillInfoData.startTime + this.inL);
                                        this.inr.setVisibility(0);
                                        cF(this.inr);
                                        long j5 = this.inp - (j2 - max);
                                        if (j5 <= 0) {
                                            j5 = 0;
                                        }
                                        this.f4int.setText(j5 + "秒" + pkKillInfoData.title);
                                        this.inu.setText(pkKillInfoData.tip);
                                        this.f4int.setTextColor(Color.parseColor("#FF89460D"));
                                        this.inu.setTextColor(Color.parseColor("#FF89460D"));
                                        eG("pk_competition_kill_mode", "activate_success");
                                        return;
                                    case 3:
                                    case 4:
                                        if (cqt() && !this.inC) {
                                            cqs();
                                            this.ink.setVisibility(0);
                                            this.gTG.fW(-1L);
                                            this.inC = true;
                                            this.inG = null;
                                            this.inL = 0L;
                                            this.inK = 0L;
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
        this.ink.setVisibility(8);
        if (this.inR != null && this.inR.cpf()) {
            this.inq.setVisibility(0);
            view.setBackgroundResource(a.c.sdk_transparent);
            return;
        }
        view.setBackgroundResource(a.e.ala_pk_rank_task_bg_light);
    }

    private void cG(View view) {
        this.inD = false;
        if (this.inR != null) {
            this.inR.reset();
            view.setVisibility(0);
            view.setBackgroundResource(a.e.ala_pk_rank_task_bg_black);
            this.ink.setVisibility(8);
        }
    }

    public void cqs() {
        this.inr.setVisibility(8);
        this.inv.setVisibility(8);
        this.inz.setVisibility(8);
        this.inq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqt() {
        return this.inz.getVisibility() == 0 || this.inr.getVisibility() == 0 || this.inv.getVisibility() == 0;
    }

    public void eG(String str, String str2) {
        if (this.gTG.isHost) {
            if (this.inS.containsKey(str + str2)) {
                if (this.inE.pkStatusInfoData.pkID != Integer.parseInt(this.inS.get(str + str2))) {
                    eH(str, str2);
                    this.inS.put(str + str2, this.inE.pkStatusInfoData.pkID + "");
                    return;
                }
                return;
            }
            eH(str, str2);
            this.inS.put(str + str2, this.inE.pkStatusInfoData.pkID + "");
        }
    }

    private void eH(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pkId", Long.valueOf(this.inE.pkStatusInfoData.pkID));
            jSONObject.putOpt("lodId", Long.valueOf(this.inE.logId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, str, "author_liveroom", str2).setContentExt(jSONObject));
    }
}
