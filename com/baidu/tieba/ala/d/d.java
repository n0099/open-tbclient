package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.live.data.an;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class d implements com.baidu.live.u.b {
    private x bzc;
    private com.baidu.tieba.ala.view.c gSH;
    private boolean gSI;
    private boolean isShowing = false;
    private Context mContext;
    private ViewGroup mParentView;

    public d(Context context) {
        this.mContext = context;
        bXh();
        an anVar = com.baidu.live.af.a.SE().bwi;
        if (anVar != null && anVar.aPn != null) {
            this.gSI = anVar.aPn.aSw;
        }
    }

    private void bXh() {
        if (this.gSH == null) {
            this.gSH = new com.baidu.tieba.ala.view.c(this.mContext);
            this.gSH.setId(a.f.ala_rank_level_entry);
        }
    }

    @Override // com.baidu.live.u.b
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, x xVar) {
        this.mParentView = viewGroup;
        this.bzc = xVar;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gSH.getView()) == -1) {
                this.mParentView.addView(this.gSH.getView(), layoutParams);
                this.gSH.getView().setVisibility(8);
            }
            if (this.gSI && xVar != null && xVar.aKW != null && xVar.aKW.aLT != null) {
                setVisible(0);
                this.gSH.V(xVar);
            }
        }
    }

    @Override // com.baidu.live.u.b
    public void a(x xVar) {
        this.bzc = xVar;
        if (this.gSI && xVar != null && xVar.aKW != null && xVar.aKW.aLT != null) {
            setVisible(0);
            this.gSH.V(xVar);
        }
    }

    @Override // com.baidu.live.u.b
    public void setVisible(int i) {
        if (this.gSI && this.bzc != null && this.bzc.aKW != null && this.bzc.aKW.aLT != null && this.gSH != null && this.gSH.getView() != null && i != this.gSH.getView().getVisibility()) {
            if (i == 0) {
                this.isShowing = true;
            } else {
                this.isShowing = false;
            }
            this.gSH.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.u.b
    public void Bf() {
        this.isShowing = false;
        if (this.gSH != null) {
            this.gSH.Bf();
        }
    }

    @Override // com.baidu.live.u.b
    public void onDestroy() {
        if (this.gSH != null) {
            this.gSH.onDestroy();
        }
        this.isShowing = false;
    }

    @Override // com.baidu.live.u.b
    public boolean isShowing() {
        return this.isShowing;
    }
}
