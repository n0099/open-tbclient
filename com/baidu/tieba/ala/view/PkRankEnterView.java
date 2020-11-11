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
    private PkRankView gzq;
    com.baidu.tieba.ala.d hNA;
    p hNB;
    com.baidu.tieba.ala.g.a hNC;
    com.baidu.tieba.ala.g.k hND;
    i hNE;
    int hNr;
    ImageView hNs;
    ImageView hNt;
    HeadImageView hNu;
    TextView hNv;
    TextView hNw;
    TextView hNx;
    Button hNy;
    RelativeLayout hNz;
    private View mView;
    int status;

    public PkRankEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNB = new p();
        this.hNC = new com.baidu.tieba.ala.g.a();
        this.hND = new com.baidu.tieba.ala.g.k();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_enter_layout, (ViewGroup) this, true);
        this.hNz = (RelativeLayout) this.mView.findViewById(a.f.enter_container);
        this.hNu = (HeadImageView) this.mView.findViewById(a.f.enter_head);
        this.hNu.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hNu.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hNu.setIsRound(true);
        this.hNu.setAutoChangeStyle(false);
        this.hNs = (ImageView) this.mView.findViewById(a.f.enter_bg);
        this.hNt = (ImageView) this.mView.findViewById(a.f.enter_image);
        this.hNv = (TextView) this.mView.findViewById(a.f.invite_id);
        this.hNw = (TextView) this.mView.findViewById(a.f.invite_tip);
        this.hNy = (Button) this.mView.findViewById(a.f.bottom_button);
        this.hNx = (TextView) this.mView.findViewById(a.f.matching_tip);
        this.hNC.a(new a.InterfaceC0644a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.1
            @Override // com.baidu.tieba.ala.g.a.InterfaceC0644a
            public void fe(long j) {
                PkRankEnterView.this.hNB.ciW();
                PkRankEnterView.this.clY();
                if (!PkRankEnterView.this.gzq.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.gzq.getGetPkInfoModel().a(PkRankEnterView.this.gzq.aKv.aIV.userId, j, PkRankEnterView.this.gzq.aKv.mLiveInfo.room_id, PkRankEnterView.this.gzq.aKv.mLiveInfo.live_id, PkRankEnterView.this.gzq.isHost ? 1 : 0);
                }
            }

            @Override // com.baidu.tieba.ala.g.a.InterfaceC0644a
            public void bo(int i, String str) {
            }
        });
        this.hND.a(new k.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.2
            @Override // com.baidu.tieba.ala.g.k.a
            public void ciR() {
                PkRankEnterView.this.hNB.ciW();
                PkRankEnterView.this.clT();
                PkRankEnterView.this.wL(1);
            }

            @Override // com.baidu.tieba.ala.g.k.a
            public void bp(int i, String str) {
            }
        });
        this.hNB.a(new p.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.3
            @Override // com.baidu.tieba.ala.g.p.a
            public void fi(long j) {
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "match_success");
                alaStatsItem.addValue("pkId", Long.valueOf(j));
                AlaStatManager.getInstance().debug("pk_competition_start_pk", alaStatsItem);
                if (!PkRankEnterView.this.gzq.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.gzq.getGetPkInfoModel().a(PkRankEnterView.this.gzq.aKv.aIV.userId, j, PkRankEnterView.this.gzq.aKv.mLiveInfo.room_id, PkRankEnterView.this.gzq.aKv.mLiveInfo.live_id, PkRankEnterView.this.gzq.isHost ? 1 : 0);
                }
                PkRankEnterView.this.clT();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void ciX() {
                PkRankEnterView.this.wL(3);
                PkRankEnterView.this.clT();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void aj(ArrayList<String> arrayList) {
                PkRankEnterView.this.wL(2);
                PkRankEnterView.this.al(arrayList);
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void bn(int i, String str) {
            }
        });
    }

    public void wL(int i) {
        this.status = i;
        if (this.gzq.wN(i)) {
            if (!this.gzq.isHost) {
                this.gzq.cmC();
                setVisibility(8);
                return;
            }
            this.gzq.cmC();
            clZ();
            switch (i) {
                case 0:
                    clU();
                    break;
                case 1:
                    clV();
                    break;
                case 2:
                    clW();
                    break;
                case 3:
                    clX();
                    break;
            }
            this.hNr = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(ArrayList<String> arrayList) {
        if (this.hNE == null || !this.hNE.clS()) {
            this.hNE = new i(arrayList, this.hNu, this.hNz);
            this.hNE.tk();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clT() {
        if (this.hNE != null) {
            this.hNE.ciW();
        }
    }

    private void clU() {
        wM(10);
        this.hNt.setVisibility(0);
        this.hNt.setImageResource(a.e.pk_rank_enter_view_again);
        this.hNs.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.hNy.setVisibility(0);
        this.hNy.setText(a.h.sdk_pk_rank_restart);
        this.hNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hNB.fh(PkRankEnterView.this.gzq.aKv.aIV.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_rematch_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clV() {
        this.gzq.hPp = 1;
        this.status = 1;
        this.hNr = 1;
        this.hNt.setVisibility(0);
        this.hNt.setImageResource(a.e.pk_rank_enter_view_main);
        this.hNs.setImageResource(a.e.pk_rank_enter_view_bg);
        this.hNy.setVisibility(0);
        this.hNy.setText(a.h.sdk_pk_rank_start);
        this.hNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hNB.fh(PkRankEnterView.this.gzq.aKv.aIV.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_quick_start_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void clW() {
        this.hNu.setVisibility(0);
        this.hNs.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.hNx.setVisibility(0);
        this.hNy.setVisibility(0);
        this.hNy.setText(a.h.sdk_pk_rank_matching_cancel);
        this.hNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hND.fg(PkRankEnterView.this.gzq.aKv.aIV.userId);
            }
        });
    }

    private void clX() {
        wM(10);
        this.hNt.setVisibility(0);
        this.hNt.setImageResource(a.e.pk_rank_enter_view_fail);
        this.hNs.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.hNy.setVisibility(0);
        this.hNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hNB.fh(PkRankEnterView.this.gzq.aKv.aIV.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_match_filed_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void dV(JSONObject jSONObject) {
        this.hNs.setImageResource(a.e.pk_rank_enter_view_black_bg);
        wM(10);
        final JSONObject optJSONObject = jSONObject.optJSONObject("rival_anchor");
        String optString = optJSONObject.optString("bd_portrait");
        this.hNu.setVisibility(0);
        this.hNu.startLoad(optString, 25, false, false);
        this.hNv.setVisibility(0);
        this.hNv.setText(optJSONObject.optString("nick_name"));
        this.hNw.setVisibility(0);
        this.hNy.setVisibility(0);
        this.hNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hNC.w(PkRankEnterView.this.gzq.aKv.aIV.userId, optJSONObject.optLong("user_id"));
            }
        });
    }

    private void wM(int i) {
        if ((this.hNA == null || !this.hNA.isRunning()) && i > 0) {
            this.hNA = new com.baidu.tieba.ala.d(i * 1000, 1000L);
            this.hNA.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.9
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j) {
                    long round = Math.round(j / 1000.0d) % 60;
                    if (PkRankEnterView.this.status == 0 || PkRankEnterView.this.status == 3) {
                        PkRankEnterView.this.hNy.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_restart_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 4) {
                        PkRankEnterView.this.hNy.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_accept_time, String.valueOf(round)));
                    }
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankEnterView.this.hNA.cancelTimer();
                    PkRankEnterView.this.clZ();
                    PkRankEnterView.this.clV();
                }
            });
            this.hNA.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clY() {
        if (this.hNA != null) {
            this.hNA.cancelTimer();
            this.hNA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clZ() {
        setVisibility(0);
        if (this.hNr != this.status) {
            clY();
        }
        this.hNu.setVisibility(8);
        this.hNx.setVisibility(8);
        this.hNt.setVisibility(8);
        this.hNv.setVisibility(8);
        this.hNw.setVisibility(8);
        this.hNy.setVisibility(8);
    }

    public void onDestroy() {
        if (this.hNB != null) {
            this.hNB.ciV();
        }
        if (this.hNC != null) {
            this.hNC.ciK();
        }
        if (this.hND != null) {
            this.hND.ciQ();
        }
        if (this.gzq.getGetPkInfoModel() != null) {
            this.gzq.getGetPkInfoModel().ciT();
        }
        clY();
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gzq = pkRankView;
    }

    public void d(JSONObject jSONObject, int i) {
        if (this.gzq.wN(i) && i == 4) {
            this.hNB.ciW();
            clT();
            clY();
            this.gzq.cmC();
            clZ();
            this.hNr = i;
            this.status = i;
            dV(jSONObject);
        }
    }
}
