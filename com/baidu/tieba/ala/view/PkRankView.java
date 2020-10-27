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
    w aJv;
    Context context;
    boolean hGP;
    PkRankEnterView hJn;
    PkRankInView hJo;
    PkRankResultView hJp;
    private l hJq;
    PkInfoData hJr;
    public int hJs;
    CustomMessageListener hJt;
    CustomMessageListener hJu;
    boolean hJv;
    boolean isHost;
    private View mView;

    public PkRankView(Context context, boolean z, w wVar) {
        this(context, null);
        this.isHost = z;
        this.aJv = wVar;
    }

    public PkRankView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hJs = -1;
        this.hGP = true;
        this.hJv = false;
        this.context = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_pk_rank_view_layout, (ViewGroup) this, true);
        this.hJn = (PkRankEnterView) this.mView.findViewById(a.g.enter_view);
        this.hJn.setPkRankView(this);
        this.hJo = (PkRankInView) this.mView.findViewById(a.g.in_view);
        this.hJo.setPkRankView(this);
        this.hJp = (PkRankResultView) this.mView.findViewById(a.g.result_view);
        this.hJp.setPkRankView(this);
        cjx();
        ckd();
    }

    public void cjZ() {
        if (this.aJv.mLiveInfo.pkId == 0) {
            if (this.isHost) {
                cka();
                this.hJn.wy(1);
                return;
            }
            postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PkRankView.this.aJv.mLiveInfo.pkId == 0) {
                        PkRankView.this.cjx();
                    }
                }
            }, 6000L);
        } else if (!getGetPkInfoModel().isLoop()) {
            getGetPkInfoModel().a(this.aJv.aIe.userId, this.aJv.mLiveInfo.pkId, this.aJv.mLiveInfo.room_id, this.aJv.mLiveInfo.live_id, this.isHost ? 1 : 0);
        }
    }

    public void f(JSONObject jSONObject, int i) {
        if (this.hJs < 10 || this.hJs > 30 || i >= 10) {
            if ((this.hJs >= 10 && this.hJs < 30) || i <= 10 || i >= 30) {
                if (jSONObject.optLong("pk_id") == 0 || this.hJr == null || this.hJr.pkStatusInfoData.pkID == jSONObject.optLong("pk_id") || i == 10) {
                    if (i != 4 || this.hJs == 1) {
                        if (i < 10 && this.isHost) {
                            this.hJn.d(jSONObject, i);
                        } else if (i >= 10 && i < 30) {
                            this.hJo.e(jSONObject, i);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cka() {
        this.hJn.setVisibility(0);
        this.hJo.setVisibility(8);
        this.hJp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckb() {
        this.hJn.setVisibility(8);
        this.hJo.setVisibility(0);
        this.hJp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ckc() {
        this.hJn.setVisibility(8);
        this.hJo.setVisibility(8);
        this.hJp.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjx() {
        this.hJn.setVisibility(8);
        this.hJo.setVisibility(8);
        this.hJp.setVisibility(8);
    }

    public void setCanVisible(boolean z) {
        this.hGP = z;
        this.mView.setVisibility((z && this.hJv) ? 0 : 8);
    }

    public void setInSeason(boolean z) {
        int i = 8;
        this.hJv = z;
        if (this.hGP) {
            this.mView.setVisibility((this.hJs >= 10 || z) ? 0 : 0);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void B(String str, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        String a2 = com.baidu.live.utils.b.a(1, str, this.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aJv.aIA.userId)), ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aJv.aIe.userId)), String.valueOf(this.aJv.mLiveInfo.room_id), String.valueOf(this.aJv.mLiveInfo.live_id), hashMap);
        com.baidu.live.ai.c cVar = new com.baidu.live.ai.c();
        cVar.url = a2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    public l getGetPkInfoModel() {
        if (this.hJq == null) {
            this.hJq = new l();
            this.hJq.a(new l.a() { // from class: com.baidu.tieba.ala.view.PkRankView.2
                @Override // com.baidu.tieba.ala.g.l.a
                public void a(PkInfoData pkInfoData) {
                    if (PkRankView.this.isHost || PkRankView.this.hJr != null || pkInfoData.pkStatusInfoData.pkStatus == 1) {
                        PkRankView.this.l(pkInfoData);
                        if (PkRankView.this.hJr == null || PkRankView.this.hJr.myPkData.userID == pkInfoData.myPkData.userID) {
                            PkRankView.this.hJr = pkInfoData;
                            switch (pkInfoData.pkStatusInfoData.pkStatus) {
                                case 1:
                                    PkRankView.this.hJp.isShowing = false;
                                    PkRankView.this.hJo.a(pkInfoData, 10);
                                    PkRankView.this.hJo.getPkRankPropController().f(pkInfoData);
                                    return;
                                case 2:
                                    PkRankView.this.hJp.isShowing = false;
                                    PkRankView.this.hJo.a(pkInfoData, 30);
                                    return;
                                case 3:
                                    PkRankView.this.hJq.hi(false);
                                    PkRankView.this.hJo.resetView();
                                    PkRankView.this.hJp.b(pkInfoData, 40);
                                    return;
                                case 4:
                                    PkRankView.this.hJq.hi(false);
                                    PkRankView.this.hJp.isShowing = false;
                                    PkRankView.this.hJo.resetView();
                                    PkRankView.this.hJo.setVisibility(8);
                                    PkRankView.this.hJn.wy(1);
                                    return;
                                default:
                                    return;
                            }
                        }
                        return;
                    }
                    PkRankView.this.hJq.hi(false);
                }

                @Override // com.baidu.tieba.ala.g.l.a
                public void bm(int i, String str) {
                }
            });
        }
        return this.hJq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(PkInfoData pkInfoData) {
        if (this.hJr == null || this.hJr.pkStatusInfoData.pkID != pkInfoData.pkStatusInfoData.pkID) {
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

    public void ckd() {
        if (this.hJt == null) {
            this.hJt = new CustomMessageListener(2913233) { // from class: com.baidu.tieba.ala.view.PkRankView.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        PkRankView.this.hJn.hHE.eL(PkRankView.this.aJv.aIe.userId);
                        AlaStatsItem alaStatsItem = new AlaStatsItem();
                        alaStatsItem.addValue("source", "pk_challage_btn_click");
                        AlaStatManager.getInstance().debug("pk_competition_start_match", alaStatsItem);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hJt);
        }
        if (this.hJu == null) {
            this.hJu = new CustomMessageListener(2913237) { // from class: com.baidu.tieba.ala.view.PkRankView.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && com.baidu.live.z.a.Pq().bmJ.aMw.aPu) {
                        PkRankView.this.setInSeason(((Boolean) customResponsedMessage.getData()).booleanValue());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hJu);
        }
    }

    public boolean wA(int i) {
        if (this.hJs < 10 || this.hJs > 30 || i >= 10 || i == 1) {
            if (this.hJs == 4 && i < 4) {
                this.hJn.hHE.cgu();
                this.hJn.cjr();
                return false;
            }
            if (i >= 10 && i < 30) {
                if (this.hJr != null && this.hJr.pkStatusInfoData != null) {
                    eR(this.hJr.pkStatusInfoData.pkID);
                } else {
                    eR(-1L);
                }
            } else {
                eR(-1L);
            }
            this.hJs = i;
            return true;
        }
        return false;
    }

    public void eR(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, Long.valueOf(j)));
    }

    public void onDestroy() {
        if (this.hJq != null) {
            this.hJq.cgr();
        }
        this.hJn.onDestroy();
        this.hJo.onDestroy();
        this.hJp.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hJt);
        MessageManager.getInstance().unRegisterListener(this.hJu);
    }
}
