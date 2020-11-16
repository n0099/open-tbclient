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
    private PkRankView gyX;
    int hMY;
    ImageView hMZ;
    ImageView hNa;
    HeadImageView hNb;
    TextView hNc;
    TextView hNd;
    TextView hNe;
    Button hNf;
    RelativeLayout hNg;
    com.baidu.tieba.ala.d hNh;
    p hNi;
    com.baidu.tieba.ala.g.a hNj;
    com.baidu.tieba.ala.g.k hNk;
    i hNl;
    private View mView;
    int status;

    public PkRankEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNi = new p();
        this.hNj = new com.baidu.tieba.ala.g.a();
        this.hNk = new com.baidu.tieba.ala.g.k();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_enter_layout, (ViewGroup) this, true);
        this.hNg = (RelativeLayout) this.mView.findViewById(a.f.enter_container);
        this.hNb = (HeadImageView) this.mView.findViewById(a.f.enter_head);
        this.hNb.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hNb.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.hNb.setIsRound(true);
        this.hNb.setAutoChangeStyle(false);
        this.hMZ = (ImageView) this.mView.findViewById(a.f.enter_bg);
        this.hNa = (ImageView) this.mView.findViewById(a.f.enter_image);
        this.hNc = (TextView) this.mView.findViewById(a.f.invite_id);
        this.hNd = (TextView) this.mView.findViewById(a.f.invite_tip);
        this.hNf = (Button) this.mView.findViewById(a.f.bottom_button);
        this.hNe = (TextView) this.mView.findViewById(a.f.matching_tip);
        this.hNj.a(new a.InterfaceC0644a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.1
            @Override // com.baidu.tieba.ala.g.a.InterfaceC0644a
            public void fe(long j) {
                PkRankEnterView.this.hNi.cip();
                PkRankEnterView.this.clr();
                if (!PkRankEnterView.this.gyX.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.gyX.getGetPkInfoModel().a(PkRankEnterView.this.gyX.aIK.aHk.userId, j, PkRankEnterView.this.gyX.aIK.mLiveInfo.room_id, PkRankEnterView.this.gyX.aIK.mLiveInfo.live_id, PkRankEnterView.this.gyX.isHost ? 1 : 0);
                }
            }

            @Override // com.baidu.tieba.ala.g.a.InterfaceC0644a
            public void bm(int i, String str) {
            }
        });
        this.hNk.a(new k.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.2
            @Override // com.baidu.tieba.ala.g.k.a
            public void cik() {
                PkRankEnterView.this.hNi.cip();
                PkRankEnterView.this.clm();
                PkRankEnterView.this.xj(1);
            }

            @Override // com.baidu.tieba.ala.g.k.a
            public void bn(int i, String str) {
            }
        });
        this.hNi.a(new p.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.3
            @Override // com.baidu.tieba.ala.g.p.a
            public void fi(long j) {
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "match_success");
                alaStatsItem.addValue("pkId", Long.valueOf(j));
                AlaStatManager.getInstance().debug("pk_competition_start_pk", alaStatsItem);
                if (!PkRankEnterView.this.gyX.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.gyX.getGetPkInfoModel().a(PkRankEnterView.this.gyX.aIK.aHk.userId, j, PkRankEnterView.this.gyX.aIK.mLiveInfo.room_id, PkRankEnterView.this.gyX.aIK.mLiveInfo.live_id, PkRankEnterView.this.gyX.isHost ? 1 : 0);
                }
                PkRankEnterView.this.clm();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void ciq() {
                PkRankEnterView.this.xj(3);
                PkRankEnterView.this.clm();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void aj(ArrayList<String> arrayList) {
                PkRankEnterView.this.xj(2);
                PkRankEnterView.this.al(arrayList);
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void bl(int i, String str) {
            }
        });
    }

    public void xj(int i) {
        this.status = i;
        if (this.gyX.xl(i)) {
            if (!this.gyX.isHost) {
                this.gyX.clV();
                setVisibility(8);
                return;
            }
            this.gyX.clV();
            cls();
            switch (i) {
                case 0:
                    cln();
                    break;
                case 1:
                    clo();
                    break;
                case 2:
                    clp();
                    break;
                case 3:
                    clq();
                    break;
            }
            this.hMY = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(ArrayList<String> arrayList) {
        if (this.hNl == null || !this.hNl.cll()) {
            this.hNl = new i(arrayList, this.hNb, this.hNg);
            this.hNl.tk();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clm() {
        if (this.hNl != null) {
            this.hNl.cip();
        }
    }

    private void cln() {
        xk(10);
        this.hNa.setVisibility(0);
        this.hNa.setImageResource(a.e.pk_rank_enter_view_again);
        this.hMZ.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.hNf.setVisibility(0);
        this.hNf.setText(a.h.sdk_pk_rank_restart);
        this.hNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hNi.fh(PkRankEnterView.this.gyX.aIK.aHk.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_rematch_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clo() {
        this.gyX.hOW = 1;
        this.status = 1;
        this.hMY = 1;
        this.hNa.setVisibility(0);
        this.hNa.setImageResource(a.e.pk_rank_enter_view_main);
        this.hMZ.setImageResource(a.e.pk_rank_enter_view_bg);
        this.hNf.setVisibility(0);
        this.hNf.setText(a.h.sdk_pk_rank_start);
        this.hNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hNi.fh(PkRankEnterView.this.gyX.aIK.aHk.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_quick_start_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void clp() {
        this.hNb.setVisibility(0);
        this.hMZ.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.hNe.setVisibility(0);
        this.hNf.setVisibility(0);
        this.hNf.setText(a.h.sdk_pk_rank_matching_cancel);
        this.hNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hNk.fg(PkRankEnterView.this.gyX.aIK.aHk.userId);
            }
        });
    }

    private void clq() {
        xk(10);
        this.hNa.setVisibility(0);
        this.hNa.setImageResource(a.e.pk_rank_enter_view_fail);
        this.hMZ.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.hNf.setVisibility(0);
        this.hNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hNi.fh(PkRankEnterView.this.gyX.aIK.aHk.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_match_filed_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void dP(JSONObject jSONObject) {
        this.hMZ.setImageResource(a.e.pk_rank_enter_view_black_bg);
        xk(10);
        final JSONObject optJSONObject = jSONObject.optJSONObject("rival_anchor");
        String optString = optJSONObject.optString("bd_portrait");
        this.hNb.setVisibility(0);
        this.hNb.startLoad(optString, 25, false, false);
        this.hNc.setVisibility(0);
        this.hNc.setText(optJSONObject.optString("nick_name"));
        this.hNd.setVisibility(0);
        this.hNf.setVisibility(0);
        this.hNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hNj.w(PkRankEnterView.this.gyX.aIK.aHk.userId, optJSONObject.optLong("user_id"));
            }
        });
    }

    private void xk(int i) {
        if ((this.hNh == null || !this.hNh.isRunning()) && i > 0) {
            this.hNh = new com.baidu.tieba.ala.d(i * 1000, 1000L);
            this.hNh.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.9
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j) {
                    long round = Math.round(j / 1000.0d) % 60;
                    if (PkRankEnterView.this.status == 0 || PkRankEnterView.this.status == 3) {
                        PkRankEnterView.this.hNf.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_restart_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 4) {
                        PkRankEnterView.this.hNf.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_accept_time, String.valueOf(round)));
                    }
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankEnterView.this.hNh.cancelTimer();
                    PkRankEnterView.this.cls();
                    PkRankEnterView.this.clo();
                }
            });
            this.hNh.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clr() {
        if (this.hNh != null) {
            this.hNh.cancelTimer();
            this.hNh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cls() {
        setVisibility(0);
        if (this.hMY != this.status) {
            clr();
        }
        this.hNb.setVisibility(8);
        this.hNe.setVisibility(8);
        this.hNa.setVisibility(8);
        this.hNc.setVisibility(8);
        this.hNd.setVisibility(8);
        this.hNf.setVisibility(8);
    }

    public void onDestroy() {
        if (this.hNi != null) {
            this.hNi.cio();
        }
        if (this.hNj != null) {
            this.hNj.cid();
        }
        if (this.hNk != null) {
            this.hNk.cij();
        }
        if (this.gyX.getGetPkInfoModel() != null) {
            this.gyX.getGetPkInfoModel().cim();
        }
        clr();
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gyX = pkRankView;
    }

    public void d(JSONObject jSONObject, int i) {
        if (this.gyX.xl(i) && i == 4) {
            this.hNi.cip();
            clm();
            clr();
            this.gyX.clV();
            cls();
            this.hMY = i;
            this.status = i;
            dP(jSONObject);
        }
    }
}
