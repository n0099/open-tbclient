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
    protected AlaSeriesGiftPendant gSd;
    private PendantParentView gou;
    private PendantChildView gov;
    private boolean isHost = false;
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.ad.a
    public void a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            if (viewGroup instanceof PendantParentView) {
                this.gou = (PendantParentView) viewGroup;
                bNZ();
            }
            if (str != null && !TextUtils.isEmpty(str)) {
                if (this.gSd == null || (this.gov != null && this.gov.indexOfChild(this.gSd) < 0)) {
                    this.gSd = new AlaSeriesGiftPendant(this.gov.getContext(), this.isHost, str);
                    this.gov.addView(this.gSd);
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
        if (this.gSd != null && (this.gSd.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gSd.getParent()).removeView(this.gSd);
        }
        this.gSd = new AlaSeriesGiftPendant(this.gov.getContext(), this.isHost, jSONObject.toString());
        this.gov.addView(this.gSd);
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
        if (this.gSd != null) {
            this.gSd.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.ad.a
    public void cT(boolean z) {
        if (this.gSd != null && z && !AlaSeriesGiftPendant.ijT) {
            this.gSd.setCanVisible(true);
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

    private void bNZ() {
        if (this.gov == null) {
            this.gov = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.h.1
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
            this.gov.setBackgroundColor(0);
        }
        if (this.gou != null && this.gou.indexOfChild(this.gov) < 0) {
            this.gou.a(this.gov, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private int dJ(JSONObject jSONObject) {
        String optString;
        return (jSONObject == null || (optString = jSONObject.optString("content_type")) == null || optString.isEmpty() || !optString.equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT)) ? -1 : 0;
    }

    private void mv(boolean z) {
        if (this.gSd != null && (this.gSd.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gSd.getParent()).removeView(this.gSd);
        }
        if (z && this.gov != null && (this.gov.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gov.getParent()).removeView(this.gov);
        }
        AlaSeriesGiftPendant.ijT = true;
    }
}
