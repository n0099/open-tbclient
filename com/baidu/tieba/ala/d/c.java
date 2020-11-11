package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.live.data.ak;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class c implements com.baidu.live.r.b {
    private w bqS;
    private com.baidu.tieba.ala.view.c gyq;
    private boolean gyr;
    private boolean isShowing = false;
    private Context mContext;
    private ViewGroup mParentView;

    public c(Context context) {
        this.mContext = context;
        bRy();
        ak akVar = com.baidu.live.aa.a.PQ().bod;
        if (akVar != null && akVar.aNw != null) {
            this.gyr = akVar.aNw.aQr;
        }
    }

    private void bRy() {
        if (this.gyq == null) {
            this.gyq = new com.baidu.tieba.ala.view.c(this.mContext);
            this.gyq.setId(a.f.ala_rank_level_entry);
        }
    }

    @Override // com.baidu.live.r.b
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, w wVar) {
        this.mParentView = viewGroup;
        this.bqS = wVar;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gyq.getView()) == -1) {
                this.mParentView.addView(this.gyq.getView(), layoutParams);
                this.gyq.getView().setVisibility(8);
            }
            if (this.gyr && wVar != null && wVar.aJx != null && wVar.aJx.aKn != null) {
                setVisible(0);
                this.gyq.O(wVar);
            }
        }
    }

    @Override // com.baidu.live.r.b
    public void a(w wVar) {
        this.bqS = wVar;
        if (this.gyr && wVar != null && wVar.aJx != null && wVar.aJx.aKn != null) {
            setVisible(0);
            this.gyq.O(wVar);
        }
    }

    @Override // com.baidu.live.r.b
    public void setVisible(int i) {
        if (this.gyr && this.bqS != null && this.bqS.aJx != null && this.bqS.aJx.aKn != null && this.gyq != null && this.gyq.getView() != null && i != this.gyq.getView().getVisibility()) {
            if (i == 0) {
                this.isShowing = true;
            } else {
                this.isShowing = false;
            }
            this.gyq.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.r.b
    public void KJ() {
        this.isShowing = false;
        if (this.gyq != null) {
            this.gyq.KJ();
        }
    }

    @Override // com.baidu.live.r.b
    public void onDestroy() {
        if (this.gyq != null) {
            this.gyq.onDestroy();
        }
        this.isShowing = false;
    }

    @Override // com.baidu.live.r.b
    public boolean isShowing() {
        return this.isShowing;
    }
}
