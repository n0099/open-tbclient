package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tieba.ala.view.PkRankView;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g implements com.baidu.live.t.a {
    w aLD;
    private boolean aRH;
    private PendantParentView gEi;
    private PendantChildView gEj;
    protected PkRankView gHT;
    private boolean isHost = false;
    private Context mContext;

    public g(Context context) {
        this.aRH = false;
        this.mContext = context;
        if (com.baidu.live.ae.a.RB().brA.aOG != null) {
            this.aRH = com.baidu.live.ae.a.RB().brA.aOG.aRH;
        } else {
            this.aRH = false;
        }
    }

    @Override // com.baidu.live.t.a
    public void a(ViewGroup viewGroup, w wVar) {
        this.aLD = wVar;
        if (viewGroup != null) {
            if (viewGroup instanceof PendantParentView) {
                this.gEi = (PendantParentView) viewGroup;
                bUj();
            }
            if (this.gHT == null || (this.gEj != null && this.gEj.indexOfChild(this.gHT) < 0)) {
                this.gHT = new PkRankView(this.gEj.getContext(), this.isHost, wVar);
                this.gEj.addView(this.gHT, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.aRH) {
                this.gHT.cqh();
                if (wVar.aKy) {
                    this.gHT.setInSeason(true);
                } else {
                    this.gHT.setInSeason(false);
                }
            }
        }
    }

    private void bUj() {
        this.gEj = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.g.1
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.LEFT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
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
        this.gEj.setBackgroundColor(0);
        if (this.gEi != null) {
            this.gEi.a(this.gEj, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    @Override // com.baidu.live.t.a
    public void a(w wVar) {
        if (this.aRH) {
            this.aLD = wVar;
            if (wVar != null && wVar.mLiveInfo != null) {
                if (!this.isHost) {
                    this.gHT.cqh();
                }
                if (wVar.aKy) {
                    this.gHT.setInSeason(true);
                } else {
                    this.gHT.setInSeason(false);
                }
            }
        }
    }

    @Override // com.baidu.live.t.a
    public boolean N(JSONObject jSONObject) {
        int dy;
        if (this.aRH && (dy = dy(jSONObject)) != -1) {
            this.gHT.f(jSONObject, dy);
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int dy(JSONObject jSONObject) {
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
                if (this.aLD.mLiveInfo.room_id == jSONObject.optJSONObject("first_blood_info").optLong("room_id")) {
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
                    if (this.aLD.mLiveInfo.room_id == jSONObject.optLong("send_room_id")) {
                        i = 14;
                        break;
                    } else {
                        i = 24;
                        break;
                    }
                } else {
                    if (optLong == 2) {
                        if (this.aLD.mLiveInfo.room_id == jSONObject.optLong("send_room_id")) {
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
            s(optString, jSONObject);
        }
        return i;
    }

    private void s(String str, JSONObject jSONObject) {
        if (!"pk_send_props".equals(str) && !"pk_first_blood".equals(str) && !"pk_honor_change".equals(str)) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue(CameraActivityConfig.KEY_CONTENT_TYPE, str);
            alaStatsItem.addValue("lodId", Long.valueOf(jSONObject.optLong("log_id")));
            if (!"pk_invite".equals(str)) {
                alaStatsItem.addValue("pkId", Long.valueOf(jSONObject.optLong("pk_id")));
            }
            AlaStatManager.getInstance().debug("pk_competition_im_msg", alaStatsItem);
        }
    }

    @Override // com.baidu.live.t.a
    public void setCanVisible(boolean z) {
        if (this.gHT != null) {
            this.gHT.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.t.a
    public void Do() {
        lY(true);
        onDestroy();
    }

    @Override // com.baidu.live.t.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void lY(boolean z) {
        if (this.gHT != null && (this.gHT.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gHT.getParent()).removeView(this.gHT);
        }
        if (z && this.gEj != null && (this.gEj.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gEj.getParent()).removeView(this.gEj);
        }
    }

    @Override // com.baidu.live.t.a
    public boolean Em() {
        return this.gHT.hZN >= 10 && this.gHT.hZN <= 30;
    }

    @Override // com.baidu.live.t.a
    public boolean Qx() {
        return this.gHT.hZN == 2;
    }

    @Override // com.baidu.live.t.a
    public void onDestroy() {
        lY(true);
        this.gHT.onDestroy();
    }
}
