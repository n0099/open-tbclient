package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.data.u;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tieba.ala.view.PkRankView;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.p.a {
    u aIT;
    private boolean aOP;
    private PendantParentView gga;
    private PendantChildView ggb;
    protected PkRankView gjB;
    private boolean isHost = false;
    private Context mContext;

    public f(Context context) {
        this.aOP = false;
        this.mContext = context;
        if (com.baidu.live.x.a.OS().blo.aLS != null) {
            this.aOP = com.baidu.live.x.a.OS().blo.aLS.aOP;
        } else {
            this.aOP = false;
        }
    }

    @Override // com.baidu.live.p.a
    public void b(ViewGroup viewGroup, u uVar) {
        this.aIT = uVar;
        if (viewGroup != null) {
            if (viewGroup instanceof PendantParentView) {
                this.gga = (PendantParentView) viewGroup;
                bMe();
            }
            if (this.gjB == null || (this.ggb != null && this.ggb.indexOfChild(this.gjB) < 0)) {
                this.gjB = new PkRankView(this.ggb.getContext(), this.isHost, uVar);
                this.ggb.addView(this.gjB, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.aOP) {
                this.gjB.cgS();
                if (uVar.aIk) {
                    this.gjB.setInSeason(true);
                } else {
                    this.gjB.setInSeason(false);
                }
            }
        }
    }

    private void bMe() {
        this.ggb = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.f.1
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
        this.ggb.setBackgroundColor(0);
        if (this.gga != null) {
            this.gga.a(this.ggb, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    @Override // com.baidu.live.p.a
    public void a(u uVar) {
        if (this.aOP) {
            this.aIT = uVar;
            if (uVar != null && uVar.mLiveInfo != null) {
                if (!this.isHost) {
                    this.gjB.cgS();
                }
                if (uVar.aIk) {
                    this.gjB.setInSeason(true);
                } else {
                    this.gjB.setInSeason(false);
                }
            }
        }
    }

    @Override // com.baidu.live.p.a
    public boolean M(JSONObject jSONObject) {
        int dt;
        if (this.aOP && (dt = dt(jSONObject)) != -1) {
            this.gjB.f(jSONObject, dt);
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int dt(JSONObject jSONObject) {
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
                if (this.aIT.mLiveInfo.room_id == jSONObject.optJSONObject("first_blood_info").optLong("room_id")) {
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
                    if (this.aIT.mLiveInfo.room_id == jSONObject.optLong("send_room_id")) {
                        i = 14;
                        break;
                    } else {
                        i = 24;
                        break;
                    }
                } else {
                    if (optLong == 2) {
                        if (this.aIT.mLiveInfo.room_id == jSONObject.optLong("send_room_id")) {
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
            p(optString, jSONObject);
        }
        return i;
    }

    private void p(String str, JSONObject jSONObject) {
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

    @Override // com.baidu.live.p.a
    public void setCanVisible(boolean z) {
        if (this.gjB != null) {
            this.gjB.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.p.a
    public void JQ() {
        lb(true);
        onDestroy();
    }

    @Override // com.baidu.live.p.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void lb(boolean z) {
        if (this.gjB != null && (this.gjB.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gjB.getParent()).removeView(this.gjB);
        }
        if (z && this.ggb != null && (this.ggb.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ggb.getParent()).removeView(this.ggb);
        }
    }

    @Override // com.baidu.live.p.a
    public boolean CM() {
        return this.gjB.hwV >= 10 && this.gjB.hwV <= 30;
    }

    @Override // com.baidu.live.p.a
    public boolean NP() {
        return this.gjB.hwV == 2;
    }

    @Override // com.baidu.live.p.a
    public void onDestroy() {
        lb(true);
        this.gjB.onDestroy();
    }
}
