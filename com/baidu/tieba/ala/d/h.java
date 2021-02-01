package com.baidu.tieba.ala.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.data.ab;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.view.AlaSeriesGiftPendant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h implements com.baidu.live.ad.a {
    protected AlaSeriesGiftPendant gRP;
    private PendantParentView gog;
    private PendantChildView goh;
    private boolean isHost = false;
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.ad.a
    public void a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            if (viewGroup instanceof PendantParentView) {
                this.gog = (PendantParentView) viewGroup;
                bNS();
            }
            if (str != null && !TextUtils.isEmpty(str)) {
                if (this.gRP == null || (this.goh != null && this.goh.indexOfChild(this.gRP) < 0)) {
                    this.gRP = new AlaSeriesGiftPendant(this.goh.getContext(), this.isHost, str);
                    this.goh.addView(this.gRP);
                }
            }
        }
    }

    @Override // com.baidu.live.ad.a
    public void a(ab abVar) {
    }

    @Override // com.baidu.live.ad.a
    public boolean Z(JSONObject jSONObject) {
        if (dJ(jSONObject) == -1) {
            return false;
        }
        if (this.gRP != null && (this.gRP.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gRP.getParent()).removeView(this.gRP);
        }
        this.gRP = new AlaSeriesGiftPendant(this.goh.getContext(), this.isHost, jSONObject.toString());
        this.goh.addView(this.gRP);
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(LogConfig.LOG_GIFT_ID, jSONObject.optInt(LogConfig.LOG_GIFT_ID));
            jSONObject3.put("tying_gift_id", jSONObject.optLong("tying_gift_id"));
            jSONObject2.putOpt(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT, jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_TYING_GIFT, UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT, this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_TYING_PENDANT_SHOW).setContentExt(null, null, jSONObject2));
        return true;
    }

    @Override // com.baidu.live.ad.a
    public void setCanVisible(boolean z) {
        if (this.gRP != null) {
            this.gRP.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.ad.a
    public void cT(boolean z) {
        if (this.gRP != null && z && !AlaSeriesGiftPendant.ijF) {
            this.gRP.setCanVisible(true);
        }
    }

    @Override // com.baidu.live.ad.a
    public void xh() {
        mv(true);
    }

    @Override // com.baidu.live.ad.a
    public void onDestroy() {
        mv(true);
    }

    @Override // com.baidu.live.ad.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void bNS() {
        if (this.goh == null) {
            this.goh = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.h.1
                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalPkPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getVerticalBBChattingPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getHorizontalPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public PendantParentView.Position getHorizontalFullPosition() {
                    return PendantParentView.Position.RIGHT;
                }

                @Override // com.baidu.live.pendantview.PendantChildView
                public int getPriority() {
                    return 9;
                }
            };
            this.goh.setBackgroundColor(0);
        }
        if (this.gog != null && this.gog.indexOfChild(this.goh) < 0) {
            this.gog.a(this.goh, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private int dJ(JSONObject jSONObject) {
        String optString;
        return (jSONObject == null || (optString = jSONObject.optString("content_type")) == null || optString.isEmpty() || !optString.equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT)) ? -1 : 0;
    }

    private void mv(boolean z) {
        if (this.gRP != null && (this.gRP.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gRP.getParent()).removeView(this.gRP);
        }
        if (z && this.goh != null && (this.goh.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.goh.getParent()).removeView(this.goh);
        }
        AlaSeriesGiftPendant.ijF = true;
    }
}
