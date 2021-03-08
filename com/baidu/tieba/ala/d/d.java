package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.live.data.ab;
import com.baidu.live.data.ar;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class d implements com.baidu.live.t.c {
    private ab bzn;
    private com.baidu.tieba.ala.view.c gSE;
    private boolean gSF;
    private boolean isShowing = false;
    private Context mContext;
    private ViewGroup mParentView;

    public d(Context context) {
        this.mContext = context;
        bUg();
        ar arVar = com.baidu.live.ae.a.Qm().bwx;
        if (arVar != null && arVar.aON != null) {
            this.gSF = arVar.aON.aSk;
        }
    }

    private void bUg() {
        if (this.gSE == null) {
            this.gSE = new com.baidu.tieba.ala.view.c(this.mContext);
            this.gSE.setId(a.f.ala_rank_level_entry);
        }
    }

    @Override // com.baidu.live.t.c
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, ab abVar) {
        this.mParentView = viewGroup;
        this.bzn = abVar;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gSE.getView()) == -1) {
                this.mParentView.addView(this.gSE.getView(), layoutParams);
                this.gSE.getView().setVisibility(8);
            }
            if (this.gSF && abVar != null && abVar.aKf != null && abVar.aKf.aLk != null) {
                setVisible(0);
                this.gSE.X(abVar);
            }
        }
    }

    @Override // com.baidu.live.t.c
    public void a(ab abVar) {
        this.bzn = abVar;
        if (this.gSF && abVar != null && abVar.aKf != null && abVar.aKf.aLk != null) {
            setVisible(0);
            this.gSE.X(abVar);
        }
    }

    @Override // com.baidu.live.t.c
    public void setVisible(int i) {
        if (this.gSF && this.bzn != null && this.bzn.aKf != null && this.bzn.aKf.aLk != null && this.gSE != null && this.gSE.getView() != null && i != this.gSE.getView().getVisibility()) {
            if (i == 0) {
                this.isShowing = true;
            } else {
                this.isShowing = false;
            }
            this.gSE.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.t.c
    public void xk() {
        this.isShowing = false;
        if (this.gSE != null) {
            this.gSE.xk();
        }
    }

    @Override // com.baidu.live.t.c
    public void onDestroy() {
        if (this.gSE != null) {
            this.gSE.onDestroy();
        }
        this.isShowing = false;
    }

    @Override // com.baidu.live.t.c
    public boolean isShowing() {
        return this.isShowing;
    }
}
