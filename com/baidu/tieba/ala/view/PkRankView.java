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
    u aFP;
    Context context;
    PkRankEnterView hhU;
    PkRankInView hhV;
    PkRankResultView hhW;
    private l hhX;
    PkInfoData hhY;
    public int hhZ;
    CustomMessageListener hia;
    CustomMessageListener hib;
    boolean hic;
    boolean hie;
    boolean isHost;
    private View mView;

    public PkRankView(Context context, boolean z, u uVar) {
        this(context, null);
        this.isHost = z;
        this.aFP = uVar;
    }

    public PkRankView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hhZ = -1;
        this.hic = true;
        this.hie = false;
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_pk_rank_view_layout, (ViewGroup) this, true);
        this.hhU = (PkRankEnterView) this.mView.findViewById(a.g.enter_view);
        this.hhU.setPkRankView(this);
        this.hhV = (PkRankInView) this.mView.findViewById(a.g.in_view);
        this.hhV.setPkRankView(this);
        this.hhW = (PkRankResultView) this.mView.findViewById(a.g.result_view);
        this.hhW.setPkRankView(this);
        ccU();
        cdA();
    }

    public void cdw() {
        if (this.aFP.mLiveInfo.pkId == 0) {
            if (this.isHost) {
                cdx();
                this.hhU.vz(1);
                return;
            }
            postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankView.this.aFP.mLiveInfo.pkId == 0) {
                        PkRankView.this.ccU();
                    }
                }
            }, 6000L);
        } else if (!getGetPkInfoModel().isLoop()) {
            getGetPkInfoModel().a(this.aFP.aEz.userId, this.aFP.mLiveInfo.pkId, this.aFP.mLiveInfo.room_id, this.aFP.mLiveInfo.live_id, this.isHost ? 1 : 0);
        }
    }

    public void e(JSONObject jSONObject, int i) {
        if (this.hhZ < 10 || this.hhZ > 30 || i >= 10) {
            if ((this.hhZ >= 10 && this.hhZ < 30) || i <= 10 || i >= 30) {
                if (jSONObject.optLong("pk_id") == 0 || this.hhY == null || this.hhY.pkStatusInfoData.pkID == jSONObject.optLong("pk_id") || i == 10) {
                    if (i != 4 || this.hhZ == 1) {
                        if (i < 10 && this.isHost) {
                            this.hhU.c(jSONObject, i);
                        } else if (i >= 10 && i < 30) {
                            this.hhV.d(jSONObject, i);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdx() {
        this.hhU.setVisibility(0);
        this.hhV.setVisibility(8);
        this.hhW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdy() {
        this.hhU.setVisibility(8);
        this.hhV.setVisibility(0);
        this.hhW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdz() {
        this.hhU.setVisibility(8);
        this.hhV.setVisibility(8);
        this.hhW.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccU() {
        this.hhU.setVisibility(8);
        this.hhV.setVisibility(8);
        this.hhW.setVisibility(8);
    }

    public void setCanVisible(boolean z) {
        this.hic = z;
        this.mView.setVisibility((z && this.hie) ? 0 : 8);
    }

    public void setInSeason(boolean z) {
        int i = 8;
        this.hie = z;
        if (this.hic) {
            this.mView.setVisibility((this.hhZ >= 10 || z) ? 0 : 0);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void y(String str, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        String a = com.baidu.live.utils.b.a(1, str, this.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aFP.aFb.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aFP.aEz.userId)), String.valueOf(this.aFP.mLiveInfo.room_id), String.valueOf(this.aFP.mLiveInfo.live_id), hashMap);
        com.baidu.live.ae.c cVar = new com.baidu.live.ae.c();
        cVar.url = a;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    public l getGetPkInfoModel() {
        if (this.hhX == null) {
            this.hhX = new l();
            this.hhX.a(new l.a() { // from class: com.baidu.tieba.ala.view.PkRankView.2
                @Override // com.baidu.tieba.ala.g.l.a
                public void a(PkInfoData pkInfoData) {
                    if (PkRankView.this.isHost || PkRankView.this.hhY != null || pkInfoData.pkStatusInfoData.pkStatus == 1) {
                        PkRankView.this.l(pkInfoData);
                        if (PkRankView.this.hhY == null || PkRankView.this.hhY.myPkData.userID == pkInfoData.myPkData.userID) {
                            PkRankView.this.hhY = pkInfoData;
                            switch (pkInfoData.pkStatusInfoData.pkStatus) {
                                case 1:
                                    PkRankView.this.hhW.isShowing = false;
                                    PkRankView.this.hhV.a(pkInfoData, 10);
                                    PkRankView.this.hhV.getPkRankPropController().f(pkInfoData);
                                    return;
                                case 2:
                                    PkRankView.this.hhW.isShowing = false;
                                    PkRankView.this.hhV.a(pkInfoData, 30);
                                    return;
                                case 3:
                                    PkRankView.this.hhX.gz(false);
                                    PkRankView.this.hhV.resetView();
                                    PkRankView.this.hhW.b(pkInfoData, 40);
                                    return;
                                case 4:
                                    PkRankView.this.hhX.gz(false);
                                    PkRankView.this.hhW.isShowing = false;
                                    PkRankView.this.hhV.resetView();
                                    PkRankView.this.hhV.setVisibility(8);
                                    PkRankView.this.hhU.vz(1);
                                    return;
                                default:
                                    return;
                            }
                        }
                        return;
                    }
                    PkRankView.this.hhX.gz(false);
                }

                @Override // com.baidu.tieba.ala.g.l.a
                public void ba(int i, String str) {
                }
            });
        }
        return this.hhX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(PkInfoData pkInfoData) {
        if (this.hhY == null || this.hhY.pkStatusInfoData.pkID != pkInfoData.pkStatusInfoData.pkID) {
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

    public void cdA() {
        if (this.hia == null) {
            this.hia = new CustomMessageListener(2913233) { // from class: com.baidu.tieba.ala.view.PkRankView.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        PkRankView.this.hhU.hgm.es(PkRankView.this.aFP.aEz.userId);
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("source", "pk_challage_btn_click");
                        AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hia);
        }
        if (this.hib == null) {
            this.hib = new CustomMessageListener(2913237) { // from class: com.baidu.tieba.ala.view.PkRankView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && com.baidu.live.x.a.NN().bhy.aIO.aLK) {
                        PkRankView.this.setInSeason(((Boolean) customResponsedMessage.getData()).booleanValue());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hib);
        }
    }

    public boolean vB(int i) {
        if (this.hhZ < 10 || this.hhZ > 30 || i >= 10 || i == 1) {
            if (this.hhZ == 4 && i < 4) {
                this.hhU.hgm.bZU();
                this.hhU.ccO();
                return false;
            }
            if (i >= 10 && i < 30) {
                if (this.hhY != null && this.hhY.pkStatusInfoData != null) {
                    ez(this.hhY.pkStatusInfoData.pkID);
                } else {
                    ez(-1L);
                }
            } else {
                ez(-1L);
            }
            this.hhZ = i;
            return true;
        }
        return false;
    }

    public void ez(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, Long.valueOf(j)));
    }

    public void onDestroy() {
        if (this.hhX != null) {
            this.hhX.bZR();
        }
        this.hhU.onDestroy();
        this.hhV.onDestroy();
        this.hhW.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hia);
        MessageManager.getInstance().unRegisterListener(this.hib);
    }
}
