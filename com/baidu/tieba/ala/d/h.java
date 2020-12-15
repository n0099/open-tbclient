package com.baidu.tieba.ala.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.tieba.ala.view.AlaSeriesGiftPendant;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h implements com.baidu.live.ad.a {
    private PendantParentView gEk;
    private PendantChildView gEl;
    protected AlaSeriesGiftPendant gIa;
    private Context mContext;
    private final int gHX = 1;
    private final int gHY = 0;
    private final int gHZ = -1;
    private boolean isHost = false;

    public h(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.ad.a
    public void a(ViewGroup viewGroup, String str) {
        if (viewGroup != null && str != null && !TextUtils.isEmpty(str)) {
            if (viewGroup instanceof PendantParentView) {
                this.gEk = (PendantParentView) viewGroup;
                bUk();
            }
            if (this.gIa == null || (this.gEl != null && this.gEl.indexOfChild(this.gIa) < 0)) {
                this.gIa = new AlaSeriesGiftPendant(this.gEl.getContext(), this.isHost, str);
                this.gEl.addView(this.gIa);
            }
        }
    }

    @Override // com.baidu.live.ad.a
    public void a(w wVar) {
    }

    @Override // com.baidu.live.ad.a
    public boolean N(JSONObject jSONObject) {
        if (dz(jSONObject) == -1) {
            return false;
        }
        if (this.gIa != null && (this.gIa.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gIa.getParent()).removeView(this.gIa);
        }
        this.gIa = new AlaSeriesGiftPendant(this.gEl.getContext(), this.isHost, jSONObject.toString());
        this.gEl.addView(this.gIa);
        return true;
    }

    @Override // com.baidu.live.ad.a
    public void setCanVisible(boolean z) {
        if (this.gIa != null) {
            this.gIa.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.ad.a
    public void cL(boolean z) {
        if (this.gIa != null && z && !AlaSeriesGiftPendant.hWX) {
            this.gIa.setCanVisible(true);
        }
    }

    @Override // com.baidu.live.ad.a
    public void Do() {
        lY(true);
    }

    @Override // com.baidu.live.ad.a
    public void onDestroy() {
        lY(true);
    }

    @Override // com.baidu.live.ad.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void bUk() {
        this.gEl = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.h.1
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
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
        this.gEl.setBackgroundColor(0);
        if (this.gEk != null) {
            this.gEk.a(this.gEl, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private int dz(JSONObject jSONObject) {
        String optString;
        return (jSONObject == null || (optString = jSONObject.optString("content_type")) == null || optString.isEmpty() || !optString.equals("tying_gift")) ? -1 : 0;
    }

    private void lY(boolean z) {
        if (this.gIa != null && (this.gIa.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gIa.getParent()).removeView(this.gIa);
        }
        if (z && this.gEl != null && (this.gEl.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gEl.getParent()).removeView(this.gEl);
        }
        AlaSeriesGiftPendant.hWX = true;
    }
}
