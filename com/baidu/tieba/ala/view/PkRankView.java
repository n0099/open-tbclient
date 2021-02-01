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
    boolean ijX;
    private boolean ine;
    PkRankEnterView inf;
    public PkRankInView ing;
    PkRankResultView inh;
    private l ini;
    PkInfoData inj;
    public int ink;
    CustomMessageListener inl;
    boolean inm;
    private CustomMessageListener inn;
    private boolean ino;
    private a inp;
    private boolean inq;
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
        this.ine = false;
        this.ink = -1;
        this.ijX = true;
        this.inm = false;
        this.ino = false;
        this.inq = false;
        this.context = context;
        initView();
    }

    public final void initView() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.sdk_pk_rank_view_layout, (ViewGroup) this, true);
        this.fHe = this.mView.findViewById(a.f.pk_rank_container_view);
        this.inf = (PkRankEnterView) this.mView.findViewById(a.f.enter_view);
        this.inf.setPkRankView(this);
        this.ing = (PkRankInView) this.mView.findViewById(a.f.in_view);
        this.ing.setPkRankView(this);
        this.inh = (PkRankResultView) this.mView.findViewById(a.f.result_view);
        this.inh.setPkRankView(this);
        cpP();
        cqw();
        cqx();
    }

    public View getContainerView() {
        return this.fHe;
    }

    public void cqr() {
        if (this.aJZ.mLiveInfo.pkId == 0) {
            if (this.isHost) {
                cqs();
                this.inf.wH(1);
                return;
            }
            postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankView.this.aJZ.mLiveInfo.pkId == 0) {
                        PkRankView.this.cpP();
                    }
                }
            }, 6000L);
            if (this.inp != null) {
                this.inp.mZ(false);
                return;
            }
            return;
        }
        getGetPkInfoModel().a(this.aJZ.aId.userId, this.aJZ.mLiveInfo.pkId, this.aJZ.mLiveInfo.room_id, this.aJZ.mLiveInfo.live_id, this.isHost ? 1 : 0);
    }

    public void f(JSONObject jSONObject, int i) {
        if (this.ink < 10 || this.ink > 30 || i >= 10) {
            if ((this.ink >= 10 && this.ink < 30) || i <= 10 || i >= 30) {
                if (jSONObject.optLong("pk_id") == 0 || this.inj == null || this.inj.pkStatusInfoData.pkID == jSONObject.optLong("pk_id") || i == 10) {
                    if (i != 4 || this.ink == 1) {
                        if (i < 10 && this.isHost) {
                            this.inf.d(jSONObject, i);
                        } else if (i >= 10 && i < 30) {
                            this.ing.e(jSONObject, i);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqs() {
        this.inf.setVisibility(0);
        this.ing.setVisibility(8);
        this.inh.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqt() {
        this.inf.setVisibility(8);
        this.ing.setVisibility(0);
        this.inh.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqu() {
        this.inf.setVisibility(8);
        this.ing.setVisibility(8);
        this.inh.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpP() {
        this.inf.setVisibility(8);
        this.ing.setVisibility(8);
        this.inh.setVisibility(8);
    }

    public void setCanVisible(boolean z) {
        boolean z2 = false;
        this.ijX = z;
        this.mView.setVisibility((z && this.inm) ? 0 : 8);
        if (this.inp != null) {
            a aVar = this.inp;
            if (z && this.inm) {
                z2 = true;
            }
            aVar.mZ(z2);
        }
    }

    public void setInSeason(boolean z) {
        int i = 8;
        boolean z2 = false;
        this.inm = z;
        if (this.ijX) {
            View view = this.mView;
            if (this.ink >= 10 || z) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.inp != null) {
                this.inp.mZ((this.ink >= 10 || z) ? true : true);
                return;
            }
            return;
        }
        this.mView.setVisibility(8);
        if (this.inp != null) {
            this.inp.mZ(false);
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
        if (this.ini == null) {
            this.ini = new l();
            this.ini.a(new l.a() { // from class: com.baidu.tieba.ala.view.PkRankView.2
                @Override // com.baidu.tieba.ala.g.l.a
                public void a(final PkInfoData pkInfoData) {
                    if (PkRankView.this.isHost || PkRankView.this.inj != null || pkInfoData.pkStatusInfoData.pkStatus == 1) {
                        PkRankView.this.m(pkInfoData);
                        if (PkRankView.this.inj == null || PkRankView.this.inj.myPkData.userID == pkInfoData.myPkData.userID) {
                            PkRankView.this.post(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PkRankView.this.inj == null) {
                                        PkRankView.this.inj = pkInfoData;
                                    }
                                    if (pkInfoData.pkStatusInfoData.pkID != PkRankView.this.inj.pkStatusInfoData.pkID) {
                                        PkRankView.this.inq = false;
                                        PkRankView.this.ino = false;
                                        PkRankView.this.ing.cpQ();
                                    }
                                    PkRankView.this.inj = pkInfoData;
                                    PkRankView.this.cqv();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    PkRankView.this.ini.cmg();
                }

                @Override // com.baidu.tieba.ala.g.l.a
                public void bw(int i, String str) {
                }
            });
        }
        return this.ini;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqv() {
        if ((this.inq && this.inj.pkStatusInfoData.pkStatus == 3) || this.inj.pkStatusInfoData.pkStatus == 4) {
            this.ini.cmg();
        }
        if (!this.inq && this.inj.killInfoData.status == 3 && this.inj.killInfoData.winner == this.inj.myPkData.userID) {
            this.ino = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913291, ""));
            if (!this.isHost && this.inj.pkStatusInfoData.pkStatus == 1) {
                getGetPkInfoModel().a(this.aJZ.aId.userId, this.aJZ.mLiveInfo.pkId, this.aJZ.mLiveInfo.room_id, this.aJZ.mLiveInfo.live_id, this.isHost ? 1 : 0);
            }
            this.ing.eG("pk_competition_kill_mode", "play_kill");
        }
        if (!this.inq && this.inj.killInfoData.status == 4 && this.inj.killInfoData.winner == this.inj.myPkData.userID) {
            this.ino = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913295, ""));
            this.ing.eG("pk_competition_kill_mode", "play_anti_kill");
            if (!this.isHost && this.inj.pkStatusInfoData.pkStatus == 1) {
                getGetPkInfoModel().a(this.aJZ.aId.userId, this.aJZ.mLiveInfo.pkId, this.aJZ.mLiveInfo.room_id, this.aJZ.mLiveInfo.live_id, this.isHost ? 1 : 0);
            }
        }
        if (!this.ino) {
            switch (this.inj.pkStatusInfoData.pkStatus) {
                case 1:
                    this.inh.isShowing = false;
                    this.ing.a(this.inj, 10);
                    this.ing.getPkRankPropController().g(this.inj);
                    return;
                case 2:
                    this.inh.isShowing = false;
                    this.ing.a(this.inj, 30);
                    return;
                case 3:
                    this.ini.cmg();
                    this.ing.resetView();
                    this.inh.b(this.inj, 40);
                    return;
                case 4:
                    this.ini.cmg();
                    this.inh.isShowing = false;
                    this.ing.resetView();
                    this.ing.setVisibility(8);
                    this.inf.wH(1);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(PkInfoData pkInfoData) {
        if (this.inj == null || this.inj.pkStatusInfoData.pkID != pkInfoData.pkStatusInfoData.pkID) {
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

    public void cqw() {
        if (this.inl == null) {
            this.inl = new CustomMessageListener(2913233) { // from class: com.baidu.tieba.ala.view.PkRankView.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        PkRankView.this.inf.ikO.fR(com.baidu.live.ae.a.Qj().buX.aKw);
                        PkRankView.this.inf.ikO.fQ(PkRankView.this.aJZ.aId.userId);
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("source", "pk_challage_btn_click");
                        AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_challage_btn_click"));
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.inl);
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
        if (this.ink < 10 || this.ink > 30 || i >= 10 || i == 1) {
            if (this.ink == 4 && i < 4) {
                this.inf.ikO.cmg();
                this.inf.cpJ();
                return false;
            }
            if (i >= 10 && i < 30) {
                if (this.inj != null && this.inj.pkStatusInfoData != null) {
                    fW(this.inj.pkStatusInfoData.pkID);
                } else {
                    fW(-1L);
                }
            } else {
                fW(-1L);
            }
            this.ink = i;
            if (this.inp != null) {
                a aVar = this.inp;
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
        if (this.ini != null) {
            this.ini.cmf();
        }
        this.inq = false;
        this.inf.onDestroy();
        this.ing.onDestroy();
        this.inh.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.inl);
        MessageManager.getInstance().unRegisterListener(this.boU);
        cqy();
        this.inp = null;
    }

    private void cqx() {
        if (this.inn == null) {
            this.inn = new CustomMessageListener(2913294) { // from class: com.baidu.tieba.ala.view.PkRankView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() instanceof String) {
                        PkRankView.this.ino = false;
                        PkRankView.this.inq = true;
                        PkRankView.this.cqv();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.inn);
    }

    private void cqy() {
        if (this.inn != null) {
            MessageManager.getInstance().unRegisterListener(this.inn);
        }
    }

    public boolean getIsAtBottom() {
        return this.ine;
    }

    public void setIsAtBottom(boolean z) {
        this.ine = z;
    }

    public void setPkRankViewVisibleListener(a aVar) {
        this.inp = aVar;
    }
}
