package com.baidu.tieba.ala.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.live.data.ab;
import com.baidu.live.data.ar;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class d implements com.baidu.live.t.c {
    private ab bxN;
    private com.baidu.tieba.ala.view.c gQH;
    private boolean gQI;
    private boolean isShowing = false;
    private Context mContext;
    private ViewGroup mParentView;

    public d(Context context) {
        this.mContext = context;
        bTT();
        ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar != null && arVar.aNn != null) {
            this.gQI = arVar.aNn.aQK;
        }
    }

    private void bTT() {
        if (this.gQH == null) {
            this.gQH = new com.baidu.tieba.ala.view.c(this.mContext);
            this.gQH.setId(a.f.ala_rank_level_entry);
        }
    }

    @Override // com.baidu.live.t.c
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, ab abVar) {
        this.mParentView = viewGroup;
        this.bxN = abVar;
        if (this.mParentView != null) {
            if (this.mParentView.indexOfChild(this.gQH.getView()) == -1) {
                this.mParentView.addView(this.gQH.getView(), layoutParams);
                this.gQH.getView().setVisibility(8);
            }
            if (this.gQI && abVar != null && abVar.aIF != null && abVar.aIF.aJK != null) {
                setVisible(0);
                this.gQH.X(abVar);
            }
        }
    }

    @Override // com.baidu.live.t.c
    public void a(ab abVar) {
        this.bxN = abVar;
        if (this.gQI && abVar != null && abVar.aIF != null && abVar.aIF.aJK != null) {
            setVisible(0);
            this.gQH.X(abVar);
        }
    }

    @Override // com.baidu.live.t.c
    public void setVisible(int i) {
        if (this.gQI && this.bxN != null && this.bxN.aIF != null && this.bxN.aIF.aJK != null && this.gQH != null && this.gQH.getView() != null && i != this.gQH.getView().getVisibility()) {
            if (i == 0) {
                this.isShowing = true;
            } else {
                this.isShowing = false;
            }
            this.gQH.getView().setVisibility(i);
        }
    }

    @Override // com.baidu.live.t.c
    public void xh() {
        this.isShowing = false;
        if (this.gQH != null) {
            this.gQH.xh();
        }
    }

    @Override // com.baidu.live.t.c
    public void onDestroy() {
        if (this.gQH != null) {
            this.gQH.onDestroy();
        }
        this.isShowing = false;
    }

    @Override // com.baidu.live.t.c
    public boolean isShowing() {
        return this.isShowing;
    }
}
