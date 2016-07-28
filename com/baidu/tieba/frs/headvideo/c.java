package com.baidu.tieba.frs.headvideo;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
public class c {
    private FrsActivity bGh;
    private com.baidu.tieba.frs.j.p bIw;
    private b bPY;
    private boolean bPZ = false;
    private boolean bQa = false;
    private View mRootView;

    public boolean Zt() {
        return this.bPZ && !Zu();
    }

    public void dH(boolean z) {
        this.bPZ = z;
    }

    private boolean Zu() {
        return this.bPY != null && this.bPY.Da();
    }

    public c(FrsActivity frsActivity, View view, com.baidu.tieba.frs.j.p pVar) {
        this.bGh = frsActivity;
        this.mRootView = view;
        this.bIw = pVar;
    }

    public void Zv() {
        if (this.bPY == null && this.bGh != null) {
            this.bPY = new b(this.bGh.getPageContext().getPageActivity());
        }
        if (this.mRootView != null && this.bPY != null) {
            this.bPY.L(this.mRootView);
            this.bPY.Dg().setOnTouchListener(new d(this));
        }
    }

    public void XB() {
        if (this.bPY != null && Zu()) {
            Zw();
            if (this.bIw != null && this.bIw.aaE() != null) {
                ForumHeadVideoView aba = this.bIw.aaE().aba();
                if (aba != null) {
                    aba.ZJ();
                }
                a.Zr();
            }
        }
    }

    public void Zw() {
        if (this.bPY != null && this.mRootView != null) {
            this.bPY.K(this.mRootView);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bPY != null) {
            this.bPY.onChangeSkinType(i);
        }
    }

    public void dI(boolean z) {
        ForumHeadVideoView aba;
        this.bQa = z;
        if (this.bQa && this.bIw != null && this.bIw.aaE() != null && (aba = this.bIw.aaE().aba()) != null) {
            aba.stopPlay();
        }
    }

    public boolean Zx() {
        return this.bQa;
    }

    public void onDestroy() {
        Zw();
    }
}
