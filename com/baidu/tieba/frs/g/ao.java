package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.cp;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.e<FrsActivity> {
    private final View.OnClickListener bNB;
    private final FrsActivity bST;
    private final cp cbT;
    private boolean cbU;
    private boolean cbV;
    private boolean cbW;
    private final Runnable cbX;
    private final BdSwitchView.a cbY;

    public ao(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.cbU = false;
        this.cbV = false;
        this.cbW = false;
        this.cbX = new ap(this);
        this.bNB = new aq(this);
        this.cbY = new ar(this);
        this.bST = frsActivity;
        this.cbT = new cp(frsActivity.getPageContext());
        aeg();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.cbT != null) {
            this.cbT.c(tbPageContext, i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.cbT != null) {
            this.cbT.destroy();
        }
        if (this.cbX != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.cbX);
        }
    }

    public View aee() {
        return this.cbT.getView();
    }

    public cp aef() {
        return this.cbT;
    }

    private void aeg() {
        com.baidu.adp.lib.g.h.fR().postDelayed(this.cbX, 10L);
    }

    public void dQ(boolean z) {
        this.cbV = z;
        if (this.cbT != null) {
            this.cbT.dQ(z);
        }
    }

    public void em(boolean z) {
        this.cbW = z;
        if (this.cbT != null) {
            this.cbT.a(z, this.cbY);
        }
    }

    public void dR(boolean z) {
        this.cbU = z;
        if (this.cbT != null) {
            this.cbT.dR(z);
        }
    }

    public void a(bq bqVar) {
        if (this.cbT != null) {
            this.cbT.a(bqVar, FrsActivityStatic.bNQ);
        }
    }
}
