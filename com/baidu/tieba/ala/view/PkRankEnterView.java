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
    private PkRankView gjB;
    int huX;
    ImageView huY;
    ImageView huZ;
    HeadImageView hva;
    TextView hvb;
    TextView hvc;
    TextView hvd;
    Button hve;
    RelativeLayout hvf;
    com.baidu.tieba.ala.d hvg;
    p hvh;
    com.baidu.tieba.ala.g.a hvi;
    com.baidu.tieba.ala.g.k hvj;
    i hvk;
    private View mView;
    int status;

    public PkRankEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hvh = new p();
        this.hvi = new com.baidu.tieba.ala.g.a();
        this.hvj = new com.baidu.tieba.ala.g.k();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_enter_layout, (ViewGroup) this, true);
        this.hvf = (RelativeLayout) this.mView.findViewById(a.g.enter_container);
        this.hva = (HeadImageView) this.mView.findViewById(a.g.enter_head);
        this.hva.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.hva.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.hva.setIsRound(true);
        this.hva.setAutoChangeStyle(false);
        this.huY = (ImageView) this.mView.findViewById(a.g.enter_bg);
        this.huZ = (ImageView) this.mView.findViewById(a.g.enter_image);
        this.hvb = (TextView) this.mView.findViewById(a.g.invite_id);
        this.hvc = (TextView) this.mView.findViewById(a.g.invite_tip);
        this.hve = (Button) this.mView.findViewById(a.g.bottom_button);
        this.hvd = (TextView) this.mView.findViewById(a.g.matching_tip);
        this.hvi.a(new a.InterfaceC0616a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.1
            @Override // com.baidu.tieba.ala.g.a.InterfaceC0616a
            public void eG(long j) {
                PkRankEnterView.this.hvh.cds();
                PkRankEnterView.this.cgp();
                if (!PkRankEnterView.this.gjB.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.gjB.getGetPkInfoModel().a(PkRankEnterView.this.gjB.aIT.aHD.userId, j, PkRankEnterView.this.gjB.aIT.mLiveInfo.room_id, PkRankEnterView.this.gjB.aIT.mLiveInfo.live_id, PkRankEnterView.this.gjB.isHost ? 1 : 0);
                }
            }

            @Override // com.baidu.tieba.ala.g.a.InterfaceC0616a
            public void bi(int i, String str) {
            }
        });
        this.hvj.a(new k.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.2
            @Override // com.baidu.tieba.ala.g.k.a
            public void cdn() {
                PkRankEnterView.this.hvh.cds();
                PkRankEnterView.this.cgk();
                PkRankEnterView.this.wf(1);
            }

            @Override // com.baidu.tieba.ala.g.k.a
            public void bj(int i, String str) {
            }
        });
        this.hvh.a(new p.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.3
            @Override // com.baidu.tieba.ala.g.p.a
            public void eK(long j) {
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "match_success");
                alaStatsItem.addValue("pkId", Long.valueOf(j));
                AlaStatManager.getInstance().debug("pk_competition_start_pk", alaStatsItem);
                if (!PkRankEnterView.this.gjB.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.gjB.getGetPkInfoModel().a(PkRankEnterView.this.gjB.aIT.aHD.userId, j, PkRankEnterView.this.gjB.aIT.mLiveInfo.room_id, PkRankEnterView.this.gjB.aIT.mLiveInfo.live_id, PkRankEnterView.this.gjB.isHost ? 1 : 0);
                }
                PkRankEnterView.this.cgk();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void cdt() {
                PkRankEnterView.this.wf(3);
                PkRankEnterView.this.cgk();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void ai(ArrayList<String> arrayList) {
                PkRankEnterView.this.wf(2);
                PkRankEnterView.this.ak(arrayList);
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void bh(int i, String str) {
            }
        });
    }

    public void wf(int i) {
        this.status = i;
        if (this.gjB.wh(i)) {
            if (!this.gjB.isHost) {
                this.gjB.cgT();
                setVisibility(8);
                return;
            }
            this.gjB.cgT();
            cgq();
            switch (i) {
                case 0:
                    cgl();
                    break;
                case 1:
                    cgm();
                    break;
                case 2:
                    cgn();
                    break;
                case 3:
                    cgo();
                    break;
            }
            this.huX = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(ArrayList<String> arrayList) {
        if (this.hvk == null || !this.hvk.cgj()) {
            this.hvk = new i(arrayList, this.hva, this.hvf);
            this.hvk.tk();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cgk() {
        if (this.hvk != null) {
            this.hvk.cds();
        }
    }

    private void cgl() {
        wg(10);
        this.huZ.setVisibility(0);
        this.huZ.setImageResource(a.f.pk_rank_enter_view_again);
        this.huY.setImageResource(a.f.pk_rank_enter_view_black_bg);
        this.hve.setVisibility(0);
        this.hve.setText(a.i.sdk_pk_rank_restart);
        this.hve.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hvh.eJ(PkRankEnterView.this.gjB.aIT.aHD.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_rematch_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgm() {
        this.gjB.hwV = 1;
        this.status = 1;
        this.huX = 1;
        this.huZ.setVisibility(0);
        this.huZ.setImageResource(a.f.pk_rank_enter_view_main);
        this.huY.setImageResource(a.f.pk_rank_enter_view_bg);
        this.hve.setVisibility(0);
        this.hve.setText(a.i.sdk_pk_rank_start);
        this.hve.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hvh.eJ(PkRankEnterView.this.gjB.aIT.aHD.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_quick_start_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void cgn() {
        this.hva.setVisibility(0);
        this.huY.setImageResource(a.f.pk_rank_enter_view_black_bg);
        this.hvd.setVisibility(0);
        this.hve.setVisibility(0);
        this.hve.setText(a.i.sdk_pk_rank_matching_cancel);
        this.hve.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hvj.eI(PkRankEnterView.this.gjB.aIT.aHD.userId);
            }
        });
    }

    private void cgo() {
        wg(10);
        this.huZ.setVisibility(0);
        this.huZ.setImageResource(a.f.pk_rank_enter_view_fail);
        this.huY.setImageResource(a.f.pk_rank_enter_view_black_bg);
        this.hve.setVisibility(0);
        this.hve.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hvh.eJ(PkRankEnterView.this.gjB.aIT.aHD.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_match_filed_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void dJ(JSONObject jSONObject) {
        this.huY.setImageResource(a.f.pk_rank_enter_view_black_bg);
        wg(10);
        final JSONObject optJSONObject = jSONObject.optJSONObject("rival_anchor");
        String optString = optJSONObject.optString("bd_portrait");
        this.hva.setVisibility(0);
        this.hva.startLoad(optString, 25, false, false);
        this.hvb.setVisibility(0);
        this.hvb.setText(optJSONObject.optString("nick_name"));
        this.hvc.setVisibility(0);
        this.hve.setVisibility(0);
        this.hve.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hvi.v(PkRankEnterView.this.gjB.aIT.aHD.userId, optJSONObject.optLong("user_id"));
            }
        });
    }

    private void wg(int i) {
        if ((this.hvg == null || !this.hvg.isRunning()) && i > 0) {
            this.hvg = new com.baidu.tieba.ala.d(i * 1000, 1000L);
            this.hvg.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.9
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j) {
                    long round = Math.round(j / 1000.0d) % 60;
                    if (PkRankEnterView.this.status == 0 || PkRankEnterView.this.status == 3) {
                        PkRankEnterView.this.hve.setText(PkRankEnterView.this.context.getString(a.i.sdk_pk_rank_restart_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 4) {
                        PkRankEnterView.this.hve.setText(PkRankEnterView.this.context.getString(a.i.sdk_pk_rank_accept_time, String.valueOf(round)));
                    }
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankEnterView.this.hvg.cancelTimer();
                    PkRankEnterView.this.cgq();
                    PkRankEnterView.this.cgm();
                }
            });
            this.hvg.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgp() {
        if (this.hvg != null) {
            this.hvg.cancelTimer();
            this.hvg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgq() {
        setVisibility(0);
        if (this.huX != this.status) {
            cgp();
        }
        this.hva.setVisibility(8);
        this.hvd.setVisibility(8);
        this.huZ.setVisibility(8);
        this.hvb.setVisibility(8);
        this.hvc.setVisibility(8);
        this.hve.setVisibility(8);
    }

    public void onDestroy() {
        if (this.hvh != null) {
            this.hvh.cdr();
        }
        if (this.hvi != null) {
            this.hvi.cdd();
        }
        if (this.hvj != null) {
            this.hvj.cdm();
        }
        if (this.gjB.getGetPkInfoModel() != null) {
            this.gjB.getGetPkInfoModel().cdp();
        }
        cgp();
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gjB = pkRankView;
    }

    public void d(JSONObject jSONObject, int i) {
        if (this.gjB.wh(i) && i == 4) {
            this.hvh.cds();
            cgk();
            cgp();
            this.gjB.cgT();
            cgq();
            this.huX = i;
            this.status = i;
            dJ(jSONObject);
        }
    }
}
