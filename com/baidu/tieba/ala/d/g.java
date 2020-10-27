package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.tieba.ala.view.AlaSeriesGiftPendant;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g implements com.baidu.live.y.a {
    private PendantParentView gqd;
    private PendantChildView gqe;
    protected AlaSeriesGiftPendant gtH;
    private Context mContext;
    private final int gtE = 1;
    private final int gtF = 0;
    private final int gtG = -1;
    private boolean isHost = false;

    public g(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.y.a
    public void a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            if (viewGroup instanceof PendantParentView) {
                this.gqd = (PendantParentView) viewGroup;
                bOG();
            }
            if (this.gtH == null || (this.gqe != null && this.gqe.indexOfChild(this.gtH) < 0)) {
                this.gtH = new AlaSeriesGiftPendant(this.gqe.getContext(), this.isHost, str);
                this.gqe.addView(this.gtH);
            }
        }
    }

    @Override // com.baidu.live.y.a
    public void a(w wVar) {
    }

    @Override // com.baidu.live.y.a
    public boolean O(JSONObject jSONObject) {
        if (dy(jSONObject) == -1) {
            return false;
        }
        if (this.gtH != null && (this.gtH.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gtH.getParent()).removeView(this.gtH);
        }
        this.gtH = new AlaSeriesGiftPendant(this.gqe.getContext(), this.isHost, jSONObject.toString());
        this.gqe.addView(this.gtH);
        return true;
    }

    @Override // com.baidu.live.y.a
    public void setCanVisible(boolean z) {
        if (this.gtH != null) {
            this.gtH.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.y.a
    public void cu(boolean z) {
        if (this.gtH != null && z && !AlaSeriesGiftPendant.hGx) {
            this.gtH.setCanVisible(true);
        } else {
            this.gtH.setCanVisible(false);
        }
    }

    @Override // com.baidu.live.y.a
    public void Kj() {
        lt(true);
    }

    @Override // com.baidu.live.y.a
    public void onDestroy() {
        lt(true);
        this.gtH.onDestroy();
    }

    @Override // com.baidu.live.y.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void bOG() {
        this.gqe = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.g.1
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
        this.gqe.setBackgroundColor(0);
        if (this.gqd != null) {
            this.gqd.a(this.gqe, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private int dy(JSONObject jSONObject) {
        String optString;
        return (jSONObject == null || (optString = jSONObject.optString("content_type")) == null || optString.isEmpty() || !optString.equals("tying_gift")) ? -1 : 0;
    }

    private void lt(boolean z) {
        if (this.gtH != null && (this.gtH.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gtH.getParent()).removeView(this.gtH);
        }
        if (z && this.gqe != null && (this.gqe.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gqe.getParent()).removeView(this.gqe);
        }
        AlaSeriesGiftPendant.hGx = true;
    }
}
