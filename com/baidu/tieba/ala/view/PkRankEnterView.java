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
/* loaded from: classes10.dex */
public class PkRankEnterView extends RelativeLayout {
    Context context;
    private PkRankView gTG;
    ImageView imA;
    ImageView imB;
    HeadImageView imC;
    TextView imD;
    TextView imE;
    TextView imF;
    TextView imG;
    TextView imH;
    RelativeLayout imI;
    Button imJ;
    RelativeLayout imK;
    com.baidu.tieba.ala.f imL;
    p imM;
    com.baidu.tieba.ala.g.a imN;
    com.baidu.tieba.ala.g.k imO;
    i imP;
    com.baidu.tieba.ala.h.d imQ;
    int imz;
    private View mView;
    int status;

    public PkRankEnterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankEnterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.imM = new p();
        this.imN = new com.baidu.tieba.ala.g.a();
        this.imO = new com.baidu.tieba.ala.g.k();
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_rank_enter_layout, (ViewGroup) this, true);
        this.imK = (RelativeLayout) this.mView.findViewById(a.f.enter_container);
        this.imC = (HeadImageView) this.mView.findViewById(a.f.enter_head);
        this.imC.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.imC.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.imC.setIsRound(true);
        this.imC.setAutoChangeStyle(false);
        this.imA = (ImageView) this.mView.findViewById(a.f.enter_bg);
        this.imB = (ImageView) this.mView.findViewById(a.f.enter_image);
        this.imD = (TextView) this.mView.findViewById(a.f.invite_id);
        this.imE = (TextView) this.mView.findViewById(a.f.invite_tip);
        this.imF = (TextView) this.mView.findViewById(a.f.new_invite_tip);
        this.imI = (RelativeLayout) this.mView.findViewById(a.f.bottom_button_layout);
        this.imJ = (Button) this.mView.findViewById(a.f.bottom_button);
        this.imG = (TextView) this.mView.findViewById(a.f.matching_tip);
        this.imH = (TextView) this.mView.findViewById(a.f.matching_time);
        this.imQ = new com.baidu.tieba.ala.h.d(this.imI);
        this.imN.a(new a.InterfaceC0637a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.1
            @Override // com.baidu.tieba.ala.g.a.InterfaceC0637a
            public void fN(long j) {
                PkRankEnterView.this.imM.cmt();
                PkRankEnterView.this.cqb();
                PkRankEnterView.this.gTG.getGetPkInfoModel().a(PkRankEnterView.this.gTG.aLz.aJD.userId, j, PkRankEnterView.this.gTG.aLz.mLiveInfo.room_id, PkRankEnterView.this.gTG.aLz.mLiveInfo.live_id, PkRankEnterView.this.gTG.isHost ? 1 : 0);
            }

            @Override // com.baidu.tieba.ala.g.a.InterfaceC0637a
            public void bu(int i, String str) {
            }
        });
        this.imO.a(new k.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.2
            @Override // com.baidu.tieba.ala.g.k.a
            public void cmq() {
                PkRankEnterView.this.imM.cmt();
                PkRankEnterView.this.cpW();
                PkRankEnterView.this.wI(1);
            }

            @Override // com.baidu.tieba.ala.g.k.a
            public void bv(int i, String str) {
            }
        });
        this.imM.a(new p.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.3
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
                PkRankEnterView.this.gTG.getGetPkInfoModel().a(PkRankEnterView.this.gTG.aLz.aJD.userId, j, PkRankEnterView.this.gTG.aLz.mLiveInfo.room_id, PkRankEnterView.this.gTG.aLz.mLiveInfo.live_id, PkRankEnterView.this.gTG.isHost ? 1 : 0);
                PkRankEnterView.this.cpW();
                PkRankEnterView.this.cqb();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void cmw() {
                PkRankEnterView.this.wI(3);
                PkRankEnterView.this.cpW();
                PkRankEnterView.this.cqb();
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void ae(ArrayList<String> arrayList) {
                PkRankEnterView.this.wI(2);
                PkRankEnterView.this.ag(arrayList);
            }

            @Override // com.baidu.tieba.ala.g.p.a
            public void bt(int i, String str) {
            }
        });
    }

    public void wI(int i) {
        this.status = i;
        if (this.gTG.wK(i)) {
            if (!this.gTG.isHost) {
                this.gTG.cqF();
                setVisibility(8);
                return;
            }
            this.gTG.cqF();
            cqc();
            switch (i) {
                case 0:
                    cpX();
                    break;
                case 1:
                    cpY();
                    break;
                case 2:
                    cpZ();
                    break;
                case 3:
                    cqa();
                    break;
            }
            this.imz = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(ArrayList<String> arrayList) {
        if (this.imP == null || !this.imP.cpV()) {
            this.imP = new i(arrayList, this.imC, this.imK);
            this.imP.sz();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cpW() {
        if (this.imP != null) {
            this.imP.cmt();
        }
    }

    private void cpX() {
        wJ(10);
        this.imB.setVisibility(0);
        this.imB.setImageResource(a.e.pk_rank_enter_view_again);
        this.imA.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.imJ.setVisibility(0);
        this.imJ.setText(a.h.sdk_pk_rank_restart);
        this.imJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.imM.fR(com.baidu.live.ae.a.Qm().bwx.aLW);
                PkRankEnterView.this.imM.fQ(PkRankEnterView.this.gTG.aLz.aJD.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_rematch_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_rematch_btn_click"));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpY() {
        this.gTG.ipi = 1;
        this.status = 1;
        this.imz = 1;
        this.imB.setVisibility(0);
        this.imB.setImageResource(a.e.pk_rank_enter_view_main);
        this.imA.setImageResource(a.e.pk_rank_enter_view_bg);
        this.imJ.setVisibility(0);
        this.imJ.setText(a.h.sdk_pk_rank_start);
        this.imJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.imM.fR(com.baidu.live.ae.a.Qm().bwx.aLW);
                PkRankEnterView.this.imM.fQ(PkRankEnterView.this.gTG.aLz.aJD.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_quick_start_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_quick_start_btn_click"));
            }
        });
    }

    private void cpZ() {
        wJ(com.baidu.live.ae.a.Qm().bwx.aLW);
        this.imC.setVisibility(0);
        this.imA.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.imG.setVisibility(0);
        this.imH.setVisibility(0);
        this.imJ.setVisibility(0);
        this.imJ.setText(a.h.sdk_pk_rank_matching_cancel);
        this.imJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.imO.fP(PkRankEnterView.this.gTG.aLz.aJD.userId);
            }
        });
    }

    private void cqa() {
        wJ(10);
        this.imB.setVisibility(0);
        this.imB.setImageResource(a.e.pk_rank_enter_view_fail);
        this.imA.setImageResource(a.e.pk_rank_enter_view_black_bg);
        this.imJ.setVisibility(0);
        this.imJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.imM.fR(com.baidu.live.ae.a.Qm().bwx.aLW);
                PkRankEnterView.this.imM.fQ(PkRankEnterView.this.gTG.aLz.aJD.userId);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                alaStatsItem.addValue("source", "pk_pendant_match_filed_btn_click");
                AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_pendant_match_filed_btn_click"));
            }
        });
    }

    private void ei(JSONObject jSONObject) {
        this.imA.setImageResource(a.e.pk_rank_enter_view_black_bg);
        wJ(10);
        final JSONObject optJSONObject = jSONObject.optJSONObject("rival_anchor");
        this.imF.setVisibility(0);
        this.imJ.setVisibility(0);
        this.imJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PkRankEnterView.this.imN.D(PkRankEnterView.this.gTG.aLz.aJD.userId, optJSONObject.optLong("user_id"));
                PkRankEnterView.this.imQ.stopAnim();
            }
        });
        this.imQ.startAnim();
    }

    private void wJ(int i) {
        if ((this.imL == null || !this.imL.isRunning()) && i > 0) {
            this.imH.setText(i + "s");
            this.imL = new com.baidu.tieba.ala.f(i * 1000, 1000L);
            this.imL.a(new f.a() { // from class: com.baidu.tieba.ala.view.PkRankEnterView.9
                @Override // com.baidu.tieba.ala.f.a
                public void onTick(long j) {
                    long round = Math.round(j / 1000.0d);
                    if (PkRankEnterView.this.status == 0 || PkRankEnterView.this.status == 3) {
                        PkRankEnterView.this.imJ.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_restart_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 4) {
                        PkRankEnterView.this.imJ.setText(PkRankEnterView.this.context.getString(a.h.sdk_pk_rank_accept_time, String.valueOf(round)));
                    } else if (PkRankEnterView.this.status == 2) {
                        PkRankEnterView.this.imM.fR(round);
                        PkRankEnterView.this.imH.setText(round + "s");
                    }
                }

                @Override // com.baidu.tieba.ala.f.a
                public void onFinish() {
                    if (PkRankEnterView.this.status == 2) {
                        PkRankEnterView.this.imO.fP(PkRankEnterView.this.gTG.aLz.aJD.userId);
                        return;
                    }
                    PkRankEnterView.this.imL.cancelTimer();
                    PkRankEnterView.this.cqc();
                    PkRankEnterView.this.cpY();
                    PkRankEnterView.this.imQ.stopAnim();
                }
            });
            this.imL.startTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqb() {
        if (this.imL != null) {
            this.imL.cancelTimer();
            this.imL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqc() {
        setVisibility(0);
        if (this.imz != this.status) {
            cqb();
        }
        this.imC.setVisibility(8);
        this.imG.setVisibility(8);
        this.imH.setVisibility(8);
        this.imB.setVisibility(8);
        this.imD.setVisibility(8);
        this.imE.setVisibility(8);
        this.imF.setVisibility(8);
        this.imJ.setVisibility(8);
    }

    public void onDestroy() {
        if (this.imM != null) {
            this.imM.cmv();
        }
        if (this.imN != null) {
            this.imN.cmk();
        }
        if (this.imO != null) {
            this.imO.cmp();
        }
        if (this.gTG.getGetPkInfoModel() != null) {
            this.gTG.getGetPkInfoModel().cms();
        }
        if (this.imQ != null) {
            this.imQ.release();
            this.imQ = null;
        }
        cqb();
    }

    public void setPkRankView(PkRankView pkRankView) {
        this.gTG = pkRankView;
    }

    public void d(JSONObject jSONObject, int i) {
        if (this.gTG.wK(i) && i == 4) {
            this.imM.cmt();
            cpW();
            cqb();
            this.gTG.cqF();
            cqc();
            this.imz = i;
            this.status = i;
            ei(jSONObject);
        }
    }
}
