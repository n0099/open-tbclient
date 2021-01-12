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
/* loaded from: classes10.dex */
public class PkRankView extends RelativeLayout {
    x aHu;
    CustomMessageListener blz;
    Context context;
    boolean ifi;
    PkRankEnterView ihC;
    PkRankInView ihD;
    PkRankResultView ihE;
    private l ihF;
    PkInfoData ihG;
    public int ihH;
    CustomMessageListener ihI;
    boolean ihJ;
    boolean isHost;
    private View mView;

    public PkRankView(Context context, boolean z, x xVar) {
        this(context, null);
        this.isHost = z;
        this.aHu = xVar;
    }

    public PkRankView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ihH = -1;
        this.ifi = true;
        this.ihJ = false;
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_view_layout, (ViewGroup) this, true);
        this.ihC = (PkRankEnterView) this.mView.findViewById(a.f.enter_view);
        this.ihC.setPkRankView(this);
        this.ihD = (PkRankInView) this.mView.findViewById(a.f.in_view);
        this.ihD.setPkRankView(this);
        this.ihE = (PkRankResultView) this.mView.findViewById(a.f.result_view);
        this.ihE.setPkRankView(this);
        coK();
        cpo();
    }

    public void cpk() {
        if (this.aHu.mLiveInfo.pkId == 0) {
            if (this.isHost) {
                cpl();
                this.ihC.ww(1);
                return;
            }
            postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankView.this.aHu.mLiveInfo.pkId == 0) {
                        PkRankView.this.coK();
                    }
                }
            }, 6000L);
        } else if (!getGetPkInfoModel().aHm()) {
            getGetPkInfoModel().a(this.aHu.aFH.userId, this.aHu.mLiveInfo.pkId, this.aHu.mLiveInfo.room_id, this.aHu.mLiveInfo.live_id, this.isHost ? 1 : 0);
        }
    }

    public void f(JSONObject jSONObject, int i) {
        if (this.ihH < 10 || this.ihH > 30 || i >= 10) {
            if ((this.ihH >= 10 && this.ihH < 30) || i <= 10 || i >= 30) {
                if (jSONObject.optLong("pk_id") == 0 || this.ihG == null || this.ihG.pkStatusInfoData.pkID == jSONObject.optLong("pk_id") || i == 10) {
                    if (i != 4 || this.ihH == 1) {
                        if (i < 10 && this.isHost) {
                            this.ihC.d(jSONObject, i);
                        } else if (i >= 10 && i < 30) {
                            this.ihD.e(jSONObject, i);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cpl() {
        this.ihC.setVisibility(0);
        this.ihD.setVisibility(8);
        this.ihE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cpm() {
        this.ihC.setVisibility(8);
        this.ihD.setVisibility(0);
        this.ihE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cpn() {
        this.ihC.setVisibility(8);
        this.ihD.setVisibility(8);
        this.ihE.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coK() {
        this.ihC.setVisibility(8);
        this.ihD.setVisibility(8);
        this.ihE.setVisibility(8);
    }

    public void setCanVisible(boolean z) {
        this.ifi = z;
        this.mView.setVisibility((z && this.ihJ) ? 0 : 8);
    }

    public void setInSeason(boolean z) {
        int i = 8;
        this.ihJ = z;
        if (this.ifi) {
            this.mView.setVisibility((this.ihH >= 10 || z) ? 0 : 0);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void B(String str, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        String a2 = com.baidu.live.utils.b.a(1, str, this.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aHu.aGd.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aHu.aFH.userId)), String.valueOf(this.aHu.mLiveInfo.room_id), String.valueOf(this.aHu.mLiveInfo.live_id), hashMap);
        com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
        cVar.url = a2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    public l getGetPkInfoModel() {
        if (this.ihF == null) {
            this.ihF = new l();
            this.ihF.a(new l.a() { // from class: com.baidu.tieba.ala.view.PkRankView.2
                @Override // com.baidu.tieba.ala.g.l.a
                public void a(PkInfoData pkInfoData) {
                    if (PkRankView.this.isHost || PkRankView.this.ihG != null || pkInfoData.pkStatusInfoData.pkStatus == 1) {
                        PkRankView.this.l(pkInfoData);
                        if (PkRankView.this.ihG == null || PkRankView.this.ihG.myPkData.userID == pkInfoData.myPkData.userID) {
                            PkRankView.this.ihG = pkInfoData;
                            switch (pkInfoData.pkStatusInfoData.pkStatus) {
                                case 1:
                                    PkRankView.this.ihE.isShowing = false;
                                    PkRankView.this.ihD.a(pkInfoData, 10);
                                    PkRankView.this.ihD.getPkRankPropController().f(pkInfoData);
                                    return;
                                case 2:
                                    PkRankView.this.ihE.isShowing = false;
                                    PkRankView.this.ihD.a(pkInfoData, 30);
                                    return;
                                case 3:
                                    PkRankView.this.ihF.hX(false);
                                    PkRankView.this.ihD.resetView();
                                    PkRankView.this.ihE.b(pkInfoData, 40);
                                    return;
                                case 4:
                                    PkRankView.this.ihF.hX(false);
                                    PkRankView.this.ihE.isShowing = false;
                                    PkRankView.this.ihD.resetView();
                                    PkRankView.this.ihD.setVisibility(8);
                                    PkRankView.this.ihC.ww(1);
                                    return;
                                default:
                                    return;
                            }
                        }
                        return;
                    }
                    PkRankView.this.ihF.hX(false);
                }

                @Override // com.baidu.tieba.ala.g.l.a
                public void br(int i, String str) {
                }
            });
        }
        return this.ihF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(PkInfoData pkInfoData) {
        if (this.ihG == null || this.ihG.pkStatusInfoData.pkID != pkInfoData.pkStatusInfoData.pkID) {
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

    public void cpo() {
        if (this.ihI == null) {
            this.ihI = new CustomMessageListener(2913233) { // from class: com.baidu.tieba.ala.view.PkRankView.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        PkRankView.this.ihC.ifW.fL(PkRankView.this.aHu.aFH.userId);
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("source", "pk_challage_btn_click");
                        AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_challage_btn_click"));
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ihI);
        }
        if (this.blz == null) {
            this.blz = new CustomMessageListener(2913237) { // from class: com.baidu.tieba.ala.view.PkRankView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && com.baidu.live.af.a.OJ().bru.aKA.aNJ) {
                        PkRankView.this.setInSeason(((Boolean) customResponsedMessage.getData()).booleanValue());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.blz);
        }
    }

    public boolean wy(int i) {
        if (this.ihH < 10 || this.ihH > 30 || i >= 10 || i == 1) {
            if (this.ihH == 4 && i < 4) {
                this.ihC.ifW.clk();
                this.ihC.coE();
                return false;
            }
            if (i >= 10 && i < 30) {
                if (this.ihG != null && this.ihG.pkStatusInfoData != null) {
                    fR(this.ihG.pkStatusInfoData.pkID);
                } else {
                    fR(-1L);
                }
            } else {
                fR(-1L);
            }
            this.ihH = i;
            return true;
        }
        return false;
    }

    public void fR(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, Long.valueOf(j)));
    }

    public void onDestroy() {
        if (this.ihF != null) {
            this.ihF.clh();
        }
        this.ihC.onDestroy();
        this.ihD.onDestroy();
        this.ihE.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.ihI);
        MessageManager.getInstance().unRegisterListener(this.blz);
    }
}
