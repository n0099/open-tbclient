package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.f;
import com.baidu.tieba.ala.g.a;
import com.baidu.tieba.ala.g.k;
import com.baidu.tieba.ala.g.p;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PkRankEnterView extends RelativeLayout {
    Context context;
    private PkRankView gRJ;
    int ikB;
    ImageView ikC;
    ImageView ikD;
    HeadImageView ikE;
    TextView ikF;
    TextView ikG;
    TextView ikH;
    TextView ikI;
    TextView ikJ;
    RelativeLayout ikK;
    Button ikL;
    RelativeLayout ikM;
    com.baidu.tieba.ala.f ikN;
    p ikO;
    com.baidu.tieba.ala.g.a ikP;
    com.baidu.tieba.ala.g.k ikQ;
    i ikR;
    com.baidu.tieba.ala.h.d ikS;
    private View mView;
    int status;

    public PkRankEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ikO = new p();
        this.ikP = new com.baidu.tieba.ala.g.a();
        this.ikQ = new com.baidu.tieba.ala.g.k();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_enter_layout, (ViewGroup) this, true);
        this.ikM = (RelativeLayout) this.mView.findViewById(a.f.enter_container);
        this.ikE = (HeadImageView) this.mView.findViewById(a.f.enter_head);
        this.ikE.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.ikE.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.ikE.setIsRound(true);
        this.ikE.setAutoChangeStyle(false);
        this.ikC = (ImageView) this.mView.findViewById(a.f.enter_bg);
        this.ikD = (ImageView) this.mView.findViewById(a.f.enter_image);
        this.ikF = (TextView) this.mView.findViewById(a.f.invite_id);
        this.ikG = (TextView) this.mView.findViewById(a.f.invite_tip);
        this.ikH = (TextView) this.mView.findViewById(a.f.new_invite_tip);
        this.ikK = (RelativeLayout) this.mView.findViewById(a.f.bottom_button_layout);
        this.ikL = (Button) this.mView.findViewById(a.f.bottom_button);
        this.ikI = (TextView) this.mView.findViewById(a.f.matching_tip);
        this.ikJ = (TextView) this.mView.findViewById(a.f.matching_time);
        this.ikS = new com.baidu.tieba.ala.h.d(this.ikK);
        this.ikP.a(new a.InterfaceC0630a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.1
            @Override // com.baidu.tieba.ala.g.a.InterfaceC0630a
            public void fN(long j) {
                PkRankEnterView.this.ikO.cmg();
                PkRankEnterView.this.cpO();
                PkRankEnterView.this.gRJ.getGetPkInfoModel().a(PkRankEnterView.this.gRJ.aJZ.aId.userId, j, PkRankEnterView.this.gRJ.aJZ.mLiveInfo.room_id, PkRankEnterView.this.gRJ.aJZ.mLiveInfo.live_id, PkRankEnterView.this.gRJ.isHost ? 1 : 0);
            }

            @Override // com.baidu.tieba.ala.g.a.InterfaceC0630a
            public void bu(int i, String str) {
            }
        });
        this.ikQ.a(new k.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.2
            @Override // com.baidu.tieba.ala.g.k.a
            public void cmd() {
                PkRankEnterView.this.ikO.cmg();
                PkRankEnterView.this.cpJ();
                PkRankEnterView.this.wH(1);
            }

            @Override // com.baidu.tieba.ala.g.k.a
            public void bv(int i, String str) {
            }
        });
        this.ikO.a(new p.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.3
            @Override // com.baidu.tieba.ala.g.p.a
            public void fS(long j) {
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "match_success");
                alaStatsItem.addValue("pkId", Long.valueOf(j));
                AlaStatManager.getInstance().debug("pk_competition_start_pk", alaStatsItem);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pkId", Long.valueOf(j));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_pk", "author_liveroom", "match_success").setContentExt(jSONObject));
                PkRankEnterView.this.gRJ.getGetPkInfoModel().a(PkRankEnterView.this.gRJ.aJZ.aId.userId, j, PkRankEnterView.this.gRJ.aJZ.mLiveInfo.room_id, PkRankEnterView.this.gRJ.aJZ.mLiveInfo.live_id, PkRankEnterView.this.gRJ.isHost ? 1 : 0);
                PkRankEnterView.this.cpJ();
                PkRankEnterView.this.cpO();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void cmj() {
                PkRankEnterView.this.wH(3);
                PkRankEnterView.this.cpJ();
                PkRankEnterView.this.cpO();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void ae(ArrayList<String> arrayList) {
                PkRankEnterView.this.wH(2);
                PkRankEnterView.this.ag(arrayList);
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void bt(int i, String str) {
            }
        });
    }

    public void wH(int i) {
        this.status = i;
        if (this.gRJ.wJ(i)) {
            if (!this.gRJ.isHost) {
                this.gRJ.cqs();
                setVisibility(8);
                return;
            }
            this.gRJ.cqs();
            cpP();
            switch (i) {
                case 0:
                    cpK();
                    break;
                case 1:
                    cpL();
                    break;
                case 2:
                    cpM();
                    break;
                case 3:
                    cpN();
                    break;
            }
            this.ikB = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(ArrayList<String> arrayList) {
        if (this.ikR == null || !this.ikR.cpI()) {
            this.ikR = new i(arrayList, this.ikE, this.ikM);
            this.ikR.sz();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cpJ() {
        if (this.ikR != null) {
            this.ikR.cmg();
        }
    }

    private void cpK() {
        wI(10);
        this.ikD.setVisibility(0);
        this.ikD.setImageResource(a.e.pk_rank_enter_view_again);
        this.ikC.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.ikL.setVisibility(0);
        this.ikL.setText(a.h.sdk_pk_rank_restart);
        this.ikL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ikO.fR(com.baidu.live.ae.a.Qj().buX.aKw);
                PkRankEnterView.this.ikO.fQ(PkRankEnterView.this.gRJ.aJZ.aId.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_rematch_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_rematch_btn_click"));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpL() {
        this.gRJ.ink = 1;
        this.status = 1;
        this.ikB = 1;
        this.ikD.setVisibility(0);
        this.ikD.setImageResource(a.e.pk_rank_enter_view_main);
        this.ikC.setImageResource(a.e.pk_rank_enter_view_bg);
        this.ikL.setVisibility(0);
        this.ikL.setText(a.h.sdk_pk_rank_start);
        this.ikL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ikO.fR(com.baidu.live.ae.a.Qj().buX.aKw);
                PkRankEnterView.this.ikO.fQ(PkRankEnterView.this.gRJ.aJZ.aId.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_quick_start_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_quick_start_btn_click"));
            }
        });
    }

    private void cpM() {
        wI(com.baidu.live.ae.a.Qj().buX.aKw);
        this.ikE.setVisibility(0);
        this.ikC.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.ikI.setVisibility(0);
        this.ikJ.setVisibility(0);
        this.ikL.setVisibility(0);
        this.ikL.setText(a.h.sdk_pk_rank_matching_cancel);
        this.ikL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ikQ.fP(PkRankEnterView.this.gRJ.aJZ.aId.userId);
            }
        });
    }

    private void cpN() {
        wI(10);
        this.ikD.setVisibility(0);
        this.ikD.setImageResource(a.e.pk_rank_enter_view_fail);
        this.ikC.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.ikL.setVisibility(0);
        this.ikL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ikO.fR(com.baidu.live.ae.a.Qj().buX.aKw);
                PkRankEnterView.this.ikO.fQ(PkRankEnterView.this.gRJ.aJZ.aId.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_match_filed_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_match_filed_btn_click"));
            }
        });
    }

    private void eg(JSONObject jSONObject) {
        this.ikC.setImageResource(a.e.pk_rank_enter_view_black_bg);
        wI(10);
        final JSONObject optJSONObject = jSONObject.optJSONObject("rival_anchor");
        this.ikH.setVisibility(0);
        this.ikL.setVisibility(0);
        this.ikL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ikP.D(PkRankEnterView.this.gRJ.aJZ.aId.userId, optJSONObject.optLong("user_id"));
                PkRankEnterView.this.ikS.stopAnim();
            }
        });
        this.ikS.startAnim();
    }

    private void wI(int i) {
        if ((this.ikN == null || !this.ikN.isRunning()) && i > 0) {
            this.ikJ.setText(i + "s");
            this.ikN = new com.baidu.tieba.ala.f(i * 1000, 1000L);
            this.ikN.a(new f.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.9
                @Override // com.baidu.tieba.ala.f.a
                public void onTick(long j) {
                    long round = Math.round(j / 1000.0d);
                    if (PkRankEnterView.this.status == 0 || PkRankEnterView.this.status == 3) {
                        PkRankEnterView.this.ikL.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_restart_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 4) {
                        PkRankEnterView.this.ikL.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_accept_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 2) {
                        PkRankEnterView.this.ikO.fR(round);
                        PkRankEnterView.this.ikJ.setText(round + "s");
                    }
                }

                @Override // com.baidu.tieba.ala.f.a
                public void onFinish() {
                    if (PkRankEnterView.this.status == 2) {
                        PkRankEnterView.this.ikQ.fP(PkRankEnterView.this.gRJ.aJZ.aId.userId);
                        return;
                    }
                    PkRankEnterView.this.ikN.cancelTimer();
                    PkRankEnterView.this.cpP();
                    PkRankEnterView.this.cpL();
                    PkRankEnterView.this.ikS.stopAnim();
                }
            });
            this.ikN.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpO() {
        if (this.ikN != null) {
            this.ikN.cancelTimer();
            this.ikN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpP() {
        setVisibility(0);
        if (this.ikB != this.status) {
            cpO();
        }
        this.ikE.setVisibility(8);
        this.ikI.setVisibility(8);
        this.ikJ.setVisibility(8);
        this.ikD.setVisibility(8);
        this.ikF.setVisibility(8);
        this.ikG.setVisibility(8);
        this.ikH.setVisibility(8);
        this.ikL.setVisibility(8);
    }

    public void onDestroy() {
        if (this.ikO != null) {
            this.ikO.cmi();
        }
        if (this.ikP != null) {
            this.ikP.clX();
        }
        if (this.ikQ != null) {
            this.ikQ.cmc();
        }
        if (this.gRJ.getGetPkInfoModel() != null) {
            this.gRJ.getGetPkInfoModel().cmf();
        }
        if (this.ikS != null) {
            this.ikS.release();
            this.ikS = null;
        }
        cpO();
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gRJ = pkRankView;
    }

    public void d(JSONObject jSONObject, int i) {
        if (this.gRJ.wJ(i) && i == 4) {
            this.ikO.cmg();
            cpJ();
            cpO();
            this.gRJ.cqs();
            cpP();
            this.ikB = i;
            this.status = i;
            eg(jSONObject);
        }
    }
}
