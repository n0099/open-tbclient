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
    private PkRankView fXi;
    int hgc;
    ImageView hgd;
    ImageView hge;
    HeadImageView hgf;
    TextView hgg;
    TextView hgh;
    TextView hgi;
    Button hgj;
    RelativeLayout hgk;
    com.baidu.tieba.ala.d hgl;
    p hgm;
    com.baidu.tieba.ala.g.a hgn;
    com.baidu.tieba.ala.g.k hgo;
    i hgp;
    private View mView;
    int status;

    public PkRankEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hgm = new p();
        this.hgn = new com.baidu.tieba.ala.g.a();
        this.hgo = new com.baidu.tieba.ala.g.k();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_rank_enter_layout, (ViewGroup) this, true);
        this.hgk = (RelativeLayout) this.mView.findViewById(a.g.enter_container);
        this.hgf = (HeadImageView) this.mView.findViewById(a.g.enter_head);
        this.hgf.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.hgf.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.hgf.setIsRound(true);
        this.hgf.setAutoChangeStyle(false);
        this.hgd = (ImageView) this.mView.findViewById(a.g.enter_bg);
        this.hge = (ImageView) this.mView.findViewById(a.g.enter_image);
        this.hgg = (TextView) this.mView.findViewById(a.g.invite_id);
        this.hgh = (TextView) this.mView.findViewById(a.g.invite_tip);
        this.hgj = (Button) this.mView.findViewById(a.g.bottom_button);
        this.hgi = (TextView) this.mView.findViewById(a.g.matching_tip);
        this.hgn.a(new a.InterfaceC0599a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.1
            @Override // com.baidu.tieba.ala.g.a.InterfaceC0599a
            public void ep(long j) {
                PkRankEnterView.this.hgm.bZU();
                PkRankEnterView.this.ccT();
                if (!PkRankEnterView.this.fXi.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.fXi.getGetPkInfoModel().a(PkRankEnterView.this.fXi.aFP.aEz.userId, j, PkRankEnterView.this.fXi.aFP.mLiveInfo.room_id, PkRankEnterView.this.fXi.aFP.mLiveInfo.live_id, PkRankEnterView.this.fXi.isHost ? 1 : 0);
                }
            }

            @Override // com.baidu.tieba.ala.g.a.InterfaceC0599a
            public void aY(int i, String str) {
            }
        });
        this.hgo.a(new k.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.2
            @Override // com.baidu.tieba.ala.g.k.a
            public void bZP() {
                PkRankEnterView.this.hgm.bZU();
                PkRankEnterView.this.ccO();
                PkRankEnterView.this.vz(1);
            }

            @Override // com.baidu.tieba.ala.g.k.a
            public void aZ(int i, String str) {
            }
        });
        this.hgm.a(new p.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.3
            @Override // com.baidu.tieba.ala.g.p.a
            public void et(long j) {
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "match_success");
                alaStatsItem.addValue("pkId", Long.valueOf(j));
                AlaStatManager.getInstance().debug("pk_competition_start_pk", alaStatsItem);
                if (!PkRankEnterView.this.fXi.getGetPkInfoModel().isLoop()) {
                    PkRankEnterView.this.fXi.getGetPkInfoModel().a(PkRankEnterView.this.fXi.aFP.aEz.userId, j, PkRankEnterView.this.fXi.aFP.mLiveInfo.room_id, PkRankEnterView.this.fXi.aFP.mLiveInfo.live_id, PkRankEnterView.this.fXi.isHost ? 1 : 0);
                }
                PkRankEnterView.this.ccO();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void bZV() {
                PkRankEnterView.this.vz(3);
                PkRankEnterView.this.ccO();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void ai(ArrayList<String> arrayList) {
                PkRankEnterView.this.vz(2);
                PkRankEnterView.this.ak(arrayList);
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void aX(int i, String str) {
            }
        });
    }

    public void vz(int i) {
        this.status = i;
        if (this.fXi.vB(i)) {
            if (!this.fXi.isHost) {
                this.fXi.cdx();
                setVisibility(8);
                return;
            }
            this.fXi.cdx();
            ccU();
            switch (i) {
                case 0:
                    ccP();
                    break;
                case 1:
                    ccQ();
                    break;
                case 2:
                    ccR();
                    break;
                case 3:
                    ccS();
                    break;
            }
            this.hgc = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(ArrayList<String> arrayList) {
        if (this.hgp == null || !this.hgp.ccN()) {
            this.hgp = new i(arrayList, this.hgf, this.hgk);
            this.hgp.tk();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ccO() {
        if (this.hgp != null) {
            this.hgp.bZU();
        }
    }

    private void ccP() {
        vA(10);
        this.hge.setVisibility(0);
        this.hge.setImageResource(a.f.pk_rank_enter_view_again);
        this.hgd.setImageResource(a.f.pk_rank_enter_view_black_bg);
        this.hgj.setVisibility(0);
        this.hgj.setText(a.i.sdk_pk_rank_restart);
        this.hgj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hgm.es(PkRankEnterView.this.fXi.aFP.aEz.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_rematch_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccQ() {
        this.fXi.hhZ = 1;
        this.status = 1;
        this.hgc = 1;
        this.hge.setVisibility(0);
        this.hge.setImageResource(a.f.pk_rank_enter_view_main);
        this.hgd.setImageResource(a.f.pk_rank_enter_view_bg);
        this.hgj.setVisibility(0);
        this.hgj.setText(a.i.sdk_pk_rank_start);
        this.hgj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hgm.es(PkRankEnterView.this.fXi.aFP.aEz.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_quick_start_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void ccR() {
        this.hgf.setVisibility(0);
        this.hgd.setImageResource(a.f.pk_rank_enter_view_black_bg);
        this.hgi.setVisibility(0);
        this.hgj.setVisibility(0);
        this.hgj.setText(a.i.sdk_pk_rank_matching_cancel);
        this.hgj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hgo.er(PkRankEnterView.this.fXi.aFP.aEz.userId);
            }
        });
    }

    private void ccS() {
        vA(10);
        this.hge.setVisibility(0);
        this.hge.setImageResource(a.f.pk_rank_enter_view_fail);
        this.hgd.setImageResource(a.f.pk_rank_enter_view_black_bg);
        this.hgj.setVisibility(0);
        this.hgj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hgm.es(PkRankEnterView.this.fXi.aFP.aEz.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_match_filed_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
            }
        });
    }

    private void dE(JSONObject jSONObject) {
        this.hgd.setImageResource(a.f.pk_rank_enter_view_black_bg);
        vA(10);
        final JSONObject optJSONObject = jSONObject.optJSONObject("rival_anchor");
        String optString = optJSONObject.optString("bd_portrait");
        this.hgf.setVisibility(0);
        this.hgf.startLoad(optString, 25, false, false);
        this.hgg.setVisibility(0);
        this.hgg.setText(optJSONObject.optString("nick_name"));
        this.hgh.setVisibility(0);
        this.hgj.setVisibility(0);
        this.hgj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.hgn.v(PkRankEnterView.this.fXi.aFP.aEz.userId, optJSONObject.optLong("user_id"));
            }
        });
    }

    private void vA(int i) {
        if ((this.hgl == null || !this.hgl.isRunning()) && i > 0) {
            this.hgl = new com.baidu.tieba.ala.d(i * 1000, 1000L);
            this.hgl.a(new d.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.9
                @Override // com.baidu.tieba.ala.d.a
                public void onTick(long j) {
                    long round = Math.round(j / 1000.0d) % 60;
                    if (PkRankEnterView.this.status == 0 || PkRankEnterView.this.status == 3) {
                        PkRankEnterView.this.hgj.setText(PkRankEnterView.this.context.getString(a.i.sdk_pk_rank_restart_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 4) {
                        PkRankEnterView.this.hgj.setText(PkRankEnterView.this.context.getString(a.i.sdk_pk_rank_accept_time, String.valueOf(round)));
                    }
                }

                @Override // com.baidu.tieba.ala.d.a
                public void onFinish() {
                    PkRankEnterView.this.hgl.cancelTimer();
                    PkRankEnterView.this.ccU();
                    PkRankEnterView.this.ccQ();
                }
            });
            this.hgl.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccT() {
        if (this.hgl != null) {
            this.hgl.cancelTimer();
            this.hgl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccU() {
        setVisibility(0);
        if (this.hgc != this.status) {
            ccT();
        }
        this.hgf.setVisibility(8);
        this.hgi.setVisibility(8);
        this.hge.setVisibility(8);
        this.hgg.setVisibility(8);
        this.hgh.setVisibility(8);
        this.hgj.setVisibility(8);
    }

    public void onDestroy() {
        if (this.hgm != null) {
            this.hgm.bZT();
        }
        if (this.hgn != null) {
            this.hgn.bZF();
        }
        if (this.hgo != null) {
            this.hgo.bZO();
        }
        if (this.fXi.getGetPkInfoModel() != null) {
            this.fXi.getGetPkInfoModel().bZR();
        }
        ccT();
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.fXi = pkRankView;
    }

    public void c(JSONObject jSONObject, int i) {
        if (this.fXi.vB(i) && i == 4) {
            this.hgm.bZU();
            ccO();
            ccT();
            this.fXi.cdx();
            ccU();
            this.hgc = i;
            this.status = i;
            dE(jSONObject);
        }
    }
}
