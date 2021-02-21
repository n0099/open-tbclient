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
import com.baidu.live.data.ab;
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
    ab aJZ;
    CustomMessageListener boU;
    Context context;
    View fHe;
    boolean ikl;
    CustomMessageListener inA;
    boolean inB;
    private CustomMessageListener inC;
    private boolean inD;
    private a inE;
    private boolean inF;

    /* renamed from: int  reason: not valid java name */
    private boolean f4int;
    PkRankEnterView inu;
    public PkRankInView inv;
    PkRankResultView inw;
    private l inx;
    PkInfoData iny;
    public int inz;
    boolean isHost;
    private View mView;

    /* loaded from: classes11.dex */
    public interface a {
        void mZ(boolean z);
    }

    public PkRankView(Context context, boolean z, ab abVar) {
        this(context, null);
        this.isHost = z;
        this.aJZ = abVar;
    }

    public PkRankView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4int = false;
        this.inz = -1;
        this.ikl = true;
        this.inB = false;
        this.inD = false;
        this.inF = false;
        this.context = context;
        initView();
    }

    public final void initView() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.sdk_pk_rank_view_layout, (ViewGroup) this, true);
        this.fHe = this.mView.findViewById(a.f.pk_rank_container_view);
        this.inu = (PkRankEnterView) this.mView.findViewById(a.f.enter_view);
        this.inu.setPkRankView(this);
        this.inv = (PkRankInView) this.mView.findViewById(a.f.in_view);
        this.inv.setPkRankView(this);
        this.inw = (PkRankResultView) this.mView.findViewById(a.f.result_view);
        this.inw.setPkRankView(this);
        cpW();
        cqD();
        cqE();
    }

    public View getContainerView() {
        return this.fHe;
    }

    public void cqy() {
        if (this.aJZ.mLiveInfo.pkId == 0) {
            if (this.isHost) {
                cqz();
                this.inu.wH(1);
                return;
            }
            postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankView.this.aJZ.mLiveInfo.pkId == 0) {
                        PkRankView.this.cpW();
                    }
                }
            }, 6000L);
            if (this.inE != null) {
                this.inE.mZ(false);
                return;
            }
            return;
        }
        getGetPkInfoModel().a(this.aJZ.aId.userId, this.aJZ.mLiveInfo.pkId, this.aJZ.mLiveInfo.room_id, this.aJZ.mLiveInfo.live_id, this.isHost ? 1 : 0);
    }

    public void f(JSONObject jSONObject, int i) {
        if (this.inz < 10 || this.inz > 30 || i >= 10) {
            if ((this.inz >= 10 && this.inz < 30) || i <= 10 || i >= 30) {
                if (jSONObject.optLong("pk_id") == 0 || this.iny == null || this.iny.pkStatusInfoData.pkID == jSONObject.optLong("pk_id") || i == 10) {
                    if (i != 4 || this.inz == 1) {
                        if (i < 10 && this.isHost) {
                            this.inu.d(jSONObject, i);
                        } else if (i >= 10 && i < 30) {
                            this.inv.e(jSONObject, i);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqz() {
        this.inu.setVisibility(0);
        this.inv.setVisibility(8);
        this.inw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqA() {
        this.inu.setVisibility(8);
        this.inv.setVisibility(0);
        this.inw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqB() {
        this.inu.setVisibility(8);
        this.inv.setVisibility(8);
        this.inw.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpW() {
        this.inu.setVisibility(8);
        this.inv.setVisibility(8);
        this.inw.setVisibility(8);
    }

    public void setCanVisible(boolean z) {
        boolean z2 = false;
        this.ikl = z;
        this.mView.setVisibility((z && this.inB) ? 0 : 8);
        if (this.inE != null) {
            a aVar = this.inE;
            if (z && this.inB) {
                z2 = true;
            }
            aVar.mZ(z2);
        }
    }

    public void setInSeason(boolean z) {
        int i = 8;
        boolean z2 = false;
        this.inB = z;
        if (this.ikl) {
            View view = this.mView;
            if (this.inz >= 10 || z) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.inE != null) {
                this.inE.mZ((this.inz >= 10 || z) ? true : true);
                return;
            }
            return;
        }
        this.mView.setVisibility(8);
        if (this.inE != null) {
            this.inE.mZ(false);
        }
    }

    public void A(String str, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        String a2 = com.baidu.live.utils.b.a(1, str, this.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aJZ.aIz.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aJZ.aId.userId)), String.valueOf(this.aJZ.mLiveInfo.room_id), String.valueOf(this.aJZ.mLiveInfo.live_id), hashMap);
        com.baidu.live.an.c cVar = new com.baidu.live.an.c();
        cVar.url = a2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    public l getGetPkInfoModel() {
        if (this.inx == null) {
            this.inx = new l();
            this.inx.a(new l.a() { // from class: com.baidu.tieba.ala.view.PkRankView.2
                @Override // com.baidu.tieba.ala.g.l.a
                public void a(final PkInfoData pkInfoData) {
                    if (PkRankView.this.isHost || PkRankView.this.iny != null || pkInfoData.pkStatusInfoData.pkStatus == 1) {
                        PkRankView.this.m(pkInfoData);
                        if (PkRankView.this.iny == null || PkRankView.this.iny.myPkData.userID == pkInfoData.myPkData.userID) {
                            PkRankView.this.post(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PkRankView.this.iny == null) {
                                        PkRankView.this.iny = pkInfoData;
                                    }
                                    if (pkInfoData.pkStatusInfoData.pkID != PkRankView.this.iny.pkStatusInfoData.pkID) {
                                        PkRankView.this.inF = false;
                                        PkRankView.this.inD = false;
                                        PkRankView.this.inv.cpX();
                                    }
                                    PkRankView.this.iny = pkInfoData;
                                    PkRankView.this.cqC();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    PkRankView.this.inx.cmn();
                }

                @Override // com.baidu.tieba.ala.g.l.a
                public void bw(int i, String str) {
                }
            });
        }
        return this.inx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqC() {
        if ((this.inF && this.iny.pkStatusInfoData.pkStatus == 3) || this.iny.pkStatusInfoData.pkStatus == 4) {
            this.inx.cmn();
        }
        if (!this.inF && this.iny.killInfoData.status == 3 && this.iny.killInfoData.winner == this.iny.myPkData.userID) {
            this.inD = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913291, ""));
            if (!this.isHost && this.iny.pkStatusInfoData.pkStatus == 1) {
                getGetPkInfoModel().a(this.aJZ.aId.userId, this.aJZ.mLiveInfo.pkId, this.aJZ.mLiveInfo.room_id, this.aJZ.mLiveInfo.live_id, this.isHost ? 1 : 0);
            }
            this.inv.eG("pk_competition_kill_mode", "play_kill");
        }
        if (!this.inF && this.iny.killInfoData.status == 4 && this.iny.killInfoData.winner == this.iny.myPkData.userID) {
            this.inD = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913295, ""));
            this.inv.eG("pk_competition_kill_mode", "play_anti_kill");
            if (!this.isHost && this.iny.pkStatusInfoData.pkStatus == 1) {
                getGetPkInfoModel().a(this.aJZ.aId.userId, this.aJZ.mLiveInfo.pkId, this.aJZ.mLiveInfo.room_id, this.aJZ.mLiveInfo.live_id, this.isHost ? 1 : 0);
            }
        }
        if (!this.inD) {
            switch (this.iny.pkStatusInfoData.pkStatus) {
                case 1:
                    this.inw.isShowing = false;
                    this.inv.a(this.iny, 10);
                    this.inv.getPkRankPropController().g(this.iny);
                    return;
                case 2:
                    this.inw.isShowing = false;
                    this.inv.a(this.iny, 30);
                    return;
                case 3:
                    this.inx.cmn();
                    this.inv.resetView();
                    this.inw.b(this.iny, 40);
                    return;
                case 4:
                    this.inx.cmn();
                    this.inw.isShowing = false;
                    this.inv.resetView();
                    this.inv.setVisibility(8);
                    this.inu.wH(1);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(PkInfoData pkInfoData) {
        if (this.iny == null || this.iny.pkStatusInfoData.pkID != pkInfoData.pkStatusInfoData.pkID) {
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

    public void cqD() {
        if (this.inA == null) {
            this.inA = new CustomMessageListener(2913233) { // from class: com.baidu.tieba.ala.view.PkRankView.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        PkRankView.this.inu.ilc.fR(com.baidu.live.ae.a.Qj().buX.aKw);
                        PkRankView.this.inu.ilc.fQ(PkRankView.this.aJZ.aId.userId);
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("source", "pk_challage_btn_click");
                        AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_challage_btn_click"));
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.inA);
        }
        if (this.boU == null) {
            this.boU = new CustomMessageListener(2913237) { // from class: com.baidu.tieba.ala.view.PkRankView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && com.baidu.live.ae.a.Qj().buX.aNn.aQK) {
                        PkRankView.this.setInSeason(((Boolean) customResponsedMessage.getData()).booleanValue());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.boU);
        }
    }

    public boolean wJ(int i) {
        boolean z = false;
        if (this.inz < 10 || this.inz > 30 || i >= 10 || i == 1) {
            if (this.inz == 4 && i < 4) {
                this.inu.ilc.cmn();
                this.inu.cpQ();
                return false;
            }
            if (i >= 10 && i < 30) {
                if (this.iny != null && this.iny.pkStatusInfoData != null) {
                    fW(this.iny.pkStatusInfoData.pkID);
                } else {
                    fW(-1L);
                }
            } else {
                fW(-1L);
            }
            this.inz = i;
            if (this.inE != null) {
                a aVar = this.inE;
                if (this.isHost || i >= 10) {
                    z = true;
                }
                aVar.mZ(z);
            }
            return true;
        }
        return false;
    }

    public void fW(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, Long.valueOf(j)));
    }

    public void onDestroy() {
        if (this.inx != null) {
            this.inx.cmm();
        }
        this.inF = false;
        this.inu.onDestroy();
        this.inv.onDestroy();
        this.inw.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.inA);
        MessageManager.getInstance().unRegisterListener(this.boU);
        cqF();
        this.inE = null;
    }

    private void cqE() {
        if (this.inC == null) {
            this.inC = new CustomMessageListener(2913294) { // from class: com.baidu.tieba.ala.view.PkRankView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() instanceof String) {
                        PkRankView.this.inD = false;
                        PkRankView.this.inF = true;
                        PkRankView.this.cqC();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.inC);
    }

    private void cqF() {
        if (this.inC != null) {
            MessageManager.getInstance().unRegisterListener(this.inC);
        }
    }

    public boolean getIsAtBottom() {
        return this.f4int;
    }

    public void setIsAtBottom(boolean z) {
        this.f4int = z;
    }

    public void setPkRankViewVisibleListener(a aVar) {
        this.inE = aVar;
    }
}
