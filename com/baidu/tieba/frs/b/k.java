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
import com.baidu.tieba.frs.dg;
import com.baidu.tieba.frs.ef;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.f<FrsActivity> implements BdSwitchView.a {
    private final View.OnClickListener aUx;
    private FrsActivity baR;
    private SlidingMenu bbZ;
    private ef bca;
    private final SlidingMenu.OnClosedListener bcb;

    public k(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bbZ = null;
        this.bca = null;
        this.aUx = new l(this);
        this.bcb = new m(this);
        this.baR = frsActivity;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bca != null) {
            this.bca.changeSkinType(i);
            return true;
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.bca != null) {
            this.bca.destroy();
        }
    }

    public boolean onBackPressed() {
        if (NO().isMenuShowing()) {
            NO().toggle(true);
            if (NN().MB()) {
                NN().ch(false);
                this.baR.refresh();
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

    public ef NN() {
        if (this.bca == null) {
            this.bca = new ef(this.baR.getPageContext());
            NO().setMenu(this.bca.getView());
            this.bca.setCommonClickListener(this.aUx);
            this.bca.init();
            this.bca.MA().setOnSwitchStateChangeListener(this);
        }
        this.bca.changeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return this.bca;
    }

    public SlidingMenu NO() {
        if (this.bbZ == null) {
            this.bbZ = new SlidingMenu(getPageContext().getPageActivity());
            this.bbZ.setBackgroundColor(getPageContext().getResources().getColor(17170444));
            this.bbZ.setMode(1);
            this.bbZ.setTouchModeAbove(1);
            this.bbZ.setBehindOffset((int) (com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity()) * 0.3d));
            this.bbZ.setBehindScrollScale(0.5f);
            this.bbZ.setFadeDegree(0.35f);
            this.bbZ.attachToActivity(getPageContext().getPageActivity(), 1, true);
            this.bbZ.setOnClosedListener(this.bcb);
        }
        return this.bbZ;
    }

    public void showMenu(boolean z) {
        NO().showMenu(z);
    }

    public void cl(boolean z) {
        NN().cg(z);
    }

    public void setIsManager(boolean z) {
        NN().setIsManager(z);
    }

    public void a(dg dgVar) {
        if (this.bca != null) {
            NN().a(dgVar, FrsActivityStatic.aVb, FrsActivityStatic.aVc);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        int i = 1;
        if (view == NN().MA()) {
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
            this.baR.onChangeSkinType(i);
            com.baidu.tbadk.core.util.c.iv();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
        }
    }
}
