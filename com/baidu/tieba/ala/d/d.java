package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.live.data.an;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class d implements com.baidu.live.u.b {
    private x buq;
    private com.baidu.tieba.ala.view.c gOb;
    private boolean gOc;
    private boolean isShowing = false;
    private Context mContext;
    private ViewGroup mParentView;

    public d(Context context) {
        this.mContext = context;
        bTp();
        an anVar = com.baidu.live.af.a.OJ().bru;
        if (anVar != null && anVar.aKA != null) {
            this.gOc = anVar.aKA.aNJ;
        }
    }

    private void bTp() {
        if (this.gOb == null) {
            this.gOb = new com.baidu.tieba.ala.view.c(this.mContext);
            this.gOb.setId(a.f.ala_rank_level_entry);
        }
    }

    @Override // com.baidu.live.u.b
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, x xVar) {
        this.mParentView = viewGroup;
        this.buq = xVar;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gOb.getView()) == -1) {
                this.mParentView.addView(this.gOb.getView(), layoutParams);
                this.gOb.getView().setVisibility(8);
            }
            if (this.gOc && xVar != null && xVar.aGj != null && xVar.aGj.aHg != null) {
                setVisible(0);
                this.gOb.V(xVar);
            }
        }
    }

    @Override // com.baidu.live.u.b
    public void a(x xVar) {
        this.buq = xVar;
        if (this.gOc && xVar != null && xVar.aGj != null && xVar.aGj.aHg != null) {
            setVisible(0);
            this.gOb.V(xVar);
        }
    }

    @Override // com.baidu.live.u.b
    public void setVisible(int i) {
        if (this.gOc && this.buq != null && this.buq.aGj != null && this.buq.aGj.aHg != null && this.gOb != null && this.gOb.getView() != null && i != this.gOb.getView().getVisibility()) {
            if (i == 0) {
                this.isShowing = true;
            } else {
                this.isShowing = false;
            }
            this.gOb.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.u.b
    public void xk() {
        this.isShowing = false;
        if (this.gOb != null) {
            this.gOb.xk();
        }
    }

    @Override // com.baidu.live.u.b
    public void onDestroy() {
        if (this.gOb != null) {
            this.gOb.onDestroy();
        }
        this.isShowing = false;
    }

    @Override // com.baidu.live.u.b
    public boolean isShowing() {
        return this.isShowing;
    }
}
