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
    w aKv;
    Context context;
    boolean hMM;
    PkRankEnterView hPk;
    PkRankInView hPl;
    PkRankResultView hPm;
    private l hPn;
    PkInfoData hPo;
    public int hPp;
    CustomMessageListener hPq;
    CustomMessageListener hPr;
    boolean hPs;
    boolean isHost;
    private View mView;

    public PkRankView(Context context, boolean z, w wVar) {
        this(context, null);
        this.isHost = z;
        this.aKv = wVar;
    }

    public PkRankView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hPp = -1;
        this.hMM = true;
        this.hPs = false;
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_pk_rank_view_layout, (ViewGroup) this, true);
        this.hPk = (PkRankEnterView) this.mView.findViewById(a.f.enter_view);
        this.hPk.setPkRankView(this);
        this.hPl = (PkRankInView) this.mView.findViewById(a.f.in_view);
        this.hPl.setPkRankView(this);
        this.hPm = (PkRankResultView) this.mView.findViewById(a.f.result_view);
        this.hPm.setPkRankView(this);
        clZ();
        cmF();
    }

    public void cmB() {
        if (this.aKv.mLiveInfo.pkId == 0) {
            if (this.isHost) {
                cmC();
                this.hPk.wL(1);
                return;
            }
            postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankView.this.aKv.mLiveInfo.pkId == 0) {
                        PkRankView.this.clZ();
                    }
                }
            }, 6000L);
        } else if (!getGetPkInfoModel().isLoop()) {
            getGetPkInfoModel().a(this.aKv.aIV.userId, this.aKv.mLiveInfo.pkId, this.aKv.mLiveInfo.room_id, this.aKv.mLiveInfo.live_id, this.isHost ? 1 : 0);
        }
    }

    public void f(JSONObject jSONObject, int i) {
        if (this.hPp < 10 || this.hPp > 30 || i >= 10) {
            if ((this.hPp >= 10 && this.hPp < 30) || i <= 10 || i >= 30) {
                if (jSONObject.optLong("pk_id") == 0 || this.hPo == null || this.hPo.pkStatusInfoData.pkID == jSONObject.optLong("pk_id") || i == 10) {
                    if (i != 4 || this.hPp == 1) {
                        if (i < 10 && this.isHost) {
                            this.hPk.d(jSONObject, i);
                        } else if (i >= 10 && i < 30) {
                            this.hPl.e(jSONObject, i);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cmC() {
        this.hPk.setVisibility(0);
        this.hPl.setVisibility(8);
        this.hPm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cmD() {
        this.hPk.setVisibility(8);
        this.hPl.setVisibility(0);
        this.hPm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cmE() {
        this.hPk.setVisibility(8);
        this.hPl.setVisibility(8);
        this.hPm.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clZ() {
        this.hPk.setVisibility(8);
        this.hPl.setVisibility(8);
        this.hPm.setVisibility(8);
    }

    public void setCanVisible(boolean z) {
        this.hMM = z;
        this.mView.setVisibility((z && this.hPs) ? 0 : 8);
    }

    public void setInSeason(boolean z) {
        int i = 8;
        this.hPs = z;
        if (this.hMM) {
            this.mView.setVisibility((this.hPp >= 10 || z) ? 0 : 0);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void B(String str, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        String a2 = com.baidu.live.utils.b.a(1, str, this.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aKv.aJr.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aKv.aIV.userId)), String.valueOf(this.aKv.mLiveInfo.room_id), String.valueOf(this.aKv.mLiveInfo.live_id), hashMap);
        com.baidu.live.ak.c cVar = new com.baidu.live.ak.c();
        cVar.url = a2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    public l getGetPkInfoModel() {
        if (this.hPn == null) {
            this.hPn = new l();
            this.hPn.a(new l.a() { // from class: com.baidu.tieba.ala.view.PkRankView.2
                @Override // com.baidu.tieba.ala.g.l.a
                public void a(PkInfoData pkInfoData) {
                    if (PkRankView.this.isHost || PkRankView.this.hPo != null || pkInfoData.pkStatusInfoData.pkStatus == 1) {
                        PkRankView.this.l(pkInfoData);
                        if (PkRankView.this.hPo == null || PkRankView.this.hPo.myPkData.userID == pkInfoData.myPkData.userID) {
                            PkRankView.this.hPo = pkInfoData;
                            switch (pkInfoData.pkStatusInfoData.pkStatus) {
                                case 1:
                                    PkRankView.this.hPm.isShowing = false;
                                    PkRankView.this.hPl.a(pkInfoData, 10);
                                    PkRankView.this.hPl.getPkRankPropController().f(pkInfoData);
                                    return;
                                case 2:
                                    PkRankView.this.hPm.isShowing = false;
                                    PkRankView.this.hPl.a(pkInfoData, 30);
                                    return;
                                case 3:
                                    PkRankView.this.hPn.hr(false);
                                    PkRankView.this.hPl.resetView();
                                    PkRankView.this.hPm.b(pkInfoData, 40);
                                    return;
                                case 4:
                                    PkRankView.this.hPn.hr(false);
                                    PkRankView.this.hPm.isShowing = false;
                                    PkRankView.this.hPl.resetView();
                                    PkRankView.this.hPl.setVisibility(8);
                                    PkRankView.this.hPk.wL(1);
                                    return;
                                default:
                                    return;
                            }
                        }
                        return;
                    }
                    PkRankView.this.hPn.hr(false);
                }

                @Override // com.baidu.tieba.ala.g.l.a
                public void bq(int i, String str) {
                }
            });
        }
        return this.hPn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(PkInfoData pkInfoData) {
        if (this.hPo == null || this.hPo.pkStatusInfoData.pkID != pkInfoData.pkStatusInfoData.pkID) {
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

    public void cmF() {
        if (this.hPq == null) {
            this.hPq = new CustomMessageListener(2913233) { // from class: com.baidu.tieba.ala.view.PkRankView.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        PkRankView.this.hPk.hNB.fh(PkRankView.this.aKv.aIV.userId);
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("source", "pk_challage_btn_click");
                        AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hPq);
        }
        if (this.hPr == null) {
            this.hPr = new CustomMessageListener(2913237) { // from class: com.baidu.tieba.ala.view.PkRankView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && com.baidu.live.aa.a.PQ().bod.aNw.aQr) {
                        PkRankView.this.setInSeason(((Boolean) customResponsedMessage.getData()).booleanValue());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hPr);
        }
    }

    public boolean wN(int i) {
        if (this.hPp < 10 || this.hPp > 30 || i >= 10 || i == 1) {
            if (this.hPp == 4 && i < 4) {
                this.hPk.hNB.ciW();
                this.hPk.clT();
                return false;
            }
            if (i >= 10 && i < 30) {
                if (this.hPo != null && this.hPo.pkStatusInfoData != null) {
                    fn(this.hPo.pkStatusInfoData.pkID);
                } else {
                    fn(-1L);
                }
            } else {
                fn(-1L);
            }
            this.hPp = i;
            return true;
        }
        return false;
    }

    public void fn(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, Long.valueOf(j)));
    }

    public void onDestroy() {
        if (this.hPn != null) {
            this.hPn.ciT();
        }
        this.hPk.onDestroy();
        this.hPl.onDestroy();
        this.hPm.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hPq);
        MessageManager.getInstance().unRegisterListener(this.hPr);
    }
}
