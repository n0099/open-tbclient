package com.baidu.tieba.ala.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.data.x;
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
public class h implements com.baidu.live.ae.a {
    protected AlaSeriesGiftPendant gTM;
    private PendantParentView gqh;
    private PendantChildView gqi;
    private Context mContext;
    private final int gTJ = 1;
    private final int gTK = 0;
    private final int gTL = -1;
    private boolean isHost = false;

    public h(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.ae.a
    public void a(ViewGroup viewGroup, String str) {
        if (viewGroup != null && str != null && !TextUtils.isEmpty(str)) {
            if (viewGroup instanceof PendantParentView) {
                this.gqh = (PendantParentView) viewGroup;
                bRi();
            }
            if (this.gTM == null || (this.gqi != null && this.gqi.indexOfChild(this.gTM) < 0)) {
                this.gTM = new AlaSeriesGiftPendant(this.gqi.getContext(), this.isHost, str);
                this.gqi.addView(this.gTM);
            }
        }
    }

    @Override // com.baidu.live.ae.a
    public void a(x xVar) {
    }

    @Override // com.baidu.live.ae.a
    public boolean V(JSONObject jSONObject) {
        if (dI(jSONObject) == -1) {
            return false;
        }
        if (this.gTM != null && (this.gTM.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gTM.getParent()).removeView(this.gTM);
        }
        this.gTM = new AlaSeriesGiftPendant(this.gqi.getContext(), this.isHost, jSONObject.toString());
        this.gqi.addView(this.gTM);
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

    @Override // com.baidu.live.ae.a
    public void setCanVisible(boolean z) {
        if (this.gTM != null) {
            this.gTM.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.ae.a
    public void cO(boolean z) {
        if (this.gTM != null && z && !AlaSeriesGiftPendant.ijx) {
            this.gTM.setCanVisible(true);
        }
    }

    @Override // com.baidu.live.ae.a
    public void Bf() {
        mv(true);
    }

    @Override // com.baidu.live.ae.a
    public void onDestroy() {
        mv(true);
    }

    @Override // com.baidu.live.ae.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void bRi() {
        this.gqi = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.h.1
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
        this.gqi.setBackgroundColor(0);
        if (this.gqh != null) {
            this.gqh.a(this.gqi, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private int dI(JSONObject jSONObject) {
        String optString;
        return (jSONObject == null || (optString = jSONObject.optString("content_type")) == null || optString.isEmpty() || !optString.equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT)) ? -1 : 0;
    }

    private void mv(boolean z) {
        if (this.gTM != null && (this.gTM.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gTM.getParent()).removeView(this.gTM);
        }
        if (z && this.gqi != null && (this.gqi.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gqi.getParent()).removeView(this.gqi);
        }
        AlaSeriesGiftPendant.ijx = true;
    }
}
