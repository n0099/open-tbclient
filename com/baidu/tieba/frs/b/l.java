package com.baidu.tieba.frs.b;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.dw;
import com.baidu.tieba.frs.ez;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener bdQ;
    private FrsActivity blE;
    private SlidingMenu bna;
    private ez bnb;
    private final SlidingMenu.OnClosedListener bnc;

    public l(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bna = null;
        this.bnb = null;
        this.bdQ = new m(this);
        this.bnc = new n(this);
        this.blE = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bnb != null) {
            this.bnb.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bnb != null) {
            this.bnb.destroy();
        }
    }

    public boolean onBackPressed() {
        if (Qe().isMenuShowing()) {
            Qe().toggle(true);
            if (Qd().OE()) {
                Qd().cx(false);
                this.blE.refresh();
                return true;
            }
            return true;
        }
        return false;
    }

    public void Qc() {
        if (Qe().isMenuShowing()) {
            Qe().toggle(true);
        }
    }

    public ez Qd() {
        if (this.bnb == null) {
            this.bnb = new ez(this.blE.getPageContext());
            Qe().setMenu(this.bnb.getView());
            this.bnb.setCommonClickListener(this.bdQ);
            this.bnb.init();
            this.bnb.OD().setOnSwitchStateChangeListener(this);
        }
        this.bnb.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return this.bnb;
    }

    public SlidingMenu Qe() {
        if (this.bna == null) {
            this.bna = new SlidingMenu(getPageContext().getPageActivity());
            this.bna.setBackgroundColor(getPageContext().getResources().getColor(17170444));
            this.bna.setMode(1);
            this.bna.setTouchModeAbove(1);
            this.bna.setBehindOffset((int) (com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity()) * 0.3d));
            this.bna.setBehindScrollScale(0.5f);
            this.bna.setFadeDegree(0.35f);
            this.bna.attachToActivity(getPageContext().getPageActivity(), 1, true);
            this.bna.setOnClosedListener(this.bnc);
        }
        return this.bna;
    }

    public void showMenu(boolean z) {
        Qe().showMenu(z);
    }

    public void cB(boolean z) {
        Qd().cw(z);
    }

    public void setIsManager(boolean z) {
        Qd().setIsManager(z);
    }

    public void a(dw dwVar) {
        if (this.bnb != null) {
            Qd().a(dwVar, FrsActivityStatic.bey);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == Qd().OD()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkCoreApplication.m411getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_night_mode", "frsclick", 1, new Object[0]);
                    TbadkCoreApplication.m411getInst().setSkinType(1);
                    TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                } else {
                    return;
                }
            } else if (TbadkCoreApplication.m411getInst().getSkinType() != 0) {
                TbadkCoreApplication.m411getInst().setSkinType(0);
                i = 0;
            } else {
                return;
            }
            this.blE.onChangeSkinType(i);
            com.baidu.tbadk.core.util.c.iy();
        }
    }
}
