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
    private PkRankView gtC;
    TextView hHA;
    Button hHB;
    RelativeLayout hHC;
    com.baidu.tieba.ala.d hHD;
    p hHE;
    com.baidu.tieba.ala.g.a hHF;
    com.baidu.tieba.ala.g.k hHG;
    i hHH;
    int hHu;
    ImageView hHv;
    ImageView hHw;
    HeadImageView hHx;
    TextView hHy;
    TextView hHz;
    private View mView;
    int status;

    public PkRankEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hHE = new p();
        this.hHF = new com.baidu.tieba.ala.g.a();
        this.hHG = new com.baidu.tieba.ala.g.k();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_enter_layout, (ViewGroup) this, true);
        this.hHC = (RelativeLayout) this.mView.findViewById(a.g.enter_container);
        this.hHx = (HeadImageView) this.mView.findViewById(a.g.enter_head);
        this.hHx.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.hHx.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.hHx.setIsRound(true);
        this.hHx.setAutoChangeStyle(false);
        this.hHv = (ImageView) this.mView.findViewById(a.g.enter_bg);
        this.hHw = (ImageView) this.mView.findViewById(a.g.enter_image);
        this.hHy = (TextView) this.mView.findViewById(a.g.invite_id);
        this.hHz = (TextView) this.mView.findViewById(a.g.invite_tip);
        this.hHB = (Button) this.mView.findViewById(a.g.bottom_button);
        this.hHA = (TextView) this.mView.findViewById(a.g.matching_tip);
        this.hHF.a(new a.InterfaceC0632a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.1
            @Override // com.baidu.tieba.ala.g.a.InterfaceC0632a
            public void eI(long j) {
                PkRankEnterView.this.hHE.cgu();
                PkRankEnterView.this.cjw();
                if (!PkRankEnterView.this.gtC.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.gtC.getGetPkInfoModel().a(PkRankEnterView.this.gtC.aJv.aIe.userId, j, PkRankEnterView.this.gtC.aJv.mLiveInfo.room_id, PkRankEnterView.this.gtC.aJv.mLiveInfo.live_id, PkRankEnterView.this.gtC.isHost ? 1 : 0);
                }
            }

            @Override // com.baidu.tieba.ala.g.a.InterfaceC0632a
            public void bk(int i, String str) {
            }
        });
        this.hHG.a(new k.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.2
            @Override // com.baidu.tieba.ala.g.k.a
            public void cgp() {
                PkRankEnterView.this.hHE.cgu();
                PkRankEnterView.this.cjr();
                PkRankEnterView.this.wy(1);
            }

            @Override // com.baidu.tieba.ala.g.k.a
            public void bl(int i, String str) {
            }
        });
        this.hHE.a(new p.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.3
            @Override // com.baidu.tieba.ala.g.p.a
            public void eM(long j) {
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "match_success");
                alaStatsItem.addValue("pkId", Long.valueOf(j));
                AlaStatManager.getInstance().debug("pk_competition_start_pk", alaStatsItem);
                if (!PkRankEnterView.this.gtC.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.gtC.getGetPkInfoModel().a(PkRankEnterView.this.gtC.aJv.aIe.userId, j, PkRankEnterView.this.gtC.aJv.mLiveInfo.room_id, PkRankEnterView.this.gtC.aJv.mLiveInfo.live_id, PkRankEnterView.this.gtC.isHost ? 1 : 0);
                }
                PkRankEnterView.this.cjr();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void cgv() {
                PkRankEnterView.this.wy(3);
                PkRankEnterView.this.cjr();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void aj(ArrayList<String> arrayList) {
                PkRankEnterView.this.wy(2);
                PkRankEnterView.this.al(arrayList);
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void bj(int i, String str) {
            }
        });
    }

    public void wy(int i) {
        this.status = i;
        if (this.gtC.wA(i)) {
            if (!this.gtC.isHost) {
                this.gtC.cka();
                setVisibility(8);
                return;
            }
            this.gtC.cka();
            cjx();
            switch (i) {
                case 0:
                    cjs();
                    break;
                case 1:
                    cjt();
                    break;
                case 2:
                    cju();
                    break;
                case 3:
                    cjv();
                    break;
            }
            this.hHu = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(ArrayList<String> arrayList) {
        if (this.hHH == null || !this.hHH.cjq()) {
            this.hHH = new i(arrayList, this.hHx, this.hHC);
            this.hHH.tk();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cjr() {
        if (this.hHH != null) {
            this.hHH.cgu();
        }
    }

    private void cjs() {
        wz(10);
        this.hHw.setVisibility(0);
        this.hHw.setImageResource(a.f.pk_rank_enter_view_again);
        this.hHv.setImageResource(a.f.pk_rank_enter_view_black_bg);
        this.hHB.setVisibility(0);
        this.hHB.setText(a.i.sdk_pk_rank_restart);
        this.hHB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hHE.eL(PkRankEnterView.this.gtC.aJv.aIe.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_rematch_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjt() {
        this.gtC.hJs = 1;
        this.status = 1;
        this.hHu = 1;
        this.hHw.setVisibility(0);
        this.hHw.setImageResource(a.f.pk_rank_enter_view_main);
        this.hHv.setImageResource(a.f.pk_rank_enter_view_bg);
        this.hHB.setVisibility(0);
        this.hHB.setText(a.i.sdk_pk_rank_start);
        this.hHB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hHE.eL(PkRankEnterView.this.gtC.aJv.aIe.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_quick_start_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void cju() {
        this.hHx.setVisibility(0);
        this.hHv.setImageResource(a.f.pk_rank_enter_view_black_bg);
        this.hHA.setVisibility(0);
        this.hHB.setVisibility(0);
        this.hHB.setText(a.i.sdk_pk_rank_matching_cancel);
        this.hHB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hHG.eK(PkRankEnterView.this.gtC.aJv.aIe.userId);
            }
        });
    }

    private void cjv() {
        wz(10);
        this.hHw.setVisibility(0);
        this.hHw.setImageResource(a.f.pk_rank_enter_view_fail);
        this.hHv.setImageResource(a.f.pk_rank_enter_view_black_bg);
        this.hHB.setVisibility(0);
        this.hHB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hHE.eL(PkRankEnterView.this.gtC.aJv.aIe.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_match_filed_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void dP(JSONObject jSONObject) {
        this.hHv.setImageResource(a.f.pk_rank_enter_view_black_bg);
        wz(10);
        final JSONObject optJSONObject = jSONObject.optJSONObject("rival_anchor");
        String optString = optJSONObject.optString("bd_portrait");
        this.hHx.setVisibility(0);
        this.hHx.startLoad(optString, 25, false, false);
        this.hHy.setVisibility(0);
        this.hHy.setText(optJSONObject.optString("nick_name"));
        this.hHz.setVisibility(0);
        this.hHB.setVisibility(0);
        this.hHB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hHF.v(PkRankEnterView.this.gtC.aJv.aIe.userId, optJSONObject.optLong("user_id"));
            }
        });
    }

    private void wz(int i) {
        if ((this.hHD == null || !this.hHD.isRunning()) && i > 0) {
            this.hHD = new com.baidu.tieba.ala.d(i * 1000, 1000L);
            this.hHD.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.9
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j) {
                    long round = Math.round(j / 1000.0d) % 60;
                    if (PkRankEnterView.this.status == 0 || PkRankEnterView.this.status == 3) {
                        PkRankEnterView.this.hHB.setText(PkRankEnterView.this.context.getString(a.i.sdk_pk_rank_restart_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 4) {
                        PkRankEnterView.this.hHB.setText(PkRankEnterView.this.context.getString(a.i.sdk_pk_rank_accept_time, String.valueOf(round)));
                    }
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankEnterView.this.hHD.cancelTimer();
                    PkRankEnterView.this.cjx();
                    PkRankEnterView.this.cjt();
                }
            });
            this.hHD.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjw() {
        if (this.hHD != null) {
            this.hHD.cancelTimer();
            this.hHD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjx() {
        setVisibility(0);
        if (this.hHu != this.status) {
            cjw();
        }
        this.hHx.setVisibility(8);
        this.hHA.setVisibility(8);
        this.hHw.setVisibility(8);
        this.hHy.setVisibility(8);
        this.hHz.setVisibility(8);
        this.hHB.setVisibility(8);
    }

    public void onDestroy() {
        if (this.hHE != null) {
            this.hHE.cgt();
        }
        if (this.hHF != null) {
            this.hHF.cgi();
        }
        if (this.hHG != null) {
            this.hHG.cgo();
        }
        if (this.gtC.getGetPkInfoModel() != null) {
            this.gtC.getGetPkInfoModel().cgr();
        }
        cjw();
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gtC = pkRankView;
    }

    public void d(JSONObject jSONObject, int i) {
        if (this.gtC.wA(i) && i == 4) {
            this.hHE.cgu();
            cjr();
            cjw();
            this.gtC.cka();
            cjx();
            this.hHu = i;
            this.status = i;
            dP(jSONObject);
        }
    }
}
