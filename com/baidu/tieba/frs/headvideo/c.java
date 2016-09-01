package com.baidu.tieba.frs.headvideo;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
public class c {
    private FrsActivity bRp;
    private com.baidu.tieba.frs.i.p bTC;
    private b cbg;
    private boolean cbh = false;
    private boolean cbi = false;
    private View mRootView;

    public boolean aef() {
        return this.cbh && !aeg();
    }

    public void ed(boolean z) {
        this.cbh = z;
    }

    private boolean aeg() {
        return this.cbg != null && this.cbg.Eu();
    }

    public c(FrsActivity frsActivity, View view, com.baidu.tieba.frs.i.p pVar) {
        this.bRp = frsActivity;
        this.mRootView = view;
        this.bTC = pVar;
    }

    public void aeh() {
        if (this.cbg == null && this.bRp != null) {
            this.cbg = new b(this.bRp.getPageContext().getPageActivity());
        }
        if (this.mRootView != null && this.cbg != null) {
            this.cbg.M(this.mRootView);
            this.cbg.EA().setOnTouchListener(new d(this));
        }
    }

    public void YN() {
        if (this.cbg != null && aeg()) {
            aei();
            if (this.bTC != null && this.bTC.afp() != null) {
                ForumHeadVideoView afL = this.bTC.afp().afL();
                if (afL != null) {
                    afL.aet();
                }
                a.aed();
            }
        }
    }

    public void aei() {
        if (this.cbg != null && this.mRootView != null) {
            this.cbg.L(this.mRootView);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cbg != null) {
            this.cbg.onChangeSkinType(i);
        }
    }

    public void ee(boolean z) {
        ForumHeadVideoView afL;
        this.cbi = z;
        if (this.cbi && this.bTC != null && this.bTC.afp() != null && (afL = this.bTC.afp().afL()) != null) {
            afL.stopPlay();
        }
    }

    public boolean aej() {
        return this.cbi;
    }

    public void onDestroy() {
        aei();
    }
}
