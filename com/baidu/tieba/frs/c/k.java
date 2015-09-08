package com.baidu.tieba.frs.c;

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
import com.baidu.tieba.frs.cr;
import com.baidu.tieba.frs.dm;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener aVm;
    private FrsActivity baN;
    private SlidingMenu bbU;
    private dm bbV;
    private final SlidingMenu.OnClosedListener bbW;

    public k(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bbU = null;
        this.bbV = null;
        this.aVm = new l(this);
        this.bbW = new m(this);
        this.baN = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bbV != null) {
            this.bbV.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bbV != null) {
            this.bbV.destroy();
        }
    }

    public boolean onBackPressed() {
        if (NO().isMenuShowing()) {
            NO().toggle(true);
            if (NN().MC()) {
                NN().ck(false);
                this.baN.refresh();
                return true;
            }
            return true;
        }
        return false;
    }

    public void NM() {
        if (NO().isMenuShowing()) {
            NO().toggle(true);
        }
    }

    public dm NN() {
        if (this.bbV == null) {
            this.bbV = new dm(this.baN.getPageContext());
            NO().setMenu(this.bbV.getView());
            this.bbV.setCommonClickListener(this.aVm);
            this.bbV.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            this.bbV.init();
            this.bbV.MB().setOnSwitchStateChangeListener(this);
        }
        return this.bbV;
    }

    public SlidingMenu NO() {
        if (this.bbU == null) {
            this.bbU = new SlidingMenu(getPageContext().getPageActivity());
            this.bbU.setBackgroundColor(getPageContext().getResources().getColor(17170444));
            this.bbU.setMode(1);
            this.bbU.setTouchModeAbove(1);
            this.bbU.setBehindOffset(com.baidu.adp.lib.util.k.dip2px(getPageContext().getPageActivity(), 48.0f));
            this.bbU.setBehindScrollScale(0.5f);
            this.bbU.setFadeDegree(0.35f);
            this.bbU.attachToActivity(getPageContext().getPageActivity(), 1, true);
            this.bbU.setOnClosedListener(this.bbW);
        }
        return this.bbU;
    }

    public void showMenu(boolean z) {
        NO().showMenu(z);
    }

    public void co(boolean z) {
        NN().cj(z);
    }

    public void setIsManager(boolean z) {
        NN().setIsManager(z);
    }

    public void a(cr crVar) {
        if (this.bbV != null) {
            NN().a(crVar, FrsActivityStatic.aVI, FrsActivityStatic.aVJ);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == NN().MB()) {
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
            this.baN.onChangeSkinType(i);
            com.baidu.tbadk.core.util.c.iu();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        }
    }
}
