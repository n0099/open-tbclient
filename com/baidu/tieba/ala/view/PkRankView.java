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
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.tieba.ala.data.PkInfoData;
import com.baidu.tieba.ala.g.l;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PkRankView extends RelativeLayout {
    u aIT;
    Context context;
    PkRankEnterView hwQ;
    PkRankInView hwR;
    PkRankResultView hwS;
    private l hwT;
    PkInfoData hwU;
    public int hwV;
    CustomMessageListener hwW;
    CustomMessageListener hwX;
    boolean hwY;
    boolean hwZ;
    boolean isHost;
    private View mView;

    public PkRankView(Context context, boolean z, u uVar) {
        this(context, null);
        this.isHost = z;
        this.aIT = uVar;
    }

    public PkRankView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hwV = -1;
        this.hwY = true;
        this.hwZ = false;
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_pk_rank_view_layout, (ViewGroup) this, true);
        this.hwQ = (PkRankEnterView) this.mView.findViewById(a.g.enter_view);
        this.hwQ.setPkRankView(this);
        this.hwR = (PkRankInView) this.mView.findViewById(a.g.in_view);
        this.hwR.setPkRankView(this);
        this.hwS = (PkRankResultView) this.mView.findViewById(a.g.result_view);
        this.hwS.setPkRankView(this);
        cgq();
        cgW();
    }

    public void cgS() {
        if (this.aIT.mLiveInfo.pkId == 0) {
            if (this.isHost) {
                cgT();
                this.hwQ.wf(1);
                return;
            }
            postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankView.this.aIT.mLiveInfo.pkId == 0) {
                        PkRankView.this.cgq();
                    }
                }
            }, 6000L);
        } else if (!getGetPkInfoModel().isLoop()) {
            getGetPkInfoModel().a(this.aIT.aHD.userId, this.aIT.mLiveInfo.pkId, this.aIT.mLiveInfo.room_id, this.aIT.mLiveInfo.live_id, this.isHost ? 1 : 0);
        }
    }

    public void f(JSONObject jSONObject, int i) {
        if (this.hwV < 10 || this.hwV > 30 || i >= 10) {
            if ((this.hwV >= 10 && this.hwV < 30) || i <= 10 || i >= 30) {
                if (jSONObject.optLong("pk_id") == 0 || this.hwU == null || this.hwU.pkStatusInfoData.pkID == jSONObject.optLong("pk_id") || i == 10) {
                    if (i != 4 || this.hwV == 1) {
                        if (i < 10 && this.isHost) {
                            this.hwQ.d(jSONObject, i);
                        } else if (i >= 10 && i < 30) {
                            this.hwR.e(jSONObject, i);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cgT() {
        this.hwQ.setVisibility(0);
        this.hwR.setVisibility(8);
        this.hwS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cgU() {
        this.hwQ.setVisibility(8);
        this.hwR.setVisibility(0);
        this.hwS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cgV() {
        this.hwQ.setVisibility(8);
        this.hwR.setVisibility(8);
        this.hwS.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgq() {
        this.hwQ.setVisibility(8);
        this.hwR.setVisibility(8);
        this.hwS.setVisibility(8);
    }

    public void setCanVisible(boolean z) {
        this.hwY = z;
        this.mView.setVisibility((z && this.hwZ) ? 0 : 8);
    }

    public void setInSeason(boolean z) {
        int i = 8;
        this.hwZ = z;
        if (this.hwY) {
            this.mView.setVisibility((this.hwV >= 10 || z) ? 0 : 0);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void y(String str, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        String a2 = com.baidu.live.utils.b.a(1, str, this.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aIT.aIf.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aIT.aHD.userId)), String.valueOf(this.aIT.mLiveInfo.room_id), String.valueOf(this.aIT.mLiveInfo.live_id), hashMap);
        com.baidu.live.af.c cVar = new com.baidu.live.af.c();
        cVar.url = a2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    public l getGetPkInfoModel() {
        if (this.hwT == null) {
            this.hwT = new l();
            this.hwT.a(new l.a() { // from class: com.baidu.tieba.ala.view.PkRankView.2
                @Override // com.baidu.tieba.ala.g.l.a
                public void a(PkInfoData pkInfoData) {
                    if (PkRankView.this.isHost || PkRankView.this.hwU != null || pkInfoData.pkStatusInfoData.pkStatus == 1) {
                        PkRankView.this.l(pkInfoData);
                        if (PkRankView.this.hwU == null || PkRankView.this.hwU.myPkData.userID == pkInfoData.myPkData.userID) {
                            PkRankView.this.hwU = pkInfoData;
                            switch (pkInfoData.pkStatusInfoData.pkStatus) {
                                case 1:
                                    PkRankView.this.hwS.isShowing = false;
                                    PkRankView.this.hwR.a(pkInfoData, 10);
                                    PkRankView.this.hwR.getPkRankPropController().f(pkInfoData);
                                    return;
                                case 2:
                                    PkRankView.this.hwS.isShowing = false;
                                    PkRankView.this.hwR.a(pkInfoData, 30);
                                    return;
                                case 3:
                                    PkRankView.this.hwT.gV(false);
                                    PkRankView.this.hwR.resetView();
                                    PkRankView.this.hwS.b(pkInfoData, 40);
                                    return;
                                case 4:
                                    PkRankView.this.hwT.gV(false);
                                    PkRankView.this.hwS.isShowing = false;
                                    PkRankView.this.hwR.resetView();
                                    PkRankView.this.hwR.setVisibility(8);
                                    PkRankView.this.hwQ.wf(1);
                                    return;
                                default:
                                    return;
                            }
                        }
                        return;
                    }
                    PkRankView.this.hwT.gV(false);
                }

                @Override // com.baidu.tieba.ala.g.l.a
                public void bk(int i, String str) {
                }
            });
        }
        return this.hwT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(PkInfoData pkInfoData) {
        if (this.hwU == null || this.hwU.pkStatusInfoData.pkID != pkInfoData.pkStatusInfoData.pkID) {
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

    public void cgW() {
        if (this.hwW == null) {
            this.hwW = new CustomMessageListener(2913233) { // from class: com.baidu.tieba.ala.view.PkRankView.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        PkRankView.this.hwQ.hvh.eJ(PkRankView.this.aIT.aHD.userId);
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("source", "pk_challage_btn_click");
                        AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hwW);
        }
        if (this.hwX == null) {
            this.hwX = new CustomMessageListener(2913237) { // from class: com.baidu.tieba.ala.view.PkRankView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && com.baidu.live.x.a.OS().blo.aLS.aOP) {
                        PkRankView.this.setInSeason(((Boolean) customResponsedMessage.getData()).booleanValue());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hwX);
        }
    }

    public boolean wh(int i) {
        if (this.hwV < 10 || this.hwV > 30 || i >= 10 || i == 1) {
            if (this.hwV == 4 && i < 4) {
                this.hwQ.hvh.cds();
                this.hwQ.cgk();
                return false;
            }
            if (i >= 10 && i < 30) {
                if (this.hwU != null && this.hwU.pkStatusInfoData != null) {
                    eQ(this.hwU.pkStatusInfoData.pkID);
                } else {
                    eQ(-1L);
                }
            } else {
                eQ(-1L);
            }
            this.hwV = i;
            return true;
        }
        return false;
    }

    public void eQ(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, Long.valueOf(j)));
    }

    public void onDestroy() {
        if (this.hwT != null) {
            this.hwT.cdp();
        }
        this.hwQ.onDestroy();
        this.hwR.onDestroy();
        this.hwS.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hwW);
        MessageManager.getInstance().unRegisterListener(this.hwX);
    }
}
