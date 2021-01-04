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
import com.baidu.tieba.ala.e;
import com.baidu.tieba.ala.g.a;
import com.baidu.tieba.ala.g.k;
import com.baidu.tieba.ala.g.p;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PkRankEnterView extends RelativeLayout {
    Context context;
    private PkRankView gTH;
    Button ikA;
    RelativeLayout ikB;
    com.baidu.tieba.ala.e ikC;
    p ikD;
    com.baidu.tieba.ala.g.a ikE;
    com.baidu.tieba.ala.g.k ikF;
    i ikG;
    int ikt;
    ImageView iku;
    ImageView ikv;
    HeadImageView ikw;
    TextView ikx;
    TextView iky;
    TextView ikz;
    private View mView;
    int status;

    public PkRankEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ikD = new p();
        this.ikE = new com.baidu.tieba.ala.g.a();
        this.ikF = new com.baidu.tieba.ala.g.k();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_enter_layout, (ViewGroup) this, true);
        this.ikB = (RelativeLayout) this.mView.findViewById(a.f.enter_container);
        this.ikw = (HeadImageView) this.mView.findViewById(a.f.enter_head);
        this.ikw.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.ikw.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.ikw.setIsRound(true);
        this.ikw.setAutoChangeStyle(false);
        this.iku = (ImageView) this.mView.findViewById(a.f.enter_bg);
        this.ikv = (ImageView) this.mView.findViewById(a.f.enter_image);
        this.ikx = (TextView) this.mView.findViewById(a.f.invite_id);
        this.iky = (TextView) this.mView.findViewById(a.f.invite_tip);
        this.ikA = (Button) this.mView.findViewById(a.f.bottom_button);
        this.ikz = (TextView) this.mView.findViewById(a.f.matching_tip);
        this.ikE.a(new a.InterfaceC0648a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.1
            @Override // com.baidu.tieba.ala.g.a.InterfaceC0648a
            public void fI(long j) {
                PkRankEnterView.this.ikD.cpb();
                PkRankEnterView.this.csA();
                if (!PkRankEnterView.this.gTH.getGetPkInfoModel().aLf()) {
                    PkRankEnterView.this.gTH.getGetPkInfoModel().a(PkRankEnterView.this.gTH.aMh.aKu.userId, j, PkRankEnterView.this.gTH.aMh.mLiveInfo.room_id, PkRankEnterView.this.gTH.aMh.mLiveInfo.live_id, PkRankEnterView.this.gTH.isHost ? 1 : 0);
                }
            }

            @Override // com.baidu.tieba.ala.g.a.InterfaceC0648a
            public void bo(int i, String str) {
            }
        });
        this.ikF.a(new k.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.2
            @Override // com.baidu.tieba.ala.g.k.a
            public void coW() {
                PkRankEnterView.this.ikD.cpb();
                PkRankEnterView.this.csv();
                PkRankEnterView.this.yc(1);
            }

            @Override // com.baidu.tieba.ala.g.k.a
            public void bp(int i, String str) {
            }
        });
        this.ikD.a(new p.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.3
            @Override // com.baidu.tieba.ala.g.p.a
            public void fM(long j) {
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
                if (!PkRankEnterView.this.gTH.getGetPkInfoModel().aLf()) {
                    PkRankEnterView.this.gTH.getGetPkInfoModel().a(PkRankEnterView.this.gTH.aMh.aKu.userId, j, PkRankEnterView.this.gTH.aMh.mLiveInfo.room_id, PkRankEnterView.this.gTH.aMh.mLiveInfo.live_id, PkRankEnterView.this.gTH.isHost ? 1 : 0);
                }
                PkRankEnterView.this.csv();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void cpc() {
                PkRankEnterView.this.yc(3);
                PkRankEnterView.this.csv();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void ak(ArrayList<String> arrayList) {
                PkRankEnterView.this.yc(2);
                PkRankEnterView.this.am(arrayList);
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void bn(int i, String str) {
            }
        });
    }

    public void yc(int i) {
        this.status = i;
        if (this.gTH.ye(i)) {
            if (!this.gTH.isHost) {
                this.gTH.ctc();
                setVisibility(8);
                return;
            }
            this.gTH.ctc();
            csB();
            switch (i) {
                case 0:
                    csw();
                    break;
                case 1:
                    csx();
                    break;
                case 2:
                    csy();
                    break;
                case 3:
                    csz();
                    break;
            }
            this.ikt = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(ArrayList<String> arrayList) {
        if (this.ikG == null || !this.ikG.csu()) {
            this.ikG = new i(arrayList, this.ikw, this.ikB);
            this.ikG.sN();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void csv() {
        if (this.ikG != null) {
            this.ikG.cpb();
        }
    }

    private void csw() {
        yd(10);
        this.ikv.setVisibility(0);
        this.ikv.setImageResource(a.e.pk_rank_enter_view_again);
        this.iku.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.ikA.setVisibility(0);
        this.ikA.setText(a.h.sdk_pk_rank_restart);
        this.ikA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ikD.fL(PkRankEnterView.this.gTH.aMh.aKu.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_rematch_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_rematch_btn_click"));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csx() {
        this.gTH.imp = 1;
        this.status = 1;
        this.ikt = 1;
        this.ikv.setVisibility(0);
        this.ikv.setImageResource(a.e.pk_rank_enter_view_main);
        this.iku.setImageResource(a.e.pk_rank_enter_view_bg);
        this.ikA.setVisibility(0);
        this.ikA.setText(a.h.sdk_pk_rank_start);
        this.ikA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ikD.fL(PkRankEnterView.this.gTH.aMh.aKu.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_quick_start_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_quick_start_btn_click"));
            }
        });
    }

    private void csy() {
        this.ikw.setVisibility(0);
        this.iku.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.ikz.setVisibility(0);
        this.ikA.setVisibility(0);
        this.ikA.setText(a.h.sdk_pk_rank_matching_cancel);
        this.ikA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ikF.fK(PkRankEnterView.this.gTH.aMh.aKu.userId);
            }
        });
    }

    private void csz() {
        yd(10);
        this.ikv.setVisibility(0);
        this.ikv.setImageResource(a.e.pk_rank_enter_view_fail);
        this.iku.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.ikA.setVisibility(0);
        this.ikA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ikD.fL(PkRankEnterView.this.gTH.aMh.aKu.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_match_filed_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_match_filed_btn_click"));
            }
        });
    }

    private void ef(JSONObject jSONObject) {
        this.iku.setImageResource(a.e.pk_rank_enter_view_black_bg);
        yd(10);
        final JSONObject optJSONObject = jSONObject.optJSONObject("rival_anchor");
        String optString = optJSONObject.optString("bd_portrait");
        this.ikw.setVisibility(0);
        this.ikw.startLoad(optString, 25, false, false);
        this.ikx.setVisibility(0);
        this.ikx.setText(optJSONObject.optString("nick_name"));
        this.iky.setVisibility(0);
        this.ikA.setVisibility(0);
        this.ikA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ikE.z(PkRankEnterView.this.gTH.aMh.aKu.userId, optJSONObject.optLong("user_id"));
            }
        });
    }

    private void yd(int i) {
        if ((this.ikC == null || !this.ikC.isRunning()) && i > 0) {
            this.ikC = new com.baidu.tieba.ala.e(i * 1000, 1000L);
            this.ikC.a(new e.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.9
                @Override // com.baidu.tieba.ala.e.a
                public void onTick(long j) {
                    long round = Math.round(j / 1000.0d) % 60;
                    if (PkRankEnterView.this.status == 0 || PkRankEnterView.this.status == 3) {
                        PkRankEnterView.this.ikA.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_restart_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 4) {
                        PkRankEnterView.this.ikA.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_accept_time, String.valueOf(round)));
                    }
                }

                @Override // com.baidu.tieba.ala.e.a
                public void onFinish() {
                    PkRankEnterView.this.ikC.cancelTimer();
                    PkRankEnterView.this.csB();
                    PkRankEnterView.this.csx();
                }
            });
            this.ikC.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csA() {
        if (this.ikC != null) {
            this.ikC.cancelTimer();
            this.ikC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csB() {
        setVisibility(0);
        if (this.ikt != this.status) {
            csA();
        }
        this.ikw.setVisibility(8);
        this.ikz.setVisibility(8);
        this.ikv.setVisibility(8);
        this.ikx.setVisibility(8);
        this.iky.setVisibility(8);
        this.ikA.setVisibility(8);
    }

    public void onDestroy() {
        if (this.ikD != null) {
            this.ikD.cpa();
        }
        if (this.ikE != null) {
            this.ikE.coQ();
        }
        if (this.ikF != null) {
            this.ikF.coV();
        }
        if (this.gTH.getGetPkInfoModel() != null) {
            this.gTH.getGetPkInfoModel().coY();
        }
        csA();
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gTH = pkRankView;
    }

    public void d(JSONObject jSONObject, int i) {
        if (this.gTH.ye(i) && i == 4) {
            this.ikD.cpb();
            csv();
            csA();
            this.gTH.ctc();
            csB();
            this.ikt = i;
            this.status = i;
            ef(jSONObject);
        }
    }
}
