package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.live.data.ak;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class c implements com.baidu.live.r.b {
    private w bph;
    private com.baidu.tieba.ala.view.c gxX;
    private boolean gxY;
    private boolean isShowing = false;
    private Context mContext;
    private ViewGroup mParentView;

    public c(Context context) {
        this.mContext = context;
        bQR();
        ak akVar = com.baidu.live.aa.a.Ph().bms;
        if (akVar != null && akVar.aLL != null) {
            this.gxY = akVar.aLL.aOG;
        }
    }

    private void bQR() {
        if (this.gxX == null) {
            this.gxX = new com.baidu.tieba.ala.view.c(this.mContext);
            this.gxX.setId(a.f.ala_rank_level_entry);
        }
    }

    @Override // com.baidu.live.r.b
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, w wVar) {
        this.mParentView = viewGroup;
        this.bph = wVar;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gxX.getView()) == -1) {
                this.mParentView.addView(this.gxX.getView(), layoutParams);
                this.gxX.getView().setVisibility(8);
            }
            if (this.gxY && wVar != null && wVar.aHM != null && wVar.aHM.aIC != null) {
                setVisible(0);
                this.gxX.O(wVar);
            }
        }
    }

    @Override // com.baidu.live.r.b
    public void a(w wVar) {
        this.bph = wVar;
        if (this.gxY && wVar != null && wVar.aHM != null && wVar.aHM.aIC != null) {
            setVisible(0);
            this.gxX.O(wVar);
        }
    }

    @Override // com.baidu.live.r.b
    public void setVisible(int i) {
        if (this.gxY && this.bph != null && this.bph.aHM != null && this.bph.aHM.aIC != null && this.gxX != null && this.gxX.getView() != null && i != this.gxX.getView().getVisibility()) {
            if (i == 0) {
                this.isShowing = true;
            } else {
                this.isShowing = false;
            }
            this.gxX.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.r.b
    public void Ka() {
        this.isShowing = false;
        if (this.gxX != null) {
            this.gxX.Ka();
        }
    }

    @Override // com.baidu.live.r.b
    public void onDestroy() {
        if (this.gxX != null) {
            this.gxX.onDestroy();
        }
        this.isShowing = false;
    }

    @Override // com.baidu.live.r.b
    public boolean isShowing() {
        return this.isShowing;
    }
}
