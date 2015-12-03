package com.baidu.tieba.frs.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.dw;
import com.baidu.tieba.frs.ez;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener aZT;
    private FrsActivity bhN;
    private SlidingMenu bjj;
    private ez bjk;
    private final SlidingMenu.OnClosedListener bjl;

    public l(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bjj = null;
        this.bjk = null;
        this.aZT = new m(this);
        this.bjl = new n(this);
        this.bhN = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bjk != null) {
            this.bjk.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bjk != null) {
            this.bjk.destroy();
        }
    }

    public boolean onBackPressed() {
        if (PM().isMenuShowing()) {
            PM().toggle(true);
            if (PL().Om()) {
                PL().cw(false);
                this.bhN.refresh();
                return true;
            }
            return true;
        }
        return false;
    }

    public void PK() {
        if (PM().isMenuShowing()) {
            PM().toggle(true);
        }
    }

    public ez PL() {
        if (this.bjk == null) {
            this.bjk = new ez(this.bhN.getPageContext());
            PM().setMenu(this.bjk.getView());
            this.bjk.setCommonClickListener(this.aZT);
            this.bjk.init();
            this.bjk.Ol().setOnSwitchStateChangeListener(this);
        }
        this.bjk.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return this.bjk;
    }

    public SlidingMenu PM() {
        if (this.bjj == null) {
            this.bjj = new SlidingMenu(getPageContext().getPageActivity());
            this.bjj.setBackgroundColor(getPageContext().getResources().getColor(17170444));
            this.bjj.setMode(1);
            this.bjj.setTouchModeAbove(1);
            this.bjj.setBehindOffset((int) (com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity()) * 0.3d));
            this.bjj.setBehindScrollScale(0.5f);
            this.bjj.setFadeDegree(0.35f);
            this.bjj.attachToActivity(getPageContext().getPageActivity(), 1, true);
            this.bjj.setOnClosedListener(this.bjl);
        }
        return this.bjj;
    }

    public void showMenu(boolean z) {
        PM().showMenu(z);
    }

    public void cA(boolean z) {
        PL().cv(z);
    }

    public void setIsManager(boolean z) {
        PL().setIsManager(z);
    }

    public void a(dw dwVar) {
        if (this.bjk != null) {
            PL().a(dwVar, FrsActivityStatic.baz);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == PL().Ol()) {
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
            this.bhN.onChangeSkinType(i);
            com.baidu.tbadk.core.util.c.iy();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        }
    }
}
