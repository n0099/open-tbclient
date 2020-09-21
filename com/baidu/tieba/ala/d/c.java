package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.live.data.ag;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class c implements com.baidu.live.p.b {
    private com.baidu.tieba.ala.view.c fWh;
    private ViewGroup.LayoutParams fWi;
    private boolean fWj;
    private boolean isShowing = false;
    private Context mContext;
    private ViewGroup mParentView;

    public c(Context context) {
        this.mContext = context;
        ag agVar = com.baidu.live.x.a.NN().bhy;
        if (agVar != null && agVar.aIO != null) {
            this.fWj = agVar.aIO.aLK;
        }
    }

    private void ad(ViewGroup viewGroup) {
        if (this.fWj && viewGroup != null) {
            if (this.fWh == null) {
                this.fWh = new com.baidu.tieba.ala.view.c(this.mContext);
            }
            bJM();
            this.fWh.setId(a.g.ala_rank_level_entry);
        }
    }

    @Override // com.baidu.live.p.b
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, u uVar) {
        if (this.fWj) {
            this.mParentView = viewGroup;
            this.fWi = layoutParams;
            if (uVar != null && uVar.aFf != null && uVar.aFf.aFI != null && this.mParentView != null) {
                ad(this.mParentView);
                this.mParentView.addView(this.fWh.getView(), this.fWi);
                this.isShowing = true;
                this.fWh.F(uVar);
            }
        }
    }

    @Override // com.baidu.live.p.b
    public void a(u uVar) {
        if (this.fWj && uVar != null && uVar.aFf != null && uVar.aFf.aFI != null) {
            if (this.fWh == null) {
                if (this.mParentView != null) {
                    ad(this.mParentView);
                    this.mParentView.addView(this.fWh.getView(), this.fWi);
                } else {
                    return;
                }
            }
            this.fWh.F(uVar);
        }
    }

    private void bJM() {
        if (this.fWh != null && this.fWh.getView().getParent() != null) {
            ((ViewGroup) this.fWh.getView().getParent()).removeView(this.fWh.getView());
        }
    }

    @Override // com.baidu.live.p.b
    public void setVisible(int i) {
        if (this.fWh != null && this.fWh.getView() != null) {
            this.fWh.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.p.b
    public void IT() {
        this.isShowing = false;
        if (this.fWh != null) {
            this.fWh.IT();
        }
    }

    @Override // com.baidu.live.p.b
    public void onDestroy() {
        if (this.fWh != null) {
            this.fWh.onDestroy();
        }
        this.isShowing = false;
    }

    @Override // com.baidu.live.p.b
    public boolean isShowing() {
        return this.isShowing;
    }
}
