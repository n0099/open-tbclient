package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.frs.cn;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.base.e<FrsActivity> {
    private final View.OnClickListener bNM;
    private final FrsActivity bTf;
    private final cn cds;
    private boolean cdt;
    private boolean cdu;
    private boolean cdv;
    private final Runnable cdw;
    private final BdSwitchView.a cdx;

    public ao(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.cdt = false;
        this.cdu = false;
        this.cdv = false;
        this.cdw = new ap(this);
        this.bNM = new aq(this);
        this.cdx = new ar(this);
        this.bTf = frsActivity;
        this.cds = new cn(frsActivity.getPageContext());
        ael();
    }

    public boolean b(TbPageContext<?> tbPageContext, int i) {
        if (this.cds != null) {
            this.cds.c(tbPageContext, i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.cds != null) {
            this.cds.destroy();
        }
        if (this.cdw != null) {
            com.baidu.adp.lib.g.h.fM().removeCallbacks(this.cdw);
        }
    }

    public View aej() {
        return this.cds.getView();
    }

    public cn aek() {
        return this.cds;
    }

    private void ael() {
        com.baidu.adp.lib.g.h.fM().postDelayed(this.cdw, 10L);
    }

    public void dO(boolean z) {
        this.cdu = z;
        if (this.cds != null) {
            this.cds.dO(z);
        }
    }

    public void em(boolean z) {
        this.cdv = z;
        if (this.cds != null) {
            this.cds.a(z, this.cdx);
        }
    }

    public void dP(boolean z) {
        this.cdt = z;
        if (this.cds != null) {
            this.cds.dP(z);
        }
    }

    public void a(bo boVar) {
        if (this.cds != null) {
            this.cds.a(boVar, FrsActivityStatic.bOb);
        }
    }
}
