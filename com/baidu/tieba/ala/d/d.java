package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.live.data.al;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class d implements com.baidu.live.t.b {
    private w bur;
    private com.baidu.tieba.ala.view.c gGV;
    private boolean gGW;
    private boolean isShowing = false;
    private Context mContext;
    private ViewGroup mParentView;

    public d(Context context) {
        this.mContext = context;
        bUC();
        al alVar = com.baidu.live.ae.a.RB().brA;
        if (alVar != null && alVar.aOG != null) {
            this.gGW = alVar.aOG.aRH;
        }
    }

    private void bUC() {
        if (this.gGV == null) {
            this.gGV = new com.baidu.tieba.ala.view.c(this.mContext);
            this.gGV.setId(a.f.ala_rank_level_entry);
        }
    }

    @Override // com.baidu.live.t.b
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, w wVar) {
        this.mParentView = viewGroup;
        this.bur = wVar;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gGV.getView()) == -1) {
                this.mParentView.addView(this.gGV.getView(), layoutParams);
                this.gGV.getView().setVisibility(8);
            }
            if (this.gGW && wVar != null && wVar.aKx != null && wVar.aKx.aLr != null) {
                setVisible(0);
                this.gGV.T(wVar);
            }
        }
    }

    @Override // com.baidu.live.t.b
    public void a(w wVar) {
        this.bur = wVar;
        if (this.gGW && wVar != null && wVar.aKx != null && wVar.aKx.aLr != null) {
            setVisible(0);
            this.gGV.T(wVar);
        }
    }

    @Override // com.baidu.live.t.b
    public void setVisible(int i) {
        if (this.gGW && this.bur != null && this.bur.aKx != null && this.bur.aKx.aLr != null && this.gGV != null && this.gGV.getView() != null && i != this.gGV.getView().getVisibility()) {
            if (i == 0) {
                this.isShowing = true;
            } else {
                this.isShowing = false;
            }
            this.gGV.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.t.b
    public void Do() {
        this.isShowing = false;
        if (this.gGV != null) {
            this.gGV.Do();
        }
    }

    @Override // com.baidu.live.t.b
    public void onDestroy() {
        if (this.gGV != null) {
            this.gGV.onDestroy();
        }
        this.isShowing = false;
    }

    @Override // com.baidu.live.t.b
    public boolean isShowing() {
        return this.isShowing;
    }
}
