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
    private PkRankView gHV;
    int hXU;
    ImageView hXV;
    ImageView hXW;
    HeadImageView hXX;
    TextView hXY;
    TextView hXZ;
    TextView hYa;
    Button hYb;
    RelativeLayout hYc;
    com.baidu.tieba.ala.d hYd;
    p hYe;
    com.baidu.tieba.ala.g.a hYf;
    com.baidu.tieba.ala.g.k hYg;
    i hYh;
    private View mView;
    int status;

    public PkRankEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYe = new p();
        this.hYf = new com.baidu.tieba.ala.g.a();
        this.hYg = new com.baidu.tieba.ala.g.k();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_enter_layout, (ViewGroup) this, true);
        this.hYc = (RelativeLayout) this.mView.findViewById(a.f.enter_container);
        this.hXX = (HeadImageView) this.mView.findViewById(a.f.enter_head);
        this.hXX.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hXX.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hXX.setIsRound(true);
        this.hXX.setAutoChangeStyle(false);
        this.hXV = (ImageView) this.mView.findViewById(a.f.enter_bg);
        this.hXW = (ImageView) this.mView.findViewById(a.f.enter_image);
        this.hXY = (TextView) this.mView.findViewById(a.f.invite_id);
        this.hXZ = (TextView) this.mView.findViewById(a.f.invite_tip);
        this.hYb = (Button) this.mView.findViewById(a.f.bottom_button);
        this.hYa = (TextView) this.mView.findViewById(a.f.matching_tip);
        this.hYf.a(new a.InterfaceC0657a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.1
            @Override // com.baidu.tieba.ala.g.a.InterfaceC0657a
            public void fI(long j) {
                PkRankEnterView.this.hYe.cmk();
                PkRankEnterView.this.cpH();
                if (!PkRankEnterView.this.gHV.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.gHV.getGetPkInfoModel().a(PkRankEnterView.this.gHV.aLD.aJV.userId, j, PkRankEnterView.this.gHV.aLD.mLiveInfo.room_id, PkRankEnterView.this.gHV.aLD.mLiveInfo.live_id, PkRankEnterView.this.gHV.isHost ? 1 : 0);
                }
            }

            @Override // com.baidu.tieba.ala.g.a.InterfaceC0657a
            public void bm(int i, String str) {
            }
        });
        this.hYg.a(new k.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.2
            @Override // com.baidu.tieba.ala.g.k.a
            public void cmf() {
                PkRankEnterView.this.hYe.cmk();
                PkRankEnterView.this.cpC();
                PkRankEnterView.this.xP(1);
            }

            @Override // com.baidu.tieba.ala.g.k.a
            public void bn(int i, String str) {
            }
        });
        this.hYe.a(new p.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.3
            @Override // com.baidu.tieba.ala.g.p.a
            public void fM(long j) {
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "match_success");
                alaStatsItem.addValue("pkId", Long.valueOf(j));
                AlaStatManager.getInstance().debug("pk_competition_start_pk", alaStatsItem);
                if (!PkRankEnterView.this.gHV.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.gHV.getGetPkInfoModel().a(PkRankEnterView.this.gHV.aLD.aJV.userId, j, PkRankEnterView.this.gHV.aLD.mLiveInfo.room_id, PkRankEnterView.this.gHV.aLD.mLiveInfo.live_id, PkRankEnterView.this.gHV.isHost ? 1 : 0);
                }
                PkRankEnterView.this.cpC();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void cml() {
                PkRankEnterView.this.xP(3);
                PkRankEnterView.this.cpC();
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
        if (this.gHV.xR(i)) {
            if (!this.gHV.isHost) {
                this.gHV.cqj();
                setVisibility(8);
                return;
            }
            this.gHV.cqj();
            cpI();
            switch (i) {
                case 0:
                    cpD();
                    break;
                case 1:
                    cpE();
                    break;
                case 2:
                    cpF();
                    break;
                case 3:
                    cpG();
                    break;
            }
            this.hXU = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(ArrayList<String> arrayList) {
        if (this.hYh == null || !this.hYh.cpB()) {
            this.hYh = new i(arrayList, this.hXX, this.hYc);
            this.hYh.tn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cpC() {
        if (this.hYh != null) {
            this.hYh.cmk();
        }
    }

    private void cpD() {
        xQ(10);
        this.hXW.setVisibility(0);
        this.hXW.setImageResource(a.e.pk_rank_enter_view_again);
        this.hXV.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.hYb.setVisibility(0);
        this.hYb.setText(a.h.sdk_pk_rank_restart);
        this.hYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hYe.fL(PkRankEnterView.this.gHV.aLD.aJV.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_rematch_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpE() {
        this.gHV.hZP = 1;
        this.status = 1;
        this.hXU = 1;
        this.hXW.setVisibility(0);
        this.hXW.setImageResource(a.e.pk_rank_enter_view_main);
        this.hXV.setImageResource(a.e.pk_rank_enter_view_bg);
        this.hYb.setVisibility(0);
        this.hYb.setText(a.h.sdk_pk_rank_start);
        this.hYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hYe.fL(PkRankEnterView.this.gHV.aLD.aJV.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_quick_start_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void cpF() {
        this.hXX.setVisibility(0);
        this.hXV.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.hYa.setVisibility(0);
        this.hYb.setVisibility(0);
        this.hYb.setText(a.h.sdk_pk_rank_matching_cancel);
        this.hYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hYg.fK(PkRankEnterView.this.gHV.aLD.aJV.userId);
            }
        });
    }

    private void cpG() {
        xQ(10);
        this.hXW.setVisibility(0);
        this.hXW.setImageResource(a.e.pk_rank_enter_view_fail);
        this.hXV.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.hYb.setVisibility(0);
        this.hYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hYe.fL(PkRankEnterView.this.gHV.aLD.aJV.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_match_filed_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void dR(JSONObject jSONObject) {
        this.hXV.setImageResource(a.e.pk_rank_enter_view_black_bg);
        xQ(10);
        final JSONObject optJSONObject = jSONObject.optJSONObject("rival_anchor");
        String optString = optJSONObject.optString("bd_portrait");
        this.hXX.setVisibility(0);
        this.hXX.startLoad(optString, 25, false, false);
        this.hXY.setVisibility(0);
        this.hXY.setText(optJSONObject.optString("nick_name"));
        this.hXZ.setVisibility(0);
        this.hYb.setVisibility(0);
        this.hYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hYf.w(PkRankEnterView.this.gHV.aLD.aJV.userId, optJSONObject.optLong("user_id"));
            }
        });
    }

    private void xQ(int i) {
        if ((this.hYd == null || !this.hYd.isRunning()) && i > 0) {
            this.hYd = new com.baidu.tieba.ala.d(i * 1000, 1000L);
            this.hYd.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.9
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j) {
                    long round = Math.round(j / 1000.0d) % 60;
                    if (PkRankEnterView.this.status == 0 || PkRankEnterView.this.status == 3) {
                        PkRankEnterView.this.hYb.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_restart_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 4) {
                        PkRankEnterView.this.hYb.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_accept_time, String.valueOf(round)));
                    }
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankEnterView.this.hYd.cancelTimer();
                    PkRankEnterView.this.cpI();
                    PkRankEnterView.this.cpE();
                }
            });
            this.hYd.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpH() {
        if (this.hYd != null) {
            this.hYd.cancelTimer();
            this.hYd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpI() {
        setVisibility(0);
        if (this.hXU != this.status) {
            cpH();
        }
        this.hXX.setVisibility(8);
        this.hYa.setVisibility(8);
        this.hXW.setVisibility(8);
        this.hXY.setVisibility(8);
        this.hXZ.setVisibility(8);
        this.hYb.setVisibility(8);
    }

    public void onDestroy() {
        if (this.hYe != null) {
            this.hYe.cmj();
        }
        if (this.hYf != null) {
            this.hYf.clZ();
        }
        if (this.hYg != null) {
            this.hYg.cme();
        }
        if (this.gHV.getGetPkInfoModel() != null) {
            this.gHV.getGetPkInfoModel().cmh();
        }
        cpH();
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gHV = pkRankView;
    }

    public void d(JSONObject jSONObject, int i) {
        if (this.gHV.xR(i) && i == 4) {
            this.hYe.cmk();
            cpC();
            cpH();
            this.gHV.cqj();
            cpI();
            this.hXU = i;
            this.status = i;
            dR(jSONObject);
        }
    }
}
