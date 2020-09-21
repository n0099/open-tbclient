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
    u aFP;
    private boolean aLK;
    private PendantParentView fTH;
    private PendantChildView fTI;
    protected PkRankView fXi;
    private boolean isHost = false;
    private Context mContext;

    public f(Context context) {
        this.aLK = false;
        this.mContext = context;
        if (com.baidu.live.x.a.NN().bhy.aIO != null) {
            this.aLK = com.baidu.live.x.a.NN().bhy.aIO.aLK;
        } else {
            this.aLK = false;
        }
    }

    @Override // com.baidu.live.p.a
    public void b(ViewGroup viewGroup, u uVar) {
        this.aFP = uVar;
        if (viewGroup != null) {
            if (viewGroup instanceof PendantParentView) {
                this.fTH = (PendantParentView) viewGroup;
                bJu();
            }
            if (this.fXi == null || (this.fTI != null && this.fTI.indexOfChild(this.fXi) < 0)) {
                this.fXi = new PkRankView(this.fTI.getContext(), this.isHost, uVar);
                this.fTI.addView(this.fXi, new FrameLayout.LayoutParams(-2, -2));
            }
            if (this.aLK) {
                this.fXi.cdw();
                if (uVar.aFg) {
                    this.fXi.setInSeason(true);
                } else {
                    this.fXi.setInSeason(false);
                }
            }
        }
    }

    private void bJu() {
        this.fTI = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.f.1
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
        this.fTI.setBackgroundColor(0);
        if (this.fTH != null) {
            this.fTH.a(this.fTI, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    @Override // com.baidu.live.p.a
    public void a(u uVar) {
        if (this.aLK) {
            this.aFP = uVar;
            if (uVar != null && uVar.mLiveInfo != null) {
                if (!this.isHost) {
                    this.fXi.cdw();
                }
                if (uVar.aFg) {
                    this.fXi.setInSeason(true);
                } else {
                    this.fXi.setInSeason(false);
                }
            }
        }
    }

    @Override // com.baidu.live.p.a
    public boolean N(JSONObject jSONObject) {
        int dm;
        if (this.aLK && (dm = dm(jSONObject)) != -1) {
            this.fXi.e(jSONObject, dm);
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int dm(JSONObject jSONObject) {
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
                if (this.aFP.mLiveInfo.room_id == jSONObject.optJSONObject("first_blood_info").optLong("room_id")) {
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
                    if (this.aFP.mLiveInfo.room_id == jSONObject.optLong("send_room_id")) {
                        i = 14;
                        break;
                    } else {
                        i = 24;
                        break;
                    }
                } else {
                    if (optLong == 2) {
                        if (this.aFP.mLiveInfo.room_id == jSONObject.optLong("send_room_id")) {
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
        if (this.fXi != null) {
            this.fXi.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.p.a
    public void IT() {
        kD(true);
        onDestroy();
    }

    @Override // com.baidu.live.p.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void kD(boolean z) {
        if (this.fXi != null && (this.fXi.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fXi.getParent()).removeView(this.fXi);
        }
        if (z && this.fTI != null && (this.fTI.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fTI.getParent()).removeView(this.fTI);
        }
    }

    @Override // com.baidu.live.p.a
    public boolean BP() {
        return this.fXi.hhZ >= 10 && this.fXi.hhZ <= 30;
    }

    @Override // com.baidu.live.p.a
    public boolean MK() {
        return this.fXi.hhZ == 2;
    }

    @Override // com.baidu.live.p.a
    public void onDestroy() {
        kD(true);
        this.fXi.onDestroy();
    }
}
