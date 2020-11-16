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
    w aIK;
    Context context;
    boolean hMt;
    PkRankEnterView hOR;
    PkRankInView hOS;
    PkRankResultView hOT;
    private l hOU;
    PkInfoData hOV;
    public int hOW;
    CustomMessageListener hOX;
    CustomMessageListener hOY;
    boolean hOZ;
    boolean isHost;
    private View mView;

    public PkRankView(Context context, boolean z, w wVar) {
        this(context, null);
        this.isHost = z;
        this.aIK = wVar;
    }

    public PkRankView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hOW = -1;
        this.hMt = true;
        this.hOZ = false;
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_view_layout, (ViewGroup) this, true);
        this.hOR = (PkRankEnterView) this.mView.findViewById(a.f.enter_view);
        this.hOR.setPkRankView(this);
        this.hOS = (PkRankInView) this.mView.findViewById(a.f.in_view);
        this.hOS.setPkRankView(this);
        this.hOT = (PkRankResultView) this.mView.findViewById(a.f.result_view);
        this.hOT.setPkRankView(this);
        cls();
        clY();
    }

    public void clU() {
        if (this.aIK.mLiveInfo.pkId == 0) {
            if (this.isHost) {
                clV();
                this.hOR.xj(1);
                return;
            }
            postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankView.this.aIK.mLiveInfo.pkId == 0) {
                        PkRankView.this.cls();
                    }
                }
            }, 6000L);
        } else if (!getGetPkInfoModel().isLoop()) {
            getGetPkInfoModel().a(this.aIK.aHk.userId, this.aIK.mLiveInfo.pkId, this.aIK.mLiveInfo.room_id, this.aIK.mLiveInfo.live_id, this.isHost ? 1 : 0);
        }
    }

    public void f(JSONObject jSONObject, int i) {
        if (this.hOW < 10 || this.hOW > 30 || i >= 10) {
            if ((this.hOW >= 10 && this.hOW < 30) || i <= 10 || i >= 30) {
                if (jSONObject.optLong("pk_id") == 0 || this.hOV == null || this.hOV.pkStatusInfoData.pkID == jSONObject.optLong("pk_id") || i == 10) {
                    if (i != 4 || this.hOW == 1) {
                        if (i < 10 && this.isHost) {
                            this.hOR.d(jSONObject, i);
                        } else if (i >= 10 && i < 30) {
                            this.hOS.e(jSONObject, i);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clV() {
        this.hOR.setVisibility(0);
        this.hOS.setVisibility(8);
        this.hOT.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clW() {
        this.hOR.setVisibility(8);
        this.hOS.setVisibility(0);
        this.hOT.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clX() {
        this.hOR.setVisibility(8);
        this.hOS.setVisibility(8);
        this.hOT.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cls() {
        this.hOR.setVisibility(8);
        this.hOS.setVisibility(8);
        this.hOT.setVisibility(8);
    }

    public void setCanVisible(boolean z) {
        this.hMt = z;
        this.mView.setVisibility((z && this.hOZ) ? 0 : 8);
    }

    public void setInSeason(boolean z) {
        int i = 8;
        this.hOZ = z;
        if (this.hMt) {
            this.mView.setVisibility((this.hOW >= 10 || z) ? 0 : 0);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void B(String str, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        String a2 = com.baidu.live.utils.b.a(1, str, this.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aIK.aHG.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aIK.aHk.userId)), String.valueOf(this.aIK.mLiveInfo.room_id), String.valueOf(this.aIK.mLiveInfo.live_id), hashMap);
        com.baidu.live.ak.c cVar = new com.baidu.live.ak.c();
        cVar.url = a2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    public l getGetPkInfoModel() {
        if (this.hOU == null) {
            this.hOU = new l();
            this.hOU.a(new l.a() { // from class: com.baidu.tieba.ala.view.PkRankView.2
                @Override // com.baidu.tieba.ala.g.l.a
                public void a(PkInfoData pkInfoData) {
                    if (PkRankView.this.isHost || PkRankView.this.hOV != null || pkInfoData.pkStatusInfoData.pkStatus == 1) {
                        PkRankView.this.l(pkInfoData);
                        if (PkRankView.this.hOV == null || PkRankView.this.hOV.myPkData.userID == pkInfoData.myPkData.userID) {
                            PkRankView.this.hOV = pkInfoData;
                            switch (pkInfoData.pkStatusInfoData.pkStatus) {
                                case 1:
                                    PkRankView.this.hOT.isShowing = false;
                                    PkRankView.this.hOS.a(pkInfoData, 10);
                                    PkRankView.this.hOS.getPkRankPropController().f(pkInfoData);
                                    return;
                                case 2:
                                    PkRankView.this.hOT.isShowing = false;
                                    PkRankView.this.hOS.a(pkInfoData, 30);
                                    return;
                                case 3:
                                    PkRankView.this.hOU.hu(false);
                                    PkRankView.this.hOS.resetView();
                                    PkRankView.this.hOT.b(pkInfoData, 40);
                                    return;
                                case 4:
                                    PkRankView.this.hOU.hu(false);
                                    PkRankView.this.hOT.isShowing = false;
                                    PkRankView.this.hOS.resetView();
                                    PkRankView.this.hOS.setVisibility(8);
                                    PkRankView.this.hOR.xj(1);
                                    return;
                                default:
                                    return;
                            }
                        }
                        return;
                    }
                    PkRankView.this.hOU.hu(false);
                }

                @Override // com.baidu.tieba.ala.g.l.a
                public void bo(int i, String str) {
                }
            });
        }
        return this.hOU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(PkInfoData pkInfoData) {
        if (this.hOV == null || this.hOV.pkStatusInfoData.pkID != pkInfoData.pkStatusInfoData.pkID) {
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

    public void clY() {
        if (this.hOX == null) {
            this.hOX = new CustomMessageListener(2913233) { // from class: com.baidu.tieba.ala.view.PkRankView.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        PkRankView.this.hOR.hNi.fh(PkRankView.this.aIK.aHk.userId);
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("source", "pk_challage_btn_click");
                        AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hOX);
        }
        if (this.hOY == null) {
            this.hOY = new CustomMessageListener(2913237) { // from class: com.baidu.tieba.ala.view.PkRankView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && com.baidu.live.aa.a.Ph().bms.aLL.aOG) {
                        PkRankView.this.setInSeason(((Boolean) customResponsedMessage.getData()).booleanValue());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hOY);
        }
    }

    public boolean xl(int i) {
        if (this.hOW < 10 || this.hOW > 30 || i >= 10 || i == 1) {
            if (this.hOW == 4 && i < 4) {
                this.hOR.hNi.cip();
                this.hOR.clm();
                return false;
            }
            if (i >= 10 && i < 30) {
                if (this.hOV != null && this.hOV.pkStatusInfoData != null) {
                    fn(this.hOV.pkStatusInfoData.pkID);
                } else {
                    fn(-1L);
                }
            } else {
                fn(-1L);
            }
            this.hOW = i;
            return true;
        }
        return false;
    }

    public void fn(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, Long.valueOf(j)));
    }

    public void onDestroy() {
        if (this.hOU != null) {
            this.hOU.cim();
        }
        this.hOR.onDestroy();
        this.hOS.onDestroy();
        this.hOT.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hOX);
        MessageManager.getInstance().unRegisterListener(this.hOY);
    }
}
