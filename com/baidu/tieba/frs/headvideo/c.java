package com.baidu.tieba.frs.headvideo;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
public class c {
    private FrsActivity bRi;
    private com.baidu.tieba.frs.i.p bTv;
    private b cbi;
    private boolean cbj = false;
    private boolean cbk = false;
    private View mRootView;

    public boolean aeu() {
        return this.cbj && !aev();
    }

    public void ee(boolean z) {
        this.cbj = z;
    }

    private boolean aev() {
        return this.cbi != null && this.cbi.Eu();
    }

    public c(FrsActivity frsActivity, View view, com.baidu.tieba.frs.i.p pVar) {
        this.bRi = frsActivity;
        this.mRootView = view;
        this.bTv = pVar;
    }

    public void aew() {
        if (this.cbi == null && this.bRi != null) {
            this.cbi = new b(this.bRi.getPageContext().getPageActivity());
        }
        if (this.mRootView != null && this.cbi != null) {
            this.cbi.M(this.mRootView);
            this.cbi.EA().setOnTouchListener(new d(this));
        }
    }

    public void Zc() {
        if (this.cbi != null && aev()) {
            aex();
            if (this.bTv != null && this.bTv.afD() != null) {
                ForumHeadVideoView afZ = this.bTv.afD().afZ();
                if (afZ != null) {
                    afZ.aeI();
                }
                a.aes();
            }
        }
    }

    public void aex() {
        if (this.cbi != null && this.mRootView != null) {
            this.cbi.L(this.mRootView);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.cbi != null) {
            this.cbi.onChangeSkinType(i);
        }
    }

    public void ef(boolean z) {
        ForumHeadVideoView afZ;
        this.cbk = z;
        if (this.cbk && this.bTv != null && this.bTv.afD() != null && (afZ = this.bTv.afD().afZ()) != null) {
            afZ.stopPlay();
        }
    }

    public boolean aey() {
        return this.cbk;
    }

    public void onDestroy() {
        aex();
    }
}
