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
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.ala.data.PkInfoData;
import com.baidu.tieba.ala.g.l;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PkRankView extends RelativeLayout {
    w aLD;
    CustomMessageListener boD;
    Context context;
    boolean hXn;
    PkRankEnterView hZI;
    PkRankInView hZJ;
    PkRankResultView hZK;
    private l hZL;
    PkInfoData hZM;
    public int hZN;
    CustomMessageListener hZO;
    boolean hZP;
    boolean isHost;
    private View mView;

    public PkRankView(Context context, boolean z, w wVar) {
        this(context, null);
        this.isHost = z;
        this.aLD = wVar;
    }

    public PkRankView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hZN = -1;
        this.hXn = true;
        this.hZP = false;
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_view_layout, (ViewGroup) this, true);
        this.hZI = (PkRankEnterView) this.mView.findViewById(a.f.enter_view);
        this.hZI.setPkRankView(this);
        this.hZJ = (PkRankInView) this.mView.findViewById(a.f.in_view);
        this.hZJ.setPkRankView(this);
        this.hZK = (PkRankResultView) this.mView.findViewById(a.f.result_view);
        this.hZK.setPkRankView(this);
        cpH();
        cql();
    }

    public void cqh() {
        if (this.aLD.mLiveInfo.pkId == 0) {
            if (this.isHost) {
                cqi();
                this.hZI.xP(1);
                return;
            }
            postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankView.this.aLD.mLiveInfo.pkId == 0) {
                        PkRankView.this.cpH();
                    }
                }
            }, 6000L);
        } else if (!getGetPkInfoModel().isLoop()) {
            getGetPkInfoModel().a(this.aLD.aJV.userId, this.aLD.mLiveInfo.pkId, this.aLD.mLiveInfo.room_id, this.aLD.mLiveInfo.live_id, this.isHost ? 1 : 0);
        }
    }

    public void f(JSONObject jSONObject, int i) {
        if (this.hZN < 10 || this.hZN > 30 || i >= 10) {
            if ((this.hZN >= 10 && this.hZN < 30) || i <= 10 || i >= 30) {
                if (jSONObject.optLong("pk_id") == 0 || this.hZM == null || this.hZM.pkStatusInfoData.pkID == jSONObject.optLong("pk_id") || i == 10) {
                    if (i != 4 || this.hZN == 1) {
                        if (i < 10 && this.isHost) {
                            this.hZI.d(jSONObject, i);
                        } else if (i >= 10 && i < 30) {
                            this.hZJ.e(jSONObject, i);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqi() {
        this.hZI.setVisibility(0);
        this.hZJ.setVisibility(8);
        this.hZK.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqj() {
        this.hZI.setVisibility(8);
        this.hZJ.setVisibility(0);
        this.hZK.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqk() {
        this.hZI.setVisibility(8);
        this.hZJ.setVisibility(8);
        this.hZK.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpH() {
        this.hZI.setVisibility(8);
        this.hZJ.setVisibility(8);
        this.hZK.setVisibility(8);
    }

    public void setCanVisible(boolean z) {
        this.hXn = z;
        this.mView.setVisibility((z && this.hZP) ? 0 : 8);
    }

    public void setInSeason(boolean z) {
        int i = 8;
        this.hZP = z;
        if (this.hXn) {
            this.mView.setVisibility((this.hZN >= 10 || z) ? 0 : 0);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void B(String str, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        String a2 = com.baidu.live.utils.b.a(1, str, this.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aLD.aKr.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aLD.aJV.userId)), String.valueOf(this.aLD.mLiveInfo.room_id), String.valueOf(this.aLD.mLiveInfo.live_id), hashMap);
        com.baidu.live.ao.c cVar = new com.baidu.live.ao.c();
        cVar.url = a2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    public l getGetPkInfoModel() {
        if (this.hZL == null) {
            this.hZL = new l();
            this.hZL.a(new l.a() { // from class: com.baidu.tieba.ala.view.PkRankView.2
                @Override // com.baidu.tieba.ala.g.l.a
                public void a(PkInfoData pkInfoData) {
                    if (PkRankView.this.isHost || PkRankView.this.hZM != null || pkInfoData.pkStatusInfoData.pkStatus == 1) {
                        PkRankView.this.l(pkInfoData);
                        if (PkRankView.this.hZM == null || PkRankView.this.hZM.myPkData.userID == pkInfoData.myPkData.userID) {
                            PkRankView.this.hZM = pkInfoData;
                            switch (pkInfoData.pkStatusInfoData.pkStatus) {
                                case 1:
                                    PkRankView.this.hZK.isShowing = false;
                                    PkRankView.this.hZJ.a(pkInfoData, 10);
                                    PkRankView.this.hZJ.getPkRankPropController().f(pkInfoData);
                                    return;
                                case 2:
                                    PkRankView.this.hZK.isShowing = false;
                                    PkRankView.this.hZJ.a(pkInfoData, 30);
                                    return;
                                case 3:
                                    PkRankView.this.hZL.hJ(false);
                                    PkRankView.this.hZJ.resetView();
                                    PkRankView.this.hZK.b(pkInfoData, 40);
                                    return;
                                case 4:
                                    PkRankView.this.hZL.hJ(false);
                                    PkRankView.this.hZK.isShowing = false;
                                    PkRankView.this.hZJ.resetView();
                                    PkRankView.this.hZJ.setVisibility(8);
                                    PkRankView.this.hZI.xP(1);
                                    return;
                                default:
                                    return;
                            }
                        }
                        return;
                    }
                    PkRankView.this.hZL.hJ(false);
                }

                @Override // com.baidu.tieba.ala.g.l.a
                public void bo(int i, String str) {
                }
            });
        }
        return this.hZL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(PkInfoData pkInfoData) {
        if (this.hZM == null || this.hZM.pkStatusInfoData.pkID != pkInfoData.pkStatusInfoData.pkID) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue("lodId", Long.valueOf(pkInfoData.logId));
            alaStatsItem.addValue("pkId", Long.valueOf(pkInfoData.pkStatusInfoData.pkID));
            switch (pkInfoData.pkStatusInfoData.pkStatus) {
                case 2:
                    AlaStatManager.getInstance().debug("pk_competition_start_settle", alaStatsItem);
                    return;
                case 3:
                    alaStatsItem.addValue("resultType", Integer.valueOf(pkInfoData.pkResultData.resultType));
                    AlaStatManager.getInstance().debug("pk_competition_show_result", alaStatsItem);
                    return;
                case 4:
                    AlaStatManager.getInstance().debug("pk_competition_pk_stop", alaStatsItem);
                    return;
                default:
                    return;
            }
        }
    }

    public void cql() {
        if (this.hZO == null) {
            this.hZO = new CustomMessageListener(2913233) { // from class: com.baidu.tieba.ala.view.PkRankView.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        PkRankView.this.hZI.hYc.fL(PkRankView.this.aLD.aJV.userId);
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("source", "pk_challage_btn_click");
                        AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hZO);
        }
        if (this.boD == null) {
            this.boD = new CustomMessageListener(2913237) { // from class: com.baidu.tieba.ala.view.PkRankView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && com.baidu.live.ae.a.RB().brA.aOG.aRH) {
                        PkRankView.this.setInSeason(((Boolean) customResponsedMessage.getData()).booleanValue());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.boD);
        }
    }

    public boolean xR(int i) {
        if (this.hZN < 10 || this.hZN > 30 || i >= 10 || i == 1) {
            if (this.hZN == 4 && i < 4) {
                this.hZI.hYc.cmj();
                this.hZI.cpB();
                return false;
            }
            if (i >= 10 && i < 30) {
                if (this.hZM != null && this.hZM.pkStatusInfoData != null) {
                    fR(this.hZM.pkStatusInfoData.pkID);
                } else {
                    fR(-1L);
                }
            } else {
                fR(-1L);
            }
            this.hZN = i;
            return true;
        }
        return false;
    }

    public void fR(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, Long.valueOf(j)));
    }

    public void onDestroy() {
        if (this.hZL != null) {
            this.hZL.cmg();
        }
        this.hZI.onDestroy();
        this.hZJ.onDestroy();
        this.hZK.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hZO);
        MessageManager.getInstance().unRegisterListener(this.boD);
    }
}
