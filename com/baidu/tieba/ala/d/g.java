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
public class g implements com.baidu.live.z.a {
    private PendantParentView gvR;
    private PendantChildView gvS;
    protected AlaSeriesGiftPendant gzv;
    private Context mContext;
    private final int gzs = 1;
    private final int gzt = 0;
    private final int gzu = -1;
    private boolean isHost = false;

    public g(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.z.a
    public void a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            if (viewGroup instanceof PendantParentView) {
                this.gvR = (PendantParentView) viewGroup;
                bRg();
            }
            if (this.gzv == null || (this.gvS != null && this.gvS.indexOfChild(this.gzv) < 0)) {
                this.gzv = new AlaSeriesGiftPendant(this.gvS.getContext(), this.isHost, str);
                this.gvS.addView(this.gzv);
            }
        }
    }

    @Override // com.baidu.live.z.a
    public void a(w wVar) {
    }

    @Override // com.baidu.live.z.a
    public boolean R(JSONObject jSONObject) {
        if (dE(jSONObject) == -1) {
            return false;
        }
        if (this.gzv != null && (this.gzv.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gzv.getParent()).removeView(this.gzv);
        }
        this.gzv = new AlaSeriesGiftPendant(this.gvS.getContext(), this.isHost, jSONObject.toString());
        this.gvS.addView(this.gzv);
        return true;
    }

    @Override // com.baidu.live.z.a
    public void setCanVisible(boolean z) {
        if (this.gzv != null) {
            this.gzv.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.z.a
    public void cv(boolean z) {
        if (this.gzv != null && z && !AlaSeriesGiftPendant.hMu) {
            this.gzv.setCanVisible(true);
        } else {
            this.gzv.setCanVisible(false);
        }
    }

    @Override // com.baidu.live.z.a
    public void KJ() {
        lC(true);
    }

    @Override // com.baidu.live.z.a
    public void onDestroy() {
        lC(true);
        this.gzv.onDestroy();
    }

    @Override // com.baidu.live.z.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void bRg() {
        this.gvS = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.g.1
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
        this.gvS.setBackgroundColor(0);
        if (this.gvR != null) {
            this.gvR.a(this.gvS, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private int dE(JSONObject jSONObject) {
        String optString;
        return (jSONObject == null || (optString = jSONObject.optString("content_type")) == null || optString.isEmpty() || !optString.equals("tying_gift")) ? -1 : 0;
    }

    private void lC(boolean z) {
        if (this.gzv != null && (this.gzv.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gzv.getParent()).removeView(this.gzv);
        }
        if (z && this.gvS != null && (this.gvS.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gvS.getParent()).removeView(this.gvS);
        }
        AlaSeriesGiftPendant.hMu = true;
    }
}
