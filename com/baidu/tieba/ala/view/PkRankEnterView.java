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
/* loaded from: classes10.dex */
public class PkRankEnterView extends RelativeLayout {
    Context context;
    private PkRankView gPb;
    int ifM;
    ImageView ifN;
    ImageView ifO;
    HeadImageView ifP;
    TextView ifQ;
    TextView ifR;
    TextView ifS;
    Button ifT;
    RelativeLayout ifU;
    com.baidu.tieba.ala.e ifV;
    p ifW;
    com.baidu.tieba.ala.g.a ifX;
    com.baidu.tieba.ala.g.k ifY;
    i ifZ;
    private View mView;
    int status;

    public PkRankEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ifW = new p();
        this.ifX = new com.baidu.tieba.ala.g.a();
        this.ifY = new com.baidu.tieba.ala.g.k();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_enter_layout, (ViewGroup) this, true);
        this.ifU = (RelativeLayout) this.mView.findViewById(a.f.enter_container);
        this.ifP = (HeadImageView) this.mView.findViewById(a.f.enter_head);
        this.ifP.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        this.ifP.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        this.ifP.setIsRound(true);
        this.ifP.setAutoChangeStyle(false);
        this.ifN = (ImageView) this.mView.findViewById(a.f.enter_bg);
        this.ifO = (ImageView) this.mView.findViewById(a.f.enter_image);
        this.ifQ = (TextView) this.mView.findViewById(a.f.invite_id);
        this.ifR = (TextView) this.mView.findViewById(a.f.invite_tip);
        this.ifT = (Button) this.mView.findViewById(a.f.bottom_button);
        this.ifS = (TextView) this.mView.findViewById(a.f.matching_tip);
        this.ifX.a(new a.InterfaceC0631a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.1
            @Override // com.baidu.tieba.ala.g.a.InterfaceC0631a
            public void fI(long j) {
                PkRankEnterView.this.ifW.clk();
                PkRankEnterView.this.coJ();
                if (!PkRankEnterView.this.gPb.getGetPkInfoModel().aHm()) {
                    PkRankEnterView.this.gPb.getGetPkInfoModel().a(PkRankEnterView.this.gPb.aHu.aFH.userId, j, PkRankEnterView.this.gPb.aHu.mLiveInfo.room_id, PkRankEnterView.this.gPb.aHu.mLiveInfo.live_id, PkRankEnterView.this.gPb.isHost ? 1 : 0);
                }
            }

            @Override // com.baidu.tieba.ala.g.a.InterfaceC0631a
            public void bp(int i, String str) {
            }
        });
        this.ifY.a(new k.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.2
            @Override // com.baidu.tieba.ala.g.k.a
            public void clf() {
                PkRankEnterView.this.ifW.clk();
                PkRankEnterView.this.coE();
                PkRankEnterView.this.ww(1);
            }

            @Override // com.baidu.tieba.ala.g.k.a
            public void bq(int i, String str) {
            }
        });
        this.ifW.a(new p.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.3
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
                if (!PkRankEnterView.this.gPb.getGetPkInfoModel().aHm()) {
                    PkRankEnterView.this.gPb.getGetPkInfoModel().a(PkRankEnterView.this.gPb.aHu.aFH.userId, j, PkRankEnterView.this.gPb.aHu.mLiveInfo.room_id, PkRankEnterView.this.gPb.aHu.mLiveInfo.live_id, PkRankEnterView.this.gPb.isHost ? 1 : 0);
                }
                PkRankEnterView.this.coE();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void cll() {
                PkRankEnterView.this.ww(3);
                PkRankEnterView.this.coE();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void af(ArrayList<String> arrayList) {
                PkRankEnterView.this.ww(2);
                PkRankEnterView.this.ah(arrayList);
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void bo(int i, String str) {
            }
        });
    }

    public void ww(int i) {
        this.status = i;
        if (this.gPb.wy(i)) {
            if (!this.gPb.isHost) {
                this.gPb.cpl();
                setVisibility(8);
                return;
            }
            this.gPb.cpl();
            coK();
            switch (i) {
                case 0:
                    coF();
                    break;
                case 1:
                    coG();
                    break;
                case 2:
                    coH();
                    break;
                case 3:
                    coI();
                    break;
            }
            this.ifM = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(ArrayList<String> arrayList) {
        if (this.ifZ == null || !this.ifZ.coD()) {
            this.ifZ = new i(arrayList, this.ifP, this.ifU);
            this.ifZ.sC();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void coE() {
        if (this.ifZ != null) {
            this.ifZ.clk();
        }
    }

    private void coF() {
        wx(10);
        this.ifO.setVisibility(0);
        this.ifO.setImageResource(a.e.pk_rank_enter_view_again);
        this.ifN.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.ifT.setVisibility(0);
        this.ifT.setText(a.h.sdk_pk_rank_restart);
        this.ifT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ifW.fL(PkRankEnterView.this.gPb.aHu.aFH.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_rematch_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_rematch_btn_click"));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coG() {
        this.gPb.ihH = 1;
        this.status = 1;
        this.ifM = 1;
        this.ifO.setVisibility(0);
        this.ifO.setImageResource(a.e.pk_rank_enter_view_main);
        this.ifN.setImageResource(a.e.pk_rank_enter_view_bg);
        this.ifT.setVisibility(0);
        this.ifT.setText(a.h.sdk_pk_rank_start);
        this.ifT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ifW.fL(PkRankEnterView.this.gPb.aHu.aFH.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_quick_start_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_quick_start_btn_click"));
            }
        });
    }

    private void coH() {
        this.ifP.setVisibility(0);
        this.ifN.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.ifS.setVisibility(0);
        this.ifT.setVisibility(0);
        this.ifT.setText(a.h.sdk_pk_rank_matching_cancel);
        this.ifT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ifY.fK(PkRankEnterView.this.gPb.aHu.aFH.userId);
            }
        });
    }

    private void coI() {
        wx(10);
        this.ifO.setVisibility(0);
        this.ifO.setImageResource(a.e.pk_rank_enter_view_fail);
        this.ifN.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.ifT.setVisibility(0);
        this.ifT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ifW.fL(PkRankEnterView.this.gPb.aHu.aFH.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_match_filed_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_match_filed_btn_click"));
            }
        });
    }

    private void ef(JSONObject jSONObject) {
        this.ifN.setImageResource(a.e.pk_rank_enter_view_black_bg);
        wx(10);
        final JSONObject optJSONObject = jSONObject.optJSONObject("rival_anchor");
        String optString = optJSONObject.optString("bd_portrait");
        this.ifP.setVisibility(0);
        this.ifP.startLoad(optString, 25, false, false);
        this.ifQ.setVisibility(0);
        this.ifQ.setText(optJSONObject.optString("nick_name"));
        this.ifR.setVisibility(0);
        this.ifT.setVisibility(0);
        this.ifT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.ifX.z(PkRankEnterView.this.gPb.aHu.aFH.userId, optJSONObject.optLong("user_id"));
            }
        });
    }

    private void wx(int i) {
        if ((this.ifV == null || !this.ifV.isRunning()) && i > 0) {
            this.ifV = new com.baidu.tieba.ala.e(i * 1000, 1000L);
            this.ifV.a(new e.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.9
                @Override // com.baidu.tieba.ala.e.a
                public void onTick(long j) {
                    long round = Math.round(j / 1000.0d) % 60;
                    if (PkRankEnterView.this.status == 0 || PkRankEnterView.this.status == 3) {
                        PkRankEnterView.this.ifT.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_restart_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 4) {
                        PkRankEnterView.this.ifT.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_accept_time, String.valueOf(round)));
                    }
                }

                @Override // com.baidu.tieba.ala.e.a
                public void onFinish() {
                    PkRankEnterView.this.ifV.cancelTimer();
                    PkRankEnterView.this.coK();
                    PkRankEnterView.this.coG();
                }
            });
            this.ifV.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coJ() {
        if (this.ifV != null) {
            this.ifV.cancelTimer();
            this.ifV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coK() {
        setVisibility(0);
        if (this.ifM != this.status) {
            coJ();
        }
        this.ifP.setVisibility(8);
        this.ifS.setVisibility(8);
        this.ifO.setVisibility(8);
        this.ifQ.setVisibility(8);
        this.ifR.setVisibility(8);
        this.ifT.setVisibility(8);
    }

    public void onDestroy() {
        if (this.ifW != null) {
            this.ifW.clj();
        }
        if (this.ifX != null) {
            this.ifX.ckZ();
        }
        if (this.ifY != null) {
            this.ifY.cle();
        }
        if (this.gPb.getGetPkInfoModel() != null) {
            this.gPb.getGetPkInfoModel().clh();
        }
        coJ();
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gPb = pkRankView;
    }

    public void d(JSONObject jSONObject, int i) {
        if (this.gPb.wy(i) && i == 4) {
            this.ifW.clk();
            coE();
            coJ();
            this.gPb.cpl();
            coK();
            this.ifM = i;
            this.status = i;
            ef(jSONObject);
        }
    }
}
