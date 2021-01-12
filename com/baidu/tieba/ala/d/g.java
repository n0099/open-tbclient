package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.data.x;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tieba.ala.view.PkRankView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g implements com.baidu.live.u.a {
    x aHu;
    private boolean aNJ;
    protected PkRankView gPb;
    private PendantParentView glA;
    private PendantChildView glB;
    private boolean isHost = false;
    private Context mContext;

    public g(Context context) {
        this.aNJ = false;
        this.mContext = context;
        if (com.baidu.live.af.a.OJ().bru.aKA != null) {
            this.aNJ = com.baidu.live.af.a.OJ().bru.aKA.aNJ;
        } else {
            this.aNJ = false;
        }
    }

    @Override // com.baidu.live.u.a
    public void a(ViewGroup viewGroup, x xVar) {
        this.aHu = xVar;
        if (viewGroup != null) {
            if (viewGroup instanceof PendantParentView) {
                this.glA = (PendantParentView) viewGroup;
                bNr();
            }
            if (this.gPb == null || (this.glB != null && this.glB.indexOfChild(this.gPb) < 0)) {
                this.gPb = new PkRankView(this.glB.getContext(), this.isHost, xVar);
                this.glB.addView(this.gPb, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.aNJ) {
                this.gPb.cpk();
                if (xVar.aGk) {
                    this.gPb.setInSeason(true);
                } else {
                    this.gPb.setInSeason(false);
                }
                if (this.isHost) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pkId", Long.valueOf(xVar.mLiveInfo.pkId));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_pk", "author_liveroom", "update_live").setContentExt(jSONObject));
                }
            }
        }
    }

    private void bNr() {
        this.glB = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.g.1
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.LEFT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
                return PendantParentView.Position.LEFT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalBBChattingPosition() {
                return PendantParentView.Position.LEFT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalPosition() {
                return PendantParentView.Position.LEFT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalFullPosition() {
                return PendantParentView.Position.LEFT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public int getPriority() {
                return 31;
            }
        };
        this.glB.setBackgroundColor(0);
        if (this.glA != null) {
            this.glA.a(this.glB, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    @Override // com.baidu.live.u.a
    public void a(x xVar) {
        if (this.aNJ) {
            if (this.isHost && xVar != null && xVar.mLiveInfo != null && this.aHu != null && this.aHu.mLiveInfo != null && xVar.mLiveInfo.pkId != this.aHu.mLiveInfo.pkId) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pkId", Long.valueOf(xVar.mLiveInfo.pkId));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_PK_RANK, "pk_competition_start_pk", "author_liveroom", "live_info").setContentExt(jSONObject));
            }
            this.aHu = xVar;
            if (xVar != null && xVar.mLiveInfo != null) {
                if (!this.isHost) {
                    this.gPb.cpk();
                }
                if (xVar.aGk) {
                    this.gPb.setInSeason(true);
                } else {
                    this.gPb.setInSeason(false);
                }
            }
        }
    }

    @Override // com.baidu.live.u.a
    public boolean V(JSONObject jSONObject) {
        int dH;
        if (this.aNJ && (dH = dH(jSONObject)) != -1) {
            this.gPb.f(jSONObject, dH);
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int dH(JSONObject jSONObject) {
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
            case -415549965:
                if (optString.equals("pk_end_settle")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 43745981:
                if (optString.equals("pk_send_props")) {
                    c = 4;
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
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 982000524:
                if (optString.equals("pk_start_settle")) {
                    c = 5;
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
                if (this.aHu.mLiveInfo.room_id == jSONObject.optJSONObject("first_blood_info").optLong("room_id")) {
                    i = 11;
                    break;
                } else {
                    i = 21;
                    break;
                }
            case 2:
                break;
            case 3:
                i = 10;
                break;
            case 4:
                long optLong = jSONObject.optLong("props_type");
                if (optLong == 1) {
                    if (this.aHu.mLiveInfo.room_id == jSONObject.optLong("send_room_id")) {
                        i = 14;
                        break;
                    } else {
                        i = 24;
                        break;
                    }
                } else {
                    if (optLong == 2) {
                        if (this.aHu.mLiveInfo.room_id == jSONObject.optLong("send_room_id")) {
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
            case 5:
                i = 30;
                break;
            case 6:
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

    @Override // com.baidu.live.u.a
    public void setCanVisible(boolean z) {
        if (this.gPb != null) {
            this.gPb.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.u.a
    public void xk() {
        mr(true);
        onDestroy();
    }

    @Override // com.baidu.live.u.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void mr(boolean z) {
        if (this.gPb != null && (this.gPb.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gPb.getParent()).removeView(this.gPb);
        }
        if (z && this.glB != null && (this.glB.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.glB.getParent()).removeView(this.glB);
        }
    }

    @Override // com.baidu.live.u.a
    public boolean zG() {
        return this.gPb.ihH >= 10 && this.gPb.ihH <= 30;
    }

    @Override // com.baidu.live.u.a
    public boolean NG() {
        return this.gPb.ihH == 2;
    }

    @Override // com.baidu.live.u.a
    public void onDestroy() {
        mr(true);
        this.gPb.onDestroy();
    }
}
