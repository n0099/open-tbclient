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
import com.baidu.tieba.ala.d;
import com.baidu.tieba.ala.g.a;
import com.baidu.tieba.ala.g.k;
import com.baidu.tieba.ala.g.p;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PkRankEnterView extends RelativeLayout {
    Context context;
    private PkRankView gHT;
    int hXS;
    ImageView hXT;
    ImageView hXU;
    HeadImageView hXV;
    TextView hXW;
    TextView hXX;
    TextView hXY;
    Button hXZ;
    RelativeLayout hYa;
    com.baidu.tieba.ala.d hYb;
    p hYc;
    com.baidu.tieba.ala.g.a hYd;
    com.baidu.tieba.ala.g.k hYe;
    i hYf;
    private View mView;
    int status;

    public PkRankEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYc = new p();
        this.hYd = new com.baidu.tieba.ala.g.a();
        this.hYe = new com.baidu.tieba.ala.g.k();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_enter_layout, (ViewGroup) this, true);
        this.hYa = (RelativeLayout) this.mView.findViewById(a.f.enter_container);
        this.hXV = (HeadImageView) this.mView.findViewById(a.f.enter_head);
        this.hXV.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hXV.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hXV.setIsRound(true);
        this.hXV.setAutoChangeStyle(false);
        this.hXT = (ImageView) this.mView.findViewById(a.f.enter_bg);
        this.hXU = (ImageView) this.mView.findViewById(a.f.enter_image);
        this.hXW = (TextView) this.mView.findViewById(a.f.invite_id);
        this.hXX = (TextView) this.mView.findViewById(a.f.invite_tip);
        this.hXZ = (Button) this.mView.findViewById(a.f.bottom_button);
        this.hXY = (TextView) this.mView.findViewById(a.f.matching_tip);
        this.hYd.a(new a.InterfaceC0657a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.1
            @Override // com.baidu.tieba.ala.g.a.InterfaceC0657a
            public void fI(long j) {
                PkRankEnterView.this.hYc.cmj();
                PkRankEnterView.this.cpG();
                if (!PkRankEnterView.this.gHT.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.gHT.getGetPkInfoModel().a(PkRankEnterView.this.gHT.aLD.aJV.userId, j, PkRankEnterView.this.gHT.aLD.mLiveInfo.room_id, PkRankEnterView.this.gHT.aLD.mLiveInfo.live_id, PkRankEnterView.this.gHT.isHost ? 1 : 0);
                }
            }

            @Override // com.baidu.tieba.ala.g.a.InterfaceC0657a
            public void bm(int i, String str) {
            }
        });
        this.hYe.a(new k.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.2
            @Override // com.baidu.tieba.ala.g.k.a
            public void cme() {
                PkRankEnterView.this.hYc.cmj();
                PkRankEnterView.this.cpB();
                PkRankEnterView.this.xP(1);
            }

            @Override // com.baidu.tieba.ala.g.k.a
            public void bn(int i, String str) {
            }
        });
        this.hYc.a(new p.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.3
            @Override // com.baidu.tieba.ala.g.p.a
            public void fM(long j) {
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "match_success");
                alaStatsItem.addValue("pkId", Long.valueOf(j));
                AlaStatManager.getInstance().debug("pk_competition_start_pk", alaStatsItem);
                if (!PkRankEnterView.this.gHT.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.gHT.getGetPkInfoModel().a(PkRankEnterView.this.gHT.aLD.aJV.userId, j, PkRankEnterView.this.gHT.aLD.mLiveInfo.room_id, PkRankEnterView.this.gHT.aLD.mLiveInfo.live_id, PkRankEnterView.this.gHT.isHost ? 1 : 0);
                }
                PkRankEnterView.this.cpB();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void cmk() {
                PkRankEnterView.this.xP(3);
                PkRankEnterView.this.cpB();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void ak(ArrayList<String> arrayList) {
                PkRankEnterView.this.xP(2);
                PkRankEnterView.this.am(arrayList);
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void bl(int i, String str) {
            }
        });
    }

    public void xP(int i) {
        this.status = i;
        if (this.gHT.xR(i)) {
            if (!this.gHT.isHost) {
                this.gHT.cqi();
                setVisibility(8);
                return;
            }
            this.gHT.cqi();
            cpH();
            switch (i) {
                case 0:
                    cpC();
                    break;
                case 1:
                    cpD();
                    break;
                case 2:
                    cpE();
                    break;
                case 3:
                    cpF();
                    break;
            }
            this.hXS = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(ArrayList<String> arrayList) {
        if (this.hYf == null || !this.hYf.cpA()) {
            this.hYf = new i(arrayList, this.hXV, this.hYa);
            this.hYf.tn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cpB() {
        if (this.hYf != null) {
            this.hYf.cmj();
        }
    }

    private void cpC() {
        xQ(10);
        this.hXU.setVisibility(0);
        this.hXU.setImageResource(a.e.pk_rank_enter_view_again);
        this.hXT.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.hXZ.setVisibility(0);
        this.hXZ.setText(a.h.sdk_pk_rank_restart);
        this.hXZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hYc.fL(PkRankEnterView.this.gHT.aLD.aJV.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_rematch_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpD() {
        this.gHT.hZN = 1;
        this.status = 1;
        this.hXS = 1;
        this.hXU.setVisibility(0);
        this.hXU.setImageResource(a.e.pk_rank_enter_view_main);
        this.hXT.setImageResource(a.e.pk_rank_enter_view_bg);
        this.hXZ.setVisibility(0);
        this.hXZ.setText(a.h.sdk_pk_rank_start);
        this.hXZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hYc.fL(PkRankEnterView.this.gHT.aLD.aJV.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_quick_start_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void cpE() {
        this.hXV.setVisibility(0);
        this.hXT.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.hXY.setVisibility(0);
        this.hXZ.setVisibility(0);
        this.hXZ.setText(a.h.sdk_pk_rank_matching_cancel);
        this.hXZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hYe.fK(PkRankEnterView.this.gHT.aLD.aJV.userId);
            }
        });
    }

    private void cpF() {
        xQ(10);
        this.hXU.setVisibility(0);
        this.hXU.setImageResource(a.e.pk_rank_enter_view_fail);
        this.hXT.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.hXZ.setVisibility(0);
        this.hXZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hYc.fL(PkRankEnterView.this.gHT.aLD.aJV.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_match_filed_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void dR(JSONObject jSONObject) {
        this.hXT.setImageResource(a.e.pk_rank_enter_view_black_bg);
        xQ(10);
        final JSONObject optJSONObject = jSONObject.optJSONObject("rival_anchor");
        String optString = optJSONObject.optString("bd_portrait");
        this.hXV.setVisibility(0);
        this.hXV.startLoad(optString, 25, false, false);
        this.hXW.setVisibility(0);
        this.hXW.setText(optJSONObject.optString("nick_name"));
        this.hXX.setVisibility(0);
        this.hXZ.setVisibility(0);
        this.hXZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hYd.w(PkRankEnterView.this.gHT.aLD.aJV.userId, optJSONObject.optLong("user_id"));
            }
        });
    }

    private void xQ(int i) {
        if ((this.hYb == null || !this.hYb.isRunning()) && i > 0) {
            this.hYb = new com.baidu.tieba.ala.d(i * 1000, 1000L);
            this.hYb.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.9
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j) {
                    long round = Math.round(j / 1000.0d) % 60;
                    if (PkRankEnterView.this.status == 0 || PkRankEnterView.this.status == 3) {
                        PkRankEnterView.this.hXZ.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_restart_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 4) {
                        PkRankEnterView.this.hXZ.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_accept_time, String.valueOf(round)));
                    }
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankEnterView.this.hYb.cancelTimer();
                    PkRankEnterView.this.cpH();
                    PkRankEnterView.this.cpD();
                }
            });
            this.hYb.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpG() {
        if (this.hYb != null) {
            this.hYb.cancelTimer();
            this.hYb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpH() {
        setVisibility(0);
        if (this.hXS != this.status) {
            cpG();
        }
        this.hXV.setVisibility(8);
        this.hXY.setVisibility(8);
        this.hXU.setVisibility(8);
        this.hXW.setVisibility(8);
        this.hXX.setVisibility(8);
        this.hXZ.setVisibility(8);
    }

    public void onDestroy() {
        if (this.hYc != null) {
            this.hYc.cmi();
        }
        if (this.hYd != null) {
            this.hYd.clY();
        }
        if (this.hYe != null) {
            this.hYe.cmd();
        }
        if (this.gHT.getGetPkInfoModel() != null) {
            this.gHT.getGetPkInfoModel().cmg();
        }
        cpG();
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gHT = pkRankView;
    }

    public void d(JSONObject jSONObject, int i) {
        if (this.gHT.xR(i) && i == 4) {
            this.hYc.cmj();
            cpB();
            cpG();
            this.gHT.cqi();
            cpH();
            this.hXS = i;
            this.status = i;
            dR(jSONObject);
        }
    }
}
