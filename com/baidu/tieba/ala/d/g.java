package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tieba.ala.view.AlaDragContainerView;
import com.baidu.tieba.ala.view.PkRankView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g implements com.baidu.live.t.a {
    ab aJZ;
    private boolean aQK;
    private View gRV;
    private AlaDragContainerView gRW;
    protected PkRankView gRX;
    com.baidu.tieba.ala.h.e gRY;
    com.baidu.tieba.ala.h.a gRZ;
    private Context mContext;
    private ViewGroup mRootView;
    private boolean isHost = false;
    private CustomMessageListener gSa = new CustomMessageListener(2913301) { // from class: com.baidu.tieba.ala.d.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (g.this.aQK && !g.this.gRW.getIsDragged() && g.this.gRX != null && !g.this.gRX.getIsAtBottom()) {
                g.this.gRX.setIsAtBottom(true);
                g.this.gRW.removeAllViews();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 8388693;
                g.this.gRW.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(BdUtilHelper.px2dip(g.this.mContext, 0.0f), BdUtilHelper.px2dip(g.this.mContext, 0.0f), BdUtilHelper.px2dip(g.this.mContext, 10.0f), BdUtilHelper.px2dip(g.this.mContext, 600.0f));
                g.this.gRW.setMargins(g.this.isHost, true, 0, 0, BdUtilHelper.px2dip(g.this.mContext, 500.0f), BdUtilHelper.px2dip(g.this.mContext, 10.0f));
                g.this.gRW.addView(g.this.gRX, layoutParams2);
            }
        }
    };
    private CustomMessageListener gSb = new CustomMessageListener(2913302) { // from class: com.baidu.tieba.ala.d.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (g.this.aQK && !g.this.gRW.getIsDragged() && g.this.gRX != null && g.this.gRX.getIsAtBottom()) {
                g.this.gRX.setIsAtBottom(false);
                g.this.gRX.setClickable(true);
                g.this.gRW.removeAllViews();
                g.this.gRW.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(BdUtilHelper.px2dip(g.this.mContext, 100.0f), BdUtilHelper.px2dip(g.this.mContext, 850.0f), BdUtilHelper.px2dip(g.this.mContext, 0.0f), BdUtilHelper.px2dip(g.this.mContext, 0.0f));
                g.this.gRW.setMargins(g.this.isHost, false, BdUtilHelper.px2dip(g.this.mContext, 850.0f), BdUtilHelper.px2dip(g.this.mContext, 100.0f), 0, 0);
                g.this.gRW.addView(g.this.gRX, layoutParams);
            }
        }
    };

    public g(Context context) {
        this.aQK = false;
        this.mContext = context;
        if (com.baidu.live.ae.a.Qj().buX.aNn != null) {
            this.aQK = com.baidu.live.ae.a.Qj().buX.aNn.aQK;
        } else {
            this.aQK = false;
        }
        bUh();
    }

    private void bUh() {
        if (this.gRV == null) {
            this.gRV = LayoutInflater.from(this.mContext).inflate(a.g.ala_pk_rank_drag_view, (ViewGroup) null);
            this.gRW = (AlaDragContainerView) this.gRV.findViewById(a.f.ala_pk_rank_dragview);
        }
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.gSb);
        MessageManager.getInstance().registerListener(this.gSa);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gSb);
        MessageManager.getInstance().unRegisterListener(this.gSa);
    }

    @Override // com.baidu.live.t.a
    public void a(ViewGroup viewGroup, ab abVar) {
        this.aJZ = abVar;
        if (viewGroup != null && abVar != null) {
            this.mRootView = viewGroup;
            if (this.gRX == null || (viewGroup != null && viewGroup.indexOfChild(this.gRX) < 0)) {
                this.gRX = new PkRankView(this.mContext, this.isHost, abVar);
                this.gRX.setClickable(true);
                this.gRX.setPkRankViewVisibleListener(new PkRankView.a() { // from class: com.baidu.tieba.ala.d.g.3
                    @Override // com.baidu.tieba.ala.view.PkRankView.a
                    public void mZ(boolean z) {
                        if (g.this.mRootView != null) {
                            if (z) {
                                if (g.this.mRootView.indexOfChild(g.this.gRV) < 0) {
                                    g.this.mRootView.addView(g.this.gRV, new FrameLayout.LayoutParams(-1, -1));
                                    return;
                                }
                                return;
                            }
                            g.this.mRootView.removeView(g.this.gRV);
                        }
                    }
                });
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(BdUtilHelper.px2dip(this.mContext, 100.0f), BdUtilHelper.px2dip(this.mContext, 850.0f), BdUtilHelper.px2dip(this.mContext, 0.0f), BdUtilHelper.px2dip(this.mContext, 0.0f));
                this.gRW.setMargins(this.isHost, false, BdUtilHelper.px2dip(this.mContext, 850.0f), BdUtilHelper.px2dip(this.mContext, 100.0f), 0, 0);
                this.gRW.addView(this.gRX, layoutParams);
            }
            if (this.aQK) {
                if (abVar.aIG) {
                    this.gRX.setInSeason(true);
                } else {
                    this.gRX.setInSeason(false);
                }
                this.gRX.cqy();
                if (this.isHost) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pkId", Long.valueOf(abVar.mLiveInfo.pkId));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_pk", "author_liveroom", "update_live").setContentExt(jSONObject));
                }
                this.gRY = new com.baidu.tieba.ala.h.e();
                this.gRY.PU();
                this.gRY.setParentView(this.gRX.inv.ilj);
                this.gRZ = new com.baidu.tieba.ala.h.a();
                this.gRZ.PU();
                this.gRZ.setParentView(this.gRX.inv.ilj);
                registerListener();
            }
        }
    }

    @Override // com.baidu.live.t.a
    public void a(ab abVar) {
        if (this.aQK) {
            if (abVar.aIG) {
                this.gRX.setInSeason(true);
            } else {
                this.gRX.setInSeason(false);
            }
            if (this.isHost && abVar != null && abVar.mLiveInfo != null && this.aJZ != null && this.aJZ.mLiveInfo != null && abVar.mLiveInfo.pkId != this.aJZ.mLiveInfo.pkId) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pkId", Long.valueOf(abVar.mLiveInfo.pkId));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_pk", "author_liveroom", "live_info").setContentExt(jSONObject));
            }
            this.aJZ = abVar;
            if (abVar != null && abVar.mLiveInfo != null && !this.isHost) {
                this.gRX.cqy();
            }
        }
    }

    @Override // com.baidu.live.t.a
    public boolean J(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        int dI;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            try {
                jSONObject.put("log_id", bVar.getMsgId());
                jSONObject.put("user_id", bVar.getUserId());
            } catch (JSONException e) {
            }
        } catch (JSONException e2) {
            jSONObject = null;
        }
        if (this.aQK && (dI = dI(jSONObject)) != -1) {
            this.gRX.f(jSONObject, dI);
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int dI(JSONObject jSONObject) {
        char c;
        int i = 4;
        if (jSONObject == null) {
            return -1;
        }
        String optString = jSONObject.optString("content_type");
        if (optString == null || optString.isEmpty()) {
        }
        switch (optString.hashCode()) {
            case -1544520243:
                if (optString.equals("pk_invite")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1116887831:
                if (optString.equals("pk_honor_change")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -480236384:
                if (optString.equals("pk_kill_mode")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -415549965:
                if (optString.equals("pk_end_settle")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -101959775:
                if (optString.equals("pk_solo_task")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 43745981:
                if (optString.equals("pk_send_props")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 849249127:
                if (optString.equals("pk_first_blood")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 929402142:
                if (optString.equals("pk_start")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 982000524:
                if (optString.equals("pk_start_settle")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                i = 16;
                break;
            case 1:
                if (this.aJZ.mLiveInfo.room_id == jSONObject.optJSONObject("first_blood_info").optLong("room_id")) {
                    i = 11;
                    break;
                } else {
                    i = 21;
                    break;
                }
            case 2:
                break;
            case 3:
                i = 18;
                break;
            case 4:
                i = 17;
                break;
            case 5:
                i = 10;
                break;
            case 6:
                long optLong = jSONObject.optLong("props_type");
                if (optLong == 1) {
                    if (this.aJZ.mLiveInfo.room_id == jSONObject.optLong("send_room_id")) {
                        i = 14;
                        break;
                    } else {
                        i = 24;
                        break;
                    }
                } else {
                    if (optLong == 2) {
                        if (this.aJZ.mLiveInfo.room_id == jSONObject.optLong("send_room_id")) {
                            i = 12;
                            break;
                        } else {
                            i = 22;
                            break;
                        }
                    }
                    i = -1;
                    break;
                }
            case 7:
                i = 30;
                break;
            case '\b':
                i = 40;
                break;
            default:
                i = -1;
                break;
        }
        if (i != -1) {
            t(optString, jSONObject);
        }
        return i;
    }

    private void t(String str, JSONObject jSONObject) {
        if (!"pk_send_props".equals(str) && !"pk_first_blood".equals(str) && !"pk_honor_change".equals(str)) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue(CameraActivityConfig.KEY_CONTENT_TYPE, str);
            alaStatsItem.addValue("lodId", Long.valueOf(jSONObject.optLong("log_id")));
            if (!"pk_invite".equals(str)) {
                alaStatsItem.addValue("pkId", Long.valueOf(jSONObject.optLong("pk_id")));
            }
            AlaStatManager.getInstance().debug("pk_competition_im_msg", alaStatsItem);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("lodId", Long.valueOf(jSONObject.optLong("log_id")));
                if (!"pk_invite".equals(str)) {
                    alaStatsItem.addValue("pkId", Long.valueOf(jSONObject.optLong("pk_id")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_im_msg", "author_liveroom", CameraActivityConfig.KEY_CONTENT_TYPE).setContentExt(jSONObject2));
        }
    }

    @Override // com.baidu.live.t.a
    public void setCanVisible(boolean z) {
        if (this.gRX != null) {
            this.gRX.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.t.a
    public void xh() {
        onDestroy();
    }

    @Override // com.baidu.live.t.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void mv(boolean z) {
        if (z && this.mRootView != null) {
            this.mRootView.removeView(this.gRV);
        }
        unRegisterListener();
    }

    @Override // com.baidu.live.t.a
    public boolean Aq() {
        return this.gRX.inz >= 10 && this.gRX.inz <= 30;
    }

    @Override // com.baidu.live.t.a
    public boolean Pi() {
        return this.gRX.inz == 2;
    }

    @Override // com.baidu.live.t.a
    public void onDestroy() {
        mv(true);
        if (this.gRY != null) {
            this.gRY.release();
            this.gRY = null;
        }
        if (this.gRZ != null) {
            this.gRZ.release();
            this.gRZ = null;
        }
        if (this.gRX != null) {
            this.gRX.onDestroy();
        }
    }
}
