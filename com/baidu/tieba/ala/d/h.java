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
    private PendantParentView gEi;
    private PendantChildView gEj;
    protected AlaSeriesGiftPendant gHY;
    private Context mContext;
    private final int gHV = 1;
    private final int gHW = 0;
    private final int gHX = -1;
    private boolean isHost = false;

    public h(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.ad.a
    public void a(ViewGroup viewGroup, String str) {
        if (viewGroup != null && str != null && !TextUtils.isEmpty(str)) {
            if (viewGroup instanceof PendantParentView) {
                this.gEi = (PendantParentView) viewGroup;
                bUj();
            }
            if (this.gHY == null || (this.gEj != null && this.gEj.indexOfChild(this.gHY) < 0)) {
                this.gHY = new AlaSeriesGiftPendant(this.gEj.getContext(), this.isHost, str);
                this.gEj.addView(this.gHY);
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
        if (this.gHY != null && (this.gHY.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gHY.getParent()).removeView(this.gHY);
        }
        this.gHY = new AlaSeriesGiftPendant(this.gEj.getContext(), this.isHost, jSONObject.toString());
        this.gEj.addView(this.gHY);
        return true;
    }

    @Override // com.baidu.live.ad.a
    public void setCanVisible(boolean z) {
        if (this.gHY != null) {
            this.gHY.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.ad.a
    public void cL(boolean z) {
        if (this.gHY != null && z && !AlaSeriesGiftPendant.hWV) {
            this.gHY.setCanVisible(true);
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

    private void bUj() {
        this.gEj = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.h.1
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
        this.gEj.setBackgroundColor(0);
        if (this.gEi != null) {
            this.gEi.a(this.gEj, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private int dz(JSONObject jSONObject) {
        String optString;
        return (jSONObject == null || (optString = jSONObject.optString("content_type")) == null || optString.isEmpty() || !optString.equals("tying_gift")) ? -1 : 0;
    }

    private void lY(boolean z) {
        if (this.gHY != null && (this.gHY.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gHY.getParent()).removeView(this.gHY);
        }
        if (z && this.gEj != null && (this.gEj.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gEj.getParent()).removeView(this.gEj);
        }
        AlaSeriesGiftPendant.hWV = true;
    }
}
