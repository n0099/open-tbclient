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
/* loaded from: classes10.dex */
public class h implements com.baidu.live.ad.a {
    protected AlaSeriesGiftPendant gTM;
    private PendantParentView gqd;
    private PendantChildView gqe;
    private boolean isHost = false;
    private Context mContext;

    public h(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.ad.a
    public void a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            if (viewGroup instanceof PendantParentView) {
                this.gqd = (PendantParentView) viewGroup;
                bOf();
            }
            if (str != null && !TextUtils.isEmpty(str)) {
                if (this.gTM == null || (this.gqe != null && this.gqe.indexOfChild(this.gTM) < 0)) {
                    this.gTM = new AlaSeriesGiftPendant(this.gqe.getContext(), this.isHost, str);
                    this.gqe.addView(this.gTM);
                }
            }
        }
    }

    @Override // com.baidu.live.ad.a
    public void a(ab abVar) {
    }

    @Override // com.baidu.live.ad.a
    public boolean ab(JSONObject jSONObject) {
        if (dL(jSONObject) == -1) {
            return false;
        }
        if (this.gTM != null && (this.gTM.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gTM.getParent()).removeView(this.gTM);
        }
        this.gTM = new AlaSeriesGiftPendant(this.gqe.getContext(), this.isHost, jSONObject.toString());
        this.gqe.addView(this.gTM);
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
        if (this.gTM != null) {
            this.gTM.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.ad.a
    public void cT(boolean z) {
        if (this.gTM != null && z && !AlaSeriesGiftPendant.ilC) {
            this.gTM.setCanVisible(true);
        }
    }

    @Override // com.baidu.live.ad.a
    public void xk() {
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

    private void bOf() {
        if (this.gqe == null) {
            this.gqe = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.h.1
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
            this.gqe.setBackgroundColor(0);
        }
        if (this.gqd != null && this.gqd.indexOfChild(this.gqe) < 0) {
            this.gqd.a(this.gqe, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private int dL(JSONObject jSONObject) {
        String optString;
        return (jSONObject == null || (optString = jSONObject.optString("content_type")) == null || optString.isEmpty() || !optString.equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT)) ? -1 : 0;
    }

    private void mv(boolean z) {
        if (this.gTM != null && (this.gTM.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gTM.getParent()).removeView(this.gTM);
        }
        if (z && this.gqe != null && (this.gqe.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gqe.getParent()).removeView(this.gqe);
        }
        AlaSeriesGiftPendant.ilC = true;
    }
}
