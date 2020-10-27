package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.live.data.aj;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class c implements com.baidu.live.q.b {
    private w bpz;
    private com.baidu.tieba.ala.view.c gsC;
    private boolean gsD;
    private boolean isShowing = false;
    private Context mContext;
    private ViewGroup mParentView;

    public c(Context context) {
        this.mContext = context;
        bOY();
        aj ajVar = com.baidu.live.z.a.Pq().bmJ;
        if (ajVar != null && ajVar.aMw != null) {
            this.gsD = ajVar.aMw.aPu;
        }
    }

    private void bOY() {
        if (this.gsC == null) {
            this.gsC = new com.baidu.tieba.ala.view.c(this.mContext);
            this.gsC.setId(a.g.ala_rank_level_entry);
        }
    }

    @Override // com.baidu.live.q.b
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, w wVar) {
        this.mParentView = viewGroup;
        this.bpz = wVar;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gsC.getView()) == -1) {
                this.mParentView.addView(this.gsC.getView(), layoutParams);
                this.gsC.getView().setVisibility(8);
            }
            if (this.gsD && wVar != null && wVar.aIG != null && wVar.aIG.aJn != null) {
                setVisible(0);
                this.gsC.J(wVar);
            }
        }
    }

    @Override // com.baidu.live.q.b
    public void a(w wVar) {
        this.bpz = wVar;
        if (this.gsD && wVar != null && wVar.aIG != null && wVar.aIG.aJn != null) {
            setVisible(0);
            this.gsC.J(wVar);
        }
    }

    @Override // com.baidu.live.q.b
    public void setVisible(int i) {
        if (this.gsD && this.bpz != null && this.bpz.aIG != null && this.bpz.aIG.aJn != null && this.gsC != null && this.gsC.getView() != null && i != this.gsC.getView().getVisibility()) {
            if (i == 0) {
                this.isShowing = true;
            } else {
                this.isShowing = false;
            }
            this.gsC.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.q.b
    public void Kj() {
        this.isShowing = false;
        if (this.gsC != null) {
            this.gsC.Kj();
        }
    }

    @Override // com.baidu.live.q.b
    public void onDestroy() {
        if (this.gsC != null) {
            this.gsC.onDestroy();
        }
        this.isShowing = false;
    }

    @Override // com.baidu.live.q.b
    public boolean isShowing() {
        return this.isShowing;
    }
}
