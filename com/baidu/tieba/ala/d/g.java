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
    private PendantParentView gvy;
    private PendantChildView gvz;
    protected AlaSeriesGiftPendant gzc;
    private Context mContext;
    private final int gyZ = 1;
    private final int gza = 0;
    private final int gzb = -1;
    private boolean isHost = false;

    public g(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.z.a
    public void a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            if (viewGroup instanceof PendantParentView) {
                this.gvy = (PendantParentView) viewGroup;
                bQz();
            }
            if (this.gzc == null || (this.gvz != null && this.gvz.indexOfChild(this.gzc) < 0)) {
                this.gzc = new AlaSeriesGiftPendant(this.gvz.getContext(), this.isHost, str);
                this.gvz.addView(this.gzc);
            }
        }
    }

    @Override // com.baidu.live.z.a
    public void a(w wVar) {
    }

    @Override // com.baidu.live.z.a
    public boolean L(JSONObject jSONObject) {
        if (dy(jSONObject) == -1) {
            return false;
        }
        if (this.gzc != null && (this.gzc.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gzc.getParent()).removeView(this.gzc);
        }
        this.gzc = new AlaSeriesGiftPendant(this.gvz.getContext(), this.isHost, jSONObject.toString());
        this.gvz.addView(this.gzc);
        return true;
    }

    @Override // com.baidu.live.z.a
    public void setCanVisible(boolean z) {
        if (this.gzc != null) {
            this.gzc.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.z.a
    public void cx(boolean z) {
        if (this.gzc != null && z && !AlaSeriesGiftPendant.hMb) {
            this.gzc.setCanVisible(true);
        } else {
            this.gzc.setCanVisible(false);
        }
    }

    @Override // com.baidu.live.z.a
    public void Ka() {
        lD(true);
    }

    @Override // com.baidu.live.z.a
    public void onDestroy() {
        lD(true);
        this.gzc.onDestroy();
    }

    @Override // com.baidu.live.z.a
    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    private void bQz() {
        this.gvz = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.d.g.1
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
        this.gvz.setBackgroundColor(0);
        if (this.gvy != null) {
            this.gvy.a(this.gvz, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private int dy(JSONObject jSONObject) {
        String optString;
        return (jSONObject == null || (optString = jSONObject.optString("content_type")) == null || optString.isEmpty() || !optString.equals("tying_gift")) ? -1 : 0;
    }

    private void lD(boolean z) {
        if (this.gzc != null && (this.gzc.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gzc.getParent()).removeView(this.gzc);
        }
        if (z && this.gvz != null && (this.gvz.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gvz.getParent()).removeView(this.gvz);
        }
        AlaSeriesGiftPendant.hMb = true;
    }
}
