package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.live.data.ab;
import com.baidu.live.data.ar;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class d implements com.baidu.live.t.c {
    private ab bxN;
    private com.baidu.tieba.ala.view.c gQV;
    private boolean gQW;
    private boolean isShowing = false;
    private Context mContext;
    private ViewGroup mParentView;

    public d(Context context) {
        this.mContext = context;
        bUa();
        ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar != null && arVar.aNn != null) {
            this.gQW = arVar.aNn.aQK;
        }
    }

    private void bUa() {
        if (this.gQV == null) {
            this.gQV = new com.baidu.tieba.ala.view.c(this.mContext);
            this.gQV.setId(a.f.ala_rank_level_entry);
        }
    }

    @Override // com.baidu.live.t.c
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, ab abVar) {
        this.mParentView = viewGroup;
        this.bxN = abVar;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gQV.getView()) == -1) {
                this.mParentView.addView(this.gQV.getView(), layoutParams);
                this.gQV.getView().setVisibility(8);
            }
            if (this.gQW && abVar != null && abVar.aIF != null && abVar.aIF.aJK != null) {
                setVisible(0);
                this.gQV.X(abVar);
            }
        }
    }

    @Override // com.baidu.live.t.c
    public void a(ab abVar) {
        this.bxN = abVar;
        if (this.gQW && abVar != null && abVar.aIF != null && abVar.aIF.aJK != null) {
            setVisible(0);
            this.gQV.X(abVar);
        }
    }

    @Override // com.baidu.live.t.c
    public void setVisible(int i) {
        if (this.gQW && this.bxN != null && this.bxN.aIF != null && this.bxN.aIF.aJK != null && this.gQV != null && this.gQV.getView() != null && i != this.gQV.getView().getVisibility()) {
            if (i == 0) {
                this.isShowing = true;
            } else {
                this.isShowing = false;
            }
            this.gQV.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.t.c
    public void xh() {
        this.isShowing = false;
        if (this.gQV != null) {
            this.gQV.xh();
        }
    }

    @Override // com.baidu.live.t.c
    public void onDestroy() {
        if (this.gQV != null) {
            this.gQV.onDestroy();
        }
        this.isShowing = false;
    }

    @Override // com.baidu.live.t.c
    public boolean isShowing() {
        return this.isShowing;
    }
}
