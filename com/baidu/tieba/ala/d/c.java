package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.live.data.ag;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class c implements com.baidu.live.p.b {
    private com.baidu.tieba.ala.view.c giA;
    private ViewGroup.LayoutParams giB;
    private boolean giC;
    private boolean isShowing = false;
    private Context mContext;
    private ViewGroup mParentView;

    public c(Context context) {
        this.mContext = context;
        ag agVar = com.baidu.live.x.a.OS().blo;
        if (agVar != null && agVar.aLS != null) {
            this.giC = agVar.aLS.aOP;
        }
    }

    private void af(ViewGroup viewGroup) {
        if (this.giC && viewGroup != null) {
            if (this.giA == null) {
                this.giA = new com.baidu.tieba.ala.view.c(this.mContext);
            }
            bMw();
            this.giA.setId(a.g.ala_rank_level_entry);
        }
    }

    @Override // com.baidu.live.p.b
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, u uVar) {
        if (this.giC) {
            this.mParentView = viewGroup;
            this.giB = layoutParams;
            if (uVar != null && uVar.aIj != null && uVar.aIj.aIM != null && this.mParentView != null) {
                af(this.mParentView);
                this.mParentView.addView(this.giA.getView(), this.giB);
                this.isShowing = true;
                this.giA.G(uVar);
            }
        }
    }

    @Override // com.baidu.live.p.b
    public void a(u uVar) {
        if (this.giC && uVar != null && uVar.aIj != null && uVar.aIj.aIM != null) {
            if (this.giA == null) {
                if (this.mParentView != null) {
                    af(this.mParentView);
                    this.mParentView.addView(this.giA.getView(), this.giB);
                } else {
                    return;
                }
            }
            this.giA.G(uVar);
        }
    }

    private void bMw() {
        if (this.giA != null && this.giA.getView().getParent() != null) {
            ((ViewGroup) this.giA.getView().getParent()).removeView(this.giA.getView());
        }
    }

    @Override // com.baidu.live.p.b
    public void setVisible(int i) {
        if (this.giA != null && this.giA.getView() != null) {
            this.giA.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.p.b
    public void JQ() {
        this.isShowing = false;
        if (this.giA != null) {
            this.giA.JQ();
        }
    }

    @Override // com.baidu.live.p.b
    public void onDestroy() {
        if (this.giA != null) {
            this.giA.onDestroy();
        }
        this.isShowing = false;
    }

    @Override // com.baidu.live.p.b
    public boolean isShowing() {
        return this.isShowing;
    }
}
