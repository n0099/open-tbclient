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
/* loaded from: classes10.dex */
public class PkRankView extends RelativeLayout {
    ab aLz;
    CustomMessageListener bqu;
    Context context;
    View fID;
    boolean ilU;
    private boolean ipc;
    PkRankEnterView ipd;
    public PkRankInView ipe;
    PkRankResultView ipf;
    private l ipg;
    PkInfoData iph;
    public int ipi;
    CustomMessageListener ipj;
    boolean ipk;
    private CustomMessageListener ipl;
    private boolean ipm;
    private a ipn;
    private boolean ipo;
    boolean isHost;
    private View mView;

    /* loaded from: classes10.dex */
    public interface a {
        void mZ(boolean z);
    }

    public PkRankView(Context context, boolean z, ab abVar) {
        this(context, null);
        this.isHost = z;
        this.aLz = abVar;
    }

    public PkRankView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ipc = false;
        this.ipi = -1;
        this.ilU = true;
        this.ipk = false;
        this.ipm = false;
        this.ipo = false;
        this.context = context;
        initView();
    }

    public final void initView() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.sdk_pk_rank_view_layout, (ViewGroup) this, true);
        this.fID = this.mView.findViewById(a.f.pk_rank_container_view);
        this.ipd = (PkRankEnterView) this.mView.findViewById(a.f.enter_view);
        this.ipd.setPkRankView(this);
        this.ipe = (PkRankInView) this.mView.findViewById(a.f.in_view);
        this.ipe.setPkRankView(this);
        this.ipf = (PkRankResultView) this.mView.findViewById(a.f.result_view);
        this.ipf.setPkRankView(this);
        cqc();
        cqJ();
        cqK();
    }

    public View getContainerView() {
        return this.fID;
    }

    public void cqE() {
        if (this.aLz.mLiveInfo.pkId == 0) {
            if (this.isHost) {
                cqF();
                this.ipd.wI(1);
                return;
            }
            postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankView.this.aLz.mLiveInfo.pkId == 0) {
                        PkRankView.this.cqc();
                    }
                }
            }, 6000L);
            if (this.ipn != null) {
                this.ipn.mZ(false);
                return;
            }
            return;
        }
        getGetPkInfoModel().a(this.aLz.aJD.userId, this.aLz.mLiveInfo.pkId, this.aLz.mLiveInfo.room_id, this.aLz.mLiveInfo.live_id, this.isHost ? 1 : 0);
    }

    public void f(JSONObject jSONObject, int i) {
        if (this.ipi < 10 || this.ipi > 30 || i >= 10) {
            if ((this.ipi >= 10 && this.ipi < 30) || i <= 10 || i >= 30) {
                if (jSONObject.optLong("pk_id") == 0 || this.iph == null || this.iph.pkStatusInfoData.pkID == jSONObject.optLong("pk_id") || i == 10) {
                    if (i != 4 || this.ipi == 1) {
                        if (i < 10 && this.isHost) {
                            this.ipd.d(jSONObject, i);
                        } else if (i >= 10 && i < 30) {
                            this.ipe.e(jSONObject, i);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqF() {
        this.ipd.setVisibility(0);
        this.ipe.setVisibility(8);
        this.ipf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqG() {
        this.ipd.setVisibility(8);
        this.ipe.setVisibility(0);
        this.ipf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cqH() {
        this.ipd.setVisibility(8);
        this.ipe.setVisibility(8);
        this.ipf.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqc() {
        this.ipd.setVisibility(8);
        this.ipe.setVisibility(8);
        this.ipf.setVisibility(8);
    }

    public void setCanVisible(boolean z) {
        boolean z2 = false;
        this.ilU = z;
        this.mView.setVisibility((z && this.ipk) ? 0 : 8);
        if (this.ipn != null) {
            a aVar = this.ipn;
            if (z && this.ipk) {
                z2 = true;
            }
            aVar.mZ(z2);
        }
    }

    public void setInSeason(boolean z) {
        int i = 8;
        boolean z2 = false;
        this.ipk = z;
        if (this.ilU) {
            View view = this.mView;
            if (this.ipi >= 10 || z) {
                i = 0;
            }
            view.setVisibility(i);
            if (this.ipn != null) {
                this.ipn.mZ((this.ipi >= 10 || z) ? true : true);
                return;
            }
            return;
        }
        this.mView.setVisibility(8);
        if (this.ipn != null) {
            this.ipn.mZ(false);
        }
    }

    public void A(String str, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        String a2 = com.baidu.live.utils.b.a(1, str, this.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aLz.aJZ.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aLz.aJD.userId)), String.valueOf(this.aLz.mLiveInfo.room_id), String.valueOf(this.aLz.mLiveInfo.live_id), hashMap);
        com.baidu.live.an.c cVar = new com.baidu.live.an.c();
        cVar.url = a2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    public l getGetPkInfoModel() {
        if (this.ipg == null) {
            this.ipg = new l();
            this.ipg.a(new l.a() { // from class: com.baidu.tieba.ala.view.PkRankView.2
                @Override // com.baidu.tieba.ala.g.l.a
                public void a(final PkInfoData pkInfoData) {
                    if (PkRankView.this.isHost || PkRankView.this.iph != null || pkInfoData.pkStatusInfoData.pkStatus == 1) {
                        PkRankView.this.m(pkInfoData);
                        if (PkRankView.this.iph == null || PkRankView.this.iph.myPkData.userID == pkInfoData.myPkData.userID) {
                            PkRankView.this.post(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PkRankView.this.iph == null) {
                                        PkRankView.this.iph = pkInfoData;
                                    }
                                    if (pkInfoData.pkStatusInfoData.pkID != PkRankView.this.iph.pkStatusInfoData.pkID) {
                                        PkRankView.this.ipo = false;
                                        PkRankView.this.ipm = false;
                                        PkRankView.this.ipe.cqd();
                                    }
                                    PkRankView.this.iph = pkInfoData;
                                    PkRankView.this.cqI();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    PkRankView.this.ipg.cmt();
                }

                @Override // com.baidu.tieba.ala.g.l.a
                public void bw(int i, String str) {
                }
            });
        }
        return this.ipg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqI() {
        if ((this.ipo && this.iph.pkStatusInfoData.pkStatus == 3) || this.iph.pkStatusInfoData.pkStatus == 4) {
            this.ipg.cmt();
        }
        if (!this.ipo && this.iph.killInfoData.status == 3 && this.iph.killInfoData.winner == this.iph.myPkData.userID) {
            this.ipm = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913291, ""));
            if (!this.isHost && this.iph.pkStatusInfoData.pkStatus == 1) {
                getGetPkInfoModel().a(this.aLz.aJD.userId, this.aLz.mLiveInfo.pkId, this.aLz.mLiveInfo.room_id, this.aLz.mLiveInfo.live_id, this.isHost ? 1 : 0);
            }
            this.ipe.eG("pk_competition_kill_mode", "play_kill");
        }
        if (!this.ipo && this.iph.killInfoData.status == 4 && this.iph.killInfoData.winner == this.iph.myPkData.userID) {
            this.ipm = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913295, ""));
            this.ipe.eG("pk_competition_kill_mode", "play_anti_kill");
            if (!this.isHost && this.iph.pkStatusInfoData.pkStatus == 1) {
                getGetPkInfoModel().a(this.aLz.aJD.userId, this.aLz.mLiveInfo.pkId, this.aLz.mLiveInfo.room_id, this.aLz.mLiveInfo.live_id, this.isHost ? 1 : 0);
            }
        }
        if (!this.ipm) {
            switch (this.iph.pkStatusInfoData.pkStatus) {
                case 1:
                    this.ipf.isShowing = false;
                    this.ipe.a(this.iph, 10);
                    this.ipe.getPkRankPropController().g(this.iph);
                    return;
                case 2:
                    this.ipf.isShowing = false;
                    this.ipe.a(this.iph, 30);
                    return;
                case 3:
                    this.ipg.cmt();
                    this.ipe.resetView();
                    this.ipf.b(this.iph, 40);
                    return;
                case 4:
                    this.ipg.cmt();
                    this.ipf.isShowing = false;
                    this.ipe.resetView();
                    this.ipe.setVisibility(8);
                    this.ipd.wI(1);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(PkInfoData pkInfoData) {
        if (this.iph == null || this.iph.pkStatusInfoData.pkID != pkInfoData.pkStatusInfoData.pkID) {
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

    public void cqJ() {
        if (this.ipj == null) {
            this.ipj = new CustomMessageListener(2913233) { // from class: com.baidu.tieba.ala.view.PkRankView.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        PkRankView.this.ipd.imM.fR(com.baidu.live.ae.a.Qm().bwx.aLW);
                        PkRankView.this.ipd.imM.fQ(PkRankView.this.aLz.aJD.userId);
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("source", "pk_challage_btn_click");
                        AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_match", "author_liveroom", "pk_challage_btn_click"));
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ipj);
        }
        if (this.bqu == null) {
            this.bqu = new CustomMessageListener(2913237) { // from class: com.baidu.tieba.ala.view.PkRankView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && com.baidu.live.ae.a.Qm().bwx.aON.aSk) {
                        PkRankView.this.setInSeason(((Boolean) customResponsedMessage.getData()).booleanValue());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bqu);
        }
    }

    public boolean wK(int i) {
        boolean z = false;
        if (this.ipi < 10 || this.ipi > 30 || i >= 10 || i == 1) {
            if (this.ipi == 4 && i < 4) {
                this.ipd.imM.cmt();
                this.ipd.cpW();
                return false;
            }
            if (i >= 10 && i < 30) {
                if (this.iph != null && this.iph.pkStatusInfoData != null) {
                    fW(this.iph.pkStatusInfoData.pkID);
                } else {
                    fW(-1L);
                }
            } else {
                fW(-1L);
            }
            this.ipi = i;
            if (this.ipn != null) {
                a aVar = this.ipn;
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
        if (this.ipg != null) {
            this.ipg.cms();
        }
        this.ipo = false;
        this.ipd.onDestroy();
        this.ipe.onDestroy();
        this.ipf.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.ipj);
        MessageManager.getInstance().unRegisterListener(this.bqu);
        cqL();
        this.ipn = null;
    }

    private void cqK() {
        if (this.ipl == null) {
            this.ipl = new CustomMessageListener(2913294) { // from class: com.baidu.tieba.ala.view.PkRankView.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() instanceof String) {
                        PkRankView.this.ipm = false;
                        PkRankView.this.ipo = true;
                        PkRankView.this.cqI();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ipl);
    }

    private void cqL() {
        if (this.ipl != null) {
            MessageManager.getInstance().unRegisterListener(this.ipl);
        }
    }

    public boolean getIsAtBottom() {
        return this.ipc;
    }

    public void setIsAtBottom(boolean z) {
        this.ipc = z;
    }

    public void setPkRankViewVisibleListener(a aVar) {
        this.ipn = aVar;
    }
}
