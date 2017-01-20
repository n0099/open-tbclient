package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.frs.cn;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.base.e<FrsActivity> {
    private final View.OnClickListener bGD;
    private final FrsActivity bLZ;
    private final cn bVX;
    private boolean bVY;
    private boolean bVZ;
    private boolean bWa;
    private final Runnable bWb;
    private final BdSwitchView.a bWc;

    public am(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bVY = false;
        this.bVZ = false;
        this.bWa = false;
        this.bWb = new an(this);
        this.bGD = new ao(this);
        this.bWc = new ap(this);
        this.bLZ = frsActivity;
        this.bVX = new cn(frsActivity.getPageContext());
        adl();
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bVX != null) {
            this.bVX.c(tbPageContext, i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.bVX != null) {
            this.bVX.destroy();
        }
        if (this.bWb != null) {
            com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bWb);
        }
    }

    public View adj() {
        return this.bVX.getView();
    }

    public cn adk() {
        return this.bVX;
    }

    private void adl() {
        com.baidu.adp.lib.g.h.eE().postDelayed(this.bWb, 10L);
    }

    public void dO(boolean z) {
        this.bVZ = z;
        if (this.bVX != null) {
            this.bVX.dO(z);
        }
    }

    public void em(boolean z) {
        this.bWa = z;
        if (this.bVX != null) {
            this.bVX.a(z, this.bWc);
        }
    }

    public void dP(boolean z) {
        this.bVY = z;
        if (this.bVX != null) {
            this.bVX.dP(z);
        }
    }

    public void a(bo boVar) {
        if (this.bVX != null) {
            this.bVX.a(boVar, FrsActivityStatic.bGS);
        }
    }
}
