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
    private PkRankView gRX;
    int ikP;
    ImageView ikQ;
    ImageView ikR;
    HeadImageView ikS;
    TextView ikT;
    TextView ikU;
    TextView ikV;
    TextView ikW;
    TextView ikX;
    RelativeLayout ikY;
    Button ikZ;
    RelativeLayout ila;
    com.baidu.tieba.ala.f ilb;
    p ilc;
    com.baidu.tieba.ala.g.a ild;
    com.baidu.tieba.ala.g.k ile;
    i ilf;
    com.baidu.tieba.ala.h.d ilg;
    private View mView;
    int status;

    public PkRankEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilc = new p();
        this.ild = new com.baidu.tieba.ala.g.a();
        this.ile = new com.baidu.tieba.ala.g.k();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_enter_layout, (ViewGroup) this, true);
        this.ila = (RelativeLayout) this.mView.findViewById(a.f.enter_container);
        this.ikS = (HeadImageView) this.mView.findViewById(a.f.enter_head);
        this.ikS.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.ikS.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.ikS.setIsRound(true);
        this.ikS.setAutoChangeStyle(false);
        this.ikQ = (ImageView) this.mView.findViewById(a.f.enter_bg);
        this.ikR = (ImageView) this.mView.findViewById(a.f.enter_image);
        this.ikT = (TextView) this.mView.findViewById(a.f.invite_id);
        this.ikU = (TextView) this.mView.findViewById(a.f.invite_tip);
        this.ikV = (TextView) this.mView.findViewById(a.f.new_invite_tip);
        this.ikY = (RelativeLayout) this.mView.findViewById(a.f.bottom_button_layout);
        this.ikZ = (Button) this.mView.findViewById(a.f.bottom_button);
        this.ikW = (TextView) this.mView.findViewById(a.f.matching_tip);
        this.ikX = (TextView) this.mView.findViewById(a.f.matching_time);
        this.ilg = new com.baidu.tieba.ala.h.d(this.ikY);
        this.ild.a(new a.InterfaceC0631a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.1
            @Override // com.baidu.tieba.ala.g.a.InterfaceC0631a
            public void fN(long j) {
                PkRankEnterView.this.ilc.cmn();
                PkRankEnterView.this.cpV();
                PkRankEnterView.this.gRX.getGetPkInfoModel().a(PkRankEnterView.this.gRX.aJZ.aId.userId, j, PkRankEnterView.this.gRX.aJZ.mLiveInfo.room_id, PkRankEnterView.this.gRX.aJZ.mLiveInfo.live_id, PkRankEnterView.this.gRX.isHost ? 1 : 0);
            }

            @Override // com.baidu.tieba.ala.g.a.InterfaceC0631a
            public void bu(int i, String str) {
            }
        });
        this.ile.a(new k.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.2
            @Override // com.baidu.tieba.ala.g.k.a
            public void cmk() {
                PkRankEnterView.this.ilc.cmn();
                PkRankEnterView.this.cpQ();
                PkRankEnterView.this.wH(1);
            }

            @Override // com.baidu.tieba.ala.g.k.a
            public void bv(int i, String str) {
            }
        });
        this.ilc.a(new p.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.3
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
                PkRankEnterView.this.gRX.getGetPkInfoModel().a(PkRankEnterView.this.gRX.aJZ.aId.userId, j, PkRankEnterView.this.gRX.aJZ.mLiveInfo.room_id, PkRankEnterView.this.gRX.aJZ.mLiveInfo.live_id, PkRankEnterView.this.gRX.isHost ? 1 : 0);
                PkRankEnterView.this.cpQ();
                PkRankEnterView.this.cpV();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void cmq() {
                PkRankEnterView.this.wH(3);
                PkRankEnterView.this.cpQ();
                PkRankEnterView.this.cpV();
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
        if (this.gRX.wJ(i)) {
            if (!this.gRX.isHost) {
                this.gRX.cqz();
                setVisibility(8);
                return;
            }
            this.gRX.cqz();
            cpW();
            switch (i) {
                case 0:
                    cpR();
                    break;
                case 1:
                    cpS();
                    break;
                case 2:
                    cpT();
                    break;
                case 3:
                    cpU();
                    break;
            }
            this.ikP = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(ArrayList<String> arrayList) {
        if (this.ilf == null || !this.ilf.cpP()) {
            this.ilf = new i(arrayList, this.ikS, this.ila);
            this.ilf.sz();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cpQ() {
        if (this.ilf != null) {
            this.ilf.cmn();
        }
    }

    private void cpR() {
        wI(10);
        this.ikR.setVisibility(0);
        this.ikR.setImageResource(a.e.pk_rank_enter_view_again);
        this.ikQ.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.ikZ.setVisibility(0);
        this.ikZ.setText(a.h.sdk_pk_rank_restart);
        this.ikZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ilc.fR(com.baidu.live.ae.a.Qj().buX.aKw);
                PkRankEnterView.this.ilc.fQ(PkRankEnterView.this.gRX.aJZ.aId.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_rematch_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_rematch_btn_click"));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpS() {
        this.gRX.inz = 1;
        this.status = 1;
        this.ikP = 1;
        this.ikR.setVisibility(0);
        this.ikR.setImageResource(a.e.pk_rank_enter_view_main);
        this.ikQ.setImageResource(a.e.pk_rank_enter_view_bg);
        this.ikZ.setVisibility(0);
        this.ikZ.setText(a.h.sdk_pk_rank_start);
        this.ikZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ilc.fR(com.baidu.live.ae.a.Qj().buX.aKw);
                PkRankEnterView.this.ilc.fQ(PkRankEnterView.this.gRX.aJZ.aId.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_quick_start_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_quick_start_btn_click"));
            }
        });
    }

    private void cpT() {
        wI(com.baidu.live.ae.a.Qj().buX.aKw);
        this.ikS.setVisibility(0);
        this.ikQ.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.ikW.setVisibility(0);
        this.ikX.setVisibility(0);
        this.ikZ.setVisibility(0);
        this.ikZ.setText(a.h.sdk_pk_rank_matching_cancel);
        this.ikZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ile.fP(PkRankEnterView.this.gRX.aJZ.aId.userId);
            }
        });
    }

    private void cpU() {
        wI(10);
        this.ikR.setVisibility(0);
        this.ikR.setImageResource(a.e.pk_rank_enter_view_fail);
        this.ikQ.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.ikZ.setVisibility(0);
        this.ikZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ilc.fR(com.baidu.live.ae.a.Qj().buX.aKw);
                PkRankEnterView.this.ilc.fQ(PkRankEnterView.this.gRX.aJZ.aId.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_match_filed_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_match_filed_btn_click"));
            }
        });
    }

    private void eg(JSONObject jSONObject) {
        this.ikQ.setImageResource(a.e.pk_rank_enter_view_black_bg);
        wI(10);
        final JSONObject optJSONObject = jSONObject.optJSONObject("rival_anchor");
        this.ikV.setVisibility(0);
        this.ikZ.setVisibility(0);
        this.ikZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ild.D(PkRankEnterView.this.gRX.aJZ.aId.userId, optJSONObject.optLong("user_id"));
                PkRankEnterView.this.ilg.stopAnim();
            }
        });
        this.ilg.startAnim();
    }

    private void wI(int i) {
        if ((this.ilb == null || !this.ilb.isRunning()) && i > 0) {
            this.ikX.setText(i + "s");
            this.ilb = new com.baidu.tieba.ala.f(i * 1000, 1000L);
            this.ilb.a(new f.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.9
                @Override // com.baidu.tieba.ala.f.a
                public void onTick(long j) {
                    long round = Math.round(j / 1000.0d);
                    if (PkRankEnterView.this.status == 0 || PkRankEnterView.this.status == 3) {
                        PkRankEnterView.this.ikZ.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_restart_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 4) {
                        PkRankEnterView.this.ikZ.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_accept_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 2) {
                        PkRankEnterView.this.ilc.fR(round);
                        PkRankEnterView.this.ikX.setText(round + "s");
                    }
                }

                @Override // com.baidu.tieba.ala.f.a
                public void onFinish() {
                    if (PkRankEnterView.this.status == 2) {
                        PkRankEnterView.this.ile.fP(PkRankEnterView.this.gRX.aJZ.aId.userId);
                        return;
                    }
                    PkRankEnterView.this.ilb.cancelTimer();
                    PkRankEnterView.this.cpW();
                    PkRankEnterView.this.cpS();
                    PkRankEnterView.this.ilg.stopAnim();
                }
            });
            this.ilb.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpV() {
        if (this.ilb != null) {
            this.ilb.cancelTimer();
            this.ilb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpW() {
        setVisibility(0);
        if (this.ikP != this.status) {
            cpV();
        }
        this.ikS.setVisibility(8);
        this.ikW.setVisibility(8);
        this.ikX.setVisibility(8);
        this.ikR.setVisibility(8);
        this.ikT.setVisibility(8);
        this.ikU.setVisibility(8);
        this.ikV.setVisibility(8);
        this.ikZ.setVisibility(8);
    }

    public void onDestroy() {
        if (this.ilc != null) {
            this.ilc.cmp();
        }
        if (this.ild != null) {
            this.ild.cme();
        }
        if (this.ile != null) {
            this.ile.cmj();
        }
        if (this.gRX.getGetPkInfoModel() != null) {
            this.gRX.getGetPkInfoModel().cmm();
        }
        if (this.ilg != null) {
            this.ilg.release();
            this.ilg = null;
        }
        cpV();
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gRX = pkRankView;
    }

    public void d(JSONObject jSONObject, int i) {
        if (this.gRX.wJ(i) && i == 4) {
            this.ilc.cmn();
            cpQ();
            cpV();
            this.gRX.cqz();
            cpW();
            this.ikP = i;
            this.status = i;
            eg(jSONObject);
        }
    }
}
