package com.baidu.tieba.ala.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.data.PkInfoData;
import com.baidu.tieba.ala.g.l;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PkRankView extends RelativeLayout {
    x aMh;
    CustomMessageListener bqm;
    Context context;
    boolean ijP;
    PkRankEnterView imk;
    PkRankInView iml;
    PkRankResultView imm;
    private l imn;
    PkInfoData imo;
    public int imp;
    CustomMessageListener imq;
    boolean imr;
    boolean isHost;
    private View mView;

    public PkRankView(Context context, boolean z, x xVar) {
        this(context, null);
        this.isHost = z;
        this.aMh = xVar;
    }

    public PkRankView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.imp = -1;
        this.ijP = true;
        this.imr = false;
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_view_layout, (ViewGroup) this, true);
        this.imk = (PkRankEnterView) this.mView.findViewById(a.f.enter_view);
        this.imk.setPkRankView(this);
        this.iml = (PkRankInView) this.mView.findViewById(a.f.in_view);
        this.iml.setPkRankView(this);
        this.imm = (PkRankResultView) this.mView.findViewById(a.f.result_view);
        this.imm.setPkRankView(this);
        csC();
        ctg();
    }

    public void ctc() {
        if (this.aMh.mLiveInfo.pkId == 0) {
            if (this.isHost) {
                ctd();
                this.imk.yc(1);
                return;
            }
            postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankView.this.aMh.mLiveInfo.pkId == 0) {
                        PkRankView.this.csC();
                    }
                }
            }, 6000L);
        } else if (!getGetPkInfoModel().aLg()) {
            getGetPkInfoModel().a(this.aMh.aKu.userId, this.aMh.mLiveInfo.pkId, this.aMh.mLiveInfo.room_id, this.aMh.mLiveInfo.live_id, this.isHost ? 1 : 0);
        }
    }

    public void f(JSONObject jSONObject, int i) {
        if (this.imp < 10 || this.imp > 30 || i >= 10) {
            if ((this.imp >= 10 && this.imp < 30) || i <= 10 || i >= 30) {
                if (jSONObject.optLong("pk_id") == 0 || this.imo == null || this.imo.pkStatusInfoData.pkID == jSONObject.optLong("pk_id") || i == 10) {
                    if (i != 4 || this.imp == 1) {
                        if (i < 10 && this.isHost) {
                            this.imk.d(jSONObject, i);
                        } else if (i >= 10 && i < 30) {
                            this.iml.e(jSONObject, i);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ctd() {
        this.imk.setVisibility(0);
        this.iml.setVisibility(8);
        this.imm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cte() {
        this.imk.setVisibility(8);
        this.iml.setVisibility(0);
        this.imm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ctf() {
        this.imk.setVisibility(8);
        this.iml.setVisibility(8);
        this.imm.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csC() {
        this.imk.setVisibility(8);
        this.iml.setVisibility(8);
        this.imm.setVisibility(8);
    }

    public void setCanVisible(boolean z) {
        this.ijP = z;
        this.mView.setVisibility((z && this.imr) ? 0 : 8);
    }

    public void setInSeason(boolean z) {
        int i = 8;
        this.imr = z;
        if (this.ijP) {
            this.mView.setVisibility((this.imp >= 10 || z) ? 0 : 0);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void B(String str, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        String a2 = com.baidu.live.utils.b.a(1, str, this.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aMh.aKQ.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aMh.aKu.userId)), String.valueOf(this.aMh.mLiveInfo.room_id), String.valueOf(this.aMh.mLiveInfo.live_id), hashMap);
        com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
        cVar.url = a2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    public l getGetPkInfoModel() {
        if (this.imn == null) {
            this.imn = new l();
            this.imn.a(new l.a() { // from class: com.baidu.tieba.ala.view.PkRankView.2
                @Override // com.baidu.tieba.ala.g.l.a
                public void a(PkInfoData pkInfoData) {
                    if (PkRankView.this.isHost || PkRankView.this.imo != null || pkInfoData.pkStatusInfoData.pkStatus == 1) {
                        PkRankView.this.l(pkInfoData);
                        if (PkRankView.this.imo == null || PkRankView.this.imo.myPkData.userID == pkInfoData.myPkData.userID) {
                            PkRankView.this.imo = pkInfoData;
                            switch (pkInfoData.pkStatusInfoData.pkStatus) {
                                case 1:
                                    PkRankView.this.imm.isShowing = false;
                                    PkRankView.this.iml.a(pkInfoData, 10);
                                    PkRankView.this.iml.getPkRankPropController().f(pkInfoData);
                                    return;
                                case 2:
                                    PkRankView.this.imm.isShowing = false;
                                    PkRankView.this.iml.a(pkInfoData, 30);
                                    return;
                                case 3:
                                    PkRankView.this.imn.ib(false);
                                    PkRankView.this.iml.resetView();
                                    PkRankView.this.imm.b(pkInfoData, 40);
                                    return;
                                case 4:
                                    PkRankView.this.imn.ib(false);
                                    PkRankView.this.imm.isShowing = false;
                                    PkRankView.this.iml.resetView();
                                    PkRankView.this.iml.setVisibility(8);
                                    PkRankView.this.imk.yc(1);
                                    return;
                                default:
                                    return;
                            }
                        }
                        return;
                    }
                    PkRankView.this.imn.ib(false);
                }

                @Override // com.baidu.tieba.ala.g.l.a
                public void bq(int i, String str) {
                }
            });
        }
        return this.imn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(PkInfoData pkInfoData) {
        if (this.imo == null || this.imo.pkStatusInfoData.pkID != pkInfoData.pkStatusInfoData.pkID) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue("lodId", Long.valueOf(pkInfoData.logId));
            alaStatsItem.addValue("pkId", Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("pkId", Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
                jSONObject.putOpt("lodId", Long.valueOf(pkInfoData.logId));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            switch (pkInfoData.pkStatusInfoData.pkStatus) {
                case 2:
                    AlaStatManager.getInstance().debug("pk_competition_start_settle", alaStatsItem);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_settle", "author_liveroom", "").setContentExt(jSONObject));
                    return;
                case 3:
                    alaStatsItem.addValue("resultType", Integer.valueOf(pkInfoData.pkResultData.resultType));
                    AlaStatManager.getInstance().debug("pk_competition_show_result", alaStatsItem);
                    try {
                        jSONObject.putOpt("resultType", Integer.valueOf(pkInfoData.pkResultData.resultType));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_show_result", "author_liveroom", "").setContentExt(jSONObject));
                    return;
                case 4:
                    AlaStatManager.getInstance().debug("pk_competition_pk_stop", alaStatsItem);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_pk_stop", "author_liveroom", "").setContentExt(jSONObject));
                    return;
                default:
                    return;
            }
        }
    }

    public void ctg() {
        if (this.imq == null) {
            this.imq = new CustomMessageListener(2913233) { // from class: com.baidu.tieba.ala.view.PkRankView.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        PkRankView.this.imk.ikD.fL(PkRankView.this.aMh.aKu.userId);
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("source", "pk_challage_btn_click");
                        AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_challage_btn_click"));
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.imq);
        }
        if (this.bqm == null) {
            this.bqm = new CustomMessageListener(2913237) { // from class: com.baidu.tieba.ala.view.PkRankView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && com.baidu.live.af.a.SE().bwi.aPn.aSw) {
                        PkRankView.this.setInSeason(((Boolean) customResponsedMessage.getData()).booleanValue());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bqm);
        }
    }

    public boolean ye(int i) {
        if (this.imp < 10 || this.imp > 30 || i >= 10 || i == 1) {
            if (this.imp == 4 && i < 4) {
                this.imk.ikD.cpc();
                this.imk.csw();
                return false;
            }
            if (i >= 10 && i < 30) {
                if (this.imo != null && this.imo.pkStatusInfoData != null) {
                    fR(this.imo.pkStatusInfoData.pkID);
                } else {
                    fR(-1L);
                }
            } else {
                fR(-1L);
            }
            this.imp = i;
            return true;
        }
        return false;
    }

    public void fR(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, Long.valueOf(j)));
    }

    public void onDestroy() {
        if (this.imn != null) {
            this.imn.coZ();
        }
        this.imk.onDestroy();
        this.iml.onDestroy();
        this.imm.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.imq);
        MessageManager.getInstance().unRegisterListener(this.bqm);
    }
}
