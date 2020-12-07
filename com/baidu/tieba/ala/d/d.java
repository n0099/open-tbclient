package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.live.data.al;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class d implements com.baidu.live.t.b {
    private w bur;
    private com.baidu.tieba.ala.view.c gGT;
    private boolean gGU;
    private boolean isShowing = false;
    private Context mContext;
    private ViewGroup mParentView;

    public d(Context context) {
        this.mContext = context;
        bUB();
        al alVar = com.baidu.live.ae.a.RB().brA;
        if (alVar != null && alVar.aOG != null) {
            this.gGU = alVar.aOG.aRH;
        }
    }

    private void bUB() {
        if (this.gGT == null) {
            this.gGT = new com.baidu.tieba.ala.view.c(this.mContext);
            this.gGT.setId(a.f.ala_rank_level_entry);
        }
    }

    @Override // com.baidu.live.t.b
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, w wVar) {
        this.mParentView = viewGroup;
        this.bur = wVar;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gGT.getView()) == -1) {
                this.mParentView.addView(this.gGT.getView(), layoutParams);
                this.gGT.getView().setVisibility(8);
            }
            if (this.gGU && wVar != null && wVar.aKx != null && wVar.aKx.aLr != null) {
                setVisible(0);
                this.gGT.T(wVar);
            }
        }
    }

    @Override // com.baidu.live.t.b
    public void a(w wVar) {
        this.bur = wVar;
        if (this.gGU && wVar != null && wVar.aKx != null && wVar.aKx.aLr != null) {
            setVisible(0);
            this.gGT.T(wVar);
        }
    }

    @Override // com.baidu.live.t.b
    public void setVisible(int i) {
        if (this.gGU && this.bur != null && this.bur.aKx != null && this.bur.aKx.aLr != null && this.gGT != null && this.gGT.getView() != null && i != this.gGT.getView().getVisibility()) {
            if (i == 0) {
                this.isShowing = true;
            } else {
                this.isShowing = false;
            }
            this.gGT.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.t.b
    public void Do() {
        this.isShowing = false;
        if (this.gGT != null) {
            this.gGT.Do();
        }
    }

    @Override // com.baidu.live.t.b
    public void onDestroy() {
        if (this.gGT != null) {
            this.gGT.onDestroy();
        }
        this.isShowing = false;
    }

    @Override // com.baidu.live.t.b
    public boolean isShowing() {
        return this.isShowing;
    }
}
